package com.squareup.kotlinpoet;

import com.amazon.a.a.o.b;
import java.util.ArrayList;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.NestingKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* compiled from: ClassName.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0007¢\u0006\u0002\b\u0003\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0007¢\u0006\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0005H\u0007¢\u0006\u0002\b\u0003¨\u0006\u0006"}, d2 = {"asClassName", "Lcom/squareup/kotlinpoet/ClassName;", "Ljava/lang/Class;", b.ar, "Ljavax/lang/model/element/TypeElement;", "Lkotlin/reflect/KClass;", "kotlinpoet"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassNames {
    public static final ClassName get(Class<?> cls) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(cls, "<this>");
        if (!(!cls.isPrimitive())) {
            throw new IllegalArgumentException("primitive types cannot be represented as a ClassName".toString());
        }
        if (!(!Intrinsics.areEqual(Void.TYPE, cls))) {
            throw new IllegalArgumentException("'void' type cannot be represented as a ClassName".toString());
        }
        if (!(!cls.isArray())) {
            throw new IllegalArgumentException("array types cannot be represented as a ClassName".toString());
        }
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            arrayList = arrayList2;
            arrayList.add(cls.getSimpleName());
            Class<?> enclosingClass = cls.getEnclosingClass();
            if (enclosingClass == null) {
                break;
            }
            cls = enclosingClass;
        }
        String name = cls.getName();
        Intrinsics.checkNotNullExpressionValue(name, "c.name");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) name, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default != -1) {
            String name2 = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "c.name");
            String substring = name2.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(substring);
        }
        CollectionsKt.reverse(arrayList2);
        return new ClassName(arrayList2, false, null, null, 14, null);
    }

    public static final ClassName get(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        String qualifiedName = kClass.getQualifiedName();
        if (qualifiedName != null) {
            return ClassName.INSTANCE.bestGuess(qualifiedName);
        }
        throw new IllegalArgumentException(kClass + " cannot be represented as a ClassName");
    }

    private static final boolean asClassName$isClassOrInterface(Element element) {
        return element.getKind().isClass() || element.getKind().isInterface();
    }

    private static final PackageElement asClassName$getPackage(Element element) {
        while (element.getKind() != ElementKind.PACKAGE) {
            element = element.getEnclosingElement();
            Intrinsics.checkNotNullExpressionValue(element, "t.enclosingElement");
        }
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type javax.lang.model.element.PackageElement");
        return (PackageElement) element;
    }

    public static final ClassName get(TypeElement typeElement) {
        boolean isOneOf;
        Intrinsics.checkNotNullParameter(typeElement, "<this>");
        ArrayList arrayList = new ArrayList();
        Element element = (Element) typeElement;
        Element element2 = element;
        while (asClassName$isClassOrInterface(element2)) {
            TypeElement typeElement2 = (TypeElement) element2;
            isOneOf = UtilKt.isOneOf(typeElement2.getNestingKind(), NestingKind.TOP_LEVEL, NestingKind.MEMBER, (r16 & 4) != 0 ? null : null, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? null : null);
            if (!isOneOf) {
                throw new IllegalArgumentException("unexpected type testing".toString());
            }
            arrayList.add(typeElement2.getSimpleName().toString());
            element2 = typeElement2.getEnclosingElement();
            Intrinsics.checkNotNullExpressionValue(element2, "eType.enclosingElement");
        }
        arrayList.add(asClassName$getPackage(element).getQualifiedName().toString());
        CollectionsKt.reverse(arrayList);
        return new ClassName(arrayList, false, null, null, 14, null);
    }
}
