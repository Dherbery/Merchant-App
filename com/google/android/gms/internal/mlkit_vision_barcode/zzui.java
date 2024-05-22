package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public final class zzui {
    private static zzuh zza;

    public static synchronized zztx zza(zztp zztpVar) {
        zztx zztxVar;
        synchronized (zzui.class) {
            if (zza == null) {
                zza = new zzuh(null);
            }
            zztxVar = (zztx) zza.get(zztpVar);
        }
        return zztxVar;
    }

    public static synchronized zztx zzb(String str) {
        zztx zza2;
        synchronized (zzui.class) {
            zza2 = zza(zztp.zzd(str).zzd());
        }
        return zza2;
    }
}
