package com.onesignal.notifications.internal.restoration.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationRestoreProcessor.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor", f = "NotificationRestoreProcessor.kt", i = {0, 1}, l = {25, 28}, m = "process", n = {"this", "this"}, s = {"L$0", "L$0"})
/* loaded from: classes5.dex */
public final class NotificationRestoreProcessor$process$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationRestoreProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationRestoreProcessor$process$1(NotificationRestoreProcessor notificationRestoreProcessor, Continuation<? super NotificationRestoreProcessor$process$1> continuation) {
        super(continuation);
        this.this$0 = notificationRestoreProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.process(this);
    }
}
