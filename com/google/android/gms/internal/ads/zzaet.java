package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.extractor.avi.AviExtractor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
final class zzaet implements zzaej {
    public final String zza;

    private zzaet(String str) {
        this.zza = str;
    }

    public static zzaet zzb(zzfp zzfpVar) {
        return new zzaet(zzfpVar.zzA(zzfpVar.zzb(), zzfwq.zzc));
    }

    @Override // com.google.android.gms.internal.ads.zzaej
    public final int zza() {
        return AviExtractor.FOURCC_strn;
    }
}
