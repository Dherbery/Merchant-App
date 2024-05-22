package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zzae extends zzed implements zzfp {
    private static final zzae zza;
    private int zzd;
    private int zze = 4369;
    private String zzf = "";

    static {
        zzae zzaeVar = new zzae();
        zza = zzaeVar;
        zzed.zzU(zzae.class, zzaeVar);
    }

    private zzae() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", zzr.zza, "zzf"});
        }
        if (i2 == 3) {
            return new zzae();
        }
        if (i2 == 4) {
            return new zzad(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
