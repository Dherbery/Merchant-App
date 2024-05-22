package com.polidea.rxandroidble2.internal.scan;

import android.bluetooth.le.ScanResult;
import bleshadow.javax.inject.Inject;
import com.polidea.rxandroidble2.scan.IsConnectable;

/* loaded from: classes5.dex */
public class IsConnectableCheckerApi18 implements IsConnectableChecker {
    @Inject
    public IsConnectableCheckerApi18() {
    }

    @Override // com.polidea.rxandroidble2.internal.scan.IsConnectableChecker
    public IsConnectable check(ScanResult scanResult) {
        return IsConnectable.LEGACY_UNKNOWN;
    }
}
