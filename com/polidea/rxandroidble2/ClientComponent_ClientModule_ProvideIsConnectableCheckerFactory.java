package com.polidea.rxandroidble2;

import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent;
import com.polidea.rxandroidble2.internal.scan.IsConnectableChecker;
import com.polidea.rxandroidble2.internal.scan.IsConnectableCheckerApi18;
import com.polidea.rxandroidble2.internal.scan.IsConnectableCheckerApi26;

/* loaded from: classes5.dex */
public final class ClientComponent_ClientModule_ProvideIsConnectableCheckerFactory implements Factory<IsConnectableChecker> {
    private final Provider<Integer> deviceSdkProvider;
    private final Provider<IsConnectableCheckerApi18> isConnectableCheckerApi18Provider;
    private final Provider<IsConnectableCheckerApi26> isConnectableCheckerApi26Provider;

    public ClientComponent_ClientModule_ProvideIsConnectableCheckerFactory(Provider<Integer> provider, Provider<IsConnectableCheckerApi18> provider2, Provider<IsConnectableCheckerApi26> provider3) {
        this.deviceSdkProvider = provider;
        this.isConnectableCheckerApi18Provider = provider2;
        this.isConnectableCheckerApi26Provider = provider3;
    }

    @Override // bleshadow.javax.inject.Provider
    public IsConnectableChecker get() {
        return provideIsConnectableChecker(this.deviceSdkProvider.get().intValue(), this.isConnectableCheckerApi18Provider, this.isConnectableCheckerApi26Provider);
    }

    public static ClientComponent_ClientModule_ProvideIsConnectableCheckerFactory create(Provider<Integer> provider, Provider<IsConnectableCheckerApi18> provider2, Provider<IsConnectableCheckerApi26> provider3) {
        return new ClientComponent_ClientModule_ProvideIsConnectableCheckerFactory(provider, provider2, provider3);
    }

    public static IsConnectableChecker provideIsConnectableChecker(int i, Provider<IsConnectableCheckerApi18> provider, Provider<IsConnectableCheckerApi26> provider2) {
        return (IsConnectableChecker) Preconditions.checkNotNullFromProvides(ClientComponent.ClientModule.provideIsConnectableChecker(i, provider, provider2));
    }
}
