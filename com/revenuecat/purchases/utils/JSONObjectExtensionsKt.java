package com.revenuecat.purchases.utils;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JSONObjectExtensions.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0000\u001a\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0016\u0010\b\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0000\u001a*\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\n\"\u0004\b\u0000\u0010\u000b*\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0000¨\u0006\u000e"}, d2 = {"getDate", "Ljava/util/Date;", "Lorg/json/JSONObject;", "jsonKey", "", "getNullableString", "name", "optDate", "optNullableString", "toMap", "", "T", "deep", "", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class JSONObjectExtensionsKt {
    public static final Date getDate(JSONObject jSONObject, String jsonKey) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(jsonKey, "jsonKey");
        Date parse = Iso8601Utils.parse(jSONObject.getString(jsonKey));
        Intrinsics.checkNotNullExpressionValue(parse, "parse(getString(jsonKey))");
        return parse;
    }

    public static final Date optDate(JSONObject jSONObject, String jsonKey) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(jsonKey, "jsonKey");
        if (jSONObject.isNull(jsonKey)) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return getDate(jSONObject, jsonKey);
        }
        return null;
    }

    public static final String getNullableString(JSONObject jSONObject, String name) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (jSONObject.isNull(name)) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return jSONObject.getString(name);
        }
        return null;
    }

    public static final String optNullableString(JSONObject jSONObject, String name) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!jSONObject.has(name)) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return getNullableString(jSONObject, name);
        }
        return null;
    }

    public static /* synthetic */ Map toMap$default(JSONObject jSONObject, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return toMap(jSONObject, z);
    }

    public static final <T> Map<String, T> toMap(final JSONObject jSONObject, final boolean z) {
        Sequence asSequence;
        Sequence map;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Iterator<String> keys = jSONObject.keys();
        if (keys == null || (asSequence = SequencesKt.asSequence(keys)) == null || (map = SequencesKt.map(asSequence, new Function1<String, Pair<? extends String, ? extends T>>() { // from class: com.revenuecat.purchases.utils.JSONObjectExtensionsKt$toMap$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Pair<String, T> invoke(String str) {
                if (z) {
                    Object obj = jSONObject.get(str);
                    if (obj instanceof JSONObject) {
                        obj = JSONObjectExtensionsKt.toMap((JSONObject) obj, true);
                    } else if (obj instanceof JSONArray) {
                        obj = JSONArrayExtensionsKt.toList((JSONArray) obj);
                    }
                    return TuplesKt.to(str, obj);
                }
                return TuplesKt.to(str, jSONObject.get(str));
            }
        })) == null) {
            return null;
        }
        return MapsKt.toMap(map);
    }
}
