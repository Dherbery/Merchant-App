package com.polidea.rxandroidble2.helpers;

import bleshadow.dagger.internal.Factory;
import bleshadow.javax.inject.Provider;
import io.reactivex.Observable;

/* loaded from: classes5.dex */
public final class LocationServicesOkObservable_Factory implements Factory<LocationServicesOkObservable> {
    private final Provider<Observable<Boolean>> locationServicesOkObsImplProvider;

    public LocationServicesOkObservable_Factory(Provider<Observable<Boolean>> provider) {
        this.locationServicesOkObsImplProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public LocationServicesOkObservable get() {
        return newInstance(this.locationServicesOkObsImplProvider.get());
    }

    public static LocationServicesOkObservable_Factory create(Provider<Observable<Boolean>> provider) {
        return new LocationServicesOkObservable_Factory(provider);
    }

    public static LocationServicesOkObservable newInstance(Observable<Boolean> observable) {
        return new LocationServicesOkObservable(observable);
    }
}
