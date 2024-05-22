package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothAdapter;
import bleshadow.dagger.internal.Factory;
import com.polidea.rxandroidble2.ClientComponent;

/* loaded from: classes5.dex */
public final class ClientComponent_ClientModule_ProvideBluetoothAdapterFactory implements Factory<BluetoothAdapter> {
    @Override // bleshadow.javax.inject.Provider
    public BluetoothAdapter get() {
        return provideBluetoothAdapter();
    }

    public static ClientComponent_ClientModule_ProvideBluetoothAdapterFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BluetoothAdapter provideBluetoothAdapter() {
        return ClientComponent.ClientModule.provideBluetoothAdapter();
    }

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {
        private static final ClientComponent_ClientModule_ProvideBluetoothAdapterFactory INSTANCE = new ClientComponent_ClientModule_ProvideBluetoothAdapterFactory();

        private InstanceHolder() {
        }
    }
}
