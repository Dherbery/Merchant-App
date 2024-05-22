package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
final class zzdq extends zzcy {
    private final transient zzcx zza;
    private final transient zzcv zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdq(zzcx zzcxVar, zzcv zzcvVar) {
        this.zza = zzcxVar;
        this.zzb = zzcvVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcq, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcy, com.google.android.gms.internal.mlkit_vision_barcode.zzcq, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcq
    public final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcy, com.google.android.gms.internal.mlkit_vision_barcode.zzcq
    /* renamed from: zzd */
    public final zzdx iterator() {
        return this.zzb.listIterator(0);
    }
}
