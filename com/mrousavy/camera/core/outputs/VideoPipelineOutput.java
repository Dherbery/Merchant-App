package com.mrousavy.camera.core.outputs;

import android.util.Log;
import android.util.Size;
import com.mrousavy.camera.core.VideoPipeline;
import com.mrousavy.camera.core.outputs.SurfaceOutput;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoPipelineOutput.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/mrousavy/camera/core/outputs/VideoPipelineOutput;", "Lcom/mrousavy/camera/core/outputs/SurfaceOutput;", "Ljava/io/Closeable;", "videoPipeline", "Lcom/mrousavy/camera/core/VideoPipeline;", "enableHdr", "", "(Lcom/mrousavy/camera/core/VideoPipeline;Z)V", "getVideoPipeline", "()Lcom/mrousavy/camera/core/VideoPipeline;", "close", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoPipelineOutput extends SurfaceOutput implements Closeable {
    private final VideoPipeline videoPipeline;

    public /* synthetic */ VideoPipelineOutput(VideoPipeline videoPipeline, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(videoPipeline, (i & 2) != 0 ? false : z);
    }

    public final VideoPipeline getVideoPipeline() {
        return this.videoPipeline;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPipelineOutput(VideoPipeline videoPipeline, boolean z) {
        super(videoPipeline.getSurface(), new Size(videoPipeline.getWidth(), videoPipeline.getHeight()), SurfaceOutput.OutputType.VIDEO, z);
        Intrinsics.checkNotNullParameter(videoPipeline, "videoPipeline");
        this.videoPipeline = videoPipeline;
    }

    @Override // com.mrousavy.camera.core.outputs.SurfaceOutput, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Log.i(SurfaceOutput.TAG, "Closing " + this.videoPipeline.getWidth() + "x" + this.videoPipeline.getHeight() + " Video Pipeline..");
        this.videoPipeline.close();
        super.close();
    }

    @Override // com.mrousavy.camera.core.outputs.SurfaceOutput
    public String toString() {
        return getOutputType() + " (" + getSize().getWidth() + "x" + getSize().getHeight() + " in " + this.videoPipeline.getFormat() + ")";
    }
}
