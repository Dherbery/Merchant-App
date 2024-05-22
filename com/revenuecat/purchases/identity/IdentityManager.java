package com.revenuecat.purchases.identity;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.offerings.OfferingsCache;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.common.verification.SignatureVerificationMode;
import com.revenuecat.purchases.strings.IdentityStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: IdentityManager.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J<\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00122\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00160#2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160&J\u001c\u0010(\u001a\u00020\u00162\u0014\u0010)\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0004\u0012\u00020\u00160&J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u0012H\u0002J\u0012\u0010,\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u00010$H\u0002J\u000e\u0010.\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0012R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/revenuecat/purchases/identity/IdentityManager;", "", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "subscriberAttributesCache", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;", "subscriberAttributesManager", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;", "offeringsCache", "Lcom/revenuecat/purchases/common/offerings/OfferingsCache;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "offlineEntitlementsManager", "Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;", "(Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;Lcom/revenuecat/purchases/common/offerings/OfferingsCache;Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;)V", "anonymousIdRegex", "Lkotlin/text/Regex;", "currentAppUserID", "", "getCurrentAppUserID", "()Ljava/lang/String;", "configure", "", "appUserID", "copySubscriberAttributesToNewUserIfOldIsAnonymous", "oldAppUserId", "newAppUserId", "currentUserIsAnonymous", "", "generateRandomID", "invalidateCustomerInfoAndETagCacheIfNeeded", "isUserIDAnonymous", "logIn", "newAppUserID", "onSuccess", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/CustomerInfo;", "onError", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "logOut", "completion", "resetAndSaveUserID", "newUserID", "shouldInvalidateCustomerInfoAndETagCache", "customerInfo", "switchUser", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class IdentityManager {
    private final Regex anonymousIdRegex;
    private final Backend backend;
    private final DeviceCache deviceCache;
    private final OfferingsCache offeringsCache;
    private final OfflineEntitlementsManager offlineEntitlementsManager;
    private final SubscriberAttributesCache subscriberAttributesCache;
    private final SubscriberAttributesManager subscriberAttributesManager;

    public IdentityManager(DeviceCache deviceCache, SubscriberAttributesCache subscriberAttributesCache, SubscriberAttributesManager subscriberAttributesManager, OfferingsCache offeringsCache, Backend backend, OfflineEntitlementsManager offlineEntitlementsManager) {
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(subscriberAttributesCache, "subscriberAttributesCache");
        Intrinsics.checkNotNullParameter(subscriberAttributesManager, "subscriberAttributesManager");
        Intrinsics.checkNotNullParameter(offeringsCache, "offeringsCache");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(offlineEntitlementsManager, "offlineEntitlementsManager");
        this.deviceCache = deviceCache;
        this.subscriberAttributesCache = subscriberAttributesCache;
        this.subscriberAttributesManager = subscriberAttributesManager;
        this.offeringsCache = offeringsCache;
        this.backend = backend;
        this.offlineEntitlementsManager = offlineEntitlementsManager;
        this.anonymousIdRegex = new Regex("^\\$RCAnonymousID:([a-f0-9]{32})$");
    }

    public final String getCurrentAppUserID() {
        String cachedAppUserID = this.deviceCache.getCachedAppUserID();
        return cachedAppUserID == null ? "" : cachedAppUserID;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0015 A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:28:0x0005, B:6:0x0015, B:8:0x001e, B:13:0x0040, B:22:0x002c, B:24:0x0034, B:26:0x003c), top: B:27:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:28:0x0005, B:6:0x0015, B:8:0x001e, B:13:0x0040, B:22:0x002c, B:24:0x0034, B:26:0x003c), top: B:27:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void configure(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L12
            r2 = r6
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.lang.Throwable -> L10
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)     // Catch: java.lang.Throwable -> L10
            if (r2 != r0) goto L12
            r2 = r0
            goto L13
        L10:
            r6 = move-exception
            goto L6c
        L12:
            r2 = r1
        L13:
            if (r2 == 0) goto L1c
            com.revenuecat.purchases.common.LogIntent r2 = com.revenuecat.purchases.common.LogIntent.WARNING     // Catch: java.lang.Throwable -> L10
            java.lang.String r3 = "Identifying with empty App User ID will be treated as anonymous."
            com.revenuecat.purchases.common.LogWrapperKt.log(r2, r3)     // Catch: java.lang.Throwable -> L10
        L1c:
            if (r6 == 0) goto L2c
            r2 = r6
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.lang.Throwable -> L10
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)     // Catch: java.lang.Throwable -> L10
            if (r2 != 0) goto L28
            goto L29
        L28:
            r6 = 0
        L29:
            if (r6 == 0) goto L2c
            goto L40
        L2c:
            com.revenuecat.purchases.common.caching.DeviceCache r6 = r5.deviceCache     // Catch: java.lang.Throwable -> L10
            java.lang.String r6 = r6.getCachedAppUserID()     // Catch: java.lang.Throwable -> L10
            if (r6 != 0) goto L40
            com.revenuecat.purchases.common.caching.DeviceCache r6 = r5.deviceCache     // Catch: java.lang.Throwable -> L10
            java.lang.String r6 = r6.getLegacyCachedAppUserID()     // Catch: java.lang.Throwable -> L10
            if (r6 != 0) goto L40
            java.lang.String r6 = r5.generateRandomID()     // Catch: java.lang.Throwable -> L10
        L40:
            com.revenuecat.purchases.common.LogIntent r2 = com.revenuecat.purchases.common.LogIntent.USER     // Catch: java.lang.Throwable -> L10
            java.lang.String r3 = "Identifying App User ID: %s"
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L10
            r4[r1] = r6     // Catch: java.lang.Throwable -> L10
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r4, r0)     // Catch: java.lang.Throwable -> L10
            java.lang.String r0 = java.lang.String.format(r3, r0)     // Catch: java.lang.Throwable -> L10
            java.lang.String r1 = "format(this, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Throwable -> L10
            com.revenuecat.purchases.common.LogWrapperKt.log(r2, r0)     // Catch: java.lang.Throwable -> L10
            com.revenuecat.purchases.common.caching.DeviceCache r0 = r5.deviceCache     // Catch: java.lang.Throwable -> L10
            r0.cacheAppUserID(r6)     // Catch: java.lang.Throwable -> L10
            com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache r0 = r5.subscriberAttributesCache     // Catch: java.lang.Throwable -> L10
            r0.cleanUpSubscriberAttributeCache(r6)     // Catch: java.lang.Throwable -> L10
            com.revenuecat.purchases.common.caching.DeviceCache r0 = r5.deviceCache     // Catch: java.lang.Throwable -> L10
            r0.cleanupOldAttributionData()     // Catch: java.lang.Throwable -> L10
            r5.invalidateCustomerInfoAndETagCacheIfNeeded(r6)     // Catch: java.lang.Throwable -> L10
            monitor-exit(r5)
            return
        L6c:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.identity.IdentityManager.configure(java.lang.String):void");
    }

    public final void logIn(final String newAppUserID, final Function2<? super CustomerInfo, ? super Boolean, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (StringsKt.isBlank(newAppUserID)) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.InvalidAppUserIdError, IdentityStrings.LOG_IN_ERROR_MISSING_APP_USER_ID);
            LogUtilsKt.errorLog(purchasesError);
            onError.invoke(purchasesError);
        } else {
            LogIntent logIntent = LogIntent.USER;
            String format = String.format(IdentityStrings.LOGGING_IN, Arrays.copyOf(new Object[]{getCurrentAppUserID(), newAppUserID}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
            final String currentAppUserID = getCurrentAppUserID();
            this.subscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers(newAppUserID, new Function0<Unit>() { // from class: com.revenuecat.purchases.identity.IdentityManager$logIn$2
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    Backend backend;
                    backend = IdentityManager.this.backend;
                    String str = currentAppUserID;
                    String str2 = newAppUserID;
                    final IdentityManager identityManager = IdentityManager.this;
                    final Function2<CustomerInfo, Boolean, Unit> function2 = onSuccess;
                    final String str3 = newAppUserID;
                    final String str4 = currentAppUserID;
                    backend.logIn(str, str2, new Function2<CustomerInfo, Boolean, Unit>() { // from class: com.revenuecat.purchases.identity.IdentityManager$logIn$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo, Boolean bool) {
                            invoke(customerInfo, bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(CustomerInfo customerInfo, boolean z) {
                            DeviceCache deviceCache;
                            OfferingsCache offeringsCache;
                            SubscriberAttributesCache subscriberAttributesCache;
                            DeviceCache deviceCache2;
                            DeviceCache deviceCache3;
                            OfflineEntitlementsManager offlineEntitlementsManager;
                            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                            IdentityManager identityManager2 = IdentityManager.this;
                            String str5 = str3;
                            String str6 = str4;
                            synchronized (identityManager2) {
                                LogIntent logIntent2 = LogIntent.USER;
                                String format2 = String.format(IdentityStrings.LOG_IN_SUCCESSFUL, Arrays.copyOf(new Object[]{str5, Boolean.valueOf(z)}, 2));
                                Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
                                LogWrapperKt.log(logIntent2, format2);
                                deviceCache = identityManager2.deviceCache;
                                deviceCache.clearCachesForAppUserID(str6);
                                offeringsCache = identityManager2.offeringsCache;
                                offeringsCache.clearCache();
                                subscriberAttributesCache = identityManager2.subscriberAttributesCache;
                                subscriberAttributesCache.clearSubscriberAttributesIfSyncedForSubscriber(str6);
                                deviceCache2 = identityManager2.deviceCache;
                                deviceCache2.cacheAppUserID(str5);
                                deviceCache3 = identityManager2.deviceCache;
                                deviceCache3.cacheCustomerInfo(str5, customerInfo);
                                identityManager2.copySubscriberAttributesToNewUserIfOldIsAnonymous(str6, str5);
                                offlineEntitlementsManager = identityManager2.offlineEntitlementsManager;
                                offlineEntitlementsManager.resetOfflineCustomerInfoCache();
                                Unit unit = Unit.INSTANCE;
                            }
                            function2.invoke(customerInfo, Boolean.valueOf(z));
                        }
                    }, onError);
                }
            });
        }
    }

    public final void switchUser(String newAppUserID) {
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        String format = String.format(IdentityStrings.SWITCHING_USER, Arrays.copyOf(new Object[]{newAppUserID}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogUtilsKt.debugLog(format);
        resetAndSaveUserID(newAppUserID);
    }

    public final synchronized void logOut(final Function1<? super PurchasesError, Unit> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        if (currentUserIsAnonymous()) {
            LogWrapperKt.log(LogIntent.RC_ERROR, IdentityStrings.LOG_OUT_CALLED_ON_ANONYMOUS_USER);
            completion.invoke(new PurchasesError(PurchasesErrorCode.LogOutWithAnonymousUserError, null, 2, null));
        } else {
            this.subscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers(getCurrentAppUserID(), new Function0<Unit>() { // from class: com.revenuecat.purchases.identity.IdentityManager$logOut$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    String generateRandomID;
                    IdentityManager identityManager = IdentityManager.this;
                    generateRandomID = identityManager.generateRandomID();
                    identityManager.resetAndSaveUserID(generateRandomID);
                    LogWrapperKt.log(LogIntent.USER, IdentityStrings.LOG_OUT_SUCCESSFUL);
                    completion.invoke(null);
                }
            });
        }
    }

    public final synchronized boolean currentUserIsAnonymous() {
        String cachedAppUserID;
        cachedAppUserID = this.deviceCache.getCachedAppUserID();
        if (cachedAppUserID == null) {
            cachedAppUserID = "";
        }
        return isUserIDAnonymous(cachedAppUserID) || Intrinsics.areEqual(this.deviceCache.getCachedAppUserID(), this.deviceCache.getLegacyCachedAppUserID());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void copySubscriberAttributesToNewUserIfOldIsAnonymous(String oldAppUserId, String newAppUserId) {
        if (isUserIDAnonymous(oldAppUserId)) {
            this.subscriberAttributesManager.copyUnsyncedSubscriberAttributes(oldAppUserId, newAppUserId);
        }
    }

    private final void invalidateCustomerInfoAndETagCacheIfNeeded(String appUserID) {
        if (shouldInvalidateCustomerInfoAndETagCache(this.deviceCache.getCachedCustomerInfo(appUserID))) {
            LogUtilsKt.infoLog(IdentityStrings.INVALIDATING_CACHED_CUSTOMER_INFO);
            this.deviceCache.clearCustomerInfoCache(appUserID);
            this.backend.clearCaches();
        }
    }

    private final boolean shouldInvalidateCustomerInfoAndETagCache(CustomerInfo customerInfo) {
        return (customerInfo == null || customerInfo.getEntitlements().getVerification() != VerificationResult.NOT_REQUESTED || Intrinsics.areEqual(this.backend.getVerificationMode(), SignatureVerificationMode.Disabled.INSTANCE)) ? false : true;
    }

    private final boolean isUserIDAnonymous(String appUserID) {
        return this.anonymousIdRegex.matches(appUserID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String generateRandomID() {
        StringBuilder sb = new StringBuilder("$RCAnonymousID:");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = uuid.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        String replace$default = StringsKt.replace$default(lowerCase, "-", "", false, 4, (Object) null);
        LogWrapperKt.log(LogIntent.USER, IdentityStrings.SETTING_NEW_ANON_ID);
        sb.append(replace$default);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void resetAndSaveUserID(String newUserID) {
        this.deviceCache.clearCachesForAppUserID(getCurrentAppUserID());
        this.offeringsCache.clearCache();
        this.subscriberAttributesCache.clearSubscriberAttributesIfSyncedForSubscriber(getCurrentAppUserID());
        this.offlineEntitlementsManager.resetOfflineCustomerInfoCache();
        this.deviceCache.cacheAppUserID(newUserID);
        this.backend.clearCaches();
    }
}
