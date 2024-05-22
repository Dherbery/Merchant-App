package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* loaded from: classes3.dex */
class ReactTextInputSelectionEvent extends Event<ReactTextInputSelectionEvent> {
    private static final String EVENT_NAME = "topSelectionChange";
    private int mSelectionEnd;
    private int mSelectionStart;

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return EVENT_NAME;
    }

    @Deprecated
    public ReactTextInputSelectionEvent(int i, int i2, int i3) {
        this(-1, i, i2, i3);
    }

    public ReactTextInputSelectionEvent(int i, int i2, int i3, int i4) {
        super(i, i2);
        this.mSelectionStart = i3;
        this.mSelectionEnd = i4;
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* renamed from: getEventData */
    protected WritableMap getEvent() {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putInt("end", this.mSelectionEnd);
        createMap2.putInt("start", this.mSelectionStart);
        createMap.putMap("selection", createMap2);
        return createMap;
    }
}
