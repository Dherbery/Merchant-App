package com.revenuecat.purchases;

import android.app.Activity;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.interfaces.LogInCallback;
import com.revenuecat.purchases.interfaces.ProductChangeCallback;
import com.revenuecat.purchases.interfaces.SyncPurchasesCallback;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: listenerConversions.kt */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ag\u0010\u0000\u001a\u00020\u000128\u0010\u0002\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00032#\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0006\u0012\u0004\u0018\u00010\n0\fH\u0000\u001az\u0010\u000f\u001a\u00020\u001028\u0010\u0002\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\n0\u000326\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\n0\u0003H\u0000\u001a?\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\f2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n0\fH\u0000\u001aR\u0010\u0016\u001a\u00020\n*\u00020\u00172#\b\u0002\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n0\f2!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\n0\f\u001aZ\u0010\u0016\u001a\u00020\n*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192#\b\u0002\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n0\f2!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\n0\f\u001af\u0010\u001a\u001a\u00020\n*\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n0\f2'\u0010\u001e\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001f0\u001c¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\n0\fH\u0007\u001ah\u0010!\u001a\u00020\n*\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2#\b\u0002\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n0\f2'\u0010\u001e\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001f0\u001c¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\n0\fH\u0007\u001ao\u0010\"\u001a\u00020\n*\u00020\u00172\u0006\u0010#\u001a\u00020\u001d2#\b\u0002\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n0\f26\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003\u001aR\u0010$\u001a\u00020\n*\u00020\u00172#\b\u0002\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n0\f2!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\n0\f\u001a\u008e\u0001\u0010%\u001a\u00020\n*\u00020\u00172\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)28\b\u0002\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\n0\u000326\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\n0\u0003H\u0007\u001a\u0098\u0001\u0010%\u001a\u00020\n*\u00020\u00172\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+28\b\u0002\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\n0\u000328\u0010\u0002\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\n0\u0003H\u0007\u001a\u008e\u0001\u0010,\u001a\u00020\n*\u00020\u00172\u0006\u0010&\u001a\u00020'2\u0006\u0010-\u001a\u00020\u001f28\b\u0002\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\n0\u000326\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\n0\u0003H\u0007\u001a\u0098\u0001\u0010,\u001a\u00020\n*\u00020\u00172\u0006\u0010&\u001a\u00020'2\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+28\b\u0002\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\n0\u000328\u0010\u0002\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\n0\u0003H\u0007\u001aC\u0010.\u001a\u00020\n*\u00020\u00172#\b\u0002\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n0\f2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\f¨\u0006/"}, d2 = {"logInSuccessListener", "Lcom/revenuecat/purchases/interfaces/LogInCallback;", "onSuccess", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/CustomerInfo;", "Lkotlin/ParameterName;", "name", "customerInfo", "", "created", "", "onError", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "error", "productChangeCompletedListener", "Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;", "Lcom/revenuecat/purchases/models/StoreTransaction;", "purchase", "userCancelled", "syncPurchasesListener", "Lcom/revenuecat/purchases/interfaces/SyncPurchasesCallback;", "getCustomerInfoWith", "Lcom/revenuecat/purchases/Purchases;", "fetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "getNonSubscriptionSkusWith", b.O, "", "", "onReceiveSkus", "Lcom/revenuecat/purchases/models/StoreProduct;", "storeProducts", "getSubscriptionSkusWith", "logInWith", "appUserID", "logOutWith", "purchasePackageWith", "activity", "Landroid/app/Activity;", "packageToPurchase", "Lcom/revenuecat/purchases/Package;", "upgradeInfo", "Lcom/revenuecat/purchases/UpgradeInfo;", "purchaseProductWith", "storeProduct", "syncPurchasesWith", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ListenerConversionsKt {
    public static final LogInCallback logInSuccessListener(final Function2<? super CustomerInfo, ? super Boolean, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new LogInCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt$logInSuccessListener$1
            @Override // com.revenuecat.purchases.interfaces.LogInCallback
            public void onReceived(CustomerInfo customerInfo, boolean created) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Function2<CustomerInfo, Boolean, Unit> function2 = onSuccess;
                if (function2 != null) {
                    function2.invoke(customerInfo, Boolean.valueOf(created));
                }
            }

            @Override // com.revenuecat.purchases.interfaces.LogInCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                Function1<PurchasesError, Unit> function1 = onError;
                if (function1 != null) {
                    function1.invoke(error);
                }
            }
        };
    }

    public static final ProductChangeCallback productChangeCompletedListener(final Function2<? super StoreTransaction, ? super CustomerInfo, Unit> onSuccess, final Function2<? super PurchasesError, ? super Boolean, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new ProductChangeCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt$productChangeCompletedListener$1
            @Override // com.revenuecat.purchases.interfaces.ProductChangeCallback
            public void onCompleted(StoreTransaction purchase, CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                onSuccess.invoke(purchase, customerInfo);
            }

            @Override // com.revenuecat.purchases.interfaces.PurchaseErrorCallback
            public void onError(PurchasesError error, boolean userCancelled) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error, Boolean.valueOf(userCancelled));
            }
        };
    }

    public static final SyncPurchasesCallback syncPurchasesListener(final Function1<? super CustomerInfo, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new SyncPurchasesCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt$syncPurchasesListener$1
            @Override // com.revenuecat.purchases.interfaces.SyncPurchasesCallback
            public void onSuccess(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                onSuccess.invoke(customerInfo);
            }

            @Override // com.revenuecat.purchases.interfaces.SyncPurchasesCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }
        };
    }

    public static /* synthetic */ void purchaseProductWith$default(Purchases purchases, Activity activity, StoreProduct storeProduct, Function2 function2, Function2 function22, int i, Object obj) {
        if ((i & 4) != 0) {
            function2 = ListenerConversionsCommonKt.getON_PURCHASE_ERROR_STUB();
        }
        purchaseProductWith(purchases, activity, storeProduct, function2, function22);
    }

    @Deprecated(message = "Use purchase() and PurchaseParams.Builder instead", replaceWith = @ReplaceWith(expression = "purchase()", imports = {}))
    public static final void purchaseProductWith(Purchases purchases, Activity activity, StoreProduct storeProduct, Function2<? super PurchasesError, ? super Boolean, Unit> onError, Function2<? super StoreTransaction, ? super CustomerInfo, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.purchaseProduct(activity, storeProduct, ListenerConversionsCommonKt.purchaseCompletedCallback(onSuccess, onError));
    }

    public static /* synthetic */ void purchaseProductWith$default(Purchases purchases, Activity activity, StoreProduct storeProduct, UpgradeInfo upgradeInfo, Function2 function2, Function2 function22, int i, Object obj) {
        if ((i & 8) != 0) {
            function2 = ListenerConversionsCommonKt.getON_PURCHASE_ERROR_STUB();
        }
        purchaseProductWith(purchases, activity, storeProduct, upgradeInfo, function2, function22);
    }

    @Deprecated(message = "Use purchaseWith and PurchaseParams.Builder instead", replaceWith = @ReplaceWith(expression = "purchaseWith()", imports = {}))
    public static final void purchaseProductWith(Purchases purchases, Activity activity, StoreProduct storeProduct, UpgradeInfo upgradeInfo, Function2<? super PurchasesError, ? super Boolean, Unit> onError, Function2<? super StoreTransaction, ? super CustomerInfo, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        Intrinsics.checkNotNullParameter(upgradeInfo, "upgradeInfo");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.purchaseProduct(activity, storeProduct, upgradeInfo, productChangeCompletedListener(onSuccess, onError));
    }

    public static /* synthetic */ void purchasePackageWith$default(Purchases purchases, Activity activity, Package r8, UpgradeInfo upgradeInfo, Function2 function2, Function2 function22, int i, Object obj) {
        if ((i & 8) != 0) {
            function2 = ListenerConversionsCommonKt.getON_PURCHASE_ERROR_STUB();
        }
        purchasePackageWith(purchases, activity, r8, upgradeInfo, function2, function22);
    }

    @Deprecated(message = "Use purchaseWith and PurchaseParams.Builder instead", replaceWith = @ReplaceWith(expression = "purchaseWith()", imports = {}))
    public static final void purchasePackageWith(Purchases purchases, Activity activity, Package packageToPurchase, UpgradeInfo upgradeInfo, Function2<? super PurchasesError, ? super Boolean, Unit> onError, Function2<? super StoreTransaction, ? super CustomerInfo, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(packageToPurchase, "packageToPurchase");
        Intrinsics.checkNotNullParameter(upgradeInfo, "upgradeInfo");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.purchasePackage(activity, packageToPurchase, upgradeInfo, productChangeCompletedListener(onSuccess, onError));
    }

    public static /* synthetic */ void purchasePackageWith$default(Purchases purchases, Activity activity, Package r2, Function2 function2, Function2 function22, int i, Object obj) {
        if ((i & 4) != 0) {
            function2 = ListenerConversionsCommonKt.getON_PURCHASE_ERROR_STUB();
        }
        purchasePackageWith(purchases, activity, r2, function2, function22);
    }

    @Deprecated(message = "Use purchaseWith and PurchaseParams.Builder instead", replaceWith = @ReplaceWith(expression = "purchaseWith()", imports = {}))
    public static final void purchasePackageWith(Purchases purchases, Activity activity, Package packageToPurchase, Function2<? super PurchasesError, ? super Boolean, Unit> onError, Function2<? super StoreTransaction, ? super CustomerInfo, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(packageToPurchase, "packageToPurchase");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.purchasePackage(activity, packageToPurchase, ListenerConversionsCommonKt.purchaseCompletedCallback(onSuccess, onError));
    }

    public static /* synthetic */ void logInWith$default(Purchases purchases, String str, Function1 function1, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        logInWith(purchases, str, function1, function2);
    }

    public static final void logInWith(Purchases purchases, String appUserID, Function1<? super PurchasesError, Unit> onError, Function2<? super CustomerInfo, ? super Boolean, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.logIn(appUserID, logInSuccessListener(onSuccess, onError));
    }

    public static /* synthetic */ void logOutWith$default(Purchases purchases, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        logOutWith(purchases, function1, function12);
    }

    public static final void logOutWith(Purchases purchases, Function1<? super PurchasesError, Unit> onError, Function1<? super CustomerInfo, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.logOut(ListenerConversionsCommonKt.receiveCustomerInfoCallback(onSuccess, onError));
    }

    public static /* synthetic */ void getCustomerInfoWith$default(Purchases purchases, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getCustomerInfoWith(purchases, function1, function12);
    }

    public static final void getCustomerInfoWith(Purchases purchases, Function1<? super PurchasesError, Unit> onError, Function1<? super CustomerInfo, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.getCustomerInfo(ListenerConversionsCommonKt.receiveCustomerInfoCallback(onSuccess, onError));
    }

    public static /* synthetic */ void getCustomerInfoWith$default(Purchases purchases, CacheFetchPolicy cacheFetchPolicy, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getCustomerInfoWith(purchases, cacheFetchPolicy, function1, function12);
    }

    public static final void getCustomerInfoWith(Purchases purchases, CacheFetchPolicy fetchPolicy, Function1<? super PurchasesError, Unit> onError, Function1<? super CustomerInfo, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.getCustomerInfo(fetchPolicy, ListenerConversionsCommonKt.receiveCustomerInfoCallback(onSuccess, onError));
    }

    public static /* synthetic */ void syncPurchasesWith$default(Purchases purchases, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        syncPurchasesWith(purchases, function1, function12);
    }

    public static final void syncPurchasesWith(Purchases purchases, Function1<? super PurchasesError, Unit> onError, Function1<? super CustomerInfo, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.syncPurchases(syncPurchasesListener(onSuccess, onError));
    }

    public static /* synthetic */ void getSubscriptionSkusWith$default(Purchases purchases, List list, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getSubscriptionSkusWith(purchases, list, function1, function12);
    }

    @Deprecated(message = "Replaced with getProductsWith() which returns both subscriptions and non-subscriptions", replaceWith = @ReplaceWith(expression = "getProductsWith()", imports = {}))
    public static final void getSubscriptionSkusWith(Purchases purchases, List<String> skus, Function1<? super PurchasesError, Unit> onError, Function1<? super List<? extends StoreProduct>, Unit> onReceiveSkus) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(skus, "skus");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onReceiveSkus, "onReceiveSkus");
        purchases.getProducts(skus, ProductType.SUBS, ListenerConversionsCommonKt.getStoreProductsCallback(onReceiveSkus, onError));
    }

    @Deprecated(message = "Replaced with getProductsWith() which returns both subscriptions and non-subscriptions", replaceWith = @ReplaceWith(expression = "getProductsWith()", imports = {}))
    public static final void getNonSubscriptionSkusWith(Purchases purchases, List<String> skus, Function1<? super PurchasesError, Unit> onError, Function1<? super List<? extends StoreProduct>, Unit> onReceiveSkus) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(skus, "skus");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onReceiveSkus, "onReceiveSkus");
        purchases.getProducts(skus, ProductType.INAPP, ListenerConversionsCommonKt.getStoreProductsCallback(onReceiveSkus, onError));
    }
}
