package com.mrousavy.camera.core;

import android.content.Context;
import android.graphics.Point;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.media.ImageReader;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.content.ContextCompat;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.mrousavy.camera.core.CameraConfiguration;
import com.mrousavy.camera.core.PersistentCameraCaptureSession;
import com.mrousavy.camera.core.capture.RepeatingCaptureRequest;
import com.mrousavy.camera.core.outputs.BarcodeScannerOutput;
import com.mrousavy.camera.core.outputs.PhotoOutput;
import com.mrousavy.camera.core.outputs.VideoPipelineOutput;
import com.mrousavy.camera.frameprocessor.Frame;
import com.mrousavy.camera.types.Orientation;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: CameraSession.kt */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 b2\u00020\u00012\u00020\u0002:\u0003`abB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010*\u001a\u00020+H\u0016J4\u0010,\u001a\u00020+2!\u0010-\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020+0.H\u0086@ø\u0001\u0000¢\u0006\u0002\u00101J\u0010\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020\u000fH\u0002J\u0010\u00104\u001a\u00020+2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0019\u00105\u001a\u00020+2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@ø\u0001\u0000¢\u0006\u0002\u00106J\u0010\u00107\u001a\u00020+2\u0006\u00108\u001a\u000209H\u0002J\u000e\u0010:\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010;\u001a\u00020+H\u0002J\b\u0010<\u001a\u00020+H\u0002J!\u0010=\u001a\u00020+2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u00020+2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020+2\u0006\u0010F\u001a\u00020GH\u0002J\u0011\u0010H\u001a\u00020+H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010IJ\u0011\u0010J\u001a\u00020+H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010IJg\u0010K\u001a\u00020+2\u0006\u0010L\u001a\u00020\u00132\u0006\u0010M\u001a\u00020N2!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110O¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020+0.2!\u0010B\u001a\u001d\u0012\u0013\u0012\u00110Q¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020+0.H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010RJ\u0011\u0010S\u001a\u00020+H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010IJA\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u00132\u0006\u0010[\u001a\u00020\u00132\u0006\u0010\\\u001a\u00020\u00132\u0006\u0010]\u001a\u00020\u001bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010^J\b\u0010_\u001a\u00020+H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\u0014\u001a\u0004\u0018\u00010$@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006c"}, d2 = {"Lcom/mrousavy/camera/core/CameraSession;", "Ljava/io/Closeable;", "Lcom/mrousavy/camera/core/PersistentCameraCaptureSession$Callback;", "context", "Landroid/content/Context;", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "callback", "Lcom/mrousavy/camera/core/CameraSession$Callback;", "(Landroid/content/Context;Landroid/hardware/camera2/CameraManager;Lcom/mrousavy/camera/core/CameraSession$Callback;)V", "captureSession", "Lcom/mrousavy/camera/core/PersistentCameraCaptureSession;", "codeScannerOutput", "Lcom/mrousavy/camera/core/outputs/BarcodeScannerOutput;", "configuration", "Lcom/mrousavy/camera/core/CameraConfiguration;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isDestroyed", "", "value", "isRunning", "setRunning", "(Z)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "orientation", "Lcom/mrousavy/camera/types/Orientation;", "getOrientation", "()Lcom/mrousavy/camera/types/Orientation;", "photoOutput", "Lcom/mrousavy/camera/core/outputs/PhotoOutput;", "photoOutputSynchronizer", "Lcom/mrousavy/camera/core/PhotoOutputSynchronizer;", "previewView", "Lcom/mrousavy/camera/core/PreviewView;", "Lcom/mrousavy/camera/core/RecordingSession;", "recording", "setRecording", "(Lcom/mrousavy/camera/core/RecordingSession;)V", "videoOutput", "Lcom/mrousavy/camera/core/outputs/VideoPipelineOutput;", "close", "", "configure", "lambda", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureCaptureRequest", "config", "configureInput", "configureOutputs", "(Lcom/mrousavy/camera/core/CameraConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPreviewOutput", "surface", "Landroid/view/Surface;", "createPreviewView", "destroy", "destroyPreviewOutputSync", "focus", "x", "", "y", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onError", "error", "", "onPhotoCaptured", "image", "Landroid/media/Image;", "pauseRecording", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resumeRecording", "startRecording", "enableAudio", "options", "Lcom/mrousavy/camera/types/RecordVideoOptions;", "Lcom/mrousavy/camera/core/RecordingSession$Video;", "video", "Lcom/mrousavy/camera/core/CameraError;", "(ZLcom/mrousavy/camera/types/RecordVideoOptions;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopRecording", "takePhoto", "Lcom/mrousavy/camera/core/CameraSession$CapturedPhoto;", "qualityPrioritization", "Lcom/mrousavy/camera/types/QualityPrioritization;", "flash", "Lcom/mrousavy/camera/types/Flash;", "enableShutterSound", "enableAutoStabilization", "enablePrecapture", "outputOrientation", "(Lcom/mrousavy/camera/types/QualityPrioritization;Lcom/mrousavy/camera/types/Flash;ZZZLcom/mrousavy/camera/types/Orientation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateVideoOutputs", "Callback", "CapturedPhoto", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraSession implements Closeable, PersistentCameraCaptureSession.Callback {
    private static final String TAG = "CameraSession";
    private final Callback callback;
    private final CameraManager cameraManager;
    private final PersistentCameraCaptureSession captureSession;
    private BarcodeScannerOutput codeScannerOutput;
    private CameraConfiguration configuration;
    private final Context context;
    private final CoroutineScope coroutineScope;
    private boolean isDestroyed;
    private boolean isRunning;
    private final Mutex mutex;
    private PhotoOutput photoOutput;
    private final PhotoOutputSynchronizer photoOutputSynchronizer;
    private PreviewView previewView;
    private RecordingSession recording;
    private VideoPipelineOutput videoOutput;

    /* compiled from: CameraSession.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&¨\u0006\u0012"}, d2 = {"Lcom/mrousavy/camera/core/CameraSession$Callback;", "", "onCodeScanned", "", "codes", "", "Lcom/google/mlkit/vision/barcode/common/Barcode;", "scannerFrame", "Lcom/mrousavy/camera/core/CodeScannerFrame;", "onError", "error", "", "onFrame", "frame", "Lcom/mrousavy/camera/frameprocessor/Frame;", "onInitialized", "onStarted", "onStopped", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Callback {
        void onCodeScanned(List<? extends Barcode> codes, CodeScannerFrame scannerFrame);

        void onError(Throwable error);

        void onFrame(Frame frame);

        void onInitialized();

        void onStarted();

        void onStopped();
    }

    public CameraSession(Context context, CameraManager cameraManager, Callback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cameraManager, "cameraManager");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.context = context;
        this.cameraManager = cameraManager;
        this.callback = callback;
        this.captureSession = new PersistentCameraCaptureSession(cameraManager, this);
        this.photoOutputSynchronizer = new PhotoOutputSynchronizer();
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(CameraQueues.INSTANCE.getCameraQueue().getCoroutineDispatcher());
    }

    private final void setRunning(boolean z) {
        if (this.isRunning != z) {
            if (z) {
                this.callback.onStarted();
            } else {
                this.callback.onStopped();
            }
        }
        this.isRunning = z;
    }

    private final void setRecording(RecordingSession recordingSession) {
        this.recording = recordingSession;
        updateVideoOutputs();
    }

    public final Orientation getOrientation() {
        String cameraId;
        CameraConfiguration cameraConfiguration = this.configuration;
        if (cameraConfiguration == null || (cameraId = cameraConfiguration.getCameraId()) == null) {
            return Orientation.PORTRAIT;
        }
        CameraCharacteristics cameraCharacteristics = this.cameraManager.getCameraCharacteristics(cameraId);
        Intrinsics.checkNotNullExpressionValue(cameraCharacteristics, "cameraManager.getCameraCharacteristics(cameraId)");
        int i = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
        if (i == null) {
            i = 0;
        }
        return Orientation.INSTANCE.fromRotationDegrees(i.intValue());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Log.i(TAG, "Closing CameraSession...");
        this.isDestroyed = true;
        BuildersKt__BuildersKt.runBlocking$default(null, new CameraSession$close$1(this, null), 1, null);
        Log.i(TAG, "CameraSession closed!");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x010c A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #2 {all -> 0x0049, blocks: (B:12:0x0044, B:13:0x00d9, B:15:0x010c), top: B:11:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009b A[Catch: all -> 0x014a, TryCatch #3 {all -> 0x014a, blocks: (B:18:0x013f, B:36:0x0080, B:38:0x009b, B:39:0x00a2, B:41:0x00a6, B:42:0x00ad), top: B:35:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a2 A[Catch: all -> 0x014a, TryCatch #3 {all -> 0x014a, blocks: (B:18:0x013f, B:36:0x0080, B:38:0x009b, B:39:0x00a2, B:41:0x00a6, B:42:0x00ad), top: B:35:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object configure(kotlin.jvm.functions.Function1<? super com.mrousavy.camera.core.CameraConfiguration, kotlin.Unit> r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession.configure(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void destroy() {
        Log.i(TAG, "Destroying session..");
        this.captureSession.close();
        PhotoOutput photoOutput = this.photoOutput;
        if (photoOutput != null) {
            photoOutput.close();
        }
        this.photoOutput = null;
        VideoPipelineOutput videoPipelineOutput = this.videoOutput;
        if (videoPipelineOutput != null) {
            videoPipelineOutput.close();
        }
        this.videoOutput = null;
        BarcodeScannerOutput barcodeScannerOutput = this.codeScannerOutput;
        if (barcodeScannerOutput != null) {
            barcodeScannerOutput.close();
        }
        this.codeScannerOutput = null;
        setRunning(false);
    }

    public final PreviewView createPreviewView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PreviewView previewView = new PreviewView(context, new SurfaceHolder.Callback() { // from class: com.mrousavy.camera.core.CameraSession$createPreviewView$previewView$1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Log.i("CameraSession", "PreviewView Surface created! " + holder.getSurface());
                CameraSession cameraSession = CameraSession.this;
                Surface surface = holder.getSurface();
                Intrinsics.checkNotNullExpressionValue(surface, "holder.surface");
                cameraSession.createPreviewOutput(surface);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Log.i("CameraSession", "PreviewView Surface updated! " + holder.getSurface() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + width + " x " + height);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Log.i("CameraSession", "PreviewView Surface destroyed! " + holder.getSurface());
                CameraSession.this.destroyPreviewOutputSync();
            }
        });
        this.previewView = previewView;
        return previewView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createPreviewOutput(Surface surface) {
        Log.i(TAG, "Setting Preview Output...");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new CameraSession$createPreviewOutput$1(this, surface, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void destroyPreviewOutputSync() {
        Log.i(TAG, "Destroying Preview Output...");
        BuildersKt__BuildersKt.runBlocking$default(null, new CameraSession$destroyPreviewOutputSync$1(this, null), 1, null);
        Log.i(TAG, "Preview Output destroyed!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configureInput(CameraConfiguration configuration) {
        Log.i(TAG, "Configuring inputs for CameraSession...");
        String cameraId = configuration.getCameraId();
        if (cameraId == null) {
            throw new NoCameraDeviceError();
        }
        if (ContextCompat.checkSelfPermission(this.context, "android.permission.CAMERA") != 0) {
            throw new CameraPermissionError();
        }
        setRunning(false);
        this.captureSession.setInput(cameraId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object configureOutputs(com.mrousavy.camera.core.CameraConfiguration r26, kotlin.coroutines.Continuation<? super kotlin.Unit> r27) {
        /*
            Method dump skipped, instructions count: 819
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession.configureOutputs(com.mrousavy.camera.core.CameraConfiguration, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void configureOutputs$lambda$1(CameraSession this$0, ImageReader imageReader) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.i(TAG, "Photo Captured!");
        Image image = imageReader.acquireLatestImage();
        Intrinsics.checkNotNullExpressionValue(image, "image");
        this$0.onPhotoCaptured(image);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configureCaptureRequest(CameraConfiguration config) {
        CameraConfiguration.Video video;
        CameraConfiguration.Output<CameraConfiguration.Video> video2 = config.getVideo();
        CameraConfiguration.Output.Enabled enabled = video2 instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) video2 : null;
        this.captureSession.setRepeatingRequest(new RepeatingCaptureRequest(enabled != null, config.getTorch(), config.getFps(), config.getVideoStabilizationMode(), (enabled == null || (video = (CameraConfiguration.Video) enabled.getConfig()) == null || !video.getEnableHdr()) ? false : true, config.getEnableLowLightBoost(), config.getExposure(), config.getZoom(), config.getFormat()));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0110 A[Catch: CancellationException -> 0x013c, TryCatch #0 {CancellationException -> 0x013c, blocks: (B:12:0x003c, B:14:0x00e2, B:16:0x0110, B:17:0x0116, B:20:0x011d, B:23:0x0128, B:34:0x00af), top: B:7:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object takePhoto(com.mrousavy.camera.types.QualityPrioritization r17, com.mrousavy.camera.types.Flash r18, boolean r19, boolean r20, boolean r21, com.mrousavy.camera.types.Orientation r22, kotlin.coroutines.Continuation<? super com.mrousavy.camera.core.CameraSession.CapturedPhoto> r23) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession.takePhoto(com.mrousavy.camera.types.QualityPrioritization, com.mrousavy.camera.types.Flash, boolean, boolean, boolean, com.mrousavy.camera.types.Orientation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void onPhotoCaptured(Image image) {
        Log.i(TAG, "Photo captured! " + image.getWidth() + " x " + image.getHeight());
        this.photoOutputSynchronizer.set(image.getTimestamp(), image);
    }

    private final void updateVideoOutputs() {
        VideoPipelineOutput videoPipelineOutput = this.videoOutput;
        if (videoPipelineOutput == null) {
            return;
        }
        Log.i(TAG, "Updating Video Outputs...");
        videoPipelineOutput.getVideoPipeline().setRecordingSessionOutput(this.recording);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x007f A[Catch: all -> 0x00dd, TryCatch #0 {all -> 0x00dd, blocks: (B:11:0x007b, B:13:0x007f, B:15:0x0083, B:17:0x0087, B:19:0x008d, B:21:0x0091, B:23:0x0097, B:24:0x009e, B:27:0x00aa, B:33:0x00cb, B:34:0x00d0, B:35:0x00d1, B:36:0x00d6, B:37:0x00d7, B:38:0x00dc), top: B:10:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d7 A[Catch: all -> 0x00dd, TryCatch #0 {all -> 0x00dd, blocks: (B:11:0x007b, B:13:0x007f, B:15:0x0083, B:17:0x0087, B:19:0x008d, B:21:0x0091, B:23:0x0097, B:24:0x009e, B:27:0x00aa, B:33:0x00cb, B:34:0x00d0, B:35:0x00d1, B:36:0x00d6, B:37:0x00d7, B:38:0x00dc), top: B:10:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object startRecording(boolean r19, com.mrousavy.camera.types.RecordVideoOptions r20, kotlin.jvm.functions.Function1<? super com.mrousavy.camera.core.RecordingSession.Video, kotlin.Unit> r21, kotlin.jvm.functions.Function1<? super com.mrousavy.camera.core.CameraError, kotlin.Unit> r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession.startRecording(boolean, com.mrousavy.camera.types.RecordVideoOptions, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0053 A[Catch: all -> 0x0067, TRY_LEAVE, TryCatch #0 {all -> 0x0067, blocks: (B:11:0x004f, B:13:0x0053, B:17:0x0061, B:18:0x0066), top: B:10:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0061 A[Catch: all -> 0x0067, TRY_ENTER, TryCatch #0 {all -> 0x0067, blocks: (B:11:0x004f, B:13:0x0053, B:17:0x0061, B:18:0x0066), top: B:10:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object stopRecording(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.mrousavy.camera.core.CameraSession$stopRecording$1
            if (r0 == 0) goto L14
            r0 = r6
            com.mrousavy.camera.core.CameraSession$stopRecording$1 r0 = (com.mrousavy.camera.core.CameraSession$stopRecording$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.mrousavy.camera.core.CameraSession$stopRecording$1 r0 = new com.mrousavy.camera.core.CameraSession$stopRecording$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r0 = r0.L$0
            com.mrousavy.camera.core.CameraSession r0 = (com.mrousavy.camera.core.CameraSession) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4f
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3b:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.sync.Mutex r6 = r5.mutex
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r0 = r6.lock(r4, r0)
            if (r0 != r1) goto L4d
            return r1
        L4d:
            r0 = r5
            r1 = r6
        L4f:
            com.mrousavy.camera.core.RecordingSession r6 = r0.recording     // Catch: java.lang.Throwable -> L67
            if (r6 == 0) goto L61
            r6.stop()     // Catch: java.lang.Throwable -> L67
            r0.setRecording(r4)     // Catch: java.lang.Throwable -> L67
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L67
            r1.unlock(r4)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L61:
            com.mrousavy.camera.core.NoRecordingInProgressError r6 = new com.mrousavy.camera.core.NoRecordingInProgressError     // Catch: java.lang.Throwable -> L67
            r6.<init>()     // Catch: java.lang.Throwable -> L67
            throw r6     // Catch: java.lang.Throwable -> L67
        L67:
            r6 = move-exception
            r1.unlock(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession.stopRecording(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0053 A[Catch: all -> 0x0064, TRY_LEAVE, TryCatch #0 {all -> 0x0064, blocks: (B:11:0x004f, B:13:0x0053, B:17:0x005e, B:18:0x0063), top: B:10:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005e A[Catch: all -> 0x0064, TRY_ENTER, TryCatch #0 {all -> 0x0064, blocks: (B:11:0x004f, B:13:0x0053, B:17:0x005e, B:18:0x0063), top: B:10:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object pauseRecording(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.mrousavy.camera.core.CameraSession$pauseRecording$1
            if (r0 == 0) goto L14
            r0 = r6
            com.mrousavy.camera.core.CameraSession$pauseRecording$1 r0 = (com.mrousavy.camera.core.CameraSession$pauseRecording$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.mrousavy.camera.core.CameraSession$pauseRecording$1 r0 = new com.mrousavy.camera.core.CameraSession$pauseRecording$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3b
            if (r2 != r4) goto L33
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r0 = r0.L$0
            com.mrousavy.camera.core.CameraSession r0 = (com.mrousavy.camera.core.CameraSession) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4f
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3b:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.sync.Mutex r6 = r5.mutex
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r0 = r6.lock(r3, r0)
            if (r0 != r1) goto L4d
            return r1
        L4d:
            r0 = r5
            r1 = r6
        L4f:
            com.mrousavy.camera.core.RecordingSession r6 = r0.recording     // Catch: java.lang.Throwable -> L64
            if (r6 == 0) goto L5e
            r6.pause()     // Catch: java.lang.Throwable -> L64
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L64
            r1.unlock(r3)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L5e:
            com.mrousavy.camera.core.NoRecordingInProgressError r6 = new com.mrousavy.camera.core.NoRecordingInProgressError     // Catch: java.lang.Throwable -> L64
            r6.<init>()     // Catch: java.lang.Throwable -> L64
            throw r6     // Catch: java.lang.Throwable -> L64
        L64:
            r6 = move-exception
            r1.unlock(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession.pauseRecording(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0053 A[Catch: all -> 0x0064, TRY_LEAVE, TryCatch #0 {all -> 0x0064, blocks: (B:11:0x004f, B:13:0x0053, B:17:0x005e, B:18:0x0063), top: B:10:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005e A[Catch: all -> 0x0064, TRY_ENTER, TryCatch #0 {all -> 0x0064, blocks: (B:11:0x004f, B:13:0x0053, B:17:0x005e, B:18:0x0063), top: B:10:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object resumeRecording(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.mrousavy.camera.core.CameraSession$resumeRecording$1
            if (r0 == 0) goto L14
            r0 = r6
            com.mrousavy.camera.core.CameraSession$resumeRecording$1 r0 = (com.mrousavy.camera.core.CameraSession$resumeRecording$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.mrousavy.camera.core.CameraSession$resumeRecording$1 r0 = new com.mrousavy.camera.core.CameraSession$resumeRecording$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3b
            if (r2 != r4) goto L33
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r0 = r0.L$0
            com.mrousavy.camera.core.CameraSession r0 = (com.mrousavy.camera.core.CameraSession) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4f
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3b:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.sync.Mutex r6 = r5.mutex
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r0 = r6.lock(r3, r0)
            if (r0 != r1) goto L4d
            return r1
        L4d:
            r0 = r5
            r1 = r6
        L4f:
            com.mrousavy.camera.core.RecordingSession r6 = r0.recording     // Catch: java.lang.Throwable -> L64
            if (r6 == 0) goto L5e
            r6.resume()     // Catch: java.lang.Throwable -> L64
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L64
            r1.unlock(r3)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L5e:
            com.mrousavy.camera.core.NoRecordingInProgressError r6 = new com.mrousavy.camera.core.NoRecordingInProgressError     // Catch: java.lang.Throwable -> L64
            r6.<init>()     // Catch: java.lang.Throwable -> L64
            throw r6     // Catch: java.lang.Throwable -> L64
        L64:
            r6 = move-exception
            r1.unlock(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession.resumeRecording(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.mrousavy.camera.core.PersistentCameraCaptureSession.Callback
    public void onError(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.callback.onError(error);
    }

    public final Object focus(int i, int i2, Continuation<? super Unit> continuation) {
        PreviewView previewView = this.previewView;
        if (previewView == null) {
            throw new CameraNotReadyError();
        }
        CameraDeviceDetails activeDeviceDetails = this.captureSession.getActiveDeviceDetails();
        if (activeDeviceDetails == null) {
            throw new CameraNotReadyError();
        }
        Object focus = this.captureSession.focus(previewView.convertLayerPointToCameraCoordinates(new Point(i, i2), activeDeviceDetails), continuation);
        return focus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? focus : Unit.INSTANCE;
    }

    /* compiled from: CameraSession.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u000bHÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/mrousavy/camera/core/CameraSession$CapturedPhoto;", "Ljava/io/Closeable;", "image", "Landroid/media/Image;", TtmlNode.TAG_METADATA, "Landroid/hardware/camera2/TotalCaptureResult;", "orientation", "Lcom/mrousavy/camera/types/Orientation;", "isMirrored", "", "format", "", "(Landroid/media/Image;Landroid/hardware/camera2/TotalCaptureResult;Lcom/mrousavy/camera/types/Orientation;ZI)V", "getFormat", "()I", "getImage", "()Landroid/media/Image;", "()Z", "getMetadata", "()Landroid/hardware/camera2/TotalCaptureResult;", "getOrientation", "()Lcom/mrousavy/camera/types/Orientation;", "close", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class CapturedPhoto implements Closeable {
        private final int format;
        private final Image image;
        private final boolean isMirrored;
        private final TotalCaptureResult metadata;
        private final Orientation orientation;

        public static /* synthetic */ CapturedPhoto copy$default(CapturedPhoto capturedPhoto, Image image, TotalCaptureResult totalCaptureResult, Orientation orientation, boolean z, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                image = capturedPhoto.image;
            }
            if ((i2 & 2) != 0) {
                totalCaptureResult = capturedPhoto.metadata;
            }
            TotalCaptureResult totalCaptureResult2 = totalCaptureResult;
            if ((i2 & 4) != 0) {
                orientation = capturedPhoto.orientation;
            }
            Orientation orientation2 = orientation;
            if ((i2 & 8) != 0) {
                z = capturedPhoto.isMirrored;
            }
            boolean z2 = z;
            if ((i2 & 16) != 0) {
                i = capturedPhoto.format;
            }
            return capturedPhoto.copy(image, totalCaptureResult2, orientation2, z2, i);
        }

        /* renamed from: component1, reason: from getter */
        public final Image getImage() {
            return this.image;
        }

        /* renamed from: component2, reason: from getter */
        public final TotalCaptureResult getMetadata() {
            return this.metadata;
        }

        /* renamed from: component3, reason: from getter */
        public final Orientation getOrientation() {
            return this.orientation;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsMirrored() {
            return this.isMirrored;
        }

        /* renamed from: component5, reason: from getter */
        public final int getFormat() {
            return this.format;
        }

        public final CapturedPhoto copy(Image image, TotalCaptureResult metadata, Orientation orientation, boolean isMirrored, int format) {
            Intrinsics.checkNotNullParameter(image, "image");
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            Intrinsics.checkNotNullParameter(orientation, "orientation");
            return new CapturedPhoto(image, metadata, orientation, isMirrored, format);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CapturedPhoto)) {
                return false;
            }
            CapturedPhoto capturedPhoto = (CapturedPhoto) other;
            return Intrinsics.areEqual(this.image, capturedPhoto.image) && Intrinsics.areEqual(this.metadata, capturedPhoto.metadata) && this.orientation == capturedPhoto.orientation && this.isMirrored == capturedPhoto.isMirrored && this.format == capturedPhoto.format;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((this.image.hashCode() * 31) + this.metadata.hashCode()) * 31) + this.orientation.hashCode()) * 31;
            boolean z = this.isMirrored;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return ((hashCode + i) * 31) + this.format;
        }

        public String toString() {
            return "CapturedPhoto(image=" + this.image + ", metadata=" + this.metadata + ", orientation=" + this.orientation + ", isMirrored=" + this.isMirrored + ", format=" + this.format + ")";
        }

        public CapturedPhoto(Image image, TotalCaptureResult metadata, Orientation orientation, boolean z, int i) {
            Intrinsics.checkNotNullParameter(image, "image");
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            Intrinsics.checkNotNullParameter(orientation, "orientation");
            this.image = image;
            this.metadata = metadata;
            this.orientation = orientation;
            this.isMirrored = z;
            this.format = i;
        }

        public final Image getImage() {
            return this.image;
        }

        public final TotalCaptureResult getMetadata() {
            return this.metadata;
        }

        public final Orientation getOrientation() {
            return this.orientation;
        }

        public final boolean isMirrored() {
            return this.isMirrored;
        }

        public final int getFormat() {
            return this.format;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.image.close();
        }
    }
}
