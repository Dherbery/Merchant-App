package com.polidea.rxandroidble2.internal.util;

import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;

/* loaded from: classes5.dex */
public class LocationServicesStatusApi31 implements LocationServicesStatus {
    private final CheckerLocationProvider checkerLocationProvider;
    private final CheckerScanPermission checkerScanPermission;
    private final boolean isAndroidWear;
    private final boolean isNearbyPermissionNeverForLoc;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public LocationServicesStatusApi31(CheckerLocationProvider checkerLocationProvider, CheckerScanPermission checkerScanPermission, @Named("android-wear") boolean z, @Named("nearby-permission-never-for-location") boolean z2) {
        this.checkerLocationProvider = checkerLocationProvider;
        this.checkerScanPermission = checkerScanPermission;
        this.isAndroidWear = z;
        this.isNearbyPermissionNeverForLoc = z2;
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
        if (this.isAndroidWear) {
            return false;
        }
        return !this.isNearbyPermissionNeverForLoc;
    }
}
