package com.polidea.rxandroidble2;

import bleshadow.dagger.internal.Factory;
import com.polidea.rxandroidble2.ClientComponent;

/* loaded from: classes5.dex */
public final class ClientComponent_ClientModule_ProvideDeviceSdkFactory implements Factory<Integer> {
    @Override // bleshadow.javax.inject.Provider
    public Integer get() {
        return Integer.valueOf(provideDeviceSdk());
    }

    public static ClientComponent_ClientModule_ProvideDeviceSdkFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static int provideDeviceSdk() {
        return ClientComponent.ClientModule.provideDeviceSdk();
    }

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {
        private static final ClientComponent_ClientModule_ProvideDeviceSdkFactory INSTANCE = new ClientComponent_ClientModule_ProvideDeviceSdkFactory();

        private InstanceHolder() {
        }
    }
}
