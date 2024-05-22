package io.invertase.googlemobileads;

import android.app.Activity;
import android.preference.PreferenceManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;
import io.invertase.googlemobileads.common.ReactNativeModule;
import javax.annotation.Nonnull;

/* loaded from: classes5.dex */
public class ReactNativeGoogleMobileAdsConsentModule extends ReactNativeModule {
    private static final String TAG = "RNGoogleMobileAdsConsentModule";
    private ConsentInformation consentInformation;

    private String getConsentStatusString(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "UNKNOWN" : "OBTAINED" : "REQUIRED" : "NOT_REQUIRED";
    }

    public ReactNativeGoogleMobileAdsConsentModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, TAG);
        this.consentInformation = UserMessagingPlatform.getConsentInformation(reactApplicationContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsConsentModule$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$ump$ConsentInformation$PrivacyOptionsRequirementStatus;

        static {
            int[] iArr = new int[ConsentInformation.PrivacyOptionsRequirementStatus.values().length];
            $SwitchMap$com$google$android$ump$ConsentInformation$PrivacyOptionsRequirementStatus = iArr;
            try {
                iArr[ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$android$ump$ConsentInformation$PrivacyOptionsRequirementStatus[ConsentInformation.PrivacyOptionsRequirementStatus.NOT_REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$android$ump$ConsentInformation$PrivacyOptionsRequirementStatus[ConsentInformation.PrivacyOptionsRequirementStatus.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private String getPrivacyOptionsRequirementStatusString(ConsentInformation.PrivacyOptionsRequirementStatus privacyOptionsRequirementStatus) {
        int i = AnonymousClass1.$SwitchMap$com$google$android$ump$ConsentInformation$PrivacyOptionsRequirementStatus[privacyOptionsRequirementStatus.ordinal()];
        return i != 1 ? i != 2 ? "UNKNOWN" : "NOT_REQUIRED" : "REQUIRED";
    }

    private WritableMap getConsentInformation() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("status", getConsentStatusString(this.consentInformation.getConsentStatus()));
        createMap.putBoolean("canRequestAds", this.consentInformation.canRequestAds());
        createMap.putString("privacyOptionsRequirementStatus", getPrivacyOptionsRequirementStatusString(this.consentInformation.getPrivacyOptionsRequirementStatus()));
        createMap.putBoolean("isConsentFormAvailable", this.consentInformation.isConsentFormAvailable());
        return createMap;
    }

    @ReactMethod
    public void requestInfoUpdate(@Nonnull ReadableMap readableMap, final Promise promise) {
        try {
            ConsentRequestParameters.Builder builder = new ConsentRequestParameters.Builder();
            ConsentDebugSettings.Builder builder2 = new ConsentDebugSettings.Builder(getApplicationContext());
            if (readableMap.hasKey("testDeviceIdentifiers")) {
                ReadableArray array = readableMap.getArray("testDeviceIdentifiers");
                for (int i = 0; i < array.size(); i++) {
                    builder2.addTestDeviceHashedId(array.getString(i));
                }
            }
            if (readableMap.hasKey("debugGeography")) {
                builder2.setDebugGeography(readableMap.getInt("debugGeography"));
            }
            builder.setConsentDebugSettings(builder2.build());
            if (readableMap.hasKey("tagForUnderAgeOfConsent")) {
                builder.setTagForUnderAgeOfConsent(readableMap.getBoolean("tagForUnderAgeOfConsent"));
            }
            ConsentRequestParameters build = builder.build();
            Activity currentActivity = getCurrentActivity();
            if (currentActivity == null) {
                rejectPromiseWithCodeAndMessage(promise, "null-activity", "Attempted to request a consent info update but the current Activity was null.");
            } else {
                this.consentInformation.requestConsentInfoUpdate(currentActivity, build, new ConsentInformation.OnConsentInfoUpdateSuccessListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda0
                    @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateSuccessListener
                    public final void onConsentInfoUpdateSuccess() {
                        ReactNativeGoogleMobileAdsConsentModule.this.lambda$requestInfoUpdate$0(promise);
                    }
                }, new ConsentInformation.OnConsentInfoUpdateFailureListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda1
                    @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateFailureListener
                    public final void onConsentInfoUpdateFailure(FormError formError) {
                        ReactNativeGoogleMobileAdsConsentModule.rejectPromiseWithCodeAndMessage(Promise.this, "consent-update-failed", formError.getMessage());
                    }
                });
            }
        } catch (Exception e) {
            rejectPromiseWithCodeAndMessage(promise, "consent-update-failed", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestInfoUpdate$0(Promise promise) {
        promise.resolve(getConsentInformation());
    }

    @ReactMethod
    public void showForm(final Promise promise) {
        try {
            final Activity currentActivity = getCurrentActivity();
            if (currentActivity == null) {
                rejectPromiseWithCodeAndMessage(promise, "null-activity", "Consent form attempted to show but the current Activity was null.");
            } else {
                currentActivity.runOnUiThread(new Runnable() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        ReactNativeGoogleMobileAdsConsentModule.this.lambda$showForm$5(currentActivity, promise);
                    }
                });
            }
        } catch (Exception e) {
            rejectPromiseWithCodeAndMessage(promise, "consent-form-error", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showForm$5(final Activity activity, final Promise promise) {
        UserMessagingPlatform.loadConsentForm(getReactApplicationContext(), new UserMessagingPlatform.OnConsentFormLoadSuccessListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda2
            @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadSuccessListener
            public final void onConsentFormLoadSuccess(ConsentForm consentForm) {
                ReactNativeGoogleMobileAdsConsentModule.this.lambda$showForm$3(activity, promise, consentForm);
            }
        }, new UserMessagingPlatform.OnConsentFormLoadFailureListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda3
            @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadFailureListener
            public final void onConsentFormLoadFailure(FormError formError) {
                ReactNativeGoogleMobileAdsConsentModule.rejectPromiseWithCodeAndMessage(Promise.this, "consent-form-error", formError.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showForm$3(Activity activity, final Promise promise, ConsentForm consentForm) {
        consentForm.show(activity, new ConsentForm.OnConsentFormDismissedListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda5
            @Override // com.google.android.ump.ConsentForm.OnConsentFormDismissedListener
            public final void onConsentFormDismissed(FormError formError) {
                ReactNativeGoogleMobileAdsConsentModule.this.lambda$showForm$2(promise, formError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showForm$2(Promise promise, FormError formError) {
        if (formError != null) {
            rejectPromiseWithCodeAndMessage(promise, "consent-form-error", formError.getMessage());
        } else {
            promise.resolve(getConsentInformation());
        }
    }

    @ReactMethod
    public void showPrivacyOptionsForm(final Promise promise) {
        try {
            final Activity currentActivity = getCurrentActivity();
            if (currentActivity == null) {
                rejectPromiseWithCodeAndMessage(promise, "null-activity", "Privacy options form attempted to show but the current Activity was null.");
            } else {
                currentActivity.runOnUiThread(new Runnable() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        ReactNativeGoogleMobileAdsConsentModule.this.lambda$showPrivacyOptionsForm$7(currentActivity, promise);
                    }
                });
            }
        } catch (Exception e) {
            rejectPromiseWithCodeAndMessage(promise, "consent-form-error", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPrivacyOptionsForm$7(Activity activity, final Promise promise) {
        UserMessagingPlatform.showPrivacyOptionsForm(activity, new ConsentForm.OnConsentFormDismissedListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda7
            @Override // com.google.android.ump.ConsentForm.OnConsentFormDismissedListener
            public final void onConsentFormDismissed(FormError formError) {
                ReactNativeGoogleMobileAdsConsentModule.this.lambda$showPrivacyOptionsForm$6(promise, formError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPrivacyOptionsForm$6(Promise promise, FormError formError) {
        if (formError != null) {
            rejectPromiseWithCodeAndMessage(promise, "privacy-options-form-error", formError.getMessage());
        } else {
            promise.resolve(getConsentInformation());
        }
    }

    @ReactMethod
    public void loadAndShowConsentFormIfRequired(final Promise promise) {
        try {
            final Activity currentActivity = getCurrentActivity();
            if (currentActivity == null) {
                rejectPromiseWithCodeAndMessage(promise, "null-activity", "Consent form attempted to load and show if required but the current Activity was null.");
            } else {
                currentActivity.runOnUiThread(new Runnable() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        ReactNativeGoogleMobileAdsConsentModule.this.lambda$loadAndShowConsentFormIfRequired$9(currentActivity, promise);
                    }
                });
            }
        } catch (Exception e) {
            rejectPromiseWithCodeAndMessage(promise, "consent-form-error", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAndShowConsentFormIfRequired$9(Activity activity, final Promise promise) {
        UserMessagingPlatform.loadAndShowConsentFormIfRequired(activity, new ConsentForm.OnConsentFormDismissedListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda9
            @Override // com.google.android.ump.ConsentForm.OnConsentFormDismissedListener
            public final void onConsentFormDismissed(FormError formError) {
                ReactNativeGoogleMobileAdsConsentModule.this.lambda$loadAndShowConsentFormIfRequired$8(promise, formError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAndShowConsentFormIfRequired$8(Promise promise, FormError formError) {
        if (formError != null) {
            rejectPromiseWithCodeAndMessage(promise, "consent-form-error", formError.getMessage());
        } else {
            promise.resolve(getConsentInformation());
        }
    }

    @ReactMethod
    public void getConsentInfo(Promise promise) {
        promise.resolve(getConsentInformation());
    }

    @ReactMethod
    public void reset() {
        this.consentInformation.reset();
    }

    @ReactMethod
    public void getTCString(Promise promise) {
        try {
            promise.resolve(PreferenceManager.getDefaultSharedPreferences(getReactApplicationContext()).getString("IABTCF_TCString", null));
        } catch (Exception e) {
            rejectPromiseWithCodeAndMessage(promise, "consent-string-error", e.toString());
        }
    }

    @ReactMethod
    public void getGdprApplies(Promise promise) {
        try {
            promise.resolve(Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(getReactApplicationContext()).getInt("IABTCF_gdprApplies", 0) == 1));
        } catch (Exception e) {
            rejectPromiseWithCodeAndMessage(promise, "consent-string-error", e.toString());
        }
    }

    @ReactMethod
    public void getPurposeConsents(Promise promise) {
        try {
            promise.resolve(PreferenceManager.getDefaultSharedPreferences(getReactApplicationContext()).getString("IABTCF_PurposeConsents", ""));
        } catch (Exception e) {
            rejectPromiseWithCodeAndMessage(promise, "consent-string-error", e.toString());
        }
    }
}
