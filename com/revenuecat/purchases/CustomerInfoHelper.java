package com.revenuecat.purchases;

import android.os.Handler;
import android.os.Looper;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.strings.CustomerInfoStrings;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomerInfoHelper.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001c\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J,\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J$\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J,\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J,\u0010 \u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J2\u0010!\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019J \u0010$\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/revenuecat/purchases/CustomerInfoHelper;", "", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "offlineEntitlementsManager", "Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;", "customerInfoUpdateHandler", "Lcom/revenuecat/purchases/CustomerInfoUpdateHandler;", "postPendingTransactionsHelper", "Lcom/revenuecat/purchases/PostPendingTransactionsHelper;", "handler", "Landroid/os/Handler;", "(Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;Lcom/revenuecat/purchases/CustomerInfoUpdateHandler;Lcom/revenuecat/purchases/PostPendingTransactionsHelper;Landroid/os/Handler;)V", "dispatch", "", "action", "Lkotlin/Function0;", "getCachedCustomerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "appUserID", "", "getCustomerInfoCacheOnly", "callback", "Lcom/revenuecat/purchases/interfaces/ReceiveCustomerInfoCallback;", "getCustomerInfoCachedOrFetched", "appInBackground", "", "allowSharingPlayStoreAccount", "getCustomerInfoFetchOnly", "getCustomerInfoNotStaledCachedOrFetched", "postPendingPurchasesAndFetchCustomerInfo", "retrieveCustomerInfo", "fetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "updateCachedCustomerInfoIfStale", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class CustomerInfoHelper {
    private final Backend backend;
    private final CustomerInfoUpdateHandler customerInfoUpdateHandler;
    private final DeviceCache deviceCache;
    private final Handler handler;
    private final OfflineEntitlementsManager offlineEntitlementsManager;
    private final PostPendingTransactionsHelper postPendingTransactionsHelper;

    /* compiled from: CustomerInfoHelper.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CacheFetchPolicy.values().length];
            try {
                iArr[CacheFetchPolicy.CACHE_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CacheFetchPolicy.FETCH_CURRENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CacheFetchPolicy.CACHED_OR_FETCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CacheFetchPolicy.NOT_STALE_CACHED_OR_CURRENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CustomerInfoHelper(DeviceCache deviceCache, Backend backend, OfflineEntitlementsManager offlineEntitlementsManager, CustomerInfoUpdateHandler customerInfoUpdateHandler, PostPendingTransactionsHelper postPendingTransactionsHelper, Handler handler) {
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(offlineEntitlementsManager, "offlineEntitlementsManager");
        Intrinsics.checkNotNullParameter(customerInfoUpdateHandler, "customerInfoUpdateHandler");
        Intrinsics.checkNotNullParameter(postPendingTransactionsHelper, "postPendingTransactionsHelper");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.deviceCache = deviceCache;
        this.backend = backend;
        this.offlineEntitlementsManager = offlineEntitlementsManager;
        this.customerInfoUpdateHandler = customerInfoUpdateHandler;
        this.postPendingTransactionsHelper = postPendingTransactionsHelper;
        this.handler = handler;
    }

    public /* synthetic */ CustomerInfoHelper(DeviceCache deviceCache, Backend backend, OfflineEntitlementsManager offlineEntitlementsManager, CustomerInfoUpdateHandler customerInfoUpdateHandler, PostPendingTransactionsHelper postPendingTransactionsHelper, Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceCache, backend, offlineEntitlementsManager, customerInfoUpdateHandler, postPendingTransactionsHelper, (i & 32) != 0 ? new Handler(Looper.getMainLooper()) : handler);
    }

    public static /* synthetic */ void retrieveCustomerInfo$default(CustomerInfoHelper customerInfoHelper, String str, CacheFetchPolicy cacheFetchPolicy, boolean z, boolean z2, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 16) != 0) {
            receiveCustomerInfoCallback = null;
        }
        customerInfoHelper.retrieveCustomerInfo(str, cacheFetchPolicy, z, z2, receiveCustomerInfoCallback);
    }

    public final void retrieveCustomerInfo(String appUserID, CacheFetchPolicy fetchPolicy, boolean appInBackground, boolean allowSharingPlayStoreAccount, ReceiveCustomerInfoCallback callback) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        String format = String.format(CustomerInfoStrings.RETRIEVING_CUSTOMER_INFO, Arrays.copyOf(new Object[]{fetchPolicy}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogUtilsKt.debugLog(format);
        int i = WhenMappings.$EnumSwitchMapping$0[fetchPolicy.ordinal()];
        if (i == 1) {
            getCustomerInfoCacheOnly(appUserID, callback);
            return;
        }
        if (i == 2) {
            postPendingPurchasesAndFetchCustomerInfo(appUserID, appInBackground, allowSharingPlayStoreAccount, callback);
        } else if (i == 3) {
            getCustomerInfoCachedOrFetched(appUserID, appInBackground, allowSharingPlayStoreAccount, callback);
        } else {
            if (i != 4) {
                return;
            }
            getCustomerInfoNotStaledCachedOrFetched(appUserID, appInBackground, allowSharingPlayStoreAccount, callback);
        }
    }

    static /* synthetic */ void getCustomerInfoCacheOnly$default(CustomerInfoHelper customerInfoHelper, String str, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            receiveCustomerInfoCallback = null;
        }
        customerInfoHelper.getCustomerInfoCacheOnly(str, receiveCustomerInfoCallback);
    }

    private final void getCustomerInfoCacheOnly(String appUserID, final ReceiveCustomerInfoCallback callback) {
        if (callback == null) {
            return;
        }
        final CustomerInfo cachedCustomerInfo = getCachedCustomerInfo(appUserID);
        if (cachedCustomerInfo != null) {
            LogWrapperKt.log(LogIntent.DEBUG, CustomerInfoStrings.VENDING_CACHE);
            dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper$getCustomerInfoCacheOnly$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ReceiveCustomerInfoCallback.this.onReceived(cachedCustomerInfo);
                }
            });
        } else {
            final PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.CustomerInfoError, CustomerInfoStrings.MISSING_CACHED_CUSTOMER_INFO);
            LogUtilsKt.errorLog(purchasesError);
            dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper$getCustomerInfoCacheOnly$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ReceiveCustomerInfoCallback.this.onError(purchasesError);
                }
            });
        }
    }

    static /* synthetic */ void postPendingPurchasesAndFetchCustomerInfo$default(CustomerInfoHelper customerInfoHelper, String str, boolean z, boolean z2, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 8) != 0) {
            receiveCustomerInfoCallback = null;
        }
        customerInfoHelper.postPendingPurchasesAndFetchCustomerInfo(str, z, z2, receiveCustomerInfoCallback);
    }

    private final void postPendingPurchasesAndFetchCustomerInfo(final String appUserID, final boolean appInBackground, boolean allowSharingPlayStoreAccount, final ReceiveCustomerInfoCallback callback) {
        this.postPendingTransactionsHelper.syncPendingPurchaseQueue(allowSharingPlayStoreAccount, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper$postPendingPurchasesAndFetchCustomerInfo$1
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
                CustomerInfoHelper.this.getCustomerInfoFetchOnly(appUserID, appInBackground, callback);
            }
        }, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper$postPendingPurchasesAndFetchCustomerInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                invoke2(customerInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final CustomerInfo customerInfo) {
                if (customerInfo == null) {
                    CustomerInfoHelper.this.getCustomerInfoFetchOnly(appUserID, appInBackground, callback);
                    return;
                }
                LogWrapperKt.log(LogIntent.RC_SUCCESS, CustomerInfoStrings.CUSTOMERINFO_UPDATED_FROM_SYNCING_PENDING_PURCHASES);
                CustomerInfoHelper customerInfoHelper = CustomerInfoHelper.this;
                final ReceiveCustomerInfoCallback receiveCustomerInfoCallback = callback;
                customerInfoHelper.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper$postPendingPurchasesAndFetchCustomerInfo$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ReceiveCustomerInfoCallback receiveCustomerInfoCallback2 = ReceiveCustomerInfoCallback.this;
                        if (receiveCustomerInfoCallback2 != null) {
                            receiveCustomerInfoCallback2.onReceived(customerInfo);
                        }
                    }
                });
            }
        });
    }

    static /* synthetic */ void getCustomerInfoFetchOnly$default(CustomerInfoHelper customerInfoHelper, String str, boolean z, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            receiveCustomerInfoCallback = null;
        }
        customerInfoHelper.getCustomerInfoFetchOnly(str, z, receiveCustomerInfoCallback);
    }

    public final void getCustomerInfoFetchOnly(final String appUserID, boolean appInBackground, final ReceiveCustomerInfoCallback callback) {
        this.deviceCache.setCustomerInfoCacheTimestampToNow(appUserID);
        this.backend.getCustomerInfo(appUserID, appInBackground, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper$getCustomerInfoFetchOnly$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                invoke2(customerInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final CustomerInfo info) {
                OfflineEntitlementsManager offlineEntitlementsManager;
                CustomerInfoUpdateHandler customerInfoUpdateHandler;
                Intrinsics.checkNotNullParameter(info, "info");
                LogWrapperKt.log(LogIntent.RC_SUCCESS, CustomerInfoStrings.CUSTOMERINFO_UPDATED_FROM_NETWORK);
                offlineEntitlementsManager = CustomerInfoHelper.this.offlineEntitlementsManager;
                offlineEntitlementsManager.resetOfflineCustomerInfoCache();
                customerInfoUpdateHandler = CustomerInfoHelper.this.customerInfoUpdateHandler;
                customerInfoUpdateHandler.cacheAndNotifyListeners(info);
                CustomerInfoHelper customerInfoHelper = CustomerInfoHelper.this;
                final ReceiveCustomerInfoCallback receiveCustomerInfoCallback = callback;
                customerInfoHelper.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper$getCustomerInfoFetchOnly$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ReceiveCustomerInfoCallback receiveCustomerInfoCallback2 = ReceiveCustomerInfoCallback.this;
                        if (receiveCustomerInfoCallback2 != null) {
                            receiveCustomerInfoCallback2.onReceived(info);
                        }
                    }
                });
            }
        }, new Function2<PurchasesError, Boolean, Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper$getCustomerInfoFetchOnly$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, Boolean bool) {
                invoke(purchasesError, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(final PurchasesError backendError, boolean z) {
                DeviceCache deviceCache;
                OfflineEntitlementsManager offlineEntitlementsManager;
                OfflineEntitlementsManager offlineEntitlementsManager2;
                Intrinsics.checkNotNullParameter(backendError, "backendError");
                String format = String.format(CustomerInfoStrings.ERROR_FETCHING_CUSTOMER_INFO, Arrays.copyOf(new Object[]{backendError}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                LogUtilsKt.errorLog$default(format, null, 2, null);
                deviceCache = CustomerInfoHelper.this.deviceCache;
                deviceCache.clearCustomerInfoCacheTimestamp(appUserID);
                offlineEntitlementsManager = CustomerInfoHelper.this.offlineEntitlementsManager;
                if (offlineEntitlementsManager.shouldCalculateOfflineCustomerInfoInGetCustomerInfoRequest(z, appUserID)) {
                    offlineEntitlementsManager2 = CustomerInfoHelper.this.offlineEntitlementsManager;
                    String str = appUserID;
                    final CustomerInfoHelper customerInfoHelper = CustomerInfoHelper.this;
                    final ReceiveCustomerInfoCallback receiveCustomerInfoCallback = callback;
                    Function1<CustomerInfo, Unit> function1 = new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper$getCustomerInfoFetchOnly$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                            invoke2(customerInfo);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(final CustomerInfo offlineComputedCustomerInfo) {
                            CustomerInfoUpdateHandler customerInfoUpdateHandler;
                            Intrinsics.checkNotNullParameter(offlineComputedCustomerInfo, "offlineComputedCustomerInfo");
                            customerInfoUpdateHandler = CustomerInfoHelper.this.customerInfoUpdateHandler;
                            customerInfoUpdateHandler.notifyListeners(offlineComputedCustomerInfo);
                            CustomerInfoHelper customerInfoHelper2 = CustomerInfoHelper.this;
                            final ReceiveCustomerInfoCallback receiveCustomerInfoCallback2 = receiveCustomerInfoCallback;
                            customerInfoHelper2.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper.getCustomerInfoFetchOnly.2.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    ReceiveCustomerInfoCallback receiveCustomerInfoCallback3 = ReceiveCustomerInfoCallback.this;
                                    if (receiveCustomerInfoCallback3 != null) {
                                        receiveCustomerInfoCallback3.onReceived(offlineComputedCustomerInfo);
                                    }
                                }
                            });
                        }
                    };
                    final CustomerInfoHelper customerInfoHelper2 = CustomerInfoHelper.this;
                    final ReceiveCustomerInfoCallback receiveCustomerInfoCallback2 = callback;
                    offlineEntitlementsManager2.calculateAndCacheOfflineCustomerInfo(str, function1, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper$getCustomerInfoFetchOnly$2.2
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
                            CustomerInfoHelper customerInfoHelper3 = CustomerInfoHelper.this;
                            final ReceiveCustomerInfoCallback receiveCustomerInfoCallback3 = receiveCustomerInfoCallback2;
                            final PurchasesError purchasesError = backendError;
                            customerInfoHelper3.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper.getCustomerInfoFetchOnly.2.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    ReceiveCustomerInfoCallback receiveCustomerInfoCallback4 = ReceiveCustomerInfoCallback.this;
                                    if (receiveCustomerInfoCallback4 != null) {
                                        receiveCustomerInfoCallback4.onError(purchasesError);
                                    }
                                }
                            });
                        }
                    });
                    return;
                }
                CustomerInfoHelper customerInfoHelper3 = CustomerInfoHelper.this;
                final ReceiveCustomerInfoCallback receiveCustomerInfoCallback3 = callback;
                customerInfoHelper3.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper$getCustomerInfoFetchOnly$2.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ReceiveCustomerInfoCallback receiveCustomerInfoCallback4 = ReceiveCustomerInfoCallback.this;
                        if (receiveCustomerInfoCallback4 != null) {
                            receiveCustomerInfoCallback4.onError(backendError);
                        }
                    }
                });
            }
        });
    }

    static /* synthetic */ void getCustomerInfoCachedOrFetched$default(CustomerInfoHelper customerInfoHelper, String str, boolean z, boolean z2, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 8) != 0) {
            receiveCustomerInfoCallback = null;
        }
        customerInfoHelper.getCustomerInfoCachedOrFetched(str, z, z2, receiveCustomerInfoCallback);
    }

    private final void getCustomerInfoCachedOrFetched(String appUserID, boolean appInBackground, boolean allowSharingPlayStoreAccount, final ReceiveCustomerInfoCallback callback) {
        final CustomerInfo cachedCustomerInfo = getCachedCustomerInfo(appUserID);
        if (cachedCustomerInfo != null) {
            LogWrapperKt.log(LogIntent.DEBUG, CustomerInfoStrings.VENDING_CACHE);
            dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper$getCustomerInfoCachedOrFetched$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ReceiveCustomerInfoCallback receiveCustomerInfoCallback = ReceiveCustomerInfoCallback.this;
                    if (receiveCustomerInfoCallback != null) {
                        receiveCustomerInfoCallback.onReceived(cachedCustomerInfo);
                    }
                }
            });
            updateCachedCustomerInfoIfStale(appUserID, appInBackground, allowSharingPlayStoreAccount);
        } else {
            LogWrapperKt.log(LogIntent.DEBUG, CustomerInfoStrings.NO_CACHED_CUSTOMERINFO);
            postPendingPurchasesAndFetchCustomerInfo(appUserID, appInBackground, allowSharingPlayStoreAccount, callback);
        }
    }

    static /* synthetic */ void getCustomerInfoNotStaledCachedOrFetched$default(CustomerInfoHelper customerInfoHelper, String str, boolean z, boolean z2, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 8) != 0) {
            receiveCustomerInfoCallback = null;
        }
        customerInfoHelper.getCustomerInfoNotStaledCachedOrFetched(str, z, z2, receiveCustomerInfoCallback);
    }

    private final void getCustomerInfoNotStaledCachedOrFetched(String appUserID, boolean appInBackground, boolean allowSharingPlayStoreAccount, ReceiveCustomerInfoCallback callback) {
        if (this.deviceCache.isCustomerInfoCacheStale(appUserID, appInBackground)) {
            postPendingPurchasesAndFetchCustomerInfo(appUserID, appInBackground, allowSharingPlayStoreAccount, callback);
        } else {
            getCustomerInfoCachedOrFetched(appUserID, appInBackground, allowSharingPlayStoreAccount, callback);
        }
    }

    private final CustomerInfo getCachedCustomerInfo(String appUserID) {
        CustomerInfo customerInfo = this.offlineEntitlementsManager.get_offlineCustomerInfo();
        return customerInfo == null ? this.deviceCache.getCachedCustomerInfo(appUserID) : customerInfo;
    }

    private final void updateCachedCustomerInfoIfStale(String appUserID, boolean appInBackground, boolean allowSharingPlayStoreAccount) {
        if (this.deviceCache.isCustomerInfoCacheStale(appUserID, appInBackground)) {
            LogWrapperKt.log(LogIntent.DEBUG, appInBackground ? CustomerInfoStrings.CUSTOMERINFO_STALE_UPDATING_BACKGROUND : CustomerInfoStrings.CUSTOMERINFO_STALE_UPDATING_FOREGROUND);
            postPendingPurchasesAndFetchCustomerInfo$default(this, appUserID, appInBackground, allowSharingPlayStoreAccount, null, 8, null);
        }
    }

    public final void dispatch(final Function0<Unit> action) {
        if (!Intrinsics.areEqual(Thread.currentThread(), this.handler.getLooper().getThread())) {
            this.handler.post(new Runnable() { // from class: com.revenuecat.purchases.CustomerInfoHelper$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CustomerInfoHelper.dispatch$lambda$0(Function0.this);
                }
            });
        } else {
            action.invoke();
        }
    }

    public static final void dispatch$lambda$0(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }
}
