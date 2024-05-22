package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
final class zzem {
    private static final zzek zza = new zzel();
    private static final zzek zzb;

    static {
        zzek zzekVar;
        try {
            zzekVar = (zzek) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzekVar = null;
        }
        zzb = zzekVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzek zza() {
        zzek zzekVar = zzb;
        if (zzekVar != null) {
            return zzekVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzek zzb() {
        return zza;
    }
}
