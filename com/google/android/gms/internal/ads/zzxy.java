package com.google.android.gms.internal.ads;

import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzxy implements Spatializer$OnSpatializerStateChangedListener {
    final /* synthetic */ zzyg zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxy(zzxz zzxzVar, zzyg zzygVar) {
        this.zza = zzygVar;
    }

    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
        zzyg.zzi(this.zza);
    }

    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
        zzyg.zzi(this.zza);
    }
}
