package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzbeh extends zzgzu implements zzhbf {
    private static final zzbeh zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzbeh zzbehVar = new zzbeh();
        zzb = zzbehVar;
        zzgzu.zzaU(zzbeh.class, zzbehVar);
    }

    private zzbeh() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzbeh();
        }
        zzbbw zzbbwVar = null;
        if (i2 == 4) {
            return new zzbeg(zzbbwVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
