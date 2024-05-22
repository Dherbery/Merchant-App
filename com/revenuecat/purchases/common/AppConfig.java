package com.revenuecat.purchases.common;

import android.content.Context;
import com.revenuecat.purchases.DangerousSettings;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.strings.ConfigureStrings;
import java.net.URL;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppConfig.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 ;2\u00020\u0001:\u0001;B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0012J\u0013\u00106\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020&H\u0016R\u0011\u0010\u0013\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u001a\u0010\u001d\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010 R\u001c\u0010\u0010\u001a\u00020\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010 R\u001c\u0010\u0011\u001a\u00020\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010 R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010-\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0013\u0010/\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b5\u0010(¨\u0006<"}, d2 = {"Lcom/revenuecat/purchases/common/AppConfig;", "", "context", "Landroid/content/Context;", "observerMode", "", "showInAppMessagesAutomatically", "platformInfo", "Lcom/revenuecat/purchases/common/PlatformInfo;", "proxyURL", "Ljava/net/URL;", ProductResponseJsonKeys.STORE, "Lcom/revenuecat/purchases/Store;", "dangerousSettings", "Lcom/revenuecat/purchases/DangerousSettings;", "runningTests", "forceServerErrors", "forceSigningErrors", "(Landroid/content/Context;ZZLcom/revenuecat/purchases/common/PlatformInfo;Ljava/net/URL;Lcom/revenuecat/purchases/Store;Lcom/revenuecat/purchases/DangerousSettings;ZZZ)V", "baseURL", "getBaseURL", "()Ljava/net/URL;", "customEntitlementComputation", "getCustomEntitlementComputation", "()Z", "getDangerousSettings", "()Lcom/revenuecat/purchases/DangerousSettings;", "enableOfflineEntitlements", "getEnableOfflineEntitlements", "finishTransactions", "getFinishTransactions", "setFinishTransactions", "(Z)V", "getForceServerErrors", "setForceServerErrors", "getForceSigningErrors", "setForceSigningErrors", "languageTag", "", "getLanguageTag", "()Ljava/lang/String;", "packageName", "getPackageName", "getPlatformInfo", "()Lcom/revenuecat/purchases/common/PlatformInfo;", "playServicesVersionName", "getPlayServicesVersionName", "playStoreVersionName", "getPlayStoreVersionName", "getShowInAppMessagesAutomatically", "getStore", "()Lcom/revenuecat/purchases/Store;", "versionName", "getVersionName", "equals", "other", "hashCode", "", "toString", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class AppConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final URL diagnosticsURL = new URL("https://api-diagnostics.revenuecat.com/");
    private static final URL paywallEventsURL = new URL("https://api-paywalls.revenuecat.com/");
    private final URL baseURL;
    private final DangerousSettings dangerousSettings;
    private final boolean enableOfflineEntitlements;
    private boolean finishTransactions;
    private boolean forceServerErrors;
    private boolean forceSigningErrors;
    private final String languageTag;
    private final String packageName;
    private final PlatformInfo platformInfo;
    private final String playServicesVersionName;
    private final String playStoreVersionName;
    private final boolean runningTests;
    private final boolean showInAppMessagesAutomatically;
    private final Store store;
    private final String versionName;

    public AppConfig(Context context, boolean z, boolean z2, PlatformInfo platformInfo, URL url, Store store, DangerousSettings dangerousSettings, boolean z3, boolean z4, boolean z5) {
        String bcp47;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(platformInfo, "platformInfo");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(dangerousSettings, "dangerousSettings");
        this.showInAppMessagesAutomatically = z2;
        this.platformInfo = platformInfo;
        this.store = store;
        this.dangerousSettings = dangerousSettings;
        this.runningTests = z3;
        this.forceServerErrors = z4;
        this.forceSigningErrors = z5;
        this.enableOfflineEntitlements = true;
        Locale locale = UtilsKt.getLocale(context);
        this.languageTag = (locale == null || (bcp47 = UtilsKt.toBCP47(locale)) == null) ? "" : bcp47;
        String versionName = UtilsKt.getVersionName(context);
        this.versionName = versionName != null ? versionName : "";
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        this.packageName = packageName;
        this.finishTransactions = !z;
        if (url != null) {
            LogWrapperKt.log(LogIntent.INFO, ConfigureStrings.CONFIGURING_PURCHASES_PROXY_URL_SET);
        } else {
            url = new URL("https://api.revenuecat.com/");
        }
        this.baseURL = url;
        this.playStoreVersionName = UtilsKt.getPlayStoreVersionName(context);
        this.playServicesVersionName = UtilsKt.getPlayServicesVersionName(context);
    }

    public final boolean getShowInAppMessagesAutomatically() {
        return this.showInAppMessagesAutomatically;
    }

    public final PlatformInfo getPlatformInfo() {
        return this.platformInfo;
    }

    public final Store getStore() {
        return this.store;
    }

    public /* synthetic */ AppConfig(Context context, boolean z, boolean z2, PlatformInfo platformInfo, URL url, Store store, DangerousSettings dangerousSettings, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, z, z2, platformInfo, url, store, (i & 64) != 0 ? new DangerousSettings(true) : dangerousSettings, (i & 128) != 0 ? false : z3, (i & 256) != 0 ? false : z4, (i & 512) != 0 ? false : z5);
    }

    public final DangerousSettings getDangerousSettings() {
        return this.dangerousSettings;
    }

    /* compiled from: AppConfig.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/common/AppConfig$Companion;", "", "()V", "diagnosticsURL", "Ljava/net/URL;", "getDiagnosticsURL", "()Ljava/net/URL;", "paywallEventsURL", "getPaywallEventsURL", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final URL getDiagnosticsURL() {
            return AppConfig.diagnosticsURL;
        }

        public final URL getPaywallEventsURL() {
            return AppConfig.paywallEventsURL;
        }
    }

    public final void setForceServerErrors(boolean z) {
        this.forceServerErrors = z;
    }

    public final boolean getForceServerErrors() {
        return this.runningTests && this.forceServerErrors;
    }

    public final void setForceSigningErrors(boolean z) {
        this.forceSigningErrors = z;
    }

    public final boolean getForceSigningErrors() {
        return this.runningTests && this.forceSigningErrors;
    }

    public final boolean getEnableOfflineEntitlements() {
        return this.enableOfflineEntitlements;
    }

    public final String getLanguageTag() {
        return this.languageTag;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final boolean getFinishTransactions() {
        return this.finishTransactions;
    }

    public final void setFinishTransactions(boolean z) {
        this.finishTransactions = z;
    }

    public final URL getBaseURL() {
        return this.baseURL;
    }

    public final boolean getCustomEntitlementComputation() {
        return this.dangerousSettings.getCustomEntitlementComputation$purchases_defaultsRelease();
    }

    public final String getPlayStoreVersionName() {
        return this.playStoreVersionName;
    }

    public final String getPlayServicesVersionName() {
        return this.playServicesVersionName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.revenuecat.purchases.common.AppConfig");
        AppConfig appConfig = (AppConfig) other;
        return Intrinsics.areEqual(this.platformInfo, appConfig.platformInfo) && this.store == appConfig.store && Intrinsics.areEqual(this.dangerousSettings, appConfig.dangerousSettings) && Intrinsics.areEqual(this.languageTag, appConfig.languageTag) && Intrinsics.areEqual(this.versionName, appConfig.versionName) && Intrinsics.areEqual(this.packageName, appConfig.packageName) && this.finishTransactions == appConfig.finishTransactions && getForceServerErrors() == appConfig.getForceServerErrors() && getForceSigningErrors() == appConfig.getForceSigningErrors() && Intrinsics.areEqual(this.baseURL, appConfig.baseURL) && this.showInAppMessagesAutomatically == appConfig.showInAppMessagesAutomatically;
    }

    public int hashCode() {
        return (((((((((((((((((((this.platformInfo.hashCode() * 31) + this.store.hashCode()) * 31) + this.dangerousSettings.hashCode()) * 31) + this.languageTag.hashCode()) * 31) + this.versionName.hashCode()) * 31) + this.packageName.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.finishTransactions)) * 31) + UByte$$ExternalSyntheticBackport0.m(getForceServerErrors())) * 31) + UByte$$ExternalSyntheticBackport0.m(getForceSigningErrors())) * 31) + this.baseURL.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.showInAppMessagesAutomatically);
    }

    public String toString() {
        return "AppConfig(platformInfo=" + this.platformInfo + ", store=" + this.store + ", dangerousSettings=" + this.dangerousSettings + ", languageTag='" + this.languageTag + "', versionName='" + this.versionName + "', packageName='" + this.packageName + "', finishTransactions=" + this.finishTransactions + ", showInAppMessagesAutomatically=" + this.showInAppMessagesAutomatically + ", baseURL=" + this.baseURL + ')';
    }
}
