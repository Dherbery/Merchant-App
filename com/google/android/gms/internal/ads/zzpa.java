package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
final class zzpa {
    public static final zzpa zza;
    public final LogSessionId zzb;

    static {
        LogSessionId logSessionId;
        logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
        zza = new zzpa(logSessionId);
    }

    public zzpa(LogSessionId logSessionId) {
        this.zzb = logSessionId;
    }
}
