package com.amazon.device.iap.internal.c;

import com.amazon.device.iap.model.Promotion;
import com.amazon.device.iap.model.PromotionPlan;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PromotionsDataParser.java */
/* loaded from: classes.dex */
final class a {
    a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Promotion> a(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray(com.amazon.a.a.o.b.q);
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(b(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    private static Promotion b(JSONObject jSONObject) throws JSONException {
        return new Promotion(jSONObject.getString(com.amazon.a.a.o.b.r), a(jSONObject.getJSONArray(com.amazon.a.a.o.b.s)));
    }

    private static List<PromotionPlan> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(c(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    private static PromotionPlan c(JSONObject jSONObject) throws JSONException {
        String str;
        String string = jSONObject.getString(com.amazon.a.a.o.b.t);
        int i = jSONObject.getInt(com.amazon.a.a.o.b.u);
        JSONObject optJSONObject = jSONObject.optJSONObject(com.amazon.a.a.o.b.w);
        if (optJSONObject == null || optJSONObject == JSONObject.NULL) {
            str = null;
        } else {
            Currency currency = Currency.getInstance(optJSONObject.optString(com.amazon.a.a.o.b.a));
            str = currency.getSymbol() + optJSONObject.optString("value");
        }
        return new PromotionPlan(string, str, i);
    }
}
