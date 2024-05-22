package com.revenuecat.purchases.subscriberattributes.caching;

import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.strings.AttributionStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttribute;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesFactoriesKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: SubscriberAttributesCache.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u0012\u0010\u0010\u001a\u00020\u000e2\n\u0010\u0011\u001a\u00060\bj\u0002`\u0012J\u0012\u0010\u0013\u001a\u00020\u000e2\n\u0010\u0011\u001a\u00060\bj\u0002`\u0012J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0002J*\u0010\u0015\u001a&\u0012\b\u0012\u00060\bj\u0002`\u0012\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0016j\u0002`\u00180\u0016j\u0002`\u0019J\"\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0016j\u0002`\u00182\n\u0010\u0011\u001a\u00060\bj\u0002`\u0012J*\u0010\u001a\u001a&\u0012\b\u0012\u00060\bj\u0002`\u0012\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0016j\u0002`\u00180\u0016j\u0002`\u0019J\u001e\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0016j\u0002`\u00182\u0006\u0010\u0011\u001a\u00020\bJ*\u0010\u001b\u001a\u00020\u000e2\n\u0010\u0011\u001a\u00060\bj\u0002`\u00122\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0016j\u0002`\u0018J8\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0016j\u0002`\u0018*\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0016j\u0002`\u00182\n\u0010\u0011\u001a\u00060\bj\u0002`\u0012H\u0002J=\u0010\u001e\u001a\u00020\u000e*\u00020\u00032*\u0010\u001f\u001a&\u0012\b\u0012\u00060\bj\u0002`\u0012\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0016j\u0002`\u00180\u0016j\u0002`\u0019H\u0000¢\u0006\u0002\b R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006!"}, d2 = {"Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;", "", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "(Lcom/revenuecat/purchases/common/caching/DeviceCache;)V", "getDeviceCache$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/common/caching/DeviceCache;", "subscriberAttributesCacheKey", "", "getSubscriberAttributesCacheKey$purchases_defaultsRelease", "()Ljava/lang/String;", "subscriberAttributesCacheKey$delegate", "Lkotlin/Lazy;", "cleanUpSubscriberAttributeCache", "", "currentAppUserID", "clearAllSubscriberAttributesFromUser", "appUserID", "Lcom/revenuecat/purchases/subscriberattributes/caching/AppUserID;", "clearSubscriberAttributesIfSyncedForSubscriber", "deleteSyncedSubscriberAttributesForOtherUsers", "getAllStoredSubscriberAttributes", "", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributeMap;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesPerAppUserIDMap;", "getUnsyncedSubscriberAttributes", "setAttributes", "attributesToBeSet", "filterUnsynced", "putAttributes", "updatedSubscriberAttributesForAll", "putAttributes$purchases_defaultsRelease", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriberAttributesCache {
    private final DeviceCache deviceCache;

    /* renamed from: subscriberAttributesCacheKey$delegate, reason: from kotlin metadata */
    private final Lazy subscriberAttributesCacheKey;

    public SubscriberAttributesCache(DeviceCache deviceCache) {
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        this.deviceCache = deviceCache;
        this.subscriberAttributesCacheKey = LazyKt.lazy(new Function0<String>() { // from class: com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache$subscriberAttributesCacheKey$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return SubscriberAttributesCache.this.getDeviceCache().newKey("subscriberAttributes");
            }
        });
    }

    /* renamed from: getDeviceCache$purchases_defaultsRelease, reason: from getter */
    public final DeviceCache getDeviceCache() {
        return this.deviceCache;
    }

    public final String getSubscriberAttributesCacheKey$purchases_defaultsRelease() {
        return (String) this.subscriberAttributesCacheKey.getValue();
    }

    public final synchronized void setAttributes(String appUserID, Map<String, SubscriberAttribute> attributesToBeSet) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(attributesToBeSet, "attributesToBeSet");
        Map<String, Map<String, SubscriberAttribute>> allStoredSubscriberAttributes = getAllStoredSubscriberAttributes();
        Map<String, SubscriberAttribute> map = allStoredSubscriberAttributes.get(appUserID);
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        putAttributes$purchases_defaultsRelease(this.deviceCache, MapsKt.plus(allStoredSubscriberAttributes, MapsKt.mapOf(TuplesKt.to(appUserID, MapsKt.plus(map, attributesToBeSet)))));
    }

    public final synchronized Map<String, Map<String, SubscriberAttribute>> getAllStoredSubscriberAttributes() {
        Map<String, Map<String, SubscriberAttribute>> emptyMap;
        JSONObject jSONObjectOrNull = this.deviceCache.getJSONObjectOrNull(getSubscriberAttributesCacheKey$purchases_defaultsRelease());
        if (jSONObjectOrNull == null || (emptyMap = SubscriberAttributesFactoriesKt.buildSubscriberAttributesMapPerUser(jSONObjectOrNull)) == null) {
            emptyMap = MapsKt.emptyMap();
        }
        return emptyMap;
    }

    public final synchronized Map<String, SubscriberAttribute> getAllStoredSubscriberAttributes(String appUserID) {
        Map<String, SubscriberAttribute> map;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        map = getAllStoredSubscriberAttributes().get(appUserID);
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        return map;
    }

    public final synchronized Map<String, Map<String, SubscriberAttribute>> getUnsyncedSubscriberAttributes() {
        LinkedHashMap linkedHashMap;
        Map<String, Map<String, SubscriberAttribute>> allStoredSubscriberAttributes = getAllStoredSubscriberAttributes();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(allStoredSubscriberAttributes.size()));
        for (Object obj : allStoredSubscriberAttributes.entrySet()) {
            Object key = ((Map.Entry) obj).getKey();
            Map.Entry entry = (Map.Entry) obj;
            linkedHashMap2.put(key, filterUnsynced((Map) entry.getValue(), (String) entry.getKey()));
        }
        linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            if (!((Map) entry2.getValue()).isEmpty()) {
                linkedHashMap.put(entry2.getKey(), entry2.getValue());
            }
        }
        return linkedHashMap;
    }

    public final synchronized Map<String, SubscriberAttribute> getUnsyncedSubscriberAttributes(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        return filterUnsynced(getAllStoredSubscriberAttributes(appUserID), appUserID);
    }

    public final synchronized void clearAllSubscriberAttributesFromUser(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.DELETING_ATTRIBUTES, Arrays.copyOf(new Object[]{appUserID}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        Map mutableMap = MapsKt.toMutableMap(getAllStoredSubscriberAttributes());
        mutableMap.remove(appUserID);
        putAttributes$purchases_defaultsRelease(this.deviceCache, MapsKt.toMap(mutableMap));
    }

    public final synchronized void clearSubscriberAttributesIfSyncedForSubscriber(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        if (getUnsyncedSubscriberAttributes(appUserID).isEmpty()) {
            clearAllSubscriberAttributesFromUser(appUserID);
        }
    }

    public final synchronized void cleanUpSubscriberAttributeCache(String currentAppUserID) {
        Intrinsics.checkNotNullParameter(currentAppUserID, "currentAppUserID");
        SubscriberAttributesMigrationExtensionsKt.migrateSubscriberAttributesIfNeeded(this);
        deleteSyncedSubscriberAttributesForOtherUsers(currentAppUserID);
    }

    public final void putAttributes$purchases_defaultsRelease(DeviceCache deviceCache, Map<String, ? extends Map<String, SubscriberAttribute>> updatedSubscriberAttributesForAll) {
        Intrinsics.checkNotNullParameter(deviceCache, "<this>");
        Intrinsics.checkNotNullParameter(updatedSubscriberAttributesForAll, "updatedSubscriberAttributesForAll");
        DeviceCache deviceCache2 = this.deviceCache;
        String subscriberAttributesCacheKey$purchases_defaultsRelease = getSubscriberAttributesCacheKey$purchases_defaultsRelease();
        String jSONObject = CachingHelpersKt.toJSONObject(updatedSubscriberAttributesForAll).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "updatedSubscriberAttribu…toJSONObject().toString()");
        deviceCache2.putString(subscriberAttributesCacheKey$purchases_defaultsRelease, jSONObject);
    }

    private final synchronized void deleteSyncedSubscriberAttributesForOtherUsers(String currentAppUserID) {
        Pair pair;
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.DELETING_ATTRIBUTES_OTHER_USERS, Arrays.copyOf(new Object[]{currentAppUserID}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        Map<String, Map<String, SubscriberAttribute>> allStoredSubscriberAttributes = getAllStoredSubscriberAttributes();
        ArrayList arrayList = new ArrayList(allStoredSubscriberAttributes.size());
        for (Map.Entry<String, Map<String, SubscriberAttribute>> entry : allStoredSubscriberAttributes.entrySet()) {
            String key = entry.getKey();
            Map<String, SubscriberAttribute> value = entry.getValue();
            if (Intrinsics.areEqual(currentAppUserID, key)) {
                pair = TuplesKt.to(key, value);
            } else {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, SubscriberAttribute> entry2 : value.entrySet()) {
                    if (!entry2.getValue().isSynced()) {
                        linkedHashMap.put(entry2.getKey(), entry2.getValue());
                    }
                }
                pair = TuplesKt.to(key, linkedHashMap);
            }
            arrayList.add(pair);
        }
        Map map = MapsKt.toMap(arrayList);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry3 : map.entrySet()) {
            if (!((Map) entry3.getValue()).isEmpty()) {
                linkedHashMap2.put(entry3.getKey(), entry3.getValue());
            }
        }
        putAttributes$purchases_defaultsRelease(this.deviceCache, linkedHashMap2);
    }

    private final Map<String, SubscriberAttribute> filterUnsynced(Map<String, SubscriberAttribute> map, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, SubscriberAttribute> entry : map.entrySet()) {
            if (true ^ entry.getValue().isSynced()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        LogIntent logIntent = LogIntent.DEBUG;
        StringBuilder sb = new StringBuilder();
        String format = String.format(AttributionStrings.UNSYNCED_ATTRIBUTES_COUNT, Arrays.copyOf(new Object[]{Integer.valueOf(linkedHashMap2.size()), str}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        sb.append(format);
        sb.append(linkedHashMap2.isEmpty() ^ true ? CollectionsKt.joinToString$default(linkedHashMap2.values(), "\n", null, null, 0, null, null, 62, null) : "");
        LogWrapperKt.log(logIntent, sb.toString());
        return linkedHashMap2;
    }
}
