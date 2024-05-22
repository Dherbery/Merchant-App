package com.mrousavy.camera.types;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CameraDeviceError.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/mrousavy/camera/types/CameraDeviceError;", "", "Lcom/mrousavy/camera/types/JSUnionValue;", "unionValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "CAMERA_ALREADY_IN_USE", "TOO_MANY_OPEN_CAMERAS", "CAMERA_IS_DISABLED_BY_ANDROID", "UNKNOWN_CAMERA_DEVICE_ERROR", "UNKNOWN_FATAL_CAMERA_SERVICE_ERROR", "DISCONNECTED", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum CameraDeviceError implements JSUnionValue {
    CAMERA_ALREADY_IN_USE("camera-already-in-use"),
    TOO_MANY_OPEN_CAMERAS("too-many-open-cameras"),
    CAMERA_IS_DISABLED_BY_ANDROID("camera-is-disabled-by-android"),
    UNKNOWN_CAMERA_DEVICE_ERROR("unknown-camera-device-error"),
    UNKNOWN_FATAL_CAMERA_SERVICE_ERROR("unknown-fatal-camera-service-error"),
    DISCONNECTED("camera-has-been-disconnected");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String unionValue;

    CameraDeviceError(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    /* compiled from: CameraDeviceError.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/types/CameraDeviceError$Companion;", "", "()V", "fromCameraDeviceError", "Lcom/mrousavy/camera/types/CameraDeviceError;", "cameraDeviceError", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CameraDeviceError fromCameraDeviceError(int cameraDeviceError) {
            if (cameraDeviceError == 1) {
                return CameraDeviceError.CAMERA_ALREADY_IN_USE;
            }
            if (cameraDeviceError == 2) {
                return CameraDeviceError.TOO_MANY_OPEN_CAMERAS;
            }
            if (cameraDeviceError == 3) {
                return CameraDeviceError.CAMERA_IS_DISABLED_BY_ANDROID;
            }
            if (cameraDeviceError == 4) {
                return CameraDeviceError.UNKNOWN_CAMERA_DEVICE_ERROR;
            }
            if (cameraDeviceError == 5) {
                return CameraDeviceError.UNKNOWN_FATAL_CAMERA_SERVICE_ERROR;
            }
            return CameraDeviceError.UNKNOWN_CAMERA_DEVICE_ERROR;
        }
    }
}
