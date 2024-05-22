package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import bleshadow.javax.inject.Inject;
import java.util.concurrent.atomic.AtomicReference;

@ConnectionScope
/* loaded from: classes5.dex */
public class BluetoothGattProvider {
    private final AtomicReference<BluetoothGatt> reference = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public BluetoothGattProvider() {
    }

    public BluetoothGatt getBluetoothGatt() {
        return this.reference.get();
    }

    public void updateBluetoothGatt(BluetoothGatt bluetoothGatt) {
        LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.reference, null, bluetoothGatt);
    }
}
