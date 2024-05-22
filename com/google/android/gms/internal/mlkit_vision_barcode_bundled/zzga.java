package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.NoSuchElementException;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
final class zzga extends zzcu {
    final zzge zza;
    zzcw zzb = zzb();
    final /* synthetic */ zzgg zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzga(zzgg zzggVar) {
        this.zzc = zzggVar;
        this.zza = new zzge(zzggVar, null);
    }

    private final zzcw zzb() {
        zzge zzgeVar = this.zza;
        if (zzgeVar.hasNext()) {
            return zzgeVar.next().iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcw
    public final byte zza() {
        zzcw zzcwVar = this.zzb;
        if (zzcwVar == null) {
            throw new NoSuchElementException();
        }
        byte zza = zzcwVar.zza();
        if (!this.zzb.hasNext()) {
            this.zzb = zzb();
        }
        return zza;
    }
}
