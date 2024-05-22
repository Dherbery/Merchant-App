package com.mrousavy.camera.types;

import com.canhub.cropper.CropImageOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.mrousavy.camera.core.CameraDeviceDetails;
import com.mrousavy.camera.types.JSUnionValue;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Orientation.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/mrousavy/camera/types/Orientation;", "", "Lcom/mrousavy/camera/types/JSUnionValue;", "unionValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "toDegrees", "", "toSensorRelativeOrientation", "deviceDetails", "Lcom/mrousavy/camera/core/CameraDeviceDetails;", "PORTRAIT", "LANDSCAPE_RIGHT", "PORTRAIT_UPSIDE_DOWN", "LANDSCAPE_LEFT", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum Orientation implements JSUnionValue {
    PORTRAIT("portrait"),
    LANDSCAPE_RIGHT("landscape-right"),
    PORTRAIT_UPSIDE_DOWN("portrait-upside-down"),
    LANDSCAPE_LEFT("landscape-left");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String unionValue;

    /* compiled from: Orientation.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.LANDSCAPE_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Orientation.PORTRAIT_UPSIDE_DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Orientation.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    Orientation(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    public final int toDegrees() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 90;
        }
        if (i == 3) {
            return RotationOptions.ROTATE_180;
        }
        if (i == 4) {
            return RotationOptions.ROTATE_270;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Orientation toSensorRelativeOrientation(CameraDeviceDetails deviceDetails) {
        Intrinsics.checkNotNullParameter(deviceDetails, "deviceDetails");
        int degrees = toDegrees();
        if (deviceDetails.getLensFacing() == LensFacing.FRONT) {
            degrees = -degrees;
        }
        return INSTANCE.fromRotationDegrees(((deviceDetails.getSensorOrientation().toDegrees() + degrees) + CropImageOptions.DEGREES_360) % CropImageOptions.DEGREES_360);
    }

    /* compiled from: Orientation.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/mrousavy/camera/types/Orientation$Companion;", "Lcom/mrousavy/camera/types/JSUnionValue$Companion;", "Lcom/mrousavy/camera/types/Orientation;", "()V", "fromRotationDegrees", "rotationDegrees", "", "fromUnionValue", "unionValue", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion implements JSUnionValue.Companion<Orientation> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.types.JSUnionValue.Companion
        public Orientation fromUnionValue(String unionValue) {
            if (unionValue != null) {
                switch (unionValue.hashCode()) {
                    case -1510435861:
                        if (unionValue.equals("portrait-upside-down")) {
                            return Orientation.PORTRAIT_UPSIDE_DOWN;
                        }
                        break;
                    case 687313034:
                        if (unionValue.equals("landscape-right")) {
                            return Orientation.LANDSCAPE_RIGHT;
                        }
                        break;
                    case 729267099:
                        if (unionValue.equals("portrait")) {
                            return Orientation.PORTRAIT;
                        }
                        break;
                    case 1684556761:
                        if (unionValue.equals("landscape-left")) {
                            return Orientation.LANDSCAPE_LEFT;
                        }
                        break;
                }
            }
            return Orientation.PORTRAIT;
        }

        public final Orientation fromRotationDegrees(int rotationDegrees) {
            if (45 <= rotationDegrees && rotationDegrees < 136) {
                return Orientation.LANDSCAPE_LEFT;
            }
            if (135 <= rotationDegrees && rotationDegrees < 226) {
                return Orientation.PORTRAIT_UPSIDE_DOWN;
            }
            if (225 <= rotationDegrees && rotationDegrees < 316) {
                return Orientation.LANDSCAPE_RIGHT;
            }
            return Orientation.PORTRAIT;
        }
    }
}
