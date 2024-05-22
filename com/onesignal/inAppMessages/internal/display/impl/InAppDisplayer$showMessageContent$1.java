package com.onesignal.inAppMessages.internal.display.impl;

import androidx.appcompat.app.AppCompatDelegate;
import com.facebook.common.util.UriUtil;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InAppDisplayer.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer", f = "InAppDisplayer.kt", i = {0, 0, 0, 0, 3, 3, 3}, l = {105, 107, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 114, 115}, m = "showMessageContent", n = {"this", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, UriUtil.LOCAL_CONTENT_SCHEME, "currentActivity", "this", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, UriUtil.LOCAL_CONTENT_SCHEME}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
/* loaded from: classes5.dex */
public final class InAppDisplayer$showMessageContent$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppDisplayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppDisplayer$showMessageContent$1(InAppDisplayer inAppDisplayer, Continuation<? super InAppDisplayer$showMessageContent$1> continuation) {
        super(continuation);
        this.this$0 = inAppDisplayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object showMessageContent;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        showMessageContent = this.this$0.showMessageContent(null, null, this);
        return showMessageContent;
    }
}
