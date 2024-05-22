package com.mrousavy.camera.core;

import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PersistentCameraCaptureSession.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.mrousavy.camera.core.PersistentCameraCaptureSession", f = "PersistentCameraCaptureSession.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {385, 243}, m = "focus", n = {"this", "point", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "repeatingRequest", OutcomeEventsTable.COLUMN_NAME_SESSION, "device", "deviceDetails", "outputs"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
/* loaded from: classes5.dex */
public final class PersistentCameraCaptureSession$focus$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PersistentCameraCaptureSession this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentCameraCaptureSession$focus$1(PersistentCameraCaptureSession persistentCameraCaptureSession, Continuation<? super PersistentCameraCaptureSession$focus$1> continuation) {
        super(continuation);
        this.this$0 = persistentCameraCaptureSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.focus(null, this);
    }
}
