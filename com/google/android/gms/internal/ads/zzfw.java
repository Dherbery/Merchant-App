package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.TimestampAdjuster;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzfw {
    private long zza;
    private long zzb;
    private long zzc;
    private final ThreadLocal zzd = new ThreadLocal();

    public zzfw(long j) {
        zzi(0L);
    }

    public static long zzg(long j) {
        return (j * 1000000) / 90000;
    }

    public static long zzh(long j) {
        return (j * 90000) / 1000000;
    }

    public final synchronized long zza(long j) {
        if (!zzj()) {
            long j2 = this.zza;
            if (j2 == TimestampAdjuster.MODE_SHARED) {
                Long l = (Long) this.zzd.get();
                l.getClass();
                j2 = l.longValue();
            }
            this.zzb = j2 - j;
            notifyAll();
        }
        this.zzc = j;
        return j + this.zzb;
    }

    public final synchronized long zzb(long j) {
        if (j == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long j2 = this.zzc;
        if (j2 != C.TIME_UNSET) {
            long zzh = zzh(j2);
            long j3 = (4294967296L + zzh) / 8589934592L;
            long j4 = (((-1) + j3) * 8589934592L) + j;
            j += j3 * 8589934592L;
            if (Math.abs(j4 - zzh) < Math.abs(j - zzh)) {
                j = j4;
            }
        }
        return zza(zzg(j));
    }

    public final synchronized long zzc(long j) {
        if (j == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long j2 = this.zzc;
        if (j2 != C.TIME_UNSET) {
            long zzh = zzh(j2);
            long j3 = zzh / 8589934592L;
            Long.signum(j3);
            long j4 = (j3 * 8589934592L) + j;
            j += (j3 + 1) * 8589934592L;
            if (j4 >= zzh) {
                j = j4;
            }
        }
        return zza(zzg(j));
    }

    public final synchronized long zzd() {
        long j = this.zza;
        return (j == Long.MAX_VALUE || j == TimestampAdjuster.MODE_SHARED) ? C.TIME_UNSET : j;
    }

    public final synchronized long zze() {
        long j;
        j = this.zzc;
        return j != C.TIME_UNSET ? j + this.zzb : zzd();
    }

    public final synchronized long zzf() {
        return this.zzb;
    }

    public final synchronized void zzi(long j) {
        this.zza = j;
        this.zzb = j == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.zzc = C.TIME_UNSET;
    }

    public final synchronized boolean zzj() {
        return this.zzb != C.TIME_UNSET;
    }
}
