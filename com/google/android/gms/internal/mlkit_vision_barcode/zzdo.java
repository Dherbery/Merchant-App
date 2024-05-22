package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractMap;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
final class zzdo extends zzcv {
    final /* synthetic */ zzdp zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdo(zzdp zzdpVar) {
        this.zza = zzdpVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        int i2;
        Object[] objArr;
        Object[] objArr2;
        i2 = this.zza.zzc;
        zzbc.zza(i, i2, "index");
        zzdp zzdpVar = this.zza;
        objArr = zzdpVar.zzb;
        int i3 = i + i;
        Object obj = objArr[i3];
        obj.getClass();
        objArr2 = zzdpVar.zzb;
        Object obj2 = objArr2[i3 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i;
        i = this.zza.zzc;
        return i;
    }
}
