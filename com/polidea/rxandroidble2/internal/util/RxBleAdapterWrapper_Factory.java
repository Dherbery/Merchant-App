package com.polidea.rxandroidble2.internal.util;

import android.bluetooth.BluetoothAdapter;
import bleshadow.dagger.internal.Factory;
import bleshadow.javax.inject.Provider;

/* loaded from: classes5.dex */
public final class RxBleAdapterWrapper_Factory implements Factory<RxBleAdapterWrapper> {
    private final Provider<BluetoothAdapter> bluetoothAdapterProvider;

    public RxBleAdapterWrapper_Factory(Provider<BluetoothAdapter> provider) {
        this.bluetoothAdapterProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public RxBleAdapterWrapper get() {
        return newInstance(this.bluetoothAdapterProvider.get());
    }

    public static RxBleAdapterWrapper_Factory create(Provider<BluetoothAdapter> provider) {
        return new RxBleAdapterWrapper_Factory(provider);
    }

    public static RxBleAdapterWrapper newInstance(BluetoothAdapter bluetoothAdapter) {
        return new RxBleAdapterWrapper(bluetoothAdapter);
    }
}
