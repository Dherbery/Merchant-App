package com.revenuecat.purchases;

import com.amazon.a.a.o.b;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.PostReceiptErrorHandlingBehavior;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.paywalls.PaywallPresentedCache;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData;
import com.revenuecat.purchases.subscriberattributes.BackendHelpersKt;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttribute;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PostReceiptHelper.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J8\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00180\u001c2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00180\u001cH\u0002J\u009c\u0001\u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u001a2\b\u0010&\u001a\u0004\u0018\u00010\u001a2\u0006\u0010'\u001a\u00020(2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00180\u001c2B\u0010\u001e\u001a>\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0015\u0012\u0013\u0018\u00010.¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00180)j\u0002`0H\u0002Jj\u00101\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010\u001a2\u0006\u0010'\u001a\u00020(2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00180\u001c2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00180\u001cJx\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(2\"\b\u0002\u0010\u001b\u001a\u001c\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0018\u0018\u000107j\u0004\u0018\u0001`82\"\b\u0002\u0010\u001e\u001a\u001c\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0018\u0018\u000107j\u0004\u0018\u0001`9J:\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020*2\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00180\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180<H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/revenuecat/purchases/PostReceiptHelper;", "", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "billing", "Lcom/revenuecat/purchases/common/BillingAbstract;", "customerInfoUpdateHandler", "Lcom/revenuecat/purchases/CustomerInfoUpdateHandler;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "subscriberAttributesManager", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;", "offlineEntitlementsManager", "Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;", "paywallPresentedCache", "Lcom/revenuecat/purchases/paywalls/PaywallPresentedCache;", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/BillingAbstract;Lcom/revenuecat/purchases/CustomerInfoUpdateHandler;Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;Lcom/revenuecat/purchases/paywalls/PaywallPresentedCache;)V", "finishTransactions", "", "getFinishTransactions", "()Z", "calculateOfflineCustomerInfo", "", "appUserID", "", "onSuccess", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "postReceiptAndSubscriberAttributes", "purchaseToken", "isRestore", "receiptInfo", "Lcom/revenuecat/purchases/common/ReceiptInfo;", "storeUserID", b.m, "initiationSource", "Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "Lkotlin/Function3;", "Lcom/revenuecat/purchases/common/PostReceiptErrorHandlingBehavior;", "Lkotlin/ParameterName;", "name", "postReceiptErrorHandlingBehavior", "Lorg/json/JSONObject;", TtmlNode.TAG_BODY, "Lcom/revenuecat/purchases/common/PostReceiptDataErrorCallback;", "postTokenWithoutConsuming", "postTransactionAndConsumeIfNeeded", "purchase", "Lcom/revenuecat/purchases/models/StoreTransaction;", "storeProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/SuccessfulPurchaseCallback;", "Lcom/revenuecat/purchases/ErrorPurchaseCallback;", "useOfflineEntitlementsCustomerInfoIfNeeded", "errorHandlingBehavior", "Lkotlin/Function0;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PostReceiptHelper {
    private final AppConfig appConfig;
    private final Backend backend;
    private final BillingAbstract billing;
    private final CustomerInfoUpdateHandler customerInfoUpdateHandler;
    private final DeviceCache deviceCache;
    private final OfflineEntitlementsManager offlineEntitlementsManager;
    private final PaywallPresentedCache paywallPresentedCache;
    private final SubscriberAttributesManager subscriberAttributesManager;

    public PostReceiptHelper(AppConfig appConfig, Backend backend, BillingAbstract billing, CustomerInfoUpdateHandler customerInfoUpdateHandler, DeviceCache deviceCache, SubscriberAttributesManager subscriberAttributesManager, OfflineEntitlementsManager offlineEntitlementsManager, PaywallPresentedCache paywallPresentedCache) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(customerInfoUpdateHandler, "customerInfoUpdateHandler");
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(subscriberAttributesManager, "subscriberAttributesManager");
        Intrinsics.checkNotNullParameter(offlineEntitlementsManager, "offlineEntitlementsManager");
        Intrinsics.checkNotNullParameter(paywallPresentedCache, "paywallPresentedCache");
        this.appConfig = appConfig;
        this.backend = backend;
        this.billing = billing;
        this.customerInfoUpdateHandler = customerInfoUpdateHandler;
        this.deviceCache = deviceCache;
        this.subscriberAttributesManager = subscriberAttributesManager;
        this.offlineEntitlementsManager = offlineEntitlementsManager;
        this.paywallPresentedCache = paywallPresentedCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getFinishTransactions() {
        return this.appConfig.getFinishTransactions();
    }

    public final void postTokenWithoutConsuming(final String purchaseToken, String storeUserID, ReceiptInfo receiptInfo, boolean isRestore, final String appUserID, String marketplace, PostReceiptInitiationSource initiationSource, final Function1<? super CustomerInfo, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(receiptInfo, "receiptInfo");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        postReceiptAndSubscriberAttributes(appUserID, purchaseToken, isRestore, receiptInfo, storeUserID, marketplace, initiationSource, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper$postTokenWithoutConsuming$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                invoke2(customerInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CustomerInfo it) {
                DeviceCache deviceCache;
                Intrinsics.checkNotNullParameter(it, "it");
                deviceCache = PostReceiptHelper.this.deviceCache;
                deviceCache.addSuccessfullyPostedToken(purchaseToken);
                onSuccess.invoke(it);
            }
        }, new Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper$postTokenWithoutConsuming$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, PostReceiptErrorHandlingBehavior postReceiptErrorHandlingBehavior, JSONObject jSONObject) {
                invoke2(purchasesError, postReceiptErrorHandlingBehavior, jSONObject);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final PurchasesError backendError, PostReceiptErrorHandlingBehavior errorHandlingBehavior, JSONObject jSONObject) {
                DeviceCache deviceCache;
                Intrinsics.checkNotNullParameter(backendError, "backendError");
                Intrinsics.checkNotNullParameter(errorHandlingBehavior, "errorHandlingBehavior");
                if (errorHandlingBehavior == PostReceiptErrorHandlingBehavior.SHOULD_BE_CONSUMED) {
                    deviceCache = PostReceiptHelper.this.deviceCache;
                    deviceCache.addSuccessfullyPostedToken(purchaseToken);
                }
                PostReceiptHelper postReceiptHelper = PostReceiptHelper.this;
                String str = appUserID;
                final Function1<CustomerInfo, Unit> function1 = onSuccess;
                Function1<CustomerInfo, Unit> function12 = new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper$postTokenWithoutConsuming$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                        invoke2(customerInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(CustomerInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        function1.invoke(it);
                    }
                };
                final Function1<PurchasesError, Unit> function13 = onError;
                postReceiptHelper.useOfflineEntitlementsCustomerInfoIfNeeded(errorHandlingBehavior, str, function12, new Function0<Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper$postTokenWithoutConsuming$2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        function13.invoke(backendError);
                    }
                });
            }
        });
    }

    public final void postTransactionAndConsumeIfNeeded(final StoreTransaction purchase, StoreProduct storeProduct, boolean isRestore, final String appUserID, final PostReceiptInitiationSource initiationSource, final Function2<? super StoreTransaction, ? super CustomerInfo, Unit> onSuccess, final Function2<? super StoreTransaction, ? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        postReceiptAndSubscriberAttributes(appUserID, purchase.getPurchaseToken(), isRestore, new ReceiptInfo(purchase.getProductIds(), purchase.getPresentedOfferingContext(), purchase.getSubscriptionOptionId(), storeProduct, null, null, purchase.getReplacementMode(), 48, null), purchase.getStoreUserID(), purchase.getMarketplace(), initiationSource, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper$postTransactionAndConsumeIfNeeded$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                invoke2(customerInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CustomerInfo info) {
                BillingAbstract billingAbstract;
                boolean finishTransactions;
                Intrinsics.checkNotNullParameter(info, "info");
                billingAbstract = PostReceiptHelper.this.billing;
                finishTransactions = PostReceiptHelper.this.getFinishTransactions();
                billingAbstract.consumeAndSave(finishTransactions, purchase, initiationSource);
                Function2<StoreTransaction, CustomerInfo, Unit> function2 = onSuccess;
                if (function2 != null) {
                    function2.invoke(purchase, info);
                }
            }
        }, new Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper$postTransactionAndConsumeIfNeeded$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, PostReceiptErrorHandlingBehavior postReceiptErrorHandlingBehavior, JSONObject jSONObject) {
                invoke2(purchasesError, postReceiptErrorHandlingBehavior, jSONObject);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final PurchasesError backendError, PostReceiptErrorHandlingBehavior errorHandlingBehavior, JSONObject jSONObject) {
                BillingAbstract billingAbstract;
                boolean finishTransactions;
                Intrinsics.checkNotNullParameter(backendError, "backendError");
                Intrinsics.checkNotNullParameter(errorHandlingBehavior, "errorHandlingBehavior");
                if (errorHandlingBehavior == PostReceiptErrorHandlingBehavior.SHOULD_BE_CONSUMED) {
                    billingAbstract = PostReceiptHelper.this.billing;
                    finishTransactions = PostReceiptHelper.this.getFinishTransactions();
                    billingAbstract.consumeAndSave(finishTransactions, purchase, initiationSource);
                }
                PostReceiptHelper postReceiptHelper = PostReceiptHelper.this;
                String str = appUserID;
                final Function2<StoreTransaction, CustomerInfo, Unit> function2 = onSuccess;
                final StoreTransaction storeTransaction = purchase;
                Function1<CustomerInfo, Unit> function1 = new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper$postTransactionAndConsumeIfNeeded$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                        invoke2(customerInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(CustomerInfo customerInfo) {
                        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                        Function2<StoreTransaction, CustomerInfo, Unit> function22 = function2;
                        if (function22 != null) {
                            function22.invoke(storeTransaction, customerInfo);
                        }
                    }
                };
                final Function2<StoreTransaction, PurchasesError, Unit> function22 = onError;
                final StoreTransaction storeTransaction2 = purchase;
                postReceiptHelper.useOfflineEntitlementsCustomerInfoIfNeeded(errorHandlingBehavior, str, function1, new Function0<Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper$postTransactionAndConsumeIfNeeded$2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Function2<StoreTransaction, PurchasesError, Unit> function23 = function22;
                        if (function23 != null) {
                            function23.invoke(storeTransaction2, backendError);
                        }
                    }
                });
            }
        });
    }

    private final void postReceiptAndSubscriberAttributes(final String appUserID, final String purchaseToken, final boolean isRestore, final ReceiptInfo receiptInfo, final String storeUserID, final String marketplace, final PostReceiptInitiationSource initiationSource, final Function1<? super CustomerInfo, Unit> onSuccess, final Function3<? super PurchasesError, ? super PostReceiptErrorHandlingBehavior, ? super JSONObject, Unit> onError) {
        final PaywallEvent andRemovePresentedEvent = this.paywallPresentedCache.getAndRemovePresentedEvent();
        this.subscriberAttributesManager.getUnsyncedSubscriberAttributes(appUserID, new Function1<Map<String, ? extends SubscriberAttribute>, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper$postReceiptAndSubscriberAttributes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends SubscriberAttribute> map) {
                invoke2((Map<String, SubscriberAttribute>) map);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final Map<String, SubscriberAttribute> unsyncedSubscriberAttributesByKey) {
                Backend backend;
                boolean finishTransactions;
                Intrinsics.checkNotNullParameter(unsyncedSubscriberAttributesByKey, "unsyncedSubscriberAttributesByKey");
                backend = PostReceiptHelper.this.backend;
                String str = purchaseToken;
                String str2 = appUserID;
                boolean z = isRestore;
                finishTransactions = PostReceiptHelper.this.getFinishTransactions();
                boolean z2 = !finishTransactions;
                Map<String, Map<String, Object>> backendMap = BackendHelpersKt.toBackendMap(unsyncedSubscriberAttributesByKey);
                ReceiptInfo receiptInfo2 = receiptInfo;
                String str3 = storeUserID;
                String str4 = marketplace;
                PostReceiptInitiationSource postReceiptInitiationSource = initiationSource;
                PaywallEvent paywallEvent = andRemovePresentedEvent;
                PaywallPostReceiptData paywallPostReceiptData$purchases_defaultsRelease = paywallEvent != null ? paywallEvent.toPaywallPostReceiptData$purchases_defaultsRelease() : null;
                final PostReceiptHelper postReceiptHelper = PostReceiptHelper.this;
                final String str5 = appUserID;
                final Function1<CustomerInfo, Unit> function1 = onSuccess;
                Function2<CustomerInfo, JSONObject, Unit> function2 = new Function2<CustomerInfo, JSONObject, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper$postReceiptAndSubscriberAttributes$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo, JSONObject jSONObject) {
                        invoke2(customerInfo, jSONObject);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(CustomerInfo customerInfo, JSONObject responseBody) {
                        OfflineEntitlementsManager offlineEntitlementsManager;
                        SubscriberAttributesManager subscriberAttributesManager;
                        CustomerInfoUpdateHandler customerInfoUpdateHandler;
                        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
                        offlineEntitlementsManager = PostReceiptHelper.this.offlineEntitlementsManager;
                        offlineEntitlementsManager.resetOfflineCustomerInfoCache();
                        subscriberAttributesManager = PostReceiptHelper.this.subscriberAttributesManager;
                        subscriberAttributesManager.markAsSynced(str5, unsyncedSubscriberAttributesByKey, BackendHelpersKt.getAttributeErrors(responseBody));
                        customerInfoUpdateHandler = PostReceiptHelper.this.customerInfoUpdateHandler;
                        customerInfoUpdateHandler.cacheAndNotifyListeners(customerInfo);
                        function1.invoke(customerInfo);
                    }
                };
                final PaywallEvent paywallEvent2 = andRemovePresentedEvent;
                final PostReceiptHelper postReceiptHelper2 = PostReceiptHelper.this;
                final String str6 = appUserID;
                final Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit> function3 = onError;
                backend.postReceiptData(str, str2, z, z2, backendMap, receiptInfo2, str3, str4, postReceiptInitiationSource, paywallPostReceiptData$purchases_defaultsRelease, function2, new Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper$postReceiptAndSubscriberAttributes$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, PostReceiptErrorHandlingBehavior postReceiptErrorHandlingBehavior, JSONObject jSONObject) {
                        invoke2(purchasesError, postReceiptErrorHandlingBehavior, jSONObject);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PurchasesError error, PostReceiptErrorHandlingBehavior errorHandlingBehavior, JSONObject jSONObject) {
                        SubscriberAttributesManager subscriberAttributesManager;
                        PaywallPresentedCache paywallPresentedCache;
                        Intrinsics.checkNotNullParameter(error, "error");
                        Intrinsics.checkNotNullParameter(errorHandlingBehavior, "errorHandlingBehavior");
                        PaywallEvent paywallEvent3 = PaywallEvent.this;
                        if (paywallEvent3 != null) {
                            paywallPresentedCache = postReceiptHelper2.paywallPresentedCache;
                            paywallPresentedCache.cachePresentedPaywall(paywallEvent3);
                        }
                        if (errorHandlingBehavior == PostReceiptErrorHandlingBehavior.SHOULD_BE_CONSUMED) {
                            subscriberAttributesManager = postReceiptHelper2.subscriberAttributesManager;
                            subscriberAttributesManager.markAsSynced(str6, unsyncedSubscriberAttributesByKey, BackendHelpersKt.getAttributeErrors(jSONObject));
                        }
                        function3.invoke(error, errorHandlingBehavior, jSONObject);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void useOfflineEntitlementsCustomerInfoIfNeeded(PostReceiptErrorHandlingBehavior errorHandlingBehavior, String appUserID, Function1<? super CustomerInfo, Unit> onSuccess, final Function0<Unit> onError) {
        if (this.offlineEntitlementsManager.shouldCalculateOfflineCustomerInfoInPostReceipt(errorHandlingBehavior == PostReceiptErrorHandlingBehavior.SHOULD_USE_OFFLINE_ENTITLEMENTS_AND_NOT_CONSUME)) {
            calculateOfflineCustomerInfo(appUserID, onSuccess, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper$useOfflineEntitlementsCustomerInfoIfNeeded$1
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
                public final void invoke2(PurchasesError it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    onError.invoke();
                }
            });
        } else {
            onError.invoke();
        }
    }

    private final void calculateOfflineCustomerInfo(String appUserID, final Function1<? super CustomerInfo, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        this.offlineEntitlementsManager.calculateAndCacheOfflineCustomerInfo(appUserID, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper$calculateOfflineCustomerInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                invoke2(customerInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CustomerInfo customerInfo) {
                CustomerInfoUpdateHandler customerInfoUpdateHandler;
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                customerInfoUpdateHandler = PostReceiptHelper.this.customerInfoUpdateHandler;
                customerInfoUpdateHandler.notifyListeners(customerInfo);
                onSuccess.invoke(customerInfo);
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper$calculateOfflineCustomerInfo$2
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
                onError.invoke(error);
            }
        });
    }
}
