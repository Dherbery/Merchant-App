package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzfmj implements zzflw {
    private final zzfmg zza;
    private final zzfme zzb;

    public zzfmj(zzfmg zzfmgVar, zzfme zzfmeVar) {
        this.zza = zzfmgVar;
        this.zzb = zzfmeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzflw
    public final String zza(zzflv zzflvVar) {
        zzfme zzfmeVar = this.zzb;
        Map zzj = zzflvVar.zzj();
        zzfmeVar.zza(zzj);
        return this.zza.zza(zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzflw
    public final void zzb(zzflv zzflvVar) {
    }
}
