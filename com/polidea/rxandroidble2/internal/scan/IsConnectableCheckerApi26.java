package com.polidea.rxandroidble2.internal.scan;

import android.bluetooth.le.ScanResult;
import bleshadow.javax.inject.Inject;
import com.polidea.rxandroidble2.scan.IsConnectable;

/* loaded from: classes5.dex */
public class IsConnectableCheckerApi26 implements IsConnectableChecker {
    @Inject
    public IsConnectableCheckerApi26() {
    }

    @Override // com.polidea.rxandroidble2.internal.scan.IsConnectableChecker
    public IsConnectable check(ScanResult scanResult) {
        boolean isConnectable;
        isConnectable = scanResult.isConnectable();
        return isConnectable ? IsConnectable.CONNECTABLE : IsConnectable.NOT_CONNECTABLE;
    }
}
