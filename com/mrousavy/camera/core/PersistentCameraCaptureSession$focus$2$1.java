package com.mrousavy.camera.core;

import android.graphics.Point;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import com.google.android.exoplayer2.C;
import com.mrousavy.camera.core.capture.RepeatingCaptureRequest;
import com.mrousavy.camera.core.outputs.SurfaceOutput;
import com.mrousavy.camera.extensions.CameraCaptureSession_precaptureKt;
import com.mrousavy.camera.extensions.PrecaptureOptions;
import com.mrousavy.camera.extensions.PrecaptureTrigger;
import com.mrousavy.camera.types.Flash;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PersistentCameraCaptureSession.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.mrousavy.camera.core.PersistentCameraCaptureSession$focus$2$1", f = "PersistentCameraCaptureSession.kt", i = {}, l = {241}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class PersistentCameraCaptureSession$focus$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraDevice $device;
    final /* synthetic */ CameraDeviceDetails $deviceDetails;
    final /* synthetic */ List<SurfaceOutput> $outputs;
    final /* synthetic */ Point $point;
    final /* synthetic */ RepeatingCaptureRequest $repeatingRequest;
    final /* synthetic */ CameraCaptureSession $session;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PersistentCameraCaptureSession$focus$2$1(RepeatingCaptureRequest repeatingCaptureRequest, CameraDevice cameraDevice, CameraDeviceDetails cameraDeviceDetails, List<? extends SurfaceOutput> list, Point point, CameraCaptureSession cameraCaptureSession, Continuation<? super PersistentCameraCaptureSession$focus$2$1> continuation) {
        super(2, continuation);
        this.$repeatingRequest = repeatingCaptureRequest;
        this.$device = cameraDevice;
        this.$deviceDetails = cameraDeviceDetails;
        this.$outputs = list;
        this.$point = point;
        this.$session = cameraCaptureSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PersistentCameraCaptureSession$focus$2$1(this.$repeatingRequest, this.$device, this.$deviceDetails, this.$outputs, this.$point, this.$session, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PersistentCameraCaptureSession$focus$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CaptureRequest.Builder createCaptureRequest = this.$repeatingRequest.createCaptureRequest(this.$device, this.$deviceDetails, this.$outputs);
            PrecaptureOptions precaptureOptions = new PrecaptureOptions(CollectionsKt.listOf((Object[]) new PrecaptureTrigger[]{PrecaptureTrigger.AF, PrecaptureTrigger.AE}), Flash.OFF, CollectionsKt.listOf(this.$point), false, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
            this.label = 1;
            if (CameraCaptureSession_precaptureKt.precapture(this.$session, createCaptureRequest, this.$deviceDetails, precaptureOptions, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
