package com.mrousavy.camera.core;

import com.mrousavy.camera.types.CameraDeviceError;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraError.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/core/CameraCannotBeOpenedError;", "Lcom/mrousavy/camera/core/CameraError;", "cameraId", "", "error", "Lcom/mrousavy/camera/types/CameraDeviceError;", "(Ljava/lang/String;Lcom/mrousavy/camera/types/CameraDeviceError;)V", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraCannotBeOpenedError extends CameraError {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraCannotBeOpenedError(String cameraId, CameraDeviceError error) {
        super(OutcomeEventsTable.COLUMN_NAME_SESSION, "camera-cannot-be-opened", "The given Camera device (id: " + cameraId + ") could not be opened! Error: " + error, null, 8, null);
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(error, "error");
    }
}
