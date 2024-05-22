package com.amazon.device.iap.internal.a.a;

import com.amazon.a.a.o.f;
import com.amazon.device.iap.model.Promotion;
import com.amazon.device.iap.model.PromotionPlan;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PromotionsDataParser.java */
/* loaded from: classes.dex */
final class e {
    e() {
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
        JSONObject jSONObject2;
        String string = jSONObject.getString(com.amazon.a.a.o.b.t);
        int i = jSONObject.getInt(com.amazon.a.a.o.b.u);
        String optString = jSONObject.optString(com.amazon.a.a.o.b.v);
        if (f.a(optString) && (jSONObject2 = jSONObject.getJSONObject(com.amazon.a.a.o.b.w)) != null) {
            Currency currency = Currency.getInstance(jSONObject2.getString(com.amazon.a.a.o.b.a));
            optString = currency.getSymbol() + new BigDecimal(jSONObject2.getString("value"));
        }
        return new PromotionPlan(string, optString, i);
    }
}
