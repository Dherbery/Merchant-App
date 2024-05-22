package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
final class zzex extends zzeu {
    final /* synthetic */ zzey zza;
    private final zzup zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzex(zzey zzeyVar, zzup zzupVar) {
        this.zza = zzeyVar;
        this.zzb = zzupVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzeu
    final /* bridge */ /* synthetic */ Object zza() throws Exception {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzeu
    final String zzb() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzeu
    final void zzc(Throwable th) {
        this.zza.zzl(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzeu
    final /* synthetic */ void zzd(Object obj) {
        this.zza.zzm(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzeu
    final boolean zzf() {
        return this.zza.isDone();
    }
}
