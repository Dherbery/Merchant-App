package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Iterator;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
final class zzhc implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzhd zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhc(zzhd zzhdVar) {
        zzew zzewVar;
        this.zzb = zzhdVar;
        zzewVar = zzhdVar.zza;
        this.zza = zzewVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
