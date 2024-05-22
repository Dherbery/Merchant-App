package io.invertase.googlemobileads;

import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnNativeEvent.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/invertase/googlemobileads/OnNativeEvent;", "Lcom/facebook/react/uimanager/events/Event;", "viewId", "", NotificationCompat.CATEGORY_EVENT, "Lcom/facebook/react/bridge/WritableMap;", "(ILcom/facebook/react/bridge/WritableMap;)V", "getCoalescingKey", "", "getEventData", "getEventName", "", "Companion", "react-native-google-mobile-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OnNativeEvent extends Event<OnNativeEvent> {
    public static final String EVENT_NAME = "topNative";
    private final WritableMap event;

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return EVENT_NAME;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnNativeEvent(int i, WritableMap event) {
        super(i);
        Intrinsics.checkNotNullParameter(event, "event");
        this.event = event;
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* renamed from: getEventData, reason: from getter */
    protected WritableMap getEvent() {
        return this.event;
    }
}
