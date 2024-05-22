package com.onesignal.notifications.internal.receivereceipt.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReceiveReceiptProcessor.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor", f = "ReceiveReceiptProcessor.kt", i = {}, l = {21}, m = "sendReceiveReceipt", n = {}, s = {})
/* loaded from: classes5.dex */
public final class ReceiveReceiptProcessor$sendReceiveReceipt$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReceiveReceiptProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReceiveReceiptProcessor$sendReceiveReceipt$1(ReceiveReceiptProcessor receiveReceiptProcessor, Continuation<? super ReceiveReceiptProcessor$sendReceiveReceipt$1> continuation) {
        super(continuation);
        this.this$0 = receiveReceiptProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sendReceiveReceipt(null, null, null, this);
    }
}
