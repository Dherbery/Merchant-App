package com.google.android.gms.internal.play_billing;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
public final class zzfu implements zzgn {
    private static final zzga zza = new zzfs();
    private final zzga zzb;

    public zzfu() {
        zzga zzgaVar;
        zzga[] zzgaVarArr = new zzga[2];
        zzgaVarArr[0] = zzes.zza();
        try {
            zzgaVar = (zzga) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzgaVar = zza;
        }
        zzgaVarArr[1] = zzgaVar;
        zzft zzftVar = new zzft(zzgaVarArr);
        byte[] bArr = zzfd.zzd;
        this.zzb = zzftVar;
    }

    private static boolean zzb(zzfz zzfzVar) {
        return zzfzVar.zzc() + (-1) != 1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgn
    public final zzgm zza(Class cls) {
        zzgo.zzq(cls);
        zzfz zzb = this.zzb.zzb(cls);
        if (!zzb.zzb()) {
            if (zzex.class.isAssignableFrom(cls)) {
                if (zzb(zzb)) {
                    return zzgf.zzl(cls, zzb, zzgi.zzb(), zzfq.zzd(), zzgo.zzn(), zzem.zzb(), zzfy.zzb());
                }
                return zzgf.zzl(cls, zzb, zzgi.zzb(), zzfq.zzd(), zzgo.zzn(), null, zzfy.zzb());
            }
            if (zzb(zzb)) {
                return zzgf.zzl(cls, zzb, zzgi.zza(), zzfq.zzc(), zzgo.zzm(), zzem.zza(), zzfy.zza());
            }
            return zzgf.zzl(cls, zzb, zzgi.zza(), zzfq.zzc(), zzgo.zzm(), null, zzfy.zza());
        }
        if (zzex.class.isAssignableFrom(cls)) {
            return zzgg.zzc(zzgo.zzn(), zzem.zzb(), zzb.zza());
        }
        return zzgg.zzc(zzgo.zzm(), zzem.zza(), zzb.zza());
    }
}
