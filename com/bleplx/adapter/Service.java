package com.bleplx.adapter;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class Service {
    private final BluetoothGattService btGattService;
    private final String deviceID;
    private final int id;

    public Service(int i, String str, BluetoothGattService bluetoothGattService) {
        this.id = i;
        this.deviceID = str;
        this.btGattService = bluetoothGattService;
    }

    public int getId() {
        return this.id;
    }

    public UUID getUuid() {
        return this.btGattService.getUuid();
    }

    public String getDeviceID() {
        return this.deviceID;
    }

    public boolean isPrimary() {
        return this.btGattService.getType() == 0;
    }

    public Characteristic getCharacteristicByUUID(UUID uuid) {
        BluetoothGattCharacteristic characteristic = this.btGattService.getCharacteristic(uuid);
        if (characteristic == null) {
            return null;
        }
        return new Characteristic(this, characteristic);
    }

    public List<Characteristic> getCharacteristics() {
        ArrayList arrayList = new ArrayList(this.btGattService.getCharacteristics().size());
        Iterator<BluetoothGattCharacteristic> it = this.btGattService.getCharacteristics().iterator();
        while (it.hasNext()) {
            arrayList.add(new Characteristic(this, it.next()));
        }
        return arrayList;
    }
}
