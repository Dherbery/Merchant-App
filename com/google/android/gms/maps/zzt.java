package com.google.android.gms.maps;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes4.dex */
public final class zzt extends com.google.android.gms.maps.internal.zzj {
    final /* synthetic */ LocationSource zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(GoogleMap googleMap, LocationSource locationSource) {
        this.zza = locationSource;
    }

    @Override // com.google.android.gms.maps.internal.ILocationSourceDelegate
    public final void activate(com.google.android.gms.maps.internal.zzaj zzajVar) {
        this.zza.activate(new zzl(this, zzajVar));
    }

    @Override // com.google.android.gms.maps.internal.ILocationSourceDelegate
    public final void deactivate() {
        this.zza.deactivate();
    }
}
