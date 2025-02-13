package com.bleplx.adapter;

import android.bluetooth.BluetoothGattDescriptor;
import com.bleplx.adapter.utils.ByteUtils;
import com.bleplx.adapter.utils.IdGenerator;
import com.bleplx.adapter.utils.IdGeneratorKey;
import com.polidea.rxandroidble2.internal.RxBleLog;
import java.util.UUID;

/* loaded from: classes.dex */
public class Descriptor {
    private final int characteristicId;
    private final UUID characteristicUuid;
    private final BluetoothGattDescriptor descriptor;
    private final String deviceId;
    private final int id;
    private final int serviceId;
    private final UUID serviceUuid;
    private final UUID uuid;
    private byte[] value;

    public Descriptor(Characteristic characteristic, BluetoothGattDescriptor bluetoothGattDescriptor) {
        this.value = null;
        int id = characteristic.getId();
        this.characteristicId = id;
        this.characteristicUuid = characteristic.getUuid();
        this.serviceId = characteristic.getServiceID();
        this.serviceUuid = characteristic.getServiceUUID();
        this.descriptor = bluetoothGattDescriptor;
        String deviceId = characteristic.getDeviceId();
        this.deviceId = deviceId;
        this.id = IdGenerator.getIdForKey(new IdGeneratorKey(deviceId, bluetoothGattDescriptor.getUuid(), id));
        this.uuid = bluetoothGattDescriptor.getUuid();
    }

    public Descriptor(int i, int i2, UUID uuid, UUID uuid2, String str, BluetoothGattDescriptor bluetoothGattDescriptor, int i3, UUID uuid3) {
        this.value = null;
        this.characteristicId = i;
        this.serviceId = i2;
        this.characteristicUuid = uuid;
        this.serviceUuid = uuid2;
        this.deviceId = str;
        this.descriptor = bluetoothGattDescriptor;
        this.id = i3;
        this.uuid = uuid3;
    }

    public Descriptor(Descriptor descriptor) {
        this.value = null;
        this.characteristicUuid = descriptor.characteristicUuid;
        this.characteristicId = descriptor.characteristicId;
        this.serviceUuid = descriptor.serviceUuid;
        this.serviceId = descriptor.serviceId;
        this.deviceId = descriptor.deviceId;
        this.descriptor = descriptor.descriptor;
        this.id = descriptor.id;
        this.uuid = descriptor.uuid;
        byte[] bArr = descriptor.value;
        if (bArr != null) {
            this.value = (byte[]) bArr.clone();
        }
    }

    public int getId() {
        return this.id;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getCharacteristicId() {
        return this.characteristicId;
    }

    public int getServiceId() {
        return this.serviceId;
    }

    public UUID getCharacteristicUuid() {
        return this.characteristicUuid;
    }

    public UUID getServiceUuid() {
        return this.serviceUuid;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public byte[] getValue() {
        return this.value;
    }

    public void setValue(byte[] bArr) {
        this.value = bArr;
    }

    public void setValueFromCache() {
        this.value = this.descriptor.getValue();
    }

    public BluetoothGattDescriptor getNativeDescriptor() {
        return this.descriptor;
    }

    public void logValue(String str, byte[] bArr) {
        if (bArr == null) {
            bArr = this.descriptor.getValue();
        }
        RxBleLog.v(str + " Descriptor(uuid: " + this.descriptor.getUuid().toString() + ", id: " + this.id + ", value: " + (bArr != null ? ByteUtils.bytesToHex(bArr) : "(null)") + ")", new Object[0]);
    }
}
