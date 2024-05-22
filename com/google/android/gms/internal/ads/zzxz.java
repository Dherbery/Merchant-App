package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzxz {
    private final Spatializer zza;
    private final boolean zzb;
    private Handler zzc;
    private Spatializer$OnSpatializerStateChangedListener zzd;

    private zzxz(Spatializer spatializer) {
        int immersiveAudioLevel;
        this.zza = spatializer;
        immersiveAudioLevel = spatializer.getImmersiveAudioLevel();
        this.zzb = immersiveAudioLevel != 0;
    }

    public static zzxz zza(Context context) {
        Spatializer spatializer;
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        spatializer = audioManager.getSpatializer();
        return new zzxz(spatializer);
    }

    public final void zzb(zzyg zzygVar, Looper looper) {
        if (this.zzd == null && this.zzc == null) {
            this.zzd = new zzxy(this, zzygVar);
            final Handler handler = new Handler(looper);
            this.zzc = handler;
            Spatializer spatializer = this.zza;
            Objects.requireNonNull(handler);
            spatializer.addOnSpatializerStateChangedListener(new Executor() { // from class: com.google.android.gms.internal.ads.zzxx
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    handler.post(runnable);
                }
            }, this.zzd);
        }
    }

    public final void zzc() {
        Spatializer$OnSpatializerStateChangedListener spatializer$OnSpatializerStateChangedListener = this.zzd;
        if (spatializer$OnSpatializerStateChangedListener == null || this.zzc == null) {
            return;
        }
        this.zza.removeOnSpatializerStateChangedListener(spatializer$OnSpatializerStateChangedListener);
        Handler handler = this.zzc;
        int i = zzfy.zza;
        handler.removeCallbacksAndMessages(null);
        this.zzc = null;
        this.zzd = null;
    }

    public final boolean zzd(zzk zzkVar, zzam zzamVar) {
        boolean canBeSpatialized;
        AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(zzfy.zzg((MimeTypes.AUDIO_E_AC3_JOC.equals(zzamVar.zzm) && zzamVar.zzz == 16) ? 12 : zzamVar.zzz));
        int i = zzamVar.zzA;
        if (i != -1) {
            channelMask.setSampleRate(i);
        }
        canBeSpatialized = this.zza.canBeSpatialized(zzkVar.zza().zza, channelMask.build());
        return canBeSpatialized;
    }

    public final boolean zze() {
        boolean isAvailable;
        isAvailable = this.zza.isAvailable();
        return isAvailable;
    }

    public final boolean zzf() {
        boolean isEnabled;
        isEnabled = this.zza.isEnabled();
        return isEnabled;
    }

    public final boolean zzg() {
        return this.zzb;
    }
}
