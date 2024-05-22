package com.onesignal.notifications.internal.listeners;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationListener.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.listeners.NotificationListener", f = "NotificationListener.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {84, 107}, m = "onNotificationOpened", n = {"this", "activity", "data", "notificationId", "appId", "subscriptionId", "deviceType", "i"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"})
/* loaded from: classes5.dex */
public final class NotificationListener$onNotificationOpened$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationListener this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationListener$onNotificationOpened$1(NotificationListener notificationListener, Continuation<? super NotificationListener$onNotificationOpened$1> continuation) {
        super(continuation);
        this.this$0 = notificationListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onNotificationOpened(null, null, null, this);
    }
}
