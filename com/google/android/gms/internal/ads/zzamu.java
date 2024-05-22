package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.material.internal.ViewUtils;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzamu implements zzamy {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;
    private final zzfo zzc = new zzfo(new byte[7], 7);
    private final zzfp zzd = new zzfp(Arrays.copyOf(zza, 10));
    private final String zze;
    private String zzf;
    private zzaea zzg;
    private zzaea zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private boolean zzl;
    private boolean zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private long zzr;
    private int zzs;
    private long zzt;
    private zzaea zzu;
    private long zzv;

    public zzamu(boolean z, String str) {
        zzh();
        this.zzn = -1;
        this.zzo = -1;
        this.zzr = C.TIME_UNSET;
        this.zzt = C.TIME_UNSET;
        this.zzb = z;
        this.zze = str;
    }

    public static boolean zzf(int i) {
        return (i & 65526) == 65520;
    }

    private final void zzg() {
        this.zzm = false;
        zzh();
    }

    private final void zzh() {
        this.zzi = 0;
        this.zzj = 0;
        this.zzk = 256;
    }

    private final void zzi() {
        this.zzi = 3;
        this.zzj = 0;
    }

    private final void zzj(zzaea zzaeaVar, long j, int i, int i2) {
        this.zzi = 4;
        this.zzj = i;
        this.zzu = zzaeaVar;
        this.zzv = j;
        this.zzs = i2;
    }

    private final boolean zzk(zzfp zzfpVar, byte[] bArr, int i) {
        int min = Math.min(zzfpVar.zzb(), i - this.zzj);
        zzfpVar.zzG(bArr, this.zzj, min);
        int i2 = this.zzj + min;
        this.zzj = i2;
        return i2 == i;
    }

    private static final boolean zzl(byte b, byte b2) {
        return zzf((b2 & 255) | MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }

    private static final boolean zzm(zzfp zzfpVar, byte[] bArr, int i) {
        if (zzfpVar.zzb() < i) {
            return false;
        }
        zzfpVar.zzG(bArr, 0, i);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zza(zzfp zzfpVar) throws zzcc {
        int i;
        int i2;
        int i3;
        int i4;
        this.zzg.getClass();
        int i5 = zzfy.zza;
        while (zzfpVar.zzb() > 0) {
            int i6 = this.zzi;
            int i7 = 13;
            int i8 = 2;
            if (i6 == 0) {
                byte[] zzM = zzfpVar.zzM();
                int zzd = zzfpVar.zzd();
                int zze = zzfpVar.zze();
                while (true) {
                    if (zzd < zze) {
                        i = zzd + 1;
                        i2 = zzM[zzd] & 255;
                        if (this.zzk == 512 && zzl((byte) -1, (byte) i2)) {
                            if (!this.zzm) {
                                int i9 = i - 2;
                                zzfpVar.zzK(i9 + 1);
                                if (zzm(zzfpVar, this.zzc.zza, 1)) {
                                    this.zzc.zzk(4);
                                    int zzd2 = this.zzc.zzd(1);
                                    int i10 = this.zzn;
                                    if (i10 == -1 || zzd2 == i10) {
                                        if (this.zzo != -1) {
                                            if (!zzm(zzfpVar, this.zzc.zza, 1)) {
                                                break;
                                            }
                                            this.zzc.zzk(i8);
                                            if (this.zzc.zzd(4) == this.zzo) {
                                                zzfpVar.zzK(i9 + 2);
                                            }
                                        }
                                        if (!zzm(zzfpVar, this.zzc.zza, 4)) {
                                            break;
                                        }
                                        this.zzc.zzk(14);
                                        int zzd3 = this.zzc.zzd(i7);
                                        if (zzd3 >= 7) {
                                            byte[] zzM2 = zzfpVar.zzM();
                                            int zze2 = zzfpVar.zze();
                                            int i11 = i9 + zzd3;
                                            if (i11 < zze2) {
                                                byte b = zzM2[i11];
                                                if (b != -1) {
                                                    if (b == 73) {
                                                        int i12 = i11 + 1;
                                                        if (i12 == zze2) {
                                                            break;
                                                        }
                                                        if (zzM2[i12] == 68) {
                                                            int i13 = i11 + 2;
                                                            if (i13 == zze2) {
                                                                break;
                                                            } else if (zzM2[i13] == 51) {
                                                                break;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    int i14 = i11 + 1;
                                                    if (i14 == zze2) {
                                                        break;
                                                    }
                                                    byte b2 = zzM2[i14];
                                                    if (zzl((byte) -1, b2) && ((b2 & 8) >> 3) == zzd2) {
                                                        break;
                                                    }
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                        int i15 = this.zzk;
                        int i16 = i15 | i2;
                        if (i16 == 329) {
                            i3 = 2;
                            i4 = ViewUtils.EDGE_TO_EDGE_FLAGS;
                        } else if (i16 == 511) {
                            i3 = 2;
                            i4 = 512;
                        } else if (i16 == 836) {
                            i3 = 2;
                            i4 = 1024;
                        } else {
                            if (i16 == 1075) {
                                this.zzi = 2;
                                this.zzj = 3;
                                this.zzs = 0;
                                this.zzd.zzK(0);
                                zzfpVar.zzK(i);
                                break;
                            }
                            if (i15 != 256) {
                                this.zzk = 256;
                                zzd = i - 1;
                                i7 = 13;
                                i8 = 2;
                            } else {
                                i3 = 2;
                                i8 = i3;
                                zzd = i;
                                i7 = 13;
                            }
                        }
                        this.zzk = i4;
                        i8 = i3;
                        zzd = i;
                        i7 = 13;
                    } else {
                        zzfpVar.zzK(zzd);
                        break;
                    }
                }
                this.zzp = (i2 & 8) >> 3;
                this.zzl = 1 == ((i2 & 1) ^ 1);
                if (this.zzm) {
                    zzi();
                } else {
                    this.zzi = 1;
                    this.zzj = 0;
                }
                zzfpVar.zzK(i);
            } else if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        int min = Math.min(zzfpVar.zzb(), this.zzs - this.zzj);
                        this.zzu.zzr(zzfpVar, min);
                        int i17 = this.zzj + min;
                        this.zzj = i17;
                        if (i17 == this.zzs) {
                            zzek.zzf(this.zzt != C.TIME_UNSET);
                            this.zzu.zzt(this.zzt, 1, this.zzs, 0, null);
                            this.zzt += this.zzv;
                            zzh();
                        }
                    } else {
                        if (zzk(zzfpVar, this.zzc.zza, true != this.zzl ? 5 : 7)) {
                            this.zzc.zzk(0);
                            if (!this.zzq) {
                                int zzd4 = this.zzc.zzd(2) + 1;
                                if (zzd4 != 2) {
                                    zzff.zzf("AdtsReader", "Detected audio object type: " + zzd4 + ", but assuming AAC LC.");
                                }
                                this.zzc.zzm(5);
                                int zzd5 = this.zzc.zzd(3);
                                int i18 = this.zzo;
                                int i19 = zzabs.zza;
                                byte[] bArr = {(byte) (((i18 >> 1) & 7) | 16), (byte) (((zzd5 << 3) & 120) | ((i18 << 7) & 128))};
                                zzabr zza2 = zzabs.zza(bArr);
                                zzak zzakVar = new zzak();
                                zzakVar.zzK(this.zzf);
                                zzakVar.zzW(MimeTypes.AUDIO_AAC);
                                zzakVar.zzz(zza2.zzc);
                                zzakVar.zzy(zza2.zzb);
                                zzakVar.zzX(zza2.zza);
                                zzakVar.zzL(Collections.singletonList(bArr));
                                zzakVar.zzN(this.zze);
                                zzam zzac = zzakVar.zzac();
                                this.zzr = 1024000000 / zzac.zzA;
                                this.zzg.zzl(zzac);
                                this.zzq = true;
                            } else {
                                this.zzc.zzm(10);
                            }
                            this.zzc.zzm(4);
                            int zzd6 = this.zzc.zzd(13) - 7;
                            if (this.zzl) {
                                zzd6 -= 2;
                            }
                            zzj(this.zzg, this.zzr, 0, zzd6);
                        }
                    }
                } else if (zzk(zzfpVar, this.zzd.zzM(), 10)) {
                    this.zzh.zzr(this.zzd, 10);
                    this.zzd.zzK(6);
                    zzj(this.zzh, 0L, 10, 10 + this.zzd.zzl());
                }
            } else if (zzfpVar.zzb() != 0) {
                zzfo zzfoVar = this.zzc;
                zzfoVar.zza[0] = zzfpVar.zzM()[zzfpVar.zzd()];
                zzfoVar.zzk(2);
                int zzd7 = this.zzc.zzd(4);
                int i20 = this.zzo;
                if (i20 == -1 || zzd7 == i20) {
                    if (!this.zzm) {
                        this.zzm = true;
                        this.zzn = this.zzp;
                        this.zzo = zzd7;
                    }
                    zzi();
                } else {
                    zzg();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zzf = zzaokVar.zzb();
        zzaea zzw = zzacxVar.zzw(zzaokVar.zza(), 1);
        this.zzg = zzw;
        this.zzu = zzw;
        if (!this.zzb) {
            this.zzh = new zzact();
            return;
        }
        zzaokVar.zzc();
        zzaea zzw2 = zzacxVar.zzw(zzaokVar.zza(), 5);
        this.zzh = zzw2;
        zzak zzakVar = new zzak();
        zzakVar.zzK(zzaokVar.zzb());
        zzakVar.zzW(MimeTypes.APPLICATION_ID3);
        zzw2.zzl(zzakVar.zzac());
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j, int i) {
        this.zzt = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        this.zzt = C.TIME_UNSET;
        zzg();
    }
}
