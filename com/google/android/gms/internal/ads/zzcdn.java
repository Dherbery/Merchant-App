package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.math.BigInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzcdn {
    private BigInteger zza = BigInteger.ONE;
    private String zzb = SessionDescription.SUPPORTED_SDP_VERSION;

    public final synchronized String zza() {
        String bigInteger;
        bigInteger = this.zza.toString();
        this.zza = this.zza.add(BigInteger.ONE);
        this.zzb = bigInteger;
        return bigInteger;
    }

    public final synchronized String zzb() {
        return this.zzb;
    }
}
