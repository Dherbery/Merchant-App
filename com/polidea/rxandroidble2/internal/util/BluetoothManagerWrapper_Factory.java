package com.polidea.rxandroidble2.internal.util;

import android.bluetooth.BluetoothManager;
import bleshadow.dagger.internal.Factory;
import bleshadow.javax.inject.Provider;

/* loaded from: classes5.dex */
public final class BluetoothManagerWrapper_Factory implements Factory<BluetoothManagerWrapper> {
    private final Provider<BluetoothManager> bluetoothManagerProvider;

    public BluetoothManagerWrapper_Factory(Provider<BluetoothManager> provider) {
        this.bluetoothManagerProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public BluetoothManagerWrapper get() {
        return newInstance(this.bluetoothManagerProvider.get());
    }

    public static BluetoothManagerWrapper_Factory create(Provider<BluetoothManager> provider) {
        return new BluetoothManagerWrapper_Factory(provider);
    }

    public static BluetoothManagerWrapper newInstance(BluetoothManager bluetoothManager) {
        return new BluetoothManagerWrapper(bluetoothManager);
    }
}
