package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
class zzbw extends zzdk {
    final /* synthetic */ zzby zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbw(zzby zzbyVar) {
        this.zza = zzbyVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdk
    final zzdj zza() {
        return this.zza;
    }
}
