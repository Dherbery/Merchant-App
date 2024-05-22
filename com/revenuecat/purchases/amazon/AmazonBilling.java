package com.revenuecat.purchases.amazon;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amazon.a.a.o.b;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesStateProvider;
import com.revenuecat.purchases.amazon.AmazonPurchasingData;
import com.revenuecat.purchases.amazon.listener.ProductDataResponseListener;
import com.revenuecat.purchases.amazon.listener.PurchaseResponseListener;
import com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener;
import com.revenuecat.purchases.amazon.listener.UserDataResponseListener;
import com.revenuecat.purchases.common.BackendHelper;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.strings.RestoreStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AmazonBilling.kt */
@Metadata(d1 = {"\u0000ª\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B7\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012Bq\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\b\u001a\u00020\u0015\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u0010\u001eJ\b\u0010(\u001a\u00020\u000bH\u0002J \u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020'H\u0014J\b\u00100\u001a\u00020'H\u0002J\u001e\u00101\u001a\u00020'2\u0014\u00102\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010#\u0012\u0004\u0012\u00020'0\"H\u0002JH\u00103\u001a\u00020'2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002052\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020'0\"2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"H\u0016Jn\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u0002052\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>2N\u00109\u001aJ\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u0002050A¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(B\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020#0A¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020'0@H\u0002JM\u0010D\u001a\u00020'2\f\u0010E\u001a\b\u0012\u0004\u0012\u0002050F2\u0006\u0010G\u001a\u0002052\u0018\u0010H\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0>\u0012\u0004\u0012\u00020'0\"2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"H\u0096\u0001J4\u0010J\u001a\u00020'2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020'0\"2\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"j\u0002`LH\u0016J\u0012\u0010M\u001a\u0004\u0018\u0001052\u0006\u0010N\u001a\u00020OH\u0002J1\u0010P\u001a\u00020'2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020'0\"2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"H\u0096\u0001J*\u0010R\u001a\u00020'2\u0006\u0010S\u001a\u00020?2\u0006\u0010T\u001a\u00020Q2\u0006\u0010U\u001a\u00020I2\b\u0010V\u001a\u0004\u0018\u00010WH\u0002J\b\u0010X\u001a\u00020\u000bH\u0016J\u001c\u0010Y\u001a\u00020'2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020#0AH\u0002JC\u0010Z\u001a\u00020'2\u0006\u0010[\u001a\u00020\\2\u0006\u00104\u001a\u0002052\u0006\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010`2\b\u0010V\u001a\u0004\u0018\u00010W2\b\u0010a\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010bJW\u0010c\u001a\u00020'2\u0006\u0010d\u001a\u0002052\u0006\u0010e\u001a\u0002052\u0006\u0010f\u001a\u0002052!\u0010K\u001a\u001d\u0012\u0013\u0012\u001105¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(g\u0012\u0004\u0012\u00020'0\"2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"H\u0016J\u0010\u0010h\u001a\u00020'2\u0006\u0010N\u001a\u00020iH\u0016J\u0010\u0010j\u001a\u00020'2\u0006\u0010k\u001a\u00020#H\u0002J\u0010\u0010l\u001a\u00020'2\u0006\u0010N\u001a\u00020mH\u0016J\u0010\u0010n\u001a\u00020'2\u0006\u0010N\u001a\u00020oH\u0016J\u0010\u0010p\u001a\u00020'2\u0006\u0010N\u001a\u00020qH\u0016JW\u0010+\u001a\u00020'2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010[\u001a\u00020\\2\u0006\u00104\u001a\u0002052\u0006\u0010U\u001a\u00020I2\u0018\u0010K\u001a\u0014\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020'0@2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"H\u0096\u0001JB\u0010r\u001a\u00020'2\u0006\u00104\u001a\u0002052\u0018\u0010s\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0>\u0012\u0004\u0012\u00020'0\"2\u0016\u0010t\u001a\u0012\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"j\u0002`LH\u0016JT\u0010u\u001a\u00020'2\u0006\u00106\u001a\u0002072\f\u0010v\u001a\b\u0012\u0004\u0012\u0002050F2\u001c\u0010H\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0>\u0012\u0004\u0012\u00020'0\"j\u0002`w2\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"j\u0002`LH\u0016J=\u0010x\u001a\u00020'2\u001e\u0010K\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0>\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020'0@2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"H\u0096\u0001JD\u0010x\u001a\u00020'2\u0006\u0010y\u001a\u00020\u000b2\u001e\u0010K\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020,0A\u0012\u0004\u0012\u00020'0\"2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"H\u0002JD\u0010x\u001a\u00020'2\u0006\u00104\u001a\u0002052\u001e\u0010K\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020,0A\u0012\u0004\u0012\u00020'0\"2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020'0\"H\u0016J\u0010\u0010z\u001a\u00020'2\u0006\u0010{\u001a\u00020|H\u0002J.\u0010}\u001a\u00020'2\u0006\u0010[\u001a\u00020\\2\f\u0010~\u001a\b\u0012\u0004\u0012\u00020\u007f0>2\u000e\u0010\u0080\u0001\u001a\t\u0012\u0004\u0012\u00020'0\u0081\u0001H\u0016J\t\u0010\u0082\u0001\u001a\u00020'H\u0016J\u0013\u0010\u0083\u0001\u001a\u00020'2\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0016J;\u0010\u0086\u0001\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020,0A*\b\u0012\u0004\u0012\u00020?0>2\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u0002050A2\u0006\u0010T\u001a\u00020QH\u0002R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010 \u001a%\u0012!\u0012\u001f\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020'0\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0087\u0001"}, d2 = {"Lcom/revenuecat/purchases/amazon/AmazonBilling;", "Lcom/revenuecat/purchases/common/BillingAbstract;", "Lcom/revenuecat/purchases/amazon/listener/ProductDataResponseListener;", "Lcom/revenuecat/purchases/amazon/listener/PurchaseResponseListener;", "Lcom/revenuecat/purchases/amazon/listener/PurchaseUpdatesResponseListener;", "Lcom/revenuecat/purchases/amazon/listener/UserDataResponseListener;", "applicationContext", "Landroid/content/Context;", "cache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "observerMode", "", "mainHandler", "Landroid/os/Handler;", "backendHelper", "Lcom/revenuecat/purchases/common/BackendHelper;", "stateProvider", "Lcom/revenuecat/purchases/PurchasesStateProvider;", "(Landroid/content/Context;Lcom/revenuecat/purchases/common/caching/DeviceCache;ZLandroid/os/Handler;Lcom/revenuecat/purchases/common/BackendHelper;Lcom/revenuecat/purchases/PurchasesStateProvider;)V", "amazonBackend", "Lcom/revenuecat/purchases/amazon/AmazonBackend;", "Lcom/revenuecat/purchases/amazon/AmazonCache;", "purchasingServiceProvider", "Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;", "productDataHandler", "purchaseHandler", "purchaseUpdatesHandler", "userDataHandler", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Landroid/content/Context;Lcom/revenuecat/purchases/amazon/AmazonBackend;Lcom/revenuecat/purchases/amazon/AmazonCache;ZLandroid/os/Handler;Lcom/revenuecat/purchases/PurchasesStateProvider;Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;Lcom/revenuecat/purchases/amazon/listener/ProductDataResponseListener;Lcom/revenuecat/purchases/amazon/listener/PurchaseResponseListener;Lcom/revenuecat/purchases/amazon/listener/PurchaseUpdatesResponseListener;Lcom/revenuecat/purchases/amazon/listener/UserDataResponseListener;Lcom/revenuecat/purchases/common/DateProvider;)V", "connected", "serviceRequests", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "Lkotlin/ParameterName;", "name", "connectionError", "", "checkObserverMode", "consumeAndSave", "shouldTryToConsume", "purchase", "Lcom/revenuecat/purchases/models/StoreTransaction;", "initiationSource", "Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "endConnection", "executePendingRequests", "executeRequestOnUIThread", "request", "findPurchaseInPurchaseHistory", "appUserID", "", "productType", "Lcom/revenuecat/purchases/ProductType;", "productId", "onCompletion", "onError", "getMissingSkusForReceipts", "amazonUserID", b.G, "", "Lcom/amazon/device/iap/model/Receipt;", "Lkotlin/Function2;", "", "tokensToSkusMap", "errors", "getProductData", b.O, "", b.m, "onReceive", "Lcom/revenuecat/purchases/models/StoreProduct;", "getStorefront", "onSuccess", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "getTermSkuFromJSON", "response", "Lorg/json/JSONObject;", "getUserData", "Lcom/amazon/device/iap/model/UserData;", "handleReceipt", b.D, "userData", "storeProduct", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "isConnected", "logErrorsIfAny", "makePurchaseAsync", "activity", "Landroid/app/Activity;", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "replaceProductInfo", "Lcom/revenuecat/purchases/common/ReplaceProductInfo;", "isPersonalizedPrice", "(Landroid/app/Activity;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchasingData;Lcom/revenuecat/purchases/common/ReplaceProductInfo;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/Boolean;)V", "normalizePurchaseData", "productID", "purchaseToken", "storeUserID", "correctProductID", "onProductDataResponse", "Lcom/amazon/device/iap/model/ProductDataResponse;", "onPurchaseError", "error", "onPurchaseResponse", "Lcom/amazon/device/iap/model/PurchaseResponse;", "onPurchaseUpdatesResponse", "Lcom/amazon/device/iap/model/PurchaseUpdatesResponse;", "onUserDataResponse", "Lcom/amazon/device/iap/model/UserDataResponse;", "queryAllPurchases", "onReceivePurchaseHistory", "onReceivePurchaseHistoryError", "queryProductDetailsAsync", "productIds", "Lcom/revenuecat/purchases/common/StoreProductsCallback;", "queryPurchases", "filterOnlyActivePurchases", "runOnUIThread", "runnable", "Ljava/lang/Runnable;", "showInAppMessagesIfNeeded", "inAppMessageTypes", "Lcom/revenuecat/purchases/models/InAppMessageType;", "subscriptionStatusChange", "Lkotlin/Function0;", "startConnection", "startConnectionOnMainThread", "delayMilliseconds", "", "toMapOfReceiptHashesToRestoredPurchases", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class AmazonBilling extends BillingAbstract implements ProductDataResponseListener, PurchaseResponseListener, PurchaseUpdatesResponseListener, UserDataResponseListener {
    private final AmazonBackend amazonBackend;
    private final Context applicationContext;
    private final AmazonCache cache;
    private boolean connected;
    private final DateProvider dateProvider;
    private final Handler mainHandler;
    private final boolean observerMode;
    private final ProductDataResponseListener productDataHandler;
    private final PurchaseResponseListener purchaseHandler;
    private final PurchaseUpdatesResponseListener purchaseUpdatesHandler;
    private final PurchasingServiceProvider purchasingServiceProvider;
    private final ConcurrentLinkedQueue<Function1<PurchasesError, Unit>> serviceRequests;
    private final UserDataResponseListener userDataHandler;

    @Override // com.revenuecat.purchases.common.BillingAbstract
    protected void endConnection() {
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener
    public void getProductData(Set<String> skus, String marketplace, Function1<? super List<? extends StoreProduct>, Unit> onReceive, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(skus, "skus");
        Intrinsics.checkNotNullParameter(marketplace, "marketplace");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.productDataHandler.getProductData(skus, marketplace, onReceive, onError);
    }

    @Override // com.revenuecat.purchases.amazon.listener.UserDataResponseListener
    public void getUserData(Function1<? super UserData, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.userDataHandler.getUserData(onSuccess, onError);
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseResponseListener
    public void purchase(Handler mainHandler, Activity activity, String appUserID, StoreProduct storeProduct, Function2<? super Receipt, ? super UserData, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.purchaseHandler.purchase(mainHandler, activity, appUserID, storeProduct, onSuccess, onError);
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener
    public void queryPurchases(Function2<? super List<Receipt>, ? super UserData, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.purchaseUpdatesHandler.queryPurchases(onSuccess, onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes, Function0<Unit> subscriptionStatusChange) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(inAppMessageTypes, "inAppMessageTypes");
        Intrinsics.checkNotNullParameter(subscriptionStatusChange, "subscriptionStatusChange");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AmazonBilling(android.content.Context r16, com.revenuecat.purchases.amazon.AmazonBackend r17, com.revenuecat.purchases.amazon.AmazonCache r18, boolean r19, android.os.Handler r20, com.revenuecat.purchases.PurchasesStateProvider r21, com.revenuecat.purchases.amazon.PurchasingServiceProvider r22, com.revenuecat.purchases.amazon.listener.ProductDataResponseListener r23, com.revenuecat.purchases.amazon.listener.PurchaseResponseListener r24, com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener r25, com.revenuecat.purchases.amazon.listener.UserDataResponseListener r26, com.revenuecat.purchases.common.DateProvider r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r15 = this;
            r0 = r28
            r1 = r0 & 64
            if (r1 == 0) goto Lf
            com.revenuecat.purchases.amazon.DefaultPurchasingServiceProvider r1 = new com.revenuecat.purchases.amazon.DefaultPurchasingServiceProvider
            r1.<init>()
            com.revenuecat.purchases.amazon.PurchasingServiceProvider r1 = (com.revenuecat.purchases.amazon.PurchasingServiceProvider) r1
            r9 = r1
            goto L11
        Lf:
            r9 = r22
        L11:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L20
            com.revenuecat.purchases.amazon.handler.ProductDataHandler r1 = new com.revenuecat.purchases.amazon.handler.ProductDataHandler
            r8 = r20
            r1.<init>(r9, r8)
            com.revenuecat.purchases.amazon.listener.ProductDataResponseListener r1 = (com.revenuecat.purchases.amazon.listener.ProductDataResponseListener) r1
            r10 = r1
            goto L24
        L20:
            r8 = r20
            r10 = r23
        L24:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L32
            com.revenuecat.purchases.amazon.handler.PurchaseHandler r1 = new com.revenuecat.purchases.amazon.handler.PurchaseHandler
            r11 = r16
            r1.<init>(r9, r11)
            com.revenuecat.purchases.amazon.listener.PurchaseResponseListener r1 = (com.revenuecat.purchases.amazon.listener.PurchaseResponseListener) r1
            goto L36
        L32:
            r11 = r16
            r1 = r24
        L36:
            r2 = r0 & 512(0x200, float:7.17E-43)
            if (r2 == 0) goto L43
            com.revenuecat.purchases.amazon.handler.PurchaseUpdatesHandler r2 = new com.revenuecat.purchases.amazon.handler.PurchaseUpdatesHandler
            r2.<init>(r9)
            com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener r2 = (com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener) r2
            r12 = r2
            goto L45
        L43:
            r12 = r25
        L45:
            r2 = r0 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L5a
            com.revenuecat.purchases.amazon.handler.UserDataHandler r13 = new com.revenuecat.purchases.amazon.handler.UserDataHandler
            r5 = 0
            r6 = 4
            r7 = 0
            r2 = r13
            r3 = r9
            r4 = r20
            r2.<init>(r3, r4, r5, r6, r7)
            r2 = r13
            com.revenuecat.purchases.amazon.listener.UserDataResponseListener r2 = (com.revenuecat.purchases.amazon.listener.UserDataResponseListener) r2
            r13 = r2
            goto L5c
        L5a:
            r13 = r26
        L5c:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L69
            com.revenuecat.purchases.common.DefaultDateProvider r0 = new com.revenuecat.purchases.common.DefaultDateProvider
            r0.<init>()
            com.revenuecat.purchases.common.DateProvider r0 = (com.revenuecat.purchases.common.DateProvider) r0
            r14 = r0
            goto L6b
        L69:
            r14 = r27
        L6b:
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r11 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.amazon.AmazonBilling.<init>(android.content.Context, com.revenuecat.purchases.amazon.AmazonBackend, com.revenuecat.purchases.amazon.AmazonCache, boolean, android.os.Handler, com.revenuecat.purchases.PurchasesStateProvider, com.revenuecat.purchases.amazon.PurchasingServiceProvider, com.revenuecat.purchases.amazon.listener.ProductDataResponseListener, com.revenuecat.purchases.amazon.listener.PurchaseResponseListener, com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener, com.revenuecat.purchases.amazon.listener.UserDataResponseListener, com.revenuecat.purchases.common.DateProvider, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmazonBilling(Context applicationContext, AmazonBackend amazonBackend, AmazonCache cache, boolean z, Handler mainHandler, PurchasesStateProvider stateProvider, PurchasingServiceProvider purchasingServiceProvider, ProductDataResponseListener productDataHandler, PurchaseResponseListener purchaseHandler, PurchaseUpdatesResponseListener purchaseUpdatesHandler, UserDataResponseListener userDataHandler, DateProvider dateProvider) {
        super(stateProvider);
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(amazonBackend, "amazonBackend");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        Intrinsics.checkNotNullParameter(stateProvider, "stateProvider");
        Intrinsics.checkNotNullParameter(purchasingServiceProvider, "purchasingServiceProvider");
        Intrinsics.checkNotNullParameter(productDataHandler, "productDataHandler");
        Intrinsics.checkNotNullParameter(purchaseHandler, "purchaseHandler");
        Intrinsics.checkNotNullParameter(purchaseUpdatesHandler, "purchaseUpdatesHandler");
        Intrinsics.checkNotNullParameter(userDataHandler, "userDataHandler");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.applicationContext = applicationContext;
        this.amazonBackend = amazonBackend;
        this.cache = cache;
        this.observerMode = z;
        this.mainHandler = mainHandler;
        this.purchasingServiceProvider = purchasingServiceProvider;
        this.productDataHandler = productDataHandler;
        this.purchaseHandler = purchaseHandler;
        this.purchaseUpdatesHandler = purchaseUpdatesHandler;
        this.userDataHandler = userDataHandler;
        this.dateProvider = dateProvider;
        this.serviceRequests = new ConcurrentLinkedQueue<>();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AmazonBilling(Context applicationContext, DeviceCache cache, boolean z, Handler mainHandler, BackendHelper backendHelper, PurchasesStateProvider stateProvider) {
        this(applicationContext, new AmazonBackend(backendHelper), new AmazonCache(cache), z, mainHandler, stateProvider, null, null, null, null, null, null, 4032, null);
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        Intrinsics.checkNotNullParameter(backendHelper, "backendHelper");
        Intrinsics.checkNotNullParameter(stateProvider, "stateProvider");
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void startConnection() {
        if (checkObserverMode()) {
            return;
        }
        this.purchasingServiceProvider.registerListener(this.applicationContext, this);
        this.connected = true;
        BillingAbstract.StateListener stateListener = getStateListener();
        if (stateListener != null) {
            stateListener.onConnected();
        }
        executePendingRequests();
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void startConnectionOnMainThread(long delayMilliseconds) {
        runOnUIThread(new Runnable() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AmazonBilling.startConnectionOnMainThread$lambda$0(AmazonBilling.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startConnectionOnMainThread$lambda$0(AmazonBilling this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startConnection();
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryAllPurchases(String appUserID, final Function1<? super List<StoreTransaction>, Unit> onReceivePurchaseHistory, Function1<? super PurchasesError, Unit> onReceivePurchaseHistoryError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistory, "onReceivePurchaseHistory");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistoryError, "onReceivePurchaseHistoryError");
        queryPurchases(false, (Function1<? super Map<String, StoreTransaction>, Unit>) new Function1<Map<String, ? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$queryAllPurchases$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends StoreTransaction> map) {
                invoke2((Map<String, StoreTransaction>) map);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, StoreTransaction> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                onReceivePurchaseHistory.invoke(CollectionsKt.toList(it.values()));
            }
        }, onReceivePurchaseHistoryError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void normalizePurchaseData(String productID, final String purchaseToken, String storeUserID, final Function1<? super String, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(productID, "productID");
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(storeUserID, "storeUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        String str = this.cache.getReceiptSkus().get(purchaseToken);
        if (str != null) {
            onSuccess.invoke(str);
        } else {
            this.amazonBackend.getAmazonReceiptData(purchaseToken, storeUserID, new Function1<JSONObject, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$normalizePurchaseData$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                    invoke2(jSONObject);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(JSONObject response) {
                    String termSkuFromJSON;
                    AmazonCache amazonCache;
                    Intrinsics.checkNotNullParameter(response, "response");
                    LogIntent logIntent = LogIntent.DEBUG;
                    String format = String.format(AmazonStrings.RECEIPT_DATA_RECEIVED, Arrays.copyOf(new Object[]{response.toString()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                    LogWrapperKt.log(logIntent, format);
                    termSkuFromJSON = AmazonBilling.this.getTermSkuFromJSON(response);
                    if (termSkuFromJSON != null) {
                        amazonCache = AmazonBilling.this.cache;
                        amazonCache.cacheSkusByToken(MapsKt.mapOf(TuplesKt.to(purchaseToken, termSkuFromJSON)));
                        onSuccess.invoke(termSkuFromJSON);
                        return;
                    }
                    onError.invoke(ErrorsKt.missingTermSkuError(response));
                }
            }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$normalizePurchaseData$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                    invoke2(purchasesError);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PurchasesError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    onError.invoke(ErrorsKt.errorGettingReceiptInfo(error));
                }
            });
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryProductDetailsAsync(ProductType productType, final Set<String> productIds, final Function1<? super List<? extends StoreProduct>, Unit> onReceive, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (checkObserverMode()) {
            return;
        }
        executeRequestOnUIThread(new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$queryProductDetailsAsync$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError purchasesError) {
                UserDataResponseListener userDataResponseListener;
                if (purchasesError == null) {
                    userDataResponseListener = AmazonBilling.this.userDataHandler;
                    final AmazonBilling amazonBilling = AmazonBilling.this;
                    final Set<String> set = productIds;
                    final Function1<List<? extends StoreProduct>, Unit> function1 = onReceive;
                    final Function1<PurchasesError, Unit> function12 = onError;
                    userDataResponseListener.getUserData(new Function1<UserData, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$queryProductDetailsAsync$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(UserData userData) {
                            invoke2(userData);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(UserData userData) {
                            ProductDataResponseListener productDataResponseListener;
                            Intrinsics.checkNotNullParameter(userData, "userData");
                            productDataResponseListener = AmazonBilling.this.productDataHandler;
                            Set<String> set2 = set;
                            String marketplace = userData.getMarketplace();
                            Intrinsics.checkNotNullExpressionValue(marketplace, "userData.marketplace");
                            productDataResponseListener.getProductData(set2, marketplace, function1, function12);
                        }
                    }, onError);
                    return;
                }
                onError.invoke(purchasesError);
            }
        });
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void consumeAndSave(boolean shouldTryToConsume, final StoreTransaction purchase, PostReceiptInitiationSource initiationSource) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        if (checkObserverMode() || purchase.getType() == ProductType.UNKNOWN || purchase.getPurchaseState() == PurchaseState.PENDING) {
            return;
        }
        if (shouldTryToConsume) {
            executeRequestOnUIThread(new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$consumeAndSave$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                    invoke2(purchasesError);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PurchasesError purchasesError) {
                    PurchasingServiceProvider purchasingServiceProvider;
                    if (purchasesError == null) {
                        purchasingServiceProvider = AmazonBilling.this.purchasingServiceProvider;
                        purchasingServiceProvider.notifyFulfillment(purchase.getPurchaseToken(), FulfillmentResult.FULFILLED);
                    } else {
                        LogUtilsKt.errorLog(purchasesError);
                    }
                }
            });
        }
        this.cache.addSuccessfullyPostedToken(purchase.getPurchaseToken());
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void findPurchaseInPurchaseHistory(String appUserID, ProductType productType, final String productId, final Function1<? super StoreTransaction, Unit> onCompletion, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(onCompletion, "onCompletion");
        Intrinsics.checkNotNullParameter(onError, "onError");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(RestoreStrings.QUERYING_PURCHASE_WITH_TYPE, Arrays.copyOf(new Object[]{productId, productType.name()}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        queryAllPurchases(appUserID, new Function1<List<? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$findPurchaseInPurchaseHistory$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreTransaction> list) {
                invoke2((List<StoreTransaction>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<StoreTransaction> it) {
                Object obj;
                Intrinsics.checkNotNullParameter(it, "it");
                String str = productId;
                Iterator<T> it2 = it.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it2.next();
                        if (Intrinsics.areEqual(str, ((StoreTransaction) obj).getProductIds().get(0))) {
                            break;
                        }
                    }
                }
                StoreTransaction storeTransaction = (StoreTransaction) obj;
                if (storeTransaction != null) {
                    onCompletion.invoke(storeTransaction);
                    return;
                }
                String format2 = String.format(PurchaseStrings.NO_EXISTING_PURCHASE, Arrays.copyOf(new Object[]{productId}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
                onError.invoke(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, format2));
            }
        }, onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void makePurchaseAsync(final Activity activity, final String appUserID, PurchasingData purchasingData, ReplaceProductInfo replaceProductInfo, final PresentedOfferingContext presentedOfferingContext, Boolean isPersonalizedPrice) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(purchasingData, "purchasingData");
        AmazonPurchasingData.Product product = purchasingData instanceof AmazonPurchasingData.Product ? (AmazonPurchasingData.Product) purchasingData : null;
        if (product == null) {
            PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.UnknownError;
            String format = String.format(PurchaseStrings.INVALID_PURCHASE_TYPE, Arrays.copyOf(new Object[]{"Amazon", "AmazonPurchaseInfo"}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            PurchasesError purchasesError = new PurchasesError(purchasesErrorCode, format);
            LogUtilsKt.errorLog(purchasesError);
            BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
            if (purchasesUpdatedListener != null) {
                purchasesUpdatedListener.onPurchasesFailedToUpdate(purchasesError);
                return;
            }
            return;
        }
        final AmazonStoreProduct storeProduct = product.getStoreProduct();
        if (checkObserverMode()) {
            return;
        }
        if (replaceProductInfo != null) {
            LogWrapperKt.log(LogIntent.AMAZON_WARNING, AmazonStrings.PRODUCT_CHANGES_NOT_SUPPORTED);
        } else {
            executeRequestOnUIThread(new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$makePurchaseAsync$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError2) {
                    invoke2(purchasesError2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PurchasesError purchasesError2) {
                    PurchaseResponseListener purchaseResponseListener;
                    Handler handler;
                    if (purchasesError2 == null) {
                        purchaseResponseListener = AmazonBilling.this.purchaseHandler;
                        handler = AmazonBilling.this.mainHandler;
                        Activity activity2 = activity;
                        String str = appUserID;
                        AmazonStoreProduct amazonStoreProduct = storeProduct;
                        final AmazonBilling amazonBilling = AmazonBilling.this;
                        final AmazonStoreProduct amazonStoreProduct2 = storeProduct;
                        final PresentedOfferingContext presentedOfferingContext2 = presentedOfferingContext;
                        Function2<Receipt, UserData, Unit> function2 = new Function2<Receipt, UserData, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$makePurchaseAsync$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Receipt receipt, UserData userData) {
                                invoke2(receipt, userData);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Receipt receipt, UserData userData) {
                                Intrinsics.checkNotNullParameter(receipt, "receipt");
                                Intrinsics.checkNotNullParameter(userData, "userData");
                                AmazonBilling.this.handleReceipt(receipt, userData, amazonStoreProduct2, presentedOfferingContext2);
                            }
                        };
                        final AmazonBilling amazonBilling2 = AmazonBilling.this;
                        purchaseResponseListener.purchase(handler, activity2, str, amazonStoreProduct, function2, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$makePurchaseAsync$1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError3) {
                                invoke2(purchasesError3);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PurchasesError it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                AmazonBilling.this.onPurchaseError(it);
                            }
                        });
                        return;
                    }
                    AmazonBilling.this.onPurchaseError(purchasesError2);
                }
            });
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    /* renamed from: isConnected, reason: from getter */
    public boolean getConnected() {
        return this.connected;
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryPurchases(String appUserID, Function1<? super Map<String, StoreTransaction>, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (checkObserverMode()) {
            return;
        }
        queryPurchases(true, onSuccess, onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void getStorefront(final Function1<? super String, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        executeRequestOnUIThread(new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$getStorefront$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError purchasesError) {
                UserDataResponseListener userDataResponseListener;
                if (purchasesError == null) {
                    userDataResponseListener = AmazonBilling.this.userDataHandler;
                    final AmazonBilling amazonBilling = AmazonBilling.this;
                    final Function1<String, Unit> function1 = onSuccess;
                    final Function1<PurchasesError, Unit> function12 = onError;
                    Function1<UserData, Unit> function13 = new Function1<UserData, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$getStorefront$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(UserData userData) {
                            invoke2(userData);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(UserData userData) {
                            Intrinsics.checkNotNullParameter(userData, "userData");
                            String marketplace = userData.getMarketplace();
                            if (marketplace == null) {
                                function12.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, AmazonStrings.ERROR_USER_DATA_MARKETPLACE_NULL_STORE_PROBLEM));
                            } else {
                                function1.invoke(marketplace);
                            }
                        }
                    };
                    final Function1<PurchasesError, Unit> function14 = onError;
                    userDataResponseListener.getUserData(function13, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$getStorefront$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError2) {
                            invoke2(purchasesError2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(PurchasesError error) {
                            Intrinsics.checkNotNullParameter(error, "error");
                            String format = String.format(BillingStrings.BILLING_AMAZON_ERROR_STOREFRONT, Arrays.copyOf(new Object[]{error}, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                            LogUtilsKt.errorLog$default(format, null, 2, null);
                            function14.invoke(error);
                        }
                    });
                    return;
                }
                String format = String.format(BillingStrings.BILLING_CONNECTION_ERROR_STORE_COUNTRY, Arrays.copyOf(new Object[]{purchasesError}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                LogUtilsKt.errorLog$default(format, null, 2, null);
                onError.invoke(purchasesError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, StoreTransaction> toMapOfReceiptHashesToRestoredPurchases(List<Receipt> list, Map<String, String> map, UserData userData) {
        ArrayList arrayList = new ArrayList();
        for (Receipt receipt : list) {
            String str = map.get(receipt.getReceiptId());
            Pair pair = null;
            if (str == null) {
                LogWrapperKt.log(LogIntent.AMAZON_ERROR, AmazonStrings.ERROR_FINDING_RECEIPT_SKU);
            } else {
                StoreTransaction storeTransaction = StoreTransactionConversionsKt.toStoreTransaction(receipt, str, null, PurchaseState.UNSPECIFIED_STATE, userData);
                String receiptId = receipt.getReceiptId();
                Intrinsics.checkNotNullExpressionValue(receiptId, "receipt.receiptId");
                pair = TuplesKt.to(UtilsKt.sha1(receiptId), storeTransaction);
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener, com.amazon.device.iap.PurchasingListener
    public void onUserDataResponse(UserDataResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (checkObserverMode()) {
            return;
        }
        this.userDataHandler.onUserDataResponse(response);
    }

    @Override // com.amazon.device.iap.PurchasingListener
    public void onProductDataResponse(ProductDataResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (checkObserverMode()) {
            return;
        }
        this.productDataHandler.onProductDataResponse(response);
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener, com.amazon.device.iap.PurchasingListener
    public void onPurchaseResponse(PurchaseResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (checkObserverMode()) {
            return;
        }
        this.purchaseHandler.onPurchaseResponse(response);
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener, com.amazon.device.iap.PurchasingListener
    public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (checkObserverMode()) {
            return;
        }
        this.purchaseUpdatesHandler.onPurchaseUpdatesResponse(response);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getTermSkuFromJSON(JSONObject response) {
        try {
            return response.getString(b.L);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logErrorsIfAny(Map<String, PurchasesError> errors) {
        if (!errors.isEmpty()) {
            String joinToString$default = CollectionsKt.joinToString$default(errors.keySet(), "\n", null, null, 0, null, null, 62, null);
            LogIntent logIntent = LogIntent.AMAZON_ERROR;
            String format = String.format(AmazonStrings.ERROR_FETCHING_RECEIPTS, Arrays.copyOf(new Object[]{joinToString$default}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
        }
    }

    private final void queryPurchases(final boolean filterOnlyActivePurchases, final Function1<? super Map<String, StoreTransaction>, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        executeRequestOnUIThread(new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$queryPurchases$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError purchasesError) {
                PurchaseUpdatesResponseListener purchaseUpdatesResponseListener;
                if (purchasesError == null) {
                    purchaseUpdatesResponseListener = AmazonBilling.this.purchaseUpdatesHandler;
                    final boolean z = filterOnlyActivePurchases;
                    final Function1<Map<String, StoreTransaction>, Unit> function1 = onSuccess;
                    final AmazonBilling amazonBilling = AmazonBilling.this;
                    final Function1<PurchasesError, Unit> function12 = onError;
                    purchaseUpdatesResponseListener.queryPurchases(new Function2<List<? extends Receipt>, UserData, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$queryPurchases$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Receipt> list, UserData userData) {
                            invoke2((List<Receipt>) list, userData);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:12:0x0048 A[SYNTHETIC] */
                        /* JADX WARN: Removed duplicated region for block: B:16:0x001d A[SYNTHETIC] */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final void invoke2(java.util.List<com.amazon.device.iap.model.Receipt> r10, final com.amazon.device.iap.model.UserData r11) {
                            /*
                                r9 = this;
                                java.lang.String r0 = "receipts"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                                java.lang.String r0 = "userData"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                                boolean r0 = r1
                                if (r0 == 0) goto L4f
                                java.lang.Iterable r10 = (java.lang.Iterable) r10
                                com.revenuecat.purchases.amazon.AmazonBilling r0 = r3
                                java.util.ArrayList r1 = new java.util.ArrayList
                                r1.<init>()
                                java.util.Collection r1 = (java.util.Collection) r1
                                java.util.Iterator r10 = r10.iterator()
                            L1d:
                                boolean r2 = r10.hasNext()
                                if (r2 == 0) goto L4c
                                java.lang.Object r2 = r10.next()
                                r3 = r2
                                com.amazon.device.iap.model.Receipt r3 = (com.amazon.device.iap.model.Receipt) r3
                                java.util.Date r4 = r3.getCancelDate()
                                if (r4 == 0) goto L45
                                java.util.Date r3 = r3.getCancelDate()
                                com.revenuecat.purchases.common.DateProvider r4 = com.revenuecat.purchases.amazon.AmazonBilling.access$getDateProvider$p(r0)
                                java.util.Date r4 = r4.getNow()
                                int r3 = r3.compareTo(r4)
                                if (r3 <= 0) goto L43
                                goto L45
                            L43:
                                r3 = 0
                                goto L46
                            L45:
                                r3 = 1
                            L46:
                                if (r3 == 0) goto L1d
                                r1.add(r2)
                                goto L1d
                            L4c:
                                r10 = r1
                                java.util.List r10 = (java.util.List) r10
                            L4f:
                                boolean r0 = r10.isEmpty()
                                if (r0 == 0) goto L5f
                                kotlin.jvm.functions.Function1<java.util.Map<java.lang.String, com.revenuecat.purchases.models.StoreTransaction>, kotlin.Unit> r10 = r2
                                java.util.Map r11 = kotlin.collections.MapsKt.emptyMap()
                                r10.invoke(r11)
                                return
                            L5f:
                                com.revenuecat.purchases.amazon.AmazonBilling r6 = r3
                                java.lang.String r7 = r11.getUserId()
                                java.lang.String r0 = "userData.userId"
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
                                com.revenuecat.purchases.amazon.AmazonBilling$queryPurchases$1$1$1 r8 = new com.revenuecat.purchases.amazon.AmazonBilling$queryPurchases$1$1$1
                                com.revenuecat.purchases.amazon.AmazonBilling r1 = r3
                                kotlin.jvm.functions.Function1<com.revenuecat.purchases.PurchasesError, kotlin.Unit> r2 = r4
                                kotlin.jvm.functions.Function1<java.util.Map<java.lang.String, com.revenuecat.purchases.models.StoreTransaction>, kotlin.Unit> r5 = r2
                                r0 = r8
                                r3 = r10
                                r4 = r11
                                r0.<init>()
                                kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
                                com.revenuecat.purchases.amazon.AmazonBilling.access$getMissingSkusForReceipts(r6, r7, r10, r8)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.amazon.AmazonBilling$queryPurchases$1.AnonymousClass1.invoke2(java.util.List, com.amazon.device.iap.model.UserData):void");
                        }
                    }, onError);
                    return;
                }
                onError.invoke(purchasesError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getMissingSkusForReceipts(String amazonUserID, List<Receipt> receipts, final Function2<? super Map<String, String>, ? super Map<String, PurchasesError>, Unit> onCompletion) {
        Map<String, String> receiptSkus = this.cache.getReceiptSkus();
        final Map mutableMap = MapsKt.toMutableMap(receiptSkus);
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<Receipt> list = receipts;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (!(((Receipt) next).getProductType() == com.amazon.device.iap.model.ProductType.SUBSCRIPTION)) {
                arrayList.add(next);
            }
        }
        ArrayList<Receipt> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (Receipt receipt : arrayList2) {
            arrayList3.add(TuplesKt.to(receipt.getReceiptId(), receipt.getSku()));
        }
        MapsKt.putAll(mutableMap, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : list) {
            if (((Receipt) obj).getProductType() == com.amazon.device.iap.model.ProductType.SUBSCRIPTION) {
                arrayList4.add(obj);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : arrayList4) {
            if (!receiptSkus.containsKey(((Receipt) obj2).getReceiptId())) {
                arrayList5.add(obj2);
            }
        }
        ArrayList<Receipt> arrayList6 = arrayList5;
        if (arrayList6.isEmpty()) {
            onCompletion.invoke(mutableMap, linkedHashMap);
            return;
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = arrayList6.size();
        for (final Receipt receipt2 : arrayList6) {
            AmazonBackend amazonBackend = this.amazonBackend;
            String receiptId = receipt2.getReceiptId();
            Intrinsics.checkNotNullExpressionValue(receiptId, "receipt.receiptId");
            amazonBackend.getAmazonReceiptData(receiptId, amazonUserID, new Function1<JSONObject, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$getMissingSkusForReceipts$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                    invoke2(jSONObject);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(JSONObject response) {
                    AmazonCache amazonCache;
                    Intrinsics.checkNotNullParameter(response, "response");
                    LogIntent logIntent = LogIntent.DEBUG;
                    String format = String.format(AmazonStrings.RECEIPT_DATA_RECEIVED, Arrays.copyOf(new Object[]{response.toString()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                    LogWrapperKt.log(logIntent, format);
                    Map<String, String> map = mutableMap;
                    String receiptId2 = receipt2.getReceiptId();
                    Intrinsics.checkNotNullExpressionValue(receiptId2, "receipt.receiptId");
                    Object obj3 = response.get(b.L);
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                    map.put(receiptId2, (String) obj3);
                    intRef.element--;
                    if (intRef.element == 0) {
                        amazonCache = this.cache;
                        amazonCache.cacheSkusByToken(mutableMap);
                        onCompletion.invoke(mutableMap, linkedHashMap);
                    }
                }
            }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$getMissingSkusForReceipts$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                    invoke2(purchasesError);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PurchasesError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    LogIntent logIntent = LogIntent.AMAZON_ERROR;
                    String format = String.format(AmazonStrings.ERROR_FETCHING_RECEIPT_INFO, Arrays.copyOf(new Object[]{error}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                    LogWrapperKt.log(logIntent, format);
                    Map<String, PurchasesError> map = linkedHashMap;
                    String receiptId2 = receipt2.getReceiptId();
                    Intrinsics.checkNotNullExpressionValue(receiptId2, "receipt.receiptId");
                    map.put(receiptId2, error);
                    intRef.element--;
                    if (intRef.element == 0) {
                        onCompletion.invoke(mutableMap, linkedHashMap);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleReceipt(final Receipt receipt, final UserData userData, StoreProduct storeProduct, final PresentedOfferingContext presentedOfferingContext) {
        if (receipt.getProductType() != com.amazon.device.iap.model.ProductType.SUBSCRIPTION) {
            StoreTransaction storeTransaction = StoreTransactionConversionsKt.toStoreTransaction(receipt, storeProduct.getId(), presentedOfferingContext, PurchaseState.PURCHASED, userData);
            BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
            if (purchasesUpdatedListener != null) {
                purchasesUpdatedListener.onPurchasesUpdated(CollectionsKt.listOf(storeTransaction));
                return;
            }
            return;
        }
        AmazonBackend amazonBackend = this.amazonBackend;
        String receiptId = receipt.getReceiptId();
        Intrinsics.checkNotNullExpressionValue(receiptId, "receipt.receiptId");
        String userId = userData.getUserId();
        Intrinsics.checkNotNullExpressionValue(userId, "userData.userId");
        amazonBackend.getAmazonReceiptData(receiptId, userId, new Function1<JSONObject, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$handleReceipt$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                invoke2(jSONObject);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject response) {
                Intrinsics.checkNotNullParameter(response, "response");
                Object obj = response.get(b.L);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                StoreTransaction storeTransaction2 = StoreTransactionConversionsKt.toStoreTransaction(Receipt.this, (String) obj, presentedOfferingContext, PurchaseState.PURCHASED, userData);
                BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener2 = this.getPurchasesUpdatedListener();
                if (purchasesUpdatedListener2 != null) {
                    purchasesUpdatedListener2.onPurchasesUpdated(CollectionsKt.listOf(storeTransaction2));
                }
            }
        }, new AmazonBilling$handleReceipt$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPurchaseError(PurchasesError error) {
        BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
        if (purchasesUpdatedListener != null) {
            purchasesUpdatedListener.onPurchasesFailedToUpdate(error);
        }
    }

    private final boolean checkObserverMode() {
        if (!this.observerMode) {
            return false;
        }
        LogWrapperKt.log(LogIntent.AMAZON_WARNING, AmazonStrings.WARNING_AMAZON_OBSERVER_MODE);
        return true;
    }

    private final synchronized void executeRequestOnUIThread(Function1<? super PurchasesError, Unit> request) {
        if (getPurchasesUpdatedListener() != null) {
            this.serviceRequests.add(request);
            if (!getConnected()) {
                BillingAbstract.startConnectionOnMainThread$default(this, 0L, 1, null);
            } else {
                executePendingRequests();
            }
        }
    }

    private final void executePendingRequests() {
        synchronized (this) {
            while (getConnected() && !this.serviceRequests.isEmpty()) {
                final Function1<PurchasesError, Unit> remove = this.serviceRequests.remove();
                runOnUIThread(new Runnable() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Function1.this.invoke(null);
                    }
                });
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void runOnUIThread(Runnable runnable) {
        if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            runnable.run();
        } else {
            this.mainHandler.post(runnable);
        }
    }
}
