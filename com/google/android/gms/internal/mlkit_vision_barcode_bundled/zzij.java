package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zzij extends zzed implements zzfp {
    private static final zzij zza;
    private int zzd;
    private int zze;
    private int zzf;
    private zzel zzg = zzed.zzO();
    private int zzh;

    static {
        zzij zzijVar = new zzij();
        zza = zzijVar;
        zzed.zzU(zzij.class, zzijVar);
    }

    private zzij() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002င\u0001\u0003\u001a\u0004င\u0002", new Object[]{"zzd", "zze", zzii.zza, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzij();
        }
        if (i2 == 4) {
            return new zzih(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
