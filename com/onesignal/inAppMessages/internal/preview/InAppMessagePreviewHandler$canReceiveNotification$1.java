package com.onesignal.inAppMessages.internal.preview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InAppMessagePreviewHandler.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler", f = "InAppMessagePreviewHandler.kt", i = {0}, l = {42, 48}, m = "canReceiveNotification", n = {"this"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class InAppMessagePreviewHandler$canReceiveNotification$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppMessagePreviewHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessagePreviewHandler$canReceiveNotification$1(InAppMessagePreviewHandler inAppMessagePreviewHandler, Continuation<? super InAppMessagePreviewHandler$canReceiveNotification$1> continuation) {
        super(continuation);
        this.this$0 = inAppMessagePreviewHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.canReceiveNotification(null, this);
    }
}
