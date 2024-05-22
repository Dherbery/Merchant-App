package com.mrousavy.camera.extensions;

import android.hardware.camera2.CameraDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraDevice+isValid.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0004"}, d2 = {"isValid", "", "Landroid/hardware/camera2/CameraDevice;", "(Landroid/hardware/camera2/CameraDevice;)Z", "react-native-vision-camera_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraDevice_isValidKt {
    public static final boolean isValid(CameraDevice cameraDevice) {
        Intrinsics.checkNotNullParameter(cameraDevice, "<this>");
        try {
            cameraDevice.createCaptureRequest(1);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
