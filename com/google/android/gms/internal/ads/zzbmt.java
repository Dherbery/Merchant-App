package com.google.android.gms.internal.ads;

import com.amazon.a.a.o.b;
import com.facebook.react.uimanager.ViewProps;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
final class zzbmt implements zzbng {
    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcjk zzcjkVar = (zzcjk) obj;
        try {
            String str = (String) map.get(ViewProps.ENABLED);
            if (!zzfwk.zzc(b.ac, str) && !zzfwk.zzc("false", str)) {
                return;
            }
            zzfuf.zzi(zzcjkVar.getContext()).zzm(Boolean.parseBoolean(str));
        } catch (IOException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "DefaultGmsgHandlers.SetPaidv2PersonalizationEnabled");
        }
    }
}
