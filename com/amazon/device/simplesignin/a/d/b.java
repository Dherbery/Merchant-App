package com.amazon.device.simplesignin.a.d;

import com.amazon.device.simplesignin.model.Link;
import com.amazon.device.simplesignin.model.Token;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ResponseModelGenerator.java */
/* loaded from: classes.dex */
public final class b {
    private static final String a = "b";

    private b() {
    }

    public static List<Link> a(String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray(str2);
            if (jSONArray.length() == 0) {
                a.a(a, "No links available, links object received is empty.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    arrayList.add(a(str, (JSONObject) jSONArray.get(i)));
                } catch (JSONException e) {
                    a.b(a, "Failure generating Link object from response." + e);
                    return null;
                }
            }
            return arrayList;
        } catch (JSONException e2) {
            a.b(a, "Failure generating Link object from Kiwi response." + e2);
            return null;
        }
    }

    public static Link a(String str, JSONObject jSONObject) throws JSONException {
        Link link = new Link();
        link.setAmazonUserId(str);
        link.setIdentityProviderName(jSONObject.getString(com.amazon.device.simplesignin.a.a.a.u));
        link.setLinkId(jSONObject.getString(com.amazon.device.simplesignin.a.a.a.t));
        link.setPartnerUserId(jSONObject.getString(com.amazon.device.simplesignin.a.a.a.v));
        link.setLinkedTimestamp(jSONObject.getLong(com.amazon.device.simplesignin.a.a.a.x));
        Token token = new Token();
        JSONObject jSONObject2 = new JSONObject(jSONObject.getString(com.amazon.device.simplesignin.a.a.a.y));
        token.setToken(jSONObject2.getString("token"));
        token.setSchema(jSONObject2.getString(com.amazon.device.simplesignin.a.a.a.A));
        link.setSsiToken(token);
        return link;
    }

    public static Link a(String str) {
        try {
            return a((String) null, new JSONObject(str));
        } catch (JSONException e) {
            a.b(a, "Failure generating Link object from response." + e);
            return null;
        }
    }
}
