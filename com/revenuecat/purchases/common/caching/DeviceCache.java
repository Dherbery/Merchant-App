package com.revenuecat.purchases.common.caching;

import android.content.SharedPreferences;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.CustomerInfoFactory;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping;
import com.revenuecat.purchases.interfaces.StorefrontProvider;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import com.revenuecat.purchases.strings.ReceiptStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DeviceCache.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000 f2\u00020\u0001:\u0001fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005J\u0016\u0010-\u001a\u00020)2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020)2\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u00020)2\u0006\u00104\u001a\u000205J\u0014\u00106\u001a\u00020)2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000508J\u0006\u00109\u001a\u00020)J\u000e\u0010:\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005J\u000e\u0010;\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005J\u000e\u0010<\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005J\u0006\u0010=\u001a\u00020)J\u000e\u0010>\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005J\u000e\u0010?\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005J\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\u0005082\u0006\u0010A\u001a\u00020\u0005J \u0010B\u001a\b\u0012\u0004\u0012\u00020D0C2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020D0EJ\b\u0010F\u001a\u0004\u0018\u00010\u0005J\u0010\u0010G\u001a\u0004\u0018\u00010/2\u0006\u0010,\u001a\u00020\u0005J\u0010\u0010H\u001a\u00020I2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0012\u0010J\u001a\u0004\u0018\u0001022\u0006\u0010K\u001a\u00020\u0005H\u0016J\b\u0010L\u001a\u0004\u0018\u00010\u0005J\b\u0010M\u001a\u0004\u0018\u000102J\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u000508J\b\u0010O\u001a\u0004\u0018\u000105J\n\u0010P\u001a\u0004\u0018\u00010IH\u0002J\n\u0010Q\u001a\u0004\u0018\u00010\u0005H\u0016J\u0016\u0010R\u001a\u00020S2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010T\u001a\u00020SJ\u0006\u0010U\u001a\u00020SJ\u000e\u0010V\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u0005J\u0018\u0010W\u001a\u00020)2\u0006\u0010A\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\u0005H\u0016J\u000e\u0010Y\u001a\u00020)2\u0006\u0010A\u001a\u00020\u0005J\u0016\u0010Z\u001a\u00020)2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010[\u001a\u00020IJ\u000e\u0010\\\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005J\u0010\u0010]\u001a\u00020)2\u0006\u0010[\u001a\u00020IH\u0002J\u0006\u0010^\u001a\u00020)J\u0016\u0010_\u001a\u00020)2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u000508H\u0002J\u000e\u0010a\u001a\u00020)2\u0006\u0010b\u001a\u00020\u0005J\f\u0010c\u001a\u00020d*\u00020dH\u0002J\f\u0010e\u001a\u00020d*\u00020dH\u0002J\u0014\u0010<\u001a\u00020d*\u00020d2\u0006\u0010,\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u001b\u0010\u0013\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0014\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0017\u0010\u000bR\u001b\u0010\u0019\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001a\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001d\u0010\u000bR\u001b\u0010\u001f\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b \u0010\u000bR\u001b\u0010\"\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\r\u001a\u0004\b#\u0010\u000bR\u001b\u0010%\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b&\u0010\u000b¨\u0006g"}, d2 = {"Lcom/revenuecat/purchases/common/caching/DeviceCache;", "Lcom/revenuecat/purchases/interfaces/StorefrontProvider;", "preferences", "Landroid/content/SharedPreferences;", "apiKey", "", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Landroid/content/SharedPreferences;Ljava/lang/String;Lcom/revenuecat/purchases/common/DateProvider;)V", "apiKeyPrefix", "getApiKeyPrefix", "()Ljava/lang/String;", "apiKeyPrefix$delegate", "Lkotlin/Lazy;", "appUserIDCacheKey", "getAppUserIDCacheKey", "appUserIDCacheKey$delegate", "attributionCacheKey", "getAttributionCacheKey$purchases_defaultsRelease", "customerInfoCachesLastUpdatedCacheBaseKey", "getCustomerInfoCachesLastUpdatedCacheBaseKey", "customerInfoCachesLastUpdatedCacheBaseKey$delegate", "legacyAppUserIDCacheKey", "getLegacyAppUserIDCacheKey", "legacyAppUserIDCacheKey$delegate", "offeringsResponseCacheKey", "getOfferingsResponseCacheKey", "offeringsResponseCacheKey$delegate", "productEntitlementMappingCacheKey", "getProductEntitlementMappingCacheKey", "productEntitlementMappingCacheKey$delegate", "productEntitlementMappingLastUpdatedCacheKey", "getProductEntitlementMappingLastUpdatedCacheKey", "productEntitlementMappingLastUpdatedCacheKey$delegate", "storefrontCacheKey", "getStorefrontCacheKey", "storefrontCacheKey$delegate", "tokensCacheKey", "getTokensCacheKey", "tokensCacheKey$delegate", "addSuccessfullyPostedToken", "", "token", "cacheAppUserID", "appUserID", "cacheCustomerInfo", "info", "Lcom/revenuecat/purchases/CustomerInfo;", "cacheOfferingsResponse", "offeringsResponse", "Lorg/json/JSONObject;", "cacheProductEntitlementMapping", "productEntitlementMapping", "Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;", "cleanPreviouslySentTokens", "hashedTokens", "", "cleanupOldAttributionData", "clearCachesForAppUserID", "clearCustomerInfoCache", "clearCustomerInfoCacheTimestamp", "clearOfferingsResponseCache", "customerInfoCacheKey", "customerInfoLastUpdatedCacheKey", "findKeysThatStartWith", "cacheKey", "getActivePurchasesNotInCache", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "", "getCachedAppUserID", "getCachedCustomerInfo", "getCustomerInfoCachesLastUpdated", "Ljava/util/Date;", "getJSONObjectOrNull", SubscriberAttributeKt.JSON_NAME_KEY, "getLegacyCachedAppUserID", "getOfferingsResponseCache", "getPreviouslySentHashedTokens", "getProductEntitlementMapping", "getProductEntitlementMappingLastUpdated", "getStorefront", "isCustomerInfoCacheStale", "", "appInBackground", "isProductEntitlementMappingCacheStale", "newKey", "putString", "value", "remove", "setCustomerInfoCacheTimestamp", "date", "setCustomerInfoCacheTimestampToNow", "setProductEntitlementMappingCacheTimestamp", "setProductEntitlementMappingCacheTimestampToNow", "setSavedTokenHashes", "newSet", "setStorefront", "countryCode", "clearAppUserID", "Landroid/content/SharedPreferences$Editor;", "clearCustomerInfo", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public class DeviceCache implements StorefrontProvider {
    private static final String CUSTOMER_INFO_REQUEST_DATE_KEY = "customer_info_request_date";
    private static final String CUSTOMER_INFO_SCHEMA_VERSION_KEY = "schema_version";
    private static final String CUSTOMER_INFO_VERIFICATION_RESULT_KEY = "verification_result";
    private final String apiKey;

    /* renamed from: apiKeyPrefix$delegate, reason: from kotlin metadata */
    private final Lazy apiKeyPrefix;

    /* renamed from: appUserIDCacheKey$delegate, reason: from kotlin metadata */
    private final Lazy appUserIDCacheKey;
    private final String attributionCacheKey;

    /* renamed from: customerInfoCachesLastUpdatedCacheBaseKey$delegate, reason: from kotlin metadata */
    private final Lazy customerInfoCachesLastUpdatedCacheBaseKey;
    private final DateProvider dateProvider;

    /* renamed from: legacyAppUserIDCacheKey$delegate, reason: from kotlin metadata */
    private final Lazy legacyAppUserIDCacheKey;

    /* renamed from: offeringsResponseCacheKey$delegate, reason: from kotlin metadata */
    private final Lazy offeringsResponseCacheKey;
    private final SharedPreferences preferences;

    /* renamed from: productEntitlementMappingCacheKey$delegate, reason: from kotlin metadata */
    private final Lazy productEntitlementMappingCacheKey;

    /* renamed from: productEntitlementMappingLastUpdatedCacheKey$delegate, reason: from kotlin metadata */
    private final Lazy productEntitlementMappingLastUpdatedCacheKey;

    /* renamed from: storefrontCacheKey$delegate, reason: from kotlin metadata */
    private final Lazy storefrontCacheKey;

    /* renamed from: tokensCacheKey$delegate, reason: from kotlin metadata */
    private final Lazy tokensCacheKey;

    public DeviceCache(SharedPreferences preferences, String apiKey, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.preferences = preferences;
        this.apiKey = apiKey;
        this.dateProvider = dateProvider;
        this.apiKeyPrefix = LazyKt.lazy(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$apiKeyPrefix$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str;
                StringBuilder sb = new StringBuilder("com.revenuecat.purchases.");
                str = DeviceCache.this.apiKey;
                sb.append(str);
                return sb.toString();
            }
        });
        this.legacyAppUserIDCacheKey = LazyKt.lazy(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$legacyAppUserIDCacheKey$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String apiKeyPrefix;
                apiKeyPrefix = DeviceCache.this.getApiKeyPrefix();
                return apiKeyPrefix;
            }
        });
        this.appUserIDCacheKey = LazyKt.lazy(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$appUserIDCacheKey$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String apiKeyPrefix;
                StringBuilder sb = new StringBuilder();
                apiKeyPrefix = DeviceCache.this.getApiKeyPrefix();
                sb.append(apiKeyPrefix);
                sb.append(".new");
                return sb.toString();
            }
        });
        this.attributionCacheKey = "com.revenuecat.purchases..attribution";
        this.tokensCacheKey = LazyKt.lazy(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$tokensCacheKey$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String apiKeyPrefix;
                StringBuilder sb = new StringBuilder();
                apiKeyPrefix = DeviceCache.this.getApiKeyPrefix();
                sb.append(apiKeyPrefix);
                sb.append(".tokens");
                return sb.toString();
            }
        });
        this.storefrontCacheKey = LazyKt.lazy(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$storefrontCacheKey$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "storefrontCacheKey";
            }
        });
        this.productEntitlementMappingCacheKey = LazyKt.lazy(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$productEntitlementMappingCacheKey$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String apiKeyPrefix;
                StringBuilder sb = new StringBuilder();
                apiKeyPrefix = DeviceCache.this.getApiKeyPrefix();
                sb.append(apiKeyPrefix);
                sb.append(".productEntitlementMapping");
                return sb.toString();
            }
        });
        this.productEntitlementMappingLastUpdatedCacheKey = LazyKt.lazy(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$productEntitlementMappingLastUpdatedCacheKey$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String apiKeyPrefix;
                StringBuilder sb = new StringBuilder();
                apiKeyPrefix = DeviceCache.this.getApiKeyPrefix();
                sb.append(apiKeyPrefix);
                sb.append(".productEntitlementMappingLastUpdated");
                return sb.toString();
            }
        });
        this.customerInfoCachesLastUpdatedCacheBaseKey = LazyKt.lazy(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$customerInfoCachesLastUpdatedCacheBaseKey$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String apiKeyPrefix;
                StringBuilder sb = new StringBuilder();
                apiKeyPrefix = DeviceCache.this.getApiKeyPrefix();
                sb.append(apiKeyPrefix);
                sb.append(".purchaserInfoLastUpdated");
                return sb.toString();
            }
        });
        this.offeringsResponseCacheKey = LazyKt.lazy(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$offeringsResponseCacheKey$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String apiKeyPrefix;
                StringBuilder sb = new StringBuilder();
                apiKeyPrefix = DeviceCache.this.getApiKeyPrefix();
                sb.append(apiKeyPrefix);
                sb.append(".offeringsResponse");
                return sb.toString();
            }
        });
    }

    public /* synthetic */ DeviceCache(SharedPreferences sharedPreferences, String str, DefaultDateProvider defaultDateProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences, str, (i & 4) != 0 ? new DefaultDateProvider() : defaultDateProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getApiKeyPrefix() {
        return (String) this.apiKeyPrefix.getValue();
    }

    public final String getLegacyAppUserIDCacheKey() {
        return (String) this.legacyAppUserIDCacheKey.getValue();
    }

    public final String getAppUserIDCacheKey() {
        return (String) this.appUserIDCacheKey.getValue();
    }

    /* renamed from: getAttributionCacheKey$purchases_defaultsRelease, reason: from getter */
    public final String getAttributionCacheKey() {
        return this.attributionCacheKey;
    }

    public final String getTokensCacheKey() {
        return (String) this.tokensCacheKey.getValue();
    }

    public final String getStorefrontCacheKey() {
        return (String) this.storefrontCacheKey.getValue();
    }

    private final String getProductEntitlementMappingCacheKey() {
        return (String) this.productEntitlementMappingCacheKey.getValue();
    }

    private final String getProductEntitlementMappingLastUpdatedCacheKey() {
        return (String) this.productEntitlementMappingLastUpdatedCacheKey.getValue();
    }

    private final String getCustomerInfoCachesLastUpdatedCacheBaseKey() {
        return (String) this.customerInfoCachesLastUpdatedCacheBaseKey.getValue();
    }

    private final String getOfferingsResponseCacheKey() {
        return (String) this.offeringsResponseCacheKey.getValue();
    }

    public final synchronized String getLegacyCachedAppUserID() {
        return this.preferences.getString(getLegacyAppUserIDCacheKey(), null);
    }

    public final synchronized String getCachedAppUserID() {
        return this.preferences.getString(getAppUserIDCacheKey(), null);
    }

    public final synchronized void cacheAppUserID(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        this.preferences.edit().putString(getAppUserIDCacheKey(), appUserID).apply();
    }

    public final synchronized void clearCachesForAppUserID(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        SharedPreferences.Editor edit = this.preferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "preferences.edit()");
        clearCustomerInfoCacheTimestamp(clearAppUserID(clearCustomerInfo(edit)), appUserID).apply();
    }

    private final SharedPreferences.Editor clearCustomerInfo(SharedPreferences.Editor editor) {
        String cachedAppUserID = getCachedAppUserID();
        if (cachedAppUserID != null) {
            editor.remove(customerInfoCacheKey(cachedAppUserID));
        }
        String legacyCachedAppUserID = getLegacyCachedAppUserID();
        if (legacyCachedAppUserID != null) {
            editor.remove(customerInfoCacheKey(legacyCachedAppUserID));
        }
        return editor;
    }

    private final SharedPreferences.Editor clearAppUserID(SharedPreferences.Editor editor) {
        editor.remove(getAppUserIDCacheKey());
        editor.remove(getLegacyAppUserIDCacheKey());
        return editor;
    }

    private final SharedPreferences.Editor clearCustomerInfoCacheTimestamp(SharedPreferences.Editor editor, String str) {
        editor.remove(customerInfoLastUpdatedCacheKey(str));
        return editor;
    }

    public final String customerInfoCacheKey(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        return getLegacyAppUserIDCacheKey() + '.' + appUserID;
    }

    public final String customerInfoLastUpdatedCacheKey(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        return getCustomerInfoCachesLastUpdatedCacheBaseKey() + '.' + appUserID;
    }

    public final CustomerInfo getCachedCustomerInfo(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        String string = this.preferences.getString(customerInfoCacheKey(appUserID), null);
        if (string == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            int optInt = jSONObject.optInt(CUSTOMER_INFO_SCHEMA_VERSION_KEY);
            String verificationResultString = jSONObject.has("verification_result") ? jSONObject.getString("verification_result") : "NOT_REQUESTED";
            Long valueOf = Long.valueOf(jSONObject.optLong(CUSTOMER_INFO_REQUEST_DATE_KEY));
            if (!(valueOf.longValue() > 0)) {
                valueOf = null;
            }
            Date date = valueOf != null ? new Date(valueOf.longValue()) : null;
            jSONObject.remove("verification_result");
            jSONObject.remove(CUSTOMER_INFO_REQUEST_DATE_KEY);
            Intrinsics.checkNotNullExpressionValue(verificationResultString, "verificationResultString");
            VerificationResult valueOf2 = VerificationResult.valueOf(verificationResultString);
            if (optInt == 3) {
                return CustomerInfoFactory.INSTANCE.buildCustomerInfo(jSONObject, date, valueOf2);
            }
            return null;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final synchronized void cacheCustomerInfo(String appUserID, CustomerInfo info) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(info, "info");
        JSONObject rawData = info.getRawData();
        rawData.put(CUSTOMER_INFO_SCHEMA_VERSION_KEY, 3);
        rawData.put("verification_result", info.getEntitlements().getVerification().name());
        rawData.put(CUSTOMER_INFO_REQUEST_DATE_KEY, info.getRequestDate().getTime());
        this.preferences.edit().putString(customerInfoCacheKey(appUserID), rawData.toString()).apply();
        setCustomerInfoCacheTimestampToNow(appUserID);
    }

    public final synchronized boolean isCustomerInfoCacheStale(String appUserID, boolean appInBackground) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        return DateExtensionsKt.isCacheStale(getCustomerInfoCachesLastUpdated(appUserID), appInBackground, this.dateProvider);
    }

    public final synchronized void clearCustomerInfoCacheTimestamp(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        SharedPreferences.Editor edit = this.preferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "preferences.edit()");
        clearCustomerInfoCacheTimestamp(edit, appUserID).apply();
    }

    public final synchronized void clearCustomerInfoCache(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        SharedPreferences.Editor editor = this.preferences.edit();
        Intrinsics.checkNotNullExpressionValue(editor, "editor");
        clearCustomerInfoCacheTimestamp(editor, appUserID);
        editor.remove(customerInfoCacheKey(appUserID));
        editor.apply();
    }

    public final synchronized void setCustomerInfoCacheTimestampToNow(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        setCustomerInfoCacheTimestamp(appUserID, this.dateProvider.getNow());
    }

    public final synchronized void setCustomerInfoCacheTimestamp(String appUserID, Date date) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(date, "date");
        this.preferences.edit().putLong(customerInfoLastUpdatedCacheKey(appUserID), date.getTime()).apply();
    }

    public final synchronized void setStorefront(String countryCode) {
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        String format = String.format(BillingStrings.BILLING_STOREFRONT_CACHING, Arrays.copyOf(new Object[]{countryCode}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogUtilsKt.verboseLog(format);
        this.preferences.edit().putString(getStorefrontCacheKey(), countryCode).apply();
    }

    @Override // com.revenuecat.purchases.interfaces.StorefrontProvider
    public synchronized String getStorefront() {
        String string;
        string = this.preferences.getString(getStorefrontCacheKey(), null);
        if (string == null) {
            LogUtilsKt.debugLog(BillingStrings.BILLING_STOREFRONT_NULL_FROM_CACHE);
        }
        return string;
    }

    private final synchronized Date getCustomerInfoCachesLastUpdated(String appUserID) {
        return new Date(this.preferences.getLong(customerInfoLastUpdatedCacheKey(appUserID), 0L));
    }

    public final synchronized void cleanupOldAttributionData() {
        SharedPreferences.Editor edit = this.preferences.edit();
        for (String str : this.preferences.getAll().keySet()) {
            if (str != null && StringsKt.startsWith$default(str, this.attributionCacheKey, false, 2, (Object) null)) {
                edit.remove(str);
            }
        }
        edit.apply();
    }

    public final synchronized Set<String> getPreviouslySentHashedTokens() {
        Set<String> emptySet;
        try {
            Set<String> stringSet = this.preferences.getStringSet(getTokensCacheKey(), SetsKt.emptySet());
            if (stringSet == null || (emptySet = CollectionsKt.toSet(stringSet)) == null) {
                emptySet = SetsKt.emptySet();
            }
            LogIntent logIntent = LogIntent.DEBUG;
            String format = String.format(ReceiptStrings.TOKENS_ALREADY_POSTED, Arrays.copyOf(new Object[]{emptySet}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
        } catch (ClassCastException unused) {
            emptySet = SetsKt.emptySet();
        }
        return emptySet;
    }

    public final synchronized void addSuccessfullyPostedToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(ReceiptStrings.SAVING_TOKENS_WITH_HASH, Arrays.copyOf(new Object[]{token, UtilsKt.sha1(token)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        Set<String> previouslySentHashedTokens = getPreviouslySentHashedTokens();
        LogIntent logIntent2 = LogIntent.DEBUG;
        String format2 = String.format(ReceiptStrings.TOKENS_IN_CACHE, Arrays.copyOf(new Object[]{previouslySentHashedTokens}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
        LogWrapperKt.log(logIntent2, format2);
        Set<String> mutableSet = CollectionsKt.toMutableSet(previouslySentHashedTokens);
        mutableSet.add(UtilsKt.sha1(token));
        setSavedTokenHashes(mutableSet);
    }

    private final synchronized void setSavedTokenHashes(Set<String> newSet) {
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(ReceiptStrings.SAVING_TOKENS, Arrays.copyOf(new Object[]{newSet}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.preferences.edit().putStringSet(getTokensCacheKey(), newSet).apply();
    }

    public final synchronized void cleanPreviouslySentTokens(Set<String> hashedTokens) {
        Intrinsics.checkNotNullParameter(hashedTokens, "hashedTokens");
        LogWrapperKt.log(LogIntent.DEBUG, ReceiptStrings.CLEANING_PREV_SENT_HASHED_TOKEN);
        setSavedTokenHashes(CollectionsKt.intersect(hashedTokens, getPreviouslySentHashedTokens()));
    }

    public final synchronized List<StoreTransaction> getActivePurchasesNotInCache(Map<String, StoreTransaction> hashedTokens) {
        Intrinsics.checkNotNullParameter(hashedTokens, "hashedTokens");
        return CollectionsKt.toList(MapsKt.minus((Map) hashedTokens, (Iterable) getPreviouslySentHashedTokens()).values());
    }

    public final synchronized JSONObject getOfferingsResponseCache() {
        return getJSONObjectOrNull(getOfferingsResponseCacheKey());
    }

    public final synchronized void cacheOfferingsResponse(JSONObject offeringsResponse) {
        Intrinsics.checkNotNullParameter(offeringsResponse, "offeringsResponse");
        this.preferences.edit().putString(getOfferingsResponseCacheKey(), offeringsResponse.toString()).apply();
    }

    public final synchronized void clearOfferingsResponseCache() {
        this.preferences.edit().remove(getOfferingsResponseCacheKey()).apply();
    }

    public final synchronized void cacheProductEntitlementMapping(ProductEntitlementMapping productEntitlementMapping) {
        Intrinsics.checkNotNullParameter(productEntitlementMapping, "productEntitlementMapping");
        this.preferences.edit().putString(getProductEntitlementMappingCacheKey(), productEntitlementMapping.toJson().toString()).apply();
        setProductEntitlementMappingCacheTimestampToNow();
    }

    public final synchronized void setProductEntitlementMappingCacheTimestampToNow() {
        setProductEntitlementMappingCacheTimestamp(this.dateProvider.getNow());
    }

    private final void setProductEntitlementMappingCacheTimestamp(Date date) {
        this.preferences.edit().putLong(getProductEntitlementMappingLastUpdatedCacheKey(), date.getTime()).apply();
    }

    public final synchronized boolean isProductEntitlementMappingCacheStale() {
        Date productEntitlementMappingLastUpdated;
        long j;
        productEntitlementMappingLastUpdated = getProductEntitlementMappingLastUpdated();
        j = DeviceCacheKt.PRODUCT_ENTITLEMENT_MAPPING_CACHE_REFRESH_PERIOD;
        return DateExtensionsKt.m1089isCacheStale8Mi8wO0(productEntitlementMappingLastUpdated, j, this.dateProvider);
    }

    public final synchronized ProductEntitlementMapping getProductEntitlementMapping() {
        ProductEntitlementMapping productEntitlementMapping = null;
        String string = this.preferences.getString(getProductEntitlementMappingCacheKey(), null);
        if (string == null) {
            return null;
        }
        try {
            productEntitlementMapping = ProductEntitlementMapping.INSTANCE.fromJson(new JSONObject(string));
        } catch (JSONException e) {
            String format = String.format(OfflineEntitlementsStrings.ERROR_PARSING_PRODUCT_ENTITLEMENT_MAPPING, Arrays.copyOf(new Object[]{string}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogUtilsKt.errorLog(format, e);
            this.preferences.edit().remove(getProductEntitlementMappingCacheKey()).apply();
        }
        return productEntitlementMapping;
    }

    private final Date getProductEntitlementMappingLastUpdated() {
        if (this.preferences.contains(getProductEntitlementMappingLastUpdatedCacheKey())) {
            return new Date(this.preferences.getLong(getProductEntitlementMappingLastUpdatedCacheKey(), -1L));
        }
        return null;
    }

    public JSONObject getJSONObjectOrNull(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String string = this.preferences.getString(key, null);
        if (string == null) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException unused) {
            return null;
        }
    }

    public void putString(String cacheKey, String value) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        Intrinsics.checkNotNullParameter(value, "value");
        this.preferences.edit().putString(cacheKey, value).apply();
    }

    public final void remove(String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        this.preferences.edit().remove(cacheKey).apply();
    }

    public final Set<String> findKeysThatStartWith(String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        try {
            Map<String, ?> all = this.preferences.getAll();
            if (all != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    String it = entry.getKey();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (StringsKt.startsWith$default(it, cacheKey, false, 2, (Object) null)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                Set<String> keySet = linkedHashMap.keySet();
                if (keySet != null) {
                    return keySet;
                }
            }
            return SetsKt.emptySet();
        } catch (NullPointerException unused) {
            return SetsKt.emptySet();
        }
    }

    public final String newKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getApiKeyPrefix() + '.' + key;
    }
}
