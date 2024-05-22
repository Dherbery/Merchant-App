package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public final class zzfv {
    private final zzpj zza;
    private final Boolean zzc;
    private final zzth zze;
    private final zzcv zzf;
    private final zzcv zzg;
    private final Boolean zzb = null;
    private final zzos zzd = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfv(zzft zzftVar, zzfu zzfuVar) {
        this.zza = zzft.zzi(zzftVar);
        this.zzc = zzft.zzk(zzftVar);
        this.zze = zzft.zzj(zzftVar);
        this.zzf = zzft.zza(zzftVar);
        this.zzg = zzft.zzb(zzftVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfv)) {
            return false;
        }
        zzfv zzfvVar = (zzfv) obj;
        if (Objects.equal(this.zza, zzfvVar.zza)) {
            Boolean bool = zzfvVar.zzb;
            if (Objects.equal(null, null) && Objects.equal(this.zzc, zzfvVar.zzc)) {
                zzos zzosVar = zzfvVar.zzd;
                if (Objects.equal(null, null) && Objects.equal(this.zze, zzfvVar.zze) && Objects.equal(this.zzf, zzfvVar.zzf) && Objects.equal(this.zzg, zzfvVar.zzg)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, this.zzc, null, this.zze, this.zzf, this.zzg);
    }

    public final zzcv zza() {
        return this.zzf;
    }

    public final zzcv zzb() {
        return this.zzg;
    }

    public final zzpj zzc() {
        return this.zza;
    }

    public final zzth zzd() {
        return this.zze;
    }

    public final Boolean zze() {
        return this.zzc;
    }
}
