package com.revenuecat.purchases.common;

import android.app.Activity;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesStateProvider;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BillingAbstract.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001:\u0002STB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u0015H$JH\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020 2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00150%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150%H&J4\u0010(\u001a\u00020\u00152\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00150%2\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150%j\u0002`*H&J\b\u0010+\u001a\u00020\u0018H&JE\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u0001042\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0002\u00106JW\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020 2!\u0010)\u001a\u001d\u0012\u0013\u0012\u00110 ¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u00150%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150%H\u0016JB\u0010>\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u0018\u0010?\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0@\u0012\u0004\u0012\u00020\u00150%2\u0016\u0010A\u001a\u0012\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150%j\u0002`*H&JT\u0010B\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020 0D2\u001c\u0010E\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0@\u0012\u0004\u0012\u00020\u00150%j\u0002`G2\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150%j\u0002`*H&JD\u0010H\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001a0I\u0012\u0004\u0012\u00020\u00150%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150%H&J,\u0010J\u001a\u00020\u00152\u0006\u0010-\u001a\u00020.2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L0@2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00150NH&J\b\u0010O\u001a\u00020\u0015H&J\u0012\u0010P\u001a\u00020\u00152\b\b\u0002\u0010Q\u001a\u00020RH&R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR*\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006U"}, d2 = {"Lcom/revenuecat/purchases/common/BillingAbstract;", "", "purchasesStateProvider", "Lcom/revenuecat/purchases/PurchasesStateProvider;", "(Lcom/revenuecat/purchases/PurchasesStateProvider;)V", "getPurchasesStateProvider", "()Lcom/revenuecat/purchases/PurchasesStateProvider;", "purchasesUpdatedListener", "Lcom/revenuecat/purchases/common/BillingAbstract$PurchasesUpdatedListener;", "getPurchasesUpdatedListener", "()Lcom/revenuecat/purchases/common/BillingAbstract$PurchasesUpdatedListener;", "setPurchasesUpdatedListener", "(Lcom/revenuecat/purchases/common/BillingAbstract$PurchasesUpdatedListener;)V", "<set-?>", "Lcom/revenuecat/purchases/common/BillingAbstract$StateListener;", "stateListener", "getStateListener", "()Lcom/revenuecat/purchases/common/BillingAbstract$StateListener;", "setStateListener", "(Lcom/revenuecat/purchases/common/BillingAbstract$StateListener;)V", "close", "", "consumeAndSave", "shouldTryToConsume", "", "purchase", "Lcom/revenuecat/purchases/models/StoreTransaction;", "initiationSource", "Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "endConnection", "findPurchaseInPurchaseHistory", "appUserID", "", "productType", "Lcom/revenuecat/purchases/ProductType;", "productId", "onCompletion", "Lkotlin/Function1;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "getStorefront", "onSuccess", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "isConnected", "makePurchaseAsync", "activity", "Landroid/app/Activity;", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "replaceProductInfo", "Lcom/revenuecat/purchases/common/ReplaceProductInfo;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "isPersonalizedPrice", "(Landroid/app/Activity;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchasingData;Lcom/revenuecat/purchases/common/ReplaceProductInfo;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/Boolean;)V", "normalizePurchaseData", "productID", "purchaseToken", "storeUserID", "Lkotlin/ParameterName;", "name", "normalizedProductID", "queryAllPurchases", "onReceivePurchaseHistory", "", "onReceivePurchaseHistoryError", "queryProductDetailsAsync", "productIds", "", "onReceive", "Lcom/revenuecat/purchases/models/StoreProduct;", "Lcom/revenuecat/purchases/common/StoreProductsCallback;", "queryPurchases", "", "showInAppMessagesIfNeeded", "inAppMessageTypes", "Lcom/revenuecat/purchases/models/InAppMessageType;", "subscriptionStatusChange", "Lkotlin/Function0;", "startConnection", "startConnectionOnMainThread", "delayMilliseconds", "", "PurchasesUpdatedListener", "StateListener", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BillingAbstract {
    private final PurchasesStateProvider purchasesStateProvider;
    private volatile PurchasesUpdatedListener purchasesUpdatedListener;
    private volatile StateListener stateListener;

    /* compiled from: BillingAbstract.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/common/BillingAbstract$PurchasesUpdatedListener;", "", "onPurchasesFailedToUpdate", "", "purchasesError", "Lcom/revenuecat/purchases/PurchasesError;", "onPurchasesUpdated", "purchases", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public interface PurchasesUpdatedListener {
        void onPurchasesFailedToUpdate(PurchasesError purchasesError);

        void onPurchasesUpdated(List<StoreTransaction> purchases);
    }

    /* compiled from: BillingAbstract.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/revenuecat/purchases/common/BillingAbstract$StateListener;", "", "onConnected", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public interface StateListener {
        void onConnected();
    }

    public abstract void consumeAndSave(boolean shouldTryToConsume, StoreTransaction purchase, PostReceiptInitiationSource initiationSource);

    protected abstract void endConnection();

    public abstract void findPurchaseInPurchaseHistory(String appUserID, ProductType productType, String productId, Function1<? super StoreTransaction, Unit> onCompletion, Function1<? super PurchasesError, Unit> onError);

    public abstract void getStorefront(Function1<? super String, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError);

    public abstract boolean isConnected();

    public abstract void makePurchaseAsync(Activity activity, String appUserID, PurchasingData purchasingData, ReplaceProductInfo replaceProductInfo, PresentedOfferingContext presentedOfferingContext, Boolean isPersonalizedPrice);

    public abstract void queryAllPurchases(String appUserID, Function1<? super List<StoreTransaction>, Unit> onReceivePurchaseHistory, Function1<? super PurchasesError, Unit> onReceivePurchaseHistoryError);

    public abstract void queryProductDetailsAsync(ProductType productType, Set<String> productIds, Function1<? super List<? extends StoreProduct>, Unit> onReceive, Function1<? super PurchasesError, Unit> onError);

    public abstract void queryPurchases(String appUserID, Function1<? super Map<String, StoreTransaction>, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError);

    public abstract void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes, Function0<Unit> subscriptionStatusChange);

    public abstract void startConnection();

    public abstract void startConnectionOnMainThread(long delayMilliseconds);

    public BillingAbstract(PurchasesStateProvider purchasesStateProvider) {
        Intrinsics.checkNotNullParameter(purchasesStateProvider, "purchasesStateProvider");
        this.purchasesStateProvider = purchasesStateProvider;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final PurchasesStateProvider getPurchasesStateProvider() {
        return this.purchasesStateProvider;
    }

    public final synchronized StateListener getStateListener() {
        return this.stateListener;
    }

    public final synchronized void setStateListener(StateListener stateListener) {
        this.stateListener = stateListener;
    }

    public final synchronized PurchasesUpdatedListener getPurchasesUpdatedListener() {
        return this.purchasesUpdatedListener;
    }

    public final void setPurchasesUpdatedListener(PurchasesUpdatedListener purchasesUpdatedListener) {
        this.purchasesUpdatedListener = purchasesUpdatedListener;
    }

    public static /* synthetic */ void startConnectionOnMainThread$default(BillingAbstract billingAbstract, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startConnectionOnMainThread");
        }
        if ((i & 1) != 0) {
            j = 0;
        }
        billingAbstract.startConnectionOnMainThread(j);
    }

    public final void close() {
        this.purchasesUpdatedListener = null;
        endConnection();
    }

    public static /* synthetic */ void makePurchaseAsync$default(BillingAbstract billingAbstract, Activity activity, String str, PurchasingData purchasingData, ReplaceProductInfo replaceProductInfo, PresentedOfferingContext presentedOfferingContext, Boolean bool, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: makePurchaseAsync");
        }
        if ((i & 32) != 0) {
            bool = null;
        }
        billingAbstract.makePurchaseAsync(activity, str, purchasingData, replaceProductInfo, presentedOfferingContext, bool);
    }

    public void normalizePurchaseData(String productID, String purchaseToken, String storeUserID, Function1<? super String, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(productID, "productID");
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(storeUserID, "storeUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        onSuccess.invoke(productID);
    }
}
