package com.revenuecat.purchases.google;

import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BillingWrapper.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class BillingWrapper$queryPurchases$2 extends FunctionReferenceImpl implements Function2<Long, Function1<? super PurchasesError, ? extends Unit>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BillingWrapper$queryPurchases$2(Object obj) {
        super(2, obj, BillingWrapper.class, "executeRequestOnUIThread", "executeRequestOnUIThread(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Function1<? super PurchasesError, ? extends Unit> function1) {
        invoke2(l, (Function1<? super PurchasesError, Unit>) function1);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l, Function1<? super PurchasesError, Unit> p1) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((BillingWrapper) this.receiver).executeRequestOnUIThread(l, p1);
    }
}
