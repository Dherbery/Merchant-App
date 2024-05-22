package com.onesignal.notifications.internal.backend.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationBackendService.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.backend.impl.NotificationBackendService", f = "NotificationBackendService.kt", i = {}, l = {43}, m = "updateNotificationAsOpened", n = {}, s = {})
/* loaded from: classes5.dex */
public final class NotificationBackendService$updateNotificationAsOpened$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationBackendService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationBackendService$updateNotificationAsOpened$1(NotificationBackendService notificationBackendService, Continuation<? super NotificationBackendService$updateNotificationAsOpened$1> continuation) {
        super(continuation);
        this.this$0 = notificationBackendService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateNotificationAsOpened(null, null, null, null, this);
    }
}
