package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.ContentResolver;
import android.content.Context;
import android.location.LocationManager;
import bleshadow.dagger.internal.DelegateFactory;
import bleshadow.dagger.internal.DoubleCheck;
import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.InstanceFactory;
import bleshadow.dagger.internal.Preconditions;
import bleshadow.dagger.internal.SetBuilder;
import bleshadow.javax.inject.Provider;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.polidea.rxandroidble2.ClientComponent;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.helpers.LocationServicesOkObservable;
import com.polidea.rxandroidble2.helpers.LocationServicesOkObservable_Factory;
import com.polidea.rxandroidble2.internal.DeviceComponent;
import com.polidea.rxandroidble2.internal.DeviceModule_ProvideBluetoothDeviceFactory;
import com.polidea.rxandroidble2.internal.DeviceModule_ProvideConnectionStateChangeListenerFactory;
import com.polidea.rxandroidble2.internal.DeviceModule_ProvideConnectionStateRelayFactory;
import com.polidea.rxandroidble2.internal.DeviceModule_ProvidesConnectTimeoutConfFactory;
import com.polidea.rxandroidble2.internal.DeviceModule_ProvidesDisconnectTimeoutConfFactory;
import com.polidea.rxandroidble2.internal.RxBleDeviceImpl_Factory;
import com.polidea.rxandroidble2.internal.RxBleDeviceProvider;
import com.polidea.rxandroidble2.internal.RxBleDeviceProvider_Factory;
import com.polidea.rxandroidble2.internal.cache.DeviceComponentCache;
import com.polidea.rxandroidble2.internal.cache.DeviceComponentCache_Factory;
import com.polidea.rxandroidble2.internal.connection.BluetoothGattProvider;
import com.polidea.rxandroidble2.internal.connection.BluetoothGattProvider_Factory;
import com.polidea.rxandroidble2.internal.connection.ConnectionComponent;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_GattWriteMtuOverheadFactory;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_MinimumMtuFactory;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_ProvideBluetoothGattFactory;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_ProvideCharacteristicPropertiesParserFactory;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_ProvideIllegalOperationHandlerFactory;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_ProvidesOperationTimeoutConfFactory;
import com.polidea.rxandroidble2.internal.connection.ConnectionStateChangeListener;
import com.polidea.rxandroidble2.internal.connection.ConnectionSubscriptionWatcher;
import com.polidea.rxandroidble2.internal.connection.ConnectorImpl;
import com.polidea.rxandroidble2.internal.connection.ConnectorImpl_Factory;
import com.polidea.rxandroidble2.internal.connection.DescriptorWriter_Factory;
import com.polidea.rxandroidble2.internal.connection.DisconnectAction_Factory;
import com.polidea.rxandroidble2.internal.connection.DisconnectionRouter_Factory;
import com.polidea.rxandroidble2.internal.connection.IllegalOperationChecker;
import com.polidea.rxandroidble2.internal.connection.IllegalOperationChecker_Factory;
import com.polidea.rxandroidble2.internal.connection.IllegalOperationHandler;
import com.polidea.rxandroidble2.internal.connection.IllegalOperationMessageCreator;
import com.polidea.rxandroidble2.internal.connection.IllegalOperationMessageCreator_Factory;
import com.polidea.rxandroidble2.internal.connection.LoggingIllegalOperationHandler;
import com.polidea.rxandroidble2.internal.connection.LoggingIllegalOperationHandler_Factory;
import com.polidea.rxandroidble2.internal.connection.LongWriteOperationBuilderImpl;
import com.polidea.rxandroidble2.internal.connection.LongWriteOperationBuilderImpl_Factory;
import com.polidea.rxandroidble2.internal.connection.MtuBasedPayloadSizeLimit_Factory;
import com.polidea.rxandroidble2.internal.connection.MtuWatcher_Factory;
import com.polidea.rxandroidble2.internal.connection.NativeCallbackDispatcher_Factory;
import com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager_Factory;
import com.polidea.rxandroidble2.internal.connection.RxBleConnectionImpl;
import com.polidea.rxandroidble2.internal.connection.RxBleConnectionImpl_Factory;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback_Factory;
import com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager_Factory;
import com.polidea.rxandroidble2.internal.connection.ThrowingIllegalOperationHandler;
import com.polidea.rxandroidble2.internal.connection.ThrowingIllegalOperationHandler_Factory;
import com.polidea.rxandroidble2.internal.logger.LoggerUtilBluetoothServices;
import com.polidea.rxandroidble2.internal.logger.LoggerUtilBluetoothServices_Factory;
import com.polidea.rxandroidble2.internal.operations.ConnectOperation;
import com.polidea.rxandroidble2.internal.operations.ConnectOperation_Factory;
import com.polidea.rxandroidble2.internal.operations.DisconnectOperation;
import com.polidea.rxandroidble2.internal.operations.DisconnectOperation_Factory;
import com.polidea.rxandroidble2.internal.operations.OperationsProviderImpl;
import com.polidea.rxandroidble2.internal.operations.OperationsProviderImpl_Factory;
import com.polidea.rxandroidble2.internal.operations.ReadRssiOperation;
import com.polidea.rxandroidble2.internal.operations.ReadRssiOperation_Factory;
import com.polidea.rxandroidble2.internal.operations.TimeoutConfiguration;
import com.polidea.rxandroidble2.internal.scan.AndroidScanObjectsConverter;
import com.polidea.rxandroidble2.internal.scan.AndroidScanObjectsConverter_Factory;
import com.polidea.rxandroidble2.internal.scan.BackgroundScannerImpl;
import com.polidea.rxandroidble2.internal.scan.BackgroundScannerImpl_Factory;
import com.polidea.rxandroidble2.internal.scan.InternalScanResultCreator;
import com.polidea.rxandroidble2.internal.scan.InternalScanResultCreator_Factory;
import com.polidea.rxandroidble2.internal.scan.InternalToExternalScanResultConverter;
import com.polidea.rxandroidble2.internal.scan.InternalToExternalScanResultConverter_Factory;
import com.polidea.rxandroidble2.internal.scan.IsConnectableChecker;
import com.polidea.rxandroidble2.internal.scan.IsConnectableCheckerApi18_Factory;
import com.polidea.rxandroidble2.internal.scan.IsConnectableCheckerApi26_Factory;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifier;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifierApi18;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifierApi18_Factory;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifierApi24;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifierApi24_Factory;
import com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator;
import com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator_Factory;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilder;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi18;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi18_Factory;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi21;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi21_Factory;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi23;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi23_Factory;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueueImpl;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueueImpl_Factory;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueueImpl;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueueImpl_Factory;
import com.polidea.rxandroidble2.internal.util.BleConnectionCompat;
import com.polidea.rxandroidble2.internal.util.BluetoothManagerWrapper;
import com.polidea.rxandroidble2.internal.util.BluetoothManagerWrapper_Factory;
import com.polidea.rxandroidble2.internal.util.CheckerConnectPermission;
import com.polidea.rxandroidble2.internal.util.CheckerConnectPermission_Factory;
import com.polidea.rxandroidble2.internal.util.CheckerLocationProvider;
import com.polidea.rxandroidble2.internal.util.CheckerLocationProvider_Factory;
import com.polidea.rxandroidble2.internal.util.CheckerPermission;
import com.polidea.rxandroidble2.internal.util.CheckerPermission_Factory;
import com.polidea.rxandroidble2.internal.util.CheckerScanPermission;
import com.polidea.rxandroidble2.internal.util.CheckerScanPermission_Factory;
import com.polidea.rxandroidble2.internal.util.ClientStateObservable;
import com.polidea.rxandroidble2.internal.util.ClientStateObservable_Factory;
import com.polidea.rxandroidble2.internal.util.LocationServicesOkObservableApi23Factory;
import com.polidea.rxandroidble2.internal.util.LocationServicesOkObservableApi23Factory_Factory;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatus;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi18_Factory;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi23;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi23_Factory;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi31;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi31_Factory;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper_Factory;
import com.polidea.rxandroidble2.internal.util.ScanRecordParser_Factory;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/* loaded from: classes5.dex */
public final class DaggerClientComponent {
    private DaggerClientComponent() {
    }

    public static ClientComponent.Builder builder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Builder implements ClientComponent.Builder {
        private Context applicationContext;

        private Builder() {
        }

        @Override // com.polidea.rxandroidble2.ClientComponent.Builder
        public Builder applicationContext(Context context) {
            this.applicationContext = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        @Override // com.polidea.rxandroidble2.ClientComponent.Builder
        public ClientComponent build() {
            Preconditions.checkBuilderRequirement(this.applicationContext, Context.class);
            return new ClientComponentImpl(this.applicationContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class DeviceComponentBuilder implements DeviceComponent.Builder {
        private final ClientComponentImpl clientComponentImpl;
        private String macAddress;

        private DeviceComponentBuilder(ClientComponentImpl clientComponentImpl) {
            this.clientComponentImpl = clientComponentImpl;
        }

        @Override // com.polidea.rxandroidble2.internal.DeviceComponent.Builder
        public DeviceComponentBuilder macAddress(String str) {
            this.macAddress = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.polidea.rxandroidble2.internal.DeviceComponent.Builder
        public DeviceComponent build() {
            Preconditions.checkBuilderRequirement(this.macAddress, String.class);
            return new DeviceComponentImpl(this.clientComponentImpl, this.macAddress);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class ConnectionComponentBuilder implements ConnectionComponent.Builder {
        private Boolean autoConnect;
        private final ClientComponentImpl clientComponentImpl;
        private final DeviceComponentImpl deviceComponentImpl;
        private Timeout operationTimeout;
        private Boolean suppressOperationChecks;

        private ConnectionComponentBuilder(ClientComponentImpl clientComponentImpl, DeviceComponentImpl deviceComponentImpl) {
            this.clientComponentImpl = clientComponentImpl;
            this.deviceComponentImpl = deviceComponentImpl;
        }

        @Override // com.polidea.rxandroidble2.internal.connection.ConnectionComponent.Builder
        public ConnectionComponentBuilder autoConnect(boolean z) {
            this.autoConnect = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.polidea.rxandroidble2.internal.connection.ConnectionComponent.Builder
        public ConnectionComponentBuilder suppressOperationChecks(boolean z) {
            this.suppressOperationChecks = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.polidea.rxandroidble2.internal.connection.ConnectionComponent.Builder
        public ConnectionComponentBuilder operationTimeout(Timeout timeout) {
            this.operationTimeout = (Timeout) Preconditions.checkNotNull(timeout);
            return this;
        }

        @Override // com.polidea.rxandroidble2.internal.connection.ConnectionComponent.Builder
        public ConnectionComponent build() {
            Preconditions.checkBuilderRequirement(this.autoConnect, Boolean.class);
            Preconditions.checkBuilderRequirement(this.suppressOperationChecks, Boolean.class);
            Preconditions.checkBuilderRequirement(this.operationTimeout, Timeout.class);
            return new ConnectionComponentImpl(this.clientComponentImpl, this.deviceComponentImpl, this.autoConnect, this.suppressOperationChecks, this.operationTimeout);
        }
    }

    /* loaded from: classes5.dex */
    private static final class ConnectionComponentImpl implements ConnectionComponent {
        private final Boolean autoConnect;
        private Provider<BluetoothGattProvider> bluetoothGattProvider;
        private final ClientComponentImpl clientComponentImpl;
        private final ConnectionComponentImpl connectionComponentImpl;
        private Provider<ConnectionOperationQueueImpl> connectionOperationQueueImplProvider;
        private Provider descriptorWriterProvider;
        private final DeviceComponentImpl deviceComponentImpl;
        private Provider disconnectActionProvider;
        private Provider<DisconnectOperation> disconnectOperationProvider;
        private Provider disconnectionRouterProvider;
        private Provider<IllegalOperationChecker> illegalOperationCheckerProvider;
        private Provider<IllegalOperationMessageCreator> illegalOperationMessageCreatorProvider;
        private Provider<LoggerUtilBluetoothServices> loggerUtilBluetoothServicesProvider;
        private Provider<LoggingIllegalOperationHandler> loggingIllegalOperationHandlerProvider;
        private Provider<LongWriteOperationBuilderImpl> longWriteOperationBuilderImplProvider;
        private Provider mtuBasedPayloadSizeLimitProvider;
        private Provider mtuWatcherProvider;
        private Provider notificationAndIndicationManagerProvider;
        private Provider<Timeout> operationTimeoutProvider;
        private Provider<OperationsProviderImpl> operationsProviderImplProvider;
        private Provider<BluetoothGatt> provideBluetoothGattProvider;
        private Provider<IllegalOperationHandler> provideIllegalOperationHandlerProvider;
        private Provider<TimeoutConfiguration> providesOperationTimeoutConfProvider;
        private Provider<ReadRssiOperation> readRssiOperationProvider;
        private Provider<RxBleConnectionImpl> rxBleConnectionImplProvider;
        private Provider<RxBleGattCallback> rxBleGattCallbackProvider;
        private Provider serviceDiscoveryManagerProvider;
        private Provider<Boolean> suppressOperationChecksProvider;
        private Provider<ThrowingIllegalOperationHandler> throwingIllegalOperationHandlerProvider;

        private ConnectionComponentImpl(ClientComponentImpl clientComponentImpl, DeviceComponentImpl deviceComponentImpl, Boolean bool, Boolean bool2, Timeout timeout) {
            this.connectionComponentImpl = this;
            this.clientComponentImpl = clientComponentImpl;
            this.deviceComponentImpl = deviceComponentImpl;
            this.autoConnect = bool;
            initialize(bool, bool2, timeout);
        }

        private BleConnectionCompat bleConnectionCompat() {
            return new BleConnectionCompat(this.clientComponentImpl.applicationContext);
        }

        private void initialize(Boolean bool, Boolean bool2, Timeout timeout) {
            this.bluetoothGattProvider = DoubleCheck.provider(BluetoothGattProvider_Factory.create());
            this.disconnectionRouterProvider = DoubleCheck.provider(DisconnectionRouter_Factory.create(this.deviceComponentImpl.macAddressProvider, this.clientComponentImpl.rxBleAdapterWrapperProvider, this.clientComponentImpl.rxBleAdapterStateObservableProvider));
            this.rxBleGattCallbackProvider = DoubleCheck.provider(RxBleGattCallback_Factory.create(this.clientComponentImpl.provideBluetoothCallbacksSchedulerProvider, this.bluetoothGattProvider, this.disconnectionRouterProvider, NativeCallbackDispatcher_Factory.create()));
            this.connectionOperationQueueImplProvider = DoubleCheck.provider(ConnectionOperationQueueImpl_Factory.create(this.deviceComponentImpl.macAddressProvider, this.disconnectionRouterProvider, this.clientComponentImpl.provideConnectionQueueExecutorServiceProvider, this.clientComponentImpl.provideBluetoothInteractionSchedulerProvider));
            this.provideBluetoothGattProvider = ConnectionModule_ProvideBluetoothGattFactory.create(this.bluetoothGattProvider);
            this.loggerUtilBluetoothServicesProvider = LoggerUtilBluetoothServices_Factory.create(ConnectionModule_ProvideCharacteristicPropertiesParserFactory.create());
            this.operationTimeoutProvider = InstanceFactory.create(timeout);
            ConnectionModule_ProvidesOperationTimeoutConfFactory create = ConnectionModule_ProvidesOperationTimeoutConfFactory.create(ClientComponent_ClientModule_ProvideComputationSchedulerFactory.create(), this.operationTimeoutProvider);
            this.providesOperationTimeoutConfProvider = create;
            this.readRssiOperationProvider = ReadRssiOperation_Factory.create(this.rxBleGattCallbackProvider, this.provideBluetoothGattProvider, create);
            OperationsProviderImpl_Factory create2 = OperationsProviderImpl_Factory.create(this.rxBleGattCallbackProvider, this.provideBluetoothGattProvider, this.loggerUtilBluetoothServicesProvider, this.providesOperationTimeoutConfProvider, this.clientComponentImpl.provideBluetoothInteractionSchedulerProvider, ClientComponent_ClientModule_ProvideComputationSchedulerFactory.create(), this.readRssiOperationProvider);
            this.operationsProviderImplProvider = create2;
            this.serviceDiscoveryManagerProvider = DoubleCheck.provider(ServiceDiscoveryManager_Factory.create(this.connectionOperationQueueImplProvider, this.provideBluetoothGattProvider, create2));
            this.descriptorWriterProvider = DoubleCheck.provider(DescriptorWriter_Factory.create(this.connectionOperationQueueImplProvider, this.operationsProviderImplProvider));
            this.notificationAndIndicationManagerProvider = DoubleCheck.provider(NotificationAndIndicationManager_Factory.create(ClientComponent_ClientModule_ProvideEnableNotificationValueFactory.create(), ClientComponent_ClientModule_ProvideEnableIndicationValueFactory.create(), ClientComponent_ClientModule_ProvideDisableNotificationValueFactory.create(), this.provideBluetoothGattProvider, this.rxBleGattCallbackProvider, this.descriptorWriterProvider));
            this.mtuWatcherProvider = DoubleCheck.provider(MtuWatcher_Factory.create(this.rxBleGattCallbackProvider, ConnectionModule_MinimumMtuFactory.create()));
            DelegateFactory delegateFactory = new DelegateFactory();
            this.rxBleConnectionImplProvider = delegateFactory;
            Provider provider = DoubleCheck.provider(MtuBasedPayloadSizeLimit_Factory.create(delegateFactory, ConnectionModule_GattWriteMtuOverheadFactory.create()));
            this.mtuBasedPayloadSizeLimitProvider = provider;
            this.longWriteOperationBuilderImplProvider = LongWriteOperationBuilderImpl_Factory.create(this.connectionOperationQueueImplProvider, provider, this.rxBleConnectionImplProvider, this.operationsProviderImplProvider);
            this.suppressOperationChecksProvider = InstanceFactory.create(bool2);
            IllegalOperationMessageCreator_Factory create3 = IllegalOperationMessageCreator_Factory.create(ConnectionModule_ProvideCharacteristicPropertiesParserFactory.create());
            this.illegalOperationMessageCreatorProvider = create3;
            this.loggingIllegalOperationHandlerProvider = LoggingIllegalOperationHandler_Factory.create(create3);
            ThrowingIllegalOperationHandler_Factory create4 = ThrowingIllegalOperationHandler_Factory.create(this.illegalOperationMessageCreatorProvider);
            this.throwingIllegalOperationHandlerProvider = create4;
            ConnectionModule_ProvideIllegalOperationHandlerFactory create5 = ConnectionModule_ProvideIllegalOperationHandlerFactory.create(this.suppressOperationChecksProvider, this.loggingIllegalOperationHandlerProvider, create4);
            this.provideIllegalOperationHandlerProvider = create5;
            this.illegalOperationCheckerProvider = IllegalOperationChecker_Factory.create(create5);
            DelegateFactory.setDelegate(this.rxBleConnectionImplProvider, DoubleCheck.provider(RxBleConnectionImpl_Factory.create(this.connectionOperationQueueImplProvider, this.rxBleGattCallbackProvider, this.provideBluetoothGattProvider, this.serviceDiscoveryManagerProvider, this.notificationAndIndicationManagerProvider, this.mtuWatcherProvider, this.descriptorWriterProvider, this.operationsProviderImplProvider, this.longWriteOperationBuilderImplProvider, this.clientComponentImpl.provideBluetoothInteractionSchedulerProvider, this.illegalOperationCheckerProvider)));
            this.disconnectOperationProvider = DisconnectOperation_Factory.create(this.rxBleGattCallbackProvider, this.bluetoothGattProvider, this.deviceComponentImpl.macAddressProvider, this.clientComponentImpl.provideBluetoothManagerProvider, this.clientComponentImpl.provideBluetoothInteractionSchedulerProvider, this.deviceComponentImpl.providesDisconnectTimeoutConfProvider, this.deviceComponentImpl.provideConnectionStateChangeListenerProvider);
            this.disconnectActionProvider = DoubleCheck.provider(DisconnectAction_Factory.create(this.clientComponentImpl.bindClientOperationQueueProvider, this.disconnectOperationProvider));
        }

        @Override // com.polidea.rxandroidble2.internal.connection.ConnectionComponent
        public ConnectOperation connectOperation() {
            return ConnectOperation_Factory.newInstance(this.deviceComponentImpl.bluetoothDevice(), bleConnectionCompat(), this.rxBleGattCallbackProvider.get(), this.bluetoothGattProvider.get(), this.deviceComponentImpl.namedTimeoutConfiguration(), this.autoConnect.booleanValue(), (ConnectionStateChangeListener) this.deviceComponentImpl.provideConnectionStateChangeListenerProvider.get());
        }

        @Override // com.polidea.rxandroidble2.internal.connection.ConnectionComponent
        public RxBleConnection rxBleConnection() {
            return this.rxBleConnectionImplProvider.get();
        }

        @Override // com.polidea.rxandroidble2.internal.connection.ConnectionComponent
        public RxBleGattCallback gattCallback() {
            return this.rxBleGattCallbackProvider.get();
        }

        @Override // com.polidea.rxandroidble2.internal.connection.ConnectionComponent
        public Set<ConnectionSubscriptionWatcher> connectionSubscriptionWatchers() {
            return SetBuilder.newSetBuilder(3).add((ConnectionSubscriptionWatcher) this.mtuWatcherProvider.get()).add((ConnectionSubscriptionWatcher) this.disconnectActionProvider.get()).add(this.connectionOperationQueueImplProvider.get()).build();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class DeviceComponentImpl implements DeviceComponent {
        private final ClientComponentImpl clientComponentImpl;
        private Provider<ConnectionComponent.Builder> connectionComponentBuilderProvider;
        private Provider<ConnectorImpl> connectorImplProvider;
        private final DeviceComponentImpl deviceComponentImpl;
        private final String macAddress;
        private Provider<String> macAddressProvider;
        private Provider<BluetoothDevice> provideBluetoothDeviceProvider;
        private Provider<ConnectionStateChangeListener> provideConnectionStateChangeListenerProvider;
        private Provider<BehaviorRelay<RxBleConnection.RxBleConnectionState>> provideConnectionStateRelayProvider;
        private Provider<TimeoutConfiguration> providesDisconnectTimeoutConfProvider;
        private Provider rxBleDeviceImplProvider;

        private DeviceComponentImpl(ClientComponentImpl clientComponentImpl, String str) {
            this.deviceComponentImpl = this;
            this.clientComponentImpl = clientComponentImpl;
            this.macAddress = str;
            initialize(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BluetoothDevice bluetoothDevice() {
            return DeviceModule_ProvideBluetoothDeviceFactory.provideBluetoothDevice(this.macAddress, this.clientComponentImpl.rxBleAdapterWrapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public TimeoutConfiguration namedTimeoutConfiguration() {
            return DeviceModule_ProvidesConnectTimeoutConfFactory.providesConnectTimeoutConf(ClientComponent_ClientModule_ProvideComputationSchedulerFactory.provideComputationScheduler());
        }

        private void initialize(String str) {
            Factory create = InstanceFactory.create(str);
            this.macAddressProvider = create;
            this.provideBluetoothDeviceProvider = DeviceModule_ProvideBluetoothDeviceFactory.create(create, this.clientComponentImpl.rxBleAdapterWrapperProvider);
            this.connectionComponentBuilderProvider = new Provider<ConnectionComponent.Builder>() { // from class: com.polidea.rxandroidble2.DaggerClientComponent.DeviceComponentImpl.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // bleshadow.javax.inject.Provider
                public ConnectionComponent.Builder get() {
                    return new ConnectionComponentBuilder(DeviceComponentImpl.this.clientComponentImpl, DeviceComponentImpl.this.deviceComponentImpl);
                }
            };
            this.connectorImplProvider = ConnectorImpl_Factory.create(this.clientComponentImpl.bindClientOperationQueueProvider, this.connectionComponentBuilderProvider, this.clientComponentImpl.provideBluetoothCallbacksSchedulerProvider);
            Provider<BehaviorRelay<RxBleConnection.RxBleConnectionState>> provider = DoubleCheck.provider(DeviceModule_ProvideConnectionStateRelayFactory.create());
            this.provideConnectionStateRelayProvider = provider;
            this.rxBleDeviceImplProvider = DoubleCheck.provider(RxBleDeviceImpl_Factory.create(this.provideBluetoothDeviceProvider, this.connectorImplProvider, provider, this.clientComponentImpl.checkerConnectPermissionProvider));
            this.provideConnectionStateChangeListenerProvider = DoubleCheck.provider(DeviceModule_ProvideConnectionStateChangeListenerFactory.create(this.provideConnectionStateRelayProvider));
            this.providesDisconnectTimeoutConfProvider = DeviceModule_ProvidesDisconnectTimeoutConfFactory.create(ClientComponent_ClientModule_ProvideComputationSchedulerFactory.create());
        }

        @Override // com.polidea.rxandroidble2.internal.DeviceComponent
        public RxBleDevice provideDevice() {
            return (RxBleDevice) this.rxBleDeviceImplProvider.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class ClientComponentImpl implements ClientComponent {
        private Provider<AndroidScanObjectsConverter> androidScanObjectsConverterProvider;
        private final Context applicationContext;
        private Provider<Context> applicationContextProvider;
        private Provider<BackgroundScannerImpl> backgroundScannerImplProvider;
        private Provider<ClientOperationQueue> bindClientOperationQueueProvider;
        private Provider<RxBleClient> bindRxBleClientProvider;
        private Provider<BluetoothManagerWrapper> bluetoothManagerWrapperProvider;
        private Provider<CheckerConnectPermission> checkerConnectPermissionProvider;
        private Provider<CheckerLocationProvider> checkerLocationProvider;
        private Provider<CheckerPermission> checkerPermissionProvider;
        private Provider<CheckerScanPermission> checkerScanPermissionProvider;
        private final ClientComponentImpl clientComponentImpl;
        private Provider<ClientOperationQueueImpl> clientOperationQueueImplProvider;
        private Provider<ClientStateObservable> clientStateObservableProvider;
        private Provider<DeviceComponent.Builder> deviceComponentBuilderProvider;
        private Provider<DeviceComponentCache> deviceComponentCacheProvider;
        private Provider<InternalScanResultCreator> internalScanResultCreatorProvider;
        private Provider<InternalToExternalScanResultConverter> internalToExternalScanResultConverterProvider;
        private Provider<LocationServicesOkObservableApi23Factory> locationServicesOkObservableApi23FactoryProvider;
        private Provider<LocationServicesStatusApi23> locationServicesStatusApi23Provider;
        private Provider<LocationServicesStatusApi31> locationServicesStatusApi31Provider;
        private Provider<Scheduler> provideBluetoothCallbacksSchedulerProvider;
        private Provider<ExecutorService> provideBluetoothInteractionExecutorServiceProvider;
        private Provider<Scheduler> provideBluetoothInteractionSchedulerProvider;
        private Provider<BluetoothManager> provideBluetoothManagerProvider;
        private Provider<ExecutorService> provideConnectionQueueExecutorServiceProvider;
        private Provider<ContentResolver> provideContentResolverProvider;
        private Provider<ClientComponent.ClientComponentFinalizer> provideFinalizationCloseableProvider;
        private Provider<Boolean> provideIsAndroidWearProvider;
        private Provider<IsConnectableChecker> provideIsConnectableCheckerProvider;
        private Provider<Boolean> provideIsNearbyPermissionNeverForLocationProvider;
        private Provider<LocationManager> provideLocationManagerProvider;
        private Provider<Observable<Boolean>> provideLocationServicesOkObservableProvider;
        private Provider<LocationServicesStatus> provideLocationServicesStatusProvider;
        private Provider<String[][]> provideRecommendedConnectRuntimePermissionNamesProvider;
        private Provider<String[][]> provideRecommendedScanRuntimePermissionNamesProvider;
        private Provider<ScanPreconditionsVerifier> provideScanPreconditionVerifierProvider;
        private Provider<ScanSetupBuilder> provideScanSetupProvider;
        private Provider<Integer> provideTargetSdkProvider;
        private Provider<RxBleAdapterStateObservable> rxBleAdapterStateObservableProvider;
        private Provider<RxBleAdapterWrapper> rxBleAdapterWrapperProvider;
        private Provider<RxBleClientImpl> rxBleClientImplProvider;
        private Provider<RxBleDeviceProvider> rxBleDeviceProvider;
        private Provider<ScanPreconditionsVerifierApi18> scanPreconditionsVerifierApi18Provider;
        private Provider<ScanPreconditionsVerifierApi24> scanPreconditionsVerifierApi24Provider;
        private Provider<ScanSettingsEmulator> scanSettingsEmulatorProvider;
        private Provider<ScanSetupBuilderImplApi18> scanSetupBuilderImplApi18Provider;
        private Provider<ScanSetupBuilderImplApi21> scanSetupBuilderImplApi21Provider;
        private Provider<ScanSetupBuilderImplApi23> scanSetupBuilderImplApi23Provider;

        private ClientComponentImpl(Context context) {
            this.clientComponentImpl = this;
            this.applicationContext = context;
            initialize(context);
        }

        private LocationServicesStatus locationServicesStatus() {
            return ClientComponent_ClientModule_ProvideLocationServicesStatusFactory.provideLocationServicesStatus(ClientComponent.ClientModule.provideDeviceSdk(), LocationServicesStatusApi18_Factory.create(), this.locationServicesStatusApi23Provider, this.locationServicesStatusApi31Provider);
        }

        private LocationServicesOkObservableApi23Factory locationServicesOkObservableApi23Factory() {
            return LocationServicesOkObservableApi23Factory_Factory.newInstance(this.applicationContext, locationServicesStatus());
        }

        private Observable<Boolean> namedObservableOfBoolean() {
            return ClientComponent_ClientModule_ProvideLocationServicesOkObservableFactory.provideLocationServicesOkObservable(ClientComponent.ClientModule.provideDeviceSdk(), locationServicesOkObservableApi23Factory());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public RxBleAdapterWrapper rxBleAdapterWrapper() {
            return new RxBleAdapterWrapper(ClientComponent.ClientModule.provideBluetoothAdapter());
        }

        private void initialize(Context context) {
            Factory create = InstanceFactory.create(context);
            this.applicationContextProvider = create;
            this.provideContentResolverProvider = ClientComponent_ClientModule_ProvideContentResolverFactory.create(create);
            ClientComponent_ClientModule_ProvideLocationManagerFactory create2 = ClientComponent_ClientModule_ProvideLocationManagerFactory.create(this.applicationContextProvider);
            this.provideLocationManagerProvider = create2;
            this.checkerLocationProvider = CheckerLocationProvider_Factory.create(this.provideContentResolverProvider, create2);
            this.checkerPermissionProvider = DoubleCheck.provider(CheckerPermission_Factory.create(this.applicationContextProvider));
            this.provideTargetSdkProvider = ClientComponent_ClientModule_ProvideTargetSdkFactory.create(this.applicationContextProvider);
            this.provideIsNearbyPermissionNeverForLocationProvider = DoubleCheck.provider(ClientComponent_ClientModule_ProvideIsNearbyPermissionNeverForLocationFactory.create(this.applicationContextProvider));
            ClientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactory create3 = ClientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactory.create(ClientComponent_ClientModule_ProvideDeviceSdkFactory.create(), this.provideTargetSdkProvider, this.provideIsNearbyPermissionNeverForLocationProvider);
            this.provideRecommendedScanRuntimePermissionNamesProvider = create3;
            this.checkerScanPermissionProvider = DoubleCheck.provider(CheckerScanPermission_Factory.create(this.checkerPermissionProvider, create3));
            this.provideIsAndroidWearProvider = ClientComponent_ClientModule_ProvideIsAndroidWearFactory.create(this.applicationContextProvider, ClientComponent_ClientModule_ProvideDeviceSdkFactory.create());
            this.locationServicesStatusApi23Provider = LocationServicesStatusApi23_Factory.create(this.checkerLocationProvider, this.checkerScanPermissionProvider, this.provideTargetSdkProvider, ClientComponent_ClientModule_ProvideDeviceSdkFactory.create(), this.provideIsAndroidWearProvider);
            this.locationServicesStatusApi31Provider = LocationServicesStatusApi31_Factory.create(this.checkerLocationProvider, this.checkerScanPermissionProvider, this.provideIsAndroidWearProvider, this.provideIsNearbyPermissionNeverForLocationProvider);
            ClientComponent_ClientModule_ProvideBluetoothManagerFactory create4 = ClientComponent_ClientModule_ProvideBluetoothManagerFactory.create(this.applicationContextProvider);
            this.provideBluetoothManagerProvider = create4;
            this.bluetoothManagerWrapperProvider = BluetoothManagerWrapper_Factory.create(create4);
            this.rxBleAdapterWrapperProvider = RxBleAdapterWrapper_Factory.create(ClientComponent_ClientModule_ProvideBluetoothAdapterFactory.create());
            Provider<ExecutorService> provider = DoubleCheck.provider(ClientComponent_ClientModule_ProvideBluetoothInteractionExecutorServiceFactory.create());
            this.provideBluetoothInteractionExecutorServiceProvider = provider;
            Provider<Scheduler> provider2 = DoubleCheck.provider(ClientComponent_ClientModule_ProvideBluetoothInteractionSchedulerFactory.create(provider));
            this.provideBluetoothInteractionSchedulerProvider = provider2;
            ClientOperationQueueImpl_Factory create5 = ClientOperationQueueImpl_Factory.create(provider2);
            this.clientOperationQueueImplProvider = create5;
            this.bindClientOperationQueueProvider = DoubleCheck.provider(create5);
            this.rxBleAdapterStateObservableProvider = RxBleAdapterStateObservable_Factory.create(this.applicationContextProvider);
            ClientComponent_ClientModule_ProvideLocationServicesStatusFactory create6 = ClientComponent_ClientModule_ProvideLocationServicesStatusFactory.create(ClientComponent_ClientModule_ProvideDeviceSdkFactory.create(), LocationServicesStatusApi18_Factory.create(), this.locationServicesStatusApi23Provider, this.locationServicesStatusApi31Provider);
            this.provideLocationServicesStatusProvider = create6;
            this.locationServicesOkObservableApi23FactoryProvider = LocationServicesOkObservableApi23Factory_Factory.create(this.applicationContextProvider, create6);
            ClientComponent_ClientModule_ProvideLocationServicesOkObservableFactory create7 = ClientComponent_ClientModule_ProvideLocationServicesOkObservableFactory.create(ClientComponent_ClientModule_ProvideDeviceSdkFactory.create(), this.locationServicesOkObservableApi23FactoryProvider);
            this.provideLocationServicesOkObservableProvider = create7;
            this.clientStateObservableProvider = ClientStateObservable_Factory.create(this.rxBleAdapterWrapperProvider, this.rxBleAdapterStateObservableProvider, create7, this.provideLocationServicesStatusProvider, ClientComponent_ClientModule_ProvideComputationSchedulerFactory.create());
            this.deviceComponentCacheProvider = DoubleCheck.provider(DeviceComponentCache_Factory.create());
            Provider<DeviceComponent.Builder> provider3 = new Provider<DeviceComponent.Builder>() { // from class: com.polidea.rxandroidble2.DaggerClientComponent.ClientComponentImpl.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // bleshadow.javax.inject.Provider
                public DeviceComponent.Builder get() {
                    return new DeviceComponentBuilder(ClientComponentImpl.this.clientComponentImpl);
                }
            };
            this.deviceComponentBuilderProvider = provider3;
            this.rxBleDeviceProvider = DoubleCheck.provider(RxBleDeviceProvider_Factory.create(this.deviceComponentCacheProvider, provider3));
            this.provideIsConnectableCheckerProvider = DoubleCheck.provider(ClientComponent_ClientModule_ProvideIsConnectableCheckerFactory.create(ClientComponent_ClientModule_ProvideDeviceSdkFactory.create(), IsConnectableCheckerApi18_Factory.create(), IsConnectableCheckerApi26_Factory.create()));
            this.internalScanResultCreatorProvider = DoubleCheck.provider(InternalScanResultCreator_Factory.create(ScanRecordParser_Factory.create(), this.provideIsConnectableCheckerProvider));
            ScanSettingsEmulator_Factory create8 = ScanSettingsEmulator_Factory.create(ClientComponent_ClientModule_ProvideComputationSchedulerFactory.create());
            this.scanSettingsEmulatorProvider = create8;
            this.scanSetupBuilderImplApi18Provider = ScanSetupBuilderImplApi18_Factory.create(this.rxBleAdapterWrapperProvider, this.internalScanResultCreatorProvider, create8);
            AndroidScanObjectsConverter_Factory create9 = AndroidScanObjectsConverter_Factory.create(ClientComponent_ClientModule_ProvideDeviceSdkFactory.create());
            this.androidScanObjectsConverterProvider = create9;
            this.scanSetupBuilderImplApi21Provider = ScanSetupBuilderImplApi21_Factory.create(this.rxBleAdapterWrapperProvider, this.internalScanResultCreatorProvider, this.scanSettingsEmulatorProvider, create9);
            this.scanSetupBuilderImplApi23Provider = ScanSetupBuilderImplApi23_Factory.create(this.rxBleAdapterWrapperProvider, this.internalScanResultCreatorProvider, this.scanSettingsEmulatorProvider, this.androidScanObjectsConverterProvider);
            this.provideScanSetupProvider = DoubleCheck.provider(ClientComponent_ClientModule_ProvideScanSetupProviderFactory.create(ClientComponent_ClientModule_ProvideDeviceSdkFactory.create(), this.scanSetupBuilderImplApi18Provider, this.scanSetupBuilderImplApi21Provider, this.scanSetupBuilderImplApi23Provider));
            ScanPreconditionsVerifierApi18_Factory create10 = ScanPreconditionsVerifierApi18_Factory.create(this.rxBleAdapterWrapperProvider, this.provideLocationServicesStatusProvider);
            this.scanPreconditionsVerifierApi18Provider = create10;
            this.scanPreconditionsVerifierApi24Provider = ScanPreconditionsVerifierApi24_Factory.create(create10, ClientComponent_ClientModule_ProvideComputationSchedulerFactory.create());
            this.provideScanPreconditionVerifierProvider = ClientComponent_ClientModule_ProvideScanPreconditionVerifierFactory.create(ClientComponent_ClientModule_ProvideDeviceSdkFactory.create(), this.scanPreconditionsVerifierApi18Provider, this.scanPreconditionsVerifierApi24Provider);
            this.internalToExternalScanResultConverterProvider = InternalToExternalScanResultConverter_Factory.create(this.rxBleDeviceProvider);
            this.provideBluetoothCallbacksSchedulerProvider = DoubleCheck.provider(ClientComponent_ClientModule_ProvideBluetoothCallbacksSchedulerFactory.create());
            Provider<ExecutorService> provider4 = DoubleCheck.provider(ClientComponent_ClientModule_ProvideConnectionQueueExecutorServiceFactory.create());
            this.provideConnectionQueueExecutorServiceProvider = provider4;
            this.provideFinalizationCloseableProvider = ClientComponent_ClientModule_ProvideFinalizationCloseableFactory.create(this.provideBluetoothInteractionExecutorServiceProvider, this.provideBluetoothCallbacksSchedulerProvider, provider4);
            this.backgroundScannerImplProvider = BackgroundScannerImpl_Factory.create(this.rxBleAdapterWrapperProvider, this.androidScanObjectsConverterProvider, this.internalScanResultCreatorProvider, this.internalToExternalScanResultConverterProvider);
            ClientComponent_ClientModule_ProvideRecommendedConnectRuntimePermissionNamesFactory create11 = ClientComponent_ClientModule_ProvideRecommendedConnectRuntimePermissionNamesFactory.create(ClientComponent_ClientModule_ProvideDeviceSdkFactory.create(), this.provideTargetSdkProvider);
            this.provideRecommendedConnectRuntimePermissionNamesProvider = create11;
            this.checkerConnectPermissionProvider = DoubleCheck.provider(CheckerConnectPermission_Factory.create(this.checkerPermissionProvider, create11));
            RxBleClientImpl_Factory create12 = RxBleClientImpl_Factory.create(this.bluetoothManagerWrapperProvider, this.rxBleAdapterWrapperProvider, this.bindClientOperationQueueProvider, this.rxBleAdapterStateObservableProvider, ScanRecordParser_Factory.create(), this.provideLocationServicesStatusProvider, this.clientStateObservableProvider, this.rxBleDeviceProvider, this.provideScanSetupProvider, this.provideScanPreconditionVerifierProvider, this.internalToExternalScanResultConverterProvider, this.provideBluetoothInteractionSchedulerProvider, this.provideFinalizationCloseableProvider, this.backgroundScannerImplProvider, this.checkerScanPermissionProvider, this.checkerConnectPermissionProvider);
            this.rxBleClientImplProvider = create12;
            this.bindRxBleClientProvider = DoubleCheck.provider(create12);
        }

        @Override // com.polidea.rxandroidble2.ClientComponent
        public LocationServicesOkObservable locationServicesOkObservable() {
            return LocationServicesOkObservable_Factory.newInstance(namedObservableOfBoolean());
        }

        @Override // com.polidea.rxandroidble2.ClientComponent
        public RxBleClient rxBleClient() {
            return this.bindRxBleClientProvider.get();
        }
    }
}
