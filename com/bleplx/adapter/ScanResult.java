package com.bleplx.adapter;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes.dex */
public class ScanResult {
    private AdvertisementData advertisementData;
    private String deviceId;
    private String deviceName;
    private boolean isConnectable;
    private int mtu;
    private UUID[] overflowServiceUUIDs;
    private int rssi;

    public ScanResult(String str, String str2, int i, int i2, boolean z, UUID[] uuidArr, AdvertisementData advertisementData) {
        this.deviceId = str;
        this.deviceName = str2;
        this.rssi = i;
        this.mtu = i2;
        this.isConnectable = z;
        this.overflowServiceUUIDs = uuidArr;
        this.advertisementData = advertisementData;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public int getRssi() {
        return this.rssi;
    }

    public void setRssi(int i) {
        this.rssi = i;
    }

    public int getMtu() {
        return this.mtu;
    }

    public void setMtu(int i) {
        this.mtu = i;
    }

    public boolean isConnectable() {
        return this.isConnectable;
    }

    public void setConnectable(boolean z) {
        this.isConnectable = z;
    }

    public UUID[] getOverflowServiceUUIDs() {
        return this.overflowServiceUUIDs;
    }

    public void setOverflowServiceUUIDs(UUID[] uuidArr) {
        this.overflowServiceUUIDs = uuidArr;
    }

    public AdvertisementData getAdvertisementData() {
        return this.advertisementData;
    }

    public void setAdvertisementData(AdvertisementData advertisementData) {
        this.advertisementData = advertisementData;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ScanResult scanResult = (ScanResult) obj;
        if (this.rssi == scanResult.rssi && this.mtu == scanResult.mtu && this.isConnectable == scanResult.isConnectable && this.deviceId.equals(scanResult.deviceId) && Objects.equals(this.deviceName, scanResult.deviceName) && Arrays.equals(this.overflowServiceUUIDs, scanResult.overflowServiceUUIDs)) {
            return Objects.equals(this.advertisementData, scanResult.advertisementData);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.deviceId.hashCode() * 31;
        String str = this.deviceName;
        int hashCode2 = (((((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.rssi) * 31) + this.mtu) * 31) + (this.isConnectable ? 1 : 0)) * 31) + Arrays.hashCode(this.overflowServiceUUIDs)) * 31;
        AdvertisementData advertisementData = this.advertisementData;
        return hashCode2 + (advertisementData != null ? advertisementData.hashCode() : 0);
    }

    public String toString() {
        return "ScanResult{deviceId='" + this.deviceId + "', deviceName='" + this.deviceName + "', rssi=" + this.rssi + ", mtu=" + this.mtu + ", isConnectable=" + this.isConnectable + ", overflowServiceUUIDs=" + Arrays.toString(this.overflowServiceUUIDs) + ", advertisementData=" + this.advertisementData + AbstractJsonLexerKt.END_OBJ;
    }
}
