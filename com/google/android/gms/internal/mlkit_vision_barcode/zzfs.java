package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public final class zzfs {
    private zzfv zza;
    private Integer zzb;
    private zzol zzc;

    public final zzfs zza(Integer num) {
        this.zzb = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzfs zzb(zzol zzolVar) {
        this.zzc = zzolVar;
        return this;
    }

    public final zzfs zzc(zzfv zzfvVar) {
        this.zza = zzfvVar;
        return this;
    }

    public final zzfx zze() {
        return new zzfx(this, null);
    }
}
