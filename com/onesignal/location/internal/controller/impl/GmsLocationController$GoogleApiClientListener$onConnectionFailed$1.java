package com.onesignal.location.internal.controller.impl;

import com.onesignal.location.internal.controller.impl.GmsLocationController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: GmsLocationController.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.location.internal.controller.impl.GmsLocationController$GoogleApiClientListener$onConnectionFailed$1", f = "GmsLocationController.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class GmsLocationController$GoogleApiClientListener$onConnectionFailed$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GmsLocationController.GoogleApiClientListener this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GmsLocationController$GoogleApiClientListener$onConnectionFailed$1(GmsLocationController.GoogleApiClientListener googleApiClientListener, Continuation<? super GmsLocationController$GoogleApiClientListener$onConnectionFailed$1> continuation) {
        super(1, continuation);
        this.this$0 = googleApiClientListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new GmsLocationController$GoogleApiClientListener$onConnectionFailed$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((GmsLocationController$GoogleApiClientListener$onConnectionFailed$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GmsLocationController gmsLocationController;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            gmsLocationController = this.this$0._parent;
            this.label = 1;
            if (gmsLocationController.stop(this) == coroutine_suspended) {
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
