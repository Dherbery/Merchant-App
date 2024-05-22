package com.squareup.kotlinpoet;

import androidx.webkit.ProxyConfig;
import com.amazon.a.a.o.b;
import com.squareup.kotlinpoet.TypeName;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.WildcardType;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: WildcardTypeName.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016BW\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\u0010\rJ6\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0016\u0010\t\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\f0\nH\u0016J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0010¢\u0006\u0002\b\u0015R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/squareup/kotlinpoet/WildcardTypeName;", "Lcom/squareup/kotlinpoet/TypeName;", "outTypes", "", "inTypes", "nullable", "", "annotations", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "tags", "", "Lkotlin/reflect/KClass;", "", "(Ljava/util/List;Ljava/util/List;ZLjava/util/List;Ljava/util/Map;)V", "getInTypes", "()Ljava/util/List;", "getOutTypes", "copy", "emit", "Lcom/squareup/kotlinpoet/CodeWriter;", "out", "emit$kotlinpoet", "Companion", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class WildcardTypeName extends TypeName {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<TypeName> inTypes;
    private final List<TypeName> outTypes;

    @JvmStatic
    public static final WildcardTypeName consumerOf(TypeName typeName) {
        return INSTANCE.consumerOf(typeName);
    }

    @JvmStatic
    public static final WildcardTypeName consumerOf(Type type) {
        return INSTANCE.consumerOf(type);
    }

    @JvmStatic
    public static final WildcardTypeName consumerOf(KClass<?> kClass) {
        return INSTANCE.consumerOf(kClass);
    }

    @JvmStatic
    public static final WildcardTypeName producerOf(TypeName typeName) {
        return INSTANCE.producerOf(typeName);
    }

    @JvmStatic
    public static final WildcardTypeName producerOf(Type type) {
        return INSTANCE.producerOf(type);
    }

    @JvmStatic
    public static final WildcardTypeName producerOf(KClass<?> kClass) {
        return INSTANCE.producerOf(kClass);
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public /* bridge */ /* synthetic */ TypeName copy(boolean z, List list, Map map) {
        return copy(z, (List<AnnotationSpec>) list, (Map<KClass<?>, ? extends Object>) map);
    }

    /* synthetic */ WildcardTypeName(List list, List list2, boolean z, List list3, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? CollectionsKt.emptyList() : list3, (i & 16) != 0 ? MapsKt.emptyMap() : map);
    }

    private WildcardTypeName(List<? extends TypeName> list, List<? extends TypeName> list2, boolean z, List<AnnotationSpec> list3, Map<KClass<?>, ? extends Object> map) {
        super(z, list3, new TagMap(map), null);
        List<TypeName> immutableList = UtilKt.toImmutableList(list);
        this.outTypes = immutableList;
        this.inTypes = UtilKt.toImmutableList(list2);
        if (immutableList.size() == 1) {
            return;
        }
        throw new IllegalArgumentException(("unexpected out types: " + list).toString());
    }

    public final List<TypeName> getOutTypes() {
        return this.outTypes;
    }

    public final List<TypeName> getInTypes() {
        return this.inTypes;
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public WildcardTypeName copy(boolean nullable, List<AnnotationSpec> annotations, Map<KClass<?>, ? extends Object> tags) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(tags, "tags");
        return new WildcardTypeName(this.outTypes, this.inTypes, nullable, annotations, tags);
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public CodeWriter emit$kotlinpoet(CodeWriter out) {
        Intrinsics.checkNotNullParameter(out, "out");
        return this.inTypes.size() == 1 ? out.emitCode("in·%T", this.inTypes.get(0)) : Intrinsics.areEqual(this.outTypes, TypeNames.STAR.outTypes) ? CodeWriter.emit$default(out, ProxyConfig.MATCH_ALL_SCHEMES, false, 2, null) : out.emitCode("out·%T", this.outTypes.get(0));
    }

    /* compiled from: WildcardTypeName.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0007J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\bH\u0007J)\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\rH\u0000¢\u0006\u0002\b\u000fJ)\u0010\t\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\u0013H\u0000¢\u0006\u0002\b\u000fJ\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0006H\u0007J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0007H\u0007J\u0014\u0010\u0015\u001a\u00020\u00042\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\bH\u0007¨\u0006\u0017"}, d2 = {"Lcom/squareup/kotlinpoet/WildcardTypeName$Companion;", "", "()V", "consumerOf", "Lcom/squareup/kotlinpoet/WildcardTypeName;", "inType", "Lcom/squareup/kotlinpoet/TypeName;", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KClass;", b.ar, "wildcardName", "Ljava/lang/reflect/WildcardType;", "map", "", "Lcom/squareup/kotlinpoet/TypeVariableName;", "get$kotlinpoet", "mirror", "Ljavax/lang/model/type/WildcardType;", "typeVariables", "", "Ljavax/lang/model/element/TypeParameterElement;", "producerOf", "outType", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final WildcardTypeName producerOf(TypeName outType) {
            Intrinsics.checkNotNullParameter(outType, "outType");
            return new WildcardTypeName(CollectionsKt.listOf(outType), CollectionsKt.emptyList(), false, null, null, 28, null);
        }

        @JvmStatic
        public final WildcardTypeName producerOf(Type outType) {
            Intrinsics.checkNotNullParameter(outType, "outType");
            return producerOf(TypeNames.get(outType));
        }

        @JvmStatic
        public final WildcardTypeName producerOf(KClass<?> outType) {
            Intrinsics.checkNotNullParameter(outType, "outType");
            return producerOf(TypeNames.get(outType));
        }

        @JvmStatic
        public final WildcardTypeName consumerOf(TypeName inType) {
            Intrinsics.checkNotNullParameter(inType, "inType");
            return new WildcardTypeName(CollectionsKt.listOf(TypeNames.ANY), CollectionsKt.listOf(inType), false, null, null, 28, null);
        }

        @JvmStatic
        public final WildcardTypeName consumerOf(Type inType) {
            Intrinsics.checkNotNullParameter(inType, "inType");
            return consumerOf(TypeNames.get(inType));
        }

        @JvmStatic
        public final WildcardTypeName consumerOf(KClass<?> inType) {
            Intrinsics.checkNotNullParameter(inType, "inType");
            return consumerOf(TypeNames.get(inType));
        }

        public final TypeName get$kotlinpoet(WildcardType mirror, Map<TypeParameterElement, TypeVariableName> typeVariables) {
            WildcardTypeName consumerOf;
            Intrinsics.checkNotNullParameter(mirror, "mirror");
            Intrinsics.checkNotNullParameter(typeVariables, "typeVariables");
            TypeMirror extendsBound = mirror.getExtendsBound();
            if (extendsBound == null) {
                TypeMirror superBound = mirror.getSuperBound();
                if (superBound == null) {
                    consumerOf = TypeNames.STAR;
                } else {
                    consumerOf = consumerOf(TypeName.INSTANCE.get$kotlinpoet(superBound, typeVariables));
                }
                return consumerOf;
            }
            return producerOf(TypeName.INSTANCE.get$kotlinpoet(extendsBound, typeVariables));
        }

        public final TypeName get$kotlinpoet(java.lang.reflect.WildcardType wildcardName, Map<Type, TypeVariableName> map) {
            Intrinsics.checkNotNullParameter(wildcardName, "wildcardName");
            Intrinsics.checkNotNullParameter(map, "map");
            Type[] upperBounds = wildcardName.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds, "wildcardName.upperBounds");
            Type[] typeArr = upperBounds;
            ArrayList arrayList = new ArrayList(typeArr.length);
            for (Type it : typeArr) {
                TypeName.Companion companion = TypeName.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(companion.get$kotlinpoet(it, map));
            }
            ArrayList arrayList2 = arrayList;
            Type[] lowerBounds = wildcardName.getLowerBounds();
            Intrinsics.checkNotNullExpressionValue(lowerBounds, "wildcardName.lowerBounds");
            Type[] typeArr2 = lowerBounds;
            ArrayList arrayList3 = new ArrayList(typeArr2.length);
            for (Type it2 : typeArr2) {
                TypeName.Companion companion2 = TypeName.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                arrayList3.add(companion2.get$kotlinpoet(it2, map));
            }
            return new WildcardTypeName(arrayList2, arrayList3, false, null, null, 28, null);
        }
    }
}
