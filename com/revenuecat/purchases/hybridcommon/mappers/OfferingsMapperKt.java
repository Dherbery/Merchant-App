package com.revenuecat.purchases.hybridcommon.mappers;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Package;
import java.util.ArrayList;
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

/* compiled from: OfferingsMapper.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\u0002\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0005\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0006¨\u0006\u0007"}, d2 = {"map", "", "", "", "Lcom/revenuecat/purchases/Offering;", "Lcom/revenuecat/purchases/Offerings;", "Lcom/revenuecat/purchases/Package;", "hybridcommon_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class OfferingsMapperKt {
    public static final Map<String, Object> map(Offerings offerings) {
        Intrinsics.checkNotNullParameter(offerings, "<this>");
        Pair[] pairArr = new Pair[2];
        Map<String, Offering> all = offerings.getAll();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(all.size()));
        Iterator<T> it = all.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), map((Offering) entry.getValue()));
        }
        pairArr[0] = TuplesKt.to(TtmlNode.COMBINE_ALL, linkedHashMap);
        Offering current = offerings.getCurrent();
        pairArr[1] = TuplesKt.to("current", current != null ? map(current) : null);
        return MapsKt.mapOf(pairArr);
    }

    private static final Map<String, Object> map(Offering offering) {
        Pair[] pairArr = new Pair[11];
        pairArr[0] = TuplesKt.to("identifier", offering.getIdentifier());
        pairArr[1] = TuplesKt.to("serverDescription", offering.getServerDescription());
        pairArr[2] = TuplesKt.to(TtmlNode.TAG_METADATA, offering.getMetadata());
        List<Package> availablePackages = offering.getAvailablePackages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(availablePackages, 10));
        Iterator<T> it = availablePackages.iterator();
        while (it.hasNext()) {
            arrayList.add(map((Package) it.next()));
        }
        pairArr[3] = TuplesKt.to("availablePackages", arrayList);
        Package lifetime = offering.getLifetime();
        pairArr[4] = TuplesKt.to("lifetime", lifetime != null ? map(lifetime) : null);
        Package annual = offering.getAnnual();
        pairArr[5] = TuplesKt.to("annual", annual != null ? map(annual) : null);
        Package sixMonth = offering.getSixMonth();
        pairArr[6] = TuplesKt.to("sixMonth", sixMonth != null ? map(sixMonth) : null);
        Package threeMonth = offering.getThreeMonth();
        pairArr[7] = TuplesKt.to("threeMonth", threeMonth != null ? map(threeMonth) : null);
        Package twoMonth = offering.getTwoMonth();
        pairArr[8] = TuplesKt.to("twoMonth", twoMonth != null ? map(twoMonth) : null);
        Package monthly = offering.getMonthly();
        pairArr[9] = TuplesKt.to("monthly", monthly != null ? map(monthly) : null);
        Package weekly = offering.getWeekly();
        pairArr[10] = TuplesKt.to("weekly", weekly != null ? map(weekly) : null);
        return MapsKt.mapOf(pairArr);
    }

    public static final Map<String, Object> map(Package r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return MapsKt.mapOf(TuplesKt.to("identifier", r3.getIdentifier()), TuplesKt.to("packageType", r3.getPackageType().name()), TuplesKt.to("product", StoreProductMapperKt.map(r3.getProduct())), TuplesKt.to("offeringIdentifier", r3.getOffering()));
    }
}
