package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.exception.UnexpectedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JavaCallback.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0004J\t\u0010\b\u001a\u00020\u0006H\u0082 J\u0011\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0082 J\u0011\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000bH\u0082 J\u0013\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0086\u0002J\u0011\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\rH\u0082 J\u0011\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000eH\u0082 J\u0011\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000fH\u0082 J\u0011\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0010H\u0082 J\u0011\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0011H\u0082 R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/kotlin/jni/JavaCallback;", "Lexpo/modules/kotlin/jni/Destructible;", "mHybridData", "Lcom/facebook/jni/HybridData;", "(Lcom/facebook/jni/HybridData;)V", "deallocate", "", "finalize", "invoke", "result", "Lcom/facebook/react/bridge/WritableNativeArray;", "Lcom/facebook/react/bridge/WritableNativeMap;", "", "", "", "", "", "", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JavaCallback implements Destructible {
    private final HybridData mHybridData;

    private final native void invoke();

    private final native void invoke(double result);

    private final native void invoke(float result);

    private final native void invoke(int result);

    private final native void invoke(WritableNativeArray result);

    private final native void invoke(WritableNativeMap result);

    private final native void invoke(String result);

    private final native void invoke(boolean result);

    public JavaCallback(HybridData mHybridData) {
        Intrinsics.checkNotNullParameter(mHybridData, "mHybridData");
        this.mHybridData = mHybridData;
    }

    public final void invoke(Object result) {
        try {
            if (result == null) {
                invoke();
                return;
            }
            if (result instanceof Integer) {
                invoke(((Number) result).intValue());
                return;
            }
            if (result instanceof Boolean) {
                invoke(((Boolean) result).booleanValue());
                return;
            }
            if (result instanceof Double) {
                invoke(((Number) result).doubleValue());
                return;
            }
            if (result instanceof Float) {
                invoke(((Number) result).floatValue());
                return;
            }
            if (result instanceof String) {
                invoke((String) result);
                return;
            }
            if (result instanceof WritableNativeArray) {
                invoke((WritableNativeArray) result);
            } else {
                if (result instanceof WritableNativeMap) {
                    invoke((WritableNativeMap) result);
                    return;
                }
                throw new UnexpectedException("Unknown type: " + result.getClass());
            }
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    protected final void finalize() throws Throwable {
        deallocate();
    }

    @Override // expo.modules.kotlin.jni.Destructible
    public void deallocate() {
        this.mHybridData.resetNative();
    }
}
