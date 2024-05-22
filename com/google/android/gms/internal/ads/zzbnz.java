package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzbnz implements zzbng {
    private final zzdzd zza;

    public zzbnz(zzdzd zzdzdVar) {
        Preconditions.checkNotNull(zzdzdVar, "The Inspector Manager must not be null");
        this.zza = zzdzdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final void zza(Object obj, Map map) {
        if (map == null || !map.containsKey("extras")) {
            return;
        }
        long j = Long.MAX_VALUE;
        if (map.containsKey(PermissionsResponse.EXPIRES_KEY)) {
            try {
                j = Long.parseLong((String) map.get(PermissionsResponse.EXPIRES_KEY));
            } catch (NumberFormatException unused) {
            }
        }
        this.zza.zzi((String) map.get("extras"), j);
    }
}
