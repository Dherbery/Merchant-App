package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.amazon.a.a.o.b;
import com.amazon.a.a.o.b.f;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzfme {
    private final Context zza;
    private final String zzb;
    private final String zzc;

    public zzfme(Context context, zzcei zzceiVar) {
        this.zza = context;
        this.zzb = context.getPackageName();
        this.zzc = zzceiVar.zza;
    }

    public final void zza(Map map) {
        map.put("s", "gmob_sdk");
        map.put("v", ExifInterface.GPS_MEASUREMENT_3D);
        map.put("os", Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        com.google.android.gms.ads.internal.zzt.zzp();
        map.put("device", com.google.android.gms.ads.internal.util.zzt.zzr());
        map.put("app", this.zzb);
        com.google.android.gms.ads.internal.zzt.zzp();
        boolean zzD = com.google.android.gms.ads.internal.util.zzt.zzD(this.zza);
        String str = SessionDescription.SUPPORTED_SDP_VERSION;
        map.put("is_lite_sdk", true != zzD ? SessionDescription.SUPPORTED_SDP_VERSION : IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
        zzbfu zzbfuVar = zzbgc.zza;
        List zzb = com.google.android.gms.ads.internal.client.zzba.zza().zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgU)).booleanValue()) {
            zzb.addAll(com.google.android.gms.ads.internal.zzt.zzo().zzi().zzh().zzd());
        }
        map.put("e", TextUtils.join(f.a, zzb));
        map.put(b.I, this.zzc);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkL)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzp();
            if (true == com.google.android.gms.ads.internal.util.zzt.zzA(this.zza)) {
                str = IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
            }
            map.put("is_bstar", str);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjn)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcc)).booleanValue()) {
                map.put("plugin", zzfxt.zzc(com.google.android.gms.ads.internal.zzt.zzo().zzn()));
            }
        }
    }
}
