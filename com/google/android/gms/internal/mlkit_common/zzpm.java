package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.9.0 */
/* loaded from: classes4.dex */
final class zzpm extends zzpt {
    private final String zza;
    private final boolean zzb;
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpm(String str, boolean z, int i, zzpl zzplVar) {
        this.zza = str;
        this.zzb = z;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzpt) {
            zzpt zzptVar = (zzpt) obj;
            if (this.zza.equals(zzptVar.zzb()) && this.zzb == zzptVar.zzc() && this.zzc == zzptVar.zza()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003) ^ this.zzc;
    }

    public final String toString() {
        return "MLKitLoggingOptions{libraryName=" + this.zza + ", enableFirelog=" + this.zzb + ", firelogEventType=" + this.zzc + "}";
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpt
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpt
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpt
    public final boolean zzc() {
        return this.zzb;
    }
}
