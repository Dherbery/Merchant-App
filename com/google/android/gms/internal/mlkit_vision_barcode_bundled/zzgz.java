package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zzgz {
    private static final zzgz zza = new zzgz(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzgz() {
        this(0, new int[8], new Object[8], true);
    }

    private zzgz(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzgz zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgz zze(zzgz zzgzVar, zzgz zzgzVar2) {
        int i = zzgzVar.zzb + zzgzVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzgzVar.zzc, i);
        System.arraycopy(zzgzVar2.zzc, 0, copyOf, zzgzVar.zzb, zzgzVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzgzVar.zzd, i);
        System.arraycopy(zzgzVar2.zzd, 0, copyOf2, zzgzVar.zzb, zzgzVar2.zzb);
        return new zzgz(i, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgz zzf() {
        return new zzgz(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i) {
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
        if (obj == null || !(obj instanceof zzgz)) {
            return false;
        }
        zzgz zzgzVar = (zzgz) obj;
        int i = this.zzb;
        if (i == zzgzVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzgzVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzgzVar.zzd;
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
        int i6 = (i2 * 31) + i4;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return (i6 * 31) + i3;
    }

    public final int zza() {
        int zzz;
        int zzy;
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
                    i = zzdj.zzy(i6 << 3) + 8;
                } else if (i7 == 2) {
                    zzdb zzdbVar = (zzdb) this.zzd[i4];
                    int i8 = zzdj.zzb;
                    int zzd = zzdbVar.zzd();
                    i = zzdj.zzy(i6 << 3) + zzdj.zzy(zzd) + zzd;
                } else if (i7 == 3) {
                    int i9 = i6 << 3;
                    int i10 = zzdj.zzb;
                    zzz = ((zzgz) this.zzd[i4]).zza();
                    int zzy2 = zzdj.zzy(i9);
                    zzy = zzy2 + zzy2;
                } else if (i7 == 5) {
                    ((Integer) this.zzd[i4]).intValue();
                    i = zzdj.zzy(i6 << 3) + 4;
                } else {
                    throw new IllegalStateException(zzeo.zza());
                }
                i3 += i;
            } else {
                int i11 = i6 << 3;
                zzz = zzdj.zzz(((Long) this.zzd[i4]).longValue());
                zzy = zzdj.zzy(i11);
            }
            i = zzy + zzz;
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
            zzdb zzdbVar = (zzdb) this.zzd[i3];
            int i5 = zzdj.zzb;
            int zzd = zzdbVar.zzd();
            int zzy = zzdj.zzy(zzd) + zzd;
            int zzy2 = zzdj.zzy(16);
            int zzy3 = zzdj.zzy(i4);
            int zzy4 = zzdj.zzy(8);
            i2 += zzy4 + zzy4 + zzy2 + zzy3 + zzdj.zzy(24) + zzy;
        }
        this.zze = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzgz zzd(zzgz zzgzVar) {
        if (zzgzVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzgzVar.zzb;
        zzm(i);
        System.arraycopy(zzgzVar.zzc, 0, this.zzc, this.zzb, zzgzVar.zzb);
        System.arraycopy(zzgzVar.zzd, 0, this.zzd, this.zzb, zzgzVar.zzb);
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
            zzfq.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(int i, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzk(zzhq zzhqVar) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzhqVar.zzw(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzl(zzhq zzhqVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzhqVar.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzhqVar.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzhqVar.zzd(i4, (zzdb) obj);
                } else if (i3 == 3) {
                    zzhqVar.zzF(i4);
                    ((zzgz) obj).zzl(zzhqVar);
                    zzhqVar.zzh(i4);
                } else if (i3 == 5) {
                    zzhqVar.zzk(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzeo.zza());
                }
            }
        }
    }
}
