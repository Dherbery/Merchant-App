package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.mlkit:common@@18.9.0 */
/* loaded from: classes4.dex */
public final class zzlz {
    private final String zza;
    private final String zzb;
    private final zzlx zzc;
    private final String zzd;
    private final String zze;
    private final zzlw zzf;
    private final Long zzg;
    private final Boolean zzh;
    private final Boolean zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzlz(zzlv zzlvVar, zzly zzlyVar) {
        String str;
        zzlx zzlxVar;
        String str2;
        zzlw zzlwVar;
        str = zzlvVar.zza;
        this.zza = str;
        this.zzb = null;
        zzlxVar = zzlvVar.zzb;
        this.zzc = zzlxVar;
        this.zzd = null;
        str2 = zzlvVar.zzc;
        this.zze = str2;
        zzlwVar = zzlvVar.zzd;
        this.zzf = zzlwVar;
        this.zzg = null;
        this.zzh = null;
        this.zzi = null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzlz)) {
            return false;
        }
        zzlz zzlzVar = (zzlz) obj;
        if (Objects.equal(this.zza, zzlzVar.zza)) {
            String str = zzlzVar.zzb;
            if (Objects.equal(null, null) && Objects.equal(this.zzc, zzlzVar.zzc)) {
                String str2 = zzlzVar.zzd;
                if (Objects.equal(null, null) && Objects.equal(this.zze, zzlzVar.zze) && Objects.equal(this.zzf, zzlzVar.zzf)) {
                    Long l = zzlzVar.zzg;
                    if (Objects.equal(null, null)) {
                        Boolean bool = zzlzVar.zzh;
                        if (Objects.equal(null, null)) {
                            Boolean bool2 = zzlzVar.zzi;
                            if (Objects.equal(null, null)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, this.zzc, null, this.zze, this.zzf, null, null, null);
    }

    public final zzlw zza() {
        return this.zzf;
    }

    public final zzlx zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zze;
    }

    public final String zzd() {
        return this.zza;
    }
}
