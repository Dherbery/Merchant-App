package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
public final class zzio extends zzex implements zzgd {
    private static final zzio zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzio zzioVar = new zzio();
        zzb = zzioVar;
        zzex.zzp(zzio.class, zzioVar);
    }

    private zzio() {
    }

    public static zzin zzv() {
        return (zzin) zzb.zzg();
    }

    public static /* synthetic */ void zzx(zzio zzioVar, String str) {
        str.getClass();
        zzioVar.zzd |= 1;
        zzioVar.zze = str;
    }

    public static /* synthetic */ void zzy(zzio zzioVar, String str) {
        str.getClass();
        zzioVar.zzd |= 2;
        zzioVar.zzf = str;
    }

    @Override // com.google.android.gms.internal.play_billing.zzex
    public final Object zzu(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzm(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzio();
        }
        if (i2 == 4) {
            return new zzin(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
