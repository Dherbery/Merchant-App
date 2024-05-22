package com.squareup.kotlinpoet.ksp;

import com.google.devtools.ksp.symbol.KSTypeParameter;
import com.squareup.kotlinpoet.TypeVariableName;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypeParameterResolver.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"toTypeParameterResolver", "Lcom/squareup/kotlinpoet/ksp/TypeParameterResolver;", "", "Lcom/google/devtools/ksp/symbol/KSTypeParameter;", "parent", "sourceTypeHint", "", "ksp"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class TypeParameterResolverKt {
    public static /* synthetic */ TypeParameterResolver toTypeParameterResolver$default(List list, TypeParameterResolver typeParameterResolver, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            typeParameterResolver = null;
        }
        if ((i & 2) != 0) {
            str = "<unknown>";
        }
        return toTypeParameterResolver(list, typeParameterResolver, str);
    }

    public static final TypeParameterResolver toTypeParameterResolver(List<? extends KSTypeParameter> list, final TypeParameterResolver typeParameterResolver, final String sourceTypeHint) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(sourceTypeHint, "sourceTypeHint");
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        final Function1<String, TypeVariableName> function1 = new Function1<String, TypeVariableName>() { // from class: com.squareup.kotlinpoet.ksp.TypeParameterResolverKt$toTypeParameterResolver$typeParamResolver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TypeVariableName invoke(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                TypeVariableName typeVariableName = linkedHashMap.get(id);
                if (typeVariableName == null) {
                    TypeParameterResolver typeParameterResolver2 = typeParameterResolver;
                    typeVariableName = typeParameterResolver2 != null ? typeParameterResolver2.get(id) : null;
                    if (typeVariableName == null) {
                        throw new IllegalStateException("No type argument found for " + id + "! Analyzed " + sourceTypeHint + " with known parameters " + linkedHashMap.keySet());
                    }
                }
                return typeVariableName;
            }
        };
        TypeParameterResolver typeParameterResolver2 = new TypeParameterResolver(linkedHashMap, function1) { // from class: com.squareup.kotlinpoet.ksp.TypeParameterResolverKt$toTypeParameterResolver$resolver$1
            final /* synthetic */ Function1<String, TypeVariableName> $typeParamResolver;
            private final Map<String, TypeVariableName> parametersMap;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$typeParamResolver = function1;
                this.parametersMap = linkedHashMap;
            }

            @Override // com.squareup.kotlinpoet.ksp.TypeParameterResolver
            public Map<String, TypeVariableName> getParametersMap() {
                return this.parametersMap;
            }

            @Override // com.squareup.kotlinpoet.ksp.TypeParameterResolver
            public TypeVariableName get(String index) {
                Intrinsics.checkNotNullParameter(index, "index");
                TypeVariableName invoke = this.$typeParamResolver.invoke(index);
                Intrinsics.checkNotNullExpressionValue(invoke, "typeParamResolver(index)");
                return invoke;
            }
        };
        Iterator<? extends KSTypeParameter> it = list.iterator();
        while (it.hasNext()) {
            String shortName = it.next().getName().getShortName();
            linkedHashMap.put(shortName, TypeVariableName.Companion.get$default(TypeVariableName.INSTANCE, shortName, null, 2, null));
        }
        for (KSTypeParameter kSTypeParameter : list) {
            linkedHashMap.put(kSTypeParameter.getName().getShortName(), KsTypesKt.toTypeVariableName(kSTypeParameter, typeParameterResolver2));
        }
        return typeParameterResolver2;
    }
}
