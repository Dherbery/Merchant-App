package com.polidea.rxandroidble2;

import android.content.Context;
import android.location.LocationManager;
import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent;

/* loaded from: classes5.dex */
public final class ClientComponent_ClientModule_ProvideLocationManagerFactory implements Factory<LocationManager> {
    private final Provider<Context> contextProvider;

    public ClientComponent_ClientModule_ProvideLocationManagerFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public LocationManager get() {
        return provideLocationManager(this.contextProvider.get());
    }

    public static ClientComponent_ClientModule_ProvideLocationManagerFactory create(Provider<Context> provider) {
        return new ClientComponent_ClientModule_ProvideLocationManagerFactory(provider);
    }

    public static LocationManager provideLocationManager(Context context) {
        return (LocationManager) Preconditions.checkNotNullFromProvides(ClientComponent.ClientModule.provideLocationManager(context));
    }
}
