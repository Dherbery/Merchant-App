package com.mrousavy.camera.core;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Size;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.ViewProps;
import com.mrousavy.camera.extensions.Point_rotatedByKt;
import com.mrousavy.camera.extensions.Size_ExtensionsKt;
import com.mrousavy.camera.types.Orientation;
import com.mrousavy.camera.types.ResizeMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: PreviewView.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eJ \u0010\u0014\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0015J\b\u0010&\u001a\u00020\"H\u0016J)\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010+J(\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020$2\u0006\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020$H\u0016J\u0010\u00100\u001a\u00020\"2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u00101\u001a\u00020\"2\u0006\u0010-\u001a\u00020.H\u0016J\b\u00102\u001a\u00020\"H\u0002R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Lcom/mrousavy/camera/core/PreviewView;", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceHolder$Callback;", "context", "Landroid/content/Context;", "callback", "(Landroid/content/Context;Landroid/view/SurfaceHolder$Callback;)V", "value", "Lcom/mrousavy/camera/types/Orientation;", "inputOrientation", "setInputOrientation", "(Lcom/mrousavy/camera/types/Orientation;)V", "Lcom/mrousavy/camera/types/ResizeMode;", ViewProps.RESIZE_MODE, "getResizeMode", "()Lcom/mrousavy/camera/types/ResizeMode;", "setResizeMode", "(Lcom/mrousavy/camera/types/ResizeMode;)V", "Landroid/util/Size;", "size", "getSize", "()Landroid/util/Size;", "setSize", "(Landroid/util/Size;)V", "viewSize", "getViewSize", "convertLayerPointToCameraCoordinates", "Landroid/graphics/Point;", "point", "cameraDeviceDetails", "Lcom/mrousavy/camera/core/CameraDeviceDetails;", "contentSize", "containerSize", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "requestLayout", "setSurfaceSize", "width", "height", "cameraSensorOrientation", "(IILcom/mrousavy/camera/types/Orientation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "surfaceChanged", "holder", "Landroid/view/SurfaceHolder;", "format", "surfaceCreated", "surfaceDestroyed", "updateLayout", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PreviewView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = "PreviewView";
    private Orientation inputOrientation;
    private ResizeMode resizeMode;
    private Size size;

    /* compiled from: PreviewView.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResizeMode.values().length];
            try {
                iArr[ResizeMode.COVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResizeMode.CONTAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewView(Context context, SurfaceHolder.Callback callback) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.size = CameraDeviceDetails.INSTANCE.getMaximumPreviewSize();
        this.resizeMode = ResizeMode.COVER;
        this.inputOrientation = Orientation.LANDSCAPE_LEFT;
        Log.i(TAG, "Creating PreviewView...");
        getHolder().setKeepScreenOn(true);
        getHolder().addCallback(this);
        getHolder().addCallback(callback);
        getHolder().setFixedSize(this.size.getWidth(), this.size.getHeight());
    }

    public final Size getSize() {
        return this.size;
    }

    public final void setSize(Size value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.size, value)) {
            return;
        }
        Log.i(TAG, "Surface Size changed: " + this.size + " -> " + value);
        this.size = value;
        updateLayout();
    }

    public final ResizeMode getResizeMode() {
        return this.resizeMode;
    }

    public final void setResizeMode(ResizeMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ResizeMode resizeMode = this.resizeMode;
        if (resizeMode != value) {
            Log.i(TAG, "Resize Mode changed: " + resizeMode + " -> " + value);
            this.resizeMode = value;
            updateLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setInputOrientation(Orientation orientation) {
        Orientation orientation2 = this.inputOrientation;
        if (orientation2 != orientation) {
            Log.i(TAG, "Input Orientation changed: " + orientation2 + " -> " + orientation);
            this.inputOrientation = orientation;
            updateLayout();
        }
    }

    private final Size getViewSize() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        return new Size((int) (getWidth() / displayMetrics.density), (int) (getHeight() / displayMetrics.density));
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        setSize(new Size(width, height));
    }

    public final Object setSurfaceSize(int i, int i2, Orientation orientation, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new PreviewView$setSurfaceSize$2(this, orientation, i, i2, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Point convertLayerPointToCameraCoordinates(Point point, CameraDeviceDetails cameraDeviceDetails) {
        Intrinsics.checkNotNullParameter(point, "point");
        Intrinsics.checkNotNullParameter(cameraDeviceDetails, "cameraDeviceDetails");
        Orientation sensorOrientation = cameraDeviceDetails.getSensorOrientation();
        Size size = new Size(cameraDeviceDetails.getActiveSize().width(), cameraDeviceDetails.getActiveSize().height());
        Point rotatedBy = Point_rotatedByKt.rotatedBy(point, getViewSize(), size, Orientation.PORTRAIT, sensorOrientation);
        Log.i(TAG, "Converted layer point " + point + " to camera point " + rotatedBy + "! (" + sensorOrientation + ", " + size + " -> " + getViewSize() + ")");
        return rotatedBy;
    }

    private final void updateLayout() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mrousavy.camera.core.PreviewView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PreviewView.updateLayout$lambda$0(PreviewView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateLayout$lambda$0(PreviewView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requestLayout();
        this$0.invalidate();
    }

    @Override // android.view.View
    public void requestLayout() {
        super.requestLayout();
        post(new Runnable() { // from class: com.mrousavy.camera.core.PreviewView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PreviewView.requestLayout$lambda$1(PreviewView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestLayout$lambda$1(PreviewView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.measure(View.MeasureSpec.makeMeasureSpec(this$0.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this$0.getHeight(), 1073741824));
        this$0.layout(this$0.getLeft(), this$0.getTop(), this$0.getRight(), this$0.getBottom());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:
    
        if (r0 < r2) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
    
        if (r0 > r2) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.util.Size getSize(android.util.Size r8, android.util.Size r9, com.mrousavy.camera.types.ResizeMode r10) {
        /*
            r7 = this;
            int r0 = r8.getWidth()
            double r0 = (double) r0
            int r2 = r8.getHeight()
            double r2 = (double) r2
            double r0 = r0 / r2
            int r2 = r9.getWidth()
            double r2 = (double) r2
            int r4 = r9.getHeight()
            double r4 = (double) r4
            double r2 = r2 / r4
            r4 = 0
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 <= 0) goto L69
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 > 0) goto L21
            goto L69
        L21:
            int[] r8 = com.mrousavy.camera.core.PreviewView.WhenMappings.$EnumSwitchMapping$0
            int r10 = r10.ordinal()
            r8 = r8[r10]
            r10 = 0
            r4 = 1
            if (r8 == r4) goto L3b
            r5 = 2
            if (r8 != r5) goto L35
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 >= 0) goto L40
            goto L3f
        L35:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L3b:
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 <= 0) goto L40
        L3f:
            r10 = r4
        L40:
            if (r10 == 0) goto L56
            int r8 = r9.getHeight()
            double r2 = (double) r8
            double r2 = r2 * r0
            android.util.Size r8 = new android.util.Size
            int r10 = kotlin.math.MathKt.roundToInt(r2)
            int r9 = r9.getHeight()
            r8.<init>(r10, r9)
            goto L69
        L56:
            int r8 = r9.getWidth()
            double r2 = (double) r8
            double r2 = r2 / r0
            android.util.Size r8 = new android.util.Size
            int r9 = r9.getWidth()
            int r10 = kotlin.math.MathKt.roundToInt(r2)
            r8.<init>(r9, r10)
        L69:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.PreviewView.getSize(android.util.Size, android.util.Size, com.mrousavy.camera.types.ResizeMode):android.util.Size");
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Size size = new Size(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
        Size rotatedBy = Size_ExtensionsKt.rotatedBy(this.size, this.inputOrientation);
        Size size2 = getSize(rotatedBy, size, this.resizeMode);
        Log.i(TAG, "PreviewView is " + size + ", rendering " + rotatedBy + " content (" + this.inputOrientation + "). Resizing to: " + size2 + " (" + this.resizeMode + ")");
        setMeasuredDimension(size2.getWidth(), size2.getHeight());
    }
}
