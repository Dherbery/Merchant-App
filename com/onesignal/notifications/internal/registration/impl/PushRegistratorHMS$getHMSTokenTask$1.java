package com.onesignal.notifications.internal.registration.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushRegistratorHMS.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS", f = "PushRegistratorHMS.kt", i = {0}, l = {77}, m = "getHMSTokenTask", n = {"pushToken"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class PushRegistratorHMS$getHMSTokenTask$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PushRegistratorHMS this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushRegistratorHMS$getHMSTokenTask$1(PushRegistratorHMS pushRegistratorHMS, Continuation<? super PushRegistratorHMS$getHMSTokenTask$1> continuation) {
        super(continuation);
        this.this$0 = pushRegistratorHMS;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object hMSTokenTask;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        hMSTokenTask = this.this$0.getHMSTokenTask(null, this);
        return hMSTokenTask;
    }
}
