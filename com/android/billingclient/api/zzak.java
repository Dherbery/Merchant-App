package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzhy;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzih;
import com.google.android.gms.internal.play_billing.zzii;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes.dex */
final class zzak extends ResultReceiver {
    final /* synthetic */ AlternativeBillingOnlyInformationDialogListener zza;
    final /* synthetic */ BillingClientImpl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzak(BillingClientImpl billingClientImpl, Handler handler, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        super(handler);
        this.zzb = billingClientImpl;
        this.zza = alternativeBillingOnlyInformationDialogListener;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        zzbi zzbiVar;
        zzhy zzhyVar;
        zzbi zzbiVar2;
        BillingResult.Builder newBuilder = BillingResult.newBuilder();
        newBuilder.setResponseCode(i);
        if (i != 0) {
            if (bundle == null) {
                zzbiVar2 = this.zzb.zzf;
                zzbiVar2.zza(zzbh.zza(73, 16, zzbk.zzj));
                this.zza.onAlternativeBillingOnlyInformationDialogResponse(zzbk.zzj);
                return;
            }
            newBuilder.setDebugMessage(com.google.android.gms.internal.play_billing.zzb.zzg(bundle, "BillingClient"));
            int i2 = bundle.getInt("INTERNAL_LOG_ERROR_REASON");
            zzbiVar = this.zzb.zzf;
            int zza = i2 != 0 ? zzih.zza(i2) : 23;
            BillingResult build = newBuilder.build();
            String string = bundle.getString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS");
            try {
                zzie zzv = zzii.zzv();
                zzv.zzk(build.getResponseCode());
                zzv.zzj(build.getDebugMessage());
                zzv.zzl(zza);
                if (string != null) {
                    zzv.zzi(string);
                }
                zzhx zzv2 = zzhy.zzv();
                zzv2.zzi(zzv);
                zzv2.zzk(16);
                zzhyVar = (zzhy) zzv2.zzc();
            } catch (Exception e) {
                com.google.android.gms.internal.play_billing.zzb.zzl("BillingLogger", "Unable to create logging payload", e);
                zzhyVar = null;
            }
            zzbiVar.zza(zzhyVar);
        }
        this.zza.onAlternativeBillingOnlyInformationDialogResponse(newBuilder.build());
    }
}
