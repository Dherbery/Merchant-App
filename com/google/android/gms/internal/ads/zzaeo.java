package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.extractor.avi.AviExtractor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
final class zzaeo implements zzaej {
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzaeo(int i, int i2, int i3, int i4) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    public static zzaeo zzb(zzfp zzfpVar) {
        int zzi = zzfpVar.zzi();
        zzfpVar.zzL(8);
        int zzi2 = zzfpVar.zzi();
        int zzi3 = zzfpVar.zzi();
        zzfpVar.zzL(4);
        int zzi4 = zzfpVar.zzi();
        zzfpVar.zzL(12);
        return new zzaeo(zzi, zzi2, zzi3, zzi4);
    }

    @Override // com.google.android.gms.internal.ads.zzaej
    public final int zza() {
        return AviExtractor.FOURCC_avih;
    }
}
