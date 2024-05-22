package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
final class zzcj extends zzbv {
    final /* synthetic */ zzcl zza;
    private final Object zzb;
    private int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcj(zzcl zzclVar, int i) {
        this.zza = zzclVar;
        Object[] objArr = zzclVar.zzb;
        objArr.getClass();
        this.zzb = objArr[i];
        this.zzc = i;
    }

    private final void zza() {
        int zzq;
        int i = this.zzc;
        if (i != -1 && i < this.zza.size()) {
            Object obj = this.zzb;
            zzcl zzclVar = this.zza;
            int i2 = this.zzc;
            Object[] objArr = zzclVar.zzb;
            objArr.getClass();
            if (zzay.zza(obj, objArr[i2])) {
                return;
            }
        }
        zzq = this.zza.zzq(this.zzb);
        this.zzc = zzq;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbv, java.util.Map.Entry
    public final Object getKey() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbv, java.util.Map.Entry
    public final Object getValue() {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.get(this.zzb);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            return null;
        }
        Object[] objArr = this.zza.zzc;
        objArr.getClass();
        return objArr[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbv, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.put(this.zzb, obj);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            this.zza.put(this.zzb, obj);
            return null;
        }
        Object[] objArr = this.zza.zzc;
        objArr.getClass();
        Object obj2 = objArr[i];
        objArr.getClass();
        objArr[i] = obj;
        return obj2;
    }
}
