package com.onesignal.notifications.internal.limiting.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationLimitManager.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager", f = "NotificationLimitManager.kt", i = {0, 0, 0, 1, 1}, l = {57, 60}, m = "clearOldestOverLimitStandard", n = {"this", "value", "notificationsToClear", "this", "notificationsToClear"}, s = {"L$0", "L$2", "I$0", "L$0", "I$0"})
/* loaded from: classes5.dex */
public final class NotificationLimitManager$clearOldestOverLimitStandard$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationLimitManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationLimitManager$clearOldestOverLimitStandard$1(NotificationLimitManager notificationLimitManager, Continuation<? super NotificationLimitManager$clearOldestOverLimitStandard$1> continuation) {
        super(continuation);
        this.this$0 = notificationLimitManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object clearOldestOverLimitStandard;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        clearOldestOverLimitStandard = this.this$0.clearOldestOverLimitStandard(0, this);
        return clearOldestOverLimitStandard;
    }
}
