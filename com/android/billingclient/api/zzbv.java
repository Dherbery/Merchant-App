package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes.dex */
public final class zzbv {
    private boolean zza;

    private zzbv() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbv(zzbu zzbuVar) {
    }

    public final zzbv zza() {
        this.zza = true;
        return this;
    }

    public final zzbx zzb() {
        if (this.zza) {
            return new zzbx(true, false, null);
        }
        throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
    }
}
