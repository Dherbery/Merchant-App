package com.google.android.gms.internal.ads;

import android.media.AudioFormat;
import android.media.AudioTrack;
import com.google.android.exoplayer2.audio.OpusUtil;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzpc {
    public static int zza(int i, int i2, zzk zzkVar) {
        boolean isDirectPlaybackSupported;
        for (int i3 = 10; i3 > 0; i3--) {
            int zzg = zzfy.zzg(i3);
            if (zzg != 0) {
                isDirectPlaybackSupported = AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i).setSampleRate(i2).setChannelMask(zzg).build(), zzkVar.zza().zza);
                if (isDirectPlaybackSupported) {
                    return i3;
                }
            }
        }
        return 0;
    }

    public static zzgaa<Integer> zzb(zzk zzkVar) {
        zzgad zzgadVar;
        boolean isDirectPlaybackSupported;
        zzfzx zzfzxVar = new zzfzx();
        zzgadVar = zzpd.zzc;
        zzgce it = zzgadVar.keySet().iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (zzfy.zza >= zzfy.zzf(intValue)) {
                isDirectPlaybackSupported = AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(intValue).setSampleRate(OpusUtil.SAMPLE_RATE).build(), zzkVar.zza().zza);
                if (isDirectPlaybackSupported) {
                    zzfzxVar.zzf(Integer.valueOf(intValue));
                }
            }
        }
        zzfzxVar.zzf((Object) 2);
        return zzfzxVar.zzi();
    }
}
