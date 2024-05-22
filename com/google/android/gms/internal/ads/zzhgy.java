package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.LinkedHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public class zzhgy {
    final LinkedHashMap zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhgy(int i) {
        this.zza = zzhha.zzb(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzhgy zza(Object obj, zzhhm zzhhmVar) {
        zzhhl.zza(obj, SubscriberAttributeKt.JSON_NAME_KEY);
        zzhhl.zza(zzhhmVar, "provider");
        this.zza.put(obj, zzhhmVar);
        return this;
    }
}
