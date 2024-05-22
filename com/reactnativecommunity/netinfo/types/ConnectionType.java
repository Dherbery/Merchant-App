package com.reactnativecommunity.netinfo.types;

import androidx.core.os.EnvironmentCompat;

/* loaded from: classes5.dex */
public enum ConnectionType {
    BLUETOOTH("bluetooth"),
    CELLULAR("cellular"),
    ETHERNET("ethernet"),
    NONE("none"),
    UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN),
    WIFI("wifi"),
    WIMAX("wimax"),
    VPN("vpn");

    public final String label;

    ConnectionType(String str) {
        this.label = str;
    }
}
