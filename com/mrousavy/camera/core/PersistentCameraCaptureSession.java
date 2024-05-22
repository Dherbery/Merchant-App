package com.mrousavy.camera.core;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.util.Log;
import com.mrousavy.camera.core.capture.RepeatingCaptureRequest;
import com.mrousavy.camera.core.outputs.SurfaceOutput;
import com.mrousavy.camera.extensions.CameraCaptureSession_tryAbortCapturesKt;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;
import java.io.Closeable;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: PersistentCameraCaptureSession.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 H2\u00020\u0001:\u0003GHIB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\nH\u0002JI\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020 H\u0016J\u0011\u00100\u001a\u00020 H\u0082@ø\u0001\u0000¢\u0006\u0002\u00101J\u0019\u00102\u001a\u00020 2\u0006\u00103\u001a\u000204H\u0086@ø\u0001\u0000¢\u0006\u0002\u00105J\b\u00106\u001a\u0004\u0018\u00010\bJ\u0010\u00107\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0019\u00108\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u00109J'\u0010:\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010;J\u000e\u0010<\u001a\u00020 2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010=\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u0010J\u0014\u0010>\u001a\u00020 2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u000e\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020\u001cJ/\u0010A\u001a\u00020 2\u001c\u0010B\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0D\u0012\u0006\u0012\u0004\u0018\u00010E0CH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010FR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006J"}, d2 = {"Lcom/mrousavy/camera/core/PersistentCameraCaptureSession;", "Ljava/io/Closeable;", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "callback", "Lcom/mrousavy/camera/core/PersistentCameraCaptureSession$Callback;", "(Landroid/hardware/camera2/CameraManager;Lcom/mrousavy/camera/core/PersistentCameraCaptureSession$Callback;)V", "cameraDeviceDetails", "Lcom/mrousavy/camera/core/CameraDeviceDetails;", "cameraId", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "device", "Landroid/hardware/camera2/CameraDevice;", "didDestroyFromOutside", "", "focusJob", "Lkotlinx/coroutines/Job;", "isActive", "isRunning", "()Z", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "outputs", "", "Lcom/mrousavy/camera/core/outputs/SurfaceOutput;", "repeatingRequest", "Lcom/mrousavy/camera/core/capture/RepeatingCaptureRequest;", OutcomeEventsTable.COLUMN_NAME_SESSION, "Landroid/hardware/camera2/CameraCaptureSession;", "assertLocked", "", "method", "capture", "Landroid/hardware/camera2/TotalCaptureResult;", "qualityPrioritization", "Lcom/mrousavy/camera/types/QualityPrioritization;", "flash", "Lcom/mrousavy/camera/types/Flash;", "enableAutoStabilization", "enablePhotoHdr", "orientation", "Lcom/mrousavy/camera/types/Orientation;", "enableShutterSound", "enablePrecapture", "(Lcom/mrousavy/camera/types/QualityPrioritization;Lcom/mrousavy/camera/types/Flash;ZZLcom/mrousavy/camera/types/Orientation;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "configure", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "focus", "point", "Landroid/graphics/Point;", "(Landroid/graphics/Point;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveDeviceDetails", "getOrCreateCameraDeviceDetails", "getOrCreateDevice", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrCreateSession", "(Landroid/hardware/camera2/CameraDevice;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setInput", "setIsActive", "setOutputs", "setRepeatingRequest", "request", "withConfiguration", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Callback", "Companion", "SessionIsNotLockedError", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PersistentCameraCaptureSession implements Closeable {
    private static final long FOCUS_RESET_TIMEOUT = 3000;
    private static final long PRECAPTURE_LOCK_TIMEOUT = 5000;
    private static final String TAG = "PersistentCameraCaptureSession";
    private final Callback callback;
    private CameraDeviceDetails cameraDeviceDetails;
    private String cameraId;
    private final CameraManager cameraManager;
    private final CoroutineScope coroutineScope;
    private CameraDevice device;
    private boolean didDestroyFromOutside;
    private Job focusJob;
    private boolean isActive;
    private final Mutex mutex;
    private List<? extends SurfaceOutput> outputs;
    private RepeatingCaptureRequest repeatingRequest;
    private CameraCaptureSession session;

    /* compiled from: PersistentCameraCaptureSession.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/mrousavy/camera/core/PersistentCameraCaptureSession$Callback;", "", "onError", "", "error", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Callback {
        void onError(Throwable error);
    }

    public PersistentCameraCaptureSession(CameraManager cameraManager, Callback callback) {
        Intrinsics.checkNotNullParameter(cameraManager, "cameraManager");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.cameraManager = cameraManager;
        this.callback = callback;
        this.outputs = CollectionsKt.emptyList();
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(CameraQueues.INSTANCE.getCameraQueue().getCoroutineDispatcher());
    }

    public final boolean isRunning() {
        return (!this.isActive || this.session == null || this.device == null || this.didDestroyFromOutside) ? false : true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Job job = this.focusJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        CameraCaptureSession cameraCaptureSession = this.session;
        if (cameraCaptureSession != null) {
            CameraCaptureSession_tryAbortCapturesKt.tryAbortCaptures(cameraCaptureSession);
        }
        CameraDevice cameraDevice = this.device;
        if (cameraDevice != null) {
            cameraDevice.close();
        }
    }

    private final void assertLocked(String method) {
        if (this.mutex.isLocked()) {
            return;
        }
        throw new SessionIsNotLockedError("Failed to call " + method + ", session is not locked! Call beginConfiguration() first.");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(4:(2:3|(7:5|6|7|(1:(1:(1:(5:12|13|14|15|16)(2:19|20))(7:21|22|23|(1:25)|14|15|16))(1:26))(4:37|(1:39)|40|(1:42)(1:43))|27|28|(1:30)(6:31|23|(0)|14|15|16)))|27|28|(0)(0))|45|6|7|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0049, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /* JADX WARN: Type inference failed for: r9v0, types: [kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v9, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object withConfiguration(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.mrousavy.camera.core.PersistentCameraCaptureSession$withConfiguration$1
            if (r0 == 0) goto L14
            r0 = r10
            com.mrousavy.camera.core.PersistentCameraCaptureSession$withConfiguration$1 r0 = (com.mrousavy.camera.core.PersistentCameraCaptureSession$withConfiguration$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.mrousavy.camera.core.PersistentCameraCaptureSession$withConfiguration$1 r0 = new com.mrousavy.camera.core.PersistentCameraCaptureSession$withConfiguration$1
            r0.<init>(r8, r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L5e
            if (r2 == r5) goto L4b
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L49
            goto L99
        L35:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3d:
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r2 = r0.L$0
            com.mrousavy.camera.core.PersistentCameraCaptureSession r2 = (com.mrousavy.camera.core.PersistentCameraCaptureSession) r2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L49
            goto L8c
        L49:
            r10 = move-exception
            goto La5
        L4b:
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r5 = r0.L$0
            com.mrousavy.camera.core.PersistentCameraCaptureSession r5 = (com.mrousavy.camera.core.PersistentCameraCaptureSession) r5
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            r9 = r2
            r2 = r5
            goto L7c
        L5e:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.Job r10 = r8.focusJob
            if (r10 == 0) goto L68
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r10, r6, r5, r6)
        L68:
            r8.focusJob = r6
            kotlinx.coroutines.sync.Mutex r10 = r8.mutex
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r5
            java.lang.Object r2 = r10.lock(r6, r0)
            if (r2 != r1) goto L7b
            return r1
        L7b:
            r2 = r8
        L7c:
            r0.L$0 = r2     // Catch: java.lang.Throwable -> La1
            r0.L$1 = r10     // Catch: java.lang.Throwable -> La1
            r0.L$2 = r6     // Catch: java.lang.Throwable -> La1
            r0.label = r4     // Catch: java.lang.Throwable -> La1
            java.lang.Object r9 = r9.invoke(r0)     // Catch: java.lang.Throwable -> La1
            if (r9 != r1) goto L8b
            return r1
        L8b:
            r9 = r10
        L8c:
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L49
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L49
            r0.label = r3     // Catch: java.lang.Throwable -> L49
            java.lang.Object r10 = r2.configure(r0)     // Catch: java.lang.Throwable -> L49
            if (r10 != r1) goto L99
            return r1
        L99:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L49
            r9.unlock(r6)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        La1:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        La5:
            r9.unlock(r6)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.PersistentCameraCaptureSession.withConfiguration(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setInput(String cameraId) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Log.d(TAG, "--> setInput(" + cameraId + ")");
        assertLocked("setInput");
        if (Intrinsics.areEqual(this.cameraId, cameraId)) {
            CameraDevice cameraDevice = this.device;
            if (Intrinsics.areEqual(cameraDevice != null ? cameraDevice.getId() : null, cameraId)) {
                return;
            }
        }
        this.cameraId = cameraId;
        CameraCaptureSession cameraCaptureSession = this.session;
        if (cameraCaptureSession != null) {
            CameraCaptureSession_tryAbortCapturesKt.tryAbortCaptures(cameraCaptureSession);
        }
        this.session = null;
        CameraDevice cameraDevice2 = this.device;
        if (cameraDevice2 != null) {
            cameraDevice2.close();
        }
        this.device = null;
    }

    public final void setOutputs(List<? extends SurfaceOutput> outputs) {
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        Log.d(TAG, "--> setOutputs(" + outputs + ")");
        assertLocked("setOutputs");
        if (Intrinsics.areEqual(this.outputs, outputs)) {
            return;
        }
        this.outputs = outputs;
        if (!outputs.isEmpty()) {
            CameraCaptureSession cameraCaptureSession = this.session;
            if (cameraCaptureSession != null) {
                CameraCaptureSession_tryAbortCapturesKt.tryAbortCaptures(cameraCaptureSession);
            }
        } else {
            CameraCaptureSession cameraCaptureSession2 = this.session;
            if (cameraCaptureSession2 != null) {
                cameraCaptureSession2.close();
            }
        }
        this.session = null;
    }

    public final void setRepeatingRequest(RepeatingCaptureRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        assertLocked("setRepeatingRequest");
        Log.d(TAG, "--> setRepeatingRequest(...)");
        if (Intrinsics.areEqual(this.repeatingRequest, request)) {
            return;
        }
        this.repeatingRequest = request;
    }

    public final void setIsActive(boolean isActive) {
        assertLocked("setIsActive");
        Log.d(TAG, "--> setIsActive(" + isActive + ")");
        if (this.isActive != isActive) {
            this.isActive = isActive;
        }
        if (isActive && this.didDestroyFromOutside) {
            this.didDestroyFromOutside = false;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:(2:34|(16:50|51|52|53|54|55|56|(1:58)(1:112)|59|60|61|62|(1:64)(1:107)|65|66|(1:68)(11:69|70|71|72|73|74|(0)(0)|77|(0)(0)|80|(0)(0)))(5:38|(1:40)(1:49)|41|42|(1:44)(3:46|47|48)))|53|54|55|56|(0)(0)|59|60|61|62|(0)(0)|65|66|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(25:16|(1:18)(1:118)|19|(4:22|(2:24|25)(1:27)|26|20)|28|29|(2:34|(16:50|51|52|53|54|55|56|(1:58)(1:112)|59|60|61|62|(1:64)(1:107)|65|66|(1:68)(11:69|70|71|72|73|74|(0)(0)|77|(0)(0)|80|(0)(0)))(5:38|(1:40)(1:49)|41|42|(1:44)(3:46|47|48)))|117|(1:36)|50|51|52|53|54|55|56|(0)(0)|59|60|61|62|(0)(0)|65|66|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(4:(2:3|(7:5|6|7|(1:(2:125|(1:(1:(6:129|130|131|84|85|86)(2:134|135))(14:136|137|138|139|70|71|72|73|74|(1:76)(1:89)|77|(1:79)(1:88)|80|(1:82)(4:83|84|85|86)))(5:142|143|144|47|48))(1:10))(4:147|(1:149)|150|(1:152)(1:153))|11|12|(2:14|(25:16|(1:18)(1:118)|19|(4:22|(2:24|25)(1:27)|26|20)|28|29|(2:34|(16:50|51|52|53|54|55|56|(1:58)(1:112)|59|60|61|62|(1:64)(1:107)|65|66|(1:68)(11:69|70|71|72|73|74|(0)(0)|77|(0)(0)|80|(0)(0)))(5:38|(1:40)(1:49)|41|42|(1:44)(3:46|47|48)))|117|(1:36)|50|51|52|53|54|55|56|(0)(0)|59|60|61|62|(0)(0)|65|66|(0)(0))(2:119|120))(2:121|122)))|11|12|(0)(0))|156|6|7|(0)(0)|(2:(0)|(1:98))) */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0229, code lost:
    
        r6 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x022f, code lost:
    
        r7 = r12;
        r9 = r8;
        r2 = r11;
        r10 = r14;
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0248, code lost:
    
        r8 = r0;
        r14 = r1;
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x022c, code lost:
    
        r19 = "singleRequest.build()";
        r6 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0240, code lost:
    
        r19 = "singleRequest.build()";
        r6 = r19;
        r5 = false;
        r7 = r12;
        r9 = r8;
        r2 = r11;
        r10 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02b7, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02b8, code lost:
    
        r10 = r3;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02c0 A[Catch: all -> 0x02c6, TryCatch #2 {all -> 0x02c6, blocks: (B:12:0x0105, B:14:0x010e, B:16:0x0112, B:19:0x0119, B:20:0x0149, B:22:0x014f, B:24:0x015f, B:29:0x0165, B:31:0x016c, B:36:0x0176, B:38:0x017a, B:41:0x018f, B:51:0x01ad, B:54:0x01b4, B:56:0x01b8, B:59:0x01bf, B:62:0x01c6, B:65:0x01e7, B:119:0x02ba, B:120:0x02bf, B:121:0x02c0, B:122:0x02c5), top: B:11:0x0105 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x010e A[Catch: all -> 0x02c6, TryCatch #2 {all -> 0x02c6, blocks: (B:12:0x0105, B:14:0x010e, B:16:0x0112, B:19:0x0119, B:20:0x0149, B:22:0x014f, B:24:0x015f, B:29:0x0165, B:31:0x016c, B:36:0x0176, B:38:0x017a, B:41:0x018f, B:51:0x01ad, B:54:0x01b4, B:56:0x01b8, B:59:0x01bf, B:62:0x01c6, B:65:0x01e7, B:119:0x02ba, B:120:0x02bf, B:121:0x02c0, B:122:0x02c5), top: B:11:0x0105 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0215 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0252 A[Catch: all -> 0x02a4, TryCatch #0 {all -> 0x02a4, blocks: (B:74:0x024c, B:76:0x0252, B:77:0x0267, B:80:0x0274), top: B:73:0x024c }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x028e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v40, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r10v42 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object capture(com.mrousavy.camera.types.QualityPrioritization r25, com.mrousavy.camera.types.Flash r26, boolean r27, boolean r28, com.mrousavy.camera.types.Orientation r29, boolean r30, boolean r31, kotlin.coroutines.Continuation<? super android.hardware.camera2.TotalCaptureResult> r32) {
        /*
            Method dump skipped, instructions count: 717
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.PersistentCameraCaptureSession.capture(com.mrousavy.camera.types.QualityPrioritization, com.mrousavy.camera.types.Flash, boolean, boolean, com.mrousavy.camera.types.Orientation, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ab A[Catch: all -> 0x0180, TryCatch #0 {all -> 0x0180, blocks: (B:31:0x0091, B:33:0x00ab, B:35:0x00af, B:37:0x00c2, B:38:0x00d1, B:52:0x00ec, B:54:0x011b, B:59:0x016e, B:60:0x0173, B:61:0x0174, B:62:0x0179, B:63:0x017a, B:64:0x017f), top: B:30:0x0091 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017a A[Catch: all -> 0x0180, TryCatch #0 {all -> 0x0180, blocks: (B:31:0x0091, B:33:0x00ab, B:35:0x00af, B:37:0x00c2, B:38:0x00d1, B:52:0x00ec, B:54:0x011b, B:59:0x016e, B:60:0x0173, B:61:0x0174, B:62:0x0179, B:63:0x017a, B:64:0x017f), top: B:30:0x0091 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object focus(android.graphics.Point r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.PersistentCameraCaptureSession.focus(android.graphics.Point, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final CameraDeviceDetails getActiveDeviceDetails() {
        CameraDevice cameraDevice = this.device;
        if (cameraDevice == null) {
            return null;
        }
        return getOrCreateCameraDeviceDetails(cameraDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ff A[Catch: CameraAccessException -> 0x004a, TryCatch #2 {CameraAccessException -> 0x004a, blocks: (B:12:0x0045, B:13:0x00f9, B:15:0x00ff, B:18:0x0102, B:20:0x0106, B:21:0x011c, B:23:0x0122, B:26:0x012f, B:31:0x0133, B:32:0x014a, B:35:0x0142), top: B:11:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0102 A[Catch: CameraAccessException -> 0x004a, TryCatch #2 {CameraAccessException -> 0x004a, blocks: (B:12:0x0045, B:13:0x00f9, B:15:0x00ff, B:18:0x0102, B:20:0x0106, B:21:0x011c, B:23:0x0122, B:26:0x012f, B:31:0x0133, B:32:0x014a, B:35:0x0142), top: B:11:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object configure(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.PersistentCameraCaptureSession.configure(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getOrCreateDevice(java.lang.String r6, kotlin.coroutines.Continuation<? super android.hardware.camera2.CameraDevice> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.mrousavy.camera.core.PersistentCameraCaptureSession$getOrCreateDevice$1
            if (r0 == 0) goto L14
            r0 = r7
            com.mrousavy.camera.core.PersistentCameraCaptureSession$getOrCreateDevice$1 r0 = (com.mrousavy.camera.core.PersistentCameraCaptureSession$getOrCreateDevice$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.mrousavy.camera.core.PersistentCameraCaptureSession$getOrCreateDevice$1 r0 = new com.mrousavy.camera.core.PersistentCameraCaptureSession$getOrCreateDevice$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r6 = r0.L$0
            com.mrousavy.camera.core.PersistentCameraCaptureSession r6 = (com.mrousavy.camera.core.PersistentCameraCaptureSession) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L85
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            kotlin.ResultKt.throwOnFailure(r7)
            android.hardware.camera2.CameraDevice r7 = r5.device
            r2 = 0
            if (r7 == 0) goto L43
            java.lang.String r4 = r7.getId()
            goto L44
        L43:
            r4 = r2
        L44:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r6)
            if (r4 == 0) goto L51
            boolean r4 = com.mrousavy.camera.extensions.CameraDevice_isValidKt.isValid(r7)
            if (r4 == 0) goto L51
            return r7
        L51:
            android.hardware.camera2.CameraCaptureSession r7 = r5.session
            if (r7 == 0) goto L58
            com.mrousavy.camera.extensions.CameraCaptureSession_tryAbortCapturesKt.tryAbortCaptures(r7)
        L58:
            android.hardware.camera2.CameraDevice r7 = r5.device
            if (r7 == 0) goto L5f
            r7.close()
        L5f:
            r5.device = r2
            r5.session = r2
            java.lang.String r7 = "PersistentCameraCaptureSession"
            java.lang.String r2 = "Creating new device..."
            android.util.Log.i(r7, r2)
            android.hardware.camera2.CameraManager r7 = r5.cameraManager
            com.mrousavy.camera.core.PersistentCameraCaptureSession$getOrCreateDevice$newDevice$1 r2 = new com.mrousavy.camera.core.PersistentCameraCaptureSession$getOrCreateDevice$newDevice$1
            r2.<init>()
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            com.mrousavy.camera.core.CameraQueues$Companion r4 = com.mrousavy.camera.core.CameraQueues.INSTANCE
            com.mrousavy.camera.core.CameraQueues$CameraQueue r4 = r4.getVideoQueue()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r7 = com.mrousavy.camera.extensions.CameraManager_openCameraKt.openCamera(r7, r6, r2, r4, r0)
            if (r7 != r1) goto L84
            return r1
        L84:
            r6 = r5
        L85:
            android.hardware.camera2.CameraDevice r7 = (android.hardware.camera2.CameraDevice) r7
            r6.device = r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.PersistentCameraCaptureSession.getOrCreateDevice(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getOrCreateSession(android.hardware.camera2.CameraDevice r8, java.util.List<? extends com.mrousavy.camera.core.outputs.SurfaceOutput> r9, kotlin.coroutines.Continuation<? super android.hardware.camera2.CameraCaptureSession> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.mrousavy.camera.core.PersistentCameraCaptureSession$getOrCreateSession$1
            if (r0 == 0) goto L14
            r0 = r10
            com.mrousavy.camera.core.PersistentCameraCaptureSession$getOrCreateSession$1 r0 = (com.mrousavy.camera.core.PersistentCameraCaptureSession$getOrCreateSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.mrousavy.camera.core.PersistentCameraCaptureSession$getOrCreateSession$1 r0 = new com.mrousavy.camera.core.PersistentCameraCaptureSession$getOrCreateSession$1
            r0.<init>(r7, r10)
        L19:
            r6 = r0
            java.lang.Object r10 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r8 = r6.L$0
            com.mrousavy.camera.core.PersistentCameraCaptureSession r8 = (com.mrousavy.camera.core.PersistentCameraCaptureSession) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L77
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.throwOnFailure(r10)
            android.hardware.camera2.CameraCaptureSession r10 = r7.session
            if (r10 == 0) goto L43
            android.hardware.camera2.CameraDevice r1 = r10.getDevice()
            goto L44
        L43:
            r1 = 0
        L44:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r8)
            if (r1 == 0) goto L4b
            return r10
        L4b:
            boolean r10 = r9.isEmpty()
            if (r10 != 0) goto L7c
            java.lang.String r10 = "PersistentCameraCaptureSession"
            java.lang.String r1 = "Creating new session..."
            android.util.Log.i(r10, r1)
            android.hardware.camera2.CameraManager r10 = r7.cameraManager
            com.mrousavy.camera.core.PersistentCameraCaptureSession$getOrCreateSession$newSession$1 r1 = new com.mrousavy.camera.core.PersistentCameraCaptureSession$getOrCreateSession$newSession$1
            r1.<init>()
            r4 = r1
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            com.mrousavy.camera.core.CameraQueues$Companion r1 = com.mrousavy.camera.core.CameraQueues.INSTANCE
            com.mrousavy.camera.core.CameraQueues$CameraQueue r5 = r1.getVideoQueue()
            r6.L$0 = r7
            r6.label = r2
            r1 = r8
            r2 = r10
            r3 = r9
            java.lang.Object r10 = com.mrousavy.camera.extensions.CameraDevice_createCaptureSessionKt.createCaptureSession(r1, r2, r3, r4, r5, r6)
            if (r10 != r0) goto L76
            return r0
        L76:
            r8 = r7
        L77:
            android.hardware.camera2.CameraCaptureSession r10 = (android.hardware.camera2.CameraCaptureSession) r10
            r8.session = r10
            return r10
        L7c:
            com.mrousavy.camera.core.NoOutputsError r8 = new com.mrousavy.camera.core.NoOutputsError
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.PersistentCameraCaptureSession.getOrCreateSession(android.hardware.camera2.CameraDevice, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final CameraDeviceDetails getOrCreateCameraDeviceDetails(CameraDevice device) {
        CameraDeviceDetails cameraDeviceDetails = this.cameraDeviceDetails;
        if (Intrinsics.areEqual(cameraDeviceDetails != null ? cameraDeviceDetails.getCameraId() : null, device.getId())) {
            return cameraDeviceDetails;
        }
        CameraManager cameraManager = this.cameraManager;
        String id = device.getId();
        Intrinsics.checkNotNullExpressionValue(id, "device.id");
        CameraDeviceDetails cameraDeviceDetails2 = new CameraDeviceDetails(cameraManager, id);
        this.cameraDeviceDetails = cameraDeviceDetails2;
        return cameraDeviceDetails2;
    }

    /* compiled from: PersistentCameraCaptureSession.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/mrousavy/camera/core/PersistentCameraCaptureSession$SessionIsNotLockedError;", "Ljava/lang/Error;", "Lkotlin/Error;", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "", "(Ljava/lang/String;)V", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class SessionIsNotLockedError extends Error {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SessionIsNotLockedError(String message) {
            super(message);
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }
}
