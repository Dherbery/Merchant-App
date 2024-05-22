package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
final class zzbk implements Iterator {
    final Iterator zza;

    @CheckForNull
    Collection zzb;
    final /* synthetic */ zzbl zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbk(zzbl zzblVar) {
        this.zzc = zzblVar;
        this.zza = zzblVar.zza.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        this.zzb = (Collection) entry.getValue();
        zzbl zzblVar = this.zzc;
        Object key = entry.getKey();
        return new zzcr(key, zzblVar.zzb.zzd(key, (Collection) entry.getValue()));
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i;
        zzbc.zze(this.zzb != null, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzbu zzbuVar = this.zzc.zzb;
        i = zzbuVar.zzb;
        zzbuVar.zzb = i - this.zzb.size();
        this.zzb.clear();
        this.zzb = null;
    }
}
