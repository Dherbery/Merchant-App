package com.polidea.rxandroidble2.internal.util;

import bleshadow.dagger.internal.Factory;
import bleshadow.javax.inject.Provider;

/* loaded from: classes5.dex */
public final class LocationServicesStatusApi23_Factory implements Factory<LocationServicesStatusApi23> {
    private final Provider<CheckerLocationProvider> checkerLocationProvider;
    private final Provider<CheckerScanPermission> checkerScanPermissionProvider;
    private final Provider<Integer> deviceSdkProvider;
    private final Provider<Boolean> isAndroidWearProvider;
    private final Provider<Integer> targetSdkProvider;

    public LocationServicesStatusApi23_Factory(Provider<CheckerLocationProvider> provider, Provider<CheckerScanPermission> provider2, Provider<Integer> provider3, Provider<Integer> provider4, Provider<Boolean> provider5) {
        this.checkerLocationProvider = provider;
        this.checkerScanPermissionProvider = provider2;
        this.targetSdkProvider = provider3;
        this.deviceSdkProvider = provider4;
        this.isAndroidWearProvider = provider5;
    }

    @Override // bleshadow.javax.inject.Provider
    public LocationServicesStatusApi23 get() {
        return newInstance(this.checkerLocationProvider.get(), this.checkerScanPermissionProvider.get(), this.targetSdkProvider.get().intValue(), this.deviceSdkProvider.get().intValue(), this.isAndroidWearProvider.get().booleanValue());
    }

    public static LocationServicesStatusApi23_Factory create(Provider<CheckerLocationProvider> provider, Provider<CheckerScanPermission> provider2, Provider<Integer> provider3, Provider<Integer> provider4, Provider<Boolean> provider5) {
        return new LocationServicesStatusApi23_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static LocationServicesStatusApi23 newInstance(CheckerLocationProvider checkerLocationProvider, CheckerScanPermission checkerScanPermission, int i, int i2, boolean z) {
        return new LocationServicesStatusApi23(checkerLocationProvider, checkerScanPermission, i, i2, z);
    }
}
