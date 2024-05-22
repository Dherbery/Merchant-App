package com.revenuecat.purchases.interfaces;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.List;
import kotlin.Metadata;

/* compiled from: GetStoreProductsCallback.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH'¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/interfaces/GetStoreProductsCallback;", "", "onError", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "onReceived", "storeProducts", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface GetStoreProductsCallback {
    void onError(PurchasesError error);

    void onReceived(List<StoreProduct> storeProducts);
}
