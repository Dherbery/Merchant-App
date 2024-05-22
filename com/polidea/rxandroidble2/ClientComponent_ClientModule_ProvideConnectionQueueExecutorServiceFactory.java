package com.polidea.rxandroidble2;

import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import com.polidea.rxandroidble2.ClientComponent;
import java.util.concurrent.ExecutorService;

/* loaded from: classes5.dex */
public final class ClientComponent_ClientModule_ProvideConnectionQueueExecutorServiceFactory implements Factory<ExecutorService> {
    @Override // bleshadow.javax.inject.Provider
    public ExecutorService get() {
        return provideConnectionQueueExecutorService();
    }

    public static ClientComponent_ClientModule_ProvideConnectionQueueExecutorServiceFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ExecutorService provideConnectionQueueExecutorService() {
        return (ExecutorService) Preconditions.checkNotNullFromProvides(ClientComponent.ClientModule.provideConnectionQueueExecutorService());
    }

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {
        private static final ClientComponent_ClientModule_ProvideConnectionQueueExecutorServiceFactory INSTANCE = new ClientComponent_ClientModule_ProvideConnectionQueueExecutorServiceFactory();

        private InstanceHolder() {
        }
    }
}
