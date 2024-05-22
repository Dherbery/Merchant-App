package com.bleplx.adapter.utils.mapper;

import com.bleplx.adapter.Device;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleDevice;

/* loaded from: classes.dex */
public class RxBleDeviceToDeviceMapper {
    public Device map(RxBleDevice rxBleDevice, RxBleConnection rxBleConnection) {
        Device device = new Device(rxBleDevice.getMacAddress(), rxBleDevice.getName());
        if (rxBleConnection != null) {
            device.setMtu(Integer.valueOf(rxBleConnection.getMtu()));
        }
        return device;
    }
}
