package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
final class zzdk implements zzhq {
    private final zzdj zza;

    private zzdk(zzdj zzdjVar) {
        byte[] bArr = zzem.zzd;
        this.zza = zzdjVar;
        zzdjVar.zza = this;
    }

    public static zzdk zza(zzdj zzdjVar) {
        zzdk zzdkVar = zzdjVar.zza;
        return zzdkVar != null ? zzdkVar : new zzdk(zzdjVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzB(int i, int i2) throws IOException {
        this.zza.zzp(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzD(int i, long j) throws IOException {
        this.zza.zzr(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    @Deprecated
    public final void zzF(int i) throws IOException {
        this.zza.zzo(i, 3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzG(int i, String str) throws IOException {
        this.zza.zzm(i, str);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzI(int i, int i2) throws IOException {
        this.zza.zzp(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzK(int i, long j) throws IOException {
        this.zza.zzr(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzb(int i, boolean z) throws IOException {
        this.zza.zzd(i, z);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzd(int i, zzdb zzdbVar) throws IOException {
        this.zza.zze(i, zzdbVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zze(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zze(i, (zzdb) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzf(int i, double d) throws IOException {
        this.zza.zzh(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    @Deprecated
    public final void zzh(int i) throws IOException {
        this.zza.zzo(i, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzm(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzo(int i, float f) throws IOException {
        this.zza.zzf(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzq(int i, Object obj, zzgh zzghVar) throws IOException {
        zzdj zzdjVar = this.zza;
        zzdjVar.zzo(i, 3);
        zzghVar.zzi((zzfo) obj, zzdjVar.zza);
        zzdjVar.zzo(i, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzr(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzt(int i, long j) throws IOException {
        this.zza.zzr(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzv(int i, Object obj, zzgh zzghVar) throws IOException {
        zzfo zzfoVar = (zzfo) obj;
        zzdg zzdgVar = (zzdg) this.zza;
        zzdgVar.zzq((i << 3) | 2);
        zzdgVar.zzq(((zzck) zzfoVar).zzB(zzghVar));
        zzghVar.zzi(zzfoVar, zzdgVar.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzw(int i, Object obj) throws IOException {
        if (obj instanceof zzdb) {
            zzdg zzdgVar = (zzdg) this.zza;
            zzdgVar.zzq(11);
            zzdgVar.zzp(2, i);
            zzdgVar.zze(3, (zzdb) obj);
            zzdgVar.zzq(12);
            return;
        }
        zzdj zzdjVar = this.zza;
        zzfo zzfoVar = (zzfo) obj;
        zzdg zzdgVar2 = (zzdg) zzdjVar;
        zzdgVar2.zzq(11);
        zzdgVar2.zzp(2, i);
        zzdgVar2.zzq(26);
        zzdgVar2.zzq(zzfoVar.zzE());
        zzfoVar.zzaa(zzdjVar);
        zzdgVar2.zzq(12);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzx(int i, int i2) throws IOException {
        this.zza.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzz(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzH(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzew)) {
            while (i2 < list.size()) {
                this.zza.zzm(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzew zzewVar = (zzew) list;
        while (i2 < list.size()) {
            Object zzf = zzewVar.zzf(i2);
            if (zzf instanceof String) {
                this.zza.zzm(i, (String) zzf);
            } else {
                this.zza.zze(i, (zzdb) zzf);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzJ(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzp(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzdj.zzy(((Integer) list.get(i4)).intValue());
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzq(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzL(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzr(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzdj.zzz(((Long) list.get(i4)).longValue());
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzs(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzd(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).booleanValue();
            i3++;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzb(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzf(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).intValue();
            i3 += 4;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzg(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).longValue();
            i3 += 8;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzi(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzs(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzdj.zzu(((Integer) list.get(i4)).intValue());
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzk(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzA(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).longValue();
            i3 += 8;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzi(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzC(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzdj zzdjVar = this.zza;
                int intValue = ((Integer) list.get(i2)).intValue();
                zzdjVar.zzp(i, (intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            int intValue2 = ((Integer) list.get(i4)).intValue();
            i3 += zzdj.zzy((intValue2 >> 31) ^ (intValue2 + intValue2));
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            zzdj zzdjVar2 = this.zza;
            int intValue3 = ((Integer) list.get(i2)).intValue();
            zzdjVar2.zzq((intValue3 >> 31) ^ (intValue3 + intValue3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzE(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzdj zzdjVar = this.zza;
                long longValue = ((Long) list.get(i2)).longValue();
                zzdjVar.zzr(i, (longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            long longValue2 = ((Long) list.get(i4)).longValue();
            i3 += zzdj.zzz((longValue2 >> 63) ^ (longValue2 + longValue2));
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            zzdj zzdjVar2 = this.zza;
            long longValue3 = ((Long) list.get(i2)).longValue();
            zzdjVar2.zzs((longValue3 >> 63) ^ (longValue3 + longValue3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).doubleValue();
            i3 += 8;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzdj.zzu(((Integer) list.get(i4)).intValue());
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzk(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzp(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzf(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).floatValue();
            i3 += 4;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzu(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzr(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzdj.zzz(((Long) list.get(i4)).longValue());
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzs(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void zzy(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzf(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).intValue();
            i3 += 4;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzg(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }
}
