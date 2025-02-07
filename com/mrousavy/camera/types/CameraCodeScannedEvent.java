package com.mrousavy.camera.types;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Events.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/mrousavy/camera/types/CameraCodeScannedEvent;", "Lcom/facebook/react/uimanager/events/Event;", "surfaceId", "", "viewId", "data", "Lcom/facebook/react/bridge/WritableMap;", "(IILcom/facebook/react/bridge/WritableMap;)V", "getEventData", "getEventName", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraCodeScannedEvent extends Event<CameraCodeScannedEvent> {
    private final WritableMap data;

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "cameraCodeScanned";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraCodeScannedEvent(int i, int i2, WritableMap data) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* renamed from: getEventData, reason: from getter */
    protected WritableMap getData() {
        return this.data;
    }
}
