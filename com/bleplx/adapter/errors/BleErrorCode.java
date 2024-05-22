package com.bleplx.adapter.errors;

import com.google.mlkit.common.MlKitException;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;

/* loaded from: classes.dex */
public enum BleErrorCode {
    UnknownError(0),
    BluetoothManagerDestroyed(1),
    OperationCancelled(2),
    OperationTimedOut(3),
    OperationStartFailed(4),
    InvalidIdentifiers(5),
    BluetoothUnsupported(100),
    BluetoothUnauthorized(101),
    BluetoothPoweredOff(102),
    BluetoothInUnknownState(103),
    BluetoothResetting(104),
    BluetoothStateChangeFailed(105),
    DeviceConnectionFailed(200),
    DeviceDisconnected(201),
    DeviceRSSIReadFailed(MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED),
    DeviceAlreadyConnected(203),
    DeviceNotFound(204),
    DeviceNotConnected(MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR),
    DeviceMTUChangeFailed(MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR),
    ServicesDiscoveryFailed(300),
    IncludedServicesDiscoveryFailed(MlKitException.LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE),
    ServiceNotFound(302),
    ServicesNotDiscovered(303),
    CharacteristicsDiscoveryFailed(400),
    CharacteristicWriteFailed(401),
    CharacteristicReadFailed(402),
    CharacteristicNotifyChangeFailed(403),
    CharacteristicNotFound(RCHTTPStatusCodes.NOT_FOUND),
    CharacteristicsNotDiscovered(405),
    CharacteristicInvalidDataFormat(406),
    DescriptorsDiscoveryFailed(500),
    DescriptorWriteFailed(501),
    DescriptorReadFailed(502),
    DescriptorNotFound(503),
    DescriptorsNotDiscovered(504),
    DescriptorInvalidDataFormat(505),
    DescriptorWriteNotAllowed(506),
    ScanStartFailed(600),
    LocationServicesDisabled(601);

    public final int code;

    BleErrorCode(int i) {
        this.code = i;
    }
}
