package com.mrousavy.camera.extensions;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Log;
import com.mrousavy.camera.core.CaptureAbortedError;
import com.mrousavy.camera.extensions.ExposureState;
import com.mrousavy.camera.extensions.FocusState;
import com.mrousavy.camera.extensions.WhiteBalanceState;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: CameraCaptureSession+setRepeatingRequestAndWaitForPrecapture.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a9\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"TAG", "", "setRepeatingRequestAndWaitForPrecapture", "Lcom/mrousavy/camera/extensions/ResultState;", "Landroid/hardware/camera2/CameraCaptureSession;", "request", "Landroid/hardware/camera2/CaptureRequest;", "timeoutMs", "", "precaptureTriggers", "", "Lcom/mrousavy/camera/extensions/PrecaptureTrigger;", "(Landroid/hardware/camera2/CameraCaptureSession;Landroid/hardware/camera2/CaptureRequest;J[Lcom/mrousavy/camera/extensions/PrecaptureTrigger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-vision-camera_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraCaptureSession_setRepeatingRequestAndWaitForPrecaptureKt {
    private static final String TAG = "CameraCaptureSession";

    public static final Object setRepeatingRequestAndWaitForPrecapture(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, final PrecaptureTrigger[] precaptureTriggerArr, Continuation<? super ResultState> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(precaptureTriggerArr.length), 16));
        for (PrecaptureTrigger precaptureTrigger : precaptureTriggerArr) {
            linkedHashMap.put(precaptureTrigger, Boxing.boxBoolean(false));
        }
        final Map mutableMap = MapsKt.toMutableMap(linkedHashMap);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new CameraCaptureSession_setRepeatingRequestAndWaitForPrecaptureKt$setRepeatingRequestAndWaitForPrecapture$2$1(j, cancellableContinuationImpl2, cameraCaptureSession, captureRequest, null), 3, null);
        cameraCaptureSession.setRepeatingRequest(captureRequest, new CameraCaptureSession.CaptureCallback() { // from class: com.mrousavy.camera.extensions.CameraCaptureSession_setRepeatingRequestAndWaitForPrecaptureKt$setRepeatingRequestAndWaitForPrecapture$2$2
            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureCompleted(CameraCaptureSession session, CaptureRequest request, TotalCaptureResult result) {
                Intrinsics.checkNotNullParameter(session, "session");
                Intrinsics.checkNotNullParameter(request, "request");
                Intrinsics.checkNotNullParameter(result, "result");
                super.onCaptureCompleted(session, request, result);
                if (cancellableContinuationImpl2.isActive()) {
                    FocusState.Companion companion = FocusState.INSTANCE;
                    int i = (Integer) result.get(CaptureResult.CONTROL_AF_STATE);
                    boolean z = false;
                    if (i == null) {
                        i = 0;
                    }
                    FocusState fromAFState = companion.fromAFState(i.intValue());
                    ExposureState.Companion companion2 = ExposureState.INSTANCE;
                    int i2 = (Integer) result.get(CaptureResult.CONTROL_AE_STATE);
                    if (i2 == null) {
                        i2 = 0;
                    }
                    ExposureState fromAEState = companion2.fromAEState(i2.intValue());
                    WhiteBalanceState.Companion companion3 = WhiteBalanceState.INSTANCE;
                    int i3 = (Integer) result.get(CaptureResult.CONTROL_AWB_STATE);
                    if (i3 == null) {
                        i3 = 0;
                    }
                    WhiteBalanceState fromAWBState = companion3.fromAWBState(i3.intValue());
                    Log.i("CameraCaptureSession", "Precapture state: AF: " + fromAFState + ", AE: " + fromAEState + ", AWB: " + fromAWBState);
                    if (ArraysKt.contains(precaptureTriggerArr, PrecaptureTrigger.AF)) {
                        mutableMap.put(PrecaptureTrigger.AF, Boolean.valueOf(fromAFState.isCompleted()));
                    }
                    if (ArraysKt.contains(precaptureTriggerArr, PrecaptureTrigger.AE)) {
                        mutableMap.put(PrecaptureTrigger.AE, Boolean.valueOf(fromAEState.isCompleted()));
                    }
                    if (ArraysKt.contains(precaptureTriggerArr, PrecaptureTrigger.AWB)) {
                        mutableMap.put(PrecaptureTrigger.AWB, Boolean.valueOf(fromAWBState.isCompleted()));
                    }
                    Collection<Boolean> values = mutableMap.values();
                    if (!(values instanceof Collection) || !values.isEmpty()) {
                        Iterator<T> it = values.iterator();
                        while (it.hasNext()) {
                            if (!(((Boolean) it.next()).booleanValue())) {
                                break;
                            }
                        }
                    }
                    z = true;
                    if (z) {
                        CancellableContinuation<ResultState> cancellableContinuation = cancellableContinuationImpl2;
                        Result.Companion companion4 = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m1318constructorimpl(new ResultState(fromAFState, fromAEState, fromAWBState)));
                        session.setRepeatingRequest(request, null, null);
                    }
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureFailed(CameraCaptureSession session, CaptureRequest request, CaptureFailure failure) {
                Intrinsics.checkNotNullParameter(session, "session");
                Intrinsics.checkNotNullParameter(request, "request");
                Intrinsics.checkNotNullParameter(failure, "failure");
                super.onCaptureFailed(session, request, failure);
                if (cancellableContinuationImpl2.isActive()) {
                    CancellableContinuation<ResultState> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m1318constructorimpl(ResultKt.createFailure(new CaptureAbortedError(failure.wasImageCaptured()))));
                    try {
                        session.setRepeatingRequest(request, null, null);
                    } catch (Throwable th) {
                        Log.e("CameraCaptureSession", "Failed to continue repeating request!", th);
                    }
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
