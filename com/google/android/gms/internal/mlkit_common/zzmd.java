package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.mlkit:common@@18.9.0 */
/* loaded from: classes4.dex */
public final class zzmd {
    private final zzlz zza;
    private final zzmb zzb;
    private final zzmb zzc;
    private final Boolean zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzmd(zzma zzmaVar, zzmc zzmcVar) {
        zzlz zzlzVar;
        zzlzVar = zzmaVar.zza;
        this.zza = zzlzVar;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzmd)) {
            return false;
        }
        zzmd zzmdVar = (zzmd) obj;
        if (Objects.equal(this.zza, zzmdVar.zza)) {
            zzmb zzmbVar = zzmdVar.zzb;
            if (Objects.equal(null, null)) {
                zzmb zzmbVar2 = zzmdVar.zzc;
                if (Objects.equal(null, null)) {
                    Boolean bool = zzmdVar.zzd;
                    if (Objects.equal(null, null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, null, null);
    }

    public final zzlz zza() {
        return this.zza;
    }
}
