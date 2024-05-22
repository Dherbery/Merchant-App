package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes.dex */
final class zzaw extends com.google.android.gms.internal.play_billing.zzi {
    final AlternativeBillingOnlyAvailabilityListener zza;
    final zzbi zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzaw(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener, zzbi zzbiVar, zzav zzavVar) {
        this.zza = alternativeBillingOnlyAvailabilityListener;
        this.zzb = zzbiVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzj
    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            this.zzb.zza(zzbh.zza(67, 14, zzbk.zzj));
            this.zza.onAlternativeBillingOnlyAvailabilityResponse(zzbk.zzj);
            return;
        }
        int zzb = com.google.android.gms.internal.play_billing.zzb.zzb(bundle, "BillingClient");
        BillingResult zza = zzbk.zza(zzb, com.google.android.gms.internal.play_billing.zzb.zzg(bundle, "BillingClient"));
        if (zzb != 0) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "isAlternativeBillingOnlyAvailableAsync() failed. Response code: " + zzb);
            this.zzb.zza(zzbh.zza(23, 14, zza));
        }
        this.zza.onAlternativeBillingOnlyAvailabilityResponse(zza);
    }
}
