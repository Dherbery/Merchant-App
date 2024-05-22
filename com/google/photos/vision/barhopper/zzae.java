package com.google.photos.vision.barhopper;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes5.dex */
public final class zzae extends zzed implements zzfp {
    private static final zzae zza;
    private int zzd;
    private int zze;
    private int zzf;
    private byte zzg = 2;

    static {
        zzae zzaeVar = new zzae();
        zza = zzaeVar;
        zzed.zzU(zzae.class, zzaeVar);
    }

    private zzae() {
    }

    public static zzad zzc() {
        return (zzad) zza.zzF();
    }

    public static /* synthetic */ void zze(zzae zzaeVar, int i) {
        zzaeVar.zzd |= 1;
        zzaeVar.zze = i;
    }

    public static /* synthetic */ void zzf(zzae zzaeVar, int i) {
        zzaeVar.zzd |= 2;
        zzaeVar.zzf = i;
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔄ\u0000\u0002ᔄ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzae();
        }
        if (i2 == 4) {
            return new zzad(null);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
