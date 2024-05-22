package com.polidea.rxandroidble2.internal.util;

import bleshadow.dagger.internal.Factory;
import bleshadow.javax.inject.Provider;

/* loaded from: classes5.dex */
public final class LocationServicesStatusApi31_Factory implements Factory<LocationServicesStatusApi31> {
    private final Provider<CheckerLocationProvider> checkerLocationProvider;
    private final Provider<CheckerScanPermission> checkerScanPermissionProvider;
    private final Provider<Boolean> isAndroidWearProvider;
    private final Provider<Boolean> isNearbyPermissionNeverForLocProvider;

    public LocationServicesStatusApi31_Factory(Provider<CheckerLocationProvider> provider, Provider<CheckerScanPermission> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4) {
        this.checkerLocationProvider = provider;
        this.checkerScanPermissionProvider = provider2;
        this.isAndroidWearProvider = provider3;
        this.isNearbyPermissionNeverForLocProvider = provider4;
    }

    @Override // bleshadow.javax.inject.Provider
    public LocationServicesStatusApi31 get() {
        return newInstance(this.checkerLocationProvider.get(), this.checkerScanPermissionProvider.get(), this.isAndroidWearProvider.get().booleanValue(), this.isNearbyPermissionNeverForLocProvider.get().booleanValue());
    }

    public static LocationServicesStatusApi31_Factory create(Provider<CheckerLocationProvider> provider, Provider<CheckerScanPermission> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4) {
        return new LocationServicesStatusApi31_Factory(provider, provider2, provider3, provider4);
    }

    public static LocationServicesStatusApi31 newInstance(CheckerLocationProvider checkerLocationProvider, CheckerScanPermission checkerScanPermission, boolean z, boolean z2) {
        return new LocationServicesStatusApi31(checkerLocationProvider, checkerScanPermission, z, z2);
    }
}
