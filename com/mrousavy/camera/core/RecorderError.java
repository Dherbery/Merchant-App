package com.mrousavy.camera.core;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraError.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/core/RecorderError;", "Lcom/mrousavy/camera/core/CameraError;", "name", "", "extra", "", "(Ljava/lang/String;I)V", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecorderError extends CameraError {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecorderError(String name, int i) {
        super("capture", "recorder-error", "An error occured while recording a video! " + name + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + i, null, 8, null);
        Intrinsics.checkNotNullParameter(name, "name");
    }
}
