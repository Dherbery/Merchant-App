package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

/* compiled from: com.google.mlkit:common@@18.9.0 */
/* loaded from: classes4.dex */
final class zzpn extends zzqa {
    private zzlm zza;
    private String zzb;
    private boolean zzc;
    private boolean zzd;
    private ModelType zze;
    private zzls zzf;
    private int zzg;
    private byte zzh;

    @Override // com.google.android.gms.internal.mlkit_common.zzqa
    public final zzqa zza(zzls zzlsVar) {
        if (zzlsVar == null) {
            throw new NullPointerException("Null downloadStatus");
        }
        this.zzf = zzlsVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqa
    public final zzqa zzb(zzlm zzlmVar) {
        if (zzlmVar == null) {
            throw new NullPointerException("Null errorCode");
        }
        this.zza = zzlmVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqa
    public final zzqa zzc(int i) {
        this.zzg = i;
        this.zzh = (byte) (this.zzh | 4);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqa
    public final zzqa zzd(ModelType modelType) {
        if (modelType == null) {
            throw new NullPointerException("Null modelType");
        }
        this.zze = modelType;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqa
    public final zzqa zze(boolean z) {
        this.zzd = z;
        this.zzh = (byte) (this.zzh | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqa
    public final zzqa zzf(boolean z) {
        this.zzc = z;
        this.zzh = (byte) (this.zzh | 1);
        return this;
    }

    public final zzqa zzg(String str) {
        this.zzb = "NA";
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqa
    public final zzqb zzh() {
        zzlm zzlmVar;
        String str;
        ModelType modelType;
        zzls zzlsVar;
        if (this.zzh != 7 || (zzlmVar = this.zza) == null || (str = this.zzb) == null || (modelType = this.zze) == null || (zzlsVar = this.zzf) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.zza == null) {
                sb.append(" errorCode");
            }
            if (this.zzb == null) {
                sb.append(" tfliteSchemaVersion");
            }
            if ((this.zzh & 1) == 0) {
                sb.append(" shouldLogRoughDownloadTime");
            }
            if ((this.zzh & 2) == 0) {
                sb.append(" shouldLogExactDownloadTime");
            }
            if (this.zze == null) {
                sb.append(" modelType");
            }
            if (this.zzf == null) {
                sb.append(" downloadStatus");
            }
            if ((this.zzh & 4) == 0) {
                sb.append(" failureStatusCode");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        return new zzpp(zzlmVar, str, this.zzc, this.zzd, modelType, zzlsVar, this.zzg, null);
    }
}
