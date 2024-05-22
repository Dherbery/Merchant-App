package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.mlkit:common@@18.9.0 */
/* loaded from: classes4.dex */
public final class zzqc implements zzpq {
    private final zzlo zza;
    private zzol zzb = new zzol();

    private zzqc(zzlo zzloVar, int i) {
        this.zza = zzloVar;
        zzqn.zza();
    }

    public static zzpq zzf(zzlo zzloVar) {
        return new zzqc(zzloVar, 0);
    }

    public static zzpq zzg() {
        return new zzqc(new zzlo(), 0);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpq
    public final zzpq zza(zzln zzlnVar) {
        this.zza.zzf(zzlnVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpq
    public final zzpq zzb(zzlu zzluVar) {
        this.zza.zzi(zzluVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpq
    public final zzpq zzc(zzol zzolVar) {
        this.zzb = zzolVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpq
    public final String zzd() {
        zzon zzf = this.zza.zzk().zzf();
        return (zzf == null || zzag.zzc(zzf.zzk())) ? "NA" : (String) Preconditions.checkNotNull(zzf.zzk());
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpq
    public final byte[] zze(int i, boolean z) {
        this.zzb.zzf(Boolean.valueOf(1 == (i ^ 1)));
        this.zzb.zze(false);
        this.zza.zzj(this.zzb.zzm());
        try {
            zzqn.zza();
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzjn.zza).ignoreNullValues(true).build().encode(this.zza.zzk()).getBytes("utf-8");
            }
            zzlq zzk = this.zza.zzk();
            zzbs zzbsVar = new zzbs();
            zzjn.zza.configure(zzbsVar);
            return zzbsVar.zza().zza(zzk);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
