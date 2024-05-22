package com.mrousavy.camera;

import android.hardware.camera2.CameraManager;
import android.os.Handler;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.mrousavy.camera.core.CameraDeviceDetails;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.NewHtcHomeBadger;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraDevicesManager.kt */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0016\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0006\u0010\u0019\u001a\u00020\u000bR\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/mrousavy/camera/CameraDevicesManager;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "callback", "com/mrousavy/camera/CameraDevicesManager$callback$1", "Lcom/mrousavy/camera/CameraDevicesManager$callback$1;", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "addListener", "", "eventName", "", "getConstants", "", "", "getDevicesJson", "Lcom/facebook/react/bridge/ReadableArray;", "getName", "initialize", "invalidate", "removeListeners", NewHtcHomeBadger.COUNT, "", "sendAvailableDevicesChangedEvent", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraDevicesManager extends ReactContextBaseJavaModule {
    private static final String TAG = "CameraDevices";
    private final CameraDevicesManager$callback$1 callback;
    private final CameraManager cameraManager;
    private final ReactApplicationContext reactContext;

    @ReactMethod
    public final void addListener(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }

    @ReactMethod
    public final void removeListeners(int count) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.mrousavy.camera.CameraDevicesManager$callback$1] */
    public CameraDevicesManager(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        Object systemService = reactContext.getSystemService("camera");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        this.cameraManager = (CameraManager) systemService;
        this.callback = new CameraManager.AvailabilityCallback() { // from class: com.mrousavy.camera.CameraDevicesManager$callback$1
            private List<String> devices;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                CameraManager cameraManager;
                cameraManager = CameraDevicesManager.this.cameraManager;
                String[] cameraIdList = cameraManager.getCameraIdList();
                Intrinsics.checkNotNullExpressionValue(cameraIdList, "cameraManager.cameraIdList");
                this.devices = ArraysKt.toMutableList(cameraIdList);
            }

            private final boolean isDeviceConnected(String cameraId) {
                CameraManager cameraManager;
                try {
                    cameraManager = CameraDevicesManager.this.cameraManager;
                    cameraManager.getCameraCharacteristics(cameraId);
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }

            @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
            public void onCameraAvailable(String cameraId) {
                Intrinsics.checkNotNullParameter(cameraId, "cameraId");
                Log.i("CameraDevices", "Camera #" + cameraId + " is now available.");
                if (this.devices.contains(cameraId)) {
                    return;
                }
                this.devices.add(cameraId);
                CameraDevicesManager.this.sendAvailableDevicesChangedEvent();
            }

            @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
            public void onCameraUnavailable(String cameraId) {
                Intrinsics.checkNotNullParameter(cameraId, "cameraId");
                Log.i("CameraDevices", "Camera #" + cameraId + " is now unavailable.");
                if (!this.devices.contains(cameraId) || isDeviceConnected(cameraId)) {
                    return;
                }
                this.devices.remove(cameraId);
                CameraDevicesManager.this.sendAvailableDevicesChangedEvent();
            }
        };
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        this.cameraManager.registerAvailabilityCallback(this.callback, (Handler) null);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        this.cameraManager.unregisterAvailabilityCallback(this.callback);
        super.invalidate();
    }

    private final ReadableArray getDevicesJson() {
        WritableArray devices = Arguments.createArray();
        String[] cameraIdList = this.cameraManager.getCameraIdList();
        Intrinsics.checkNotNullExpressionValue(cameraIdList, "cameraManager.cameraIdList");
        for (String cameraId : cameraIdList) {
            CameraManager cameraManager = this.cameraManager;
            Intrinsics.checkNotNullExpressionValue(cameraId, "cameraId");
            devices.pushMap(new CameraDeviceDetails(cameraManager, cameraId).toMap());
        }
        Intrinsics.checkNotNullExpressionValue(devices, "devices");
        return devices;
    }

    public final void sendAvailableDevicesChangedEvent() {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("CameraDevicesChanged", getDevicesJson());
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        ReadableArray devicesJson = getDevicesJson();
        ReadableMap map = devicesJson.size() > 0 ? devicesJson.getMap(0) : null;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("availableCameraDevices", devicesJson);
        pairArr[1] = TuplesKt.to("userPreferredCameraDevice", map != null ? map.toHashMap() : null);
        return MapsKt.mutableMapOf(pairArr);
    }
}
