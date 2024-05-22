package com.bleplx.adapter;

/* loaded from: classes.dex */
public enum RefreshGattMoment {
    ON_CONNECTED("OnConnected");

    final String name;

    RefreshGattMoment(String str) {
        this.name = str;
    }

    public static RefreshGattMoment getByName(String str) {
        for (RefreshGattMoment refreshGattMoment : values()) {
            if (refreshGattMoment.name.equals(str)) {
                return refreshGattMoment;
            }
        }
        return null;
    }
}
