package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
final class zzfa extends zzfc {
    private zzfa() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfa(zzez zzezVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfc
    public final void zza(Object obj, long j) {
        ((zzel) zzhi.zzf(obj, j)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfc
    public final void zzb(Object obj, Object obj2, long j) {
        zzel zzelVar = (zzel) zzhi.zzf(obj, j);
        zzel zzelVar2 = (zzel) zzhi.zzf(obj2, j);
        int size = zzelVar.size();
        int size2 = zzelVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzelVar.zzc()) {
                zzelVar = zzelVar.zzd(size2 + size);
            }
            zzelVar.addAll(zzelVar2);
        }
        if (size > 0) {
            zzelVar2 = zzelVar;
        }
        zzhi.zzs(obj, j, zzelVar2);
    }
}
