package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zzjl extends zzed implements zzfp {
    private static final zzjl zza;
    private int zzd;
    private zzel zze = zzO();
    private zzjn zzf;
    private zzhv zzg;

    static {
        zzjl zzjlVar = new zzjl();
        zza = zzjlVar;
        zzed.zzU(zzjl.class, zzjlVar);
    }

    private zzjl() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzd", "zze", zzjx.class, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzjl();
        }
        if (i2 == 4) {
            return new zzjk(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
