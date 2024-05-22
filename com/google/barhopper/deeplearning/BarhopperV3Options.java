package com.google.barhopper.deeplearning;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class BarhopperV3Options extends zzed<BarhopperV3Options, zzk> implements zzfp {
    private static final BarhopperV3Options zza;
    private int zzd;
    private zzi zze;
    private zzn zzf;

    static {
        BarhopperV3Options barhopperV3Options = new BarhopperV3Options();
        zza = barhopperV3Options;
        zzed.zzU(BarhopperV3Options.class, barhopperV3Options);
    }

    private BarhopperV3Options() {
    }

    public static zzk zza() {
        return (zzk) zza.zzF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzc(BarhopperV3Options barhopperV3Options, zzi zziVar) {
        zziVar.getClass();
        barhopperV3Options.zze = zziVar;
        barhopperV3Options.zzd |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzd(BarhopperV3Options barhopperV3Options, zzn zznVar) {
        zznVar.getClass();
        barhopperV3Options.zzf = zznVar;
        barhopperV3Options.zzd |= 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new BarhopperV3Options();
        }
        zzj zzjVar = null;
        if (i2 == 4) {
            return new zzk(zzjVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
