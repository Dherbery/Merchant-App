package com.revenuecat.purchases;

import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.strings.ConfigureStrings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: APIKeyValidator.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002\r\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/APIKeyValidator;", "", "()V", "getApiKeyPlatform", "Lcom/revenuecat/purchases/APIKeyValidator$APIKeyPlatform;", "apiKey", "", "validate", "Lcom/revenuecat/purchases/APIKeyValidator$ValidationResult;", "configuredStore", "Lcom/revenuecat/purchases/Store;", "validateAndLog", "", "APIKeyPlatform", "ValidationResult", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class APIKeyValidator {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: APIKeyValidator.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/APIKeyValidator$APIKeyPlatform;", "", "(Ljava/lang/String;I)V", "GOOGLE", "AMAZON", "LEGACY", "OTHER_PLATFORM", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public enum APIKeyPlatform {
        GOOGLE,
        AMAZON,
        LEGACY,
        OTHER_PLATFORM
    }

    /* compiled from: APIKeyValidator.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/APIKeyValidator$ValidationResult;", "", "(Ljava/lang/String;I)V", "VALID", "GOOGLE_KEY_AMAZON_STORE", "AMAZON_KEY_GOOGLE_STORE", "LEGACY", "OTHER_PLATFORM", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public enum ValidationResult {
        VALID,
        GOOGLE_KEY_AMAZON_STORE,
        AMAZON_KEY_GOOGLE_STORE,
        LEGACY,
        OTHER_PLATFORM
    }

    /* compiled from: APIKeyValidator.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ValidationResult.values().length];
            try {
                iArr[ValidationResult.AMAZON_KEY_GOOGLE_STORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ValidationResult.GOOGLE_KEY_AMAZON_STORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ValidationResult.LEGACY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ValidationResult.OTHER_PLATFORM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ValidationResult.VALID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final void validateAndLog(String apiKey, Store configuredStore) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(configuredStore, "configuredStore");
        int i = WhenMappings.$EnumSwitchMapping$0[validate(apiKey, configuredStore).ordinal()];
        if (i == 1) {
            LogUtilsKt.errorLog$default(ConfigureStrings.AMAZON_API_KEY_GOOGLE_STORE, null, 2, null);
            return;
        }
        if (i == 2) {
            LogUtilsKt.errorLog$default(ConfigureStrings.GOOGLE_API_KEY_AMAZON_STORE, null, 2, null);
        } else if (i == 3) {
            LogUtilsKt.debugLog(ConfigureStrings.LEGACY_API_KEY);
        } else {
            if (i != 4) {
                return;
            }
            LogUtilsKt.errorLog$default(ConfigureStrings.INVALID_API_KEY, null, 2, null);
        }
    }

    public final ValidationResult validate(String apiKey, Store configuredStore) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(configuredStore, "configuredStore");
        APIKeyPlatform apiKeyPlatform = getApiKeyPlatform(apiKey);
        if (apiKeyPlatform == APIKeyPlatform.GOOGLE && configuredStore == Store.PLAY_STORE) {
            return ValidationResult.VALID;
        }
        if (apiKeyPlatform == APIKeyPlatform.AMAZON && configuredStore == Store.AMAZON) {
            return ValidationResult.VALID;
        }
        if (apiKeyPlatform == APIKeyPlatform.GOOGLE && configuredStore == Store.AMAZON) {
            return ValidationResult.GOOGLE_KEY_AMAZON_STORE;
        }
        if (apiKeyPlatform == APIKeyPlatform.AMAZON && configuredStore == Store.PLAY_STORE) {
            return ValidationResult.AMAZON_KEY_GOOGLE_STORE;
        }
        return apiKeyPlatform == APIKeyPlatform.LEGACY ? ValidationResult.LEGACY : apiKeyPlatform == APIKeyPlatform.OTHER_PLATFORM ? ValidationResult.OTHER_PLATFORM : ValidationResult.OTHER_PLATFORM;
    }

    private final APIKeyPlatform getApiKeyPlatform(String apiKey) {
        return StringsKt.startsWith$default(apiKey, "goog_", false, 2, (Object) null) ? APIKeyPlatform.GOOGLE : StringsKt.startsWith$default(apiKey, "amzn_", false, 2, (Object) null) ? APIKeyPlatform.AMAZON : !StringsKt.contains$default((CharSequence) apiKey, '_', false, 2, (Object) null) ? APIKeyPlatform.LEGACY : APIKeyPlatform.OTHER_PLATFORM;
    }
}
