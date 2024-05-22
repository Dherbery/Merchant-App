package com.polidea.rxandroidble2.scan;

import com.polidea.rxandroidble2.RxBleDevice;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class ScanResult {
    private final RxBleDevice bleDevice;
    private final ScanCallbackType callbackType;
    private final IsConnectable isConnectable;
    private final int rssi;
    private final ScanRecord scanRecord;
    private final long timestampNanos;

    public ScanResult(RxBleDevice rxBleDevice, int i, long j, ScanCallbackType scanCallbackType, ScanRecord scanRecord, IsConnectable isConnectable) {
        this.bleDevice = rxBleDevice;
        this.rssi = i;
        this.timestampNanos = j;
        this.callbackType = scanCallbackType;
        this.scanRecord = scanRecord;
        this.isConnectable = isConnectable;
    }

    public RxBleDevice getBleDevice() {
        return this.bleDevice;
    }

    public int getRssi() {
        return this.rssi;
    }

    public long getTimestampNanos() {
        return this.timestampNanos;
    }

    public ScanCallbackType getCallbackType() {
        return this.callbackType;
    }

    public ScanRecord getScanRecord() {
        return this.scanRecord;
    }

    public IsConnectable isConnectable() {
        return this.isConnectable;
    }

    public String toString() {
        return "ScanResult{bleDevice=" + this.bleDevice + ", rssi=" + this.rssi + ", timestampNanos=" + this.timestampNanos + ", callbackType=" + this.callbackType + ", scanRecord=" + LoggerUtil.bytesToHex(this.scanRecord.getBytes()) + ", isConnectable=" + this.isConnectable + AbstractJsonLexerKt.END_OBJ;
    }
}
