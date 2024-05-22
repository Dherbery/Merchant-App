package com.polidea.rxandroidble2;

import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import com.polidea.rxandroidble2.ClientComponent;

/* loaded from: classes5.dex */
public final class ClientComponent_ClientModule_ProvideEnableIndicationValueFactory implements Factory<byte[]> {
    @Override // bleshadow.javax.inject.Provider
    public byte[] get() {
        return provideEnableIndicationValue();
    }

    public static ClientComponent_ClientModule_ProvideEnableIndicationValueFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static byte[] provideEnableIndicationValue() {
        return (byte[]) Preconditions.checkNotNullFromProvides(ClientComponent.ClientModule.provideEnableIndicationValue());
    }

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {
        private static final ClientComponent_ClientModule_ProvideEnableIndicationValueFactory INSTANCE = new ClientComponent_ClientModule_ProvideEnableIndicationValueFactory();

        private InstanceHolder() {
        }
    }
}
