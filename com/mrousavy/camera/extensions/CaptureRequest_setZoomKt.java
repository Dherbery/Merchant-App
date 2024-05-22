package com.mrousavy.camera.extensions;

import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import com.mrousavy.camera.core.CameraDeviceDetails;
import com.mrousavy.camera.types.HardwareLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CaptureRequest+setZoom.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"setZoom", "", "Landroid/hardware/camera2/CaptureRequest$Builder;", "zoom", "", "deviceDetails", "Lcom/mrousavy/camera/core/CameraDeviceDetails;", "react-native-vision-camera_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CaptureRequest_setZoomKt {
    public static final void setZoom(CaptureRequest.Builder builder, float f, CameraDeviceDetails deviceDetails) {
        CaptureRequest.Key key;
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(deviceDetails, "deviceDetails");
        Float zoomClamped = deviceDetails.getZoomRange().clamp(Float.valueOf(f));
        if (deviceDetails.getHardwareLevel().isAtLeast(HardwareLevel.LIMITED) && Build.VERSION.SDK_INT >= 30) {
            key = CaptureRequest.CONTROL_ZOOM_RATIO;
            builder.set(key, zoomClamped);
        } else {
            Rect activeSize = deviceDetails.getActiveSize();
            CaptureRequest.Key key2 = CaptureRequest.SCALER_CROP_REGION;
            Intrinsics.checkNotNullExpressionValue(zoomClamped, "zoomClamped");
            builder.set(key2, Rect_zoomedKt.zoomed(activeSize, zoomClamped.floatValue()));
        }
    }
}
