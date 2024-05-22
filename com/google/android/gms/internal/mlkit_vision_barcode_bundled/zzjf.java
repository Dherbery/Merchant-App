package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zzjf extends zzed implements zzfp {
    private static final zzjf zza;
    private int zzd;
    private int zze;
    private int zzf = 100;
    private int zzg;

    static {
        zzjf zzjfVar = new zzjf();
        zza = zzjfVar;
        zzed.zzU(zzjf.class, zzjfVar);
    }

    private zzjf() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", zzjd.zza, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzjf();
        }
        if (i2 == 4) {
            return new zzje(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
