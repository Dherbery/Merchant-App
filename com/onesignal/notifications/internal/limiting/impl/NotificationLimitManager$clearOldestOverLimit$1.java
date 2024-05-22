package com.onesignal.notifications.internal.limiting.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationLimitManager.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager", f = "NotificationLimitManager.kt", i = {0, 0, 1, 1}, l = {21, 23, 30}, m = "clearOldestOverLimit", n = {"this", "notificationsToMakeRoomFor", "this", "notificationsToMakeRoomFor"}, s = {"L$0", "I$0", "L$0", "I$0"})
/* loaded from: classes5.dex */
public final class NotificationLimitManager$clearOldestOverLimit$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationLimitManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationLimitManager$clearOldestOverLimit$1(NotificationLimitManager notificationLimitManager, Continuation<? super NotificationLimitManager$clearOldestOverLimit$1> continuation) {
        super(continuation);
        this.this$0 = notificationLimitManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.clearOldestOverLimit(0, this);
    }
}
