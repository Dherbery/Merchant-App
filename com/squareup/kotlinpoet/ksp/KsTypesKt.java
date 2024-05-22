package com.squareup.kotlinpoet.ksp;

import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.google.devtools.ksp.symbol.KSDeclaration;
import com.google.devtools.ksp.symbol.KSReferenceElement;
import com.google.devtools.ksp.symbol.KSType;
import com.google.devtools.ksp.symbol.KSTypeAlias;
import com.google.devtools.ksp.symbol.KSTypeArgument;
import com.google.devtools.ksp.symbol.KSTypeParameter;
import com.google.devtools.ksp.symbol.KSTypeReference;
import com.google.devtools.ksp.symbol.Variance;
import com.squareup.kotlinpoet.ClassName;
import com.squareup.kotlinpoet.KModifier;
import com.squareup.kotlinpoet.TypeName;
import com.squareup.kotlinpoet.TypeNames;
import com.squareup.kotlinpoet.TypeVariableName;
import com.squareup.kotlinpoet.WildcardTypeName;
import com.squareup.kotlinpoet.tags.TypeAliasTag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt;

/* compiled from: ksTypes.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0007\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r\u001a\"\u0010\n\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0014\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010\f\u001a\u00020\r¨\u0006\u0013"}, d2 = {"mapTypeArgumentsFromTypeAliasToAbbreviatedType", "", "Lcom/google/devtools/ksp/symbol/KSTypeArgument;", "typeAlias", "Lcom/google/devtools/ksp/symbol/KSTypeAlias;", "typeAliasTypeArguments", "abbreviatedType", "Lcom/google/devtools/ksp/symbol/KSType;", "toClassName", "Lcom/squareup/kotlinpoet/ClassName;", "toTypeName", "Lcom/squareup/kotlinpoet/TypeName;", "typeParamResolver", "Lcom/squareup/kotlinpoet/ksp/TypeParameterResolver;", "typeArguments", "Lcom/google/devtools/ksp/symbol/KSTypeReference;", "toTypeVariableName", "Lcom/squareup/kotlinpoet/TypeVariableName;", "Lcom/google/devtools/ksp/symbol/KSTypeParameter;", "ksp"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class KsTypesKt {

    /* compiled from: ksTypes.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            iArr[Variance.COVARIANT.ordinal()] = 1;
            iArr[Variance.CONTRAVARIANT.ordinal()] = 2;
            iArr[Variance.STAR.ordinal()] = 3;
            iArr[Variance.INVARIANT.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final ClassName toClassName(KSType kSType) {
        Intrinsics.checkNotNullParameter(kSType, "<this>");
        KSDeclaration declaration = kSType.getDeclaration();
        if (!(declaration instanceof KSClassDeclaration)) {
            throw new IllegalStateException(("Declaration was not a KSClassDeclaration: " + kSType).toString());
        }
        return KsClassDeclarationsKt.toClassName((KSClassDeclaration) declaration);
    }

    public static /* synthetic */ TypeName toTypeName$default(KSType kSType, TypeParameterResolver typeParameterResolver, int i, Object obj) {
        if ((i & 1) != 0) {
            typeParameterResolver = TypeParameterResolver.INSTANCE.getEMPTY();
        }
        return toTypeName(kSType, typeParameterResolver);
    }

    public static final TypeName toTypeName(KSType kSType, TypeParameterResolver typeParamResolver) {
        Intrinsics.checkNotNullParameter(kSType, "<this>");
        Intrinsics.checkNotNullParameter(typeParamResolver, "typeParamResolver");
        return toTypeName(kSType, typeParamResolver, CollectionsKt.emptyList());
    }

    public static final TypeName toTypeName(KSType kSType, TypeParameterResolver typeParamResolver, List<? extends KSTypeArgument> typeArguments) {
        KSType resolve;
        TypeParameterResolver typeParameterResolver$default;
        TypeVariableName copy$default;
        Intrinsics.checkNotNullParameter(kSType, "<this>");
        Intrinsics.checkNotNullParameter(typeParamResolver, "typeParamResolver");
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        if (!(!kSType.isError())) {
            throw new IllegalArgumentException(("Error type '" + kSType + "' is not resolvable in the current round of processing.").toString());
        }
        KSDeclaration declaration = kSType.getDeclaration();
        if (declaration instanceof KSClassDeclaration) {
            ClassName className = KsClassDeclarationsKt.toClassName((KSClassDeclaration) declaration);
            List<KSTypeArgument> arguments = kSType.getArguments();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments, 10));
            Iterator<T> it = arguments.iterator();
            while (it.hasNext()) {
                arrayList.add(toTypeName((KSTypeArgument) it.next(), typeParamResolver));
            }
            copy$default = UtilsKt.withTypeArguments(className, arrayList);
        } else if (declaration instanceof KSTypeParameter) {
            copy$default = typeParamResolver.get(((KSTypeParameter) declaration).getName().getShortName());
        } else if (declaration instanceof KSTypeAlias) {
            KSTypeAlias kSTypeAlias = (KSTypeAlias) declaration;
            List<KSTypeArgument> arguments2 = kSType.getArguments();
            while (true) {
                resolve = kSTypeAlias.getType().resolve();
                arguments2 = mapTypeArgumentsFromTypeAliasToAbbreviatedType(kSTypeAlias, arguments2, resolve);
                typeParameterResolver$default = kSTypeAlias.getTypeParameters().isEmpty() ? typeParamResolver : TypeParameterResolverKt.toTypeParameterResolver$default(kSTypeAlias.getTypeParameters(), typeParamResolver, null, 2, null);
                KSDeclaration declaration2 = resolve.getDeclaration();
                KSTypeAlias kSTypeAlias2 = declaration2 instanceof KSTypeAlias ? (KSTypeAlias) declaration2 : null;
                if (kSTypeAlias2 == null) {
                    break;
                }
                kSTypeAlias = kSTypeAlias2;
            }
            ClassName rawType = UtilsKt.rawType(TypeName.copy$default(toTypeName(resolve, typeParameterResolver$default), kSType.isMarkedNullable(), null, 2, null));
            List<KSTypeArgument> list = arguments2;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(toTypeName((KSTypeArgument) it2.next(), typeParamResolver));
            }
            TypeName withTypeArguments = UtilsKt.withTypeArguments(rawType, arrayList2);
            List<? extends KSTypeArgument> list2 = typeArguments;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it3 = list2.iterator();
            while (it3.hasNext()) {
                arrayList3.add(toTypeName((KSTypeArgument) it3.next(), typeParamResolver));
            }
            copy$default = TypeName.copy$default(UtilsKt.withTypeArguments(UtilsKt.toClassNameInternal(declaration), arrayList3), false, null, MapsKt.mapOf(TuplesKt.to(Reflection.getOrCreateKotlinClass(TypeAliasTag.class), new TypeAliasTag(withTypeArguments))), 3, null);
        } else {
            throw new IllegalStateException(("Unsupported type: " + kSType.getDeclaration()).toString());
        }
        return TypeName.copy$default(copy$default, kSType.isMarkedNullable(), null, 2, null);
    }

    private static final List<KSTypeArgument> mapTypeArgumentsFromTypeAliasToAbbreviatedType(KSTypeAlias kSTypeAlias, List<? extends KSTypeArgument> list, KSType kSType) {
        List<KSTypeArgument> arguments = kSType.getArguments();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments, 10));
        for (KSTypeArgument kSTypeArgument : arguments) {
            Iterator<KSTypeParameter> it = kSTypeAlias.getTypeParameters().iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                if (Intrinsics.areEqual(it.next().getName().asString(), String.valueOf(kSTypeArgument.getType()))) {
                    break;
                }
                i++;
            }
            if (i >= 0) {
                kSTypeArgument = list.get(i);
            }
            arrayList.add(kSTypeArgument);
        }
        return arrayList;
    }

    public static /* synthetic */ TypeVariableName toTypeVariableName$default(KSTypeParameter kSTypeParameter, TypeParameterResolver typeParameterResolver, int i, Object obj) {
        if ((i & 1) != 0) {
            typeParameterResolver = TypeParameterResolver.INSTANCE.getEMPTY();
        }
        return toTypeVariableName(kSTypeParameter, typeParameterResolver);
    }

    public static final TypeVariableName toTypeVariableName(KSTypeParameter kSTypeParameter, final TypeParameterResolver typeParamResolver) {
        KModifier kModifier;
        Intrinsics.checkNotNullParameter(kSTypeParameter, "<this>");
        Intrinsics.checkNotNullParameter(typeParamResolver, "typeParamResolver");
        String shortName = kSTypeParameter.getName().getShortName();
        List<? extends TypeName> list = SequencesKt.toList(SequencesKt.map(kSTypeParameter.getBounds(), new Function1<KSTypeReference, TypeName>() { // from class: com.squareup.kotlinpoet.ksp.KsTypesKt$toTypeVariableName$typeVarBounds$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TypeName invoke(KSTypeReference it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return KsTypesKt.toTypeName(it, TypeParameterResolver.this);
            }
        }));
        int i = WhenMappings.$EnumSwitchMapping$0[kSTypeParameter.getVariance().ordinal()];
        if (i == 1) {
            kModifier = KModifier.OUT;
        } else {
            kModifier = i != 2 ? null : KModifier.IN;
        }
        return TypeVariableName.INSTANCE.get(shortName, list, kModifier);
    }

    public static /* synthetic */ TypeName toTypeName$default(KSTypeArgument kSTypeArgument, TypeParameterResolver typeParameterResolver, int i, Object obj) {
        if ((i & 1) != 0) {
            typeParameterResolver = TypeParameterResolver.INSTANCE.getEMPTY();
        }
        return toTypeName(kSTypeArgument, typeParameterResolver);
    }

    public static final TypeName toTypeName(KSTypeArgument kSTypeArgument, TypeParameterResolver typeParamResolver) {
        TypeName typeName;
        Intrinsics.checkNotNullParameter(kSTypeArgument, "<this>");
        Intrinsics.checkNotNullParameter(typeParamResolver, "typeParamResolver");
        KSTypeReference type = kSTypeArgument.getType();
        if (type == null || (typeName = toTypeName(type, typeParamResolver)) == null) {
            return TypeNames.STAR;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[kSTypeArgument.getVariance().ordinal()];
        if (i == 1) {
            return WildcardTypeName.INSTANCE.producerOf(typeName);
        }
        if (i == 2) {
            return WildcardTypeName.INSTANCE.consumerOf(typeName);
        }
        if (i == 3) {
            return TypeNames.STAR;
        }
        if (i == 4) {
            return typeName;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ TypeName toTypeName$default(KSTypeReference kSTypeReference, TypeParameterResolver typeParameterResolver, int i, Object obj) {
        if ((i & 1) != 0) {
            typeParameterResolver = TypeParameterResolver.INSTANCE.getEMPTY();
        }
        return toTypeName(kSTypeReference, typeParameterResolver);
    }

    public static final TypeName toTypeName(KSTypeReference kSTypeReference, TypeParameterResolver typeParamResolver) {
        Intrinsics.checkNotNullParameter(kSTypeReference, "<this>");
        Intrinsics.checkNotNullParameter(typeParamResolver, "typeParamResolver");
        KSType resolve = kSTypeReference.resolve();
        KSReferenceElement element = kSTypeReference.getElement();
        List<KSTypeArgument> typeArguments = element != null ? element.getTypeArguments() : null;
        if (typeArguments == null) {
            typeArguments = CollectionsKt.emptyList();
        }
        return toTypeName(resolve, typeParamResolver, typeArguments);
    }
}
