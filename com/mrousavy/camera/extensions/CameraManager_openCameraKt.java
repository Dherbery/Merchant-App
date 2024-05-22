package com.mrousavy.camera.extensions;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.util.Log;
import com.mrousavy.camera.core.CameraCannotBeOpenedError;
import com.mrousavy.camera.core.CameraDisconnectedError;
import com.mrousavy.camera.core.CameraQueues;
import com.mrousavy.camera.types.CameraDeviceError;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: CameraManager+openCamera.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a_\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000128\u0010\u0006\u001a4\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"TAG", "", "openCamera", "Landroid/hardware/camera2/CameraDevice;", "Landroid/hardware/camera2/CameraManager;", "cameraId", "onDisconnected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "camera", "", "error", "", "queue", "Lcom/mrousavy/camera/core/CameraQueues$CameraQueue;", "(Landroid/hardware/camera2/CameraManager;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lcom/mrousavy/camera/core/CameraQueues$CameraQueue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-vision-camera_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraManager_openCameraKt {
    private static final String TAG = "CameraManager";

    public static final Object openCamera(CameraManager cameraManager, final String str, final Function2<? super CameraDevice, ? super Throwable, Unit> function2, CameraQueues.CameraQueue cameraQueue, Continuation<? super CameraDevice> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        Log.i(TAG, "Camera #" + str + ": Opening...");
        CameraDevice.StateCallback stateCallback = new CameraDevice.StateCallback() { // from class: com.mrousavy.camera.extensions.CameraManager_openCameraKt$openCamera$2$callback$1
            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onOpened(CameraDevice camera) {
                Intrinsics.checkNotNullParameter(camera, "camera");
                Log.i("CameraManager", "Camera #" + str + ": Opened!");
                CancellableContinuation<CameraDevice> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m1318constructorimpl(camera));
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onDisconnected(CameraDevice camera) {
                Intrinsics.checkNotNullParameter(camera, "camera");
                Log.i("CameraManager", "Camera #" + str + ": Disconnected!");
                if (cancellableContinuationImpl2.isActive()) {
                    CancellableContinuation<CameraDevice> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m1318constructorimpl(ResultKt.createFailure(new CameraCannotBeOpenedError(str, CameraDeviceError.DISCONNECTED))));
                } else {
                    function2.invoke(camera, null);
                }
                camera.close();
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onError(CameraDevice camera, int errorCode) {
                Intrinsics.checkNotNullParameter(camera, "camera");
                Log.e("CameraManager", "Camera #" + str + ": Error! " + errorCode);
                CameraDeviceError fromCameraDeviceError = CameraDeviceError.INSTANCE.fromCameraDeviceError(errorCode);
                if (cancellableContinuationImpl2.isActive()) {
                    CancellableContinuation<CameraDevice> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m1318constructorimpl(ResultKt.createFailure(new CameraCannotBeOpenedError(str, fromCameraDeviceError))));
                } else {
                    function2.invoke(camera, new CameraDisconnectedError(str, fromCameraDeviceError));
                }
                camera.close();
            }
        };
        if (Build.VERSION.SDK_INT >= 28) {
            cameraManager.openCamera(str, cameraQueue.getExecutor(), stateCallback);
        } else {
            cameraManager.openCamera(str, stateCallback, cameraQueue.getHandler());
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
