package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface JsonInclude {

    /* loaded from: classes3.dex */
    public enum Include {
        ALWAYS,
        NON_NULL,
        NON_ABSENT,
        NON_EMPTY,
        NON_DEFAULT,
        USE_DEFAULTS
    }

    Include content() default Include.ALWAYS;

    Include value() default Include.ALWAYS;

    /* loaded from: classes3.dex */
    public static class Value implements JacksonAnnotationValue<JsonInclude>, Serializable {
        protected static final Value EMPTY = new Value(Include.USE_DEFAULTS, Include.USE_DEFAULTS);
        private static final long serialVersionUID = 1;
        protected final Include _contentInclusion;
        protected final Include _valueInclusion;

        public Value(JsonInclude jsonInclude) {
            this(jsonInclude.value(), jsonInclude.content());
        }

        protected Value(Include include, Include include2) {
            this._valueInclusion = include == null ? Include.USE_DEFAULTS : include;
            this._contentInclusion = include2 == null ? Include.USE_DEFAULTS : include2;
        }

        public static Value empty() {
            return EMPTY;
        }

        public static Value merge(Value value, Value value2) {
            return value == null ? value2 : value.withOverrides(value2);
        }

        public static Value mergeAll(Value... valueArr) {
            Value value = null;
            for (Value value2 : valueArr) {
                if (value2 != null) {
                    if (value != null) {
                        value2 = value.withOverrides(value2);
                    }
                    value = value2;
                }
            }
            return value;
        }

        protected Object readResolve() {
            return (this._valueInclusion == Include.USE_DEFAULTS && this._contentInclusion == Include.USE_DEFAULTS) ? EMPTY : this;
        }

        public Value withOverrides(Value value) {
            if (value != null && value != EMPTY) {
                Include include = value._valueInclusion;
                Include include2 = value._contentInclusion;
                boolean z = (include == this._valueInclusion || include == Include.USE_DEFAULTS) ? false : true;
                boolean z2 = (include2 == this._contentInclusion || include2 == Include.USE_DEFAULTS) ? false : true;
                if (z) {
                    if (z2) {
                        return new Value(include, include2);
                    }
                    return new Value(include, this._contentInclusion);
                }
                if (z2) {
                    return new Value(this._valueInclusion, include2);
                }
            }
            return this;
        }

        public static Value construct(Include include, Include include2) {
            if ((include == Include.USE_DEFAULTS || include == null) && (include2 == Include.USE_DEFAULTS || include2 == null)) {
                return EMPTY;
            }
            return new Value(include, include2);
        }

        public static Value from(JsonInclude jsonInclude) {
            if (jsonInclude == null) {
                return null;
            }
            Include value = jsonInclude.value();
            Include content = jsonInclude.content();
            if (value == Include.USE_DEFAULTS && content == Include.USE_DEFAULTS) {
                return EMPTY;
            }
            return new Value(value, content);
        }

        public Value withValueInclusion(Include include) {
            return include == this._valueInclusion ? this : new Value(include, this._contentInclusion);
        }

        public Value withContentInclusion(Include include) {
            return include == this._contentInclusion ? this : new Value(this._valueInclusion, include);
        }

        @Override // com.fasterxml.jackson.annotation.JacksonAnnotationValue
        public Class<JsonInclude> valueFor() {
            return JsonInclude.class;
        }

        public Include getValueInclusion() {
            return this._valueInclusion;
        }

        public Include getContentInclusion() {
            return this._contentInclusion;
        }

        public String toString() {
            return String.format("[value=%s,content=%s]", this._valueInclusion, this._contentInclusion);
        }

        public int hashCode() {
            return (this._valueInclusion.hashCode() << 2) + this._contentInclusion.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            Value value = (Value) obj;
            return value._valueInclusion == this._valueInclusion && value._contentInclusion == this._contentInclusion;
        }
    }
}
