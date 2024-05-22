package com.polidea.rxandroidble2;

import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import com.polidea.rxandroidble2.ClientComponent;

/* loaded from: classes5.dex */
public final class ClientComponent_ClientModule_ProvideDisableNotificationValueFactory implements Factory<byte[]> {
    @Override // bleshadow.javax.inject.Provider
    public byte[] get() {
        return provideDisableNotificationValue();
    }

    public static ClientComponent_ClientModule_ProvideDisableNotificationValueFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static byte[] provideDisableNotificationValue() {
        return (byte[]) Preconditions.checkNotNullFromProvides(ClientComponent.ClientModule.provideDisableNotificationValue());
    }

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {
        private static final ClientComponent_ClientModule_ProvideDisableNotificationValueFactory INSTANCE = new ClientComponent_ClientModule_ProvideDisableNotificationValueFactory();

        private InstanceHolder() {
        }
    }
}
