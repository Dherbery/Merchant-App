package com.mrousavy.camera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.mrousavy.camera.core.CameraSession;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraView+TakePhoto.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u001d\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"TAG", "", "savePhotoToFile", "context", "Landroid/content/Context;", "cameraCharacteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "photo", "Lcom/mrousavy/camera/core/CameraSession$CapturedPhoto;", "(Landroid/content/Context;Landroid/hardware/camera2/CameraCharacteristics;Lcom/mrousavy/camera/core/CameraSession$CapturedPhoto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writePhotoToFile", "", "file", "Ljava/io/File;", "takePhoto", "Lcom/facebook/react/bridge/WritableMap;", "Lcom/mrousavy/camera/CameraView;", "optionsMap", "Lcom/facebook/react/bridge/ReadableMap;", "(Lcom/mrousavy/camera/CameraView;Lcom/facebook/react/bridge/ReadableMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-vision-camera_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraView_TakePhotoKt {
    private static final String TAG = "CameraView.takePhoto";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01df A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:13:0x003a, B:36:0x01c7, B:38:0x01cd, B:42:0x01df, B:43:0x01e4, B:44:0x01e5), top: B:7:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01e5 A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #0 {all -> 0x0042, blocks: (B:13:0x003a, B:36:0x01c7, B:38:0x01cd, B:42:0x01df, B:43:0x01e4, B:44:0x01e5), top: B:7:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0160 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object takePhoto(com.mrousavy.camera.CameraView r16, com.facebook.react.bridge.ReadableMap r17, kotlin.coroutines.Continuation<? super com.facebook.react.bridge.WritableMap> r18) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.CameraView_TakePhotoKt.takePhoto(com.mrousavy.camera.CameraView, com.facebook.react.bridge.ReadableMap, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void writePhotoToFile(CameraSession.CapturedPhoto capturedPhoto, File file) {
        ByteBuffer buffer = capturedPhoto.getImage().getPlanes()[0].getBuffer();
        if (capturedPhoto.isMirrored()) {
            int remaining = buffer.remaining();
            byte[] bArr = new byte[remaining];
            buffer.get(bArr);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, remaining);
            Matrix matrix = new Matrix();
            matrix.preScale(-1.0f, 1.0f);
            Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, false);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(bitmap, 0, …ap.height, matrix, false)");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                CloseableKt.closeFinally(fileOutputStream, null);
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileOutputStream, th);
                    throw th2;
                }
            }
        }
        FileChannel channel = new FileOutputStream(file).getChannel();
        channel.write(buffer);
        channel.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object savePhotoToFile(android.content.Context r5, android.hardware.camera2.CameraCharacteristics r6, com.mrousavy.camera.core.CameraSession.CapturedPhoto r7, kotlin.coroutines.Continuation<? super java.lang.String> r8) {
        /*
            boolean r0 = r8 instanceof com.mrousavy.camera.CameraView_TakePhotoKt$savePhotoToFile$1
            if (r0 == 0) goto L14
            r0 = r8
            com.mrousavy.camera.CameraView_TakePhotoKt$savePhotoToFile$1 r0 = (com.mrousavy.camera.CameraView_TakePhotoKt$savePhotoToFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.mrousavy.camera.CameraView_TakePhotoKt$savePhotoToFile$1 r0 = new com.mrousavy.camera.CameraView_TakePhotoKt$savePhotoToFile$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4c
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            com.mrousavy.camera.CameraView_TakePhotoKt$savePhotoToFile$2 r2 = new com.mrousavy.camera.CameraView_TakePhotoKt$savePhotoToFile$2
            r4 = 0
            r2.<init>(r7, r5, r6, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)
            if (r8 != r1) goto L4c
            return r1
        L4c:
            java.lang.String r5 = "context: Context,\n  came…rmat}\")\n      }\n    }\n  }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.CameraView_TakePhotoKt.savePhotoToFile(android.content.Context, android.hardware.camera2.CameraCharacteristics, com.mrousavy.camera.core.CameraSession$CapturedPhoto, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
