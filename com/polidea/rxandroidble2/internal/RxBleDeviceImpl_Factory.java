package com.polidea.rxandroidble2.internal;

import android.bluetooth.BluetoothDevice;
import bleshadow.dagger.internal.Factory;
import bleshadow.javax.inject.Provider;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.internal.connection.Connector;
import com.polidea.rxandroidble2.internal.util.CheckerConnectPermission;

/* loaded from: classes5.dex */
public final class RxBleDeviceImpl_Factory implements Factory<RxBleDeviceImpl> {
    private final Provider<BluetoothDevice> bluetoothDeviceProvider;
    private final Provider<CheckerConnectPermission> checkerConnectPermissionProvider;
    private final Provider<BehaviorRelay<RxBleConnection.RxBleConnectionState>> connectionStateRelayProvider;
    private final Provider<Connector> connectorProvider;

    public RxBleDeviceImpl_Factory(Provider<BluetoothDevice> provider, Provider<Connector> provider2, Provider<BehaviorRelay<RxBleConnection.RxBleConnectionState>> provider3, Provider<CheckerConnectPermission> provider4) {
        this.bluetoothDeviceProvider = provider;
        this.connectorProvider = provider2;
        this.connectionStateRelayProvider = provider3;
        this.checkerConnectPermissionProvider = provider4;
    }

    @Override // bleshadow.javax.inject.Provider
    public RxBleDeviceImpl get() {
        return newInstance(this.bluetoothDeviceProvider.get(), this.connectorProvider.get(), this.connectionStateRelayProvider.get(), this.checkerConnectPermissionProvider.get());
    }

    public static RxBleDeviceImpl_Factory create(Provider<BluetoothDevice> provider, Provider<Connector> provider2, Provider<BehaviorRelay<RxBleConnection.RxBleConnectionState>> provider3, Provider<CheckerConnectPermission> provider4) {
        return new RxBleDeviceImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static RxBleDeviceImpl newInstance(BluetoothDevice bluetoothDevice, Connector connector, BehaviorRelay<RxBleConnection.RxBleConnectionState> behaviorRelay, CheckerConnectPermission checkerConnectPermission) {
        return new RxBleDeviceImpl(bluetoothDevice, connector, behaviorRelay, checkerConnectPermission);
    }
}
