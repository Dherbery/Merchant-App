package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes4.dex */
public final class zzy extends com.google.android.gms.maps.internal.zzo {
    final /* synthetic */ GoogleMap.OnCameraIdleListener zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzy(GoogleMap googleMap, GoogleMap.OnCameraIdleListener onCameraIdleListener) {
        this.zza = onCameraIdleListener;
    }

    @Override // com.google.android.gms.maps.internal.zzp
    public final void zzb() {
        this.zza.onCameraIdle();
    }
}
