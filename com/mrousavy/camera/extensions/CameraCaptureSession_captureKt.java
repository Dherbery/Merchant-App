package com.mrousavy.camera.extensions;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.media.MediaActionSound;
import com.mrousavy.camera.core.CaptureAbortedError;
import com.mrousavy.camera.core.UnknownCaptureError;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: CameraCaptureSession+capture.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a%\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"TAG", "", "capture", "Landroid/hardware/camera2/TotalCaptureResult;", "Landroid/hardware/camera2/CameraCaptureSession;", "captureRequest", "Landroid/hardware/camera2/CaptureRequest;", "enableShutterSound", "", "(Landroid/hardware/camera2/CameraCaptureSession;Landroid/hardware/camera2/CaptureRequest;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-vision-camera_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraCaptureSession_captureKt {
    private static final String TAG = "CameraCaptureSession";

    public static final Object capture(CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final boolean z, Continuation<? super TotalCaptureResult> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final MediaActionSound mediaActionSound = z ? new MediaActionSound() : null;
        if (mediaActionSound != null) {
            mediaActionSound.load(0);
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new CameraCaptureSession_captureKt$capture$2$1(cancellableContinuationImpl2, cameraCaptureSession, null), 3, null);
        cameraCaptureSession.capture(captureRequest, new CameraCaptureSession.CaptureCallback() { // from class: com.mrousavy.camera.extensions.CameraCaptureSession_captureKt$capture$2$2
            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureCompleted(CameraCaptureSession session, CaptureRequest request, TotalCaptureResult result) {
                Intrinsics.checkNotNullParameter(session, "session");
                Intrinsics.checkNotNullParameter(request, "request");
                Intrinsics.checkNotNullParameter(result, "result");
                super.onCaptureCompleted(session, request, result);
                if (Intrinsics.areEqual(request, captureRequest)) {
                    CancellableContinuation<TotalCaptureResult> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m1318constructorimpl(result));
                    MediaActionSound mediaActionSound2 = mediaActionSound;
                    if (mediaActionSound2 != null) {
                        mediaActionSound2.release();
                    }
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureStarted(CameraCaptureSession session, CaptureRequest request, long timestamp, long frameNumber) {
                MediaActionSound mediaActionSound2;
                Intrinsics.checkNotNullParameter(session, "session");
                Intrinsics.checkNotNullParameter(request, "request");
                super.onCaptureStarted(session, request, timestamp, frameNumber);
                if (Intrinsics.areEqual(request, captureRequest) && z && (mediaActionSound2 = mediaActionSound) != null) {
                    mediaActionSound2.play(0);
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureFailed(CameraCaptureSession session, CaptureRequest request, CaptureFailure failure) {
                UnknownCaptureError unknownCaptureError;
                Intrinsics.checkNotNullParameter(session, "session");
                Intrinsics.checkNotNullParameter(request, "request");
                Intrinsics.checkNotNullParameter(failure, "failure");
                super.onCaptureFailed(session, request, failure);
                if (Intrinsics.areEqual(request, captureRequest)) {
                    boolean wasImageCaptured = failure.wasImageCaptured();
                    int reason = failure.getReason();
                    if (reason == 0) {
                        unknownCaptureError = new UnknownCaptureError(wasImageCaptured);
                    } else if (reason == 1) {
                        unknownCaptureError = new CaptureAbortedError(wasImageCaptured);
                    } else {
                        unknownCaptureError = new UnknownCaptureError(wasImageCaptured);
                    }
                    CancellableContinuation<TotalCaptureResult> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m1318constructorimpl(ResultKt.createFailure(unknownCaptureError)));
                }
            }
        }, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
