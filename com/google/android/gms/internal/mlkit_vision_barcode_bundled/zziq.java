package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zziq extends zzed implements zzfp {
    private static final zziq zza;
    private int zzd;
    private int zze;
    private zzij zzh;
    private int zzj;
    private int zzk;
    private zzel zzf = zzO();
    private int zzg = -1;
    private String zzi = "";
    private zzej zzl = zzN();
    private String zzm = "";

    static {
        zziq zziqVar = new zziq();
        zza = zziqVar;
        zzed.zzU(zziq.class, zziqVar);
    }

    private zziq() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0000\u0001᠌\u0000\u0002\u001b\u0003င\u0001\u0004ဉ\u0002\u0005ဈ\u0003\u0006᠌\u0004\u0007᠌\u0005\b'\tဈ\u0006", new Object[]{"zzd", "zze", zzim.zza, "zzf", zzil.class, "zzg", "zzh", "zzi", "zzj", zzio.zza, "zzk", zzip.zza, "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zziq();
        }
        if (i2 == 4) {
            return new zzin(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
