package com.polidea.rxandroidble2.internal.connection;

import bleshadow.dagger.internal.Factory;
import bleshadow.javax.inject.Provider;

/* loaded from: classes5.dex */
public final class IllegalOperationChecker_Factory implements Factory<IllegalOperationChecker> {
    private final Provider<IllegalOperationHandler> resultHandlerProvider;

    public IllegalOperationChecker_Factory(Provider<IllegalOperationHandler> provider) {
        this.resultHandlerProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public IllegalOperationChecker get() {
        return newInstance(this.resultHandlerProvider.get());
    }

    public static IllegalOperationChecker_Factory create(Provider<IllegalOperationHandler> provider) {
        return new IllegalOperationChecker_Factory(provider);
    }

    public static IllegalOperationChecker newInstance(IllegalOperationHandler illegalOperationHandler) {
        return new IllegalOperationChecker(illegalOperationHandler);
    }
}
