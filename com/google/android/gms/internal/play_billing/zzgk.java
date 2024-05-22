package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
public final class zzgk {
    private static final zzgk zza = new zzgk();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzgn zzb = new zzfu();

    private zzgk() {
    }

    public static zzgk zza() {
        return zza;
    }

    public final zzgm zzb(Class cls) {
        zzfd.zzc(cls, "messageType");
        zzgm zzgmVar = (zzgm) this.zzc.get(cls);
        if (zzgmVar == null) {
            zzgmVar = this.zzb.zza(cls);
            zzfd.zzc(cls, "messageType");
            zzgm zzgmVar2 = (zzgm) this.zzc.putIfAbsent(cls, zzgmVar);
            if (zzgmVar2 != null) {
                return zzgmVar2;
            }
        }
        return zzgmVar;
    }
}
