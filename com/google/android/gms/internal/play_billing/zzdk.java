package com.google.android.gms.internal.play_billing;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
public final class zzdk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zzdj zzdjVar) throws zzff {
        int zzh = zzh(bArr, i, zzdjVar);
        int i2 = zzdjVar.zza;
        if (i2 < 0) {
            throw zzff.zzd();
        }
        if (i2 > bArr.length - zzh) {
            throw zzff.zzg();
        }
        if (i2 == 0) {
            zzdjVar.zzc = zzdw.zzb;
            return zzh;
        }
        zzdjVar.zzc = zzdw.zzl(bArr, zzh, i2);
        return zzh + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(zzgm zzgmVar, byte[] bArr, int i, int i2, int i3, zzdj zzdjVar) throws IOException {
        Object zze = zzgmVar.zze();
        int zzl = zzl(zze, zzgmVar, bArr, i, i2, i3, zzdjVar);
        zzgmVar.zzf(zze);
        zzdjVar.zzc = zze;
        return zzl;
    }

    static int zzd(zzgm zzgmVar, byte[] bArr, int i, int i2, zzdj zzdjVar) throws IOException {
        Object zze = zzgmVar.zze();
        int zzm = zzm(zze, zzgmVar, bArr, i, i2, zzdjVar);
        zzgmVar.zzf(zze);
        zzdjVar.zzc = zze;
        return zzm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(zzgm zzgmVar, int i, byte[] bArr, int i2, int i3, zzfc zzfcVar, zzdj zzdjVar) throws IOException {
        int zzd = zzd(zzgmVar, bArr, i2, i3, zzdjVar);
        zzfcVar.add(zzdjVar.zzc);
        while (zzd < i3) {
            int zzh = zzh(bArr, zzd, zzdjVar);
            if (i != zzdjVar.zza) {
                break;
            }
            zzd = zzd(zzgmVar, bArr, zzh, i3, zzdjVar);
            zzfcVar.add(zzdjVar.zzc);
        }
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i, zzfc zzfcVar, zzdj zzdjVar) throws IOException {
        zzey zzeyVar = (zzey) zzfcVar;
        int zzh = zzh(bArr, i, zzdjVar);
        int i2 = zzdjVar.zza + zzh;
        while (zzh < i2) {
            zzh = zzh(bArr, zzh, zzdjVar);
            zzeyVar.zzf(zzdjVar.zza);
        }
        if (zzh == i2) {
            return zzh;
        }
        throw zzff.zzg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(int i, byte[] bArr, int i2, int i3, zzhe zzheVar, zzdj zzdjVar) throws zzff {
        if ((i >>> 3) == 0) {
            throw zzff.zzb();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int zzk = zzk(bArr, i2, zzdjVar);
            zzheVar.zzj(i, Long.valueOf(zzdjVar.zzb));
            return zzk;
        }
        if (i4 == 1) {
            zzheVar.zzj(i, Long.valueOf(zzn(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int zzh = zzh(bArr, i2, zzdjVar);
            int i5 = zzdjVar.zza;
            if (i5 < 0) {
                throw zzff.zzd();
            }
            if (i5 > bArr.length - zzh) {
                throw zzff.zzg();
            }
            if (i5 == 0) {
                zzheVar.zzj(i, zzdw.zzb);
            } else {
                zzheVar.zzj(i, zzdw.zzl(bArr, zzh, i5));
            }
            return zzh + i5;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zzheVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            }
            throw zzff.zzb();
        }
        int i6 = (i & (-8)) | 4;
        zzhe zzf = zzhe.zzf();
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int zzh2 = zzh(bArr, i2, zzdjVar);
            int i8 = zzdjVar.zza;
            i7 = i8;
            if (i8 == i6) {
                i2 = zzh2;
                break;
            }
            int zzg = zzg(i7, bArr, zzh2, i3, zzf, zzdjVar);
            i7 = i8;
            i2 = zzg;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzff.zze();
        }
        zzheVar.zzj(i, zzf);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i, zzdj zzdjVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzi(b, bArr, i2, zzdjVar);
        }
        zzdjVar.zza = b;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i, byte[] bArr, int i2, zzdj zzdjVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzdjVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzdjVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzdjVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzdjVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzdjVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i, byte[] bArr, int i2, int i3, zzfc zzfcVar, zzdj zzdjVar) {
        zzey zzeyVar = (zzey) zzfcVar;
        int zzh = zzh(bArr, i2, zzdjVar);
        zzeyVar.zzf(zzdjVar.zza);
        while (zzh < i3) {
            int zzh2 = zzh(bArr, zzh, zzdjVar);
            if (i != zzdjVar.zza) {
                break;
            }
            zzh = zzh(bArr, zzh2, zzdjVar);
            zzeyVar.zzf(zzdjVar.zza);
        }
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(byte[] bArr, int i, zzdj zzdjVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzdjVar.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= (b2 & Byte.MAX_VALUE) << i4;
            i3 = i5;
            b = b2;
        }
        zzdjVar.zzb = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(Object obj, zzgm zzgmVar, byte[] bArr, int i, int i2, int i3, zzdj zzdjVar) throws IOException {
        int zzc = ((zzgf) zzgmVar).zzc(obj, bArr, i, i2, i3, zzdjVar);
        zzdjVar.zzc = obj;
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(Object obj, zzgm zzgmVar, byte[] bArr, int i, int i2, zzdj zzdjVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zzi(i4, bArr, i3, zzdjVar);
            i4 = zzdjVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzff.zzg();
        }
        int i6 = i4 + i5;
        zzgmVar.zzh(obj, bArr, i5, i6, zzdjVar);
        zzdjVar.zzc = obj;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzn(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }
}
