package com.onesignal.common;

import android.os.Bundle;
import com.onesignal.core.BuildConfig;
import com.onesignal.debug.internal.logging.Logging;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JSONUtils.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0004J\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0012\u001a\u00020\u0006J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\u0015\u001a\u00020\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0017\u001a\u00020\u0001J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0006J\u0010\u0010\u001a\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/onesignal/common/JSONUtils;", "", "()V", "EXTERNAL_USER_ID", "", "bundleAsJSONObject", "Lorg/json/JSONObject;", "bundle", "Landroid/os/Bundle;", "compareJSONArrays", "", "jsonArray1", "Lorg/json/JSONArray;", "jsonArray2", "jsonStringToBundle", "data", "newStringMapFromJSONObject", "", "jsonObject", "newStringSetFromJSONArray", "", "jsonArray", "normalizeType", "object", "toUnescapedEUIDString", "json", "wrapInJsonArray", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class JSONUtils {
    public static final String EXTERNAL_USER_ID = "external_user_id";
    public static final JSONUtils INSTANCE = new JSONUtils();

    private JSONUtils() {
    }

    public final JSONArray wrapInJsonArray(JSONObject jsonObject) {
        JSONArray put = new JSONArray().put(jsonObject);
        Intrinsics.checkNotNullExpressionValue(put, "JSONArray().put(jsonObject)");
        return put;
    }

    public final JSONObject bundleAsJSONObject(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                jSONObject.put(str, bundle.get(str));
            } catch (JSONException e) {
                Logging.error("bundleAsJSONObject error for key: " + str, e);
            }
        }
        return jSONObject;
    }

    public final Bundle jsonStringToBundle(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            JSONObject jSONObject = new JSONObject(data);
            Bundle bundle = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
                String str = next;
                bundle.putString(str, jSONObject.getString(str));
            }
            return bundle;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final Map<String, String> newStringMapFromJSONObject(JSONObject jsonObject) {
        Object opt;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Iterator<String> keys = jsonObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                opt = jsonObject.opt(next);
            } catch (Throwable unused) {
            }
            if (!(opt instanceof JSONArray) && !(opt instanceof JSONObject)) {
                if (!jsonObject.isNull(next) && !Intrinsics.areEqual("", opt)) {
                    linkedHashMap.put(next, opt.toString());
                }
                linkedHashMap.put(next, "");
            }
            Logging.error$default("Omitting key '" + next + "'! sendTags DO NOT supported nested values!", null, 2, null);
        }
        return linkedHashMap;
    }

    public final Set<String> newStringSetFromJSONArray(JSONArray jsonArray) {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            String string = jsonArray.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
            linkedHashSet.add(string);
        }
        return linkedHashSet;
    }

    public final String toUnescapedEUIDString(JSONObject json) {
        String group;
        Intrinsics.checkNotNullParameter(json, "json");
        String jSONObject = json.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "json.toString()");
        if (!json.has(EXTERNAL_USER_ID)) {
            return jSONObject;
        }
        Matcher matcher = Pattern.compile("(?<=\"external_user_id\":\").*?(?=\")").matcher(jSONObject);
        if (!matcher.find() || (group = matcher.group(0)) == null) {
            return jSONObject;
        }
        String replaceAll = matcher.replaceAll(Matcher.quoteReplacement(StringsKt.replace$default(group, "\\/", "/", false, 4, (Object) null)));
        Intrinsics.checkNotNullExpressionValue(replaceAll, "eidMatcher.replaceAll(unescapedEID)");
        return replaceAll;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
    
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean compareJSONArrays(org.json.JSONArray r10, org.json.JSONArray r11) {
        /*
            r9 = this;
            r0 = 1
            if (r10 != 0) goto L6
            if (r11 != 0) goto L6
            return r0
        L6:
            r1 = 0
            if (r10 == 0) goto L51
            if (r11 != 0) goto Lc
            goto L51
        Lc:
            int r2 = r10.length()
            int r3 = r11.length()
            if (r2 == r3) goto L17
            return r1
        L17:
            int r2 = r10.length()     // Catch: org.json.JSONException -> L4d
            r3 = r1
        L1c:
            if (r3 >= r2) goto L4c
            int r4 = r11.length()     // Catch: org.json.JSONException -> L4d
            r5 = r1
        L23:
            if (r5 >= r4) goto L4b
            java.lang.Object r6 = r10.get(r3)     // Catch: org.json.JSONException -> L4d
            java.lang.String r7 = "jsonArray1[i]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch: org.json.JSONException -> L4d
            java.lang.Object r6 = r9.normalizeType(r6)     // Catch: org.json.JSONException -> L4d
            java.lang.Object r7 = r11.get(r5)     // Catch: org.json.JSONException -> L4d
            java.lang.String r8 = "jsonArray2[j]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)     // Catch: org.json.JSONException -> L4d
            java.lang.Object r7 = r9.normalizeType(r7)     // Catch: org.json.JSONException -> L4d
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)     // Catch: org.json.JSONException -> L4d
            if (r6 != 0) goto L48
            int r5 = r5 + 1
            goto L23
        L48:
            int r3 = r3 + 1
            goto L1c
        L4b:
            return r1
        L4c:
            return r0
        L4d:
            r10 = move-exception
            r10.printStackTrace()
        L51:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.common.JSONUtils.compareJSONArrays(org.json.JSONArray, org.json.JSONArray):boolean");
    }

    public final Object normalizeType(Object object) {
        Intrinsics.checkNotNullParameter(object, "object");
        Class<?> cls = object.getClass();
        if (Intrinsics.areEqual(cls, Integer.TYPE)) {
            return Long.valueOf(((Integer) object).intValue());
        }
        return Intrinsics.areEqual(cls, Float.TYPE) ? Double.valueOf(((Float) object).floatValue()) : object;
    }
}
