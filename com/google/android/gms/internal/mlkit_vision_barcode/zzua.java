package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public final class zzua implements zztm {
    private final zzpl zza;
    private zzsj zzb = new zzsj();
    private final int zzc;

    private zzua(zzpl zzplVar, int i) {
        this.zza = zzplVar;
        zzuj.zza();
        this.zzc = i;
    }

    public static zztm zzf(zzpl zzplVar) {
        return new zzua(zzplVar, 0);
    }

    public static zztm zzg(zzpl zzplVar, int i) {
        return new zzua(zzplVar, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztm
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztm
    public final zztm zzb(zzpk zzpkVar) {
        this.zza.zzf(zzpkVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztm
    public final zztm zzc(zzsj zzsjVar) {
        this.zzb = zzsjVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztm
    public final String zzd() {
        zzsl zzg = this.zza.zzk().zzg();
        return (zzg == null || zzbd.zzc(zzg.zzk())) ? "NA" : (String) Preconditions.checkNotNull(zzg.zzk());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztm
    public final byte[] zze(int i, boolean z) {
        this.zzb.zzf(Boolean.valueOf(1 == (i ^ 1)));
        this.zzb.zze(false);
        this.zza.zzj(this.zzb.zzm());
        try {
            zzuj.zza();
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(zznj.zza).ignoreNullValues(true).build().encode(this.zza.zzk()).getBytes("utf-8");
            }
            zzpn zzk = this.zza.zzk();
            zzfk zzfkVar = new zzfk();
            zznj.zza.configure(zzfkVar);
            return zzfkVar.zza().zza(zzk);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
