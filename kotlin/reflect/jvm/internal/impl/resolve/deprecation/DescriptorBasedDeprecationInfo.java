package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

/* compiled from: DescriptorBasedDeprecationInfo.kt */
/* loaded from: classes6.dex */
public abstract class DescriptorBasedDeprecationInfo extends DeprecationInfo {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationInfo
    public boolean getPropagatesToOverrides() {
        return true;
    }
}
