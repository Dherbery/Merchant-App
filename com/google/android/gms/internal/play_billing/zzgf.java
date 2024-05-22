package com.google.android.gms.internal.play_billing;

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
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
public final class zzgf<T> implements zzgm<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhn.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgc zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzfq zzl;
    private final zzhd zzm;
    private final zzek zzn;
    private final zzgh zzo;
    private final zzfx zzp;

    private zzgf(int[] iArr, Object[] objArr, int i, int i2, zzgc zzgcVar, int i3, boolean z, int[] iArr2, int i4, int i5, zzgh zzghVar, zzfq zzfqVar, zzhd zzhdVar, zzek zzekVar, zzfx zzfxVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzekVar != null && zzekVar.zzc(zzgcVar)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i4;
        this.zzk = i5;
        this.zzo = zzghVar;
        this.zzl = zzfqVar;
        this.zzm = zzhdVar;
        this.zzn = zzekVar;
        this.zzg = zzgcVar;
        this.zzp = zzfxVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int zzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgm zzv = zzv(i);
            if (!zzI(obj, i)) {
                if (!zzL(object)) {
                    unsafe.putObject(obj, j, object);
                } else {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, j, zze);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzM(obj2, i2, i)) {
            int zzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgm zzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (!zzL(object)) {
                    unsafe.putObject(obj, j, object);
                } else {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, j, zze);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int zzp = zzp(i);
        long j = 1048575 & zzp;
        if (j == 1048575) {
            return;
        }
        zzhn.zzq(obj, j, (1 << (zzp >>> 20)) | zzhn.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzhn.zzq(obj, zzp(i2) & 1048575, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int zzp = zzp(i);
        long j = zzp & 1048575;
        if (j != 1048575) {
            return (zzhn.zzc(obj, j) & (1 << (zzp >>> 20))) != 0;
        }
        int zzs = zzs(i);
        long j2 = zzs & 1048575;
        switch (zzr(zzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzhn.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhn.zzb(obj, j2)) != 0;
            case 2:
                return zzhn.zzd(obj, j2) != 0;
            case 3:
                return zzhn.zzd(obj, j2) != 0;
            case 4:
                return zzhn.zzc(obj, j2) != 0;
            case 5:
                return zzhn.zzd(obj, j2) != 0;
            case 6:
                return zzhn.zzc(obj, j2) != 0;
            case 7:
                return zzhn.zzw(obj, j2);
            case 8:
                Object zzf = zzhn.zzf(obj, j2);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                }
                if (zzf instanceof zzdw) {
                    return !zzdw.zzb.equals(zzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhn.zzf(obj, j2) != null;
            case 10:
                return !zzdw.zzb.equals(zzhn.zzf(obj, j2));
            case 11:
                return zzhn.zzc(obj, j2) != 0;
            case 12:
                return zzhn.zzc(obj, j2) != 0;
            case 13:
                return zzhn.zzc(obj, j2) != 0;
            case 14:
                return zzhn.zzd(obj, j2) != 0;
            case 15:
                return zzhn.zzc(obj, j2) != 0;
            case 16:
                return zzhn.zzd(obj, j2) != 0;
            case 17:
                return zzhn.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzI(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzgm zzgmVar) {
        return zzgmVar.zzk(zzhn.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzex) {
            return ((zzex) obj).zzt();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzhn.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzhn.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzhv zzhvVar) throws IOException {
        if (obj instanceof String) {
            zzhvVar.zzF(i, (String) obj);
        } else {
            zzhvVar.zzd(i, (zzdw) obj);
        }
    }

    static zzhe zzd(Object obj) {
        zzex zzexVar = (zzex) obj;
        zzhe zzheVar = zzexVar.zzc;
        if (zzheVar != zzhe.zzc()) {
            return zzheVar;
        }
        zzhe zzf = zzhe.zzf();
        zzexVar.zzc = zzf;
        return zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0268  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.play_billing.zzgf zzl(java.lang.Class r33, com.google.android.gms.internal.play_billing.zzfz r34, com.google.android.gms.internal.play_billing.zzgh r35, com.google.android.gms.internal.play_billing.zzfq r36, com.google.android.gms.internal.play_billing.zzhd r37, com.google.android.gms.internal.play_billing.zzek r38, com.google.android.gms.internal.play_billing.zzfx r39) {
        /*
            Method dump skipped, instructions count: 1030
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgf.zzl(java.lang.Class, com.google.android.gms.internal.play_billing.zzfz, com.google.android.gms.internal.play_billing.zzgh, com.google.android.gms.internal.play_billing.zzfq, com.google.android.gms.internal.play_billing.zzhd, com.google.android.gms.internal.play_billing.zzek, com.google.android.gms.internal.play_billing.zzfx):com.google.android.gms.internal.play_billing.zzgf");
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzhn.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzhn.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzhn.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
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

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzhn.zzf(obj, j)).longValue();
    }

    private final zzfb zzu(int i) {
        int i2 = i / 3;
        return (zzfb) this.zzd[i2 + i2 + 1];
    }

    private final zzgm zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgm zzgmVar = (zzgm) objArr[i3];
        if (zzgmVar != null) {
            return zzgmVar;
        }
        zzgm zzb2 = zzgk.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzgm zzv = zzv(i);
        int zzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzgm zzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzz(Class cls, String str) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0055. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v108, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v109, types: [com.google.android.gms.internal.play_billing.zzfk] */
    /* JADX WARN: Type inference failed for: r0v111, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v113, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v130 */
    /* JADX WARN: Type inference failed for: r0v178, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v248, types: [int] */
    /* JADX WARN: Type inference failed for: r0v255, types: [int] */
    /* JADX WARN: Type inference failed for: r0v260 */
    /* JADX WARN: Type inference failed for: r0v261 */
    /* JADX WARN: Type inference failed for: r0v262 */
    /* JADX WARN: Type inference failed for: r0v263 */
    /* JADX WARN: Type inference failed for: r0v264 */
    /* JADX WARN: Type inference failed for: r0v265 */
    /* JADX WARN: Type inference failed for: r0v266 */
    /* JADX WARN: Type inference failed for: r0v267 */
    /* JADX WARN: Type inference failed for: r0v268 */
    /* JADX WARN: Type inference failed for: r0v269 */
    /* JADX WARN: Type inference failed for: r0v270 */
    /* JADX WARN: Type inference failed for: r0v271 */
    /* JADX WARN: Type inference failed for: r0v272 */
    /* JADX WARN: Type inference failed for: r0v273 */
    /* JADX WARN: Type inference failed for: r0v274 */
    /* JADX WARN: Type inference failed for: r0v275 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v110, types: [int] */
    /* JADX WARN: Type inference failed for: r1v113, types: [int] */
    /* JADX WARN: Type inference failed for: r1v149 */
    /* JADX WARN: Type inference failed for: r1v152 */
    /* JADX WARN: Type inference failed for: r1v153 */
    /* JADX WARN: Type inference failed for: r1v154 */
    /* JADX WARN: Type inference failed for: r1v155 */
    /* JADX WARN: Type inference failed for: r1v70, types: [int] */
    /* JADX WARN: Type inference failed for: r1v72 */
    /* JADX WARN: Type inference failed for: r2v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v44, types: [int] */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53, types: [int] */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r2v94 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23, types: [int] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26, types: [int] */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v35, types: [int] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v42, types: [int] */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30, types: [int] */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v37, types: [int] */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final int zza(Object obj) {
        int i;
        int i2;
        ?? r5;
        int zzx;
        int zzx2;
        int zzy;
        int zzx3;
        int zzx4;
        int zzx5;
        int zzx6;
        ?? zzg;
        int size;
        int zzx7;
        int zzw;
        int zzw2;
        ?? r3;
        int zzv;
        ?? r1;
        ?? r0;
        int zze;
        int zzx8;
        int zzx9;
        ?? r4;
        Unsafe unsafe = zzb;
        boolean z = false;
        int i3 = 1048575;
        ?? r12 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i4 < this.zzc.length) {
            int zzs = zzs(i4);
            int zzr = zzr(zzs);
            int[] iArr = this.zzc;
            int i7 = iArr[i4];
            int i8 = iArr[i4 + 2];
            int i9 = i8 & i3;
            if (zzr <= 17) {
                if (i9 != i6) {
                    r12 = i9 == i3 ? z : unsafe.getInt(obj, i9);
                    i6 = i9;
                }
                i = i6;
                i2 = r12;
                r5 = 1 << (i8 >>> 20);
            } else {
                i = i6;
                i2 = r12;
                r5 = z;
            }
            int i10 = zzs & i3;
            if (zzr >= zzep.DOUBLE_LIST_PACKED.zza()) {
                zzep.SINT64_LIST_PACKED.zza();
            }
            long j = i10;
            switch (zzr) {
                case 0:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzx = zzee.zzx(i7 << 3);
                        r0 = zzx + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 1:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzx2 = zzee.zzx(i7 << 3);
                        r0 = zzx2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 2:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzy = zzee.zzy(unsafe.getLong(obj, j));
                        zzx3 = zzee.zzx(i7 << 3);
                        r0 = zzx3 + zzy;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 3:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzy = zzee.zzy(unsafe.getLong(obj, j));
                        zzx3 = zzee.zzx(i7 << 3);
                        r0 = zzx3 + zzy;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 4:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzy = zzee.zzu(unsafe.getInt(obj, j));
                        zzx3 = zzee.zzx(i7 << 3);
                        r0 = zzx3 + zzy;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 5:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzx = zzee.zzx(i7 << 3);
                        r0 = zzx + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 6:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzx2 = zzee.zzx(i7 << 3);
                        r0 = zzx2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 7:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzx4 = zzee.zzx(i7 << 3);
                        r0 = zzx4 + 1;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 8:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        int i11 = i7 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzdw) {
                            int i12 = zzee.zzb;
                            int zzd = ((zzdw) object).zzd();
                            zzx5 = zzee.zzx(zzd) + zzd;
                            zzx6 = zzee.zzx(i11);
                            r0 = zzx6 + zzx5;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            zzy = zzee.zzw((String) object);
                            zzx3 = zzee.zzx(i11);
                            r0 = zzx3 + zzy;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 9:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        r0 = zzgo.zzh(i7, unsafe.getObject(obj, j), zzv(i4));
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 10:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzdw zzdwVar = (zzdw) unsafe.getObject(obj, j);
                        int i13 = zzee.zzb;
                        int zzd2 = zzdwVar.zzd();
                        zzx5 = zzee.zzx(zzd2) + zzd2;
                        zzx6 = zzee.zzx(i7 << 3);
                        r0 = zzx6 + zzx5;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 11:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzy = zzee.zzx(unsafe.getInt(obj, j));
                        zzx3 = zzee.zzx(i7 << 3);
                        r0 = zzx3 + zzy;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 12:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzy = zzee.zzu(unsafe.getInt(obj, j));
                        zzx3 = zzee.zzx(i7 << 3);
                        r0 = zzx3 + zzy;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 13:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzx2 = zzee.zzx(i7 << 3);
                        r0 = zzx2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 14:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzx = zzee.zzx(i7 << 3);
                        r0 = zzx + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 15:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        int i14 = unsafe.getInt(obj, j);
                        zzx3 = zzee.zzx(i7 << 3);
                        zzy = zzee.zzx((i14 >> 31) ^ (i14 + i14));
                        r0 = zzx3 + zzy;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 16:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        long j2 = unsafe.getLong(obj, j);
                        zzx3 = zzee.zzx(i7 << 3);
                        zzy = zzee.zzy((j2 >> 63) ^ (j2 + j2));
                        r0 = zzx3 + zzy;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 17:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        r0 = zzee.zzt(i7, (zzgc) unsafe.getObject(obj, j), zzv(i4));
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 18:
                    r0 = zzgo.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 19:
                    r0 = zzgo.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i15 = zzgo.zza;
                    if (list.size() != 0) {
                        zzg = zzgo.zzg(list) + (list.size() * zzee.zzx(i7 << 3));
                        i5 += zzg;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    zzg = z;
                    i5 += zzg;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i16 = zzgo.zza;
                    size = list2.size();
                    if (size != 0) {
                        zzx3 = zzgo.zzl(list2);
                        zzx7 = zzee.zzx(i7 << 3);
                        zzy = size * zzx7;
                        r0 = zzx3 + zzy;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i17 = zzgo.zza;
                    size = list3.size();
                    if (size != 0) {
                        zzx3 = zzgo.zzf(list3);
                        zzx7 = zzee.zzx(i7 << 3);
                        zzy = size * zzx7;
                        r0 = zzx3 + zzy;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 23:
                    r0 = zzgo.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 24:
                    r0 = zzgo.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i18 = zzgo.zza;
                    int size2 = list4.size();
                    if (size2 != 0) {
                        r0 = size2 * (zzee.zzx(i7 << 3) + 1);
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 26:
                    ?? r02 = (List) unsafe.getObject(obj, j);
                    int i19 = zzgo.zza;
                    int size3 = r02.size();
                    if (size3 != 0) {
                        boolean z2 = r02 instanceof zzfk;
                        int zzx10 = zzee.zzx(i7 << 3) * size3;
                        if (z2) {
                            ?? r03 = (zzfk) r02;
                            zzg = zzx10;
                            for (?? r32 = z; r32 < size3; r32++) {
                                Object zzf = r03.zzf(r32);
                                if (zzf instanceof zzdw) {
                                    int zzd3 = ((zzdw) zzf).zzd();
                                    zzw2 = zzg + zzee.zzx(zzd3) + zzd3;
                                } else {
                                    zzw2 = zzg + zzee.zzw((String) zzf);
                                }
                                zzg = zzw2;
                            }
                        } else {
                            zzg = zzx10;
                            for (?? r33 = z; r33 < size3; r33++) {
                                Object obj2 = r02.get(r33);
                                if (obj2 instanceof zzdw) {
                                    int zzd4 = ((zzdw) obj2).zzd();
                                    zzw = zzg + zzee.zzx(zzd4) + zzd4;
                                } else {
                                    zzw = zzg + zzee.zzw((String) obj2);
                                }
                                zzg = zzw;
                            }
                        }
                        i5 += zzg;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    zzg = z;
                    i5 += zzg;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 27:
                    ?? r04 = (List) unsafe.getObject(obj, j);
                    zzgm zzv2 = zzv(i4);
                    int i20 = zzgo.zza;
                    int size4 = r04.size();
                    if (size4 == 0) {
                        r3 = z;
                    } else {
                        r3 = zzee.zzx(i7 << 3) * size4;
                        for (?? r42 = z; r42 < size4; r42++) {
                            Object obj3 = r04.get(r42);
                            if (obj3 instanceof zzfi) {
                                int zza2 = ((zzfi) obj3).zza();
                                zzv = (r3 == true ? 1 : 0) + zzee.zzx(zza2) + zza2;
                            } else {
                                zzv = (r3 == true ? 1 : 0) + zzee.zzv((zzgc) obj3, zzv2);
                            }
                            r3 = zzv;
                        }
                    }
                    i5 += r3;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 28:
                    ?? r05 = (List) unsafe.getObject(obj, j);
                    int i21 = zzgo.zza;
                    int size5 = r05.size();
                    if (size5 == 0) {
                        r1 = z;
                    } else {
                        r1 = size5 * zzee.zzx(i7 << 3);
                        for (?? r2 = z; r2 < r05.size(); r2++) {
                            int zzd5 = ((zzdw) r05.get(r2)).zzd();
                            r1 += zzee.zzx(zzd5) + zzd5;
                        }
                    }
                    i5 += r1;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 29:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i22 = zzgo.zza;
                    size = list5.size();
                    if (size != 0) {
                        zzx3 = zzgo.zzk(list5);
                        zzx7 = zzee.zzx(i7 << 3);
                        zzy = size * zzx7;
                        r0 = zzx3 + zzy;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 30:
                    List list6 = (List) unsafe.getObject(obj, j);
                    int i23 = zzgo.zza;
                    size = list6.size();
                    if (size != 0) {
                        zzx3 = zzgo.zza(list6);
                        zzx7 = zzee.zzx(i7 << 3);
                        zzy = size * zzx7;
                        r0 = zzx3 + zzy;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 31:
                    r0 = zzgo.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 32:
                    r0 = zzgo.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i24 = zzgo.zza;
                    size = list7.size();
                    if (size != 0) {
                        zzx3 = zzgo.zzi(list7);
                        zzx7 = zzee.zzx(i7 << 3);
                        zzy = size * zzx7;
                        r0 = zzx3 + zzy;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 34:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i25 = zzgo.zza;
                    size = list8.size();
                    if (size != 0) {
                        zzx3 = zzgo.zzj(list8);
                        zzx7 = zzee.zzx(i7 << 3);
                        zzy = size * zzx7;
                        r0 = zzx3 + zzy;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 35:
                    zze = zzgo.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzx8 = zzee.zzx(zze);
                        zzx9 = zzee.zzx(i7 << 3);
                        r1 = zzx9 + zzx8 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 36:
                    zze = zzgo.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzx8 = zzee.zzx(zze);
                        zzx9 = zzee.zzx(i7 << 3);
                        r1 = zzx9 + zzx8 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 37:
                    zze = zzgo.zzg((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzx8 = zzee.zzx(zze);
                        zzx9 = zzee.zzx(i7 << 3);
                        r1 = zzx9 + zzx8 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 38:
                    zze = zzgo.zzl((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzx8 = zzee.zzx(zze);
                        zzx9 = zzee.zzx(i7 << 3);
                        r1 = zzx9 + zzx8 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 39:
                    zze = zzgo.zzf((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzx8 = zzee.zzx(zze);
                        zzx9 = zzee.zzx(i7 << 3);
                        r1 = zzx9 + zzx8 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 40:
                    zze = zzgo.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzx8 = zzee.zzx(zze);
                        zzx9 = zzee.zzx(i7 << 3);
                        r1 = zzx9 + zzx8 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 41:
                    zze = zzgo.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzx8 = zzee.zzx(zze);
                        zzx9 = zzee.zzx(i7 << 3);
                        r1 = zzx9 + zzx8 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 42:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i26 = zzgo.zza;
                    zze = list9.size();
                    if (zze > 0) {
                        zzx8 = zzee.zzx(zze);
                        zzx9 = zzee.zzx(i7 << 3);
                        r1 = zzx9 + zzx8 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 43:
                    zze = zzgo.zzk((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzx8 = zzee.zzx(zze);
                        zzx9 = zzee.zzx(i7 << 3);
                        r1 = zzx9 + zzx8 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 44:
                    zze = zzgo.zza((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzx8 = zzee.zzx(zze);
                        zzx9 = zzee.zzx(i7 << 3);
                        r1 = zzx9 + zzx8 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 45:
                    zze = zzgo.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzx8 = zzee.zzx(zze);
                        zzx9 = zzee.zzx(i7 << 3);
                        r1 = zzx9 + zzx8 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 46:
                    zze = zzgo.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzx8 = zzee.zzx(zze);
                        zzx9 = zzee.zzx(i7 << 3);
                        r1 = zzx9 + zzx8 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 47:
                    zze = zzgo.zzi((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzx8 = zzee.zzx(zze);
                        zzx9 = zzee.zzx(i7 << 3);
                        r1 = zzx9 + zzx8 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 48:
                    zze = zzgo.zzj((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzx8 = zzee.zzx(zze);
                        zzx9 = zzee.zzx(i7 << 3);
                        r1 = zzx9 + zzx8 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    ?? r06 = (List) unsafe.getObject(obj, j);
                    zzgm zzv3 = zzv(i4);
                    int i27 = zzgo.zza;
                    int size6 = r06.size();
                    if (size6 == 0) {
                        r4 = z;
                    } else {
                        boolean z3 = z;
                        r4 = z3;
                        ?? r34 = z3;
                        while (r34 < size6) {
                            int zzt = zzee.zzt(i7, (zzgc) r06.get(r34), zzv3);
                            r34++;
                            r4 = (r4 == true ? 1 : 0) + zzt;
                        }
                    }
                    i5 += r4;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 50:
                    zzfw zzfwVar = (zzfw) unsafe.getObject(obj, j);
                    if (zzfwVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzfwVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzM(obj, i7, i4)) {
                        zzx = zzee.zzx(i7 << 3);
                        r0 = zzx + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 52:
                    if (zzM(obj, i7, i4)) {
                        zzx2 = zzee.zzx(i7 << 3);
                        r0 = zzx2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 53:
                    if (zzM(obj, i7, i4)) {
                        zzy = zzee.zzy(zzt(obj, j));
                        zzx3 = zzee.zzx(i7 << 3);
                        r0 = zzx3 + zzy;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case Elf64_Ehdr.e_phentsize /* 54 */:
                    if (zzM(obj, i7, i4)) {
                        zzy = zzee.zzy(zzt(obj, j));
                        zzx3 = zzee.zzx(i7 << 3);
                        r0 = zzx3 + zzy;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 55:
                    if (zzM(obj, i7, i4)) {
                        zzy = zzee.zzu(zzo(obj, j));
                        zzx3 = zzee.zzx(i7 << 3);
                        r0 = zzx3 + zzy;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 56:
                    if (zzM(obj, i7, i4)) {
                        zzx = zzee.zzx(i7 << 3);
                        r0 = zzx + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 57:
                    if (zzM(obj, i7, i4)) {
                        zzx2 = zzee.zzx(i7 << 3);
                        r0 = zzx2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case Elf64_Ehdr.e_shentsize /* 58 */:
                    if (zzM(obj, i7, i4)) {
                        zzx4 = zzee.zzx(i7 << 3);
                        r0 = zzx4 + 1;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 59:
                    if (zzM(obj, i7, i4)) {
                        int i28 = i7 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzdw) {
                            int i29 = zzee.zzb;
                            int zzd6 = ((zzdw) object2).zzd();
                            zzx5 = zzee.zzx(zzd6) + zzd6;
                            zzx6 = zzee.zzx(i28);
                            r0 = zzx6 + zzx5;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            zzy = zzee.zzw((String) object2);
                            zzx3 = zzee.zzx(i28);
                            r0 = zzx3 + zzy;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 60:
                    if (zzM(obj, i7, i4)) {
                        r0 = zzgo.zzh(i7, unsafe.getObject(obj, j), zzv(i4));
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzM(obj, i7, i4)) {
                        zzdw zzdwVar2 = (zzdw) unsafe.getObject(obj, j);
                        int i30 = zzee.zzb;
                        int zzd7 = zzdwVar2.zzd();
                        zzx5 = zzee.zzx(zzd7) + zzd7;
                        zzx6 = zzee.zzx(i7 << 3);
                        r0 = zzx6 + zzx5;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case Elf64_Ehdr.e_shstrndx /* 62 */:
                    if (zzM(obj, i7, i4)) {
                        zzy = zzee.zzx(zzo(obj, j));
                        zzx3 = zzee.zzx(i7 << 3);
                        r0 = zzx3 + zzy;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzM(obj, i7, i4)) {
                        zzy = zzee.zzu(zzo(obj, j));
                        zzx3 = zzee.zzx(i7 << 3);
                        r0 = zzx3 + zzy;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 64:
                    if (zzM(obj, i7, i4)) {
                        zzx2 = zzee.zzx(i7 << 3);
                        r0 = zzx2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzM(obj, i7, i4)) {
                        zzx = zzee.zzx(i7 << 3);
                        r0 = zzx + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 66:
                    if (zzM(obj, i7, i4)) {
                        int zzo = zzo(obj, j);
                        zzx3 = zzee.zzx(i7 << 3);
                        zzy = zzee.zzx((zzo >> 31) ^ (zzo + zzo));
                        r0 = zzx3 + zzy;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 67:
                    if (zzM(obj, i7, i4)) {
                        long zzt2 = zzt(obj, j);
                        zzx3 = zzee.zzx(i7 << 3);
                        zzy = zzee.zzy((zzt2 >> 63) ^ (zzt2 + zzt2));
                        r0 = zzx3 + zzy;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 68:
                    if (zzM(obj, i7, i4)) {
                        r0 = zzee.zzt(i7, (zzgc) unsafe.getObject(obj, j), zzv(i4));
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                default:
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
            }
        }
        zzhd zzhdVar = this.zzm;
        int zza3 = i5 + zzhdVar.zza(zzhdVar.zzd(obj));
        if (!this.zzh) {
            return zza3;
        }
        this.zzn.zza(obj);
        throw null;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001c. Please report as an issue. */
    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final int zzb(Object obj) {
        int i;
        long doubleToLongBits;
        int floatToIntBits;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int zzs = zzs(i4);
            int[] iArr = this.zzc;
            int i5 = 1048575 & zzs;
            int zzr = zzr(zzs);
            int i6 = iArr[i4];
            long j = i5;
            int i7 = 37;
            switch (zzr) {
                case 0:
                    i = i3 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zzhn.zza(obj, j));
                    byte[] bArr = zzfd.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 1:
                    i = i3 * 53;
                    floatToIntBits = Float.floatToIntBits(zzhn.zzb(obj, j));
                    i3 = i + floatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    doubleToLongBits = zzhn.zzd(obj, j);
                    byte[] bArr2 = zzfd.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 3:
                    i = i3 * 53;
                    doubleToLongBits = zzhn.zzd(obj, j);
                    byte[] bArr3 = zzfd.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 4:
                    i = i3 * 53;
                    floatToIntBits = zzhn.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    doubleToLongBits = zzhn.zzd(obj, j);
                    byte[] bArr4 = zzfd.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 6:
                    i = i3 * 53;
                    floatToIntBits = zzhn.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 7:
                    i = i3 * 53;
                    floatToIntBits = zzfd.zza(zzhn.zzw(obj, j));
                    i3 = i + floatToIntBits;
                    break;
                case 8:
                    i = i3 * 53;
                    floatToIntBits = ((String) zzhn.zzf(obj, j)).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object zzf = zzhn.zzf(obj, j);
                    if (zzf != null) {
                        i7 = zzf.hashCode();
                    }
                    i3 = i2 + i7;
                    break;
                case 10:
                    i = i3 * 53;
                    floatToIntBits = zzhn.zzf(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 11:
                    i = i3 * 53;
                    floatToIntBits = zzhn.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 12:
                    i = i3 * 53;
                    floatToIntBits = zzhn.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 13:
                    i = i3 * 53;
                    floatToIntBits = zzhn.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    doubleToLongBits = zzhn.zzd(obj, j);
                    byte[] bArr5 = zzfd.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 15:
                    i = i3 * 53;
                    floatToIntBits = zzhn.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    doubleToLongBits = zzhn.zzd(obj, j);
                    byte[] bArr6 = zzfd.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object zzf2 = zzhn.zzf(obj, j);
                    if (zzf2 != null) {
                        i7 = zzf2.hashCode();
                    }
                    i3 = i2 + i7;
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
                    i = i3 * 53;
                    floatToIntBits = zzhn.zzf(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 50:
                    i = i3 * 53;
                    floatToIntBits = zzhn.zzf(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzfd.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr8 = zzfd.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case Elf64_Ehdr.e_phentsize /* 54 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr9 = zzfd.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr10 = zzfd.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case Elf64_Ehdr.e_shentsize /* 58 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzfd.zza(zzN(obj, j));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = ((String) zzhn.zzf(obj, j)).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzhn.zzf(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzhn.zzf(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case Elf64_Ehdr.e_shstrndx /* 62 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr11 = zzfd.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr12 = zzfd.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzhn.zzf(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.zzm.zzd(obj).hashCode();
        if (!this.zzh) {
            return hashCode;
        }
        this.zzn.zza(obj);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0cf0, code lost:
    
        if (r6 == 1048575) goto L563;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0cf2, code lost:
    
        r13.putInt(r7, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0cf6, code lost:
    
        r3 = r0.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0cfa, code lost:
    
        if (r3 >= r0.zzk) goto L681;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0cfc, code lost:
    
        r5 = r0.zzi;
        r6 = r0.zzc;
        r5 = r5[r3];
        r6 = r6[r5];
        r6 = com.google.android.gms.internal.play_billing.zzhn.zzf(r7, r0.zzs(r5) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0d0e, code lost:
    
        if (r6 != null) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0d15, code lost:
    
        if (r0.zzu(r5) != null) goto L680;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0d1a, code lost:
    
        r6 = (com.google.android.gms.internal.play_billing.zzfw) r6;
        r1 = (com.google.android.gms.internal.play_billing.zzfv) r0.zzw(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0d22, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0d17, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0d23, code lost:
    
        if (r8 != 0) goto L580;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0d27, code lost:
    
        if (r1 != r37) goto L578;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0d2e, code lost:
    
        throw com.google.android.gms.internal.play_billing.zzff.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0d35, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0d31, code lost:
    
        if (r1 > r37) goto L584;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0d33, code lost:
    
        if (r4 != r8) goto L584;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0d3a, code lost:
    
        throw com.google.android.gms.internal.play_billing.zzff.zze();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:190:0x047b. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:551:0x00b4. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:91:0x0a26. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x09bb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x09c9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0c8b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:617:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:730:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0c9a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0c6d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0c84 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzc(java.lang.Object r34, byte[] r35, int r36, int r37, int r38, com.google.android.gms.internal.play_billing.zzdj r39) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgf.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzdj):int");
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final Object zze() {
        return ((zzex) this.zzg).zzi();
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzex) {
                zzex zzexVar = (zzex) obj;
                zzexVar.zzq(Integer.MAX_VALUE);
                zzexVar.zza = 0;
                zzexVar.zzo();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int zzs = zzs(i);
                int i2 = 1048575 & zzs;
                int zzr = zzr(zzs);
                long j = i2;
                if (zzr != 9) {
                    if (zzr == 60 || zzr == 68) {
                        if (zzM(obj, this.zzc[i], i)) {
                            zzv(i).zzf(zzb.getObject(obj, j));
                        }
                    } else {
                        switch (zzr) {
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
                                    ((zzfw) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                }
                if (zzI(obj, i)) {
                    zzv(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzm.zzg(obj);
            if (this.zzh) {
                this.zzn.zzb(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzs = zzs(i);
            int i2 = 1048575 & zzs;
            int[] iArr = this.zzc;
            int zzr = zzr(zzs);
            int i3 = iArr[i];
            long j = i2;
            switch (zzr) {
                case 0:
                    if (zzI(obj2, i)) {
                        zzhn.zzo(obj, j, zzhn.zza(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzI(obj2, i)) {
                        zzhn.zzp(obj, j, zzhn.zzb(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzI(obj2, i)) {
                        zzhn.zzr(obj, j, zzhn.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzI(obj2, i)) {
                        zzhn.zzr(obj, j, zzhn.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzI(obj2, i)) {
                        zzhn.zzq(obj, j, zzhn.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzI(obj2, i)) {
                        zzhn.zzr(obj, j, zzhn.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzI(obj2, i)) {
                        zzhn.zzq(obj, j, zzhn.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzI(obj2, i)) {
                        zzhn.zzm(obj, j, zzhn.zzw(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzI(obj2, i)) {
                        zzhn.zzs(obj, j, zzhn.zzf(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (zzI(obj2, i)) {
                        zzhn.zzs(obj, j, zzhn.zzf(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzI(obj2, i)) {
                        zzhn.zzq(obj, j, zzhn.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzI(obj2, i)) {
                        zzhn.zzq(obj, j, zzhn.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzI(obj2, i)) {
                        zzhn.zzq(obj, j, zzhn.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzI(obj2, i)) {
                        zzhn.zzr(obj, j, zzhn.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzI(obj2, i)) {
                        zzhn.zzq(obj, j, zzhn.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzI(obj2, i)) {
                        zzhn.zzr(obj, j, zzhn.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzB(obj, obj2, i);
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
                    int i4 = zzgo.zza;
                    zzhn.zzs(obj, j, zzfx.zza(zzhn.zzf(obj, j), zzhn.zzf(obj2, j)));
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
                    if (zzM(obj2, i3, i)) {
                        zzhn.zzs(obj, j, zzhn.zzf(obj2, j));
                        zzE(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzC(obj, obj2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case Elf64_Ehdr.e_shstrndx /* 62 */:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                case 66:
                case 67:
                    if (zzM(obj2, i3, i)) {
                        zzhn.zzs(obj, j, zzhn.zzf(obj2, j));
                        zzE(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzC(obj, obj2, i);
                    break;
            }
        }
        zzgo.zzp(this.zzm, obj, obj2);
        if (this.zzh) {
            this.zzn.zza(obj2);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzdj zzdjVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzdjVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final void zzi(Object obj, zzhv zzhvVar) throws IOException {
        int i;
        int i2;
        int i3;
        if (this.zzh) {
            this.zzn.zza(obj);
            throw null;
        }
        int[] iArr = this.zzc;
        Unsafe unsafe = zzb;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i7 < iArr.length) {
            int zzs = zzs(i7);
            int[] iArr2 = this.zzc;
            int zzr = zzr(zzs);
            int i8 = iArr2[i7];
            if (zzr <= 17) {
                int i9 = iArr2[i7 + 2];
                int i10 = i9 & i4;
                if (i10 != i5) {
                    i6 = i10 == i4 ? 0 : unsafe.getInt(obj, i10);
                    i5 = i10;
                }
                i = i5;
                i2 = i6;
                i3 = 1 << (i9 >>> 20);
            } else {
                i = i5;
                i2 = i6;
                i3 = 0;
            }
            long j = zzs & i4;
            switch (zzr) {
                case 0:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzhvVar.zzf(i8, zzhn.zza(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzhvVar.zzo(i8, zzhn.zzb(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzhvVar.zzt(i8, unsafe.getLong(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzhvVar.zzJ(i8, unsafe.getLong(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzhvVar.zzr(i8, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzhvVar.zzm(i8, unsafe.getLong(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzhvVar.zzk(i8, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzhvVar.zzb(i8, zzhn.zzw(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzO(i8, unsafe.getObject(obj, j), zzhvVar);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzhvVar.zzv(i8, unsafe.getObject(obj, j), zzv(i7));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzhvVar.zzd(i8, (zzdw) unsafe.getObject(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzhvVar.zzH(i8, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzhvVar.zzi(i8, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzhvVar.zzw(i8, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzhvVar.zzy(i8, unsafe.getLong(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzhvVar.zzA(i8, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzhvVar.zzC(i8, unsafe.getLong(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzhvVar.zzq(i8, unsafe.getObject(obj, j), zzv(i7));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzgo.zzs(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, false);
                    break;
                case 19:
                    zzgo.zzw(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, false);
                    break;
                case 20:
                    zzgo.zzy(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, false);
                    break;
                case 21:
                    zzgo.zzE(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, false);
                    break;
                case 22:
                    zzgo.zzx(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, false);
                    break;
                case 23:
                    zzgo.zzv(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, false);
                    break;
                case 24:
                    zzgo.zzu(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, false);
                    break;
                case 25:
                    zzgo.zzr(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, false);
                    break;
                case 26:
                    int i11 = this.zzc[i7];
                    List list = (List) unsafe.getObject(obj, j);
                    int i12 = zzgo.zza;
                    if (list != null && !list.isEmpty()) {
                        zzhvVar.zzG(i11, list);
                        break;
                    }
                    break;
                case 27:
                    int i13 = this.zzc[i7];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzgm zzv = zzv(i7);
                    int i14 = zzgo.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i15 = 0; i15 < list2.size(); i15++) {
                            ((zzef) zzhvVar).zzv(i13, list2.get(i15), zzv);
                        }
                        break;
                    }
                    break;
                case 28:
                    int i16 = this.zzc[i7];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i17 = zzgo.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzhvVar.zze(i16, list3);
                        break;
                    }
                    break;
                case 29:
                    zzgo.zzD(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, false);
                    break;
                case 30:
                    zzgo.zzt(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, false);
                    break;
                case 31:
                    zzgo.zzz(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, false);
                    break;
                case 32:
                    zzgo.zzA(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, false);
                    break;
                case 33:
                    zzgo.zzB(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, false);
                    break;
                case 34:
                    zzgo.zzC(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, false);
                    break;
                case 35:
                    zzgo.zzs(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, true);
                    break;
                case 36:
                    zzgo.zzw(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, true);
                    break;
                case 37:
                    zzgo.zzy(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, true);
                    break;
                case 38:
                    zzgo.zzE(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, true);
                    break;
                case 39:
                    zzgo.zzx(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, true);
                    break;
                case 40:
                    zzgo.zzv(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, true);
                    break;
                case 41:
                    zzgo.zzu(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, true);
                    break;
                case 42:
                    zzgo.zzr(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, true);
                    break;
                case 43:
                    zzgo.zzD(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, true);
                    break;
                case 44:
                    zzgo.zzt(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, true);
                    break;
                case 45:
                    zzgo.zzz(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, true);
                    break;
                case 46:
                    zzgo.zzA(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, true);
                    break;
                case 47:
                    zzgo.zzB(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, true);
                    break;
                case 48:
                    zzgo.zzC(this.zzc[i7], (List) unsafe.getObject(obj, j), zzhvVar, true);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    int i18 = this.zzc[i7];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzgm zzv2 = zzv(i7);
                    int i19 = zzgo.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i20 = 0; i20 < list4.size(); i20++) {
                            ((zzef) zzhvVar).zzq(i18, list4.get(i20), zzv2);
                        }
                        break;
                    }
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        throw null;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzM(obj, i8, i7)) {
                        zzhvVar.zzf(i8, zzm(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzM(obj, i8, i7)) {
                        zzhvVar.zzo(i8, zzn(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzM(obj, i8, i7)) {
                        zzhvVar.zzt(i8, zzt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case Elf64_Ehdr.e_phentsize /* 54 */:
                    if (zzM(obj, i8, i7)) {
                        zzhvVar.zzJ(i8, zzt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzM(obj, i8, i7)) {
                        zzhvVar.zzr(i8, zzo(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzM(obj, i8, i7)) {
                        zzhvVar.zzm(i8, zzt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzM(obj, i8, i7)) {
                        zzhvVar.zzk(i8, zzo(obj, j));
                        break;
                    } else {
                        break;
                    }
                case Elf64_Ehdr.e_shentsize /* 58 */:
                    if (zzM(obj, i8, i7)) {
                        zzhvVar.zzb(i8, zzN(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzM(obj, i8, i7)) {
                        zzO(i8, unsafe.getObject(obj, j), zzhvVar);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzM(obj, i8, i7)) {
                        zzhvVar.zzv(i8, unsafe.getObject(obj, j), zzv(i7));
                        break;
                    } else {
                        break;
                    }
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzM(obj, i8, i7)) {
                        zzhvVar.zzd(i8, (zzdw) unsafe.getObject(obj, j));
                        break;
                    } else {
                        break;
                    }
                case Elf64_Ehdr.e_shstrndx /* 62 */:
                    if (zzM(obj, i8, i7)) {
                        zzhvVar.zzH(i8, zzo(obj, j));
                        break;
                    } else {
                        break;
                    }
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzM(obj, i8, i7)) {
                        zzhvVar.zzi(i8, zzo(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzM(obj, i8, i7)) {
                        zzhvVar.zzw(i8, zzo(obj, j));
                        break;
                    } else {
                        break;
                    }
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzM(obj, i8, i7)) {
                        zzhvVar.zzy(i8, zzt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzM(obj, i8, i7)) {
                        zzhvVar.zzA(i8, zzo(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzM(obj, i8, i7)) {
                        zzhvVar.zzC(i8, zzt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzM(obj, i8, i7)) {
                        zzhvVar.zzq(i8, unsafe.getObject(obj, j), zzv(i7));
                        break;
                    } else {
                        break;
                    }
            }
            i7 += 3;
            i5 = i;
            i6 = i2;
            i4 = 1048575;
        }
        zzhd zzhdVar = this.zzm;
        zzhdVar.zzi(zzhdVar.zzd(obj), zzhvVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01c3 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzgm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzj(java.lang.Object r8, java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 634
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgf.zzj(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i4 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i6 = iArr[i4];
            int i7 = iArr2[i6];
            int zzs = zzs(i6);
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
            if ((268435456 & zzs) != 0 && !zzJ(obj, i6, i, i2, i10)) {
                return false;
            }
            int zzr = zzr(zzs);
            if (zzr != 9 && zzr != 17) {
                if (zzr != 27) {
                    if (zzr == 60 || zzr == 68) {
                        if (zzM(obj, i7, i6) && !zzK(obj, zzs, zzv(i6))) {
                            return false;
                        }
                    } else if (zzr != 49) {
                        if (zzr == 50 && !((zzfw) zzhn.zzf(obj, zzs & 1048575)).isEmpty()) {
                            throw null;
                        }
                    }
                }
                List list = (List) zzhn.zzf(obj, zzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgm zzv = zzv(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzv.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                }
            } else if (zzJ(obj, i6, i, i2, i10) && !zzK(obj, zzs, zzv(i6))) {
                return false;
            }
            i4++;
            i5 = i;
            i3 = i2;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzn.zza(obj);
        throw null;
    }
}
