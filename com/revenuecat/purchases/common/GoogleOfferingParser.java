package com.revenuecat.purchases.common;

import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: GoogleOfferingParser.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u00062\u0006\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/common/GoogleOfferingParser;", "Lcom/revenuecat/purchases/common/OfferingParser;", "()V", "findMatchingProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "productsById", "", "", "", "packageJson", "Lorg/json/JSONObject;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class GoogleOfferingParser extends OfferingParser {
    @Override // com.revenuecat.purchases.common.OfferingParser
    protected StoreProduct findMatchingProduct(Map<String, ? extends List<? extends StoreProduct>> productsById, JSONObject packageJson) {
        SubscriptionOption basePlan;
        Intrinsics.checkNotNullParameter(productsById, "productsById");
        Intrinsics.checkNotNullParameter(packageJson, "packageJson");
        String string = packageJson.getString("platform_product_identifier");
        String it = packageJson.optString("platform_product_plan_identifier");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        Object obj = null;
        if (!(it.length() > 0)) {
            it = null;
        }
        List<? extends StoreProduct> list = productsById.get(string);
        if (it == null) {
            if (!(list != null && list.size() == 1)) {
                list = null;
            }
            if (list == null) {
                return null;
            }
            if (!(list.get(0).getType() == ProductType.INAPP)) {
                list = null;
            }
            if (list != null) {
                return (StoreProduct) CollectionsKt.firstOrNull((List) list);
            }
            return null;
        }
        if (list == null) {
            return null;
        }
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            SubscriptionOptions subscriptionOptions = ((StoreProduct) next).getSubscriptionOptions();
            if (Intrinsics.areEqual((subscriptionOptions == null || (basePlan = subscriptionOptions.getBasePlan()) == null) ? null : basePlan.getId(), it)) {
                obj = next;
                break;
            }
        }
        return (StoreProduct) obj;
    }
}
