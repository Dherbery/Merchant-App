package com.polidea.rxandroidble2.internal;

import android.bluetooth.BluetoothDevice;
import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;

/* loaded from: classes5.dex */
public final class DeviceModule_ProvideBluetoothDeviceFactory implements Factory<BluetoothDevice> {
    private final Provider<RxBleAdapterWrapper> adapterWrapperProvider;
    private final Provider<String> macAddressProvider;

    public DeviceModule_ProvideBluetoothDeviceFactory(Provider<String> provider, Provider<RxBleAdapterWrapper> provider2) {
        this.macAddressProvider = provider;
        this.adapterWrapperProvider = provider2;
    }

    @Override // bleshadow.javax.inject.Provider
    public BluetoothDevice get() {
        return provideBluetoothDevice(this.macAddressProvider.get(), this.adapterWrapperProvider.get());
    }

    public static DeviceModule_ProvideBluetoothDeviceFactory create(Provider<String> provider, Provider<RxBleAdapterWrapper> provider2) {
        return new DeviceModule_ProvideBluetoothDeviceFactory(provider, provider2);
    }

    public static BluetoothDevice provideBluetoothDevice(String str, RxBleAdapterWrapper rxBleAdapterWrapper) {
        return (BluetoothDevice) Preconditions.checkNotNullFromProvides(DeviceModule.provideBluetoothDevice(str, rxBleAdapterWrapper));
    }
}
