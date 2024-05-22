package com.mrousavy.camera;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CameraViewModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.mrousavy.camera.CameraViewModule$takePhoto$1", f = "CameraViewModule.kt", i = {1}, l = {TsExtractor.TS_STREAM_TYPE_DVBSUBS, 91}, m = "invokeSuspend", n = {"promise$iv"}, s = {"L$0"})
/* loaded from: classes5.dex */
final class CameraViewModule$takePhoto$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReadableMap $options;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ int $viewTag;
    Object L$0;
    int label;
    final /* synthetic */ CameraViewModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraViewModule$takePhoto$1(CameraViewModule cameraViewModule, int i, Promise promise, ReadableMap readableMap, Continuation<? super CameraViewModule$takePhoto$1> continuation) {
        super(2, continuation);
        this.this$0 = cameraViewModule;
        this.$viewTag = i;
        this.$promise = promise;
        this.$options = readableMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CameraViewModule$takePhoto$1(this.this$0, this.$viewTag, this.$promise, this.$options, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CameraViewModule$takePhoto$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(1:(1:(6:5|6|7|8|9|10)(2:19|20))(1:21))(2:31|(1:33))|22|23|24|(1:26)(4:27|8|9|10)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004d, code lost:
    
        r6 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004e, code lost:
    
        r0 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0059  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L24
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            java.lang.Object r0 = r5.L$0
            com.facebook.react.bridge.Promise r0 = (com.facebook.react.bridge.Promise) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L16
            goto L49
        L16:
            r6 = move-exception
            goto L4f
        L18:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L20:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L37
        L24:
            kotlin.ResultKt.throwOnFailure(r6)
            com.mrousavy.camera.CameraViewModule r6 = r5.this$0
            int r1 = r5.$viewTag
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5.label = r3
            java.lang.Object r6 = com.mrousavy.camera.CameraViewModule.access$findCameraView(r6, r1, r4)
            if (r6 != r0) goto L37
            return r0
        L37:
            com.mrousavy.camera.CameraView r6 = (com.mrousavy.camera.CameraView) r6
            com.facebook.react.bridge.Promise r1 = r5.$promise
            com.facebook.react.bridge.ReadableMap r3 = r5.$options
            r5.L$0 = r1     // Catch: java.lang.Throwable -> L4d
            r5.label = r2     // Catch: java.lang.Throwable -> L4d
            java.lang.Object r6 = com.mrousavy.camera.CameraView_TakePhotoKt.takePhoto(r6, r3, r5)     // Catch: java.lang.Throwable -> L4d
            if (r6 != r0) goto L48
            return r0
        L48:
            r0 = r1
        L49:
            r0.resolve(r6)     // Catch: java.lang.Throwable -> L16
            goto L88
        L4d:
            r6 = move-exception
            r0 = r1
        L4f:
            r6.printStackTrace()
            boolean r1 = r6 instanceof com.mrousavy.camera.core.CameraError
            if (r1 == 0) goto L59
            com.mrousavy.camera.core.CameraError r6 = (com.mrousavy.camera.core.CameraError) r6
            goto L61
        L59:
            com.mrousavy.camera.core.UnknownCameraError r1 = new com.mrousavy.camera.core.UnknownCameraError
            r1.<init>(r6)
            r6 = r1
            com.mrousavy.camera.core.CameraError r6 = (com.mrousavy.camera.core.CameraError) r6
        L61:
            java.lang.String r1 = r6.getDomain()
            java.lang.String r2 = r6.getId()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = "/"
            r3.append(r1)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = r6.getMessage()
            java.lang.Throwable r6 = r6.getCause()
            r0.reject(r1, r2, r6)
        L88:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.CameraViewModule$takePhoto$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
