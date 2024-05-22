package com.bleplx.converter;

import com.bleplx.adapter.Descriptor;
import com.bleplx.adapter.utils.Base64Converter;
import com.bleplx.adapter.utils.UUIDConverter;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

/* loaded from: classes.dex */
public class DescriptorToJsObjectConverter extends JSObjectConverter<Descriptor> {

    /* loaded from: classes.dex */
    private interface Metadata {
        public static final String CHARACTERISTIC_ID = "characteristicID";
        public static final String CHARACTERISTIC_UUID = "characteristicUUID";
        public static final String DEVICE_ID = "deviceID";
        public static final String ID = "id";
        public static final String SERVICE_ID = "serviceID";
        public static final String SERVICE_UUID = "serviceUUID";
        public static final String UUID = "uuid";
        public static final String VALUE = "value";
    }

    @Override // com.bleplx.converter.JSObjectConverter
    public /* bridge */ /* synthetic */ WritableArray toJSCallback(Descriptor descriptor) {
        return super.toJSCallback(descriptor);
    }

    @Override // com.bleplx.converter.JSObjectConverter
    public WritableMap toJSObject(Descriptor descriptor) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", descriptor.getId());
        createMap.putString("uuid", UUIDConverter.fromUUID(descriptor.getUuid()));
        createMap.putInt(Metadata.CHARACTERISTIC_ID, descriptor.getCharacteristicId());
        createMap.putString(Metadata.CHARACTERISTIC_UUID, UUIDConverter.fromUUID(descriptor.getCharacteristicUuid()));
        createMap.putInt("serviceID", descriptor.getServiceId());
        createMap.putString("serviceUUID", UUIDConverter.fromUUID(descriptor.getServiceUuid()));
        createMap.putString("deviceID", descriptor.getDeviceId());
        if (descriptor.getValue() == null) {
            descriptor.setValueFromCache();
        }
        createMap.putString("value", descriptor.getValue() != null ? Base64Converter.encode(descriptor.getValue()) : null);
        return createMap;
    }
}
