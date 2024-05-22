package com.mrousavy.camera.types;

import android.util.Size;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import com.mrousavy.camera.types.PixelFormat;
import com.mrousavy.camera.types.VideoStabilizationMode;
import expo.modules.kotlin.types.LazyKType$$ExternalSyntheticBackport0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraDeviceFormat.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 K2\u00020\u0001:\u0001KB\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0014¢\u0006\u0002\u0010\u0019J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\bHÆ\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\t\u00108\u001a\u00020\u0012HÆ\u0003J\t\u00109\u001a\u00020\u0014HÆ\u0003J\t\u0010:\u001a\u00020\u0014HÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00170\u000fHÆ\u0003J\t\u0010<\u001a\u00020\u0014HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\bHÆ\u0003J\t\u0010A\u001a\u00020\bHÆ\u0003J\t\u0010B\u001a\u00020\bHÆ\u0003J\t\u0010C\u001a\u00020\bHÆ\u0003J\t\u0010D\u001a\u00020\bHÆ\u0003Jµ\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u0014HÆ\u0001J\u0013\u0010F\u001a\u00020\u00142\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020\u0003HÖ\u0001J\t\u0010I\u001a\u00020JHÖ\u0001R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0018\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0015\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b/\u0010-R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010$R\u0011\u00101\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b2\u0010(R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b3\u0010+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010$¨\u0006L"}, d2 = {"Lcom/mrousavy/camera/types/CameraDeviceFormat;", "", "videoWidth", "", "videoHeight", "photoWidth", "photoHeight", "minFps", "", "maxFps", "minISO", "maxISO", "fieldOfView", "maxZoom", "videoStabilizationModes", "", "Lcom/mrousavy/camera/types/VideoStabilizationMode;", "autoFocusSystem", "Lcom/mrousavy/camera/types/AutoFocusSystem;", "supportsVideoHdr", "", "supportsPhotoHdr", "pixelFormats", "Lcom/mrousavy/camera/types/PixelFormat;", "supportsDepthCapture", "(IIIIDDDDDDLjava/util/List;Lcom/mrousavy/camera/types/AutoFocusSystem;ZZLjava/util/List;Z)V", "getAutoFocusSystem", "()Lcom/mrousavy/camera/types/AutoFocusSystem;", "getFieldOfView", "()D", "getMaxFps", "getMaxISO", "getMaxZoom", "getMinFps", "getMinISO", "getPhotoHeight", "()I", "photoSize", "Landroid/util/Size;", "getPhotoSize", "()Landroid/util/Size;", "getPhotoWidth", "getPixelFormats", "()Ljava/util/List;", "getSupportsDepthCapture", "()Z", "getSupportsPhotoHdr", "getSupportsVideoHdr", "getVideoHeight", "videoSize", "getVideoSize", "getVideoStabilizationModes", "getVideoWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CameraDeviceFormat {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AutoFocusSystem autoFocusSystem;
    private final double fieldOfView;
    private final double maxFps;
    private final double maxISO;
    private final double maxZoom;
    private final double minFps;
    private final double minISO;
    private final int photoHeight;
    private final int photoWidth;
    private final List<PixelFormat> pixelFormats;
    private final boolean supportsDepthCapture;
    private final boolean supportsPhotoHdr;
    private final boolean supportsVideoHdr;
    private final int videoHeight;
    private final List<VideoStabilizationMode> videoStabilizationModes;
    private final int videoWidth;

    /* renamed from: component1, reason: from getter */
    public final int getVideoWidth() {
        return this.videoWidth;
    }

    /* renamed from: component10, reason: from getter */
    public final double getMaxZoom() {
        return this.maxZoom;
    }

    public final List<VideoStabilizationMode> component11() {
        return this.videoStabilizationModes;
    }

    /* renamed from: component12, reason: from getter */
    public final AutoFocusSystem getAutoFocusSystem() {
        return this.autoFocusSystem;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getSupportsVideoHdr() {
        return this.supportsVideoHdr;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getSupportsPhotoHdr() {
        return this.supportsPhotoHdr;
    }

    public final List<PixelFormat> component15() {
        return this.pixelFormats;
    }

    /* renamed from: component16, reason: from getter */
    public final boolean getSupportsDepthCapture() {
        return this.supportsDepthCapture;
    }

    /* renamed from: component2, reason: from getter */
    public final int getVideoHeight() {
        return this.videoHeight;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPhotoWidth() {
        return this.photoWidth;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPhotoHeight() {
        return this.photoHeight;
    }

    /* renamed from: component5, reason: from getter */
    public final double getMinFps() {
        return this.minFps;
    }

    /* renamed from: component6, reason: from getter */
    public final double getMaxFps() {
        return this.maxFps;
    }

    /* renamed from: component7, reason: from getter */
    public final double getMinISO() {
        return this.minISO;
    }

    /* renamed from: component8, reason: from getter */
    public final double getMaxISO() {
        return this.maxISO;
    }

    /* renamed from: component9, reason: from getter */
    public final double getFieldOfView() {
        return this.fieldOfView;
    }

    public final CameraDeviceFormat copy(int videoWidth, int videoHeight, int photoWidth, int photoHeight, double minFps, double maxFps, double minISO, double maxISO, double fieldOfView, double maxZoom, List<? extends VideoStabilizationMode> videoStabilizationModes, AutoFocusSystem autoFocusSystem, boolean supportsVideoHdr, boolean supportsPhotoHdr, List<? extends PixelFormat> pixelFormats, boolean supportsDepthCapture) {
        Intrinsics.checkNotNullParameter(videoStabilizationModes, "videoStabilizationModes");
        Intrinsics.checkNotNullParameter(autoFocusSystem, "autoFocusSystem");
        Intrinsics.checkNotNullParameter(pixelFormats, "pixelFormats");
        return new CameraDeviceFormat(videoWidth, videoHeight, photoWidth, photoHeight, minFps, maxFps, minISO, maxISO, fieldOfView, maxZoom, videoStabilizationModes, autoFocusSystem, supportsVideoHdr, supportsPhotoHdr, pixelFormats, supportsDepthCapture);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CameraDeviceFormat)) {
            return false;
        }
        CameraDeviceFormat cameraDeviceFormat = (CameraDeviceFormat) other;
        return this.videoWidth == cameraDeviceFormat.videoWidth && this.videoHeight == cameraDeviceFormat.videoHeight && this.photoWidth == cameraDeviceFormat.photoWidth && this.photoHeight == cameraDeviceFormat.photoHeight && Double.compare(this.minFps, cameraDeviceFormat.minFps) == 0 && Double.compare(this.maxFps, cameraDeviceFormat.maxFps) == 0 && Double.compare(this.minISO, cameraDeviceFormat.minISO) == 0 && Double.compare(this.maxISO, cameraDeviceFormat.maxISO) == 0 && Double.compare(this.fieldOfView, cameraDeviceFormat.fieldOfView) == 0 && Double.compare(this.maxZoom, cameraDeviceFormat.maxZoom) == 0 && Intrinsics.areEqual(this.videoStabilizationModes, cameraDeviceFormat.videoStabilizationModes) && this.autoFocusSystem == cameraDeviceFormat.autoFocusSystem && this.supportsVideoHdr == cameraDeviceFormat.supportsVideoHdr && this.supportsPhotoHdr == cameraDeviceFormat.supportsPhotoHdr && Intrinsics.areEqual(this.pixelFormats, cameraDeviceFormat.pixelFormats) && this.supportsDepthCapture == cameraDeviceFormat.supportsDepthCapture;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int m = ((((((((((((((((((((((this.videoWidth * 31) + this.videoHeight) * 31) + this.photoWidth) * 31) + this.photoHeight) * 31) + LazyKType$$ExternalSyntheticBackport0.m(this.minFps)) * 31) + LazyKType$$ExternalSyntheticBackport0.m(this.maxFps)) * 31) + LazyKType$$ExternalSyntheticBackport0.m(this.minISO)) * 31) + LazyKType$$ExternalSyntheticBackport0.m(this.maxISO)) * 31) + LazyKType$$ExternalSyntheticBackport0.m(this.fieldOfView)) * 31) + LazyKType$$ExternalSyntheticBackport0.m(this.maxZoom)) * 31) + this.videoStabilizationModes.hashCode()) * 31) + this.autoFocusSystem.hashCode()) * 31;
        boolean z = this.supportsVideoHdr;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (m + i) * 31;
        boolean z2 = this.supportsPhotoHdr;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int hashCode = (((i2 + i3) * 31) + this.pixelFormats.hashCode()) * 31;
        boolean z3 = this.supportsDepthCapture;
        return hashCode + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        return "CameraDeviceFormat(videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", photoWidth=" + this.photoWidth + ", photoHeight=" + this.photoHeight + ", minFps=" + this.minFps + ", maxFps=" + this.maxFps + ", minISO=" + this.minISO + ", maxISO=" + this.maxISO + ", fieldOfView=" + this.fieldOfView + ", maxZoom=" + this.maxZoom + ", videoStabilizationModes=" + this.videoStabilizationModes + ", autoFocusSystem=" + this.autoFocusSystem + ", supportsVideoHdr=" + this.supportsVideoHdr + ", supportsPhotoHdr=" + this.supportsPhotoHdr + ", pixelFormats=" + this.pixelFormats + ", supportsDepthCapture=" + this.supportsDepthCapture + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CameraDeviceFormat(int i, int i2, int i3, int i4, double d, double d2, double d3, double d4, double d5, double d6, List<? extends VideoStabilizationMode> videoStabilizationModes, AutoFocusSystem autoFocusSystem, boolean z, boolean z2, List<? extends PixelFormat> pixelFormats, boolean z3) {
        Intrinsics.checkNotNullParameter(videoStabilizationModes, "videoStabilizationModes");
        Intrinsics.checkNotNullParameter(autoFocusSystem, "autoFocusSystem");
        Intrinsics.checkNotNullParameter(pixelFormats, "pixelFormats");
        this.videoWidth = i;
        this.videoHeight = i2;
        this.photoWidth = i3;
        this.photoHeight = i4;
        this.minFps = d;
        this.maxFps = d2;
        this.minISO = d3;
        this.maxISO = d4;
        this.fieldOfView = d5;
        this.maxZoom = d6;
        this.videoStabilizationModes = videoStabilizationModes;
        this.autoFocusSystem = autoFocusSystem;
        this.supportsVideoHdr = z;
        this.supportsPhotoHdr = z2;
        this.pixelFormats = pixelFormats;
        this.supportsDepthCapture = z3;
    }

    public final int getVideoWidth() {
        return this.videoWidth;
    }

    public final int getVideoHeight() {
        return this.videoHeight;
    }

    public final int getPhotoWidth() {
        return this.photoWidth;
    }

    public final int getPhotoHeight() {
        return this.photoHeight;
    }

    public final double getMinFps() {
        return this.minFps;
    }

    public final double getMaxFps() {
        return this.maxFps;
    }

    public final double getMinISO() {
        return this.minISO;
    }

    public final double getMaxISO() {
        return this.maxISO;
    }

    public final double getFieldOfView() {
        return this.fieldOfView;
    }

    public final double getMaxZoom() {
        return this.maxZoom;
    }

    public final List<VideoStabilizationMode> getVideoStabilizationModes() {
        return this.videoStabilizationModes;
    }

    public final AutoFocusSystem getAutoFocusSystem() {
        return this.autoFocusSystem;
    }

    public final boolean getSupportsVideoHdr() {
        return this.supportsVideoHdr;
    }

    public final boolean getSupportsPhotoHdr() {
        return this.supportsPhotoHdr;
    }

    public final List<PixelFormat> getPixelFormats() {
        return this.pixelFormats;
    }

    public final boolean getSupportsDepthCapture() {
        return this.supportsDepthCapture;
    }

    public final Size getPhotoSize() {
        return new Size(this.photoWidth, this.photoHeight);
    }

    public final Size getVideoSize() {
        return new Size(this.videoWidth, this.videoHeight);
    }

    /* compiled from: CameraDeviceFormat.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/types/CameraDeviceFormat$Companion;", "", "()V", "fromJSValue", "Lcom/mrousavy/camera/types/CameraDeviceFormat;", "value", "Lcom/facebook/react/bridge/ReadableMap;", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CameraDeviceFormat fromJSValue(ReadableMap value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ReadableArray array = value.getArray("videoStabilizationModes");
            if (array == null) {
                throw new InvalidTypeScriptUnionError("format", value.toString());
            }
            ArrayList<Object> arrayList = array.toArrayList();
            Intrinsics.checkNotNullExpressionValue(arrayList, "modes.toArrayList()");
            ArrayList<Object> arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (Object obj : arrayList2) {
                VideoStabilizationMode.Companion companion = VideoStabilizationMode.INSTANCE;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                arrayList3.add(companion.fromUnionValue((String) obj));
            }
            ArrayList arrayList4 = arrayList3;
            ReadableArray array2 = value.getArray("pixelFormats");
            if (array2 == null) {
                throw new InvalidTypeScriptUnionError("format", value.toString());
            }
            ArrayList<Object> arrayList5 = array2.toArrayList();
            Intrinsics.checkNotNullExpressionValue(arrayList5, "formats.toArrayList()");
            ArrayList<Object> arrayList6 = arrayList5;
            ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
            for (Object obj2 : arrayList6) {
                PixelFormat.Companion companion2 = PixelFormat.INSTANCE;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                arrayList7.add(companion2.fromUnionValue((String) obj2));
            }
            ArrayList arrayList8 = arrayList7;
            return new CameraDeviceFormat(value.getInt("videoWidth"), value.getInt("videoHeight"), value.getInt("photoWidth"), value.getInt("photoHeight"), value.getDouble("minFps"), value.getDouble("maxFps"), value.getDouble("minISO"), value.getDouble("maxISO"), value.getDouble("fieldOfView"), value.getDouble("maxZoom"), arrayList4, AutoFocusSystem.INSTANCE.fromUnionValue(value.getString("autoFocusSystem")), value.getBoolean("supportsVideoHdr"), value.getBoolean("supportsPhotoHdr"), arrayList8, value.getBoolean("supportsDepthCapture"));
        }
    }
}
