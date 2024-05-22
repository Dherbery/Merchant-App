package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
final class zzcf extends AbstractSet {
    final /* synthetic */ zzcl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcf(zzcl zzclVar) {
        this.zza = zzclVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        int zzq;
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            zzq = this.zza.zzq(entry.getKey());
            if (zzq != -1) {
                Object[] objArr = this.zza.zzc;
                objArr.getClass();
                if (zzay.zza(objArr[zzq], entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzcl zzclVar = this.zza;
        Map zzj = zzclVar.zzj();
        if (zzj != null) {
            return zzj.entrySet().iterator();
        }
        return new zzcd(zzclVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object obj) {
        int zzp;
        int i;
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        zzcl zzclVar = this.zza;
        if (zzclVar.zzo()) {
            return false;
        }
        zzp = zzclVar.zzp();
        Object key = entry.getKey();
        Object value = entry.getValue();
        Object zzh = zzcl.zzh(this.zza);
        zzcl zzclVar2 = this.zza;
        int[] iArr = zzclVar2.zza;
        iArr.getClass();
        Object[] objArr = zzclVar2.zzb;
        objArr.getClass();
        Object[] objArr2 = zzclVar2.zzc;
        objArr2.getClass();
        int zzb = zzcm.zzb(key, value, zzp, zzh, iArr, objArr, objArr2);
        if (zzb == -1) {
            return false;
        }
        this.zza.zzn(zzb, zzp);
        zzcl zzclVar3 = this.zza;
        i = zzclVar3.zzg;
        zzclVar3.zzg = i - 1;
        this.zza.zzl();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }
}
