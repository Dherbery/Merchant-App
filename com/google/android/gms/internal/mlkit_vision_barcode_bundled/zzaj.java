package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zzaj extends zzed implements zzfp {
    public static final zzeb zza;
    private static final zzek zzd = new zzag();
    private static final zzaj zze;
    private int zzf;
    private zzy zzl;
    private zzkd zzm;
    private byte zzn = 2;
    private String zzg = "";
    private String zzh = "";
    private zzej zzi = zzN();
    private String zzj = "";
    private String zzk = "";

    static {
        zzaj zzajVar = new zzaj();
        zze = zzajVar;
        zzed.zzU(zzaj.class, zzajVar);
        zza = zzed.zzH(zzkd.zzf(), zzajVar, zzajVar, null, 308676116, zzho.MESSAGE, zzaj.class);
    }

    private zzaj() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzn);
        }
        if (i2 == 2) {
            return zzR(zze, "\u0001\u0007\u0000\u0001\u0001Ǵ\u0007\u0000\u0001\u0002\u0001ᔈ\u0000\u0002ဈ\u0001\u0003ࠞ\u0005ဈ\u0002\u0006ဈ\u0003\u000fᐉ\u0005Ǵဉ\u0004", new Object[]{"zzf", "zzg", "zzh", "zzi", zzai.zza, "zzj", "zzk", "zzm", "zzl"});
        }
        if (i2 == 3) {
            return new zzaj();
        }
        if (i2 == 4) {
            return new zzah(null);
        }
        if (i2 == 5) {
            return zze;
        }
        this.zzn = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
