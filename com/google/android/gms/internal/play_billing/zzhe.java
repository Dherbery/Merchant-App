package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
public final class zzhe {
    private static final zzhe zza = new zzhe(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzhe() {
        this(0, new int[8], new Object[8], true);
    }

    private zzhe(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzhe zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhe zze(zzhe zzheVar, zzhe zzheVar2) {
        int i = zzheVar.zzb + zzheVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzheVar.zzc, i);
        System.arraycopy(zzheVar2.zzc, 0, copyOf, zzheVar.zzb, zzheVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzheVar.zzd, i);
        System.arraycopy(zzheVar2.zzd, 0, copyOf2, zzheVar.zzb, zzheVar2.zzb);
        return new zzhe(i, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhe zzf() {
        return new zzhe(0, new int[8], new Object[8], true);
    }

    private final void zzl(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhe)) {
            return false;
        }
        zzhe zzheVar = (zzhe) obj;
        int i = this.zzb;
        if (i == zzheVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzheVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzheVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = ((i2 * 31) + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final int zza() {
        int zzy;
        int zzx;
        int i;
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            int i5 = this.zzc[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 != 0) {
                if (i7 == 1) {
                    ((Long) this.zzd[i4]).longValue();
                    i = zzee.zzx(i6 << 3) + 8;
                } else if (i7 == 2) {
                    int i8 = i6 << 3;
                    zzdw zzdwVar = (zzdw) this.zzd[i4];
                    int i9 = zzee.zzb;
                    int zzd = zzdwVar.zzd();
                    i = zzee.zzx(i8) + zzee.zzx(zzd) + zzd;
                } else if (i7 == 3) {
                    int i10 = i6 << 3;
                    int i11 = zzee.zzb;
                    zzy = ((zzhe) this.zzd[i4]).zza();
                    int zzx2 = zzee.zzx(i10);
                    zzx = zzx2 + zzx2;
                } else if (i7 == 5) {
                    ((Integer) this.zzd[i4]).intValue();
                    i = zzee.zzx(i6 << 3) + 4;
                } else {
                    throw new IllegalStateException(zzff.zza());
                }
                i3 += i;
            } else {
                int i12 = i6 << 3;
                zzy = zzee.zzy(((Long) this.zzd[i4]).longValue());
                zzx = zzee.zzx(i12);
            }
            i = zzx + zzy;
            i3 += i;
        }
        this.zze = i3;
        return i3;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3] >>> 3;
            zzdw zzdwVar = (zzdw) this.zzd[i3];
            int i5 = zzee.zzb;
            int zzd = zzdwVar.zzd();
            int zzx = zzee.zzx(zzd) + zzd;
            int zzx2 = zzee.zzx(16);
            int zzx3 = zzee.zzx(i4);
            int zzx4 = zzee.zzx(8);
            i2 += zzx4 + zzx4 + zzx2 + zzx3 + zzee.zzx(24) + zzx;
        }
        this.zze = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzhe zzd(zzhe zzheVar) {
        if (zzheVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzheVar.zzb;
        zzl(i);
        System.arraycopy(zzheVar.zzc, 0, this.zzc, this.zzb, zzheVar.zzb);
        System.arraycopy(zzheVar.zzd, 0, this.zzd, this.zzb, zzheVar.zzb);
        this.zzb = i;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzge.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(int i, Object obj) {
        zzg();
        zzl(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final void zzk(zzhv zzhvVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzhvVar.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzhvVar.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzhvVar.zzd(i4, (zzdw) obj);
                } else if (i3 == 3) {
                    zzhvVar.zzE(i4);
                    ((zzhe) obj).zzk(zzhvVar);
                    zzhvVar.zzh(i4);
                } else if (i3 == 5) {
                    zzhvVar.zzk(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzff.zza());
                }
            }
        }
    }
}
