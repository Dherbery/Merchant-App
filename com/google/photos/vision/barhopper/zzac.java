package com.google.photos.vision.barhopper;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes5.dex */
public final class zzac extends zzed implements zzfp {
    private static final zzac zza;
    private int zzd;
    private double zze;
    private double zzf;
    private byte zzg = 2;

    static {
        zzac zzacVar = new zzac();
        zza = zzacVar;
        zzed.zzU(zzac.class, zzacVar);
    }

    private zzac() {
    }

    public static zzac zzd() {
        return zza;
    }

    public final double zza() {
        return this.zze;
    }

    public final double zzb() {
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔀ\u0000\u0002ᔀ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzac();
        }
        zza zzaVar = null;
        if (i2 == 4) {
            return new zzab(zzaVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
