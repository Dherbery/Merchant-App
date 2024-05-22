package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import com.google.android.exoplayer2.util.MimeTypes;
import com.onesignal.Continue$with$1$$ExternalSyntheticApiModelOutline0;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
final class zzsu {
    public static int zza(MediaCodecInfo.VideoCapabilities videoCapabilities, String str, int i, int i2, double d) {
        List supportedPerformancePoints;
        supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
        if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty()) {
            return 0;
        }
        int zzb = zzb(supportedPerformancePoints, Continue$with$1$$ExternalSyntheticApiModelOutline0.m(i, i2, (int) d));
        if (zzb == 1 && str.equals(MimeTypes.VIDEO_H264)) {
            Continue$with$1$$ExternalSyntheticApiModelOutline0.m996m();
            if (zzb(supportedPerformancePoints, Continue$with$1$$ExternalSyntheticApiModelOutline0.m(1280, 720, 60)) != 2) {
                return 0;
            }
        }
        return zzb;
    }

    private static int zzb(List list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
        boolean covers;
        for (int i = 0; i < list.size(); i++) {
            covers = Continue$with$1$$ExternalSyntheticApiModelOutline0.m984m(list.get(i)).covers(performancePoint);
            if (covers) {
                return 2;
            }
        }
        return 1;
    }
}
