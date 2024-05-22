package com.onesignal.common;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowInsets;
import com.onesignal.core.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewUtils.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0003J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t¨\u0006\u0012"}, d2 = {"Lcom/onesignal/common/ViewUtils;", "", "()V", "dpToPx", "", "dp", "getCutoutAndStatusBarInsets", "", "activity", "Landroid/app/Activity;", "getDisplaySizeY", "getFullbleedWindowWidth", "getWindowHeight", "getWindowHeightAPI23Plus", "getWindowHeightLollipop", "getWindowVisibleDisplayFrame", "Landroid/graphics/Rect;", "getWindowWidth", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewUtils {
    public static final ViewUtils INSTANCE = new ViewUtils();

    private ViewUtils() {
    }

    public final int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public final int getWindowHeight(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return getWindowHeightAPI23Plus(activity);
    }

    private final int getDisplaySizeY(Activity activity) {
        Point point = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(point);
        return point.y;
    }

    private final int getWindowHeightAPI23Plus(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
        return rootWindowInsets == null ? decorView.getHeight() : (decorView.getHeight() - rootWindowInsets.getStableInsetBottom()) - rootWindowInsets.getStableInsetTop();
    }

    private final int getWindowHeightLollipop(Activity activity) {
        if (activity.getResources().getConfiguration().orientation == 2) {
            return getWindowVisibleDisplayFrame(activity).height();
        }
        return getDisplaySizeY(activity);
    }

    private final Rect getWindowVisibleDisplayFrame(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0040, code lost:
    
        r5 = r5.getWindowManager().getDefaultDisplay().getCutout();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int[] getCutoutAndStatusBarInsets(android.app.Activity r5) {
        /*
            r4 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.graphics.Rect r0 = r4.getWindowVisibleDisplayFrame(r5)
            android.view.Window r1 = r5.getWindow()
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r1 = r1.findViewById(r2)
            int r2 = r0.top
            int r3 = r1.getTop()
            int r2 = r2 - r3
            float r2 = (float) r2
            android.content.res.Resources r3 = android.content.res.Resources.getSystem()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            float r3 = r3.density
            float r2 = r2 / r3
            int r1 = r1.getBottom()
            int r0 = r0.bottom
            int r1 = r1 - r0
            float r0 = (float) r1
            android.content.res.Resources r1 = android.content.res.Resources.getSystem()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            float r1 = r1.density
            float r0 = r0 / r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 29
            if (r1 != r3) goto L6f
            android.view.WindowManager r5 = r5.getWindowManager()
            android.view.Display r5 = r5.getDefaultDisplay()
            android.view.DisplayCutout r5 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m(r5)
            if (r5 == 0) goto L6f
            int r1 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m(r5)
            float r1 = (float) r1
            android.content.res.Resources r3 = android.content.res.Resources.getSystem()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            float r3 = r3.density
            float r1 = r1 / r3
            int r5 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m$1(r5)
            float r5 = (float) r5
            android.content.res.Resources r3 = android.content.res.Resources.getSystem()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            float r3 = r3.density
            float r5 = r5 / r3
            goto L71
        L6f:
            r1 = 0
            r5 = r1
        L71:
            int r2 = kotlin.math.MathKt.roundToInt(r2)
            int r0 = kotlin.math.MathKt.roundToInt(r0)
            int r1 = kotlin.math.MathKt.roundToInt(r1)
            int r5 = kotlin.math.MathKt.roundToInt(r5)
            int[] r5 = new int[]{r2, r0, r1, r5}
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.common.ViewUtils.getCutoutAndStatusBarInsets(android.app.Activity):int[]");
    }

    public final int getFullbleedWindowWidth(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        return decorView.getWidth();
    }

    public final int getWindowWidth(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return getWindowVisibleDisplayFrame(activity).width();
    }
}
