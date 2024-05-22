package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
public final class zzbz implements zzca {
    private final String zza;
    private final zzbd zzb;

    public zzbz() {
        zzbe zzbeVar = zzbe.NO_OP;
        this.zza = "";
        this.zzb = zzbeVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzca
    public final zzbf zza(String str) {
        return new zzci(this.zza, str, true, this.zzb, true, true);
    }
}
