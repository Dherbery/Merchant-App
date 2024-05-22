package com.squareup.kotlinpoet;

import com.amazon.a.a.o.b;
import com.squareup.kotlinpoet.TypeName;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: TypeVariableName.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 Bg\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\u0010\u0011JT\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u001a\u001a\u00020\t2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0004\u0012\u00020\u00100\u000eJ6\u0010\u0019\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0016\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0016J\u0015\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0010¢\u0006\u0002\b\u001eJ\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005*\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lcom/squareup/kotlinpoet/TypeVariableName;", "Lcom/squareup/kotlinpoet/TypeName;", "name", "", "bounds", "", "variance", "Lcom/squareup/kotlinpoet/KModifier;", "isReified", "", "nullable", "annotations", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "tags", "", "Lkotlin/reflect/KClass;", "", "(Ljava/lang/String;Ljava/util/List;Lcom/squareup/kotlinpoet/KModifier;ZZLjava/util/List;Ljava/util/Map;)V", "getBounds", "()Ljava/util/List;", "()Z", "getName", "()Ljava/lang/String;", "getVariance", "()Lcom/squareup/kotlinpoet/KModifier;", "copy", "reified", "emit", "Lcom/squareup/kotlinpoet/CodeWriter;", "out", "emit$kotlinpoet", "withoutImplicitBound", "Companion", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class TypeVariableName extends TypeName {
    private final List<TypeName> bounds;
    private final boolean isReified;
    private final String name;
    private final KModifier variance;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<TypeName> NULLABLE_ANY_LIST = CollectionsKt.listOf(CodeWriterKt.getNULLABLE_ANY());
    private static final ClassName JAVA_OBJECT = new ClassName("java.lang", "Object");

    @JvmStatic
    public static final TypeVariableName get(String str) {
        return INSTANCE.get(str);
    }

    @JvmStatic
    public static final TypeVariableName get(String str, KModifier kModifier) {
        return INSTANCE.get(str, kModifier);
    }

    @JvmStatic
    public static final TypeVariableName get(String str, List<? extends TypeName> list) {
        return INSTANCE.get(str, list);
    }

    @JvmStatic
    public static final TypeVariableName get(String str, List<? extends TypeName> list, KModifier kModifier) {
        return INSTANCE.get(str, list, kModifier);
    }

    @JvmStatic
    public static final TypeVariableName get(String str, TypeName... typeNameArr) {
        return INSTANCE.get(str, typeNameArr);
    }

    @JvmStatic
    public static final TypeVariableName get(String str, TypeName[] typeNameArr, KModifier kModifier) {
        return INSTANCE.get(str, typeNameArr, kModifier);
    }

    @JvmStatic
    public static final TypeVariableName get(String str, Type... typeArr) {
        return INSTANCE.get(str, typeArr);
    }

    @JvmStatic
    public static final TypeVariableName get(String str, Type[] typeArr, KModifier kModifier) {
        return INSTANCE.get(str, typeArr, kModifier);
    }

    @JvmStatic
    public static final TypeVariableName get(String str, KClass<?>... kClassArr) {
        return INSTANCE.get(str, kClassArr);
    }

    @JvmStatic
    public static final TypeVariableName get(String str, KClass<?>[] kClassArr, KModifier kModifier) {
        return INSTANCE.get(str, kClassArr, kModifier);
    }

    @JvmStatic
    public static final TypeVariableName getWithClasses(String str, Iterable<? extends KClass<?>> iterable) {
        return INSTANCE.getWithClasses(str, iterable);
    }

    @JvmStatic
    public static final TypeVariableName getWithClasses(String str, Iterable<? extends KClass<?>> iterable, KModifier kModifier) {
        return INSTANCE.getWithClasses(str, iterable, kModifier);
    }

    @JvmStatic
    public static final TypeVariableName getWithTypes(String str, Iterable<? extends Type> iterable) {
        return INSTANCE.getWithTypes(str, iterable);
    }

    @JvmStatic
    public static final TypeVariableName getWithTypes(String str, Iterable<? extends Type> iterable, KModifier kModifier) {
        return INSTANCE.getWithTypes(str, iterable, kModifier);
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public /* bridge */ /* synthetic */ TypeName copy(boolean z, List list, Map map) {
        return copy(z, (List<AnnotationSpec>) list, (Map<KClass<?>, ? extends Object>) map);
    }

    public final String getName() {
        return this.name;
    }

    public final List<TypeName> getBounds() {
        return this.bounds;
    }

    public final KModifier getVariance() {
        return this.variance;
    }

    /* renamed from: isReified, reason: from getter */
    public final boolean getIsReified() {
        return this.isReified;
    }

    /* synthetic */ TypeVariableName(String str, List list, KModifier kModifier, boolean z, boolean z2, List list2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i & 4) != 0 ? null : kModifier, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? CollectionsKt.emptyList() : list2, (i & 64) != 0 ? MapsKt.emptyMap() : map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeVariableName(String str, List<? extends TypeName> list, KModifier kModifier, boolean z, boolean z2, List<AnnotationSpec> list2, Map<KClass<?>, ? extends Object> map) {
        super(z2, list2, new TagMap(map), null);
        this.name = str;
        this.bounds = list;
        this.variance = kModifier;
        this.isReified = z;
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public TypeVariableName copy(boolean nullable, List<AnnotationSpec> annotations, Map<KClass<?>, ? extends Object> tags) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(tags, "tags");
        return copy(nullable, annotations, this.bounds, this.isReified, tags);
    }

    public static /* synthetic */ TypeVariableName copy$default(TypeVariableName typeVariableName, boolean z, List list, List list2, boolean z2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            z = typeVariableName.getIsNullable();
        }
        if ((i & 2) != 0) {
            list = CollectionsKt.toList(typeVariableName.getAnnotations());
        }
        List list3 = list;
        if ((i & 4) != 0) {
            list2 = CollectionsKt.toList(typeVariableName.bounds);
        }
        List list4 = list2;
        if ((i & 8) != 0) {
            z2 = typeVariableName.isReified;
        }
        boolean z3 = z2;
        if ((i & 16) != 0) {
            map = typeVariableName.getTagMap().getTags();
        }
        return typeVariableName.copy(z, list3, list4, z3, map);
    }

    public final TypeVariableName copy(boolean nullable, List<AnnotationSpec> annotations, List<? extends TypeName> bounds, boolean reified, Map<KClass<?>, ? extends Object> tags) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(tags, "tags");
        return new TypeVariableName(this.name, withoutImplicitBound(bounds), this.variance, reified, nullable, annotations, tags);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<TypeName> withoutImplicitBound(List<? extends TypeName> list) {
        if (list.size() == 1) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!Intrinsics.areEqual((TypeName) obj, CodeWriterKt.getNULLABLE_ANY())) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public CodeWriter emit$kotlinpoet(CodeWriter out) {
        Intrinsics.checkNotNullParameter(out, "out");
        return CodeWriter.emit$default(out, this.name, false, 2, null);
    }

    /* compiled from: TypeVariableName.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b0\u000fH\u0000¢\u0006\u0002\b\u0011J)\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b0\u000fH\u0000¢\u0006\u0002\b\u0011J\"\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0087\u0002¢\u0006\u0002\b\nJ8\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u001c\"\u00020\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0087\u0002¢\u0006\u0004\b\n\u0010\u001dJ8\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u001c\"\u00020\u00102\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0087\u0002¢\u0006\u0004\b\n\u0010\u001eJ@\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u001a\u0010\u001b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001f0\u001c\"\u0006\u0012\u0002\b\u00030\u001f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0087\u0002¢\u0006\u0004\b\n\u0010 J0\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100!2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0087\u0002¢\u0006\u0002\b\"J4\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f0!2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0087\u0002¢\u0006\u0002\b#J0\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0087\u0002¢\u0006\u0002\b\nJ-\u0010$\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0000¢\u0006\u0002\b%R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006&"}, d2 = {"Lcom/squareup/kotlinpoet/TypeVariableName$Companion;", "", "()V", "JAVA_OBJECT", "Lcom/squareup/kotlinpoet/ClassName;", "NULLABLE_ANY_LIST", "", "Lcom/squareup/kotlinpoet/TypeName;", "getNULLABLE_ANY_LIST$kotlinpoet", "()Ljava/util/List;", b.ar, "Lcom/squareup/kotlinpoet/TypeVariableName;", "type", "Ljava/lang/reflect/TypeVariable;", "map", "", "Ljava/lang/reflect/Type;", "get$kotlinpoet", "mirror", "Ljavax/lang/model/type/TypeVariable;", "typeVariables", "Ljavax/lang/model/element/TypeParameterElement;", "invoke", "name", "", "variance", "Lcom/squareup/kotlinpoet/KModifier;", "bounds", "", "(Ljava/lang/String;[Lcom/squareup/kotlinpoet/TypeName;Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/TypeVariableName;", "(Ljava/lang/String;[Ljava/lang/reflect/Type;Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/TypeVariableName;", "Lkotlin/reflect/KClass;", "(Ljava/lang/String;[Lkotlin/reflect/KClass;Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/TypeVariableName;", "", "getWithTypes", "getWithClasses", "of", "of$kotlinpoet", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final TypeVariableName get(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return get$default(this, name, null, 2, null);
        }

        @JvmStatic
        public final TypeVariableName get(String name, List<? extends TypeName> bounds) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            return get$default(this, name, bounds, (KModifier) null, 4, (Object) null);
        }

        @JvmStatic
        public final TypeVariableName get(String name, TypeName... bounds) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            return get$default(this, name, bounds, (KModifier) null, 4, (Object) null);
        }

        @JvmStatic
        public final TypeVariableName get(String name, Type... bounds) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            return get$default(this, name, bounds, (KModifier) null, 4, (Object) null);
        }

        @JvmStatic
        public final TypeVariableName get(String name, KClass<?>... bounds) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            return get$default(this, name, bounds, (KModifier) null, 4, (Object) null);
        }

        @JvmStatic
        public final TypeVariableName getWithClasses(String name, Iterable<? extends KClass<?>> bounds) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            return getWithClasses$default(this, name, bounds, null, 4, null);
        }

        @JvmStatic
        public final TypeVariableName getWithTypes(String name, Iterable<? extends Type> bounds) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            return getWithTypes$default(this, name, bounds, null, 4, null);
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.squareup.kotlinpoet.TypeVariableName of$kotlinpoet(java.lang.String r12, java.util.List<? extends com.squareup.kotlinpoet.TypeName> r13, com.squareup.kotlinpoet.KModifier r14) {
            /*
                r11 = this;
                java.lang.String r0 = "name"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                java.lang.String r0 = "bounds"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
                r0 = 1
                if (r14 == 0) goto L22
                com.squareup.kotlinpoet.KModifier r2 = com.squareup.kotlinpoet.KModifier.IN
                com.squareup.kotlinpoet.KModifier r3 = com.squareup.kotlinpoet.KModifier.OUT
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 60
                r9 = 0
                r1 = r14
                boolean r1 = com.squareup.kotlinpoet.UtilKt.isOneOf$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                if (r1 == 0) goto L20
                goto L22
            L20:
                r1 = 0
                goto L23
            L22:
                r1 = r0
            L23:
                if (r1 == 0) goto L5b
                r1 = r13
                java.util.Collection r1 = (java.util.Collection) r1
                boolean r1 = r1.isEmpty()
                r0 = r0 ^ r1
                if (r0 == 0) goto L40
                com.squareup.kotlinpoet.TypeVariableName r0 = new com.squareup.kotlinpoet.TypeVariableName
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 120(0x78, float:1.68E-43)
                r10 = 0
                r1 = r0
                r2 = r12
                r3 = r13
                r4 = r14
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
                return r0
            L40:
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                r13.append(r12)
                java.lang.String r12 = " has no bounds"
                r13.append(r12)
                java.lang.String r12 = r13.toString()
                java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
                java.lang.String r12 = r12.toString()
                r13.<init>(r12)
                throw r13
            L5b:
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                r12.append(r14)
                java.lang.String r13 = " is an invalid variance modifier, the only allowed values are in and out!"
                r12.append(r13)
                java.lang.String r12 = r12.toString()
                java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
                java.lang.String r12 = r12.toString()
                r13.<init>(r12)
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.kotlinpoet.TypeVariableName.Companion.of$kotlinpoet(java.lang.String, java.util.List, com.squareup.kotlinpoet.KModifier):com.squareup.kotlinpoet.TypeVariableName");
        }

        public static /* synthetic */ TypeVariableName get$default(Companion companion, String str, KModifier kModifier, int i, Object obj) {
            if ((i & 2) != 0) {
                kModifier = null;
            }
            return companion.get(str, kModifier);
        }

        @JvmStatic
        public final TypeVariableName get(String name, KModifier variance) {
            Intrinsics.checkNotNullParameter(name, "name");
            return of$kotlinpoet(name, getNULLABLE_ANY_LIST$kotlinpoet(), variance);
        }

        public static /* synthetic */ TypeVariableName get$default(Companion companion, String str, TypeName[] typeNameArr, KModifier kModifier, int i, Object obj) {
            if ((i & 4) != 0) {
                kModifier = null;
            }
            return companion.get(str, typeNameArr, kModifier);
        }

        @JvmStatic
        public final TypeVariableName get(String name, TypeName[] bounds, KModifier variance) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            List<TypeName> list = ArraysKt.toList(bounds);
            if (list.isEmpty()) {
                list = getNULLABLE_ANY_LIST$kotlinpoet();
            }
            return of$kotlinpoet(name, list, variance);
        }

        public static /* synthetic */ TypeVariableName get$default(Companion companion, String str, KClass[] kClassArr, KModifier kModifier, int i, Object obj) {
            if ((i & 4) != 0) {
                kModifier = null;
            }
            return companion.get(str, (KClass<?>[]) kClassArr, kModifier);
        }

        public static /* synthetic */ TypeVariableName get$default(Companion companion, String str, Type[] typeArr, KModifier kModifier, int i, Object obj) {
            if ((i & 4) != 0) {
                kModifier = null;
            }
            return companion.get(str, typeArr, kModifier);
        }

        public static /* synthetic */ TypeVariableName get$default(Companion companion, String str, List list, KModifier kModifier, int i, Object obj) {
            if ((i & 4) != 0) {
                kModifier = null;
            }
            return companion.get(str, (List<? extends TypeName>) list, kModifier);
        }

        @JvmStatic
        public final TypeVariableName get(String name, List<? extends TypeName> bounds, KModifier variance) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            List<? extends TypeName> list = bounds;
            if (list.isEmpty()) {
                list = getNULLABLE_ANY_LIST$kotlinpoet();
            }
            return of$kotlinpoet(name, (List) list, variance);
        }

        public static /* synthetic */ TypeVariableName getWithClasses$default(Companion companion, String str, Iterable iterable, KModifier kModifier, int i, Object obj) {
            if ((i & 4) != 0) {
                kModifier = null;
            }
            return companion.getWithClasses(str, iterable, kModifier);
        }

        public static /* synthetic */ TypeVariableName getWithTypes$default(Companion companion, String str, Iterable iterable, KModifier kModifier, int i, Object obj) {
            if ((i & 4) != 0) {
                kModifier = null;
            }
            return companion.getWithTypes(str, iterable, kModifier);
        }

        public final TypeVariableName get$kotlinpoet(TypeVariable mirror, Map<TypeParameterElement, TypeVariableName> typeVariables) {
            Intrinsics.checkNotNullParameter(mirror, "mirror");
            Intrinsics.checkNotNullParameter(typeVariables, "typeVariables");
            Element asElement = mirror.asElement();
            Intrinsics.checkNotNull(asElement, "null cannot be cast to non-null type javax.lang.model.element.TypeParameterElement");
            TypeParameterElement typeParameterElement = (TypeParameterElement) asElement;
            TypeVariableName typeVariableName = typeVariables.get(typeParameterElement);
            if (typeVariableName != null) {
                return typeVariableName;
            }
            ArrayList arrayList = new ArrayList();
            List visibleBounds = Collections.unmodifiableList(arrayList);
            String obj = typeParameterElement.getSimpleName().toString();
            Intrinsics.checkNotNullExpressionValue(visibleBounds, "visibleBounds");
            TypeVariableName typeVariableName2 = new TypeVariableName(obj, visibleBounds, null, false, false, null, null, 124, null);
            typeVariables.put(typeParameterElement, typeVariableName2);
            for (TypeMirror typeMirror : typeParameterElement.getBounds()) {
                TypeName.Companion companion = TypeName.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(typeMirror, "typeMirror");
                arrayList.add(companion.get$kotlinpoet(typeMirror, typeVariables));
            }
            arrayList.remove(TypeNames.ANY);
            arrayList.remove(TypeVariableName.JAVA_OBJECT);
            if (arrayList.isEmpty()) {
                arrayList.add(CodeWriterKt.getNULLABLE_ANY());
            }
            return typeVariableName2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TypeVariableName get$kotlinpoet$default(Companion companion, java.lang.reflect.TypeVariable typeVariable, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                map = new LinkedHashMap();
            }
            return companion.get$kotlinpoet((java.lang.reflect.TypeVariable<?>) typeVariable, (Map<Type, TypeVariableName>) map);
        }

        public final TypeVariableName get$kotlinpoet(java.lang.reflect.TypeVariable<?> type, Map<Type, TypeVariableName> map) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(map, "map");
            TypeVariableName typeVariableName = map.get(type);
            if (typeVariableName != null) {
                return typeVariableName;
            }
            ArrayList arrayList = new ArrayList();
            List visibleBounds = Collections.unmodifiableList(arrayList);
            String name = type.getName();
            Intrinsics.checkNotNullExpressionValue(name, "type.name");
            Intrinsics.checkNotNullExpressionValue(visibleBounds, "visibleBounds");
            TypeVariableName typeVariableName2 = new TypeVariableName(name, visibleBounds, null, false, false, null, null, 124, null);
            map.put(type, typeVariableName2);
            Type[] bounds = type.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "type.bounds");
            for (Type bound : bounds) {
                TypeName.Companion companion = TypeName.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(bound, "bound");
                arrayList.add(companion.get$kotlinpoet(bound, map));
            }
            arrayList.remove(TypeNames.ANY);
            arrayList.remove(TypeVariableName.JAVA_OBJECT);
            if (arrayList.isEmpty()) {
                arrayList.add(CodeWriterKt.getNULLABLE_ANY());
            }
            return typeVariableName2;
        }

        public final List<TypeName> getNULLABLE_ANY_LIST$kotlinpoet() {
            return TypeVariableName.NULLABLE_ANY_LIST;
        }

        @JvmStatic
        public final TypeVariableName get(String name, KClass<?>[] bounds, KModifier variance) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            List arrayList = new ArrayList(bounds.length);
            for (KClass<?> kClass : bounds) {
                arrayList.add(TypeNames.get(kClass));
            }
            List list = arrayList;
            if (list.isEmpty()) {
                list = getNULLABLE_ANY_LIST$kotlinpoet();
            }
            return of$kotlinpoet(name, list, variance);
        }

        @JvmStatic
        public final TypeVariableName get(String name, Type[] bounds, KModifier variance) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            List arrayList = new ArrayList(bounds.length);
            for (Type type : bounds) {
                arrayList.add(TypeNames.get(type));
            }
            List list = arrayList;
            if (list.isEmpty()) {
                list = getNULLABLE_ANY_LIST$kotlinpoet();
            }
            return of$kotlinpoet(name, list, variance);
        }

        @JvmStatic
        public final TypeVariableName getWithClasses(String name, Iterable<? extends KClass<?>> bounds, KModifier variance) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            List arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(bounds, 10));
            Iterator<? extends KClass<?>> it = bounds.iterator();
            while (it.hasNext()) {
                arrayList.add(TypeNames.get(it.next()));
            }
            List list = arrayList;
            if (list.isEmpty()) {
                list = getNULLABLE_ANY_LIST$kotlinpoet();
            }
            return of$kotlinpoet(name, list, variance);
        }

        @JvmStatic
        public final TypeVariableName getWithTypes(String name, Iterable<? extends Type> bounds, KModifier variance) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            List arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(bounds, 10));
            Iterator<? extends Type> it = bounds.iterator();
            while (it.hasNext()) {
                arrayList.add(TypeNames.get(it.next()));
            }
            List list = arrayList;
            if (list.isEmpty()) {
                list = getNULLABLE_ANY_LIST$kotlinpoet();
            }
            return of$kotlinpoet(name, list, variance);
        }
    }
}
