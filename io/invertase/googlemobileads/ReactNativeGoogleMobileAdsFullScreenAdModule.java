package io.invertase.googlemobileads;

import android.app.Activity;
import android.util.SparseArray;
import com.amazon.a.a.o.b;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import io.invertase.googlemobileads.common.ReactNativeModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReactNativeGoogleMobileAdsFullScreenAdModule.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\"B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u0006H&J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J.\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H&J4\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J&\u0010\u001e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsFullScreenAdModule;", "T", "Lio/invertase/googlemobileads/common/ReactNativeModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "moduleName", "", "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/lang/String;)V", "adArray", "Landroid/util/SparseArray;", "getAdEventName", "load", "", b.B, "", "adUnitId", "adRequestOptions", "Lcom/facebook/react/bridge/ReadableMap;", "loadAd", "activity", "Landroid/app/Activity;", "adRequest", "Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;", "adLoadCallback", "Lcom/google/android/gms/ads/AdLoadCallback;", "sendAdEvent", "type", "error", "Lcom/facebook/react/bridge/WritableMap;", "data", "show", "showOptions", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "ReactNativeGoogleMobileAdsAdLoadCallback", "react-native-google-mobile-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ReactNativeGoogleMobileAdsFullScreenAdModule<T> extends ReactNativeModule {
    private final SparseArray<T> adArray;

    public abstract String getAdEventName();

    public abstract void loadAd(Activity activity, String adUnitId, AdManagerAdRequest adRequest, AdLoadCallback<T> adLoadCallback);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactNativeGoogleMobileAdsFullScreenAdModule(ReactApplicationContext reactApplicationContext, String moduleName) {
        super(reactApplicationContext, moduleName);
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        this.adArray = new SparseArray<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendAdEvent(String type, int requestId, String adUnitId, WritableMap error, WritableMap data) {
        ReactNativeGoogleMobileAdsCommon.sendAdEvent(getAdEventName(), requestId, type, adUnitId, error, data);
    }

    public final void load(int requestId, final String adUnitId, ReadableMap adRequestOptions) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(adRequestOptions, "adRequestOptions");
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("code", "null-activity");
            createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "Ad attempted to load but the current Activity was null.");
            sendAdEvent("error", requestId, adUnitId, createMap, null);
            return;
        }
        final AdManagerAdRequest buildAdRequest = ReactNativeGoogleMobileAdsCommon.buildAdRequest(adRequestOptions);
        final ReactNativeGoogleMobileAdsAdLoadCallback reactNativeGoogleMobileAdsAdLoadCallback = new ReactNativeGoogleMobileAdsAdLoadCallback(this, requestId, adUnitId, adRequestOptions);
        currentActivity.runOnUiThread(new Runnable() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ReactNativeGoogleMobileAdsFullScreenAdModule.load$lambda$0(ReactNativeGoogleMobileAdsFullScreenAdModule.this, currentActivity, adUnitId, buildAdRequest, reactNativeGoogleMobileAdsAdLoadCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void load$lambda$0(ReactNativeGoogleMobileAdsFullScreenAdModule this$0, Activity activity, String adUnitId, AdManagerAdRequest adRequest, ReactNativeGoogleMobileAdsAdLoadCallback adLoadCallback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adUnitId, "$adUnitId");
        Intrinsics.checkNotNullParameter(adLoadCallback, "$adLoadCallback");
        Intrinsics.checkNotNullExpressionValue(adRequest, "adRequest");
        this$0.loadAd(activity, adUnitId, adRequest, adLoadCallback);
    }

    public final void show(final int requestId, final String adUnitId, final ReadableMap showOptions, final Promise promise) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(showOptions, "showOptions");
        Intrinsics.checkNotNullParameter(promise, "promise");
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            ReactNativeModule.rejectPromiseWithCodeAndMessage(promise, "null-activity", "Ad attempted to show but the current Activity was null.");
        } else {
            currentActivity.runOnUiThread(new Runnable() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ReactNativeGoogleMobileAdsFullScreenAdModule.show$lambda$2(ReactNativeGoogleMobileAdsFullScreenAdModule.this, requestId, showOptions, currentActivity, promise, adUnitId);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$2(final ReactNativeGoogleMobileAdsFullScreenAdModule this$0, final int i, ReadableMap showOptions, Activity activity, Promise promise, final String adUnitId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(showOptions, "$showOptions");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(adUnitId, "$adUnitId");
        ReactNativeGoogleMobileAdsAdHelper reactNativeGoogleMobileAdsAdHelper = new ReactNativeGoogleMobileAdsAdHelper(this$0.adArray.get(i));
        reactNativeGoogleMobileAdsAdHelper.setImmersiveMode(showOptions.hasKey("immersiveModeEnabled") ? showOptions.getBoolean("immersiveModeEnabled") : false);
        reactNativeGoogleMobileAdsAdHelper.show(activity, new OnUserEarnedRewardListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
            public final void onUserEarnedReward(RewardItem rewardItem) {
                ReactNativeGoogleMobileAdsFullScreenAdModule.show$lambda$2$lambda$1(ReactNativeGoogleMobileAdsFullScreenAdModule.this, i, adUnitId, rewardItem);
            }
        });
        promise.resolve(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$2$lambda$1(ReactNativeGoogleMobileAdsFullScreenAdModule this$0, int i, String adUnitId, RewardItem rewardItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adUnitId, "$adUnitId");
        Intrinsics.checkNotNullParameter(rewardItem, "rewardItem");
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", rewardItem.getType());
        createMap.putInt("amount", rewardItem.getAmount());
        this$0.sendAdEvent(ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_REWARDED_EARNED_REWARD, i, adUnitId, null, createMap);
    }

    /* compiled from: ReactNativeGoogleMobileAdsFullScreenAdModule.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\b\u00028\u0000H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b9¨\u0006\u0010"}, d2 = {"Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsFullScreenAdModule$ReactNativeGoogleMobileAdsAdLoadCallback;", "Lcom/google/android/gms/ads/AdLoadCallback;", b.B, "", "adUnitId", "", "adRequestOptions", "Lcom/facebook/react/bridge/ReadableMap;", "(Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsFullScreenAdModule;ILjava/lang/String;Lcom/facebook/react/bridge/ReadableMap;)V", "onAdFailedToLoad", "", "loadAdError", "Lcom/google/android/gms/ads/LoadAdError;", "onAdLoaded", "ad", "(Ljava/lang/Object;)V", "react-native-google-mobile-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class ReactNativeGoogleMobileAdsAdLoadCallback extends AdLoadCallback<T> {
        private final ReadableMap adRequestOptions;
        private final String adUnitId;
        private final int requestId;
        final /* synthetic */ ReactNativeGoogleMobileAdsFullScreenAdModule<T> this$0;

        public ReactNativeGoogleMobileAdsAdLoadCallback(ReactNativeGoogleMobileAdsFullScreenAdModule reactNativeGoogleMobileAdsFullScreenAdModule, int i, String adUnitId, ReadableMap adRequestOptions) {
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(adRequestOptions, "adRequestOptions");
            this.this$0 = reactNativeGoogleMobileAdsFullScreenAdModule;
            this.requestId = i;
            this.adUnitId = adUnitId;
            this.adRequestOptions = adRequestOptions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:14:0x009c A[Catch: Exception -> 0x00c8, TryCatch #0 {Exception -> 0x00c8, blocks: (B:3:0x0005, B:5:0x0017, B:6:0x003e, B:8:0x0042, B:12:0x0098, B:14:0x009c, B:15:0x00a6, B:19:0x004a, B:21:0x0070, B:23:0x007d, B:24:0x0080, B:26:0x0088, B:27:0x008b, B:29:0x001e, B:31:0x0022, B:32:0x0029, B:34:0x002d, B:35:0x0034, B:37:0x0038), top: B:2:0x0005 }] */
        @Override // com.google.android.gms.ads.AdLoadCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onAdLoaded(T r9) {
            /*
                Method dump skipped, instructions count: 247
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule.ReactNativeGoogleMobileAdsAdLoadCallback.onAdLoaded(java.lang.Object):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onAdLoaded$lambda$0(ReactNativeGoogleMobileAdsFullScreenAdModule this$0, ReactNativeGoogleMobileAdsAdLoadCallback this$1, AdValue adValue) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(adValue, "adValue");
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("value", adValue.getValueMicros() * 1.0E-6d);
            createMap.putDouble("precision", adValue.getPrecisionType() * 1.0d);
            createMap.putString(b.a, adValue.getCurrencyCode());
            this$0.sendAdEvent(ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_PAID, this$1.requestId, this$1.adUnitId, null, createMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onAdLoaded$lambda$4(ReactNativeGoogleMobileAdsFullScreenAdModule this$0, ReactNativeGoogleMobileAdsAdLoadCallback this$1, String name, String eventData) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            WritableMap createMap = Arguments.createMap();
            createMap.putString("name", name);
            createMap.putString("data", eventData);
            this$0.sendAdEvent(ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_APP_EVENT, this$1.requestId, this$1.adUnitId, null, createMap);
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdFailedToLoad(LoadAdError loadAdError) {
            Intrinsics.checkNotNullParameter(loadAdError, "loadAdError");
            WritableMap createMap = Arguments.createMap();
            String[] codeAndMessageFromAdError = ReactNativeGoogleMobileAdsCommon.getCodeAndMessageFromAdError(loadAdError);
            createMap.putString("code", codeAndMessageFromAdError[0]);
            createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, codeAndMessageFromAdError[1]);
            this.this$0.sendAdEvent("error", this.requestId, this.adUnitId, createMap, null);
        }
    }
}
