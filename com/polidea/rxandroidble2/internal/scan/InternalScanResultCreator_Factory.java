package com.polidea.rxandroidble2.internal.scan;

import bleshadow.dagger.internal.Factory;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.util.ScanRecordParser;

/* loaded from: classes5.dex */
public final class InternalScanResultCreator_Factory implements Factory<InternalScanResultCreator> {
    private final Provider<IsConnectableChecker> isConnectableCheckerProvider;
    private final Provider<ScanRecordParser> scanRecordParserProvider;

    public InternalScanResultCreator_Factory(Provider<ScanRecordParser> provider, Provider<IsConnectableChecker> provider2) {
        this.scanRecordParserProvider = provider;
        this.isConnectableCheckerProvider = provider2;
    }

    @Override // bleshadow.javax.inject.Provider
    public InternalScanResultCreator get() {
        return newInstance(this.scanRecordParserProvider.get(), this.isConnectableCheckerProvider.get());
    }

    public static InternalScanResultCreator_Factory create(Provider<ScanRecordParser> provider, Provider<IsConnectableChecker> provider2) {
        return new InternalScanResultCreator_Factory(provider, provider2);
    }

    public static InternalScanResultCreator newInstance(ScanRecordParser scanRecordParser, IsConnectableChecker isConnectableChecker) {
        return new InternalScanResultCreator(scanRecordParser, isConnectableChecker);
    }
}
