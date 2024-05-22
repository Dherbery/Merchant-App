package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public final class zzos {
    private final zzoq zza;
    private final Integer zzb;
    private final Integer zzc;
    private final Boolean zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzos(zzop zzopVar, zzor zzorVar) {
        zzoq zzoqVar;
        Integer num;
        zzoqVar = zzopVar.zza;
        this.zza = zzoqVar;
        num = zzopVar.zzb;
        this.zzb = num;
        this.zzc = null;
        this.zzd = null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzos)) {
            return false;
        }
        zzos zzosVar = (zzos) obj;
        if (Objects.equal(this.zza, zzosVar.zza) && Objects.equal(this.zzb, zzosVar.zzb)) {
            Integer num = zzosVar.zzc;
            if (Objects.equal(null, null)) {
                Boolean bool = zzosVar.zzd;
                if (Objects.equal(null, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, null, null);
    }

    public final zzoq zza() {
        return this.zza;
    }

    public final Integer zzb() {
        return this.zzb;
    }
}
