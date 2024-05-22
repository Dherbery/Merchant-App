package com.mrousavy.camera;

import android.content.ComponentCallbacks2;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.facebook.react.uimanager.UIManagerHelper;
import com.mrousavy.camera.core.CameraQueues;
import com.mrousavy.camera.core.ViewNotFoundError;
import com.mrousavy.camera.frameprocessor.VisionCameraInstaller;
import com.mrousavy.camera.frameprocessor.VisionCameraProxy;
import com.mrousavy.camera.types.PermissionStatus;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: CameraViewModule.kt */
@ReactModule(name = "CameraView")
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\nH\u0007J\b\u0010\u0018\u001a\u00020\nH\u0007J\b\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0007J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J \u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#H\u0007J\u0018\u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J \u0010%\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/mrousavy/camera/CameraViewModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "canRequestPermission", "", "permission", "", "findCameraView", "Lcom/mrousavy/camera/CameraView;", "viewId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "focus", "", "viewTag", "point", "Lcom/facebook/react/bridge/ReadableMap;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "getCameraPermissionStatus", "getMicrophonePermissionStatus", "getName", "installFrameProcessorBindings", "invalidate", "pauseRecording", "requestCameraPermission", "requestMicrophonePermission", "resumeRecording", "startRecording", "jsOptions", "onRecordCallback", "Lcom/facebook/react/bridge/Callback;", "stopRecording", "takePhoto", "options", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraViewModule extends ReactContextBaseJavaModule {
    public static final String TAG = "CameraView";
    private final CoroutineScope coroutineScope;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int sharedRequestCode = 10;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "CameraView";
    }

    /* compiled from: CameraViewModule.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/mrousavy/camera/CameraViewModule$Companion;", "", "()V", "TAG", "", "sharedRequestCode", "", "getSharedRequestCode", "()I", "setSharedRequestCode", "(I)V", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getSharedRequestCode() {
            return CameraViewModule.sharedRequestCode;
        }

        public final void setSharedRequestCode(int i) {
            CameraViewModule.sharedRequestCode = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraViewModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(CameraQueues.INSTANCE.getCameraQueue().getCoroutineDispatcher());
    }

    static {
        try {
            System.loadLibrary("VisionCamera");
        } catch (UnsatisfiedLinkError e) {
            Log.e(VisionCameraProxy.TAG, "Failed to load VisionCamera C++ library!", e);
            throw e;
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        if (CoroutineScopeKt.isActive(this.coroutineScope)) {
            CoroutineScopeKt.cancel$default(this.coroutineScope, "CameraViewModule has been destroyed.", null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object findCameraView(final int i, Continuation<? super CameraView> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mrousavy.camera.CameraViewModule$findCameraView$2$1
            @Override // java.lang.Runnable
            public final void run() {
                ReactApplicationContext reactApplicationContext;
                ReactApplicationContext reactApplicationContext2;
                int i2;
                StringBuilder sb;
                ReactApplicationContext reactApplicationContext3;
                Log.d("CameraView", "Finding view " + i + "...");
                reactApplicationContext = this.getReactApplicationContext();
                if (reactApplicationContext != null) {
                    reactApplicationContext3 = this.getReactApplicationContext();
                    UIManager uIManager = UIManagerHelper.getUIManager(reactApplicationContext3, i);
                    r2 = (CameraView) (uIManager != null ? uIManager.resolveView(i) : null);
                }
                reactApplicationContext2 = this.getReactApplicationContext();
                if (reactApplicationContext2 != null) {
                    i2 = i;
                    sb = new StringBuilder("Found view ");
                } else {
                    i2 = i;
                    sb = new StringBuilder("Couldn't find view ");
                }
                sb.append(i2);
                sb.append("!");
                Log.d("CameraView", sb.toString());
                if (r2 != null) {
                    Continuation<CameraView> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1318constructorimpl(r2));
                } else {
                    Continuation<CameraView> continuation3 = safeContinuation2;
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation3.resumeWith(Result.m1318constructorimpl(ResultKt.createFailure(new ViewNotFoundError(i))));
                }
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final boolean installFrameProcessorBindings() {
        try {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "reactApplicationContext");
            VisionCameraInstaller.install(new VisionCameraProxy(reactApplicationContext));
            return true;
        } catch (Error e) {
            Log.e("CameraView", "Failed to install Frame Processor JSI Bindings!", e);
            return false;
        }
    }

    @ReactMethod
    public final void takePhoto(int viewTag, ReadableMap options, Promise promise) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new CameraViewModule$takePhoto$1(this, viewTag, promise, options, null), 3, null);
    }

    @ReactMethod
    public final void startRecording(int viewTag, ReadableMap jsOptions, Callback onRecordCallback) {
        Intrinsics.checkNotNullParameter(jsOptions, "jsOptions");
        Intrinsics.checkNotNullParameter(onRecordCallback, "onRecordCallback");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new CameraViewModule$startRecording$1(this, viewTag, jsOptions, onRecordCallback, null), 3, null);
    }

    @ReactMethod
    public final void pauseRecording(int viewTag, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new CameraViewModule$pauseRecording$1(promise, this, viewTag, null), 3, null);
    }

    @ReactMethod
    public final void resumeRecording(int viewTag, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new CameraViewModule$resumeRecording$1(this, viewTag, promise, null), 3, null);
    }

    @ReactMethod
    public final void stopRecording(int viewTag, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new CameraViewModule$stopRecording$1(this, viewTag, promise, null), 3, null);
    }

    @ReactMethod
    public final void focus(int viewTag, ReadableMap point, Promise promise) {
        Intrinsics.checkNotNullParameter(point, "point");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new CameraViewModule$focus$1(this, viewTag, promise, point, null), 3, null);
    }

    private final boolean canRequestPermission(String permission) {
        ComponentCallbacks2 currentActivity = getCurrentActivity();
        PermissionAwareActivity permissionAwareActivity = currentActivity instanceof PermissionAwareActivity ? (PermissionAwareActivity) currentActivity : null;
        if (permissionAwareActivity != null) {
            return permissionAwareActivity.shouldShowRequestPermissionRationale(permission);
        }
        return false;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final String getCameraPermissionStatus() {
        PermissionStatus fromPermissionStatus = PermissionStatus.INSTANCE.fromPermissionStatus(ContextCompat.checkSelfPermission(getReactApplicationContext(), "android.permission.CAMERA"));
        if (fromPermissionStatus == PermissionStatus.DENIED && canRequestPermission("android.permission.CAMERA")) {
            fromPermissionStatus = PermissionStatus.NOT_DETERMINED;
        }
        return fromPermissionStatus.getUnionValue();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final String getMicrophonePermissionStatus() {
        PermissionStatus fromPermissionStatus = PermissionStatus.INSTANCE.fromPermissionStatus(ContextCompat.checkSelfPermission(getReactApplicationContext(), "android.permission.RECORD_AUDIO"));
        if (fromPermissionStatus == PermissionStatus.DENIED && canRequestPermission("android.permission.RECORD_AUDIO")) {
            fromPermissionStatus = PermissionStatus.NOT_DETERMINED;
        }
        return fromPermissionStatus.getUnionValue();
    }

    @ReactMethod
    public final void requestCameraPermission(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        ComponentCallbacks2 currentActivity = getReactApplicationContext().getCurrentActivity();
        if (currentActivity instanceof PermissionAwareActivity) {
            final int i = sharedRequestCode;
            sharedRequestCode = i + 1;
            ((PermissionAwareActivity) currentActivity).requestPermissions(new String[]{"android.permission.CAMERA"}, i, new PermissionListener() { // from class: com.mrousavy.camera.CameraViewModule$$ExternalSyntheticLambda0
                @Override // com.facebook.react.modules.core.PermissionListener
                public final boolean onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                    boolean requestCameraPermission$lambda$1;
                    requestCameraPermission$lambda$1 = CameraViewModule.requestCameraPermission$lambda$1(i, promise, i2, strArr, iArr);
                    return requestCameraPermission$lambda$1;
                }
            });
            return;
        }
        promise.reject("NO_ACTIVITY", "No PermissionAwareActivity was found! Make sure the app has launched before calling this function.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean requestCameraPermission$lambda$1(int i, Promise promise, int i2, String[] strArr, int[] grantResults) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(strArr, "<anonymous parameter 1>");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (i2 != i) {
            return false;
        }
        promise.resolve(PermissionStatus.INSTANCE.fromPermissionStatus((grantResults.length == 0) ^ true ? grantResults[0] : -1).getUnionValue());
        return true;
    }

    @ReactMethod
    public final void requestMicrophonePermission(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        ComponentCallbacks2 currentActivity = getReactApplicationContext().getCurrentActivity();
        if (currentActivity instanceof PermissionAwareActivity) {
            final int i = sharedRequestCode;
            sharedRequestCode = i + 1;
            ((PermissionAwareActivity) currentActivity).requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, i, new PermissionListener() { // from class: com.mrousavy.camera.CameraViewModule$$ExternalSyntheticLambda1
                @Override // com.facebook.react.modules.core.PermissionListener
                public final boolean onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                    boolean requestMicrophonePermission$lambda$2;
                    requestMicrophonePermission$lambda$2 = CameraViewModule.requestMicrophonePermission$lambda$2(i, promise, i2, strArr, iArr);
                    return requestMicrophonePermission$lambda$2;
                }
            });
            return;
        }
        promise.reject("NO_ACTIVITY", "No PermissionAwareActivity was found! Make sure the app has launched before calling this function.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean requestMicrophonePermission$lambda$2(int i, Promise promise, int i2, String[] strArr, int[] grantResults) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(strArr, "<anonymous parameter 1>");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (i2 != i) {
            return false;
        }
        promise.resolve(PermissionStatus.INSTANCE.fromPermissionStatus((grantResults.length == 0) ^ true ? grantResults[0] : -1).getUnionValue());
        return true;
    }
}
