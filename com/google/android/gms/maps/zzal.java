package com.google.android.gms.maps;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.internal.zzbo;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes4.dex */
final class zzal extends zzbo {
    final /* synthetic */ StreetViewPanorama.OnStreetViewPanoramaClickListener zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzal(StreetViewPanorama streetViewPanorama, StreetViewPanorama.OnStreetViewPanoramaClickListener onStreetViewPanoramaClickListener) {
        this.zza = onStreetViewPanoramaClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbp
    public final void zzb(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        this.zza.onStreetViewPanoramaClick(streetViewPanoramaOrientation);
    }
}
