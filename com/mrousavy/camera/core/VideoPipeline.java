package com.mrousavy.camera.core;

import android.graphics.SurfaceTexture;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.media.ImageWriter;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import com.facebook.jni.HybridData;
import com.mrousavy.camera.core.CameraSession;
import com.mrousavy.camera.frameprocessor.Frame;
import com.mrousavy.camera.types.Orientation;
import com.mrousavy.camera.types.PixelFormat;
import com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoPipeline.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:BE\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u0004H\u0002J\t\u0010-\u001a\u00020\u0004H\u0082 J\b\u0010.\u001a\u00020/H\u0003J\u0019\u00100\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0082 J\t\u00101\u001a\u00020+H\u0082 J\u0011\u00102\u001a\u00020+2\u0006\u0010'\u001a\u00020(H\u0082 J\u0010\u00103\u001a\u00020+2\u0006\u0010%\u001a\u00020&H\u0016J\t\u00104\u001a\u00020+H\u0082 J\u0010\u00105\u001a\u00020+2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0011\u00106\u001a\u00020+2\u0006\u0010!\u001a\u000207H\u0082 J\u0010\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020/H\u0003R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001c8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0015¨\u0006;"}, d2 = {"Lcom/mrousavy/camera/core/VideoPipeline;", "Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;", "Ljava/io/Closeable;", "width", "", "height", "format", "Lcom/mrousavy/camera/types/PixelFormat;", "isMirrored", "", "enableFrameProcessor", "enableGpuBuffers", "callback", "Lcom/mrousavy/camera/core/CameraSession$Callback;", "(IILcom/mrousavy/camera/types/PixelFormat;ZZZLcom/mrousavy/camera/core/CameraSession$Callback;)V", "getFormat", "()Lcom/mrousavy/camera/types/PixelFormat;", "hasOutputs", "getHasOutputs", "()Z", "getHeight", "()I", "imageReader", "Landroid/media/ImageReader;", "imageWriter", "Landroid/media/ImageWriter;", "isActive", "mHybridData", "Lcom/facebook/jni/HybridData;", "openGLTextureId", "Ljava/lang/Integer;", "recordingSession", "Lcom/mrousavy/camera/core/RecordingSession;", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", Snapshot.TRANSFORM_MATRIX, "", "getWidth", "close", "", "getImageReaderFormat", "getInputTextureId", "getRecommendedHardwareBufferFlags", "", "initHybrid", "onBeforeFrame", "onFrame", "onFrameAvailable", "removeRecordingSessionOutputSurface", "setRecordingSessionOutput", "setRecordingSessionOutputSurface", "", "supportsHardwareBufferFlags", "flags", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoPipeline implements SurfaceTexture.OnFrameAvailableListener, Closeable {
    private static final int MAX_IMAGES = 3;
    private static final String TAG = "VideoPipeline";
    private final CameraSession.Callback callback;
    private final boolean enableFrameProcessor;
    private final PixelFormat format;
    private final int height;
    private ImageReader imageReader;
    private ImageWriter imageWriter;
    private boolean isActive;
    private final boolean isMirrored;
    private final HybridData mHybridData;
    private Integer openGLTextureId;
    private RecordingSession recordingSession;
    private final Surface surface;
    private final SurfaceTexture surfaceTexture;
    private float[] transformMatrix;
    private final int width;

    /* compiled from: VideoPipeline.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PixelFormat.values().length];
            try {
                iArr[PixelFormat.NATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PixelFormat.RGB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PixelFormat.YUV.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final native int getInputTextureId();

    private final native HybridData initHybrid(int width, int height);

    private final native void onBeforeFrame();

    private final native void onFrame(float[] transformMatrix);

    private final native void removeRecordingSessionOutputSurface();

    private final native void setRecordingSessionOutputSurface(Object surface);

    public VideoPipeline(int i, int i2, PixelFormat format, boolean z, boolean z2, boolean z3, CameraSession.Callback callback) {
        ImageWriter newInstance;
        ImageReader newInstance2;
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.width = i;
        this.height = i2;
        this.format = format;
        this.isMirrored = z;
        this.enableFrameProcessor = z2;
        this.callback = callback;
        this.transformMatrix = new float[16];
        this.isActive = true;
        Log.i(TAG, "Initializing " + i + " x " + i2 + " Video Pipeline (format: " + format + ")");
        this.mHybridData = initHybrid(i, i2);
        SurfaceTexture m = Downloader$$ExternalSyntheticApiModelOutline0.m(false);
        this.surfaceTexture = m;
        m.setDefaultBufferSize(i, i2);
        m.setOnFrameAvailableListener(this);
        Surface surface = new Surface(m);
        if (z2) {
            int imageReaderFormat = getImageReaderFormat();
            Log.i(TAG, "Using ImageReader round-trip (format: #" + imageReaderFormat + ")");
            if (z3 && Build.VERSION.SDK_INT >= 29) {
                long recommendedHardwareBufferFlags = getRecommendedHardwareBufferFlags();
                Log.i(TAG, "Creating ImageReader with GPU-optimized usage flags: " + recommendedHardwareBufferFlags);
                newInstance2 = ImageReader.newInstance(i, i2, imageReaderFormat, 3, recommendedHardwareBufferFlags);
                this.imageReader = newInstance2;
            } else {
                Log.i(TAG, "Creating ImageReader with default usage flags...");
                this.imageReader = ImageReader.newInstance(i, i2, imageReaderFormat, 3);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                Log.i(TAG, "Creating ImageWriter with format #" + imageReaderFormat + "...");
                newInstance = ImageWriter.newInstance(surface, 3, imageReaderFormat);
                this.imageWriter = newInstance;
            } else {
                Log.i(TAG, "Creating ImageWriter with default format...");
                this.imageWriter = ImageWriter.newInstance(surface, 3);
            }
            ImageReader imageReader = this.imageReader;
            Intrinsics.checkNotNull(imageReader);
            imageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: com.mrousavy.camera.core.VideoPipeline$$ExternalSyntheticLambda4
                @Override // android.media.ImageReader.OnImageAvailableListener
                public final void onImageAvailable(ImageReader imageReader2) {
                    VideoPipeline._init_$lambda$0(VideoPipeline.this, imageReader2);
                }
            }, CameraQueues.INSTANCE.getVideoQueue().getHandler());
            ImageReader imageReader2 = this.imageReader;
            Intrinsics.checkNotNull(imageReader2);
            Surface surface2 = imageReader2.getSurface();
            Intrinsics.checkNotNullExpressionValue(surface2, "imageReader!!.surface");
            this.surface = surface2;
            return;
        }
        this.surface = surface;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public /* synthetic */ VideoPipeline(int i, int i2, PixelFormat pixelFormat, boolean z, boolean z2, boolean z3, CameraSession.Callback callback, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? PixelFormat.NATIVE : pixelFormat, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? false : z2, (i3 & 32) != 0 ? false : z3, callback);
    }

    public final PixelFormat getFormat() {
        return this.format;
    }

    public final Surface getSurface() {
        return this.surface;
    }

    private final boolean getHasOutputs() {
        return this.recordingSession != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(VideoPipeline this$0, ImageReader imageReader) {
        ImageWriter imageWriter;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.i(TAG, "ImageReader::onImageAvailable!");
        Image acquireNextImage = imageReader.acquireNextImage();
        if (acquireNextImage == null) {
            return;
        }
        Frame frame = new Frame(acquireNextImage, acquireNextImage.getTimestamp(), Orientation.PORTRAIT, this$0.isMirrored);
        frame.incrementRefCount();
        try {
            this$0.callback.onFrame(frame);
            if (this$0.getHasOutputs() && (imageWriter = this$0.imageWriter) != null) {
                imageWriter.queueInputImage(acquireNextImage);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            this.isActive = false;
            ImageWriter imageWriter = this.imageWriter;
            if (imageWriter != null) {
                imageWriter.close();
            }
            ImageReader imageReader = this.imageReader;
            if (imageReader != null) {
                imageReader.close();
            }
            removeRecordingSessionOutputSurface();
            this.recordingSession = null;
            this.surfaceTexture.setOnFrameAvailableListener(null, null);
            this.surfaceTexture.release();
            this.surface.release();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        synchronized (this) {
            if (this.isActive) {
                if (this.openGLTextureId == null) {
                    Integer valueOf = Integer.valueOf(getInputTextureId());
                    this.openGLTextureId = valueOf;
                    Intrinsics.checkNotNull(valueOf);
                    surfaceTexture.attachToGLContext(valueOf.intValue());
                    Log.i(TAG, "Attached Texture to Context " + this.openGLTextureId);
                }
                onBeforeFrame();
                surfaceTexture.updateTexImage();
                surfaceTexture.getTransformMatrix(this.transformMatrix);
                onFrame(this.transformMatrix);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final int getImageReaderFormat() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.format.ordinal()];
        if (i == 1) {
            return 34;
        }
        if (i != 2) {
            return i != 3 ? 34 : 35;
        }
        return 1;
    }

    public final void setRecordingSessionOutput(RecordingSession recordingSession) {
        synchronized (this) {
            if (recordingSession != null) {
                Log.i(TAG, "Setting " + recordingSession.getSize() + " RecordingSession Output...");
                setRecordingSessionOutputSurface(recordingSession.getSurface());
                this.recordingSession = recordingSession;
            } else {
                Log.i(TAG, "Removing RecordingSession Output...");
                removeRecordingSessionOutputSurface();
                this.recordingSession = null;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final long getRecommendedHardwareBufferFlags() {
        if (this.format == PixelFormat.NATIVE) {
            if (!supportsHardwareBufferFlags(256L)) {
                return 0L;
            }
            Log.i(TAG, "GPU HardwareBuffers are supported!");
            return 256L;
        }
        if (supportsHardwareBufferFlags(259L)) {
            Log.i(TAG, "GPU + CPU HardwareBuffers are supported!");
            return 259L;
        }
        if (!supportsHardwareBufferFlags(3L)) {
            return 0L;
        }
        Log.i(TAG, "CPU HardwareBuffers are supported!");
        return 3L;
    }

    private final boolean supportsHardwareBufferFlags(long flags) {
        boolean isSupported;
        try {
            isSupported = HardwareBuffer.isSupported(this.width, this.height, this.format.toHardwareBufferFormat(), 1, flags);
            return isSupported;
        } catch (Throwable unused) {
            return false;
        }
    }
}
