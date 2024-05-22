package com.bleplx;

/* loaded from: classes.dex */
public enum Event {
    ScanEvent("ScanEvent"),
    ReadEvent("ReadEvent"),
    StateChangeEvent("StateChangeEvent"),
    RestoreStateEvent("RestoreStateEvent"),
    DisconnectionEvent("DisconnectionEvent");

    public String name;

    Event(String str) {
        this.name = str;
    }
}
