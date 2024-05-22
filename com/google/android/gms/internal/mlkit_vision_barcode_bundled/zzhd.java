package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
@Deprecated
/* loaded from: classes4.dex */
public final class zzhd extends AbstractList implements RandomAccess, zzew {
    private final zzew zza;

    public zzhd(zzew zzewVar) {
        this.zza = zzewVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzev) this.zza).get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzhc(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new zzhb(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzew
    public final zzew zze() {
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzew
    public final Object zzf(int i) {
        return this.zza.zzf(i);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzew
    public final List zzh() {
        return this.zza.zzh();
    }
}
