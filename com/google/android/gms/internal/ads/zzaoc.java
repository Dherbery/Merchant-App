package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
final class zzaoc {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzfw zza = new zzfw(0);
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private final zzfp zzb = new zzfp();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaoc(int i) {
    }

    private final int zze(zzacv zzacvVar) {
        byte[] bArr = zzfy.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
        this.zzc = true;
        zzacvVar.zzj();
        return 0;
    }

    public final int zza(zzacv zzacvVar, zzadr zzadrVar, int i) throws IOException {
        if (i <= 0) {
            zze(zzacvVar);
            return 0;
        }
        boolean z = this.zze;
        long j = C.TIME_UNSET;
        if (!z) {
            long zzd = zzacvVar.zzd();
            int min = (int) Math.min(112800L, zzd);
            long j2 = zzd - min;
            if (zzacvVar.zzf() == j2) {
                this.zzb.zzH(min);
                zzacvVar.zzj();
                ((zzack) zzacvVar).zzm(this.zzb.zzM(), 0, min, false);
                zzfp zzfpVar = this.zzb;
                int zzd2 = zzfpVar.zzd();
                int zze = zzfpVar.zze();
                int i2 = zze - 188;
                while (true) {
                    if (i2 < zzd2) {
                        break;
                    }
                    byte[] zzM = zzfpVar.zzM();
                    int i3 = -4;
                    int i4 = 0;
                    while (true) {
                        if (i3 > 4) {
                            break;
                        }
                        int i5 = (i3 * TsExtractor.TS_PACKET_SIZE) + i2;
                        if (i5 < zzd2 || i5 >= zze || zzM[i5] != 71) {
                            i4 = 0;
                        } else {
                            i4++;
                            if (i4 == 5) {
                                long zzb = zzaom.zzb(zzfpVar, i2, i);
                                if (zzb != C.TIME_UNSET) {
                                    j = zzb;
                                    break;
                                }
                            }
                        }
                        i3++;
                    }
                    i2--;
                }
                this.zzg = j;
                this.zze = true;
                return 0;
            }
            zzadrVar.zza = j2;
        } else {
            if (this.zzg == C.TIME_UNSET) {
                zze(zzacvVar);
                return 0;
            }
            if (this.zzd) {
                long j3 = this.zzf;
                if (j3 == C.TIME_UNSET) {
                    zze(zzacvVar);
                    return 0;
                }
                zzfw zzfwVar = this.zza;
                this.zzh = zzfwVar.zzc(this.zzg) - zzfwVar.zzb(j3);
                zze(zzacvVar);
                return 0;
            }
            int min2 = (int) Math.min(112800L, zzacvVar.zzd());
            if (zzacvVar.zzf() == 0) {
                this.zzb.zzH(min2);
                zzacvVar.zzj();
                ((zzack) zzacvVar).zzm(this.zzb.zzM(), 0, min2, false);
                zzfp zzfpVar2 = this.zzb;
                int zzd3 = zzfpVar2.zzd();
                int zze2 = zzfpVar2.zze();
                while (true) {
                    if (zzd3 >= zze2) {
                        break;
                    }
                    if (zzfpVar2.zzM()[zzd3] == 71) {
                        long zzb2 = zzaom.zzb(zzfpVar2, zzd3, i);
                        if (zzb2 != C.TIME_UNSET) {
                            j = zzb2;
                            break;
                        }
                    }
                    zzd3++;
                }
                this.zzf = j;
                this.zzd = true;
                return 0;
            }
            zzadrVar.zza = 0L;
        }
        return 1;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzfw zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzc;
    }
}
