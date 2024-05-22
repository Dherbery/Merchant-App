package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
final class zzajg {
    public final zzajm zza;
    public final zzajp zzb;
    public final zzaea zzc;
    public final zzaeb zzd;
    public int zze;

    public zzajg(zzajm zzajmVar, zzajp zzajpVar, zzaea zzaeaVar) {
        this.zza = zzajmVar;
        this.zzb = zzajpVar;
        this.zzc = zzaeaVar;
        this.zzd = MimeTypes.AUDIO_TRUEHD.equals(zzajmVar.zzf.zzm) ? new zzaeb() : null;
    }
}
