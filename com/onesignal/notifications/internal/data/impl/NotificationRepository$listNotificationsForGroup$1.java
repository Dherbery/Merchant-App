package com.onesignal.notifications.internal.data.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationRepository.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository", f = "NotificationRepository.kt", i = {0}, l = {440}, m = "listNotificationsForGroup", n = {"listOfNotifications"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class NotificationRepository$listNotificationsForGroup$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationRepository$listNotificationsForGroup$1(NotificationRepository notificationRepository, Continuation<? super NotificationRepository$listNotificationsForGroup$1> continuation) {
        super(continuation);
        this.this$0 = notificationRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.listNotificationsForGroup(null, this);
    }
}
