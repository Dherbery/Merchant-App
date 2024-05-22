package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Set;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
public final class zzbt {
    private static final zzbp zza = new zzbr();
    private static final zzbo zzb = new zzbs();

    public static zzbl zza(Set set) {
        zzbl zzblVar = new zzbl(zza, null);
        zzblVar.zza(zzb);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzblVar.zzg((zzba) it.next());
        }
        return zzblVar;
    }
}
