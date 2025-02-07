package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
final class zzant {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzfw zza = new zzfw(0);
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private final zzfp zzb = new zzfp();

    public static long zzc(zzfp zzfpVar) {
        int zzd = zzfpVar.zzd();
        if (zzfpVar.zzb() < 9) {
            return C.TIME_UNSET;
        }
        byte[] bArr = new byte[9];
        zzfpVar.zzG(bArr, 0, 9);
        zzfpVar.zzK(zzd);
        byte b = bArr[0];
        if ((b & 196) != 68) {
            return C.TIME_UNSET;
        }
        byte b2 = bArr[2];
        if ((b2 & 4) != 4) {
            return C.TIME_UNSET;
        }
        byte b3 = bArr[4];
        if ((b3 & 4) != 4 || (bArr[5] & 1) != 1 || (bArr[8] & 3) != 3) {
            return C.TIME_UNSET;
        }
        long j = b;
        long j2 = b2;
        long j3 = (248 & j2) >> 3;
        long j4 = (j2 & 3) << 13;
        return j4 | ((bArr[1] & 255) << 20) | ((j & 3) << 28) | (((j & 56) >> 3) << 30) | (j3 << 15) | ((bArr[3] & 255) << 5) | ((b3 & 248) >> 3);
    }

    private final int zzf(zzacv zzacvVar) {
        byte[] bArr = zzfy.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
        this.zzc = true;
        zzacvVar.zzj();
        return 0;
    }

    private static final int zzg(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public final int zza(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        boolean z = this.zze;
        long j = C.TIME_UNSET;
        if (!z) {
            long zzd = zzacvVar.zzd();
            int min = (int) Math.min(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, zzd);
            long j2 = zzd - min;
            if (zzacvVar.zzf() != j2) {
                zzadrVar.zza = j2;
                return 1;
            }
            this.zzb.zzH(min);
            zzacvVar.zzj();
            ((zzack) zzacvVar).zzm(this.zzb.zzM(), 0, min, false);
            zzfp zzfpVar = this.zzb;
            int zzd2 = zzfpVar.zzd();
            int zze = zzfpVar.zze() - 4;
            while (true) {
                if (zze < zzd2) {
                    break;
                }
                if (zzg(zzfpVar.zzM(), zze) == 442) {
                    zzfpVar.zzK(zze + 4);
                    long zzc = zzc(zzfpVar);
                    if (zzc != C.TIME_UNSET) {
                        j = zzc;
                        break;
                    }
                }
                zze--;
            }
            this.zzg = j;
            this.zze = true;
        } else {
            if (this.zzg == C.TIME_UNSET) {
                zzf(zzacvVar);
                return 0;
            }
            if (this.zzd) {
                long j3 = this.zzf;
                if (j3 == C.TIME_UNSET) {
                    zzf(zzacvVar);
                    return 0;
                }
                zzfw zzfwVar = this.zza;
                this.zzh = zzfwVar.zzc(this.zzg) - zzfwVar.zzb(j3);
                zzf(zzacvVar);
                return 0;
            }
            int min2 = (int) Math.min(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, zzacvVar.zzd());
            if (zzacvVar.zzf() != 0) {
                zzadrVar.zza = 0L;
                return 1;
            }
            this.zzb.zzH(min2);
            zzacvVar.zzj();
            ((zzack) zzacvVar).zzm(this.zzb.zzM(), 0, min2, false);
            zzfp zzfpVar2 = this.zzb;
            int zzd3 = zzfpVar2.zzd();
            int zze2 = zzfpVar2.zze();
            while (true) {
                if (zzd3 >= zze2 - 3) {
                    break;
                }
                if (zzg(zzfpVar2.zzM(), zzd3) == 442) {
                    zzfpVar2.zzK(zzd3 + 4);
                    long zzc2 = zzc(zzfpVar2);
                    if (zzc2 != C.TIME_UNSET) {
                        j = zzc2;
                        break;
                    }
                }
                zzd3++;
            }
            this.zzf = j;
            this.zzd = true;
        }
        return 0;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzfw zzd() {
        return this.zza;
    }

    public final boolean zze() {
        return this.zzc;
    }
}
