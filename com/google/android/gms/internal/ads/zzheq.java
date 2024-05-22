package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzheq extends zzgzu implements zzhbf {
    private static final zzheq zzb;
    private int zzd;
    private zzgyl zze = zzgyl.zzb;
    private zzgyl zzf;
    private zzgyl zzg;

    static {
        zzheq zzheqVar = new zzheq();
        zzb = zzheqVar;
        zzgzu.zzaU(zzheq.class, zzheqVar);
    }

    private zzheq() {
        zzgyl zzgylVar = zzgyl.zzb;
        this.zzf = zzgylVar;
        this.zzg = zzgylVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzheq();
        }
        if (i2 == 4) {
            return new zzhep(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
