package com.revenuecat.purchases.google;

import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PurchaseContext.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/google/PurchaseContext;", "", "productType", "Lcom/revenuecat/purchases/ProductType;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "selectedSubscriptionOptionId", "", "replacementMode", "Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "(Lcom/revenuecat/purchases/ProductType;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/String;Lcom/revenuecat/purchases/models/GoogleReplacementMode;)V", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getProductType", "()Lcom/revenuecat/purchases/ProductType;", "getReplacementMode", "()Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "getSelectedSubscriptionOptionId", "()Ljava/lang/String;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PurchaseContext {
    private final PresentedOfferingContext presentedOfferingContext;
    private final ProductType productType;
    private final GoogleReplacementMode replacementMode;
    private final String selectedSubscriptionOptionId;

    public PurchaseContext(ProductType productType, PresentedOfferingContext presentedOfferingContext, String str, GoogleReplacementMode googleReplacementMode) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        this.productType = productType;
        this.presentedOfferingContext = presentedOfferingContext;
        this.selectedSubscriptionOptionId = str;
        this.replacementMode = googleReplacementMode;
    }

    public final ProductType getProductType() {
        return this.productType;
    }

    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public final String getSelectedSubscriptionOptionId() {
        return this.selectedSubscriptionOptionId;
    }

    public final GoogleReplacementMode getReplacementMode() {
        return this.replacementMode;
    }
}
