package com.mrousavy.camera.core.capture;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import android.util.Range;
import com.mrousavy.camera.core.CameraDeviceDetails;
import com.mrousavy.camera.core.InvalidFpsError;
import com.mrousavy.camera.core.InvalidVideoStabilizationMode;
import com.mrousavy.camera.core.PropRequiresFormatToBeNonNullError;
import com.mrousavy.camera.core.capture.CameraCaptureRequest;
import com.mrousavy.camera.core.outputs.SurfaceOutput;
import com.mrousavy.camera.types.CameraDeviceFormat;
import com.mrousavy.camera.types.HardwareLevel;
import com.mrousavy.camera.types.Torch;
import com.mrousavy.camera.types.VideoStabilizationMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RepeatingCaptureRequest.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J.\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0014J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/mrousavy/camera/core/capture/RepeatingCaptureRequest;", "Lcom/mrousavy/camera/core/capture/CameraCaptureRequest;", "enableVideoPipeline", "", "torch", "Lcom/mrousavy/camera/types/Torch;", "fps", "", "videoStabilizationMode", "Lcom/mrousavy/camera/types/VideoStabilizationMode;", "enableVideoHdr", "enableLowLightBoost", "exposureBias", "", "zoom", "", "format", "Lcom/mrousavy/camera/types/CameraDeviceFormat;", "(ZLcom/mrousavy/camera/types/Torch;Ljava/lang/Integer;Lcom/mrousavy/camera/types/VideoStabilizationMode;ZZLjava/lang/Double;FLcom/mrousavy/camera/types/CameraDeviceFormat;)V", "Ljava/lang/Integer;", "createCaptureRequest", "Landroid/hardware/camera2/CaptureRequest$Builder;", "device", "Landroid/hardware/camera2/CameraDevice;", "deviceDetails", "Lcom/mrousavy/camera/core/CameraDeviceDetails;", "outputs", "", "Lcom/mrousavy/camera/core/outputs/SurfaceOutput;", "template", "Lcom/mrousavy/camera/core/capture/CameraCaptureRequest$Template;", "getBestDigitalStabilizationMode", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RepeatingCaptureRequest extends CameraCaptureRequest {
    private final boolean enableVideoPipeline;
    private final Integer fps;
    private final VideoStabilizationMode videoStabilizationMode;

    /* compiled from: RepeatingCaptureRequest.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VideoStabilizationMode.values().length];
            try {
                iArr[VideoStabilizationMode.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VideoStabilizationMode.CINEMATIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VideoStabilizationMode.CINEMATIC_EXTENDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ RepeatingCaptureRequest(boolean z, Torch torch, Integer num, VideoStabilizationMode videoStabilizationMode, boolean z2, boolean z3, Double d, float f, CameraDeviceFormat cameraDeviceFormat, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? Torch.OFF : torch, (i & 4) != 0 ? null : num, (i & 8) != 0 ? VideoStabilizationMode.OFF : videoStabilizationMode, (i & 16) != 0 ? false : z2, (i & 32) == 0 ? z3 : false, (i & 64) != 0 ? null : d, (i & 128) != 0 ? 1.0f : f, (i & 256) == 0 ? cameraDeviceFormat : null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepeatingCaptureRequest(boolean z, Torch torch, Integer num, VideoStabilizationMode videoStabilizationMode, boolean z2, boolean z3, Double d, float f, CameraDeviceFormat cameraDeviceFormat) {
        super(torch, z2, z3, d, f, cameraDeviceFormat);
        Intrinsics.checkNotNullParameter(torch, "torch");
        Intrinsics.checkNotNullParameter(videoStabilizationMode, "videoStabilizationMode");
        this.enableVideoPipeline = z;
        this.fps = num;
        this.videoStabilizationMode = videoStabilizationMode;
    }

    @Override // com.mrousavy.camera.core.capture.CameraCaptureRequest
    public CaptureRequest.Builder createCaptureRequest(CameraDevice device, CameraDeviceDetails deviceDetails, List<? extends SurfaceOutput> outputs) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(deviceDetails, "deviceDetails");
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        return createCaptureRequest(this.enableVideoPipeline ? CameraCaptureRequest.Template.RECORD : CameraCaptureRequest.Template.PREVIEW, device, deviceDetails, outputs);
    }

    private final int getBestDigitalStabilizationMode(CameraDeviceDetails deviceDetails) {
        if (Build.VERSION.SDK_INT < 33) {
            return 1;
        }
        int[] digitalStabilizationModes = deviceDetails.getDigitalStabilizationModes();
        Intrinsics.checkNotNullExpressionValue(digitalStabilizationModes, "deviceDetails.digitalStabilizationModes");
        return ArraysKt.contains(digitalStabilizationModes, 2) ? 2 : 1;
    }

    @Override // com.mrousavy.camera.core.capture.CameraCaptureRequest
    protected CaptureRequest.Builder createCaptureRequest(CameraCaptureRequest.Template template, CameraDevice device, CameraDeviceDetails deviceDetails, List<? extends SurfaceOutput> outputs) {
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(deviceDetails, "deviceDetails");
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        CaptureRequest.Builder createCaptureRequest = super.createCaptureRequest(template, device, deviceDetails, outputs);
        if (deviceDetails.getModes().contains(1)) {
            createCaptureRequest.set(CaptureRequest.CONTROL_MODE, 1);
        }
        if (this.enableVideoPipeline && deviceDetails.getAfModes().contains(3)) {
            createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 3);
        } else if (deviceDetails.getAfModes().contains(4)) {
            createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 4);
        } else if (deviceDetails.getAfModes().contains(1)) {
            createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 1);
        } else if (deviceDetails.getAfModes().contains(0)) {
            createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 0);
            createCaptureRequest.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(0.0f));
        }
        if (deviceDetails.getAeModes().contains(1)) {
            createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, 1);
        } else if (deviceDetails.getAeModes().contains(0)) {
            createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, 0);
        }
        if (deviceDetails.getAwbModes().contains(1)) {
            createCaptureRequest.set(CaptureRequest.CONTROL_AWB_MODE, 1);
        }
        if (this.fps != null) {
            if (getFormat() == null) {
                throw new PropRequiresFormatToBeNonNullError("fps");
            }
            if (getFormat().getMaxFps() < this.fps.intValue()) {
                throw new InvalidFpsError(this.fps.intValue());
            }
            CaptureRequest.Key key = CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE;
            Integer num = this.fps;
            createCaptureRequest.set(key, new Range(num, num));
        }
        if (this.videoStabilizationMode != VideoStabilizationMode.OFF) {
            if (getFormat() == null) {
                throw new PropRequiresFormatToBeNonNullError("videoStabilizationMode");
            }
            if (!getFormat().getVideoStabilizationModes().contains(this.videoStabilizationMode)) {
                throw new InvalidVideoStabilizationMode(this.videoStabilizationMode);
            }
            int i = WhenMappings.$EnumSwitchMapping$0[this.videoStabilizationMode.ordinal()];
            if (i == 1) {
                createCaptureRequest.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, Integer.valueOf(getBestDigitalStabilizationMode(deviceDetails)));
            } else if (i == 2 || i == 3) {
                if (deviceDetails.getHardwareLevel().isAtLeast(HardwareLevel.LIMITED)) {
                    createCaptureRequest.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 1);
                } else {
                    createCaptureRequest.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, Integer.valueOf(getBestDigitalStabilizationMode(deviceDetails)));
                }
            } else {
                throw new InvalidVideoStabilizationMode(this.videoStabilizationMode);
            }
        }
        return createCaptureRequest;
    }
}
