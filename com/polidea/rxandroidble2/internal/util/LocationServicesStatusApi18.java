package com.polidea.rxandroidble2.internal.util;

import bleshadow.javax.inject.Inject;

/* loaded from: classes5.dex */
public class LocationServicesStatusApi18 implements LocationServicesStatus {
    @Override // com.polidea.rxandroidble2.internal.util.LocationServicesStatus
    public boolean isLocationPermissionOk() {
        return true;
    }

    @Override // com.polidea.rxandroidble2.internal.util.LocationServicesStatus
    public boolean isLocationProviderOk() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public LocationServicesStatusApi18() {
    }
}
