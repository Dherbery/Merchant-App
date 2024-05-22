package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public final class zzar {
    private static final zzbf zza;

    static {
        zzbf zzaqVar;
        try {
            SystemClock.elapsedRealtimeNanos();
            zzaqVar = new zzap();
        } catch (Throwable unused) {
            SystemClock.elapsedRealtime();
            zzaqVar = new zzaq();
        }
        zza = zzaqVar;
    }

    public static zzbf zza() {
        return zza;
    }
}
