package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import com.facebook.soloader.Elf64_Ehdr;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zzfr<T> implements zzgh<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhi.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfo zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzfc zzl;
    private final zzgy zzm;
    private final zzdp zzn;
    private final int zzo;
    private final zzfu zzp;
    private final zzfj zzq;

    private zzfr(int[] iArr, Object[] objArr, int i, int i2, zzfo zzfoVar, int i3, boolean z, int[] iArr2, int i4, int i5, zzfu zzfuVar, zzfc zzfcVar, zzgy zzgyVar, zzdp zzdpVar, zzfj zzfjVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzo = i3;
        boolean z2 = false;
        if (zzdpVar != null && zzdpVar.zzg(zzfoVar)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i4;
        this.zzk = i5;
        this.zzp = zzfuVar;
        this.zzl = zzfcVar;
        this.zzm = zzgyVar;
        this.zzn = zzdpVar;
        this.zzg = zzfoVar;
        this.zzq = zzfjVar;
    }

    private final zzeh zzA(int i) {
        int i2 = i / 3;
        return (zzeh) this.zzd[i2 + i2 + 1];
    }

    private final zzgh zzB(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgh zzghVar = (zzgh) this.zzd[i3];
        if (zzghVar != null) {
            return zzghVar;
        }
        zzgh zzb2 = zzfx.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzC(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzD(Object obj, int i) {
        zzgh zzB = zzB(i);
        int zzy = zzy(i) & 1048575;
        if (!zzP(obj, i)) {
            return zzB.zze();
        }
        Object object = zzb.getObject(obj, zzy);
        if (zzS(object)) {
            return object;
        }
        Object zze = zzB.zze();
        if (object != null) {
            zzB.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzE(Object obj, int i, int i2) {
        zzgh zzB = zzB(i2);
        if (!zzT(obj, i, i2)) {
            return zzB.zze();
        }
        Object object = zzb.getObject(obj, zzy(i2) & 1048575);
        if (zzS(object)) {
            return object;
        }
        Object zze = zzB.zze();
        if (object != null) {
            zzB.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzF(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzG(Object obj) {
        if (!zzS(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzH(Object obj, Object obj2, int i) {
        if (zzP(obj2, i)) {
            int zzy = zzy(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzy;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgh zzB = zzB(i);
            if (!zzP(obj, i)) {
                if (!zzS(object)) {
                    unsafe.putObject(obj, j, object);
                } else {
                    Object zze = zzB.zze();
                    zzB.zzg(zze, object);
                    unsafe.putObject(obj, j, zze);
                }
                zzJ(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzS(object2)) {
                Object zze2 = zzB.zze();
                zzB.zzg(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            zzB.zzg(object2, object);
        }
    }

    private final void zzI(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzT(obj2, i2, i)) {
            int zzy = zzy(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzy;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgh zzB = zzB(i);
            if (!zzT(obj, i2, i)) {
                if (!zzS(object)) {
                    unsafe.putObject(obj, j, object);
                } else {
                    Object zze = zzB.zze();
                    zzB.zzg(zze, object);
                    unsafe.putObject(obj, j, zze);
                }
                zzK(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzS(object2)) {
                Object zze2 = zzB.zze();
                zzB.zzg(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            zzB.zzg(object2, object);
        }
    }

    private final void zzJ(Object obj, int i) {
        int zzv = zzv(i);
        long j = 1048575 & zzv;
        if (j == 1048575) {
            return;
        }
        zzhi.zzq(obj, j, (1 << (zzv >>> 20)) | zzhi.zzc(obj, j));
    }

    private final void zzK(Object obj, int i, int i2) {
        zzhi.zzq(obj, zzv(i2) & 1048575, i);
    }

    private final void zzL(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzy(i) & 1048575, obj2);
        zzJ(obj, i);
    }

    private final void zzM(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzy(i2) & 1048575, obj2);
        zzK(obj, i, i2);
    }

    private final void zzN(zzhq zzhqVar, int i, Object obj, int i2) throws IOException {
        if (obj == null) {
            return;
        }
        throw null;
    }

    private final boolean zzO(Object obj, Object obj2, int i) {
        return zzP(obj, i) == zzP(obj2, i);
    }

    private final boolean zzP(Object obj, int i) {
        int zzv = zzv(i);
        long j = zzv & 1048575;
        if (j != 1048575) {
            return (zzhi.zzc(obj, j) & (1 << (zzv >>> 20))) != 0;
        }
        int zzy = zzy(i);
        long j2 = zzy & 1048575;
        switch (zzx(zzy)) {
            case 0:
                return Double.doubleToRawLongBits(zzhi.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhi.zzb(obj, j2)) != 0;
            case 2:
                return zzhi.zzd(obj, j2) != 0;
            case 3:
                return zzhi.zzd(obj, j2) != 0;
            case 4:
                return zzhi.zzc(obj, j2) != 0;
            case 5:
                return zzhi.zzd(obj, j2) != 0;
            case 6:
                return zzhi.zzc(obj, j2) != 0;
            case 7:
                return zzhi.zzw(obj, j2);
            case 8:
                Object zzf = zzhi.zzf(obj, j2);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                }
                if (zzf instanceof zzdb) {
                    return !zzdb.zzb.equals(zzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhi.zzf(obj, j2) != null;
            case 10:
                return !zzdb.zzb.equals(zzhi.zzf(obj, j2));
            case 11:
                return zzhi.zzc(obj, j2) != 0;
            case 12:
                return zzhi.zzc(obj, j2) != 0;
            case 13:
                return zzhi.zzc(obj, j2) != 0;
            case 14:
                return zzhi.zzd(obj, j2) != 0;
            case 15:
                return zzhi.zzc(obj, j2) != 0;
            case 16:
                return zzhi.zzd(obj, j2) != 0;
            case 17:
                return zzhi.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzQ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzP(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzR(Object obj, int i, zzgh zzghVar) {
        return zzghVar.zzk(zzhi.zzf(obj, i & 1048575));
    }

    private static boolean zzS(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzed) {
            return ((zzed) obj).zzX();
        }
        return true;
    }

    private final boolean zzT(Object obj, int i, int i2) {
        return zzhi.zzc(obj, (long) (zzv(i2) & 1048575)) == i;
    }

    private static boolean zzU(Object obj, long j) {
        return ((Boolean) zzhi.zzf(obj, j)).booleanValue();
    }

    private static final void zzV(int i, Object obj, zzhq zzhqVar) throws IOException {
        if (obj instanceof String) {
            zzhqVar.zzG(i, (String) obj);
        } else {
            zzhqVar.zzd(i, (zzdb) obj);
        }
    }

    static zzgz zzd(Object obj) {
        zzed zzedVar = (zzed) obj;
        zzgz zzgzVar = zzedVar.zzc;
        if (zzgzVar != zzgz.zzc()) {
            return zzgzVar;
        }
        zzgz zzf = zzgz.zzf();
        zzedVar.zzc = zzf;
        return zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:65:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0252  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfr zzl(java.lang.Class r30, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfl r31, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfu r32, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfc r33, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy r34, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp r35, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfj r36) {
        /*
            Method dump skipped, instructions count: 996
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfr.zzl(java.lang.Class, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfl, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfu, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfc, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfj):com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfr");
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzhi.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzhi.zzf(obj, j)).floatValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x003a. Please report as an issue. */
    private final int zzo(Object obj) {
        int i;
        int zzy;
        int zzy2;
        int zzz;
        int zzy3;
        int zzy4;
        int zzy5;
        int zzy6;
        int zzt;
        boolean z;
        int zzc;
        int zzh;
        int zzy7;
        int zzy8;
        int i2;
        int zzy9;
        int zzy10;
        int zzy11;
        int zzy12;
        Unsafe unsafe = zzb;
        int i3 = 1048575;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < this.zzc.length) {
            int zzy13 = zzy(i5);
            int[] iArr = this.zzc;
            int i8 = iArr[i5];
            int zzx = zzx(zzy13);
            if (zzx <= 17) {
                int i9 = iArr[i5 + 2];
                int i10 = i9 & i3;
                int i11 = i9 >>> 20;
                if (i10 != i4) {
                    i7 = unsafe.getInt(obj, i10);
                    i4 = i10;
                }
                i = 1 << i11;
            } else {
                i = 0;
            }
            long j = zzy13 & i3;
            switch (zzx) {
                case 0:
                    if ((i7 & i) != 0) {
                        zzy = zzdj.zzy(i8 << 3);
                        zzy4 = zzy + 8;
                        i6 += zzy4;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i7 & i) != 0) {
                        zzy2 = zzdj.zzy(i8 << 3);
                        zzy4 = zzy2 + 4;
                        i6 += zzy4;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i7 & i) != 0) {
                        zzz = zzdj.zzz(unsafe.getLong(obj, j));
                        zzy3 = zzdj.zzy(i8 << 3);
                        i6 += zzy3 + zzz;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i7 & i) != 0) {
                        zzz = zzdj.zzz(unsafe.getLong(obj, j));
                        zzy3 = zzdj.zzy(i8 << 3);
                        i6 += zzy3 + zzz;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i7 & i) != 0) {
                        zzz = zzdj.zzu(unsafe.getInt(obj, j));
                        zzy3 = zzdj.zzy(i8 << 3);
                        i6 += zzy3 + zzz;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i7 & i) != 0) {
                        zzy = zzdj.zzy(i8 << 3);
                        zzy4 = zzy + 8;
                        i6 += zzy4;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i7 & i) != 0) {
                        zzy2 = zzdj.zzy(i8 << 3);
                        zzy4 = zzy2 + 4;
                        i6 += zzy4;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i7 & i) != 0) {
                        zzy4 = zzdj.zzy(i8 << 3) + 1;
                        i6 += zzy4;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i7 & i) != 0) {
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzdb) {
                            int i12 = zzdj.zzb;
                            int zzd = ((zzdb) object).zzd();
                            zzy5 = zzdj.zzy(zzd) + zzd;
                            zzy6 = zzdj.zzy(i8 << 3);
                            zzy4 = zzy6 + zzy5;
                            i6 += zzy4;
                            break;
                        } else {
                            zzz = zzdj.zzx((String) object);
                            zzy3 = zzdj.zzy(i8 << 3);
                            i6 += zzy3 + zzz;
                            break;
                        }
                    } else {
                        break;
                    }
                case 9:
                    if ((i7 & i) != 0) {
                        zzy4 = zzgj.zzn(i8, unsafe.getObject(obj, j), zzB(i5));
                        i6 += zzy4;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i7 & i) != 0) {
                        zzdb zzdbVar = (zzdb) unsafe.getObject(obj, j);
                        int i13 = zzdj.zzb;
                        int zzd2 = zzdbVar.zzd();
                        zzy5 = zzdj.zzy(zzd2) + zzd2;
                        zzy6 = zzdj.zzy(i8 << 3);
                        zzy4 = zzy6 + zzy5;
                        i6 += zzy4;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i7 & i) != 0) {
                        zzz = zzdj.zzy(unsafe.getInt(obj, j));
                        zzy3 = zzdj.zzy(i8 << 3);
                        i6 += zzy3 + zzz;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i7 & i) != 0) {
                        zzz = zzdj.zzu(unsafe.getInt(obj, j));
                        zzy3 = zzdj.zzy(i8 << 3);
                        i6 += zzy3 + zzz;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i7 & i) != 0) {
                        zzy2 = zzdj.zzy(i8 << 3);
                        zzy4 = zzy2 + 4;
                        i6 += zzy4;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((i7 & i) != 0) {
                        zzy = zzdj.zzy(i8 << 3);
                        zzy4 = zzy + 8;
                        i6 += zzy4;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((i7 & i) != 0) {
                        int i14 = unsafe.getInt(obj, j);
                        zzy3 = zzdj.zzy(i8 << 3);
                        zzz = zzdj.zzy((i14 >> 31) ^ (i14 + i14));
                        i6 += zzy3 + zzz;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i & i7) != 0) {
                        long j2 = unsafe.getLong(obj, j);
                        i6 += zzdj.zzy(i8 << 3) + zzdj.zzz((j2 >> 63) ^ (j2 + j2));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i7 & i) != 0) {
                        zzy4 = zzdj.zzt(i8, (zzfo) unsafe.getObject(obj, j), zzB(i5));
                        i6 += zzy4;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzy4 = zzgj.zzg(i8, (List) unsafe.getObject(obj, j), false);
                    i6 += zzy4;
                    break;
                case 19:
                    zzy4 = zzgj.zze(i8, (List) unsafe.getObject(obj, j), false);
                    i6 += zzy4;
                    break;
                case 20:
                    zzy4 = zzgj.zzl(i8, (List) unsafe.getObject(obj, j), false);
                    i6 += zzy4;
                    break;
                case 21:
                    zzy4 = zzgj.zzw(i8, (List) unsafe.getObject(obj, j), false);
                    i6 += zzy4;
                    break;
                case 22:
                    zzy4 = zzgj.zzj(i8, (List) unsafe.getObject(obj, j), false);
                    i6 += zzy4;
                    break;
                case 23:
                    zzy4 = zzgj.zzg(i8, (List) unsafe.getObject(obj, j), false);
                    i6 += zzy4;
                    break;
                case 24:
                    zzy4 = zzgj.zze(i8, (List) unsafe.getObject(obj, j), false);
                    i6 += zzy4;
                    break;
                case 25:
                    zzy4 = zzgj.zza(i8, (List) unsafe.getObject(obj, j), false);
                    i6 += zzy4;
                    break;
                case 26:
                    zzt = zzgj.zzt(i8, (List) unsafe.getObject(obj, j));
                    i6 += zzt;
                    break;
                case 27:
                    zzt = zzgj.zzo(i8, (List) unsafe.getObject(obj, j), zzB(i5));
                    i6 += zzt;
                    break;
                case 28:
                    zzt = zzgj.zzb(i8, (List) unsafe.getObject(obj, j));
                    i6 += zzt;
                    break;
                case 29:
                    zzt = zzgj.zzu(i8, (List) unsafe.getObject(obj, j), false);
                    i6 += zzt;
                    break;
                case 30:
                    z = false;
                    zzc = zzgj.zzc(i8, (List) unsafe.getObject(obj, j), false);
                    i6 += zzc;
                    break;
                case 31:
                    z = false;
                    zzc = zzgj.zze(i8, (List) unsafe.getObject(obj, j), false);
                    i6 += zzc;
                    break;
                case 32:
                    z = false;
                    zzc = zzgj.zzg(i8, (List) unsafe.getObject(obj, j), false);
                    i6 += zzc;
                    break;
                case 33:
                    z = false;
                    zzc = zzgj.zzp(i8, (List) unsafe.getObject(obj, j), false);
                    i6 += zzc;
                    break;
                case 34:
                    z = false;
                    zzc = zzgj.zzr(i8, (List) unsafe.getObject(obj, j), false);
                    i6 += zzc;
                    break;
                case 35:
                    zzh = zzgj.zzh((List) unsafe.getObject(obj, j));
                    if (zzh > 0) {
                        zzy7 = zzdj.zzy(zzh);
                        zzy8 = zzdj.zzy(i8 << 3);
                        i2 = zzy8 + zzy7;
                        i6 += i2 + zzh;
                    }
                    break;
                case 36:
                    zzh = zzgj.zzf((List) unsafe.getObject(obj, j));
                    if (zzh > 0) {
                        zzy7 = zzdj.zzy(zzh);
                        zzy8 = zzdj.zzy(i8 << 3);
                        i2 = zzy8 + zzy7;
                        i6 += i2 + zzh;
                    }
                    break;
                case 37:
                    zzh = zzgj.zzm((List) unsafe.getObject(obj, j));
                    if (zzh > 0) {
                        zzy7 = zzdj.zzy(zzh);
                        zzy8 = zzdj.zzy(i8 << 3);
                        i2 = zzy8 + zzy7;
                        i6 += i2 + zzh;
                    }
                    break;
                case 38:
                    zzh = zzgj.zzx((List) unsafe.getObject(obj, j));
                    if (zzh > 0) {
                        zzy7 = zzdj.zzy(zzh);
                        zzy8 = zzdj.zzy(i8 << 3);
                        i2 = zzy8 + zzy7;
                        i6 += i2 + zzh;
                    }
                    break;
                case 39:
                    zzh = zzgj.zzk((List) unsafe.getObject(obj, j));
                    if (zzh > 0) {
                        zzy7 = zzdj.zzy(zzh);
                        zzy8 = zzdj.zzy(i8 << 3);
                        i2 = zzy8 + zzy7;
                        i6 += i2 + zzh;
                    }
                    break;
                case 40:
                    zzh = zzgj.zzh((List) unsafe.getObject(obj, j));
                    if (zzh > 0) {
                        zzy7 = zzdj.zzy(zzh);
                        zzy8 = zzdj.zzy(i8 << 3);
                        i2 = zzy8 + zzy7;
                        i6 += i2 + zzh;
                    }
                    break;
                case 41:
                    zzh = zzgj.zzf((List) unsafe.getObject(obj, j));
                    if (zzh > 0) {
                        zzy7 = zzdj.zzy(zzh);
                        zzy8 = zzdj.zzy(i8 << 3);
                        i2 = zzy8 + zzy7;
                        i6 += i2 + zzh;
                    }
                    break;
                case 42:
                    List list = (List) unsafe.getObject(obj, j);
                    int i15 = zzgj.zza;
                    zzh = list.size();
                    if (zzh > 0) {
                        zzy7 = zzdj.zzy(zzh);
                        zzy8 = zzdj.zzy(i8 << 3);
                        i2 = zzy8 + zzy7;
                        i6 += i2 + zzh;
                    }
                    break;
                case 43:
                    zzh = zzgj.zzv((List) unsafe.getObject(obj, j));
                    if (zzh > 0) {
                        zzy7 = zzdj.zzy(zzh);
                        zzy8 = zzdj.zzy(i8 << 3);
                        i2 = zzy8 + zzy7;
                        i6 += i2 + zzh;
                    }
                    break;
                case 44:
                    zzh = zzgj.zzd((List) unsafe.getObject(obj, j));
                    if (zzh > 0) {
                        zzy7 = zzdj.zzy(zzh);
                        zzy8 = zzdj.zzy(i8 << 3);
                        i2 = zzy8 + zzy7;
                        i6 += i2 + zzh;
                    }
                    break;
                case 45:
                    zzh = zzgj.zzf((List) unsafe.getObject(obj, j));
                    if (zzh > 0) {
                        zzy7 = zzdj.zzy(zzh);
                        zzy8 = zzdj.zzy(i8 << 3);
                        i2 = zzy8 + zzy7;
                        i6 += i2 + zzh;
                    }
                    break;
                case 46:
                    zzh = zzgj.zzh((List) unsafe.getObject(obj, j));
                    if (zzh > 0) {
                        zzy7 = zzdj.zzy(zzh);
                        zzy8 = zzdj.zzy(i8 << 3);
                        i2 = zzy8 + zzy7;
                        i6 += i2 + zzh;
                    }
                    break;
                case 47:
                    zzh = zzgj.zzq((List) unsafe.getObject(obj, j));
                    if (zzh > 0) {
                        zzy7 = zzdj.zzy(zzh);
                        zzy8 = zzdj.zzy(i8 << 3);
                        i2 = zzy8 + zzy7;
                        i6 += i2 + zzh;
                    }
                    break;
                case 48:
                    zzh = zzgj.zzs((List) unsafe.getObject(obj, j));
                    if (zzh > 0) {
                        zzy7 = zzdj.zzy(zzh);
                        zzy8 = zzdj.zzy(i8 << 3);
                        i2 = zzy8 + zzy7;
                        i6 += i2 + zzh;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    zzt = zzgj.zzi(i8, (List) unsafe.getObject(obj, j), zzB(i5));
                    i6 += zzt;
                    break;
                case 50:
                    zzfj.zza(i8, unsafe.getObject(obj, j), zzC(i5));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzT(obj, i8, i5)) {
                        zzy9 = zzdj.zzy(i8 << 3);
                        zzt = zzy9 + 8;
                        i6 += zzt;
                    }
                    break;
                case 52:
                    if (zzT(obj, i8, i5)) {
                        zzy10 = zzdj.zzy(i8 << 3);
                        zzt = zzy10 + 4;
                        i6 += zzt;
                    }
                    break;
                case 53:
                    if (zzT(obj, i8, i5)) {
                        zzh = zzdj.zzz(zzz(obj, j));
                        i2 = zzdj.zzy(i8 << 3);
                        i6 += i2 + zzh;
                    }
                    break;
                case Elf64_Ehdr.e_phentsize /* 54 */:
                    if (zzT(obj, i8, i5)) {
                        zzh = zzdj.zzz(zzz(obj, j));
                        i2 = zzdj.zzy(i8 << 3);
                        i6 += i2 + zzh;
                    }
                    break;
                case 55:
                    if (zzT(obj, i8, i5)) {
                        zzh = zzdj.zzu(zzp(obj, j));
                        i2 = zzdj.zzy(i8 << 3);
                        i6 += i2 + zzh;
                    }
                    break;
                case 56:
                    if (zzT(obj, i8, i5)) {
                        zzy9 = zzdj.zzy(i8 << 3);
                        zzt = zzy9 + 8;
                        i6 += zzt;
                    }
                    break;
                case 57:
                    if (zzT(obj, i8, i5)) {
                        zzy10 = zzdj.zzy(i8 << 3);
                        zzt = zzy10 + 4;
                        i6 += zzt;
                    }
                    break;
                case Elf64_Ehdr.e_shentsize /* 58 */:
                    if (zzT(obj, i8, i5)) {
                        zzt = zzdj.zzy(i8 << 3) + 1;
                        i6 += zzt;
                    }
                    break;
                case 59:
                    if (zzT(obj, i8, i5)) {
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzdb) {
                            int i16 = zzdj.zzb;
                            int zzd3 = ((zzdb) object2).zzd();
                            zzy11 = zzdj.zzy(zzd3) + zzd3;
                            zzy12 = zzdj.zzy(i8 << 3);
                            zzt = zzy12 + zzy11;
                            i6 += zzt;
                        } else {
                            zzh = zzdj.zzx((String) object2);
                            i2 = zzdj.zzy(i8 << 3);
                            i6 += i2 + zzh;
                        }
                    }
                    break;
                case 60:
                    if (zzT(obj, i8, i5)) {
                        zzt = zzgj.zzn(i8, unsafe.getObject(obj, j), zzB(i5));
                        i6 += zzt;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzT(obj, i8, i5)) {
                        zzdb zzdbVar2 = (zzdb) unsafe.getObject(obj, j);
                        int i17 = zzdj.zzb;
                        int zzd4 = zzdbVar2.zzd();
                        zzy11 = zzdj.zzy(zzd4) + zzd4;
                        zzy12 = zzdj.zzy(i8 << 3);
                        zzt = zzy12 + zzy11;
                        i6 += zzt;
                    }
                    break;
                case Elf64_Ehdr.e_shstrndx /* 62 */:
                    if (zzT(obj, i8, i5)) {
                        zzh = zzdj.zzy(zzp(obj, j));
                        i2 = zzdj.zzy(i8 << 3);
                        i6 += i2 + zzh;
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzT(obj, i8, i5)) {
                        zzh = zzdj.zzu(zzp(obj, j));
                        i2 = zzdj.zzy(i8 << 3);
                        i6 += i2 + zzh;
                    }
                    break;
                case 64:
                    if (zzT(obj, i8, i5)) {
                        zzy10 = zzdj.zzy(i8 << 3);
                        zzt = zzy10 + 4;
                        i6 += zzt;
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzT(obj, i8, i5)) {
                        zzy9 = zzdj.zzy(i8 << 3);
                        zzt = zzy9 + 8;
                        i6 += zzt;
                    }
                    break;
                case 66:
                    if (zzT(obj, i8, i5)) {
                        int zzp = zzp(obj, j);
                        i2 = zzdj.zzy(i8 << 3);
                        zzh = zzdj.zzy((zzp >> 31) ^ (zzp + zzp));
                        i6 += i2 + zzh;
                    }
                    break;
                case 67:
                    if (zzT(obj, i8, i5)) {
                        long zzz2 = zzz(obj, j);
                        i6 += zzdj.zzy(i8 << 3) + zzdj.zzz((zzz2 >> 63) ^ (zzz2 + zzz2));
                    }
                    break;
                case 68:
                    if (zzT(obj, i8, i5)) {
                        zzt = zzdj.zzt(i8, (zzfo) unsafe.getObject(obj, j), zzB(i5));
                        i6 += zzt;
                    }
                    break;
            }
            i5 += 3;
            i3 = 1048575;
        }
        int i18 = 0;
        zzgy zzgyVar = this.zzm;
        int zza2 = i6 + zzgyVar.zza(zzgyVar.zzd(obj));
        if (!this.zzh) {
            return zza2;
        }
        zzdt zzb2 = this.zzn.zzb(obj);
        for (int i19 = 0; i19 < zzb2.zza.zzb(); i19++) {
            Map.Entry zzg = zzb2.zza.zzg(i19);
            i18 += zzdt.zza((zzds) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : zzb2.zza.zzc()) {
            i18 += zzdt.zza((zzds) entry.getKey(), entry.getValue());
        }
        return zza2 + i18;
    }

    private static int zzp(Object obj, long j) {
        return ((Integer) zzhi.zzf(obj, j)).intValue();
    }

    private final int zzq(Object obj, byte[] bArr, int i, int i2, int i3, long j, zzco zzcoVar) throws IOException {
        Unsafe unsafe = zzb;
        Object zzC = zzC(i3);
        Object object = unsafe.getObject(obj, j);
        if (!((zzfi) object).zze()) {
            zzfi zzb2 = zzfi.zza().zzb();
            zzfj.zzb(zzb2, object);
            unsafe.putObject(obj, j, zzb2);
        }
        throw null;
    }

    private final int zzr(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzco zzcoVar) throws IOException {
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(zzcp.zzq(bArr, i))));
                    int i9 = i + 8;
                    unsafe.putInt(obj, j2, i4);
                    return i9;
                }
                break;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(zzcp.zzb(bArr, i))));
                    int i10 = i + 4;
                    unsafe.putInt(obj, j2, i4);
                    return i10;
                }
                break;
            case 53:
            case Elf64_Ehdr.e_phentsize /* 54 */:
                if (i5 == 0) {
                    int zzm = zzcp.zzm(bArr, i, zzcoVar);
                    unsafe.putObject(obj, j, Long.valueOf(zzcoVar.zzb));
                    unsafe.putInt(obj, j2, i4);
                    return zzm;
                }
                break;
            case 55:
            case Elf64_Ehdr.e_shstrndx /* 62 */:
                if (i5 == 0) {
                    int zzj = zzcp.zzj(bArr, i, zzcoVar);
                    unsafe.putObject(obj, j, Integer.valueOf(zzcoVar.zza));
                    unsafe.putInt(obj, j2, i4);
                    return zzj;
                }
                break;
            case 56:
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Long.valueOf(zzcp.zzq(bArr, i)));
                    int i11 = i + 8;
                    unsafe.putInt(obj, j2, i4);
                    return i11;
                }
                break;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Integer.valueOf(zzcp.zzb(bArr, i)));
                    int i12 = i + 4;
                    unsafe.putInt(obj, j2, i4);
                    return i12;
                }
                break;
            case Elf64_Ehdr.e_shentsize /* 58 */:
                if (i5 == 0) {
                    int zzm2 = zzcp.zzm(bArr, i, zzcoVar);
                    unsafe.putObject(obj, j, Boolean.valueOf(zzcoVar.zzb != 0));
                    unsafe.putInt(obj, j2, i4);
                    return zzm2;
                }
                break;
            case 59:
                if (i5 == 2) {
                    int zzj2 = zzcp.zzj(bArr, i, zzcoVar);
                    int i13 = zzcoVar.zza;
                    if (i13 == 0) {
                        unsafe.putObject(obj, j, "");
                    } else if ((i6 & 536870912) == 0 || zzhn.zzh(bArr, zzj2, zzj2 + i13)) {
                        unsafe.putObject(obj, j, new String(bArr, zzj2, i13, zzem.zzb));
                        zzj2 += i13;
                    } else {
                        throw zzeo.zzc();
                    }
                    unsafe.putInt(obj, j2, i4);
                    return zzj2;
                }
                break;
            case 60:
                if (i5 == 2) {
                    Object zzE = zzE(obj, i4, i8);
                    int zzo = zzcp.zzo(zzE, zzB(i8), bArr, i, i2, zzcoVar);
                    zzM(obj, i4, i8, zzE);
                    return zzo;
                }
                break;
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                if (i5 == 2) {
                    int zza2 = zzcp.zza(bArr, i, zzcoVar);
                    unsafe.putObject(obj, j, zzcoVar.zzc);
                    unsafe.putInt(obj, j2, i4);
                    return zza2;
                }
                break;
            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                if (i5 == 0) {
                    int zzj3 = zzcp.zzj(bArr, i, zzcoVar);
                    int i14 = zzcoVar.zza;
                    zzeh zzA = zzA(i8);
                    if (zzA == null || zzA.zza(i14)) {
                        unsafe.putObject(obj, j, Integer.valueOf(i14));
                        unsafe.putInt(obj, j2, i4);
                    } else {
                        zzd(obj).zzj(i3, Long.valueOf(i14));
                    }
                    return zzj3;
                }
                break;
            case 66:
                if (i5 == 0) {
                    int zzj4 = zzcp.zzj(bArr, i, zzcoVar);
                    unsafe.putObject(obj, j, Integer.valueOf(zzdf.zzb(zzcoVar.zza)));
                    unsafe.putInt(obj, j2, i4);
                    return zzj4;
                }
                break;
            case 67:
                if (i5 == 0) {
                    int zzm3 = zzcp.zzm(bArr, i, zzcoVar);
                    unsafe.putObject(obj, j, Long.valueOf(zzdf.zzc(zzcoVar.zzb)));
                    unsafe.putInt(obj, j2, i4);
                    return zzm3;
                }
                break;
            case 68:
                if (i5 == 3) {
                    Object zzE2 = zzE(obj, i4, i8);
                    int zzn = zzcp.zzn(zzE2, zzB(i8), bArr, i, i2, (i3 & (-8)) | 4, zzcoVar);
                    zzM(obj, i4, i8, zzE2);
                    return zzn;
                }
                break;
        }
        return i;
    }

    private final int zzs(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzco zzcoVar) throws IOException {
        int i8;
        int i9;
        int i10;
        int i11;
        int zzl;
        int i12 = i;
        Unsafe unsafe = zzb;
        zzel zzelVar = (zzel) unsafe.getObject(obj, j2);
        if (!zzelVar.zzc()) {
            int size = zzelVar.size();
            zzelVar = zzelVar.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j2, zzelVar);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zzdl zzdlVar = (zzdl) zzelVar;
                    int zzj = zzcp.zzj(bArr, i12, zzcoVar);
                    int i13 = zzcoVar.zza + zzj;
                    while (zzj < i13) {
                        zzdlVar.zze(Double.longBitsToDouble(zzcp.zzq(bArr, zzj)));
                        zzj += 8;
                    }
                    if (zzj == i13) {
                        return zzj;
                    }
                    throw zzeo.zzg();
                }
                if (i5 == 1) {
                    zzdl zzdlVar2 = (zzdl) zzelVar;
                    zzdlVar2.zze(Double.longBitsToDouble(zzcp.zzq(bArr, i)));
                    while (true) {
                        i8 = i12 + 8;
                        if (i8 < i2) {
                            i12 = zzcp.zzj(bArr, i8, zzcoVar);
                            if (i3 == zzcoVar.zza) {
                                zzdlVar2.zze(Double.longBitsToDouble(zzcp.zzq(bArr, i12)));
                            }
                        }
                    }
                    return i8;
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzdv zzdvVar = (zzdv) zzelVar;
                    int zzj2 = zzcp.zzj(bArr, i12, zzcoVar);
                    int i14 = zzcoVar.zza + zzj2;
                    while (zzj2 < i14) {
                        zzdvVar.zzg(Float.intBitsToFloat(zzcp.zzb(bArr, zzj2)));
                        zzj2 += 4;
                    }
                    if (zzj2 == i14) {
                        return zzj2;
                    }
                    throw zzeo.zzg();
                }
                if (i5 == 5) {
                    zzdv zzdvVar2 = (zzdv) zzelVar;
                    zzdvVar2.zzg(Float.intBitsToFloat(zzcp.zzb(bArr, i)));
                    while (true) {
                        i9 = i12 + 4;
                        if (i9 < i2) {
                            i12 = zzcp.zzj(bArr, i9, zzcoVar);
                            if (i3 == zzcoVar.zza) {
                                zzdvVar2.zzg(Float.intBitsToFloat(zzcp.zzb(bArr, i12)));
                            }
                        }
                    }
                    return i9;
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzfd zzfdVar = (zzfd) zzelVar;
                    int zzj3 = zzcp.zzj(bArr, i12, zzcoVar);
                    int i15 = zzcoVar.zza + zzj3;
                    while (zzj3 < i15) {
                        zzj3 = zzcp.zzm(bArr, zzj3, zzcoVar);
                        zzfdVar.zzf(zzcoVar.zzb);
                    }
                    if (zzj3 == i15) {
                        return zzj3;
                    }
                    throw zzeo.zzg();
                }
                if (i5 == 0) {
                    zzfd zzfdVar2 = (zzfd) zzelVar;
                    int zzm = zzcp.zzm(bArr, i12, zzcoVar);
                    zzfdVar2.zzf(zzcoVar.zzb);
                    while (zzm < i2) {
                        int zzj4 = zzcp.zzj(bArr, zzm, zzcoVar);
                        if (i3 != zzcoVar.zza) {
                            return zzm;
                        }
                        zzm = zzcp.zzm(bArr, zzj4, zzcoVar);
                        zzfdVar2.zzf(zzcoVar.zzb);
                    }
                    return zzm;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzcp.zzf(bArr, i12, zzelVar, zzcoVar);
                }
                if (i5 == 0) {
                    return zzcp.zzl(i3, bArr, i, i2, zzelVar, zzcoVar);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzfd zzfdVar3 = (zzfd) zzelVar;
                    int zzj5 = zzcp.zzj(bArr, i12, zzcoVar);
                    int i16 = zzcoVar.zza + zzj5;
                    while (zzj5 < i16) {
                        zzfdVar3.zzf(zzcp.zzq(bArr, zzj5));
                        zzj5 += 8;
                    }
                    if (zzj5 == i16) {
                        return zzj5;
                    }
                    throw zzeo.zzg();
                }
                if (i5 == 1) {
                    zzfd zzfdVar4 = (zzfd) zzelVar;
                    zzfdVar4.zzf(zzcp.zzq(bArr, i));
                    while (true) {
                        i10 = i12 + 8;
                        if (i10 < i2) {
                            i12 = zzcp.zzj(bArr, i10, zzcoVar);
                            if (i3 == zzcoVar.zza) {
                                zzfdVar4.zzf(zzcp.zzq(bArr, i12));
                            }
                        }
                    }
                    return i10;
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzee zzeeVar = (zzee) zzelVar;
                    int zzj6 = zzcp.zzj(bArr, i12, zzcoVar);
                    int i17 = zzcoVar.zza + zzj6;
                    while (zzj6 < i17) {
                        zzeeVar.zzg(zzcp.zzb(bArr, zzj6));
                        zzj6 += 4;
                    }
                    if (zzj6 == i17) {
                        return zzj6;
                    }
                    throw zzeo.zzg();
                }
                if (i5 == 5) {
                    zzee zzeeVar2 = (zzee) zzelVar;
                    zzeeVar2.zzg(zzcp.zzb(bArr, i));
                    while (true) {
                        i11 = i12 + 4;
                        if (i11 < i2) {
                            i12 = zzcp.zzj(bArr, i11, zzcoVar);
                            if (i3 == zzcoVar.zza) {
                                zzeeVar2.zzg(zzcp.zzb(bArr, i12));
                            }
                        }
                    }
                    return i11;
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzcq zzcqVar = (zzcq) zzelVar;
                    int zzj7 = zzcp.zzj(bArr, i12, zzcoVar);
                    int i18 = zzcoVar.zza + zzj7;
                    while (zzj7 < i18) {
                        zzj7 = zzcp.zzm(bArr, zzj7, zzcoVar);
                        zzcqVar.zze(zzcoVar.zzb != 0);
                    }
                    if (zzj7 == i18) {
                        return zzj7;
                    }
                    throw zzeo.zzg();
                }
                if (i5 == 0) {
                    zzcq zzcqVar2 = (zzcq) zzelVar;
                    int zzm2 = zzcp.zzm(bArr, i12, zzcoVar);
                    zzcqVar2.zze(zzcoVar.zzb != 0);
                    while (zzm2 < i2) {
                        int zzj8 = zzcp.zzj(bArr, zzm2, zzcoVar);
                        if (i3 != zzcoVar.zza) {
                            return zzm2;
                        }
                        zzm2 = zzcp.zzm(bArr, zzj8, zzcoVar);
                        zzcqVar2.zze(zzcoVar.zzb != 0);
                    }
                    return zzm2;
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) != 0) {
                        int zzj9 = zzcp.zzj(bArr, i12, zzcoVar);
                        int i19 = zzcoVar.zza;
                        if (i19 < 0) {
                            throw zzeo.zzd();
                        }
                        if (i19 == 0) {
                            zzelVar.add("");
                        } else {
                            int i20 = zzj9 + i19;
                            if (!zzhn.zzh(bArr, zzj9, i20)) {
                                throw zzeo.zzc();
                            }
                            zzelVar.add(new String(bArr, zzj9, i19, zzem.zzb));
                            zzj9 = i20;
                        }
                        while (zzj9 < i2) {
                            int zzj10 = zzcp.zzj(bArr, zzj9, zzcoVar);
                            if (i3 != zzcoVar.zza) {
                                return zzj9;
                            }
                            zzj9 = zzcp.zzj(bArr, zzj10, zzcoVar);
                            int i21 = zzcoVar.zza;
                            if (i21 < 0) {
                                throw zzeo.zzd();
                            }
                            if (i21 == 0) {
                                zzelVar.add("");
                            } else {
                                int i22 = zzj9 + i21;
                                if (zzhn.zzh(bArr, zzj9, i22)) {
                                    zzelVar.add(new String(bArr, zzj9, i21, zzem.zzb));
                                    zzj9 = i22;
                                } else {
                                    throw zzeo.zzc();
                                }
                            }
                        }
                        return zzj9;
                    }
                    int zzj11 = zzcp.zzj(bArr, i12, zzcoVar);
                    int i23 = zzcoVar.zza;
                    if (i23 < 0) {
                        throw zzeo.zzd();
                    }
                    if (i23 == 0) {
                        zzelVar.add("");
                    } else {
                        zzelVar.add(new String(bArr, zzj11, i23, zzem.zzb));
                        zzj11 += i23;
                    }
                    while (zzj11 < i2) {
                        int zzj12 = zzcp.zzj(bArr, zzj11, zzcoVar);
                        if (i3 != zzcoVar.zza) {
                            return zzj11;
                        }
                        zzj11 = zzcp.zzj(bArr, zzj12, zzcoVar);
                        int i24 = zzcoVar.zza;
                        if (i24 < 0) {
                            throw zzeo.zzd();
                        }
                        if (i24 == 0) {
                            zzelVar.add("");
                        } else {
                            zzelVar.add(new String(bArr, zzj11, i24, zzem.zzb));
                            zzj11 += i24;
                        }
                    }
                    return zzj11;
                }
                break;
            case 27:
                if (i5 == 2) {
                    return zzcp.zze(zzB(i6), i3, bArr, i, i2, zzelVar, zzcoVar);
                }
                break;
            case 28:
                if (i5 == 2) {
                    int zzj13 = zzcp.zzj(bArr, i12, zzcoVar);
                    int i25 = zzcoVar.zza;
                    if (i25 >= 0) {
                        if (i25 > bArr.length - zzj13) {
                            throw zzeo.zzg();
                        }
                        if (i25 == 0) {
                            zzelVar.add(zzdb.zzb);
                        } else {
                            zzelVar.add(zzdb.zzr(bArr, zzj13, i25));
                            zzj13 += i25;
                        }
                        while (zzj13 < i2) {
                            int zzj14 = zzcp.zzj(bArr, zzj13, zzcoVar);
                            if (i3 != zzcoVar.zza) {
                                return zzj13;
                            }
                            zzj13 = zzcp.zzj(bArr, zzj14, zzcoVar);
                            int i26 = zzcoVar.zza;
                            if (i26 >= 0) {
                                if (i26 > bArr.length - zzj13) {
                                    throw zzeo.zzg();
                                }
                                if (i26 == 0) {
                                    zzelVar.add(zzdb.zzb);
                                } else {
                                    zzelVar.add(zzdb.zzr(bArr, zzj13, i26));
                                    zzj13 += i26;
                                }
                            } else {
                                throw zzeo.zzd();
                            }
                        }
                        return zzj13;
                    }
                    throw zzeo.zzd();
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    zzl = zzcp.zzf(bArr, i12, zzelVar, zzcoVar);
                } else if (i5 == 0) {
                    zzl = zzcp.zzl(i3, bArr, i, i2, zzelVar, zzcoVar);
                }
                zzeh zzA = zzA(i6);
                zzgy zzgyVar = this.zzm;
                int i27 = zzgj.zza;
                if (zzA != null) {
                    Object obj2 = null;
                    if (zzelVar instanceof RandomAccess) {
                        int size2 = zzelVar.size();
                        int i28 = 0;
                        for (int i29 = 0; i29 < size2; i29++) {
                            int intValue = ((Integer) zzelVar.get(i29)).intValue();
                            if (zzA.zza(intValue)) {
                                if (i29 != i28) {
                                    zzelVar.set(i28, Integer.valueOf(intValue));
                                }
                                i28++;
                            } else {
                                obj2 = zzgj.zzA(obj, i4, intValue, obj2, zzgyVar);
                            }
                        }
                        if (i28 != size2) {
                            zzelVar.subList(i28, size2).clear();
                            return zzl;
                        }
                    } else {
                        Iterator it = zzelVar.iterator();
                        while (it.hasNext()) {
                            int intValue2 = ((Integer) it.next()).intValue();
                            if (!zzA.zza(intValue2)) {
                                obj2 = zzgj.zzA(obj, i4, intValue2, obj2, zzgyVar);
                                it.remove();
                            }
                        }
                    }
                }
                return zzl;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzee zzeeVar3 = (zzee) zzelVar;
                    int zzj15 = zzcp.zzj(bArr, i12, zzcoVar);
                    int i30 = zzcoVar.zza + zzj15;
                    while (zzj15 < i30) {
                        zzj15 = zzcp.zzj(bArr, zzj15, zzcoVar);
                        zzeeVar3.zzg(zzdf.zzb(zzcoVar.zza));
                    }
                    if (zzj15 == i30) {
                        return zzj15;
                    }
                    throw zzeo.zzg();
                }
                if (i5 == 0) {
                    zzee zzeeVar4 = (zzee) zzelVar;
                    int zzj16 = zzcp.zzj(bArr, i12, zzcoVar);
                    zzeeVar4.zzg(zzdf.zzb(zzcoVar.zza));
                    while (zzj16 < i2) {
                        int zzj17 = zzcp.zzj(bArr, zzj16, zzcoVar);
                        if (i3 != zzcoVar.zza) {
                            return zzj16;
                        }
                        zzj16 = zzcp.zzj(bArr, zzj17, zzcoVar);
                        zzeeVar4.zzg(zzdf.zzb(zzcoVar.zza));
                    }
                    return zzj16;
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzfd zzfdVar5 = (zzfd) zzelVar;
                    int zzj18 = zzcp.zzj(bArr, i12, zzcoVar);
                    int i31 = zzcoVar.zza + zzj18;
                    while (zzj18 < i31) {
                        zzj18 = zzcp.zzm(bArr, zzj18, zzcoVar);
                        zzfdVar5.zzf(zzdf.zzc(zzcoVar.zzb));
                    }
                    if (zzj18 == i31) {
                        return zzj18;
                    }
                    throw zzeo.zzg();
                }
                if (i5 == 0) {
                    zzfd zzfdVar6 = (zzfd) zzelVar;
                    int zzm3 = zzcp.zzm(bArr, i12, zzcoVar);
                    zzfdVar6.zzf(zzdf.zzc(zzcoVar.zzb));
                    while (zzm3 < i2) {
                        int zzj19 = zzcp.zzj(bArr, zzm3, zzcoVar);
                        if (i3 != zzcoVar.zza) {
                            return zzm3;
                        }
                        zzm3 = zzcp.zzm(bArr, zzj19, zzcoVar);
                        zzfdVar6.zzf(zzdf.zzc(zzcoVar.zzb));
                    }
                    return zzm3;
                }
                break;
            default:
                if (i5 == 3) {
                    zzgh zzB = zzB(i6);
                    int i32 = (i3 & (-8)) | 4;
                    int zzc = zzcp.zzc(zzB, bArr, i, i2, i32, zzcoVar);
                    zzelVar.add(zzcoVar.zzc);
                    while (zzc < i2) {
                        int zzj20 = zzcp.zzj(bArr, zzc, zzcoVar);
                        if (i3 != zzcoVar.zza) {
                            return zzc;
                        }
                        zzc = zzcp.zzc(zzB, bArr, zzj20, i2, i32, zzcoVar);
                        zzelVar.add(zzcoVar.zzc);
                    }
                    return zzc;
                }
                break;
        }
        return i12;
    }

    private final int zzt(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzw(i, 0);
    }

    private final int zzu(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzw(i, i2);
    }

    private final int zzv(int i) {
        return this.zzc[i + 2];
    }

    private final int zzw(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzx(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzy(int i) {
        return this.zzc[i + 1];
    }

    private static long zzz(Object obj, long j) {
        return ((Long) zzhi.zzf(obj, j)).longValue();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x003b. Please report as an issue. */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final int zza(Object obj) {
        int zzy;
        int zzy2;
        int zzz;
        int zzy3;
        int zzy4;
        int zzy5;
        int zzy6;
        int zzn;
        int zzy7;
        int zzz2;
        int zzy8;
        int zzy9;
        zzho zzhoVar = zzho.DOUBLE;
        if (this.zzo - 1 != 0) {
            Unsafe unsafe = zzb;
            int i = 0;
            for (int i2 = 0; i2 < this.zzc.length; i2 += 3) {
                int zzy10 = zzy(i2);
                int zzx = zzx(zzy10);
                int i3 = this.zzc[i2];
                int i4 = zzy10 & 1048575;
                if (zzx >= zzdu.DOUBLE_LIST_PACKED.zza() && zzx <= zzdu.SINT64_LIST_PACKED.zza()) {
                    int i5 = this.zzc[i2 + 2];
                }
                long j = i4;
                switch (zzx) {
                    case 0:
                        if (zzP(obj, i2)) {
                            zzy = zzdj.zzy(i3 << 3);
                            zzn = zzy + 8;
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzP(obj, i2)) {
                            zzy2 = zzdj.zzy(i3 << 3);
                            zzn = zzy2 + 4;
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zzP(obj, i2)) {
                            zzz = zzdj.zzz(zzhi.zzd(obj, j));
                            zzy3 = zzdj.zzy(i3 << 3);
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zzP(obj, i2)) {
                            zzz = zzdj.zzz(zzhi.zzd(obj, j));
                            zzy3 = zzdj.zzy(i3 << 3);
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zzP(obj, i2)) {
                            zzz = zzdj.zzu(zzhi.zzc(obj, j));
                            zzy3 = zzdj.zzy(i3 << 3);
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zzP(obj, i2)) {
                            zzy = zzdj.zzy(i3 << 3);
                            zzn = zzy + 8;
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zzP(obj, i2)) {
                            zzy2 = zzdj.zzy(i3 << 3);
                            zzn = zzy2 + 4;
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zzP(obj, i2)) {
                            zzy4 = zzdj.zzy(i3 << 3);
                            zzn = zzy4 + 1;
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zzP(obj, i2)) {
                            Object zzf = zzhi.zzf(obj, j);
                            if (zzf instanceof zzdb) {
                                int i6 = i3 << 3;
                                int i7 = zzdj.zzb;
                                int zzd = ((zzdb) zzf).zzd();
                                zzy5 = zzdj.zzy(zzd) + zzd;
                                zzy6 = zzdj.zzy(i6);
                                zzn = zzy6 + zzy5;
                                i += zzn;
                                break;
                            } else {
                                zzz = zzdj.zzx((String) zzf);
                                zzy3 = zzdj.zzy(i3 << 3);
                                i += zzy3 + zzz;
                                break;
                            }
                        } else {
                            break;
                        }
                    case 9:
                        if (zzP(obj, i2)) {
                            zzn = zzgj.zzn(i3, zzhi.zzf(obj, j), zzB(i2));
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zzP(obj, i2)) {
                            zzdb zzdbVar = (zzdb) zzhi.zzf(obj, j);
                            int i8 = i3 << 3;
                            int i9 = zzdj.zzb;
                            int zzd2 = zzdbVar.zzd();
                            zzy5 = zzdj.zzy(zzd2) + zzd2;
                            zzy6 = zzdj.zzy(i8);
                            zzn = zzy6 + zzy5;
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zzP(obj, i2)) {
                            zzz = zzdj.zzy(zzhi.zzc(obj, j));
                            zzy3 = zzdj.zzy(i3 << 3);
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zzP(obj, i2)) {
                            zzz = zzdj.zzu(zzhi.zzc(obj, j));
                            zzy3 = zzdj.zzy(i3 << 3);
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zzP(obj, i2)) {
                            zzy2 = zzdj.zzy(i3 << 3);
                            zzn = zzy2 + 4;
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zzP(obj, i2)) {
                            zzy = zzdj.zzy(i3 << 3);
                            zzn = zzy + 8;
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zzP(obj, i2)) {
                            int zzc = zzhi.zzc(obj, j);
                            zzy3 = zzdj.zzy(i3 << 3);
                            zzz = zzdj.zzy((zzc >> 31) ^ (zzc + zzc));
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zzP(obj, i2)) {
                            long zzd3 = zzhi.zzd(obj, j);
                            zzy7 = zzdj.zzy(i3 << 3);
                            zzz2 = zzdj.zzz((zzd3 + zzd3) ^ (zzd3 >> 63));
                            zzn = zzy7 + zzz2;
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zzP(obj, i2)) {
                            zzn = zzdj.zzt(i3, (zzfo) zzhi.zzf(obj, j), zzB(i2));
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzn = zzgj.zzg(i3, (List) zzhi.zzf(obj, j), false);
                        i += zzn;
                        break;
                    case 19:
                        zzn = zzgj.zze(i3, (List) zzhi.zzf(obj, j), false);
                        i += zzn;
                        break;
                    case 20:
                        zzn = zzgj.zzl(i3, (List) zzhi.zzf(obj, j), false);
                        i += zzn;
                        break;
                    case 21:
                        zzn = zzgj.zzw(i3, (List) zzhi.zzf(obj, j), false);
                        i += zzn;
                        break;
                    case 22:
                        zzn = zzgj.zzj(i3, (List) zzhi.zzf(obj, j), false);
                        i += zzn;
                        break;
                    case 23:
                        zzn = zzgj.zzg(i3, (List) zzhi.zzf(obj, j), false);
                        i += zzn;
                        break;
                    case 24:
                        zzn = zzgj.zze(i3, (List) zzhi.zzf(obj, j), false);
                        i += zzn;
                        break;
                    case 25:
                        zzn = zzgj.zza(i3, (List) zzhi.zzf(obj, j), false);
                        i += zzn;
                        break;
                    case 26:
                        zzn = zzgj.zzt(i3, (List) zzhi.zzf(obj, j));
                        i += zzn;
                        break;
                    case 27:
                        zzn = zzgj.zzo(i3, (List) zzhi.zzf(obj, j), zzB(i2));
                        i += zzn;
                        break;
                    case 28:
                        zzn = zzgj.zzb(i3, (List) zzhi.zzf(obj, j));
                        i += zzn;
                        break;
                    case 29:
                        zzn = zzgj.zzu(i3, (List) zzhi.zzf(obj, j), false);
                        i += zzn;
                        break;
                    case 30:
                        zzn = zzgj.zzc(i3, (List) zzhi.zzf(obj, j), false);
                        i += zzn;
                        break;
                    case 31:
                        zzn = zzgj.zze(i3, (List) zzhi.zzf(obj, j), false);
                        i += zzn;
                        break;
                    case 32:
                        zzn = zzgj.zzg(i3, (List) zzhi.zzf(obj, j), false);
                        i += zzn;
                        break;
                    case 33:
                        zzn = zzgj.zzp(i3, (List) zzhi.zzf(obj, j), false);
                        i += zzn;
                        break;
                    case 34:
                        zzn = zzgj.zzr(i3, (List) zzhi.zzf(obj, j), false);
                        i += zzn;
                        break;
                    case 35:
                        zzz = zzgj.zzh((List) unsafe.getObject(obj, j));
                        if (zzz > 0) {
                            int i10 = i3 << 3;
                            zzy8 = zzdj.zzy(zzz);
                            zzy9 = zzdj.zzy(i10);
                            zzy3 = zzy9 + zzy8;
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        zzz = zzgj.zzf((List) unsafe.getObject(obj, j));
                        if (zzz > 0) {
                            int i11 = i3 << 3;
                            zzy8 = zzdj.zzy(zzz);
                            zzy9 = zzdj.zzy(i11);
                            zzy3 = zzy9 + zzy8;
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        zzz = zzgj.zzm((List) unsafe.getObject(obj, j));
                        if (zzz > 0) {
                            int i12 = i3 << 3;
                            zzy8 = zzdj.zzy(zzz);
                            zzy9 = zzdj.zzy(i12);
                            zzy3 = zzy9 + zzy8;
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        zzz = zzgj.zzx((List) unsafe.getObject(obj, j));
                        if (zzz > 0) {
                            int i13 = i3 << 3;
                            zzy8 = zzdj.zzy(zzz);
                            zzy9 = zzdj.zzy(i13);
                            zzy3 = zzy9 + zzy8;
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        zzz = zzgj.zzk((List) unsafe.getObject(obj, j));
                        if (zzz > 0) {
                            int i14 = i3 << 3;
                            zzy8 = zzdj.zzy(zzz);
                            zzy9 = zzdj.zzy(i14);
                            zzy3 = zzy9 + zzy8;
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        zzz = zzgj.zzh((List) unsafe.getObject(obj, j));
                        if (zzz > 0) {
                            int i15 = i3 << 3;
                            zzy8 = zzdj.zzy(zzz);
                            zzy9 = zzdj.zzy(i15);
                            zzy3 = zzy9 + zzy8;
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        zzz = zzgj.zzf((List) unsafe.getObject(obj, j));
                        if (zzz > 0) {
                            int i16 = i3 << 3;
                            zzy8 = zzdj.zzy(zzz);
                            zzy9 = zzdj.zzy(i16);
                            zzy3 = zzy9 + zzy8;
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        List list = (List) unsafe.getObject(obj, j);
                        int i17 = zzgj.zza;
                        zzz = list.size();
                        if (zzz > 0) {
                            int i18 = i3 << 3;
                            zzy8 = zzdj.zzy(zzz);
                            zzy9 = zzdj.zzy(i18);
                            zzy3 = zzy9 + zzy8;
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        zzz = zzgj.zzv((List) unsafe.getObject(obj, j));
                        if (zzz > 0) {
                            int i19 = i3 << 3;
                            zzy8 = zzdj.zzy(zzz);
                            zzy9 = zzdj.zzy(i19);
                            zzy3 = zzy9 + zzy8;
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        zzz = zzgj.zzd((List) unsafe.getObject(obj, j));
                        if (zzz > 0) {
                            int i20 = i3 << 3;
                            zzy8 = zzdj.zzy(zzz);
                            zzy9 = zzdj.zzy(i20);
                            zzy3 = zzy9 + zzy8;
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        zzz = zzgj.zzf((List) unsafe.getObject(obj, j));
                        if (zzz > 0) {
                            int i21 = i3 << 3;
                            zzy8 = zzdj.zzy(zzz);
                            zzy9 = zzdj.zzy(i21);
                            zzy3 = zzy9 + zzy8;
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        zzz = zzgj.zzh((List) unsafe.getObject(obj, j));
                        if (zzz > 0) {
                            int i22 = i3 << 3;
                            zzy8 = zzdj.zzy(zzz);
                            zzy9 = zzdj.zzy(i22);
                            zzy3 = zzy9 + zzy8;
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        zzz = zzgj.zzq((List) unsafe.getObject(obj, j));
                        if (zzz > 0) {
                            int i23 = i3 << 3;
                            zzy8 = zzdj.zzy(zzz);
                            zzy9 = zzdj.zzy(i23);
                            zzy3 = zzy9 + zzy8;
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        zzz = zzgj.zzs((List) unsafe.getObject(obj, j));
                        if (zzz > 0) {
                            int i24 = i3 << 3;
                            zzy8 = zzdj.zzy(zzz);
                            zzy9 = zzdj.zzy(i24);
                            zzy3 = zzy9 + zzy8;
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                        zzn = zzgj.zzi(i3, (List) zzhi.zzf(obj, j), zzB(i2));
                        i += zzn;
                        break;
                    case 50:
                        zzfj.zza(i3, zzhi.zzf(obj, j), zzC(i2));
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        if (zzT(obj, i3, i2)) {
                            zzy = zzdj.zzy(i3 << 3);
                            zzn = zzy + 8;
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zzT(obj, i3, i2)) {
                            zzy2 = zzdj.zzy(i3 << 3);
                            zzn = zzy2 + 4;
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zzT(obj, i3, i2)) {
                            zzz = zzdj.zzz(zzz(obj, j));
                            zzy3 = zzdj.zzy(i3 << 3);
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case Elf64_Ehdr.e_phentsize /* 54 */:
                        if (zzT(obj, i3, i2)) {
                            zzz = zzdj.zzz(zzz(obj, j));
                            zzy3 = zzdj.zzy(i3 << 3);
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zzT(obj, i3, i2)) {
                            zzz = zzdj.zzu(zzp(obj, j));
                            zzy3 = zzdj.zzy(i3 << 3);
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zzT(obj, i3, i2)) {
                            zzy = zzdj.zzy(i3 << 3);
                            zzn = zzy + 8;
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zzT(obj, i3, i2)) {
                            zzy2 = zzdj.zzy(i3 << 3);
                            zzn = zzy2 + 4;
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case Elf64_Ehdr.e_shentsize /* 58 */:
                        if (zzT(obj, i3, i2)) {
                            zzy4 = zzdj.zzy(i3 << 3);
                            zzn = zzy4 + 1;
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zzT(obj, i3, i2)) {
                            Object zzf2 = zzhi.zzf(obj, j);
                            if (zzf2 instanceof zzdb) {
                                int i25 = i3 << 3;
                                int i26 = zzdj.zzb;
                                int zzd4 = ((zzdb) zzf2).zzd();
                                zzy5 = zzdj.zzy(zzd4) + zzd4;
                                zzy6 = zzdj.zzy(i25);
                                zzn = zzy6 + zzy5;
                                i += zzn;
                                break;
                            } else {
                                zzz = zzdj.zzx((String) zzf2);
                                zzy3 = zzdj.zzy(i3 << 3);
                                i += zzy3 + zzz;
                                break;
                            }
                        } else {
                            break;
                        }
                    case 60:
                        if (zzT(obj, i3, i2)) {
                            zzn = zzgj.zzn(i3, zzhi.zzf(obj, j), zzB(i2));
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                        if (zzT(obj, i3, i2)) {
                            zzdb zzdbVar2 = (zzdb) zzhi.zzf(obj, j);
                            int i27 = i3 << 3;
                            int i28 = zzdj.zzb;
                            int zzd5 = zzdbVar2.zzd();
                            zzy5 = zzdj.zzy(zzd5) + zzd5;
                            zzy6 = zzdj.zzy(i27);
                            zzn = zzy6 + zzy5;
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case Elf64_Ehdr.e_shstrndx /* 62 */:
                        if (zzT(obj, i3, i2)) {
                            zzz = zzdj.zzy(zzp(obj, j));
                            zzy3 = zzdj.zzy(i3 << 3);
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                        if (zzT(obj, i3, i2)) {
                            zzz = zzdj.zzu(zzp(obj, j));
                            zzy3 = zzdj.zzy(i3 << 3);
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zzT(obj, i3, i2)) {
                            zzy2 = zzdj.zzy(i3 << 3);
                            zzn = zzy2 + 4;
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                        if (zzT(obj, i3, i2)) {
                            zzy = zzdj.zzy(i3 << 3);
                            zzn = zzy + 8;
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zzT(obj, i3, i2)) {
                            int zzp = zzp(obj, j);
                            zzy3 = zzdj.zzy(i3 << 3);
                            zzz = zzdj.zzy((zzp >> 31) ^ (zzp + zzp));
                            i += zzy3 + zzz;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zzT(obj, i3, i2)) {
                            long zzz3 = zzz(obj, j);
                            zzy7 = zzdj.zzy(i3 << 3);
                            zzz2 = zzdj.zzz((zzz3 + zzz3) ^ (zzz3 >> 63));
                            zzn = zzy7 + zzz2;
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zzT(obj, i3, i2)) {
                            zzn = zzdj.zzt(i3, (zzfo) zzhi.zzf(obj, j), zzB(i2));
                            i += zzn;
                            break;
                        } else {
                            break;
                        }
                }
            }
            zzgy zzgyVar = this.zzm;
            return i + zzgyVar.zza(zzgyVar.zzd(obj));
        }
        return zzo(obj);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001c. Please report as an issue. */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final int zzb(Object obj) {
        int i;
        long doubleToLongBits;
        int floatToIntBits;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int zzy = zzy(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & zzy;
            int i5 = 37;
            switch (zzx(zzy)) {
                case 0:
                    i = i2 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zzhi.zza(obj, j));
                    byte[] bArr = zzem.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i2 = i + floatToIntBits;
                    break;
                case 1:
                    i = i2 * 53;
                    floatToIntBits = Float.floatToIntBits(zzhi.zzb(obj, j));
                    i2 = i + floatToIntBits;
                    break;
                case 2:
                    i = i2 * 53;
                    doubleToLongBits = zzhi.zzd(obj, j);
                    byte[] bArr2 = zzem.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i2 = i + floatToIntBits;
                    break;
                case 3:
                    i = i2 * 53;
                    doubleToLongBits = zzhi.zzd(obj, j);
                    byte[] bArr3 = zzem.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i2 = i + floatToIntBits;
                    break;
                case 4:
                    i = i2 * 53;
                    floatToIntBits = zzhi.zzc(obj, j);
                    i2 = i + floatToIntBits;
                    break;
                case 5:
                    i = i2 * 53;
                    doubleToLongBits = zzhi.zzd(obj, j);
                    byte[] bArr4 = zzem.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i2 = i + floatToIntBits;
                    break;
                case 6:
                    i = i2 * 53;
                    floatToIntBits = zzhi.zzc(obj, j);
                    i2 = i + floatToIntBits;
                    break;
                case 7:
                    i = i2 * 53;
                    floatToIntBits = zzem.zza(zzhi.zzw(obj, j));
                    i2 = i + floatToIntBits;
                    break;
                case 8:
                    i = i2 * 53;
                    floatToIntBits = ((String) zzhi.zzf(obj, j)).hashCode();
                    i2 = i + floatToIntBits;
                    break;
                case 9:
                    Object zzf = zzhi.zzf(obj, j);
                    if (zzf != null) {
                        i5 = zzf.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
                    break;
                case 10:
                    i = i2 * 53;
                    floatToIntBits = zzhi.zzf(obj, j).hashCode();
                    i2 = i + floatToIntBits;
                    break;
                case 11:
                    i = i2 * 53;
                    floatToIntBits = zzhi.zzc(obj, j);
                    i2 = i + floatToIntBits;
                    break;
                case 12:
                    i = i2 * 53;
                    floatToIntBits = zzhi.zzc(obj, j);
                    i2 = i + floatToIntBits;
                    break;
                case 13:
                    i = i2 * 53;
                    floatToIntBits = zzhi.zzc(obj, j);
                    i2 = i + floatToIntBits;
                    break;
                case 14:
                    i = i2 * 53;
                    doubleToLongBits = zzhi.zzd(obj, j);
                    byte[] bArr5 = zzem.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i2 = i + floatToIntBits;
                    break;
                case 15:
                    i = i2 * 53;
                    floatToIntBits = zzhi.zzc(obj, j);
                    i2 = i + floatToIntBits;
                    break;
                case 16:
                    i = i2 * 53;
                    doubleToLongBits = zzhi.zzd(obj, j);
                    byte[] bArr6 = zzem.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i2 = i + floatToIntBits;
                    break;
                case 17:
                    Object zzf2 = zzhi.zzf(obj, j);
                    if (zzf2 != null) {
                        i5 = zzf2.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    i = i2 * 53;
                    floatToIntBits = zzhi.zzf(obj, j).hashCode();
                    i2 = i + floatToIntBits;
                    break;
                case 50:
                    i = i2 * 53;
                    floatToIntBits = zzhi.zzf(obj, j).hashCode();
                    i2 = i + floatToIntBits;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzem.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        doubleToLongBits = zzz(obj, j);
                        byte[] bArr8 = zzem.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case Elf64_Ehdr.e_phentsize /* 54 */:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        doubleToLongBits = zzz(obj, j);
                        byte[] bArr9 = zzem.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = zzp(obj, j);
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        doubleToLongBits = zzz(obj, j);
                        byte[] bArr10 = zzem.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = zzp(obj, j);
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case Elf64_Ehdr.e_shentsize /* 58 */:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = zzem.zza(zzU(obj, j));
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = ((String) zzhi.zzf(obj, j)).hashCode();
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = zzhi.zzf(obj, j).hashCode();
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = zzhi.zzf(obj, j).hashCode();
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case Elf64_Ehdr.e_shstrndx /* 62 */:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = zzp(obj, j);
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = zzp(obj, j);
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = zzp(obj, j);
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        doubleToLongBits = zzz(obj, j);
                        byte[] bArr11 = zzem.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = zzp(obj, j);
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        doubleToLongBits = zzz(obj, j);
                        byte[] bArr12 = zzem.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = zzhi.zzf(obj, j).hashCode();
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i2 * 53) + this.zzm.zzd(obj).hashCode();
        return this.zzh ? (hashCode * 53) + this.zzn.zzb(obj).zza.hashCode() : hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0551, code lost:
    
        if (r6 == r1) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0553, code lost:
    
        r32.putInt(r12, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0559, code lost:
    
        r2 = r9.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x055d, code lost:
    
        if (r2 >= r9.zzk) goto L270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x055f, code lost:
    
        r4 = r9.zzi[r2];
        r5 = r9.zzc[r4];
        r5 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhi.zzf(r12, r9.zzy(r4) & r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0571, code lost:
    
        if (r5 != null) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0578, code lost:
    
        if (r9.zzA(r4) != null) goto L269;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x057d, code lost:
    
        r5 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfi) r5;
        r0 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfh) r9.zzC(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0585, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x057a, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0586, code lost:
    
        if (r7 != 0) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x058a, code lost:
    
        if (r0 != r38) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0591, code lost:
    
        throw com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0598, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0594, code lost:
    
        if (r0 > r38) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0596, code lost:
    
        if (r3 != r7) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x059d, code lost:
    
        throw com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo.zze();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:143:0x00a0. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:72:0x03f6. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzc(java.lang.Object r35, byte[] r36, int r37, int r38, int r39, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzco r40) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfr.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzco):int");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final Object zze() {
        return ((zzed) this.zzg).zzJ();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final void zzf(Object obj) {
        if (zzS(obj)) {
            if (obj instanceof zzed) {
                zzed zzedVar = (zzed) obj;
                zzedVar.zzV(Integer.MAX_VALUE);
                zzedVar.zzb = 0;
                zzedVar.zzT();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzy = zzy(i);
                int i2 = 1048575 & zzy;
                int zzx = zzx(zzy);
                long j = i2;
                if (zzx != 9) {
                    if (zzx == 60 || zzx == 68) {
                        if (zzT(obj, this.zzc[i], i)) {
                            zzB(i).zzf(zzb.getObject(obj, j));
                        }
                    } else {
                        switch (zzx) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                this.zzl.zza(obj, j);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzfi) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                }
                if (zzP(obj, i)) {
                    zzB(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzm.zzg(obj);
            if (this.zzh) {
                this.zzn.zze(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final void zzg(Object obj, Object obj2) {
        zzG(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzy = zzy(i);
            int i2 = this.zzc[i];
            long j = 1048575 & zzy;
            switch (zzx(zzy)) {
                case 0:
                    if (zzP(obj2, i)) {
                        zzhi.zzo(obj, j, zzhi.zza(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzP(obj2, i)) {
                        zzhi.zzp(obj, j, zzhi.zzb(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzP(obj2, i)) {
                        zzhi.zzr(obj, j, zzhi.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzP(obj2, i)) {
                        zzhi.zzr(obj, j, zzhi.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzP(obj2, i)) {
                        zzhi.zzq(obj, j, zzhi.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzP(obj2, i)) {
                        zzhi.zzr(obj, j, zzhi.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzP(obj2, i)) {
                        zzhi.zzq(obj, j, zzhi.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzP(obj2, i)) {
                        zzhi.zzm(obj, j, zzhi.zzw(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzP(obj2, i)) {
                        zzhi.zzs(obj, j, zzhi.zzf(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzH(obj, obj2, i);
                    break;
                case 10:
                    if (zzP(obj2, i)) {
                        zzhi.zzs(obj, j, zzhi.zzf(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzP(obj2, i)) {
                        zzhi.zzq(obj, j, zzhi.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzP(obj2, i)) {
                        zzhi.zzq(obj, j, zzhi.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzP(obj2, i)) {
                        zzhi.zzq(obj, j, zzhi.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzP(obj2, i)) {
                        zzhi.zzr(obj, j, zzhi.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzP(obj2, i)) {
                        zzhi.zzq(obj, j, zzhi.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzP(obj2, i)) {
                        zzhi.zzr(obj, j, zzhi.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzH(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    this.zzl.zzb(obj, obj2, j);
                    break;
                case 50:
                    int i3 = zzgj.zza;
                    zzhi.zzs(obj, j, zzfj.zzb(zzhi.zzf(obj, j), zzhi.zzf(obj2, j)));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                case 52:
                case 53:
                case Elf64_Ehdr.e_phentsize /* 54 */:
                case 55:
                case 56:
                case 57:
                case Elf64_Ehdr.e_shentsize /* 58 */:
                case 59:
                    if (zzT(obj2, i2, i)) {
                        zzhi.zzs(obj, j, zzhi.zzf(obj2, j));
                        zzK(obj, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzI(obj, obj2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case Elf64_Ehdr.e_shstrndx /* 62 */:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                case 66:
                case 67:
                    if (zzT(obj2, i2, i)) {
                        zzhi.zzs(obj, j, zzhi.zzf(obj2, j));
                        zzK(obj, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzI(obj, obj2, i);
                    break;
            }
        }
        zzgj.zzC(this.zzm, obj, obj2);
        if (this.zzh) {
            zzgj.zzB(this.zzn, obj, obj2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0294, code lost:
    
        if (r0 != r5) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0296, code lost:
    
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r9 = r18;
        r1 = r19;
        r2 = r22;
        r6 = r25;
        r7 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x02ac, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x02d9, code lost:
    
        if (r0 != r15) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x02fd, code lost:
    
        if (r0 != r15) goto L97;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:62:0x008d. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh(java.lang.Object r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzco r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 892
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfr.zzh(java.lang.Object, byte[], int, int, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzco):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:319:0x059d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:509:0x09e9  */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzi(java.lang.Object r18, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2852
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfr.zzi(java.lang.Object, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01c3 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzj(java.lang.Object r9, java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfr.zzj(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i4 < this.zzj) {
            int i6 = this.zzi[i4];
            int i7 = this.zzc[i6];
            int zzy = zzy(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i5) {
                if (i9 != 1048575) {
                    i3 = zzb.getInt(obj, i9);
                }
                i2 = i3;
                i = i9;
            } else {
                i = i5;
                i2 = i3;
            }
            if ((268435456 & zzy) != 0 && !zzQ(obj, i6, i, i2, i10)) {
                return false;
            }
            int zzx = zzx(zzy);
            if (zzx != 9 && zzx != 17) {
                if (zzx != 27) {
                    if (zzx == 60 || zzx == 68) {
                        if (zzT(obj, i7, i6) && !zzR(obj, zzy, zzB(i6))) {
                            return false;
                        }
                    } else if (zzx != 49) {
                        if (zzx == 50 && !((zzfi) zzhi.zzf(obj, zzy & 1048575)).isEmpty()) {
                            throw null;
                        }
                    }
                }
                List list = (List) zzhi.zzf(obj, zzy & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgh zzB = zzB(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzB.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                }
            } else if (zzQ(obj, i6, i, i2, i10) && !zzR(obj, zzy, zzB(i6))) {
                return false;
            }
            i4++;
            i5 = i;
            i3 = i2;
        }
        return !this.zzh || this.zzn.zzb(obj).zzk();
    }
}
