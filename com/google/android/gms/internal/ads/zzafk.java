package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
final class zzafk implements zzacu {
    private zzacx zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private zzahe zzg;
    private zzacv zzh;
    private zzafn zzi;
    private zzajh zzj;
    private final zzfp zza = new zzfp(6);
    private long zzf = -1;

    private final int zza(zzacv zzacvVar) throws IOException {
        this.zza.zzH(2);
        ((zzack) zzacvVar).zzm(this.zza.zzM(), 0, 2, false);
        return this.zza.zzq();
    }

    private final void zzf() {
        zzg(new zzbx[0]);
        zzacx zzacxVar = this.zzb;
        zzacxVar.getClass();
        zzacxVar.zzD();
        this.zzb.zzO(new zzadt(C.TIME_UNSET, 0L));
        this.zzc = 6;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0160  */
    @Override // com.google.android.gms.internal.ads.zzacu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzb(com.google.android.gms.internal.ads.zzacv r24, com.google.android.gms.internal.ads.zzadr r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafk.zzb(com.google.android.gms.internal.ads.zzacv, com.google.android.gms.internal.ads.zzadr):int");
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzb = zzacxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        if (zza(zzacvVar) != 65496) {
            return false;
        }
        int zza = zza(zzacvVar);
        this.zzd = zza;
        if (zza == 65504) {
            this.zza.zzH(2);
            zzack zzackVar = (zzack) zzacvVar;
            zzackVar.zzm(this.zza.zzM(), 0, 2, false);
            zzackVar.zzl(this.zza.zzq() - 2, false);
            zza = zza(zzacvVar);
            this.zzd = zza;
        }
        if (zza == 65505) {
            zzack zzackVar2 = (zzack) zzacvVar;
            zzackVar2.zzl(2, false);
            this.zza.zzH(6);
            zzackVar2.zzm(this.zza.zzM(), 0, 6, false);
            if (this.zza.zzu() == 1165519206 && this.zza.zzq() == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j, long j2) {
        if (j == 0) {
            this.zzc = 0;
            this.zzj = null;
        } else if (this.zzc == 5) {
            zzajh zzajhVar = this.zzj;
            zzajhVar.getClass();
            zzajhVar.zzd(j, j2);
        }
    }

    private final void zzg(zzbx... zzbxVarArr) {
        zzacx zzacxVar = this.zzb;
        zzacxVar.getClass();
        zzaea zzw = zzacxVar.zzw(1024, 4);
        zzak zzakVar = new zzak();
        zzakVar.zzB(MimeTypes.IMAGE_JPEG);
        zzakVar.zzP(new zzby(C.TIME_UNSET, zzbxVarArr));
        zzw.zzl(zzakVar.zzac());
    }
}
