package com.polidea.rxandroidble2.internal.util;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import bleshadow.javax.inject.Inject;
import java.util.List;

/* loaded from: classes5.dex */
public class BluetoothManagerWrapper {
    private final BluetoothManager bluetoothManager;

    @Inject
    public BluetoothManagerWrapper(BluetoothManager bluetoothManager) {
        this.bluetoothManager = bluetoothManager;
    }

    public List<BluetoothDevice> getConnectedPeripherals() {
        return this.bluetoothManager.getConnectedDevices(8);
    }
}
