package com.google.android.gms.internal.play_billing;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
public final class zzbl {
    private static final zzbp zza = new zzbi();
    private static final zzbo zzb = new zzbj();
    private final zzbp zze;
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private zzbo zzf = null;

    public final zzbl zza(zzbo zzboVar) {
        this.zzf = zzboVar;
        return this;
    }

    public final zzbq zzd() {
        return new zzbn(this, null);
    }

    public final void zzg(zzba zzbaVar) {
        zzda.zza(zzbaVar, SubscriberAttributeKt.JSON_NAME_KEY);
        if (zzbaVar.zzb()) {
            zzbo zzboVar = zzb;
            zzda.zza(zzbaVar, SubscriberAttributeKt.JSON_NAME_KEY);
            if (zzbaVar.zzb()) {
                this.zzc.remove(zzbaVar);
                this.zzd.put(zzbaVar, zzboVar);
                return;
            }
            throw new IllegalArgumentException("key must be repeating");
        }
        zzbp zzbpVar = zza;
        zzda.zza(zzbaVar, SubscriberAttributeKt.JSON_NAME_KEY);
        this.zzd.remove(zzbaVar);
        this.zzc.put(zzbaVar, zzbpVar);
    }
}
