package com.mrousavy.camera;

import android.util.Log;
import com.mrousavy.camera.core.CameraConfiguration;
import com.mrousavy.camera.core.CameraSession;
import com.mrousavy.camera.types.CodeScannerOptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraView.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.mrousavy.camera.CameraView$update$1", f = "CameraView.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class CameraView$update$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $now;
    int label;
    final /* synthetic */ CameraView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraView$update$1(CameraView cameraView, long j, Continuation<? super CameraView$update$1> continuation) {
        super(2, continuation);
        this.this$0 = cameraView;
        this.$now = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CameraView$update$1(this.this$0, this.$now, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CameraView$update$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CameraSession cameraSession = this.this$0.getCameraSession();
            final CameraView cameraView = this.this$0;
            final long j = this.$now;
            this.label = 1;
            if (cameraSession.configure(new Function1<CameraConfiguration, Unit>() { // from class: com.mrousavy.camera.CameraView$update$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CameraConfiguration cameraConfiguration) {
                    invoke2(cameraConfiguration);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CameraConfiguration config) {
                    long j2;
                    Intrinsics.checkNotNullParameter(config, "config");
                    j2 = CameraView.this.currentConfigureCall;
                    if (j2 != j) {
                        Log.i("CameraView", "A new configure { ... } call arrived, aborting this one...");
                        return;
                    }
                    config.setCameraId(CameraView.this.getCameraId());
                    if (CameraView.this.getPhoto()) {
                        config.setPhoto(CameraConfiguration.Output.Enabled.INSTANCE.create(new CameraConfiguration.Photo(CameraView.this.getPhotoHdr())));
                    } else {
                        config.setPhoto(CameraConfiguration.Output.Disabled.INSTANCE.create());
                    }
                    if (CameraView.this.getVideo() || CameraView.this.getEnableFrameProcessor()) {
                        config.setVideo(CameraConfiguration.Output.Enabled.INSTANCE.create(new CameraConfiguration.Video(CameraView.this.getVideoHdr(), CameraView.this.getPixelFormat(), CameraView.this.getEnableFrameProcessor(), CameraView.this.getEnableGpuBuffers())));
                    } else {
                        config.setVideo(CameraConfiguration.Output.Disabled.INSTANCE.create());
                    }
                    if (CameraView.this.getAudio()) {
                        config.setAudio(CameraConfiguration.Output.Enabled.INSTANCE.create(new CameraConfiguration.Audio(Unit.INSTANCE)));
                    } else {
                        config.setAudio(CameraConfiguration.Output.Disabled.INSTANCE.create());
                    }
                    CodeScannerOptions codeScannerOptions = CameraView.this.getCodeScannerOptions();
                    if (codeScannerOptions != null) {
                        config.setCodeScanner(CameraConfiguration.Output.Enabled.INSTANCE.create(new CameraConfiguration.CodeScanner(codeScannerOptions.getCodeTypes())));
                    } else {
                        config.setCodeScanner(CameraConfiguration.Output.Disabled.INSTANCE.create());
                    }
                    config.setOrientation(CameraView.this.getOrientation());
                    config.setFormat(CameraView.this.getFormat());
                    config.setFps(CameraView.this.getFps());
                    config.setEnableLowLightBoost(CameraView.this.getLowLightBoost());
                    config.setTorch(CameraView.this.getTorch());
                    config.setExposure(Double.valueOf(CameraView.this.getExposure()));
                    config.setZoom(CameraView.this.getZoom());
                    config.setActive(CameraView.this.getIsActive() && CameraView.this.isAttachedToWindow());
                }
            }, this) == coroutine_suspended) {
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
