package com.revenuecat.purchases.google;

import com.android.billingclient.api.BillingFlowParams;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BillingFlowParamsExtensions.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"setUpgradeInfo", "", "Lcom/android/billingclient/api/BillingFlowParams$Builder;", "replaceProductInfo", "Lcom/revenuecat/purchases/common/ReplaceProductInfo;", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class BillingFlowParamsExtensionsKt {
    public static final void setUpgradeInfo(BillingFlowParams.Builder builder, ReplaceProductInfo replaceProductInfo) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(replaceProductInfo, "replaceProductInfo");
        BillingFlowParams.SubscriptionUpdateParams.Builder newBuilder = BillingFlowParams.SubscriptionUpdateParams.newBuilder();
        newBuilder.setOldPurchaseToken(replaceProductInfo.getOldPurchase().getPurchaseToken());
        ReplacementMode replacementMode = replaceProductInfo.getReplacementMode();
        if (replacementMode != null) {
            GoogleReplacementMode googleReplacementMode = replacementMode instanceof GoogleReplacementMode ? (GoogleReplacementMode) replacementMode : null;
            if (googleReplacementMode == null) {
                LogUtilsKt.errorLog$default("Got non-Google replacement mode", null, 2, null);
            } else {
                newBuilder.setSubscriptionReplacementMode(googleReplacementMode.getPlayBillingClientMode());
            }
        }
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder().apply {\n   …        }\n        }\n    }");
        builder.setSubscriptionUpdateParams(newBuilder.build());
    }
}
