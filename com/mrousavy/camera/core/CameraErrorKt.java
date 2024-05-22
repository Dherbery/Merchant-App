package com.mrousavy.camera.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraError.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"code", "", "Lcom/mrousavy/camera/core/CameraError;", "getCode", "(Lcom/mrousavy/camera/core/CameraError;)Ljava/lang/String;", "react-native-vision-camera_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraErrorKt {
    public static final String getCode(CameraError cameraError) {
        Intrinsics.checkNotNullParameter(cameraError, "<this>");
        return cameraError.getDomain() + "/" + cameraError.getId();
    }
}
