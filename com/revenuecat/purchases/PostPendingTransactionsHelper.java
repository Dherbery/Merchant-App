package com.revenuecat.purchases;

import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.strings.RestoreStrings;
import com.revenuecat.purchases.utils.Result;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PostPendingTransactionsHelper.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJb\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0018\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00150\u00122\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00192\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0019H\u0002JX\u0010\u001b\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00192\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0019H\u0002J@\u0010 \u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00192\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/revenuecat/purchases/PostPendingTransactionsHelper;", "", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "billing", "Lcom/revenuecat/purchases/common/BillingAbstract;", "dispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "identityManager", "Lcom/revenuecat/purchases/identity/IdentityManager;", "postTransactionWithProductDetailsHelper", "Lcom/revenuecat/purchases/PostTransactionWithProductDetailsHelper;", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/common/BillingAbstract;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/identity/IdentityManager;Lcom/revenuecat/purchases/PostTransactionWithProductDetailsHelper;)V", "callCompletionFromResults", "", "transactionsToSync", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "results", "Lcom/revenuecat/purchases/utils/Result;", "Lcom/revenuecat/purchases/CustomerInfo;", "Lcom/revenuecat/purchases/PurchasesError;", "onError", "Lkotlin/Function1;", "onSuccess", "postTransactionsWithCompletion", "allowSharingPlayStoreAccount", "", "appUserID", "", "syncPendingPurchaseQueue", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PostPendingTransactionsHelper {
    private final AppConfig appConfig;
    private final BillingAbstract billing;
    private final DeviceCache deviceCache;
    private final Dispatcher dispatcher;
    private final IdentityManager identityManager;
    private final PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper;

    public PostPendingTransactionsHelper(AppConfig appConfig, DeviceCache deviceCache, BillingAbstract billing, Dispatcher dispatcher, IdentityManager identityManager, PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(identityManager, "identityManager");
        Intrinsics.checkNotNullParameter(postTransactionWithProductDetailsHelper, "postTransactionWithProductDetailsHelper");
        this.appConfig = appConfig;
        this.deviceCache = deviceCache;
        this.billing = billing;
        this.dispatcher = dispatcher;
        this.identityManager = identityManager;
        this.postTransactionWithProductDetailsHelper = postTransactionWithProductDetailsHelper;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void syncPendingPurchaseQueue$default(PostPendingTransactionsHelper postPendingTransactionsHelper, boolean z, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = null;
        }
        postPendingTransactionsHelper.syncPendingPurchaseQueue(z, function1, function12);
    }

    public final void syncPendingPurchaseQueue(final boolean allowSharingPlayStoreAccount, final Function1<? super PurchasesError, Unit> onError, final Function1<? super CustomerInfo, Unit> onSuccess) {
        if (!this.appConfig.getDangerousSettings().getAutoSyncPurchases()) {
            LogWrapperKt.log(LogIntent.DEBUG, PurchaseStrings.SKIPPING_AUTOMATIC_SYNC);
            if (onSuccess != null) {
                onSuccess.invoke(null);
                return;
            }
            return;
        }
        LogWrapperKt.log(LogIntent.DEBUG, PurchaseStrings.UPDATING_PENDING_PURCHASE_QUEUE);
        final String currentAppUserID = this.identityManager.getCurrentAppUserID();
        Dispatcher.enqueue$default(this.dispatcher, new Runnable() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PostPendingTransactionsHelper.syncPendingPurchaseQueue$lambda$0(PostPendingTransactionsHelper.this, currentAppUserID, allowSharingPlayStoreAccount, onError, onSuccess);
            }
        }, null, 2, null);
    }

    public static final void syncPendingPurchaseQueue$lambda$0(PostPendingTransactionsHelper this$0, final String appUserID, final boolean z, final Function1 function1, final Function1 function12) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appUserID, "$appUserID");
        this$0.billing.queryPurchases(appUserID, new Function1<Map<String, ? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$1$1
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
            public final void invoke2(Map<String, StoreTransaction> purchasesByHashedToken) {
                DeviceCache deviceCache;
                DeviceCache deviceCache2;
                Intrinsics.checkNotNullParameter(purchasesByHashedToken, "purchasesByHashedToken");
                for (Map.Entry<String, StoreTransaction> entry : purchasesByHashedToken.entrySet()) {
                    String key = entry.getKey();
                    StoreTransaction value = entry.getValue();
                    LogIntent logIntent = LogIntent.DEBUG;
                    String format = String.format(RestoreStrings.QUERYING_PURCHASE_WITH_HASH, Arrays.copyOf(new Object[]{value.getType(), key}, 2));
                    Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                    LogWrapperKt.log(logIntent, format);
                }
                deviceCache = PostPendingTransactionsHelper.this.deviceCache;
                deviceCache.cleanPreviouslySentTokens(purchasesByHashedToken.keySet());
                deviceCache2 = PostPendingTransactionsHelper.this.deviceCache;
                PostPendingTransactionsHelper.this.postTransactionsWithCompletion(deviceCache2.getActivePurchasesNotInCache(purchasesByHashedToken), z, appUserID, function1, function12);
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$1$2
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
                LogWrapperKt.log(LogIntent.GOOGLE_ERROR, error.toString());
                Function1<PurchasesError, Unit> function13 = function1;
                if (function13 != null) {
                    function13.invoke(error);
                }
            }
        });
    }

    public final void postTransactionsWithCompletion(final List<StoreTransaction> transactionsToSync, boolean allowSharingPlayStoreAccount, String appUserID, final Function1<? super PurchasesError, Unit> onError, final Function1<? super CustomerInfo, Unit> onSuccess) {
        if (transactionsToSync.isEmpty()) {
            LogWrapperKt.log(LogIntent.DEBUG, PurchaseStrings.NO_PENDING_PURCHASES_TO_SYNC);
            if (onSuccess != null) {
                onSuccess.invoke(null);
            }
        } else {
            final ArrayList arrayList = new ArrayList();
            this.postTransactionWithProductDetailsHelper.postTransactions(transactionsToSync, allowSharingPlayStoreAccount, appUserID, PostReceiptInitiationSource.UNSYNCED_ACTIVE_PURCHASES, new Function2<StoreTransaction, CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$postTransactionsWithCompletion$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                    invoke2(storeTransaction, customerInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                    Intrinsics.checkNotNullParameter(storeTransaction, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                    arrayList.add(new Result.Success(customerInfo));
                    this.callCompletionFromResults(transactionsToSync, arrayList, onError, onSuccess);
                }
            }, new Function2<StoreTransaction, PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$postTransactionsWithCompletion$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction, PurchasesError purchasesError) {
                    invoke2(storeTransaction, purchasesError);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(StoreTransaction storeTransaction, PurchasesError purchasesError) {
                    Intrinsics.checkNotNullParameter(storeTransaction, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(purchasesError, "purchasesError");
                    arrayList.add(new Result.Error(purchasesError));
                    this.callCompletionFromResults(transactionsToSync, arrayList, onError, onSuccess);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void callCompletionFromResults$default(PostPendingTransactionsHelper postPendingTransactionsHelper, List list, List list2, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        if ((i & 8) != 0) {
            function12 = null;
        }
        postPendingTransactionsHelper.callCompletionFromResults(list, list2, function1, function12);
    }

    public final void callCompletionFromResults(List<StoreTransaction> transactionsToSync, List<? extends Result<CustomerInfo, PurchasesError>> results, Function1<? super PurchasesError, Unit> onError, Function1<? super CustomerInfo, Unit> onSuccess) {
        if (transactionsToSync.size() == results.size()) {
            int i = 0;
            for (Object obj : results) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Result result = (Result) obj;
                if (result instanceof Result.Error) {
                    if (onError != null) {
                        onError.invoke(((Result.Error) result).getValue());
                        return;
                    }
                    return;
                } else {
                    if (i == results.size() - 1 && onSuccess != null) {
                        Intrinsics.checkNotNull(result, "null cannot be cast to non-null type com.revenuecat.purchases.utils.Result.Success<com.revenuecat.purchases.CustomerInfo>");
                        onSuccess.invoke(((Result.Success) result).getValue());
                    }
                    i = i2;
                }
            }
        }
    }
}
