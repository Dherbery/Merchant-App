package com.revenuecat.purchases.common.offlineentitlements;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OfflineEntitlementsManager.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ6\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00132\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00170\u00162\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00170\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0006\u0010 \u001a\u00020\u0017J\u0016\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u0013J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fJ \u0010$\u001a\u00020\u00172\u0018\b\u0002\u0010%\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016R\u001e\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8B@BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000RH\u0010\u0011\u001a<\u0012\u0004\u0012\u00020\u0013\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00170\u00160\u0015j\u0002`\u00190\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;", "", "backend", "Lcom/revenuecat/purchases/common/Backend;", "offlineCustomerInfoCalculator", "Lcom/revenuecat/purchases/common/offlineentitlements/OfflineCustomerInfoCalculator;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "(Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/offlineentitlements/OfflineCustomerInfoCalculator;Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/common/AppConfig;)V", "<set-?>", "Lcom/revenuecat/purchases/CustomerInfo;", "_offlineCustomerInfo", "offlineCustomerInfo", "getOfflineCustomerInfo", "()Lcom/revenuecat/purchases/CustomerInfo;", "offlineCustomerInfoCallbackCache", "", "", "", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/common/offlineentitlements/OfflineCustomerInfoCallback;", "calculateAndCacheOfflineCustomerInfo", "appUserId", "onSuccess", "onError", "isOfflineEntitlementsEnabled", "", "resetOfflineCustomerInfoCache", "shouldCalculateOfflineCustomerInfoInGetCustomerInfoRequest", "isServerError", "shouldCalculateOfflineCustomerInfoInPostReceipt", "updateProductEntitlementMappingCacheIfStale", "completion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class OfflineEntitlementsManager {
    private CustomerInfo _offlineCustomerInfo;
    private final AppConfig appConfig;
    private final Backend backend;
    private final DeviceCache deviceCache;
    private final OfflineCustomerInfoCalculator offlineCustomerInfoCalculator;
    private final Map<String, List<Pair<Function1<CustomerInfo, Unit>, Function1<PurchasesError, Unit>>>> offlineCustomerInfoCallbackCache;

    public OfflineEntitlementsManager(Backend backend, OfflineCustomerInfoCalculator offlineCustomerInfoCalculator, DeviceCache deviceCache, AppConfig appConfig) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(offlineCustomerInfoCalculator, "offlineCustomerInfoCalculator");
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        this.backend = backend;
        this.offlineCustomerInfoCalculator = offlineCustomerInfoCalculator;
        this.deviceCache = deviceCache;
        this.appConfig = appConfig;
        this.offlineCustomerInfoCallbackCache = new LinkedHashMap();
    }

    /* renamed from: getOfflineCustomerInfo, reason: from getter */
    public final CustomerInfo get_offlineCustomerInfo() {
        return this._offlineCustomerInfo;
    }

    public final synchronized void resetOfflineCustomerInfoCache() {
        if (this._offlineCustomerInfo != null) {
            LogUtilsKt.debugLog(OfflineEntitlementsStrings.RESETTING_OFFLINE_CUSTOMER_INFO_CACHE);
            this._offlineCustomerInfo = null;
        }
    }

    public final boolean shouldCalculateOfflineCustomerInfoInGetCustomerInfoRequest(boolean isServerError, String appUserId) {
        Intrinsics.checkNotNullParameter(appUserId, "appUserId");
        return isServerError && isOfflineEntitlementsEnabled() && this.deviceCache.getCachedCustomerInfo(appUserId) == null;
    }

    public final boolean shouldCalculateOfflineCustomerInfoInPostReceipt(boolean isServerError) {
        return isServerError && isOfflineEntitlementsEnabled();
    }

    public final void calculateAndCacheOfflineCustomerInfo(final String appUserId, Function1<? super CustomerInfo, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserId, "appUserId");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (!this.appConfig.getEnableOfflineEntitlements()) {
            onError.invoke(new PurchasesError(PurchasesErrorCode.UnsupportedError, OfflineEntitlementsStrings.OFFLINE_ENTITLEMENTS_NOT_ENABLED));
            return;
        }
        synchronized (this) {
            boolean containsKey = this.offlineCustomerInfoCallbackCache.containsKey(appUserId);
            List<Pair<Function1<CustomerInfo, Unit>, Function1<PurchasesError, Unit>>> list = this.offlineCustomerInfoCallbackCache.get(appUserId);
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            this.offlineCustomerInfoCallbackCache.put(appUserId, CollectionsKt.plus((Collection) list, (Iterable) CollectionsKt.listOf(TuplesKt.to(onSuccess, onError))));
            if (containsKey) {
                String format = String.format(OfflineEntitlementsStrings.ALREADY_CALCULATING_OFFLINE_CUSTOMER_INFO, Arrays.copyOf(new Object[]{appUserId}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                LogUtilsKt.debugLog(format);
            } else {
                Unit unit = Unit.INSTANCE;
                this.offlineCustomerInfoCalculator.computeOfflineCustomerInfo(appUserId, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager$calculateAndCacheOfflineCustomerInfo$2
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
                    public final void invoke2(CustomerInfo customerInfo) {
                        DeviceCache deviceCache;
                        Map map;
                        DeviceCache deviceCache2;
                        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                        OfflineEntitlementsManager offlineEntitlementsManager = OfflineEntitlementsManager.this;
                        String str = appUserId;
                        synchronized (offlineEntitlementsManager) {
                            LogUtilsKt.warnLog(OfflineEntitlementsStrings.USING_OFFLINE_ENTITLEMENTS_CUSTOMER_INFO);
                            offlineEntitlementsManager._offlineCustomerInfo = customerInfo;
                            deviceCache = offlineEntitlementsManager.deviceCache;
                            String cachedAppUserID = deviceCache.getCachedAppUserID();
                            if (cachedAppUserID != null) {
                                deviceCache2 = offlineEntitlementsManager.deviceCache;
                                deviceCache2.clearCustomerInfoCache(cachedAppUserID);
                            }
                            map = offlineEntitlementsManager.offlineCustomerInfoCallbackCache;
                            List list2 = (List) map.remove(str);
                            if (list2 != null) {
                                Iterator it = list2.iterator();
                                while (it.hasNext()) {
                                    ((Function1) ((Pair) it.next()).component1()).invoke(customerInfo);
                                }
                            }
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager$calculateAndCacheOfflineCustomerInfo$3
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
                        Map map;
                        Intrinsics.checkNotNullParameter(it, "it");
                        OfflineEntitlementsManager offlineEntitlementsManager = OfflineEntitlementsManager.this;
                        String str = appUserId;
                        synchronized (offlineEntitlementsManager) {
                            map = offlineEntitlementsManager.offlineCustomerInfoCallbackCache;
                            List list2 = (List) map.remove(str);
                            if (list2 != null) {
                                Iterator it2 = list2.iterator();
                                while (it2.hasNext()) {
                                    ((Function1) ((Pair) it2.next()).component2()).invoke(it);
                                }
                            }
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                });
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateProductEntitlementMappingCacheIfStale$default(OfflineEntitlementsManager offlineEntitlementsManager, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        offlineEntitlementsManager.updateProductEntitlementMappingCacheIfStale(function1);
    }

    public final void updateProductEntitlementMappingCacheIfStale(final Function1<? super PurchasesError, Unit> completion) {
        if (isOfflineEntitlementsEnabled() && this.deviceCache.isProductEntitlementMappingCacheStale()) {
            LogUtilsKt.debugLog(OfflineEntitlementsStrings.UPDATING_PRODUCT_ENTITLEMENT_MAPPING);
            this.backend.getProductEntitlementMapping(new Function1<ProductEntitlementMapping, Unit>() { // from class: com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager$updateProductEntitlementMappingCacheIfStale$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ProductEntitlementMapping productEntitlementMapping) {
                    invoke2(productEntitlementMapping);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ProductEntitlementMapping productEntitlementMapping) {
                    DeviceCache deviceCache;
                    Intrinsics.checkNotNullParameter(productEntitlementMapping, "productEntitlementMapping");
                    deviceCache = OfflineEntitlementsManager.this.deviceCache;
                    deviceCache.cacheProductEntitlementMapping(productEntitlementMapping);
                    LogUtilsKt.debugLog(OfflineEntitlementsStrings.SUCCESSFULLY_UPDATED_PRODUCT_ENTITLEMENTS);
                    Function1<PurchasesError, Unit> function1 = completion;
                    if (function1 != null) {
                        function1.invoke(null);
                    }
                }
            }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager$updateProductEntitlementMappingCacheIfStale$2
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
                public final void invoke2(PurchasesError e) {
                    Intrinsics.checkNotNullParameter(e, "e");
                    String format = String.format(OfflineEntitlementsStrings.ERROR_UPDATING_PRODUCT_ENTITLEMENTS, Arrays.copyOf(new Object[]{e}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                    LogUtilsKt.errorLog$default(format, null, 2, null);
                    Function1<PurchasesError, Unit> function1 = completion;
                    if (function1 != null) {
                        function1.invoke(e);
                    }
                }
            });
        } else if (completion != null) {
            completion.invoke(null);
        }
    }

    private final boolean isOfflineEntitlementsEnabled() {
        return this.appConfig.getFinishTransactions() && this.appConfig.getEnableOfflineEntitlements() && !this.appConfig.getCustomEntitlementComputation();
    }
}
