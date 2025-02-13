package com.facebook.react.views.modal;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* loaded from: classes3.dex */
class ShowEvent extends Event<ShowEvent> {
    public static final String EVENT_NAME = "topShow";

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return EVENT_NAME;
    }

    @Deprecated
    protected ShowEvent(int i) {
        this(-1, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShowEvent(int i, int i2) {
        super(i, i2);
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* renamed from: getEventData */
    protected WritableMap getEvent() {
        return Arguments.createMap();
    }
}
