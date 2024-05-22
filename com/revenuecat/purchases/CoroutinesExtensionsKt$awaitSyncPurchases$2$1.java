package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: coroutinesExtensions.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class CoroutinesExtensionsKt$awaitSyncPurchases$2$1 extends FunctionReferenceImpl implements Function1<CustomerInfo, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CoroutinesExtensionsKt$awaitSyncPurchases$2$1(Object obj) {
        super(1, obj, ContinuationKt.class, "resume", "resume(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
        invoke2(customerInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CustomerInfo p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Continuation continuation = (Continuation) this.receiver;
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m1318constructorimpl(p0));
    }
}
