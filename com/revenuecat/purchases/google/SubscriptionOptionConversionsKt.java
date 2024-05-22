package com.revenuecat.purchases.google;

import com.android.billingclient.api.ProductDetails;
import com.revenuecat.purchases.models.GoogleSubscriptionOption;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: subscriptionOptionConversions.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"isBasePlan", "", "Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;", "(Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;)Z", "subscriptionBillingPeriod", "", "getSubscriptionBillingPeriod", "(Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;)Ljava/lang/String;", "toSubscriptionOption", "Lcom/revenuecat/purchases/models/GoogleSubscriptionOption;", "productId", "productDetails", "Lcom/android/billingclient/api/ProductDetails;", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriptionOptionConversionsKt {
    public static final GoogleSubscriptionOption toSubscriptionOption(ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails, String productId, ProductDetails productDetails) {
        Intrinsics.checkNotNullParameter(subscriptionOfferDetails, "<this>");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        List<ProductDetails.PricingPhase> pricingPhaseList = subscriptionOfferDetails.getPricingPhases().getPricingPhaseList();
        Intrinsics.checkNotNullExpressionValue(pricingPhaseList, "pricingPhases.pricingPhaseList");
        List<ProductDetails.PricingPhase> list = pricingPhaseList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ProductDetails.PricingPhase it : list) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(PricingPhaseConversionsKt.toRevenueCatPricingPhase(it));
        }
        ArrayList arrayList2 = arrayList;
        String basePlanId = subscriptionOfferDetails.getBasePlanId();
        Intrinsics.checkNotNullExpressionValue(basePlanId, "basePlanId");
        String offerId = subscriptionOfferDetails.getOfferId();
        List<String> offerTags = subscriptionOfferDetails.getOfferTags();
        Intrinsics.checkNotNullExpressionValue(offerTags, "offerTags");
        String offerToken = subscriptionOfferDetails.getOfferToken();
        Intrinsics.checkNotNullExpressionValue(offerToken, "offerToken");
        return new GoogleSubscriptionOption(productId, basePlanId, offerId, arrayList2, offerTags, productDetails, offerToken, null, 128, null);
    }

    public static final String getSubscriptionBillingPeriod(ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails) {
        Intrinsics.checkNotNullParameter(subscriptionOfferDetails, "<this>");
        List<ProductDetails.PricingPhase> pricingPhaseList = subscriptionOfferDetails.getPricingPhases().getPricingPhaseList();
        Intrinsics.checkNotNullExpressionValue(pricingPhaseList, "this.pricingPhases.pricingPhaseList");
        ProductDetails.PricingPhase pricingPhase = (ProductDetails.PricingPhase) CollectionsKt.lastOrNull((List) pricingPhaseList);
        if (pricingPhase != null) {
            return pricingPhase.getBillingPeriod();
        }
        return null;
    }

    public static final boolean isBasePlan(ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails) {
        Intrinsics.checkNotNullParameter(subscriptionOfferDetails, "<this>");
        return subscriptionOfferDetails.getPricingPhases().getPricingPhaseList().size() == 1;
    }
}
