package io.invertase.googlemobileads;

import android.app.Activity;
import android.content.Context;
import com.amazon.a.a.o.b;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReactNativeGoogleMobileAdsRewardedInterstitialModule.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J.\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J(\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0007¨\u0006\u001b"}, d2 = {"Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsRewardedInterstitialModule;", "Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsFullScreenAdModule;", "Lcom/google/android/gms/ads/rewardedinterstitial/RewardedInterstitialAd;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getAdEventName", "", "loadAd", "", "activity", "Landroid/app/Activity;", "adUnitId", "adRequest", "Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;", "adLoadCallback", "Lcom/google/android/gms/ads/AdLoadCallback;", "rewardedInterstitialLoad", b.B, "", "adRequestOptions", "Lcom/facebook/react/bridge/ReadableMap;", "rewardedInterstitialShow", "showOptions", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "Companion", "react-native-google-mobile-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReactNativeGoogleMobileAdsRewardedInterstitialModule extends ReactNativeGoogleMobileAdsFullScreenAdModule<RewardedInterstitialAd> {
    public static final String NAME = "RNGoogleMobileAdsRewardedInterstitialModule";

    @Override // io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule
    public String getAdEventName() {
        return ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_REWARDED_INTERSTITIAL;
    }

    public ReactNativeGoogleMobileAdsRewardedInterstitialModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, NAME);
    }

    @ReactMethod
    public final void rewardedInterstitialLoad(int requestId, String adUnitId, ReadableMap adRequestOptions) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(adRequestOptions, "adRequestOptions");
        load(requestId, adUnitId, adRequestOptions);
    }

    @ReactMethod
    public final void rewardedInterstitialShow(int requestId, String adUnitId, ReadableMap showOptions, Promise promise) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(showOptions, "showOptions");
        Intrinsics.checkNotNullParameter(promise, "promise");
        show(requestId, adUnitId, showOptions, promise);
    }

    @Override // io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule
    public void loadAd(Activity activity, String adUnitId, AdManagerAdRequest adRequest, final AdLoadCallback<RewardedInterstitialAd> adLoadCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(adRequest, "adRequest");
        Intrinsics.checkNotNullParameter(adLoadCallback, "adLoadCallback");
        RewardedInterstitialAd.load((Context) activity, adUnitId, adRequest, new RewardedInterstitialAdLoadCallback() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsRewardedInterstitialModule$loadAd$1
            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(RewardedInterstitialAd ad) {
                Intrinsics.checkNotNullParameter(ad, "ad");
                adLoadCallback.onAdLoaded(ad);
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(LoadAdError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                adLoadCallback.onAdFailedToLoad(error);
            }
        });
    }
}
