package com.mrousavy.camera.extensions;

import android.hardware.camera2.CameraCaptureSession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraCaptureSession+tryAbortCaptures.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"tryAbortCaptures", "", "Landroid/hardware/camera2/CameraCaptureSession;", "react-native-vision-camera_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraCaptureSession_tryAbortCapturesKt {
    public static final void tryAbortCaptures(CameraCaptureSession cameraCaptureSession) {
        Intrinsics.checkNotNullParameter(cameraCaptureSession, "<this>");
        try {
            cameraCaptureSession.abortCaptures();
        } catch (Throwable unused) {
        }
    }
}
