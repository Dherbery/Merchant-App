package com.revenuecat.purchases.hybridcommon.mappers;

import com.revenuecat.purchases.utils.Iso8601Utils;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: mappersHelpers.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\f\u0012\u0004\u0012\u00020\u0001\u0012\u0002\b\u00030\u0007\u001a\u000e\u0010\b\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\n\u001a\u0018\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007*\u00020\u0006\u001a\f\u0010\f\u001a\u00020\u0001*\u00020\rH\u0000\u001a\f\u0010\u000e\u001a\u00020\u0004*\u00020\rH\u0000¨\u0006\u000f"}, d2 = {"formatUsingDeviceLocale", "", "priceCurrencyCode", "number", "", "convertToJson", "Lorg/json/JSONObject;", "", "convertToJsonArray", "Lorg/json/JSONArray;", "", "convertToMap", "toIso8601", "Ljava/util/Date;", "toMillis", "hybridcommon_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class MappersHelpersKt {
    public static final JSONObject convertToJson(Map<String, ?> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                jSONObject.put(key, JSONObject.NULL);
            } else if (value instanceof Map) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
                jSONObject.put(key, convertToJson((Map) value));
            } else if (value instanceof List) {
                jSONObject.put(key, convertToJsonArray((List) value));
            } else if (value instanceof Object[]) {
                jSONObject.put(key, convertToJsonArray(ArraysKt.toList((Object[]) value)));
            } else {
                jSONObject.put(key, value);
            }
        }
        return jSONObject;
    }

    public static final JSONArray convertToJsonArray(List<?> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        JSONArray jSONArray = new JSONArray();
        for (Object obj : list) {
            if (obj == null) {
                jSONArray.put(JSONObject.NULL);
            } else if (obj instanceof Map) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
                jSONArray.put(convertToJson((Map) obj));
            } else if (obj instanceof Object[]) {
                jSONArray.put(convertToJsonArray(ArraysKt.asList((Object[]) obj)));
            } else if (obj instanceof List) {
                jSONArray.put(convertToJsonArray((List) obj));
            } else {
                jSONArray.put(obj);
            }
        }
        return jSONArray;
    }

    public static final Map<String, String> convertToMap(JSONObject jSONObject) {
        Pair pair;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "this.keys()");
        Sequence<String> asSequence = SequencesKt.asSequence(keys);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : asSequence) {
            if (jSONObject.isNull(str)) {
                pair = TuplesKt.to(str, null);
            } else {
                pair = TuplesKt.to(str, jSONObject.getString(str));
            }
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    public static final long toMillis(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        return date.getTime();
    }

    public static final String toIso8601(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        String format = Iso8601Utils.format(date);
        Intrinsics.checkNotNullExpressionValue(format, "format(this)");
        return format;
    }

    public static final String formatUsingDeviceLocale(String priceCurrencyCode, long j) {
        Intrinsics.checkNotNullParameter(priceCurrencyCode, "priceCurrencyCode");
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        currencyInstance.setCurrency(Currency.getInstance(priceCurrencyCode));
        String format = currencyInstance.format(j);
        Intrinsics.checkNotNullExpressionValue(format, "getCurrencyInstance().ap…ode)\n    }.format(number)");
        return format;
    }
}
