package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzaao {
    private final zzaan zza;
    private final zzaaw zzb;
    private boolean zzc;
    private long zzf;
    private int zzd = 0;
    private long zze = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private float zzi = 1.0f;
    private zzel zzj = zzel.zza;

    public zzaao(Context context, zzaan zzaanVar, long j) {
        this.zza = zzaanVar;
        this.zzb = new zzaaw(context);
    }

    private final void zzq(int i) {
        this.zzd = Math.min(this.zzd, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        if (r20.zza.zzb(r1, r11) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
    
        if (r23 >= r27) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007d, code lost:
    
        if (r20.zzc != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(long r21, long r23, long r25, long r27, boolean r29, com.google.android.gms.internal.ads.zzaam r30) throws com.google.android.gms.internal.ads.zziz {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaao.zza(long, long, long, long, boolean, com.google.android.gms.internal.ads.zzaam):int");
    }

    public final void zzb() {
        if (this.zzd == 0) {
            this.zzd = 1;
        }
    }

    public final void zzc() {
        this.zzh = C.TIME_UNSET;
    }

    public final void zzd() {
        zzq(0);
    }

    public final void zze(boolean z) {
        this.zzd = z ? 1 : 0;
    }

    public final void zzf() {
        zzq(2);
    }

    public final void zzg() {
        this.zzc = true;
        this.zzf = zzfy.zzq(SystemClock.elapsedRealtime());
        this.zzb.zzg();
    }

    public final void zzh() {
        this.zzc = false;
        this.zzh = C.TIME_UNSET;
        this.zzb.zzh();
    }

    public final void zzi() {
        this.zzb.zzf();
        this.zzg = C.TIME_UNSET;
        this.zze = C.TIME_UNSET;
        zzq(1);
        this.zzh = C.TIME_UNSET;
    }

    public final void zzj(int i) {
        this.zzb.zzj(i);
    }

    public final void zzk(zzel zzelVar) {
        this.zzj = zzelVar;
    }

    public final void zzl(float f) {
        this.zzb.zzc(f);
    }

    public final void zzm(Surface surface) {
        this.zzb.zzi(surface);
        zzq(1);
    }

    public final void zzn(float f) {
        this.zzi = f;
        this.zzb.zze(f);
    }

    public final boolean zzo(boolean z) {
        if (!z || this.zzd != 3) {
            if (this.zzh == C.TIME_UNSET) {
                return false;
            }
            r0 = SystemClock.elapsedRealtime() < this.zzh;
            return r0;
        }
        this.zzh = C.TIME_UNSET;
        return r0;
    }

    public final boolean zzp() {
        int i = this.zzd;
        this.zzd = 3;
        this.zzf = zzfy.zzq(SystemClock.elapsedRealtime());
        return i != 3;
    }
}
