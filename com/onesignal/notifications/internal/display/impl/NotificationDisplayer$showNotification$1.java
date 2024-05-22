package com.onesignal.notifications.internal.display.impl;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationDisplayer.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.display.impl.NotificationDisplayer", f = "NotificationDisplayer.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {122, 137, 144}, m = "showNotification", n = {"this", "notificationJob", "fcmJson", "group", "intentGenerator", "grouplessNotifs", "oneSignalNotificationBuilder", "notifBuilder", "notificationId", "this", "group", "oneSignalNotificationBuilder", OneSignalDbContract.NotificationTable.TABLE_NAME, "notificationId", "this", "group", "oneSignalNotificationBuilder", OneSignalDbContract.NotificationTable.TABLE_NAME, "notificationId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"})
/* loaded from: classes5.dex */
public final class NotificationDisplayer$showNotification$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationDisplayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationDisplayer$showNotification$1(NotificationDisplayer notificationDisplayer, Continuation<? super NotificationDisplayer$showNotification$1> continuation) {
        super(continuation);
        this.this$0 = notificationDisplayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object showNotification;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        showNotification = this.this$0.showNotification(null, this);
        return showNotification;
    }
}
