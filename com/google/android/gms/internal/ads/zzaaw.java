package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.Display;
import android.view.Surface;
import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzaaw {
    private final zzaad zza = new zzaad();
    private final zzaas zzb;
    private final zzaav zzc;
    private boolean zzd;
    private Surface zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private int zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;

    public zzaaw(Context context) {
        zzaas zzaasVar;
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            int i = zzfy.zza;
            zzaasVar = zzaau.zzc(applicationContext);
            if (zzaasVar == null) {
                zzaasVar = zzaat.zzc(applicationContext);
            }
        } else {
            zzaasVar = null;
        }
        this.zzb = zzaasVar;
        this.zzc = zzaasVar != null ? zzaav.zza() : null;
        this.zzk = C.TIME_UNSET;
        this.zzl = C.TIME_UNSET;
        this.zzf = -1.0f;
        this.zzi = 1.0f;
        this.zzj = 0;
    }

    public static /* synthetic */ void zzb(zzaaw zzaawVar, Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / display.getRefreshRate());
            zzaawVar.zzk = refreshRate;
            zzaawVar.zzl = (refreshRate * 80) / 100;
        } else {
            zzff.zzf("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            zzaawVar.zzk = C.TIME_UNSET;
            zzaawVar.zzl = C.TIME_UNSET;
        }
    }

    private final void zzk() {
        Surface surface;
        if (zzfy.zza < 30 || (surface = this.zze) == null || this.zzj == Integer.MIN_VALUE || this.zzh == 0.0f) {
            return;
        }
        this.zzh = 0.0f;
        zzaar.zza(surface, 0.0f);
    }

    private final void zzl() {
        this.zzm = 0L;
        this.zzp = -1L;
        this.zzn = -1L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        if (java.lang.Math.abs(r0 - r9.zzg) >= r2) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0062, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
    
        if (r5 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        if (r9.zza.zzb() >= 30) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzm() {
        /*
            r9 = this;
            int r0 = com.google.android.gms.internal.ads.zzfy.zza
            r1 = 30
            if (r0 < r1) goto L6a
            android.view.Surface r0 = r9.zze
            if (r0 != 0) goto Lb
            goto L6a
        Lb:
            com.google.android.gms.internal.ads.zzaad r0 = r9.zza
            boolean r0 = r0.zzg()
            if (r0 == 0) goto L1a
            com.google.android.gms.internal.ads.zzaad r0 = r9.zza
            float r0 = r0.zza()
            goto L1c
        L1a:
            float r0 = r9.zzf
        L1c:
            float r2 = r9.zzg
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 == 0) goto L6a
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L57
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L57
            com.google.android.gms.internal.ads.zzaad r1 = r9.zza
            boolean r1 = r1.zzg()
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L4a
            com.google.android.gms.internal.ads.zzaad r1 = r9.zza
            long r3 = r1.zzd()
            r7 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 < 0) goto L4a
            r2 = 1017370378(0x3ca3d70a, float:0.02)
        L4a:
            float r1 = r9.zzg
            float r1 = r0 - r1
            float r1 = java.lang.Math.abs(r1)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto L62
            goto L63
        L57:
            if (r4 != 0) goto L65
            com.google.android.gms.internal.ads.zzaad r2 = r9.zza
            int r2 = r2.zzb()
            if (r2 < r1) goto L62
            goto L63
        L62:
            r5 = r6
        L63:
            if (r5 == 0) goto L6a
        L65:
            r9.zzg = r0
            r9.zzn(r6)
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaaw.zzm():void");
    }

    private final void zzn(boolean z) {
        Surface surface;
        if (zzfy.zza < 30 || (surface = this.zze) == null || this.zzj == Integer.MIN_VALUE) {
            return;
        }
        float f = 0.0f;
        if (this.zzd) {
            float f2 = this.zzg;
            if (f2 != -1.0f) {
                f = this.zzi * f2;
            }
        }
        if (z || this.zzh != f) {
            this.zzh = f;
            zzaar.zza(surface, f);
        }
    }

    public final long zza(long j) {
        long j2;
        if (this.zzp != -1 && this.zza.zzg()) {
            long zzc = this.zza.zzc();
            long j3 = this.zzq + (((float) (zzc * (this.zzm - this.zzp))) / this.zzi);
            if (Math.abs(j - j3) > 20000000) {
                zzl();
            } else {
                j = j3;
            }
        }
        this.zzn = this.zzm;
        this.zzo = j;
        zzaav zzaavVar = this.zzc;
        if (zzaavVar != null && this.zzk != C.TIME_UNSET) {
            long j4 = zzaavVar.zza;
            if (j4 != C.TIME_UNSET) {
                long j5 = this.zzk;
                long j6 = j4 + (((j - j4) / j5) * j5);
                if (j <= j6) {
                    j2 = j6 - j5;
                } else {
                    j6 = j5 + j6;
                    j2 = j6;
                }
                long j7 = this.zzl;
                if (j6 - j >= j - j2) {
                    j6 = j2;
                }
                return j6 - j7;
            }
        }
        return j;
    }

    public final void zzc(float f) {
        this.zzf = f;
        this.zza.zzf();
        zzm();
    }

    public final void zzd(long j) {
        long j2 = this.zzn;
        if (j2 != -1) {
            this.zzp = j2;
            this.zzq = this.zzo;
        }
        this.zzm++;
        this.zza.zze(j * 1000);
        zzm();
    }

    public final void zze(float f) {
        this.zzi = f;
        zzl();
        zzn(false);
    }

    public final void zzf() {
        zzl();
    }

    public final void zzg() {
        this.zzd = true;
        zzl();
        if (this.zzb != null) {
            zzaav zzaavVar = this.zzc;
            zzaavVar.getClass();
            zzaavVar.zzb();
            this.zzb.zzb(new zzaap(this));
        }
        zzn(false);
    }

    public final void zzh() {
        this.zzd = false;
        zzaas zzaasVar = this.zzb;
        if (zzaasVar != null) {
            zzaasVar.zza();
            zzaav zzaavVar = this.zzc;
            zzaavVar.getClass();
            zzaavVar.zzc();
        }
        zzk();
    }

    public final void zzi(Surface surface) {
        int i = zzfy.zza;
        boolean zza = zzaaq.zza(surface);
        Surface surface2 = this.zze;
        if (true == zza) {
            surface = null;
        }
        if (surface2 == surface) {
            return;
        }
        zzk();
        this.zze = surface;
        zzn(true);
    }

    public final void zzj(int i) {
        if (this.zzj == i) {
            return;
        }
        this.zzj = i;
        zzn(true);
    }
}
