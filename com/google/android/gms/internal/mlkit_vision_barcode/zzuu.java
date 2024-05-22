package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public abstract class zzuu {
    public static final zzuu zza = zzm().zzm();
    public static final zzuu zzb;

    static {
        zzut zzm = zzm();
        zzm.zzi(false);
        zzb = zzm.zzm();
    }

    public static zzut zzm() {
        zzul zzulVar = new zzul();
        zzulVar.zzg(10);
        zzulVar.zze(5);
        zzulVar.zzf(0.25f);
        zzulVar.zzd(0.8f);
        zzulVar.zzi(true);
        zzulVar.zzc(0.5f);
        zzulVar.zzb(0.8f);
        zzulVar.zzk(1500L);
        zzulVar.zzh(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        zzulVar.zza(true);
        zzulVar.zzj(0.1f);
        zzulVar.zzl(0.05f);
        return zzulVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract float zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract float zzb();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract float zzc();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract float zzd();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract float zze();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract float zzf();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzg();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzh();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long zzi();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long zzj();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzk();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzl();
}
