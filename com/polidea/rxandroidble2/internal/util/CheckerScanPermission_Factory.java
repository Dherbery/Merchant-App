package com.polidea.rxandroidble2.internal.util;

import bleshadow.dagger.internal.Factory;
import bleshadow.javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CheckerScanPermission_Factory implements Factory<CheckerScanPermission> {
    private final Provider<CheckerPermission> checkerPermissionProvider;
    private final Provider<String[][]> scanPermissionsProvider;

    public CheckerScanPermission_Factory(Provider<CheckerPermission> provider, Provider<String[][]> provider2) {
        this.checkerPermissionProvider = provider;
        this.scanPermissionsProvider = provider2;
    }

    @Override // bleshadow.javax.inject.Provider
    public CheckerScanPermission get() {
        return newInstance(this.checkerPermissionProvider.get(), this.scanPermissionsProvider.get());
    }

    public static CheckerScanPermission_Factory create(Provider<CheckerPermission> provider, Provider<String[][]> provider2) {
        return new CheckerScanPermission_Factory(provider, provider2);
    }

    public static CheckerScanPermission newInstance(CheckerPermission checkerPermission, String[][] strArr) {
        return new CheckerScanPermission(checkerPermission, strArr);
    }
}
