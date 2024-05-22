package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzana implements zzamy {
    private static final double[] zza = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String zzb;
    private zzaea zzc;
    private final zzaon zzd;
    private final zzfp zze;
    private final zzann zzf;
    private final boolean[] zzg;
    private final zzamz zzh;
    private long zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;
    private boolean zzq;

    public zzana() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c6  */
    @Override // com.google.android.gms.internal.ads.zzamy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(com.google.android.gms.internal.ads.zzfp r21) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzana.zza(com.google.android.gms.internal.ads.zzfp):void");
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zzb = zzaokVar.zzb();
        this.zzc = zzacxVar.zzw(zzaokVar.zza(), 2);
        zzaon zzaonVar = this.zzd;
        if (zzaonVar != null) {
            zzaonVar.zzb(zzacxVar, zzaokVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z) {
        zzek.zzb(this.zzc);
        if (z) {
            boolean z2 = this.zzp;
            long j = this.zzi - this.zzn;
            this.zzc.zzt(this.zzo, z2 ? 1 : 0, (int) j, 0, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        zzgm.zzf(this.zzg);
        this.zzh.zzb();
        zzann zzannVar = this.zzf;
        if (zzannVar != null) {
            zzannVar.zzb();
        }
        this.zzi = 0L;
        this.zzj = false;
        this.zzm = C.TIME_UNSET;
        this.zzo = C.TIME_UNSET;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzana(zzaon zzaonVar) {
        zzfp zzfpVar;
        this.zzd = zzaonVar;
        this.zzg = new boolean[4];
        this.zzh = new zzamz(128);
        if (zzaonVar != null) {
            this.zzf = new zzann(178, 128);
            zzfpVar = new zzfp();
        } else {
            zzfpVar = null;
            this.zzf = null;
        }
        this.zze = zzfpVar;
        this.zzm = C.TIME_UNSET;
        this.zzo = C.TIME_UNSET;
    }
}
