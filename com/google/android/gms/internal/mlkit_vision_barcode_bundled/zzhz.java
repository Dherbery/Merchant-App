package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zzhz extends zzed implements zzfp {
    private static final zzhz zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzhz zzhzVar = new zzhz();
        zza = zzhzVar;
        zzed.zzU(zzhz.class, zzhzVar);
    }

    private zzhz() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzhz();
        }
        zzhr zzhrVar = null;
        if (i2 == 4) {
            return new zzhy(zzhrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
