package com.revenuecat.purchases.amazon;

import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AmazonBilling.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public /* synthetic */ class AmazonBilling$handleReceipt$2 extends FunctionReferenceImpl implements Function1<PurchasesError, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AmazonBilling$handleReceipt$2(Object obj) {
        super(1, obj, AmazonBilling.class, "onPurchaseError", "onPurchaseError(Lcom/revenuecat/purchases/PurchasesError;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
        invoke2(purchasesError);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PurchasesError p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((AmazonBilling) this.receiver).onPurchaseError(p0);
    }
}
