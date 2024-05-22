package com.amazon.device.iap.internal.util;

import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.a.e;
import com.amazon.device.iap.internal.a.f;
import com.amazon.device.iap.internal.model.ReceiptBuilder;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.Receipt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ReceiptHelper.java */
/* loaded from: classes.dex */
public class c {
    private static final String a = "c";

    public static Receipt a(JSONObject jSONObject, String str, String str2) throws e, f, IllegalArgumentException {
        int i = AnonymousClass1.a[b(jSONObject).ordinal()];
        if (i == 1) {
            return c(jSONObject, str, str2);
        }
        if (i == 2) {
            return b(jSONObject, str, str2);
        }
        if (i == 3) {
            return d(jSONObject, str, str2);
        }
        return e(jSONObject, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReceiptHelper.java */
    /* renamed from: com.amazon.device.iap.internal.util.c$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            a = iArr;
            try {
                iArr[d.V1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.V2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[d.V3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static Receipt b(JSONObject jSONObject, String str, String str2) throws e, f {
        String optString = jSONObject.optString("signature");
        if (com.amazon.a.a.o.f.a(optString)) {
            b.b(a, "a signature was not found in the receipt for request ID " + str2);
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, "NO Signature found", optString);
            throw new f(str2, null, optString);
        }
        try {
            Receipt a2 = a(jSONObject);
            String str3 = str + "-" + a2.getReceiptId();
            boolean a3 = com.amazon.a.a.a(str3, optString);
            b.a(a, "stringToVerify/legacy:\n" + str3 + "\nsignature:\n" + optString);
            if (a3) {
                return a2;
            }
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, str3, optString);
            throw new f(str2, str3, optString);
        } catch (JSONException e) {
            throw new e(str2, jSONObject.toString(), e);
        }
    }

    private static Receipt a(JSONObject jSONObject) throws JSONException {
        String optString = jSONObject.optString("token");
        String string = jSONObject.getString("sku");
        ProductType valueOf = ProductType.valueOf(jSONObject.getString(com.amazon.a.a.o.b.k).toUpperCase());
        String optString2 = jSONObject.optString(com.amazon.a.a.o.b.P);
        Date b = a(optString2) ? null : b(optString2);
        String optString3 = jSONObject.optString(com.amazon.a.a.o.b.d);
        return new ReceiptBuilder().setReceiptId(optString).setSku(string).setProductType(valueOf).setPurchaseDate(b).setCancelDate(a(optString3) ? null : b(optString3)).build();
    }

    private static Receipt c(JSONObject jSONObject, String str, String str2) throws e, f {
        String optString = jSONObject.optString(com.amazon.a.a.o.b.Z);
        String optString2 = jSONObject.optString("signature");
        if (com.amazon.a.a.o.f.a(optString2)) {
            b.b(a, "a signature was not found in the receipt for request ID " + str2);
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, "NO Signature found", optString2);
            throw new f(str2, null, optString2);
        }
        try {
            Receipt a2 = a(jSONObject);
            Object[] objArr = new Object[9];
            objArr[0] = PurchasingService.SDK_VERSION;
            objArr[1] = str;
            objArr[2] = optString;
            objArr[3] = a2.getProductType();
            objArr[4] = a2.getSku();
            objArr[5] = a2.getReceiptId();
            objArr[6] = str2;
            objArr[7] = ProductType.SUBSCRIPTION == a2.getProductType() ? a2.getPurchaseDate() : null;
            objArr[8] = ProductType.SUBSCRIPTION == a2.getProductType() ? a2.getCancelDate() : null;
            String format = String.format("%s|%s|%s|%s|%s|%s|%s|%tQ|%tQ", objArr);
            b.a(a, "stringToVerify/v1:\n" + format + "\nsignature:\n" + optString2);
            if (com.amazon.a.a.a(format, optString2)) {
                return a2;
            }
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, format, optString2);
            throw new f(str2, format, optString2);
        } catch (JSONException e) {
            throw new e(str2, jSONObject.toString(), e);
        }
    }

    private static Receipt d(JSONObject jSONObject, String str, String str2) throws e, f {
        String optString = jSONObject.optString(com.amazon.a.a.o.b.Z);
        String optString2 = jSONObject.optString("signature");
        Date date = null;
        if (com.amazon.a.a.o.f.a(optString2)) {
            b.b(a, "a signature was not found in the receipt for request ID " + str2);
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, "NO Signature found", optString2);
            throw new f(str2, null, optString2);
        }
        try {
            String string = jSONObject.getString(com.amazon.a.a.o.b.E);
            String string2 = jSONObject.getString("sku");
            ProductType valueOf = ProductType.valueOf(jSONObject.getString(com.amazon.a.a.o.b.k).toUpperCase());
            String optString3 = jSONObject.optString(com.amazon.a.a.o.b.Q);
            Date b = a(optString3) ? null : b(optString3);
            String optString4 = jSONObject.optString(com.amazon.a.a.o.b.e);
            if (!a(optString4)) {
                date = b(optString4);
            }
            Receipt build = new ReceiptBuilder().setReceiptId(string).setSku(string2).setProductType(valueOf).setPurchaseDate(b).setCancelDate(date).build();
            String format = String.format("%s|%s|%s|%s|%s|%tQ|%tQ", str, optString, build.getProductType(), build.getSku(), build.getReceiptId(), build.getPurchaseDate(), build.getCancelDate());
            b.a(a, "stringToVerify/v2:\n" + format + "\nsignature:\n" + optString2);
            if (com.amazon.a.a.a(format, optString2)) {
                return build;
            }
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, format, optString2);
            throw new f(str2, format, optString2);
        } catch (JSONException e) {
            throw new e(str2, jSONObject.toString(), e);
        }
    }

    private static Receipt e(JSONObject jSONObject, String str, String str2) throws e, f {
        String optString = jSONObject.optString(com.amazon.a.a.o.b.Z);
        String optString2 = jSONObject.optString("signature");
        Date date = null;
        if (com.amazon.a.a.o.f.a(optString2)) {
            b.b(a, "a signature was not found in the receipt for request ID " + str2);
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, "NO Signature found", optString2);
            throw new f(str2, null, optString2);
        }
        try {
            String string = jSONObject.getString(com.amazon.a.a.o.b.E);
            String string2 = jSONObject.getString("sku");
            String optString3 = jSONObject.optString(com.amazon.a.a.o.b.L, null);
            String optString4 = jSONObject.optString(com.amazon.a.a.o.b.M, null);
            ProductType valueOf = ProductType.valueOf(jSONObject.getString(com.amazon.a.a.o.b.k).toUpperCase());
            String optString5 = jSONObject.optString(com.amazon.a.a.o.b.Q);
            Date b = a(optString5) ? null : b(optString5);
            String optString6 = jSONObject.optString(com.amazon.a.a.o.b.e);
            Date b2 = a(optString6) ? null : b(optString6);
            String optString7 = jSONObject.optString(com.amazon.a.a.o.b.R);
            if (!a(optString7)) {
                date = b(optString7);
            }
            Receipt build = new ReceiptBuilder().setReceiptId(string).setSku(string2).setProductType(valueOf).setPurchaseDate(b).setCancelDate(b2).setDeferredDate(date).setDeferredSku(optString4).setTermSku(optString3).build();
            String format = String.format("%s|%s|%s|%s|%s|%s|%s|%tQ|%tQ|%tQ", str, optString, build.getProductType(), build.getSku(), build.getReceiptId(), build.getDeferredSku(), build.getTermSku(), build.getPurchaseDate(), build.getCancelDate(), build.getDeferredDate());
            b.a(a, "stringToVerify/v3:\n" + format + "\nsignature:\n" + optString2);
            if (com.amazon.a.a.a(format, optString2)) {
                return build;
            }
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, format, optString2);
            throw new f(str2, format, optString2);
        } catch (JSONException e) {
            throw new e(str2, jSONObject.toString(), e);
        }
    }

    protected static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    protected static Date b(String str) throws JSONException {
        try {
            Date parse = new SimpleDateFormat(com.amazon.a.a.o.b.ag).parse(str);
            if (0 == parse.getTime()) {
                return null;
            }
            return parse;
        } catch (ParseException e) {
            throw new JSONException(e.getMessage());
        }
    }

    private static d b(JSONObject jSONObject) {
        String optString = jSONObject.optString(com.amazon.a.a.o.b.Z);
        String optString2 = jSONObject.optString(com.amazon.a.a.o.b.E);
        String optString3 = jSONObject.optString(com.amazon.a.a.o.b.N);
        if (!com.amazon.a.a.o.f.a(optString3) && optString3.equals(d.V3.name())) {
            return d.V3;
        }
        if (!com.amazon.a.a.o.f.a(optString2)) {
            return d.V2;
        }
        if (com.amazon.a.a.o.f.a(optString)) {
            return d.LEGACY;
        }
        return d.V1;
    }

    protected static JSONObject a(Receipt receipt, String str) {
        JSONObject jSONObject = new JSONObject();
        if (receipt != null && !com.amazon.a.a.o.f.a(str)) {
            try {
                jSONObject.put(com.amazon.a.a.o.b.E, receipt.getReceiptId());
                jSONObject.put("sku", receipt.getSku());
                jSONObject.put(com.amazon.a.a.o.b.k, receipt.getProductType());
                jSONObject.put(com.amazon.a.a.o.b.Q, receipt.getPurchaseDate());
                jSONObject.put(com.amazon.a.a.o.b.d, receipt.getCancelDate());
                jSONObject.put("signature", str);
            } catch (JSONException unused) {
                b.b(a, "Failure during toJsonInternal: " + receipt + ", signature:" + str);
            }
        }
        return jSONObject;
    }

    public static String b(Receipt receipt, String str) {
        try {
            return a(receipt, str).toString(4);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static List<Receipt> a(String str, String str2, String str3) throws JSONException, e, f, IllegalArgumentException {
        if (str2 == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str2);
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(a(jSONArray.getJSONObject(i), str, str3));
            } catch (e e) {
                b.b(a, "fail to parse receipt, requestId:" + e.a());
                throw e;
            } catch (f e2) {
                b.b(a, "fail to verify receipt, requestId:" + e2.a());
                throw e2;
            } catch (Throwable th) {
                b.b(a, "fail to verify receipt, requestId:" + th.getMessage());
                throw th;
            }
        }
        return arrayList;
    }
}
