package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzdsu implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;
    private final zzhhu zzc;

    public zzdsu(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
        this.zzc = zzhhuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* synthetic */ Object zzb() {
        int i = ((zzdao) this.zzc).zza().zzo.zza;
        if (i == 0) {
            throw null;
        }
        if (i - 1 != 0) {
            return ((zzeoa) this.zzb).zzb();
        }
        return ((zzeoa) this.zza).zzb();
    }
}
