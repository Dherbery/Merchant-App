package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
public final class zzgo {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzhd zzc;
    private static final zzhd zzd;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzhd zzhdVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzhdVar = (zzhd) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzhdVar;
        zzd = new zzhf();
    }

    public static void zzA(int i, List list, zzhv zzhvVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzz(i, list, z);
    }

    public static void zzB(int i, List list, zzhv zzhvVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzB(i, list, z);
    }

    public static void zzC(int i, List list, zzhv zzhvVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzD(i, list, z);
    }

    public static void zzD(int i, List list, zzhv zzhvVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzI(i, list, z);
    }

    public static void zzE(int i, List list, zzhv zzhvVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzK(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzF(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzey) {
            zzey zzeyVar = (zzey) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzu(zzeyVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzee.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzee.zzx(i << 3) + 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(List list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzee.zzx(i << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzey) {
            zzey zzeyVar = (zzey) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzu(zzeyVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzee.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfr) {
            zzfr zzfrVar = (zzfr) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzy(zzfrVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzee.zzy(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i, Object obj, zzgm zzgmVar) {
        int i2 = i << 3;
        if (obj instanceof zzfi) {
            int i3 = zzee.zzb;
            int zza2 = ((zzfi) obj).zza();
            return zzee.zzx(i2) + zzee.zzx(zza2) + zza2;
        }
        return zzee.zzx(i2) + zzee.zzv((zzgc) obj, zzgmVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzey) {
            zzey zzeyVar = (zzey) list;
            i = 0;
            while (i2 < size) {
                int zze = zzeyVar.zze(i2);
                i += zzee.zzx((zze >> 31) ^ (zze + zze));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i += zzee.zzx((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfr) {
            zzfr zzfrVar = (zzfr) list;
            i = 0;
            while (i2 < size) {
                long zze = zzfrVar.zze(i2);
                i += zzee.zzy((zze >> 63) ^ (zze + zze));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i += zzee.zzy((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzey) {
            zzey zzeyVar = (zzey) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzx(zzeyVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzee.zzx(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfr) {
            zzfr zzfrVar = (zzfr) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzy(zzfrVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzee.zzy(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzhd zzm() {
        return zzc;
    }

    public static zzhd zzn() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzo(Object obj, int i, int i2, Object obj2, zzhd zzhdVar) {
        if (obj2 == null) {
            obj2 = zzhdVar.zzc(obj);
        }
        zzhdVar.zzf(obj2, i, i2);
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzp(zzhd zzhdVar, Object obj, Object obj2) {
        zzhdVar.zzh(obj, zzhdVar.zze(zzhdVar.zzd(obj), zzhdVar.zzd(obj2)));
    }

    public static void zzq(Class cls) {
        Class cls2;
        if (!zzex.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzr(int i, List list, zzhv zzhvVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzc(i, list, z);
    }

    public static void zzs(int i, List list, zzhv zzhvVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzg(i, list, z);
    }

    public static void zzt(int i, List list, zzhv zzhvVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzj(i, list, z);
    }

    public static void zzu(int i, List list, zzhv zzhvVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzl(i, list, z);
    }

    public static void zzv(int i, List list, zzhv zzhvVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzn(i, list, z);
    }

    public static void zzw(int i, List list, zzhv zzhvVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzp(i, list, z);
    }

    public static void zzx(int i, List list, zzhv zzhvVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzs(i, list, z);
    }

    public static void zzy(int i, List list, zzhv zzhvVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzu(i, list, z);
    }

    public static void zzz(int i, List list, zzhv zzhvVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzx(i, list, z);
    }
}
