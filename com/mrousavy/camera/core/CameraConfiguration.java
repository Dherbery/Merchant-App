package com.mrousavy.camera.core;

import android.view.Surface;
import com.mrousavy.camera.types.CameraDeviceFormat;
import com.mrousavy.camera.types.CodeType;
import com.mrousavy.camera.types.Orientation;
import com.mrousavy.camera.types.PixelFormat;
import com.mrousavy.camera.types.Torch;
import com.mrousavy.camera.types.VideoStabilizationMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraConfiguration.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bR\b\u0086\b\u0018\u0000 k2\u00020\u0001:\bijklmnopBÁ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0014\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0005¢\u0006\u0002\u0010 J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0016HÆ\u0003J\t\u0010V\u001a\u00020\u0018HÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u00100J\t\u0010X\u001a\u00020\u001cHÆ\u0003J\t\u0010Y\u001a\u00020\u0014HÆ\u0003J\u000f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0005HÆ\u0003J\u000f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\u000f\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003J\u000f\u0010^\u001a\b\u0012\u0004\u0012\u00020\f0\u0005HÆ\u0003J\t\u0010_\u001a\u00020\u000eHÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00109J\t\u0010b\u001a\u00020\u0014HÆ\u0003JÊ\u0001\u0010c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00142\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0005HÆ\u0001¢\u0006\u0002\u0010dJ\u0013\u0010e\u001a\u00020\u00142\b\u0010f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010g\u001a\u00020\u0012HÖ\u0001J\t\u0010h\u001a\u00020\u0003HÖ\u0001R \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010\u001d\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010,\"\u0004\b=\u0010.R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\"\"\u0004\bC\u0010$R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\"\"\u0004\bE\u0010$R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\"\"\u0004\bK\u0010$R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010S¨\u0006q"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration;", "", "cameraId", "", "preview", "Lcom/mrousavy/camera/core/CameraConfiguration$Output;", "Lcom/mrousavy/camera/core/CameraConfiguration$Preview;", "photo", "Lcom/mrousavy/camera/core/CameraConfiguration$Photo;", "video", "Lcom/mrousavy/camera/core/CameraConfiguration$Video;", "codeScanner", "Lcom/mrousavy/camera/core/CameraConfiguration$CodeScanner;", "orientation", "Lcom/mrousavy/camera/types/Orientation;", "format", "Lcom/mrousavy/camera/types/CameraDeviceFormat;", "fps", "", "enableLowLightBoost", "", "torch", "Lcom/mrousavy/camera/types/Torch;", "videoStabilizationMode", "Lcom/mrousavy/camera/types/VideoStabilizationMode;", "exposure", "", "zoom", "", "isActive", "audio", "Lcom/mrousavy/camera/core/CameraConfiguration$Audio;", "(Ljava/lang/String;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/types/Orientation;Lcom/mrousavy/camera/types/CameraDeviceFormat;Ljava/lang/Integer;ZLcom/mrousavy/camera/types/Torch;Lcom/mrousavy/camera/types/VideoStabilizationMode;Ljava/lang/Double;FZLcom/mrousavy/camera/core/CameraConfiguration$Output;)V", "getAudio", "()Lcom/mrousavy/camera/core/CameraConfiguration$Output;", "setAudio", "(Lcom/mrousavy/camera/core/CameraConfiguration$Output;)V", "getCameraId", "()Ljava/lang/String;", "setCameraId", "(Ljava/lang/String;)V", "getCodeScanner", "setCodeScanner", "getEnableLowLightBoost", "()Z", "setEnableLowLightBoost", "(Z)V", "getExposure", "()Ljava/lang/Double;", "setExposure", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getFormat", "()Lcom/mrousavy/camera/types/CameraDeviceFormat;", "setFormat", "(Lcom/mrousavy/camera/types/CameraDeviceFormat;)V", "getFps", "()Ljava/lang/Integer;", "setFps", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "setActive", "getOrientation", "()Lcom/mrousavy/camera/types/Orientation;", "setOrientation", "(Lcom/mrousavy/camera/types/Orientation;)V", "getPhoto", "setPhoto", "getPreview", "setPreview", "getTorch", "()Lcom/mrousavy/camera/types/Torch;", "setTorch", "(Lcom/mrousavy/camera/types/Torch;)V", "getVideo", "setVideo", "getVideoStabilizationMode", "()Lcom/mrousavy/camera/types/VideoStabilizationMode;", "setVideoStabilizationMode", "(Lcom/mrousavy/camera/types/VideoStabilizationMode;)V", "getZoom", "()F", "setZoom", "(F)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/types/Orientation;Lcom/mrousavy/camera/types/CameraDeviceFormat;Ljava/lang/Integer;ZLcom/mrousavy/camera/types/Torch;Lcom/mrousavy/camera/types/VideoStabilizationMode;Ljava/lang/Double;FZLcom/mrousavy/camera/core/CameraConfiguration$Output;)Lcom/mrousavy/camera/core/CameraConfiguration;", "equals", "other", "hashCode", "toString", "Audio", "CodeScanner", "Companion", "Difference", "Output", "Photo", "Preview", "Video", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CameraConfiguration {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Output<Audio> audio;
    private String cameraId;
    private Output<CodeScanner> codeScanner;
    private boolean enableLowLightBoost;
    private Double exposure;
    private CameraDeviceFormat format;
    private Integer fps;
    private boolean isActive;
    private Orientation orientation;
    private Output<Photo> photo;
    private Output<Preview> preview;
    private Torch torch;
    private Output<Video> video;
    private VideoStabilizationMode videoStabilizationMode;
    private float zoom;

    public CameraConfiguration() {
        this(null, null, null, null, null, null, null, null, false, null, null, null, 0.0f, false, null, 32767, null);
    }

    public static /* synthetic */ CameraConfiguration copy$default(CameraConfiguration cameraConfiguration, String str, Output output, Output output2, Output output3, Output output4, Orientation orientation, CameraDeviceFormat cameraDeviceFormat, Integer num, boolean z, Torch torch, VideoStabilizationMode videoStabilizationMode, Double d, float f, boolean z2, Output output5, int i, Object obj) {
        return cameraConfiguration.copy((i & 1) != 0 ? cameraConfiguration.cameraId : str, (i & 2) != 0 ? cameraConfiguration.preview : output, (i & 4) != 0 ? cameraConfiguration.photo : output2, (i & 8) != 0 ? cameraConfiguration.video : output3, (i & 16) != 0 ? cameraConfiguration.codeScanner : output4, (i & 32) != 0 ? cameraConfiguration.orientation : orientation, (i & 64) != 0 ? cameraConfiguration.format : cameraDeviceFormat, (i & 128) != 0 ? cameraConfiguration.fps : num, (i & 256) != 0 ? cameraConfiguration.enableLowLightBoost : z, (i & 512) != 0 ? cameraConfiguration.torch : torch, (i & 1024) != 0 ? cameraConfiguration.videoStabilizationMode : videoStabilizationMode, (i & 2048) != 0 ? cameraConfiguration.exposure : d, (i & 4096) != 0 ? cameraConfiguration.zoom : f, (i & 8192) != 0 ? cameraConfiguration.isActive : z2, (i & 16384) != 0 ? cameraConfiguration.audio : output5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCameraId() {
        return this.cameraId;
    }

    /* renamed from: component10, reason: from getter */
    public final Torch getTorch() {
        return this.torch;
    }

    /* renamed from: component11, reason: from getter */
    public final VideoStabilizationMode getVideoStabilizationMode() {
        return this.videoStabilizationMode;
    }

    /* renamed from: component12, reason: from getter */
    public final Double getExposure() {
        return this.exposure;
    }

    /* renamed from: component13, reason: from getter */
    public final float getZoom() {
        return this.zoom;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    public final Output<Audio> component15() {
        return this.audio;
    }

    public final Output<Preview> component2() {
        return this.preview;
    }

    public final Output<Photo> component3() {
        return this.photo;
    }

    public final Output<Video> component4() {
        return this.video;
    }

    public final Output<CodeScanner> component5() {
        return this.codeScanner;
    }

    /* renamed from: component6, reason: from getter */
    public final Orientation getOrientation() {
        return this.orientation;
    }

    /* renamed from: component7, reason: from getter */
    public final CameraDeviceFormat getFormat() {
        return this.format;
    }

    /* renamed from: component8, reason: from getter */
    public final Integer getFps() {
        return this.fps;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getEnableLowLightBoost() {
        return this.enableLowLightBoost;
    }

    public final CameraConfiguration copy(String cameraId, Output<Preview> preview, Output<Photo> photo, Output<Video> video, Output<CodeScanner> codeScanner, Orientation orientation, CameraDeviceFormat format, Integer fps, boolean enableLowLightBoost, Torch torch, VideoStabilizationMode videoStabilizationMode, Double exposure, float zoom, boolean isActive, Output<Audio> audio) {
        Intrinsics.checkNotNullParameter(preview, "preview");
        Intrinsics.checkNotNullParameter(photo, "photo");
        Intrinsics.checkNotNullParameter(video, "video");
        Intrinsics.checkNotNullParameter(codeScanner, "codeScanner");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(torch, "torch");
        Intrinsics.checkNotNullParameter(videoStabilizationMode, "videoStabilizationMode");
        Intrinsics.checkNotNullParameter(audio, "audio");
        return new CameraConfiguration(cameraId, preview, photo, video, codeScanner, orientation, format, fps, enableLowLightBoost, torch, videoStabilizationMode, exposure, zoom, isActive, audio);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CameraConfiguration)) {
            return false;
        }
        CameraConfiguration cameraConfiguration = (CameraConfiguration) other;
        return Intrinsics.areEqual(this.cameraId, cameraConfiguration.cameraId) && Intrinsics.areEqual(this.preview, cameraConfiguration.preview) && Intrinsics.areEqual(this.photo, cameraConfiguration.photo) && Intrinsics.areEqual(this.video, cameraConfiguration.video) && Intrinsics.areEqual(this.codeScanner, cameraConfiguration.codeScanner) && this.orientation == cameraConfiguration.orientation && Intrinsics.areEqual(this.format, cameraConfiguration.format) && Intrinsics.areEqual(this.fps, cameraConfiguration.fps) && this.enableLowLightBoost == cameraConfiguration.enableLowLightBoost && this.torch == cameraConfiguration.torch && this.videoStabilizationMode == cameraConfiguration.videoStabilizationMode && Intrinsics.areEqual((Object) this.exposure, (Object) cameraConfiguration.exposure) && Float.compare(this.zoom, cameraConfiguration.zoom) == 0 && this.isActive == cameraConfiguration.isActive && Intrinsics.areEqual(this.audio, cameraConfiguration.audio);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.cameraId;
        int hashCode = (((((((((((str == null ? 0 : str.hashCode()) * 31) + this.preview.hashCode()) * 31) + this.photo.hashCode()) * 31) + this.video.hashCode()) * 31) + this.codeScanner.hashCode()) * 31) + this.orientation.hashCode()) * 31;
        CameraDeviceFormat cameraDeviceFormat = this.format;
        int hashCode2 = (hashCode + (cameraDeviceFormat == null ? 0 : cameraDeviceFormat.hashCode())) * 31;
        Integer num = this.fps;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        boolean z = this.enableLowLightBoost;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode4 = (((((hashCode3 + i) * 31) + this.torch.hashCode()) * 31) + this.videoStabilizationMode.hashCode()) * 31;
        Double d = this.exposure;
        int hashCode5 = (((hashCode4 + (d != null ? d.hashCode() : 0)) * 31) + Float.floatToIntBits(this.zoom)) * 31;
        boolean z2 = this.isActive;
        return ((hashCode5 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.audio.hashCode();
    }

    public String toString() {
        return "CameraConfiguration(cameraId=" + this.cameraId + ", preview=" + this.preview + ", photo=" + this.photo + ", video=" + this.video + ", codeScanner=" + this.codeScanner + ", orientation=" + this.orientation + ", format=" + this.format + ", fps=" + this.fps + ", enableLowLightBoost=" + this.enableLowLightBoost + ", torch=" + this.torch + ", videoStabilizationMode=" + this.videoStabilizationMode + ", exposure=" + this.exposure + ", zoom=" + this.zoom + ", isActive=" + this.isActive + ", audio=" + this.audio + ")";
    }

    public CameraConfiguration(String str, Output<Preview> preview, Output<Photo> photo, Output<Video> video, Output<CodeScanner> codeScanner, Orientation orientation, CameraDeviceFormat cameraDeviceFormat, Integer num, boolean z, Torch torch, VideoStabilizationMode videoStabilizationMode, Double d, float f, boolean z2, Output<Audio> audio) {
        Intrinsics.checkNotNullParameter(preview, "preview");
        Intrinsics.checkNotNullParameter(photo, "photo");
        Intrinsics.checkNotNullParameter(video, "video");
        Intrinsics.checkNotNullParameter(codeScanner, "codeScanner");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(torch, "torch");
        Intrinsics.checkNotNullParameter(videoStabilizationMode, "videoStabilizationMode");
        Intrinsics.checkNotNullParameter(audio, "audio");
        this.cameraId = str;
        this.preview = preview;
        this.photo = photo;
        this.video = video;
        this.codeScanner = codeScanner;
        this.orientation = orientation;
        this.format = cameraDeviceFormat;
        this.fps = num;
        this.enableLowLightBoost = z;
        this.torch = torch;
        this.videoStabilizationMode = videoStabilizationMode;
        this.exposure = d;
        this.zoom = f;
        this.isActive = z2;
        this.audio = audio;
    }

    public final String getCameraId() {
        return this.cameraId;
    }

    public final void setCameraId(String str) {
        this.cameraId = str;
    }

    public /* synthetic */ CameraConfiguration(String str, Output output, Output output2, Output output3, Output output4, Orientation orientation, CameraDeviceFormat cameraDeviceFormat, Integer num, boolean z, Torch torch, VideoStabilizationMode videoStabilizationMode, Double d, float f, boolean z2, Output output5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? Output.Disabled.INSTANCE.create() : output, (i & 4) != 0 ? Output.Disabled.INSTANCE.create() : output2, (i & 8) != 0 ? Output.Disabled.INSTANCE.create() : output3, (i & 16) != 0 ? Output.Disabled.INSTANCE.create() : output4, (i & 32) != 0 ? Orientation.PORTRAIT : orientation, (i & 64) != 0 ? null : cameraDeviceFormat, (i & 128) != 0 ? null : num, (i & 256) != 0 ? false : z, (i & 512) != 0 ? Torch.OFF : torch, (i & 1024) != 0 ? VideoStabilizationMode.OFF : videoStabilizationMode, (i & 2048) == 0 ? d : null, (i & 4096) != 0 ? 1.0f : f, (i & 8192) == 0 ? z2 : false, (i & 16384) != 0 ? Output.Disabled.INSTANCE.create() : output5);
    }

    public final Output<Preview> getPreview() {
        return this.preview;
    }

    public final void setPreview(Output<Preview> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.preview = output;
    }

    public final Output<Photo> getPhoto() {
        return this.photo;
    }

    public final void setPhoto(Output<Photo> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.photo = output;
    }

    public final Output<Video> getVideo() {
        return this.video;
    }

    public final void setVideo(Output<Video> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.video = output;
    }

    public final Output<CodeScanner> getCodeScanner() {
        return this.codeScanner;
    }

    public final void setCodeScanner(Output<CodeScanner> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.codeScanner = output;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final void setOrientation(Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "<set-?>");
        this.orientation = orientation;
    }

    public final CameraDeviceFormat getFormat() {
        return this.format;
    }

    public final void setFormat(CameraDeviceFormat cameraDeviceFormat) {
        this.format = cameraDeviceFormat;
    }

    public final Integer getFps() {
        return this.fps;
    }

    public final void setFps(Integer num) {
        this.fps = num;
    }

    public final boolean getEnableLowLightBoost() {
        return this.enableLowLightBoost;
    }

    public final void setEnableLowLightBoost(boolean z) {
        this.enableLowLightBoost = z;
    }

    public final Torch getTorch() {
        return this.torch;
    }

    public final void setTorch(Torch torch) {
        Intrinsics.checkNotNullParameter(torch, "<set-?>");
        this.torch = torch;
    }

    public final VideoStabilizationMode getVideoStabilizationMode() {
        return this.videoStabilizationMode;
    }

    public final void setVideoStabilizationMode(VideoStabilizationMode videoStabilizationMode) {
        Intrinsics.checkNotNullParameter(videoStabilizationMode, "<set-?>");
        this.videoStabilizationMode = videoStabilizationMode;
    }

    public final Double getExposure() {
        return this.exposure;
    }

    public final void setExposure(Double d) {
        this.exposure = d;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final void setZoom(float f) {
        this.zoom = f;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }

    public final Output<Audio> getAudio() {
        return this.audio;
    }

    public final void setAudio(Output<Audio> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.audio = output;
    }

    /* compiled from: CameraConfiguration.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$CodeScanner;", "", "codeTypes", "", "Lcom/mrousavy/camera/types/CodeType;", "(Ljava/util/List;)V", "getCodeTypes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class CodeScanner {
        private final List<CodeType> codeTypes;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CodeScanner copy$default(CodeScanner codeScanner, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = codeScanner.codeTypes;
            }
            return codeScanner.copy(list);
        }

        public final List<CodeType> component1() {
            return this.codeTypes;
        }

        public final CodeScanner copy(List<? extends CodeType> codeTypes) {
            Intrinsics.checkNotNullParameter(codeTypes, "codeTypes");
            return new CodeScanner(codeTypes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CodeScanner) && Intrinsics.areEqual(this.codeTypes, ((CodeScanner) other).codeTypes);
        }

        public int hashCode() {
            return this.codeTypes.hashCode();
        }

        public String toString() {
            return "CodeScanner(codeTypes=" + this.codeTypes + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CodeScanner(List<? extends CodeType> codeTypes) {
            Intrinsics.checkNotNullParameter(codeTypes, "codeTypes");
            this.codeTypes = codeTypes;
        }

        public final List<CodeType> getCodeTypes() {
            return this.codeTypes;
        }
    }

    /* compiled from: CameraConfiguration.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Photo;", "", "enableHdr", "", "(Z)V", "getEnableHdr", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Photo {
        private final boolean enableHdr;

        public static /* synthetic */ Photo copy$default(Photo photo, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = photo.enableHdr;
            }
            return photo.copy(z);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getEnableHdr() {
            return this.enableHdr;
        }

        public final Photo copy(boolean enableHdr) {
            return new Photo(enableHdr);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Photo) && this.enableHdr == ((Photo) other).enableHdr;
        }

        public int hashCode() {
            boolean z = this.enableHdr;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "Photo(enableHdr=" + this.enableHdr + ")";
        }

        public Photo(boolean z) {
            this.enableHdr = z;
        }

        public final boolean getEnableHdr() {
            return this.enableHdr;
        }
    }

    /* compiled from: CameraConfiguration.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Video;", "", "enableHdr", "", "pixelFormat", "Lcom/mrousavy/camera/types/PixelFormat;", "enableFrameProcessor", "enableGpuBuffers", "(ZLcom/mrousavy/camera/types/PixelFormat;ZZ)V", "getEnableFrameProcessor", "()Z", "getEnableGpuBuffers", "getEnableHdr", "getPixelFormat", "()Lcom/mrousavy/camera/types/PixelFormat;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Video {
        private final boolean enableFrameProcessor;
        private final boolean enableGpuBuffers;
        private final boolean enableHdr;
        private final PixelFormat pixelFormat;

        public static /* synthetic */ Video copy$default(Video video, boolean z, PixelFormat pixelFormat, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                z = video.enableHdr;
            }
            if ((i & 2) != 0) {
                pixelFormat = video.pixelFormat;
            }
            if ((i & 4) != 0) {
                z2 = video.enableFrameProcessor;
            }
            if ((i & 8) != 0) {
                z3 = video.enableGpuBuffers;
            }
            return video.copy(z, pixelFormat, z2, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getEnableHdr() {
            return this.enableHdr;
        }

        /* renamed from: component2, reason: from getter */
        public final PixelFormat getPixelFormat() {
            return this.pixelFormat;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getEnableFrameProcessor() {
            return this.enableFrameProcessor;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getEnableGpuBuffers() {
            return this.enableGpuBuffers;
        }

        public final Video copy(boolean enableHdr, PixelFormat pixelFormat, boolean enableFrameProcessor, boolean enableGpuBuffers) {
            Intrinsics.checkNotNullParameter(pixelFormat, "pixelFormat");
            return new Video(enableHdr, pixelFormat, enableFrameProcessor, enableGpuBuffers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Video)) {
                return false;
            }
            Video video = (Video) other;
            return this.enableHdr == video.enableHdr && this.pixelFormat == video.pixelFormat && this.enableFrameProcessor == video.enableFrameProcessor && this.enableGpuBuffers == video.enableGpuBuffers;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        public int hashCode() {
            boolean z = this.enableHdr;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int hashCode = ((r0 * 31) + this.pixelFormat.hashCode()) * 31;
            ?? r2 = this.enableFrameProcessor;
            int i = r2;
            if (r2 != 0) {
                i = 1;
            }
            int i2 = (hashCode + i) * 31;
            boolean z2 = this.enableGpuBuffers;
            return i2 + (z2 ? 1 : z2 ? 1 : 0);
        }

        public String toString() {
            return "Video(enableHdr=" + this.enableHdr + ", pixelFormat=" + this.pixelFormat + ", enableFrameProcessor=" + this.enableFrameProcessor + ", enableGpuBuffers=" + this.enableGpuBuffers + ")";
        }

        public Video(boolean z, PixelFormat pixelFormat, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(pixelFormat, "pixelFormat");
            this.enableHdr = z;
            this.pixelFormat = pixelFormat;
            this.enableFrameProcessor = z2;
            this.enableGpuBuffers = z3;
        }

        public final boolean getEnableFrameProcessor() {
            return this.enableFrameProcessor;
        }

        public final boolean getEnableGpuBuffers() {
            return this.enableGpuBuffers;
        }

        public final boolean getEnableHdr() {
            return this.enableHdr;
        }

        public final PixelFormat getPixelFormat() {
            return this.pixelFormat;
        }
    }

    /* compiled from: CameraConfiguration.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0018\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Audio;", "", "nothing", "", "(Lkotlin/Unit;)V", "getNothing", "()Lkotlin/Unit;", "Lkotlin/Unit;", "component1", "copy", "(Lkotlin/Unit;)Lcom/mrousavy/camera/core/CameraConfiguration$Audio;", "equals", "", "other", "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Audio {
        private final Unit nothing;

        public static /* synthetic */ Audio copy$default(Audio audio, Unit unit, int i, Object obj) {
            if ((i & 1) != 0) {
                unit = audio.nothing;
            }
            return audio.copy(unit);
        }

        public final void component1() {
        }

        public final Audio copy(Unit nothing) {
            Intrinsics.checkNotNullParameter(nothing, "nothing");
            return new Audio(nothing);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Audio) && Intrinsics.areEqual(this.nothing, ((Audio) other).nothing);
        }

        public int hashCode() {
            return this.nothing.hashCode();
        }

        public String toString() {
            return "Audio(nothing=" + this.nothing + ")";
        }

        public Audio(Unit nothing) {
            Intrinsics.checkNotNullParameter(nothing, "nothing");
            this.nothing = nothing;
        }

        public final Unit getNothing() {
            return this.nothing;
        }
    }

    /* compiled from: CameraConfiguration.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Preview;", "", "surface", "Landroid/view/Surface;", "(Landroid/view/Surface;)V", "getSurface", "()Landroid/view/Surface;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Preview {
        private final Surface surface;

        public static /* synthetic */ Preview copy$default(Preview preview, Surface surface, int i, Object obj) {
            if ((i & 1) != 0) {
                surface = preview.surface;
            }
            return preview.copy(surface);
        }

        /* renamed from: component1, reason: from getter */
        public final Surface getSurface() {
            return this.surface;
        }

        public final Preview copy(Surface surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            return new Preview(surface);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Preview) && Intrinsics.areEqual(this.surface, ((Preview) other).surface);
        }

        public int hashCode() {
            return this.surface.hashCode();
        }

        public String toString() {
            return "Preview(surface=" + this.surface + ")";
        }

        public Preview(Surface surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            this.surface = surface;
        }

        public final Surface getSurface() {
            return this.surface;
        }
    }

    /* compiled from: CameraConfiguration.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Output;", "T", "", "()V", "isEnabled", "", "()Z", "Disabled", "Enabled", "Lcom/mrousavy/camera/core/CameraConfiguration$Output$Disabled;", "Lcom/mrousavy/camera/core/CameraConfiguration$Output$Enabled;", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static abstract class Output<T> {
        public /* synthetic */ Output(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Output() {
        }

        /* compiled from: CameraConfiguration.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \b*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0002¨\u0006\t"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Output$Disabled;", "T", "Lcom/mrousavy/camera/core/CameraConfiguration$Output;", "()V", "equals", "", "other", "", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Disabled<T> extends Output<T> {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);

            public /* synthetic */ Disabled(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Disabled() {
                super(null);
            }

            /* compiled from: CameraConfiguration.kt */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Output$Disabled$Companion;", "", "()V", "create", "Lcom/mrousavy/camera/core/CameraConfiguration$Output$Disabled;", "T", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* loaded from: classes5.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final <T> Disabled<T> create() {
                    return new Disabled<>(null);
                }
            }

            public boolean equals(Object other) {
                return other instanceof Disabled;
            }
        }

        public final boolean isEnabled() {
            return this instanceof Enabled;
        }

        /* compiled from: CameraConfiguration.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \f*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Output$Enabled;", "T", "Lcom/mrousavy/camera/core/CameraConfiguration$Output;", "config", "(Ljava/lang/Object;)V", "getConfig", "()Ljava/lang/Object;", "Ljava/lang/Object;", "equals", "", "other", "", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Enabled<T> extends Output<T> {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final T config;

            public /* synthetic */ Enabled(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
                this(obj);
            }

            private Enabled(T t) {
                super(null);
                this.config = t;
            }

            public final T getConfig() {
                return this.config;
            }

            /* compiled from: CameraConfiguration.kt */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0002\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Output$Enabled$Companion;", "", "()V", "create", "Lcom/mrousavy/camera/core/CameraConfiguration$Output$Enabled;", "T", "config", "(Ljava/lang/Object;)Lcom/mrousavy/camera/core/CameraConfiguration$Output$Enabled;", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* loaded from: classes5.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final <T> Enabled<T> create(T config) {
                    return new Enabled<>(config, null);
                }
            }

            public boolean equals(Object other) {
                return (other instanceof Enabled) && Intrinsics.areEqual(this.config, ((Enabled) other).config);
            }
        }
    }

    /* compiled from: CameraConfiguration.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Difference;", "", "deviceChanged", "", "outputsChanged", "sidePropsChanged", "isActiveChanged", "(ZZZZ)V", "getDeviceChanged", "()Z", "hasChanges", "getHasChanges", "getOutputsChanged", "getSidePropsChanged", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Difference {
        private final boolean deviceChanged;
        private final boolean isActiveChanged;
        private final boolean outputsChanged;
        private final boolean sidePropsChanged;

        public static /* synthetic */ Difference copy$default(Difference difference, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                z = difference.deviceChanged;
            }
            if ((i & 2) != 0) {
                z2 = difference.outputsChanged;
            }
            if ((i & 4) != 0) {
                z3 = difference.sidePropsChanged;
            }
            if ((i & 8) != 0) {
                z4 = difference.isActiveChanged;
            }
            return difference.copy(z, z2, z3, z4);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getDeviceChanged() {
            return this.deviceChanged;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getOutputsChanged() {
            return this.outputsChanged;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getSidePropsChanged() {
            return this.sidePropsChanged;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsActiveChanged() {
            return this.isActiveChanged;
        }

        public final Difference copy(boolean deviceChanged, boolean outputsChanged, boolean sidePropsChanged, boolean isActiveChanged) {
            return new Difference(deviceChanged, outputsChanged, sidePropsChanged, isActiveChanged);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Difference)) {
                return false;
            }
            Difference difference = (Difference) other;
            return this.deviceChanged == difference.deviceChanged && this.outputsChanged == difference.outputsChanged && this.sidePropsChanged == difference.sidePropsChanged && this.isActiveChanged == difference.isActiveChanged;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        public int hashCode() {
            boolean z = this.deviceChanged;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.outputsChanged;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            ?? r22 = this.sidePropsChanged;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            boolean z2 = this.isActiveChanged;
            return i5 + (z2 ? 1 : z2 ? 1 : 0);
        }

        public String toString() {
            return "Difference(deviceChanged=" + this.deviceChanged + ", outputsChanged=" + this.outputsChanged + ", sidePropsChanged=" + this.sidePropsChanged + ", isActiveChanged=" + this.isActiveChanged + ")";
        }

        public Difference(boolean z, boolean z2, boolean z3, boolean z4) {
            this.deviceChanged = z;
            this.outputsChanged = z2;
            this.sidePropsChanged = z3;
            this.isActiveChanged = z4;
        }

        public final boolean getDeviceChanged() {
            return this.deviceChanged;
        }

        public final boolean getOutputsChanged() {
            return this.outputsChanged;
        }

        public final boolean getSidePropsChanged() {
            return this.sidePropsChanged;
        }

        public final boolean isActiveChanged() {
            return this.isActiveChanged;
        }

        public final boolean getHasChanges() {
            return this.deviceChanged || this.outputsChanged || this.sidePropsChanged || this.isActiveChanged;
        }
    }

    /* compiled from: CameraConfiguration.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Companion;", "", "()V", "copyOf", "Lcom/mrousavy/camera/core/CameraConfiguration;", "other", "difference", "Lcom/mrousavy/camera/core/CameraConfiguration$Difference;", "left", "right", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CameraConfiguration copyOf(CameraConfiguration other) {
            CameraConfiguration copy$default;
            return (other == null || (copy$default = CameraConfiguration.copy$default(other, null, null, null, null, null, null, null, null, false, null, null, null, 0.0f, false, null, 32767, null)) == null) ? new CameraConfiguration(null, null, null, null, null, null, null, null, false, null, null, null, 0.0f, false, null, 32767, null) : copy$default;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00be  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.mrousavy.camera.core.CameraConfiguration.Difference difference(com.mrousavy.camera.core.CameraConfiguration r7, com.mrousavy.camera.core.CameraConfiguration r8) {
            /*
                r6 = this;
                java.lang.String r0 = "right"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                r0 = 0
                if (r7 == 0) goto Ld
                java.lang.String r1 = r7.getCameraId()
                goto Le
            Ld:
                r1 = r0
            Le:
                java.lang.String r2 = r8.getCameraId()
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
                r2 = 1
                r1 = r1 ^ r2
                r3 = 0
                if (r1 != 0) goto L68
                if (r7 == 0) goto L22
                com.mrousavy.camera.core.CameraConfiguration$Output r4 = r7.getPhoto()
                goto L23
            L22:
                r4 = r0
            L23:
                com.mrousavy.camera.core.CameraConfiguration$Output r5 = r8.getPhoto()
                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
                if (r4 == 0) goto L68
                com.mrousavy.camera.core.CameraConfiguration$Output r4 = r7.getVideo()
                com.mrousavy.camera.core.CameraConfiguration$Output r5 = r8.getVideo()
                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
                if (r4 == 0) goto L68
                com.mrousavy.camera.core.CameraConfiguration$Output r4 = r7.getCodeScanner()
                com.mrousavy.camera.core.CameraConfiguration$Output r5 = r8.getCodeScanner()
                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
                if (r4 == 0) goto L68
                com.mrousavy.camera.core.CameraConfiguration$Output r4 = r7.getPreview()
                com.mrousavy.camera.core.CameraConfiguration$Output r5 = r8.getPreview()
                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
                if (r4 == 0) goto L68
                com.mrousavy.camera.types.CameraDeviceFormat r4 = r7.getFormat()
                com.mrousavy.camera.types.CameraDeviceFormat r5 = r8.getFormat()
                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
                if (r4 != 0) goto L66
                goto L68
            L66:
                r4 = r3
                goto L69
            L68:
                r4 = r2
            L69:
                if (r4 != 0) goto Lbb
                if (r7 == 0) goto L71
                com.mrousavy.camera.types.Torch r0 = r7.getTorch()
            L71:
                com.mrousavy.camera.types.Torch r5 = r8.getTorch()
                if (r0 != r5) goto Lbb
                boolean r0 = r7.getEnableLowLightBoost()
                boolean r5 = r8.getEnableLowLightBoost()
                if (r0 != r5) goto Lbb
                java.lang.Integer r0 = r7.getFps()
                java.lang.Integer r5 = r8.getFps()
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r5)
                if (r0 == 0) goto Lbb
                float r0 = r7.getZoom()
                float r5 = r8.getZoom()
                int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r0 != 0) goto L9d
                r0 = r2
                goto L9e
            L9d:
                r0 = r3
            L9e:
                if (r0 == 0) goto Lbb
                com.mrousavy.camera.types.VideoStabilizationMode r0 = r7.getVideoStabilizationMode()
                com.mrousavy.camera.types.VideoStabilizationMode r5 = r8.getVideoStabilizationMode()
                if (r0 != r5) goto Lbb
                java.lang.Double r0 = r7.getExposure()
                java.lang.Double r5 = r8.getExposure()
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r5)
                if (r0 != 0) goto Lb9
                goto Lbb
            Lb9:
                r0 = r3
                goto Lbc
            Lbb:
                r0 = r2
            Lbc:
                if (r0 != 0) goto Ld1
                if (r7 == 0) goto Lcc
                boolean r7 = r7.isActive()
                boolean r8 = r8.isActive()
                if (r7 != r8) goto Lcc
                r7 = r2
                goto Lcd
            Lcc:
                r7 = r3
            Lcd:
                if (r7 != 0) goto Ld0
                goto Ld1
            Ld0:
                r2 = r3
            Ld1:
                com.mrousavy.camera.core.CameraConfiguration$Difference r7 = new com.mrousavy.camera.core.CameraConfiguration$Difference
                r7.<init>(r1, r4, r0, r2)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraConfiguration.Companion.difference(com.mrousavy.camera.core.CameraConfiguration, com.mrousavy.camera.core.CameraConfiguration):com.mrousavy.camera.core.CameraConfiguration$Difference");
        }
    }
}
