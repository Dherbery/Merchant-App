package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zzht extends zzed implements zzfp {
    private static final zzht zza;
    private int zzd;
    private int zze;
    private zzjx zzf;
    private zzjj zzg;
    private zzjl zzh;

    static {
        zzht zzhtVar = new zzht();
        zza = zzhtVar;
        zzed.zzU(zzht.class, zzhtVar);
    }

    private zzht() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0005ဉ\u0003", new Object[]{"zzd", "zze", zzir.zza, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzht();
        }
        if (i2 == 4) {
            return new zzhs(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
