package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.9.0 */
/* loaded from: classes4.dex */
public final class zzlr {
    private zzmd zza;
    private Long zzb;
    private zzlm zzc;
    private Long zzd;
    private zzls zze;
    private Long zzf;

    public static /* bridge */ /* synthetic */ zzlm zza(zzlr zzlrVar) {
        return zzlrVar.zzc;
    }

    public static /* bridge */ /* synthetic */ zzls zzh(zzlr zzlrVar) {
        return zzlrVar.zze;
    }

    public static /* bridge */ /* synthetic */ zzmd zzj(zzlr zzlrVar) {
        return zzlrVar.zza;
    }

    public static /* bridge */ /* synthetic */ Long zzk(zzlr zzlrVar) {
        return zzlrVar.zzf;
    }

    public static /* bridge */ /* synthetic */ Long zzl(zzlr zzlrVar) {
        return zzlrVar.zzd;
    }

    public static /* bridge */ /* synthetic */ Long zzm(zzlr zzlrVar) {
        return zzlrVar.zzb;
    }

    public final zzlr zzb(Long l) {
        this.zzf = l;
        return this;
    }

    public final zzlr zzc(zzls zzlsVar) {
        this.zze = zzlsVar;
        return this;
    }

    public final zzlr zzd(zzlm zzlmVar) {
        this.zzc = zzlmVar;
        return this;
    }

    public final zzlr zze(Long l) {
        this.zzd = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzlr zzf(zzmd zzmdVar) {
        this.zza = zzmdVar;
        return this;
    }

    public final zzlr zzg(Long l) {
        this.zzb = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzlu zzi() {
        return new zzlu(this, null);
    }
}
