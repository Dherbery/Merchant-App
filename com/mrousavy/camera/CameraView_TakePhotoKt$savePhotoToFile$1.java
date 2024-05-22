package com.mrousavy.camera;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraView+TakePhoto.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.mrousavy.camera.CameraView_TakePhotoKt", f = "CameraView+TakePhoto.kt", i = {}, l = {105}, m = "savePhotoToFile", n = {}, s = {})
/* loaded from: classes5.dex */
public final class CameraView_TakePhotoKt$savePhotoToFile$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraView_TakePhotoKt$savePhotoToFile$1(Continuation<? super CameraView_TakePhotoKt$savePhotoToFile$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object savePhotoToFile;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        savePhotoToFile = CameraView_TakePhotoKt.savePhotoToFile(null, null, null, this);
        return savePhotoToFile;
    }
}
