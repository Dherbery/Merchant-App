package com.canhub.cropper;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import com.canhub.cropper.CropException;
import com.canhub.cropper.CropImageView;
import com.canhub.cropper.common.CommonVersionCheck;
import com.canhub.cropper.utils.GetUriForFileKt;
import com.facebook.imagepipeline.common.RotationOptions;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.apache.commons.io.IOUtils;

/* compiled from: BitmapUtils.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002ijB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u0018\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fH\u0002J(\u0010,\u001a\u00020\f2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\f2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\fH\u0002J\u0012\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0002Jp\u00103\u001a\u0002042\u0006\u0010%\u001a\u00020&2\u0006\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\f2\u0006\u0010>\u001a\u0002092\u0006\u0010?\u001a\u000209H\u0002Jx\u00103\u001a\u0002042\u0006\u0010%\u001a\u00020&2\u0006\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\f2\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\f2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\f2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\f2\u0006\u0010>\u001a\u0002092\u0006\u0010?\u001a\u0002092\u0006\u0010<\u001a\u00020\fH\u0002Jp\u00103\u001a\u0002042\u0006\u0010%\u001a\u00020&2\b\u00105\u001a\u0004\u0018\u00010$2\u0006\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\f2\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\f2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\f2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\f2\u0006\u0010>\u001a\u0002092\u0006\u0010?\u001a\u000209JH\u0010B\u001a\u0002042\b\u0010C\u001a\u0004\u0018\u00010\u001b2\u0006\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\f2\u0006\u0010>\u001a\u0002092\u0006\u0010?\u001a\u000209JR\u0010D\u001a\u0004\u0018\u00010\u001b2\u0006\u0010C\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\f2\u0006\u0010E\u001a\u00020F2\u0006\u0010>\u001a\u0002092\u0006\u0010?\u001a\u000209H\u0002JD\u0010G\u001a\u0004\u0018\u00010\u001b2\b\u0010C\u001a\u0004\u0018\u00010\u001b2\u0006\u00106\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u00042\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\fH\u0002J\"\u0010H\u001a\u0004\u0018\u00010\u001b2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020MH\u0002J\u0018\u0010N\u001a\u00020M2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020$H\u0002J&\u0010O\u001a\u0002042\u0006\u0010%\u001a\u00020&2\u0006\u0010K\u001a\u00020$2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\fJ8\u0010P\u001a\u0002042\u0006\u0010%\u001a\u00020&2\u0006\u0010K\u001a\u00020$2\u0006\u0010=\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\f2\u0006\u0010<\u001a\u00020\fH\u0002J \u0010Q\u001a\u0002002\u0006\u0010=\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\fH\u0002J\u000e\u0010R\u001a\u00020F2\u0006\u00106\u001a\u00020\u000eJ\u000e\u0010S\u001a\u00020F2\u0006\u00106\u001a\u00020\u000eJ\u000e\u0010T\u001a\u00020F2\u0006\u00106\u001a\u00020\u000eJ6\u0010U\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u000e2\u0006\u0010V\u001a\u00020\f2\u0006\u0010W\u001a\u00020\f2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\fJ\u000e\u0010X\u001a\u00020F2\u0006\u00106\u001a\u00020\u000eJ\u000e\u0010Y\u001a\u00020F2\u0006\u00106\u001a\u00020\u000eJ\u000e\u0010Z\u001a\u00020F2\u0006\u00106\u001a\u00020\u000eJ\u000e\u0010[\u001a\u00020F2\u0006\u00106\u001a\u00020\u000eJ\u000e\u0010\\\u001a\u00020F2\u0006\u00106\u001a\u00020\u000eJ\"\u0010]\u001a\u00020^2\b\u0010C\u001a\u0004\u0018\u00010\u001b2\u0006\u0010%\u001a\u00020&2\b\u0010K\u001a\u0004\u0018\u00010$J\u0018\u0010]\u001a\u00020^2\b\u0010C\u001a\u0004\u0018\u00010\u001b2\u0006\u0010_\u001a\u00020`J(\u0010a\u001a\u00020\u001b2\b\u0010C\u001a\u0004\u0018\u00010\u001b2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\f2\u0006\u0010L\u001a\u00020bJ(\u0010c\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u001b2\u0006\u0010d\u001a\u00020\f2\u0006\u0010>\u001a\u0002092\u0006\u0010?\u001a\u000209H\u0002J2\u0010e\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\u0006\u0010C\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(2\u0006\u0010f\u001a\u00020\f2\b\u0010g\u001a\u0004\u0018\u00010$J$\u0010h\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010C\u001a\u0004\u0018\u00010\u001b2\b\u0010g\u001a\u0004\u0018\u00010$R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006k"}, d2 = {"Lcom/canhub/cropper/BitmapUtils;", "", "()V", "EMPTY_RECT", "Landroid/graphics/Rect;", "getEMPTY_RECT", "()Landroid/graphics/Rect;", "EMPTY_RECT_F", "Landroid/graphics/RectF;", "getEMPTY_RECT_F", "()Landroid/graphics/RectF;", "IMAGE_MAX_BITMAP_DIMENSION", "", "POINTS", "", "getPOINTS", "()[F", "POINTS2", "getPOINTS2", "RECT", "getRECT", "WRITE_AND_TRUNCATE", "", "mMaxTextureSize", "mStateBitmap", "Landroid/util/Pair;", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/Bitmap;", "getMStateBitmap", "()Landroid/util/Pair;", "setMStateBitmap", "(Landroid/util/Pair;)V", "maxTextureSize", "getMaxTextureSize", "()I", "buildUri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "compressFormat", "Landroid/graphics/Bitmap$CompressFormat;", "calculateInSampleSizeByMaxTextureSize", "width", "height", "calculateInSampleSizeByReqestedSize", "reqWidth", "reqHeight", "closeSafe", "", "closeable", "Ljava/io/Closeable;", "cropBitmap", "Lcom/canhub/cropper/BitmapUtils$BitmapSampled;", "loadedImageUri", "points", "degreesRotated", "fixAspectRatio", "", "aspectRatioX", "aspectRatioY", "sampleMulti", "rect", "flipHorizontally", "flipVertically", "orgWidth", "orgHeight", "cropBitmapObjectHandleOOM", "bitmap", "cropBitmapObjectWithScale", "scale", "", "cropForRotatedImage", "decodeImage", "resolver", "Landroid/content/ContentResolver;", "uri", "options", "Landroid/graphics/BitmapFactory$Options;", "decodeImageForOption", "decodeSampledBitmap", "decodeSampledBitmapRegion", "fixRectForAspectRatio", "getRectBottom", "getRectCenterX", "getRectCenterY", "getRectFromPoints", "imageWidth", "imageHeight", "getRectHeight", "getRectLeft", "getRectRight", "getRectTop", "getRectWidth", "orientateBitmapByExif", "Lcom/canhub/cropper/BitmapUtils$RotateBitmapResult;", "exif", "Landroidx/exifinterface/media/ExifInterface;", "resizeBitmap", "Lcom/canhub/cropper/CropImageView$RequestSizeOptions;", "rotateAndFlipBitmapInt", "degrees", "writeBitmapToUri", "compressQuality", "customOutputUri", "writeTempStateStoreBitmap", "BitmapSampled", "RotateBitmapResult", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class BitmapUtils {
    private static final int IMAGE_MAX_BITMAP_DIMENSION = 2048;
    private static final String WRITE_AND_TRUNCATE = "wt";
    private static int mMaxTextureSize;
    private static Pair<String, WeakReference<Bitmap>> mStateBitmap;
    public static final BitmapUtils INSTANCE = new BitmapUtils();
    private static final Rect EMPTY_RECT = new Rect();
    private static final RectF EMPTY_RECT_F = new RectF();
    private static final RectF RECT = new RectF();
    private static final float[] POINTS = new float[6];
    private static final float[] POINTS2 = new float[6];

    /* compiled from: BitmapUtils.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            iArr[Bitmap.CompressFormat.JPEG.ordinal()] = 1;
            iArr[Bitmap.CompressFormat.PNG.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private BitmapUtils() {
    }

    public final Rect getEMPTY_RECT() {
        return EMPTY_RECT;
    }

    public final RectF getEMPTY_RECT_F() {
        return EMPTY_RECT_F;
    }

    public final RectF getRECT() {
        return RECT;
    }

    public final float[] getPOINTS() {
        return POINTS;
    }

    public final float[] getPOINTS2() {
        return POINTS2;
    }

    public final Pair<String, WeakReference<Bitmap>> getMStateBitmap() {
        return mStateBitmap;
    }

    public final void setMStateBitmap(Pair<String, WeakReference<Bitmap>> pair) {
        mStateBitmap = pair;
    }

    public final RotateBitmapResult orientateBitmapByExif(Bitmap bitmap, Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        ExifInterface exifInterface = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics.checkNotNull(uri);
            InputStream openInputStream = contentResolver.openInputStream(uri);
            if (openInputStream != null) {
                ExifInterface exifInterface2 = new ExifInterface(openInputStream);
                try {
                    openInputStream.close();
                } catch (Exception unused) {
                }
                exifInterface = exifInterface2;
            }
        } catch (Exception unused2) {
        }
        return exifInterface != null ? orientateBitmapByExif(bitmap, exifInterface) : new RotateBitmapResult(bitmap, 0, false, false, 12, null);
    }

    public final RotateBitmapResult orientateBitmapByExif(Bitmap bitmap, ExifInterface exif) {
        Intrinsics.checkNotNullParameter(exif, "exif");
        boolean z = true;
        int attributeInt = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        int i = attributeInt != 3 ? (attributeInt == 5 || attributeInt == 6 || attributeInt == 7) ? 90 : attributeInt != 8 ? 0 : RotationOptions.ROTATE_270 : RotationOptions.ROTATE_180;
        boolean z2 = attributeInt == 2 || attributeInt == 5;
        if (attributeInt != 4 && attributeInt != 7) {
            z = false;
        }
        return new RotateBitmapResult(bitmap, i, z2, z);
    }

    public final BitmapSampled decodeSampledBitmap(Context context, Uri uri, int reqWidth, int reqHeight) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            ContentResolver resolver = context.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(resolver, "resolver");
            BitmapFactory.Options decodeImageForOption = decodeImageForOption(resolver, uri);
            if (decodeImageForOption.outWidth == -1 && decodeImageForOption.outHeight == -1) {
                throw new RuntimeException("File is not a picture");
            }
            decodeImageForOption.inSampleSize = Math.max(calculateInSampleSizeByReqestedSize(decodeImageForOption.outWidth, decodeImageForOption.outHeight, reqWidth, reqHeight), calculateInSampleSizeByMaxTextureSize(decodeImageForOption.outWidth, decodeImageForOption.outHeight));
            return new BitmapSampled(decodeImage(resolver, uri, decodeImageForOption), decodeImageForOption.inSampleSize);
        } catch (Exception e) {
            throw new CropException.FailedToLoadBitmap(uri, e.getMessage());
        }
    }

    public final BitmapSampled cropBitmapObjectHandleOOM(Bitmap bitmap, float[] points, int degreesRotated, boolean fixAspectRatio, int aspectRatioX, int aspectRatioY, boolean flipHorizontally, boolean flipVertically) {
        Intrinsics.checkNotNullParameter(points, "points");
        int i = 1;
        do {
            try {
                Intrinsics.checkNotNull(bitmap);
                return new BitmapSampled(cropBitmapObjectWithScale(bitmap, points, degreesRotated, fixAspectRatio, aspectRatioX, aspectRatioY, 1 / i, flipHorizontally, flipVertically), i);
            } catch (OutOfMemoryError e) {
                i *= 2;
            }
        } while (i <= 8);
        throw e;
    }

    private final Bitmap cropBitmapObjectWithScale(Bitmap bitmap, float[] points, int degreesRotated, boolean fixAspectRatio, int aspectRatioX, int aspectRatioY, float scale, boolean flipHorizontally, boolean flipVertically) {
        float f = scale;
        Rect rectFromPoints = getRectFromPoints(points, bitmap.getWidth(), bitmap.getHeight(), fixAspectRatio, aspectRatioX, aspectRatioY);
        Matrix matrix = new Matrix();
        matrix.setRotate(degreesRotated, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        float f2 = flipHorizontally ? -f : f;
        if (flipVertically) {
            f = -f;
        }
        matrix.postScale(f2, f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, rectFromPoints.left, rectFromPoints.top, rectFromPoints.width(), rectFromPoints.height(), matrix, true);
        if (Intrinsics.areEqual(createBitmap, bitmap)) {
            createBitmap = bitmap.copy(bitmap.getConfig(), false);
        }
        Bitmap bitmap2 = createBitmap;
        return degreesRotated % 90 != 0 ? cropForRotatedImage(bitmap2, points, rectFromPoints, degreesRotated, fixAspectRatio, aspectRatioX, aspectRatioY) : bitmap2;
    }

    public final BitmapSampled cropBitmap(Context context, Uri loadedImageUri, float[] points, int degreesRotated, int orgWidth, int orgHeight, boolean fixAspectRatio, int aspectRatioX, int aspectRatioY, int reqWidth, int reqHeight, boolean flipHorizontally, boolean flipVertically) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(points, "points");
        int i = 1;
        while (true) {
            try {
                Intrinsics.checkNotNull(loadedImageUri);
                return cropBitmap(context, loadedImageUri, points, degreesRotated, orgWidth, orgHeight, fixAspectRatio, aspectRatioX, aspectRatioY, reqWidth, reqHeight, flipHorizontally, flipVertically, i);
            } catch (OutOfMemoryError e) {
                int i2 = i * 2;
                if (i2 > 16) {
                    throw new RuntimeException("Failed to handle OOM by sampling (" + i2 + "): " + loadedImageUri + IOUtils.LINE_SEPARATOR_WINDOWS + e.getMessage(), e);
                }
                i = i2;
            }
        }
    }

    public final float getRectLeft(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        return Math.min(Math.min(Math.min(points[0], points[2]), points[4]), points[6]);
    }

    public final float getRectTop(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        return Math.min(Math.min(Math.min(points[1], points[3]), points[5]), points[7]);
    }

    public final float getRectRight(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        return Math.max(Math.max(Math.max(points[0], points[2]), points[4]), points[6]);
    }

    public final float getRectBottom(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        return Math.max(Math.max(Math.max(points[1], points[3]), points[5]), points[7]);
    }

    public final float getRectWidth(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        return getRectRight(points) - getRectLeft(points);
    }

    public final float getRectHeight(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        return getRectBottom(points) - getRectTop(points);
    }

    public final float getRectCenterX(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        return (getRectRight(points) + getRectLeft(points)) / 2.0f;
    }

    public final float getRectCenterY(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        return (getRectBottom(points) + getRectTop(points)) / 2.0f;
    }

    public final Rect getRectFromPoints(float[] points, int imageWidth, int imageHeight, boolean fixAspectRatio, int aspectRatioX, int aspectRatioY) {
        Intrinsics.checkNotNullParameter(points, "points");
        Rect rect = new Rect(MathKt.roundToInt(Math.max(0.0f, getRectLeft(points))), MathKt.roundToInt(Math.max(0.0f, getRectTop(points))), MathKt.roundToInt(Math.min(imageWidth, getRectRight(points))), MathKt.roundToInt(Math.min(imageHeight, getRectBottom(points))));
        if (fixAspectRatio) {
            fixRectForAspectRatio(rect, aspectRatioX, aspectRatioY);
        }
        return rect;
    }

    private final void fixRectForAspectRatio(Rect rect, int aspectRatioX, int aspectRatioY) {
        if (aspectRatioX != aspectRatioY || rect.width() == rect.height()) {
            return;
        }
        if (rect.height() > rect.width()) {
            rect.bottom -= rect.height() - rect.width();
        } else {
            rect.right -= rect.width() - rect.height();
        }
    }

    public final Uri writeTempStateStoreBitmap(Context context, Bitmap bitmap, Uri customOutputUri) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intrinsics.checkNotNull(bitmap);
            return writeBitmapToUri(context, bitmap, Bitmap.CompressFormat.JPEG, 95, customOutputUri);
        } catch (Exception e) {
            Log.w("AIC", "Failed to write bitmap to temp file for image-cropper save instance state", e);
            return null;
        }
    }

    public final Uri writeBitmapToUri(Context context, Bitmap bitmap, Bitmap.CompressFormat compressFormat, int compressQuality, Uri customOutputUri) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(compressFormat, "compressFormat");
        if (customOutputUri == null) {
            customOutputUri = buildUri(context, compressFormat);
        }
        OutputStream outputStream = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics.checkNotNull(customOutputUri);
            outputStream = contentResolver.openOutputStream(customOutputUri, WRITE_AND_TRUNCATE);
            bitmap.compress(compressFormat, compressQuality, outputStream);
            return customOutputUri;
        } finally {
            closeSafe(outputStream);
        }
    }

    private final Uri buildUri(Context context, Bitmap.CompressFormat compressFormat) {
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[compressFormat.ordinal()];
            String str = i != 1 ? i != 2 ? ".webp" : ".png" : ".jpg";
            if (CommonVersionCheck.INSTANCE.isAtLeastQ29()) {
                try {
                    File file = File.createTempFile("cropped", str, context.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
                    Intrinsics.checkNotNullExpressionValue(file, "file");
                    return GetUriForFileKt.getUriForFile(context, file);
                } catch (Exception e) {
                    Log.e("AIC", String.valueOf(e.getMessage()));
                    File file2 = File.createTempFile("cropped", str, context.getCacheDir());
                    Intrinsics.checkNotNullExpressionValue(file2, "file");
                    return GetUriForFileKt.getUriForFile(context, file2);
                }
            }
            return Uri.fromFile(File.createTempFile("cropped", str, context.getCacheDir()));
        } catch (IOException e2) {
            throw new RuntimeException("Failed to create temp file for output image", e2);
        }
    }

    public final Bitmap resizeBitmap(Bitmap bitmap, int reqWidth, int reqHeight, CropImageView.RequestSizeOptions options) {
        Bitmap createScaledBitmap;
        Intrinsics.checkNotNullParameter(options, "options");
        if (reqWidth > 0 && reqHeight > 0) {
            try {
                if (options == CropImageView.RequestSizeOptions.RESIZE_FIT || options == CropImageView.RequestSizeOptions.RESIZE_INSIDE || options == CropImageView.RequestSizeOptions.RESIZE_EXACT) {
                    if (options == CropImageView.RequestSizeOptions.RESIZE_EXACT) {
                        Intrinsics.checkNotNull(bitmap);
                        createScaledBitmap = Bitmap.createScaledBitmap(bitmap, reqWidth, reqHeight, false);
                    } else {
                        Intrinsics.checkNotNull(bitmap);
                        float width = bitmap.getWidth();
                        float height = bitmap.getHeight();
                        float max = Math.max(width / reqWidth, height / reqHeight);
                        if (max <= 1.0f && options != CropImageView.RequestSizeOptions.RESIZE_FIT) {
                            createScaledBitmap = null;
                        }
                        createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (width / max), (int) (height / max), false);
                    }
                    if (createScaledBitmap != null) {
                        if (!Intrinsics.areEqual(createScaledBitmap, bitmap)) {
                            bitmap.recycle();
                        }
                        return createScaledBitmap;
                    }
                }
            } catch (Exception e) {
                Log.w("AIC", "Failed to resize cropped image, return bitmap before resize", e);
            }
        }
        Intrinsics.checkNotNull(bitmap);
        return bitmap;
    }

    private final BitmapSampled cropBitmap(Context context, Uri loadedImageUri, float[] points, int degreesRotated, int orgWidth, int orgHeight, boolean fixAspectRatio, int aspectRatioX, int aspectRatioY, int reqWidth, int reqHeight, boolean flipHorizontally, boolean flipVertically, int sampleMulti) {
        int i;
        Bitmap rotateAndFlipBitmapInt;
        Rect rectFromPoints = getRectFromPoints(points, orgWidth, orgHeight, fixAspectRatio, aspectRatioX, aspectRatioY);
        int width = reqWidth > 0 ? reqWidth : rectFromPoints.width();
        int height = reqHeight > 0 ? reqHeight : rectFromPoints.height();
        Bitmap bitmap = null;
        try {
            BitmapSampled decodeSampledBitmapRegion = decodeSampledBitmapRegion(context, loadedImageUri, rectFromPoints, width, height, sampleMulti);
            bitmap = decodeSampledBitmapRegion.getBitmap();
            i = decodeSampledBitmapRegion.getSampleSize();
        } catch (Exception unused) {
            i = 1;
        }
        int i2 = i;
        if (bitmap != null) {
            try {
                rotateAndFlipBitmapInt = rotateAndFlipBitmapInt(bitmap, degreesRotated, flipHorizontally, flipVertically);
            } catch (OutOfMemoryError e) {
                e = e;
            }
            try {
                if (degreesRotated % 90 != 0) {
                    rotateAndFlipBitmapInt = cropForRotatedImage(rotateAndFlipBitmapInt, points, rectFromPoints, degreesRotated, fixAspectRatio, aspectRatioX, aspectRatioY);
                }
                return new BitmapSampled(rotateAndFlipBitmapInt, i2);
            } catch (OutOfMemoryError e2) {
                e = e2;
                bitmap = rotateAndFlipBitmapInt;
                bitmap.recycle();
                throw e;
            }
        }
        return cropBitmap(context, loadedImageUri, points, degreesRotated, fixAspectRatio, aspectRatioX, aspectRatioY, sampleMulti, rectFromPoints, width, height, flipHorizontally, flipVertically);
    }

    /* JADX WARN: Finally extract failed */
    private final BitmapSampled cropBitmap(Context context, Uri loadedImageUri, float[] points, int degreesRotated, boolean fixAspectRatio, int aspectRatioX, int aspectRatioY, int sampleMulti, Rect rect, int width, int height, boolean flipHorizontally, boolean flipVertically) {
        Bitmap bitmap = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int calculateInSampleSizeByReqestedSize = sampleMulti * calculateInSampleSizeByReqestedSize(rect.width(), rect.height(), width, height);
            options.inSampleSize = calculateInSampleSizeByReqestedSize;
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            Bitmap decodeImage = decodeImage(contentResolver, loadedImageUri, options);
            if (decodeImage != null) {
                try {
                    int length = points.length;
                    float[] fArr = new float[length];
                    System.arraycopy(points, 0, fArr, 0, points.length);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = fArr[i] / options.inSampleSize;
                    }
                    bitmap = cropBitmapObjectWithScale(decodeImage, fArr, degreesRotated, fixAspectRatio, aspectRatioX, aspectRatioY, 1.0f, flipHorizontally, flipVertically);
                    if (!Intrinsics.areEqual(bitmap, decodeImage)) {
                        decodeImage.recycle();
                    }
                } catch (Throwable th) {
                    if (!Intrinsics.areEqual((Object) null, decodeImage)) {
                        decodeImage.recycle();
                    }
                    throw th;
                }
            }
            return new BitmapSampled(bitmap, calculateInSampleSizeByReqestedSize);
        } catch (Exception e) {
            throw new CropException.FailedToLoadBitmap(loadedImageUri, e.getMessage());
        } catch (OutOfMemoryError e2) {
            if (0 != 0) {
                bitmap.recycle();
            }
            throw e2;
        }
    }

    private final BitmapFactory.Options decodeImageForOption(ContentResolver resolver, Uri uri) throws FileNotFoundException {
        InputStream inputStream;
        try {
            inputStream = resolver.openInputStream(uri);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, EMPTY_RECT, options);
            options.inJustDecodeBounds = false;
            closeSafe(inputStream);
            return options;
        } catch (Throwable th2) {
            th = th2;
            closeSafe(inputStream);
            throw th;
        }
    }

    private final Bitmap decodeImage(ContentResolver resolver, Uri uri, BitmapFactory.Options options) throws FileNotFoundException {
        do {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = resolver.openInputStream(uri);
                    return BitmapFactory.decodeStream(inputStream, EMPTY_RECT, options);
                } catch (OutOfMemoryError unused) {
                    options.inSampleSize *= 2;
                    closeSafe(inputStream);
                }
            } finally {
                closeSafe(inputStream);
            }
        } while (options.inSampleSize <= 512);
        throw new CropException.FailedToDecodeImage(uri);
    }

    private final BitmapSampled decodeSampledBitmapRegion(Context context, Uri uri, Rect rect, int reqWidth, int reqHeight, int sampleMulti) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = sampleMulti * calculateInSampleSizeByReqestedSize(rect.width(), rect.height(), reqWidth, reqHeight);
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            Intrinsics.checkNotNull(openInputStream);
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(openInputStream, false);
            do {
                try {
                    Intrinsics.checkNotNull(newInstance);
                    return new BitmapSampled(newInstance.decodeRegion(rect, options), options.inSampleSize);
                } catch (OutOfMemoryError unused) {
                    options.inSampleSize *= 2;
                }
            } while (options.inSampleSize <= 512);
            closeSafe(openInputStream);
            if (newInstance != null) {
                newInstance.recycle();
            }
            return new BitmapSampled(null, 1);
        } catch (Exception e) {
            throw new CropException.FailedToLoadBitmap(uri, e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0085 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.graphics.Bitmap cropForRotatedImage(android.graphics.Bitmap r14, float[] r15, android.graphics.Rect r16, int r17, boolean r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 185
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.canhub.cropper.BitmapUtils.cropForRotatedImage(android.graphics.Bitmap, float[], android.graphics.Rect, int, boolean, int, int):android.graphics.Bitmap");
    }

    private final int calculateInSampleSizeByReqestedSize(int width, int height, int reqWidth, int reqHeight) {
        int i = 1;
        if (height > reqHeight || width > reqWidth) {
            while ((height / 2) / i > reqHeight && (width / 2) / i > reqWidth) {
                i *= 2;
            }
        }
        return i;
    }

    private final int calculateInSampleSizeByMaxTextureSize(int width, int height) {
        if (mMaxTextureSize == 0) {
            mMaxTextureSize = getMaxTextureSize();
        }
        int i = 1;
        if (mMaxTextureSize > 0) {
            while (true) {
                int i2 = height / i;
                int i3 = mMaxTextureSize;
                if (i2 <= i3 && width / i <= i3) {
                    break;
                }
                i *= 2;
            }
        }
        return i;
    }

    private final Bitmap rotateAndFlipBitmapInt(Bitmap bitmap, int degrees, boolean flipHorizontally, boolean flipVertically) {
        if (degrees <= 0 && !flipHorizontally && !flipVertically) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(degrees);
        matrix.postScale(flipHorizontally ? -1 : 1, flipVertically ? -1 : 1);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        if (!Intrinsics.areEqual(createBitmap, bitmap)) {
            bitmap.recycle();
        }
        Intrinsics.checkNotNullExpressionValue(createBitmap, "{\n            val matrix…      newBitmap\n        }");
        return createBitmap;
    }

    private final int getMaxTextureSize() {
        try {
            EGL egl = EGLContext.getEGL();
            Intrinsics.checkNotNull(egl, "null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
            EGL10 egl10 = (EGL10) egl;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eglGetDisplay, new int[2]);
            int[] iArr = new int[1];
            egl10.eglGetConfigs(eglGetDisplay, null, 0, iArr);
            int i = iArr[0];
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            egl10.eglGetConfigs(eglGetDisplay, eGLConfigArr, i, iArr);
            int[] iArr2 = new int[1];
            int i2 = iArr[0];
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i4], 12332, iArr2);
                int i5 = iArr2[0];
                if (i3 < i5) {
                    i3 = i5;
                }
            }
            egl10.eglTerminate(eglGetDisplay);
            return Math.max(i3, 2048);
        } catch (Exception unused) {
            return 2048;
        }
    }

    private final void closeSafe(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* compiled from: BitmapUtils.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/canhub/cropper/BitmapUtils$BitmapSampled;", "", "bitmap", "Landroid/graphics/Bitmap;", "sampleSize", "", "(Landroid/graphics/Bitmap;I)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getSampleSize", "()I", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class BitmapSampled {
        private final Bitmap bitmap;
        private final int sampleSize;

        public BitmapSampled(Bitmap bitmap, int i) {
            this.bitmap = bitmap;
            this.sampleSize = i;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final int getSampleSize() {
            return this.sampleSize;
        }
    }

    /* compiled from: BitmapUtils.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/canhub/cropper/BitmapUtils$RotateBitmapResult;", "", "bitmap", "Landroid/graphics/Bitmap;", "degrees", "", "flipHorizontally", "", "flipVertically", "(Landroid/graphics/Bitmap;IZZ)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getDegrees", "()I", "getFlipHorizontally", "()Z", "getFlipVertically", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class RotateBitmapResult {
        private final Bitmap bitmap;
        private final int degrees;
        private final boolean flipHorizontally;
        private final boolean flipVertically;

        public RotateBitmapResult(Bitmap bitmap, int i, boolean z, boolean z2) {
            this.bitmap = bitmap;
            this.degrees = i;
            this.flipHorizontally = z;
            this.flipVertically = z2;
        }

        public /* synthetic */ RotateBitmapResult(Bitmap bitmap, int i, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(bitmap, i, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2);
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final int getDegrees() {
            return this.degrees;
        }

        public final boolean getFlipHorizontally() {
            return this.flipHorizontally;
        }

        public final boolean getFlipVertically() {
            return this.flipVertically;
        }
    }
}
