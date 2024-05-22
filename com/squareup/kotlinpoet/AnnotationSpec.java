package com.squareup.kotlinpoet;

import androidx.browser.trusted.sharing.ShareTarget;
import com.amazon.a.a.o.b;
import com.amazon.a.a.o.b.f;
import com.onesignal.notifications.internal.bundle.impl.NotificationBundleProcessor;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.squareup.kotlinpoet.CodeBlock;
import com.squareup.kotlinpoet.Taggable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.AnnotationValueVisitor;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor7;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: AnnotationSpec.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 62\u00020\u0001:\u00045678B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J'\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%H\u0000¢\u0006\u0002\b'J\u0013\u0010(\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010*\u001a\u00020+H\u0016J(\u0010,\u001a\u0004\u0018\u0001H-\"\b\b\u0000\u0010-*\u00020\u00152\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0/H\u0096\u0001¢\u0006\u0002\u00100J(\u0010,\u001a\u0004\u0018\u0001H-\"\b\b\u0000\u0010-*\u00020\u00152\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0\u0014H\u0096\u0001¢\u0006\u0002\u00101J\u0006\u00102\u001a\u00020\u0003J\b\u00103\u001a\u000204H\u0016R\u001a\u0010\u0007\u001a\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\u0004\u0012\u00020\u00150\u00138VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00069"}, d2 = {"Lcom/squareup/kotlinpoet/AnnotationSpec;", "Lcom/squareup/kotlinpoet/Taggable;", "builder", "Lcom/squareup/kotlinpoet/AnnotationSpec$Builder;", "tagMap", "Lcom/squareup/kotlinpoet/TagMap;", "(Lcom/squareup/kotlinpoet/AnnotationSpec$Builder;Lcom/squareup/kotlinpoet/TagMap;)V", "className", "Lcom/squareup/kotlinpoet/ClassName;", "getClassName$annotations", "()V", "getClassName", "()Lcom/squareup/kotlinpoet/ClassName;", "members", "", "Lcom/squareup/kotlinpoet/CodeBlock;", "getMembers", "()Ljava/util/List;", "tags", "", "Lkotlin/reflect/KClass;", "", "getTags", "()Ljava/util/Map;", "typeName", "Lcom/squareup/kotlinpoet/TypeName;", "getTypeName", "()Lcom/squareup/kotlinpoet/TypeName;", "useSiteTarget", "Lcom/squareup/kotlinpoet/AnnotationSpec$UseSiteTarget;", "getUseSiteTarget", "()Lcom/squareup/kotlinpoet/AnnotationSpec$UseSiteTarget;", "emit", "", "codeWriter", "Lcom/squareup/kotlinpoet/CodeWriter;", "inline", "", "asParameter", "emit$kotlinpoet", "equals", "other", "hashCode", "", "tag", "T", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toBuilder", "toString", "", "Builder", "Companion", "UseSiteTarget", "Visitor", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class AnnotationSpec implements Taggable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<CodeBlock> members;
    private final TagMap tagMap;
    private final TypeName typeName;
    private final UseSiteTarget useSiteTarget;

    @JvmStatic
    public static final Builder builder(ClassName className) {
        return INSTANCE.builder(className);
    }

    @JvmStatic
    public static final Builder builder(ParameterizedTypeName parameterizedTypeName) {
        return INSTANCE.builder(parameterizedTypeName);
    }

    @JvmStatic
    public static final Builder builder(Class<? extends Annotation> cls) {
        return INSTANCE.builder(cls);
    }

    @JvmStatic
    public static final Builder builder(KClass<? extends Annotation> kClass) {
        return INSTANCE.builder(kClass);
    }

    @JvmStatic
    public static final AnnotationSpec get(Annotation annotation) {
        return INSTANCE.get(annotation);
    }

    @JvmStatic
    public static final AnnotationSpec get(Annotation annotation, boolean z) {
        return INSTANCE.get(annotation, z);
    }

    @JvmStatic
    public static final AnnotationSpec get(AnnotationMirror annotationMirror) {
        return INSTANCE.get(annotationMirror);
    }

    @Deprecated(message = "Use typeName instead. This property will be removed in KotlinPoet 2.0.", replaceWith = @ReplaceWith(expression = "typeName", imports = {}))
    public static /* synthetic */ void getClassName$annotations() {
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

    private AnnotationSpec(Builder builder, TagMap tagMap) {
        this.tagMap = tagMap;
        this.typeName = builder.getTypeName();
        this.members = UtilKt.toImmutableList(builder.getMembers());
        this.useSiteTarget = builder.getUseSiteTarget();
    }

    /* synthetic */ AnnotationSpec(Builder builder, TagMap tagMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder, (i & 2) != 0 ? TaggableKt.buildTagMap(builder) : tagMap);
    }

    public final ClassName getClassName() {
        TypeName typeName = this.typeName;
        ClassName className = typeName instanceof ClassName ? (ClassName) typeName : null;
        if (className != null) {
            return className;
        }
        throw new IllegalStateException("ClassName is not available. Call typeName instead.".toString());
    }

    public final TypeName getTypeName() {
        return this.typeName;
    }

    public final List<CodeBlock> getMembers() {
        return this.members;
    }

    public final UseSiteTarget getUseSiteTarget() {
        return this.useSiteTarget;
    }

    public static /* synthetic */ void emit$kotlinpoet$default(AnnotationSpec annotationSpec, CodeWriter codeWriter, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        annotationSpec.emit$kotlinpoet(codeWriter, z, z2);
    }

    public final void emit$kotlinpoet(CodeWriter codeWriter, boolean inline, boolean asParameter) {
        Intrinsics.checkNotNullParameter(codeWriter, "codeWriter");
        if (!asParameter) {
            CodeWriter.emit$default(codeWriter, "@", false, 2, null);
        }
        if (this.useSiteTarget != null) {
            CodeWriter.emit$default(codeWriter, this.useSiteTarget.getKeyword() + AbstractJsonLexerKt.COLON, false, 2, null);
        }
        codeWriter.emitCode("%T", this.typeName);
        if (!this.members.isEmpty() || asParameter) {
            String str = inline ? "" : "\n";
            String str2 = inline ? ", " : ",\n";
            String str3 = (inline || this.members.size() <= 1) ? "" : f.a;
            CodeWriter.emit$default(codeWriter, "(", false, 2, null);
            if (this.members.size() > 1) {
                CodeWriter.emit$default(codeWriter, str, false, 2, null).indent(1);
            }
            List<CodeBlock> list = this.members;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (CodeBlock codeBlock : list) {
                if (inline) {
                    codeBlock = codeBlock.replaceAll$kotlinpoet("[⇥|⇤]", "");
                }
                arrayList.add(codeBlock);
            }
            CodeWriter.emitCode$default(codeWriter, CodeBlocks.joinToCode$default(arrayList, str2, null, str3, 2, null), true, false, 4, null);
            if (this.members.size() > 1) {
                CodeWriter.emit$default(codeWriter.unindent(1), str, false, 2, null);
            }
            CodeWriter.emit$default(codeWriter, ")", false, 2, null);
        }
    }

    public final Builder toBuilder() {
        Builder builder = new Builder(this.typeName);
        CollectionsKt.addAll(builder.getMembers(), this.members);
        builder.setUseSiteTarget$kotlinpoet(this.useSiteTarget);
        builder.getTags().putAll(this.tagMap.getTags());
        return builder;
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

    /* compiled from: AnnotationSpec.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/squareup/kotlinpoet/AnnotationSpec$UseSiteTarget;", "", "keyword", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKeyword$kotlinpoet", "()Ljava/lang/String;", "FILE", "PROPERTY", "FIELD", ShareTarget.METHOD_GET, "SET", "RECEIVER", "PARAM", "SETPARAM", "DELEGATE", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public enum UseSiteTarget {
        FILE("file"),
        PROPERTY("property"),
        FIELD("field"),
        GET(b.ar),
        SET("set"),
        RECEIVER("receiver"),
        PARAM("param"),
        SETPARAM("setparam"),
        DELEGATE("delegate");

        private final String keyword;

        UseSiteTarget(String str) {
            this.keyword = str;
        }

        /* renamed from: getKeyword$kotlinpoet, reason: from getter */
        public final String getKeyword() {
            return this.keyword;
        }
    }

    /* compiled from: AnnotationSpec.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001!B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0007J'\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u001d\"\u00020\r¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR$\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\r0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/squareup/kotlinpoet/AnnotationSpec$Builder;", "Lcom/squareup/kotlinpoet/Taggable$Builder;", "typeName", "Lcom/squareup/kotlinpoet/TypeName;", "(Lcom/squareup/kotlinpoet/TypeName;)V", "members", "", "Lcom/squareup/kotlinpoet/CodeBlock;", "getMembers", "()Ljava/util/List;", "tags", "", "Lkotlin/reflect/KClass;", "", "getTags", "()Ljava/util/Map;", "getTypeName$kotlinpoet", "()Lcom/squareup/kotlinpoet/TypeName;", "useSiteTarget", "Lcom/squareup/kotlinpoet/AnnotationSpec$UseSiteTarget;", "getUseSiteTarget$kotlinpoet", "()Lcom/squareup/kotlinpoet/AnnotationSpec$UseSiteTarget;", "setUseSiteTarget$kotlinpoet", "(Lcom/squareup/kotlinpoet/AnnotationSpec$UseSiteTarget;)V", "addMember", "codeBlock", "format", "", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/squareup/kotlinpoet/AnnotationSpec$Builder;", "build", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "Companion", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder implements Taggable.Builder<Builder> {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<CodeBlock> members;
        private final Map<KClass<?>, Object> tags;
        private final TypeName typeName;
        private UseSiteTarget useSiteTarget;

        public Builder(TypeName typeName) {
            Intrinsics.checkNotNullParameter(typeName, "typeName");
            this.typeName = typeName;
            this.members = new ArrayList();
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

        /* renamed from: getTypeName$kotlinpoet, reason: from getter */
        public final TypeName getTypeName() {
            return this.typeName;
        }

        /* renamed from: getUseSiteTarget$kotlinpoet, reason: from getter */
        public final UseSiteTarget getUseSiteTarget() {
            return this.useSiteTarget;
        }

        public final void setUseSiteTarget$kotlinpoet(UseSiteTarget useSiteTarget) {
            this.useSiteTarget = useSiteTarget;
        }

        public final List<CodeBlock> getMembers() {
            return this.members;
        }

        @Override // com.squareup.kotlinpoet.Taggable.Builder
        public Map<KClass<?>, Object> getTags() {
            return this.tags;
        }

        public final Builder addMember(String format, Object... args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            return addMember(CodeBlock.INSTANCE.of(format, Arrays.copyOf(args, args.length)));
        }

        public final Builder addMember(CodeBlock codeBlock) {
            Intrinsics.checkNotNullParameter(codeBlock, "codeBlock");
            this.members.add(codeBlock);
            return this;
        }

        public final Builder useSiteTarget(UseSiteTarget useSiteTarget) {
            this.useSiteTarget = useSiteTarget;
            return this;
        }

        public final AnnotationSpec build() {
            return new AnnotationSpec(this, null, 2, 0 == true ? 1 : 0);
        }

        /* compiled from: AnnotationSpec.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/squareup/kotlinpoet/AnnotationSpec$Builder$Companion;", "", "()V", "memberForValue", "Lcom/squareup/kotlinpoet/CodeBlock;", "value", "memberForValue$kotlinpoet", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final CodeBlock memberForValue$kotlinpoet(Object value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value instanceof Class ? CodeBlock.INSTANCE.of("%T::class", value) : value instanceof Enum ? CodeBlock.INSTANCE.of("%T.%L", value.getClass(), ((Enum) value).name()) : value instanceof String ? CodeBlock.INSTANCE.of("%S", value) : value instanceof Float ? CodeBlock.INSTANCE.of("%Lf", value) : value instanceof Character ? CodeBlock.INSTANCE.of("'%L'", UtilKt.characterLiteralWithoutSingleQuotes(((Character) value).charValue())) : CodeBlock.INSTANCE.of("%L", value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnnotationSpec.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0014J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u001e\u0010\u000f\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/squareup/kotlinpoet/AnnotationSpec$Visitor;", "Ljavax/lang/model/util/SimpleAnnotationValueVisitor7;", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "", "builder", "(Lcom/squareup/kotlinpoet/CodeBlock$Builder;)V", "getBuilder", "()Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "defaultAction", NotificationBundleProcessor.PUSH_MINIFIED_BUTTONS_LIST, "", "name", "visitAnnotation", "a", "Ljavax/lang/model/element/AnnotationMirror;", "visitArray", DiagnosticsEntry.Histogram.VALUES_KEY, "", "Ljavax/lang/model/element/AnnotationValue;", "visitEnumConstant", "c", "Ljavax/lang/model/element/VariableElement;", "visitType", "t", "Ljavax/lang/model/type/TypeMirror;", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Visitor extends SimpleAnnotationValueVisitor7<CodeBlock.Builder, String> {
        private final CodeBlock.Builder builder;

        public /* bridge */ /* synthetic */ Object visitArray(List list, Object obj) {
            return visitArray((List<? extends AnnotationValue>) list, (String) obj);
        }

        public final CodeBlock.Builder getBuilder() {
            return this.builder;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Visitor(CodeBlock.Builder builder) {
            super(builder);
            Intrinsics.checkNotNullParameter(builder, "builder");
            this.builder = builder;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public CodeBlock.Builder defaultAction(Object o, String name) {
            Intrinsics.checkNotNullParameter(o, "o");
            Intrinsics.checkNotNullParameter(name, "name");
            return this.builder.add(Builder.INSTANCE.memberForValue$kotlinpoet(o));
        }

        public CodeBlock.Builder visitAnnotation(AnnotationMirror a, String name) {
            Intrinsics.checkNotNullParameter(a, "a");
            Intrinsics.checkNotNullParameter(name, "name");
            return this.builder.add("%L", AnnotationSpec.INSTANCE.get(a));
        }

        public CodeBlock.Builder visitEnumConstant(VariableElement c, String name) {
            Intrinsics.checkNotNullParameter(c, "c");
            Intrinsics.checkNotNullParameter(name, "name");
            CodeBlock.Builder builder = this.builder;
            TypeMirror asType = c.asType();
            Intrinsics.checkNotNullExpressionValue(asType, "c.asType()");
            return builder.add("%T.%L", TypeNames.get(asType), c.getSimpleName());
        }

        public CodeBlock.Builder visitType(TypeMirror t, String name) {
            Intrinsics.checkNotNullParameter(t, "t");
            Intrinsics.checkNotNullParameter(name, "name");
            return this.builder.add("%T::class", TypeNames.get(t));
        }

        public CodeBlock.Builder visitArray(List<? extends AnnotationValue> values, String name) {
            Intrinsics.checkNotNullParameter(values, "values");
            Intrinsics.checkNotNullParameter(name, "name");
            this.builder.add("arrayOf(⇥⇥", new Object[0]);
            int i = 0;
            for (Object obj : values) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                AnnotationValue annotationValue = (AnnotationValue) obj;
                if (i > 0) {
                    this.builder.add(", ", new Object[0]);
                }
                annotationValue.accept((AnnotationValueVisitor) this, name);
                i = i2;
            }
            this.builder.add("⇤⇤)", new Object[0]);
            return this.builder;
        }
    }

    /* compiled from: AnnotationSpec.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0007J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\bH\u0007J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¨\u0006\u0011"}, d2 = {"Lcom/squareup/kotlinpoet/AnnotationSpec$Companion;", "", "()V", "builder", "Lcom/squareup/kotlinpoet/AnnotationSpec$Builder;", "type", "Lcom/squareup/kotlinpoet/ClassName;", "Lcom/squareup/kotlinpoet/ParameterizedTypeName;", "Ljava/lang/Class;", "", "Lkotlin/reflect/KClass;", b.ar, "Lcom/squareup/kotlinpoet/AnnotationSpec;", "annotation", "Ljavax/lang/model/element/AnnotationMirror;", "includeDefaultValues", "", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final AnnotationSpec get(Annotation annotation) {
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            return get$default(this, annotation, false, 2, null);
        }

        private Companion() {
        }

        public static /* synthetic */ AnnotationSpec get$default(Companion companion, Annotation annotation, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.get(annotation, z);
        }

        @JvmStatic
        public final AnnotationSpec get(Annotation annotation, boolean includeDefaultValues) {
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            try {
                Class<? extends Annotation> annotationType = annotation.annotationType();
                Intrinsics.checkNotNullExpressionValue(annotationType, "javaAnnotation.annotationType()");
                Builder builder = (Builder) builder(annotationType).tag(Reflection.getOrCreateKotlinClass(Object.class), (Object) annotation);
                Method[] declaredMethods = annotation.annotationType().getDeclaredMethods();
                Intrinsics.checkNotNullExpressionValue(declaredMethods, "annotation.annotationType().declaredMethods");
                for (Method method : ArraysKt.sortedWith(declaredMethods, new Comparator() { // from class: com.squareup.kotlinpoet.AnnotationSpec$Companion$get$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((Method) t).getName(), ((Method) t2).getName());
                    }
                })) {
                    Object value = method.invoke(annotation, new Object[0]);
                    if (includeDefaultValues || !Objects.deepEquals(value, method.getDefaultValue())) {
                        CodeBlock.Builder builder2 = CodeBlock.INSTANCE.builder();
                        builder2.add("%L = ", method.getName());
                        if (value.getClass().isArray()) {
                            builder2.add("arrayOf(⇥⇥", new Object[0]);
                            int length = Array.getLength(value);
                            for (int i = 0; i < length; i++) {
                                if (i > 0) {
                                    builder2.add(", ", new Object[0]);
                                }
                                Builder.Companion companion = Builder.INSTANCE;
                                Object obj = Array.get(value, i);
                                Intrinsics.checkNotNullExpressionValue(obj, "get(value, i)");
                                builder2.add(companion.memberForValue$kotlinpoet(obj));
                            }
                            builder2.add("⇤⇤)", new Object[0]);
                            builder.addMember(builder2.build());
                        } else if (value instanceof Annotation) {
                            builder2.add("%L", get$default(this, (Annotation) value, false, 2, null));
                            builder.addMember(builder2.build());
                        } else {
                            Builder.Companion companion2 = Builder.INSTANCE;
                            Intrinsics.checkNotNullExpressionValue(value, "value");
                            builder2.add("%L", companion2.memberForValue$kotlinpoet(value));
                            builder.addMember(builder2.build());
                        }
                    }
                }
                return builder.build();
            } catch (Exception e) {
                throw new RuntimeException("Reflecting " + annotation + " failed!", e);
            }
        }

        @JvmStatic
        public final AnnotationSpec get(AnnotationMirror annotation) {
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            TypeElement asElement = annotation.getAnnotationType().asElement();
            Intrinsics.checkNotNull(asElement, "null cannot be cast to non-null type javax.lang.model.element.TypeElement");
            Builder builder = (Builder) builder(ClassNames.get(asElement)).tag(Reflection.getOrCreateKotlinClass(AnnotationMirror.class), (Object) annotation);
            for (ExecutableElement executableElement : annotation.getElementValues().keySet()) {
                CodeBlock.Builder builder2 = CodeBlock.INSTANCE.builder();
                AnnotationValueVisitor visitor = new Visitor(builder2);
                String obj = executableElement.getSimpleName().toString();
                builder2.add("%L = ", obj);
                Map elementValues = annotation.getElementValues();
                Intrinsics.checkNotNullExpressionValue(elementValues, "annotation.elementValues");
                Object obj2 = elementValues.get(executableElement);
                Intrinsics.checkNotNull(obj2);
                ((AnnotationValue) obj2).accept(visitor, obj);
                builder.addMember(builder2.build());
            }
            return builder.build();
        }

        @JvmStatic
        public final Builder builder(ClassName type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new Builder(type);
        }

        @JvmStatic
        public final Builder builder(ParameterizedTypeName type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new Builder(type);
        }

        @JvmStatic
        public final Builder builder(Class<? extends Annotation> type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return builder(ClassNames.get(type));
        }

        @JvmStatic
        public final Builder builder(KClass<? extends Annotation> type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return builder(ClassNames.get(type));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        CodeWriter codeWriter = new CodeWriter(sb, null, null, null, null, Integer.MAX_VALUE, 30, null);
        try {
            emit$kotlinpoet(codeWriter, true, false);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(codeWriter, null);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
            return sb2;
        } finally {
        }
    }
}
