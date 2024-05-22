package com.google.photos.vision.barhopper;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcb;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcd;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzci;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzel;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;
import java.util.List;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes5.dex */
public final class zzr extends zzed implements zzfp {
    private static final zzr zza;
    private int zzd;
    private zzcd zze;
    private byte zzm = 2;
    private String zzf = "";
    private String zzg = "";
    private zzel zzh = zzO();
    private zzel zzi = zzO();
    private zzel zzj = zzed.zzO();
    private zzel zzk = zzO();
    private String zzl = "";

    static {
        zzr zzrVar = new zzr();
        zza = zzrVar;
        zzed.zzU(zzr.class, zzrVar);
    }

    private zzr() {
    }

    public static zzr zzc() {
        return zza;
    }

    public final zzcd zza() {
        zzcd zzcdVar = this.zze;
        return zzcdVar == null ? zzcd.zzb() : zzcdVar;
    }

    public final String zzd() {
        return this.zzf;
    }

    public final String zze() {
        return this.zzg;
    }

    public final List zzf() {
        return this.zzk;
    }

    public final List zzh() {
        return this.zzi;
    }

    public final List zzi() {
        return this.zzh;
    }

    public final List zzj() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0004\u0001\u0001ဉ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004\u001b\u0005\u001b\u0006\u001a\u0007Л\bဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzci.class, "zzi", zzy.class, "zzj", "zzk", zzcb.class, "zzl"});
        }
        if (i2 == 3) {
            return new zzr();
        }
        if (i2 == 4) {
            return new zzq(null);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzm = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
