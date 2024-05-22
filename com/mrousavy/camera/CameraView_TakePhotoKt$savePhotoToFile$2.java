package com.mrousavy.camera;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.DngCreator;
import com.mrousavy.camera.core.CameraSession;
import com.mrousavy.camera.utils.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraView+TakePhoto.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.mrousavy.camera.CameraView_TakePhotoKt$savePhotoToFile$2", f = "CameraView+TakePhoto.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class CameraView_TakePhotoKt$savePhotoToFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ CameraCharacteristics $cameraCharacteristics;
    final /* synthetic */ Context $context;
    final /* synthetic */ CameraSession.CapturedPhoto $photo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraView_TakePhotoKt$savePhotoToFile$2(CameraSession.CapturedPhoto capturedPhoto, Context context, CameraCharacteristics cameraCharacteristics, Continuation<? super CameraView_TakePhotoKt$savePhotoToFile$2> continuation) {
        super(2, continuation);
        this.$photo = capturedPhoto;
        this.$context = context;
        this.$cameraCharacteristics = cameraCharacteristics;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CameraView_TakePhotoKt$savePhotoToFile$2(this.$photo, this.$context, this.$cameraCharacteristics, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((CameraView_TakePhotoKt$savePhotoToFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        int format = this.$photo.getFormat();
        if (format != 32) {
            if (format == 256 || format == 1768253795) {
                File createTempFile = FileUtils.INSTANCE.createTempFile(this.$context, ".jpg");
                CameraView_TakePhotoKt.writePhotoToFile(this.$photo, createTempFile);
                return createTempFile.getAbsolutePath();
            }
            throw new Error("Failed to save Photo to file, image format is not supported! " + this.$photo.getFormat());
        }
        DngCreator dngCreator = new DngCreator(this.$cameraCharacteristics, this.$photo.getMetadata());
        File createTempFile2 = FileUtils.INSTANCE.createTempFile(this.$context, ".dng");
        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile2);
        try {
            dngCreator.writeImage(fileOutputStream, this.$photo.getImage());
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
            return createTempFile2.getAbsolutePath();
        } finally {
        }
    }
}
