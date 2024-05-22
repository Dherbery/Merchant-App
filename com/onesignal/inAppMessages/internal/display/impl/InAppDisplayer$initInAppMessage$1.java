package com.onesignal.inAppMessages.internal.display.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InAppDisplayer.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer", f = "InAppDisplayer.kt", i = {}, l = {145}, m = "initInAppMessage", n = {}, s = {})
/* loaded from: classes5.dex */
public final class InAppDisplayer$initInAppMessage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppDisplayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppDisplayer$initInAppMessage$1(InAppDisplayer inAppDisplayer, Continuation<? super InAppDisplayer$initInAppMessage$1> continuation) {
        super(continuation);
        this.this$0 = inAppDisplayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object initInAppMessage;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        initInAppMessage = this.this$0.initInAppMessage(null, null, null, this);
        return initInAppMessage;
    }
}
