package com.revenuecat.purchases.amazon;

import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.UserData;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.PurchaseType;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: storeTransactionConversions.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¨\u0006\u000b"}, d2 = {"toStoreTransaction", "Lcom/revenuecat/purchases/models/StoreTransaction;", "Lcom/amazon/device/iap/model/Receipt;", "productId", "", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "purchaseState", "Lcom/revenuecat/purchases/models/PurchaseState;", "userData", "Lcom/amazon/device/iap/model/UserData;", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class StoreTransactionConversionsKt {
    public static final StoreTransaction toStoreTransaction(Receipt receipt, String productId, PresentedOfferingContext presentedOfferingContext, PurchaseState purchaseState, UserData userData) {
        Intrinsics.checkNotNullParameter(receipt, "<this>");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(purchaseState, "purchaseState");
        Intrinsics.checkNotNullParameter(userData, "userData");
        ProductType productType = receipt.getProductType();
        Intrinsics.checkNotNullExpressionValue(productType, "this.productType");
        com.revenuecat.purchases.ProductType revenueCatProductType = ProductTypeConversionsKt.toRevenueCatProductType(productType);
        List listOf = CollectionsKt.listOf(productId);
        long time = receipt.getPurchaseDate().getTime();
        String receiptId = receipt.getReceiptId();
        Intrinsics.checkNotNullExpressionValue(receiptId, "this.receiptId");
        boolean z = false;
        if (revenueCatProductType == com.revenuecat.purchases.ProductType.SUBS && !receipt.isCanceled()) {
            z = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        JSONObject json = receipt.toJSON();
        Intrinsics.checkNotNullExpressionValue(json, "this.toJSON()");
        return new StoreTransaction((String) null, (List<String>) listOf, revenueCatProductType, time, receiptId, purchaseState, valueOf, (String) null, json, presentedOfferingContext, userData.getUserId(), PurchaseType.AMAZON_PURCHASE, userData.getMarketplace(), (String) null, (ReplacementMode) null);
    }
}
