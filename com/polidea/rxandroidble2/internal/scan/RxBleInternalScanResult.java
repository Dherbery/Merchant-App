package com.polidea.rxandroidble2.internal.scan;

import android.bluetooth.BluetoothDevice;
import com.polidea.rxandroidble2.internal.ScanResultInterface;
import com.polidea.rxandroidble2.scan.IsConnectable;
import com.polidea.rxandroidble2.scan.ScanCallbackType;
import com.polidea.rxandroidble2.scan.ScanRecord;

/* loaded from: classes5.dex */
public class RxBleInternalScanResult implements ScanResultInterface {
    private final BluetoothDevice bluetoothDevice;
    private final IsConnectable isConnectable;
    private final int rssi;
    private final ScanCallbackType scanCallbackType;
    private final ScanRecord scanRecord;
    private final long timestampNanos;

    public RxBleInternalScanResult(BluetoothDevice bluetoothDevice, int i, long j, ScanRecord scanRecord, ScanCallbackType scanCallbackType, IsConnectable isConnectable) {
        this.bluetoothDevice = bluetoothDevice;
        this.rssi = i;
        this.timestampNanos = j;
        this.scanRecord = scanRecord;
        this.scanCallbackType = scanCallbackType;
        this.isConnectable = isConnectable;
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.bluetoothDevice;
    }

    @Override // com.polidea.rxandroidble2.internal.ScanResultInterface
    public int getRssi() {
        return this.rssi;
    }

    @Override // com.polidea.rxandroidble2.internal.ScanResultInterface
    public ScanRecord getScanRecord() {
        return this.scanRecord;
    }

    @Override // com.polidea.rxandroidble2.internal.ScanResultInterface
    public long getTimestampNanos() {
        return this.timestampNanos;
    }

    @Override // com.polidea.rxandroidble2.internal.ScanResultInterface
    public ScanCallbackType getScanCallbackType() {
        return this.scanCallbackType;
    }

    @Override // com.polidea.rxandroidble2.internal.ScanResultInterface
    public String getAddress() {
        return this.bluetoothDevice.getAddress();
    }

    @Override // com.polidea.rxandroidble2.internal.ScanResultInterface
    public String getDeviceName() {
        BluetoothDevice bluetoothDevice = getBluetoothDevice();
        if (bluetoothDevice == null) {
            return null;
        }
        return bluetoothDevice.getName();
    }

    public IsConnectable isConnectable() {
        return this.isConnectable;
    }
}
