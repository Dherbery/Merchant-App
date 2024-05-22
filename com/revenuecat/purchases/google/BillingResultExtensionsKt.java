package com.revenuecat.purchases.google;

import com.android.billingclient.api.BillingResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: billingResultExtensions.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0000¨\u0006\u0005"}, d2 = {"isSuccessful", "", "Lcom/android/billingclient/api/BillingResult;", "toHumanReadableDescription", "", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class BillingResultExtensionsKt {
    public static final String toHumanReadableDescription(BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "<this>");
        return "DebugMessage: " + billingResult.getDebugMessage() + ". ErrorCode: " + ErrorsKt.getBillingResponseCodeName(billingResult.getResponseCode()) + '.';
    }

    public static final boolean isSuccessful(BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "<this>");
        return billingResult.getResponseCode() == 0;
    }
}
