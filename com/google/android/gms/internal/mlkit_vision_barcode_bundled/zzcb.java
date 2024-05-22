package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.List;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zzcb extends zzed implements zzfp {
    private static final zzcb zza;
    private int zzd;
    private int zze;
    private zzf zzg;
    private byte zzh = 2;
    private zzel zzf = zzed.zzO();

    static {
        zzcb zzcbVar = new zzcb();
        zza = zzcbVar;
        zzed.zzU(zzcb.class, zzcbVar);
    }

    private zzcb() {
    }

    public final List zzb() {
        return this.zzf;
    }

    public final int zzc() {
        int zza2 = zzca.zza(this.zze);
        if (zza2 == 0) {
            return 1;
        }
        return zza2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001᠌\u0000\u0002\u001a\u0003ᐉ\u0001", new Object[]{"zzd", "zze", zzbz.zza, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzcb();
        }
        if (i2 == 4) {
            return new zzbx(null);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
