package io.invertase.googlemobileads;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.a.a.o.b;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AppEventListener;
import io.invertase.googlemobileads.ReactNativeGoogleMobileAdsBannerAdViewManager;
import io.invertase.googlemobileads.common.ReactNativeAdView;
import io.invertase.googlemobileads.common.SharedUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class ReactNativeGoogleMobileAdsBannerAdViewManager extends SimpleViewManager<ReactNativeAdView> {
    private static final String REACT_CLASS = "RNGoogleMobileAdsBannerView";
    private final String EVENT_AD_LOADED = "onAdLoaded";
    private final String EVENT_AD_FAILED_TO_LOAD = "onAdFailedToLoad";
    private final String EVENT_AD_OPENED = "onAdOpened";
    private final String EVENT_AD_CLOSED = "onAdClosed";
    private final String EVENT_PAID = "onPaid";
    private final String EVENT_SIZE_CHANGE = "onSizeChange";
    private final String EVENT_APP_EVENT = "onAppEvent";
    private final int COMMAND_ID_RECORD_MANUAL_IMPRESSION = 1;

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nonnull
    public ReactNativeAdView createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
        return new ReactNativeAdView(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder.Builder builder = MapBuilder.builder();
        builder.put(OnNativeEvent.EVENT_NAME, MapBuilder.of("registrationName", "onNativeEvent"));
        return builder.build();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("recordManualImpression", 1);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(ReactNativeAdView reactNativeAdView, String str, @Nullable ReadableArray readableArray) {
        super.receiveCommand((ReactNativeGoogleMobileAdsBannerAdViewManager) reactNativeAdView, str, readableArray);
        if (Integer.parseInt(str) == 1) {
            BaseAdView adView = getAdView(reactNativeAdView);
            if (adView instanceof AdManagerAdView) {
                ((AdManagerAdView) adView).recordManualImpression();
            }
        }
    }

    @ReactProp(name = "unitId")
    public void setUnitId(ReactNativeAdView reactNativeAdView, String str) {
        reactNativeAdView.setUnitId(str);
        reactNativeAdView.setPropsChanged(true);
    }

    @ReactProp(name = "request")
    public void setRequest(ReactNativeAdView reactNativeAdView, String str) {
        try {
            reactNativeAdView.setRequest(ReactNativeGoogleMobileAdsCommon.buildAdRequest(SharedUtils.jsonObjectToWritableMap(new JSONObject(str))));
            reactNativeAdView.setPropsChanged(true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @ReactProp(name = "sizes")
    public void setSizes(ReactNativeAdView reactNativeAdView, ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = readableArray.toArrayList().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof String) {
                arrayList.add(ReactNativeGoogleMobileAdsCommon.getAdSize((String) next, reactNativeAdView));
            }
        }
        if (arrayList.size() > 0 && !arrayList.contains(AdSize.FLUID)) {
            AdSize adSize = arrayList.get(0);
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("width", adSize.getWidth());
            createMap.putDouble("height", adSize.getHeight());
            sendEvent(reactNativeAdView, "onSizeChange", createMap);
        }
        reactNativeAdView.setSizes(arrayList);
        reactNativeAdView.setPropsChanged(true);
    }

    @ReactProp(name = "manualImpressionsEnabled")
    public void setManualImpressionsEnabled(ReactNativeAdView reactNativeAdView, boolean z) {
        reactNativeAdView.setManualImpressionsEnabled(z);
        reactNativeAdView.setPropsChanged(true);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(ReactNativeAdView reactNativeAdView) {
        super.onAfterUpdateTransaction((ReactNativeGoogleMobileAdsBannerAdViewManager) reactNativeAdView);
        if (reactNativeAdView.getPropsChanged()) {
            requestAd(reactNativeAdView);
        }
        reactNativeAdView.setPropsChanged(false);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(ReactNativeAdView reactNativeAdView) {
        BaseAdView adView = getAdView(reactNativeAdView);
        if (adView != null) {
            adView.setAdListener(null);
            if (adView instanceof AdManagerAdView) {
                ((AdManagerAdView) adView).setAppEventListener(null);
            }
            adView.destroy();
            reactNativeAdView.removeView(adView);
        }
        super.onDropViewInstance((ReactNativeGoogleMobileAdsBannerAdViewManager) reactNativeAdView);
    }

    private BaseAdView initAdView(final ReactNativeAdView reactNativeAdView) {
        BaseAdView adView;
        BaseAdView adView2 = getAdView(reactNativeAdView);
        if (adView2 != null) {
            adView2.setAdListener(null);
            if (adView2 instanceof AdManagerAdView) {
                ((AdManagerAdView) adView2).setAppEventListener(null);
            }
            adView2.destroy();
            reactNativeAdView.removeView(adView2);
        }
        Activity currentActivity = ((ReactContext) reactNativeAdView.getContext()).getCurrentActivity();
        if (currentActivity == null) {
            return null;
        }
        if (ReactNativeGoogleMobileAdsCommon.isAdManagerUnit(reactNativeAdView.getUnitId())) {
            adView = new AdManagerAdView(currentActivity);
        } else {
            adView = new AdView(currentActivity);
        }
        adView.setDescendantFocusability(393216);
        adView.setOnPaidEventListener(new OnPaidEventListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsBannerAdViewManager.1
            @Override // com.google.android.gms.ads.OnPaidEventListener
            public void onPaidEvent(AdValue adValue) {
                WritableMap createMap = Arguments.createMap();
                createMap.putDouble("value", adValue.getValueMicros() * 1.0E-6d);
                createMap.putDouble("precision", adValue.getPrecisionType());
                createMap.putString(b.a, adValue.getCurrencyCode());
                ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(reactNativeAdView, "onPaid", createMap);
            }
        });
        adView.setAdListener(new AnonymousClass2(adView, reactNativeAdView));
        if (adView instanceof AdManagerAdView) {
            ((AdManagerAdView) adView).setAppEventListener(new AppEventListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsBannerAdViewManager.3
                @Override // com.google.android.gms.ads.admanager.AppEventListener
                public void onAppEvent(String str, @Nullable String str2) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("name", str);
                    createMap.putString("data", str2);
                    ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(reactNativeAdView, "onAppEvent", createMap);
                }
            });
        }
        reactNativeAdView.addView(adView);
        return adView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsBannerAdViewManager$2, reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass2 extends AdListener {
        final /* synthetic */ BaseAdView val$adView;
        final /* synthetic */ ReactNativeAdView val$reactViewGroup;

        AnonymousClass2(BaseAdView baseAdView, ReactNativeAdView reactNativeAdView) {
            this.val$adView = baseAdView;
            this.val$reactViewGroup = reactNativeAdView;
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
            int i;
            int i2;
            AdSize adSize = this.val$adView.getAdSize();
            if (this.val$reactViewGroup.getIsFluid()) {
                i2 = this.val$reactViewGroup.getWidth();
                i = this.val$reactViewGroup.getHeight();
                BaseAdView baseAdView = this.val$adView;
                final ReactNativeAdView reactNativeAdView = this.val$reactViewGroup;
                baseAdView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsBannerAdViewManager$2$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                        ReactNativeGoogleMobileAdsBannerAdViewManager.AnonymousClass2.this.lambda$onAdLoaded$0(reactNativeAdView, view, i3, i4, i5, i6, i7, i8, i9, i10);
                    }
                });
            } else {
                int left = this.val$adView.getLeft();
                int top = this.val$adView.getTop();
                int widthInPixels = adSize.getWidthInPixels(this.val$reactViewGroup.getContext());
                int heightInPixels = adSize.getHeightInPixels(this.val$reactViewGroup.getContext());
                this.val$adView.measure(widthInPixels, heightInPixels);
                this.val$adView.layout(left, top, left + widthInPixels, top + heightInPixels);
                i = heightInPixels;
                i2 = widthInPixels;
            }
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("width", PixelUtil.toDIPFromPixel(i2));
            createMap.putDouble("height", PixelUtil.toDIPFromPixel(i));
            ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(this.val$reactViewGroup, "onAdLoaded", createMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAdLoaded$0(ReactNativeAdView reactNativeAdView, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("width", PixelUtil.toDIPFromPixel(i3 - i));
            createMap.putDouble("height", PixelUtil.toDIPFromPixel(i4 - i2));
            ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(reactNativeAdView, "onSizeChange", createMap);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(LoadAdError loadAdError) {
            ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(this.val$reactViewGroup, "onAdFailedToLoad", ReactNativeGoogleMobileAdsCommon.errorCodeToMap(loadAdError.getCode()));
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
            ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(this.val$reactViewGroup, "onAdOpened", null);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
            ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(this.val$reactViewGroup, "onAdClosed", null);
        }
    }

    @Nullable
    private BaseAdView getAdView(ViewGroup viewGroup) {
        return (BaseAdView) viewGroup.getChildAt(0);
    }

    private void requestAd(ReactNativeAdView reactNativeAdView) {
        BaseAdView initAdView;
        String unitId = reactNativeAdView.getUnitId();
        List<AdSize> sizes = reactNativeAdView.getSizes();
        AdRequest request = reactNativeAdView.getRequest();
        Boolean valueOf = Boolean.valueOf(reactNativeAdView.getManualImpressionsEnabled());
        if (sizes == null || unitId == null || request == null || valueOf == null || (initAdView = initAdView(reactNativeAdView)) == null) {
            return;
        }
        initAdView.setAdUnitId(unitId);
        reactNativeAdView.setIsFluid(false);
        if (initAdView instanceof AdManagerAdView) {
            if (sizes.contains(AdSize.FLUID)) {
                reactNativeAdView.setIsFluid(true);
            }
            AdManagerAdView adManagerAdView = (AdManagerAdView) initAdView;
            adManagerAdView.setAdSizes((AdSize[]) sizes.toArray(new AdSize[0]));
            if (valueOf.booleanValue()) {
                adManagerAdView.setManualImpressionsEnabled(true);
            }
        } else {
            initAdView.setAdSize(sizes.get(0));
        }
        initAdView.loadAd(request);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(ReactNativeAdView reactNativeAdView, String str, WritableMap writableMap) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", str);
        if (writableMap != null) {
            createMap.merge(writableMap);
        }
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ThemedReactContext) reactNativeAdView.getContext(), reactNativeAdView.getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new OnNativeEvent(reactNativeAdView.getId(), createMap));
        }
    }
}
