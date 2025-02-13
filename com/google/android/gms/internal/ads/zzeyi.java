package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzeyi implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;
    private final zzhhu zzc;
    private final zzhhu zzd;
    private final zzhhu zze;
    private final zzhhu zzf;

    public zzeyi(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3, zzhhu zzhhuVar4, zzhhu zzhhuVar5, zzhhu zzhhuVar6) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
        this.zzc = zzhhuVar3;
        this.zzd = zzhhuVar4;
        this.zze = zzhhuVar5;
        this.zzf = zzhhuVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        com.google.android.gms.ads.internal.util.zzg zzb = ((zzclk) this.zza).zzb();
        Context zza = ((zzclm) this.zzb).zza();
        zzgey zzgeyVar = zzcep.zza;
        zzhhl.zzb(zzgeyVar);
        return new zzeyf(zzb, zza, zzgeyVar, (ScheduledExecutorService) this.zzd.zzb(), ((zzeim) this.zze).zzb(), ((zzdao) this.zzf).zza());
    }
}
