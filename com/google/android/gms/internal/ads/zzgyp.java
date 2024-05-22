package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
final class zzgyp extends zzgyt {
    private final Iterable zze;
    private final Iterator zzf;
    private ByteBuffer zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgyp(Iterable iterable, int i, boolean z, zzgyo zzgyoVar) {
        super(null);
        this.zzj = Integer.MAX_VALUE;
        this.zzh = i;
        this.zze = iterable;
        this.zzf = iterable.iterator();
        this.zzl = 0;
        if (i == 0) {
            this.zzg = zzhae.zze;
            this.zzm = 0L;
            this.zzn = 0L;
            this.zzo = 0L;
            return;
        }
        zzN();
    }

    private final int zzJ() {
        return (int) (((this.zzh - this.zzl) - this.zzm) + this.zzn);
    }

    private final void zzK() throws zzhag {
        if (!this.zzf.hasNext()) {
            throw zzhag.zzj();
        }
        zzN();
    }

    private final void zzL(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > zzJ()) {
            if (i2 > 0) {
                throw zzhag.zzj();
            }
            return;
        }
        int i3 = i2;
        while (i3 > 0) {
            if (this.zzo - this.zzm == 0) {
                zzK();
            }
            int min = Math.min(i3, (int) (this.zzo - this.zzm));
            long j = min;
            zzhcz.zzo(this.zzm, bArr, i2 - i3, j);
            i3 -= min;
            this.zzm += j;
        }
    }

    private final void zzM() {
        int i = this.zzh + this.zzi;
        this.zzh = i;
        int i2 = this.zzj;
        if (i <= i2) {
            this.zzi = 0;
            return;
        }
        int i3 = i - i2;
        this.zzi = i3;
        this.zzh = i - i3;
    }

    private final void zzN() {
        ByteBuffer byteBuffer = (ByteBuffer) this.zzf.next();
        this.zzg = byteBuffer;
        this.zzl += (int) (this.zzm - this.zzn);
        long position = byteBuffer.position();
        this.zzm = position;
        this.zzn = position;
        this.zzo = this.zzg.limit();
        long zze = zzhcz.zze(this.zzg);
        this.zzm += zze;
        this.zzn += zze;
        this.zzo += zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final void zzA(int i) {
        this.zzj = i;
        zzM();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final boolean zzC() throws IOException {
        return (((long) this.zzl) + this.zzm) - this.zzn == ((long) this.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final boolean zzD() throws IOException {
        return zzr() != 0;
    }

    public final byte zza() throws IOException {
        if (this.zzo - this.zzm == 0) {
            zzK();
        }
        long j = this.zzm;
        this.zzm = 1 + j;
        return zzhcz.zza(j);
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final double zzb() throws IOException {
        return Double.longBitsToDouble(zzq());
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final float zzc() throws IOException {
        return Float.intBitsToFloat(zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final int zzd() {
        return (int) ((this.zzl + this.zzm) - this.zzn);
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final int zze(int i) throws zzhag {
        if (i >= 0) {
            int zzd = i + zzd();
            int i2 = this.zzj;
            if (zzd <= i2) {
                this.zzj = zzd;
                zzM();
                return i2;
            }
            throw zzhag.zzj();
        }
        throw zzhag.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final int zzf() throws IOException {
        return zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final int zzg() throws IOException {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final int zzh() throws IOException {
        return zzj();
    }

    public final int zzi() throws IOException {
        long j = this.zzo;
        long j2 = this.zzm;
        if (j - j2 >= 4) {
            this.zzm = 4 + j2;
            int zza = zzhcz.zza(j2) & 255;
            int zza2 = (zzhcz.zza(1 + j2) & 255) << 8;
            return zza | zza2 | ((zzhcz.zza(2 + j2) & 255) << 16) | ((zzhcz.zza(j2 + 3) & 255) << 24);
        }
        int zza3 = zza() & 255;
        int zza4 = (zza() & 255) << 8;
        return zza3 | zza4 | ((zza() & 255) << 16) | ((zza() & 255) << 24);
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final int zzk() throws IOException {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final int zzl() throws IOException {
        return zzF(zzj());
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final int zzm() throws IOException {
        if (zzC()) {
            this.zzk = 0;
            return 0;
        }
        int zzj = zzj();
        this.zzk = zzj;
        if ((zzj >>> 3) != 0) {
            return zzj;
        }
        throw zzhag.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final int zzn() throws IOException {
        return zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final long zzo() throws IOException {
        return zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final long zzp() throws IOException {
        return zzr();
    }

    public final long zzq() throws IOException {
        long j = this.zzo;
        long j2 = this.zzm;
        if (j - j2 >= 8) {
            this.zzm = 8 + j2;
            long zza = zzhcz.zza(j2) & 255;
            long zza2 = (zzhcz.zza(1 + j2) & 255) << 8;
            long zza3 = (zzhcz.zza(j2 + 2) & 255) << 16;
            long zza4 = (zzhcz.zza(3 + j2) & 255) << 24;
            long zza5 = (zzhcz.zza(j2 + 4) & 255) << 32;
            return zza5 | zza | zza2 | zza3 | zza4 | ((zzhcz.zza(j2 + 5) & 255) << 40) | ((zzhcz.zza(j2 + 6) & 255) << 48) | ((zzhcz.zza(j2 + 7) & 255) << 56);
        }
        return (zza() & 255) | ((zza() & 255) << 8) | ((zza() & 255) << 16) | ((zza() & 255) << 24) | ((zza() & 255) << 32) | ((zza() & 255) << 40) | ((zza() & 255) << 48) | ((zza() & 255) << 56);
    }

    final long zzs() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((zza() & 128) == 0) {
                return j;
            }
        }
        throw zzhag.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final long zzt() throws IOException {
        return zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final long zzu() throws IOException {
        return zzG(zzr());
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final long zzv() throws IOException {
        return zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final zzgyl zzw() throws IOException {
        int zzj = zzj();
        if (zzj > 0) {
            long j = this.zzo;
            long j2 = this.zzm;
            long j3 = zzj;
            if (j3 <= j - j2) {
                byte[] bArr = new byte[zzj];
                zzhcz.zzo(j2, bArr, 0L, j3);
                this.zzm += j3;
                return new zzgyh(bArr);
            }
        }
        if (zzj > 0 && zzj <= zzJ()) {
            byte[] bArr2 = new byte[zzj];
            zzL(bArr2, 0, zzj);
            return new zzgyh(bArr2);
        }
        if (zzj == 0) {
            return zzgyl.zzb;
        }
        if (zzj < 0) {
            throw zzhag.zzf();
        }
        throw zzhag.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final String zzx() throws IOException {
        int zzj = zzj();
        if (zzj > 0) {
            long j = this.zzo;
            long j2 = this.zzm;
            long j3 = zzj;
            if (j3 <= j - j2) {
                byte[] bArr = new byte[zzj];
                zzhcz.zzo(j2, bArr, 0L, j3);
                String str = new String(bArr, zzhae.zzb);
                this.zzm += j3;
                return str;
            }
        }
        if (zzj > 0 && zzj <= zzJ()) {
            byte[] bArr2 = new byte[zzj];
            zzL(bArr2, 0, zzj);
            return new String(bArr2, zzhae.zzb);
        }
        if (zzj == 0) {
            return "";
        }
        if (zzj < 0) {
            throw zzhag.zzf();
        }
        throw zzhag.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final String zzy() throws IOException {
        int zzj = zzj();
        if (zzj > 0) {
            long j = this.zzo;
            long j2 = this.zzm;
            long j3 = zzj;
            if (j3 <= j - j2) {
                String zzg = zzhde.zzg(this.zzg, (int) (j2 - this.zzn), zzj);
                this.zzm += j3;
                return zzg;
            }
        }
        if (zzj >= 0 && zzj <= zzJ()) {
            byte[] bArr = new byte[zzj];
            zzL(bArr, 0, zzj);
            return zzhde.zzh(bArr, 0, zzj);
        }
        if (zzj == 0) {
            return "";
        }
        if (zzj <= 0) {
            throw zzhag.zzf();
        }
        throw zzhag.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final void zzz(int i) throws zzhag {
        if (this.zzk != i) {
            throw zzhag.zzb();
        }
    }

    public final void zzB(int i) throws IOException {
        if (i >= 0) {
            if (i <= ((this.zzh - this.zzl) - this.zzm) + this.zzn) {
                while (i > 0) {
                    if (this.zzo - this.zzm == 0) {
                        zzK();
                    }
                    int min = Math.min(i, (int) (this.zzo - this.zzm));
                    i -= min;
                    this.zzm += min;
                }
                return;
            }
        }
        if (i < 0) {
            throw zzhag.zzf();
        }
        throw zzhag.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final boolean zzE(int i) throws IOException {
        int zzm;
        int i2 = i & 7;
        if (i2 == 0) {
            for (int i3 = 0; i3 < 10; i3++) {
                if (zza() >= 0) {
                    return true;
                }
            }
            throw zzhag.zze();
        }
        if (i2 == 1) {
            zzB(8);
            return true;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    return false;
                }
                if (i2 == 5) {
                    zzB(4);
                    return true;
                }
                throw zzhag.zza();
            }
            do {
                zzm = zzm();
                if (zzm == 0) {
                    break;
                }
            } while (zzE(zzm));
            zzz(((i >>> 3) << 3) | 4);
            return true;
        }
        zzB(zzj());
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0087, code lost:
    
        if (com.google.android.gms.internal.ads.zzhcz.zza(r4) >= 0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzj() throws java.io.IOException {
        /*
            r10 = this;
            long r0 = r10.zzm
            long r2 = r10.zzo
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 != 0) goto La
            goto L8c
        La:
            r2 = 1
            long r4 = r0 + r2
            byte r0 = com.google.android.gms.internal.ads.zzhcz.zza(r0)
            if (r0 < 0) goto L1a
            long r4 = r10.zzm
            long r4 = r4 + r2
            r10.zzm = r4
            return r0
        L1a:
            long r6 = r10.zzo
            long r8 = r10.zzm
            long r6 = r6 - r8
            r8 = 10
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 < 0) goto L8c
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhcz.zza(r4)
            int r1 = r1 << 7
            r0 = r0 ^ r1
            if (r0 >= 0) goto L33
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L89
        L33:
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhcz.zza(r6)
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L42
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L40:
            r6 = r4
            goto L89
        L42:
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhcz.zza(r4)
            int r1 = r1 << 21
            r0 = r0 ^ r1
            if (r0 >= 0) goto L52
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            goto L89
        L52:
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhcz.zza(r6)
            int r6 = r1 << 28
            r0 = r0 ^ r6
            r6 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r6
            if (r1 >= 0) goto L40
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhcz.zza(r4)
            if (r1 >= 0) goto L89
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhcz.zza(r6)
            if (r1 >= 0) goto L40
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhcz.zza(r4)
            if (r1 >= 0) goto L89
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhcz.zza(r6)
            if (r1 >= 0) goto L40
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhcz.zza(r4)
            if (r1 < 0) goto L8c
        L89:
            r10.zzm = r6
            return r0
        L8c:
            long r0 = r10.zzs()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgyp.zzj():int");
    }

    public final long zzr() throws IOException {
        long zza;
        long j;
        long j2;
        int i;
        long j3 = this.zzm;
        if (this.zzo != j3) {
            long j4 = j3 + 1;
            byte zza2 = zzhcz.zza(j3);
            if (zza2 >= 0) {
                this.zzm++;
                return zza2;
            }
            if (this.zzo - this.zzm >= 10) {
                long j5 = j4 + 1;
                int zza3 = zza2 ^ (zzhcz.zza(j4) << 7);
                if (zza3 >= 0) {
                    long j6 = j5 + 1;
                    int zza4 = zza3 ^ (zzhcz.zza(j5) << Ascii.SO);
                    if (zza4 >= 0) {
                        zza = zza4 ^ 16256;
                    } else {
                        j5 = j6 + 1;
                        int zza5 = zza4 ^ (zzhcz.zza(j6) << Ascii.NAK);
                        if (zza5 < 0) {
                            i = zza5 ^ (-2080896);
                        } else {
                            j6 = j5 + 1;
                            long zza6 = zza5 ^ (zzhcz.zza(j5) << 28);
                            if (zza6 < 0) {
                                long j7 = j6 + 1;
                                long zza7 = zza6 ^ (zzhcz.zza(j6) << 35);
                                if (zza7 < 0) {
                                    j = -34093383808L;
                                } else {
                                    j6 = j7 + 1;
                                    zza6 = zza7 ^ (zzhcz.zza(j7) << 42);
                                    if (zza6 >= 0) {
                                        j2 = 4363953127296L;
                                    } else {
                                        j7 = j6 + 1;
                                        zza7 = zza6 ^ (zzhcz.zza(j6) << 49);
                                        if (zza7 < 0) {
                                            j = -558586000294016L;
                                        } else {
                                            j6 = j7 + 1;
                                            zza = (zza7 ^ (zzhcz.zza(j7) << 56)) ^ 71499008037633920L;
                                            if (zza < 0) {
                                                long j8 = 1 + j6;
                                                if (zzhcz.zza(j6) >= 0) {
                                                    j5 = j8;
                                                    this.zzm = j5;
                                                    return zza;
                                                }
                                            }
                                        }
                                    }
                                }
                                zza = zza7 ^ j;
                                j5 = j7;
                                this.zzm = j5;
                                return zza;
                            }
                            j2 = 266354560;
                            zza = zza6 ^ j2;
                        }
                    }
                    j5 = j6;
                    this.zzm = j5;
                    return zza;
                }
                i = zza3 ^ (-128);
                zza = i;
                this.zzm = j5;
                return zza;
            }
        }
        return zzs();
    }
}
