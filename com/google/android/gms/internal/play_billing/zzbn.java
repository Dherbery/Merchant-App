package com.google.android.gms.internal.play_billing;

import java.util.HashMap;
import java.util.Map;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
final class zzbn extends zzbq {
    private final Map zza;
    private final Map zzb;
    private final zzbp zzc;
    private final zzbo zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbn(zzbl zzblVar, zzbm zzbmVar) {
        HashMap hashMap = new HashMap();
        this.zza = hashMap;
        HashMap hashMap2 = new HashMap();
        this.zzb = hashMap2;
        hashMap.putAll(zzbl.zzf(zzblVar));
        hashMap2.putAll(zzbl.zze(zzblVar));
        this.zzc = zzbl.zzc(zzblVar);
        this.zzd = zzbl.zzb(zzblVar);
    }
}
