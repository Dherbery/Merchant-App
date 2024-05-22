package com.onesignal.notifications.internal.registration.impl;

import com.google.firebase.messaging.FirebaseMessaging;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PushRegistratorFCM.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2$exception$1", f = "PushRegistratorFCM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2$exception$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Method $getTokenMethod;
    final /* synthetic */ Object $instanceId;
    final /* synthetic */ String $senderId;
    final /* synthetic */ Ref.ObjectRef<String> $token;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2$exception$1(Method method, Object obj, String str, Ref.ObjectRef<String> objectRef, Continuation<? super PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2$exception$1> continuation) {
        super(2, continuation);
        this.$getTokenMethod = method;
        this.$instanceId = obj;
        this.$senderId = str;
        this.$token = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2$exception$1(this.$getTokenMethod, this.$instanceId, this.$senderId, this.$token, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2$exception$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Object invoke = this.$getTokenMethod.invoke(this.$instanceId, this.$senderId, FirebaseMessaging.INSTANCE_ID_SCOPE);
        Ref.ObjectRef<String> objectRef = this.$token;
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.String");
        objectRef.element = (String) invoke;
        return Unit.INSTANCE;
    }
}
