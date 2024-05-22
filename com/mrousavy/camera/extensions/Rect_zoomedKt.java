package com.mrousavy.camera.extensions;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Rect+zoomed.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"zoomed", "Landroid/graphics/Rect;", "zoomFactor", "", "react-native-vision-camera_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Rect_zoomedKt {
    public static final Rect zoomed(Rect rect, float f) {
        Intrinsics.checkNotNullParameter(rect, "<this>");
        float f2 = 2;
        int width = (int) ((rect.width() / f) / f2);
        int height = (int) ((rect.height() / f) / f2);
        return new Rect((rect.centerX() - rect.left) - width, (rect.centerY() - rect.top) - height, (rect.centerX() - rect.left) + width, (rect.centerY() - rect.top) + height);
    }
}
