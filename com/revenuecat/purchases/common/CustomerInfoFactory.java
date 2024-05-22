package com.revenuecat.purchases.common;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CustomerInfoFactory.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ4\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000ej\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\n`\u0010*\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u001a\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0013*\u00020\bH\u0002J\u001a\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0013*\u00020\bH\u0002¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/common/CustomerInfoFactory;", "", "()V", "buildCustomerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "httpResult", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", TtmlNode.TAG_BODY, "Lorg/json/JSONObject;", "overrideRequestDate", "Ljava/util/Date;", "verificationResult", "Lcom/revenuecat/purchases/VerificationResult;", "parseDates", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "jsonKey", "parseExpirations", "", "parsePurchaseDates", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class CustomerInfoFactory {
    public static final CustomerInfoFactory INSTANCE = new CustomerInfoFactory();

    private CustomerInfoFactory() {
    }

    public final CustomerInfo buildCustomerInfo(HTTPResult httpResult) throws JSONException {
        Intrinsics.checkNotNullParameter(httpResult, "httpResult");
        return buildCustomerInfo(httpResult.getBody(), httpResult.getRequestDate(), httpResult.getVerificationResult());
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x008d, code lost:
    
        if (r5 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.revenuecat.purchases.CustomerInfo buildCustomerInfo(org.json.JSONObject r18, java.util.Date r19, com.revenuecat.purchases.VerificationResult r20) throws org.json.JSONException {
        /*
            r17 = this;
            r0 = r17
            r11 = r18
            r1 = r20
            java.lang.String r2 = "body"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r2)
            java.lang.String r2 = "verificationResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "subscriber"
            org.json.JSONObject r3 = r11.getJSONObject(r2)
            java.lang.String r4 = "non_subscriptions"
            org.json.JSONObject r4 = r3.getJSONObject(r4)
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            java.util.Iterator r6 = r4.keys()
            java.lang.String r7 = "nonSubscriptions.keys()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
        L2a:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L4a
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            org.json.JSONArray r8 = r4.getJSONArray(r7)
            int r9 = r8.length()
            if (r9 <= 0) goto L2a
            int r9 = r9 + (-1)
            org.json.JSONObject r8 = r8.getJSONObject(r9)
            r5.put(r7, r8)
            goto L2a
        L4a:
            java.lang.String r4 = "subscriptions"
            org.json.JSONObject r6 = r3.getJSONObject(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
            java.util.Map r4 = r0.parseExpirations(r6)
            java.util.Map r7 = r0.parsePurchaseDates(r6)
            java.util.Map r8 = r0.parsePurchaseDates(r5)
            java.util.Map r7 = kotlin.collections.MapsKt.plus(r7, r8)
            java.lang.String r8 = "entitlements"
            org.json.JSONObject r8 = r3.optJSONObject(r8)
            if (r19 != 0) goto L76
            java.lang.String r9 = "request_date"
            java.lang.String r9 = r11.getString(r9)
            java.util.Date r9 = com.revenuecat.purchases.utils.Iso8601Utils.parse(r9)
            goto L78
        L76:
            r9 = r19
        L78:
            java.lang.String r10 = "first_seen"
            java.lang.String r10 = r3.getString(r10)
            java.util.Date r10 = com.revenuecat.purchases.utils.Iso8601Utils.parse(r10)
            java.lang.String r12 = "requestDate"
            if (r8 == 0) goto L8f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r12)
            com.revenuecat.purchases.EntitlementInfos r5 = com.revenuecat.purchases.common.EntitlementInfoFactoriesKt.buildEntitlementInfos(r8, r6, r5, r9, r1)
            if (r5 != 0) goto L9d
        L8f:
            com.revenuecat.purchases.EntitlementInfos r5 = new com.revenuecat.purchases.EntitlementInfos
            java.util.Map r6 = java.util.Collections.emptyMap()
            java.lang.String r8 = "emptyMap()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r8)
            r5.<init>(r6, r1)
        L9d:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            java.lang.String r1 = "management_url"
            java.lang.String r1 = com.revenuecat.purchases.utils.JSONObjectExtensionsKt.optNullableString(r3, r1)
            java.lang.String r2 = "original_purchase_date"
            java.lang.String r2 = com.revenuecat.purchases.utils.JSONObjectExtensionsKt.optNullableString(r3, r2)
            r6 = 0
            if (r2 == 0) goto Lb8
            java.util.Date r2 = com.revenuecat.purchases.utils.Iso8601Utils.parse(r2)
            if (r2 != 0) goto Lb6
            r2 = r6
        Lb6:
            r13 = r2
            goto Lb9
        Lb8:
            r13 = r6
        Lb9:
            java.lang.String r2 = "schema_version"
            r8 = 3
            int r8 = r11.optInt(r2, r8)
            java.lang.String r2 = "original_app_user_id"
            java.lang.String r14 = r3.optString(r2)
            if (r1 == 0) goto Lce
            android.net.Uri r1 = android.net.Uri.parse(r1)
            r15 = r1
            goto Lcf
        Lce:
            r15 = r6
        Lcf:
            com.revenuecat.purchases.CustomerInfo r16 = new com.revenuecat.purchases.CustomerInfo
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r12)
            java.lang.String r1 = "firstSeen"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r1)
            java.lang.String r1 = "optString(CustomerInfoRe…eys.ORIGINAL_APP_USER_ID)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r1)
            r1 = r16
            r2 = r5
            r3 = r4
            r4 = r7
            r5 = r9
            r6 = r8
            r7 = r10
            r8 = r14
            r9 = r15
            r10 = r13
            r11 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.CustomerInfoFactory.buildCustomerInfo(org.json.JSONObject, java.util.Date, com.revenuecat.purchases.VerificationResult):com.revenuecat.purchases.CustomerInfo");
    }

    private final Map<String, Date> parseExpirations(JSONObject jSONObject) {
        return parseDates(jSONObject, "expires_date");
    }

    private final Map<String, Date> parsePurchaseDates(JSONObject jSONObject) {
        return parseDates(jSONObject, "purchase_date");
    }

    private final HashMap<String, Date> parseDates(JSONObject jSONObject, String str) {
        HashMap<String, Date> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            String it = jSONObject.getJSONObject(key).optString("product_plan_identifier");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (!(it.length() > 0)) {
                it = null;
            }
            JSONObject expirationObject = jSONObject.getJSONObject(key);
            if (it != null) {
                String str2 = key + AbstractJsonLexerKt.COLON + it;
                if (str2 != null) {
                    key = str2;
                }
            }
            Intrinsics.checkNotNullExpressionValue(key, "key");
            Intrinsics.checkNotNullExpressionValue(expirationObject, "expirationObject");
            hashMap.put(key, JSONObjectExtensionsKt.optDate(expirationObject, str));
        }
        return hashMap;
    }
}
