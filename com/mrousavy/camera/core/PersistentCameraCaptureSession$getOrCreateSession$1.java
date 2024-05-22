package com.mrousavy.camera.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PersistentCameraCaptureSession.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.mrousavy.camera.core.PersistentCameraCaptureSession", f = "PersistentCameraCaptureSession.kt", i = {0}, l = {349}, m = "getOrCreateSession", n = {"this"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class PersistentCameraCaptureSession$getOrCreateSession$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PersistentCameraCaptureSession this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentCameraCaptureSession$getOrCreateSession$1(PersistentCameraCaptureSession persistentCameraCaptureSession, Continuation<? super PersistentCameraCaptureSession$getOrCreateSession$1> continuation) {
        super(continuation);
        this.this$0 = persistentCameraCaptureSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object orCreateSession;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        orCreateSession = this.this$0.getOrCreateSession(null, null, this);
        return orCreateSession;
    }
}
