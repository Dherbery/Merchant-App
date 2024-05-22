package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

/* compiled from: com.google.mlkit:common@@18.9.0 */
/* loaded from: classes4.dex */
final class zzpp extends zzqb {
    private final zzlm zza;
    private final String zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final ModelType zze;
    private final zzls zzf;
    private final int zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpp(zzlm zzlmVar, String str, boolean z, boolean z2, ModelType modelType, zzls zzlsVar, int i, zzpo zzpoVar) {
        this.zza = zzlmVar;
        this.zzb = str;
        this.zzc = z;
        this.zzd = z2;
        this.zze = modelType;
        this.zzf = zzlsVar;
        this.zzg = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzqb) {
            zzqb zzqbVar = (zzqb) obj;
            if (this.zza.equals(zzqbVar.zzc()) && this.zzb.equals(zzqbVar.zze()) && this.zzc == zzqbVar.zzg() && this.zzd == zzqbVar.zzf() && this.zze.equals(zzqbVar.zzb()) && this.zzf.equals(zzqbVar.zzd()) && this.zzg == zzqbVar.zza()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
        return (((((((((hashCode * 1000003) ^ (true != this.zzc ? 1237 : 1231)) * 1000003) ^ (true == this.zzd ? 1231 : 1237)) * 1000003) ^ this.zze.hashCode()) * 1000003) ^ this.zzf.hashCode()) * 1000003) ^ this.zzg;
    }

    public final String toString() {
        return "RemoteModelLoggingOptions{errorCode=" + this.zza.toString() + ", tfliteSchemaVersion=" + this.zzb + ", shouldLogRoughDownloadTime=" + this.zzc + ", shouldLogExactDownloadTime=" + this.zzd + ", modelType=" + this.zze.toString() + ", downloadStatus=" + this.zzf.toString() + ", failureStatusCode=" + this.zzg + "}";
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqb
    public final int zza() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqb
    public final ModelType zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqb
    public final zzlm zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqb
    public final zzls zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqb
    public final String zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqb
    public final boolean zzf() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqb
    public final boolean zzg() {
        return this.zzc;
    }
}
