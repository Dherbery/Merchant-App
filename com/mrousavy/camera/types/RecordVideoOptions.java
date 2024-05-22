package com.mrousavy.camera.types;

import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecordVideoOptions.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/mrousavy/camera/types/RecordVideoOptions;", "", "map", "Lcom/facebook/react/bridge/ReadableMap;", "(Lcom/facebook/react/bridge/ReadableMap;)V", "fileType", "Lcom/mrousavy/camera/types/VideoFileType;", "getFileType", "()Lcom/mrousavy/camera/types/VideoFileType;", "setFileType", "(Lcom/mrousavy/camera/types/VideoFileType;)V", "flash", "Lcom/mrousavy/camera/types/Flash;", "getFlash", "()Lcom/mrousavy/camera/types/Flash;", "setFlash", "(Lcom/mrousavy/camera/types/Flash;)V", "videoBitRateMultiplier", "", "getVideoBitRateMultiplier", "()Ljava/lang/Double;", "setVideoBitRateMultiplier", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "videoBitRateOverride", "getVideoBitRateOverride", "setVideoBitRateOverride", "videoCodec", "Lcom/mrousavy/camera/types/VideoCodec;", "getVideoCodec", "()Lcom/mrousavy/camera/types/VideoCodec;", "setVideoCodec", "(Lcom/mrousavy/camera/types/VideoCodec;)V", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecordVideoOptions {
    private VideoFileType fileType;
    private Flash flash;
    private Double videoBitRateMultiplier;
    private Double videoBitRateOverride;
    private VideoCodec videoCodec;

    public RecordVideoOptions(ReadableMap map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.fileType = VideoFileType.MOV;
        this.flash = Flash.OFF;
        this.videoCodec = VideoCodec.H264;
        if (map.hasKey("fileType")) {
            this.fileType = VideoFileType.INSTANCE.fromUnionValue(map.getString("fileType"));
        }
        if (map.hasKey("flash")) {
            this.flash = Flash.INSTANCE.fromUnionValue(map.getString("flash"));
        }
        if (map.hasKey("videoCodec")) {
            this.videoCodec = VideoCodec.INSTANCE.fromUnionValue(map.getString("videoCodec"));
        }
        if (map.hasKey("videoBitRateOverride")) {
            this.videoBitRateOverride = Double.valueOf(map.getDouble("videoBitRateOverride"));
        }
        if (map.hasKey("videoBitRateMultiplier")) {
            this.videoBitRateMultiplier = Double.valueOf(map.getDouble("videoBitRateMultiplier"));
        }
    }

    public final VideoFileType getFileType() {
        return this.fileType;
    }

    public final void setFileType(VideoFileType videoFileType) {
        Intrinsics.checkNotNullParameter(videoFileType, "<set-?>");
        this.fileType = videoFileType;
    }

    public final Flash getFlash() {
        return this.flash;
    }

    public final void setFlash(Flash flash) {
        Intrinsics.checkNotNullParameter(flash, "<set-?>");
        this.flash = flash;
    }

    public final VideoCodec getVideoCodec() {
        return this.videoCodec;
    }

    public final void setVideoCodec(VideoCodec videoCodec) {
        Intrinsics.checkNotNullParameter(videoCodec, "<set-?>");
        this.videoCodec = videoCodec;
    }

    public final Double getVideoBitRateOverride() {
        return this.videoBitRateOverride;
    }

    public final void setVideoBitRateOverride(Double d) {
        this.videoBitRateOverride = d;
    }

    public final Double getVideoBitRateMultiplier() {
        return this.videoBitRateMultiplier;
    }

    public final void setVideoBitRateMultiplier(Double d) {
        this.videoBitRateMultiplier = d;
    }
}
