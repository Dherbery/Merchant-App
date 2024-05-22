package com.onesignal.inAppMessages.internal.display.impl;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InAppDisplayer.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer", f = "InAppDisplayer.kt", i = {0, 0}, l = {73, 79}, m = "displayPreviewMessage", n = {"this", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE}, s = {"L$0", "L$1"})
/* loaded from: classes5.dex */
public final class InAppDisplayer$displayPreviewMessage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppDisplayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppDisplayer$displayPreviewMessage$1(InAppDisplayer inAppDisplayer, Continuation<? super InAppDisplayer$displayPreviewMessage$1> continuation) {
        super(continuation);
        this.this$0 = inAppDisplayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.displayPreviewMessage(null, this);
    }
}
