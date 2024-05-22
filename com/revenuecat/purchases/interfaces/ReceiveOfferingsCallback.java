package com.revenuecat.purchases.interfaces;

import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;

/* compiled from: ReceiveOfferingsCallback.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/interfaces/ReceiveOfferingsCallback;", "", "onError", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "onReceived", "offerings", "Lcom/revenuecat/purchases/Offerings;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface ReceiveOfferingsCallback {
    void onError(PurchasesError error);

    void onReceived(Offerings offerings);
}
