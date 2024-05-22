package com.revenuecat.purchases.amazon.listener;

import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import com.revenuecat.purchases.PurchasesError;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PurchaseUpdatesResponseListener.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH\u0016J<\u0010\n\u001a\u00020\u00032\u001e\u0010\u000b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00030\u0011H&¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/amazon/listener/PurchaseUpdatesResponseListener;", "Lcom/amazon/device/iap/PurchasingListener;", "onProductDataResponse", "", "response", "Lcom/amazon/device/iap/model/ProductDataResponse;", "onPurchaseResponse", "Lcom/amazon/device/iap/model/PurchaseResponse;", "onUserDataResponse", "Lcom/amazon/device/iap/model/UserDataResponse;", "queryPurchases", "onSuccess", "Lkotlin/Function2;", "", "Lcom/amazon/device/iap/model/Receipt;", "Lcom/amazon/device/iap/model/UserData;", "onError", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface PurchaseUpdatesResponseListener extends PurchasingListener {

    /* compiled from: PurchaseUpdatesResponseListener.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static void onProductDataResponse(PurchaseUpdatesResponseListener purchaseUpdatesResponseListener, ProductDataResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
        }

        public static void onPurchaseResponse(PurchaseUpdatesResponseListener purchaseUpdatesResponseListener, PurchaseResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
        }

        public static void onUserDataResponse(PurchaseUpdatesResponseListener purchaseUpdatesResponseListener, UserDataResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
        }
    }

    @Override // com.amazon.device.iap.PurchasingListener
    void onProductDataResponse(ProductDataResponse response);

    @Override // com.amazon.device.iap.PurchasingListener
    void onPurchaseResponse(PurchaseResponse response);

    @Override // com.amazon.device.iap.PurchasingListener
    void onUserDataResponse(UserDataResponse response);

    void queryPurchases(Function2<? super List<Receipt>, ? super UserData, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError);
}
