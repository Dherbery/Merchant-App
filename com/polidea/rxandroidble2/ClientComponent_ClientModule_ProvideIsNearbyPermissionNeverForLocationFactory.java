package com.polidea.rxandroidble2;

import android.content.Context;
import bleshadow.dagger.internal.Factory;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent;

/* loaded from: classes5.dex */
public final class ClientComponent_ClientModule_ProvideIsNearbyPermissionNeverForLocationFactory implements Factory<Boolean> {
    private final Provider<Context> contextProvider;

    public ClientComponent_ClientModule_ProvideIsNearbyPermissionNeverForLocationFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provideIsNearbyPermissionNeverForLocation(this.contextProvider.get()));
    }

    public static ClientComponent_ClientModule_ProvideIsNearbyPermissionNeverForLocationFactory create(Provider<Context> provider) {
        return new ClientComponent_ClientModule_ProvideIsNearbyPermissionNeverForLocationFactory(provider);
    }

    public static boolean provideIsNearbyPermissionNeverForLocation(Context context) {
        return ClientComponent.ClientModule.provideIsNearbyPermissionNeverForLocation(context);
    }
}
