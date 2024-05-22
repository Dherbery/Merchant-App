package com.google.barhopper.deeplearning;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzel;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zzf extends zzed implements zzfp {
    private static final zzf zza;
    private zzel zzd = zzO();

    static {
        zzf zzfVar = new zzf();
        zza = zzfVar;
        zzed.zzU(zzf.class, zzfVar);
    }

    private zzf() {
    }

    public static zze zza() {
        return (zze) zza.zzF();
    }

    public static /* synthetic */ zzf zzb() {
        return zza;
    }

    public static /* synthetic */ void zzc(zzf zzfVar, zzc zzcVar) {
        zzcVar.getClass();
        zzel zzelVar = zzfVar.zzd;
        if (!zzelVar.zzc()) {
            zzfVar.zzd = zzed.zzP(zzelVar);
        }
        zzfVar.zzd.add(zzcVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzc.class});
        }
        if (i2 == 3) {
            return new zzf();
        }
        if (i2 == 4) {
            return new zze(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
