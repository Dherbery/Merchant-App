package com.onesignal.inAppMessages.internal.backend.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InAppBackendService.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService", f = "InAppBackendService.kt", i = {0}, l = {148}, m = "sendIAMPageImpression", n = {"this"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class InAppBackendService$sendIAMPageImpression$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppBackendService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppBackendService$sendIAMPageImpression$1(InAppBackendService inAppBackendService, Continuation<? super InAppBackendService$sendIAMPageImpression$1> continuation) {
        super(continuation);
        this.this$0 = inAppBackendService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sendIAMPageImpression(null, null, null, null, null, this);
    }
}
