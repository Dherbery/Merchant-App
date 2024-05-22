package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
final class zzha extends zzgy {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final /* synthetic */ int zza(Object obj) {
        return ((zzgz) obj).zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final /* synthetic */ int zzb(Object obj) {
        return ((zzgz) obj).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzed zzedVar = (zzed) obj;
        zzgz zzgzVar = zzedVar.zzc;
        if (zzgzVar != zzgz.zzc()) {
            return zzgzVar;
        }
        zzgz zzf = zzgz.zzf();
        zzedVar.zzc = zzf;
        return zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final /* synthetic */ Object zzd(Object obj) {
        return ((zzed) obj).zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (zzgz.zzc().equals(obj2)) {
            return obj;
        }
        if (zzgz.zzc().equals(obj)) {
            return zzgz.zze((zzgz) obj, (zzgz) obj2);
        }
        ((zzgz) obj).zzd((zzgz) obj2);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final /* bridge */ /* synthetic */ void zzf(Object obj, int i, long j) {
        ((zzgz) obj).zzj(i << 3, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final void zzg(Object obj) {
        ((zzed) obj).zzc.zzh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final /* synthetic */ void zzh(Object obj, Object obj2) {
        ((zzed) obj).zzc = (zzgz) obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final /* synthetic */ void zzi(Object obj, zzhq zzhqVar) throws IOException {
        ((zzgz) obj).zzk(zzhqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final /* synthetic */ void zzj(Object obj, zzhq zzhqVar) throws IOException {
        ((zzgz) obj).zzl(zzhqVar);
    }
}
