package com.onesignal.inAppMessages.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InAppMessagesManager.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager", f = "InAppMessagesManager.kt", i = {0, 0, 0, 0, 1}, l = {902, 255, 259}, m = "fetchMessages", n = {"this", "appId", "subscriptionId", "$this$withLock_u24default$iv", "this"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
/* loaded from: classes5.dex */
public final class InAppMessagesManager$fetchMessages$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppMessagesManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessagesManager$fetchMessages$1(InAppMessagesManager inAppMessagesManager, Continuation<? super InAppMessagesManager$fetchMessages$1> continuation) {
        super(continuation);
        this.this$0 = inAppMessagesManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fetchMessages;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchMessages = this.this$0.fetchMessages(this);
        return fetchMessages;
    }
}
