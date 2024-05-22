package com.revenuecat.purchases.hybridcommon.mappers;

import android.net.Uri;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.revenuecat.purchases.models.Transaction;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomerInfoMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"map", "", "", "", "Lcom/revenuecat/purchases/CustomerInfo;", "hybridcommon_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class CustomerInfoMapperKt {
    public static final Map<String, Object> map(CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "<this>");
        Pair[] pairArr = new Pair[19];
        pairArr[0] = TuplesKt.to(CustomerInfoResponseJsonKeys.ENTITLEMENTS, EntitlementInfosMapperKt.map(customerInfo.getEntitlements()));
        pairArr[1] = TuplesKt.to("activeSubscriptions", CollectionsKt.toList(customerInfo.getActiveSubscriptions()));
        pairArr[2] = TuplesKt.to("allPurchasedProductIdentifiers", CollectionsKt.toList(customerInfo.getAllPurchasedProductIds()));
        Date latestExpirationDate = customerInfo.getLatestExpirationDate();
        pairArr[3] = TuplesKt.to("latestExpirationDate", latestExpirationDate != null ? MappersHelpersKt.toIso8601(latestExpirationDate) : null);
        Date latestExpirationDate2 = customerInfo.getLatestExpirationDate();
        pairArr[4] = TuplesKt.to("latestExpirationDateMillis", latestExpirationDate2 != null ? Long.valueOf(MappersHelpersKt.toMillis(latestExpirationDate2)) : null);
        pairArr[5] = TuplesKt.to("firstSeen", MappersHelpersKt.toIso8601(customerInfo.getFirstSeen()));
        pairArr[6] = TuplesKt.to("firstSeenMillis", Long.valueOf(MappersHelpersKt.toMillis(customerInfo.getFirstSeen())));
        pairArr[7] = TuplesKt.to("originalAppUserId", customerInfo.getOriginalAppUserId());
        pairArr[8] = TuplesKt.to("requestDate", MappersHelpersKt.toIso8601(customerInfo.getRequestDate()));
        pairArr[9] = TuplesKt.to("requestDateMillis", Long.valueOf(MappersHelpersKt.toMillis(customerInfo.getRequestDate())));
        Map<String, Date> allExpirationDatesByProduct = customerInfo.getAllExpirationDatesByProduct();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(allExpirationDatesByProduct.size()));
        Iterator<T> it = allExpirationDatesByProduct.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Date date = (Date) entry.getValue();
            linkedHashMap.put(key, date != null ? MappersHelpersKt.toIso8601(date) : null);
        }
        pairArr[10] = TuplesKt.to("allExpirationDates", linkedHashMap);
        Map<String, Date> allExpirationDatesByProduct2 = customerInfo.getAllExpirationDatesByProduct();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(allExpirationDatesByProduct2.size()));
        Iterator<T> it2 = allExpirationDatesByProduct2.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            Object key2 = entry2.getKey();
            Date date2 = (Date) entry2.getValue();
            linkedHashMap2.put(key2, date2 != null ? Long.valueOf(MappersHelpersKt.toMillis(date2)) : null);
        }
        pairArr[11] = TuplesKt.to("allExpirationDatesMillis", linkedHashMap2);
        Map<String, Date> allPurchaseDatesByProduct = customerInfo.getAllPurchaseDatesByProduct();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(allPurchaseDatesByProduct.size()));
        Iterator<T> it3 = allPurchaseDatesByProduct.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it3.next();
            Object key3 = entry3.getKey();
            Date date3 = (Date) entry3.getValue();
            linkedHashMap3.put(key3, date3 != null ? MappersHelpersKt.toIso8601(date3) : null);
        }
        pairArr[12] = TuplesKt.to("allPurchaseDates", linkedHashMap3);
        Map<String, Date> allPurchaseDatesByProduct2 = customerInfo.getAllPurchaseDatesByProduct();
        LinkedHashMap linkedHashMap4 = new LinkedHashMap(MapsKt.mapCapacity(allPurchaseDatesByProduct2.size()));
        Iterator<T> it4 = allPurchaseDatesByProduct2.entrySet().iterator();
        while (it4.hasNext()) {
            Map.Entry entry4 = (Map.Entry) it4.next();
            Object key4 = entry4.getKey();
            Date date4 = (Date) entry4.getValue();
            linkedHashMap4.put(key4, date4 != null ? Long.valueOf(MappersHelpersKt.toMillis(date4)) : null);
        }
        pairArr[13] = TuplesKt.to("allPurchaseDatesMillis", linkedHashMap4);
        pairArr[14] = TuplesKt.to("originalApplicationVersion", null);
        Uri managementURL = customerInfo.getManagementURL();
        pairArr[15] = TuplesKt.to("managementURL", managementURL != null ? managementURL.toString() : null);
        Date originalPurchaseDate = customerInfo.getOriginalPurchaseDate();
        pairArr[16] = TuplesKt.to("originalPurchaseDate", originalPurchaseDate != null ? MappersHelpersKt.toIso8601(originalPurchaseDate) : null);
        Date originalPurchaseDate2 = customerInfo.getOriginalPurchaseDate();
        pairArr[17] = TuplesKt.to("originalPurchaseDateMillis", originalPurchaseDate2 != null ? Long.valueOf(MappersHelpersKt.toMillis(originalPurchaseDate2)) : null);
        List<Transaction> nonSubscriptionTransactions = customerInfo.getNonSubscriptionTransactions();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(nonSubscriptionTransactions, 10));
        Iterator<T> it5 = nonSubscriptionTransactions.iterator();
        while (it5.hasNext()) {
            arrayList.add(TransactionMapperKt.map((Transaction) it5.next()));
        }
        pairArr[18] = TuplesKt.to("nonSubscriptionTransactions", arrayList);
        return MapsKt.mapOf(pairArr);
    }
}
