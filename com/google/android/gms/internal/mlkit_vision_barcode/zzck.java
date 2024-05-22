package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
final class zzck extends AbstractCollection {
    final /* synthetic */ zzcl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzck(zzcl zzclVar) {
        this.zza = zzclVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzcl zzclVar = this.zza;
        Map zzj = zzclVar.zzj();
        if (zzj != null) {
            return zzj.values().iterator();
        }
        return new zzce(zzclVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.zza.size();
    }
}
