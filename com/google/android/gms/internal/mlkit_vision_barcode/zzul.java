package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
final class zzul extends zzut {
    private int zza;
    private int zzb;
    private float zzc;
    private float zzd;
    private boolean zze;
    private float zzf;
    private float zzg;
    private long zzh;
    private long zzi;
    private boolean zzj;
    private float zzk;
    private float zzl;
    private short zzm;

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut zza(boolean z) {
        this.zzj = true;
        this.zzm = (short) (this.zzm | 512);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut zzb(float f) {
        this.zzg = 0.8f;
        this.zzm = (short) (this.zzm | 64);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut zzc(float f) {
        this.zzf = 0.5f;
        this.zzm = (short) (this.zzm | 32);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut zzd(float f) {
        this.zzd = 0.8f;
        this.zzm = (short) (this.zzm | 8);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut zze(int i) {
        this.zzb = 5;
        this.zzm = (short) (this.zzm | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut zzf(float f) {
        this.zzc = 0.25f;
        this.zzm = (short) (this.zzm | 4);
        return this;
    }

    public final zzut zzg(int i) {
        this.zza = 10;
        this.zzm = (short) (this.zzm | 1);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut zzh(long j) {
        this.zzi = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
        this.zzm = (short) (this.zzm | 256);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut zzi(boolean z) {
        this.zze = z;
        this.zzm = (short) (this.zzm | 16);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut zzj(float f) {
        this.zzk = 0.1f;
        this.zzm = (short) (this.zzm | SilenceSkippingAudioProcessor.DEFAULT_SILENCE_THRESHOLD_LEVEL);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut zzk(long j) {
        this.zzh = 1500L;
        this.zzm = (short) (this.zzm | 128);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut zzl(float f) {
        this.zzl = 0.05f;
        this.zzm = (short) (this.zzm | 2048);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzuu zzm() {
        if (this.zzm != 4095) {
            StringBuilder sb = new StringBuilder();
            if ((this.zzm & 1) == 0) {
                sb.append(" recentFramesToCheck");
            }
            if ((this.zzm & 2) == 0) {
                sb.append(" recentFramesContainingPredictedArea");
            }
            if ((this.zzm & 4) == 0) {
                sb.append(" recentFramesIou");
            }
            if ((this.zzm & 8) == 0) {
                sb.append(" maxCoverage");
            }
            if ((this.zzm & 16) == 0) {
                sb.append(" useConfidenceScore");
            }
            if ((this.zzm & 32) == 0) {
                sb.append(" lowerConfidenceScore");
            }
            if ((this.zzm & 64) == 0) {
                sb.append(" higherConfidenceScore");
            }
            if ((this.zzm & 128) == 0) {
                sb.append(" zoomIntervalInMillis");
            }
            if ((this.zzm & 256) == 0) {
                sb.append(" resetIntervalInMillis");
            }
            if ((this.zzm & 512) == 0) {
                sb.append(" enableZoomThreshold");
            }
            if ((this.zzm & SilenceSkippingAudioProcessor.DEFAULT_SILENCE_THRESHOLD_LEVEL) == 0) {
                sb.append(" zoomInThreshold");
            }
            if ((this.zzm & 2048) == 0) {
                sb.append(" zoomOutThreshold");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        return new zzun(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, null);
    }
}
