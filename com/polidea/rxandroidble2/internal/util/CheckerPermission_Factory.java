package com.polidea.rxandroidble2.internal.util;

import android.content.Context;
import bleshadow.dagger.internal.Factory;
import bleshadow.javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CheckerPermission_Factory implements Factory<CheckerPermission> {
    private final Provider<Context> contextProvider;

    public CheckerPermission_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public CheckerPermission get() {
        return newInstance(this.contextProvider.get());
    }

    public static CheckerPermission_Factory create(Provider<Context> provider) {
        return new CheckerPermission_Factory(provider);
    }

    public static CheckerPermission newInstance(Context context) {
        return new CheckerPermission(context);
    }
}
