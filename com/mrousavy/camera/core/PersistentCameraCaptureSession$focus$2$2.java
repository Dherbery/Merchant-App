package com.mrousavy.camera.core;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.util.Log;
import com.google.android.exoplayer2.C;
import com.mrousavy.camera.core.capture.RepeatingCaptureRequest;
import com.mrousavy.camera.core.outputs.SurfaceOutput;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PersistentCameraCaptureSession.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.mrousavy.camera.core.PersistentCameraCaptureSession$focus$2$2", f = "PersistentCameraCaptureSession.kt", i = {0}, l = {247}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class PersistentCameraCaptureSession$focus$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraDevice $device;
    final /* synthetic */ CameraDeviceDetails $deviceDetails;
    final /* synthetic */ List<SurfaceOutput> $outputs;
    final /* synthetic */ RepeatingCaptureRequest $repeatingRequest;
    final /* synthetic */ CameraCaptureSession $session;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PersistentCameraCaptureSession this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PersistentCameraCaptureSession$focus$2$2(PersistentCameraCaptureSession persistentCameraCaptureSession, CameraCaptureSession cameraCaptureSession, RepeatingCaptureRequest repeatingCaptureRequest, CameraDevice cameraDevice, CameraDeviceDetails cameraDeviceDetails, List<? extends SurfaceOutput> list, Continuation<? super PersistentCameraCaptureSession$focus$2$2> continuation) {
        super(2, continuation);
        this.this$0 = persistentCameraCaptureSession;
        this.$session = cameraCaptureSession;
        this.$repeatingRequest = repeatingCaptureRequest;
        this.$device = cameraDevice;
        this.$deviceDetails = cameraDeviceDetails;
        this.$outputs = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PersistentCameraCaptureSession$focus$2$2 persistentCameraCaptureSession$focus$2$2 = new PersistentCameraCaptureSession$focus$2$2(this.this$0, this.$session, this.$repeatingRequest, this.$device, this.$deviceDetails, this.$outputs, continuation);
        persistentCameraCaptureSession$focus$2$2.L$0 = obj;
        return persistentCameraCaptureSession$focus$2$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PersistentCameraCaptureSession$focus$2$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        CameraCaptureSession cameraCaptureSession;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            this.L$0 = coroutineScope2;
            this.label = 1;
            if (DelayKt.delay(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope = coroutineScope2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (!CoroutineScopeKt.isActive(coroutineScope)) {
            return Unit.INSTANCE;
        }
        if (this.this$0.isRunning()) {
            cameraCaptureSession = this.this$0.session;
            if (Intrinsics.areEqual(cameraCaptureSession, this.$session)) {
                Log.i("PersistentCameraCaptureSession", "Resetting focus to auto-focus...");
                this.$session.setRepeatingRequest(this.$repeatingRequest.createCaptureRequest(this.$device, this.$deviceDetails, this.$outputs).build(), null, null);
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }
}
