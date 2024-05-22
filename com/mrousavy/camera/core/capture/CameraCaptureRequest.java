package com.mrousavy.camera.core.capture;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import com.mrousavy.camera.core.CameraDeviceDetails;
import com.mrousavy.camera.core.FlashUnavailableError;
import com.mrousavy.camera.core.InvalidVideoHdrError;
import com.mrousavy.camera.core.LowLightBoostNotSupportedError;
import com.mrousavy.camera.core.PropRequiresFormatToBeNonNullError;
import com.mrousavy.camera.core.outputs.SurfaceOutput;
import com.mrousavy.camera.extensions.CaptureRequest_setZoomKt;
import com.mrousavy.camera.types.CameraDeviceFormat;
import com.mrousavy.camera.types.Torch;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraCaptureRequest.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\"BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH&J.\u0010\u0017\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/mrousavy/camera/core/capture/CameraCaptureRequest;", "", "torch", "Lcom/mrousavy/camera/types/Torch;", "enableVideoHdr", "", "enableLowLightBoost", "exposureBias", "", "zoom", "", "format", "Lcom/mrousavy/camera/types/CameraDeviceFormat;", "(Lcom/mrousavy/camera/types/Torch;ZZLjava/lang/Double;FLcom/mrousavy/camera/types/CameraDeviceFormat;)V", "getEnableLowLightBoost", "()Z", "getExposureBias", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getFormat", "()Lcom/mrousavy/camera/types/CameraDeviceFormat;", "getZoom", "()F", "createCaptureRequest", "Landroid/hardware/camera2/CaptureRequest$Builder;", "device", "Landroid/hardware/camera2/CameraDevice;", "deviceDetails", "Lcom/mrousavy/camera/core/CameraDeviceDetails;", "outputs", "", "Lcom/mrousavy/camera/core/outputs/SurfaceOutput;", "template", "Lcom/mrousavy/camera/core/capture/CameraCaptureRequest$Template;", "Template", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class CameraCaptureRequest {
    private final boolean enableLowLightBoost;
    private final boolean enableVideoHdr;
    private final Double exposureBias;
    private final CameraDeviceFormat format;
    private final Torch torch;
    private final float zoom;

    public CameraCaptureRequest() {
        this(null, false, false, null, 0.0f, null, 63, null);
    }

    public abstract CaptureRequest.Builder createCaptureRequest(CameraDevice device, CameraDeviceDetails deviceDetails, List<? extends SurfaceOutput> outputs);

    public CameraCaptureRequest(Torch torch, boolean z, boolean z2, Double d, float f, CameraDeviceFormat cameraDeviceFormat) {
        Intrinsics.checkNotNullParameter(torch, "torch");
        this.torch = torch;
        this.enableVideoHdr = z;
        this.enableLowLightBoost = z2;
        this.exposureBias = d;
        this.zoom = f;
        this.format = cameraDeviceFormat;
    }

    public /* synthetic */ CameraCaptureRequest(Torch torch, boolean z, boolean z2, Double d, float f, CameraDeviceFormat cameraDeviceFormat, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Torch.OFF : torch, (i & 2) != 0 ? false : z, (i & 4) == 0 ? z2 : false, (i & 8) != 0 ? null : d, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? null : cameraDeviceFormat);
    }

    public final boolean getEnableLowLightBoost() {
        return this.enableLowLightBoost;
    }

    public final Double getExposureBias() {
        return this.exposureBias;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final CameraDeviceFormat getFormat() {
        return this.format;
    }

    /* compiled from: CameraCaptureRequest.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/mrousavy/camera/core/capture/CameraCaptureRequest$Template;", "", "(Ljava/lang/String;I)V", "toRequestTemplate", "", "RECORD", "PHOTO", "PHOTO_ZSL", "PHOTO_SNAPSHOT", "PREVIEW", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum Template {
        RECORD,
        PHOTO,
        PHOTO_ZSL,
        PHOTO_SNAPSHOT,
        PREVIEW;

        /* compiled from: CameraCaptureRequest.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Template.values().length];
                try {
                    iArr[Template.RECORD.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Template.PHOTO.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Template.PHOTO_ZSL.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Template.PHOTO_SNAPSHOT.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Template.PREVIEW.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final int toRequestTemplate() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return 3;
            }
            int i2 = 2;
            if (i != 2) {
                i2 = 5;
                if (i != 3) {
                    if (i == 4) {
                        return 4;
                    }
                    if (i == 5) {
                        return 1;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
            return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CaptureRequest.Builder createCaptureRequest(Template template, CameraDevice device, CameraDeviceDetails deviceDetails, List<? extends SurfaceOutput> outputs) {
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(deviceDetails, "deviceDetails");
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        CaptureRequest.Builder createCaptureRequest = device.createCaptureRequest(template.toRequestTemplate());
        Intrinsics.checkNotNullExpressionValue(createCaptureRequest, "device.createCaptureRequ…late.toRequestTemplate())");
        Iterator<T> it = outputs.iterator();
        while (it.hasNext()) {
            createCaptureRequest.addTarget(((SurfaceOutput) it.next()).getSurface());
        }
        if (this.enableVideoHdr) {
            CameraDeviceFormat cameraDeviceFormat = this.format;
            if (cameraDeviceFormat == null) {
                throw new PropRequiresFormatToBeNonNullError("videoHdr");
            }
            if (!cameraDeviceFormat.getSupportsVideoHdr()) {
                throw new InvalidVideoHdrError();
            }
            createCaptureRequest.set(CaptureRequest.CONTROL_SCENE_MODE, 18);
            createCaptureRequest.set(CaptureRequest.CONTROL_MODE, 2);
        } else if (this.enableLowLightBoost) {
            if (!deviceDetails.getSupportsLowLightBoost()) {
                throw new LowLightBoostNotSupportedError();
            }
            createCaptureRequest.set(CaptureRequest.CONTROL_SCENE_MODE, 5);
            createCaptureRequest.set(CaptureRequest.CONTROL_MODE, 2);
        }
        if (this.exposureBias != null) {
            createCaptureRequest.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, deviceDetails.getExposureRange().clamp(Integer.valueOf((int) this.exposureBias.doubleValue())));
        }
        CaptureRequest_setZoomKt.setZoom(createCaptureRequest, this.zoom, deviceDetails);
        if (this.torch == Torch.ON) {
            if (!deviceDetails.getHasFlash().booleanValue()) {
                throw new FlashUnavailableError();
            }
            createCaptureRequest.set(CaptureRequest.FLASH_MODE, 2);
        }
        return createCaptureRequest;
    }
}
