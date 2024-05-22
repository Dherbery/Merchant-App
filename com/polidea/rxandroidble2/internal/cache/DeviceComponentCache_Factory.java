package com.polidea.rxandroidble2.internal.cache;

import bleshadow.dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class DeviceComponentCache_Factory implements Factory<DeviceComponentCache> {
    @Override // bleshadow.javax.inject.Provider
    public DeviceComponentCache get() {
        return newInstance();
    }

    public static DeviceComponentCache_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DeviceComponentCache newInstance() {
        return new DeviceComponentCache();
    }

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {
        private static final DeviceComponentCache_Factory INSTANCE = new DeviceComponentCache_Factory();

        private InstanceHolder() {
        }
    }
}
