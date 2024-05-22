package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import com.polidea.rxandroidble2.RxBleDeviceServices;
import com.polidea.rxandroidble2.exceptions.BleGattCallbackTimeoutException;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.SingleResponseOperation;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtilBluetoothServices;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class ServiceDiscoveryOperation extends SingleResponseOperation<RxBleDeviceServices> {
    final LoggerUtilBluetoothServices bleServicesLogger;
    final BluetoothGatt bluetoothGatt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceDiscoveryOperation(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, LoggerUtilBluetoothServices loggerUtilBluetoothServices, TimeoutConfiguration timeoutConfiguration) {
        super(bluetoothGatt, rxBleGattCallback, BleGattOperationType.SERVICE_DISCOVERY, timeoutConfiguration);
        this.bluetoothGatt = bluetoothGatt;
        this.bleServicesLogger = loggerUtilBluetoothServices;
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    protected Single<RxBleDeviceServices> getCallback(RxBleGattCallback rxBleGattCallback) {
        return rxBleGattCallback.getOnServicesDiscovered().firstOrError().doOnSuccess(new Consumer() { // from class: com.polidea.rxandroidble2.internal.operations.ServiceDiscoveryOperation$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ServiceDiscoveryOperation.this.m1052xb394fc7f((RxBleDeviceServices) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getCallback$0$com-polidea-rxandroidble2-internal-operations-ServiceDiscoveryOperation, reason: not valid java name */
    public /* synthetic */ void m1052xb394fc7f(RxBleDeviceServices rxBleDeviceServices) throws Exception {
        this.bleServicesLogger.log(rxBleDeviceServices, this.bluetoothGatt.getDevice());
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    protected boolean startOperation(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt.discoverServices();
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    protected Single<RxBleDeviceServices> timeoutFallbackProcedure(final BluetoothGatt bluetoothGatt, RxBleGattCallback rxBleGattCallback, final Scheduler scheduler) {
        return Single.defer(new Callable() { // from class: com.polidea.rxandroidble2.internal.operations.ServiceDiscoveryOperation$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ServiceDiscoveryOperation.lambda$timeoutFallbackProcedure$3(bluetoothGatt, scheduler);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ SingleSource lambda$timeoutFallbackProcedure$3(final BluetoothGatt bluetoothGatt, Scheduler scheduler) throws Exception {
        if (bluetoothGatt.getServices().size() == 0) {
            return Single.error(new BleGattCallbackTimeoutException(bluetoothGatt, BleGattOperationType.SERVICE_DISCOVERY));
        }
        return Single.timer(5L, TimeUnit.SECONDS, scheduler).flatMap(new Function() { // from class: com.polidea.rxandroidble2.internal.operations.ServiceDiscoveryOperation$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Single fromCallable;
                fromCallable = Single.fromCallable(new Callable() { // from class: com.polidea.rxandroidble2.internal.operations.ServiceDiscoveryOperation$$ExternalSyntheticLambda0
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return ServiceDiscoveryOperation.lambda$timeoutFallbackProcedure$1(r1);
                    }
                });
                return fromCallable;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ RxBleDeviceServices lambda$timeoutFallbackProcedure$1(BluetoothGatt bluetoothGatt) throws Exception {
        return new RxBleDeviceServices(bluetoothGatt.getServices());
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public String toString() {
        return "ServiceDiscoveryOperation{" + super.toString() + AbstractJsonLexerKt.END_OBJ;
    }
}
