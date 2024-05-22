package com.revenuecat.purchases;

import android.app.Activity;
import android.content.Context;
import androidx.autofill.HintConstants;
import com.amazon.a.a.o.b;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.interfaces.Callback;
import com.revenuecat.purchases.interfaces.GetStoreProductsCallback;
import com.revenuecat.purchases.interfaces.LogInCallback;
import com.revenuecat.purchases.interfaces.ProductChangeCallback;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback;
import com.revenuecat.purchases.interfaces.SyncPurchasesCallback;
import com.revenuecat.purchases.interfaces.UpdatedCustomerInfoListener;
import com.revenuecat.purchases.models.BillingFeature;
import com.revenuecat.purchases.models.GoogleProrationMode;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.ConfigureStrings;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UninitializedPropertyAccessException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Purchases.kt */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0088\u00012\u00020\u0001:\u0002\u0088\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\u0016\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u000e\u0010%\u001a\u00020#2\u0006\u0010(\u001a\u00020)J\u001e\u0010*\u001a\u00020#2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0,2\u0006\u0010(\u001a\u00020-H\u0007J\u000e\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u000200J(\u00101\u001a\u00020#2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0,2\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\u0006\u0010(\u001a\u00020-J\u001c\u00101\u001a\u00020#2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0,2\u0006\u0010(\u001a\u00020-J\u001e\u00104\u001a\u00020#2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0,2\u0006\u0010(\u001a\u00020-H\u0007J\u0006\u00105\u001a\u00020#J\u001c\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020\u000f2\n\b\u0002\u0010(\u001a\u0004\u0018\u000108H\u0007J\u0014\u00109\u001a\u00020#2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)H\u0007J\b\u0010:\u001a\u00020#H\u0017J\b\u0010;\u001a\u00020#H\u0017J\u0016\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020>2\u0006\u0010(\u001a\u00020?J(\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010(\u001a\u00020GH\u0007J \u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010/\u001a\u00020?H\u0007J(\u0010H\u001a\u00020#2\u0006\u0010A\u001a\u00020B2\u0006\u0010I\u001a\u00020J2\u0006\u0010E\u001a\u00020F2\u0006\u0010/\u001a\u00020GH\u0007J \u0010H\u001a\u00020#2\u0006\u0010A\u001a\u00020B2\u0006\u0010I\u001a\u00020J2\u0006\u0010(\u001a\u00020?H\u0007J\u0006\u0010K\u001a\u00020#J\u000e\u0010L\u001a\u00020#2\u0006\u0010(\u001a\u00020)J\u0010\u0010M\u001a\u00020#2\b\u0010N\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010O\u001a\u00020#2\b\u0010P\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010Q\u001a\u00020#2\b\u0010R\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010S\u001a\u00020#2\b\u0010T\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010U\u001a\u00020#2\b\u0010V\u001a\u0004\u0018\u00010\u000fJ\u001c\u0010W\u001a\u00020#2\u0014\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0YJ\u0010\u0010Z\u001a\u00020#2\b\u0010[\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\\\u001a\u00020#2\b\u0010]\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010^\u001a\u00020#2\b\u0010_\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010`\u001a\u00020#2\b\u0010a\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010b\u001a\u00020#2\b\u0010c\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010d\u001a\u00020#2\b\u0010e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010f\u001a\u00020#2\b\u0010g\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010h\u001a\u00020#2\b\u0010i\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010j\u001a\u00020#2\b\u0010k\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010l\u001a\u00020#2\b\u0010m\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010n\u001a\u00020#2\b\u0010o\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010p\u001a\u00020#2\b\u0010q\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010r\u001a\u00020#2\b\u0010s\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010t\u001a\u00020#2\b\u0010u\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010v\u001a\u00020#2\b\u0010w\u001a\u0004\u0018\u00010\u000fJ \u0010x\u001a\u00020#2\u0006\u0010A\u001a\u00020B2\u000e\b\u0002\u0010y\u001a\b\u0012\u0004\u0012\u00020z0,H\u0007J:\u0010{\u001a\u00020#2\u0006\u0010|\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020\u000f2\u0006\u0010~\u001a\u00020\u000f2\b\u0010\u007f\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001¢\u0006\u0003\u0010\u0082\u0001J\u0016\u0010\u0083\u0001\u001a\u00020#2\u000b\b\u0002\u0010/\u001a\u0005\u0018\u00010\u0084\u0001H\u0007J\u0013\u0010\u0085\u0001\u001a\u00020#2\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0007R*\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u0011\u0010\u0015\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR(\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0005\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\u0089\u0001"}, d2 = {"Lcom/revenuecat/purchases/Purchases;", "Lcom/revenuecat/purchases/LifecycleDelegate;", "purchasesOrchestrator", "Lcom/revenuecat/purchases/PurchasesOrchestrator;", "(Lcom/revenuecat/purchases/PurchasesOrchestrator;)V", "value", "", "allowSharingPlayStoreAccount", "getAllowSharingPlayStoreAccount$annotations", "()V", "getAllowSharingPlayStoreAccount", "()Z", "setAllowSharingPlayStoreAccount", "(Z)V", "appUserID", "", "getAppUserID", "()Ljava/lang/String;", "finishTransactions", "getFinishTransactions", "setFinishTransactions", "isAnonymous", "getPurchasesOrchestrator$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/PurchasesOrchestrator;", ProductResponseJsonKeys.STORE, "Lcom/revenuecat/purchases/Store;", "getStore", "()Lcom/revenuecat/purchases/Store;", "Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;", "updatedCustomerInfoListener", "getUpdatedCustomerInfoListener", "()Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;", "setUpdatedCustomerInfoListener", "(Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;)V", "close", "", "collectDeviceIdentifiers", "getCustomerInfo", "fetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "callback", "Lcom/revenuecat/purchases/interfaces/ReceiveCustomerInfoCallback;", "getNonSubscriptionSkus", "productIds", "", "Lcom/revenuecat/purchases/interfaces/GetStoreProductsCallback;", "getOfferings", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/revenuecat/purchases/interfaces/ReceiveOfferingsCallback;", "getProducts", "type", "Lcom/revenuecat/purchases/ProductType;", "getSubscriptionSkus", "invalidateCustomerInfoCache", "logIn", "newAppUserID", "Lcom/revenuecat/purchases/interfaces/LogInCallback;", "logOut", "onAppBackgrounded", "onAppForegrounded", "purchase", "purchaseParams", "Lcom/revenuecat/purchases/PurchaseParams;", "Lcom/revenuecat/purchases/interfaces/PurchaseCallback;", "purchasePackage", "activity", "Landroid/app/Activity;", "packageToPurchase", "Lcom/revenuecat/purchases/Package;", "upgradeInfo", "Lcom/revenuecat/purchases/UpgradeInfo;", "Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;", "purchaseProduct", "storeProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "removeUpdatedCustomerInfoListener", "restorePurchases", "setAd", "ad", "setAdGroup", "adGroup", "setAdjustID", "adjustID", "setAirshipChannelID", "airshipChannelID", "setAppsflyerID", "appsflyerID", "setAttributes", "attributes", "", "setCampaign", Constants.ScionAnalytics.PARAM_CAMPAIGN, "setCleverTapID", "cleverTapID", "setCreative", "creative", "setDisplayName", "displayName", "setEmail", "email", "setFBAnonymousID", "fbAnonymousID", "setFirebaseAppInstanceID", "firebaseAppInstanceID", "setKeyword", "keyword", "setMediaSource", "mediaSource", "setMixpanelDistinctID", "mixpanelDistinctID", "setMparticleID", "mparticleID", "setOnesignalID", "onesignalID", "setOnesignalUserID", "onesignalUserID", "setPhoneNumber", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "setPushToken", "fcmToken", "showInAppMessagesIfNeeded", "inAppMessageTypes", "Lcom/revenuecat/purchases/models/InAppMessageType;", "syncObserverModeAmazonPurchase", "productID", "receiptID", "amazonUserID", "isoCurrencyCode", b.x, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "syncPurchases", "Lcom/revenuecat/purchases/interfaces/SyncPurchasesCallback;", "track", "paywallEvent", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class Purchases implements LifecycleDelegate {
    private static /* synthetic */ Purchases backingFieldSharedInstance;
    private final PurchasesOrchestrator purchasesOrchestrator;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String frameworkVersion = "7.6.0";

    @JvmStatic
    public static final void canMakePayments(Context context, Callback<Boolean> callback) {
        INSTANCE.canMakePayments(context, callback);
    }

    @JvmStatic
    public static final void canMakePayments(Context context, List<? extends BillingFeature> list, Callback<Boolean> callback) {
        INSTANCE.canMakePayments(context, list, callback);
    }

    @JvmStatic
    public static final Purchases configure(PurchasesConfiguration purchasesConfiguration) {
        return INSTANCE.configure(purchasesConfiguration);
    }

    @Deprecated(message = "Replaced with configuration in the RevenueCat dashboard", replaceWith = @ReplaceWith(expression = "configure through the RevenueCat dashboard", imports = {}))
    public static /* synthetic */ void getAllowSharingPlayStoreAccount$annotations() {
    }

    public static final boolean getDebugLogsEnabled() {
        return INSTANCE.getDebugLogsEnabled();
    }

    public static final String getFrameworkVersion() {
        return INSTANCE.getFrameworkVersion();
    }

    public static final synchronized LogHandler getLogHandler() {
        LogHandler logHandler;
        synchronized (Purchases.class) {
            logHandler = INSTANCE.getLogHandler();
        }
        return logHandler;
    }

    public static final LogLevel getLogLevel() {
        return INSTANCE.getLogLevel();
    }

    public static final PlatformInfo getPlatformInfo() {
        return INSTANCE.getPlatformInfo();
    }

    public static final URL getProxyURL() {
        return INSTANCE.getProxyURL();
    }

    public static final Purchases getSharedInstance() {
        return INSTANCE.getSharedInstance();
    }

    public static final boolean isConfigured() {
        return INSTANCE.isConfigured();
    }

    public static final void setDebugLogsEnabled(boolean z) {
        INSTANCE.setDebugLogsEnabled(z);
    }

    public static final synchronized void setLogHandler(LogHandler logHandler) {
        synchronized (Purchases.class) {
            INSTANCE.setLogHandler(logHandler);
        }
    }

    public static final void setLogLevel(LogLevel logLevel) {
        INSTANCE.setLogLevel(logLevel);
    }

    public static final void setPlatformInfo(PlatformInfo platformInfo) {
        INSTANCE.setPlatformInfo(platformInfo);
    }

    public static final void setProxyURL(URL url) {
        INSTANCE.setProxyURL(url);
    }

    public final void logIn(String newAppUserID) {
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        logIn$default(this, newAppUserID, null, 2, null);
    }

    public final void logOut() {
        logOut$default(this, null, 1, null);
    }

    public final void showInAppMessagesIfNeeded(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        showInAppMessagesIfNeeded$default(this, activity, null, 2, null);
    }

    public final void syncPurchases() {
        syncPurchases$default(this, null, 1, null);
    }

    public Purchases(PurchasesOrchestrator purchasesOrchestrator) {
        Intrinsics.checkNotNullParameter(purchasesOrchestrator, "purchasesOrchestrator");
        this.purchasesOrchestrator = purchasesOrchestrator;
    }

    /* renamed from: getPurchasesOrchestrator$purchases_defaultsRelease, reason: from getter */
    public final /* synthetic */ PurchasesOrchestrator getPurchasesOrchestrator() {
        return this.purchasesOrchestrator;
    }

    public final synchronized boolean getFinishTransactions() {
        return this.purchasesOrchestrator.getFinishTransactions();
    }

    public final synchronized void setFinishTransactions(boolean z) {
        this.purchasesOrchestrator.setFinishTransactions(z);
    }

    public final synchronized String getAppUserID() {
        return this.purchasesOrchestrator.getAppUserID();
    }

    public final synchronized UpdatedCustomerInfoListener getUpdatedCustomerInfoListener() {
        return this.purchasesOrchestrator.getUpdatedCustomerInfoListener();
    }

    public final synchronized void setUpdatedCustomerInfoListener(UpdatedCustomerInfoListener updatedCustomerInfoListener) {
        this.purchasesOrchestrator.setUpdatedCustomerInfoListener(updatedCustomerInfoListener);
    }

    public final boolean isAnonymous() {
        return this.purchasesOrchestrator.isAnonymous();
    }

    public final Store getStore() {
        return this.purchasesOrchestrator.getStore();
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    @Deprecated(message = "Will be removed in next major. Logic has been moved to PurchasesOrchestrator")
    public void onAppBackgrounded() {
        this.purchasesOrchestrator.onAppBackgrounded();
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    @Deprecated(message = "Will be removed in next major. Logic has been moved to PurchasesOrchestrator")
    public void onAppForegrounded() {
        this.purchasesOrchestrator.onAppForegrounded();
    }

    public static /* synthetic */ void syncPurchases$default(Purchases purchases, SyncPurchasesCallback syncPurchasesCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            syncPurchasesCallback = null;
        }
        purchases.syncPurchases(syncPurchasesCallback);
    }

    public final void syncPurchases(SyncPurchasesCallback listener) {
        this.purchasesOrchestrator.syncPurchases(listener);
    }

    public final void syncObserverModeAmazonPurchase(String productID, String receiptID, String amazonUserID, String isoCurrencyCode, Double price) {
        Intrinsics.checkNotNullParameter(productID, "productID");
        Intrinsics.checkNotNullParameter(receiptID, "receiptID");
        Intrinsics.checkNotNullParameter(amazonUserID, "amazonUserID");
        this.purchasesOrchestrator.syncObserverModeAmazonPurchase(productID, receiptID, amazonUserID, isoCurrencyCode, price);
    }

    public final void getOfferings(ReceiveOfferingsCallback listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.purchasesOrchestrator.getOfferings(listener);
    }

    public final void getProducts(List<String> productIds, GetStoreProductsCallback callback) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getProducts(productIds, null, callback);
    }

    public static /* synthetic */ void getProducts$default(Purchases purchases, List list, ProductType productType, GetStoreProductsCallback getStoreProductsCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            productType = null;
        }
        purchases.getProducts(list, productType, getStoreProductsCallback);
    }

    public final void getProducts(List<String> productIds, ProductType type, GetStoreProductsCallback callback) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getProducts(productIds, type, callback);
    }

    public final void purchase(PurchaseParams purchaseParams, PurchaseCallback callback) {
        Intrinsics.checkNotNullParameter(purchaseParams, "purchaseParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.purchase(purchaseParams, callback);
    }

    @Deprecated(message = "Use purchase() and PurchaseParams.Builder instead", replaceWith = @ReplaceWith(expression = "purchase()", imports = {}))
    public final void purchaseProduct(Activity activity, StoreProduct storeProduct, UpgradeInfo upgradeInfo, ProductChangeCallback listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        Intrinsics.checkNotNullParameter(upgradeInfo, "upgradeInfo");
        Intrinsics.checkNotNullParameter(listener, "listener");
        PurchasesOrchestrator purchasesOrchestrator = this.purchasesOrchestrator;
        PurchasingData purchasingData = storeProduct.getPurchasingData();
        String oldSku = upgradeInfo.getOldSku();
        GoogleProrationMode fromPlayBillingClientMode = GoogleProrationMode.INSTANCE.fromPlayBillingClientMode(upgradeInfo.getProrationMode());
        purchasesOrchestrator.startDeprecatedProductChange(activity, purchasingData, null, oldSku, fromPlayBillingClientMode != null ? fromPlayBillingClientMode.getAsGoogleReplacementMode$purchases_defaultsRelease() : null, listener);
    }

    @Deprecated(message = "Use purchase() and PurchaseParams.Builder instead", replaceWith = @ReplaceWith(expression = "purchase()", imports = {}))
    public final void purchaseProduct(Activity activity, StoreProduct storeProduct, PurchaseCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.startPurchase(activity, storeProduct.getPurchasingData(), null, null, callback);
    }

    @Deprecated(message = "Use purchase() and PurchaseParams.Builder instead", replaceWith = @ReplaceWith(expression = "purchase()", imports = {}))
    public final void purchasePackage(Activity activity, Package packageToPurchase, UpgradeInfo upgradeInfo, ProductChangeCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(packageToPurchase, "packageToPurchase");
        Intrinsics.checkNotNullParameter(upgradeInfo, "upgradeInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PurchasesOrchestrator purchasesOrchestrator = this.purchasesOrchestrator;
        PurchasingData purchasingData = packageToPurchase.getProduct().getPurchasingData();
        PresentedOfferingContext presentedOfferingContext = packageToPurchase.getPresentedOfferingContext();
        String oldSku = upgradeInfo.getOldSku();
        GoogleProrationMode fromPlayBillingClientMode = GoogleProrationMode.INSTANCE.fromPlayBillingClientMode(upgradeInfo.getProrationMode());
        purchasesOrchestrator.startDeprecatedProductChange(activity, purchasingData, presentedOfferingContext, oldSku, fromPlayBillingClientMode != null ? fromPlayBillingClientMode.getAsGoogleReplacementMode$purchases_defaultsRelease() : null, callback);
    }

    @Deprecated(message = "Use purchase() and PurchaseParams.Builder instead", replaceWith = @ReplaceWith(expression = "purchase()", imports = {}))
    public final void purchasePackage(Activity activity, Package packageToPurchase, PurchaseCallback listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(packageToPurchase, "packageToPurchase");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.purchasesOrchestrator.startPurchase(activity, packageToPurchase.getProduct().getPurchasingData(), packageToPurchase.getPresentedOfferingContext(), null, listener);
    }

    public final void restorePurchases(ReceiveCustomerInfoCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.restorePurchases(callback);
    }

    public static /* synthetic */ void logIn$default(Purchases purchases, String str, LogInCallback logInCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            logInCallback = null;
        }
        purchases.logIn(str, logInCallback);
    }

    public final void logIn(String newAppUserID, LogInCallback callback) {
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        this.purchasesOrchestrator.logIn(newAppUserID, callback);
    }

    public static /* synthetic */ void logOut$default(Purchases purchases, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            receiveCustomerInfoCallback = null;
        }
        purchases.logOut(receiveCustomerInfoCallback);
    }

    public final void logOut(ReceiveCustomerInfoCallback callback) {
        this.purchasesOrchestrator.logOut(callback);
    }

    public final void close() {
        this.purchasesOrchestrator.close();
    }

    public final void getCustomerInfo(ReceiveCustomerInfoCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getCustomerInfo(CacheFetchPolicy.INSTANCE.m1080default(), callback);
    }

    public final void getCustomerInfo(CacheFetchPolicy fetchPolicy, ReceiveCustomerInfoCallback callback) {
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getCustomerInfo(fetchPolicy, callback);
    }

    public final void removeUpdatedCustomerInfoListener() {
        this.purchasesOrchestrator.removeUpdatedCustomerInfoListener();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showInAppMessagesIfNeeded$default(Purchases purchases, Activity activity, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.listOf(InAppMessageType.BILLING_ISSUES);
        }
        purchases.showInAppMessagesIfNeeded(activity, list);
    }

    public final void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(inAppMessageTypes, "inAppMessageTypes");
        this.purchasesOrchestrator.showInAppMessagesIfNeeded(activity, inAppMessageTypes);
    }

    public final void invalidateCustomerInfoCache() {
        this.purchasesOrchestrator.invalidateCustomerInfoCache();
    }

    public final /* synthetic */ void track(PaywallEvent paywallEvent) {
        Intrinsics.checkNotNullParameter(paywallEvent, "paywallEvent");
        this.purchasesOrchestrator.track(paywallEvent);
    }

    public final void setAttributes(Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.purchasesOrchestrator.setAttributes(attributes);
    }

    public final void setEmail(String email) {
        this.purchasesOrchestrator.setEmail(email);
    }

    public final void setPhoneNumber(String phoneNumber) {
        this.purchasesOrchestrator.setPhoneNumber(phoneNumber);
    }

    public final void setDisplayName(String displayName) {
        this.purchasesOrchestrator.setDisplayName(displayName);
    }

    public final void setPushToken(String fcmToken) {
        this.purchasesOrchestrator.setPushToken(fcmToken);
    }

    public final void setMixpanelDistinctID(String mixpanelDistinctID) {
        this.purchasesOrchestrator.setMixpanelDistinctID(mixpanelDistinctID);
    }

    public final void setOnesignalID(String onesignalID) {
        this.purchasesOrchestrator.setOnesignalID(onesignalID);
    }

    public final void setOnesignalUserID(String onesignalUserID) {
        this.purchasesOrchestrator.setOnesignalUserID(onesignalUserID);
    }

    public final void setAirshipChannelID(String airshipChannelID) {
        this.purchasesOrchestrator.setAirshipChannelID(airshipChannelID);
    }

    public final void setFirebaseAppInstanceID(String firebaseAppInstanceID) {
        this.purchasesOrchestrator.setFirebaseAppInstanceID(firebaseAppInstanceID);
    }

    public final void collectDeviceIdentifiers() {
        this.purchasesOrchestrator.collectDeviceIdentifiers();
    }

    public final void setAdjustID(String adjustID) {
        this.purchasesOrchestrator.setAdjustID(adjustID);
    }

    public final void setAppsflyerID(String appsflyerID) {
        this.purchasesOrchestrator.setAppsflyerID(appsflyerID);
    }

    public final void setFBAnonymousID(String fbAnonymousID) {
        this.purchasesOrchestrator.setFBAnonymousID(fbAnonymousID);
    }

    public final void setMparticleID(String mparticleID) {
        this.purchasesOrchestrator.setMparticleID(mparticleID);
    }

    public final void setCleverTapID(String cleverTapID) {
        this.purchasesOrchestrator.setCleverTapID(cleverTapID);
    }

    public final void setMediaSource(String mediaSource) {
        this.purchasesOrchestrator.setMediaSource(mediaSource);
    }

    public final void setCampaign(String campaign) {
        this.purchasesOrchestrator.setCampaign(campaign);
    }

    public final void setAdGroup(String adGroup) {
        this.purchasesOrchestrator.setAdGroup(adGroup);
    }

    public final void setAd(String ad) {
        this.purchasesOrchestrator.setAd(ad);
    }

    public final void setKeyword(String keyword) {
        this.purchasesOrchestrator.setKeyword(keyword);
    }

    public final void setCreative(String creative) {
        this.purchasesOrchestrator.setCreative(creative);
    }

    public final synchronized boolean getAllowSharingPlayStoreAccount() {
        return this.purchasesOrchestrator.getAllowSharingPlayStoreAccount();
    }

    public final synchronized void setAllowSharingPlayStoreAccount(boolean z) {
        this.purchasesOrchestrator.setAllowSharingPlayStoreAccount(z);
    }

    @Deprecated(message = "Replaced with getProducts() which returns both subscriptions and non-subscriptions", replaceWith = @ReplaceWith(expression = "getProducts()", imports = {}))
    public final void getSubscriptionSkus(List<String> productIds, GetStoreProductsCallback callback) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getProductsOfTypes(CollectionsKt.toSet(productIds), SetsKt.setOf(ProductType.SUBS), callback);
    }

    @Deprecated(message = "Replaced with getProducts() which returns both subscriptions and non-subscriptions", replaceWith = @ReplaceWith(expression = "getProducts()", imports = {}))
    public final void getNonSubscriptionSkus(List<String> productIds, GetStoreProductsCallback callback) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getProductsOfTypes(CollectionsKt.toSet(productIds), SetsKt.setOf(ProductType.INAPP), callback);
    }

    /* compiled from: Purchases.kt */
    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\n0@H\u0007J\u0010\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020CH\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00128\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0016\u0010\u000eR*\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u00188F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\u0002\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010 \u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\u001f8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b!\u0010\u0002\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R*\u0010'\u001a\u00020&2\u0006\u0010\t\u001a\u00020&8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b(\u0010\u0002\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R.\u0010.\u001a\u0004\u0018\u00010-2\b\u0010\t\u001a\u0004\u0018\u00010-8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b/\u0010\u0002\u001a\u0004\b0\u00101\"\u0004\b2\u00103R*\u00104\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@AX\u0087\u000e¢\u0006\u0012\u0012\u0004\b5\u0010\u0002\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\b¨\u0006D"}, d2 = {"Lcom/revenuecat/purchases/Purchases$Companion;", "", "()V", "backingFieldSharedInstance", "Lcom/revenuecat/purchases/Purchases;", "getBackingFieldSharedInstance$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/Purchases;", "setBackingFieldSharedInstance$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/Purchases;)V", "value", "", "debugLogsEnabled", "getDebugLogsEnabled$annotations", "getDebugLogsEnabled", "()Z", "setDebugLogsEnabled", "(Z)V", "frameworkVersion", "", "getFrameworkVersion$annotations", "getFrameworkVersion", "()Ljava/lang/String;", "isConfigured", "isConfigured$annotations", "Lcom/revenuecat/purchases/LogHandler;", "logHandler", "getLogHandler$annotations", "getLogHandler", "()Lcom/revenuecat/purchases/LogHandler;", "setLogHandler", "(Lcom/revenuecat/purchases/LogHandler;)V", "Lcom/revenuecat/purchases/LogLevel;", "logLevel", "getLogLevel$annotations", "getLogLevel", "()Lcom/revenuecat/purchases/LogLevel;", "setLogLevel", "(Lcom/revenuecat/purchases/LogLevel;)V", "Lcom/revenuecat/purchases/common/PlatformInfo;", "platformInfo", "getPlatformInfo$annotations", "getPlatformInfo", "()Lcom/revenuecat/purchases/common/PlatformInfo;", "setPlatformInfo", "(Lcom/revenuecat/purchases/common/PlatformInfo;)V", "Ljava/net/URL;", "proxyURL", "getProxyURL$annotations", "getProxyURL", "()Ljava/net/URL;", "setProxyURL", "(Ljava/net/URL;)V", "sharedInstance", "getSharedInstance$annotations", "getSharedInstance", "setSharedInstance$purchases_defaultsRelease", "canMakePayments", "", "context", "Landroid/content/Context;", "features", "", "Lcom/revenuecat/purchases/models/BillingFeature;", "callback", "Lcom/revenuecat/purchases/interfaces/Callback;", "configure", "configuration", "Lcom/revenuecat/purchases/PurchasesConfiguration;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = "Use logLevel instead")
        @JvmStatic
        public static /* synthetic */ void getDebugLogsEnabled$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getFrameworkVersion$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getLogHandler$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getLogLevel$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getPlatformInfo$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getProxyURL$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getSharedInstance$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void isConfigured$annotations() {
        }

        @JvmStatic
        public final void canMakePayments(Context context, Callback<Boolean> callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callback, "callback");
            canMakePayments$default(this, context, null, callback, 2, null);
        }

        private Companion() {
        }

        public final PlatformInfo getPlatformInfo() {
            return PurchasesOrchestrator.INSTANCE.getPlatformInfo();
        }

        public final void setPlatformInfo(PlatformInfo value) {
            Intrinsics.checkNotNullParameter(value, "value");
            PurchasesOrchestrator.INSTANCE.setPlatformInfo(value);
        }

        public final boolean getDebugLogsEnabled() {
            return PurchasesOrchestrator.INSTANCE.getDebugLogsEnabled();
        }

        public final void setDebugLogsEnabled(boolean z) {
            PurchasesOrchestrator.INSTANCE.setDebugLogsEnabled(z);
        }

        public final LogLevel getLogLevel() {
            return PurchasesOrchestrator.INSTANCE.getLogLevel();
        }

        public final void setLogLevel(LogLevel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            PurchasesOrchestrator.INSTANCE.setLogLevel(value);
        }

        public final synchronized LogHandler getLogHandler() {
            return PurchasesOrchestrator.INSTANCE.getLogHandler();
        }

        public final synchronized void setLogHandler(LogHandler value) {
            Intrinsics.checkNotNullParameter(value, "value");
            PurchasesOrchestrator.INSTANCE.setLogHandler(value);
        }

        public final Purchases getBackingFieldSharedInstance$purchases_defaultsRelease() {
            return Purchases.backingFieldSharedInstance;
        }

        public final void setBackingFieldSharedInstance$purchases_defaultsRelease(Purchases purchases) {
            Purchases.backingFieldSharedInstance = purchases;
        }

        public final Purchases getSharedInstance() {
            Purchases backingFieldSharedInstance$purchases_defaultsRelease = getBackingFieldSharedInstance$purchases_defaultsRelease();
            if (backingFieldSharedInstance$purchases_defaultsRelease != null) {
                return backingFieldSharedInstance$purchases_defaultsRelease;
            }
            throw new UninitializedPropertyAccessException(ConfigureStrings.NO_SINGLETON_INSTANCE);
        }

        public final void setSharedInstance$purchases_defaultsRelease(Purchases value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Purchases backingFieldSharedInstance$purchases_defaultsRelease = getBackingFieldSharedInstance$purchases_defaultsRelease();
            if (backingFieldSharedInstance$purchases_defaultsRelease != null) {
                backingFieldSharedInstance$purchases_defaultsRelease.close();
            }
            setBackingFieldSharedInstance$purchases_defaultsRelease(value);
        }

        public final String getFrameworkVersion() {
            return Purchases.frameworkVersion;
        }

        public final URL getProxyURL() {
            return PurchasesOrchestrator.INSTANCE.getProxyURL();
        }

        public final void setProxyURL(URL url) {
            PurchasesOrchestrator.INSTANCE.setProxyURL(url);
        }

        public final boolean isConfigured() {
            return getBackingFieldSharedInstance$purchases_defaultsRelease() != null;
        }

        @JvmStatic
        public final Purchases configure(PurchasesConfiguration configuration) {
            Purchases createPurchases;
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            if (isConfigured()) {
                LogUtilsKt.infoLog(ConfigureStrings.INSTANCE_ALREADY_EXISTS);
            }
            createPurchases = new PurchasesFactory(null, 1, 0 == true ? 1 : 0).createPurchases(configuration, getPlatformInfo(), getProxyURL(), (r17 & 8) != 0 ? null : null, (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? false : false, (r17 & 64) != 0 ? false : false);
            Purchases.INSTANCE.setSharedInstance$purchases_defaultsRelease(createPurchases);
            return createPurchases;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void canMakePayments$default(Companion companion, Context context, List list, Callback callback, int i, Object obj) {
            if ((i & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            companion.canMakePayments(context, list, callback);
        }

        @JvmStatic
        public final void canMakePayments(Context context, List<? extends BillingFeature> features, Callback<Boolean> callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(features, "features");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (getSharedInstance().getPurchasesOrchestrator().getAppConfig().getStore() != Store.PLAY_STORE) {
                LogWrapperKt.log(LogIntent.RC_ERROR, BillingStrings.CANNOT_CALL_CAN_MAKE_PAYMENTS);
                callback.onReceived(true);
            } else {
                PurchasesOrchestrator.INSTANCE.canMakePayments(context, features, callback);
            }
        }
    }
}
