package com.onesignal.notifications.internal.generation.impl;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.notifications.internal.common.NotificationConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationGenerationProcessor.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor", f = "NotificationGenerationProcessor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, 57, 72, 93, 104, 127, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, 140, 146}, m = "processNotificationData", n = {"this", "context", "jsonPayload", NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID, "isRestoring", "timestamp", "this", "context", "jsonPayload", OneSignalDbContract.NotificationTable.TABLE_NAME, "isRestoring", "timestamp", "this", OneSignalDbContract.NotificationTable.TABLE_NAME, "notificationJob", "wantsToDisplay", "isRestoring", "didDisplay", "this", OneSignalDbContract.NotificationTable.TABLE_NAME, "notificationJob", "wantsToDisplay", "isRestoring", "didDisplay", "this", "notificationJob", "wantsToDisplay", "isRestoring", "didDisplay", "this", "notificationJob", "isRestoring", "didDisplay", "this", "notificationJob", "isRestoring", "isRestoring"}, s = {"L$0", "L$1", "L$2", "I$0", "Z$0", "J$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "J$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "L$0", "L$1", "L$2", "Z$0", "I$0", "L$0", "L$1", "Z$0", "I$0", "L$0", "L$1", "Z$0", "Z$0"})
/* loaded from: classes5.dex */
public final class NotificationGenerationProcessor$processNotificationData$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationGenerationProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationGenerationProcessor$processNotificationData$1(NotificationGenerationProcessor notificationGenerationProcessor, Continuation<? super NotificationGenerationProcessor$processNotificationData$1> continuation) {
        super(continuation);
        this.this$0 = notificationGenerationProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.processNotificationData(null, 0, null, false, 0L, this);
    }
}
