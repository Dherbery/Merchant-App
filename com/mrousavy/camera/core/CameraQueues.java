package com.mrousavy.camera.core;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;

/* compiled from: CameraQueues.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/mrousavy/camera/core/CameraQueues;", "", "()V", "CameraQueue", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraQueues {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CameraQueue cameraQueue = new CameraQueue("mrousavy/VisionCamera.main");
    private static final CameraQueue videoQueue = new CameraQueue("mrousavy/VisionCamera.video");

    /* compiled from: CameraQueues.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/mrousavy/camera/core/CameraQueues$Companion;", "", "()V", "cameraQueue", "Lcom/mrousavy/camera/core/CameraQueues$CameraQueue;", "getCameraQueue", "()Lcom/mrousavy/camera/core/CameraQueues$CameraQueue;", "videoQueue", "getVideoQueue", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CameraQueue getCameraQueue() {
            return CameraQueues.cameraQueue;
        }

        public final CameraQueue getVideoQueue() {
            return CameraQueues.videoQueue;
        }
    }

    /* compiled from: CameraQueues.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/mrousavy/camera/core/CameraQueues$CameraQueue;", "", "name", "", "(Ljava/lang/String;)V", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getCoroutineDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "thread", "Landroid/os/HandlerThread;", "finalize", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class CameraQueue {
        private final CoroutineDispatcher coroutineDispatcher;
        private final Executor executor;
        private final Handler handler;
        private final HandlerThread thread;

        public CameraQueue(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            HandlerThread handlerThread = new HandlerThread(name);
            this.thread = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.handler = handler;
            HandlerDispatcher from = HandlerDispatcherKt.from(handler, name);
            this.coroutineDispatcher = from;
            this.executor = ExecutorsKt.asExecutor(from);
        }

        public final Handler getHandler() {
            return this.handler;
        }

        public final Executor getExecutor() {
            return this.executor;
        }

        public final CoroutineDispatcher getCoroutineDispatcher() {
            return this.coroutineDispatcher;
        }

        protected final void finalize() {
            this.thread.quitSafely();
        }
    }
}
