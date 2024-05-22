package com.polidea.rxandroidble2.internal.connection;

import bleshadow.dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class NativeCallbackDispatcher_Factory implements Factory<NativeCallbackDispatcher> {
    @Override // bleshadow.javax.inject.Provider
    public NativeCallbackDispatcher get() {
        return newInstance();
    }

    public static NativeCallbackDispatcher_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static NativeCallbackDispatcher newInstance() {
        return new NativeCallbackDispatcher();
    }

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {
        private static final NativeCallbackDispatcher_Factory INSTANCE = new NativeCallbackDispatcher_Factory();

        private InstanceHolder() {
        }
    }
}
