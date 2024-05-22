package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public final class zzuj {
    private static zzuj zza;

    private zzuj() {
    }

    public static synchronized zzuj zza() {
        zzuj zzujVar;
        synchronized (zzuj.class) {
            if (zza == null) {
                zza = new zzuj();
            }
            zzujVar = zza;
        }
        return zzujVar;
    }
}
