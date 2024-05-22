package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

/* compiled from: com.google.mlkit:common@@18.9.0 */
/* loaded from: classes4.dex */
public abstract class zzqb {
    public static zzqa zzh() {
        zzpn zzpnVar = new zzpn();
        zzpnVar.zzg("NA");
        zzpnVar.zzf(false);
        zzpnVar.zze(false);
        zzpnVar.zzd(ModelType.UNKNOWN);
        zzpnVar.zzb(zzlm.NO_ERROR);
        zzpnVar.zza(zzls.UNKNOWN_STATUS);
        zzpnVar.zzc(0);
        return zzpnVar;
    }

    public abstract int zza();

    public abstract ModelType zzb();

    public abstract zzlm zzc();

    public abstract zzls zzd();

    public abstract String zze();

    public abstract boolean zzf();

    public abstract boolean zzg();
}
