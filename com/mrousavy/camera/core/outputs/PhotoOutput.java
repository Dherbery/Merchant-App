package com.mrousavy.camera.core.outputs;

import android.media.ImageReader;
import android.util.Log;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.mrousavy.camera.utils.ImageFormatUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PhotoOutput.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/mrousavy/camera/core/outputs/PhotoOutput;", "Lcom/mrousavy/camera/core/outputs/SurfaceOutput;", "imageReader", "Landroid/media/ImageReader;", "enableHdr", "", "(Landroid/media/ImageReader;Z)V", "close", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public class PhotoOutput extends SurfaceOutput {
    private final ImageReader imageReader;

    public /* synthetic */ PhotoOutput(ImageReader imageReader, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageReader, (i & 2) != 0 ? false : z);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PhotoOutput(android.media.ImageReader r5, boolean r6) {
        /*
            r4 = this;
            java.lang.String r0 = "imageReader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.view.Surface r0 = r5.getSurface()
            java.lang.String r1 = "imageReader.surface"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.util.Size r1 = new android.util.Size
            int r2 = r5.getWidth()
            int r3 = r5.getHeight()
            r1.<init>(r2, r3)
            com.mrousavy.camera.core.outputs.SurfaceOutput$OutputType r2 = com.mrousavy.camera.core.outputs.SurfaceOutput.OutputType.PHOTO
            r4.<init>(r0, r1, r2, r6)
            r4.imageReader = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.outputs.PhotoOutput.<init>(android.media.ImageReader, boolean):void");
    }

    @Override // com.mrousavy.camera.core.outputs.SurfaceOutput, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Log.i(SurfaceOutput.TAG, "Closing " + this.imageReader.getWidth() + "x" + this.imageReader.getHeight() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getOutputType() + " ImageReader..");
        this.imageReader.close();
        super.close();
    }

    @Override // com.mrousavy.camera.core.outputs.SurfaceOutput
    public String toString() {
        return getOutputType() + " (" + getSize().getWidth() + "x" + getSize().getHeight() + " in " + ImageFormatUtils.INSTANCE.imageFormatToString(this.imageReader.getImageFormat()) + ")";
    }
}
