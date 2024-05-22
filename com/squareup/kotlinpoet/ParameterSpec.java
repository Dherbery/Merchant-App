package com.squareup.kotlinpoet;

import com.amazon.a.a.o.b;
import com.squareup.kotlinpoet.CodeBlock;
import com.squareup.kotlinpoet.Taggable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: ParameterSpec.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 @2\u00020\u0001:\u0002?@B+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\b¢\u0006\u0002\u0010\tB%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\u0010\u000bB\u0019\b\u0002\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J3\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\b\b\u0002\u00100\u001a\u00020.H\u0000¢\u0006\u0002\b1J\u0015\u00102\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0000¢\u0006\u0002\b3J\u0013\u00104\u001a\u00020.2\b\u00105\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u00106\u001a\u000207H\u0016J(\u00108\u001a\u0004\u0018\u0001H9\"\b\b\u0000\u00109*\u00020$2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H90:H\u0096\u0001¢\u0006\u0002\u0010;J(\u00108\u001a\u0004\u0018\u0001H9\"\b\b\u0000\u00109*\u00020$2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H90#H\u0096\u0001¢\u0006\u0002\u0010<J\u001a\u0010=\u001a\u00020\r2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005J\b\u0010>\u001a\u00020\u0003H\u0016R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010!\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030#\u0012\u0004\u0012\u00020$0\"8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006A"}, d2 = {"Lcom/squareup/kotlinpoet/ParameterSpec;", "Lcom/squareup/kotlinpoet/Taggable;", "name", "", "type", "Lcom/squareup/kotlinpoet/TypeName;", "modifiers", "", "Lcom/squareup/kotlinpoet/KModifier;", "(Ljava/lang/String;Lcom/squareup/kotlinpoet/TypeName;[Lcom/squareup/kotlinpoet/KModifier;)V", "", "(Ljava/lang/String;Lcom/squareup/kotlinpoet/TypeName;Ljava/lang/Iterable;)V", "builder", "Lcom/squareup/kotlinpoet/ParameterSpec$Builder;", "tagMap", "Lcom/squareup/kotlinpoet/TagMap;", "(Lcom/squareup/kotlinpoet/ParameterSpec$Builder;Lcom/squareup/kotlinpoet/TagMap;)V", "annotations", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "getAnnotations", "()Ljava/util/List;", "defaultValue", "Lcom/squareup/kotlinpoet/CodeBlock;", "getDefaultValue", "()Lcom/squareup/kotlinpoet/CodeBlock;", "kdoc", "getKdoc", "", "getModifiers", "()Ljava/util/Set;", "getName", "()Ljava/lang/String;", "tags", "", "Lkotlin/reflect/KClass;", "", "getTags", "()Ljava/util/Map;", "getType", "()Lcom/squareup/kotlinpoet/TypeName;", "emit", "", "codeWriter", "Lcom/squareup/kotlinpoet/CodeWriter;", "includeType", "", "emitKdoc", "inlineAnnotations", "emit$kotlinpoet", "emitDefaultValue", "emitDefaultValue$kotlinpoet", "equals", "other", "hashCode", "", "tag", "T", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toBuilder", "toString", "Builder", "Companion", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ParameterSpec implements Taggable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<AnnotationSpec> annotations;
    private final CodeBlock defaultValue;
    private final CodeBlock kdoc;
    private final Set<KModifier> modifiers;
    private final String name;
    private final TagMap tagMap;
    private final TypeName type;

    @JvmStatic
    public static final Builder builder(String str, TypeName typeName, Iterable<? extends KModifier> iterable) {
        return INSTANCE.builder(str, typeName, iterable);
    }

    @JvmStatic
    public static final Builder builder(String str, TypeName typeName, KModifier... kModifierArr) {
        return INSTANCE.builder(str, typeName, kModifierArr);
    }

    @JvmStatic
    public static final Builder builder(String str, Type type, Iterable<? extends KModifier> iterable) {
        return INSTANCE.builder(str, type, iterable);
    }

    @JvmStatic
    public static final Builder builder(String str, Type type, KModifier... kModifierArr) {
        return INSTANCE.builder(str, type, kModifierArr);
    }

    @JvmStatic
    public static final Builder builder(String str, KClass<?> kClass, Iterable<? extends KModifier> iterable) {
        return INSTANCE.builder(str, kClass, iterable);
    }

    @JvmStatic
    public static final Builder builder(String str, KClass<?> kClass, KModifier... kModifierArr) {
        return INSTANCE.builder(str, kClass, kModifierArr);
    }

    @JvmStatic
    public static final ParameterSpec get(VariableElement variableElement) {
        return INSTANCE.get(variableElement);
    }

    @JvmStatic
    public static final List<ParameterSpec> parametersOf(ExecutableElement executableElement) {
        return INSTANCE.parametersOf(executableElement);
    }

    @JvmStatic
    public static final ParameterSpec unnamed(TypeName typeName) {
        return INSTANCE.unnamed(typeName);
    }

    @JvmStatic
    public static final ParameterSpec unnamed(Type type) {
        return INSTANCE.unnamed(type);
    }

    @JvmStatic
    public static final ParameterSpec unnamed(KClass<?> kClass) {
        return INSTANCE.unnamed(kClass);
    }

    @Override // com.squareup.kotlinpoet.Taggable
    public Map<KClass<?>, Object> getTags() {
        return this.tagMap.getTags();
    }

    @Override // com.squareup.kotlinpoet.Taggable
    public <T> T tag(Class<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (T) this.tagMap.tag(type);
    }

    @Override // com.squareup.kotlinpoet.Taggable
    public <T> T tag(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (T) this.tagMap.tag(type);
    }

    private ParameterSpec(Builder builder, TagMap tagMap) {
        this.tagMap = tagMap;
        this.name = builder.getName();
        this.kdoc = builder.getKdoc().build();
        this.annotations = UtilKt.toImmutableList(builder.getAnnotations());
        List<KModifier> modifiers = builder.getModifiers();
        LinkedHashSet linkedHashSet = new LinkedHashSet(modifiers);
        linkedHashSet.removeAll(ParameterSpecKt.access$getALLOWED_PARAMETER_MODIFIERS$p());
        if (!linkedHashSet.isEmpty()) {
            throw new IllegalArgumentException("Modifiers " + linkedHashSet + " are not allowed on Kotlin parameters. Allowed modifiers: " + ParameterSpecKt.access$getALLOWED_PARAMETER_MODIFIERS$p());
        }
        this.modifiers = UtilKt.toImmutableSet(modifiers);
        this.type = builder.getType();
        this.defaultValue = builder.getDefaultValue();
    }

    /* synthetic */ ParameterSpec(Builder builder, TagMap tagMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder, (i & 2) != 0 ? TaggableKt.buildTagMap(builder) : tagMap);
    }

    public final String getName() {
        return this.name;
    }

    public final CodeBlock getKdoc() {
        return this.kdoc;
    }

    public final List<AnnotationSpec> getAnnotations() {
        return this.annotations;
    }

    public final Set<KModifier> getModifiers() {
        return this.modifiers;
    }

    public final TypeName getType() {
        return this.type;
    }

    public final CodeBlock getDefaultValue() {
        return this.defaultValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ParameterSpec(String name, TypeName type, KModifier... modifiers) {
        this(INSTANCE.builder(name, type, (KModifier[]) Arrays.copyOf(modifiers, modifiers.length)), null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ParameterSpec(String name, TypeName type, Iterable<? extends KModifier> modifiers) {
        this(INSTANCE.builder(name, type, modifiers), null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
    }

    public static /* synthetic */ void emit$kotlinpoet$default(ParameterSpec parameterSpec, CodeWriter codeWriter, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        if ((i & 8) != 0) {
            z3 = true;
        }
        parameterSpec.emit$kotlinpoet(codeWriter, z, z2, z3);
    }

    public final void emit$kotlinpoet(CodeWriter codeWriter, boolean includeType, boolean emitKdoc, boolean inlineAnnotations) {
        Intrinsics.checkNotNullParameter(codeWriter, "codeWriter");
        if (emitKdoc) {
            codeWriter.emitKdoc(UtilKt.ensureEndsWithNewLine(this.kdoc));
        }
        codeWriter.emitAnnotations(this.annotations, inlineAnnotations);
        CodeWriter.emitModifiers$default(codeWriter, this.modifiers, null, 2, null);
        if (this.name.length() > 0) {
            codeWriter.emitCode("%N", this);
        }
        if ((this.name.length() > 0) && includeType) {
            codeWriter.emitCode(":·");
        }
        if (includeType) {
            codeWriter.emitCode("%T", this.type);
        }
        emitDefaultValue$kotlinpoet(codeWriter);
    }

    public final void emitDefaultValue$kotlinpoet(CodeWriter codeWriter) {
        Intrinsics.checkNotNullParameter(codeWriter, "codeWriter");
        CodeBlock codeBlock = this.defaultValue;
        if (codeBlock != null) {
            codeWriter.emitCode(codeBlock.hasStatements$kotlinpoet() ? " = %L" : " = «%L»", this.defaultValue);
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && Intrinsics.areEqual(getClass(), other.getClass())) {
            return Intrinsics.areEqual(toString(), other.toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public static /* synthetic */ Builder toBuilder$default(ParameterSpec parameterSpec, String str, TypeName typeName, int i, Object obj) {
        if ((i & 1) != 0) {
            str = parameterSpec.name;
        }
        if ((i & 2) != 0) {
            typeName = parameterSpec.type;
        }
        return parameterSpec.toBuilder(str, typeName);
    }

    public final Builder toBuilder(String name, TypeName type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Builder builder = new Builder(name, type);
        builder.getKdoc().add(this.kdoc);
        CollectionsKt.addAll(builder.getAnnotations(), this.annotations);
        CollectionsKt.addAll(builder.getModifiers(), this.modifiers);
        builder.setDefaultValue$kotlinpoet(this.defaultValue);
        builder.getTags().putAll(this.tagMap.getTags());
        return builder;
    }

    /* compiled from: ParameterSpec.kt */
    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\tJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&J\u0012\u0010#\u001a\u00020\u00002\n\u0010%\u001a\u0006\u0012\u0002\b\u00030'J\u0012\u0010#\u001a\u00020\u00002\n\u0010%\u001a\u0006\u0012\u0002\b\u00030\u001dJ\u0014\u0010(\u001a\u00020\u00002\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0*J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\rJ'\u0010+\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u00032\u0012\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001e0/\"\u00020\u001e¢\u0006\u0002\u00100J\u001f\u00101\u001a\u00020\u00002\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170/\"\u00020\u0017¢\u0006\u0002\u00102J\u0014\u00101\u001a\u00020\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170*J\u0006\u00103\u001a\u000204J\u0010\u0010\f\u001a\u00020\u00002\b\u00105\u001a\u0004\u0018\u00010\rJ+\u0010\f\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u00032\u0016\u0010.\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001e0/\"\u0004\u0018\u00010\u001e¢\u0006\u0002\u00100J\u0016\u00106\u001a\u00020\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002070*H\u0007R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001d\u0012\u0004\u0012\u00020\u001e0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00068"}, d2 = {"Lcom/squareup/kotlinpoet/ParameterSpec$Builder;", "Lcom/squareup/kotlinpoet/Taggable$Builder;", "name", "", "type", "Lcom/squareup/kotlinpoet/TypeName;", "(Ljava/lang/String;Lcom/squareup/kotlinpoet/TypeName;)V", "annotations", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "getAnnotations", "()Ljava/util/List;", "defaultValue", "Lcom/squareup/kotlinpoet/CodeBlock;", "getDefaultValue$kotlinpoet", "()Lcom/squareup/kotlinpoet/CodeBlock;", "setDefaultValue$kotlinpoet", "(Lcom/squareup/kotlinpoet/CodeBlock;)V", "kdoc", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "getKdoc", "()Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "modifiers", "Lcom/squareup/kotlinpoet/KModifier;", "getModifiers", "getName$kotlinpoet", "()Ljava/lang/String;", "tags", "", "Lkotlin/reflect/KClass;", "", "getTags", "()Ljava/util/Map;", "getType$kotlinpoet", "()Lcom/squareup/kotlinpoet/TypeName;", "addAnnotation", "annotationSpec", "annotation", "Lcom/squareup/kotlinpoet/ClassName;", "Ljava/lang/Class;", "addAnnotations", "annotationSpecs", "", "addKdoc", "block", "format", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/squareup/kotlinpoet/ParameterSpec$Builder;", "addModifiers", "([Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/ParameterSpec$Builder;", "build", "Lcom/squareup/kotlinpoet/ParameterSpec;", "codeBlock", "jvmModifiers", "Ljavax/lang/model/element/Modifier;", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder implements Taggable.Builder<Builder> {
        private final List<AnnotationSpec> annotations;
        private CodeBlock defaultValue;
        private final CodeBlock.Builder kdoc;
        private final List<KModifier> modifiers;
        private final String name;
        private final Map<KClass<?>, Object> tags;
        private final TypeName type;

        public Builder(String name, TypeName type) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            this.name = name;
            this.type = type;
            this.kdoc = CodeBlock.INSTANCE.builder();
            this.annotations = new ArrayList();
            this.modifiers = new ArrayList();
            this.tags = new LinkedHashMap();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.kotlinpoet.Taggable.Builder
        public Builder tag(Class<?> cls, Object obj) {
            return (Builder) Taggable.Builder.DefaultImpls.tag(this, cls, obj);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.kotlinpoet.Taggable.Builder
        public Builder tag(KClass<?> kClass, Object obj) {
            return (Builder) Taggable.Builder.DefaultImpls.tag(this, kClass, obj);
        }

        @Override // com.squareup.kotlinpoet.Taggable.Builder
        public /* bridge */ /* synthetic */ Builder tag(Class cls, Object obj) {
            return tag((Class<?>) cls, obj);
        }

        @Override // com.squareup.kotlinpoet.Taggable.Builder
        public /* bridge */ /* synthetic */ Builder tag(KClass kClass, Object obj) {
            return tag((KClass<?>) kClass, obj);
        }

        /* renamed from: getName$kotlinpoet, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: getType$kotlinpoet, reason: from getter */
        public final TypeName getType() {
            return this.type;
        }

        /* renamed from: getDefaultValue$kotlinpoet, reason: from getter */
        public final CodeBlock getDefaultValue() {
            return this.defaultValue;
        }

        public final void setDefaultValue$kotlinpoet(CodeBlock codeBlock) {
            this.defaultValue = codeBlock;
        }

        public final CodeBlock.Builder getKdoc() {
            return this.kdoc;
        }

        public final List<AnnotationSpec> getAnnotations() {
            return this.annotations;
        }

        public final List<KModifier> getModifiers() {
            return this.modifiers;
        }

        @Override // com.squareup.kotlinpoet.Taggable.Builder
        public Map<KClass<?>, Object> getTags() {
            return this.tags;
        }

        public final Builder addKdoc(String format, Object... args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            this.kdoc.add(format, Arrays.copyOf(args, args.length));
            return this;
        }

        public final Builder addKdoc(CodeBlock block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.kdoc.add(block);
            return this;
        }

        public final Builder addAnnotations(Iterable<AnnotationSpec> annotationSpecs) {
            Intrinsics.checkNotNullParameter(annotationSpecs, "annotationSpecs");
            CollectionsKt.addAll(this.annotations, annotationSpecs);
            return this;
        }

        public final Builder addAnnotation(AnnotationSpec annotationSpec) {
            Intrinsics.checkNotNullParameter(annotationSpec, "annotationSpec");
            this.annotations.add(annotationSpec);
            return this;
        }

        public final Builder addAnnotation(ClassName annotation) {
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            this.annotations.add(AnnotationSpec.INSTANCE.builder(annotation).build());
            return this;
        }

        public final Builder addAnnotation(Class<?> annotation) {
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            return addAnnotation(ClassNames.get(annotation));
        }

        public final Builder addAnnotation(KClass<?> annotation) {
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            return addAnnotation(ClassNames.get(annotation));
        }

        public final Builder addModifiers(KModifier... modifiers) {
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            CollectionsKt.addAll(this.modifiers, modifiers);
            return this;
        }

        public final Builder addModifiers(Iterable<? extends KModifier> modifiers) {
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            CollectionsKt.addAll(this.modifiers, modifiers);
            return this;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "There are no jvm modifiers applicable to parameters in Kotlin", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public final Builder jvmModifiers(Iterable<? extends Modifier> modifiers) {
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            throw new IllegalArgumentException("JVM modifiers are not permitted on parameters in Kotlin");
        }

        public final Builder defaultValue(String format, Object... args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            return defaultValue(CodeBlock.INSTANCE.of(format, Arrays.copyOf(args, args.length)));
        }

        public final Builder defaultValue(CodeBlock codeBlock) {
            this.defaultValue = codeBlock;
            return this;
        }

        public final ParameterSpec build() {
            return new ParameterSpec(this, null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: ParameterSpec.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000bH\u0007¢\u0006\u0002\u0010\fJ&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0007J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000e2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000bH\u0007¢\u0006\u0002\u0010\u000fJ&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0007J5\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00102\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0011J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u000eH\u0007J\u0014\u0010\u001a\u001a\u00020\u00132\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0007¨\u0006\u001b"}, d2 = {"Lcom/squareup/kotlinpoet/ParameterSpec$Companion;", "", "()V", "builder", "Lcom/squareup/kotlinpoet/ParameterSpec$Builder;", "name", "", "type", "Lcom/squareup/kotlinpoet/TypeName;", "modifiers", "", "Lcom/squareup/kotlinpoet/KModifier;", "(Ljava/lang/String;Lcom/squareup/kotlinpoet/TypeName;[Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/ParameterSpec$Builder;", "", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;[Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/ParameterSpec$Builder;", "Lkotlin/reflect/KClass;", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/ParameterSpec$Builder;", b.ar, "Lcom/squareup/kotlinpoet/ParameterSpec;", "element", "Ljavax/lang/model/element/VariableElement;", "parametersOf", "", "method", "Ljavax/lang/model/element/ExecutableElement;", "unnamed", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ParameterSpec get(VariableElement element) {
            Intrinsics.checkNotNullParameter(element, "element");
            String obj = element.getSimpleName().toString();
            TypeMirror asType = element.asType();
            Intrinsics.checkNotNullExpressionValue(asType, "element.asType()");
            return builder(obj, TypeNames.get(asType), new KModifier[0]).build();
        }

        @JvmStatic
        public final List<ParameterSpec> parametersOf(ExecutableElement method) {
            Intrinsics.checkNotNullParameter(method, "method");
            List parameters = method.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "method.parameters");
            List list = parameters;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(get((VariableElement) it.next()));
            }
            return arrayList;
        }

        @JvmStatic
        public final Builder builder(String name, TypeName type, KModifier... modifiers) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            return new Builder(name, type).addModifiers((KModifier[]) Arrays.copyOf(modifiers, modifiers.length));
        }

        @JvmStatic
        public final Builder builder(String name, Type type, KModifier... modifiers) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            return builder(name, TypeNames.get(type), (KModifier[]) Arrays.copyOf(modifiers, modifiers.length));
        }

        @JvmStatic
        public final Builder builder(String name, KClass<?> type, KModifier... modifiers) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            return builder(name, TypeNames.get(type), (KModifier[]) Arrays.copyOf(modifiers, modifiers.length));
        }

        @JvmStatic
        public final Builder builder(String name, TypeName type, Iterable<? extends KModifier> modifiers) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            return new Builder(name, type).addModifiers(modifiers);
        }

        @JvmStatic
        public final Builder builder(String name, Type type, Iterable<? extends KModifier> modifiers) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            return builder(name, TypeNames.get(type), modifiers);
        }

        @JvmStatic
        public final Builder builder(String name, KClass<?> type, Iterable<? extends KModifier> modifiers) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            return builder(name, TypeNames.get(type), modifiers);
        }

        @JvmStatic
        public final ParameterSpec unnamed(KClass<?> type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return unnamed(TypeNames.get(type));
        }

        @JvmStatic
        public final ParameterSpec unnamed(Type type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return unnamed(TypeNames.get(type));
        }

        @JvmStatic
        public final ParameterSpec unnamed(TypeName type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new Builder("", type).build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        CodeWriter codeWriter = new CodeWriter(sb, null, null, null, null, Integer.MAX_VALUE, 30, null);
        try {
            emit$kotlinpoet$default(this, codeWriter, false, false, false, 14, null);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(codeWriter, null);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
            return sb2;
        } finally {
        }
    }
}
