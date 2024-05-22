package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import sun.misc.Unsafe;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
final class zzhf extends zzhh {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhf(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzc(Object obj, long j, boolean z) {
        if (zzhi.zzb) {
            zzhi.zzD(obj, j, r3 ? (byte) 1 : (byte) 0);
        } else {
            zzhi.zzE(obj, j, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzd(Object obj, long j, byte b) {
        if (zzhi.zzb) {
            zzhi.zzD(obj, j, b);
        } else {
            zzhi.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final boolean zzg(Object obj, long j) {
        if (zzhi.zzb) {
            return zzhi.zzt(obj, j);
        }
        return zzhi.zzu(obj, j);
    }
}
