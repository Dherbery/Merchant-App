package com.polidea.rxandroidble2.internal.connection;

import bleshadow.dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class BluetoothGattProvider_Factory implements Factory<BluetoothGattProvider> {
    @Override // bleshadow.javax.inject.Provider
    public BluetoothGattProvider get() {
        return newInstance();
    }

    public static BluetoothGattProvider_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BluetoothGattProvider newInstance() {
        return new BluetoothGattProvider();
    }

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {
        private static final BluetoothGattProvider_Factory INSTANCE = new BluetoothGattProvider_Factory();

        private InstanceHolder() {
        }
    }
}
