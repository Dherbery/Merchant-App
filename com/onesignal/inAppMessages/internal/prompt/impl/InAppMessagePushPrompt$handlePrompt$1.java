package com.onesignal.inAppMessages.internal.prompt.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InAppMessagePushPrompt.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePushPrompt", f = "InAppMessagePushPrompt.kt", i = {}, l = {10}, m = "handlePrompt", n = {}, s = {})
/* loaded from: classes5.dex */
public final class InAppMessagePushPrompt$handlePrompt$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppMessagePushPrompt this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessagePushPrompt$handlePrompt$1(InAppMessagePushPrompt inAppMessagePushPrompt, Continuation<? super InAppMessagePushPrompt$handlePrompt$1> continuation) {
        super(continuation);
        this.this$0 = inAppMessagePushPrompt;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handlePrompt(this);
    }
}
