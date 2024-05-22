package com.squareup.kotlinpoet;

import com.amazon.a.a.o.b;
import com.squareup.kotlinpoet.TypeVariableName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;

/* compiled from: TypeVariableName.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¢\u0006\u0002\b\u0003\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0007¢\u0006\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0005¨\u0006\u0006"}, d2 = {"asTypeVariableName", "Lcom/squareup/kotlinpoet/TypeVariableName;", "Ljavax/lang/model/element/TypeParameterElement;", b.ar, "Ljavax/lang/model/type/TypeVariable;", "Lkotlin/reflect/KTypeParameter;", "kotlinpoet"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class TypeVariableNames {

    /* compiled from: TypeVariableName.kt */
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

    public static final TypeVariableName get(TypeVariable typeVariable) {
        Intrinsics.checkNotNullParameter(typeVariable, "<this>");
        TypeParameterElement asElement = typeVariable.asElement();
        Intrinsics.checkNotNull(asElement, "null cannot be cast to non-null type javax.lang.model.element.TypeParameterElement");
        return get(asElement);
    }

    public static final TypeVariableName get(TypeParameterElement typeParameterElement) {
        Intrinsics.checkNotNullParameter(typeParameterElement, "<this>");
        String obj = typeParameterElement.getSimpleName().toString();
        List bounds = typeParameterElement.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
        List list = bounds;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(TypeNames.get((TypeMirror) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        TypeVariableName.Companion companion = TypeVariableName.INSTANCE;
        if (arrayList2.isEmpty()) {
            arrayList2 = companion.getNULLABLE_ANY_LIST$kotlinpoet();
        }
        return TypeVariableName.INSTANCE.of$kotlinpoet(obj, arrayList2, null);
    }

    public static final TypeVariableName asTypeVariableName(KTypeParameter kTypeParameter) {
        KModifier kModifier;
        Intrinsics.checkNotNullParameter(kTypeParameter, "<this>");
        TypeVariableName.Companion companion = TypeVariableName.INSTANCE;
        String name = kTypeParameter.getName();
        List<KType> upperBounds = kTypeParameter.getUpperBounds();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(ParameterizedTypeNames.asTypeName((KType) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        TypeVariableName.Companion companion2 = TypeVariableName.INSTANCE;
        if (arrayList2.isEmpty()) {
            arrayList2 = companion2.getNULLABLE_ANY_LIST$kotlinpoet();
        }
        List<TypeName> list = arrayList2;
        int i = WhenMappings.$EnumSwitchMapping$0[kTypeParameter.getVariance().ordinal()];
        if (i == 1) {
            kModifier = null;
        } else if (i == 2) {
            kModifier = KModifier.IN;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            kModifier = KModifier.OUT;
        }
        return companion.of$kotlinpoet(name, list, kModifier);
    }
}
