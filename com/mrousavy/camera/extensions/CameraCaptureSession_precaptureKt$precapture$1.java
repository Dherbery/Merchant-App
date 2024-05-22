package com.mrousavy.camera.extensions;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraCaptureSession+precapture.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.mrousavy.camera.extensions.CameraCaptureSession_precaptureKt", f = "CameraCaptureSession+precapture.kt", i = {0, 0, 0, 0, 0}, l = {55, 143}, m = "precapture", n = {"$this$precapture", "request", "deviceDetails", "options", "precaptureModes"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: classes5.dex */
public final class CameraCaptureSession_precaptureKt$precapture$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraCaptureSession_precaptureKt$precapture$1(Continuation<? super CameraCaptureSession_precaptureKt$precapture$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return CameraCaptureSession_precaptureKt.precapture(null, null, null, null, this);
    }
}
