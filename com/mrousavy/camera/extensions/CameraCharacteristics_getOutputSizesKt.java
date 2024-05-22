package com.mrousavy.camera.extensions;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import com.mrousavy.camera.utils.CamcorderProfileUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraCharacteristics+getOutputSizes.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\t"}, d2 = {"getPhotoSizes", "", "Landroid/util/Size;", "Landroid/hardware/camera2/CameraCharacteristics;", "format", "", "getVideoSizes", "cameraId", "", "react-native-vision-camera_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraCharacteristics_getOutputSizesKt {
    public static final List<Size> getVideoSizes(CameraCharacteristics cameraCharacteristics, String cameraId, int i) {
        Intrinsics.checkNotNullParameter(cameraCharacteristics, "<this>");
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Object obj = cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        Intrinsics.checkNotNull(obj);
        Size[] outputSizes = ((StreamConfigurationMap) obj).getOutputSizes(i);
        if (outputSizes == null) {
            outputSizes = new Size[0];
        }
        Size maximumVideoSize = CamcorderProfileUtils.INSTANCE.getMaximumVideoSize(cameraId);
        if (maximumVideoSize == null) {
            return ArraysKt.toList(outputSizes);
        }
        ArrayList arrayList = new ArrayList();
        for (Size it : outputSizes) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (Size_ExtensionsKt.getBigger(it) <= Size_ExtensionsKt.getBigger(maximumVideoSize)) {
                arrayList.add(it);
            }
        }
        return arrayList;
    }

    public static final List<Size> getPhotoSizes(CameraCharacteristics cameraCharacteristics, int i) {
        Intrinsics.checkNotNullParameter(cameraCharacteristics, "<this>");
        Object obj = cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        Intrinsics.checkNotNull(obj);
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) obj;
        Size[] outputSizes = streamConfigurationMap.getOutputSizes(i);
        if (outputSizes == null) {
            outputSizes = new Size[0];
        }
        Size[] highResolutionOutputSizes = streamConfigurationMap.getHighResolutionOutputSizes(i);
        if (highResolutionOutputSizes == null) {
            highResolutionOutputSizes = new Size[0];
        }
        return ArraysKt.toList(ArraysKt.plus((Object[]) outputSizes, (Object[]) highResolutionOutputSizes));
    }
}
