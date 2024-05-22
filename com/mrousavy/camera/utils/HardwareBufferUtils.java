package com.mrousavy.camera.utils;

import android.media.ImageReader;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HardwareBufferUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/mrousavy/camera/utils/HardwareBufferUtils;", "", "()V", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HardwareBufferUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: HardwareBufferUtils.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/mrousavy/camera/utils/HardwareBufferUtils$Companion;", "", "()V", "getHardwareBufferFormat", "", "imageFormat", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getHardwareBufferFormat(int imageFormat) {
            ImageReader newInstance;
            int hardwareBufferFormat;
            if (Build.VERSION.SDK_INT < 33) {
                return imageFormat == 34 ? Build.VERSION.SDK_INT >= 30 ? 35 : 3 : imageFormat;
            }
            newInstance = ImageReader.newInstance(1, 1, imageFormat, 1, 256L);
            Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(1, 1, imageF….USAGE_GPU_SAMPLED_IMAGE)");
            hardwareBufferFormat = newInstance.getHardwareBufferFormat();
            newInstance.close();
            return hardwareBufferFormat;
        }
    }
}
