package com.squareup.kotlinpoet;

import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.squareup.kotlinpoet.CodeBlock;
import com.squareup.kotlinpoet.OriginatingElementsHolder;
import com.squareup.kotlinpoet.Taggable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.Element;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* compiled from: TypeSpec.kt */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0003lmnB#\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0002\u0010\bJ\u0014\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020@0\u000fH\u0002J9\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010\u00102\u000e\b\u0002\u0010Y\u001a\b\u0012\u0004\u0012\u000201002\b\b\u0002\u0010Z\u001a\u00020\u0017H\u0000¢\u0006\u0002\b[J\u0013\u0010\\\u001a\u00020\u00172\b\u0010]\u001a\u0004\u0018\u00010LH\u0096\u0002J\b\u0010^\u001a\u00020!H\u0016J\u0018\u0010_\u001a\u00020\u00172\u0006\u0010`\u001a\u00020@2\u0006\u0010a\u001a\u00020bH\u0002J\b\u0010c\u001a\u00020\u001dH\u0002J(\u0010d\u001a\u0004\u0018\u0001He\"\b\b\u0000\u0010e*\u00020L2\f\u0010f\u001a\b\u0012\u0004\u0012\u0002He0gH\u0096\u0001¢\u0006\u0002\u0010hJ(\u0010d\u001a\u0004\u0018\u0001He\"\b\b\u0000\u0010e*\u00020L2\f\u0010f\u001a\b\u0012\u0004\u0012\u0002He0KH\u0096\u0001¢\u0006\u0002\u0010iJ\u001e\u0010j\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0010H\u0007J\b\u0010k\u001a\u00020\u0010H\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00000\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010%\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0011\u0010&\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0011\u0010'\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0011\u0010(\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0011\u0010)\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020100¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u00104\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001c\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001000X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00103R\u0018\u00109\u001a\b\u0012\u0004\u0012\u00020:0\nX\u0096\u0005¢\u0006\u0006\u001a\u0004\b;\u0010\rR\u0013\u0010<\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\n¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\rR\u0011\u0010B\u001a\u00020C¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001d0\n¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\rR\u001f\u0010H\u001a\u0010\u0012\u0004\u0012\u00020C\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u000f¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010J\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030K\u0012\u0004\u0012\u00020L0\u000f8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bM\u0010\u0012R\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00000\n¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\rR\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\n¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\r¨\u0006o"}, d2 = {"Lcom/squareup/kotlinpoet/TypeSpec;", "Lcom/squareup/kotlinpoet/Taggable;", "Lcom/squareup/kotlinpoet/OriginatingElementsHolder;", "builder", "Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "tagMap", "Lcom/squareup/kotlinpoet/TagMap;", "delegateOriginatingElements", "(Lcom/squareup/kotlinpoet/TypeSpec$Builder;Lcom/squareup/kotlinpoet/TagMap;Lcom/squareup/kotlinpoet/OriginatingElementsHolder;)V", "annotationSpecs", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "getAnnotationSpecs", "()Ljava/util/List;", "enumConstants", "", "", "getEnumConstants", "()Ljava/util/Map;", "funSpecs", "Lcom/squareup/kotlinpoet/FunSpec;", "getFunSpecs", "hasInitializer", "", "getHasInitializer", "()Z", "hasNoBody", "getHasNoBody", "initializerBlock", "Lcom/squareup/kotlinpoet/CodeBlock;", "getInitializerBlock", "()Lcom/squareup/kotlinpoet/CodeBlock;", "initializerIndex", "", "getInitializerIndex", "()I", "isAnnotation", "isAnonymousClass", "isCompanion", "isEnum", "isFunctionalInterface", "kdoc", "getKdoc", "kind", "Lcom/squareup/kotlinpoet/TypeSpec$Kind;", "getKind", "()Lcom/squareup/kotlinpoet/TypeSpec$Kind;", "modifiers", "", "Lcom/squareup/kotlinpoet/KModifier;", "getModifiers", "()Ljava/util/Set;", "name", "getName", "()Ljava/lang/String;", "nestedTypesSimpleNames", "getNestedTypesSimpleNames$kotlinpoet", "originatingElements", "Ljavax/lang/model/element/Element;", "getOriginatingElements", "primaryConstructor", "getPrimaryConstructor", "()Lcom/squareup/kotlinpoet/FunSpec;", "propertySpecs", "Lcom/squareup/kotlinpoet/PropertySpec;", "getPropertySpecs", "superclass", "Lcom/squareup/kotlinpoet/TypeName;", "getSuperclass", "()Lcom/squareup/kotlinpoet/TypeName;", "superclassConstructorParameters", "getSuperclassConstructorParameters", "superinterfaces", "getSuperinterfaces", "tags", "Lkotlin/reflect/KClass;", "", "getTags", "typeSpecs", "getTypeSpecs", "typeVariables", "Lcom/squareup/kotlinpoet/TypeVariableName;", "getTypeVariables", "constructorProperties", "emit", "", "codeWriter", "Lcom/squareup/kotlinpoet/CodeWriter;", "enumName", "implicitModifiers", "isNestedExternal", "emit$kotlinpoet", "equals", "other", "hashCode", "isPropertyInitializerConstructorParameter", "property", MediationConfiguration.CUSTOM_EVENT_SERVER_PARAMETER_FIELD, "Lcom/squareup/kotlinpoet/ParameterSpec;", "kdocWithConstructorParameters", "tag", "T", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toBuilder", "toString", "Builder", "Companion", "Kind", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class TypeSpec implements Taggable, OriginatingElementsHolder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<AnnotationSpec> annotationSpecs;
    private final OriginatingElementsHolder delegateOriginatingElements;
    private final Map<String, TypeSpec> enumConstants;
    private final List<FunSpec> funSpecs;
    private final CodeBlock initializerBlock;
    private final int initializerIndex;
    private final boolean isAnnotation;
    private final boolean isAnonymousClass;
    private final boolean isCompanion;
    private final boolean isEnum;
    private final boolean isFunctionalInterface;
    private final CodeBlock kdoc;
    private final Kind kind;
    private final Set<KModifier> modifiers;
    private final String name;
    private final Set<String> nestedTypesSimpleNames;
    private final FunSpec primaryConstructor;
    private final List<PropertySpec> propertySpecs;
    private final TypeName superclass;
    private final List<CodeBlock> superclassConstructorParameters;
    private final Map<TypeName, CodeBlock> superinterfaces;
    private final TagMap tagMap;
    private final List<TypeSpec> typeSpecs;
    private final List<TypeVariableName> typeVariables;

    @JvmStatic
    public static final Builder annotationBuilder(ClassName className) {
        return INSTANCE.annotationBuilder(className);
    }

    @JvmStatic
    public static final Builder annotationBuilder(String str) {
        return INSTANCE.annotationBuilder(str);
    }

    @JvmStatic
    public static final Builder anonymousClassBuilder() {
        return INSTANCE.anonymousClassBuilder();
    }

    @JvmStatic
    public static final Builder classBuilder(ClassName className) {
        return INSTANCE.classBuilder(className);
    }

    @JvmStatic
    public static final Builder classBuilder(String str) {
        return INSTANCE.classBuilder(str);
    }

    @JvmStatic
    public static final Builder companionObjectBuilder() {
        return INSTANCE.companionObjectBuilder();
    }

    @JvmStatic
    public static final Builder companionObjectBuilder(String str) {
        return INSTANCE.companionObjectBuilder(str);
    }

    @JvmStatic
    public static final Builder enumBuilder(ClassName className) {
        return INSTANCE.enumBuilder(className);
    }

    @JvmStatic
    public static final Builder enumBuilder(String str) {
        return INSTANCE.enumBuilder(str);
    }

    @JvmStatic
    public static final Builder expectClassBuilder(ClassName className) {
        return INSTANCE.expectClassBuilder(className);
    }

    @JvmStatic
    public static final Builder expectClassBuilder(String str) {
        return INSTANCE.expectClassBuilder(str);
    }

    @JvmStatic
    public static final Builder funInterfaceBuilder(ClassName className) {
        return INSTANCE.funInterfaceBuilder(className);
    }

    @JvmStatic
    public static final Builder funInterfaceBuilder(String str) {
        return INSTANCE.funInterfaceBuilder(str);
    }

    @JvmStatic
    public static final Builder interfaceBuilder(ClassName className) {
        return INSTANCE.interfaceBuilder(className);
    }

    @JvmStatic
    public static final Builder interfaceBuilder(String str) {
        return INSTANCE.interfaceBuilder(str);
    }

    @JvmStatic
    public static final Builder objectBuilder(ClassName className) {
        return INSTANCE.objectBuilder(className);
    }

    @JvmStatic
    public static final Builder objectBuilder(String str) {
        return INSTANCE.objectBuilder(str);
    }

    @JvmStatic
    public static final Builder valueClassBuilder(String str) {
        return INSTANCE.valueClassBuilder(str);
    }

    @Override // com.squareup.kotlinpoet.OriginatingElementsHolder
    public List<Element> getOriginatingElements() {
        return this.delegateOriginatingElements.getOriginatingElements();
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

    public final Builder toBuilder(Kind kind) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        return toBuilder$default(this, kind, null, 2, null);
    }

    private TypeSpec(Builder builder, TagMap tagMap, OriginatingElementsHolder originatingElementsHolder) {
        this.tagMap = tagMap;
        this.delegateOriginatingElements = originatingElementsHolder;
        this.kind = builder.getKind();
        this.name = builder.getName();
        this.kdoc = builder.getKdoc().build();
        this.annotationSpecs = UtilKt.toImmutableList(builder.getAnnotationSpecs());
        this.modifiers = UtilKt.toImmutableSet(builder.getModifiers());
        this.typeVariables = UtilKt.toImmutableList(builder.getTypeVariables());
        this.primaryConstructor = builder.getPrimaryConstructor();
        this.superclass = builder.getSuperclass();
        this.superclassConstructorParameters = UtilKt.toImmutableList(builder.getSuperclassConstructorParameters());
        this.isEnum = builder.isEnum$kotlinpoet();
        this.isAnnotation = builder.isAnnotation$kotlinpoet();
        this.isCompanion = builder.isCompanion$kotlinpoet();
        this.isAnonymousClass = builder.isAnonymousClass$kotlinpoet();
        this.isFunctionalInterface = builder.isFunInterface$kotlinpoet();
        this.superinterfaces = UtilKt.toImmutableMap(builder.getSuperinterfaces());
        this.enumConstants = UtilKt.toImmutableMap(builder.getEnumConstants());
        this.propertySpecs = UtilKt.toImmutableList(builder.getPropertySpecs());
        this.initializerBlock = builder.getInitializerBlock().build();
        this.initializerIndex = builder.getInitializerIndex();
        this.funSpecs = UtilKt.toImmutableList(builder.getFunSpecs());
        List<TypeSpec> immutableList = UtilKt.toImmutableList(builder.getTypeSpecs());
        this.typeSpecs = immutableList;
        List<TypeSpec> list = immutableList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeSpec) it.next()).name);
        }
        this.nestedTypesSimpleNames = UtilKt.toImmutableSet(arrayList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    /* synthetic */ TypeSpec(com.squareup.kotlinpoet.TypeSpec.Builder r2, com.squareup.kotlinpoet.TagMap r3, com.squareup.kotlinpoet.OriginatingElementsHolder r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r1 = this;
            r6 = r5 & 2
            if (r6 == 0) goto Lb
            r3 = r2
            com.squareup.kotlinpoet.Taggable$Builder r3 = (com.squareup.kotlinpoet.Taggable.Builder) r3
            com.squareup.kotlinpoet.TagMap r3 = com.squareup.kotlinpoet.TaggableKt.buildTagMap(r3)
        Lb:
            r5 = r5 & 4
            if (r5 == 0) goto L4a
            java.util.List r4 = r2.getOriginatingElements()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.List r5 = r2.getTypeSpecs()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L26:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L3c
            java.lang.Object r0 = r5.next()
            com.squareup.kotlinpoet.TypeSpec r0 = (com.squareup.kotlinpoet.TypeSpec) r0
            java.util.List r0 = r0.getOriginatingElements()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            kotlin.collections.CollectionsKt.addAll(r6, r0)
            goto L26
        L3c:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.List r4 = kotlin.collections.CollectionsKt.plus(r4, r6)
            com.squareup.kotlinpoet.OriginatingElements r4 = com.squareup.kotlinpoet.OriginatingElementsHolderKt.buildOriginatingElements(r4)
            com.squareup.kotlinpoet.OriginatingElementsHolder r4 = (com.squareup.kotlinpoet.OriginatingElementsHolder) r4
        L4a:
            r1.<init>(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.kotlinpoet.TypeSpec.<init>(com.squareup.kotlinpoet.TypeSpec$Builder, com.squareup.kotlinpoet.TagMap, com.squareup.kotlinpoet.OriginatingElementsHolder, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Kind getKind() {
        return this.kind;
    }

    public final String getName() {
        return this.name;
    }

    public final CodeBlock getKdoc() {
        return this.kdoc;
    }

    public final List<AnnotationSpec> getAnnotationSpecs() {
        return this.annotationSpecs;
    }

    public final Set<KModifier> getModifiers() {
        return this.modifiers;
    }

    public final List<TypeVariableName> getTypeVariables() {
        return this.typeVariables;
    }

    public final FunSpec getPrimaryConstructor() {
        return this.primaryConstructor;
    }

    public final TypeName getSuperclass() {
        return this.superclass;
    }

    public final List<CodeBlock> getSuperclassConstructorParameters() {
        return this.superclassConstructorParameters;
    }

    /* renamed from: isEnum, reason: from getter */
    public final boolean getIsEnum() {
        return this.isEnum;
    }

    /* renamed from: isAnnotation, reason: from getter */
    public final boolean getIsAnnotation() {
        return this.isAnnotation;
    }

    /* renamed from: isCompanion, reason: from getter */
    public final boolean getIsCompanion() {
        return this.isCompanion;
    }

    /* renamed from: isAnonymousClass, reason: from getter */
    public final boolean getIsAnonymousClass() {
        return this.isAnonymousClass;
    }

    /* renamed from: isFunctionalInterface, reason: from getter */
    public final boolean getIsFunctionalInterface() {
        return this.isFunctionalInterface;
    }

    public final Map<TypeName, CodeBlock> getSuperinterfaces() {
        return this.superinterfaces;
    }

    public final Map<String, TypeSpec> getEnumConstants() {
        return this.enumConstants;
    }

    public final List<PropertySpec> getPropertySpecs() {
        return this.propertySpecs;
    }

    public final CodeBlock getInitializerBlock() {
        return this.initializerBlock;
    }

    public final int getInitializerIndex() {
        return this.initializerIndex;
    }

    public final List<FunSpec> getFunSpecs() {
        return this.funSpecs;
    }

    public final List<TypeSpec> getTypeSpecs() {
        return this.typeSpecs;
    }

    public final Set<String> getNestedTypesSimpleNames$kotlinpoet() {
        return this.nestedTypesSimpleNames;
    }

    public static /* synthetic */ Builder toBuilder$default(TypeSpec typeSpec, Kind kind, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            kind = typeSpec.kind;
        }
        if ((i & 2) != 0) {
            str = typeSpec.name;
        }
        return typeSpec.toBuilder(kind, str);
    }

    public final Builder toBuilder(Kind kind, String name) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Builder builder = new Builder(kind, name, new KModifier[0]);
        CollectionsKt.addAll(builder.getModifiers(), this.modifiers);
        builder.getKdoc().add(this.kdoc);
        CollectionsKt.addAll(builder.getAnnotationSpecs(), this.annotationSpecs);
        CollectionsKt.addAll(builder.getTypeVariables(), this.typeVariables);
        builder.setSuperclass$kotlinpoet(this.superclass);
        CollectionsKt.addAll(builder.getSuperclassConstructorParameters(), this.superclassConstructorParameters);
        builder.getEnumConstants().putAll(this.enumConstants);
        CollectionsKt.addAll(builder.getPropertySpecs(), this.propertySpecs);
        CollectionsKt.addAll(builder.getFunSpecs(), this.funSpecs);
        CollectionsKt.addAll(builder.getTypeSpecs(), this.typeSpecs);
        builder.getInitializerBlock().add(this.initializerBlock);
        builder.setInitializerIndex(this.initializerIndex);
        builder.getSuperinterfaces().putAll(this.superinterfaces);
        builder.setPrimaryConstructor$kotlinpoet(this.primaryConstructor);
        builder.getTags().putAll(this.tagMap.getTags());
        CollectionsKt.addAll(builder.getOriginatingElements(), getOriginatingElements());
        return builder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void emit$kotlinpoet$default(TypeSpec typeSpec, CodeWriter codeWriter, String str, Set set, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            set = SetsKt.emptySet();
        }
        if ((i & 8) != 0) {
            z = false;
        }
        typeSpec.emit$kotlinpoet(codeWriter, str, set, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0241 A[Catch: all -> 0x05c5, TryCatch #0 {all -> 0x05c5, blocks: (B:8:0x0046, B:10:0x0061, B:11:0x0086, B:16:0x0090, B:17:0x03d2, B:18:0x03ea, B:20:0x03f0, B:22:0x0407, B:24:0x040d, B:27:0x0420, B:29:0x0424, B:31:0x0428, B:32:0x042e, B:34:0x043a, B:36:0x0445, B:38:0x0450, B:39:0x0458, B:40:0x0468, B:42:0x046e, B:44:0x047a, B:45:0x047d, B:50:0x048e, B:52:0x0492, B:53:0x0498, B:56:0x04c7, B:58:0x04d0, B:60:0x04da, B:61:0x0501, B:62:0x0507, B:64:0x050d, B:67:0x0519, B:69:0x051d, B:70:0x0523, B:75:0x053b, B:76:0x0541, B:78:0x0547, B:81:0x0553, B:83:0x0557, B:84:0x055d, B:89:0x0576, B:90:0x057c, B:92:0x0582, B:94:0x058c, B:96:0x0592, B:99:0x05a9, B:101:0x05ba, B:103:0x05be, B:107:0x0099, B:109:0x00a3, B:113:0x00b6, B:115:0x00c0, B:116:0x00ec, B:118:0x00f8, B:119:0x010f, B:121:0x0115, B:123:0x012e, B:124:0x0135, B:126:0x0146, B:127:0x016b, B:129:0x0171, B:133:0x017c, B:135:0x0131, B:136:0x00d6, B:137:0x00e8, B:138:0x0185, B:140:0x0196, B:141:0x01ac, B:143:0x01bd, B:144:0x01c7, B:146:0x01d0, B:149:0x01e2, B:151:0x01f0, B:155:0x0201, B:159:0x0212, B:160:0x021d, B:163:0x022d, B:164:0x0235, B:166:0x0241, B:167:0x0246, B:172:0x0258, B:173:0x026b, B:175:0x0271, B:178:0x0282, B:183:0x0286, B:184:0x029b, B:187:0x02a3, B:189:0x02ad, B:191:0x02b5, B:196:0x02da, B:198:0x0312, B:199:0x02c0, B:200:0x02c4, B:202:0x02ca, B:210:0x02ec, B:212:0x02f6, B:214:0x0307, B:217:0x0318, B:218:0x0335, B:220:0x033b, B:222:0x034f, B:224:0x0374, B:225:0x035f, B:228:0x037d, B:230:0x0390, B:231:0x03b3, B:233:0x03be, B:237:0x03cf, B:238:0x01a6), top: B:6:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x023d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void emit$kotlinpoet(final com.squareup.kotlinpoet.CodeWriter r29, java.lang.String r30, java.util.Set<? extends com.squareup.kotlinpoet.KModifier> r31, boolean r32) {
        /*
            Method dump skipped, instructions count: 1482
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.kotlinpoet.TypeSpec.emit$kotlinpoet(com.squareup.kotlinpoet.CodeWriter, java.lang.String, java.util.Set, boolean):void");
    }

    private static final void emit$possiblyEmitInitializer(Ref.BooleanRef booleanRef, boolean z, Ref.BooleanRef booleanRef2, CodeWriter codeWriter, TypeSpec typeSpec) {
        if (booleanRef.element) {
            return;
        }
        booleanRef.element = true;
        if (z) {
            if (!booleanRef2.element) {
                CodeWriter.emit$default(codeWriter, "\n", false, 2, null);
            }
            CodeWriter.emitCode$default(codeWriter, typeSpec.initializerBlock, false, false, 6, null);
            booleanRef2.element = false;
        }
    }

    private final Map<String, PropertySpec> constructorProperties() {
        IntRange indices;
        ParameterSpec parameter$kotlinpoet;
        if (this.primaryConstructor == null) {
            return MapsKt.emptyMap();
        }
        if (getHasInitializer()) {
            indices = RangesKt.until(0, this.initializerIndex);
        } else {
            indices = CollectionsKt.getIndices(this.propertySpecs);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int first = indices.getFirst();
        int last = indices.getLast();
        if (first <= last) {
            while (true) {
                PropertySpec propertySpec = this.propertySpecs.get(first);
                if (propertySpec.getGetter() == null && propertySpec.getSetter() == null && (parameter$kotlinpoet = this.primaryConstructor.parameter$kotlinpoet(propertySpec.getName())) != null && Intrinsics.areEqual(parameter$kotlinpoet.getType(), propertySpec.getType()) && isPropertyInitializerConstructorParameter(propertySpec, parameter$kotlinpoet)) {
                    linkedHashMap.put(propertySpec.getName(), propertySpec.fromPrimaryConstructorParameter$kotlinpoet(parameter$kotlinpoet));
                }
                if (first == last) {
                    break;
                }
                first++;
            }
        }
        return linkedHashMap;
    }

    private final boolean isPropertyInitializerConstructorParameter(PropertySpec property, ParameterSpec r5) {
        return Intrinsics.areEqual(CodeBlock.INSTANCE.of("%N", r5).toString(), UtilKt.escapeIfNecessary(String.valueOf(property.getInitializer()), false));
    }

    private final CodeBlock kdocWithConstructorParameters() {
        CodeBlock eMPTY$kotlinpoet;
        FunSpec funSpec = this.primaryConstructor;
        if (funSpec == null || funSpec.getParameters().isEmpty()) {
            return UtilKt.ensureEndsWithNewLine(this.kdoc);
        }
        Map<String, PropertySpec> constructorProperties = constructorProperties();
        List<ParameterSpec> parameters = this.primaryConstructor.getParameters();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = parameters.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ParameterSpec parameterSpec = (ParameterSpec) next;
            PropertySpec propertySpec = constructorProperties.get(parameterSpec.getName());
            if (propertySpec == null || (eMPTY$kotlinpoet = propertySpec.getKdoc()) == null) {
                eMPTY$kotlinpoet = CodeBlock.INSTANCE.getEMPTY$kotlinpoet();
            }
            if (parameterSpec.getKdoc().isNotEmpty() && eMPTY$kotlinpoet.isNotEmpty() && !Intrinsics.areEqual(parameterSpec.getKdoc(), eMPTY$kotlinpoet)) {
                arrayList.add(next);
            }
        }
        CodeBlock.Builder builder = UtilKt.ensureEndsWithNewLine(this.kdoc).toBuilder();
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ParameterSpec parameterSpec2 = (ParameterSpec) obj;
            if (i == 0 && this.kdoc.isNotEmpty()) {
                builder.add("\n", new Object[0]);
            }
            builder.add("@param %L %L", parameterSpec2.getName(), UtilKt.ensureEndsWithNewLine(parameterSpec2.getKdoc()));
            i = i2;
        }
        return builder.build();
    }

    private final boolean getHasInitializer() {
        return this.initializerIndex != -1 && this.initializerBlock.isNotEmpty();
    }

    private final boolean getHasNoBody() {
        CodeBlock body;
        if (!this.propertySpecs.isEmpty()) {
            Map<String, PropertySpec> constructorProperties = constructorProperties();
            Iterator<PropertySpec> it = this.propertySpecs.iterator();
            while (it.hasNext()) {
                if (!constructorProperties.containsKey(it.next().getName())) {
                    return false;
                }
            }
        }
        if (this.enumConstants.isEmpty() && this.initializerBlock.isEmpty()) {
            FunSpec funSpec = this.primaryConstructor;
            if (((funSpec == null || (body = funSpec.getBody()) == null) ? true : body.isEmpty()) && this.funSpecs.isEmpty() && this.typeSpecs.isEmpty()) {
                return true;
            }
        }
        return false;
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

    /* compiled from: TypeSpec.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B9\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\tJ#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¢\u0006\u0002\b\u0012J!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¢\u0006\u0002\b\u0014J#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¢\u0006\u0002\b\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rj\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/squareup/kotlinpoet/TypeSpec$Kind;", "", "declarationKeyword", "", "defaultImplicitPropertyModifiers", "", "Lcom/squareup/kotlinpoet/KModifier;", "defaultImplicitFunctionModifiers", "defaultImplicitTypeModifiers", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;)V", "getDeclarationKeyword$kotlinpoet", "()Ljava/lang/String;", "getDefaultImplicitFunctionModifiers$kotlinpoet", "()Ljava/util/Set;", "getDefaultImplicitPropertyModifiers$kotlinpoet", "getDefaultImplicitTypeModifiers$kotlinpoet", "implicitFunctionModifiers", "modifiers", "implicitFunctionModifiers$kotlinpoet", "implicitPropertyModifiers", "implicitPropertyModifiers$kotlinpoet", "implicitTypeModifiers", "implicitTypeModifiers$kotlinpoet", "CLASS", "OBJECT", "INTERFACE", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public enum Kind {
        CLASS("class", SetsKt.setOf(KModifier.PUBLIC), SetsKt.setOf(KModifier.PUBLIC), SetsKt.emptySet()),
        OBJECT("object", SetsKt.setOf(KModifier.PUBLIC), SetsKt.setOf(KModifier.PUBLIC), SetsKt.emptySet()),
        INTERFACE("interface", SetsKt.setOf((Object[]) new KModifier[]{KModifier.PUBLIC, KModifier.ABSTRACT}), SetsKt.setOf((Object[]) new KModifier[]{KModifier.PUBLIC, KModifier.ABSTRACT}), SetsKt.emptySet());

        private final String declarationKeyword;
        private final Set<KModifier> defaultImplicitFunctionModifiers;
        private final Set<KModifier> defaultImplicitPropertyModifiers;
        private final Set<KModifier> defaultImplicitTypeModifiers;

        Kind(String str, Set set, Set set2, Set set3) {
            this.declarationKeyword = str;
            this.defaultImplicitPropertyModifiers = set;
            this.defaultImplicitFunctionModifiers = set2;
            this.defaultImplicitTypeModifiers = set3;
        }

        /* renamed from: getDeclarationKeyword$kotlinpoet, reason: from getter */
        public final String getDeclarationKeyword() {
            return this.declarationKeyword;
        }

        public final Set<KModifier> getDefaultImplicitPropertyModifiers$kotlinpoet() {
            return this.defaultImplicitPropertyModifiers;
        }

        public final Set<KModifier> getDefaultImplicitFunctionModifiers$kotlinpoet() {
            return this.defaultImplicitFunctionModifiers;
        }

        public final Set<KModifier> getDefaultImplicitTypeModifiers$kotlinpoet() {
            return this.defaultImplicitTypeModifiers;
        }

        public final Set<KModifier> implicitPropertyModifiers$kotlinpoet(Set<? extends KModifier> modifiers) {
            Set of;
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            Set<KModifier> set = this.defaultImplicitPropertyModifiers;
            if (modifiers.contains(KModifier.ANNOTATION)) {
                of = SetsKt.emptySet();
            } else if (modifiers.contains(KModifier.EXPECT)) {
                of = SetsKt.setOf(KModifier.EXPECT);
            } else {
                of = modifiers.contains(KModifier.EXTERNAL) ? SetsKt.setOf(KModifier.EXTERNAL) : SetsKt.emptySet();
            }
            return SetsKt.plus((Set) set, (Iterable) of);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Set implicitFunctionModifiers$kotlinpoet$default(Kind kind, Set set, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: implicitFunctionModifiers");
            }
            if ((i & 1) != 0) {
                set = SetsKt.emptySet();
            }
            return kind.implicitFunctionModifiers$kotlinpoet(set);
        }

        public final Set<KModifier> implicitFunctionModifiers$kotlinpoet(Set<? extends KModifier> modifiers) {
            Set of;
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            Set<KModifier> set = this.defaultImplicitFunctionModifiers;
            if (modifiers.contains(KModifier.ANNOTATION)) {
                of = SetsKt.setOf(KModifier.ABSTRACT);
            } else if (modifiers.contains(KModifier.EXPECT)) {
                of = SetsKt.setOf(KModifier.EXPECT);
            } else {
                of = modifiers.contains(KModifier.EXTERNAL) ? SetsKt.setOf(KModifier.EXTERNAL) : SetsKt.emptySet();
            }
            return SetsKt.plus((Set) set, (Iterable) of);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Set implicitTypeModifiers$kotlinpoet$default(Kind kind, Set set, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: implicitTypeModifiers");
            }
            if ((i & 1) != 0) {
                set = SetsKt.emptySet();
            }
            return kind.implicitTypeModifiers$kotlinpoet(set);
        }

        public final Set<KModifier> implicitTypeModifiers$kotlinpoet(Set<? extends KModifier> modifiers) {
            Set of;
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            Set<KModifier> set = this.defaultImplicitTypeModifiers;
            if (modifiers.contains(KModifier.EXPECT)) {
                of = SetsKt.setOf(KModifier.EXPECT);
            } else {
                of = modifiers.contains(KModifier.EXTERNAL) ? SetsKt.setOf(KModifier.EXTERNAL) : SetsKt.emptySet();
            }
            return SetsKt.plus((Set) set, (Iterable) of);
        }
    }

    /* compiled from: TypeSpec.kt */
    @Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B-\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010^\u001a\u00020\u00002\u0006\u0010_\u001a\u00020\rJ\u000e\u0010^\u001a\u00020\u00002\u0006\u0010`\u001a\u00020aJ\u0014\u0010^\u001a\u00020\u00002\n\u0010`\u001a\u0006\u0012\u0002\b\u00030bH\u0007J\u0012\u0010^\u001a\u00020\u00002\n\u0010`\u001a\u0006\u0012\u0002\b\u00030VJ\u0014\u0010c\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0dJ\u001a\u0010e\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010f\u001a\u00020\u0012H\u0007J\u000e\u0010g\u001a\u00020\u00002\u0006\u0010h\u001a\u00020\u0016J\u0014\u0010i\u001a\u00020\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160dJ\u000e\u0010j\u001a\u00020\u00002\u0006\u0010k\u001a\u00020QJ\u000e\u0010l\u001a\u00020\u00002\u0006\u0010k\u001a\u00020QJ'\u0010l\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\u00062\u0012\u0010n\u001a\n\u0012\u0006\b\u0001\u0012\u00020W0\b\"\u00020W¢\u0006\u0002\u0010oJ\u001f\u0010p\u001a\u00020\u00002\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0002\u0010qJ\u0014\u0010p\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0dJ\u0014\u0010r\u001a\u00020\u00002\f\u0010G\u001a\b\u0012\u0004\u0012\u00020H0dJ\u000e\u0010s\u001a\u00020\u00002\u0006\u0010t\u001a\u00020HJ/\u0010s\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010u\u001a\u00020K2\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0002\u0010vJ$\u0010s\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010u\u001a\u00020K2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0dJ1\u0010s\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010u\u001a\u00020w2\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0007¢\u0006\u0002\u0010xJ&\u0010s\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010u\u001a\u00020w2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0dH\u0007J3\u0010s\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010u\u001a\u0006\u0012\u0002\b\u00030V2\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0002\u0010yJ(\u0010s\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010u\u001a\u0006\u0012\u0002\b\u00030V2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0dJ\u000e\u0010z\u001a\u00020\u00002\u0006\u0010{\u001a\u00020QJ'\u0010z\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\u00062\u0012\u0010n\u001a\n\u0012\u0006\b\u0001\u0012\u00020W0\b\"\u00020W¢\u0006\u0002\u0010oJ\u0018\u0010|\u001a\u00020\u00002\u0006\u0010}\u001a\u00020K2\b\b\u0002\u0010~\u001a\u00020QJ\u0016\u0010|\u001a\u00020\u00002\u0006\u0010}\u001a\u00020K2\u0006\u0010\u007f\u001a\u00020\u0006J\u001a\u0010|\u001a\u00020\u00002\u0006\u0010}\u001a\u00020w2\b\b\u0002\u0010~\u001a\u00020QH\u0007J\u001c\u0010|\u001a\u00020\u00002\n\u0010}\u001a\u0006\u0012\u0002\b\u00030V2\b\b\u0002\u0010~\u001a\u00020QJ\u001b\u0010|\u001a\u00020\u00002\n\u0010}\u001a\u0006\u0012\u0002\b\u00030V2\u0007\u0010\u0080\u0001\u001a\u00020\u0006J\u0015\u0010\u0081\u0001\u001a\u00020\u00002\f\u0010S\u001a\b\u0012\u0004\u0012\u00020K0dJ\u000f\u0010\u0082\u0001\u001a\u00020\u00002\u0006\u0010f\u001a\u00020\u0012J\u0010\u0010\u0083\u0001\u001a\u00020\u00002\u0007\u0010\u0084\u0001\u001a\u00020\\J\u0015\u0010\u0085\u0001\u001a\u00020\u00002\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0dJ\u0015\u0010\u0086\u0001\u001a\u00020\u00002\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00120dJ\u0007\u0010\u0087\u0001\u001a\u00020\u0012J\n\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0002J\n\u0010\u008a\u0001\u001a\u00030\u0089\u0001H\u0002J\u0010\u0010B\u001a\u00020\u00002\b\u0010B\u001a\u0004\u0018\u00010\u0016J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010J\u001a\u00020KJ\u0010\u0010J\u001a\u00020\u00002\u0006\u0010J\u001a\u00020wH\u0007J\u0012\u0010J\u001a\u00020\u00002\n\u0010J\u001a\u0006\u0012\u0002\b\u00030VR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\u0019X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%R\u0014\u0010(\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b)\u0010%R\u0014\u0010*\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010%R\u0014\u0010,\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010%R\u0014\u0010.\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b/\u0010%R\u0014\u00100\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b1\u0010%R\u0014\u00102\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b3\u0010%R\u0014\u00104\u001a\u00020\u0019X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0:¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u000fR\u001c\u0010B\u001a\u0004\u0018\u00010\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0017\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\f¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u000fR\u001a\u0010J\u001a\u00020KX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\f¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u000fR\u001f\u0010S\u001a\u0010\u0012\u0004\u0012\u00020K\u0012\u0006\u0012\u0004\u0018\u00010Q0\u0011¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\u0014R$\u0010U\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030V\u0012\u0004\u0012\u00020W0\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\u0014R\u0017\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00120\f¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010\u000fR\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0\f¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u000f¨\u0006\u008b\u0001"}, d2 = {"Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "Lcom/squareup/kotlinpoet/Taggable$Builder;", "Lcom/squareup/kotlinpoet/OriginatingElementsHolder$Builder;", "kind", "Lcom/squareup/kotlinpoet/TypeSpec$Kind;", "name", "", "modifiers", "", "Lcom/squareup/kotlinpoet/KModifier;", "(Lcom/squareup/kotlinpoet/TypeSpec$Kind;Ljava/lang/String;[Lcom/squareup/kotlinpoet/KModifier;)V", "annotationSpecs", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "getAnnotationSpecs", "()Ljava/util/List;", "enumConstants", "", "Lcom/squareup/kotlinpoet/TypeSpec;", "getEnumConstants", "()Ljava/util/Map;", "funSpecs", "Lcom/squareup/kotlinpoet/FunSpec;", "getFunSpecs", "initializerBlock", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "getInitializerBlock$kotlinpoet", "()Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "initializerIndex", "", "getInitializerIndex", "()I", "setInitializerIndex", "(I)V", "isAnnotation", "", "isAnnotation$kotlinpoet", "()Z", "isAnonymousClass", "isAnonymousClass$kotlinpoet", "isCompanion", "isCompanion$kotlinpoet", "isEnum", "isEnum$kotlinpoet", "isExternal", "isExternal$kotlinpoet", "isFunInterface", "isFunInterface$kotlinpoet", "isInlineOrValClass", "isInlineOrValClass$kotlinpoet", "isSimpleClass", "isSimpleClass$kotlinpoet", "kdoc", "getKdoc$kotlinpoet", "getKind$kotlinpoet", "()Lcom/squareup/kotlinpoet/TypeSpec$Kind;", "setKind$kotlinpoet", "(Lcom/squareup/kotlinpoet/TypeSpec$Kind;)V", "", "getModifiers", "()Ljava/util/Set;", "getName$kotlinpoet", "()Ljava/lang/String;", "originatingElements", "Ljavax/lang/model/element/Element;", "getOriginatingElements", "primaryConstructor", "getPrimaryConstructor$kotlinpoet", "()Lcom/squareup/kotlinpoet/FunSpec;", "setPrimaryConstructor$kotlinpoet", "(Lcom/squareup/kotlinpoet/FunSpec;)V", "propertySpecs", "Lcom/squareup/kotlinpoet/PropertySpec;", "getPropertySpecs", "superclass", "Lcom/squareup/kotlinpoet/TypeName;", "getSuperclass$kotlinpoet", "()Lcom/squareup/kotlinpoet/TypeName;", "setSuperclass$kotlinpoet", "(Lcom/squareup/kotlinpoet/TypeName;)V", "superclassConstructorParameters", "Lcom/squareup/kotlinpoet/CodeBlock;", "getSuperclassConstructorParameters", "superinterfaces", "getSuperinterfaces", "tags", "Lkotlin/reflect/KClass;", "", "getTags", "typeSpecs", "getTypeSpecs", "typeVariables", "Lcom/squareup/kotlinpoet/TypeVariableName;", "getTypeVariables", "addAnnotation", "annotationSpec", "annotation", "Lcom/squareup/kotlinpoet/ClassName;", "Ljava/lang/Class;", "addAnnotations", "", "addEnumConstant", "typeSpec", "addFunction", "funSpec", "addFunctions", "addInitializerBlock", "block", "addKdoc", "format", "args", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "addModifiers", "([Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "addProperties", "addProperty", "propertySpec", "type", "(Ljava/lang/String;Lcom/squareup/kotlinpoet/TypeName;[Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;[Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "addSuperclassConstructorParameter", "codeBlock", "addSuperinterface", "superinterface", "delegate", "constructorParameter", "constructorParameterName", "addSuperinterfaces", "addType", "addTypeVariable", "typeVariable", "addTypeVariables", "addTypes", "build", "checkCanHaveInitializerBlocks", "", "checkCanHaveSuperclass", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder implements Taggable.Builder<Builder>, OriginatingElementsHolder.Builder<Builder> {
        private final List<AnnotationSpec> annotationSpecs;
        private final Map<String, TypeSpec> enumConstants;
        private final List<FunSpec> funSpecs;
        private final CodeBlock.Builder initializerBlock;
        private int initializerIndex;
        private final CodeBlock.Builder kdoc;
        private Kind kind;
        private final Set<KModifier> modifiers;
        private final String name;
        private final List<Element> originatingElements;
        private FunSpec primaryConstructor;
        private final List<PropertySpec> propertySpecs;
        private TypeName superclass;
        private final List<CodeBlock> superclassConstructorParameters;
        private final Map<TypeName, CodeBlock> superinterfaces;
        private final Map<KClass<?>, Object> tags;
        private final List<TypeSpec> typeSpecs;
        private final List<TypeVariableName> typeVariables;

        public final Builder addEnumConstant(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return addEnumConstant$default(this, name, null, 2, null);
        }

        public Builder(Kind kind, String str, KModifier... modifiers) {
            Intrinsics.checkNotNullParameter(kind, "kind");
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            this.kind = kind;
            this.name = str;
            this.kdoc = CodeBlock.INSTANCE.builder();
            this.superclass = TypeNames.ANY;
            this.initializerBlock = CodeBlock.INSTANCE.builder();
            this.initializerIndex = -1;
            this.tags = new LinkedHashMap();
            this.originatingElements = new ArrayList();
            this.modifiers = SetsKt.mutableSetOf(Arrays.copyOf(modifiers, modifiers.length));
            this.superinterfaces = new LinkedHashMap();
            this.enumConstants = new LinkedHashMap();
            this.annotationSpecs = new ArrayList();
            this.typeVariables = new ArrayList();
            this.superclassConstructorParameters = new ArrayList();
            this.propertySpecs = new ArrayList();
            this.funSpecs = new ArrayList();
            this.typeSpecs = new ArrayList();
        }

        @Override // com.squareup.kotlinpoet.OriginatingElementsHolder.Builder
        public Builder addOriginatingElement(Element element) {
            return (Builder) OriginatingElementsHolder.Builder.DefaultImpls.addOriginatingElement(this, element);
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
        /* renamed from: tag */
        public Builder tag2(Class<?> cls, Object obj) {
            return (Builder) Taggable.Builder.DefaultImpls.tag(this, cls, obj);
        }

        @Override // com.squareup.kotlinpoet.Taggable.Builder
        /* renamed from: tag */
        public Builder tag2(KClass<?> kClass, Object obj) {
            return (Builder) Taggable.Builder.DefaultImpls.tag(this, kClass, obj);
        }

        /* renamed from: getKind$kotlinpoet, reason: from getter */
        public final Kind getKind() {
            return this.kind;
        }

        public final void setKind$kotlinpoet(Kind kind) {
            Intrinsics.checkNotNullParameter(kind, "<set-?>");
            this.kind = kind;
        }

        /* renamed from: getName$kotlinpoet, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: getKdoc$kotlinpoet, reason: from getter */
        public final CodeBlock.Builder getKdoc() {
            return this.kdoc;
        }

        /* renamed from: getPrimaryConstructor$kotlinpoet, reason: from getter */
        public final FunSpec getPrimaryConstructor() {
            return this.primaryConstructor;
        }

        public final void setPrimaryConstructor$kotlinpoet(FunSpec funSpec) {
            this.primaryConstructor = funSpec;
        }

        /* renamed from: getSuperclass$kotlinpoet, reason: from getter */
        public final TypeName getSuperclass() {
            return this.superclass;
        }

        public final void setSuperclass$kotlinpoet(TypeName typeName) {
            Intrinsics.checkNotNullParameter(typeName, "<set-?>");
            this.superclass = typeName;
        }

        /* renamed from: getInitializerBlock$kotlinpoet, reason: from getter */
        public final CodeBlock.Builder getInitializerBlock() {
            return this.initializerBlock;
        }

        public final int getInitializerIndex() {
            return this.initializerIndex;
        }

        public final void setInitializerIndex(int i) {
            this.initializerIndex = i;
        }

        public final boolean isAnonymousClass$kotlinpoet() {
            return this.name == null && this.kind == Kind.CLASS;
        }

        public final boolean isExternal$kotlinpoet() {
            return this.modifiers.contains(KModifier.EXTERNAL);
        }

        public final boolean isEnum$kotlinpoet() {
            return this.kind == Kind.CLASS && this.modifiers.contains(KModifier.ENUM);
        }

        public final boolean isAnnotation$kotlinpoet() {
            return this.kind == Kind.CLASS && this.modifiers.contains(KModifier.ANNOTATION);
        }

        public final boolean isCompanion$kotlinpoet() {
            return this.kind == Kind.OBJECT && this.modifiers.contains(KModifier.COMPANION);
        }

        public final boolean isInlineOrValClass$kotlinpoet() {
            return this.kind == Kind.CLASS && (this.modifiers.contains(KModifier.INLINE) || this.modifiers.contains(KModifier.VALUE));
        }

        public final boolean isSimpleClass$kotlinpoet() {
            return (this.kind != Kind.CLASS || isEnum$kotlinpoet() || isAnnotation$kotlinpoet()) ? false : true;
        }

        public final boolean isFunInterface$kotlinpoet() {
            return this.kind == Kind.INTERFACE && this.modifiers.contains(KModifier.FUN);
        }

        @Override // com.squareup.kotlinpoet.Taggable.Builder
        public Map<KClass<?>, Object> getTags() {
            return this.tags;
        }

        @Override // com.squareup.kotlinpoet.OriginatingElementsHolder.Builder
        public List<Element> getOriginatingElements() {
            return this.originatingElements;
        }

        public final Set<KModifier> getModifiers() {
            return this.modifiers;
        }

        public final Map<TypeName, CodeBlock> getSuperinterfaces() {
            return this.superinterfaces;
        }

        public final Map<String, TypeSpec> getEnumConstants() {
            return this.enumConstants;
        }

        public final List<AnnotationSpec> getAnnotationSpecs() {
            return this.annotationSpecs;
        }

        public final List<TypeVariableName> getTypeVariables() {
            return this.typeVariables;
        }

        public final List<CodeBlock> getSuperclassConstructorParameters() {
            return this.superclassConstructorParameters;
        }

        public final List<PropertySpec> getPropertySpecs() {
            return this.propertySpecs;
        }

        public final List<FunSpec> getFunSpecs() {
            return this.funSpecs;
        }

        public final List<TypeSpec> getTypeSpecs() {
            return this.typeSpecs;
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
            CollectionsKt.addAll(this.annotationSpecs, annotationSpecs);
            return this;
        }

        public final Builder addAnnotation(AnnotationSpec annotationSpec) {
            Intrinsics.checkNotNullParameter(annotationSpec, "annotationSpec");
            this.annotationSpecs.add(annotationSpec);
            return this;
        }

        public final Builder addAnnotation(ClassName annotation) {
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            return addAnnotation(AnnotationSpec.INSTANCE.builder(annotation).build());
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
            if (!(!isAnonymousClass$kotlinpoet())) {
                throw new IllegalStateException("forbidden on anonymous types.".toString());
            }
            CollectionsKt.addAll(this.modifiers, modifiers);
            return this;
        }

        public final Builder addModifiers(Iterable<? extends KModifier> modifiers) {
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            if (!(!isAnonymousClass$kotlinpoet())) {
                throw new IllegalStateException("forbidden on anonymous types.".toString());
            }
            CollectionsKt.addAll(this.modifiers, modifiers);
            return this;
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

        public final Builder primaryConstructor(FunSpec primaryConstructor) {
            if (!(this.kind == Kind.CLASS)) {
                throw new IllegalStateException((this.kind + " can't have a primary constructor").toString());
            }
            if (primaryConstructor != null) {
                if (!primaryConstructor.isConstructor()) {
                    throw new IllegalArgumentException(("expected a constructor but was " + primaryConstructor.getName()).toString());
                }
                if (isInlineOrValClass$kotlinpoet()) {
                    if (!(primaryConstructor.getParameters().size() == 1)) {
                        throw new IllegalStateException("value/inline classes must have 1 parameter in constructor".toString());
                    }
                }
            }
            this.primaryConstructor = primaryConstructor;
            return this;
        }

        public final Builder superclass(TypeName superclass) {
            Intrinsics.checkNotNullParameter(superclass, "superclass");
            checkCanHaveSuperclass();
            if (!(this.superclass == TypeNames.ANY)) {
                throw new IllegalStateException(("superclass already set to " + this.superclass).toString());
            }
            this.superclass = superclass;
            return this;
        }

        private final void checkCanHaveSuperclass() {
            if (!(isSimpleClass$kotlinpoet() || this.kind == Kind.OBJECT)) {
                throw new IllegalStateException(("only classes can have super classes, not " + this.kind).toString());
            }
            if (!(!isInlineOrValClass$kotlinpoet())) {
                throw new IllegalStateException("value/inline classes cannot have super classes".toString());
            }
        }

        private final void checkCanHaveInitializerBlocks() {
            if (!(isSimpleClass$kotlinpoet() || isEnum$kotlinpoet() || this.kind == Kind.OBJECT)) {
                throw new IllegalStateException((this.kind + " can't have initializer blocks").toString());
            }
            if (!this.modifiers.contains(KModifier.EXPECT)) {
                return;
            }
            throw new IllegalStateException(("expect " + this.kind + " can't have initializer blocks").toString());
        }

        public final Builder superclass(Type superclass) {
            Intrinsics.checkNotNullParameter(superclass, "superclass");
            return superclass(TypeNames.get(superclass));
        }

        public final Builder superclass(KClass<?> superclass) {
            Intrinsics.checkNotNullParameter(superclass, "superclass");
            return superclass(TypeNames.get(superclass));
        }

        public final Builder addSuperclassConstructorParameter(String format, Object... args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            addSuperclassConstructorParameter(CodeBlock.INSTANCE.of(format, Arrays.copyOf(args, args.length)));
            return this;
        }

        public final Builder addSuperclassConstructorParameter(CodeBlock codeBlock) {
            Intrinsics.checkNotNullParameter(codeBlock, "codeBlock");
            checkCanHaveSuperclass();
            this.superclassConstructorParameters.add(codeBlock);
            return this;
        }

        public final Builder addSuperinterfaces(Iterable<? extends TypeName> superinterfaces) {
            Intrinsics.checkNotNullParameter(superinterfaces, "superinterfaces");
            Map<TypeName, CodeBlock> map = this.superinterfaces;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(superinterfaces, 10));
            Iterator<? extends TypeName> it = superinterfaces.iterator();
            while (it.hasNext()) {
                arrayList.add(TuplesKt.to(it.next(), null));
            }
            MapsKt.putAll(map, arrayList);
            return this;
        }

        public static /* synthetic */ Builder addSuperinterface$default(Builder builder, TypeName typeName, CodeBlock codeBlock, int i, Object obj) {
            if ((i & 2) != 0) {
                codeBlock = CodeBlock.INSTANCE.getEMPTY$kotlinpoet();
            }
            return builder.addSuperinterface(typeName, codeBlock);
        }

        public final Builder addSuperinterface(TypeName superinterface, CodeBlock delegate) {
            Intrinsics.checkNotNullParameter(superinterface, "superinterface");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            if (delegate.isEmpty()) {
                this.superinterfaces.put(superinterface, null);
            } else {
                if (!(isSimpleClass$kotlinpoet() || this.kind == Kind.OBJECT)) {
                    throw new IllegalArgumentException(("delegation only allowed for classes and objects (found " + this.kind + " '" + this.name + "')").toString());
                }
                if (!(!superinterface.getIsNullable())) {
                    throw new IllegalArgumentException(("expected non-nullable type but was '" + TypeName.copy$default(superinterface, false, null, 2, null) + '\'').toString());
                }
                if (!(this.superinterfaces.get(superinterface) == null)) {
                    throw new IllegalArgumentException(("'" + this.name + "' can not delegate to " + superinterface + " by " + delegate + " with existing declaration by " + this.superinterfaces.get(superinterface)).toString());
                }
                this.superinterfaces.put(superinterface, delegate);
            }
            return this;
        }

        public static /* synthetic */ Builder addSuperinterface$default(Builder builder, Type type, CodeBlock codeBlock, int i, Object obj) {
            if ((i & 2) != 0) {
                codeBlock = CodeBlock.INSTANCE.getEMPTY$kotlinpoet();
            }
            return builder.addSuperinterface(type, codeBlock);
        }

        public final Builder addSuperinterface(Type superinterface, CodeBlock delegate) {
            Intrinsics.checkNotNullParameter(superinterface, "superinterface");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            return addSuperinterface(TypeNames.get(superinterface), delegate);
        }

        public static /* synthetic */ Builder addSuperinterface$default(Builder builder, KClass kClass, CodeBlock codeBlock, int i, Object obj) {
            if ((i & 2) != 0) {
                codeBlock = CodeBlock.INSTANCE.getEMPTY$kotlinpoet();
            }
            return builder.addSuperinterface((KClass<?>) kClass, codeBlock);
        }

        public final Builder addSuperinterface(KClass<?> superinterface, CodeBlock delegate) {
            Intrinsics.checkNotNullParameter(superinterface, "superinterface");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            return addSuperinterface(TypeNames.get(superinterface), delegate);
        }

        public final Builder addSuperinterface(KClass<?> superinterface, String constructorParameterName) {
            Intrinsics.checkNotNullParameter(superinterface, "superinterface");
            Intrinsics.checkNotNullParameter(constructorParameterName, "constructorParameterName");
            return addSuperinterface(TypeNames.get(superinterface), constructorParameterName);
        }

        public final Builder addSuperinterface(TypeName superinterface, String constructorParameter) {
            Intrinsics.checkNotNullParameter(superinterface, "superinterface");
            Intrinsics.checkNotNullParameter(constructorParameter, "constructorParameter");
            FunSpec funSpec = this.primaryConstructor;
            if (funSpec == null) {
                throw new IllegalArgumentException("delegating to constructor parameter requires not-null constructor".toString());
            }
            if ((funSpec != null ? funSpec.parameter$kotlinpoet(constructorParameter) : null) == null) {
                throw new IllegalArgumentException(("no such constructor parameter '" + constructorParameter + "' to delegate to for type '" + this.name + '\'').toString());
            }
            addSuperinterface(superinterface, CodeBlock.INSTANCE.of(constructorParameter, new Object[0]));
            return this;
        }

        public static /* synthetic */ Builder addEnumConstant$default(Builder builder, String str, TypeSpec typeSpec, int i, Object obj) {
            if ((i & 2) != 0) {
                typeSpec = TypeSpec.INSTANCE.anonymousClassBuilder().build();
            }
            return builder.addEnumConstant(str, typeSpec);
        }

        public final Builder addEnumConstant(String name, TypeSpec typeSpec) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(typeSpec, "typeSpec");
            if (!((Intrinsics.areEqual(name, "name") || Intrinsics.areEqual(name, "ordinal")) ? false : true)) {
                throw new IllegalArgumentException(("constant with name \"" + name + "\" conflicts with a supertype member with the same name").toString());
            }
            this.enumConstants.put(name, typeSpec);
            return this;
        }

        public final Builder addProperties(Iterable<PropertySpec> propertySpecs) {
            Intrinsics.checkNotNullParameter(propertySpecs, "propertySpecs");
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(propertySpecs, 10));
            Iterator<PropertySpec> it = propertySpecs.iterator();
            while (it.hasNext()) {
                arrayList.add(addProperty(it.next()));
            }
            return this;
        }

        public final Builder addProperty(PropertySpec propertySpec) {
            Intrinsics.checkNotNullParameter(propertySpec, "propertySpec");
            if (this.modifiers.contains(KModifier.EXPECT)) {
                if (!(propertySpec.getInitializer() == null)) {
                    throw new IllegalArgumentException("properties in expect classes can't have initializers".toString());
                }
                if (!(propertySpec.getGetter() == null && propertySpec.getSetter() == null)) {
                    throw new IllegalArgumentException("properties in expect classes can't have getters and setters".toString());
                }
            }
            if (isEnum$kotlinpoet()) {
                if (!((Intrinsics.areEqual(propertySpec.getName(), "name") || Intrinsics.areEqual(propertySpec.getName(), "ordinal")) ? false : true)) {
                    throw new IllegalArgumentException((propertySpec.getName() + " is a final supertype member and can't be redeclared or overridden").toString());
                }
            }
            this.propertySpecs.add(propertySpec);
            return this;
        }

        public final Builder addProperty(String name, TypeName type, KModifier... modifiers) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            return addProperty(PropertySpec.INSTANCE.builder(name, type, (KModifier[]) Arrays.copyOf(modifiers, modifiers.length)).build());
        }

        public final Builder addProperty(String name, Type type, KModifier... modifiers) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            return addProperty(name, TypeNames.get(type), (KModifier[]) Arrays.copyOf(modifiers, modifiers.length));
        }

        public final Builder addProperty(String name, KClass<?> type, KModifier... modifiers) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            return addProperty(name, TypeNames.get(type), (KModifier[]) Arrays.copyOf(modifiers, modifiers.length));
        }

        public final Builder addProperty(String name, TypeName type, Iterable<? extends KModifier> modifiers) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            return addProperty(PropertySpec.INSTANCE.builder(name, type, modifiers).build());
        }

        public final Builder addProperty(String name, Type type, Iterable<? extends KModifier> modifiers) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            return addProperty(name, TypeNames.get(type), modifiers);
        }

        public final Builder addProperty(String name, KClass<?> type, Iterable<? extends KModifier> modifiers) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(modifiers, "modifiers");
            return addProperty(name, TypeNames.get(type), modifiers);
        }

        public final Builder addInitializerBlock(CodeBlock block) {
            Intrinsics.checkNotNullParameter(block, "block");
            checkCanHaveInitializerBlocks();
            this.initializerIndex = this.propertySpecs.size();
            this.initializerBlock.add("init {\n", new Object[0]).indent().add(block).unindent().add("}\n", new Object[0]);
            return this;
        }

        public final Builder addFunctions(Iterable<FunSpec> funSpecs) {
            Intrinsics.checkNotNullParameter(funSpecs, "funSpecs");
            Iterator<FunSpec> it = funSpecs.iterator();
            while (it.hasNext()) {
                addFunction(it.next());
            }
            return this;
        }

        public final Builder addFunction(FunSpec funSpec) {
            Intrinsics.checkNotNullParameter(funSpec, "funSpec");
            this.funSpecs.add(funSpec);
            return this;
        }

        public final Builder addTypes(Iterable<TypeSpec> typeSpecs) {
            Intrinsics.checkNotNullParameter(typeSpecs, "typeSpecs");
            CollectionsKt.addAll(this.typeSpecs, typeSpecs);
            return this;
        }

        public final Builder addType(TypeSpec typeSpec) {
            Intrinsics.checkNotNullParameter(typeSpec, "typeSpec");
            this.typeSpecs.add(typeSpec);
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:219:0x03d2  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x008e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.squareup.kotlinpoet.TypeSpec build() {
            /*
                Method dump skipped, instructions count: 988
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.kotlinpoet.TypeSpec.Builder.build():com.squareup.kotlinpoet.TypeSpec");
        }
    }

    /* compiled from: TypeSpec.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0014\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\u0012"}, d2 = {"Lcom/squareup/kotlinpoet/TypeSpec$Companion;", "", "()V", "annotationBuilder", "Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "className", "Lcom/squareup/kotlinpoet/ClassName;", "name", "", "anonymousClassBuilder", "classBuilder", "companionObjectBuilder", "enumBuilder", "expectClassBuilder", "funInterfaceBuilder", "interfaceBuilder", "objectBuilder", "valueClassBuilder", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Builder companionObjectBuilder() {
            return companionObjectBuilder$default(this, null, 1, null);
        }

        private Companion() {
        }

        @JvmStatic
        public final Builder classBuilder(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Builder(Kind.CLASS, name, new KModifier[0]);
        }

        @JvmStatic
        public final Builder classBuilder(ClassName className) {
            Intrinsics.checkNotNullParameter(className, "className");
            return classBuilder(className.getSimpleName());
        }

        @JvmStatic
        public final Builder expectClassBuilder(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Builder(Kind.CLASS, name, KModifier.EXPECT);
        }

        @JvmStatic
        public final Builder expectClassBuilder(ClassName className) {
            Intrinsics.checkNotNullParameter(className, "className");
            return expectClassBuilder(className.getSimpleName());
        }

        @JvmStatic
        public final Builder valueClassBuilder(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Builder(Kind.CLASS, name, KModifier.VALUE);
        }

        @JvmStatic
        public final Builder objectBuilder(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Builder(Kind.OBJECT, name, new KModifier[0]);
        }

        @JvmStatic
        public final Builder objectBuilder(ClassName className) {
            Intrinsics.checkNotNullParameter(className, "className");
            return objectBuilder(className.getSimpleName());
        }

        public static /* synthetic */ Builder companionObjectBuilder$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.companionObjectBuilder(str);
        }

        @JvmStatic
        public final Builder companionObjectBuilder(String name) {
            return new Builder(Kind.OBJECT, name, KModifier.COMPANION);
        }

        @JvmStatic
        public final Builder interfaceBuilder(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Builder(Kind.INTERFACE, name, new KModifier[0]);
        }

        @JvmStatic
        public final Builder interfaceBuilder(ClassName className) {
            Intrinsics.checkNotNullParameter(className, "className");
            return interfaceBuilder(className.getSimpleName());
        }

        @JvmStatic
        public final Builder funInterfaceBuilder(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Builder(Kind.INTERFACE, name, KModifier.FUN);
        }

        @JvmStatic
        public final Builder funInterfaceBuilder(ClassName className) {
            Intrinsics.checkNotNullParameter(className, "className");
            return funInterfaceBuilder(className.getSimpleName());
        }

        @JvmStatic
        public final Builder enumBuilder(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Builder(Kind.CLASS, name, KModifier.ENUM);
        }

        @JvmStatic
        public final Builder enumBuilder(ClassName className) {
            Intrinsics.checkNotNullParameter(className, "className");
            return enumBuilder(className.getSimpleName());
        }

        @JvmStatic
        public final Builder anonymousClassBuilder() {
            return new Builder(Kind.CLASS, null, new KModifier[0]);
        }

        @JvmStatic
        public final Builder annotationBuilder(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Builder(Kind.CLASS, name, KModifier.ANNOTATION);
        }

        @JvmStatic
        public final Builder annotationBuilder(ClassName className) {
            Intrinsics.checkNotNullParameter(className, "className");
            return annotationBuilder(className.getSimpleName());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        CodeWriter codeWriter = new CodeWriter(sb, null, null, null, null, Integer.MAX_VALUE, 30, null);
        try {
            emit$kotlinpoet$default(this, codeWriter, null, null, false, 12, null);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(codeWriter, null);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
            return sb2;
        } finally {
        }
    }
}
