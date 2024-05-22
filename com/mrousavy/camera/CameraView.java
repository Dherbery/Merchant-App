package com.mrousavy.camera;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.react.uimanager.ViewProps;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.mrousavy.camera.core.CameraQueues;
import com.mrousavy.camera.core.CameraSession;
import com.mrousavy.camera.core.CodeScannerFrame;
import com.mrousavy.camera.core.PreviewView;
import com.mrousavy.camera.extensions.ViewGroup_installHierarchyFitterKt;
import com.mrousavy.camera.frameprocessor.Frame;
import com.mrousavy.camera.frameprocessor.FrameProcessor;
import com.mrousavy.camera.types.CameraDeviceFormat;
import com.mrousavy.camera.types.CodeScannerOptions;
import com.mrousavy.camera.types.Orientation;
import com.mrousavy.camera.types.PixelFormat;
import com.mrousavy.camera.types.ResizeMode;
import com.mrousavy.camera.types.Torch;
import com.mrousavy.camera.types.VideoStabilizationMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: CameraView.kt */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000  \u00012\u00020\u00012\u00020\u0002:\u0002 \u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001J\n\u0010\u008c\u0001\u001a\u00030\u008b\u0001H\u0014J%\u0010\u008d\u0001\u001a\u00030\u008b\u00012\u000f\u0010\u008e\u0001\u001a\n\u0012\u0005\u0012\u00030\u0090\u00010\u008f\u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0016J\n\u0010\u0093\u0001\u001a\u00030\u008b\u0001H\u0014J\u0014\u0010\u0094\u0001\u001a\u00030\u008b\u00012\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0016J\u0014\u0010\u0097\u0001\u001a\u00030\u008b\u00012\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0016J\n\u0010\u009a\u0001\u001a\u00030\u008b\u0001H\u0016J\n\u0010\u009b\u0001\u001a\u00030\u008b\u0001H\u0016J\n\u0010\u009c\u0001\u001a\u00030\u008b\u0001H\u0016J\b\u0010\u009d\u0001\u001a\u00030\u008b\u0001J\n\u0010\u009e\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010\u009f\u0001\u001a\u00030\u008b\u0001H\u0003R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR$\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\t\"\u0004\b*\u0010\u000bR\u001a\u0010+\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\t\"\u0004\b-\u0010\u000bR\u001a\u0010.\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\t\"\u0004\b0\u0010\u000bR\u001a\u00101\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\t\"\u0004\b3\u0010\u000bR$\u00104\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\t\"\u0004\b6\u0010\u000bR\u001a\u00107\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001e\u0010C\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u0010\n\u0002\u0010I\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010L\u001a\u0004\u0018\u00010MX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\t\"\u0004\bS\u0010\u000bR\u000e\u0010T\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010U\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\t\"\u0004\bW\u0010\u000bR\u001a\u0010X\u001a\u00020YX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010^\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\t\"\u0004\b`\u0010\u000bR\u001a\u0010a\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\t\"\u0004\bc\u0010\u000bR\u001a\u0010d\u001a\u00020eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u000e\u0010j\u001a\u00020kX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010m\u001a\u00020l2\u0006\u0010'\u001a\u00020l@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001a\u0010r\u001a\u00020sX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001a\u0010x\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\t\"\u0004\bz\u0010\u000bR\u001a\u0010{\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010\t\"\u0004\b}\u0010\u000bR \u0010~\u001a\u0004\u0018\u00010\u007fX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R \u0010\u0084\u0001\u001a\u00030\u0085\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001¨\u0006¡\u0001"}, d2 = {"Lcom/mrousavy/camera/CameraView;", "Landroid/widget/FrameLayout;", "Lcom/mrousavy/camera/core/CameraSession$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "audio", "", "getAudio", "()Z", "setAudio", "(Z)V", "cameraId", "", "getCameraId", "()Ljava/lang/String;", "setCameraId", "(Ljava/lang/String;)V", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "getCameraManager$react_native_vision_camera_release", "()Landroid/hardware/camera2/CameraManager;", "cameraSession", "Lcom/mrousavy/camera/core/CameraSession;", "getCameraSession$react_native_vision_camera_release", "()Lcom/mrousavy/camera/core/CameraSession;", "codeScannerOptions", "Lcom/mrousavy/camera/types/CodeScannerOptions;", "getCodeScannerOptions", "()Lcom/mrousavy/camera/types/CodeScannerOptions;", "setCodeScannerOptions", "(Lcom/mrousavy/camera/types/CodeScannerOptions;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "currentConfigureCall", "", "enableDepthData", "getEnableDepthData", "setEnableDepthData", "value", "enableFpsGraph", "getEnableFpsGraph", "setEnableFpsGraph", "enableFrameProcessor", "getEnableFrameProcessor", "setEnableFrameProcessor", "enableGpuBuffers", "getEnableGpuBuffers", "setEnableGpuBuffers", "enablePortraitEffectsMatteDelivery", "getEnablePortraitEffectsMatteDelivery", "setEnablePortraitEffectsMatteDelivery", "enableZoomGesture", "getEnableZoomGesture", "setEnableZoomGesture", "exposure", "", "getExposure", "()D", "setExposure", "(D)V", "format", "Lcom/mrousavy/camera/types/CameraDeviceFormat;", "getFormat", "()Lcom/mrousavy/camera/types/CameraDeviceFormat;", "setFormat", "(Lcom/mrousavy/camera/types/CameraDeviceFormat;)V", "fps", "", "getFps", "()Ljava/lang/Integer;", "setFps", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "fpsGraph", "Lcom/mrousavy/camera/FpsGraphView;", "frameProcessor", "Lcom/mrousavy/camera/frameprocessor/FrameProcessor;", "getFrameProcessor$react_native_vision_camera_release", "()Lcom/mrousavy/camera/frameprocessor/FrameProcessor;", "setFrameProcessor$react_native_vision_camera_release", "(Lcom/mrousavy/camera/frameprocessor/FrameProcessor;)V", "isActive", "setActive", "isMounted", "lowLightBoost", "getLowLightBoost", "setLowLightBoost", "orientation", "Lcom/mrousavy/camera/types/Orientation;", "getOrientation", "()Lcom/mrousavy/camera/types/Orientation;", "setOrientation", "(Lcom/mrousavy/camera/types/Orientation;)V", "photo", "getPhoto", "setPhoto", "photoHdr", "getPhotoHdr", "setPhotoHdr", "pixelFormat", "Lcom/mrousavy/camera/types/PixelFormat;", "getPixelFormat", "()Lcom/mrousavy/camera/types/PixelFormat;", "setPixelFormat", "(Lcom/mrousavy/camera/types/PixelFormat;)V", "previewView", "Lcom/mrousavy/camera/core/PreviewView;", "Lcom/mrousavy/camera/types/ResizeMode;", ViewProps.RESIZE_MODE, "getResizeMode", "()Lcom/mrousavy/camera/types/ResizeMode;", "setResizeMode", "(Lcom/mrousavy/camera/types/ResizeMode;)V", "torch", "Lcom/mrousavy/camera/types/Torch;", "getTorch", "()Lcom/mrousavy/camera/types/Torch;", "setTorch", "(Lcom/mrousavy/camera/types/Torch;)V", "video", "getVideo", "setVideo", "videoHdr", "getVideoHdr", "setVideoHdr", "videoStabilizationMode", "Lcom/mrousavy/camera/types/VideoStabilizationMode;", "getVideoStabilizationMode", "()Lcom/mrousavy/camera/types/VideoStabilizationMode;", "setVideoStabilizationMode", "(Lcom/mrousavy/camera/types/VideoStabilizationMode;)V", "zoom", "", "getZoom", "()F", "setZoom", "(F)V", "destroy", "", "onAttachedToWindow", "onCodeScanned", "codes", "", "Lcom/google/mlkit/vision/barcode/common/Barcode;", "scannerFrame", "Lcom/mrousavy/camera/core/CodeScannerFrame;", "onDetachedFromWindow", "onError", "error", "", "onFrame", "frame", "Lcom/mrousavy/camera/frameprocessor/Frame;", "onInitialized", "onStarted", "onStopped", "update", "updateFpsGraph", "updateZoomGesture", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraView extends FrameLayout implements CameraSession.Callback {
    public static final String TAG = "CameraView";
    private boolean audio;
    private String cameraId;
    private final CameraManager cameraManager;
    private final CameraSession cameraSession;
    private CodeScannerOptions codeScannerOptions;
    private final CoroutineScope coroutineScope;
    private long currentConfigureCall;
    private boolean enableDepthData;
    private boolean enableFpsGraph;
    private boolean enableFrameProcessor;
    private boolean enableGpuBuffers;
    private boolean enablePortraitEffectsMatteDelivery;
    private boolean enableZoomGesture;
    private double exposure;
    private CameraDeviceFormat format;
    private Integer fps;
    private FpsGraphView fpsGraph;
    private FrameProcessor frameProcessor;
    private boolean isActive;
    private boolean isMounted;
    private boolean lowLightBoost;
    private Orientation orientation;
    private boolean photo;
    private boolean photoHdr;
    private PixelFormat pixelFormat;
    private final PreviewView previewView;
    private ResizeMode resizeMode;
    private Torch torch;
    private boolean video;
    private boolean videoHdr;
    private VideoStabilizationMode videoStabilizationMode;
    private float zoom;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pixelFormat = PixelFormat.NATIVE;
        this.torch = Torch.OFF;
        this.zoom = 1.0f;
        this.exposure = 1.0d;
        this.orientation = Orientation.PORTRAIT;
        this.resizeMode = ResizeMode.COVER;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(CameraQueues.INSTANCE.getCameraQueue().getCoroutineDispatcher());
        Object systemService = context.getSystemService("camera");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        CameraManager cameraManager = (CameraManager) systemService;
        this.cameraManager = cameraManager;
        this.currentConfigureCall = System.currentTimeMillis();
        ViewGroup_installHierarchyFitterKt.installHierarchyFitter(this);
        setClipToOutline(true);
        CameraSession cameraSession = new CameraSession(context, cameraManager, this);
        this.cameraSession = cameraSession;
        PreviewView createPreviewView = cameraSession.createPreviewView(context);
        this.previewView = createPreviewView;
        createPreviewView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        addView(createPreviewView);
    }

    public final String getCameraId() {
        return this.cameraId;
    }

    public final void setCameraId(String str) {
        this.cameraId = str;
    }

    public final boolean getEnableDepthData() {
        return this.enableDepthData;
    }

    public final void setEnableDepthData(boolean z) {
        this.enableDepthData = z;
    }

    public final boolean getEnablePortraitEffectsMatteDelivery() {
        return this.enablePortraitEffectsMatteDelivery;
    }

    public final void setEnablePortraitEffectsMatteDelivery(boolean z) {
        this.enablePortraitEffectsMatteDelivery = z;
    }

    public final boolean getPhoto() {
        return this.photo;
    }

    public final void setPhoto(boolean z) {
        this.photo = z;
    }

    public final boolean getVideo() {
        return this.video;
    }

    public final void setVideo(boolean z) {
        this.video = z;
    }

    public final boolean getAudio() {
        return this.audio;
    }

    public final void setAudio(boolean z) {
        this.audio = z;
    }

    public final boolean getEnableFrameProcessor() {
        return this.enableFrameProcessor;
    }

    public final void setEnableFrameProcessor(boolean z) {
        this.enableFrameProcessor = z;
    }

    public final PixelFormat getPixelFormat() {
        return this.pixelFormat;
    }

    public final void setPixelFormat(PixelFormat pixelFormat) {
        Intrinsics.checkNotNullParameter(pixelFormat, "<set-?>");
        this.pixelFormat = pixelFormat;
    }

    public final CameraDeviceFormat getFormat() {
        return this.format;
    }

    public final void setFormat(CameraDeviceFormat cameraDeviceFormat) {
        this.format = cameraDeviceFormat;
    }

    public final Integer getFps() {
        return this.fps;
    }

    public final void setFps(Integer num) {
        this.fps = num;
    }

    public final VideoStabilizationMode getVideoStabilizationMode() {
        return this.videoStabilizationMode;
    }

    public final void setVideoStabilizationMode(VideoStabilizationMode videoStabilizationMode) {
        this.videoStabilizationMode = videoStabilizationMode;
    }

    public final boolean getVideoHdr() {
        return this.videoHdr;
    }

    public final void setVideoHdr(boolean z) {
        this.videoHdr = z;
    }

    public final boolean getPhotoHdr() {
        return this.photoHdr;
    }

    public final void setPhotoHdr(boolean z) {
        this.photoHdr = z;
    }

    public final boolean getLowLightBoost() {
        return this.lowLightBoost;
    }

    public final void setLowLightBoost(boolean z) {
        this.lowLightBoost = z;
    }

    public final boolean getEnableGpuBuffers() {
        return this.enableGpuBuffers;
    }

    public final void setEnableGpuBuffers(boolean z) {
        this.enableGpuBuffers = z;
    }

    /* renamed from: isActive, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }

    public final Torch getTorch() {
        return this.torch;
    }

    public final void setTorch(Torch torch) {
        Intrinsics.checkNotNullParameter(torch, "<set-?>");
        this.torch = torch;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final void setZoom(float f) {
        this.zoom = f;
    }

    public final double getExposure() {
        return this.exposure;
    }

    public final void setExposure(double d) {
        this.exposure = d;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final void setOrientation(Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "<set-?>");
        this.orientation = orientation;
    }

    public final boolean getEnableZoomGesture() {
        return this.enableZoomGesture;
    }

    public final void setEnableZoomGesture(boolean z) {
        this.enableZoomGesture = z;
        updateZoomGesture();
    }

    public final ResizeMode getResizeMode() {
        return this.resizeMode;
    }

    public final void setResizeMode(ResizeMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.previewView.setResizeMode(value);
        this.resizeMode = value;
    }

    public final boolean getEnableFpsGraph() {
        return this.enableFpsGraph;
    }

    public final void setEnableFpsGraph(boolean z) {
        this.enableFpsGraph = z;
        updateFpsGraph();
    }

    public final CodeScannerOptions getCodeScannerOptions() {
        return this.codeScannerOptions;
    }

    public final void setCodeScannerOptions(CodeScannerOptions codeScannerOptions) {
        this.codeScannerOptions = codeScannerOptions;
    }

    /* renamed from: getCameraManager$react_native_vision_camera_release, reason: from getter */
    public final CameraManager getCameraManager() {
        return this.cameraManager;
    }

    /* renamed from: getCameraSession$react_native_vision_camera_release, reason: from getter */
    public final CameraSession getCameraSession() {
        return this.cameraSession;
    }

    /* renamed from: getFrameProcessor$react_native_vision_camera_release, reason: from getter */
    public final FrameProcessor getFrameProcessor() {
        return this.frameProcessor;
    }

    public final void setFrameProcessor$react_native_vision_camera_release(FrameProcessor frameProcessor) {
        this.frameProcessor = frameProcessor;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.isMounted) {
            this.isMounted = true;
            CameraView_EventsKt.invokeOnViewReady(this);
        }
        update();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        update();
    }

    public final void destroy() {
        this.cameraSession.close();
    }

    public final void update() {
        Log.i("CameraView", "Updating CameraSession...");
        long currentTimeMillis = System.currentTimeMillis();
        this.currentConfigureCall = currentTimeMillis;
        BuildersKt.launch$default(this.coroutineScope, null, null, new CameraView$update$1(this, currentTimeMillis, null), 3, null);
    }

    private final void updateZoomGesture() {
        if (this.enableZoomGesture) {
            final ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.mrousavy.camera.CameraView$updateZoomGesture$scaleGestureDetector$1
                @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
                public boolean onScale(ScaleGestureDetector detector) {
                    Intrinsics.checkNotNullParameter(detector, "detector");
                    CameraView cameraView = CameraView.this;
                    cameraView.setZoom(cameraView.getZoom() * detector.getScaleFactor());
                    CameraView.this.update();
                    return true;
                }
            });
            setOnTouchListener(new View.OnTouchListener() { // from class: com.mrousavy.camera.CameraView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean updateZoomGesture$lambda$0;
                    updateZoomGesture$lambda$0 = CameraView.updateZoomGesture$lambda$0(scaleGestureDetector, view, motionEvent);
                    return updateZoomGesture$lambda$0;
                }
            });
        } else {
            setOnTouchListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateZoomGesture$lambda$0(ScaleGestureDetector scaleGestureDetector, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(scaleGestureDetector, "$scaleGestureDetector");
        return scaleGestureDetector.onTouchEvent(motionEvent);
    }

    private final void updateFpsGraph() {
        if (this.enableFpsGraph) {
            if (this.fpsGraph != null) {
                return;
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FpsGraphView fpsGraphView = new FpsGraphView(context);
            this.fpsGraph = fpsGraphView;
            addView(fpsGraphView);
            return;
        }
        FpsGraphView fpsGraphView2 = this.fpsGraph;
        if (fpsGraphView2 == null) {
            return;
        }
        removeView(fpsGraphView2);
        this.fpsGraph = null;
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onFrame(Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        FrameProcessor frameProcessor = this.frameProcessor;
        if (frameProcessor != null) {
            frameProcessor.call(frame);
        }
        FpsGraphView fpsGraphView = this.fpsGraph;
        if (fpsGraphView != null) {
            fpsGraphView.onTick();
        }
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onError(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        CameraView_EventsKt.invokeOnError(this, error);
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onInitialized() {
        CameraView_EventsKt.invokeOnInitialized(this);
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onStarted() {
        CameraView_EventsKt.invokeOnStarted(this);
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onStopped() {
        CameraView_EventsKt.invokeOnStopped(this);
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onCodeScanned(List<? extends Barcode> codes, CodeScannerFrame scannerFrame) {
        Intrinsics.checkNotNullParameter(codes, "codes");
        Intrinsics.checkNotNullParameter(scannerFrame, "scannerFrame");
        CameraView_EventsKt.invokeOnCodeScanned(this, codes, scannerFrame);
    }
}
