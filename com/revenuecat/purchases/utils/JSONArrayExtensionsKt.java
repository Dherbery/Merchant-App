package com.revenuecat.purchases.utils;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JSONArrayExtensions.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"toList", "", "T", "Lorg/json/JSONArray;", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class JSONArrayExtensionsKt {
    public static final <T> List<T> toList(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONObject) {
                obj = JSONObjectExtensionsKt.toMap((JSONObject) obj, true);
            } else if (obj instanceof JSONArray) {
                obj = toList((JSONArray) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }
}
