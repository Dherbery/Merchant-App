package com.mrousavy.camera.core.outputs;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SurfaceOutput.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/mrousavy/camera/core/outputs/SurfaceOutput;", "Ljava/io/Closeable;", "surface", "Landroid/view/Surface;", "size", "Landroid/util/Size;", "outputType", "Lcom/mrousavy/camera/core/outputs/SurfaceOutput$OutputType;", "enableHdr", "", "(Landroid/view/Surface;Landroid/util/Size;Lcom/mrousavy/camera/core/outputs/SurfaceOutput$OutputType;Z)V", "getEnableHdr", "()Z", "isRepeating", "getOutputType", "()Lcom/mrousavy/camera/core/outputs/SurfaceOutput$OutputType;", "getSize", "()Landroid/util/Size;", "getSurface", "()Landroid/view/Surface;", "close", "", "toOutputConfiguration", "Landroid/hardware/camera2/params/OutputConfiguration;", "characteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "toString", "", "Companion", "OutputType", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public class SurfaceOutput implements Closeable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "SurfaceOutput";
    private final boolean enableHdr;
    private final OutputType outputType;
    private final Size size;
    private final Surface surface;

    /* compiled from: SurfaceOutput.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OutputType.values().length];
            try {
                iArr[OutputType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OutputType.PREVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OutputType.VIDEO_AND_PREVIEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OutputType.PHOTO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* compiled from: SurfaceOutput.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/mrousavy/camera/core/outputs/SurfaceOutput$Companion;", "", "()V", "TAG", "", "supportsOutputType", "", "characteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "outputType", "Lcom/mrousavy/camera/core/outputs/SurfaceOutput$OutputType;", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean supportsOutputType(CameraCharacteristics characteristics, OutputType outputType) {
            CameraCharacteristics.Key key;
            if (Build.VERSION.SDK_INT < 33) {
                return false;
            }
            key = CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES;
            long[] jArr = (long[]) characteristics.get(key);
            return jArr != null && ArraysKt.contains(jArr, (long) outputType.toOutputType());
        }
    }

    public SurfaceOutput(Surface surface, Size size, OutputType outputType, boolean z) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(outputType, "outputType");
        this.surface = surface;
        this.size = size;
        this.outputType = outputType;
        this.enableHdr = z;
    }

    public /* synthetic */ SurfaceOutput(Surface surface, Size size, OutputType outputType, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(surface, size, outputType, (i & 8) != 0 ? false : z);
    }

    public final boolean getEnableHdr() {
        return this.enableHdr;
    }

    public final OutputType getOutputType() {
        return this.outputType;
    }

    public final Size getSize() {
        return this.size;
    }

    public final Surface getSurface() {
        return this.surface;
    }

    public final OutputConfiguration toOutputConfiguration(CameraCharacteristics characteristics) {
        long streamUseCase;
        CameraCharacteristics.Key key;
        long dynamicRangeProfile;
        Intrinsics.checkNotNullParameter(characteristics, "characteristics");
        Downloader$$ExternalSyntheticApiModelOutline0.m1120m$1();
        OutputConfiguration m = Downloader$$ExternalSyntheticApiModelOutline0.m(this.surface);
        if (Build.VERSION.SDK_INT >= 33) {
            if (this.enableHdr) {
                key = CameraCharacteristics.REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE;
                Long l = (Long) characteristics.get(key);
                if (l != null) {
                    m.setDynamicRangeProfile(l.longValue());
                    dynamicRangeProfile = m.getDynamicRangeProfile();
                    Log.i(TAG, "Using dynamic range profile " + dynamicRangeProfile + " for " + this.outputType + " output.");
                }
            }
            if (INSTANCE.supportsOutputType(characteristics, this.outputType)) {
                m.setStreamUseCase(this.outputType.toOutputType());
                streamUseCase = m.getStreamUseCase();
                Log.i(TAG, "Using optimized stream use case " + streamUseCase + " for " + this.outputType + " output.");
            }
        }
        return m;
    }

    public final boolean isRepeating() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.outputType.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return true;
        }
        if (i == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public String toString() {
        return this.outputType + " (" + this.size.getWidth() + " x " + this.size.getHeight() + ")";
    }

    /* compiled from: SurfaceOutput.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/mrousavy/camera/core/outputs/SurfaceOutput$OutputType;", "", "(Ljava/lang/String;I)V", "toOutputType", "", "PHOTO", "VIDEO", "PREVIEW", "VIDEO_AND_PREVIEW", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum OutputType {
        PHOTO,
        VIDEO,
        PREVIEW,
        VIDEO_AND_PREVIEW;

        /* compiled from: SurfaceOutput.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[OutputType.values().length];
                try {
                    iArr[OutputType.PHOTO.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[OutputType.VIDEO.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[OutputType.PREVIEW.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[OutputType.VIDEO_AND_PREVIEW.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final int toOutputType() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return 2;
            }
            if (i == 2) {
                return 3;
            }
            if (i == 3) {
                return 1;
            }
            if (i == 4) {
                return 4;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
