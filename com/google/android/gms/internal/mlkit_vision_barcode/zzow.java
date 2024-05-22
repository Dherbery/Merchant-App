package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public final class zzow {
    private Long zza;
    private zzpj zzb;
    private Boolean zzc;
    private Boolean zzd;
    private Boolean zze;

    public final zzow zza(Boolean bool) {
        this.zzd = bool;
        return this;
    }

    public final zzow zzb(Boolean bool) {
        this.zze = bool;
        return this;
    }

    public final zzow zzc(Long l) {
        this.zza = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzow zzd(zzpj zzpjVar) {
        this.zzb = zzpjVar;
        return this;
    }

    public final zzow zze(Boolean bool) {
        this.zzc = bool;
        return this;
    }

    public final zzoy zzf() {
        return new zzoy(this, null);
    }
}
