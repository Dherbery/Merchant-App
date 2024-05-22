package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent;

/* loaded from: classes5.dex */
public final class ClientComponent_ClientModule_ProvideBluetoothManagerFactory implements Factory<BluetoothManager> {
    private final Provider<Context> contextProvider;

    public ClientComponent_ClientModule_ProvideBluetoothManagerFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public BluetoothManager get() {
        return provideBluetoothManager(this.contextProvider.get());
    }

    public static ClientComponent_ClientModule_ProvideBluetoothManagerFactory create(Provider<Context> provider) {
        return new ClientComponent_ClientModule_ProvideBluetoothManagerFactory(provider);
    }

    public static BluetoothManager provideBluetoothManager(Context context) {
        return (BluetoothManager) Preconditions.checkNotNullFromProvides(ClientComponent.ClientModule.provideBluetoothManager(context));
    }
}
