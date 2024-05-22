package com.polidea.rxandroidble2.internal.util;

import android.content.ContentResolver;
import android.location.LocationManager;
import bleshadow.dagger.internal.Factory;
import bleshadow.javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CheckerLocationProvider_Factory implements Factory<CheckerLocationProvider> {
    private final Provider<ContentResolver> contentResolverProvider;
    private final Provider<LocationManager> locationManagerProvider;

    public CheckerLocationProvider_Factory(Provider<ContentResolver> provider, Provider<LocationManager> provider2) {
        this.contentResolverProvider = provider;
        this.locationManagerProvider = provider2;
    }

    @Override // bleshadow.javax.inject.Provider
    public CheckerLocationProvider get() {
        return newInstance(this.contentResolverProvider.get(), this.locationManagerProvider.get());
    }

    public static CheckerLocationProvider_Factory create(Provider<ContentResolver> provider, Provider<LocationManager> provider2) {
        return new CheckerLocationProvider_Factory(provider, provider2);
    }

    public static CheckerLocationProvider newInstance(ContentResolver contentResolver, LocationManager locationManager) {
        return new CheckerLocationProvider(contentResolver, locationManager);
    }
}
