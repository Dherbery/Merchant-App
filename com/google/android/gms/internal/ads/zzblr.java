package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzblr {
    private final com.google.android.gms.ads.formats.zzg zza;
    private final com.google.android.gms.ads.formats.zzf zzb;
    private zzbkh zzc;

    public zzblr(com.google.android.gms.ads.formats.zzg zzgVar, com.google.android.gms.ads.formats.zzf zzfVar) {
        this.zza = zzgVar;
        this.zzb = zzfVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized zzbkh zzf(zzbkg zzbkgVar) {
        zzbkh zzbkhVar = this.zzc;
        if (zzbkhVar != null) {
            return zzbkhVar;
        }
        zzbkh zzbkhVar2 = new zzbkh(zzbkgVar);
        this.zzc = zzbkhVar2;
        return zzbkhVar2;
    }

    public final zzbkq zzc() {
        zzbln zzblnVar = null;
        if (this.zzb == null) {
            return null;
        }
        return new zzblo(this, zzblnVar);
    }

    public final zzbkt zzd() {
        return new zzblq(this, null);
    }
}
