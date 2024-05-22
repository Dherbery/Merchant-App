package com.squareup.kotlinpoet;

import com.amazon.a.a.o.b;
import com.squareup.kotlinpoet.AnnotationSpec;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

/* compiled from: ParameterizedTypeName.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB[\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\u0010\u000fJ6\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0016\u0010\u000b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u000e0\fH\u0016JJ\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u000e0\f2\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006J\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0010¢\u0006\u0002\b\u0018J\u001c\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0001J\u0012\u0010\u001c\u001a\u00020\u00002\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001eJ\u0012\u0010\u001c\u001a\u00020\u00002\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\rR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/squareup/kotlinpoet/ParameterizedTypeName;", "Lcom/squareup/kotlinpoet/TypeName;", "enclosingType", "rawType", "Lcom/squareup/kotlinpoet/ClassName;", "typeArguments", "", "nullable", "", "annotations", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "tags", "", "Lkotlin/reflect/KClass;", "", "(Lcom/squareup/kotlinpoet/TypeName;Lcom/squareup/kotlinpoet/ClassName;Ljava/util/List;ZLjava/util/List;Ljava/util/Map;)V", "getRawType", "()Lcom/squareup/kotlinpoet/ClassName;", "getTypeArguments", "()Ljava/util/List;", "copy", "emit", "Lcom/squareup/kotlinpoet/CodeWriter;", "out", "emit$kotlinpoet", "nestedClass", "name", "", "plusParameter", "typeArgument", "Ljava/lang/Class;", "Companion", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ParameterizedTypeName extends TypeName {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final TypeName enclosingType;
    private final ClassName rawType;
    private final List<TypeName> typeArguments;

    @JvmStatic
    public static final ParameterizedTypeName get(ClassName className, TypeName typeName) {
        return INSTANCE.get(className, typeName);
    }

    @JvmStatic
    public static final ParameterizedTypeName get(ClassName className, List<? extends TypeName> list) {
        return INSTANCE.get(className, list);
    }

    @JvmStatic
    public static final ParameterizedTypeName get(ClassName className, TypeName... typeNameArr) {
        return INSTANCE.get(className, typeNameArr);
    }

    @JvmStatic
    public static final ParameterizedTypeName get(Class<?> cls, Class<?> cls2) {
        return INSTANCE.get(cls, cls2);
    }

    @JvmStatic
    public static final ParameterizedTypeName get(Class<?> cls, Iterable<? extends Type> iterable) {
        return INSTANCE.get(cls, iterable);
    }

    @JvmStatic
    public static final ParameterizedTypeName get(Class<?> cls, Type... typeArr) {
        return INSTANCE.get(cls, typeArr);
    }

    @JvmStatic
    public static final ParameterizedTypeName get(KClass<?> kClass, Iterable<? extends KClass<?>> iterable) {
        return INSTANCE.get(kClass, iterable);
    }

    @JvmStatic
    public static final ParameterizedTypeName get(KClass<?> kClass, KClass<?> kClass2) {
        return INSTANCE.get(kClass, kClass2);
    }

    @JvmStatic
    public static final ParameterizedTypeName get(KClass<?> kClass, KClass<?>... kClassArr) {
        return INSTANCE.get(kClass, kClassArr);
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public /* bridge */ /* synthetic */ TypeName copy(boolean z, List list, Map map) {
        return copy(z, (List<AnnotationSpec>) list, (Map<KClass<?>, ? extends Object>) map);
    }

    public final ClassName getRawType() {
        return this.rawType;
    }

    public /* synthetic */ ParameterizedTypeName(TypeName typeName, ClassName className, List list, boolean z, List list2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeName, className, list, (i & 8) != 0 ? false : z, (i & 16) != 0 ? CollectionsKt.emptyList() : list2, (i & 32) != 0 ? MapsKt.emptyMap() : map);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParameterizedTypeName(TypeName typeName, ClassName rawType, List<? extends TypeName> typeArguments, boolean z, List<AnnotationSpec> annotations, Map<KClass<?>, ? extends Object> tags) {
        super(z, annotations, new TagMap(tags), null);
        Intrinsics.checkNotNullParameter(rawType, "rawType");
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.enclosingType = typeName;
        this.rawType = rawType;
        this.typeArguments = UtilKt.toImmutableList(typeArguments);
        boolean z2 = true;
        if (!(!r4.isEmpty()) && typeName == null) {
            z2 = false;
        }
        if (z2) {
            return;
        }
        throw new IllegalArgumentException(("no type arguments: " + rawType).toString());
    }

    public final List<TypeName> getTypeArguments() {
        return this.typeArguments;
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public ParameterizedTypeName copy(boolean nullable, List<AnnotationSpec> annotations, Map<KClass<?>, ? extends Object> tags) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(tags, "tags");
        return new ParameterizedTypeName(this.enclosingType, this.rawType, this.typeArguments, nullable, annotations, tags);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ParameterizedTypeName copy$default(ParameterizedTypeName parameterizedTypeName, boolean z, List list, Map map, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = parameterizedTypeName.getIsNullable();
        }
        if ((i & 2) != 0) {
            list = parameterizedTypeName.getAnnotations();
        }
        if ((i & 4) != 0) {
            map = parameterizedTypeName.getTags();
        }
        if ((i & 8) != 0) {
            list2 = parameterizedTypeName.typeArguments;
        }
        return parameterizedTypeName.copy(z, list, map, list2);
    }

    public final ParameterizedTypeName copy(boolean nullable, List<AnnotationSpec> annotations, Map<KClass<?>, ? extends Object> tags, List<? extends TypeName> typeArguments) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        return new ParameterizedTypeName(this.enclosingType, this.rawType, typeArguments, nullable, annotations, tags);
    }

    public final ParameterizedTypeName plusParameter(TypeName typeArgument) {
        Intrinsics.checkNotNullParameter(typeArgument, "typeArgument");
        return new ParameterizedTypeName(this.enclosingType, this.rawType, CollectionsKt.plus((Collection<? extends TypeName>) this.typeArguments, typeArgument), getIsNullable(), getAnnotations(), null, 32, null);
    }

    public final ParameterizedTypeName plusParameter(KClass<?> typeArgument) {
        Intrinsics.checkNotNullParameter(typeArgument, "typeArgument");
        return plusParameter(ClassNames.get(typeArgument));
    }

    public final ParameterizedTypeName plusParameter(Class<?> typeArgument) {
        Intrinsics.checkNotNullParameter(typeArgument, "typeArgument");
        return plusParameter(ClassNames.get(typeArgument));
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public CodeWriter emit$kotlinpoet(CodeWriter out) {
        Intrinsics.checkNotNullParameter(out, "out");
        TypeName typeName = this.enclosingType;
        if (typeName != null) {
            typeName.emitAnnotations$kotlinpoet(out);
            this.enclosingType.emit$kotlinpoet(out);
            CodeWriter.emit$default(out, "." + this.rawType.getSimpleName(), false, 2, null);
        } else {
            this.rawType.emitAnnotations$kotlinpoet(out);
            this.rawType.emit$kotlinpoet(out);
        }
        if (!this.typeArguments.isEmpty()) {
            CodeWriter.emit$default(out, "<", false, 2, null);
            int i = 0;
            for (Object obj : this.typeArguments) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                TypeName typeName2 = (TypeName) obj;
                if (i > 0) {
                    CodeWriter.emit$default(out, ",·", false, 2, null);
                }
                typeName2.emitAnnotations$kotlinpoet(out);
                typeName2.emit$kotlinpoet(out);
                typeName2.emitNullable$kotlinpoet(out);
                i = i2;
            }
            CodeWriter.emit$default(out, ">", false, 2, null);
        }
        return out;
    }

    public final ParameterizedTypeName nestedClass(String name, List<? extends TypeName> typeArguments) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        return new ParameterizedTypeName(this, this.rawType.nestedClass(name), typeArguments, false, null, null, 56, null);
    }

    /* compiled from: ParameterizedTypeName.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0000¢\u0006\u0002\b\u000bJ/\u0010\u0003\u001a\u00020\f2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0000¢\u0006\u0002\b\u000bJ'\u0010\u0013\u001a\u00020\u0004*\u00020\u00142\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0015\"\u00020\fH\u0007¢\u0006\u0004\b\u0003\u0010\u0016J\u001f\u0010\u0013\u001a\u00020\u0004*\u00020\u00142\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0011H\u0007¢\u0006\u0002\b\u0003J+\u0010\u0013\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00172\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0015\"\u00020\tH\u0007¢\u0006\u0004\b\u0003\u0010\u0018J#\u0010\u0013\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00172\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0019H\u0007¢\u0006\u0002\b\u0003J3\u0010\u0013\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\r2\u001a\u0010\u0010\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\r0\u0015\"\u0006\u0012\u0002\b\u00030\rH\u0007¢\u0006\u0004\b\u0003\u0010\u001aJ'\u0010\u0013\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\r2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u0019H\u0007¢\u0006\u0002\b\u0003J\u0019\u0010\u001b\u001a\u00020\u0004*\u00020\u00142\u0006\u0010\u001c\u001a\u00020\fH\u0007¢\u0006\u0002\b\u0003J!\u0010\u001b\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00172\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0007¢\u0006\u0002\b\u0003J!\u0010\u001b\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\r2\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\rH\u0007¢\u0006\u0002\b\u0003¨\u0006\u001d"}, d2 = {"Lcom/squareup/kotlinpoet/ParameterizedTypeName$Companion;", "", "()V", b.ar, "Lcom/squareup/kotlinpoet/ParameterizedTypeName;", "type", "Ljava/lang/reflect/ParameterizedType;", "map", "", "Ljava/lang/reflect/Type;", "Lcom/squareup/kotlinpoet/TypeVariableName;", "get$kotlinpoet", "Lcom/squareup/kotlinpoet/TypeName;", "Lkotlin/reflect/KClass;", "nullable", "", "typeArguments", "", "Lkotlin/reflect/KTypeProjection;", "parameterizedBy", "Lcom/squareup/kotlinpoet/ClassName;", "", "(Lcom/squareup/kotlinpoet/ClassName;[Lcom/squareup/kotlinpoet/TypeName;)Lcom/squareup/kotlinpoet/ParameterizedTypeName;", "Ljava/lang/Class;", "(Ljava/lang/Class;[Ljava/lang/reflect/Type;)Lcom/squareup/kotlinpoet/ParameterizedTypeName;", "", "(Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;)Lcom/squareup/kotlinpoet/ParameterizedTypeName;", "plusParameter", "typeArgument", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* compiled from: ParameterizedTypeName.kt */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[KVariance.values().length];
                iArr[KVariance.INVARIANT.ordinal()] = 1;
                iArr[KVariance.IN.ordinal()] = 2;
                iArr[KVariance.OUT.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ParameterizedTypeName get(ClassName className, TypeName... typeArguments) {
            Intrinsics.checkNotNullParameter(className, "<this>");
            Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
            return new ParameterizedTypeName(null, className, ArraysKt.toList(typeArguments), false, null, null, 56, null);
        }

        @JvmStatic
        public final ParameterizedTypeName get(KClass<?> kClass, KClass<?>... typeArguments) {
            Intrinsics.checkNotNullParameter(kClass, "<this>");
            Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
            TypeName typeName = null;
            ClassName className = ClassNames.get(kClass);
            ArrayList arrayList = new ArrayList(typeArguments.length);
            for (KClass<?> kClass2 : typeArguments) {
                arrayList.add(TypeNames.get(kClass2));
            }
            return new ParameterizedTypeName(typeName, className, arrayList, false, null, null, 56, null);
        }

        @JvmStatic
        public final ParameterizedTypeName get(Class<?> cls, Type... typeArguments) {
            Intrinsics.checkNotNullParameter(cls, "<this>");
            Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
            TypeName typeName = null;
            ClassName className = ClassNames.get(cls);
            ArrayList arrayList = new ArrayList(typeArguments.length);
            for (Type type : typeArguments) {
                arrayList.add(TypeNames.get(type));
            }
            return new ParameterizedTypeName(typeName, className, arrayList, false, null, null, 56, null);
        }

        @JvmStatic
        public final ParameterizedTypeName get(ClassName className, List<? extends TypeName> typeArguments) {
            Intrinsics.checkNotNullParameter(className, "<this>");
            Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
            return new ParameterizedTypeName(null, className, typeArguments, false, null, null, 56, null);
        }

        @JvmStatic
        public final ParameterizedTypeName get(KClass<?> kClass, Iterable<? extends KClass<?>> typeArguments) {
            Intrinsics.checkNotNullParameter(kClass, "<this>");
            Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
            TypeName typeName = null;
            ClassName className = ClassNames.get(kClass);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(typeArguments, 10));
            Iterator<? extends KClass<?>> it = typeArguments.iterator();
            while (it.hasNext()) {
                arrayList.add(TypeNames.get(it.next()));
            }
            return new ParameterizedTypeName(typeName, className, arrayList, false, null, null, 56, null);
        }

        @JvmStatic
        public final ParameterizedTypeName get(Class<?> cls, Iterable<? extends Type> typeArguments) {
            Intrinsics.checkNotNullParameter(cls, "<this>");
            Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
            TypeName typeName = null;
            ClassName className = ClassNames.get(cls);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(typeArguments, 10));
            Iterator<? extends Type> it = typeArguments.iterator();
            while (it.hasNext()) {
                arrayList.add(TypeNames.get(it.next()));
            }
            return new ParameterizedTypeName(typeName, className, arrayList, false, null, null, 56, null);
        }

        @JvmStatic
        public final ParameterizedTypeName get(ClassName className, TypeName typeArgument) {
            Intrinsics.checkNotNullParameter(className, "<this>");
            Intrinsics.checkNotNullParameter(typeArgument, "typeArgument");
            return get(className, typeArgument);
        }

        @JvmStatic
        public final ParameterizedTypeName get(KClass<?> kClass, KClass<?> typeArgument) {
            Intrinsics.checkNotNullParameter(kClass, "<this>");
            Intrinsics.checkNotNullParameter(typeArgument, "typeArgument");
            return get(kClass, typeArgument);
        }

        @JvmStatic
        public final ParameterizedTypeName get(Class<?> cls, Class<?> typeArgument) {
            Intrinsics.checkNotNullParameter(cls, "<this>");
            Intrinsics.checkNotNullParameter(typeArgument, "typeArgument");
            return get(cls, typeArgument);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0058 A[LOOP:0: B:7:0x0056->B:8:0x0058, LOOP_END] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.squareup.kotlinpoet.ParameterizedTypeName get$kotlinpoet(java.lang.reflect.ParameterizedType r12, java.util.Map<java.lang.reflect.Type, com.squareup.kotlinpoet.TypeVariableName> r13) {
            /*
                r11 = this;
                java.lang.String r0 = "type"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                java.lang.String r0 = "map"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
                java.lang.reflect.Type r0 = r12.getRawType()
                java.lang.String r1 = "null cannot be cast to non-null type java.lang.Class<*>"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
                java.lang.Class r0 = (java.lang.Class) r0
                com.squareup.kotlinpoet.ClassName r4 = com.squareup.kotlinpoet.ClassNames.get(r0)
                java.lang.reflect.Type r0 = r12.getOwnerType()
                boolean r0 = r0 instanceof java.lang.reflect.ParameterizedType
                if (r0 == 0) goto L40
                java.lang.reflect.Type r0 = r12.getRawType()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
                java.lang.Class r0 = (java.lang.Class) r0
                int r0 = r0.getModifiers()
                boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
                if (r0 != 0) goto L40
                java.lang.reflect.Type r0 = r12.getOwnerType()
                java.lang.String r1 = "null cannot be cast to non-null type java.lang.reflect.ParameterizedType"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
                java.lang.reflect.ParameterizedType r0 = (java.lang.reflect.ParameterizedType) r0
                goto L41
            L40:
                r0 = 0
            L41:
                java.lang.reflect.Type[] r12 = r12.getActualTypeArguments()
                java.lang.String r1 = "type.actualTypeArguments"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r1)
                java.lang.Object[] r12 = (java.lang.Object[]) r12
                java.util.ArrayList r1 = new java.util.ArrayList
                int r2 = r12.length
                r1.<init>(r2)
                java.util.Collection r1 = (java.util.Collection) r1
                int r2 = r12.length
                r3 = 0
            L56:
                if (r3 >= r2) goto L6d
                r5 = r12[r3]
                java.lang.reflect.Type r5 = (java.lang.reflect.Type) r5
                com.squareup.kotlinpoet.TypeName$Companion r6 = com.squareup.kotlinpoet.TypeName.INSTANCE
                java.lang.String r7 = "it"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
                com.squareup.kotlinpoet.TypeName r5 = r6.get$kotlinpoet(r5, r13)
                r1.add(r5)
                int r3 = r3 + 1
                goto L56
            L6d:
                r5 = r1
                java.util.List r5 = (java.util.List) r5
                if (r0 == 0) goto L7f
                com.squareup.kotlinpoet.ParameterizedTypeName r12 = r11.get$kotlinpoet(r0, r13)
                java.lang.String r13 = r4.getSimpleName()
                com.squareup.kotlinpoet.ParameterizedTypeName r12 = r12.nestedClass(r13, r5)
                goto L8c
            L7f:
                com.squareup.kotlinpoet.ParameterizedTypeName r12 = new com.squareup.kotlinpoet.ParameterizedTypeName
                r3 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 56
                r10 = 0
                r2 = r12
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            L8c:
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.kotlinpoet.ParameterizedTypeName.Companion.get$kotlinpoet(java.lang.reflect.ParameterizedType, java.util.Map):com.squareup.kotlinpoet.ParameterizedTypeName");
        }

        public final TypeName get$kotlinpoet(KClass<?> type, boolean nullable, List<KTypeProjection> typeArguments) {
            WildcardTypeName wildcardTypeName;
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
            if (typeArguments.isEmpty()) {
                ClassName className = TypeNames.get(type);
                return nullable ? TypeName.copy$default(className, true, null, 2, null) : className;
            }
            KClass<?> orCreateKotlinClass = JvmClassMappingKt.getJavaClass((KClass) type).isArray() ? Reflection.getOrCreateKotlinClass(Unit[].class) : type;
            Class<?> enclosingClass = JvmClassMappingKt.getJavaClass((KClass) type).getEnclosingClass();
            KClass<?> kotlinClass = enclosingClass != null ? JvmClassMappingKt.getKotlinClass(enclosingClass) : null;
            TypeName typeName = kotlinClass != null ? ParameterizedTypeName.INSTANCE.get$kotlinpoet(kotlinClass, false, CollectionsKt.drop(typeArguments, orCreateKotlinClass.getTypeParameters().size())) : null;
            ClassName className2 = TypeNames.get(orCreateKotlinClass);
            List<KTypeProjection> take = CollectionsKt.take(typeArguments, orCreateKotlinClass.getTypeParameters().size());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(take, 10));
            for (KTypeProjection kTypeProjection : take) {
                KVariance variance = kTypeProjection.getVariance();
                KType type2 = kTypeProjection.getType();
                if (type2 == null || (wildcardTypeName = ParameterizedTypeNames.asTypeName(type2)) == null) {
                    wildcardTypeName = TypeNames.STAR;
                } else {
                    int i = variance == null ? -1 : WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
                    if (i == -1) {
                        wildcardTypeName = TypeNames.STAR;
                    } else if (i == 1) {
                        continue;
                    } else if (i == 2) {
                        wildcardTypeName = WildcardTypeName.INSTANCE.consumerOf(wildcardTypeName);
                    } else {
                        if (i != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        wildcardTypeName = WildcardTypeName.INSTANCE.producerOf(wildcardTypeName);
                    }
                }
                arrayList.add(wildcardTypeName);
            }
            ArrayList arrayList2 = arrayList;
            List<Annotation> annotations = orCreateKotlinClass.getAnnotations();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(annotations, 10));
            Iterator<T> it = annotations.iterator();
            while (it.hasNext()) {
                arrayList3.add(AnnotationSpec.Companion.get$default(AnnotationSpec.INSTANCE, (Annotation) it.next(), false, 2, null));
            }
            return new ParameterizedTypeName(typeName, className2, arrayList2, nullable, arrayList3, null, 32, null);
        }
    }
}
