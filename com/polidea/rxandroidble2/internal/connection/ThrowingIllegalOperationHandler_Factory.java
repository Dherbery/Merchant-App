package com.polidea.rxandroidble2.internal.connection;

import bleshadow.dagger.internal.Factory;
import bleshadow.javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ThrowingIllegalOperationHandler_Factory implements Factory<ThrowingIllegalOperationHandler> {
    private final Provider<IllegalOperationMessageCreator> messageCreatorProvider;

    public ThrowingIllegalOperationHandler_Factory(Provider<IllegalOperationMessageCreator> provider) {
        this.messageCreatorProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public ThrowingIllegalOperationHandler get() {
        return newInstance(this.messageCreatorProvider.get());
    }

    public static ThrowingIllegalOperationHandler_Factory create(Provider<IllegalOperationMessageCreator> provider) {
        return new ThrowingIllegalOperationHandler_Factory(provider);
    }

    public static ThrowingIllegalOperationHandler newInstance(IllegalOperationMessageCreator illegalOperationMessageCreator) {
        return new ThrowingIllegalOperationHandler(illegalOperationMessageCreator);
    }
}
