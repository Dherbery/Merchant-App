package com.android.billingclient.api;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes.dex */
public final class AlternativeBillingOnlyReportingDetails {
    private final String zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlternativeBillingOnlyReportingDetails(String str) throws JSONException {
        this.zza = new JSONObject(str).optString("externalTransactionToken");
    }

    public String getExternalTransactionToken() {
        return this.zza;
    }
}
