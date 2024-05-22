package com.onesignal.notifications.internal.summary.impl;

import com.facebook.imagepipeline.common.RotationOptions;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationSummaryManager.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager", f = "NotificationSummaryManager.kt", i = {0, 1}, l = {88, RotationOptions.ROTATE_90}, m = "restoreSummary", n = {"this", "this"}, s = {"L$0", "L$0"})
/* loaded from: classes5.dex */
public final class NotificationSummaryManager$restoreSummary$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationSummaryManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationSummaryManager$restoreSummary$1(NotificationSummaryManager notificationSummaryManager, Continuation<? super NotificationSummaryManager$restoreSummary$1> continuation) {
        super(continuation);
        this.this$0 = notificationSummaryManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object restoreSummary;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        restoreSummary = this.this$0.restoreSummary(null, this);
        return restoreSummary;
    }
}
