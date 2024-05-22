package com.polidea.rxandroidble2.internal.util;

import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;

/* loaded from: classes5.dex */
public class LocationServicesStatusApi23 implements LocationServicesStatus {
    private final CheckerLocationProvider checkerLocationProvider;
    private final CheckerScanPermission checkerScanPermission;
    private final int deviceSdk;
    private final boolean isAndroidWear;
    private final int targetSdk;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public LocationServicesStatusApi23(CheckerLocationProvider checkerLocationProvider, CheckerScanPermission checkerScanPermission, @Named("target-sdk") int i, @Named("device-sdk") int i2, @Named("android-wear") boolean z) {
        this.checkerLocationProvider = checkerLocationProvider;
        this.checkerScanPermission = checkerScanPermission;
        this.targetSdk = i;
        this.deviceSdk = i2;
        this.isAndroidWear = z;
    }

    @Override // com.polidea.rxandroidble2.internal.util.LocationServicesStatus
    public boolean isLocationPermissionOk() {
        return this.checkerScanPermission.isScanRuntimePermissionGranted();
    }

    @Override // com.polidea.rxandroidble2.internal.util.LocationServicesStatus
    public boolean isLocationProviderOk() {
        return !isLocationProviderEnabledRequired() || this.checkerLocationProvider.isLocationProviderEnabled();
    }

    private boolean isLocationProviderEnabledRequired() {
        return !this.isAndroidWear && (this.deviceSdk >= 29 || this.targetSdk >= 23);
    }
}
