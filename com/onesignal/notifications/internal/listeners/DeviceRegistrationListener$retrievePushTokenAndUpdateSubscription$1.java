package com.onesignal.notifications.internal.listeners;

import com.onesignal.notifications.INotificationsManager;
import com.onesignal.notifications.internal.pushtoken.IPushTokenManager;
import com.onesignal.notifications.internal.pushtoken.PushTokenResponse;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceRegistrationListener.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.listeners.DeviceRegistrationListener$retrievePushTokenAndUpdateSubscription$1", f = "DeviceRegistrationListener.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class DeviceRegistrationListener$retrievePushTokenAndUpdateSubscription$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DeviceRegistrationListener this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceRegistrationListener$retrievePushTokenAndUpdateSubscription$1(DeviceRegistrationListener deviceRegistrationListener, Continuation<? super DeviceRegistrationListener$retrievePushTokenAndUpdateSubscription$1> continuation) {
        super(1, continuation);
        this.this$0 = deviceRegistrationListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new DeviceRegistrationListener$retrievePushTokenAndUpdateSubscription$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((DeviceRegistrationListener$retrievePushTokenAndUpdateSubscription$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IPushTokenManager iPushTokenManager;
        INotificationsManager iNotificationsManager;
        ISubscriptionManager iSubscriptionManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            iPushTokenManager = this.this$0._pushTokenManager;
            this.label = 1;
            obj = iPushTokenManager.retrievePushToken(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        PushTokenResponse pushTokenResponse = (PushTokenResponse) obj;
        iNotificationsManager = this.this$0._notificationsManager;
        boolean permission = iNotificationsManager.getPermission();
        iSubscriptionManager = this.this$0._subscriptionManager;
        iSubscriptionManager.addOrUpdatePushSubscriptionToken(pushTokenResponse.getToken(), permission ? pushTokenResponse.getStatus() : SubscriptionStatus.NO_PERMISSION);
        return Unit.INSTANCE;
    }
}
