package com.revenuecat.purchases.strings;

import kotlin.Metadata;

/* compiled from: ConfigureStrings.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/strings/ConfigureStrings;", "", "()V", "AMAZON_API_KEY_GOOGLE_STORE", "", "APP_BACKGROUNDED", "APP_FOREGROUNDED", "AUTO_SYNC_PURCHASES_DISABLED", "CONFIGURING_PURCHASES_PROXY_URL_SET", "DEBUG_ENABLED", "GOOGLE_API_KEY_AMAZON_STORE", "INITIAL_APP_USER_ID", "INSTANCE_ALREADY_EXISTS", "INVALID_API_KEY", "LEGACY_API_KEY", "LISTENER_SET", "NO_SINGLETON_INSTANCE", "PACKAGE_NAME", "SDK_VERSION", "VERIFICATION_MODE_SELECTED", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ConfigureStrings {
    public static final String AMAZON_API_KEY_GOOGLE_STORE = "Looks like you're using an Amazon API key but have configured the SDK for the Google play store.\nEither use a Google API key which should look like 'goog_1a2b3c4d5e6f7h' or configure the SDK to use Amazon.\nSee https://rev.cat/auth for more details.";
    public static final String APP_BACKGROUNDED = "App backgrounded";
    public static final String APP_FOREGROUNDED = "App foregrounded";
    public static final String AUTO_SYNC_PURCHASES_DISABLED = "Automatic syncing of purchases has been disabled. \nRevenueCat won’t observe the StoreKit queue, and it will not sync any purchase \nautomatically. Call syncPurchases whenever a new transaction is completed so the \nreceipt is sent to RevenueCat’s backend. Consumables disappear from the receipt \nafter the transaction is finished, so make sure purchases are synced before \nfinishing any consumable transaction, otherwise RevenueCat won’t register the \npurchase.";
    public static final String CONFIGURING_PURCHASES_PROXY_URL_SET = "Purchases is being configured using a proxy for RevenueCat";
    public static final String DEBUG_ENABLED = "Debug logging enabled";
    public static final String GOOGLE_API_KEY_AMAZON_STORE = "Looks like you're using a Google API key but have configured the SDK for the Amazon app store.\nEither use an Amazon API key which should look like 'amzn_1a2b3c4d5e6f7h' or configure the SDK to use Google.\nSee https://rev.cat/auth for more details.";
    public static final String INITIAL_APP_USER_ID = "Initial App User ID - %s";
    public static final ConfigureStrings INSTANCE = new ConfigureStrings();
    public static final String INSTANCE_ALREADY_EXISTS = "Purchases instance already set. Did you mean to configure two Purchases objects?";
    public static final String INVALID_API_KEY = "The specified API Key is not recognized.\nEnsure that you are using the public app-specific API key, which should look like 'goog_1a2b3c4d5e6f7h' or 'amzn_1a2b3c4d5e6f7h'.\nSee https://rev.cat/auth for more details.";
    public static final String LEGACY_API_KEY = "Looks like you're using a legacy API key.\nThis is still supported, but it's recommended to migrate to using platform-specific API key, which should look like 'goog_1a2b3c4d5e6f7h' or 'amzn_1a2b3c4d5e6f7h'.\nSee https://rev.cat/auth for more details.";
    public static final String LISTENER_SET = "Listener set";
    public static final String NO_SINGLETON_INSTANCE = "There is no singleton instance. Make sure you configure Purchases before trying to get the default instance. More info here: https://errors.rev.cat/configuring-sdk";
    public static final String PACKAGE_NAME = "Package name - %s";
    public static final String SDK_VERSION = "SDK Version - %s";
    public static final String VERIFICATION_MODE_SELECTED = "Purchases configured with response verification: %s";

    private ConfigureStrings() {
    }
}
