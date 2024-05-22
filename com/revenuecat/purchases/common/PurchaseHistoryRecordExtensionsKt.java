package com.revenuecat.purchases.common;

import com.android.billingclient.api.PurchaseHistoryRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: purchaseHistoryRecordExtensions.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\u0002H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"firstSku", "", "Lcom/android/billingclient/api/PurchaseHistoryRecord;", "getFirstSku", "(Lcom/android/billingclient/api/PurchaseHistoryRecord;)Ljava/lang/String;", "listOfSkus", "Ljava/util/ArrayList;", "getListOfSkus", "(Lcom/android/billingclient/api/PurchaseHistoryRecord;)Ljava/util/ArrayList;", "toHumanReadableDescription", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PurchaseHistoryRecordExtensionsKt {
    public static final String toHumanReadableDescription(PurchaseHistoryRecord purchaseHistoryRecord) {
        Intrinsics.checkNotNullParameter(purchaseHistoryRecord, "<this>");
        StringBuilder sb = new StringBuilder("skus: ");
        ArrayList<String> skus = purchaseHistoryRecord.getSkus();
        Intrinsics.checkNotNullExpressionValue(skus, "this.skus");
        sb.append(CollectionsKt.joinToString$default(skus, null, "[", "]", 0, null, null, 57, null));
        sb.append(", purchaseTime: ");
        sb.append(purchaseHistoryRecord.getPurchaseTime());
        sb.append(", purchaseToken: ");
        sb.append(purchaseHistoryRecord.getPurchaseToken());
        return sb.toString();
    }

    public static final String getFirstSku(PurchaseHistoryRecord purchaseHistoryRecord) {
        Intrinsics.checkNotNullParameter(purchaseHistoryRecord, "<this>");
        String str = purchaseHistoryRecord.getSkus().get(0);
        String str2 = str;
        if (purchaseHistoryRecord.getSkus().size() > 1) {
            LogWrapperKt.log(LogIntent.GOOGLE_WARNING, "There's more than one sku in the PurchaseHistoryRecord, but only one will be used.");
        }
        Intrinsics.checkNotNullExpressionValue(str, "skus[0].also {\n        i…_ONE_SKU)\n        }\n    }");
        return str2;
    }

    public static final ArrayList<String> getListOfSkus(PurchaseHistoryRecord purchaseHistoryRecord) {
        Intrinsics.checkNotNullParameter(purchaseHistoryRecord, "<this>");
        ArrayList<String> skus = purchaseHistoryRecord.getSkus();
        Intrinsics.checkNotNullExpressionValue(skus, "this.skus");
        return skus;
    }
}
