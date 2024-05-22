package com.revenuecat.purchases.amazon.handler;

import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.amazon.AmazonStrings;
import com.revenuecat.purchases.amazon.PurchasingServiceProvider;
import com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PurchaseUpdatesHandler.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016JD\u0010\u0016\u001a\u00020\r2\"\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\tj\u0002`\u000e2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000fj\u0002`\u0011H\u0016J$\u0010\u0019\u001a\u00020\r*\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000fj\u0002`\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RV\u0010\u0005\u001aJ\u0012\u0004\u0012\u00020\u0007\u0012@\u0012>\u0012 \u0012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\tj\u0002`\u000e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000fj\u0002`\u00110\bj\u0002`\u00120\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/amazon/handler/PurchaseUpdatesHandler;", "Lcom/revenuecat/purchases/amazon/listener/PurchaseUpdatesResponseListener;", "purchasingServiceProvider", "Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;", "(Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;)V", "requests", "", "Lcom/amazon/device/iap/model/RequestId;", "Lkotlin/Pair;", "Lkotlin/Function2;", "", "Lcom/amazon/device/iap/model/Receipt;", "Lcom/amazon/device/iap/model/UserData;", "", "Lcom/revenuecat/purchases/amazon/handler/QueryPurchasesSuccessCallback;", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "Lcom/revenuecat/purchases/amazon/handler/QueryPurchasesCallbacks;", "onPurchaseUpdatesResponse", "response", "Lcom/amazon/device/iap/model/PurchaseUpdatesResponse;", "queryPurchases", "onSuccess", "onError", "invokeWithStoreProblem", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PurchaseUpdatesHandler implements PurchaseUpdatesResponseListener {
    private final PurchasingServiceProvider purchasingServiceProvider;
    private final Map<RequestId, Pair<Function2<List<Receipt>, UserData, Unit>, Function1<PurchasesError, Unit>>> requests;

    /* compiled from: PurchaseUpdatesHandler.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PurchaseUpdatesResponse.RequestStatus.values().length];
            try {
                iArr[PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchaseUpdatesResponse.RequestStatus.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PurchaseUpdatesResponse.RequestStatus.NOT_SUPPORTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PurchaseUpdatesHandler(PurchasingServiceProvider purchasingServiceProvider) {
        Intrinsics.checkNotNullParameter(purchasingServiceProvider, "purchasingServiceProvider");
        this.purchasingServiceProvider = purchasingServiceProvider;
        this.requests = new LinkedHashMap();
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener, com.amazon.device.iap.PurchasingListener
    public void onProductDataResponse(ProductDataResponse productDataResponse) {
        PurchaseUpdatesResponseListener.DefaultImpls.onProductDataResponse(this, productDataResponse);
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener, com.amazon.device.iap.PurchasingListener
    public void onPurchaseResponse(PurchaseResponse purchaseResponse) {
        PurchaseUpdatesResponseListener.DefaultImpls.onPurchaseResponse(this, purchaseResponse);
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener, com.amazon.device.iap.PurchasingListener
    public void onUserDataResponse(UserDataResponse userDataResponse) {
        PurchaseUpdatesResponseListener.DefaultImpls.onUserDataResponse(this, userDataResponse);
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener
    public void queryPurchases(Function2<? super List<Receipt>, ? super UserData, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        RequestId purchaseUpdates = this.purchasingServiceProvider.getPurchaseUpdates(true);
        synchronized (this) {
            this.requests.put(purchaseUpdates, TuplesKt.to(onSuccess, onError));
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.amazon.device.iap.PurchasingListener
    public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse response) {
        Pair<Function2<List<Receipt>, UserData, Unit>, Function1<PurchasesError, Unit>> remove;
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            LogIntent logIntent = LogIntent.DEBUG;
            String format = String.format(AmazonStrings.RETRIEVED_PRODUCT_DATA, Arrays.copyOf(new Object[]{response}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
            RequestId requestId = response.getRequestId();
            synchronized (this) {
                remove = this.requests.remove(requestId);
            }
            if (remove != null) {
                Function2<List<Receipt>, UserData, Unit> component1 = remove.component1();
                Function1<PurchasesError, Unit> component2 = remove.component2();
                PurchaseUpdatesResponse.RequestStatus requestStatus = response.getRequestStatus();
                int i = requestStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$0[requestStatus.ordinal()];
                if (i == -1) {
                    invokeWithStoreProblem(component2, AmazonStrings.ERROR_PURCHASES_UPDATES_STORE_PROBLEM);
                    return;
                }
                if (i == 1) {
                    List<Receipt> receipts = response.getReceipts();
                    Intrinsics.checkNotNullExpressionValue(receipts, "response.receipts");
                    UserData userData = response.getUserData();
                    Intrinsics.checkNotNullExpressionValue(userData, "response.userData");
                    component1.invoke(receipts, userData);
                    return;
                }
                if (i == 2) {
                    invokeWithStoreProblem(component2, AmazonStrings.ERROR_FAILED_PURCHASES_UPDATES);
                } else {
                    if (i != 3) {
                        return;
                    }
                    invokeWithStoreProblem(component2, AmazonStrings.ERROR_UNSUPPORTED_PURCHASES_UPDATES);
                }
            }
        } catch (Exception e) {
            LogUtilsKt.errorLog("Exception in onPurchaseUpdatesResponse", e);
            throw e;
        }
    }

    private final void invokeWithStoreProblem(Function1<? super PurchasesError, Unit> function1, String str) {
        function1.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, str));
    }
}
