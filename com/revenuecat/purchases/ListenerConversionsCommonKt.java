package com.revenuecat.purchases;

import com.revenuecat.purchases.interfaces.GetStoreProductsCallback;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListenerConversionsCommon.kt */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aT\u0010\u000f\u001a\u00020\u00102'\u0010\u0011\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00060\u00012!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001H\u0000\u001ax\u0010\u0016\u001a\u00020\u001726\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00060\n26\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\nH\u0000\u001aR\u0010\u001d\u001a\u00020\u001e2#\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00012#\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001H\u0000\u001aN\u0010\u001f\u001a\u00020 2!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110!¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00060\u00012!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001H\u0000\u001aR\u0010#\u001a\u00020\u0006*\u00020$2#\b\u0002\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110!¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00060\u0001\u001af\u0010%\u001a\u00020\u0006*\u00020$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00122#\b\u0002\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012'\u0010(\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00060\u0001\u001ap\u0010%\u001a\u00020\u0006*\u00020$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00122\b\u0010)\u001a\u0004\u0018\u00010*2#\b\u0002\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012'\u0010(\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00060\u0001\u001a\u0086\u0001\u0010+\u001a\u00020\u0006*\u00020$2\u0006\u0010,\u001a\u00020-28\b\u0002\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\n28\u0010\u0018\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00060\n\u001aR\u0010.\u001a\u00020\u0006*\u00020$2#\b\u0002\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00060\u0001\"/\u0010\u0000\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"D\u0010\t\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006/"}, d2 = {"ON_ERROR_STUB", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "Lkotlin/ParameterName;", "name", "error", "", "getON_ERROR_STUB", "()Lkotlin/jvm/functions/Function1;", "ON_PURCHASE_ERROR_STUB", "Lkotlin/Function2;", "", "userCancelled", "getON_PURCHASE_ERROR_STUB", "()Lkotlin/jvm/functions/Function2;", "getStoreProductsCallback", "Lcom/revenuecat/purchases/interfaces/GetStoreProductsCallback;", "onReceived", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "storeProducts", "onError", "purchaseCompletedCallback", "Lcom/revenuecat/purchases/interfaces/PurchaseCallback;", "onSuccess", "Lcom/revenuecat/purchases/models/StoreTransaction;", "purchase", "Lcom/revenuecat/purchases/CustomerInfo;", "customerInfo", "receiveCustomerInfoCallback", "Lcom/revenuecat/purchases/interfaces/ReceiveCustomerInfoCallback;", "receiveOfferingsCallback", "Lcom/revenuecat/purchases/interfaces/ReceiveOfferingsCallback;", "Lcom/revenuecat/purchases/Offerings;", "offerings", "getOfferingsWith", "Lcom/revenuecat/purchases/Purchases;", "getProductsWith", "productIds", "", "onGetStoreProducts", "type", "Lcom/revenuecat/purchases/ProductType;", "purchaseWith", "purchaseParams", "Lcom/revenuecat/purchases/PurchaseParams;", "restorePurchasesWith", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ListenerConversionsCommonKt {
    private static final Function1<PurchasesError, Unit> ON_ERROR_STUB = new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.ListenerConversionsCommonKt$ON_ERROR_STUB$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PurchasesError it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
            invoke2(purchasesError);
            return Unit.INSTANCE;
        }
    };
    private static final Function2<PurchasesError, Boolean, Unit> ON_PURCHASE_ERROR_STUB = new Function2<PurchasesError, Boolean, Unit>() { // from class: com.revenuecat.purchases.ListenerConversionsCommonKt$ON_PURCHASE_ERROR_STUB$1
        public final void invoke(PurchasesError purchasesError, boolean z) {
            Intrinsics.checkNotNullParameter(purchasesError, "<anonymous parameter 0>");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, Boolean bool) {
            invoke(purchasesError, bool.booleanValue());
            return Unit.INSTANCE;
        }
    };

    public static final Function1<PurchasesError, Unit> getON_ERROR_STUB() {
        return ON_ERROR_STUB;
    }

    public static final Function2<PurchasesError, Boolean, Unit> getON_PURCHASE_ERROR_STUB() {
        return ON_PURCHASE_ERROR_STUB;
    }

    public static final PurchaseCallback purchaseCompletedCallback(final Function2<? super StoreTransaction, ? super CustomerInfo, Unit> onSuccess, final Function2<? super PurchasesError, ? super Boolean, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new PurchaseCallback() { // from class: com.revenuecat.purchases.ListenerConversionsCommonKt$purchaseCompletedCallback$1
            @Override // com.revenuecat.purchases.interfaces.PurchaseCallback
            public void onCompleted(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                onSuccess.invoke(storeTransaction, customerInfo);
            }

            @Override // com.revenuecat.purchases.interfaces.PurchaseErrorCallback
            public void onError(PurchasesError error, boolean userCancelled) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error, Boolean.valueOf(userCancelled));
            }
        };
    }

    public static final GetStoreProductsCallback getStoreProductsCallback(final Function1<? super List<? extends StoreProduct>, Unit> onReceived, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onReceived, "onReceived");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new GetStoreProductsCallback() { // from class: com.revenuecat.purchases.ListenerConversionsCommonKt$getStoreProductsCallback$1
            @Override // com.revenuecat.purchases.interfaces.GetStoreProductsCallback
            public void onReceived(List<? extends StoreProduct> storeProducts) {
                Intrinsics.checkNotNullParameter(storeProducts, "storeProducts");
                onReceived.invoke(storeProducts);
            }

            @Override // com.revenuecat.purchases.interfaces.GetStoreProductsCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }
        };
    }

    public static final ReceiveOfferingsCallback receiveOfferingsCallback(final Function1<? super Offerings, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new ReceiveOfferingsCallback() { // from class: com.revenuecat.purchases.ListenerConversionsCommonKt$receiveOfferingsCallback$1
            @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
            public void onReceived(Offerings offerings) {
                Intrinsics.checkNotNullParameter(offerings, "offerings");
                onSuccess.invoke(offerings);
            }

            @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }
        };
    }

    public static final ReceiveCustomerInfoCallback receiveCustomerInfoCallback(final Function1<? super CustomerInfo, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new ReceiveCustomerInfoCallback() { // from class: com.revenuecat.purchases.ListenerConversionsCommonKt$receiveCustomerInfoCallback$1
            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onReceived(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Function1<CustomerInfo, Unit> function1 = onSuccess;
                if (function1 != null) {
                    function1.invoke(customerInfo);
                }
            }

            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                Function1<PurchasesError, Unit> function1 = onError;
                if (function1 != null) {
                    function1.invoke(error);
                }
            }
        };
    }

    public static /* synthetic */ void getOfferingsWith$default(Purchases purchases, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ON_ERROR_STUB;
        }
        getOfferingsWith(purchases, function1, function12);
    }

    public static final void getOfferingsWith(Purchases purchases, Function1<? super PurchasesError, Unit> onError, Function1<? super Offerings, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.getOfferings(receiveOfferingsCallback(onSuccess, onError));
    }

    public static /* synthetic */ void purchaseWith$default(Purchases purchases, PurchaseParams purchaseParams, Function2 function2, Function2 function22, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = ON_PURCHASE_ERROR_STUB;
        }
        purchaseWith(purchases, purchaseParams, function2, function22);
    }

    public static final void purchaseWith(Purchases purchases, PurchaseParams purchaseParams, Function2<? super PurchasesError, ? super Boolean, Unit> onError, Function2<? super StoreTransaction, ? super CustomerInfo, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(purchaseParams, "purchaseParams");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.purchase(purchaseParams, purchaseCompletedCallback(onSuccess, onError));
    }

    public static /* synthetic */ void getProductsWith$default(Purchases purchases, List list, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = ON_ERROR_STUB;
        }
        getProductsWith(purchases, list, function1, function12);
    }

    public static final void getProductsWith(Purchases purchases, List<String> productIds, Function1<? super PurchasesError, Unit> onError, Function1<? super List<? extends StoreProduct>, Unit> onGetStoreProducts) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onGetStoreProducts, "onGetStoreProducts");
        purchases.getProducts(productIds, getStoreProductsCallback(onGetStoreProducts, onError));
    }

    public static /* synthetic */ void getProductsWith$default(Purchases purchases, List list, ProductType productType, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = ON_ERROR_STUB;
        }
        getProductsWith(purchases, list, productType, function1, function12);
    }

    public static final void getProductsWith(Purchases purchases, List<String> productIds, ProductType productType, Function1<? super PurchasesError, Unit> onError, Function1<? super List<? extends StoreProduct>, Unit> onGetStoreProducts) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onGetStoreProducts, "onGetStoreProducts");
        purchases.getProducts(productIds, productType, getStoreProductsCallback(onGetStoreProducts, onError));
    }

    public static /* synthetic */ void restorePurchasesWith$default(Purchases purchases, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ON_ERROR_STUB;
        }
        restorePurchasesWith(purchases, function1, function12);
    }

    public static final void restorePurchasesWith(Purchases purchases, Function1<? super PurchasesError, Unit> onError, Function1<? super CustomerInfo, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.restorePurchases(receiveCustomerInfoCallback(onSuccess, onError));
    }
}
