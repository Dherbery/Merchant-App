package com.mrousavy.camera.extensions;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.util.Log;
import com.mrousavy.camera.core.CameraQueues;
import com.mrousavy.camera.core.CameraSessionCannotBeConfiguredError;
import com.mrousavy.camera.core.outputs.SurfaceOutput;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;
import com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: CameraDevice+createCaptureSession.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aV\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"TAG", "", "sessionId", "", "createCaptureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "Landroid/hardware/camera2/CameraDevice;", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "outputs", "", "Lcom/mrousavy/camera/core/outputs/SurfaceOutput;", "onClosed", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", OutcomeEventsTable.COLUMN_NAME_SESSION, "", "queue", "Lcom/mrousavy/camera/core/CameraQueues$CameraQueue;", "(Landroid/hardware/camera2/CameraDevice;Landroid/hardware/camera2/CameraManager;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lcom/mrousavy/camera/core/CameraQueues$CameraQueue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-vision-camera_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraDevice_createCaptureSessionKt {
    private static final String TAG = "CreateCaptureSession";
    private static int sessionId = 1;

    public static final Object createCaptureSession(final CameraDevice cameraDevice, CameraManager cameraManager, List<? extends SurfaceOutput> list, final Function1<? super CameraCaptureSession, Unit> function1, CameraQueues.CameraQueue cameraQueue, Continuation<? super CameraCaptureSession> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraDevice.getId());
        Intrinsics.checkNotNullExpressionValue(cameraCharacteristics, "cameraManager.getCameraCharacteristics(id)");
        Object obj = cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        Intrinsics.checkNotNull(obj);
        int intValue = ((Number) obj).intValue();
        final int i = sessionId;
        sessionId = i + 1;
        List<? extends SurfaceOutput> list2 = list;
        Log.i(TAG, "Camera #" + cameraDevice.getId() + ": Creating Capture Session #" + i + "... (Hardware Level: " + intValue + " | Outputs: [" + CollectionsKt.joinToString$default(list2, null, null, null, 0, null, null, 63, null) + "])");
        CameraCaptureSession.StateCallback stateCallback = new CameraCaptureSession.StateCallback() { // from class: com.mrousavy.camera.extensions.CameraDevice_createCaptureSessionKt$createCaptureSession$2$callback$1
            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onConfigured(CameraCaptureSession session) {
                Intrinsics.checkNotNullParameter(session, "session");
                Log.i("CreateCaptureSession", "Camera #" + cameraDevice.getId() + ": Successfully created CameraCaptureSession #" + i + "!");
                CancellableContinuation<CameraCaptureSession> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m1318constructorimpl(session));
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onConfigureFailed(CameraCaptureSession session) {
                Intrinsics.checkNotNullParameter(session, "session");
                Log.e("CreateCaptureSession", "Camera #" + cameraDevice.getId() + ": Failed to create CameraCaptureSession #" + i + "!");
                CancellableContinuation<CameraCaptureSession> cancellableContinuation = cancellableContinuationImpl2;
                String id = cameraDevice.getId();
                Intrinsics.checkNotNullExpressionValue(id, "id");
                CameraSessionCannotBeConfiguredError cameraSessionCannotBeConfiguredError = new CameraSessionCannotBeConfiguredError(id);
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m1318constructorimpl(ResultKt.createFailure(cameraSessionCannotBeConfiguredError)));
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onClosed(CameraCaptureSession session) {
                Intrinsics.checkNotNullParameter(session, "session");
                Log.i("CreateCaptureSession", "Camera #" + cameraDevice.getId() + ": CameraCaptureSession #" + i + " has been closed.");
                super.onClosed(session);
                function1.invoke(session);
            }
        };
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((SurfaceOutput) it.next()).toOutputConfiguration(cameraCharacteristics));
        }
        ArrayList arrayList2 = arrayList;
        if (Build.VERSION.SDK_INT >= 28) {
            Log.i(TAG, "Using new API (>=28)");
            Downloader$$ExternalSyntheticApiModelOutline0.m1124m$2();
            cameraDevice.createCaptureSession(Downloader$$ExternalSyntheticApiModelOutline0.m(0, arrayList2, cameraQueue.getExecutor(), stateCallback));
        } else {
            Log.i(TAG, "Using legacy API (<28)");
            cameraDevice.createCaptureSessionByOutputConfigurations(arrayList2, stateCallback, cameraQueue.getHandler());
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
