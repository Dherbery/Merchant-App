package com.mrousavy.camera.extensions;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.util.Log;
import com.mrousavy.camera.core.CaptureTimedOutError;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: CameraCaptureSession+setRepeatingRequestAndWaitForPrecapture.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.mrousavy.camera.extensions.CameraCaptureSession_setRepeatingRequestAndWaitForPrecaptureKt$setRepeatingRequestAndWaitForPrecapture$2$1", f = "CameraCaptureSession+setRepeatingRequestAndWaitForPrecapture.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class CameraCaptureSession_setRepeatingRequestAndWaitForPrecaptureKt$setRepeatingRequestAndWaitForPrecapture$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CancellableContinuation<ResultState> $continuation;
    final /* synthetic */ CaptureRequest $request;
    final /* synthetic */ CameraCaptureSession $this_setRepeatingRequestAndWaitForPrecapture;
    final /* synthetic */ long $timeoutMs;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CameraCaptureSession_setRepeatingRequestAndWaitForPrecaptureKt$setRepeatingRequestAndWaitForPrecapture$2$1(long j, CancellableContinuation<? super ResultState> cancellableContinuation, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Continuation<? super CameraCaptureSession_setRepeatingRequestAndWaitForPrecaptureKt$setRepeatingRequestAndWaitForPrecapture$2$1> continuation) {
        super(2, continuation);
        this.$timeoutMs = j;
        this.$continuation = cancellableContinuation;
        this.$this_setRepeatingRequestAndWaitForPrecapture = cameraCaptureSession;
        this.$request = captureRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CameraCaptureSession_setRepeatingRequestAndWaitForPrecaptureKt$setRepeatingRequestAndWaitForPrecapture$2$1(this.$timeoutMs, this.$continuation, this.$this_setRepeatingRequestAndWaitForPrecapture, this.$request, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CameraCaptureSession_setRepeatingRequestAndWaitForPrecaptureKt$setRepeatingRequestAndWaitForPrecapture$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(this.$timeoutMs, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (this.$continuation.isActive()) {
            Log.e("CameraCaptureSession", "Precapture timed out after " + (this.$timeoutMs / 1000) + " seconds!");
            CancellableContinuation<ResultState> cancellableContinuation = this.$continuation;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m1318constructorimpl(ResultKt.createFailure(new CaptureTimedOutError())));
            try {
                this.$this_setRepeatingRequestAndWaitForPrecapture.setRepeatingRequest(this.$request, null, null);
            } catch (Throwable th) {
                Log.e("CameraCaptureSession", "Error resetting session repeating request..", th);
            }
        }
        return Unit.INSTANCE;
    }
}
