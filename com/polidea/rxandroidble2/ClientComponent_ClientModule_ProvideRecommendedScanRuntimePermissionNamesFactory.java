package com.polidea.rxandroidble2;

import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent;

/* loaded from: classes5.dex */
public final class ClientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactory implements Factory<String[][]> {
    private final Provider<Integer> deviceSdkProvider;
    private final Provider<Boolean> isNearbyServicesNeverForLocationProvider;
    private final Provider<Integer> targetSdkProvider;

    public ClientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactory(Provider<Integer> provider, Provider<Integer> provider2, Provider<Boolean> provider3) {
        this.deviceSdkProvider = provider;
        this.targetSdkProvider = provider2;
        this.isNearbyServicesNeverForLocationProvider = provider3;
    }

    @Override // bleshadow.javax.inject.Provider
    public String[][] get() {
        return provideRecommendedScanRuntimePermissionNames(this.deviceSdkProvider.get().intValue(), this.targetSdkProvider.get().intValue(), this.isNearbyServicesNeverForLocationProvider.get().booleanValue());
    }

    public static ClientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactory create(Provider<Integer> provider, Provider<Integer> provider2, Provider<Boolean> provider3) {
        return new ClientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactory(provider, provider2, provider3);
    }

    public static String[][] provideRecommendedScanRuntimePermissionNames(int i, int i2, boolean z) {
        return (String[][]) Preconditions.checkNotNullFromProvides(ClientComponent.ClientModule.provideRecommendedScanRuntimePermissionNames(i, i2, z));
    }
}
