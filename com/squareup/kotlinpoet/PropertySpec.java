package com.squareup.kotlinpoet;

import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.squareup.kotlinpoet.CodeBlock;
import com.squareup.kotlinpoet.KModifier;
import com.squareup.kotlinpoet.OriginatingElementsHolder;
import com.squareup.kotlinpoet.Taggable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.Element;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: PropertySpec.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Y2\u00020\u00012\u00020\u0002:\u0002XYB#\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0002\u0010\bJK\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020#0\"2\b\b\u0002\u0010D\u001a\u00020\u00142\b\b\u0002\u0010E\u001a\u00020\u00142\b\b\u0002\u0010F\u001a\u00020\u00142\b\b\u0002\u0010G\u001a\u00020\u0014H\u0000¢\u0006\u0002\bHJ\u0013\u0010I\u001a\u00020\u00142\b\u0010J\u001a\u0004\u0018\u000107H\u0096\u0002J\u0015\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020MH\u0000¢\u0006\u0002\bNJ\b\u0010O\u001a\u00020PH\u0016J(\u0010Q\u001a\u0004\u0018\u0001HR\"\b\b\u0000\u0010R*\u0002072\f\u0010:\u001a\b\u0012\u0004\u0012\u0002HR0SH\u0096\u0001¢\u0006\u0002\u0010TJ(\u0010Q\u001a\u0004\u0018\u0001HR\"\b\b\u0000\u0010R*\u0002072\f\u0010:\u001a\b\u0012\u0004\u0012\u0002HR06H\u0096\u0001¢\u0006\u0002\u0010UJ\u001c\u0010V\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010:\u001a\u00020\u000fH\u0007J\b\u0010W\u001a\u00020)H\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\rR\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0016R\u0011\u0010(\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0018\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\nX\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010\rR\u0013\u0010/\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u00102\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R$\u00104\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u000306\u0012\u0004\u0012\u000207058VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b8\u00109R\u0011\u0010:\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b;\u00101R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\n¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\r¨\u0006Z"}, d2 = {"Lcom/squareup/kotlinpoet/PropertySpec;", "Lcom/squareup/kotlinpoet/Taggable;", "Lcom/squareup/kotlinpoet/OriginatingElementsHolder;", "builder", "Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "tagMap", "Lcom/squareup/kotlinpoet/TagMap;", "delegateOriginatingElementsHolder", "(Lcom/squareup/kotlinpoet/PropertySpec$Builder;Lcom/squareup/kotlinpoet/TagMap;Lcom/squareup/kotlinpoet/OriginatingElementsHolder;)V", "annotations", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "getAnnotations", "()Ljava/util/List;", "contextReceiverTypes", "Lcom/squareup/kotlinpoet/TypeName;", "getContextReceiverTypes$annotations", "()V", "getContextReceiverTypes", "delegated", "", "getDelegated", "()Z", "getter", "Lcom/squareup/kotlinpoet/FunSpec;", "getGetter", "()Lcom/squareup/kotlinpoet/FunSpec;", "initializer", "Lcom/squareup/kotlinpoet/CodeBlock;", "getInitializer", "()Lcom/squareup/kotlinpoet/CodeBlock;", "kdoc", "getKdoc", "modifiers", "", "Lcom/squareup/kotlinpoet/KModifier;", "getModifiers", "()Ljava/util/Set;", "mutable", "getMutable", "name", "", "getName", "()Ljava/lang/String;", "originatingElements", "Ljavax/lang/model/element/Element;", "getOriginatingElements", "receiverType", "getReceiverType", "()Lcom/squareup/kotlinpoet/TypeName;", "setter", "getSetter", "tags", "", "Lkotlin/reflect/KClass;", "", "getTags", "()Ljava/util/Map;", "type", "getType", "typeVariables", "Lcom/squareup/kotlinpoet/TypeVariableName;", "getTypeVariables", "emit", "", "codeWriter", "Lcom/squareup/kotlinpoet/CodeWriter;", "implicitModifiers", "withInitializer", "emitKdoc", "inline", "inlineAnnotations", "emit$kotlinpoet", "equals", "other", "fromPrimaryConstructorParameter", MediationConfiguration.CUSTOM_EVENT_SERVER_PARAMETER_FIELD, "Lcom/squareup/kotlinpoet/ParameterSpec;", "fromPrimaryConstructorParameter$kotlinpoet", "hashCode", "", "tag", "T", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toBuilder", "toString", "Builder", "Companion", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PropertySpec implements Taggable, OriginatingElementsHolder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<AnnotationSpec> annotations;
    private final List<TypeName> contextReceiverTypes;
    private final OriginatingElementsHolder delegateOriginatingElementsHolder;
    private final boolean delegated;
    private final FunSpec getter;
    private final CodeBlock initializer;
    private final CodeBlock kdoc;
    private final Set<KModifier> modifiers;
    private final boolean mutable;
    private final String name;
    private final TypeName receiverType;
    private final FunSpec setter;
    private final TagMap tagMap;
    private final TypeName type;
    private final List<TypeVariableName> typeVariables;

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

    public static /* synthetic */ void getContextReceiverTypes$annotations() {
    }

    @Override // com.squareup.kotlinpoet.OriginatingElementsHolder
    public List<Element> getOriginatingElements() {
        return this.delegateOriginatingElementsHolder.getOriginatingElements();
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

    private PropertySpec(Builder builder, TagMap tagMap, OriginatingElementsHolder originatingElementsHolder) {
        boolean z;
        FunSpec funSpec;
        FunSpec funSpec2;
        this.tagMap = tagMap;
        this.delegateOriginatingElementsHolder = originatingElementsHolder;
        this.mutable = builder.getMutable();
        this.name = builder.getName();
        this.type = builder.getType();
        this.kdoc = builder.getKdoc().build();
        this.annotations = UtilKt.toImmutableList(builder.getAnnotations());
        this.modifiers = UtilKt.toImmutableSet(builder.getModifiers());
        List<TypeVariableName> immutableList = UtilKt.toImmutableList(builder.getTypeVariables());
        this.typeVariables = immutableList;
        this.initializer = builder.getInitializer();
        this.delegated = builder.getDelegated();
        this.getter = builder.getGetter();
        this.setter = builder.getSetter();
        this.receiverType = builder.getReceiverType();
        this.contextReceiverTypes = UtilKt.toImmutableList(builder.getContextReceiverTypes$kotlinpoet());
        List<TypeVariableName> list = immutableList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((TypeVariableName) it.next()).getIsReified()) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (!(z || (!((funSpec = this.getter) == null && this.setter == null) && ((funSpec == null || funSpec.getModifiers().contains(KModifier.INLINE)) && ((funSpec2 = this.setter) == null || funSpec2.getModifiers().contains(KModifier.INLINE)))))) {
            throw new IllegalArgumentException("only type parameters of properties with inline getters and/or setters can be reified!".toString());
        }
        if (!(this.mutable || this.setter == null)) {
            throw new IllegalArgumentException("only a mutable property can have a setter".toString());
        }
        if (!this.contextReceiverTypes.isEmpty()) {
            if (this.getter == null) {
                throw new IllegalArgumentException("properties with context receivers require a get()".toString());
            }
            if (this.mutable && this.setter == null) {
                throw new IllegalArgumentException("mutable properties with context receivers require a set()".toString());
            }
        }
    }

    /* synthetic */ PropertySpec(Builder builder, TagMap tagMap, OriginatingElements originatingElements, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder, (i & 2) != 0 ? TaggableKt.buildTagMap(builder) : tagMap, (i & 4) != 0 ? OriginatingElementsHolderKt.buildOriginatingElements(builder) : originatingElements);
    }

    public final boolean getMutable() {
        return this.mutable;
    }

    public final String getName() {
        return this.name;
    }

    public final TypeName getType() {
        return this.type;
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

    public final List<TypeVariableName> getTypeVariables() {
        return this.typeVariables;
    }

    public final CodeBlock getInitializer() {
        return this.initializer;
    }

    public final boolean getDelegated() {
        return this.delegated;
    }

    public final FunSpec getGetter() {
        return this.getter;
    }

    public final FunSpec getSetter() {
        return this.setter;
    }

    public final TypeName getReceiverType() {
        return this.receiverType;
    }

    public final List<TypeName> getContextReceiverTypes() {
        return this.contextReceiverTypes;
    }

    public static /* synthetic */ void emit$kotlinpoet$default(PropertySpec propertySpec, CodeWriter codeWriter, Set set, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        boolean z5 = (i & 4) != 0 ? true : z;
        boolean z6 = (i & 8) != 0 ? true : z2;
        boolean z7 = (i & 16) != 0 ? false : z3;
        propertySpec.emit$kotlinpoet(codeWriter, set, z5, z6, z7, (i & 32) != 0 ? z7 : z4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        if (((r1 == null || (r1 = r1.getModifiers()) == null) ? false : r1.contains(com.squareup.kotlinpoet.KModifier.INLINE)) != false) goto L95;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void emit$kotlinpoet(com.squareup.kotlinpoet.CodeWriter r15, java.util.Set<? extends com.squareup.kotlinpoet.KModifier> r16, boolean r17, boolean r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.kotlinpoet.PropertySpec.emit$kotlinpoet(com.squareup.kotlinpoet.CodeWriter, java.util.Set, boolean, boolean, boolean, boolean):void");
    }

    public final PropertySpec fromPrimaryConstructorParameter$kotlinpoet(ParameterSpec r4) {
        Intrinsics.checkNotNullParameter(r4, "parameter");
        Builder addAnnotations = toBuilder$default(this, null, null, 3, null).addAnnotations(r4.getAnnotations());
        addAnnotations.setPrimaryConstructorParameter$kotlinpoet(true);
        CollectionsKt.addAll(addAnnotations.getModifiers(), r4.getModifiers());
        if (addAnnotations.getKdoc().isEmpty()) {
            addAnnotations.addKdoc(r4.getKdoc());
        }
        return addAnnotations.build();
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

    public static /* synthetic */ Builder toBuilder$default(PropertySpec propertySpec, String str, TypeName typeName, int i, Object obj) {
        if ((i & 1) != 0) {
            str = propertySpec.name;
        }
        if ((i & 2) != 0) {
            typeName = propertySpec.type;
        }
        return propertySpec.toBuilder(str, typeName);
    }

    public final Builder toBuilder(String name, TypeName type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Builder builder = new Builder(name, type);
        builder.setMutable$kotlinpoet(this.mutable);
        builder.getKdoc().add(this.kdoc);
        CollectionsKt.addAll(builder.getAnnotations(), this.annotations);
        CollectionsKt.addAll(builder.getModifiers(), this.modifiers);
        CollectionsKt.addAll(builder.getTypeVariables(), this.typeVariables);
        builder.setInitializer$kotlinpoet(this.initializer);
        builder.setDelegated$kotlinpoet(this.delegated);
        builder.setSetter$kotlinpoet(this.setter);
        builder.setGetter$kotlinpoet(this.getter);
        builder.setReceiverType$kotlinpoet(this.receiverType);
        builder.getTags().putAll(this.tagMap.getTags());
        CollectionsKt.addAll(builder.getOriginatingElements(), getOriginatingElements());
        return builder;
    }

    /* compiled from: PropertySpec.kt */
    @Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0017\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020\nJ\u000e\u0010E\u001a\u00020\u00002\u0006\u0010G\u001a\u00020HJ\u0014\u0010E\u001a\u00020\u00002\n\u0010G\u001a\u0006\u0012\u0002\b\u00030IH\u0007J\u0012\u0010E\u001a\u00020\u00002\n\u0010G\u001a\u0006\u0012\u0002\b\u00030=J\u0014\u0010J\u001a\u00020\u00002\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\n0LJ\u000e\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u001cJ'\u0010M\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\u00042\u0012\u0010P\u001a\n\u0012\u0006\b\u0001\u0012\u00020>0Q\"\u00020>¢\u0006\u0002\u0010RJ\u001f\u0010S\u001a\u00020\u00002\u0012\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0Q\"\u00020)¢\u0006\u0002\u0010TJ\u0014\u0010S\u001a\u00020\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0LJ\u000e\u0010U\u001a\u00020\u00002\u0006\u0010V\u001a\u00020CJ\u0014\u0010W\u001a\u00020\u00002\f\u0010B\u001a\b\u0012\u0004\u0012\u00020C0LJ\u0006\u0010X\u001a\u00020YJ!\u0010Z\u001a\u00020\u00002\u0012\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060Q\"\u00020\u0006H\u0007¢\u0006\u0002\u0010[J\u0016\u0010Z\u001a\u00020\u00002\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00060LH\u0007J\u000e\u0010]\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\u001cJ+\u0010]\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\u00042\u0016\u0010P\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010>0Q\"\u0004\u0018\u00010>¢\u0006\u0002\u0010RJ\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u001cJ+\u0010\u001b\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\u00042\u0016\u0010P\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010>0Q\"\u0004\u0018\u00010>¢\u0006\u0002\u0010RJ\u0010\u0010+\u001a\u00020\u00002\b\b\u0002\u0010+\u001a\u00020\u0010J\u0010\u0010_\u001a\u00020\u00002\b\u00103\u001a\u0004\u0018\u00010\u0006J\u0010\u0010_\u001a\u00020\u00002\u0006\u00103\u001a\u00020`H\u0007J\u0012\u0010_\u001a\u00020\u00002\n\u00103\u001a\u0006\u0012\u0002\b\u00030=J\u0010\u00108\u001a\u00020\u00002\b\u00108\u001a\u0004\u0018\u00010\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\u0014\u0010$\u001a\u00020%X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\fR\u001a\u0010+\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0012\"\u0004\b-\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001a\u00100\u001a\b\u0012\u0004\u0012\u0002010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\fR\u001c\u00103\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u00010\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0018\"\u0004\b:\u0010\u001aR$\u0010;\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030=\u0012\u0004\u0012\u00020>0<X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u00105R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\t¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\f¨\u0006a"}, d2 = {"Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "Lcom/squareup/kotlinpoet/Taggable$Builder;", "Lcom/squareup/kotlinpoet/OriginatingElementsHolder$Builder;", "name", "", "type", "Lcom/squareup/kotlinpoet/TypeName;", "(Ljava/lang/String;Lcom/squareup/kotlinpoet/TypeName;)V", "annotations", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "getAnnotations", "()Ljava/util/List;", "contextReceiverTypes", "getContextReceiverTypes$kotlinpoet", "delegated", "", "getDelegated$kotlinpoet", "()Z", "setDelegated$kotlinpoet", "(Z)V", "getter", "Lcom/squareup/kotlinpoet/FunSpec;", "getGetter$kotlinpoet", "()Lcom/squareup/kotlinpoet/FunSpec;", "setGetter$kotlinpoet", "(Lcom/squareup/kotlinpoet/FunSpec;)V", "initializer", "Lcom/squareup/kotlinpoet/CodeBlock;", "getInitializer$kotlinpoet", "()Lcom/squareup/kotlinpoet/CodeBlock;", "setInitializer$kotlinpoet", "(Lcom/squareup/kotlinpoet/CodeBlock;)V", "isPrimaryConstructorParameter", "isPrimaryConstructorParameter$kotlinpoet", "setPrimaryConstructorParameter$kotlinpoet", "kdoc", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "getKdoc$kotlinpoet", "()Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "modifiers", "Lcom/squareup/kotlinpoet/KModifier;", "getModifiers", "mutable", "getMutable$kotlinpoet", "setMutable$kotlinpoet", "getName$kotlinpoet", "()Ljava/lang/String;", "originatingElements", "Ljavax/lang/model/element/Element;", "getOriginatingElements", "receiverType", "getReceiverType$kotlinpoet", "()Lcom/squareup/kotlinpoet/TypeName;", "setReceiverType$kotlinpoet", "(Lcom/squareup/kotlinpoet/TypeName;)V", "setter", "getSetter$kotlinpoet", "setSetter$kotlinpoet", "tags", "", "Lkotlin/reflect/KClass;", "", "getTags", "()Ljava/util/Map;", "getType$kotlinpoet", "typeVariables", "Lcom/squareup/kotlinpoet/TypeVariableName;", "getTypeVariables", "addAnnotation", "annotationSpec", "annotation", "Lcom/squareup/kotlinpoet/ClassName;", "Ljava/lang/Class;", "addAnnotations", "annotationSpecs", "", "addKdoc", "block", "format", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "addModifiers", "([Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "addTypeVariable", "typeVariable", "addTypeVariables", "build", "Lcom/squareup/kotlinpoet/PropertySpec;", "contextReceivers", "([Lcom/squareup/kotlinpoet/TypeName;)Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "receiverTypes", "delegate", "codeBlock", "receiver", "Ljava/lang/reflect/Type;", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder implements Taggable.Builder<Builder>, OriginatingElementsHolder.Builder<Builder> {
        private final List<AnnotationSpec> annotations;
        private final List<TypeName> contextReceiverTypes;
        private boolean delegated;
        private FunSpec getter;
        private CodeBlock initializer;
        private boolean isPrimaryConstructorParameter;
        private final CodeBlock.Builder kdoc;
        private final List<KModifier> modifiers;
        private boolean mutable;
        private final String name;
        private final List<Element> originatingElements;
        private TypeName receiverType;
        private FunSpec setter;
        private final Map<KClass<?>, Object> tags;
        private final TypeName type;
        private final List<TypeVariableName> typeVariables;

        public Builder(String name, TypeName type) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            this.name = name;
            this.type = type;
            this.kdoc = CodeBlock.INSTANCE.builder();
            this.contextReceiverTypes = new ArrayList();
            this.annotations = new ArrayList();
            this.modifiers = new ArrayList();
            this.typeVariables = new ArrayList();
            this.tags = new LinkedHashMap();
            this.originatingElements = new ArrayList();
        }

        @Override // com.squareup.kotlinpoet.OriginatingElementsHolder.Builder
        public Builder addOriginatingElement(Element element) {
            return (Builder) OriginatingElementsHolder.Builder.DefaultImpls.addOriginatingElement(this, element);
        }

        @Override // com.squareup.kotlinpoet.Taggable.Builder
        public Builder tag(Class<?> cls, Object obj) {
            return (Builder) Taggable.Builder.DefaultImpls.tag(this, cls, obj);
        }

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

        /* renamed from: isPrimaryConstructorParameter$kotlinpoet, reason: from getter */
        public final boolean getIsPrimaryConstructorParameter() {
            return this.isPrimaryConstructorParameter;
        }

        public final void setPrimaryConstructorParameter$kotlinpoet(boolean z) {
            this.isPrimaryConstructorParameter = z;
        }

        /* renamed from: getMutable$kotlinpoet, reason: from getter */
        public final boolean getMutable() {
            return this.mutable;
        }

        public final void setMutable$kotlinpoet(boolean z) {
            this.mutable = z;
        }

        /* renamed from: getKdoc$kotlinpoet, reason: from getter */
        public final CodeBlock.Builder getKdoc() {
            return this.kdoc;
        }

        /* renamed from: getInitializer$kotlinpoet, reason: from getter */
        public final CodeBlock getInitializer() {
            return this.initializer;
        }

        public final void setInitializer$kotlinpoet(CodeBlock codeBlock) {
            this.initializer = codeBlock;
        }

        /* renamed from: getDelegated$kotlinpoet, reason: from getter */
        public final boolean getDelegated() {
            return this.delegated;
        }

        public final void setDelegated$kotlinpoet(boolean z) {
            this.delegated = z;
        }

        /* renamed from: getGetter$kotlinpoet, reason: from getter */
        public final FunSpec getGetter() {
            return this.getter;
        }

        public final void setGetter$kotlinpoet(FunSpec funSpec) {
            this.getter = funSpec;
        }

        /* renamed from: getSetter$kotlinpoet, reason: from getter */
        public final FunSpec getSetter() {
            return this.setter;
        }

        public final void setSetter$kotlinpoet(FunSpec funSpec) {
            this.setter = funSpec;
        }

        /* renamed from: getReceiverType$kotlinpoet, reason: from getter */
        public final TypeName getReceiverType() {
            return this.receiverType;
        }

        public final void setReceiverType$kotlinpoet(TypeName typeName) {
            this.receiverType = typeName;
        }

        public final List<TypeName> getContextReceiverTypes$kotlinpoet() {
            return this.contextReceiverTypes;
        }

        public final List<AnnotationSpec> getAnnotations() {
            return this.annotations;
        }

        public final List<KModifier> getModifiers() {
            return this.modifiers;
        }

        public final List<TypeVariableName> getTypeVariables() {
            return this.typeVariables;
        }

        @Override // com.squareup.kotlinpoet.Taggable.Builder
        public Map<KClass<?>, Object> getTags() {
            return this.tags;
        }

        @Override // com.squareup.kotlinpoet.OriginatingElementsHolder.Builder
        public List<Element> getOriginatingElements() {
            return this.originatingElements;
        }

        public static /* synthetic */ Builder mutable$default(Builder builder, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = true;
            }
            return builder.mutable(z);
        }

        public final Builder mutable(boolean mutable) {
            this.mutable = mutable;
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

        public final Builder initializer(String format, Object... args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            return initializer(CodeBlock.INSTANCE.of(format, Arrays.copyOf(args, args.length)));
        }

        public final Builder initializer(CodeBlock codeBlock) {
            this.initializer = codeBlock;
            this.delegated = false;
            return this;
        }

        public final Builder delegate(String format, Object... args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            return delegate(CodeBlock.INSTANCE.of(format, Arrays.copyOf(args, args.length)));
        }

        public final Builder delegate(CodeBlock codeBlock) {
            Intrinsics.checkNotNullParameter(codeBlock, "codeBlock");
            this.initializer = codeBlock;
            this.delegated = true;
            return this;
        }

        public final Builder getter(FunSpec getter) {
            if (!(getter == null || Intrinsics.areEqual(getter.getName(), FunSpec.GETTER))) {
                StringBuilder sb = new StringBuilder();
                Intrinsics.checkNotNull(getter);
                sb.append(getter.getName());
                sb.append(" is not a getter");
                throw new IllegalArgumentException(sb.toString().toString());
            }
            this.getter = getter;
            return this;
        }

        public final Builder setter(FunSpec setter) {
            if (!(setter == null || Intrinsics.areEqual(setter.getName(), FunSpec.SETTER))) {
                StringBuilder sb = new StringBuilder();
                Intrinsics.checkNotNull(setter);
                sb.append(setter.getName());
                sb.append(" is not a setter");
                throw new IllegalArgumentException(sb.toString().toString());
            }
            this.setter = setter;
            return this;
        }

        public final Builder receiver(TypeName receiverType) {
            this.receiverType = receiverType;
            return this;
        }

        public final Builder receiver(Type receiverType) {
            Intrinsics.checkNotNullParameter(receiverType, "receiverType");
            return receiver(TypeNames.get(receiverType));
        }

        public final Builder receiver(KClass<?> receiverType) {
            Intrinsics.checkNotNullParameter(receiverType, "receiverType");
            return receiver(TypeNames.get(receiverType));
        }

        public final Builder contextReceivers(Iterable<? extends TypeName> receiverTypes) {
            Intrinsics.checkNotNullParameter(receiverTypes, "receiverTypes");
            CollectionsKt.addAll(this.contextReceiverTypes, receiverTypes);
            return this;
        }

        public final Builder contextReceivers(TypeName... receiverType) {
            Intrinsics.checkNotNullParameter(receiverType, "receiverType");
            return contextReceivers(ArraysKt.toList(receiverType));
        }

        public final PropertySpec build() {
            if (this.modifiers.contains(KModifier.INLINE)) {
                throw new IllegalArgumentException("KotlinPoet doesn't allow setting the inline modifier on properties. You should mark either the getter, the setter, or both inline.");
            }
            for (KModifier kModifier : this.modifiers) {
                if (!this.isPrimaryConstructorParameter) {
                    kModifier.checkTarget$kotlinpoet(KModifier.Target.PROPERTY);
                }
            }
            return new PropertySpec(this, null, null, 6, null);
        }
    }

    /* compiled from: PropertySpec.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000bH\u0007¢\u0006\u0002\u0010\fJ&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0007J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000e2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000bH\u0007¢\u0006\u0002\u0010\u000fJ&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0007J5\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00102\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0011J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0007¨\u0006\u0012"}, d2 = {"Lcom/squareup/kotlinpoet/PropertySpec$Companion;", "", "()V", "builder", "Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "name", "", "type", "Lcom/squareup/kotlinpoet/TypeName;", "modifiers", "", "Lcom/squareup/kotlinpoet/KModifier;", "(Ljava/lang/String;Lcom/squareup/kotlinpoet/TypeName;[Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;[Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "Lkotlin/reflect/KClass;", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
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
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        CodeWriter codeWriter = new CodeWriter(sb, null, null, null, null, Integer.MAX_VALUE, 30, null);
        try {
            emit$kotlinpoet$default(this, codeWriter, SetsKt.emptySet(), false, false, false, false, 60, null);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(codeWriter, null);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
            return sb2;
        } finally {
        }
    }
}
