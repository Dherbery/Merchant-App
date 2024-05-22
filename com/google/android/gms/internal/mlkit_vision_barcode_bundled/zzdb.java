package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public abstract class zzdb implements Iterable, Serializable {
    private static final Comparator zza;
    public static final zzdb zzb = new zzcy(zzem.zzd);
    private static final zzda zzd;
    private int zzc = 0;

    static {
        int i = zzcn.zza;
        zzd = new zzda(null);
        zza = new zzct();
    }

    public static zzdb zzr(byte[] bArr, int i, int i2) {
        zzo(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzcy(bArr2);
    }

    public static zzdb zzs(InputStream inputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        int i = 256;
        while (true) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            zzdb zzr = i2 == 0 ? null : zzr(bArr, 0, i2);
            if (zzr == null) {
                break;
            }
            arrayList.add(zzr);
            i = Math.min(i + i, 8192);
        }
        int size = arrayList.size();
        return size == 0 ? zzb : zzc(arrayList.iterator(), size);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzv(int i, int i2) {
        if (((i2 - (i + 1)) | i) < 0) {
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
        }
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzc;
        if (i == 0) {
            int zzd2 = zzd();
            i = zzi(zzd2, 0, zzd2);
            if (i == 0) {
                i = 1;
            }
            this.zzc = i;
        }
        return i;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        objArr[2] = zzd() <= 50 ? zzgw.zza(this) : zzgw.zza(zzk(0, 47)).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte zzb(int i);

    public abstract int zzd();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void zze(byte[] bArr, int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int zzf();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean zzh();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int zzi(int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int zzj(int i, int i2, int i3);

    public abstract zzdb zzk(int i, int i2);

    protected abstract String zzl(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzm(zzcr zzcrVar) throws IOException;

    public abstract boolean zzn();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzp() {
        return this.zzc;
    }

    @Override // java.lang.Iterable
    /* renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public zzcw iterator() {
        return new zzcs(this);
    }

    public final String zzt(Charset charset) {
        return zzd() == 0 ? "" : zzl(charset);
    }

    public final String zzu() {
        return zzt(zzem.zzb);
    }

    @Deprecated
    public final void zzw(byte[] bArr, int i, int i2, int i3) {
        zzo(0, i3, zzd());
        zzo(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zze(bArr, 0, i2, i3);
        }
    }

    public final byte[] zzx() {
        int zzd2 = zzd();
        if (zzd2 == 0) {
            return zzem.zzd;
        }
        byte[] bArr = new byte[zzd2];
        zze(bArr, 0, 0, zzd2);
        return bArr;
    }

    private static zzdb zzc(Iterator it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i)));
        }
        if (i == 1) {
            return (zzdb) it.next();
        }
        int i2 = i >>> 1;
        zzdb zzc = zzc(it, i2);
        zzdb zzc2 = zzc(it, i - i2);
        if (Integer.MAX_VALUE - zzc.zzd() < zzc2.zzd()) {
            throw new IllegalArgumentException("ByteString would be too long: " + zzc.zzd() + "+" + zzc2.zzd());
        }
        return zzgg.zzz(zzc, zzc2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }
}
