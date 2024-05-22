package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzadx implements zzadu {
    public zzadx(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return C.TIME_UNSET;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j) {
        zzadv zzadvVar = new zzadv(j, 0L);
        return new zzads(zzadvVar, zzadvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}
