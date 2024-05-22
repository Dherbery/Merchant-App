package com.mrousavy.camera.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraSession.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.mrousavy.camera.core.CameraSession", f = "CameraSession.kt", i = {0, 0, 0, 0, 0, 0}, l = {505}, m = "startRecording", n = {"this", "options", "callback", "onError", "$this$withLock_u24default$iv", "enableAudio"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"})
/* loaded from: classes5.dex */
public final class CameraSession$startRecording$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CameraSession this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraSession$startRecording$1(CameraSession cameraSession, Continuation<? super CameraSession$startRecording$1> continuation) {
        super(continuation);
        this.this$0 = cameraSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.startRecording(false, null, null, null, this);
    }
}
