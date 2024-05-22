package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zzjc extends zzed implements zzfp {
    private static final zzjc zza;
    private int zzd;
    private boolean zzf;
    private int zzg;
    private boolean zzj;
    private int zzm;
    private int zzn;
    private boolean zzo;
    private int zze = -1;
    private zzdb zzh = zzdb.zzb;
    private String zzi = "";
    private boolean zzk = true;
    private boolean zzl = true;

    static {
        zzjc zzjcVar = new zzjc();
        zza = zzjcVar;
        zzed.zzU(zzjc.class, zzjcVar);
    }

    private zzjc() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzeh zzehVar = zzjb.zza;
            return zzR(zza, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001င\u0000\u0002ဇ\u0001\u0003᠌\u0002\u0004ည\u0003\u0005ဈ\u0004\u0006ဇ\u0005\u0007ဇ\u0006\bဇ\u0007\t᠌\b\n᠌\t\u000bဇ\n", new Object[]{"zzd", "zze", "zzf", "zzg", zzja.zza, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", zzehVar, "zzn", zzehVar, "zzo"});
        }
        if (i2 == 3) {
            return new zzjc();
        }
        if (i2 == 4) {
            return new zziz(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
