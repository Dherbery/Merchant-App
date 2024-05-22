package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zzf extends zzed implements zzfp {
    public static final zzeb zza;
    private static final zzf zzd;
    private int zze;
    private zzkd zzj;
    private zzf zzk;
    private zzy zzl;
    private byte zzm = 2;
    private String zzf = "";
    private zzel zzg = zzO();
    private zzel zzh = zzO();
    private zzel zzi = zzO();

    static {
        zzf zzfVar = new zzf();
        zzd = zzfVar;
        zzed.zzU(zzf.class, zzfVar);
        zza = zzed.zzH(zzkd.zzf(), zzfVar, zzfVar, null, 12208774, zzho.MESSAGE, zzf.class);
    }

    private zzf() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i2 == 2) {
            return zzR(zzd, "\u0001\u0007\u0000\u0001\u0002Ǵ\u0007\u0000\u0003\u0004\u0002Л\u0005Л\u0006\u001b\bᐉ\u0001\nဈ\u0000\u000bᐉ\u0002Ǵဉ\u0003", new Object[]{"zze", "zzg", zzj.class, "zzi", zzj.class, "zzh", zzm.class, "zzj", "zzf", "zzk", "zzl"});
        }
        if (i2 == 3) {
            return new zzf();
        }
        if (i2 == 4) {
            return new zze(null);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzm = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
