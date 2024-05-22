package com.mrousavy.camera.extensions;

import android.graphics.Rect;
import android.util.Log;
import android.view.SurfaceHolder;
import com.onesignal.inAppMessages.internal.display.impl.WebViewManager;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: SurfaceHolder+resize.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a%\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"TAG", "", WebViewManager.EVENT_TYPE_RESIZE, "", "Landroid/view/SurfaceHolder;", Snapshot.TARGET_WIDTH, "", Snapshot.TARGET_HEIGHT, "(Landroid/view/SurfaceHolder;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-vision-camera_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SurfaceHolder_resizeKt {
    private static final String TAG = "SurfaceHolder";

    public static final Object resize(SurfaceHolder surfaceHolder, final int i, final int i2, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
        if (surfaceFrame.width() == i && surfaceFrame.height() == i2) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(Result.m1318constructorimpl(Unit.INSTANCE));
        } else {
            Log.i(TAG, "Resizing SurfaceHolder to " + i + " x " + i2 + "...");
            surfaceHolder.addCallback(new SurfaceHolder.Callback() { // from class: com.mrousavy.camera.extensions.SurfaceHolder_resizeKt$resize$2$callback$1
                @Override // android.view.SurfaceHolder.Callback
                public void surfaceCreated(SurfaceHolder holder) {
                    Intrinsics.checkNotNullParameter(holder, "holder");
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                    Intrinsics.checkNotNullParameter(holder, "holder");
                    if (width == i && height == i2) {
                        holder.removeCallback(this);
                        Log.i("SurfaceHolder", "Resized SurfaceHolder to " + width + " x " + height + "!");
                        CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl2;
                        Result.Companion companion2 = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m1318constructorimpl(Unit.INSTANCE));
                    }
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceDestroyed(SurfaceHolder holder) {
                    Intrinsics.checkNotNullParameter(holder, "holder");
                    holder.removeCallback(this);
                    Log.e("SurfaceHolder", "Failed to resize SurfaceHolder to " + i + " x " + i2 + "!");
                    cancellableContinuationImpl2.cancel(new Error("Tried to resize SurfaceView, but Surface has been destroyed!"));
                }
            });
            surfaceHolder.setFixedSize(i, i2);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}
