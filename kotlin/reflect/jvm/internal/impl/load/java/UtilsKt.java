package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: utils.kt */
/* loaded from: classes6.dex */
public final class UtilsKt {
    public static final DescriptorVisibility toDescriptorVisibility(Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "<this>");
        DescriptorVisibility descriptorVisibility = JavaDescriptorVisibilities.toDescriptorVisibility(visibility);
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "toDescriptorVisibility(this)");
        return descriptorVisibility;
    }

    public static final boolean isJspecifyEnabledInStrictMode(JavaTypeEnhancementState javaTypeEnhancementState) {
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        return javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(JavaNullabilityAnnotationSettingsKt.getJSPECIFY_ANNOTATIONS_PACKAGE()) == ReportLevel.STRICT;
    }

    public static final boolean hasErasedValueParameters(CallableMemberDescriptor memberDescriptor) {
        Intrinsics.checkNotNullParameter(memberDescriptor, "memberDescriptor");
        return (memberDescriptor instanceof FunctionDescriptor) && Intrinsics.areEqual(memberDescriptor.getUserData(JavaMethodDescriptor.HAS_ERASED_VALUE_PARAMETERS), (Object) true);
    }

    public static final AnnotationDescriptor extractNullabilityAnnotationOnBoundedWildcard(LazyJavaResolverContext c, JavaWildcardType wildcardType) {
        AnnotationDescriptor annotationDescriptor;
        boolean z;
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(wildcardType, "wildcardType");
        if (!(wildcardType.getBound() != null)) {
            throw new IllegalArgumentException("Nullability annotations on unbounded wildcards aren't supported".toString());
        }
        Iterator<AnnotationDescriptor> it = new LazyJavaAnnotations(c, wildcardType, false, 4, null).iterator();
        while (true) {
            if (!it.hasNext()) {
                annotationDescriptor = null;
                break;
            }
            annotationDescriptor = it.next();
            AnnotationDescriptor annotationDescriptor2 = annotationDescriptor;
            FqName[] rxjava3_annotations = JavaNullabilityAnnotationSettingsKt.getRXJAVA3_ANNOTATIONS();
            int length = rxjava3_annotations.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                }
                if (Intrinsics.areEqual(annotationDescriptor2.getFqName(), rxjava3_annotations[i])) {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                break;
            }
        }
        return annotationDescriptor;
    }
}
