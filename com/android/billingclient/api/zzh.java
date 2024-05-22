package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes.dex */
public final class zzh {
    private final Context zza;
    private final zzg zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(Context context, zzbq zzbqVar, zzbi zzbiVar) {
        this.zza = context;
        this.zzb = new zzg(this, null, zzbiVar, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbq zzc() {
        zzg.zza(this.zzb);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PurchasesUpdatedListener zzd() {
        return zzg.zzb(this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zze() {
        this.zzb.zzd(this.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzf(boolean z) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        this.zza.getApplicationContext().getPackageName();
        intentFilter.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.zzb.zzc(this.zza, intentFilter, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(Context context, PurchasesUpdatedListener purchasesUpdatedListener, AlternativeBillingListener alternativeBillingListener, zzbi zzbiVar) {
        this.zza = context;
        this.zzb = new zzg(this, purchasesUpdatedListener, alternativeBillingListener, zzbiVar, (zzf) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(Context context, PurchasesUpdatedListener purchasesUpdatedListener, UserChoiceBillingListener userChoiceBillingListener, zzbi zzbiVar) {
        this.zza = context;
        this.zzb = new zzg(this, purchasesUpdatedListener, userChoiceBillingListener, zzbiVar, (zzf) null);
    }
}
