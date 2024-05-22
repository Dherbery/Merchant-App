package com.polidea.rxandroidble2;

import bleshadow.dagger.Lazy;
import bleshadow.dagger.internal.DoubleCheck;
import bleshadow.dagger.internal.Factory;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import com.polidea.rxandroidble2.internal.RxBleDeviceProvider;
import com.polidea.rxandroidble2.internal.scan.RxBleInternalScanResult;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifier;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilder;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import com.polidea.rxandroidble2.internal.util.BluetoothManagerWrapper;
import com.polidea.rxandroidble2.internal.util.CheckerConnectPermission;
import com.polidea.rxandroidble2.internal.util.CheckerScanPermission;
import com.polidea.rxandroidble2.internal.util.ClientStateObservable;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatus;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.internal.util.ScanRecordParser;
import com.polidea.rxandroidble2.scan.BackgroundScanner;
import com.polidea.rxandroidble2.scan.ScanResult;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;

/* loaded from: classes5.dex */
public final class RxBleClientImpl_Factory implements Factory<RxBleClientImpl> {
    private final Provider<Observable<RxBleAdapterStateObservable.BleAdapterState>> adapterStateObservableProvider;
    private final Provider<BackgroundScanner> backgroundScannerProvider;
    private final Provider<Scheduler> bluetoothInteractionSchedulerProvider;
    private final Provider<BluetoothManagerWrapper> bluetoothManagerWrapperProvider;
    private final Provider<CheckerConnectPermission> checkerConnectPermissionProvider;
    private final Provider<CheckerScanPermission> checkerScanPermissionProvider;
    private final Provider<ClientComponent.ClientComponentFinalizer> clientComponentFinalizerProvider;
    private final Provider<ClientStateObservable> clientStateObservableProvider;
    private final Provider<Function<RxBleInternalScanResult, ScanResult>> internalToExternalScanResultMapFunctionProvider;
    private final Provider<LocationServicesStatus> locationServicesStatusProvider;
    private final Provider<ClientOperationQueue> operationQueueProvider;
    private final Provider<RxBleAdapterWrapper> rxBleAdapterWrapperProvider;
    private final Provider<RxBleDeviceProvider> rxBleDeviceProvider;
    private final Provider<ScanPreconditionsVerifier> scanPreconditionVerifierProvider;
    private final Provider<ScanRecordParser> scanRecordParserProvider;
    private final Provider<ScanSetupBuilder> scanSetupBuilderProvider;

    public RxBleClientImpl_Factory(Provider<BluetoothManagerWrapper> provider, Provider<RxBleAdapterWrapper> provider2, Provider<ClientOperationQueue> provider3, Provider<Observable<RxBleAdapterStateObservable.BleAdapterState>> provider4, Provider<ScanRecordParser> provider5, Provider<LocationServicesStatus> provider6, Provider<ClientStateObservable> provider7, Provider<RxBleDeviceProvider> provider8, Provider<ScanSetupBuilder> provider9, Provider<ScanPreconditionsVerifier> provider10, Provider<Function<RxBleInternalScanResult, ScanResult>> provider11, Provider<Scheduler> provider12, Provider<ClientComponent.ClientComponentFinalizer> provider13, Provider<BackgroundScanner> provider14, Provider<CheckerScanPermission> provider15, Provider<CheckerConnectPermission> provider16) {
        this.bluetoothManagerWrapperProvider = provider;
        this.rxBleAdapterWrapperProvider = provider2;
        this.operationQueueProvider = provider3;
        this.adapterStateObservableProvider = provider4;
        this.scanRecordParserProvider = provider5;
        this.locationServicesStatusProvider = provider6;
        this.clientStateObservableProvider = provider7;
        this.rxBleDeviceProvider = provider8;
        this.scanSetupBuilderProvider = provider9;
        this.scanPreconditionVerifierProvider = provider10;
        this.internalToExternalScanResultMapFunctionProvider = provider11;
        this.bluetoothInteractionSchedulerProvider = provider12;
        this.clientComponentFinalizerProvider = provider13;
        this.backgroundScannerProvider = provider14;
        this.checkerScanPermissionProvider = provider15;
        this.checkerConnectPermissionProvider = provider16;
    }

    @Override // bleshadow.javax.inject.Provider
    public RxBleClientImpl get() {
        return newInstance(this.bluetoothManagerWrapperProvider.get(), this.rxBleAdapterWrapperProvider.get(), this.operationQueueProvider.get(), this.adapterStateObservableProvider.get(), this.scanRecordParserProvider.get(), this.locationServicesStatusProvider.get(), DoubleCheck.lazy(this.clientStateObservableProvider), this.rxBleDeviceProvider.get(), this.scanSetupBuilderProvider.get(), this.scanPreconditionVerifierProvider.get(), this.internalToExternalScanResultMapFunctionProvider.get(), this.bluetoothInteractionSchedulerProvider.get(), this.clientComponentFinalizerProvider.get(), this.backgroundScannerProvider.get(), this.checkerScanPermissionProvider.get(), this.checkerConnectPermissionProvider.get());
    }

    public static RxBleClientImpl_Factory create(Provider<BluetoothManagerWrapper> provider, Provider<RxBleAdapterWrapper> provider2, Provider<ClientOperationQueue> provider3, Provider<Observable<RxBleAdapterStateObservable.BleAdapterState>> provider4, Provider<ScanRecordParser> provider5, Provider<LocationServicesStatus> provider6, Provider<ClientStateObservable> provider7, Provider<RxBleDeviceProvider> provider8, Provider<ScanSetupBuilder> provider9, Provider<ScanPreconditionsVerifier> provider10, Provider<Function<RxBleInternalScanResult, ScanResult>> provider11, Provider<Scheduler> provider12, Provider<ClientComponent.ClientComponentFinalizer> provider13, Provider<BackgroundScanner> provider14, Provider<CheckerScanPermission> provider15, Provider<CheckerConnectPermission> provider16) {
        return new RxBleClientImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16);
    }

    public static RxBleClientImpl newInstance(BluetoothManagerWrapper bluetoothManagerWrapper, RxBleAdapterWrapper rxBleAdapterWrapper, ClientOperationQueue clientOperationQueue, Observable<RxBleAdapterStateObservable.BleAdapterState> observable, ScanRecordParser scanRecordParser, LocationServicesStatus locationServicesStatus, Lazy<ClientStateObservable> lazy, RxBleDeviceProvider rxBleDeviceProvider, ScanSetupBuilder scanSetupBuilder, ScanPreconditionsVerifier scanPreconditionsVerifier, Function<RxBleInternalScanResult, ScanResult> function, Scheduler scheduler, ClientComponent.ClientComponentFinalizer clientComponentFinalizer, BackgroundScanner backgroundScanner, CheckerScanPermission checkerScanPermission, CheckerConnectPermission checkerConnectPermission) {
        return new RxBleClientImpl(bluetoothManagerWrapper, rxBleAdapterWrapper, clientOperationQueue, observable, scanRecordParser, locationServicesStatus, lazy, rxBleDeviceProvider, scanSetupBuilder, scanPreconditionsVerifier, function, scheduler, clientComponentFinalizer, backgroundScanner, checkerScanPermission, checkerConnectPermission);
    }
}
