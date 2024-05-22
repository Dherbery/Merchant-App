package com.mrousavy.camera.core;

import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PersistentCameraCaptureSession.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.mrousavy.camera.core.PersistentCameraCaptureSession", f = "PersistentCameraCaptureSession.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {385, 178, 195, 211}, m = "capture", n = {"this", "qualityPrioritization", "flash", "orientation", "$this$withLock_u24default$iv", "enableAutoStabilization", "enablePhotoHdr", "enableShutterSound", "enablePrecapture", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "repeatingRequest", OutcomeEventsTable.COLUMN_NAME_SESSION, "photoRequest", "deviceDetails", "device", "outputs", "repeatingOutputs", "enableShutterSound", "$this$withLock_u24default$iv", "repeatingRequest", OutcomeEventsTable.COLUMN_NAME_SESSION, "deviceDetails", "device", "repeatingOutputs"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "Z$1", "Z$2", "Z$3", "L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* loaded from: classes5.dex */
public final class PersistentCameraCaptureSession$capture$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    boolean Z$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PersistentCameraCaptureSession this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentCameraCaptureSession$capture$1(PersistentCameraCaptureSession persistentCameraCaptureSession, Continuation<? super PersistentCameraCaptureSession$capture$1> continuation) {
        super(continuation);
        this.this$0 = persistentCameraCaptureSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.capture(null, null, false, false, null, false, false, this);
    }
}
