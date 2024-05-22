package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzeuo implements zzexp {
    public final String zza;
    public final boolean zzb;

    public zzeuo(String str, boolean z) {
        this.zza = str;
        this.zzb = z;
    }

    @Override // com.google.android.gms.internal.ads.zzexp
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("gct", this.zza);
        if (this.zzb) {
            bundle.putString("de", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
        }
    }
}
