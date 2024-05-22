package com.onesignal.notifications.internal.receivereceipt.impl;

import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReceiveReceiptWorkManager.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager$ReceiveReceiptWorker", f = "ReceiveReceiptWorkManager.kt", i = {}, l = {JpegTranscoderUtils.DEFAULT_JPEG_QUALITY}, m = "doWork", n = {}, s = {})
/* loaded from: classes5.dex */
public final class ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReceiveReceiptWorkManager.ReceiveReceiptWorker this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1(ReceiveReceiptWorkManager.ReceiveReceiptWorker receiveReceiptWorker, Continuation<? super ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1> continuation) {
        super(continuation);
        this.this$0 = receiveReceiptWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doWork(this);
    }
}
