package com.revenuecat.purchases;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.preference.PreferenceManager;
import com.revenuecat.purchases.PurchasesFactory;
import com.revenuecat.purchases.common.Anonymizer;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BackendHelper;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.FileHelper;
import com.revenuecat.purchases.common.HTTPClient;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.OfferingParser;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsAnonymizer;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsFileHelper;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.networking.ETagManager;
import com.revenuecat.purchases.common.offerings.OfferingsCache;
import com.revenuecat.purchases.common.offerings.OfferingsFactory;
import com.revenuecat.purchases.common.offerings.OfferingsManager;
import com.revenuecat.purchases.common.offlineentitlements.OfflineCustomerInfoCalculator;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.common.offlineentitlements.PurchasedProductsFetcher;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import com.revenuecat.purchases.common.verification.SignatureVerificationMode;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.paywalls.PaywallPresentedCache;
import com.revenuecat.purchases.paywalls.events.PaywallEventsManager;
import com.revenuecat.purchases.paywalls.events.PaywallStoredEvent;
import com.revenuecat.purchases.strings.ConfigureStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesPoster;
import com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache;
import com.revenuecat.purchases.utils.AndroidVersionUtilsKt;
import com.revenuecat.purchases.utils.CoilImageDownloader;
import com.revenuecat.purchases.utils.EventsFileHelper;
import com.revenuecat.purchases.utils.OfferingImagePreDownloader;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PurchasesFactory.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001'B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002JJ\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001dJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\f\u0010\"\u001a\u00020#*\u00020\u000bH\u0002J\u0014\u0010$\u001a\u00020\u001d*\u00020\u000b2\u0006\u0010%\u001a\u00020&H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/revenuecat/purchases/PurchasesFactory;", "", "apiKeyValidator", "Lcom/revenuecat/purchases/APIKeyValidator;", "(Lcom/revenuecat/purchases/APIKeyValidator;)V", "createDefaultExecutor", "Ljava/util/concurrent/ExecutorService;", "createEventsExecutor", "createPaywallEventsManager", "Lcom/revenuecat/purchases/paywalls/events/PaywallEventsManager;", "context", "Landroid/content/Context;", "identityManager", "Lcom/revenuecat/purchases/identity/IdentityManager;", "eventsDispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "createPurchases", "Lcom/revenuecat/purchases/Purchases;", "configuration", "Lcom/revenuecat/purchases/PurchasesConfiguration;", "platformInfo", "Lcom/revenuecat/purchases/common/PlatformInfo;", "proxyURL", "Ljava/net/URL;", "overrideBillingAbstract", "Lcom/revenuecat/purchases/common/BillingAbstract;", "forceServerErrors", "", "forceSigningError", "runningIntegrationTests", "validateConfiguration", "", "getApplication", "Landroid/app/Application;", "hasPermission", "permission", "", "LowPriorityThreadFactory", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PurchasesFactory {
    private final APIKeyValidator apiKeyValidator;

    public PurchasesFactory() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public PurchasesFactory(APIKeyValidator apiKeyValidator) {
        Intrinsics.checkNotNullParameter(apiKeyValidator, "apiKeyValidator");
        this.apiKeyValidator = apiKeyValidator;
    }

    public /* synthetic */ PurchasesFactory(APIKeyValidator aPIKeyValidator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new APIKeyValidator() : aPIKeyValidator);
    }

    public final Purchases createPurchases(PurchasesConfiguration configuration, PlatformInfo platformInfo, URL proxyURL, BillingAbstract overrideBillingAbstract, boolean forceServerErrors, boolean forceSigningError, boolean runningIntegrationTests) {
        DiagnosticsFileHelper diagnosticsFileHelper;
        DiagnosticsTracker diagnosticsTracker;
        PurchasesStateCache purchasesStateCache;
        BillingAbstract billingAbstract;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(platformInfo, "platformInfo");
        validateConfiguration(configuration);
        Application application = getApplication(configuration.getContext());
        AppConfig appConfig = new AppConfig(configuration.getContext(), configuration.getObserverMode(), configuration.getShowInAppMessagesAutomatically(), platformInfo, proxyURL, configuration.getStore(), configuration.getDangerousSettings(), runningIntegrationTests, forceServerErrors, forceSigningError);
        Application application2 = application;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(application2);
        ETagManager eTagManager = new ETagManager(configuration.getContext(), null, null, 6, null);
        Dispatcher dispatcher = new Dispatcher(createDefaultExecutor(), null, runningIntegrationTests, 2, null);
        ExecutorService service = configuration.getService();
        if (service == null) {
            service = createDefaultExecutor();
        }
        Dispatcher dispatcher2 = new Dispatcher(service, null, runningIntegrationTests, 2, null);
        Dispatcher dispatcher3 = new Dispatcher(createEventsExecutor(), null, runningIntegrationTests, 2, null);
        if (configuration.getDiagnosticsEnabled() && AndroidVersionUtilsKt.isAndroidNOrNewer()) {
            DiagnosticsFileHelper diagnosticsFileHelper2 = new DiagnosticsFileHelper(new FileHelper(configuration.getContext()));
            diagnosticsFileHelper = diagnosticsFileHelper2;
            diagnosticsTracker = new DiagnosticsTracker(appConfig, diagnosticsFileHelper2, new DiagnosticsAnonymizer(new Anonymizer()), dispatcher3);
        } else {
            if (configuration.getDiagnosticsEnabled()) {
                LogUtilsKt.warnLog("Diagnostics are only supported on Android N or newer.");
            }
            diagnosticsFileHelper = null;
            diagnosticsTracker = null;
        }
        SigningManager signingManager = new SigningManager(SignatureVerificationMode.Companion.fromEntitlementVerificationMode$default(SignatureVerificationMode.INSTANCE, configuration.getVerificationMode(), null, 2, null), appConfig, configuration.getApiKey());
        Intrinsics.checkNotNullExpressionValue(prefs, "prefs");
        DeviceCache deviceCache = new DeviceCache(prefs, configuration.getApiKey(), null, 4, null);
        HTTPClient hTTPClient = new HTTPClient(appConfig, eTagManager, diagnosticsTracker, signingManager, deviceCache, null, null, 96, null);
        BackendHelper backendHelper = new BackendHelper(configuration.getApiKey(), dispatcher2, appConfig, hTTPClient);
        Backend backend = new Backend(appConfig, dispatcher2, dispatcher3, hTTPClient, backendHelper);
        PurchasesStateCache purchasesStateCache2 = new PurchasesStateCache(new PurchasesState(null, null, null, false, false, 31, null));
        if (overrideBillingAbstract == null) {
            purchasesStateCache = purchasesStateCache2;
            billingAbstract = BillingFactory.INSTANCE.createBilling(configuration.getStore(), application, backendHelper, deviceCache, configuration.getObserverMode(), diagnosticsTracker, purchasesStateCache2);
        } else {
            purchasesStateCache = purchasesStateCache2;
            billingAbstract = overrideBillingAbstract;
        }
        SubscriberAttributesPoster subscriberAttributesPoster = new SubscriberAttributesPoster(backendHelper);
        DeviceIdentifiersFetcher createAttributionFetcher = AttributionFetcherFactory.INSTANCE.createAttributionFetcher(configuration.getStore(), dispatcher2);
        SubscriberAttributesCache subscriberAttributesCache = new SubscriberAttributesCache(deviceCache);
        SubscriberAttributesManager subscriberAttributesManager = new SubscriberAttributesManager(subscriberAttributesCache, subscriberAttributesPoster, createAttributionFetcher);
        DateProvider dateProvider = null;
        int i = 4;
        DefaultConstructorMarker defaultConstructorMarker = null;
        OfflineEntitlementsManager offlineEntitlementsManager = new OfflineEntitlementsManager(backend, new OfflineCustomerInfoCalculator(new PurchasedProductsFetcher(deviceCache, billingAbstract, dateProvider, i, defaultConstructorMarker), appConfig, dateProvider, i, defaultConstructorMarker), deviceCache, appConfig);
        OfferingsCache offeringsCache = new OfferingsCache(deviceCache, null, null, 6, null);
        IdentityManager identityManager = new IdentityManager(deviceCache, subscriberAttributesCache, subscriberAttributesManager, offeringsCache, backend, offlineEntitlementsManager);
        BillingAbstract billingAbstract2 = billingAbstract;
        CustomerInfoUpdateHandler customerInfoUpdateHandler = new CustomerInfoUpdateHandler(deviceCache, identityManager, offlineEntitlementsManager, appConfig, null, 16, null);
        PaywallPresentedCache paywallPresentedCache = new PaywallPresentedCache();
        PostReceiptHelper postReceiptHelper = new PostReceiptHelper(appConfig, backend, billingAbstract2, customerInfoUpdateHandler, deviceCache, subscriberAttributesManager, offlineEntitlementsManager, paywallPresentedCache);
        PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper = new PostTransactionWithProductDetailsHelper(billingAbstract2, postReceiptHelper);
        PostPendingTransactionsHelper postPendingTransactionsHelper = new PostPendingTransactionsHelper(appConfig, deviceCache, billingAbstract2, dispatcher2, identityManager, postTransactionWithProductDetailsHelper);
        CustomerInfoHelper customerInfoHelper = new CustomerInfoHelper(deviceCache, backend, offlineEntitlementsManager, customerInfoUpdateHandler, postPendingTransactionsHelper, null, 32, null);
        OfferingParser createOfferingParser = OfferingParserFactory.INSTANCE.createOfferingParser(configuration.getStore());
        DiagnosticsSynchronizer diagnosticsSynchronizer = (diagnosticsFileHelper == null || diagnosticsTracker == null || !AndroidVersionUtilsKt.isAndroidNOrNewer()) ? null : new DiagnosticsSynchronizer(configuration.getContext(), diagnosticsFileHelper, diagnosticsTracker, backend, dispatcher3, null, 32, null);
        SyncPurchasesHelper syncPurchasesHelper = new SyncPurchasesHelper(billingAbstract2, identityManager, customerInfoHelper, postReceiptHelper);
        OfferingsManager offeringsManager = new OfferingsManager(offeringsCache, backend, new OfferingsFactory(billingAbstract2, createOfferingParser, dispatcher), new OfferingImagePreDownloader(false, new CoilImageDownloader(application2), 1, null), null, 16, null);
        LogWrapperKt.log(LogIntent.DEBUG, ConfigureStrings.DEBUG_ENABLED);
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(ConfigureStrings.SDK_VERSION, Arrays.copyOf(new Object[]{Purchases.INSTANCE.getFrameworkVersion()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        LogIntent logIntent2 = LogIntent.DEBUG;
        String format2 = String.format(ConfigureStrings.PACKAGE_NAME, Arrays.copyOf(new Object[]{appConfig.getPackageName()}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
        LogWrapperKt.log(logIntent2, format2);
        LogIntent logIntent3 = LogIntent.USER;
        String format3 = String.format(ConfigureStrings.INITIAL_APP_USER_ID, Arrays.copyOf(new Object[]{configuration.getAppUserID()}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "format(this, *args)");
        LogWrapperKt.log(logIntent3, format3);
        LogIntent logIntent4 = LogIntent.DEBUG;
        String format4 = String.format(ConfigureStrings.VERIFICATION_MODE_SELECTED, Arrays.copyOf(new Object[]{configuration.getVerificationMode().name()}, 1));
        Intrinsics.checkNotNullExpressionValue(format4, "format(this, *args)");
        LogWrapperKt.log(logIntent4, format4);
        return new Purchases(new PurchasesOrchestrator(application, configuration.getAppUserID(), backend, billingAbstract2, deviceCache, identityManager, subscriberAttributesManager, appConfig, customerInfoHelper, customerInfoUpdateHandler, diagnosticsSynchronizer, offlineEntitlementsManager, postReceiptHelper, postTransactionWithProductDetailsHelper, postPendingTransactionsHelper, syncPurchasesHelper, offeringsManager, createPaywallEventsManager(application2, identityManager, dispatcher3, backend), paywallPresentedCache, purchasesStateCache, null, 1048576, 0 == true ? 1 : 0));
    }

    private final PaywallEventsManager createPaywallEventsManager(Context context, IdentityManager identityManager, Dispatcher eventsDispatcher, Backend backend) {
        if (AndroidVersionUtilsKt.isAndroidNOrNewer()) {
            return new PaywallEventsManager(new EventsFileHelper(new FileHelper(context), PaywallEventsManager.PAYWALL_EVENTS_FILE_PATH, new PurchasesFactory$createPaywallEventsManager$1(PaywallStoredEvent.INSTANCE)), identityManager, eventsDispatcher, backend);
        }
        LogUtilsKt.debugLog("Paywall events are only supported on Android N or newer.");
        return null;
    }

    public final void validateConfiguration(PurchasesConfiguration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        if (!hasPermission(configuration.getContext(), "android.permission.INTERNET")) {
            throw new IllegalArgumentException("Purchases requires INTERNET permission.".toString());
        }
        if (!(!StringsKt.isBlank(configuration.getApiKey()))) {
            throw new IllegalArgumentException("API key must be set. Get this from the RevenueCat web app".toString());
        }
        if (!(configuration.getContext().getApplicationContext() instanceof Application)) {
            throw new IllegalArgumentException("Needs an application context.".toString());
        }
        this.apiKeyValidator.validateAndLog(configuration.getApiKey(), configuration.getStore());
    }

    private final Application getApplication(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        return (Application) applicationContext;
    }

    private final boolean hasPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    private final ExecutorService createDefaultExecutor() {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor()");
        return newSingleThreadScheduledExecutor;
    }

    private final ExecutorService createEventsExecutor() {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new LowPriorityThreadFactory("revenuecat-events-thread"));
        Intrinsics.checkNotNullExpressionValue(newSingleThreadScheduledExecutor, "newSingleThreadScheduled…venuecat-events-thread\"))");
        return newSingleThreadScheduledExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PurchasesFactory.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/PurchasesFactory$LowPriorityThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "threadName", "", "(Ljava/lang/String;)V", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class LowPriorityThreadFactory implements ThreadFactory {
        private final String threadName;

        public LowPriorityThreadFactory(String threadName) {
            Intrinsics.checkNotNullParameter(threadName, "threadName");
            this.threadName = threadName;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable r) {
            return new Thread(new Runnable() { // from class: com.revenuecat.purchases.PurchasesFactory$LowPriorityThreadFactory$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PurchasesFactory.LowPriorityThreadFactory.newThread$lambda$1(r);
                }
            }, this.threadName);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void newThread$lambda$1(Runnable runnable) {
            if (runnable != null) {
                Process.setThreadPriority(19);
                runnable.run();
            }
        }
    }
}
