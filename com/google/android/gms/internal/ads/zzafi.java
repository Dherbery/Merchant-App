package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.extractor.mp4.Sniffer;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzafi implements zzacu {
    private final zzfp zza = new zzfp(4);
    private final zzadw zzb = new zzadw(-1, -1, "image/heif");

    private final boolean zza(zzacv zzacvVar, int i) throws IOException {
        this.zza.zzH(4);
        ((zzack) zzacvVar).zzm(this.zza.zzM(), 0, 4, false);
        return this.zza.zzu() == ((long) i);
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        return this.zzb.zzb(zzacvVar, zzadrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzb.zzc(zzacxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j, long j2) {
        this.zzb.zzd(j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        ((zzack) zzacvVar).zzl(4, false);
        return zza(zzacvVar, Atom.TYPE_ftyp) && zza(zzacvVar, Sniffer.BRAND_HEIC);
    }
}
