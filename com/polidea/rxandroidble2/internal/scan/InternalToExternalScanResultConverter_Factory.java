package com.polidea.rxandroidble2.internal.scan;

import bleshadow.dagger.internal.Factory;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.RxBleDeviceProvider;

/* loaded from: classes5.dex */
public final class InternalToExternalScanResultConverter_Factory implements Factory<InternalToExternalScanResultConverter> {
    private final Provider<RxBleDeviceProvider> deviceProvider;

    public InternalToExternalScanResultConverter_Factory(Provider<RxBleDeviceProvider> provider) {
        this.deviceProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public InternalToExternalScanResultConverter get() {
        return newInstance(this.deviceProvider.get());
    }

    public static InternalToExternalScanResultConverter_Factory create(Provider<RxBleDeviceProvider> provider) {
        return new InternalToExternalScanResultConverter_Factory(provider);
    }

    public static InternalToExternalScanResultConverter newInstance(RxBleDeviceProvider rxBleDeviceProvider) {
        return new InternalToExternalScanResultConverter(rxBleDeviceProvider);
    }
}
