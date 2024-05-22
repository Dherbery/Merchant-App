package com.polidea.rxandroidble2.internal.connection;

import bleshadow.dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class ConnectionModule_MinimumMtuFactory implements Factory<Integer> {
    @Override // bleshadow.javax.inject.Provider
    public Integer get() {
        return Integer.valueOf(minimumMtu());
    }

    public static ConnectionModule_MinimumMtuFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static int minimumMtu() {
        return ConnectionModule.minimumMtu();
    }

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {
        private static final ConnectionModule_MinimumMtuFactory INSTANCE = new ConnectionModule_MinimumMtuFactory();

        private InstanceHolder() {
        }
    }
}
