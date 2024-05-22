package com.onesignal.session.internal.outcomes.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OutcomeEventsController.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsController", f = "OutcomeEventsController.kt", i = {0, 0, 0}, l = {140, 153, 169}, m = "sendUniqueOutcomeEvent", n = {"this", "name", "influences"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes5.dex */
public final class OutcomeEventsController$sendUniqueOutcomeEvent$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OutcomeEventsController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutcomeEventsController$sendUniqueOutcomeEvent$2(OutcomeEventsController outcomeEventsController, Continuation<? super OutcomeEventsController$sendUniqueOutcomeEvent$2> continuation) {
        super(continuation);
        this.this$0 = outcomeEventsController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object sendUniqueOutcomeEvent;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        sendUniqueOutcomeEvent = this.this$0.sendUniqueOutcomeEvent(null, null, this);
        return sendUniqueOutcomeEvent;
    }
}
