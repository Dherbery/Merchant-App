package com.mrousavy.camera.extensions;

import android.util.Size;
import android.util.SizeF;
import com.mrousavy.camera.types.Orientation;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Size+Extensions.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\n\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u001a\u0015\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0086\u0002\u001a\u0012\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0000\u001a\u00020\u0005*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0007\"\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0004\"\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u0012"}, d2 = {"bigger", "", "Landroid/util/Size;", "getBigger", "(Landroid/util/Size;)I", "", "Landroid/util/SizeF;", "(Landroid/util/SizeF;)F", "smaller", "getSmaller", "closestToOrMax", "", "size", "compareTo", "other", "rotatedBy", "orientation", "Lcom/mrousavy/camera/types/Orientation;", "react-native-vision-camera_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Size_ExtensionsKt {

    /* compiled from: Size+Extensions.kt */
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

    public static final Size closestToOrMax(List<Size> list, Size size) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (size != null) {
            Iterator<T> it = list.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next = it.next();
            if (it.hasNext()) {
                Size size2 = (Size) next;
                int abs = Math.abs((size2.getWidth() * size2.getHeight()) - (size.getWidth() * size.getHeight()));
                do {
                    Object next2 = it.next();
                    Size size3 = (Size) next2;
                    int abs2 = Math.abs((size3.getWidth() * size3.getHeight()) - (size.getWidth() * size.getHeight()));
                    if (abs > abs2) {
                        next = next2;
                        abs = abs2;
                    }
                } while (it.hasNext());
            }
            return (Size) next;
        }
        Iterator<T> it2 = list.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next3 = it2.next();
        if (it2.hasNext()) {
            Size size4 = (Size) next3;
            int width = size4.getWidth() * size4.getHeight();
            do {
                Object next4 = it2.next();
                Size size5 = (Size) next4;
                int width2 = size5.getWidth() * size5.getHeight();
                if (width < width2) {
                    next3 = next4;
                    width = width2;
                }
            } while (it2.hasNext());
        }
        return (Size) next3;
    }

    public static final Size rotatedBy(Size size, Orientation orientation) {
        Intrinsics.checkNotNullParameter(size, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1 || i == 2) {
            return size;
        }
        if (i == 3 || i == 4) {
            return new Size(size.getHeight(), size.getWidth());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int getBigger(Size size) {
        Intrinsics.checkNotNullParameter(size, "<this>");
        return Math.max(size.getWidth(), size.getHeight());
    }

    public static final int getSmaller(Size size) {
        Intrinsics.checkNotNullParameter(size, "<this>");
        return Math.min(size.getWidth(), size.getHeight());
    }

    public static final float getBigger(SizeF sizeF) {
        Intrinsics.checkNotNullParameter(sizeF, "<this>");
        return Math.max(sizeF.getWidth(), sizeF.getHeight());
    }

    public static final float getSmaller(SizeF sizeF) {
        Intrinsics.checkNotNullParameter(sizeF, "<this>");
        return Math.min(sizeF.getWidth(), sizeF.getHeight());
    }

    public static final int compareTo(Size size, Size other) {
        Intrinsics.checkNotNullParameter(size, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.compare(size.getWidth() * size.getHeight(), other.getWidth() * other.getHeight());
    }
}
