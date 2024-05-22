package com.polidea.rxandroidble2;

import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import com.polidea.rxandroidble2.ClientComponent;
import io.reactivex.Scheduler;

/* loaded from: classes5.dex */
public final class ClientComponent_ClientModule_ProvideBluetoothCallbacksSchedulerFactory implements Factory<Scheduler> {
    @Override // bleshadow.javax.inject.Provider
    public Scheduler get() {
        return provideBluetoothCallbacksScheduler();
    }

    public static ClientComponent_ClientModule_ProvideBluetoothCallbacksSchedulerFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Scheduler provideBluetoothCallbacksScheduler() {
        return (Scheduler) Preconditions.checkNotNullFromProvides(ClientComponent.ClientModule.provideBluetoothCallbacksScheduler());
    }

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {
        private static final ClientComponent_ClientModule_ProvideBluetoothCallbacksSchedulerFactory INSTANCE = new ClientComponent_ClientModule_ProvideBluetoothCallbacksSchedulerFactory();

        private InstanceHolder() {
        }
    }
}
