package io.invertase.googlemobileads;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import androidx.core.os.EnvironmentCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import io.invertase.googlemobileads.common.ReactNativeEventEmitter;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* loaded from: classes5.dex */
public class ReactNativeGoogleMobileAdsCommon {
    static AdSize getAdSizeForAdaptiveBanner(String str, ViewGroup viewGroup) {
        try {
            Display defaultDisplay = ((Activity) Objects.requireNonNull(((ReactContext) viewGroup.getContext()).getCurrentActivity())).getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int i = (int) (displayMetrics.widthPixels / displayMetrics.density);
            if ("INLINE_ADAPTIVE_BANNER".equals(str)) {
                return AdSize.getCurrentOrientationInlineAdaptiveBannerAdSize(viewGroup.getContext(), i);
            }
            return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(viewGroup.getContext(), i);
        } catch (Exception unused) {
            return AdSize.BANNER;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AdSize getAdSize(String str, ViewGroup viewGroup) {
        if (str.matches("ADAPTIVE_BANNER|ANCHORED_ADAPTIVE_BANNER|INLINE_ADAPTIVE_BANNER")) {
            return getAdSizeForAdaptiveBanner(str, viewGroup);
        }
        return stringToAdSize(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static AdSize stringToAdSize(String str) {
        char c;
        Matcher matcher = Pattern.compile("([0-9]+)x([0-9]+)").matcher(str);
        if (matcher.find()) {
            return new AdSize(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
        }
        String upperCase = str.toUpperCase();
        switch (upperCase.hashCode()) {
            case -1966536496:
                if (upperCase.equals("LARGE_BANNER")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1008851236:
                if (upperCase.equals("FULL_BANNER")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -96588539:
                if (upperCase.equals("MEDIUM_RECTANGLE")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -14796567:
                if (upperCase.equals("WIDE_SKYSCRAPER")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 66994602:
                if (upperCase.equals("FLUID")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 446888797:
                if (upperCase.equals("LEADERBOARD")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1951953708:
                if (upperCase.equals("BANNER")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            return AdSize.FLUID;
        }
        if (c == 1) {
            return AdSize.WIDE_SKYSCRAPER;
        }
        if (c == 2) {
            return AdSize.LARGE_BANNER;
        }
        if (c == 3) {
            return AdSize.MEDIUM_RECTANGLE;
        }
        if (c == 4) {
            return AdSize.FULL_BANNER;
        }
        if (c == 5) {
            return AdSize.LEADERBOARD;
        }
        return AdSize.BANNER;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WritableMap errorCodeToMap(int i) {
        WritableMap createMap = Arguments.createMap();
        if (i == 0) {
            createMap.putString("code", "error-code-internal-error");
            createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "Something happened internally; for instance, an invalid response was received from the ad server.");
        } else if (i == 1) {
            createMap.putString("code", "error-code-invalid-request");
            createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "The ad request was invalid; for instance, the ad unit ID was incorrect.");
        } else if (i == 2) {
            createMap.putString("code", "error-code-network-error");
            createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "The ad request was unsuccessful due to network connectivity.");
        } else if (i == 3) {
            createMap.putString("code", "error-code-no-fill");
            createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "The ad request was successful, but no ad was returned due to lack of ad inventory.");
        }
        return createMap;
    }

    public static AdManagerAdRequest buildAdRequest(ReadableMap readableMap) {
        AdManagerAdRequest.Builder builder = new AdManagerAdRequest.Builder();
        Bundle bundle = new Bundle();
        if (readableMap.hasKey("requestNonPersonalizedAdsOnly") && readableMap.getBoolean("requestNonPersonalizedAdsOnly")) {
            bundle.putString("npa", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
        }
        if (readableMap.hasKey("networkExtras")) {
            for (Map.Entry<String, Object> entry : readableMap.getMap("networkExtras").toHashMap().entrySet()) {
                bundle.putString(entry.getKey(), (String) entry.getValue());
            }
        }
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        if (readableMap.hasKey("keywords")) {
            Iterator<Object> it = ((ReadableArray) Objects.requireNonNull(readableMap.getArray("keywords"))).toArrayList().iterator();
            while (it.hasNext()) {
                builder.addKeyword((String) it.next());
            }
        }
        if (readableMap.hasKey("contentUrl")) {
            builder.setContentUrl((String) Objects.requireNonNull(readableMap.getString("contentUrl")));
        }
        if (readableMap.hasKey("requestAgent")) {
            builder.setRequestAgent((String) Objects.requireNonNull(readableMap.getString("requestAgent")));
        }
        if (readableMap.hasKey("customTargeting")) {
            for (Map.Entry<String, Object> entry2 : readableMap.getMap("customTargeting").toHashMap().entrySet()) {
                builder.addCustomTargeting(entry2.getKey(), (String) entry2.getValue());
            }
        }
        if (readableMap.hasKey("publisherProvidedId")) {
            builder.setPublisherProvidedId((String) Objects.requireNonNull(readableMap.getString("publisherProvidedId")));
        }
        return builder.build();
    }

    public static void sendAdEvent(String str, int i, String str2, String str3, @Nullable WritableMap writableMap) {
        ReactNativeEventEmitter sharedInstance = ReactNativeEventEmitter.getSharedInstance();
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", str2);
        if (writableMap != null) {
            createMap.putMap("error", writableMap);
        }
        sharedInstance.sendEvent(new ReactNativeGoogleMobileAdsEvent(str, i, str3, createMap));
    }

    public static void sendAdEvent(String str, int i, String str2, String str3, @Nullable WritableMap writableMap, @Nullable WritableMap writableMap2) {
        ReactNativeEventEmitter sharedInstance = ReactNativeEventEmitter.getSharedInstance();
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", str2);
        if (writableMap != null) {
            createMap.putMap("error", writableMap);
        }
        if (writableMap2 != null) {
            createMap.putMap("data", writableMap2);
        }
        sharedInstance.sendEvent(new ReactNativeGoogleMobileAdsEvent(str, i, str3, createMap));
    }

    public static String[] getCodeAndMessageFromAdError(AdError adError) {
        String str;
        String message = adError.getMessage();
        int code = adError.getCode();
        if (code == 0) {
            str = "internal-error";
        } else if (code == 1) {
            str = "invalid-request";
        } else if (code == 2) {
            str = "network-error";
        } else if (code != 3) {
            switch (code) {
                case 8:
                    str = "app-id-missing";
                    break;
                case 9:
                    str = "mediation-no-fill";
                    break;
                case 10:
                    str = "request-id-mismatch";
                    break;
                case 11:
                    str = "invalid-ad-string";
                    break;
                default:
                    str = EnvironmentCompat.MEDIA_UNKNOWN;
                    break;
            }
        } else {
            str = "no-fill";
        }
        return new String[]{str, message};
    }

    public static boolean isAdManagerUnit(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("/");
    }
}
