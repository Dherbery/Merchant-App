package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
final class zzdw implements zzfm {
    private static final zzdw zza = new zzdw();

    private zzdw() {
    }

    public static zzdw zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfm
    public final zzfl zzb(Class cls) {
        if (!zzed.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
        try {
            return (zzfl) zzed.zzI(cls.asSubclass(zzed.class)).zzg(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfm
    public final boolean zzc(Class cls) {
        return zzed.class.isAssignableFrom(cls);
    }
}
