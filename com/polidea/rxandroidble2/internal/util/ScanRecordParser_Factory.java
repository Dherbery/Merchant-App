package com.polidea.rxandroidble2.internal.util;

import bleshadow.dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class ScanRecordParser_Factory implements Factory<ScanRecordParser> {
    @Override // bleshadow.javax.inject.Provider
    public ScanRecordParser get() {
        return newInstance();
    }

    public static ScanRecordParser_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ScanRecordParser newInstance() {
        return new ScanRecordParser();
    }

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {
        private static final ScanRecordParser_Factory INSTANCE = new ScanRecordParser_Factory();

        private InstanceHolder() {
        }
    }
}
