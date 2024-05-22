package com.bleplx.adapter.utils;

import android.bluetooth.BluetoothGatt;
import com.polidea.rxandroidble2.RxBleCustomOperation;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class RefreshGattCustomOperation implements RxBleCustomOperation<Boolean> {
    @Override // com.polidea.rxandroidble2.RxBleCustomOperation
    public Observable<Boolean> asObservable(final BluetoothGatt bluetoothGatt, RxBleGattCallback rxBleGattCallback, Scheduler scheduler) {
        return Observable.ambArray(Observable.fromCallable(new Callable() { // from class: com.bleplx.adapter.utils.RefreshGattCustomOperation$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return RefreshGattCustomOperation.lambda$asObservable$0(bluetoothGatt);
            }
        }).subscribeOn(scheduler).delay(1L, TimeUnit.SECONDS, scheduler), rxBleGattCallback.observeDisconnect());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Boolean lambda$asObservable$0(android.bluetooth.BluetoothGatt r4) throws java.lang.Exception {
        /*
            r0 = 0
            java.lang.Class r1 = r4.getClass()     // Catch: java.lang.Exception -> L25
            java.lang.String r2 = "refresh"
            java.lang.Class[] r3 = new java.lang.Class[r0]     // Catch: java.lang.Exception -> L25
            java.lang.reflect.Method r1 = r1.getMethod(r2, r3)     // Catch: java.lang.Exception -> L25
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L25
            java.lang.Object r4 = r1.invoke(r4, r2)     // Catch: java.lang.Exception -> L25
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch: java.lang.Exception -> L25
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Exception -> L25
            if (r4 != 0) goto L2e
            java.lang.String r1 = "BluetoothGatt.refresh() returned false"
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L23
            com.polidea.rxandroidble2.internal.RxBleLog.d(r1, r2)     // Catch: java.lang.Exception -> L23
            goto L2e
        L23:
            r1 = move-exception
            goto L27
        L25:
            r1 = move-exception
            r4 = r0
        L27:
            java.lang.String r2 = "Could not call function BluetoothGatt.refresh()"
            java.lang.Object[] r3 = new java.lang.Object[r0]
            com.polidea.rxandroidble2.internal.RxBleLog.d(r1, r2, r3)
        L2e:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r4 == 0) goto L36
            java.lang.String r2 = "Success"
            goto L38
        L36:
            java.lang.String r2 = "Failure"
        L38:
            r1[r0] = r2
            java.lang.String r0 = "Calling BluetoothGatt.refresh() status: %s"
            com.polidea.rxandroidble2.internal.RxBleLog.i(r0, r1)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bleplx.adapter.utils.RefreshGattCustomOperation.lambda$asObservable$0(android.bluetooth.BluetoothGatt):java.lang.Boolean");
    }
}
