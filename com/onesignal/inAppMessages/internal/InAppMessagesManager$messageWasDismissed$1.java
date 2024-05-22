package com.onesignal.inAppMessages.internal;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InAppMessagesManager.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager", f = "InAppMessagesManager.kt", i = {0, 0}, l = {415, 441, 444}, m = "messageWasDismissed", n = {"this", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE}, s = {"L$0", "L$1"})
/* loaded from: classes5.dex */
public final class InAppMessagesManager$messageWasDismissed$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppMessagesManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessagesManager$messageWasDismissed$1(InAppMessagesManager inAppMessagesManager, Continuation<? super InAppMessagesManager$messageWasDismissed$1> continuation) {
        super(continuation);
        this.this$0 = inAppMessagesManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object messageWasDismissed;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        messageWasDismissed = this.this$0.messageWasDismissed(null, false, this);
        return messageWasDismissed;
    }
}
