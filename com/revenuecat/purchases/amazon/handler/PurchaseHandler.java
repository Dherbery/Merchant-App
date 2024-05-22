package com.revenuecat.purchases.amazon.handler;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.amazon.a.a.o.b;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.amazon.AmazonStrings;
import com.revenuecat.purchases.amazon.PurchasingServiceProvider;
import com.revenuecat.purchases.amazon.listener.PurchaseResponseListener;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivityBroadcastReceiver;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PurchaseHandler.kt */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0015\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JK\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000e2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0012H\u0002¢\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\u00020\u00112\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0012H\u0002J\u001c\u0010\u001e\u001a\u00020\u00112\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0012H\u0002J\u001c\u0010\u001f\u001a\u00020\u00112\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0012H\u0002J\u001c\u0010 \u001a\u00020\u00112\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0012H\u0002J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#H\u0016J2\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00102\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000eH\u0002J\u001c\u0010'\u001a\u00020\u00112\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0012H\u0002JV\u0010(\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000e2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0012H\u0016JN\u0010,\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0018\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000e2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000RD\u0010\u000b\u001a8\u0012\u0004\u0012\u00020\f\u0012.\u0012,\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u00120\r0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/revenuecat/purchases/amazon/handler/PurchaseHandler;", "Lcom/revenuecat/purchases/amazon/listener/PurchaseResponseListener;", "purchasingServiceProvider", "Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;", "applicationContext", "Landroid/content/Context;", "(Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;Landroid/content/Context;)V", "productTypes", "", "", "Lcom/revenuecat/purchases/ProductType;", "purchaseCallbacks", "Lcom/amazon/device/iap/model/RequestId;", "Lkotlin/Pair;", "Lkotlin/Function2;", "Lcom/amazon/device/iap/model/Receipt;", "Lcom/amazon/device/iap/model/UserData;", "", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "createRequestIdResultReceiver", "com/revenuecat/purchases/amazon/handler/PurchaseHandler$createRequestIdResultReceiver$1", "mainHandler", "Landroid/os/Handler;", "storeProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "onSuccess", "onError", "(Landroid/os/Handler;Lcom/revenuecat/purchases/models/StoreProduct;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Lcom/revenuecat/purchases/amazon/handler/PurchaseHandler$createRequestIdResultReceiver$1;", "onAlreadyPurchased", "onFailed", "onInvalidSku", "onNotSupported", "onPurchaseResponse", "response", "Lcom/amazon/device/iap/model/PurchaseResponse;", "onSuccessfulPurchase", b.D, "userData", "onUnknownError", "purchase", "activity", "Landroid/app/Activity;", "appUserID", "startProxyActivity", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PurchaseHandler implements PurchaseResponseListener {
    private final Context applicationContext;
    private final Map<String, ProductType> productTypes;
    private final Map<RequestId, Pair<Function2<Receipt, UserData, Unit>, Function1<PurchasesError, Unit>>> purchaseCallbacks;
    private final PurchasingServiceProvider purchasingServiceProvider;

    /* compiled from: PurchaseHandler.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PurchaseResponse.RequestStatus.values().length];
            try {
                iArr[PurchaseResponse.RequestStatus.SUCCESSFUL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchaseResponse.RequestStatus.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PurchaseResponse.RequestStatus.INVALID_SKU.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PurchaseResponse.RequestStatus.ALREADY_PURCHASED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PurchaseResponse.RequestStatus.NOT_SUPPORTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PurchaseHandler(PurchasingServiceProvider purchasingServiceProvider, Context applicationContext) {
        Intrinsics.checkNotNullParameter(purchasingServiceProvider, "purchasingServiceProvider");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.purchasingServiceProvider = purchasingServiceProvider;
        this.applicationContext = applicationContext;
        this.productTypes = new LinkedHashMap();
        this.purchaseCallbacks = new LinkedHashMap();
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseResponseListener, com.amazon.device.iap.PurchasingListener
    public void onProductDataResponse(ProductDataResponse productDataResponse) {
        PurchaseResponseListener.DefaultImpls.onProductDataResponse(this, productDataResponse);
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseResponseListener, com.amazon.device.iap.PurchasingListener
    public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse purchaseUpdatesResponse) {
        PurchaseResponseListener.DefaultImpls.onPurchaseUpdatesResponse(this, purchaseUpdatesResponse);
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseResponseListener, com.amazon.device.iap.PurchasingListener
    public void onUserDataResponse(UserDataResponse userDataResponse) {
        PurchaseResponseListener.DefaultImpls.onUserDataResponse(this, userDataResponse);
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseResponseListener
    public void purchase(Handler mainHandler, Activity activity, String appUserID, StoreProduct storeProduct, Function2<? super Receipt, ? super UserData, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        LogIntent logIntent = LogIntent.PURCHASE;
        String format = String.format(PurchaseStrings.PURCHASING_PRODUCT, Arrays.copyOf(new Object[]{storeProduct.getId()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        startProxyActivity(mainHandler, activity, storeProduct, onSuccess, onError);
    }

    private final void startProxyActivity(Handler mainHandler, Activity activity, StoreProduct storeProduct, Function2<? super Receipt, ? super UserData, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        activity.startActivity(ProxyAmazonBillingActivity.INSTANCE.newStartIntent(activity, createRequestIdResultReceiver(mainHandler, storeProduct, onSuccess, onError), storeProduct.getId(), this.purchasingServiceProvider));
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.revenuecat.purchases.amazon.handler.PurchaseHandler$createRequestIdResultReceiver$1] */
    private final PurchaseHandler$createRequestIdResultReceiver$1 createRequestIdResultReceiver(final Handler mainHandler, final StoreProduct storeProduct, final Function2<? super Receipt, ? super UserData, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        return new ResultReceiver(mainHandler) { // from class: com.revenuecat.purchases.amazon.handler.PurchaseHandler$createRequestIdResultReceiver$1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                Object obj;
                Map map;
                Map map2;
                PurchaseHandler purchaseHandler = this;
                Function2<Receipt, UserData, Unit> function2 = onSuccess;
                Function1<PurchasesError, Unit> function1 = onError;
                StoreProduct storeProduct2 = storeProduct;
                synchronized (purchaseHandler) {
                    if (resultData != null) {
                        try {
                            obj = resultData.get(ProxyAmazonBillingActivity.EXTRAS_REQUEST_ID);
                        } catch (Throwable th) {
                            throw th;
                        }
                    } else {
                        obj = null;
                    }
                    RequestId requestId = obj instanceof RequestId ? (RequestId) obj : null;
                    if (requestId != null) {
                        map = purchaseHandler.purchaseCallbacks;
                        map.put(requestId, TuplesKt.to(function2, function1));
                        map2 = purchaseHandler.productTypes;
                        map2.put(storeProduct2.getId(), storeProduct2.getType());
                    } else {
                        LogUtilsKt.errorLog$default("No RequestId coming from ProxyAmazonBillingActivity", null, 2, null);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        };
    }

    @Override // com.amazon.device.iap.PurchasingListener
    public void onPurchaseResponse(PurchaseResponse response) {
        Pair<Function2<Receipt, UserData, Unit>, Function1<PurchasesError, Unit>> remove;
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            LogIntent logIntent = LogIntent.DEBUG;
            String format = String.format(AmazonStrings.PURCHASE_REQUEST_FINISHED, Arrays.copyOf(new Object[]{response.toJSON().toString(1)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
            ProxyAmazonBillingActivityBroadcastReceiver.Companion companion = ProxyAmazonBillingActivityBroadcastReceiver.INSTANCE;
            String packageName = this.applicationContext.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "applicationContext.packageName");
            this.applicationContext.sendBroadcast(companion.newPurchaseFinishedIntent(packageName));
            RequestId requestId = response.getRequestId();
            synchronized (this) {
                remove = this.purchaseCallbacks.remove(requestId);
            }
            if (remove != null) {
                Function2<Receipt, UserData, Unit> component1 = remove.component1();
                Function1<PurchasesError, Unit> component2 = remove.component2();
                PurchaseResponse.RequestStatus requestStatus = response.getRequestStatus();
                int i = requestStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$0[requestStatus.ordinal()];
                if (i == 1) {
                    Receipt receipt = response.getReceipt();
                    Intrinsics.checkNotNullExpressionValue(receipt, "response.receipt");
                    UserData userData = response.getUserData();
                    Intrinsics.checkNotNullExpressionValue(userData, "response.userData");
                    onSuccessfulPurchase(receipt, userData, component1);
                    return;
                }
                if (i == 2) {
                    onFailed(component2);
                    return;
                }
                if (i == 3) {
                    onInvalidSku(component2);
                    return;
                }
                if (i == 4) {
                    onAlreadyPurchased(component2);
                } else if (i == 5) {
                    onNotSupported(component2);
                } else {
                    onUnknownError(component2);
                }
            }
        } catch (Exception e) {
            LogUtilsKt.errorLog("Exception in onPurchaseResponse", e);
            throw e;
        }
    }

    private final void onSuccessfulPurchase(Receipt receipt, UserData userData, Function2<? super Receipt, ? super UserData, Unit> onSuccess) {
        onSuccess.invoke(receipt, userData);
    }

    private final void onUnknownError(Function1<? super PurchasesError, Unit> onError) {
        onError.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, AmazonStrings.ERROR_PURCHASE_UNKNOWN));
    }

    private final void onNotSupported(Function1<? super PurchasesError, Unit> onError) {
        onError.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, AmazonStrings.ERROR_PURCHASE_NOT_SUPPORTED));
    }

    private final void onAlreadyPurchased(Function1<? super PurchasesError, Unit> onError) {
        onError.invoke(new PurchasesError(PurchasesErrorCode.ProductAlreadyPurchasedError, AmazonStrings.ERROR_PURCHASE_ALREADY_OWNED));
    }

    private final void onInvalidSku(Function1<? super PurchasesError, Unit> onError) {
        onError.invoke(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, AmazonStrings.ERROR_PURCHASE_INVALID_SKU));
    }

    private final void onFailed(Function1<? super PurchasesError, Unit> onError) {
        onError.invoke(new PurchasesError(PurchasesErrorCode.PurchaseCancelledError, AmazonStrings.ERROR_PURCHASE_FAILED));
    }
}
