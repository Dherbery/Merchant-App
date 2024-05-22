package com.polidea.rxandroidble2.internal.scan;

import bleshadow.dagger.internal.Factory;
import bleshadow.javax.inject.Provider;

/* loaded from: classes5.dex */
public final class AndroidScanObjectsConverter_Factory implements Factory<AndroidScanObjectsConverter> {
    private final Provider<Integer> deviceSdkProvider;

    public AndroidScanObjectsConverter_Factory(Provider<Integer> provider) {
        this.deviceSdkProvider = provider;
    }

    @Override // bleshadow.javax.inject.Provider
    public AndroidScanObjectsConverter get() {
        return newInstance(this.deviceSdkProvider.get().intValue());
    }

    public static AndroidScanObjectsConverter_Factory create(Provider<Integer> provider) {
        return new AndroidScanObjectsConverter_Factory(provider);
    }

    public static AndroidScanObjectsConverter newInstance(int i) {
        return new AndroidScanObjectsConverter(i);
    }
}
