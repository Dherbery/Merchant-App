package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import bleshadow.javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ConnectionModule_ProvideBluetoothGattFactory implements Factory<BluetoothGatt> {
    private final Provider<BluetoothGattProvider> bluetoothGattProvider;

    public ConnectionModule_ProvideBluetoothGattFactory(Provider<BluetoothGattProvider> provider) {
        this.bluetoothGattProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public BluetoothGatt get() {
        return provideBluetoothGatt(this.bluetoothGattProvider.get());
    }

    public static ConnectionModule_ProvideBluetoothGattFactory create(Provider<BluetoothGattProvider> provider) {
        return new ConnectionModule_ProvideBluetoothGattFactory(provider);
    }

    public static BluetoothGatt provideBluetoothGatt(BluetoothGattProvider bluetoothGattProvider) {
        return (BluetoothGatt) Preconditions.checkNotNullFromProvides(ConnectionModule.provideBluetoothGatt(bluetoothGattProvider));
    }
}
