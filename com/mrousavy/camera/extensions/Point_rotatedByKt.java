package com.mrousavy.camera.extensions;

import android.graphics.Point;
import android.graphics.PointF;
import android.util.Log;
import android.util.Size;
import com.canhub.cropper.CropImageOptions;
import com.mrousavy.camera.types.Orientation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Point+rotatedBy.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"rotatedBy", "Landroid/graphics/Point;", "fromSize", "Landroid/util/Size;", "toSize", "fromOrientation", "Lcom/mrousavy/camera/types/Orientation;", "toOrientation", "react-native-vision-camera_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Point_rotatedByKt {

    /* compiled from: Point+rotatedBy.kt */
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
                iArr[Orientation.PORTRAIT_UPSIDE_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Orientation.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Orientation.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Point rotatedBy(Point point, Size fromSize, Size toSize, Orientation fromOrientation, Orientation toOrientation) {
        PointF pointF;
        Intrinsics.checkNotNullParameter(point, "<this>");
        Intrinsics.checkNotNullParameter(fromSize, "fromSize");
        Intrinsics.checkNotNullParameter(toSize, "toSize");
        Intrinsics.checkNotNullParameter(fromOrientation, "fromOrientation");
        Intrinsics.checkNotNullParameter(toOrientation, "toOrientation");
        Orientation fromRotationDegrees = Orientation.INSTANCE.fromRotationDegrees((fromOrientation.toDegrees() + toOrientation.toDegrees()) % CropImageOptions.DEGREES_360);
        PointF pointF2 = new PointF(point.x / fromSize.getWidth(), point.y / fromSize.getHeight());
        int i = WhenMappings.$EnumSwitchMapping$0[fromRotationDegrees.ordinal()];
        if (i == 1) {
            pointF = pointF2;
        } else if (i == 2) {
            float f = 1;
            pointF = new PointF(f - pointF2.x, f - pointF2.y);
        } else if (i == 3) {
            pointF = new PointF(pointF2.y, 1 - pointF2.x);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            pointF = new PointF(1 - pointF2.y, pointF2.x);
        }
        float width = pointF.x * toSize.getWidth();
        float height = pointF.y * toSize.getHeight();
        Log.i("ROTATE", point + " -> " + pointF2 + " -> " + fromRotationDegrees + " -> " + width + ", " + height);
        return new Point((int) width, (int) height);
    }
}
