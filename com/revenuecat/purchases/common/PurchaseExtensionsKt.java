package com.revenuecat.purchases.common;

import com.android.billingclient.api.Purchase;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: purchaseExtensions.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"firstProductId", "", "Lcom/android/billingclient/api/Purchase;", "getFirstProductId", "(Lcom/android/billingclient/api/Purchase;)Ljava/lang/String;", "toHumanReadableDescription", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PurchaseExtensionsKt {
    public static final String toHumanReadableDescription(Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "<this>");
        StringBuilder sb = new StringBuilder("productIds: ");
        List<String> products = purchase.getProducts();
        Intrinsics.checkNotNullExpressionValue(products, "this.products");
        sb.append(CollectionsKt.joinToString$default(products, null, "[", "]", 0, null, null, 57, null));
        sb.append(", orderId: ");
        sb.append(purchase.getOrderId());
        sb.append(", purchaseToken: ");
        sb.append(purchase.getPurchaseToken());
        return sb.toString();
    }

    public static final String getFirstProductId(Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "<this>");
        String str = purchase.getProducts().get(0);
        String str2 = str;
        if (purchase.getProducts().size() > 1) {
            LogWrapperKt.log(LogIntent.GOOGLE_WARNING, "There's more than one sku in the PurchaseHistoryRecord, but only one will be used.");
        }
        Intrinsics.checkNotNullExpressionValue(str, "products[0].also {\n     …_ONE_SKU)\n        }\n    }");
        return str2;
    }
}
