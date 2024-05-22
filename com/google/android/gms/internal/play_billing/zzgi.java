package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
final class zzgi {
    private static final zzgh zza;
    private static final zzgh zzb;

    static {
        zzgh zzghVar;
        try {
            zzghVar = (zzgh) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzghVar = null;
        }
        zza = zzghVar;
        zzb = new zzgh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgh zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgh zzb() {
        return zzb;
    }
}
