package com.mrousavy.camera;

import com.facebook.react.bridge.Promise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CameraViewModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.mrousavy.camera.CameraViewModule$pauseRecording$1", f = "CameraViewModule.kt", i = {0, 1}, l = {119, 120}, m = "invokeSuspend", n = {"promise$iv", "promise$iv"}, s = {"L$0", "L$0"})
/* loaded from: classes5.dex */
final class CameraViewModule$pauseRecording$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ int $viewTag;
    Object L$0;
    int label;
    final /* synthetic */ CameraViewModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraViewModule$pauseRecording$1(Promise promise, CameraViewModule cameraViewModule, int i, Continuation<? super CameraViewModule$pauseRecording$1> continuation) {
        super(2, continuation);
        this.$promise = promise;
        this.this$0 = cameraViewModule;
        this.$viewTag = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CameraViewModule$pauseRecording$1(this.$promise, this.this$0, this.$viewTag, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CameraViewModule$pauseRecording$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2b
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            java.lang.Object r0 = r6.L$0
            com.facebook.react.bridge.Promise r0 = (com.facebook.react.bridge.Promise) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L16
            goto L50
        L16:
            r7 = move-exception
            goto L59
        L18:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L20:
            java.lang.Object r1 = r6.L$0
            com.facebook.react.bridge.Promise r1 = (com.facebook.react.bridge.Promise) r1
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L28
            goto L42
        L28:
            r7 = move-exception
            r0 = r1
            goto L59
        L2b:
            kotlin.ResultKt.throwOnFailure(r7)
            com.facebook.react.bridge.Promise r7 = r6.$promise
            com.mrousavy.camera.CameraViewModule r1 = r6.this$0
            int r4 = r6.$viewTag
            r6.L$0 = r7     // Catch: java.lang.Throwable -> L55
            r6.label = r3     // Catch: java.lang.Throwable -> L55
            java.lang.Object r1 = com.mrousavy.camera.CameraViewModule.access$findCameraView(r1, r4, r6)     // Catch: java.lang.Throwable -> L55
            if (r1 != r0) goto L3f
            return r0
        L3f:
            r5 = r1
            r1 = r7
            r7 = r5
        L42:
            com.mrousavy.camera.CameraView r7 = (com.mrousavy.camera.CameraView) r7     // Catch: java.lang.Throwable -> L28
            r6.L$0 = r1     // Catch: java.lang.Throwable -> L28
            r6.label = r2     // Catch: java.lang.Throwable -> L28
            java.lang.Object r7 = com.mrousavy.camera.CameraView_RecordVideoKt.pauseRecording(r7, r6)     // Catch: java.lang.Throwable -> L28
            if (r7 != r0) goto L4f
            return r0
        L4f:
            r0 = r1
        L50:
            r7 = 0
            r0.resolve(r7)     // Catch: java.lang.Throwable -> L16
            goto L92
        L55:
            r0 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
        L59:
            r7.printStackTrace()
            boolean r1 = r7 instanceof com.mrousavy.camera.core.CameraError
            if (r1 == 0) goto L63
            com.mrousavy.camera.core.CameraError r7 = (com.mrousavy.camera.core.CameraError) r7
            goto L6b
        L63:
            com.mrousavy.camera.core.UnknownCameraError r1 = new com.mrousavy.camera.core.UnknownCameraError
            r1.<init>(r7)
            r7 = r1
            com.mrousavy.camera.core.CameraError r7 = (com.mrousavy.camera.core.CameraError) r7
        L6b:
            java.lang.String r1 = r7.getDomain()
            java.lang.String r2 = r7.getId()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = "/"
            r3.append(r1)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = r7.getMessage()
            java.lang.Throwable r7 = r7.getCause()
            r0.reject(r1, r2, r7)
        L92:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.CameraViewModule$pauseRecording$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
