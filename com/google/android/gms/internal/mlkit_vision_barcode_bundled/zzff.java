package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
final class zzff implements zzfm {
    private final zzfm[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzff(zzfm... zzfmVarArr) {
        this.zza = zzfmVarArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfm
    public final zzfl zzb(Class cls) {
        zzfm[] zzfmVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzfm zzfmVar = zzfmVarArr[i];
            if (zzfmVar.zzc(cls)) {
                return zzfmVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfm
    public final boolean zzc(Class cls) {
        zzfm[] zzfmVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzfmVarArr[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
