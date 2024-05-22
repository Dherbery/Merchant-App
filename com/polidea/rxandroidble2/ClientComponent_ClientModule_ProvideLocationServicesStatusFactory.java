package com.polidea.rxandroidble2;

import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatus;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi18;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi23;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi31;

/* loaded from: classes5.dex */
public final class ClientComponent_ClientModule_ProvideLocationServicesStatusFactory implements Factory<LocationServicesStatus> {
    private final Provider<Integer> deviceSdkProvider;
    private final Provider<LocationServicesStatusApi18> locationServicesStatusApi18Provider;
    private final Provider<LocationServicesStatusApi23> locationServicesStatusApi23Provider;
    private final Provider<LocationServicesStatusApi31> locationServicesStatusApi31Provider;

    public ClientComponent_ClientModule_ProvideLocationServicesStatusFactory(Provider<Integer> provider, Provider<LocationServicesStatusApi18> provider2, Provider<LocationServicesStatusApi23> provider3, Provider<LocationServicesStatusApi31> provider4) {
        this.deviceSdkProvider = provider;
        this.locationServicesStatusApi18Provider = provider2;
        this.locationServicesStatusApi23Provider = provider3;
        this.locationServicesStatusApi31Provider = provider4;
    }

    @Override // bleshadow.javax.inject.Provider
    public LocationServicesStatus get() {
        return provideLocationServicesStatus(this.deviceSdkProvider.get().intValue(), this.locationServicesStatusApi18Provider, this.locationServicesStatusApi23Provider, this.locationServicesStatusApi31Provider);
    }

    public static ClientComponent_ClientModule_ProvideLocationServicesStatusFactory create(Provider<Integer> provider, Provider<LocationServicesStatusApi18> provider2, Provider<LocationServicesStatusApi23> provider3, Provider<LocationServicesStatusApi31> provider4) {
        return new ClientComponent_ClientModule_ProvideLocationServicesStatusFactory(provider, provider2, provider3, provider4);
    }

    public static LocationServicesStatus provideLocationServicesStatus(int i, Provider<LocationServicesStatusApi18> provider, Provider<LocationServicesStatusApi23> provider2, Provider<LocationServicesStatusApi31> provider3) {
        return (LocationServicesStatus) Preconditions.checkNotNullFromProvides(ClientComponent.ClientModule.provideLocationServicesStatus(i, provider, provider2, provider3));
    }
}
