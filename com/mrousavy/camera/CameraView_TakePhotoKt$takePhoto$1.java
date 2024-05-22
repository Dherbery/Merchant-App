package com.mrousavy.camera;

import com.facebook.soloader.Elf64_Ehdr;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraView+TakePhoto.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.mrousavy.camera.CameraView_TakePhotoKt", f = "CameraView+TakePhoto.kt", i = {0, 1}, l = {43, Elf64_Ehdr.e_shentsize}, m = "takePhoto", n = {"$this$takePhoto", "photo"}, s = {"L$0", "L$0"})
/* loaded from: classes5.dex */
public final class CameraView_TakePhotoKt$takePhoto$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraView_TakePhotoKt$takePhoto$1(Continuation<? super CameraView_TakePhotoKt$takePhoto$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return CameraView_TakePhotoKt.takePhoto(null, null, this);
    }
}
