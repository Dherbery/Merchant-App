package com.revenuecat.purchases.amazon.handler;

import android.os.Handler;
import com.amazon.a.a.o.b;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataResponse;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.amazon.AmazonStrings;
import com.revenuecat.purchases.amazon.PurchasingServiceProvider;
import com.revenuecat.purchases.amazon.StoreProductConversionsKt;
import com.revenuecat.purchases.amazon.listener.ProductDataResponseListener;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProductDataHandler.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0002JL\u0010\u0013\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0004\u0012\u00020\u00110\u00182\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00110\u0018H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002JB\u0010\u001e\u001a\u00020\u00112\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0 2\u0006\u0010\u0016\u001a\u00020\t2\u001c\u0010\u0017\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0004\u0012\u00020\u00110\u0018j\u0002`!H\u0002J(\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00110\u0018j\u0002`%H\u0002J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8@X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\b8BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/revenuecat/purchases/amazon/handler/ProductDataHandler;", "Lcom/revenuecat/purchases/amazon/listener/ProductDataResponseListener;", "purchasingServiceProvider", "Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;", "mainHandler", "Landroid/os/Handler;", "(Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;Landroid/os/Handler;)V", "productDataCache", "", "", "Lcom/amazon/device/iap/model/Product;", "getProductDataCache$purchases_defaultsRelease", "()Ljava/util/Map;", "productDataRequests", "Lcom/amazon/device/iap/model/RequestId;", "Lcom/revenuecat/purchases/amazon/handler/ProductDataHandler$Request;", "addTimeoutToProductDataRequest", "", b.B, "getProductData", b.O, "", b.m, "onReceive", "Lkotlin/Function1;", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "getRequest", "handleSuccessfulProductDataResponse", "productData", "", "Lcom/revenuecat/purchases/common/StoreProductsCallback;", "handleUnsuccessfulProductDataResponse", "response", "Lcom/amazon/device/iap/model/ProductDataResponse;", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "onProductDataResponse", "Companion", "Request", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ProductDataHandler implements ProductDataResponseListener {
    private static final long GET_PRODUCT_DATA_TIMEOUT_MILLIS = 10000;
    private final Handler mainHandler;
    private final Map<String, Product> productDataCache;
    private final Map<RequestId, Request> productDataRequests;
    private final PurchasingServiceProvider purchasingServiceProvider;

    public ProductDataHandler(PurchasingServiceProvider purchasingServiceProvider, Handler mainHandler) {
        Intrinsics.checkNotNullParameter(purchasingServiceProvider, "purchasingServiceProvider");
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        this.purchasingServiceProvider = purchasingServiceProvider;
        this.mainHandler = mainHandler;
        this.productDataRequests = new LinkedHashMap();
        this.productDataCache = new LinkedHashMap();
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener, com.amazon.device.iap.PurchasingListener
    public void onPurchaseResponse(PurchaseResponse purchaseResponse) {
        ProductDataResponseListener.DefaultImpls.onPurchaseResponse(this, purchaseResponse);
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener, com.amazon.device.iap.PurchasingListener
    public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse purchaseUpdatesResponse) {
        ProductDataResponseListener.DefaultImpls.onPurchaseUpdatesResponse(this, purchaseUpdatesResponse);
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener, com.amazon.device.iap.PurchasingListener
    public void onUserDataResponse(UserDataResponse userDataResponse) {
        ProductDataResponseListener.DefaultImpls.onUserDataResponse(this, userDataResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProductDataHandler.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BQ\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u001c\u0010\u0006\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\r¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\u001f\u0010\u0018\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\nHÆ\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\rHÆ\u0003J]\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u001e\b\u0002\u0010\u0006\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n2\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\rHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R'\u0010\u0006\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/revenuecat/purchases/amazon/handler/ProductDataHandler$Request;", "", "skuList", "", "", b.m, "onReceive", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/models/StoreProduct;", "", "Lcom/revenuecat/purchases/common/StoreProductsCallback;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "(Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getMarketplace", "()Ljava/lang/String;", "getOnError", "()Lkotlin/jvm/functions/Function1;", "getOnReceive", "getSkuList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Request {
        private final String marketplace;
        private final Function1<PurchasesError, Unit> onError;
        private final Function1<List<? extends StoreProduct>, Unit> onReceive;
        private final List<String> skuList;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Request copy$default(Request request, List list, String str, Function1 function1, Function1 function12, int i, Object obj) {
            if ((i & 1) != 0) {
                list = request.skuList;
            }
            if ((i & 2) != 0) {
                str = request.marketplace;
            }
            if ((i & 4) != 0) {
                function1 = request.onReceive;
            }
            if ((i & 8) != 0) {
                function12 = request.onError;
            }
            return request.copy(list, str, function1, function12);
        }

        public final List<String> component1() {
            return this.skuList;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMarketplace() {
            return this.marketplace;
        }

        public final Function1<List<? extends StoreProduct>, Unit> component3() {
            return this.onReceive;
        }

        public final Function1<PurchasesError, Unit> component4() {
            return this.onError;
        }

        public final Request copy(List<String> skuList, String marketplace, Function1<? super List<? extends StoreProduct>, Unit> onReceive, Function1<? super PurchasesError, Unit> onError) {
            Intrinsics.checkNotNullParameter(skuList, "skuList");
            Intrinsics.checkNotNullParameter(marketplace, "marketplace");
            Intrinsics.checkNotNullParameter(onReceive, "onReceive");
            Intrinsics.checkNotNullParameter(onError, "onError");
            return new Request(skuList, marketplace, onReceive, onError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Request)) {
                return false;
            }
            Request request = (Request) other;
            return Intrinsics.areEqual(this.skuList, request.skuList) && Intrinsics.areEqual(this.marketplace, request.marketplace) && Intrinsics.areEqual(this.onReceive, request.onReceive) && Intrinsics.areEqual(this.onError, request.onError);
        }

        public int hashCode() {
            return (((((this.skuList.hashCode() * 31) + this.marketplace.hashCode()) * 31) + this.onReceive.hashCode()) * 31) + this.onError.hashCode();
        }

        public String toString() {
            return "Request(skuList=" + this.skuList + ", marketplace=" + this.marketplace + ", onReceive=" + this.onReceive + ", onError=" + this.onError + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Request(List<String> skuList, String marketplace, Function1<? super List<? extends StoreProduct>, Unit> onReceive, Function1<? super PurchasesError, Unit> onError) {
            Intrinsics.checkNotNullParameter(skuList, "skuList");
            Intrinsics.checkNotNullParameter(marketplace, "marketplace");
            Intrinsics.checkNotNullParameter(onReceive, "onReceive");
            Intrinsics.checkNotNullParameter(onError, "onError");
            this.skuList = skuList;
            this.marketplace = marketplace;
            this.onReceive = onReceive;
            this.onError = onError;
        }

        public final List<String> getSkuList() {
            return this.skuList;
        }

        public final String getMarketplace() {
            return this.marketplace;
        }

        public final Function1<List<? extends StoreProduct>, Unit> getOnReceive() {
            return this.onReceive;
        }

        public final Function1<PurchasesError, Unit> getOnError() {
            return this.onError;
        }
    }

    public final synchronized Map<String, Product> getProductDataCache$purchases_defaultsRelease() {
        return this.productDataCache;
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener
    public void getProductData(Set<String> skus, String marketplace, Function1<? super List<? extends StoreProduct>, Unit> onReceive, Function1<? super PurchasesError, Unit> onError) {
        Map map;
        Intrinsics.checkNotNullParameter(skus, "skus");
        Intrinsics.checkNotNullParameter(marketplace, "marketplace");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Intrinsics.checkNotNullParameter(onError, "onError");
        LogIntent logIntent = LogIntent.DEBUG;
        Set<String> set = skus;
        String format = String.format(AmazonStrings.REQUESTING_PRODUCTS, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(set, null, null, null, 0, null, null, 63, null)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        synchronized (this) {
            map = MapsKt.toMap(this.productDataCache);
        }
        if (!map.keySet().containsAll(skus)) {
            RequestId productData = this.purchasingServiceProvider.getProductData(skus);
            Request request = new Request(CollectionsKt.toList(set), marketplace, onReceive, onError);
            synchronized (this) {
                this.productDataRequests.put(productData, request);
                addTimeoutToProductDataRequest(productData);
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (skus.contains((String) entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        handleSuccessfulProductDataResponse(linkedHashMap, marketplace, onReceive);
    }

    @Override // com.amazon.device.iap.PurchasingListener
    public void onProductDataResponse(ProductDataResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            LogIntent logIntent = LogIntent.DEBUG;
            boolean z = true;
            String format = String.format(AmazonStrings.PRODUCTS_REQUEST_FINISHED, Arrays.copyOf(new Object[]{response.getRequestStatus().name()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
            Intrinsics.checkNotNullExpressionValue(response.getUnavailableSkus(), "response.unavailableSkus");
            if (!r0.isEmpty()) {
                LogIntent logIntent2 = LogIntent.DEBUG;
                String format2 = String.format(AmazonStrings.PRODUCTS_REQUEST_UNAVAILABLE, Arrays.copyOf(new Object[]{response.getUnavailableSkus()}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
                LogWrapperKt.log(logIntent2, format2);
            }
            RequestId requestId = response.getRequestId();
            Intrinsics.checkNotNullExpressionValue(requestId, "requestId");
            Request request = getRequest(requestId);
            if (request == null) {
                return;
            }
            if (response.getRequestStatus() != ProductDataResponse.RequestStatus.SUCCESSFUL) {
                z = false;
            }
            if (z) {
                synchronized (this) {
                    Map<String, Product> map = this.productDataCache;
                    Map<String, Product> productData = response.getProductData();
                    Intrinsics.checkNotNullExpressionValue(productData, "response.productData");
                    map.putAll(productData);
                    Unit unit = Unit.INSTANCE;
                }
                Map<String, Product> productData2 = response.getProductData();
                Intrinsics.checkNotNullExpressionValue(productData2, "response.productData");
                handleSuccessfulProductDataResponse(productData2, request.getMarketplace(), request.getOnReceive());
                return;
            }
            handleUnsuccessfulProductDataResponse(response, request.getOnError());
        } catch (Exception e) {
            LogUtilsKt.errorLog("Exception in onProductDataResponse", e);
            throw e;
        }
    }

    private final void handleSuccessfulProductDataResponse(Map<String, Product> productData, String marketplace, Function1<? super List<? extends StoreProduct>, Unit> onReceive) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AmazonStrings.RETRIEVED_PRODUCT_DATA, Arrays.copyOf(new Object[]{productData}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        if (productData.isEmpty()) {
            LogWrapperKt.log(LogIntent.DEBUG, AmazonStrings.RETRIEVED_PRODUCT_DATA_EMPTY);
        }
        Collection<Product> values = productData.values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            StoreProduct storeProduct = StoreProductConversionsKt.toStoreProduct((Product) it.next(), marketplace);
            if (storeProduct != null) {
                arrayList.add(storeProduct);
            }
        }
        onReceive.invoke(arrayList);
    }

    private final void handleUnsuccessfulProductDataResponse(ProductDataResponse response, Function1<? super PurchasesError, Unit> onError) {
        onError.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, response.getRequestStatus() == ProductDataResponse.RequestStatus.NOT_SUPPORTED ? "Couldn't fetch product data, since it's not supported." : "Error when fetching product data."));
    }

    private final void addTimeoutToProductDataRequest(final RequestId requestId) {
        this.mainHandler.postDelayed(new Runnable() { // from class: com.revenuecat.purchases.amazon.handler.ProductDataHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ProductDataHandler.addTimeoutToProductDataRequest$lambda$6(ProductDataHandler.this, requestId);
            }
        }, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addTimeoutToProductDataRequest$lambda$6(ProductDataHandler this$0, RequestId requestId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(requestId, "$requestId");
        Request request = this$0.getRequest(requestId);
        if (request == null) {
            return;
        }
        PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.UnknownError;
        String format = String.format(AmazonStrings.ERROR_TIMEOUT_GETTING_PRODUCT_DATA, Arrays.copyOf(new Object[]{request.getSkuList().toString()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        request.getOnError().invoke(new PurchasesError(purchasesErrorCode, format));
    }

    private final synchronized Request getRequest(RequestId requestId) {
        return this.productDataRequests.remove(requestId);
    }
}
