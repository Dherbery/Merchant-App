package com.amplitude.reactnative;

import com.amazon.a.a.o.b;
import com.amplitude.api.Amplitude;
import com.amplitude.api.AmplitudeClient;
import com.amplitude.api.AmplitudeLogCallback;
import com.amplitude.api.AmplitudeServerZone;
import com.amplitude.api.Constants;
import com.amplitude.api.IngestionMetadata;
import com.amplitude.api.Plan;
import com.amplitude.api.Revenue;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = AmplitudeReactNativeModule.NAME)
/* loaded from: classes.dex */
public class AmplitudeReactNativeModule extends ReactContextBaseJavaModule {
    public static final String NAME = "AmplitudeReactNative";
    private final ReactApplicationContext reactContext;

    @ReactMethod
    public void addListener(String str) {
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public AmplitudeReactNativeModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @ReactMethod
    public void initialize(String str, String str2, Promise promise) {
        Amplitude.getInstance(str).initialize(this.reactContext, str2);
        promise.resolve(true);
    }

    @ReactMethod
    public void logEvent(String str, String str2, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.logEvent(str2);
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void logEventWithProperties(String str, String str2, ReadableMap readableMap, Promise promise) throws JSONException {
        JSONObject convertMapToJson = ReactNativeHelper.convertMapToJson(readableMap);
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.logEvent(str2, convertMapToJson);
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void enableCoppaControl(String str, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.enableCoppaControl();
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void disableCoppaControl(String str, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.disableCoppaControl();
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void regenerateDeviceId(String str, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.regenerateDeviceId();
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void setDeviceId(String str, String str2, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.setDeviceId(str2);
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void getDeviceId(String str, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            promise.resolve(amplitude.getDeviceId());
        }
    }

    @ReactMethod
    public void setAdvertisingIdForDeviceId(String str, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.useAdvertisingIdForDeviceId();
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void setAppSetIdForDeviceId(String str, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.useAppSetIdForDeviceId();
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void setOptOut(String str, boolean z, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.setOptOut(z);
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void setLibraryName(String str, String str2, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.setLibraryName(str2);
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void setLibraryVersion(String str, String str2, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.setLibraryVersion(str2);
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void trackingSessionEvents(String str, boolean z, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.trackSessionEvents(z);
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void setUseDynamicConfig(String str, boolean z, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.setUseDynamicConfig(z);
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void setUserId(String str, String str2, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.setUserId(str2);
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void setServerUrl(String str, String str2, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.setServerUrl(str2);
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void logRevenueV2(String str, ReadableMap readableMap, Promise promise) throws JSONException {
        JSONObject convertMapToJson = ReactNativeHelper.convertMapToJson(readableMap);
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.logRevenueV2(createRevenue(convertMapToJson));
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void identify(String str, ReadableMap readableMap, Promise promise) throws JSONException {
        JSONObject convertMapToJson = ReactNativeHelper.convertMapToJson(readableMap);
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.identify(createIdentify(convertMapToJson));
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void groupIdentify(String str, String str2, String str3, ReadableMap readableMap, Promise promise) throws JSONException {
        JSONObject convertMapToJson = ReactNativeHelper.convertMapToJson(readableMap);
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.groupIdentify(str2, str3, createIdentify(convertMapToJson));
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void setUserProperties(String str, ReadableMap readableMap, Promise promise) throws JSONException {
        JSONObject convertMapToJson = ReactNativeHelper.convertMapToJson(readableMap);
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.setUserProperties(convertMapToJson);
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void clearUserProperties(String str, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.clearUserProperties();
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void setGroup(String str, String str2, String str3, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.setGroup(str2, str3);
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void uploadEvents(String str, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.uploadEvents();
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void getSessionId(String str, Promise promise) {
        synchronized (Amplitude.getInstance(str)) {
            promise.resolve(Double.valueOf(r3.getSessionId()));
        }
    }

    @ReactMethod
    public void setMinTimeBetweenSessionsMillis(String str, double d, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.setMinTimeBetweenSessionsMillis((long) d);
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void setServerZone(String str, String str2, boolean z, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.setServerZone(str2.equals("EU") ? AmplitudeServerZone.EU : AmplitudeServerZone.US, z);
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void setEventUploadMaxBatchSize(String str, int i, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.setEventUploadMaxBatchSize(i);
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void setEventUploadPeriodMillis(String str, int i, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.setEventUploadPeriodMillis(i);
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void setEventUploadThreshold(String str, int i, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.setEventUploadThreshold(i);
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void setPlan(String str, ReadableMap readableMap, Promise promise) {
        Plan plan = new Plan();
        if (readableMap.hasKey(Constants.AMP_PLAN_BRANCH)) {
            plan.setBranch(readableMap.getString(Constants.AMP_PLAN_BRANCH));
        }
        if (readableMap.hasKey("source")) {
            plan.setSource(readableMap.getString("source"));
        }
        if (readableMap.hasKey(Constants.AMP_PLAN_VERSION)) {
            plan.setVersion(readableMap.getString(Constants.AMP_PLAN_VERSION));
        }
        if (readableMap.hasKey(Constants.AMP_PLAN_VERSION_ID)) {
            plan.setVersionId(readableMap.getString(Constants.AMP_PLAN_VERSION_ID));
        }
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.setPlan(plan);
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void setIngestionMetadata(String str, ReadableMap readableMap, Promise promise) {
        IngestionMetadata ingestionMetadata = new IngestionMetadata();
        if (readableMap.hasKey("sourceName")) {
            ingestionMetadata.setSourceName(readableMap.getString("sourceName"));
        }
        if (readableMap.hasKey("sourceVersion")) {
            ingestionMetadata.setSourceVersion(readableMap.getString("sourceVersion"));
        }
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.setIngestionMetadata(ingestionMetadata);
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void enableLogging(String str, Boolean bool, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.enableLogging(bool.booleanValue());
            if (bool.booleanValue()) {
                amplitude.setLogCallback(new AmplitudeLogCallback() { // from class: com.amplitude.reactnative.AmplitudeReactNativeModule.1
                    @Override // com.amplitude.api.AmplitudeLogCallback
                    public void onError(String str2, String str3) {
                        WritableNativeMap writableNativeMap = new WritableNativeMap();
                        writableNativeMap.putString("tag", str2);
                        writableNativeMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, str3);
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) AmplitudeReactNativeModule.this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("AmplitudeLogError", writableNativeMap);
                    }
                });
            } else {
                amplitude.setLogCallback(null);
            }
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void setLogLevel(String str, Integer num, Promise promise) {
        AmplitudeClient amplitude = Amplitude.getInstance(str);
        synchronized (amplitude) {
            amplitude.setLogLevel(num.intValue());
            promise.resolve(true);
        }
    }

    private Revenue createRevenue(JSONObject jSONObject) {
        Revenue revenue = new Revenue();
        try {
            if (jSONObject.has("productId")) {
                revenue.setProductId(jSONObject.getString("productId"));
            }
            if (jSONObject.has(b.x)) {
                revenue.setPrice(jSONObject.getDouble(b.x));
            }
            if (jSONObject.has("quantity")) {
                revenue.setQuantity(jSONObject.getInt("quantity"));
            } else {
                revenue.setQuantity(1);
            }
            if (jSONObject.has("revenueType")) {
                revenue.setRevenueType(jSONObject.getString("revenueType"));
            }
            if (jSONObject.has(b.D) && jSONObject.has("receiptSignature")) {
                revenue.setReceipt(jSONObject.getString(b.D), jSONObject.getString("receiptSignature"));
            }
            if (jSONObject.has("eventProperties")) {
                revenue.setEventProperties(jSONObject.getJSONObject("eventProperties"));
            }
        } catch (JSONException unused) {
        }
        return revenue;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0082. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0154 A[Catch: JSONException -> 0x0009, TryCatch #0 {JSONException -> 0x0009, blocks: (B:6:0x0015, B:7:0x001d, B:9:0x0023, B:10:0x002d, B:13:0x0082, B:15:0x0086, B:17:0x008e, B:147:0x0096, B:149:0x009e, B:150:0x00a6, B:152:0x00ae, B:153:0x00b6, B:155:0x00be, B:156:0x00c6, B:158:0x00ce, B:18:0x00d5, B:20:0x00dd, B:129:0x00e5, B:131:0x00ed, B:132:0x00f5, B:134:0x00fd, B:135:0x0105, B:137:0x010d, B:138:0x0115, B:140:0x011d, B:141:0x0125, B:143:0x012d, B:144:0x0135, B:146:0x013d, B:21:0x0144, B:23:0x014c, B:111:0x0154, B:113:0x015c, B:114:0x0164, B:116:0x016c, B:117:0x0174, B:119:0x017c, B:120:0x0184, B:122:0x018c, B:123:0x0194, B:125:0x019c, B:126:0x01a4, B:128:0x01ac, B:24:0x01b3, B:26:0x01bb, B:93:0x01c3, B:95:0x01cb, B:96:0x01d3, B:98:0x01db, B:99:0x01e3, B:101:0x01eb, B:102:0x01f3, B:104:0x01fb, B:105:0x0203, B:107:0x020b, B:108:0x0213, B:110:0x021b, B:27:0x0222, B:29:0x022a, B:75:0x0232, B:77:0x023a, B:78:0x0242, B:80:0x024a, B:81:0x0252, B:83:0x025a, B:84:0x0262, B:86:0x026a, B:87:0x0272, B:89:0x027a, B:90:0x0282, B:92:0x028a, B:30:0x0291, B:32:0x0299, B:57:0x02a1, B:59:0x02a9, B:60:0x02b1, B:62:0x02b9, B:63:0x02c1, B:65:0x02c9, B:66:0x02d1, B:68:0x02d9, B:69:0x02e1, B:71:0x02e9, B:72:0x02f1, B:74:0x02f9, B:33:0x0300, B:35:0x0308, B:39:0x0310, B:41:0x0318, B:42:0x0320, B:44:0x0328, B:45:0x0330, B:47:0x0338, B:48:0x0340, B:50:0x0348, B:51:0x0350, B:53:0x0358, B:54:0x0360, B:56:0x0368, B:36:0x036f, B:169:0x0031, B:172:0x003b, B:175:0x0045, B:178:0x004f, B:181:0x0059, B:184:0x0063, B:187:0x006d, B:190:0x0077), top: B:5:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00e5 A[Catch: JSONException -> 0x0009, TryCatch #0 {JSONException -> 0x0009, blocks: (B:6:0x0015, B:7:0x001d, B:9:0x0023, B:10:0x002d, B:13:0x0082, B:15:0x0086, B:17:0x008e, B:147:0x0096, B:149:0x009e, B:150:0x00a6, B:152:0x00ae, B:153:0x00b6, B:155:0x00be, B:156:0x00c6, B:158:0x00ce, B:18:0x00d5, B:20:0x00dd, B:129:0x00e5, B:131:0x00ed, B:132:0x00f5, B:134:0x00fd, B:135:0x0105, B:137:0x010d, B:138:0x0115, B:140:0x011d, B:141:0x0125, B:143:0x012d, B:144:0x0135, B:146:0x013d, B:21:0x0144, B:23:0x014c, B:111:0x0154, B:113:0x015c, B:114:0x0164, B:116:0x016c, B:117:0x0174, B:119:0x017c, B:120:0x0184, B:122:0x018c, B:123:0x0194, B:125:0x019c, B:126:0x01a4, B:128:0x01ac, B:24:0x01b3, B:26:0x01bb, B:93:0x01c3, B:95:0x01cb, B:96:0x01d3, B:98:0x01db, B:99:0x01e3, B:101:0x01eb, B:102:0x01f3, B:104:0x01fb, B:105:0x0203, B:107:0x020b, B:108:0x0213, B:110:0x021b, B:27:0x0222, B:29:0x022a, B:75:0x0232, B:77:0x023a, B:78:0x0242, B:80:0x024a, B:81:0x0252, B:83:0x025a, B:84:0x0262, B:86:0x026a, B:87:0x0272, B:89:0x027a, B:90:0x0282, B:92:0x028a, B:30:0x0291, B:32:0x0299, B:57:0x02a1, B:59:0x02a9, B:60:0x02b1, B:62:0x02b9, B:63:0x02c1, B:65:0x02c9, B:66:0x02d1, B:68:0x02d9, B:69:0x02e1, B:71:0x02e9, B:72:0x02f1, B:74:0x02f9, B:33:0x0300, B:35:0x0308, B:39:0x0310, B:41:0x0318, B:42:0x0320, B:44:0x0328, B:45:0x0330, B:47:0x0338, B:48:0x0340, B:50:0x0348, B:51:0x0350, B:53:0x0358, B:54:0x0360, B:56:0x0368, B:36:0x036f, B:169:0x0031, B:172:0x003b, B:175:0x0045, B:178:0x004f, B:181:0x0059, B:184:0x0063, B:187:0x006d, B:190:0x0077), top: B:5:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00dd A[Catch: JSONException -> 0x0009, TryCatch #0 {JSONException -> 0x0009, blocks: (B:6:0x0015, B:7:0x001d, B:9:0x0023, B:10:0x002d, B:13:0x0082, B:15:0x0086, B:17:0x008e, B:147:0x0096, B:149:0x009e, B:150:0x00a6, B:152:0x00ae, B:153:0x00b6, B:155:0x00be, B:156:0x00c6, B:158:0x00ce, B:18:0x00d5, B:20:0x00dd, B:129:0x00e5, B:131:0x00ed, B:132:0x00f5, B:134:0x00fd, B:135:0x0105, B:137:0x010d, B:138:0x0115, B:140:0x011d, B:141:0x0125, B:143:0x012d, B:144:0x0135, B:146:0x013d, B:21:0x0144, B:23:0x014c, B:111:0x0154, B:113:0x015c, B:114:0x0164, B:116:0x016c, B:117:0x0174, B:119:0x017c, B:120:0x0184, B:122:0x018c, B:123:0x0194, B:125:0x019c, B:126:0x01a4, B:128:0x01ac, B:24:0x01b3, B:26:0x01bb, B:93:0x01c3, B:95:0x01cb, B:96:0x01d3, B:98:0x01db, B:99:0x01e3, B:101:0x01eb, B:102:0x01f3, B:104:0x01fb, B:105:0x0203, B:107:0x020b, B:108:0x0213, B:110:0x021b, B:27:0x0222, B:29:0x022a, B:75:0x0232, B:77:0x023a, B:78:0x0242, B:80:0x024a, B:81:0x0252, B:83:0x025a, B:84:0x0262, B:86:0x026a, B:87:0x0272, B:89:0x027a, B:90:0x0282, B:92:0x028a, B:30:0x0291, B:32:0x0299, B:57:0x02a1, B:59:0x02a9, B:60:0x02b1, B:62:0x02b9, B:63:0x02c1, B:65:0x02c9, B:66:0x02d1, B:68:0x02d9, B:69:0x02e1, B:71:0x02e9, B:72:0x02f1, B:74:0x02f9, B:33:0x0300, B:35:0x0308, B:39:0x0310, B:41:0x0318, B:42:0x0320, B:44:0x0328, B:45:0x0330, B:47:0x0338, B:48:0x0340, B:50:0x0348, B:51:0x0350, B:53:0x0358, B:54:0x0360, B:56:0x0368, B:36:0x036f, B:169:0x0031, B:172:0x003b, B:175:0x0045, B:178:0x004f, B:181:0x0059, B:184:0x0063, B:187:0x006d, B:190:0x0077), top: B:5:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x014c A[Catch: JSONException -> 0x0009, TryCatch #0 {JSONException -> 0x0009, blocks: (B:6:0x0015, B:7:0x001d, B:9:0x0023, B:10:0x002d, B:13:0x0082, B:15:0x0086, B:17:0x008e, B:147:0x0096, B:149:0x009e, B:150:0x00a6, B:152:0x00ae, B:153:0x00b6, B:155:0x00be, B:156:0x00c6, B:158:0x00ce, B:18:0x00d5, B:20:0x00dd, B:129:0x00e5, B:131:0x00ed, B:132:0x00f5, B:134:0x00fd, B:135:0x0105, B:137:0x010d, B:138:0x0115, B:140:0x011d, B:141:0x0125, B:143:0x012d, B:144:0x0135, B:146:0x013d, B:21:0x0144, B:23:0x014c, B:111:0x0154, B:113:0x015c, B:114:0x0164, B:116:0x016c, B:117:0x0174, B:119:0x017c, B:120:0x0184, B:122:0x018c, B:123:0x0194, B:125:0x019c, B:126:0x01a4, B:128:0x01ac, B:24:0x01b3, B:26:0x01bb, B:93:0x01c3, B:95:0x01cb, B:96:0x01d3, B:98:0x01db, B:99:0x01e3, B:101:0x01eb, B:102:0x01f3, B:104:0x01fb, B:105:0x0203, B:107:0x020b, B:108:0x0213, B:110:0x021b, B:27:0x0222, B:29:0x022a, B:75:0x0232, B:77:0x023a, B:78:0x0242, B:80:0x024a, B:81:0x0252, B:83:0x025a, B:84:0x0262, B:86:0x026a, B:87:0x0272, B:89:0x027a, B:90:0x0282, B:92:0x028a, B:30:0x0291, B:32:0x0299, B:57:0x02a1, B:59:0x02a9, B:60:0x02b1, B:62:0x02b9, B:63:0x02c1, B:65:0x02c9, B:66:0x02d1, B:68:0x02d9, B:69:0x02e1, B:71:0x02e9, B:72:0x02f1, B:74:0x02f9, B:33:0x0300, B:35:0x0308, B:39:0x0310, B:41:0x0318, B:42:0x0320, B:44:0x0328, B:45:0x0330, B:47:0x0338, B:48:0x0340, B:50:0x0348, B:51:0x0350, B:53:0x0358, B:54:0x0360, B:56:0x0368, B:36:0x036f, B:169:0x0031, B:172:0x003b, B:175:0x0045, B:178:0x004f, B:181:0x0059, B:184:0x0063, B:187:0x006d, B:190:0x0077), top: B:5:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01bb A[Catch: JSONException -> 0x0009, TryCatch #0 {JSONException -> 0x0009, blocks: (B:6:0x0015, B:7:0x001d, B:9:0x0023, B:10:0x002d, B:13:0x0082, B:15:0x0086, B:17:0x008e, B:147:0x0096, B:149:0x009e, B:150:0x00a6, B:152:0x00ae, B:153:0x00b6, B:155:0x00be, B:156:0x00c6, B:158:0x00ce, B:18:0x00d5, B:20:0x00dd, B:129:0x00e5, B:131:0x00ed, B:132:0x00f5, B:134:0x00fd, B:135:0x0105, B:137:0x010d, B:138:0x0115, B:140:0x011d, B:141:0x0125, B:143:0x012d, B:144:0x0135, B:146:0x013d, B:21:0x0144, B:23:0x014c, B:111:0x0154, B:113:0x015c, B:114:0x0164, B:116:0x016c, B:117:0x0174, B:119:0x017c, B:120:0x0184, B:122:0x018c, B:123:0x0194, B:125:0x019c, B:126:0x01a4, B:128:0x01ac, B:24:0x01b3, B:26:0x01bb, B:93:0x01c3, B:95:0x01cb, B:96:0x01d3, B:98:0x01db, B:99:0x01e3, B:101:0x01eb, B:102:0x01f3, B:104:0x01fb, B:105:0x0203, B:107:0x020b, B:108:0x0213, B:110:0x021b, B:27:0x0222, B:29:0x022a, B:75:0x0232, B:77:0x023a, B:78:0x0242, B:80:0x024a, B:81:0x0252, B:83:0x025a, B:84:0x0262, B:86:0x026a, B:87:0x0272, B:89:0x027a, B:90:0x0282, B:92:0x028a, B:30:0x0291, B:32:0x0299, B:57:0x02a1, B:59:0x02a9, B:60:0x02b1, B:62:0x02b9, B:63:0x02c1, B:65:0x02c9, B:66:0x02d1, B:68:0x02d9, B:69:0x02e1, B:71:0x02e9, B:72:0x02f1, B:74:0x02f9, B:33:0x0300, B:35:0x0308, B:39:0x0310, B:41:0x0318, B:42:0x0320, B:44:0x0328, B:45:0x0330, B:47:0x0338, B:48:0x0340, B:50:0x0348, B:51:0x0350, B:53:0x0358, B:54:0x0360, B:56:0x0368, B:36:0x036f, B:169:0x0031, B:172:0x003b, B:175:0x0045, B:178:0x004f, B:181:0x0059, B:184:0x0063, B:187:0x006d, B:190:0x0077), top: B:5:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x022a A[Catch: JSONException -> 0x0009, TryCatch #0 {JSONException -> 0x0009, blocks: (B:6:0x0015, B:7:0x001d, B:9:0x0023, B:10:0x002d, B:13:0x0082, B:15:0x0086, B:17:0x008e, B:147:0x0096, B:149:0x009e, B:150:0x00a6, B:152:0x00ae, B:153:0x00b6, B:155:0x00be, B:156:0x00c6, B:158:0x00ce, B:18:0x00d5, B:20:0x00dd, B:129:0x00e5, B:131:0x00ed, B:132:0x00f5, B:134:0x00fd, B:135:0x0105, B:137:0x010d, B:138:0x0115, B:140:0x011d, B:141:0x0125, B:143:0x012d, B:144:0x0135, B:146:0x013d, B:21:0x0144, B:23:0x014c, B:111:0x0154, B:113:0x015c, B:114:0x0164, B:116:0x016c, B:117:0x0174, B:119:0x017c, B:120:0x0184, B:122:0x018c, B:123:0x0194, B:125:0x019c, B:126:0x01a4, B:128:0x01ac, B:24:0x01b3, B:26:0x01bb, B:93:0x01c3, B:95:0x01cb, B:96:0x01d3, B:98:0x01db, B:99:0x01e3, B:101:0x01eb, B:102:0x01f3, B:104:0x01fb, B:105:0x0203, B:107:0x020b, B:108:0x0213, B:110:0x021b, B:27:0x0222, B:29:0x022a, B:75:0x0232, B:77:0x023a, B:78:0x0242, B:80:0x024a, B:81:0x0252, B:83:0x025a, B:84:0x0262, B:86:0x026a, B:87:0x0272, B:89:0x027a, B:90:0x0282, B:92:0x028a, B:30:0x0291, B:32:0x0299, B:57:0x02a1, B:59:0x02a9, B:60:0x02b1, B:62:0x02b9, B:63:0x02c1, B:65:0x02c9, B:66:0x02d1, B:68:0x02d9, B:69:0x02e1, B:71:0x02e9, B:72:0x02f1, B:74:0x02f9, B:33:0x0300, B:35:0x0308, B:39:0x0310, B:41:0x0318, B:42:0x0320, B:44:0x0328, B:45:0x0330, B:47:0x0338, B:48:0x0340, B:50:0x0348, B:51:0x0350, B:53:0x0358, B:54:0x0360, B:56:0x0368, B:36:0x036f, B:169:0x0031, B:172:0x003b, B:175:0x0045, B:178:0x004f, B:181:0x0059, B:184:0x0063, B:187:0x006d, B:190:0x0077), top: B:5:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0299 A[Catch: JSONException -> 0x0009, TryCatch #0 {JSONException -> 0x0009, blocks: (B:6:0x0015, B:7:0x001d, B:9:0x0023, B:10:0x002d, B:13:0x0082, B:15:0x0086, B:17:0x008e, B:147:0x0096, B:149:0x009e, B:150:0x00a6, B:152:0x00ae, B:153:0x00b6, B:155:0x00be, B:156:0x00c6, B:158:0x00ce, B:18:0x00d5, B:20:0x00dd, B:129:0x00e5, B:131:0x00ed, B:132:0x00f5, B:134:0x00fd, B:135:0x0105, B:137:0x010d, B:138:0x0115, B:140:0x011d, B:141:0x0125, B:143:0x012d, B:144:0x0135, B:146:0x013d, B:21:0x0144, B:23:0x014c, B:111:0x0154, B:113:0x015c, B:114:0x0164, B:116:0x016c, B:117:0x0174, B:119:0x017c, B:120:0x0184, B:122:0x018c, B:123:0x0194, B:125:0x019c, B:126:0x01a4, B:128:0x01ac, B:24:0x01b3, B:26:0x01bb, B:93:0x01c3, B:95:0x01cb, B:96:0x01d3, B:98:0x01db, B:99:0x01e3, B:101:0x01eb, B:102:0x01f3, B:104:0x01fb, B:105:0x0203, B:107:0x020b, B:108:0x0213, B:110:0x021b, B:27:0x0222, B:29:0x022a, B:75:0x0232, B:77:0x023a, B:78:0x0242, B:80:0x024a, B:81:0x0252, B:83:0x025a, B:84:0x0262, B:86:0x026a, B:87:0x0272, B:89:0x027a, B:90:0x0282, B:92:0x028a, B:30:0x0291, B:32:0x0299, B:57:0x02a1, B:59:0x02a9, B:60:0x02b1, B:62:0x02b9, B:63:0x02c1, B:65:0x02c9, B:66:0x02d1, B:68:0x02d9, B:69:0x02e1, B:71:0x02e9, B:72:0x02f1, B:74:0x02f9, B:33:0x0300, B:35:0x0308, B:39:0x0310, B:41:0x0318, B:42:0x0320, B:44:0x0328, B:45:0x0330, B:47:0x0338, B:48:0x0340, B:50:0x0348, B:51:0x0350, B:53:0x0358, B:54:0x0360, B:56:0x0368, B:36:0x036f, B:169:0x0031, B:172:0x003b, B:175:0x0045, B:178:0x004f, B:181:0x0059, B:184:0x0063, B:187:0x006d, B:190:0x0077), top: B:5:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0308 A[Catch: JSONException -> 0x0009, TryCatch #0 {JSONException -> 0x0009, blocks: (B:6:0x0015, B:7:0x001d, B:9:0x0023, B:10:0x002d, B:13:0x0082, B:15:0x0086, B:17:0x008e, B:147:0x0096, B:149:0x009e, B:150:0x00a6, B:152:0x00ae, B:153:0x00b6, B:155:0x00be, B:156:0x00c6, B:158:0x00ce, B:18:0x00d5, B:20:0x00dd, B:129:0x00e5, B:131:0x00ed, B:132:0x00f5, B:134:0x00fd, B:135:0x0105, B:137:0x010d, B:138:0x0115, B:140:0x011d, B:141:0x0125, B:143:0x012d, B:144:0x0135, B:146:0x013d, B:21:0x0144, B:23:0x014c, B:111:0x0154, B:113:0x015c, B:114:0x0164, B:116:0x016c, B:117:0x0174, B:119:0x017c, B:120:0x0184, B:122:0x018c, B:123:0x0194, B:125:0x019c, B:126:0x01a4, B:128:0x01ac, B:24:0x01b3, B:26:0x01bb, B:93:0x01c3, B:95:0x01cb, B:96:0x01d3, B:98:0x01db, B:99:0x01e3, B:101:0x01eb, B:102:0x01f3, B:104:0x01fb, B:105:0x0203, B:107:0x020b, B:108:0x0213, B:110:0x021b, B:27:0x0222, B:29:0x022a, B:75:0x0232, B:77:0x023a, B:78:0x0242, B:80:0x024a, B:81:0x0252, B:83:0x025a, B:84:0x0262, B:86:0x026a, B:87:0x0272, B:89:0x027a, B:90:0x0282, B:92:0x028a, B:30:0x0291, B:32:0x0299, B:57:0x02a1, B:59:0x02a9, B:60:0x02b1, B:62:0x02b9, B:63:0x02c1, B:65:0x02c9, B:66:0x02d1, B:68:0x02d9, B:69:0x02e1, B:71:0x02e9, B:72:0x02f1, B:74:0x02f9, B:33:0x0300, B:35:0x0308, B:39:0x0310, B:41:0x0318, B:42:0x0320, B:44:0x0328, B:45:0x0330, B:47:0x0338, B:48:0x0340, B:50:0x0348, B:51:0x0350, B:53:0x0358, B:54:0x0360, B:56:0x0368, B:36:0x036f, B:169:0x0031, B:172:0x003b, B:175:0x0045, B:178:0x004f, B:181:0x0059, B:184:0x0063, B:187:0x006d, B:190:0x0077), top: B:5:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0310 A[Catch: JSONException -> 0x0009, TryCatch #0 {JSONException -> 0x0009, blocks: (B:6:0x0015, B:7:0x001d, B:9:0x0023, B:10:0x002d, B:13:0x0082, B:15:0x0086, B:17:0x008e, B:147:0x0096, B:149:0x009e, B:150:0x00a6, B:152:0x00ae, B:153:0x00b6, B:155:0x00be, B:156:0x00c6, B:158:0x00ce, B:18:0x00d5, B:20:0x00dd, B:129:0x00e5, B:131:0x00ed, B:132:0x00f5, B:134:0x00fd, B:135:0x0105, B:137:0x010d, B:138:0x0115, B:140:0x011d, B:141:0x0125, B:143:0x012d, B:144:0x0135, B:146:0x013d, B:21:0x0144, B:23:0x014c, B:111:0x0154, B:113:0x015c, B:114:0x0164, B:116:0x016c, B:117:0x0174, B:119:0x017c, B:120:0x0184, B:122:0x018c, B:123:0x0194, B:125:0x019c, B:126:0x01a4, B:128:0x01ac, B:24:0x01b3, B:26:0x01bb, B:93:0x01c3, B:95:0x01cb, B:96:0x01d3, B:98:0x01db, B:99:0x01e3, B:101:0x01eb, B:102:0x01f3, B:104:0x01fb, B:105:0x0203, B:107:0x020b, B:108:0x0213, B:110:0x021b, B:27:0x0222, B:29:0x022a, B:75:0x0232, B:77:0x023a, B:78:0x0242, B:80:0x024a, B:81:0x0252, B:83:0x025a, B:84:0x0262, B:86:0x026a, B:87:0x0272, B:89:0x027a, B:90:0x0282, B:92:0x028a, B:30:0x0291, B:32:0x0299, B:57:0x02a1, B:59:0x02a9, B:60:0x02b1, B:62:0x02b9, B:63:0x02c1, B:65:0x02c9, B:66:0x02d1, B:68:0x02d9, B:69:0x02e1, B:71:0x02e9, B:72:0x02f1, B:74:0x02f9, B:33:0x0300, B:35:0x0308, B:39:0x0310, B:41:0x0318, B:42:0x0320, B:44:0x0328, B:45:0x0330, B:47:0x0338, B:48:0x0340, B:50:0x0348, B:51:0x0350, B:53:0x0358, B:54:0x0360, B:56:0x0368, B:36:0x036f, B:169:0x0031, B:172:0x003b, B:175:0x0045, B:178:0x004f, B:181:0x0059, B:184:0x0063, B:187:0x006d, B:190:0x0077), top: B:5:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02a1 A[Catch: JSONException -> 0x0009, TryCatch #0 {JSONException -> 0x0009, blocks: (B:6:0x0015, B:7:0x001d, B:9:0x0023, B:10:0x002d, B:13:0x0082, B:15:0x0086, B:17:0x008e, B:147:0x0096, B:149:0x009e, B:150:0x00a6, B:152:0x00ae, B:153:0x00b6, B:155:0x00be, B:156:0x00c6, B:158:0x00ce, B:18:0x00d5, B:20:0x00dd, B:129:0x00e5, B:131:0x00ed, B:132:0x00f5, B:134:0x00fd, B:135:0x0105, B:137:0x010d, B:138:0x0115, B:140:0x011d, B:141:0x0125, B:143:0x012d, B:144:0x0135, B:146:0x013d, B:21:0x0144, B:23:0x014c, B:111:0x0154, B:113:0x015c, B:114:0x0164, B:116:0x016c, B:117:0x0174, B:119:0x017c, B:120:0x0184, B:122:0x018c, B:123:0x0194, B:125:0x019c, B:126:0x01a4, B:128:0x01ac, B:24:0x01b3, B:26:0x01bb, B:93:0x01c3, B:95:0x01cb, B:96:0x01d3, B:98:0x01db, B:99:0x01e3, B:101:0x01eb, B:102:0x01f3, B:104:0x01fb, B:105:0x0203, B:107:0x020b, B:108:0x0213, B:110:0x021b, B:27:0x0222, B:29:0x022a, B:75:0x0232, B:77:0x023a, B:78:0x0242, B:80:0x024a, B:81:0x0252, B:83:0x025a, B:84:0x0262, B:86:0x026a, B:87:0x0272, B:89:0x027a, B:90:0x0282, B:92:0x028a, B:30:0x0291, B:32:0x0299, B:57:0x02a1, B:59:0x02a9, B:60:0x02b1, B:62:0x02b9, B:63:0x02c1, B:65:0x02c9, B:66:0x02d1, B:68:0x02d9, B:69:0x02e1, B:71:0x02e9, B:72:0x02f1, B:74:0x02f9, B:33:0x0300, B:35:0x0308, B:39:0x0310, B:41:0x0318, B:42:0x0320, B:44:0x0328, B:45:0x0330, B:47:0x0338, B:48:0x0340, B:50:0x0348, B:51:0x0350, B:53:0x0358, B:54:0x0360, B:56:0x0368, B:36:0x036f, B:169:0x0031, B:172:0x003b, B:175:0x0045, B:178:0x004f, B:181:0x0059, B:184:0x0063, B:187:0x006d, B:190:0x0077), top: B:5:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0232 A[Catch: JSONException -> 0x0009, TryCatch #0 {JSONException -> 0x0009, blocks: (B:6:0x0015, B:7:0x001d, B:9:0x0023, B:10:0x002d, B:13:0x0082, B:15:0x0086, B:17:0x008e, B:147:0x0096, B:149:0x009e, B:150:0x00a6, B:152:0x00ae, B:153:0x00b6, B:155:0x00be, B:156:0x00c6, B:158:0x00ce, B:18:0x00d5, B:20:0x00dd, B:129:0x00e5, B:131:0x00ed, B:132:0x00f5, B:134:0x00fd, B:135:0x0105, B:137:0x010d, B:138:0x0115, B:140:0x011d, B:141:0x0125, B:143:0x012d, B:144:0x0135, B:146:0x013d, B:21:0x0144, B:23:0x014c, B:111:0x0154, B:113:0x015c, B:114:0x0164, B:116:0x016c, B:117:0x0174, B:119:0x017c, B:120:0x0184, B:122:0x018c, B:123:0x0194, B:125:0x019c, B:126:0x01a4, B:128:0x01ac, B:24:0x01b3, B:26:0x01bb, B:93:0x01c3, B:95:0x01cb, B:96:0x01d3, B:98:0x01db, B:99:0x01e3, B:101:0x01eb, B:102:0x01f3, B:104:0x01fb, B:105:0x0203, B:107:0x020b, B:108:0x0213, B:110:0x021b, B:27:0x0222, B:29:0x022a, B:75:0x0232, B:77:0x023a, B:78:0x0242, B:80:0x024a, B:81:0x0252, B:83:0x025a, B:84:0x0262, B:86:0x026a, B:87:0x0272, B:89:0x027a, B:90:0x0282, B:92:0x028a, B:30:0x0291, B:32:0x0299, B:57:0x02a1, B:59:0x02a9, B:60:0x02b1, B:62:0x02b9, B:63:0x02c1, B:65:0x02c9, B:66:0x02d1, B:68:0x02d9, B:69:0x02e1, B:71:0x02e9, B:72:0x02f1, B:74:0x02f9, B:33:0x0300, B:35:0x0308, B:39:0x0310, B:41:0x0318, B:42:0x0320, B:44:0x0328, B:45:0x0330, B:47:0x0338, B:48:0x0340, B:50:0x0348, B:51:0x0350, B:53:0x0358, B:54:0x0360, B:56:0x0368, B:36:0x036f, B:169:0x0031, B:172:0x003b, B:175:0x0045, B:178:0x004f, B:181:0x0059, B:184:0x0063, B:187:0x006d, B:190:0x0077), top: B:5:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01c3 A[Catch: JSONException -> 0x0009, TryCatch #0 {JSONException -> 0x0009, blocks: (B:6:0x0015, B:7:0x001d, B:9:0x0023, B:10:0x002d, B:13:0x0082, B:15:0x0086, B:17:0x008e, B:147:0x0096, B:149:0x009e, B:150:0x00a6, B:152:0x00ae, B:153:0x00b6, B:155:0x00be, B:156:0x00c6, B:158:0x00ce, B:18:0x00d5, B:20:0x00dd, B:129:0x00e5, B:131:0x00ed, B:132:0x00f5, B:134:0x00fd, B:135:0x0105, B:137:0x010d, B:138:0x0115, B:140:0x011d, B:141:0x0125, B:143:0x012d, B:144:0x0135, B:146:0x013d, B:21:0x0144, B:23:0x014c, B:111:0x0154, B:113:0x015c, B:114:0x0164, B:116:0x016c, B:117:0x0174, B:119:0x017c, B:120:0x0184, B:122:0x018c, B:123:0x0194, B:125:0x019c, B:126:0x01a4, B:128:0x01ac, B:24:0x01b3, B:26:0x01bb, B:93:0x01c3, B:95:0x01cb, B:96:0x01d3, B:98:0x01db, B:99:0x01e3, B:101:0x01eb, B:102:0x01f3, B:104:0x01fb, B:105:0x0203, B:107:0x020b, B:108:0x0213, B:110:0x021b, B:27:0x0222, B:29:0x022a, B:75:0x0232, B:77:0x023a, B:78:0x0242, B:80:0x024a, B:81:0x0252, B:83:0x025a, B:84:0x0262, B:86:0x026a, B:87:0x0272, B:89:0x027a, B:90:0x0282, B:92:0x028a, B:30:0x0291, B:32:0x0299, B:57:0x02a1, B:59:0x02a9, B:60:0x02b1, B:62:0x02b9, B:63:0x02c1, B:65:0x02c9, B:66:0x02d1, B:68:0x02d9, B:69:0x02e1, B:71:0x02e9, B:72:0x02f1, B:74:0x02f9, B:33:0x0300, B:35:0x0308, B:39:0x0310, B:41:0x0318, B:42:0x0320, B:44:0x0328, B:45:0x0330, B:47:0x0338, B:48:0x0340, B:50:0x0348, B:51:0x0350, B:53:0x0358, B:54:0x0360, B:56:0x0368, B:36:0x036f, B:169:0x0031, B:172:0x003b, B:175:0x0045, B:178:0x004f, B:181:0x0059, B:184:0x0063, B:187:0x006d, B:190:0x0077), top: B:5:0x0015 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amplitude.api.Identify createIdentify(org.json.JSONObject r9) {
        /*
            Method dump skipped, instructions count: 940
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.reactnative.AmplitudeReactNativeModule.createIdentify(org.json.JSONObject):com.amplitude.api.Identify");
    }
}
