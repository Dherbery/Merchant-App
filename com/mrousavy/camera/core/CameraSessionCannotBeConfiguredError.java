package com.mrousavy.camera.core;

import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraError.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/mrousavy/camera/core/CameraSessionCannotBeConfiguredError;", "Lcom/mrousavy/camera/core/CameraError;", "cameraId", "", "(Ljava/lang/String;)V", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraSessionCannotBeConfiguredError extends CameraError {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraSessionCannotBeConfiguredError(String cameraId) {
        super(OutcomeEventsTable.COLUMN_NAME_SESSION, "cannot-create-session", "Failed to create a Camera Session for Camera #" + cameraId + "!", null, 8, null);
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
    }
}
