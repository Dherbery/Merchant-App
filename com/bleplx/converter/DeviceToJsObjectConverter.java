package com.bleplx.converter;

import com.bleplx.adapter.Device;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

/* loaded from: classes.dex */
public class DeviceToJsObjectConverter extends JSObjectConverter<Device> {

    /* loaded from: classes.dex */
    private interface Metadata {
        public static final String ID = "id";
        public static final String IS_CONNECTABLE = "isConnectable";
        public static final String LOCAL_NAME = "localName";
        public static final String MANUFACTURER_DATA = "manufacturerData";
        public static final String MTU = "mtu";
        public static final String NAME = "name";
        public static final String OVERFLOW_SERVICE_UUIDS = "overflowServiceUUIDs";
        public static final String RSSI = "rssi";
        public static final String SERVICE_DATA = "serviceData";
        public static final String SERVICE_UUIDS = "serviceUUIDs";
        public static final String SOLICITED_SERVICE_UUIDS = "solicitedServiceUUIDs";
        public static final String TX_POWER_LEVEL = "txPowerLevel";
    }

    @Override // com.bleplx.converter.JSObjectConverter
    public /* bridge */ /* synthetic */ WritableArray toJSCallback(Device device) {
        return super.toJSCallback(device);
    }

    @Override // com.bleplx.converter.JSObjectConverter
    public WritableMap toJSObject(Device device) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("id", device.getId());
        createMap.putString("name", device.getName());
        if (device.getRssi() != null) {
            createMap.putInt("rssi", device.getRssi().intValue());
        } else {
            createMap.putNull("rssi");
        }
        if (device.getMtu() != null) {
            createMap.putInt("mtu", device.getMtu().intValue());
        } else {
            createMap.putNull("mtu");
        }
        createMap.putNull("manufacturerData");
        createMap.putNull("serviceData");
        createMap.putNull("serviceUUIDs");
        createMap.putNull("localName");
        createMap.putNull("txPowerLevel");
        createMap.putNull("solicitedServiceUUIDs");
        createMap.putNull("isConnectable");
        createMap.putNull("overflowServiceUUIDs");
        return createMap;
    }
}
