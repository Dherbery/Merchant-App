package com.facebook.react.uimanager;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/* loaded from: classes3.dex */
public class RootViewUtil {
    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.react.uimanager.RootView getRootView(android.view.View r1) {
        /*
        L0:
            boolean r0 = r1 instanceof com.facebook.react.uimanager.RootView
            if (r0 == 0) goto L7
            com.facebook.react.uimanager.RootView r1 = (com.facebook.react.uimanager.RootView) r1
            return r1
        L7:
            android.view.ViewParent r1 = r1.getParent()
            if (r1 != 0) goto Lf
            r1 = 0
            return r1
        Lf:
            boolean r0 = r1 instanceof android.view.View
            com.facebook.infer.annotation.Assertions.assertCondition(r0)
            android.view.View r1 = (android.view.View) r1
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.RootViewUtil.getRootView(android.view.View):com.facebook.react.uimanager.RootView");
    }

    public static Point getViewportOffset(View view) {
        view.getLocationInWindow(r0);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int[] iArr = {iArr[0] - rect.left, iArr[1] - rect.top};
        return new Point(iArr[0], iArr[1]);
    }
}
