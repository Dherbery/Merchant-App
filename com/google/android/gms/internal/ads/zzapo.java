package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.DefaultLoadControl;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzapo {
    private int zza = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS;
    private int zzb;

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }

    public final void zzc(zzaqj zzaqjVar) throws zzaqj {
        int i = this.zzb + 1;
        this.zzb = i;
        int i2 = this.zza;
        this.zza = i2 + i2;
        if (i > 1) {
            throw zzaqjVar;
        }
    }
}
