package com.polidea.rxandroidble2;

import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import com.polidea.rxandroidble2.ClientComponent;
import io.reactivex.Scheduler;

/* loaded from: classes5.dex */
public final class ClientComponent_ClientModule_ProvideComputationSchedulerFactory implements Factory<Scheduler> {
    @Override // bleshadow.javax.inject.Provider
    public Scheduler get() {
        return provideComputationScheduler();
    }

    public static ClientComponent_ClientModule_ProvideComputationSchedulerFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Scheduler provideComputationScheduler() {
        return (Scheduler) Preconditions.checkNotNullFromProvides(ClientComponent.ClientModule.provideComputationScheduler());
    }

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {
        private static final ClientComponent_ClientModule_ProvideComputationSchedulerFactory INSTANCE = new ClientComponent_ClientModule_ProvideComputationSchedulerFactory();

        private InstanceHolder() {
        }
    }
}
