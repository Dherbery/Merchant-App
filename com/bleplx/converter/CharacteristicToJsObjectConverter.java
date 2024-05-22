package com.bleplx.converter;

import com.bleplx.adapter.Characteristic;
import com.bleplx.adapter.utils.Base64Converter;
import com.bleplx.adapter.utils.UUIDConverter;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

/* loaded from: classes.dex */
public class CharacteristicToJsObjectConverter extends JSObjectConverter<Characteristic> {

    /* loaded from: classes.dex */
    private interface Metadata {
        public static final String DEVICE_ID = "deviceID";
        public static final String ID = "id";
        public static final String IS_INDICATABLE = "isIndicatable";
        public static final String IS_NOTIFIABLE = "isNotifiable";
        public static final String IS_NOTIFYING = "isNotifying";
        public static final String IS_READABLE = "isReadable";
        public static final String IS_WRITABLE_WITHOUT_RESPONSE = "isWritableWithoutResponse";
        public static final String IS_WRITABLE_WITH_RESPONSE = "isWritableWithResponse";
        public static final String SERVICE_ID = "serviceID";
        public static final String SERVICE_UUID = "serviceUUID";
        public static final String UUID = "uuid";
        public static final String VALUE = "value";
    }

    @Override // com.bleplx.converter.JSObjectConverter
    public /* bridge */ /* synthetic */ WritableArray toJSCallback(Characteristic characteristic) {
        return super.toJSCallback(characteristic);
    }

    @Override // com.bleplx.converter.JSObjectConverter
    public WritableMap toJSObject(Characteristic characteristic) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", characteristic.getId());
        createMap.putString("uuid", UUIDConverter.fromUUID(characteristic.getUuid()));
        createMap.putInt("serviceID", characteristic.getServiceID());
        createMap.putString("serviceUUID", UUIDConverter.fromUUID(characteristic.getServiceUUID()));
        createMap.putString("deviceID", characteristic.getDeviceId());
        createMap.putBoolean(Metadata.IS_READABLE, characteristic.isReadable());
        createMap.putBoolean(Metadata.IS_WRITABLE_WITH_RESPONSE, characteristic.isWritableWithResponse());
        createMap.putBoolean(Metadata.IS_WRITABLE_WITHOUT_RESPONSE, characteristic.isWritableWithoutResponse());
        createMap.putBoolean(Metadata.IS_NOTIFIABLE, characteristic.isNotifiable());
        createMap.putBoolean(Metadata.IS_INDICATABLE, characteristic.isIndicatable());
        createMap.putBoolean(Metadata.IS_NOTIFYING, characteristic.isNotifying());
        createMap.putString("value", characteristic.getValue() != null ? Base64Converter.encode(characteristic.getValue()) : null);
        return createMap;
    }
}
