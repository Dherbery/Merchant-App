package com.polidea.rxandroidble2;

import android.content.ContentResolver;
import android.content.Context;
import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent;

/* loaded from: classes5.dex */
public final class ClientComponent_ClientModule_ProvideContentResolverFactory implements Factory<ContentResolver> {
    private final Provider<Context> contextProvider;

    public ClientComponent_ClientModule_ProvideContentResolverFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public ContentResolver get() {
        return provideContentResolver(this.contextProvider.get());
    }

    public static ClientComponent_ClientModule_ProvideContentResolverFactory create(Provider<Context> provider) {
        return new ClientComponent_ClientModule_ProvideContentResolverFactory(provider);
    }

    public static ContentResolver provideContentResolver(Context context) {
        return (ContentResolver) Preconditions.checkNotNullFromProvides(ClientComponent.ClientModule.provideContentResolver(context));
    }
}
