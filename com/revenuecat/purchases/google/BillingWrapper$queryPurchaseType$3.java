package com.revenuecat.purchases.google;

import com.android.billingclient.api.BillingClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BillingWrapper.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public /* synthetic */ class BillingWrapper$queryPurchaseType$3 extends FunctionReferenceImpl implements Function1<Function1<? super BillingClient, ? extends Unit>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BillingWrapper$queryPurchaseType$3(Object obj) {
        super(1, obj, BillingWrapper.class, "withConnectedClient", "withConnectedClient(Lkotlin/jvm/functions/Function1;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Function1<? super BillingClient, ? extends Unit> function1) {
        invoke2((Function1<? super BillingClient, Unit>) function1);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Function1<? super BillingClient, Unit> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((BillingWrapper) this.receiver).withConnectedClient(p0);
    }
}
