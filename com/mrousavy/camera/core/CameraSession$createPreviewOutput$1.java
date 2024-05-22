package com.mrousavy.camera.core;

import android.view.Surface;
import com.google.mlkit.common.MlKitException;
import com.mrousavy.camera.core.CameraConfiguration;
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
/* compiled from: CameraSession.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.mrousavy.camera.core.CameraSession$createPreviewOutput$1", f = "CameraSession.kt", i = {}, l = {MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class CameraSession$createPreviewOutput$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Surface $surface;
    int label;
    final /* synthetic */ CameraSession this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraSession$createPreviewOutput$1(CameraSession cameraSession, Surface surface, Continuation<? super CameraSession$createPreviewOutput$1> continuation) {
        super(2, continuation);
        this.this$0 = cameraSession;
        this.$surface = surface;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CameraSession$createPreviewOutput$1(this.this$0, this.$surface, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CameraSession$createPreviewOutput$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CameraSession cameraSession = this.this$0;
            final Surface surface = this.$surface;
            this.label = 1;
            if (cameraSession.configure(new Function1<CameraConfiguration, Unit>() { // from class: com.mrousavy.camera.core.CameraSession$createPreviewOutput$1.1
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
                    Intrinsics.checkNotNullParameter(config, "config");
                    config.setPreview(CameraConfiguration.Output.Enabled.INSTANCE.create(new CameraConfiguration.Preview(surface)));
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
