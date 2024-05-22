package com.polidea.rxandroidble2.internal;

import android.bluetooth.BluetoothDevice;
import bleshadow.javax.inject.Inject;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.polidea.rxandroidble2.ConnectionSetup;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleDevice;
import com.polidea.rxandroidble2.Timeout;
import com.polidea.rxandroidble2.exceptions.BleAlreadyConnectedException;
import com.polidea.rxandroidble2.internal.connection.Connector;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.util.CheckerConnectPermission;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Action;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: Access modifiers changed from: package-private */
@DeviceScope
/* loaded from: classes5.dex */
public class RxBleDeviceImpl implements RxBleDevice {
    final BluetoothDevice bluetoothDevice;
    private final CheckerConnectPermission checkerConnectPermission;
    private final BehaviorRelay<RxBleConnection.RxBleConnectionState> connectionStateRelay;
    final Connector connector;
    final AtomicBoolean isConnected = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public RxBleDeviceImpl(BluetoothDevice bluetoothDevice, Connector connector, BehaviorRelay<RxBleConnection.RxBleConnectionState> behaviorRelay, CheckerConnectPermission checkerConnectPermission) {
        this.bluetoothDevice = bluetoothDevice;
        this.connector = connector;
        this.connectionStateRelay = behaviorRelay;
        this.checkerConnectPermission = checkerConnectPermission;
    }

    @Override // com.polidea.rxandroidble2.RxBleDevice
    public Observable<RxBleConnection.RxBleConnectionState> observeConnectionStateChanges() {
        return this.connectionStateRelay.distinctUntilChanged().skip(1L);
    }

    @Override // com.polidea.rxandroidble2.RxBleDevice
    public RxBleConnection.RxBleConnectionState getConnectionState() {
        return this.connectionStateRelay.getValue();
    }

    @Override // com.polidea.rxandroidble2.RxBleDevice
    public Observable<RxBleConnection> establishConnection(boolean z) {
        return establishConnection(new ConnectionSetup.Builder().setAutoConnect(z).setSuppressIllegalOperationCheck(true).build());
    }

    @Override // com.polidea.rxandroidble2.RxBleDevice
    public Observable<RxBleConnection> establishConnection(boolean z, Timeout timeout) {
        return establishConnection(new ConnectionSetup.Builder().setAutoConnect(z).setOperationTimeout(timeout).setSuppressIllegalOperationCheck(true).build());
    }

    public Observable<RxBleConnection> establishConnection(final ConnectionSetup connectionSetup) {
        return Observable.defer(new Callable() { // from class: com.polidea.rxandroidble2.internal.RxBleDeviceImpl$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return RxBleDeviceImpl.this.m1048x8d54919a(connectionSetup);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$establishConnection$1$com-polidea-rxandroidble2-internal-RxBleDeviceImpl, reason: not valid java name */
    public /* synthetic */ ObservableSource m1048x8d54919a(ConnectionSetup connectionSetup) throws Exception {
        if (this.isConnected.compareAndSet(false, true)) {
            return this.connector.prepareConnection(connectionSetup).doFinally(new Action() { // from class: com.polidea.rxandroidble2.internal.RxBleDeviceImpl$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Action
                public final void run() {
                    RxBleDeviceImpl.this.m1047x5f7bf73b();
                }
            });
        }
        return Observable.error(new BleAlreadyConnectedException(this.bluetoothDevice.getAddress()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$establishConnection$0$com-polidea-rxandroidble2-internal-RxBleDeviceImpl, reason: not valid java name */
    public /* synthetic */ void m1047x5f7bf73b() throws Exception {
        this.isConnected.set(false);
    }

    @Override // com.polidea.rxandroidble2.RxBleDevice
    public String getName() {
        return getName(false);
    }

    private String getName(boolean z) {
        return (!z || this.checkerConnectPermission.isConnectRuntimePermissionGranted()) ? this.bluetoothDevice.getName() : "[NO BLUETOOTH_CONNECT PERMISSION]";
    }

    @Override // com.polidea.rxandroidble2.RxBleDevice
    public String getMacAddress() {
        return this.bluetoothDevice.getAddress();
    }

    @Override // com.polidea.rxandroidble2.RxBleDevice
    public BluetoothDevice getBluetoothDevice() {
        return this.bluetoothDevice;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RxBleDeviceImpl) {
            return this.bluetoothDevice.equals(((RxBleDeviceImpl) obj).bluetoothDevice);
        }
        return false;
    }

    public int hashCode() {
        return this.bluetoothDevice.hashCode();
    }

    public String toString() {
        return "RxBleDeviceImpl{" + LoggerUtil.commonMacMessage(this.bluetoothDevice.getAddress()) + ", name=" + getName(true) + AbstractJsonLexerKt.END_OBJ;
    }
}
