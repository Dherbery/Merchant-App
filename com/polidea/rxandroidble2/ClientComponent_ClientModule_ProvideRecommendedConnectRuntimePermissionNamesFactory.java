package com.polidea.rxandroidble2;

import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent;

/* loaded from: classes5.dex */
public final class ClientComponent_ClientModule_ProvideRecommendedConnectRuntimePermissionNamesFactory implements Factory<String[][]> {
    private final Provider<Integer> deviceSdkProvider;
    private final Provider<Integer> targetSdkProvider;

    public ClientComponent_ClientModule_ProvideRecommendedConnectRuntimePermissionNamesFactory(Provider<Integer> provider, Provider<Integer> provider2) {
        this.deviceSdkProvider = provider;
        this.targetSdkProvider = provider2;
    }

    @Override // bleshadow.javax.inject.Provider
    public String[][] get() {
        return provideRecommendedConnectRuntimePermissionNames(this.deviceSdkProvider.get().intValue(), this.targetSdkProvider.get().intValue());
    }

    public static ClientComponent_ClientModule_ProvideRecommendedConnectRuntimePermissionNamesFactory create(Provider<Integer> provider, Provider<Integer> provider2) {
        return new ClientComponent_ClientModule_ProvideRecommendedConnectRuntimePermissionNamesFactory(provider, provider2);
    }

    public static String[][] provideRecommendedConnectRuntimePermissionNames(int i, int i2) {
        return (String[][]) Preconditions.checkNotNullFromProvides(ClientComponent.ClientModule.provideRecommendedConnectRuntimePermissionNames(i, i2));
    }
}
