package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.media.metrics.LogSessionId;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
final class zzqo {
    public static void zza(AudioTrack audioTrack, zzpb zzpbVar) {
        LogSessionId logSessionId;
        boolean equals;
        LogSessionId zza = zzpbVar.zza();
        logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
        equals = zza.equals(logSessionId);
        if (equals) {
            return;
        }
        audioTrack.setLogSessionId(zza);
    }
}
