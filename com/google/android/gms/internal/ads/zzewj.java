package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzewj implements zzexp {
    private final String zza;
    private final String zzb;

    public zzewj(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzexp
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgW)).booleanValue()) {
            bundle.putString(ProxyAmazonBillingActivity.EXTRAS_REQUEST_ID, this.zzb);
        } else {
            bundle.putString(ProxyAmazonBillingActivity.EXTRAS_REQUEST_ID, this.zza);
        }
    }
}
