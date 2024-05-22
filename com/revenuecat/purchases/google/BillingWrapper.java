package com.revenuecat.purchases.google;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingConfig;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.InAppMessageParams;
import com.android.billingclient.api.InAppMessageResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesStateProvider;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.PurchaseExtensionsKt;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCase;
import com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCaseParams;
import com.revenuecat.purchases.google.usecase.BillingClientUseCase;
import com.revenuecat.purchases.google.usecase.ConsumePurchaseUseCase;
import com.revenuecat.purchases.google.usecase.ConsumePurchaseUseCaseParams;
import com.revenuecat.purchases.google.usecase.GetBillingConfigUseCase;
import com.revenuecat.purchases.google.usecase.GetBillingConfigUseCaseParams;
import com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase;
import com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCaseParams;
import com.revenuecat.purchases.google.usecase.QueryPurchaseHistoryUseCase;
import com.revenuecat.purchases.google.usecase.QueryPurchaseHistoryUseCaseParams;
import com.revenuecat.purchases.google.usecase.QueryPurchasesByTypeUseCase;
import com.revenuecat.purchases.google.usecase.QueryPurchasesByTypeUseCaseParams;
import com.revenuecat.purchases.google.usecase.QueryPurchasesUseCase;
import com.revenuecat.purchases.google.usecase.QueryPurchasesUseCaseParams;
import com.revenuecat.purchases.models.GooglePurchasingData;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.OfferingStrings;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.strings.RestoreStrings;
import com.revenuecat.purchases.utils.Result;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: BillingWrapper.kt */
@Metadata(d1 = {"\u0000ª\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0090\u0001B9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J@\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/2!\u00100\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020+0&H\u0000¢\u0006\u0002\b2J3\u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020'042\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001e2\b\u00109\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010:J=\u0010;\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020'042\u0006\u00106\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u00108\u001a\u00020\u001e2\b\u00109\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010?J=\u0010@\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020'042\u0006\u00106\u001a\u00020A2\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u00108\u001a\u00020\u001e2\b\u00109\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010BJ \u0010C\u001a\u00020+2\u0006\u0010D\u001a\u00020\u00122\u0006\u0010E\u001a\u00020F2\u0006\u0010.\u001a\u00020/H\u0016J@\u0010G\u001a\u00020+2\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/2!\u0010H\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020+0&H\u0000¢\u0006\u0002\bIJ\b\u0010J\u001a\u00020+H\u0014J\b\u0010K\u001a\u00020+H\u0002J/\u0010L\u001a\u00020+2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010!2\u0014\u0010N\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0004\u0012\u00020+0&H\u0002¢\u0006\u0002\u0010OJH\u0010P\u001a\u00020+2\u0006\u00108\u001a\u00020\u001e2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u001e2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020+0&2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020+0&H\u0016J)\u0010V\u001a\u00020+2\u0006\u00101\u001a\u00020\u001e2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020+0&H\u0001¢\u0006\u0002\bXJ\b\u0010Y\u001a\u00020\u001eH\u0002J3\u0010Z\u001a\u00020+2\u0006\u0010E\u001a\u00020[2!\u0010\\\u001a\u001d\u0012\u0013\u0012\u00110F¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(]\u0012\u0004\u0012\u00020+0&H\u0002J4\u0010^\u001a\u00020+2\u0012\u0010_\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020+0&2\u0016\u0010U\u001a\u0012\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020+0&j\u0002``H\u0016J\b\u0010a\u001a\u00020\u0012H\u0016J\u0018\u0010b\u001a\u00020+2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u000205H\u0003JC\u0010f\u001a\u00020+2\u0006\u0010c\u001a\u00020d2\u0006\u00108\u001a\u00020\u001e2\u0006\u0010g\u001a\u00020h2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010i\u001a\u0004\u0018\u00010j2\b\u00109\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010kJ\b\u0010l\u001a\u00020+H\u0016J\u0010\u0010m\u001a\u00020+2\u0006\u0010n\u001a\u00020oH\u0016J \u0010p\u001a\u00020+2\u0006\u0010n\u001a\u00020o2\u000e\u0010q\u001a\n\u0012\u0004\u0012\u00020[\u0018\u00010rH\u0016J>\u0010s\u001a\u00020+2\u0006\u00108\u001a\u00020\u001e2\u0018\u0010t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0r\u0012\u0004\u0012\u00020+0&2\u0012\u0010u\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020+0&H\u0016JT\u0010v\u001a\u00020+2\u0006\u0010Q\u001a\u00020R2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020\u001e0x2\u001c\u0010y\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020z0r\u0012\u0004\u0012\u00020+0&j\u0002`{2\u0016\u0010U\u001a\u0012\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020+0&j\u0002``H\u0016J<\u0010|\u001a\u00020+2\u0006\u0010Q\u001a\u00020\u001e2\u0018\u0010t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020}0r\u0012\u0004\u0012\u00020+0&2\u0012\u0010u\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020+0&J@\u0010~\u001a\u00020+2\u0006\u0010Q\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001e2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020+0&2\u0012\u0010\u007f\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020+0&H\u0002JF\u0010\u0080\u0001\u001a\u00020+2\u0006\u00108\u001a\u00020\u001e2\u001f\u0010_\u001a\u001b\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020F0\u0081\u0001\u0012\u0004\u0012\u00020+0&2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020+0&H\u0016J\t\u0010\u0082\u0001\u001a\u00020+H\u0002J\u0012\u0010\u0083\u0001\u001a\u00020+2\u0007\u0010\u0084\u0001\u001a\u00020'H\u0002J1\u0010\u0085\u0001\u001a\u00020+2\u0006\u0010c\u001a\u00020d2\u000e\u0010\u0086\u0001\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010r2\u000e\u0010\u0088\u0001\u001a\t\u0012\u0004\u0012\u00020+0\u0089\u0001H\u0016J\t\u0010\u008a\u0001\u001a\u00020+H\u0016J\u0011\u0010\u008b\u0001\u001a\u00020+2\u0006\u0010M\u001a\u00020!H\u0016J\t\u0010\u008c\u0001\u001a\u00020+H\u0002J$\u0010\u008d\u0001\u001a\u00020+2\u0019\u0010\u008e\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020+0&¢\u0006\u0003\b\u008f\u0001H\u0002R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00128B@BX\u0082\u000e¢\u0006\u0002\n\u0000R?\u0010#\u001a3\u0012/\u0012-\u0012!\u0012\u001f\u0012\u0015\u0012\u0013\u0018\u00010'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020+0&\u0012\u0006\u0012\u0004\u0018\u00010!0%0$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0091\u0001"}, d2 = {"Lcom/revenuecat/purchases/google/BillingWrapper;", "Lcom/revenuecat/purchases/common/BillingAbstract;", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "Lcom/android/billingclient/api/BillingClientStateListener;", "clientFactory", "Lcom/revenuecat/purchases/google/BillingWrapper$ClientFactory;", "mainHandler", "Landroid/os/Handler;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "diagnosticsTrackerIfEnabled", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "purchasesStateProvider", "Lcom/revenuecat/purchases/PurchasesStateProvider;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Lcom/revenuecat/purchases/google/BillingWrapper$ClientFactory;Landroid/os/Handler;Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;Lcom/revenuecat/purchases/PurchasesStateProvider;Lcom/revenuecat/purchases/common/DateProvider;)V", "appInBackground", "", "getAppInBackground", "()Z", "<set-?>", "Lcom/android/billingclient/api/BillingClient;", "billingClient", "getBillingClient", "()Lcom/android/billingclient/api/BillingClient;", "setBillingClient", "(Lcom/android/billingclient/api/BillingClient;)V", "purchaseContext", "", "", "Lcom/revenuecat/purchases/google/PurchaseContext;", "reconnectMilliseconds", "", "reconnectionAlreadyScheduled", "serviceRequests", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Pair;", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "Lkotlin/ParameterName;", "name", "connectionError", "", "acknowledge", "token", "initiationSource", "Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "onAcknowledged", "purchaseToken", "acknowledge$purchases_defaultsRelease", "buildOneTimePurchaseParams", "Lcom/revenuecat/purchases/utils/Result;", "Lcom/android/billingclient/api/BillingFlowParams;", "purchaseInfo", "Lcom/revenuecat/purchases/models/GooglePurchasingData$InAppProduct;", "appUserID", "isPersonalizedPrice", "(Lcom/revenuecat/purchases/models/GooglePurchasingData$InAppProduct;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/revenuecat/purchases/utils/Result;", "buildPurchaseParams", "Lcom/revenuecat/purchases/models/GooglePurchasingData;", "replaceProductInfo", "Lcom/revenuecat/purchases/common/ReplaceProductInfo;", "(Lcom/revenuecat/purchases/models/GooglePurchasingData;Lcom/revenuecat/purchases/common/ReplaceProductInfo;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/revenuecat/purchases/utils/Result;", "buildSubscriptionPurchaseParams", "Lcom/revenuecat/purchases/models/GooglePurchasingData$Subscription;", "(Lcom/revenuecat/purchases/models/GooglePurchasingData$Subscription;Lcom/revenuecat/purchases/common/ReplaceProductInfo;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/revenuecat/purchases/utils/Result;", "consumeAndSave", "shouldTryToConsume", "purchase", "Lcom/revenuecat/purchases/models/StoreTransaction;", "consumePurchase", "onConsumed", "consumePurchase$purchases_defaultsRelease", "endConnection", "executePendingRequests", "executeRequestOnUIThread", "delayMilliseconds", "request", "(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "findPurchaseInPurchaseHistory", "productType", "Lcom/revenuecat/purchases/ProductType;", "productId", "onCompletion", "onError", "getPurchaseType", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getPurchaseType$purchases_defaultsRelease", "getStackTrace", "getStoreTransaction", "Lcom/android/billingclient/api/Purchase;", "completion", "storeTxn", "getStorefront", "onSuccess", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "isConnected", "launchBillingFlow", "activity", "Landroid/app/Activity;", OutcomeEventsTable.COLUMN_NAME_PARAMS, "makePurchaseAsync", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Landroid/app/Activity;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchasingData;Lcom/revenuecat/purchases/common/ReplaceProductInfo;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/Boolean;)V", "onBillingServiceDisconnected", "onBillingSetupFinished", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "onPurchasesUpdated", "purchases", "", "queryAllPurchases", "onReceivePurchaseHistory", "onReceivePurchaseHistoryError", "queryProductDetailsAsync", "productIds", "", "onReceive", "Lcom/revenuecat/purchases/models/StoreProduct;", "Lcom/revenuecat/purchases/common/StoreProductsCallback;", "queryPurchaseHistoryAsync", "Lcom/android/billingclient/api/PurchaseHistoryRecord;", "queryPurchaseType", "resultHandler", "queryPurchases", "", "retryBillingServiceConnectionWithExponentialBackoff", "sendErrorsToAllPendingRequests", "error", "showInAppMessagesIfNeeded", "inAppMessageTypes", "Lcom/revenuecat/purchases/models/InAppMessageType;", "subscriptionStatusChange", "Lkotlin/Function0;", "startConnection", "startConnectionOnMainThread", "trackProductDetailsNotSupportedIfNeeded", "withConnectedClient", "receivingFunction", "Lkotlin/ExtensionFunctionType;", "ClientFactory", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class BillingWrapper extends BillingAbstract implements PurchasesUpdatedListener, BillingClientStateListener {
    private volatile BillingClient billingClient;
    private final ClientFactory clientFactory;
    private final DateProvider dateProvider;
    private final DeviceCache deviceCache;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final Handler mainHandler;
    private final Map<String, PurchaseContext> purchaseContext;
    private long reconnectMilliseconds;
    private boolean reconnectionAlreadyScheduled;
    private final ConcurrentLinkedQueue<Pair<Function1<PurchasesError, Unit>, Long>> serviceRequests;

    public /* synthetic */ BillingWrapper(ClientFactory clientFactory, Handler handler, DeviceCache deviceCache, DiagnosticsTracker diagnosticsTracker, PurchasesStateProvider purchasesStateProvider, DefaultDateProvider defaultDateProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(clientFactory, handler, deviceCache, diagnosticsTracker, purchasesStateProvider, (i & 32) != 0 ? new DefaultDateProvider() : defaultDateProvider);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingWrapper(ClientFactory clientFactory, Handler mainHandler, DeviceCache deviceCache, DiagnosticsTracker diagnosticsTracker, PurchasesStateProvider purchasesStateProvider, DateProvider dateProvider) {
        super(purchasesStateProvider);
        Intrinsics.checkNotNullParameter(clientFactory, "clientFactory");
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(purchasesStateProvider, "purchasesStateProvider");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.clientFactory = clientFactory;
        this.mainHandler = mainHandler;
        this.deviceCache = deviceCache;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.dateProvider = dateProvider;
        this.purchaseContext = new LinkedHashMap();
        this.serviceRequests = new ConcurrentLinkedQueue<>();
        this.reconnectMilliseconds = 1000L;
    }

    public final synchronized BillingClient getBillingClient() {
        return this.billingClient;
    }

    public final synchronized void setBillingClient(BillingClient billingClient) {
        this.billingClient = billingClient;
    }

    public final boolean getAppInBackground() {
        return getPurchasesStateProvider().getPurchasesState().getAppInBackground();
    }

    /* compiled from: BillingWrapper.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/google/BillingWrapper$ClientFactory;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "buildClient", "Lcom/android/billingclient/api/BillingClient;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ClientFactory {
        private final Context context;

        public ClientFactory(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
        }

        public final BillingClient buildClient(PurchasesUpdatedListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            BillingClient build = BillingClient.newBuilder(this.context).enablePendingPurchases().setListener(listener).build();
            Intrinsics.checkNotNullExpressionValue(build, "newBuilder(context).enab…\n                .build()");
            return build;
        }
    }

    private final void executePendingRequests() {
        Pair<Function1<PurchasesError, Unit>, Long> poll;
        synchronized (this) {
            while (true) {
                BillingClient billingClient = this.billingClient;
                boolean z = false;
                if (billingClient != null && billingClient.isReady()) {
                    z = true;
                }
                if (!z || (poll = this.serviceRequests.poll()) == null) {
                    break;
                }
                Intrinsics.checkNotNullExpressionValue(poll, "poll()");
                final Function1<PurchasesError, Unit> component1 = poll.component1();
                Long component2 = poll.component2();
                if (component2 != null) {
                    this.mainHandler.postDelayed(new Runnable() { // from class: com.revenuecat.purchases.google.BillingWrapper$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            BillingWrapper.executePendingRequests$lambda$3$lambda$2$lambda$0(Function1.this);
                        }
                    }, component2.longValue());
                } else {
                    this.mainHandler.post(new Runnable() { // from class: com.revenuecat.purchases.google.BillingWrapper$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            BillingWrapper.executePendingRequests$lambda$3$lambda$2$lambda$1(Function1.this);
                        }
                    });
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executePendingRequests$lambda$3$lambda$2$lambda$0(Function1 request) {
        Intrinsics.checkNotNullParameter(request, "$request");
        request.invoke(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executePendingRequests$lambda$3$lambda$2$lambda$1(Function1 request) {
        Intrinsics.checkNotNullParameter(request, "$request");
        request.invoke(null);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void startConnectionOnMainThread(long delayMilliseconds) {
        this.mainHandler.postDelayed(new Runnable() { // from class: com.revenuecat.purchases.google.BillingWrapper$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                BillingWrapper.startConnectionOnMainThread$lambda$4(BillingWrapper.this);
            }
        }, delayMilliseconds);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startConnectionOnMainThread$lambda$4(BillingWrapper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startConnection();
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void startConnection() {
        synchronized (this) {
            if (this.billingClient == null) {
                this.billingClient = this.clientFactory.buildClient(this);
            }
            this.reconnectionAlreadyScheduled = false;
            BillingClient billingClient = this.billingClient;
            if (billingClient != null) {
                if (!billingClient.isReady()) {
                    LogIntent logIntent = LogIntent.DEBUG;
                    String format = String.format(BillingStrings.BILLING_CLIENT_STARTING, Arrays.copyOf(new Object[]{billingClient}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                    LogWrapperKt.log(logIntent, format);
                    try {
                        billingClient.startConnection(this);
                    } catch (IllegalStateException e) {
                        LogIntent logIntent2 = LogIntent.GOOGLE_ERROR;
                        String format2 = String.format(BillingStrings.ILLEGAL_STATE_EXCEPTION_WHEN_CONNECTING, Arrays.copyOf(new Object[]{e}, 1));
                        Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
                        LogWrapperKt.log(logIntent2, format2);
                        sendErrorsToAllPendingRequests(new PurchasesError(PurchasesErrorCode.StoreProblemError, e.getMessage()));
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    protected void endConnection() {
        this.mainHandler.post(new Runnable() { // from class: com.revenuecat.purchases.google.BillingWrapper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BillingWrapper.endConnection$lambda$9(BillingWrapper.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endConnection$lambda$9(BillingWrapper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (this$0) {
            BillingClient billingClient = this$0.billingClient;
            if (billingClient != null) {
                LogIntent logIntent = LogIntent.DEBUG;
                String format = String.format(BillingStrings.BILLING_CLIENT_ENDING, Arrays.copyOf(new Object[]{billingClient}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                LogWrapperKt.log(logIntent, format);
                billingClient.endConnection();
            }
            this$0.billingClient = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    static /* synthetic */ void executeRequestOnUIThread$default(BillingWrapper billingWrapper, Long l, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        billingWrapper.executeRequestOnUIThread(l, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void executeRequestOnUIThread(Long delayMilliseconds, Function1<? super PurchasesError, Unit> request) {
        if (getPurchasesUpdatedListener() != null) {
            this.serviceRequests.add(TuplesKt.to(request, delayMilliseconds));
            BillingClient billingClient = this.billingClient;
            boolean z = false;
            if (billingClient != null && !billingClient.isReady()) {
                z = true;
            }
            if (z) {
                BillingAbstract.startConnectionOnMainThread$default(this, 0L, 1, null);
            } else {
                executePendingRequests();
            }
        } else {
            request.invoke(new PurchasesError(PurchasesErrorCode.UnknownError, "BillingWrapper is not attached to a listener"));
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryProductDetailsAsync(ProductType productType, Set<String> productIds, Function1<? super List<? extends StoreProduct>, Unit> onReceive, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Intrinsics.checkNotNullParameter(onError, "onError");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(OfferingStrings.FETCHING_PRODUCTS, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(productIds, null, null, null, 0, null, null, 63, null)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        BillingClientUseCase.run$default(new QueryProductDetailsUseCase(new QueryProductDetailsUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, productIds, productType, getAppInBackground()), onReceive, onError, new BillingWrapper$queryProductDetailsAsync$useCase$1(this), new BillingWrapper$queryProductDetailsAsync$useCase$2(this)), 0L, 1, null);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void makePurchaseAsync(final Activity activity, final String appUserID, final PurchasingData purchasingData, final ReplaceProductInfo replaceProductInfo, PresentedOfferingContext presentedOfferingContext, final Boolean isPersonalizedPrice) {
        String optionId;
        PresentedOfferingContext presentedOfferingContext2;
        GoogleReplacementMode googleReplacementMode;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(purchasingData, "purchasingData");
        GooglePurchasingData googlePurchasingData = purchasingData instanceof GooglePurchasingData ? (GooglePurchasingData) purchasingData : null;
        if (googlePurchasingData == null) {
            PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.UnknownError;
            String format = String.format(PurchaseStrings.INVALID_PURCHASE_TYPE, Arrays.copyOf(new Object[]{"Play", "GooglePurchasingData"}, 2));
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
        if (googlePurchasingData instanceof GooglePurchasingData.InAppProduct) {
            optionId = null;
        } else if (googlePurchasingData instanceof GooglePurchasingData.Subscription) {
            optionId = ((GooglePurchasingData.Subscription) googlePurchasingData).getOptionId();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (replaceProductInfo != null) {
            LogIntent logIntent = LogIntent.PURCHASE;
            String format2 = String.format(PurchaseStrings.UPGRADING_SKU, Arrays.copyOf(new Object[]{replaceProductInfo.getOldPurchase().getProductIds().get(0), googlePurchasingData.getProductId()}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
            LogWrapperKt.log(logIntent, format2);
        } else {
            LogIntent logIntent2 = LogIntent.PURCHASE;
            String format3 = String.format(PurchaseStrings.PURCHASING_PRODUCT, Arrays.copyOf(new Object[]{googlePurchasingData.getProductId()}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(this, *args)");
            LogWrapperKt.log(logIntent2, format3);
        }
        synchronized (this) {
            String productId = googlePurchasingData.getProductId();
            Map<String, PurchaseContext> map = this.purchaseContext;
            ProductType productType = googlePurchasingData.getProductType();
            ReplacementMode replacementMode = replaceProductInfo != null ? replaceProductInfo.getReplacementMode() : null;
            if (replacementMode instanceof GoogleReplacementMode) {
                googleReplacementMode = (GoogleReplacementMode) replacementMode;
                presentedOfferingContext2 = presentedOfferingContext;
            } else {
                presentedOfferingContext2 = presentedOfferingContext;
                googleReplacementMode = null;
            }
            map.put(productId, new PurchaseContext(productType, presentedOfferingContext2, optionId, googleReplacementMode));
            Unit unit = Unit.INSTANCE;
        }
        executeRequestOnUIThread$default(this, null, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$makePurchaseAsync$2
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
                Result buildPurchaseParams;
                BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener2;
                buildPurchaseParams = BillingWrapper.this.buildPurchaseParams((GooglePurchasingData) purchasingData, replaceProductInfo, appUserID, isPersonalizedPrice);
                if (buildPurchaseParams instanceof Result.Success) {
                    BillingWrapper.this.launchBillingFlow(activity, (BillingFlowParams) ((Result.Success) buildPurchaseParams).getValue());
                } else {
                    if (!(buildPurchaseParams instanceof Result.Error) || (purchasesUpdatedListener2 = BillingWrapper.this.getPurchasesUpdatedListener()) == null) {
                        return;
                    }
                    purchasesUpdatedListener2.onPurchasesFailedToUpdate((PurchasesError) ((Result.Error) buildPurchaseParams).getValue());
                }
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchBillingFlow(final Activity activity, final BillingFlowParams params) {
        if (activity.getIntent() == null) {
            LogWrapperKt.log(LogIntent.WARNING, BillingStrings.NULL_ACTIVITY_INTENT);
        }
        withConnectedClient(new Function1<BillingClient, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$launchBillingFlow$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BillingClient billingClient) {
                invoke2(billingClient);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BillingClient withConnectedClient) {
                Intrinsics.checkNotNullParameter(withConnectedClient, "$this$withConnectedClient");
                BillingResult launchBillingFlow = withConnectedClient.launchBillingFlow(activity, params);
                if (!(launchBillingFlow.getResponseCode() != 0)) {
                    launchBillingFlow = null;
                }
                if (launchBillingFlow != null) {
                    LogIntent logIntent = LogIntent.GOOGLE_ERROR;
                    String format = String.format(BillingStrings.BILLING_INTENT_FAILED, Arrays.copyOf(new Object[]{BillingResultExtensionsKt.toHumanReadableDescription(launchBillingFlow)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                    LogWrapperKt.log(logIntent, format);
                }
            }
        });
    }

    public final void queryPurchaseHistoryAsync(String productType, Function1<? super List<? extends PurchaseHistoryRecord>, Unit> onReceivePurchaseHistory, Function1<? super PurchasesError, Unit> onReceivePurchaseHistoryError) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistory, "onReceivePurchaseHistory");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistoryError, "onReceivePurchaseHistoryError");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(RestoreStrings.QUERYING_PURCHASE_HISTORY, Arrays.copyOf(new Object[]{productType}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        BillingClientUseCase.run$default(new QueryPurchaseHistoryUseCase(new QueryPurchaseHistoryUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, productType, getAppInBackground()), onReceivePurchaseHistory, onReceivePurchaseHistoryError, new BillingWrapper$queryPurchaseHistoryAsync$1(this), new BillingWrapper$queryPurchaseHistoryAsync$2(this)), 0L, 1, null);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryAllPurchases(String appUserID, final Function1<? super List<StoreTransaction>, Unit> onReceivePurchaseHistory, final Function1<? super PurchasesError, Unit> onReceivePurchaseHistoryError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistory, "onReceivePurchaseHistory");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistoryError, "onReceivePurchaseHistoryError");
        queryPurchaseHistoryAsync("subs", new Function1<List<? extends PurchaseHistoryRecord>, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$queryAllPurchases$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends PurchaseHistoryRecord> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final List<? extends PurchaseHistoryRecord> subsPurchasesList) {
                Intrinsics.checkNotNullParameter(subsPurchasesList, "subsPurchasesList");
                BillingWrapper billingWrapper = BillingWrapper.this;
                final Function1<List<StoreTransaction>, Unit> function1 = onReceivePurchaseHistory;
                billingWrapper.queryPurchaseHistoryAsync("inapp", new Function1<List<? extends PurchaseHistoryRecord>, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$queryAllPurchases$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends PurchaseHistoryRecord> list) {
                        invoke2(list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<? extends PurchaseHistoryRecord> inAppPurchasesList) {
                        Intrinsics.checkNotNullParameter(inAppPurchasesList, "inAppPurchasesList");
                        Function1<List<StoreTransaction>, Unit> function12 = function1;
                        List<PurchaseHistoryRecord> list = subsPurchasesList;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(StoreTransactionConversionsKt.toStoreTransaction((PurchaseHistoryRecord) it.next(), ProductType.SUBS));
                        }
                        ArrayList arrayList2 = arrayList;
                        List<? extends PurchaseHistoryRecord> list2 = inAppPurchasesList;
                        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                        Iterator<T> it2 = list2.iterator();
                        while (it2.hasNext()) {
                            arrayList3.add(StoreTransactionConversionsKt.toStoreTransaction((PurchaseHistoryRecord) it2.next(), ProductType.INAPP));
                        }
                        function12.invoke(CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList3));
                    }
                }, onReceivePurchaseHistoryError);
            }
        }, onReceivePurchaseHistoryError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void consumeAndSave(boolean shouldTryToConsume, StoreTransaction purchase, PostReceiptInitiationSource initiationSource) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        if (purchase.getType() == ProductType.UNKNOWN || purchase.getPurchaseState() == PurchaseState.PENDING) {
            return;
        }
        Purchase originalGooglePurchase = StoreTransactionConversionsKt.getOriginalGooglePurchase(purchase);
        boolean isAcknowledged = originalGooglePurchase != null ? originalGooglePurchase.isAcknowledged() : false;
        if (shouldTryToConsume && purchase.getType() == ProductType.INAPP) {
            consumePurchase$purchases_defaultsRelease(purchase.getPurchaseToken(), initiationSource, new BillingWrapper$consumeAndSave$1(this.deviceCache));
        } else if (shouldTryToConsume && !isAcknowledged) {
            acknowledge$purchases_defaultsRelease(purchase.getPurchaseToken(), initiationSource, new BillingWrapper$consumeAndSave$2(this.deviceCache));
        } else {
            this.deviceCache.addSuccessfullyPostedToken(purchase.getPurchaseToken());
        }
    }

    public final void consumePurchase$purchases_defaultsRelease(String token, PostReceiptInitiationSource initiationSource, Function1<? super String, Unit> onConsumed) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        Intrinsics.checkNotNullParameter(onConsumed, "onConsumed");
        LogIntent logIntent = LogIntent.PURCHASE;
        String format = String.format(PurchaseStrings.CONSUMING_PURCHASE, Arrays.copyOf(new Object[]{token}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        BillingClientUseCase.run$default(new ConsumePurchaseUseCase(new ConsumePurchaseUseCaseParams(token, initiationSource, getAppInBackground()), onConsumed, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$consumePurchase$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                LogIntent logIntent2 = LogIntent.GOOGLE_ERROR;
                String format2 = String.format(PurchaseStrings.CONSUMING_PURCHASE_ERROR, Arrays.copyOf(new Object[]{error.getUnderlyingErrorMessage()}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
                LogWrapperKt.log(logIntent2, format2);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }
        }, new BillingWrapper$consumePurchase$2(this), new BillingWrapper$consumePurchase$3(this)), 0L, 1, null);
    }

    public final void acknowledge$purchases_defaultsRelease(String token, PostReceiptInitiationSource initiationSource, Function1<? super String, Unit> onAcknowledged) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        Intrinsics.checkNotNullParameter(onAcknowledged, "onAcknowledged");
        LogIntent logIntent = LogIntent.PURCHASE;
        String format = String.format(PurchaseStrings.ACKNOWLEDGING_PURCHASE, Arrays.copyOf(new Object[]{token}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        BillingClientUseCase.run$default(new AcknowledgePurchaseUseCase(new AcknowledgePurchaseUseCaseParams(token, initiationSource, getAppInBackground()), onAcknowledged, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$acknowledge$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                LogIntent logIntent2 = LogIntent.GOOGLE_ERROR;
                String format2 = String.format(PurchaseStrings.ACKNOWLEDGING_PURCHASE_ERROR, Arrays.copyOf(new Object[]{error.getUnderlyingErrorMessage()}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
                LogWrapperKt.log(logIntent2, format2);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }
        }, new BillingWrapper$acknowledge$2(this), new BillingWrapper$acknowledge$3(this)), 0L, 1, null);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryPurchases(String appUserID, Function1<? super Map<String, StoreTransaction>, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        LogWrapperKt.log(LogIntent.DEBUG, RestoreStrings.QUERYING_PURCHASE);
        BillingClientUseCase.run$default(new QueryPurchasesUseCase(new QueryPurchasesUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, getAppInBackground()), onSuccess, onError, new BillingWrapper$queryPurchases$1(this), new BillingWrapper$queryPurchases$2(this)), 0L, 1, null);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void findPurchaseInPurchaseHistory(String appUserID, final ProductType productType, final String productId, final Function1<? super StoreTransaction, Unit> onCompletion, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(onCompletion, "onCompletion");
        Intrinsics.checkNotNullParameter(onError, "onError");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(RestoreStrings.QUERYING_PURCHASE_WITH_TYPE, Arrays.copyOf(new Object[]{productId, productType.name()}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        String googleProductType = ProductTypeConversionsKt.toGoogleProductType(productType);
        Unit unit = null;
        if (googleProductType != null) {
            BillingClientUseCase.run$default(new QueryPurchaseHistoryUseCase(new QueryPurchaseHistoryUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, googleProductType, getAppInBackground()), new Function1<List<? extends PurchaseHistoryRecord>, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$findPurchaseInPurchaseHistory$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends PurchaseHistoryRecord> purchasesList) {
                    Object obj;
                    Intrinsics.checkNotNullParameter(purchasesList, "purchasesList");
                    String str = productId;
                    Iterator<T> it = purchasesList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        } else {
                            obj = it.next();
                            if (((PurchaseHistoryRecord) obj).getProducts().contains(str)) {
                                break;
                            }
                        }
                    }
                    PurchaseHistoryRecord purchaseHistoryRecord = (PurchaseHistoryRecord) obj;
                    StoreTransaction storeTransaction = purchaseHistoryRecord != null ? StoreTransactionConversionsKt.toStoreTransaction(purchaseHistoryRecord, ProductType.this) : null;
                    if (storeTransaction != null) {
                        onCompletion.invoke(storeTransaction);
                        return;
                    }
                    String format2 = String.format(PurchaseStrings.NO_EXISTING_PURCHASE, Arrays.copyOf(new Object[]{productId}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
                    onError.invoke(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, format2));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends PurchaseHistoryRecord> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }
            }, onError, new BillingWrapper$findPurchaseInPurchaseHistory$1$2(this), new BillingWrapper$findPurchaseInPurchaseHistory$1$3(this)), 0L, 1, null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            onError.invoke(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, PurchaseStrings.NOT_RECOGNIZED_PRODUCT_TYPE));
        }
    }

    public final void getPurchaseType$purchases_defaultsRelease(final String purchaseToken, final Function1<? super ProductType, Unit> listener) {
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(listener, "listener");
        queryPurchaseType("subs", purchaseToken, listener, new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$getPurchaseType$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    listener.invoke(ProductType.SUBS);
                    return;
                }
                BillingWrapper billingWrapper = this;
                String str = purchaseToken;
                Function1<ProductType, Unit> function1 = listener;
                final Function1<ProductType, Unit> function12 = listener;
                billingWrapper.queryPurchaseType("inapp", str, function1, new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$getPurchaseType$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z2) {
                        if (z2) {
                            function12.invoke(ProductType.INAPP);
                        } else {
                            function12.invoke(ProductType.UNKNOWN);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void queryPurchaseType(String productType, final String purchaseToken, final Function1<? super ProductType, Unit> listener, final Function1<? super Boolean, Unit> resultHandler) {
        BillingClientUseCase.run$default(new QueryPurchasesByTypeUseCase(new QueryPurchasesByTypeUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, getAppInBackground(), productType), new Function1<Map<String, ? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$queryPurchaseType$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, StoreTransaction> purchases) {
                Intrinsics.checkNotNullParameter(purchases, "purchases");
                Function1<Boolean, Unit> function1 = resultHandler;
                Collection<StoreTransaction> values = purchases.values();
                String str = purchaseToken;
                boolean z = false;
                if (!(values instanceof Collection) || !values.isEmpty()) {
                    Iterator<T> it = values.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (Intrinsics.areEqual(((StoreTransaction) it.next()).getPurchaseToken(), str)) {
                            z = true;
                            break;
                        }
                    }
                }
                function1.invoke(Boolean.valueOf(z));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends StoreTransaction> map) {
                invoke2((Map<String, StoreTransaction>) map);
                return Unit.INSTANCE;
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$queryPurchaseType$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                LogUtilsKt.errorLog(error);
                listener.invoke(ProductType.UNKNOWN);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }
        }, new BillingWrapper$queryPurchaseType$3(this), new BillingWrapper$queryPurchaseType$4(this)), 0L, 1, null);
    }

    @Override // com.android.billingclient.api.PurchasesUpdatedListener
    public void onPurchasesUpdated(BillingResult billingResult, List<? extends Purchase> purchases) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        final List<? extends Purchase> emptyList = purchases == null ? CollectionsKt.emptyList() : purchases;
        if (billingResult.getResponseCode() == 0 && (!emptyList.isEmpty())) {
            final ArrayList arrayList = new ArrayList();
            Iterator<T> it = emptyList.iterator();
            while (it.hasNext()) {
                getStoreTransaction((Purchase) it.next(), new Function1<StoreTransaction, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction) {
                        invoke2(storeTransaction);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(StoreTransaction storeTxn) {
                        BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener;
                        Intrinsics.checkNotNullParameter(storeTxn, "storeTxn");
                        arrayList.add(storeTxn);
                        if (arrayList.size() != emptyList.size() || (purchasesUpdatedListener = this.getPurchasesUpdatedListener()) == null) {
                            return;
                        }
                        purchasesUpdatedListener.onPurchasesUpdated(arrayList);
                    }
                });
            }
            return;
        }
        LogIntent logIntent = LogIntent.GOOGLE_ERROR;
        StringBuilder sb = new StringBuilder();
        String format = String.format(BillingStrings.BILLING_WRAPPER_PURCHASES_ERROR, Arrays.copyOf(new Object[]{BillingResultExtensionsKt.toHumanReadableDescription(billingResult)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        sb.append(format);
        String str = null;
        if (emptyList.isEmpty()) {
            emptyList = null;
        }
        if (emptyList != null) {
            str = "Purchases:" + CollectionsKt.joinToString$default(emptyList, ", ", null, null, 0, null, new Function1<Purchase, CharSequence>() { // from class: com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$3$1
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(Purchase it2) {
                    Intrinsics.checkNotNullParameter(it2, "it");
                    return PurchaseExtensionsKt.toHumanReadableDescription(it2);
                }
            }, 30, null);
        }
        sb.append(str);
        LogWrapperKt.log(logIntent, sb.toString());
        String str2 = "Error updating purchases. " + BillingResultExtensionsKt.toHumanReadableDescription(billingResult);
        int responseCode = billingResult.getResponseCode();
        if (purchases == null && billingResult.getResponseCode() == 0) {
            str2 = "Error: onPurchasesUpdated received an OK BillingResult with a Null purchases list.";
            responseCode = 6;
        }
        PurchasesError billingResponseToPurchasesError = ErrorsKt.billingResponseToPurchasesError(responseCode, str2);
        LogUtilsKt.errorLog(billingResponseToPurchasesError);
        BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
        if (purchasesUpdatedListener != null) {
            purchasesUpdatedListener.onPurchasesFailedToUpdate(billingResponseToPurchasesError);
        }
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public void onBillingSetupFinished(final BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        this.mainHandler.post(new Runnable() { // from class: com.revenuecat.purchases.google.BillingWrapper$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                BillingWrapper.onBillingSetupFinished$lambda$18(BillingResult.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBillingSetupFinished$lambda$18(BillingResult billingResult, BillingWrapper this$0) {
        PurchasesError billingResponseToPurchasesError;
        Intrinsics.checkNotNullParameter(billingResult, "$billingResult");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int responseCode = billingResult.getResponseCode();
        if (responseCode != 6) {
            if (responseCode != 7 && responseCode != 8) {
                if (responseCode != 12) {
                    switch (responseCode) {
                        case -2:
                        case 3:
                            String humanReadableDescription = BillingResultExtensionsKt.toHumanReadableDescription(billingResult);
                            if (Intrinsics.areEqual(billingResult.getDebugMessage(), ErrorsKt.IN_APP_BILLING_LESS_THAN_3_ERROR_MESSAGE)) {
                                String format = String.format(BillingStrings.BILLING_UNAVAILABLE_LESS_THAN_3, Arrays.copyOf(new Object[]{humanReadableDescription}, 1));
                                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                                billingResponseToPurchasesError = new PurchasesError(PurchasesErrorCode.StoreProblemError, format);
                                LogUtilsKt.errorLog(billingResponseToPurchasesError);
                            } else {
                                String format2 = String.format(BillingStrings.BILLING_UNAVAILABLE, Arrays.copyOf(new Object[]{humanReadableDescription}, 1));
                                Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
                                billingResponseToPurchasesError = ErrorsKt.billingResponseToPurchasesError(billingResult.getResponseCode(), format2);
                                LogUtilsKt.errorLog(billingResponseToPurchasesError);
                            }
                            this$0.sendErrorsToAllPendingRequests(billingResponseToPurchasesError);
                            return;
                        case -1:
                        case 1:
                        case 2:
                            break;
                        case 0:
                            LogIntent logIntent = LogIntent.DEBUG;
                            Object[] objArr = new Object[1];
                            BillingClient billingClient = this$0.billingClient;
                            objArr[0] = billingClient != null ? billingClient.toString() : null;
                            String format3 = String.format(BillingStrings.BILLING_SERVICE_SETUP_FINISHED, Arrays.copyOf(objArr, 1));
                            Intrinsics.checkNotNullExpressionValue(format3, "format(this, *args)");
                            LogWrapperKt.log(logIntent, format3);
                            BillingAbstract.StateListener stateListener = this$0.getStateListener();
                            if (stateListener != null) {
                                stateListener.onConnected();
                            }
                            this$0.executePendingRequests();
                            this$0.reconnectMilliseconds = 1000L;
                            this$0.trackProductDetailsNotSupportedIfNeeded();
                            return;
                        case 4:
                            break;
                        default:
                            return;
                    }
                }
            }
            LogIntent logIntent2 = LogIntent.GOOGLE_WARNING;
            String format4 = String.format(BillingStrings.BILLING_CLIENT_ERROR, Arrays.copyOf(new Object[]{BillingResultExtensionsKt.toHumanReadableDescription(billingResult)}, 1));
            Intrinsics.checkNotNullExpressionValue(format4, "format(this, *args)");
            LogWrapperKt.log(logIntent2, format4);
            return;
        }
        LogIntent logIntent3 = LogIntent.GOOGLE_WARNING;
        String format5 = String.format(BillingStrings.BILLING_CLIENT_ERROR, Arrays.copyOf(new Object[]{BillingResultExtensionsKt.toHumanReadableDescription(billingResult)}, 1));
        Intrinsics.checkNotNullExpressionValue(format5, "format(this, *args)");
        LogWrapperKt.log(logIntent3, format5);
        this$0.retryBillingServiceConnectionWithExponentialBackoff();
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public void onBillingServiceDisconnected() {
        LogIntent logIntent = LogIntent.WARNING;
        Object[] objArr = new Object[1];
        BillingClient billingClient = this.billingClient;
        objArr[0] = billingClient != null ? billingClient.toString() : null;
        String format = String.format(BillingStrings.BILLING_SERVICE_DISCONNECTED_INSTANCE, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
    }

    private final void retryBillingServiceConnectionWithExponentialBackoff() {
        if (this.reconnectionAlreadyScheduled) {
            LogWrapperKt.log(LogIntent.WARNING, BillingStrings.BILLING_CLIENT_RETRY_ALREADY_SCHEDULED);
            return;
        }
        LogIntent logIntent = LogIntent.WARNING;
        String format = String.format(BillingStrings.BILLING_CLIENT_RETRY, Arrays.copyOf(new Object[]{Long.valueOf(this.reconnectMilliseconds)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.reconnectionAlreadyScheduled = true;
        startConnectionOnMainThread(this.reconnectMilliseconds);
        this.reconnectMilliseconds = Math.min(this.reconnectMilliseconds * 2, 900000L);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    /* renamed from: isConnected */
    public boolean getConnected() {
        BillingClient billingClient = this.billingClient;
        if (billingClient != null) {
            return billingClient.isReady();
        }
        return false;
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes, final Function0<Unit> subscriptionStatusChange) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(inAppMessageTypes, "inAppMessageTypes");
        Intrinsics.checkNotNullParameter(subscriptionStatusChange, "subscriptionStatusChange");
        if (inAppMessageTypes.isEmpty()) {
            LogUtilsKt.errorLog$default(BillingStrings.BILLING_UNSPECIFIED_INAPP_MESSAGE_TYPES, null, 2, null);
            return;
        }
        InAppMessageParams.Builder newBuilder = InAppMessageParams.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        Iterator<? extends InAppMessageType> it = inAppMessageTypes.iterator();
        while (it.hasNext()) {
            newBuilder.addInAppMessageCategoryToShow(it.next().getInAppMessageCategoryId());
        }
        final InAppMessageParams build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "inAppMessageParamsBuilder.build()");
        final WeakReference weakReference = new WeakReference(activity);
        executeRequestOnUIThread$default(this, null, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$showInAppMessagesIfNeeded$1
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
                if (purchasesError == null) {
                    BillingWrapper.this.withConnectedClient(new AnonymousClass1(weakReference, build, subscriptionStatusChange));
                    return;
                }
                String format = String.format(BillingStrings.BILLING_CONNECTION_ERROR_INAPP_MESSAGES, Arrays.copyOf(new Object[]{purchasesError}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                LogUtilsKt.errorLog$default(format, null, 2, null);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: BillingWrapper.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.revenuecat.purchases.google.BillingWrapper$showInAppMessagesIfNeeded$1$1, reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass1 extends Lambda implements Function1<BillingClient, Unit> {
                final /* synthetic */ InAppMessageParams $inAppMessageParams;
                final /* synthetic */ Function0<Unit> $subscriptionStatusChange;
                final /* synthetic */ WeakReference<Activity> $weakActivity;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(WeakReference<Activity> weakReference, InAppMessageParams inAppMessageParams, Function0<Unit> function0) {
                    super(1);
                    this.$weakActivity = weakReference;
                    this.$inAppMessageParams = inAppMessageParams;
                    this.$subscriptionStatusChange = function0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BillingClient billingClient) {
                    invoke2(billingClient);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BillingClient withConnectedClient) {
                    Intrinsics.checkNotNullParameter(withConnectedClient, "$this$withConnectedClient");
                    Activity activity = this.$weakActivity.get();
                    if (activity == null) {
                        LogUtilsKt.debugLog("Activity is null, not showing Google Play in-app message.");
                        return;
                    }
                    InAppMessageParams inAppMessageParams = this.$inAppMessageParams;
                    final Function0<Unit> function0 = this.$subscriptionStatusChange;
                    withConnectedClient.showInAppMessages(activity, inAppMessageParams, 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001e: INVOKE 
                          (r5v0 'withConnectedClient' com.android.billingclient.api.BillingClient)
                          (r0v3 'activity' android.app.Activity)
                          (r1v0 'inAppMessageParams' com.android.billingclient.api.InAppMessageParams)
                          (wrap:com.android.billingclient.api.InAppMessageResponseListener:0x001b: CONSTRUCTOR (r2v0 'function0' kotlin.jvm.functions.Function0<kotlin.Unit> A[DONT_INLINE]) A[MD:(kotlin.jvm.functions.Function0):void (m), WRAPPED] call: com.revenuecat.purchases.google.BillingWrapper$showInAppMessagesIfNeeded$1$1$$ExternalSyntheticLambda0.<init>(kotlin.jvm.functions.Function0):void type: CONSTRUCTOR)
                         VIRTUAL call: com.android.billingclient.api.BillingClient.showInAppMessages(android.app.Activity, com.android.billingclient.api.InAppMessageParams, com.android.billingclient.api.InAppMessageResponseListener):com.android.billingclient.api.BillingResult A[MD:(android.app.Activity, com.android.billingclient.api.InAppMessageParams, com.android.billingclient.api.InAppMessageResponseListener):com.android.billingclient.api.BillingResult (m)] in method: com.revenuecat.purchases.google.BillingWrapper$showInAppMessagesIfNeeded$1.1.invoke(com.android.billingclient.api.BillingClient):void, file: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.revenuecat.purchases.google.BillingWrapper$showInAppMessagesIfNeeded$1$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 19 more
                        */
                    /*
                        this = this;
                        java.lang.String r0 = "$this$withConnectedClient"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                        java.lang.ref.WeakReference<android.app.Activity> r0 = r4.$weakActivity
                        java.lang.Object r0 = r0.get()
                        android.app.Activity r0 = (android.app.Activity) r0
                        if (r0 != 0) goto L15
                        java.lang.String r5 = "Activity is null, not showing Google Play in-app message."
                        com.revenuecat.purchases.common.LogUtilsKt.debugLog(r5)
                        return
                    L15:
                        com.android.billingclient.api.InAppMessageParams r1 = r4.$inAppMessageParams
                        kotlin.jvm.functions.Function0<kotlin.Unit> r2 = r4.$subscriptionStatusChange
                        com.revenuecat.purchases.google.BillingWrapper$showInAppMessagesIfNeeded$1$1$$ExternalSyntheticLambda0 r3 = new com.revenuecat.purchases.google.BillingWrapper$showInAppMessagesIfNeeded$1$1$$ExternalSyntheticLambda0
                        r3.<init>(r2)
                        r5.showInAppMessages(r0, r1, r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.google.BillingWrapper$showInAppMessagesIfNeeded$1.AnonymousClass1.invoke2(com.android.billingclient.api.BillingClient):void");
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void invoke$lambda$1(Function0 subscriptionStatusChange, InAppMessageResult inAppMessageResult) {
                    Intrinsics.checkNotNullParameter(subscriptionStatusChange, "$subscriptionStatusChange");
                    Intrinsics.checkNotNullParameter(inAppMessageResult, "inAppMessageResult");
                    int responseCode = inAppMessageResult.getResponseCode();
                    if (responseCode == 0) {
                        LogUtilsKt.verboseLog(BillingStrings.BILLING_INAPP_MESSAGE_NONE);
                        return;
                    }
                    if (responseCode == 1) {
                        LogUtilsKt.debugLog(BillingStrings.BILLING_INAPP_MESSAGE_UPDATE);
                        subscriptionStatusChange.invoke();
                    } else {
                        String format = String.format(BillingStrings.BILLING_INAPP_MESSAGE_UNEXPECTED_CODE, Arrays.copyOf(new Object[]{Integer.valueOf(responseCode)}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                        LogUtilsKt.errorLog$default(format, null, 2, null);
                    }
                }
            }
        }, 1, null);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void getStorefront(final Function1<? super String, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        LogUtilsKt.verboseLog(BillingStrings.BILLING_INITIATE_GETTING_COUNTRY_CODE);
        BillingClientUseCase.run$default(new GetBillingConfigUseCase(new GetBillingConfigUseCaseParams(getAppInBackground()), this.deviceCache, new Function1<BillingConfig, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$getStorefront$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BillingConfig billingConfig) {
                Intrinsics.checkNotNullParameter(billingConfig, "billingConfig");
                Function1<String, Unit> function1 = onSuccess;
                String countryCode = billingConfig.getCountryCode();
                Intrinsics.checkNotNullExpressionValue(countryCode, "billingConfig.countryCode");
                function1.invoke(countryCode);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BillingConfig billingConfig) {
                invoke2(billingConfig);
                return Unit.INSTANCE;
            }
        }, onError, new BillingWrapper$getStorefront$2(this), new BillingWrapper$getStorefront$3(this)), 0L, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void withConnectedClient(Function1<? super BillingClient, Unit> receivingFunction) {
        BillingClient billingClient = this.billingClient;
        Unit unit = null;
        if (billingClient != null) {
            if (!billingClient.isReady()) {
                billingClient = null;
            }
            if (billingClient != null) {
                receivingFunction.invoke(billingClient);
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            LogIntent logIntent = LogIntent.GOOGLE_WARNING;
            String format = String.format(BillingStrings.BILLING_CLIENT_DISCONNECTED, Arrays.copyOf(new Object[]{getStackTrace()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
        }
    }

    private final String getStackTrace() {
        StringWriter stringWriter = new StringWriter();
        new Throwable().printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "stringWriter.toString()");
        return stringWriter2;
    }

    private final void getStoreTransaction(final Purchase purchase, final Function1<? super StoreTransaction, Unit> completion) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(BillingStrings.BILLING_WRAPPER_PURCHASES_UPDATED, Arrays.copyOf(new Object[]{PurchaseExtensionsKt.toHumanReadableDescription(purchase)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        synchronized (this) {
            PurchaseContext purchaseContext = this.purchaseContext.get(PurchaseExtensionsKt.getFirstProductId(purchase));
            if (purchaseContext != null && purchaseContext.getProductType() != null) {
                completion.invoke(StoreTransactionConversionsKt.toStoreTransaction(purchase, purchaseContext));
                return;
            }
            String purchaseToken = purchase.getPurchaseToken();
            Intrinsics.checkNotNullExpressionValue(purchaseToken, "purchase.purchaseToken");
            getPurchaseType$purchases_defaultsRelease(purchaseToken, new Function1<ProductType, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$getStoreTransaction$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ProductType productType) {
                    invoke2(productType);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ProductType type) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    completion.invoke(StoreTransactionConversionsKt.toStoreTransaction$default(purchase, type, null, null, null, 14, null));
                }
            });
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void trackProductDetailsNotSupportedIfNeeded() {
        if (this.diagnosticsTrackerIfEnabled == null) {
            return;
        }
        BillingClient billingClient = this.billingClient;
        BillingResult isFeatureSupported = billingClient != null ? billingClient.isFeatureSupported(BillingClient.FeatureType.PRODUCT_DETAILS) : null;
        if (isFeatureSupported == null || isFeatureSupported.getResponseCode() != -2) {
            return;
        }
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        int responseCode = isFeatureSupported.getResponseCode();
        String debugMessage = isFeatureSupported.getDebugMessage();
        Intrinsics.checkNotNullExpressionValue(debugMessage, "billingResult.debugMessage");
        diagnosticsTracker.trackProductDetailsNotSupported(responseCode, debugMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result<BillingFlowParams, PurchasesError> buildPurchaseParams(GooglePurchasingData purchaseInfo, ReplaceProductInfo replaceProductInfo, String appUserID, Boolean isPersonalizedPrice) {
        if (purchaseInfo instanceof GooglePurchasingData.InAppProduct) {
            return buildOneTimePurchaseParams((GooglePurchasingData.InAppProduct) purchaseInfo, appUserID, isPersonalizedPrice);
        }
        if (purchaseInfo instanceof GooglePurchasingData.Subscription) {
            return buildSubscriptionPurchaseParams((GooglePurchasingData.Subscription) purchaseInfo, replaceProductInfo, appUserID, isPersonalizedPrice);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Result<BillingFlowParams, PurchasesError> buildOneTimePurchaseParams(GooglePurchasingData.InAppProduct purchaseInfo, String appUserID, Boolean isPersonalizedPrice) {
        BillingFlowParams.ProductDetailsParams.Builder newBuilder = BillingFlowParams.ProductDetailsParams.newBuilder();
        newBuilder.setProductDetails(purchaseInfo.getProductDetails());
        BillingFlowParams.ProductDetailsParams build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder().apply {\n   …etails)\n        }.build()");
        BillingFlowParams.Builder obfuscatedAccountId = BillingFlowParams.newBuilder().setProductDetailsParamsList(CollectionsKt.listOf(build)).setObfuscatedAccountId(UtilsKt.sha256(appUserID));
        if (isPersonalizedPrice != null) {
            obfuscatedAccountId.setIsOfferPersonalized(isPersonalizedPrice.booleanValue());
        }
        BillingFlowParams build2 = obfuscatedAccountId.build();
        Intrinsics.checkNotNullExpressionValue(build2, "newBuilder()\n           …\n                .build()");
        return new Result.Success(build2);
    }

    private final Result<BillingFlowParams, PurchasesError> buildSubscriptionPurchaseParams(GooglePurchasingData.Subscription purchaseInfo, ReplaceProductInfo replaceProductInfo, String appUserID, Boolean isPersonalizedPrice) {
        BillingFlowParams.ProductDetailsParams.Builder newBuilder = BillingFlowParams.ProductDetailsParams.newBuilder();
        newBuilder.setOfferToken(purchaseInfo.getToken());
        newBuilder.setProductDetails(purchaseInfo.getProductDetails());
        BillingFlowParams.ProductDetailsParams build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder().apply {\n   …etails)\n        }.build()");
        BillingFlowParams.Builder productDetailsParamsList = BillingFlowParams.newBuilder().setProductDetailsParamsList(CollectionsKt.listOf(build));
        if (replaceProductInfo != null) {
            Intrinsics.checkNotNullExpressionValue(productDetailsParamsList, "buildSubscriptionPurchas…arams$lambda$29$lambda$27");
            BillingFlowParamsExtensionsKt.setUpgradeInfo(productDetailsParamsList, replaceProductInfo);
            Unit unit = Unit.INSTANCE;
        } else {
            Intrinsics.checkNotNullExpressionValue(productDetailsParamsList.setObfuscatedAccountId(UtilsKt.sha256(appUserID)), "setObfuscatedAccountId(appUserID.sha256())");
        }
        if (isPersonalizedPrice != null) {
            productDetailsParamsList.setIsOfferPersonalized(isPersonalizedPrice.booleanValue());
        }
        BillingFlowParams build2 = productDetailsParamsList.build();
        Intrinsics.checkNotNullExpressionValue(build2, "newBuilder()\n           …\n                .build()");
        return new Result.Success(build2);
    }

    private final synchronized void sendErrorsToAllPendingRequests(final PurchasesError error) {
        while (true) {
            Pair<Function1<PurchasesError, Unit>, Long> poll = this.serviceRequests.poll();
            if (poll != null) {
                final Function1<PurchasesError, Unit> component1 = poll.component1();
                this.mainHandler.post(new Runnable() { // from class: com.revenuecat.purchases.google.BillingWrapper$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        BillingWrapper.sendErrorsToAllPendingRequests$lambda$31$lambda$30(Function1.this, error);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendErrorsToAllPendingRequests$lambda$31$lambda$30(Function1 serviceRequest, PurchasesError error) {
        Intrinsics.checkNotNullParameter(serviceRequest, "$serviceRequest");
        Intrinsics.checkNotNullParameter(error, "$error");
        serviceRequest.invoke(error);
    }
}
