package com.google.android.gms.internal.mlkit_vision_barcode;

import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public final class zzdz extends zzea {
    public static int zza(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }
}
