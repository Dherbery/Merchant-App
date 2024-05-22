package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.9.0 */
/* loaded from: classes4.dex */
public final class zzqk {
    private static zzqj zza;

    public static synchronized zzpz zza(zzpt zzptVar) {
        zzpz zzpzVar;
        synchronized (zzqk.class) {
            if (zza == null) {
                zza = new zzqj(null);
            }
            zzpzVar = (zzpz) zza.get(zzptVar);
        }
        return zzpzVar;
    }

    public static synchronized zzpz zzb(String str) {
        zzpz zza2;
        synchronized (zzqk.class) {
            zza2 = zza(zzpt.zzd("common").zzd());
        }
        return zza2;
    }
}
