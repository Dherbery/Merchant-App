package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public abstract class zzbm implements Iterator {
    final Iterator zza;

    @CheckForNull
    Object zzb;

    @CheckForNull
    Collection zzc;
    Iterator zzd;
    final /* synthetic */ zzbu zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbm(zzbu zzbuVar) {
        Map map;
        this.zze = zzbuVar;
        map = zzbuVar.zza;
        this.zza = map.entrySet().iterator();
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzcz.INSTANCE;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext() || this.zzd.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.zzd.hasNext()) {
            Map.Entry entry = (Map.Entry) this.zza.next();
            this.zzb = entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.zzc = collection;
            this.zzd = collection.iterator();
        }
        return zza(this.zzb, this.zzd.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i;
        this.zzd.remove();
        Collection collection = this.zzc;
        collection.getClass();
        if (collection.isEmpty()) {
            this.zza.remove();
        }
        zzbu zzbuVar = this.zze;
        i = zzbuVar.zzb;
        zzbuVar.zzb = i - 1;
    }

    abstract Object zza(Object obj, Object obj2);
}
