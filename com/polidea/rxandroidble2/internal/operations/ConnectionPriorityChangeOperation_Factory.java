package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import bleshadow.dagger.internal.Factory;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;

/* loaded from: classes5.dex */
public final class ConnectionPriorityChangeOperation_Factory implements Factory<ConnectionPriorityChangeOperation> {
    private final Provider<BluetoothGatt> bluetoothGattProvider;
    private final Provider<Integer> connectionPriorityProvider;
    private final Provider<RxBleGattCallback> rxBleGattCallbackProvider;
    private final Provider<TimeoutConfiguration> successTimeoutConfigurationProvider;
    private final Provider<TimeoutConfiguration> timeoutConfigurationProvider;

    public ConnectionPriorityChangeOperation_Factory(Provider<RxBleGattCallback> provider, Provider<BluetoothGatt> provider2, Provider<TimeoutConfiguration> provider3, Provider<Integer> provider4, Provider<TimeoutConfiguration> provider5) {
        this.rxBleGattCallbackProvider = provider;
        this.bluetoothGattProvider = provider2;
        this.timeoutConfigurationProvider = provider3;
        this.connectionPriorityProvider = provider4;
        this.successTimeoutConfigurationProvider = provider5;
    }

    @Override // bleshadow.javax.inject.Provider
    public ConnectionPriorityChangeOperation get() {
        return newInstance(this.rxBleGattCallbackProvider.get(), this.bluetoothGattProvider.get(), this.timeoutConfigurationProvider.get(), this.connectionPriorityProvider.get().intValue(), this.successTimeoutConfigurationProvider.get());
    }

    public static ConnectionPriorityChangeOperation_Factory create(Provider<RxBleGattCallback> provider, Provider<BluetoothGatt> provider2, Provider<TimeoutConfiguration> provider3, Provider<Integer> provider4, Provider<TimeoutConfiguration> provider5) {
        return new ConnectionPriorityChangeOperation_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ConnectionPriorityChangeOperation newInstance(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, TimeoutConfiguration timeoutConfiguration, int i, TimeoutConfiguration timeoutConfiguration2) {
        return new ConnectionPriorityChangeOperation(rxBleGattCallback, bluetoothGatt, timeoutConfiguration, i, timeoutConfiguration2);
    }
}
