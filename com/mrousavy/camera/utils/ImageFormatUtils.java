package com.mrousavy.camera.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ImageFormatUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/mrousavy/camera/utils/ImageFormatUtils;", "", "()V", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImageFormatUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: ImageFormatUtils.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/utils/ImageFormatUtils$Companion;", "", "()V", "imageFormatToString", "", "format", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String imageFormatToString(int format) {
            if (format == 3) {
                return "RGB_888";
            }
            if (format == 4) {
                return "RGB_565";
            }
            if (format == 16) {
                return "NV16";
            }
            if (format == 17) {
                return "NV21";
            }
            if (format == 20) {
                return "YUY2";
            }
            if (format == 54) {
                return "YCBCR_P010";
            }
            if (format == 256) {
                return "JPEG";
            }
            if (format == 538982489) {
                return "Y8";
            }
            if (format == 842094169) {
                return "YV12";
            }
            if (format == 34) {
                return "PRIVATE";
            }
            if (format == 35) {
                return "YUV_420_888";
            }
            switch (format) {
                case 39:
                    return "YUV_422_888";
                case 40:
                    return "YUV_444_888";
                case 41:
                    return "FLEX_RGB_888";
                case 42:
                    return "FLEX_RGBA_8888";
                default:
                    return "UNKNOWN (" + format + ")";
            }
        }
    }
}
