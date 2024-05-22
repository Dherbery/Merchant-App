package com.revenuecat.purchases.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: JsonElementExtensions.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006*\u00020\u0002H\u0000\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"extractedContent", "", "Lkotlinx/serialization/json/JsonElement;", "getExtractedContent", "(Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "asMap", "", "", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class JsonElementExtensionsKt {
    public static final Map<String, Object> asMap(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "<this>");
        if (!(jsonElement instanceof JsonObject)) {
            return null;
        }
        Set<Map.Entry<String, JsonElement>> entrySet = JsonElementKt.getJsonObject(jsonElement).entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entrySet, 10)), 16));
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Pair pair = TuplesKt.to(entry.getKey(), getExtractedContent((JsonElement) entry.getValue()));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Float] */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.Map] */
    private static final Object getExtractedContent(JsonElement jsonElement) {
        Object linkedHashMap;
        if (jsonElement instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement);
            if (jsonPrimitive.getIsString()) {
                return jsonPrimitive.getContent();
            }
            linkedHashMap = JsonElementKt.getBooleanOrNull(jsonPrimitive);
            if (linkedHashMap == 0 && (linkedHashMap = JsonElementKt.getIntOrNull(jsonPrimitive)) == 0 && (linkedHashMap = JsonElementKt.getLongOrNull(jsonPrimitive)) == 0 && (linkedHashMap = JsonElementKt.getFloatOrNull(jsonPrimitive)) == 0 && (linkedHashMap = JsonElementKt.getDoubleOrNull(jsonPrimitive)) == 0) {
                return JsonElementKt.getContentOrNull(jsonPrimitive);
            }
        } else {
            if (jsonElement instanceof JsonArray) {
                JsonArray jsonArray = JsonElementKt.getJsonArray(jsonElement);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray, 10));
                Iterator<JsonElement> it = jsonArray.iterator();
                while (it.hasNext()) {
                    arrayList.add(getExtractedContent(it.next()));
                }
                return arrayList;
            }
            if (!(jsonElement instanceof JsonObject)) {
                return null;
            }
            Set<Map.Entry<String, JsonElement>> entrySet = JsonElementKt.getJsonObject(jsonElement).entrySet();
            linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entrySet, 10)), 16));
            Iterator it2 = entrySet.iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                Pair pair = TuplesKt.to(entry.getKey(), getExtractedContent((JsonElement) entry.getValue()));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
        }
        return linkedHashMap;
    }
}
