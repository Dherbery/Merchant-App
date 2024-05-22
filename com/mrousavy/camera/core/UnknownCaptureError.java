package com.mrousavy.camera.core;

import androidx.core.os.EnvironmentCompat;
import kotlin.Metadata;

/* compiled from: CameraError.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/mrousavy/camera/core/UnknownCaptureError;", "Lcom/mrousavy/camera/core/CameraError;", "wasImageCaptured", "", "(Z)V", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UnknownCaptureError extends CameraError {
    public UnknownCaptureError(boolean z) {
        super("capture", EnvironmentCompat.MEDIA_UNKNOWN, "An unknown error occurred while trying to capture an Image! Was Image captured: " + z, null, 8, null);
    }
}
