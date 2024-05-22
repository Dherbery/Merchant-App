package com.onesignal.user.internal.operations.impl.executors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubscriptionOperationExecutor.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor", f = "SubscriptionOperationExecutor.kt", i = {}, l = {221}, m = "transferSubscription", n = {}, s = {})
/* loaded from: classes5.dex */
public final class SubscriptionOperationExecutor$transferSubscription$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SubscriptionOperationExecutor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionOperationExecutor$transferSubscription$1(SubscriptionOperationExecutor subscriptionOperationExecutor, Continuation<? super SubscriptionOperationExecutor$transferSubscription$1> continuation) {
        super(continuation);
        this.this$0 = subscriptionOperationExecutor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object transferSubscription;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        transferSubscription = this.this$0.transferSubscription(null, this);
        return transferSubscription;
    }
}
