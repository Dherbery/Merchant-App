package com.mrousavy.camera.core.capture;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import android.util.Log;
import com.mrousavy.camera.core.CameraDeviceDetails;
import com.mrousavy.camera.core.capture.CameraCaptureRequest;
import com.mrousavy.camera.core.outputs.SurfaceOutput;
import com.mrousavy.camera.types.HardwareLevel;
import com.mrousavy.camera.types.Orientation;
import com.mrousavy.camera.types.QualityPrioritization;
import com.mrousavy.camera.types.Torch;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhotoCaptureRequest.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J.\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/mrousavy/camera/core/capture/PhotoCaptureRequest;", "Lcom/mrousavy/camera/core/capture/CameraCaptureRequest;", "repeatingRequest", "Lcom/mrousavy/camera/core/capture/RepeatingCaptureRequest;", "qualityPrioritization", "Lcom/mrousavy/camera/types/QualityPrioritization;", "enableAutoStabilization", "", "enablePhotoHdr", "outputOrientation", "Lcom/mrousavy/camera/types/Orientation;", "(Lcom/mrousavy/camera/core/capture/RepeatingCaptureRequest;Lcom/mrousavy/camera/types/QualityPrioritization;ZZLcom/mrousavy/camera/types/Orientation;)V", "createCaptureRequest", "Landroid/hardware/camera2/CaptureRequest$Builder;", "device", "Landroid/hardware/camera2/CameraDevice;", "deviceDetails", "Lcom/mrousavy/camera/core/CameraDeviceDetails;", "outputs", "", "Lcom/mrousavy/camera/core/outputs/SurfaceOutput;", "template", "Lcom/mrousavy/camera/core/capture/CameraCaptureRequest$Template;", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PhotoCaptureRequest extends CameraCaptureRequest {
    private static final String TAG = "PhotoCaptureRequest";
    private final boolean enableAutoStabilization;
    private final Orientation outputOrientation;
    private final QualityPrioritization qualityPrioritization;

    /* compiled from: PhotoCaptureRequest.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[QualityPrioritization.values().length];
            try {
                iArr[QualityPrioritization.QUALITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[QualityPrioritization.BALANCED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[QualityPrioritization.SPEED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoCaptureRequest(RepeatingCaptureRequest repeatingRequest, QualityPrioritization qualityPrioritization, boolean z, boolean z2, Orientation outputOrientation) {
        super(Torch.OFF, z2, repeatingRequest.getEnableLowLightBoost(), repeatingRequest.getExposureBias(), repeatingRequest.getZoom(), repeatingRequest.getFormat());
        Intrinsics.checkNotNullParameter(repeatingRequest, "repeatingRequest");
        Intrinsics.checkNotNullParameter(qualityPrioritization, "qualityPrioritization");
        Intrinsics.checkNotNullParameter(outputOrientation, "outputOrientation");
        this.qualityPrioritization = qualityPrioritization;
        this.enableAutoStabilization = z;
        this.outputOrientation = outputOrientation;
    }

    @Override // com.mrousavy.camera.core.capture.CameraCaptureRequest
    public CaptureRequest.Builder createCaptureRequest(CameraDevice device, CameraDeviceDetails deviceDetails, List<? extends SurfaceOutput> outputs) {
        CameraCaptureRequest.Template template;
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(deviceDetails, "deviceDetails");
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        int i = WhenMappings.$EnumSwitchMapping$0[this.qualityPrioritization.ordinal()];
        if (i == 1) {
            template = CameraCaptureRequest.Template.PHOTO;
        } else if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            if (deviceDetails.getSupportsSnapshotCapture()) {
                template = CameraCaptureRequest.Template.PHOTO_SNAPSHOT;
            } else if (deviceDetails.getSupportsZsl()) {
                template = CameraCaptureRequest.Template.PHOTO_ZSL;
            } else {
                template = CameraCaptureRequest.Template.PHOTO;
            }
        } else if (deviceDetails.getSupportsZsl()) {
            template = CameraCaptureRequest.Template.PHOTO_ZSL;
        } else {
            template = CameraCaptureRequest.Template.PHOTO;
        }
        Log.i(TAG, "Using CaptureRequest Template " + template + "...");
        return createCaptureRequest(template, device, deviceDetails, outputs);
    }

    @Override // com.mrousavy.camera.core.capture.CameraCaptureRequest
    protected CaptureRequest.Builder createCaptureRequest(CameraCaptureRequest.Template template, CameraDevice device, CameraDeviceDetails deviceDetails, List<? extends SurfaceOutput> outputs) {
        CaptureRequest.Key key;
        CaptureRequest.Key key2;
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(deviceDetails, "deviceDetails");
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        CaptureRequest.Builder createCaptureRequest = super.createCaptureRequest(template, device, deviceDetails, outputs);
        int i = WhenMappings.$EnumSwitchMapping$0[this.qualityPrioritization.ordinal()];
        if (i == 1) {
            if (deviceDetails.getHardwareLevel().isAtLeast(HardwareLevel.FULL)) {
                createCaptureRequest.set(CaptureRequest.COLOR_CORRECTION_MODE, 2);
                int[] availableEdgeModes = deviceDetails.getAvailableEdgeModes();
                Intrinsics.checkNotNullExpressionValue(availableEdgeModes, "deviceDetails.availableEdgeModes");
                if (ArraysKt.contains(availableEdgeModes, 2)) {
                    createCaptureRequest.set(CaptureRequest.EDGE_MODE, 2);
                }
            }
            int[] availableAberrationModes = deviceDetails.getAvailableAberrationModes();
            Intrinsics.checkNotNullExpressionValue(availableAberrationModes, "deviceDetails.availableAberrationModes");
            if (ArraysKt.contains(availableAberrationModes, 2)) {
                createCaptureRequest.set(CaptureRequest.COLOR_CORRECTION_ABERRATION_MODE, 2);
            }
            int[] availableHotPixelModes = deviceDetails.getAvailableHotPixelModes();
            Intrinsics.checkNotNullExpressionValue(availableHotPixelModes, "deviceDetails.availableHotPixelModes");
            if (ArraysKt.contains(availableHotPixelModes, 2)) {
                createCaptureRequest.set(CaptureRequest.HOT_PIXEL_MODE, 2);
            }
            if (ArraysKt.contains(deviceDetails.getAvailableDistortionCorrectionModes(), 2) && Build.VERSION.SDK_INT >= 28) {
                key = CaptureRequest.DISTORTION_CORRECTION_MODE;
                createCaptureRequest.set(key, 2);
            }
            int[] availableNoiseReductionModes = deviceDetails.getAvailableNoiseReductionModes();
            Intrinsics.checkNotNullExpressionValue(availableNoiseReductionModes, "deviceDetails.availableNoiseReductionModes");
            if (ArraysKt.contains(availableNoiseReductionModes, 2)) {
                createCaptureRequest.set(CaptureRequest.NOISE_REDUCTION_MODE, 2);
            }
            int[] availableShadingModes = deviceDetails.getAvailableShadingModes();
            Intrinsics.checkNotNullExpressionValue(availableShadingModes, "deviceDetails.availableShadingModes");
            if (ArraysKt.contains(availableShadingModes, 2)) {
                createCaptureRequest.set(CaptureRequest.SHADING_MODE, 2);
            }
            int[] availableToneMapModes = deviceDetails.getAvailableToneMapModes();
            Intrinsics.checkNotNullExpressionValue(availableToneMapModes, "deviceDetails.availableToneMapModes");
            if (ArraysKt.contains(availableToneMapModes, 2)) {
                createCaptureRequest.set(CaptureRequest.TONEMAP_MODE, 2);
            }
            createCaptureRequest.set(CaptureRequest.JPEG_QUALITY, (byte) 100);
        } else if (i == 2) {
            createCaptureRequest.set(CaptureRequest.JPEG_QUALITY, (byte) 92);
        } else if (i == 3) {
            if (deviceDetails.getHardwareLevel().isAtLeast(HardwareLevel.FULL)) {
                createCaptureRequest.set(CaptureRequest.COLOR_CORRECTION_MODE, 1);
                int[] availableEdgeModes2 = deviceDetails.getAvailableEdgeModes();
                Intrinsics.checkNotNullExpressionValue(availableEdgeModes2, "deviceDetails.availableEdgeModes");
                if (ArraysKt.contains(availableEdgeModes2, 1)) {
                    createCaptureRequest.set(CaptureRequest.EDGE_MODE, 1);
                }
            }
            int[] availableAberrationModes2 = deviceDetails.getAvailableAberrationModes();
            Intrinsics.checkNotNullExpressionValue(availableAberrationModes2, "deviceDetails.availableAberrationModes");
            if (ArraysKt.contains(availableAberrationModes2, 1)) {
                createCaptureRequest.set(CaptureRequest.COLOR_CORRECTION_ABERRATION_MODE, 1);
            }
            int[] availableHotPixelModes2 = deviceDetails.getAvailableHotPixelModes();
            Intrinsics.checkNotNullExpressionValue(availableHotPixelModes2, "deviceDetails.availableHotPixelModes");
            if (ArraysKt.contains(availableHotPixelModes2, 1)) {
                createCaptureRequest.set(CaptureRequest.HOT_PIXEL_MODE, 1);
            }
            if (ArraysKt.contains(deviceDetails.getAvailableDistortionCorrectionModes(), 1) && Build.VERSION.SDK_INT >= 28) {
                key2 = CaptureRequest.DISTORTION_CORRECTION_MODE;
                createCaptureRequest.set(key2, 1);
            }
            int[] availableNoiseReductionModes2 = deviceDetails.getAvailableNoiseReductionModes();
            Intrinsics.checkNotNullExpressionValue(availableNoiseReductionModes2, "deviceDetails.availableNoiseReductionModes");
            if (ArraysKt.contains(availableNoiseReductionModes2, 1)) {
                createCaptureRequest.set(CaptureRequest.NOISE_REDUCTION_MODE, 1);
            }
            int[] availableShadingModes2 = deviceDetails.getAvailableShadingModes();
            Intrinsics.checkNotNullExpressionValue(availableShadingModes2, "deviceDetails.availableShadingModes");
            if (ArraysKt.contains(availableShadingModes2, 1)) {
                createCaptureRequest.set(CaptureRequest.SHADING_MODE, 1);
            }
            int[] availableToneMapModes2 = deviceDetails.getAvailableToneMapModes();
            Intrinsics.checkNotNullExpressionValue(availableToneMapModes2, "deviceDetails.availableToneMapModes");
            if (ArraysKt.contains(availableToneMapModes2, 1)) {
                createCaptureRequest.set(CaptureRequest.TONEMAP_MODE, 1);
            }
            createCaptureRequest.set(CaptureRequest.JPEG_QUALITY, (byte) 85);
        }
        createCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(this.outputOrientation.toSensorRelativeOrientation(deviceDetails).toDegrees()));
        if (this.enableAutoStabilization) {
            int[] opticalStabilizationModes = deviceDetails.getOpticalStabilizationModes();
            Intrinsics.checkNotNullExpressionValue(opticalStabilizationModes, "deviceDetails.opticalStabilizationModes");
            if (ArraysKt.contains(opticalStabilizationModes, 1)) {
                createCaptureRequest.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 1);
            } else {
                int[] digitalStabilizationModes = deviceDetails.getDigitalStabilizationModes();
                Intrinsics.checkNotNullExpressionValue(digitalStabilizationModes, "deviceDetails.digitalStabilizationModes");
                if (ArraysKt.contains(digitalStabilizationModes, 1)) {
                    createCaptureRequest.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 1);
                }
            }
        }
        return createCaptureRequest;
    }
}
