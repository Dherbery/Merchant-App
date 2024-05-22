package com.mrousavy.camera.core;

import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PersistentCameraCaptureSession.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.mrousavy.camera.core.PersistentCameraCaptureSession", f = "PersistentCameraCaptureSession.kt", i = {0, 0, 0, 1, 1, 2}, l = {385, JpegTranscoderUtils.DEFAULT_JPEG_QUALITY, 86}, m = "withConfiguration", n = {"this", "block", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
/* loaded from: classes5.dex */
public final class PersistentCameraCaptureSession$withConfiguration$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PersistentCameraCaptureSession this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentCameraCaptureSession$withConfiguration$1(PersistentCameraCaptureSession persistentCameraCaptureSession, Continuation<? super PersistentCameraCaptureSession$withConfiguration$1> continuation) {
        super(continuation);
        this.this$0 = persistentCameraCaptureSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.withConfiguration(null, this);
    }
}
