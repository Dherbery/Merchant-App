package com.mrousavy.camera.core.outputs;

import android.util.Log;
import com.mrousavy.camera.core.CodeScannerPipeline;
import com.mrousavy.camera.core.outputs.SurfaceOutput;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BarcodeScannerOutput.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/mrousavy/camera/core/outputs/BarcodeScannerOutput;", "Lcom/mrousavy/camera/core/outputs/SurfaceOutput;", "Ljava/io/Closeable;", "codeScannerPipeline", "Lcom/mrousavy/camera/core/CodeScannerPipeline;", "(Lcom/mrousavy/camera/core/CodeScannerPipeline;)V", "close", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BarcodeScannerOutput extends SurfaceOutput implements Closeable {
    private final CodeScannerPipeline codeScannerPipeline;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BarcodeScannerOutput(CodeScannerPipeline codeScannerPipeline) {
        super(codeScannerPipeline.getSurface(), codeScannerPipeline.getSize(), SurfaceOutput.OutputType.VIDEO, false, 8, null);
        Intrinsics.checkNotNullParameter(codeScannerPipeline, "codeScannerPipeline");
        this.codeScannerPipeline = codeScannerPipeline;
    }

    @Override // com.mrousavy.camera.core.outputs.SurfaceOutput, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Log.i(SurfaceOutput.TAG, "Closing BarcodeScanner..");
        this.codeScannerPipeline.close();
        super.close();
    }

    @Override // com.mrousavy.camera.core.outputs.SurfaceOutput
    public String toString() {
        return getOutputType() + " (" + this.codeScannerPipeline + ")";
    }
}
