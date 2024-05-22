package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zzv extends zzed implements zzfp {
    public static final zzeb zza;
    private static final zzv zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private zzkd zzh;
    private byte zzi = 2;

    static {
        zzv zzvVar = new zzv();
        zzd = zzvVar;
        zzed.zzU(zzv.class, zzvVar);
        zza = zzed.zzH(zzkd.zzf(), zzvVar, zzvVar, null, 13258261, zzho.MESSAGE, zzv.class);
    }

    private zzv() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzR(zzd, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔅ\u0000\u0002ᔅ\u0001\u0003ᐉ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzv();
        }
        if (i2 == 4) {
            return new zzu(null);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
