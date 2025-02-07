package com.bleplx.adapter.exceptions;

import com.bleplx.adapter.Characteristic;

/* loaded from: classes.dex */
public class CannotMonitorCharacteristicException extends RuntimeException {
    private Characteristic characteristic;

    public CannotMonitorCharacteristicException(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    public Characteristic getCharacteristic() {
        return this.characteristic;
    }
}
