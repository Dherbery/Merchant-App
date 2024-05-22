package com.polidea.rxandroidble2.internal.util;

import bleshadow.dagger.internal.Factory;
import bleshadow.javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CheckerConnectPermission_Factory implements Factory<CheckerConnectPermission> {
    private final Provider<CheckerPermission> checkerPermissionProvider;
    private final Provider<String[][]> connectPermissionsProvider;

    public CheckerConnectPermission_Factory(Provider<CheckerPermission> provider, Provider<String[][]> provider2) {
        this.checkerPermissionProvider = provider;
        this.connectPermissionsProvider = provider2;
    }

    @Override // bleshadow.javax.inject.Provider
    public CheckerConnectPermission get() {
        return newInstance(this.checkerPermissionProvider.get(), this.connectPermissionsProvider.get());
    }

    public static CheckerConnectPermission_Factory create(Provider<CheckerPermission> provider, Provider<String[][]> provider2) {
        return new CheckerConnectPermission_Factory(provider, provider2);
    }

    public static CheckerConnectPermission newInstance(CheckerPermission checkerPermission, String[][] strArr) {
        return new CheckerConnectPermission(checkerPermission, strArr);
    }
}
