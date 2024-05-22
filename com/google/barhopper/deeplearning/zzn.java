package com.google.barhopper.deeplearning;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zzn extends zzed implements zzfp {
    private static final zzn zza;
    private int zzd;
    private String zze = "";
    private zzdb zzf = zzdb.zzb;
    private String zzg = "";
    private zzdb zzh = zzdb.zzb;
    private float zzi = 0.25f;
    private float zzj = 0.25f;
    private float zzk = 0.5f;
    private float zzl = 0.85f;
    private int zzm = 1;

    static {
        zzn zznVar = new zzn();
        zza = zznVar;
        zzed.zzU(zzn.class, zznVar);
    }

    private zzn() {
    }

    public static zzm zza() {
        return (zzm) zza.zzF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzc(zzn zznVar, zzdb zzdbVar) {
        zzdbVar.getClass();
        zznVar.zzd |= 2;
        zznVar.zzf = zzdbVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzd(zzn zznVar, zzdb zzdbVar) {
        zzdbVar.getClass();
        zznVar.zzd |= 8;
        zznVar.zzh = zzdbVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001\u0003ဈ\u0002\u0004ည\u0003\u0005ခ\u0004\u0006ခ\u0005\u0007ခ\u0006\bခ\u0007\tင\b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zzn();
        }
        zzl zzlVar = null;
        if (i2 == 4) {
            return new zzm(zzlVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
