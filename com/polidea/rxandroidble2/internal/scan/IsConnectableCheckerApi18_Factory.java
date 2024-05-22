package com.polidea.rxandroidble2.internal.scan;

import bleshadow.dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class IsConnectableCheckerApi18_Factory implements Factory<IsConnectableCheckerApi18> {
    @Override // bleshadow.javax.inject.Provider
    public IsConnectableCheckerApi18 get() {
        return newInstance();
    }

    public static IsConnectableCheckerApi18_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static IsConnectableCheckerApi18 newInstance() {
        return new IsConnectableCheckerApi18();
    }

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {
        private static final IsConnectableCheckerApi18_Factory INSTANCE = new IsConnectableCheckerApi18_Factory();

        private InstanceHolder() {
        }
    }
}
