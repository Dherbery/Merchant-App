package com.polidea.rxandroidble2.internal;

import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import bleshadow.javax.inject.Provider;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.internal.connection.ConnectionStateChangeListener;

/* loaded from: classes5.dex */
public final class DeviceModule_ProvideConnectionStateChangeListenerFactory implements Factory<ConnectionStateChangeListener> {
    private final Provider<BehaviorRelay<RxBleConnection.RxBleConnectionState>> connectionStateBehaviorRelayProvider;

    public DeviceModule_ProvideConnectionStateChangeListenerFactory(Provider<BehaviorRelay<RxBleConnection.RxBleConnectionState>> provider) {
        this.connectionStateBehaviorRelayProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public ConnectionStateChangeListener get() {
        return provideConnectionStateChangeListener(this.connectionStateBehaviorRelayProvider.get());
    }

    public static DeviceModule_ProvideConnectionStateChangeListenerFactory create(Provider<BehaviorRelay<RxBleConnection.RxBleConnectionState>> provider) {
        return new DeviceModule_ProvideConnectionStateChangeListenerFactory(provider);
    }

    public static ConnectionStateChangeListener provideConnectionStateChangeListener(BehaviorRelay<RxBleConnection.RxBleConnectionState> behaviorRelay) {
        return (ConnectionStateChangeListener) Preconditions.checkNotNullFromProvides(DeviceModule.provideConnectionStateChangeListener(behaviorRelay));
    }
}
