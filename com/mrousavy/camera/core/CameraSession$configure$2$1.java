package com.mrousavy.camera.core;

import com.mrousavy.camera.core.CameraConfiguration;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraSession.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.mrousavy.camera.core.CameraSession$configure$2$1", f = "CameraSession.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class CameraSession$configure$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraConfiguration $config;
    final /* synthetic */ CameraConfiguration.Difference $diff;
    int label;
    final /* synthetic */ CameraSession this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraSession$configure$2$1(CameraConfiguration.Difference difference, CameraSession cameraSession, CameraConfiguration cameraConfiguration, Continuation<? super CameraSession$configure$2$1> continuation) {
        super(1, continuation);
        this.$diff = difference;
        this.this$0 = cameraSession;
        this.$config = cameraConfiguration;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new CameraSession$configure$2$1(this.$diff, this.this$0, this.$config, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((CameraSession$configure$2$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object configureOutputs;
        PersistentCameraCaptureSession persistentCameraCaptureSession;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$diff.getDeviceChanged()) {
                this.this$0.configureInput(this.$config);
            }
            if (this.$diff.getOutputsChanged()) {
                this.label = 1;
                configureOutputs = this.this$0.configureOutputs(this.$config, this);
                if (configureOutputs == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (this.$diff.getSidePropsChanged()) {
            this.this$0.configureCaptureRequest(this.$config);
        }
        if (this.$diff.isActiveChanged()) {
            boolean z = this.$config.isActive() && this.$config.getPreview().isEnabled();
            persistentCameraCaptureSession = this.this$0.captureSession;
            persistentCameraCaptureSession.setIsActive(z);
        }
        return Unit.INSTANCE;
    }
}
