package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzbcv extends zzgzu implements zzhbf {
    private static final zzbcv zzb;
    private int zzd;
    private int zze;
    private zzben zzf;
    private zzben zzg;
    private zzben zzh;
    private zzhad zzi = zzaN();
    private int zzj;

    static {
        zzbcv zzbcvVar = new zzbcv();
        zzb = zzbcvVar;
        zzgzu.zzaU(zzbcv.class, zzbcvVar);
    }

    private zzbcv() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005\u001b\u0006င\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzben.class, "zzj"});
        }
        if (i2 == 3) {
            return new zzbcv();
        }
        if (i2 == 4) {
            return new zzbcu(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
