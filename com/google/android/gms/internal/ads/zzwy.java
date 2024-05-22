package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzwy {
    private final zzel zza = zzel.zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzwz zza(zzcz zzczVar, int[] iArr, int i, zzyw zzywVar, zzgaa zzgaaVar) {
        return new zzwz(zzczVar, iArr, 0, zzywVar, WorkRequest.MIN_BACKOFF_MILLIS, 25000L, 25000L, AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 0.7f, 0.75f, zzgaaVar, this.zza);
    }
}
