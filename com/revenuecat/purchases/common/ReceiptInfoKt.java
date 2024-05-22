package com.revenuecat.purchases.common;

import com.revenuecat.purchases.models.GoogleSubscriptionOption;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReceiptInfo.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"platformProductId", "Lcom/revenuecat/purchases/common/PlatformProductId;", "Lcom/revenuecat/purchases/models/StoreProduct;", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ReceiptInfoKt {
    public static final PlatformProductId platformProductId(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        return new PlatformProductId(storeProduct.getId());
    }

    public static final PlatformProductId platformProductId(SubscriptionOption subscriptionOption) {
        Intrinsics.checkNotNullParameter(subscriptionOption, "<this>");
        if (!(subscriptionOption instanceof GoogleSubscriptionOption)) {
            return null;
        }
        GoogleSubscriptionOption googleSubscriptionOption = (GoogleSubscriptionOption) subscriptionOption;
        return new GooglePlatformProductId(googleSubscriptionOption.getProductId(), googleSubscriptionOption.getBasePlanId(), googleSubscriptionOption.getOfferId());
    }
}
