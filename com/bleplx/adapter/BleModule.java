package com.bleplx.adapter;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.ParcelUuid;
import android.util.SparseArray;
import com.bleplx.adapter.errors.BleError;
import com.bleplx.adapter.errors.BleErrorCode;
import com.bleplx.adapter.errors.BleErrorUtils;
import com.bleplx.adapter.errors.ErrorConverter;
import com.bleplx.adapter.exceptions.CannotMonitorCharacteristicException;
import com.bleplx.adapter.utils.Base64Converter;
import com.bleplx.adapter.utils.Constants;
import com.bleplx.adapter.utils.DisposableMap;
import com.bleplx.adapter.utils.IdGenerator;
import com.bleplx.adapter.utils.LogLevel;
import com.bleplx.adapter.utils.RefreshGattCustomOperation;
import com.bleplx.adapter.utils.SafeExecutor;
import com.bleplx.adapter.utils.ServiceFactory;
import com.bleplx.adapter.utils.UUIDConverter;
import com.bleplx.adapter.utils.mapper.RxBleDeviceToDeviceMapper;
import com.bleplx.adapter.utils.mapper.RxScanResultToScanResultMapper;
import com.polidea.rxandroidble2.NotificationSetupMode;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import com.polidea.rxandroidble2.RxBleClient;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleDevice;
import com.polidea.rxandroidble2.RxBleDeviceServices;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanSettings;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class BleModule implements BleAdapter {
    private Disposable adapterStateChangesSubscription;
    private final BluetoothAdapter bluetoothAdapter;
    private final BluetoothManager bluetoothManager;
    private final Context context;
    private RxBleClient rxBleClient;
    private Disposable scanSubscription;
    private final ErrorConverter errorConverter = new ErrorConverter();
    private final HashMap<String, Device> discoveredDevices = new HashMap<>();
    private final HashMap<String, Device> connectedDevices = new HashMap<>();
    private final HashMap<String, RxBleConnection> activeConnections = new HashMap<>();
    private final SparseArray<Service> discoveredServices = new SparseArray<>();
    private final SparseArray<Characteristic> discoveredCharacteristics = new SparseArray<>();
    private final SparseArray<Descriptor> discoveredDescriptors = new SparseArray<>();
    private final DisposableMap pendingTransactions = new DisposableMap();
    private final DisposableMap connectingDevices = new DisposableMap();
    private final RxBleDeviceToDeviceMapper rxBleDeviceToDeviceMapper = new RxBleDeviceToDeviceMapper();
    private final RxScanResultToScanResultMapper rxScanResultToScanResultMapper = new RxScanResultToScanResultMapper();
    private final ServiceFactory serviceFactory = new ServiceFactory();
    private int currentLogLevel = Integer.MAX_VALUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$changeAdapterState$15(RxBleAdapterStateObservable.BleAdapterState bleAdapterState, RxBleAdapterStateObservable.BleAdapterState bleAdapterState2) throws Exception {
        return bleAdapterState == bleAdapterState2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ RxBleConnection lambda$safeConnectToDevice$23(RxBleConnection rxBleConnection, Boolean bool) throws Exception {
        return rxBleConnection;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ RxBleConnection lambda$safeConnectToDevice$26(RxBleConnection rxBleConnection, Integer num) throws Exception {
        return rxBleConnection;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$safeMonitorCharacteristicForDevice$40(Observable observable) throws Exception {
        return observable;
    }

    private String mapNativeAdapterStateToLocalBluetoothState(int i) {
        switch (i) {
            case 10:
                return Constants.BluetoothState.POWERED_OFF;
            case 11:
            case 13:
                return Constants.BluetoothState.RESETTING;
            case 12:
                return Constants.BluetoothState.POWERED_ON;
            default:
                return Constants.BluetoothState.UNKNOWN;
        }
    }

    public BleModule(Context context) {
        this.context = context;
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
        this.bluetoothManager = bluetoothManager;
        this.bluetoothAdapter = bluetoothManager.getAdapter();
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void createClient(String str, OnEventCallback<String> onEventCallback, OnEventCallback<Integer> onEventCallback2) {
        this.rxBleClient = RxBleClient.create(this.context);
        this.adapterStateChangesSubscription = monitorAdapterStateChanges(this.context, onEventCallback);
        if (str != null) {
            onEventCallback2.onEvent(null);
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void destroyClient() {
        Disposable disposable = this.adapterStateChangesSubscription;
        if (disposable != null) {
            disposable.dispose();
            this.adapterStateChangesSubscription = null;
        }
        Disposable disposable2 = this.scanSubscription;
        if (disposable2 != null && !disposable2.isDisposed()) {
            this.scanSubscription.dispose();
            this.scanSubscription = null;
        }
        this.pendingTransactions.removeAllSubscriptions();
        this.connectingDevices.removeAllSubscriptions();
        this.discoveredServices.clear();
        this.discoveredCharacteristics.clear();
        this.discoveredDescriptors.clear();
        this.connectedDevices.clear();
        this.activeConnections.clear();
        this.discoveredDevices.clear();
        this.rxBleClient = null;
        IdGenerator.clear();
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void enable(String str, OnSuccessCallback<Void> onSuccessCallback, OnErrorCallback onErrorCallback) {
        changeAdapterState(RxBleAdapterStateObservable.BleAdapterState.STATE_ON, str, onSuccessCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void disable(String str, OnSuccessCallback<Void> onSuccessCallback, OnErrorCallback onErrorCallback) {
        changeAdapterState(RxBleAdapterStateObservable.BleAdapterState.STATE_OFF, str, onSuccessCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public String getCurrentState() {
        return !supportsBluetoothLowEnergy() ? Constants.BluetoothState.UNSUPPORTED : this.bluetoothManager == null ? Constants.BluetoothState.POWERED_OFF : mapNativeAdapterStateToLocalBluetoothState(this.bluetoothAdapter.getState());
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void startDeviceScan(String[] strArr, int i, int i2, boolean z, OnEventCallback<ScanResult> onEventCallback, OnErrorCallback onErrorCallback) {
        UUID[] uuidArr;
        if (strArr != null) {
            uuidArr = UUIDConverter.convert(strArr);
            if (uuidArr == null) {
                onErrorCallback.onError(BleErrorUtils.invalidIdentifiers(strArr));
                return;
            }
        } else {
            uuidArr = null;
        }
        safeStartDeviceScan(uuidArr, i, i2, z, onEventCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void stopDeviceScan() {
        Disposable disposable = this.scanSubscription;
        if (disposable != null) {
            disposable.dispose();
            this.scanSubscription = null;
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void requestConnectionPriorityForDevice(String str, int i, final String str2, OnSuccessCallback<Device> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            final Device deviceById = getDeviceById(str);
            RxBleConnection connectionOrEmitError = getConnectionOrEmitError(deviceById.getId(), onErrorCallback);
            if (connectionOrEmitError == null) {
                return;
            }
            final SafeExecutor safeExecutor = new SafeExecutor(onSuccessCallback, onErrorCallback);
            this.pendingTransactions.replaceSubscription(str2, connectionOrEmitError.requestConnectionPriority(i, 1L, TimeUnit.MILLISECONDS).doOnDispose(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda45
                @Override // io.reactivex.functions.Action
                public final void run() {
                    BleModule.this.lambda$requestConnectionPriorityForDevice$0(safeExecutor, str2);
                }
            }).subscribe(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda46
                @Override // io.reactivex.functions.Action
                public final void run() {
                    BleModule.this.lambda$requestConnectionPriorityForDevice$1(safeExecutor, deviceById, str2);
                }
            }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    BleModule.this.lambda$requestConnectionPriorityForDevice$2(safeExecutor, str2, (Throwable) obj);
                }
            }));
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestConnectionPriorityForDevice$0(SafeExecutor safeExecutor, String str) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestConnectionPriorityForDevice$1(SafeExecutor safeExecutor, Device device, String str) throws Exception {
        safeExecutor.success(device);
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestConnectionPriorityForDevice$2(SafeExecutor safeExecutor, String str, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        this.pendingTransactions.removeSubscription(str);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void readRSSIForDevice(String str, final String str2, OnSuccessCallback<Device> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            final Device deviceById = getDeviceById(str);
            RxBleConnection connectionOrEmitError = getConnectionOrEmitError(deviceById.getId(), onErrorCallback);
            if (connectionOrEmitError == null) {
                return;
            }
            final SafeExecutor safeExecutor = new SafeExecutor(onSuccessCallback, onErrorCallback);
            this.pendingTransactions.replaceSubscription(str2, connectionOrEmitError.readRssi().doOnDispose(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda21
                @Override // io.reactivex.functions.Action
                public final void run() {
                    BleModule.this.lambda$readRSSIForDevice$3(safeExecutor, str2);
                }
            }).subscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda23
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    BleModule.this.lambda$readRSSIForDevice$4(deviceById, safeExecutor, str2, (Integer) obj);
                }
            }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda24
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    BleModule.this.lambda$readRSSIForDevice$5(safeExecutor, str2, (Throwable) obj);
                }
            }));
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$readRSSIForDevice$3(SafeExecutor safeExecutor, String str) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$readRSSIForDevice$4(Device device, SafeExecutor safeExecutor, String str, Integer num) throws Exception {
        device.setRssi(num);
        safeExecutor.success(device);
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$readRSSIForDevice$5(SafeExecutor safeExecutor, String str, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        this.pendingTransactions.removeSubscription(str);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void requestMTUForDevice(String str, int i, final String str2, OnSuccessCallback<Device> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            final Device deviceById = getDeviceById(str);
            RxBleConnection connectionOrEmitError = getConnectionOrEmitError(deviceById.getId(), onErrorCallback);
            if (connectionOrEmitError == null) {
                return;
            }
            final SafeExecutor safeExecutor = new SafeExecutor(onSuccessCallback, onErrorCallback);
            this.pendingTransactions.replaceSubscription(str2, connectionOrEmitError.requestMtu(i).doOnDispose(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda42
                @Override // io.reactivex.functions.Action
                public final void run() {
                    BleModule.this.lambda$requestMTUForDevice$6(safeExecutor, str2);
                }
            }).subscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda43
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    BleModule.this.lambda$requestMTUForDevice$7(deviceById, safeExecutor, str2, (Integer) obj);
                }
            }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda44
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    BleModule.this.lambda$requestMTUForDevice$8(safeExecutor, str2, (Throwable) obj);
                }
            }));
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestMTUForDevice$6(SafeExecutor safeExecutor, String str) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestMTUForDevice$7(Device device, SafeExecutor safeExecutor, String str, Integer num) throws Exception {
        device.setMtu(num);
        safeExecutor.success(device);
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestMTUForDevice$8(SafeExecutor safeExecutor, String str, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        this.pendingTransactions.removeSubscription(str);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void getKnownDevices(String[] strArr, OnSuccessCallback<Device[]> onSuccessCallback, OnErrorCallback onErrorCallback) {
        if (this.rxBleClient == null) {
            onErrorCallback.onError(new BleError(BleErrorCode.BluetoothManagerDestroyed, "BleManager not created when tried to get known devices", null));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (str == null) {
                onErrorCallback.onError(BleErrorUtils.invalidIdentifiers(strArr));
                return;
            }
            Device device = this.discoveredDevices.get(str);
            if (device != null) {
                arrayList.add(device);
            }
        }
        onSuccessCallback.onSuccess((Device[]) arrayList.toArray(new Device[arrayList.size()]));
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void getConnectedDevices(String[] strArr, OnSuccessCallback<Device[]> onSuccessCallback, OnErrorCallback onErrorCallback) {
        if (this.rxBleClient == null) {
            onErrorCallback.onError(new BleError(BleErrorCode.BluetoothManagerDestroyed, "BleManager not created when tried to get connected devices", null));
            return;
        }
        if (strArr.length == 0) {
            onSuccessCallback.onSuccess(new Device[0]);
            return;
        }
        int length = strArr.length;
        UUID[] uuidArr = new UUID[length];
        for (int i = 0; i < strArr.length; i++) {
            UUID convert = UUIDConverter.convert(strArr[i]);
            if (convert == null) {
                onErrorCallback.onError(BleErrorUtils.invalidIdentifiers(strArr));
                return;
            }
            uuidArr[i] = convert;
        }
        ArrayList arrayList = new ArrayList();
        for (Device device : this.connectedDevices.values()) {
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (device.getServiceByUUID(uuidArr[i2]) != null) {
                    arrayList.add(device);
                    break;
                }
                i2++;
            }
        }
        onSuccessCallback.onSuccess((Device[]) arrayList.toArray(new Device[arrayList.size()]));
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void connectToDevice(String str, ConnectionOptions connectionOptions, OnSuccessCallback<Device> onSuccessCallback, OnEventCallback<ConnectionState> onEventCallback, OnErrorCallback onErrorCallback) {
        RxBleClient rxBleClient = this.rxBleClient;
        if (rxBleClient == null) {
            onErrorCallback.onError(new BleError(BleErrorCode.BluetoothManagerDestroyed, "BleManager not created when tried to connect to device", null));
            return;
        }
        RxBleDevice bleDevice = rxBleClient.getBleDevice(str);
        if (bleDevice == null) {
            onErrorCallback.onError(BleErrorUtils.deviceNotFound(str));
        } else {
            safeConnectToDevice(bleDevice, connectionOptions.getAutoConnect().booleanValue(), connectionOptions.getRequestMTU(), connectionOptions.getRefreshGattMoment(), connectionOptions.getTimeoutInMillis(), connectionOptions.getConnectionPriority(), onSuccessCallback, onEventCallback, onErrorCallback);
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void cancelDeviceConnection(String str, OnSuccessCallback<Device> onSuccessCallback, OnErrorCallback onErrorCallback) {
        RxBleClient rxBleClient = this.rxBleClient;
        if (rxBleClient == null) {
            onErrorCallback.onError(new BleError(BleErrorCode.BluetoothManagerDestroyed, "BleManager not created when tried to cancel device connection", null));
            return;
        }
        RxBleDevice bleDevice = rxBleClient.getBleDevice(str);
        if (this.connectingDevices.removeSubscription(str) && bleDevice != null) {
            onSuccessCallback.onSuccess(this.rxBleDeviceToDeviceMapper.map(bleDevice, null));
        } else if (bleDevice == null) {
            onErrorCallback.onError(BleErrorUtils.deviceNotFound(str));
        } else {
            onErrorCallback.onError(BleErrorUtils.deviceNotConnected(str));
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void isDeviceConnected(String str, OnSuccessCallback<Boolean> onSuccessCallback, OnErrorCallback onErrorCallback) {
        RxBleClient rxBleClient = this.rxBleClient;
        if (rxBleClient == null) {
            onErrorCallback.onError(new BleError(BleErrorCode.BluetoothManagerDestroyed, "BleManager not created when tried to check if device is connected", null));
            return;
        }
        try {
            RxBleDevice bleDevice = rxBleClient.getBleDevice(str);
            if (bleDevice == null) {
                onErrorCallback.onError(BleErrorUtils.deviceNotFound(str));
            } else {
                onSuccessCallback.onSuccess(Boolean.valueOf(bleDevice.getConnectionState().equals(RxBleConnection.RxBleConnectionState.CONNECTED)));
            }
        } catch (Exception e) {
            RxBleLog.e(e, "Error while checking if device is connected", new Object[0]);
            onErrorCallback.onError(this.errorConverter.toError(e));
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void discoverAllServicesAndCharacteristicsForDevice(String str, String str2, OnSuccessCallback<Device> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            safeDiscoverAllServicesAndCharacteristicsForDevice(getDeviceById(str), str2, onSuccessCallback, onErrorCallback);
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public List<Service> getServicesForDevice(String str) throws BleError {
        Device deviceById = getDeviceById(str);
        List<Service> services = deviceById.getServices();
        if (services != null) {
            return services;
        }
        throw BleErrorUtils.deviceServicesNotDiscovered(deviceById.getId());
    }

    @Override // com.bleplx.adapter.BleAdapter
    public List<Characteristic> getCharacteristicsForDevice(String str, String str2) throws BleError {
        UUID convert = UUIDConverter.convert(str2);
        if (convert == null) {
            throw BleErrorUtils.invalidIdentifiers(str2);
        }
        Service serviceByUUID = getDeviceById(str).getServiceByUUID(convert);
        if (serviceByUUID == null) {
            throw BleErrorUtils.serviceNotFound(str2);
        }
        return serviceByUUID.getCharacteristics();
    }

    @Override // com.bleplx.adapter.BleAdapter
    public List<Characteristic> getCharacteristicsForService(int i) throws BleError {
        Service service = this.discoveredServices.get(i);
        if (service == null) {
            throw BleErrorUtils.serviceNotFound(Integer.toString(i));
        }
        return service.getCharacteristics();
    }

    @Override // com.bleplx.adapter.BleAdapter
    public List<Descriptor> descriptorsForDevice(String str, String str2, String str3) throws BleError {
        UUID[] convert = UUIDConverter.convert(str2, str3);
        if (convert == null) {
            throw BleErrorUtils.invalidIdentifiers(str2, str3);
        }
        Service serviceByUUID = getDeviceById(str).getServiceByUUID(convert[0]);
        if (serviceByUUID == null) {
            throw BleErrorUtils.serviceNotFound(str2);
        }
        Characteristic characteristicByUUID = serviceByUUID.getCharacteristicByUUID(convert[1]);
        if (characteristicByUUID == null) {
            throw BleErrorUtils.characteristicNotFound(str3);
        }
        return characteristicByUUID.getDescriptors();
    }

    @Override // com.bleplx.adapter.BleAdapter
    public List<Descriptor> descriptorsForService(int i, String str) throws BleError {
        UUID convert = UUIDConverter.convert(str);
        if (convert == null) {
            throw BleErrorUtils.invalidIdentifiers(str);
        }
        Service service = this.discoveredServices.get(i);
        if (service == null) {
            throw BleErrorUtils.serviceNotFound(Integer.toString(i));
        }
        Characteristic characteristicByUUID = service.getCharacteristicByUUID(convert);
        if (characteristicByUUID == null) {
            throw BleErrorUtils.characteristicNotFound(str);
        }
        return characteristicByUUID.getDescriptors();
    }

    @Override // com.bleplx.adapter.BleAdapter
    public List<Descriptor> descriptorsForCharacteristic(int i) throws BleError {
        Characteristic characteristic = this.discoveredCharacteristics.get(i);
        if (characteristic == null) {
            throw BleErrorUtils.characteristicNotFound(Integer.toString(i));
        }
        return characteristic.getDescriptors();
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void readCharacteristicForDevice(String str, String str2, String str3, String str4, OnSuccessCallback<Characteristic> onSuccessCallback, OnErrorCallback onErrorCallback) {
        Characteristic characteristicOrEmitError = getCharacteristicOrEmitError(str, str2, str3, onErrorCallback);
        if (characteristicOrEmitError == null) {
            return;
        }
        safeReadCharacteristicForDevice(characteristicOrEmitError, str4, onSuccessCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void readCharacteristicForService(int i, String str, String str2, OnSuccessCallback<Characteristic> onSuccessCallback, OnErrorCallback onErrorCallback) {
        Characteristic characteristicOrEmitError = getCharacteristicOrEmitError(i, str, onErrorCallback);
        if (characteristicOrEmitError == null) {
            return;
        }
        safeReadCharacteristicForDevice(characteristicOrEmitError, str2, onSuccessCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void readCharacteristic(int i, String str, OnSuccessCallback<Characteristic> onSuccessCallback, OnErrorCallback onErrorCallback) {
        Characteristic characteristicOrEmitError = getCharacteristicOrEmitError(i, onErrorCallback);
        if (characteristicOrEmitError == null) {
            return;
        }
        safeReadCharacteristicForDevice(characteristicOrEmitError, str, onSuccessCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void writeCharacteristicForDevice(String str, String str2, String str3, String str4, boolean z, String str5, OnSuccessCallback<Characteristic> onSuccessCallback, OnErrorCallback onErrorCallback) {
        Characteristic characteristicOrEmitError = getCharacteristicOrEmitError(str, str2, str3, onErrorCallback);
        if (characteristicOrEmitError == null) {
            return;
        }
        writeCharacteristicWithValue(characteristicOrEmitError, str4, Boolean.valueOf(z), str5, onSuccessCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void writeCharacteristicForService(int i, String str, String str2, boolean z, String str3, OnSuccessCallback<Characteristic> onSuccessCallback, OnErrorCallback onErrorCallback) {
        Characteristic characteristicOrEmitError = getCharacteristicOrEmitError(i, str, onErrorCallback);
        if (characteristicOrEmitError == null) {
            return;
        }
        writeCharacteristicWithValue(characteristicOrEmitError, str2, Boolean.valueOf(z), str3, onSuccessCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void writeCharacteristic(int i, String str, boolean z, String str2, OnSuccessCallback<Characteristic> onSuccessCallback, OnErrorCallback onErrorCallback) {
        Characteristic characteristicOrEmitError = getCharacteristicOrEmitError(i, onErrorCallback);
        if (characteristicOrEmitError == null) {
            return;
        }
        writeCharacteristicWithValue(characteristicOrEmitError, str, Boolean.valueOf(z), str2, onSuccessCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void monitorCharacteristicForDevice(String str, String str2, String str3, String str4, OnEventCallback<Characteristic> onEventCallback, OnErrorCallback onErrorCallback) {
        Characteristic characteristicOrEmitError = getCharacteristicOrEmitError(str, str2, str3, onErrorCallback);
        if (characteristicOrEmitError == null) {
            return;
        }
        safeMonitorCharacteristicForDevice(characteristicOrEmitError, str4, onEventCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void monitorCharacteristicForService(int i, String str, String str2, OnEventCallback<Characteristic> onEventCallback, OnErrorCallback onErrorCallback) {
        Characteristic characteristicOrEmitError = getCharacteristicOrEmitError(i, str, onErrorCallback);
        if (characteristicOrEmitError == null) {
            return;
        }
        safeMonitorCharacteristicForDevice(characteristicOrEmitError, str2, onEventCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void monitorCharacteristic(int i, String str, OnEventCallback<Characteristic> onEventCallback, OnErrorCallback onErrorCallback) {
        Characteristic characteristicOrEmitError = getCharacteristicOrEmitError(i, onErrorCallback);
        if (characteristicOrEmitError == null) {
            return;
        }
        safeMonitorCharacteristicForDevice(characteristicOrEmitError, str, onEventCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void readDescriptorForDevice(String str, String str2, String str3, String str4, String str5, OnSuccessCallback<Descriptor> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            safeReadDescriptorForDevice(getDescriptor(str, str2, str3, str4), str5, onSuccessCallback, onErrorCallback);
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void readDescriptorForService(int i, String str, String str2, String str3, OnSuccessCallback<Descriptor> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            safeReadDescriptorForDevice(getDescriptor(i, str, str2), str3, onSuccessCallback, onErrorCallback);
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void readDescriptorForCharacteristic(int i, String str, String str2, OnSuccessCallback<Descriptor> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            safeReadDescriptorForDevice(getDescriptor(i, str), str2, onSuccessCallback, onErrorCallback);
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void readDescriptor(int i, String str, OnSuccessCallback<Descriptor> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            safeReadDescriptorForDevice(getDescriptor(i), str, onSuccessCallback, onErrorCallback);
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    private void safeReadDescriptorForDevice(final Descriptor descriptor, final String str, OnSuccessCallback<Descriptor> onSuccessCallback, OnErrorCallback onErrorCallback) {
        RxBleConnection connectionOrEmitError = getConnectionOrEmitError(descriptor.getDeviceId(), onErrorCallback);
        if (connectionOrEmitError == null) {
            return;
        }
        final SafeExecutor safeExecutor = new SafeExecutor(onSuccessCallback, onErrorCallback);
        this.pendingTransactions.replaceSubscription(str, connectionOrEmitError.readDescriptor(descriptor.getNativeDescriptor()).doOnDispose(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Action
            public final void run() {
                BleModule.this.lambda$safeReadDescriptorForDevice$9(safeExecutor, str);
            }
        }).subscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BleModule.this.lambda$safeReadDescriptorForDevice$10(descriptor, safeExecutor, str, (byte[]) obj);
            }
        }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BleModule.this.lambda$safeReadDescriptorForDevice$11(safeExecutor, str, (Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeReadDescriptorForDevice$9(SafeExecutor safeExecutor, String str) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeReadDescriptorForDevice$10(Descriptor descriptor, SafeExecutor safeExecutor, String str, byte[] bArr) throws Exception {
        descriptor.logValue("Read from", bArr);
        descriptor.setValue(bArr);
        safeExecutor.success(new Descriptor(descriptor));
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeReadDescriptorForDevice$11(SafeExecutor safeExecutor, String str, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        this.pendingTransactions.removeSubscription(str);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void writeDescriptorForDevice(String str, String str2, String str3, String str4, String str5, String str6, OnSuccessCallback<Descriptor> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            safeWriteDescriptorForDevice(getDescriptor(str, str2, str3, str4), str5, str6, onSuccessCallback, onErrorCallback);
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void writeDescriptorForService(int i, String str, String str2, String str3, String str4, OnSuccessCallback<Descriptor> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            safeWriteDescriptorForDevice(getDescriptor(i, str, str2), str3, str4, onSuccessCallback, onErrorCallback);
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void writeDescriptorForCharacteristic(int i, String str, String str2, String str3, OnSuccessCallback<Descriptor> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            safeWriteDescriptorForDevice(getDescriptor(i, str), str2, str3, onSuccessCallback, onErrorCallback);
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void writeDescriptor(int i, String str, String str2, OnSuccessCallback<Descriptor> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            safeWriteDescriptorForDevice(getDescriptor(i), str, str2, onSuccessCallback, onErrorCallback);
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    private void safeWriteDescriptorForDevice(final Descriptor descriptor, String str, final String str2, OnSuccessCallback<Descriptor> onSuccessCallback, OnErrorCallback onErrorCallback) {
        BluetoothGattDescriptor nativeDescriptor = descriptor.getNativeDescriptor();
        if (nativeDescriptor.getUuid().equals(Constants.CLIENT_CHARACTERISTIC_CONFIG_UUID)) {
            onErrorCallback.onError(BleErrorUtils.descriptorWriteNotAllowed(UUIDConverter.fromUUID(nativeDescriptor.getUuid())));
            return;
        }
        RxBleConnection connectionOrEmitError = getConnectionOrEmitError(descriptor.getDeviceId(), onErrorCallback);
        if (connectionOrEmitError == null) {
            return;
        }
        try {
            final byte[] decode = Base64Converter.decode(str);
            final SafeExecutor safeExecutor = new SafeExecutor(onSuccessCallback, onErrorCallback);
            this.pendingTransactions.replaceSubscription(str2, connectionOrEmitError.writeDescriptor(nativeDescriptor, decode).doOnDispose(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Action
                public final void run() {
                    BleModule.this.lambda$safeWriteDescriptorForDevice$12(safeExecutor, str2);
                }
            }).subscribe(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda11
                @Override // io.reactivex.functions.Action
                public final void run() {
                    BleModule.this.lambda$safeWriteDescriptorForDevice$13(descriptor, decode, safeExecutor, str2);
                }
            }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda22
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    BleModule.this.lambda$safeWriteDescriptorForDevice$14(safeExecutor, str2, (Throwable) obj);
                }
            }));
        } catch (Throwable unused) {
            onErrorCallback.onError(BleErrorUtils.invalidWriteDataForDescriptor(str, UUIDConverter.fromUUID(nativeDescriptor.getUuid())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeWriteDescriptorForDevice$12(SafeExecutor safeExecutor, String str) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeWriteDescriptorForDevice$13(Descriptor descriptor, byte[] bArr, SafeExecutor safeExecutor, String str) throws Exception {
        descriptor.logValue("Write to", bArr);
        descriptor.setValue(bArr);
        safeExecutor.success(new Descriptor(descriptor));
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeWriteDescriptorForDevice$14(SafeExecutor safeExecutor, String str, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        this.pendingTransactions.removeSubscription(str);
    }

    private Descriptor getDescriptor(String str, String str2, String str3, String str4) throws BleError {
        UUID[] convert = UUIDConverter.convert(str2, str3, str4);
        if (convert == null) {
            throw BleErrorUtils.invalidIdentifiers(str2, str3, str4);
        }
        Device device = this.connectedDevices.get(str);
        if (device == null) {
            throw BleErrorUtils.deviceNotConnected(str);
        }
        Service serviceByUUID = device.getServiceByUUID(convert[0]);
        if (serviceByUUID == null) {
            throw BleErrorUtils.serviceNotFound(str2);
        }
        Characteristic characteristicByUUID = serviceByUUID.getCharacteristicByUUID(convert[1]);
        if (characteristicByUUID == null) {
            throw BleErrorUtils.characteristicNotFound(str3);
        }
        Descriptor descriptorByUUID = characteristicByUUID.getDescriptorByUUID(convert[2]);
        if (descriptorByUUID != null) {
            return descriptorByUUID;
        }
        throw BleErrorUtils.descriptorNotFound(str4);
    }

    private Descriptor getDescriptor(int i, String str, String str2) throws BleError {
        UUID[] convert = UUIDConverter.convert(str, str2);
        if (convert == null) {
            throw BleErrorUtils.invalidIdentifiers(str, str2);
        }
        Service service = this.discoveredServices.get(i);
        if (service == null) {
            throw BleErrorUtils.serviceNotFound(Integer.toString(i));
        }
        Characteristic characteristicByUUID = service.getCharacteristicByUUID(convert[0]);
        if (characteristicByUUID == null) {
            throw BleErrorUtils.characteristicNotFound(str);
        }
        Descriptor descriptorByUUID = characteristicByUUID.getDescriptorByUUID(convert[1]);
        if (descriptorByUUID != null) {
            return descriptorByUUID;
        }
        throw BleErrorUtils.descriptorNotFound(str2);
    }

    private Descriptor getDescriptor(int i, String str) throws BleError {
        UUID convert = UUIDConverter.convert(str);
        if (convert == null) {
            throw BleErrorUtils.invalidIdentifiers(str);
        }
        Characteristic characteristic = this.discoveredCharacteristics.get(i);
        if (characteristic == null) {
            throw BleErrorUtils.characteristicNotFound(Integer.toString(i));
        }
        Descriptor descriptorByUUID = characteristic.getDescriptorByUUID(convert);
        if (descriptorByUUID != null) {
            return descriptorByUUID;
        }
        throw BleErrorUtils.descriptorNotFound(str);
    }

    private Descriptor getDescriptor(int i) throws BleError {
        Descriptor descriptor = this.discoveredDescriptors.get(i);
        if (descriptor != null) {
            return descriptor;
        }
        throw BleErrorUtils.descriptorNotFound(Integer.toString(i));
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void cancelTransaction(String str) {
        this.pendingTransactions.removeSubscription(str);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void setLogLevel(String str) {
        int logLevel = LogLevel.toLogLevel(str);
        this.currentLogLevel = logLevel;
        RxBleLog.setLogLevel(logLevel);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public String getLogLevel() {
        return LogLevel.fromLogLevel(this.currentLogLevel);
    }

    private Disposable monitorAdapterStateChanges(Context context, final OnEventCallback<String> onEventCallback) {
        if (!supportsBluetoothLowEnergy()) {
            return null;
        }
        Observable<R> map = new RxBleAdapterStateObservable(context).map(new Function() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda25
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String mapRxBleAdapterStateToLocalBluetoothState;
                mapRxBleAdapterStateToLocalBluetoothState = BleModule.this.mapRxBleAdapterStateToLocalBluetoothState((RxBleAdapterStateObservable.BleAdapterState) obj);
                return mapRxBleAdapterStateToLocalBluetoothState;
            }
        });
        Objects.requireNonNull(onEventCallback);
        return map.subscribe((Consumer<? super R>) new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda26
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OnEventCallback.this.onEvent((String) obj);
            }
        });
    }

    private boolean supportsBluetoothLowEnergy() {
        return this.context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String mapRxBleAdapterStateToLocalBluetoothState(RxBleAdapterStateObservable.BleAdapterState bleAdapterState) {
        return bleAdapterState == RxBleAdapterStateObservable.BleAdapterState.STATE_ON ? Constants.BluetoothState.POWERED_ON : bleAdapterState == RxBleAdapterStateObservable.BleAdapterState.STATE_OFF ? Constants.BluetoothState.POWERED_OFF : Constants.BluetoothState.RESETTING;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void changeAdapterState(final com.polidea.rxandroidble2.RxBleAdapterStateObservable.BleAdapterState r9, final java.lang.String r10, com.bleplx.adapter.OnSuccessCallback<java.lang.Void> r11, com.bleplx.adapter.OnErrorCallback r12) {
        /*
            r8 = this;
            android.bluetooth.BluetoothManager r0 = r8.bluetoothManager
            r1 = 0
            if (r0 != 0) goto L12
            com.bleplx.adapter.errors.BleError r9 = new com.bleplx.adapter.errors.BleError
            com.bleplx.adapter.errors.BleErrorCode r10 = com.bleplx.adapter.errors.BleErrorCode.BluetoothStateChangeFailed
            java.lang.String r11 = "BluetoothManager is null"
            r9.<init>(r10, r11, r1)
            r12.onError(r9)
            return
        L12:
            com.bleplx.adapter.utils.SafeExecutor r0 = new com.bleplx.adapter.utils.SafeExecutor
            r0.<init>(r11, r12)
            com.polidea.rxandroidble2.RxBleAdapterStateObservable r11 = new com.polidea.rxandroidble2.RxBleAdapterStateObservable
            android.content.Context r2 = r8.context
            r11.<init>(r2)
            com.bleplx.adapter.BleModule$$ExternalSyntheticLambda16 r2 = new com.bleplx.adapter.BleModule$$ExternalSyntheticLambda16
            r2.<init>()
            io.reactivex.Observable r11 = r11.takeUntil(r2)
            io.reactivex.Single r11 = r11.firstOrError()
            com.bleplx.adapter.BleModule$$ExternalSyntheticLambda17 r2 = new com.bleplx.adapter.BleModule$$ExternalSyntheticLambda17
            r2.<init>()
            io.reactivex.Single r11 = r11.doOnDispose(r2)
            com.bleplx.adapter.BleModule$$ExternalSyntheticLambda18 r2 = new com.bleplx.adapter.BleModule$$ExternalSyntheticLambda18
            r2.<init>()
            com.bleplx.adapter.BleModule$$ExternalSyntheticLambda19 r3 = new com.bleplx.adapter.BleModule$$ExternalSyntheticLambda19
            r3.<init>()
            io.reactivex.disposables.Disposable r11 = r11.subscribe(r2, r3)
            r0 = 31
            r2 = 0
            r3 = 1
            com.polidea.rxandroidble2.RxBleAdapterStateObservable$BleAdapterState r4 = com.polidea.rxandroidble2.RxBleAdapterStateObservable.BleAdapterState.STATE_ON     // Catch: java.lang.Exception -> L71 java.lang.SecurityException -> L95
            if (r9 != r4) goto L69
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L71 java.lang.SecurityException -> L95
            if (r4 < r0) goto L62
            android.content.Context r4 = r8.context     // Catch: java.lang.Exception -> L71 java.lang.SecurityException -> L95
            boolean r5 = r4 instanceof android.app.Activity     // Catch: java.lang.Exception -> L71 java.lang.SecurityException -> L95
            if (r5 == 0) goto Lb2
            android.app.Activity r4 = (android.app.Activity) r4     // Catch: java.lang.Exception -> L71 java.lang.SecurityException -> L95
            android.content.Intent r5 = new android.content.Intent     // Catch: java.lang.Exception -> L71 java.lang.SecurityException -> L95
            java.lang.String r6 = "android.bluetooth.adapter.action.REQUEST_ENABLE"
            r5.<init>(r6)     // Catch: java.lang.Exception -> L71 java.lang.SecurityException -> L95
            r4.startActivityForResult(r5, r3)     // Catch: java.lang.Exception -> L71 java.lang.SecurityException -> L95
            r0 = r3
            goto Lb3
        L62:
            android.bluetooth.BluetoothAdapter r4 = r8.bluetoothAdapter     // Catch: java.lang.Exception -> L71 java.lang.SecurityException -> L95
            boolean r0 = r4.enable()     // Catch: java.lang.Exception -> L71 java.lang.SecurityException -> L95
            goto L6f
        L69:
            android.bluetooth.BluetoothAdapter r4 = r8.bluetoothAdapter     // Catch: java.lang.Exception -> L71 java.lang.SecurityException -> L95
            boolean r0 = r4.disable()     // Catch: java.lang.Exception -> L71 java.lang.SecurityException -> L95
        L6f:
            r0 = r0 ^ r3
            goto Lb3
        L71:
            r0 = move-exception
            com.bleplx.adapter.errors.BleError r4 = new com.bleplx.adapter.errors.BleError
            com.bleplx.adapter.errors.BleErrorCode r5 = com.bleplx.adapter.errors.BleErrorCode.BluetoothStateChangeFailed
            java.lang.Object[] r6 = new java.lang.Object[r3]
            java.lang.String r7 = r0.getMessage()
            if (r7 == 0) goto L83
            java.lang.String r0 = r0.getMessage()
            goto L86
        L83:
            java.lang.String r0 = "unknown error"
        L86:
            r6[r2] = r0
            java.lang.String r0 = "Couldn't set bluetooth adapter state because of: %s"
            java.lang.String r0 = java.lang.String.format(r0, r6)
            r4.<init>(r5, r0, r1)
            r12.onError(r4)
            goto Lb2
        L95:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r0) goto La6
            com.bleplx.adapter.errors.BleError r0 = new com.bleplx.adapter.errors.BleError
            com.bleplx.adapter.errors.BleErrorCode r4 = com.bleplx.adapter.errors.BleErrorCode.BluetoothUnauthorized
            java.lang.String r5 = "Method requires BLUETOOTH_CONNECT permission"
            r0.<init>(r4, r5, r1)
            r12.onError(r0)
            goto Lb2
        La6:
            com.bleplx.adapter.errors.BleError r0 = new com.bleplx.adapter.errors.BleError
            com.bleplx.adapter.errors.BleErrorCode r4 = com.bleplx.adapter.errors.BleErrorCode.BluetoothUnauthorized
            java.lang.String r5 = "Method requires BLUETOOTH_ADMIN permission"
            r0.<init>(r4, r5, r1)
            r12.onError(r0)
        Lb2:
            r0 = r2
        Lb3:
            if (r0 == 0) goto Ld1
            r11.dispose()
            com.bleplx.adapter.errors.BleError r10 = new com.bleplx.adapter.errors.BleError
            com.bleplx.adapter.errors.BleErrorCode r11 = com.bleplx.adapter.errors.BleErrorCode.BluetoothStateChangeFailed
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r9 = r9.toString()
            r0[r2] = r9
            java.lang.String r9 = "Couldn't set bluetooth adapter state to %s"
            java.lang.String r9 = java.lang.String.format(r9, r0)
            r10.<init>(r11, r9, r1)
            r12.onError(r10)
            goto Ld6
        Ld1:
            com.bleplx.adapter.utils.DisposableMap r9 = r8.pendingTransactions
            r9.replaceSubscription(r10, r11)
        Ld6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bleplx.adapter.BleModule.changeAdapterState(com.polidea.rxandroidble2.RxBleAdapterStateObservable$BleAdapterState, java.lang.String, com.bleplx.adapter.OnSuccessCallback, com.bleplx.adapter.OnErrorCallback):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeAdapterState$16(SafeExecutor safeExecutor, String str) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeAdapterState$17(SafeExecutor safeExecutor, String str, RxBleAdapterStateObservable.BleAdapterState bleAdapterState) throws Exception {
        safeExecutor.success(null);
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeAdapterState$18(SafeExecutor safeExecutor, String str, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        this.pendingTransactions.removeSubscription(str);
    }

    private void safeStartDeviceScan(UUID[] uuidArr, int i, int i2, boolean z, final OnEventCallback<ScanResult> onEventCallback, final OnErrorCallback onErrorCallback) {
        if (this.rxBleClient == null) {
            onErrorCallback.onError(new BleError(BleErrorCode.BluetoothManagerDestroyed, "BleManager not created when tried to start device scan", null));
            return;
        }
        ScanSettings build = new ScanSettings.Builder().setScanMode(i).setCallbackType(i2).setLegacy(z).build();
        int length = uuidArr == null ? 0 : uuidArr.length;
        ScanFilter[] scanFilterArr = new ScanFilter[length];
        for (int i3 = 0; i3 < length; i3++) {
            scanFilterArr[i3] = new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString(uuidArr[i3].toString())).build();
        }
        this.scanSubscription = this.rxBleClient.scanBleDevices(build, scanFilterArr).subscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda33
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BleModule.this.lambda$safeStartDeviceScan$19(onEventCallback, (com.polidea.rxandroidble2.scan.ScanResult) obj);
            }
        }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda41
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BleModule.this.lambda$safeStartDeviceScan$20(onErrorCallback, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeStartDeviceScan$19(OnEventCallback onEventCallback, com.polidea.rxandroidble2.scan.ScanResult scanResult) throws Exception {
        String macAddress = scanResult.getBleDevice().getMacAddress();
        if (!this.discoveredDevices.containsKey(macAddress)) {
            this.discoveredDevices.put(macAddress, this.rxBleDeviceToDeviceMapper.map(scanResult.getBleDevice(), null));
        }
        onEventCallback.onEvent(this.rxScanResultToScanResultMapper.map(scanResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeStartDeviceScan$20(OnErrorCallback onErrorCallback, Throwable th) throws Exception {
        onErrorCallback.onError(this.errorConverter.toError(th));
    }

    private Device getDeviceById(String str) throws BleError {
        Device device = this.connectedDevices.get(str);
        if (device != null) {
            return device;
        }
        throw BleErrorUtils.deviceNotConnected(str);
    }

    private RxBleConnection getConnectionOrEmitError(String str, OnErrorCallback onErrorCallback) {
        RxBleConnection rxBleConnection = this.activeConnections.get(str);
        if (rxBleConnection != null) {
            return rxBleConnection;
        }
        onErrorCallback.onError(BleErrorUtils.deviceNotConnected(str));
        return null;
    }

    private void safeConnectToDevice(final RxBleDevice rxBleDevice, boolean z, final int i, RefreshGattMoment refreshGattMoment, Long l, final int i2, OnSuccessCallback<Device> onSuccessCallback, final OnEventCallback<ConnectionState> onEventCallback, OnErrorCallback onErrorCallback) {
        final SafeExecutor safeExecutor = new SafeExecutor(onSuccessCallback, onErrorCallback);
        Observable<RxBleConnection> doFinally = rxBleDevice.establishConnection(z).doOnSubscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda27
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OnEventCallback.this.onEvent(ConnectionState.CONNECTING);
            }
        }).doFinally(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda28
            @Override // io.reactivex.functions.Action
            public final void run() {
                BleModule.this.lambda$safeConnectToDevice$22(safeExecutor, rxBleDevice, onEventCallback);
            }
        });
        if (refreshGattMoment == RefreshGattMoment.ON_CONNECTED) {
            doFinally = doFinally.flatMap(new Function() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda29
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource map;
                    map = r1.queue(new RefreshGattCustomOperation()).map(new Function() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda20
                        @Override // io.reactivex.functions.Function
                        public final Object apply(Object obj2) {
                            return BleModule.lambda$safeConnectToDevice$23(RxBleConnection.this, (Boolean) obj2);
                        }
                    });
                    return map;
                }
            });
        }
        if (i2 > 0) {
            doFinally = doFinally.flatMap(new Function() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda30
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource andThen;
                    andThen = r2.requestConnectionPriority(i2, 1L, TimeUnit.MILLISECONDS).andThen(Observable.just((RxBleConnection) obj));
                    return andThen;
                }
            });
        }
        if (i > 0) {
            doFinally = doFinally.flatMap(new Function() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda31
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource observable;
                    observable = r2.requestMtu(i).map(new Function() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda8
                        @Override // io.reactivex.functions.Function
                        public final Object apply(Object obj2) {
                            return BleModule.lambda$safeConnectToDevice$26(RxBleConnection.this, (Integer) obj2);
                        }
                    }).toObservable();
                    return observable;
                }
            });
        }
        if (l != null) {
            doFinally = doFinally.timeout(l.longValue(), TimeUnit.MILLISECONDS);
        }
        this.connectingDevices.replaceSubscription(rxBleDevice.getMacAddress(), doFinally.subscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda32
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BleModule.this.lambda$safeConnectToDevice$28(rxBleDevice, onEventCallback, safeExecutor, (RxBleConnection) obj);
            }
        }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda34
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BleModule.this.lambda$safeConnectToDevice$29(safeExecutor, rxBleDevice, (Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeConnectToDevice$22(SafeExecutor safeExecutor, RxBleDevice rxBleDevice, OnEventCallback onEventCallback) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        onDeviceDisconnected(rxBleDevice);
        onEventCallback.onEvent(ConnectionState.DISCONNECTED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeConnectToDevice$28(RxBleDevice rxBleDevice, OnEventCallback onEventCallback, SafeExecutor safeExecutor, RxBleConnection rxBleConnection) throws Exception {
        Device map = this.rxBleDeviceToDeviceMapper.map(rxBleDevice, rxBleConnection);
        onEventCallback.onEvent(ConnectionState.CONNECTED);
        cleanServicesAndCharacteristicsForDevice(map);
        this.connectedDevices.put(rxBleDevice.getMacAddress(), map);
        this.activeConnections.put(rxBleDevice.getMacAddress(), rxBleConnection);
        safeExecutor.success(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeConnectToDevice$29(SafeExecutor safeExecutor, RxBleDevice rxBleDevice, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        onDeviceDisconnected(rxBleDevice);
    }

    private void onDeviceDisconnected(RxBleDevice rxBleDevice) {
        this.activeConnections.remove(rxBleDevice.getMacAddress());
        Device remove = this.connectedDevices.remove(rxBleDevice.getMacAddress());
        if (remove == null) {
            return;
        }
        cleanServicesAndCharacteristicsForDevice(remove);
        this.connectingDevices.removeSubscription(remove.getId());
    }

    private void safeDiscoverAllServicesAndCharacteristicsForDevice(final Device device, final String str, OnSuccessCallback<Device> onSuccessCallback, OnErrorCallback onErrorCallback) {
        RxBleConnection connectionOrEmitError = getConnectionOrEmitError(device.getId(), onErrorCallback);
        if (connectionOrEmitError == null) {
            return;
        }
        final SafeExecutor safeExecutor = new SafeExecutor(onSuccessCallback, onErrorCallback);
        this.pendingTransactions.replaceSubscription(str, connectionOrEmitError.discoverServices().doOnDispose(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda35
            @Override // io.reactivex.functions.Action
            public final void run() {
                BleModule.this.lambda$safeDiscoverAllServicesAndCharacteristicsForDevice$30(safeExecutor, str);
            }
        }).subscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda36
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BleModule.this.lambda$safeDiscoverAllServicesAndCharacteristicsForDevice$31(device, safeExecutor, str, (RxBleDeviceServices) obj);
            }
        }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda37
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BleModule.this.lambda$safeDiscoverAllServicesAndCharacteristicsForDevice$32(safeExecutor, str, (Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeDiscoverAllServicesAndCharacteristicsForDevice$30(SafeExecutor safeExecutor, String str) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeDiscoverAllServicesAndCharacteristicsForDevice$31(Device device, SafeExecutor safeExecutor, String str, RxBleDeviceServices rxBleDeviceServices) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (BluetoothGattService bluetoothGattService : rxBleDeviceServices.getBluetoothGattServices()) {
            Service create = this.serviceFactory.create(device.getId(), bluetoothGattService);
            this.discoveredServices.put(create.getId(), create);
            arrayList.add(create);
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                Characteristic characteristic = new Characteristic(create, bluetoothGattCharacteristic);
                this.discoveredCharacteristics.put(characteristic.getId(), characteristic);
                Iterator<BluetoothGattDescriptor> it = bluetoothGattCharacteristic.getDescriptors().iterator();
                while (it.hasNext()) {
                    Descriptor descriptor = new Descriptor(characteristic, it.next());
                    this.discoveredDescriptors.put(descriptor.getId(), descriptor);
                }
            }
        }
        device.setServices(arrayList);
        safeExecutor.success(device);
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeDiscoverAllServicesAndCharacteristicsForDevice$32(SafeExecutor safeExecutor, String str, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        this.pendingTransactions.removeSubscription(str);
    }

    private void safeReadCharacteristicForDevice(final Characteristic characteristic, final String str, OnSuccessCallback<Characteristic> onSuccessCallback, OnErrorCallback onErrorCallback) {
        RxBleConnection connectionOrEmitError = getConnectionOrEmitError(characteristic.getDeviceId(), onErrorCallback);
        if (connectionOrEmitError == null) {
            return;
        }
        final SafeExecutor safeExecutor = new SafeExecutor(onSuccessCallback, onErrorCallback);
        this.pendingTransactions.replaceSubscription(str, connectionOrEmitError.readCharacteristic(characteristic.gattCharacteristic).doOnDispose(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda38
            @Override // io.reactivex.functions.Action
            public final void run() {
                BleModule.this.lambda$safeReadCharacteristicForDevice$33(safeExecutor, str);
            }
        }).subscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda39
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BleModule.this.lambda$safeReadCharacteristicForDevice$34(characteristic, safeExecutor, str, (byte[]) obj);
            }
        }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda40
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BleModule.this.lambda$safeReadCharacteristicForDevice$35(safeExecutor, str, (Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeReadCharacteristicForDevice$33(SafeExecutor safeExecutor, String str) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeReadCharacteristicForDevice$34(Characteristic characteristic, SafeExecutor safeExecutor, String str, byte[] bArr) throws Exception {
        characteristic.logValue("Read from", bArr);
        characteristic.setValue(bArr);
        safeExecutor.success(new Characteristic(characteristic));
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeReadCharacteristicForDevice$35(SafeExecutor safeExecutor, String str, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        this.pendingTransactions.removeSubscription(str);
    }

    private void writeCharacteristicWithValue(Characteristic characteristic, String str, Boolean bool, String str2, OnSuccessCallback<Characteristic> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            byte[] decode = Base64Converter.decode(str);
            characteristic.setWriteType(bool.booleanValue() ? 2 : 1);
            safeWriteCharacteristicForDevice(characteristic, decode, str2, onSuccessCallback, onErrorCallback);
        } catch (Throwable unused) {
            onErrorCallback.onError(BleErrorUtils.invalidWriteDataForCharacteristic(str, UUIDConverter.fromUUID(characteristic.getUuid())));
        }
    }

    private void safeWriteCharacteristicForDevice(final Characteristic characteristic, byte[] bArr, final String str, OnSuccessCallback<Characteristic> onSuccessCallback, OnErrorCallback onErrorCallback) {
        RxBleConnection connectionOrEmitError = getConnectionOrEmitError(characteristic.getDeviceId(), onErrorCallback);
        if (connectionOrEmitError == null) {
            return;
        }
        final SafeExecutor safeExecutor = new SafeExecutor(onSuccessCallback, onErrorCallback);
        this.pendingTransactions.replaceSubscription(str, connectionOrEmitError.writeCharacteristic(characteristic.gattCharacteristic, bArr).doOnDispose(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Action
            public final void run() {
                BleModule.this.lambda$safeWriteCharacteristicForDevice$36(safeExecutor, str);
            }
        }).subscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BleModule.this.lambda$safeWriteCharacteristicForDevice$37(characteristic, safeExecutor, str, (byte[]) obj);
            }
        }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BleModule.this.lambda$safeWriteCharacteristicForDevice$38(safeExecutor, str, (Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeWriteCharacteristicForDevice$36(SafeExecutor safeExecutor, String str) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeWriteCharacteristicForDevice$37(Characteristic characteristic, SafeExecutor safeExecutor, String str, byte[] bArr) throws Exception {
        characteristic.logValue("Write to", bArr);
        characteristic.setValue(bArr);
        safeExecutor.success(new Characteristic(characteristic));
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeWriteCharacteristicForDevice$38(SafeExecutor safeExecutor, String str, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        this.pendingTransactions.removeSubscription(str);
    }

    private void safeMonitorCharacteristicForDevice(final Characteristic characteristic, final String str, final OnEventCallback<Characteristic> onEventCallback, OnErrorCallback onErrorCallback) {
        final RxBleConnection connectionOrEmitError = getConnectionOrEmitError(characteristic.getDeviceId(), onErrorCallback);
        if (connectionOrEmitError == null) {
            return;
        }
        final SafeExecutor safeExecutor = new SafeExecutor(null, onErrorCallback);
        this.pendingTransactions.replaceSubscription(str, Observable.defer(new Callable() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return BleModule.lambda$safeMonitorCharacteristicForDevice$39(Characteristic.this, connectionOrEmitError);
            }
        }).flatMap(new Function() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BleModule.lambda$safeMonitorCharacteristicForDevice$40((Observable) obj);
            }
        }).toFlowable(BackpressureStrategy.BUFFER).observeOn(Schedulers.computation()).doOnCancel(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Action
            public final void run() {
                BleModule.this.lambda$safeMonitorCharacteristicForDevice$41(safeExecutor, str);
            }
        }).doOnComplete(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Action
            public final void run() {
                BleModule.this.lambda$safeMonitorCharacteristicForDevice$42(str);
            }
        }).subscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BleModule.lambda$safeMonitorCharacteristicForDevice$43(Characteristic.this, onEventCallback, (byte[]) obj);
            }
        }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BleModule.this.lambda$safeMonitorCharacteristicForDevice$44(safeExecutor, str, (Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$safeMonitorCharacteristicForDevice$39(Characteristic characteristic, RxBleConnection rxBleConnection) throws Exception {
        NotificationSetupMode notificationSetupMode;
        if (characteristic.getGattDescriptor(Constants.CLIENT_CHARACTERISTIC_CONFIG_UUID) != null) {
            notificationSetupMode = NotificationSetupMode.QUICK_SETUP;
        } else {
            notificationSetupMode = NotificationSetupMode.COMPAT;
        }
        if (characteristic.isNotifiable()) {
            return rxBleConnection.setupNotification(characteristic.gattCharacteristic, notificationSetupMode);
        }
        if (characteristic.isIndicatable()) {
            return rxBleConnection.setupIndication(characteristic.gattCharacteristic, notificationSetupMode);
        }
        return Observable.error(new CannotMonitorCharacteristicException(characteristic));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeMonitorCharacteristicForDevice$41(SafeExecutor safeExecutor, String str) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeMonitorCharacteristicForDevice$42(String str) throws Exception {
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$safeMonitorCharacteristicForDevice$43(Characteristic characteristic, OnEventCallback onEventCallback, byte[] bArr) throws Exception {
        characteristic.logValue("Notification from", bArr);
        characteristic.setValue(bArr);
        onEventCallback.onEvent(new Characteristic(characteristic));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeMonitorCharacteristicForDevice$44(SafeExecutor safeExecutor, String str, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        this.pendingTransactions.removeSubscription(str);
    }

    private Characteristic getCharacteristicOrEmitError(String str, String str2, String str3, OnErrorCallback onErrorCallback) {
        UUID[] convert = UUIDConverter.convert(str2, str3);
        if (convert == null) {
            onErrorCallback.onError(BleErrorUtils.invalidIdentifiers(str2, str3));
            return null;
        }
        Device device = this.connectedDevices.get(str);
        if (device == null) {
            onErrorCallback.onError(BleErrorUtils.deviceNotConnected(str));
            return null;
        }
        Service serviceByUUID = device.getServiceByUUID(convert[0]);
        if (serviceByUUID == null) {
            onErrorCallback.onError(BleErrorUtils.serviceNotFound(str2));
            return null;
        }
        Characteristic characteristicByUUID = serviceByUUID.getCharacteristicByUUID(convert[1]);
        if (characteristicByUUID != null) {
            return characteristicByUUID;
        }
        onErrorCallback.onError(BleErrorUtils.characteristicNotFound(str3));
        return null;
    }

    private Characteristic getCharacteristicOrEmitError(int i, String str, OnErrorCallback onErrorCallback) {
        UUID convert = UUIDConverter.convert(str);
        if (convert == null) {
            onErrorCallback.onError(BleErrorUtils.invalidIdentifiers(str));
            return null;
        }
        Service service = this.discoveredServices.get(i);
        if (service == null) {
            onErrorCallback.onError(BleErrorUtils.serviceNotFound(Integer.toString(i)));
            return null;
        }
        Characteristic characteristicByUUID = service.getCharacteristicByUUID(convert);
        if (characteristicByUUID != null) {
            return characteristicByUUID;
        }
        onErrorCallback.onError(BleErrorUtils.characteristicNotFound(str));
        return null;
    }

    private Characteristic getCharacteristicOrEmitError(int i, OnErrorCallback onErrorCallback) {
        Characteristic characteristic = this.discoveredCharacteristics.get(i);
        if (characteristic != null) {
            return characteristic;
        }
        onErrorCallback.onError(BleErrorUtils.characteristicNotFound(Integer.toString(i)));
        return null;
    }

    private void cleanServicesAndCharacteristicsForDevice(Device device) {
        for (int size = this.discoveredServices.size() - 1; size >= 0; size--) {
            int keyAt = this.discoveredServices.keyAt(size);
            if (this.discoveredServices.get(keyAt).getDeviceID().equals(device.getId())) {
                this.discoveredServices.remove(keyAt);
            }
        }
        for (int size2 = this.discoveredCharacteristics.size() - 1; size2 >= 0; size2--) {
            int keyAt2 = this.discoveredCharacteristics.keyAt(size2);
            if (this.discoveredCharacteristics.get(keyAt2).getDeviceId().equals(device.getId())) {
                this.discoveredCharacteristics.remove(keyAt2);
            }
        }
        for (int size3 = this.discoveredDescriptors.size() - 1; size3 >= 0; size3--) {
            int keyAt3 = this.discoveredDescriptors.keyAt(size3);
            if (this.discoveredDescriptors.get(keyAt3).getDeviceId().equals(device.getId())) {
                this.discoveredDescriptors.remove(keyAt3);
            }
        }
    }
}
