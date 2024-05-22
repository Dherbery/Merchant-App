package com.polidea.rxandroidble2;

import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import com.polidea.rxandroidble2.ClientComponent;
import java.util.concurrent.ExecutorService;

/* loaded from: classes5.dex */
public final class ClientComponent_ClientModule_ProvideBluetoothInteractionExecutorServiceFactory implements Factory<ExecutorService> {
    @Override // bleshadow.javax.inject.Provider
    public ExecutorService get() {
        return provideBluetoothInteractionExecutorService();
    }

    public static ClientComponent_ClientModule_ProvideBluetoothInteractionExecutorServiceFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ExecutorService provideBluetoothInteractionExecutorService() {
        return (ExecutorService) Preconditions.checkNotNullFromProvides(ClientComponent.ClientModule.provideBluetoothInteractionExecutorService());
    }

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {
        private static final ClientComponent_ClientModule_ProvideBluetoothInteractionExecutorServiceFactory INSTANCE = new ClientComponent_ClientModule_ProvideBluetoothInteractionExecutorServiceFactory();

        private InstanceHolder() {
        }
    }
}
