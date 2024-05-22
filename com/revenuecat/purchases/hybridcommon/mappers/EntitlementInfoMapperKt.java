package com.revenuecat.purchases.hybridcommon.mappers;

import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EntitlementInfoMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"map", "", "", "", "Lcom/revenuecat/purchases/EntitlementInfo;", "hybridcommon_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class EntitlementInfoMapperKt {
    public static final Map<String, Object> map(EntitlementInfo entitlementInfo) {
        Intrinsics.checkNotNullParameter(entitlementInfo, "<this>");
        Pair[] pairArr = new Pair[20];
        pairArr[0] = TuplesKt.to("identifier", entitlementInfo.getIdentifier());
        pairArr[1] = TuplesKt.to("isActive", Boolean.valueOf(entitlementInfo.isActive()));
        pairArr[2] = TuplesKt.to("willRenew", Boolean.valueOf(entitlementInfo.getWillRenew()));
        pairArr[3] = TuplesKt.to("periodType", entitlementInfo.getPeriodType().name());
        pairArr[4] = TuplesKt.to("latestPurchaseDateMillis", Long.valueOf(MappersHelpersKt.toMillis(entitlementInfo.getLatestPurchaseDate())));
        pairArr[5] = TuplesKt.to("latestPurchaseDate", MappersHelpersKt.toIso8601(entitlementInfo.getLatestPurchaseDate()));
        pairArr[6] = TuplesKt.to("originalPurchaseDateMillis", Long.valueOf(MappersHelpersKt.toMillis(entitlementInfo.getOriginalPurchaseDate())));
        pairArr[7] = TuplesKt.to("originalPurchaseDate", MappersHelpersKt.toIso8601(entitlementInfo.getOriginalPurchaseDate()));
        Date expirationDate = entitlementInfo.getExpirationDate();
        pairArr[8] = TuplesKt.to("expirationDateMillis", expirationDate != null ? Long.valueOf(MappersHelpersKt.toMillis(expirationDate)) : null);
        Date expirationDate2 = entitlementInfo.getExpirationDate();
        pairArr[9] = TuplesKt.to("expirationDate", expirationDate2 != null ? MappersHelpersKt.toIso8601(expirationDate2) : null);
        pairArr[10] = TuplesKt.to(ProductResponseJsonKeys.STORE, entitlementInfo.getStore().name());
        pairArr[11] = TuplesKt.to("productIdentifier", entitlementInfo.getProductIdentifier());
        pairArr[12] = TuplesKt.to("productPlanIdentifier", entitlementInfo.getProductPlanIdentifier());
        pairArr[13] = TuplesKt.to("isSandbox", Boolean.valueOf(entitlementInfo.isSandbox()));
        Date unsubscribeDetectedAt = entitlementInfo.getUnsubscribeDetectedAt();
        pairArr[14] = TuplesKt.to("unsubscribeDetectedAt", unsubscribeDetectedAt != null ? MappersHelpersKt.toIso8601(unsubscribeDetectedAt) : null);
        Date unsubscribeDetectedAt2 = entitlementInfo.getUnsubscribeDetectedAt();
        pairArr[15] = TuplesKt.to("unsubscribeDetectedAtMillis", unsubscribeDetectedAt2 != null ? Long.valueOf(MappersHelpersKt.toMillis(unsubscribeDetectedAt2)) : null);
        Date billingIssueDetectedAt = entitlementInfo.getBillingIssueDetectedAt();
        pairArr[16] = TuplesKt.to("billingIssueDetectedAt", billingIssueDetectedAt != null ? MappersHelpersKt.toIso8601(billingIssueDetectedAt) : null);
        Date billingIssueDetectedAt2 = entitlementInfo.getBillingIssueDetectedAt();
        pairArr[17] = TuplesKt.to("billingIssueDetectedAtMillis", billingIssueDetectedAt2 != null ? Long.valueOf(MappersHelpersKt.toMillis(billingIssueDetectedAt2)) : null);
        pairArr[18] = TuplesKt.to("ownershipType", entitlementInfo.getOwnershipType().name());
        pairArr[19] = TuplesKt.to("verification", entitlementInfo.getVerification().name());
        return MapsKt.mapOf(pairArr);
    }
}
