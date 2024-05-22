package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzbnh implements zzbng {
    private final zzbni zza;

    public zzbnh(zzbni zzbniVar) {
        this.zza = zzbniVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcjk zzcjkVar = (zzcjk) obj;
        boolean equals = IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(map.get("transparentBackground"));
        boolean equals2 = IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(map.get("blur"));
        float f = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (NumberFormatException e) {
            zzcec.zzh("Fail to parse float", e);
        }
        this.zza.zzc(equals);
        this.zza.zzb(equals2, f);
        zzcjkVar.zzav(equals);
    }
}
