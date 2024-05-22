package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
final class zzbl extends zzdh {
    final transient Map zza;
    final /* synthetic */ zzbu zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbl(zzbu zzbuVar, Map map) {
        this.zzb = zzbuVar;
        this.zza = map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Map map;
        Map map2 = this.zza;
        zzbu zzbuVar = this.zzb;
        map = zzbuVar.zza;
        if (map2 == map) {
            zzbuVar.zzs();
        } else {
            zzda.zza(new zzbk(this));
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        return zzdi.zzb(this.zza, obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(@CheckForNull Object obj) {
        return this == obj || this.zza.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdh, java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return this.zzb.zzw();
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final /* bridge */ /* synthetic */ Object remove(@CheckForNull Object obj) {
        int i;
        Collection collection = (Collection) this.zza.remove(obj);
        if (collection == null) {
            return null;
        }
        Collection zza = this.zzb.zza();
        zza.addAll(collection);
        zzbu zzbuVar = this.zzb;
        i = zzbuVar.zzb;
        zzbuVar.zzb = i - collection.size();
        collection.clear();
        return zza;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zza.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.zza.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Collection get(@CheckForNull Object obj) {
        Collection collection = (Collection) zzdi.zza(this.zza, obj);
        if (collection == null) {
            return null;
        }
        return this.zzb.zzd(obj, collection);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdh
    protected final Set zzb() {
        return new zzbj(this);
    }
}
