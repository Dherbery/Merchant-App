package com.onesignal.inAppMessages.internal;

import com.facebook.imageutils.TiffUtil;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InAppMessagesManager.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager", f = "InAppMessagesManager.kt", i = {0}, l = {TiffUtil.TIFF_TAG_ORIENTATION}, m = "evaluateInAppMessages", n = {"this"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class InAppMessagesManager$evaluateInAppMessages$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppMessagesManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessagesManager$evaluateInAppMessages$1(InAppMessagesManager inAppMessagesManager, Continuation<? super InAppMessagesManager$evaluateInAppMessages$1> continuation) {
        super(continuation);
        this.this$0 = inAppMessagesManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object evaluateInAppMessages;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        evaluateInAppMessages = this.this$0.evaluateInAppMessages(this);
        return evaluateInAppMessages;
    }
}
