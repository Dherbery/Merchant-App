package com.mrousavy.camera.types;

import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import com.mrousavy.camera.core.PixelFormatNotSupportedError;
import com.mrousavy.camera.types.JSUnionValue;
import com.mrousavy.camera.utils.HardwareBufferUtils;
import com.mrousavy.camera.utils.ImageFormatUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PixelFormat.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/mrousavy/camera/types/PixelFormat;", "", "Lcom/mrousavy/camera/types/JSUnionValue;", "unionValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "toHardwareBufferFormat", "", "toImageFormat", "YUV", "RGB", "NATIVE", "UNKNOWN", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum PixelFormat implements JSUnionValue {
    YUV("yuv"),
    RGB("rgb"),
    NATIVE("native"),
    UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "PixelFormat";
    private final String unionValue;

    /* compiled from: PixelFormat.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PixelFormat.values().length];
            try {
                iArr[PixelFormat.YUV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PixelFormat.NATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    PixelFormat(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    public final int toImageFormat() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 35;
        }
        if (i == 2) {
            return 34;
        }
        throw new PixelFormatNotSupportedError(getUnionValue());
    }

    public final int toHardwareBufferFormat() {
        return HardwareBufferUtils.INSTANCE.getHardwareBufferFormat(toImageFormat());
    }

    /* compiled from: PixelFormat.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bJ\u0012\u0010\t\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/mrousavy/camera/types/PixelFormat$Companion;", "Lcom/mrousavy/camera/types/JSUnionValue$Companion;", "Lcom/mrousavy/camera/types/PixelFormat;", "()V", "TAG", "", "fromImageFormat", "imageFormat", "", "fromUnionValue", "unionValue", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion implements JSUnionValue.Companion<PixelFormat> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PixelFormat fromImageFormat(int imageFormat) {
            if (imageFormat == 34) {
                return PixelFormat.NATIVE;
            }
            if (imageFormat == 35) {
                return PixelFormat.YUV;
            }
            Log.w(PixelFormat.TAG, "Unknown PixelFormat! " + ImageFormatUtils.INSTANCE.imageFormatToString(imageFormat));
            return PixelFormat.UNKNOWN;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.types.JSUnionValue.Companion
        public PixelFormat fromUnionValue(String unionValue) {
            if (unionValue != null) {
                switch (unionValue.hashCode()) {
                    case -1052618729:
                        if (unionValue.equals("native")) {
                            return PixelFormat.NATIVE;
                        }
                        break;
                    case -284840886:
                        if (unionValue.equals(EnvironmentCompat.MEDIA_UNKNOWN)) {
                            return PixelFormat.UNKNOWN;
                        }
                        break;
                    case 112845:
                        if (unionValue.equals("rgb")) {
                            return PixelFormat.RGB;
                        }
                        break;
                    case 120026:
                        if (unionValue.equals("yuv")) {
                            return PixelFormat.YUV;
                        }
                        break;
                }
            }
            throw new InvalidTypeScriptUnionError("pixelFormat", unionValue);
        }
    }
}
