package com.polidea.rxandroidble2.internal.scan;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import bleshadow.javax.inject.Inject;
import com.polidea.rxandroidble2.ClientScope;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.util.ScanRecordParser;
import com.polidea.rxandroidble2.scan.IsConnectable;
import com.polidea.rxandroidble2.scan.ScanCallbackType;

@ClientScope
/* loaded from: classes5.dex */
public class InternalScanResultCreator {
    private final IsConnectableChecker isConnectableChecker;
    private final ScanRecordParser scanRecordParser;

    @Inject
    public InternalScanResultCreator(ScanRecordParser scanRecordParser, IsConnectableChecker isConnectableChecker) {
        this.scanRecordParser = scanRecordParser;
        this.isConnectableChecker = isConnectableChecker;
    }

    public RxBleInternalScanResult create(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        return new RxBleInternalScanResult(bluetoothDevice, i, System.nanoTime(), this.scanRecordParser.parseFromBytes(bArr), ScanCallbackType.CALLBACK_TYPE_UNSPECIFIED, IsConnectable.LEGACY_UNKNOWN);
    }

    public RxBleInternalScanResult create(ScanResult scanResult) {
        return new RxBleInternalScanResult(scanResult.getDevice(), scanResult.getRssi(), scanResult.getTimestampNanos(), new ScanRecordImplNativeWrapper(scanResult.getScanRecord(), this.scanRecordParser), ScanCallbackType.CALLBACK_TYPE_BATCH, this.isConnectableChecker.check(scanResult));
    }

    public RxBleInternalScanResult create(int i, ScanResult scanResult) {
        return new RxBleInternalScanResult(scanResult.getDevice(), scanResult.getRssi(), scanResult.getTimestampNanos(), new ScanRecordImplNativeWrapper(scanResult.getScanRecord(), this.scanRecordParser), toScanCallbackType(i), this.isConnectableChecker.check(scanResult));
    }

    private static ScanCallbackType toScanCallbackType(int i) {
        if (i == 1) {
            return ScanCallbackType.CALLBACK_TYPE_ALL_MATCHES;
        }
        if (i == 2) {
            return ScanCallbackType.CALLBACK_TYPE_FIRST_MATCH;
        }
        if (i == 4) {
            return ScanCallbackType.CALLBACK_TYPE_MATCH_LOST;
        }
        RxBleLog.w("Unknown callback type %d -> check android.bluetooth.le.ScanSettings", Integer.valueOf(i));
        return ScanCallbackType.CALLBACK_TYPE_UNKNOWN;
    }
}
