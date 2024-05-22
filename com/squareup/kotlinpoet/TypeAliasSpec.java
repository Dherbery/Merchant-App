package com.squareup.kotlinpoet;

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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: TypeAliasSpec.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 82\u00020\u0001:\u000278B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0000¢\u0006\u0002\b*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010.\u001a\u00020/H\u0016J(\u00100\u001a\u0004\u0018\u0001H1\"\b\b\u0000\u00101*\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H102H\u0096\u0001¢\u0006\u0002\u00103J(\u00100\u001a\u0004\u0018\u0001H1\"\b\b\u0000\u00101*\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H10\u001bH\u0096\u0001¢\u0006\u0002\u00104J\u001c\u00105\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007J\b\u00106\u001a\u00020\u0016H\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0019\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b\u0012\u0004\u0012\u00020\u001c0\u001a8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u000b¨\u00069"}, d2 = {"Lcom/squareup/kotlinpoet/TypeAliasSpec;", "Lcom/squareup/kotlinpoet/Taggable;", "builder", "Lcom/squareup/kotlinpoet/TypeAliasSpec$Builder;", "tagMap", "Lcom/squareup/kotlinpoet/TagMap;", "(Lcom/squareup/kotlinpoet/TypeAliasSpec$Builder;Lcom/squareup/kotlinpoet/TagMap;)V", "annotations", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "getAnnotations", "()Ljava/util/List;", "kdoc", "Lcom/squareup/kotlinpoet/CodeBlock;", "getKdoc", "()Lcom/squareup/kotlinpoet/CodeBlock;", "modifiers", "", "Lcom/squareup/kotlinpoet/KModifier;", "getModifiers", "()Ljava/util/Set;", "name", "", "getName", "()Ljava/lang/String;", "tags", "", "Lkotlin/reflect/KClass;", "", "getTags", "()Ljava/util/Map;", "type", "Lcom/squareup/kotlinpoet/TypeName;", "getType", "()Lcom/squareup/kotlinpoet/TypeName;", "typeVariables", "Lcom/squareup/kotlinpoet/TypeVariableName;", "getTypeVariables", "emit", "", "codeWriter", "Lcom/squareup/kotlinpoet/CodeWriter;", "emit$kotlinpoet", "equals", "", "other", "hashCode", "", "tag", "T", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toBuilder", "toString", "Builder", "Companion", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class TypeAliasSpec implements Taggable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<AnnotationSpec> annotations;
    private final CodeBlock kdoc;
    private final Set<KModifier> modifiers;
    private final String name;
    private final TagMap tagMap;
    private final TypeName type;
    private final List<TypeVariableName> typeVariables;

    @JvmStatic
    public static final Builder builder(String str, TypeName typeName) {
        return INSTANCE.builder(str, typeName);
    }

    @JvmStatic
    public static final Builder builder(String str, Type type) {
        return INSTANCE.builder(str, type);
    }

    @JvmStatic
    public static final Builder builder(String str, KClass<?> kClass) {
        return INSTANCE.builder(str, kClass);
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

    public final Builder toBuilder() {
        return toBuilder$default(this, null, null, 3, null);
    }

    public final Builder toBuilder(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return toBuilder$default(this, name, null, 2, null);
    }

    private TypeAliasSpec(Builder builder, TagMap tagMap) {
        this.tagMap = tagMap;
        this.name = builder.getName();
        this.type = builder.getType();
        this.modifiers = UtilKt.toImmutableSet(builder.getModifiers());
        this.typeVariables = UtilKt.toImmutableList(builder.getTypeVariables());
        this.kdoc = builder.getKdoc().build();
        this.annotations = UtilKt.toImmutableList(builder.getAnnotations());
    }

    /* synthetic */ TypeAliasSpec(Builder builder, TagMap tagMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder, (i & 2) != 0 ? TaggableKt.buildTagMap(builder) : tagMap);
    }

    public final String getName() {
        return this.name;
    }

    public final TypeName getType() {
        return this.type;
    }

    public final Set<KModifier> getModifiers() {
        return this.modifiers;
    }

    public final List<TypeVariableName> getTypeVariables() {
        return this.typeVariables;
    }

    public final CodeBlock getKdoc() {
        return this.kdoc;
    }

    public final List<AnnotationSpec> getAnnotations() {
        return this.annotations;
    }

    public final void emit$kotlinpoet(CodeWriter codeWriter) {
        Intrinsics.checkNotNullParameter(codeWriter, "codeWriter");
        codeWriter.emitKdoc(UtilKt.ensureEndsWithNewLine(this.kdoc));
        codeWriter.emitAnnotations(this.annotations, false);
        codeWriter.emitModifiers(this.modifiers, SetsKt.setOf(KModifier.PUBLIC));
        codeWriter.emitCode("typealias %N", this.name);
        codeWriter.emitTypeVariables(this.typeVariables);
        codeWriter.emitCode(" = %T", this.type);
        CodeWriter.emit$default(codeWriter, "\n", false, 2, null);
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

    public static /* synthetic */ Builder toBuilder$default(TypeAliasSpec typeAliasSpec, String str, TypeName typeName, int i, Object obj) {
        if ((i & 1) != 0) {
            str = typeAliasSpec.name;
        }
        if ((i & 2) != 0) {
            typeName = typeAliasSpec.type;
        }
        return typeAliasSpec.toBuilder(str, typeName);
    }

    public final Builder toBuilder(String name, TypeName type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Builder builder = new Builder(name, type);
        CollectionsKt.addAll(builder.getModifiers(), this.modifiers);
        CollectionsKt.addAll(builder.getTypeVariables(), this.typeVariables);
        builder.getKdoc().add(this.kdoc);
        CollectionsKt.addAll(builder.getAnnotations(), this.annotations);
        builder.getTags().putAll(this.tagMap.getTags());
        return builder;
    }

    /* compiled from: TypeAliasSpec.kt */
    @Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001;B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\tJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%J\u0014\u0010\"\u001a\u00020\u00002\n\u0010$\u001a\u0006\u0012\u0002\b\u00030&H\u0007J\u0012\u0010\"\u001a\u00020\u00002\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\u0019J\u0014\u0010'\u001a\u00020\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0)J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,J'\u0010*\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u00032\u0012\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0/\"\u00020\u001a¢\u0006\u0002\u00100J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0012H\u0002J\u001f\u00104\u001a\u00020\u00002\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120/\"\u00020\u0012¢\u0006\u0002\u00105J\u0014\u00104\u001a\u00020\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120)J\u000e\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u00020 J\u0014\u00108\u001a\u00020\u00002\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0)J\u0006\u00109\u001a\u00020:R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u0004\u0012\u00020\u001a0\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014¨\u0006<"}, d2 = {"Lcom/squareup/kotlinpoet/TypeAliasSpec$Builder;", "Lcom/squareup/kotlinpoet/Taggable$Builder;", "name", "", "type", "Lcom/squareup/kotlinpoet/TypeName;", "(Ljava/lang/String;Lcom/squareup/kotlinpoet/TypeName;)V", "annotations", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "getAnnotations", "()Ljava/util/List;", "kdoc", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "getKdoc$kotlinpoet", "()Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "modifiers", "", "Lcom/squareup/kotlinpoet/KModifier;", "getModifiers", "()Ljava/util/Set;", "getName$kotlinpoet", "()Ljava/lang/String;", "tags", "", "Lkotlin/reflect/KClass;", "", "getTags", "()Ljava/util/Map;", "getType$kotlinpoet", "()Lcom/squareup/kotlinpoet/TypeName;", "typeVariables", "Lcom/squareup/kotlinpoet/TypeVariableName;", "getTypeVariables", "addAnnotation", "annotationSpec", "annotation", "Lcom/squareup/kotlinpoet/ClassName;", "Ljava/lang/Class;", "addAnnotations", "annotationSpecs", "", "addKdoc", "block", "Lcom/squareup/kotlinpoet/CodeBlock;", "format", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/squareup/kotlinpoet/TypeAliasSpec$Builder;", "addModifier", "", "modifier", "addModifiers", "([Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/TypeAliasSpec$Builder;", "addTypeVariable", "typeVariable", "addTypeVariables", "build", "Lcom/squareup/kotlinpoet/TypeAliasSpec;", "Companion", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder implements Taggable.Builder<Builder> {
        private final List<AnnotationSpec> annotations;
        private final CodeBlock.Builder kdoc;
        private final Set<KModifier> modifiers;
        private final String name;
        private final Map<KClass<?>, Object> tags;
        private final TypeName type;
        private final Set<TypeVariableName> typeVariables;
        private static final Companion Companion = new Companion(null);

        @Deprecated
        private static final Set<KModifier> ALLOWABLE_MODIFIERS = SetsKt.setOf((Object[]) new KModifier[]{KModifier.PUBLIC, KModifier.INTERNAL, KModifier.PRIVATE, KModifier.ACTUAL});

        public Builder(String name, TypeName type) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            this.name = name;
            this.type = type;
            this.kdoc = CodeBlock.INSTANCE.builder();
            this.modifiers = new LinkedHashSet();
            this.typeVariables = new LinkedHashSet();
            this.annotations = new ArrayList();
            this.tags = new LinkedHashMap();
        }

        @Override // com.squareup.kotlinpoet.Taggable.Builder
        public /* bridge */ /* synthetic */ Builder tag(Class cls, Object obj) {
            return tag2((Class<?>) cls, obj);
        }

        @Override // com.squareup.kotlinpoet.Taggable.Builder
        public /* bridge */ /* synthetic */ Builder tag(KClass kClass, Object obj) {
            return tag2((KClass<?>) kClass, obj);
        }

        @Override // com.squareup.kotlinpoet.Taggable.Builder
        /* renamed from: tag, reason: avoid collision after fix types in other method */
        public Builder tag2(Class<?> cls, Object obj) {
            return (Builder) Taggable.Builder.DefaultImpls.tag(this, cls, obj);
        }

        @Override // com.squareup.kotlinpoet.Taggable.Builder
        /* renamed from: tag, reason: avoid collision after fix types in other method */
        public Builder tag2(KClass<?> kClass, Object obj) {
            return (Builder) Taggable.Builder.DefaultImpls.tag(this, kClass, obj);
        }

        /* renamed from: getName$kotlinpoet, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: getType$kotlinpoet, reason: from getter */
        public final TypeName getType() {
            return this.type;
        }

        /* renamed from: getKdoc$kotlinpoet, reason: from getter */
        public final CodeBlock.Builder getKdoc() {
            return this.kdoc;
        }

        public final Set<KModifier> getModifiers() {
            return this.modifiers;
        }

        public final Set<TypeVariableName> getTypeVariables() {
            return this.typeVariables;
        }

        public final List<AnnotationSpec> getAnnotations() {
            return this.annotations;
        }

        @Override // com.squareup.kotlinpoet.Taggable.Builder
        public Map<KClass<?>, Object> getTags() {
            return this.tags;
        }

        public final Builder addModifiers(KModifier... modifiers) {
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            for (KModifier kModifier : modifiers) {
                addModifier(kModifier);
            }
            return this;
        }

        public final Builder addModifiers(Iterable<? extends KModifier> modifiers) {
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            Iterator<? extends KModifier> it = modifiers.iterator();
            while (it.hasNext()) {
                addModifier(it.next());
            }
            return this;
        }

        private final void addModifier(KModifier modifier) {
            this.modifiers.add(modifier);
        }

        public final Builder addTypeVariables(Iterable<TypeVariableName> typeVariables) {
            Intrinsics.checkNotNullParameter(typeVariables, "typeVariables");
            CollectionsKt.addAll(this.typeVariables, typeVariables);
            return this;
        }

        public final Builder addTypeVariable(TypeVariableName typeVariable) {
            Intrinsics.checkNotNullParameter(typeVariable, "typeVariable");
            this.typeVariables.add(typeVariable);
            return this;
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

        public final TypeAliasSpec build() {
            for (KModifier kModifier : this.modifiers) {
                if (!ALLOWABLE_MODIFIERS.contains(kModifier)) {
                    throw new IllegalArgumentException(("unexpected typealias modifier " + kModifier).toString());
                }
            }
            return new TypeAliasSpec(this, null, 2, 0 == true ? 1 : 0);
        }

        /* compiled from: TypeAliasSpec.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/squareup/kotlinpoet/TypeAliasSpec$Builder$Companion;", "", "()V", "ALLOWABLE_MODIFIERS", "", "Lcom/squareup/kotlinpoet/KModifier;", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: TypeAliasSpec.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\tH\u0007J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/squareup/kotlinpoet/TypeAliasSpec$Companion;", "", "()V", "builder", "Lcom/squareup/kotlinpoet/TypeAliasSpec$Builder;", "name", "", "type", "Lcom/squareup/kotlinpoet/TypeName;", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KClass;", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Builder builder(String name, TypeName type) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            return new Builder(name, type);
        }

        @JvmStatic
        public final Builder builder(String name, Type type) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            return builder(name, TypeNames.get(type));
        }

        @JvmStatic
        public final Builder builder(String name, KClass<?> type) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            return builder(name, TypeNames.get(type));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        CodeWriter codeWriter = new CodeWriter(sb, null, null, null, null, Integer.MAX_VALUE, 30, null);
        try {
            emit$kotlinpoet(codeWriter);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(codeWriter, null);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
            return sb2;
        } finally {
        }
    }
}
