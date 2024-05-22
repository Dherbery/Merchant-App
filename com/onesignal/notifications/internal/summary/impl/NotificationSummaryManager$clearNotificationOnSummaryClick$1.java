package com.onesignal.notifications.internal.summary.impl;

import androidx.appcompat.app.AppCompatDelegate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationSummaryManager.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager", f = "NotificationSummaryManager.kt", i = {0, 0, 0, 1}, l = {99, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 118}, m = "clearNotificationOnSummaryClick", n = {"this", "group", "notificationManager", "notificationManager"}, s = {"L$0", "L$1", "L$2", "L$0"})
/* loaded from: classes5.dex */
public final class NotificationSummaryManager$clearNotificationOnSummaryClick$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationSummaryManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationSummaryManager$clearNotificationOnSummaryClick$1(NotificationSummaryManager notificationSummaryManager, Continuation<? super NotificationSummaryManager$clearNotificationOnSummaryClick$1> continuation) {
        super(continuation);
        this.this$0 = notificationSummaryManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.clearNotificationOnSummaryClick(null, this);
    }
}
