package com.onesignal.notifications.internal.registration.impl;

import com.google.firebase.FirebaseApp;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushRegistratorFCM.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2", f = "PushRegistratorFCM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $senderId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PushRegistratorFCM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2(PushRegistratorFCM pushRegistratorFCM, String str, Continuation<? super PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2> continuation) {
        super(2, continuation);
        this.this$0 = pushRegistratorFCM;
        this.$senderId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2 pushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2 = new PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2(this.this$0, this.$senderId, continuation);
        pushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2.L$0 = obj;
        return pushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InvocationTargetException invocationTargetException;
        FirebaseApp firebaseApp;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        try {
            Method method = Class.forName("com.google.firebase.iid.FirebaseInstanceId").getMethod("getInstance", FirebaseApp.class);
            firebaseApp = this.this$0.firebaseApp;
            Object invoke = method.invoke(null, firebaseApp);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getDefault(), null, new PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2$exception$1(invoke.getClass().getMethod("getToken", String.class, String.class), invoke, this.$senderId, objectRef, null), 2, null);
            return objectRef.element;
        } catch (ClassNotFoundException e) {
            invocationTargetException = e;
            throw new Error("Reflection error on FirebaseInstanceId.getInstance(firebaseApp).getToken(senderId, FirebaseMessaging.INSTANCE_ID_SCOPE)", invocationTargetException);
        } catch (IllegalAccessException e2) {
            invocationTargetException = e2;
            throw new Error("Reflection error on FirebaseInstanceId.getInstance(firebaseApp).getToken(senderId, FirebaseMessaging.INSTANCE_ID_SCOPE)", invocationTargetException);
        } catch (NoSuchMethodException e3) {
            invocationTargetException = e3;
            throw new Error("Reflection error on FirebaseInstanceId.getInstance(firebaseApp).getToken(senderId, FirebaseMessaging.INSTANCE_ID_SCOPE)", invocationTargetException);
        } catch (InvocationTargetException e4) {
            invocationTargetException = e4;
            throw new Error("Reflection error on FirebaseInstanceId.getInstance(firebaseApp).getToken(senderId, FirebaseMessaging.INSTANCE_ID_SCOPE)", invocationTargetException);
        }
    }
}
