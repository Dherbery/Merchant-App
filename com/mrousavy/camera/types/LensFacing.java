package com.mrousavy.camera.types;

import android.hardware.camera2.CameraCharacteristics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LensFacing.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/mrousavy/camera/types/LensFacing;", "", "Lcom/mrousavy/camera/types/JSUnionValue;", "unionValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "BACK", "FRONT", "EXTERNAL", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum LensFacing implements JSUnionValue {
    BACK("back"),
    FRONT("front"),
    EXTERNAL("external");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String unionValue;

    LensFacing(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    /* compiled from: LensFacing.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/types/LensFacing$Companion;", "", "()V", "fromCameraCharacteristics", "Lcom/mrousavy/camera/types/LensFacing;", "cameraCharacteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LensFacing fromCameraCharacteristics(CameraCharacteristics cameraCharacteristics) {
            Intrinsics.checkNotNullParameter(cameraCharacteristics, "cameraCharacteristics");
            Object obj = cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
            Intrinsics.checkNotNull(obj);
            int intValue = ((Number) obj).intValue();
            if (intValue == 0) {
                return LensFacing.FRONT;
            }
            if (intValue == 1) {
                return LensFacing.BACK;
            }
            if (intValue == 2) {
                return LensFacing.EXTERNAL;
            }
            return LensFacing.EXTERNAL;
        }
    }
}
