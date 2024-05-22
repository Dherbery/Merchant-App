package com.mrousavy.camera;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;
import com.mrousavy.camera.core.CameraError;
import com.mrousavy.camera.types.RecordVideoOptions;
import com.mrousavy.camera.utils.CallbackPromiseKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CameraViewModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.mrousavy.camera.CameraViewModule$startRecording$1", f = "CameraViewModule.kt", i = {}, l = {100, 103}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class CameraViewModule$startRecording$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReadableMap $jsOptions;
    final /* synthetic */ Callback $onRecordCallback;
    final /* synthetic */ int $viewTag;
    int label;
    final /* synthetic */ CameraViewModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraViewModule$startRecording$1(CameraViewModule cameraViewModule, int i, ReadableMap readableMap, Callback callback, Continuation<? super CameraViewModule$startRecording$1> continuation) {
        super(2, continuation);
        this.this$0 = cameraViewModule;
        this.$viewTag = i;
        this.$jsOptions = readableMap;
        this.$onRecordCallback = callback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CameraViewModule$startRecording$1(this.this$0, this.$viewTag, this.$jsOptions, this.$onRecordCallback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CameraViewModule$startRecording$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (CameraError e) {
            this.$onRecordCallback.invoke(null, CallbackPromiseKt.makeErrorMap$default(e.getDomain() + "/" + e.getId(), e.getMessage(), e, null, 8, null));
        } catch (Throwable th) {
            this.$onRecordCallback.invoke(null, CallbackPromiseKt.makeErrorMap$default("capture/unknown", "An unknown error occurred while trying to start a video recording! " + th.getMessage(), th, null, 8, null));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.findCameraView(this.$viewTag, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        CameraView cameraView = (CameraView) obj;
        this.label = 2;
        if (CameraView_RecordVideoKt.startRecording(cameraView, new RecordVideoOptions(this.$jsOptions), this.$onRecordCallback, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
