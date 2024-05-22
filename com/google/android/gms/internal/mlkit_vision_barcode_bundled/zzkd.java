package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zzkd extends zzdz implements zzfp {
    private static final zzkd zzd;
    private byte zze = 2;

    static {
        zzkd zzkdVar = new zzkd();
        zzd = zzkdVar;
        zzed.zzU(zzkd.class, zzkdVar);
    }

    private zzkd() {
    }

    public static zzkd zzf() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zze);
        }
        if (i2 == 2) {
            return zzR(zzd, "\u0003\u0000", null);
        }
        if (i2 == 3) {
            return new zzkd();
        }
        if (i2 == 4) {
            return new zzkc(null);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zze = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
