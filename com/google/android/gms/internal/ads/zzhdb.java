package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
abstract class zzhdb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String zzd(ByteBuffer byteBuffer, int i, int i2) throws zzhag {
        if ((((byteBuffer.limit() - i) - i2) | i | i2) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte b = byteBuffer.get(i);
            if (!zzhda.zzd(b)) {
                break;
            }
            i++;
            cArr[i4] = (char) b;
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte b2 = byteBuffer.get(i);
            if (zzhda.zzd(b2)) {
                int i7 = i5 + 1;
                cArr[i5] = (char) b2;
                i = i6;
                while (true) {
                    i5 = i7;
                    if (i < i3) {
                        byte b3 = byteBuffer.get(i);
                        if (zzhda.zzd(b3)) {
                            i++;
                            i7 = i5 + 1;
                            cArr[i5] = (char) b3;
                        }
                    }
                }
            } else if (zzhda.zzf(b2)) {
                if (i6 < i3) {
                    zzhda.zzc(b2, byteBuffer.get(i6), cArr, i5);
                    i5++;
                    i = i6 + 1;
                } else {
                    throw zzhag.zzd();
                }
            } else if (zzhda.zze(b2)) {
                if (i6 < i3 - 1) {
                    int i8 = i6 + 1;
                    zzhda.zzb(b2, byteBuffer.get(i6), byteBuffer.get(i8), cArr, i5);
                    i5++;
                    i = i8 + 1;
                } else {
                    throw zzhag.zzd();
                }
            } else if (i6 < i3 - 2) {
                int i9 = i6 + 1;
                byte b4 = byteBuffer.get(i6);
                int i10 = i9 + 1;
                zzhda.zza(b2, b4, byteBuffer.get(i9), byteBuffer.get(i10), cArr, i5);
                i5 += 2;
                i = i10 + 1;
            } else {
                throw zzhag.zzd();
            }
        }
        return new String(cArr, 0, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zza(int i, byte[] bArr, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String zzb(byte[] bArr, int i, int i2) throws zzhag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzc(byte[] bArr, int i, int i2) {
        return zza(0, bArr, i, i2) == 0;
    }
}
