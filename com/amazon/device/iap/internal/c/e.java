package com.amazon.device.iap.internal.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.amazon.a.a.o.f;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.model.ProductBuilder;
import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.internal.model.ReceiptBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SandboxRequestHandler.java */
/* loaded from: classes.dex */
public final class e implements com.amazon.device.iap.internal.e {
    private static final String a = "e";
    private static final String b = "com.amazon.sdktestclient";
    private static final String c = "com.amazon.sdktestclient.command.CommandBroker";

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId) {
        com.amazon.device.iap.internal.util.b.a(a, "sendGetUserDataRequest");
        a(requestId.toString(), false, false);
    }

    private void a(String str, boolean z, boolean z2) {
        try {
            Context b2 = com.amazon.device.iap.internal.d.e().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.B, str);
            jSONObject.put("packageName", b2.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.I, PurchasingService.SDK_VERSION);
            jSONObject.put(b.as, z);
            jSONObject.put(b.at, z2);
            bundle.putString("userInput", jSONObject.toString());
            Intent a2 = a("com.amazon.testclient.iap.appUserId");
            a2.addFlags(268435456);
            a2.putExtras(bundle);
            b2.startService(a2);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.b.b(a, "Error in sendGetUserDataRequest.");
        }
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, String str) {
        com.amazon.device.iap.internal.util.b.a(a, "sendPurchaseRequest");
        try {
            Context b2 = com.amazon.device.iap.internal.d.e().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sku", str);
            jSONObject.put(com.amazon.a.a.o.b.B, requestId.toString());
            jSONObject.put("packageName", b2.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.I, PurchasingService.SDK_VERSION);
            bundle.putString("purchaseInput", jSONObject.toString());
            Intent a2 = a("com.amazon.testclient.iap.purchase");
            a2.addFlags(268435456);
            a2.putExtras(bundle);
            b2.startService(a2);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.b.b(a, "Error in sendPurchaseRequest.");
        }
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, Set<String> set) {
        com.amazon.device.iap.internal.util.b.a(a, "sendItemDataRequest");
        try {
            Context b2 = com.amazon.device.iap.internal.d.e().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray((Collection) set);
            jSONObject.put(com.amazon.a.a.o.b.B, requestId.toString());
            jSONObject.put("packageName", b2.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.O, jSONArray);
            jSONObject.put(com.amazon.a.a.o.b.I, PurchasingService.SDK_VERSION);
            bundle.putString("itemDataInput", jSONObject.toString());
            Intent a2 = a("com.amazon.testclient.iap.itemData");
            a2.addFlags(268435456);
            a2.putExtras(bundle);
            b2.startService(a2);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.b.b(a, "Error in sendItemDataRequest.");
        }
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, boolean z) {
        if (requestId == null) {
            requestId = new RequestId();
        }
        com.amazon.device.iap.internal.util.b.a(a, "sendPurchaseUpdatesRequest/sendGetUserData first:" + requestId);
        a(requestId.toString(), true, z);
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, String str, FulfillmentResult fulfillmentResult) {
        com.amazon.device.iap.internal.util.b.a(a, "sendNotifyPurchaseFulfilled");
        try {
            Context b2 = com.amazon.device.iap.internal.d.e().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.B, requestId.toString());
            jSONObject.put("packageName", b2.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.E, str);
            jSONObject.put("fulfillmentResult", fulfillmentResult);
            jSONObject.put(com.amazon.a.a.o.b.I, PurchasingService.SDK_VERSION);
            bundle.putString("purchaseFulfilledInput", jSONObject.toString());
            Intent a2 = a("com.amazon.testclient.iap.purchaseFulfilled");
            a2.addFlags(268435456);
            a2.putExtras(bundle);
            b2.startService(a2);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.b.b(a, "Error in sendNotifyPurchaseFulfilled.");
        }
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(Context context, Intent intent) {
        com.amazon.device.iap.internal.util.b.a(a, "handleResponse");
        intent.setComponent(new ComponentName(b, c));
        try {
            String string = intent.getExtras().getString("responseType");
            if (string.equalsIgnoreCase("com.amazon.testclient.iap.purchase")) {
                g(intent);
            } else if (string.equalsIgnoreCase("com.amazon.testclient.iap.appUserId")) {
                e(intent);
            } else if (string.equalsIgnoreCase("com.amazon.testclient.iap.itemData")) {
                c(intent);
            } else if (string.equalsIgnoreCase("com.amazon.testclient.iap.purchaseUpdates")) {
                a(intent);
            }
        } catch (Exception e) {
            Log.e(a, "Error handling response.", e);
        }
    }

    private Intent a(String str) {
        Intent intent = new Intent(str);
        intent.setComponent(new ComponentName(b, c));
        return intent;
    }

    protected void a(final Object obj) {
        f.a(obj, "response");
        Context b2 = com.amazon.device.iap.internal.d.e().b();
        final PurchasingListener a2 = com.amazon.device.iap.internal.d.e().a();
        if (b2 == null || a2 == null) {
            com.amazon.device.iap.internal.util.b.a(a, "PurchasingListener is not set. Dropping response: " + obj);
            return;
        }
        new Handler(b2.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.iap.internal.c.e.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Object obj2 = obj;
                    if (obj2 instanceof ProductDataResponse) {
                        a2.onProductDataResponse((ProductDataResponse) obj2);
                    } else if (obj2 instanceof UserDataResponse) {
                        a2.onUserDataResponse((UserDataResponse) obj2);
                    } else if (obj2 instanceof PurchaseUpdatesResponse) {
                        a2.onPurchaseUpdatesResponse((PurchaseUpdatesResponse) obj2);
                    } else if (!(obj2 instanceof PurchaseResponse)) {
                        com.amazon.device.iap.internal.util.b.b(e.a, "Unknown response type:" + obj.getClass().getName());
                    } else {
                        a2.onPurchaseResponse((PurchaseResponse) obj2);
                    }
                } catch (Exception e) {
                    com.amazon.device.iap.internal.util.b.b(e.a, "Error in sendResponse: " + e);
                }
            }
        });
    }

    private void a(Intent intent) throws JSONException {
        PurchaseUpdatesResponse b2 = b(intent);
        if (b2.getRequestStatus() == PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL) {
            String optString = new JSONObject(intent.getStringExtra("purchaseUpdatesOutput")).optString(b.ar);
            Log.i(a, "Offset for PurchaseUpdatesResponse:" + optString);
            com.amazon.device.iap.internal.util.a.a(b2.getUserData().getUserId(), optString);
        }
        a(b2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    private PurchaseUpdatesResponse b(Intent intent) {
        UserData userData;
        ArrayList arrayList;
        Exception e;
        RequestId requestId;
        boolean z;
        boolean z2;
        JSONObject jSONObject;
        PurchaseUpdatesResponse.RequestStatus requestStatus = PurchaseUpdatesResponse.RequestStatus.FAILED;
        ArrayList arrayList2 = null;
        int i = 0;
        try {
            jSONObject = new JSONObject(intent.getStringExtra("purchaseUpdatesOutput"));
            requestId = RequestId.fromString(jSONObject.optString(com.amazon.a.a.o.b.B));
            try {
                requestStatus = PurchaseUpdatesResponse.RequestStatus.valueOf(jSONObject.optString("status"));
                z2 = jSONObject.optBoolean("isMore");
                try {
                    userData = new UserDataBuilder().setUserId(jSONObject.optString("userId")).setMarketplace(jSONObject.optString(com.amazon.a.a.o.b.m)).build();
                    try {
                        z = z2;
                    } catch (Exception e2) {
                        e = e2;
                        arrayList = null;
                        e = e;
                        i = z2 ? 1 : 0;
                        Log.e(a, "Error parsing purchase updates output", e);
                        z2 = i;
                        arrayList2 = arrayList;
                        z = z2;
                        return new PurchaseUpdatesResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).setReceipts(arrayList2).setHasMore(z).build();
                    }
                } catch (Exception e3) {
                    e = e3;
                    userData = null;
                    arrayList = null;
                }
            } catch (Exception e4) {
                userData = null;
                arrayList = null;
                e = e4;
            }
        } catch (Exception e5) {
            userData = null;
            arrayList = null;
            e = e5;
            requestId = null;
        }
        if (requestStatus == PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL) {
            arrayList = new ArrayList();
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray(com.amazon.a.a.o.b.G);
                if (optJSONArray != null) {
                    while (i < optJSONArray.length()) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        try {
                            arrayList.add(a(optJSONObject));
                        } catch (Exception unused) {
                            Log.e(a, "Failed to parse receipt from json:" + optJSONObject);
                        }
                        i++;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                i = z2 ? 1 : 0;
                Log.e(a, "Error parsing purchase updates output", e);
                z2 = i;
                arrayList2 = arrayList;
                z = z2;
                return new PurchaseUpdatesResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).setReceipts(arrayList2).setHasMore(z).build();
            }
            arrayList2 = arrayList;
            z = z2;
        }
        return new PurchaseUpdatesResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).setReceipts(arrayList2).setHasMore(z).build();
    }

    private void c(Intent intent) {
        a(d(intent));
    }

    private ProductDataResponse d(Intent intent) {
        LinkedHashSet linkedHashSet;
        HashMap hashMap;
        Exception e;
        RequestId requestId;
        JSONObject jSONObject;
        ProductDataResponse.RequestStatus requestStatus = ProductDataResponse.RequestStatus.FAILED;
        LinkedHashSet linkedHashSet2 = null;
        try {
            jSONObject = new JSONObject(intent.getStringExtra("itemDataOutput"));
            requestId = RequestId.fromString(jSONObject.optString(com.amazon.a.a.o.b.B));
            try {
                requestStatus = ProductDataResponse.RequestStatus.valueOf(jSONObject.optString("status"));
            } catch (Exception e2) {
                e = e2;
                linkedHashSet = null;
                hashMap = null;
            }
        } catch (Exception e3) {
            linkedHashSet = null;
            hashMap = null;
            e = e3;
            requestId = null;
        }
        if (requestStatus != ProductDataResponse.RequestStatus.FAILED) {
            linkedHashSet = new LinkedHashSet();
            try {
                hashMap = new HashMap();
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("unavailableSkus");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            linkedHashSet.add(optJSONArray.getString(i));
                        }
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("items");
                    if (optJSONObject != null) {
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, a(next, optJSONObject.optJSONObject(next)));
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    Log.e(a, "Error parsing item data output", e);
                    linkedHashSet2 = linkedHashSet;
                    return new ProductDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setProductData(hashMap).setUnavailableSkus(linkedHashSet2).build();
                }
            } catch (Exception e5) {
                e = e5;
                hashMap = null;
                e = e;
                Log.e(a, "Error parsing item data output", e);
                linkedHashSet2 = linkedHashSet;
                return new ProductDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setProductData(hashMap).setUnavailableSkus(linkedHashSet2).build();
            }
            linkedHashSet2 = linkedHashSet;
            return new ProductDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setProductData(hashMap).setUnavailableSkus(linkedHashSet2).build();
        }
        hashMap = null;
        return new ProductDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setProductData(hashMap).setUnavailableSkus(linkedHashSet2).build();
    }

    private Product a(String str, JSONObject jSONObject) throws JSONException {
        String str2;
        ProductType valueOf = ProductType.valueOf(jSONObject.optString(com.amazon.a.a.o.b.k));
        JSONObject optJSONObject = jSONObject.optJSONObject(com.amazon.a.a.o.b.y);
        if (optJSONObject == null || optJSONObject == JSONObject.NULL) {
            str2 = null;
        } else {
            Currency currency = Currency.getInstance(optJSONObject.optString(com.amazon.a.a.o.b.a));
            str2 = currency.getSymbol() + optJSONObject.optString("value");
        }
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString(com.amazon.a.a.o.b.c);
        String optString3 = jSONObject.optString("smallIconUrl");
        int optInt = jSONObject.optInt(com.amazon.a.a.o.b.T, 0);
        return new ProductBuilder().setSku(str).setProductType(valueOf).setDescription(optString2).setPrice(str2).setSmallIconUrl(optString3).setTitle(optString).setCoinsRewardAmount(optInt).setSubscriptionPeriod(jSONObject.isNull("term") ? null : jSONObject.getString("term")).setFreeTrialPeriod(jSONObject.isNull(com.amazon.a.a.o.b.p) ? null : jSONObject.getString(com.amazon.a.a.o.b.p)).setPromotions(jSONObject.isNull(com.amazon.a.a.o.b.q) ? null : a.a(jSONObject)).build();
    }

    private void e(Intent intent) {
        JSONObject jSONObject;
        UserDataResponse f = f(intent);
        RequestId requestId = f.getRequestId();
        String stringExtra = intent.getStringExtra("userInput");
        try {
            jSONObject = new JSONObject(stringExtra);
        } catch (JSONException e) {
            Log.e(a, "Unable to parse request data: " + stringExtra, e);
            jSONObject = null;
        }
        if (requestId == null || jSONObject == null) {
            a(f);
            return;
        }
        if (!jSONObject.optBoolean(b.as, false)) {
            a(f);
            return;
        }
        if (f.getUserData() == null || f.a(f.getUserData().getUserId())) {
            Log.e(a, "No Userid found in userDataResponse" + f);
            a(new PurchaseUpdatesResponseBuilder().setRequestId(requestId).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.FAILED).setUserData(f.getUserData()).setReceipts(new ArrayList()).setHasMore(false).build());
            return;
        }
        Log.i(a, "sendGetPurchaseUpdates with user id" + f.getUserData().getUserId());
        a(requestId.toString(), f.getUserData().getUserId(), jSONObject.optBoolean(b.at, true));
    }

    private void a(String str, String str2, boolean z) {
        try {
            Context b2 = com.amazon.device.iap.internal.d.e().b();
            String a2 = com.amazon.device.iap.internal.util.a.a(str2);
            Log.i(a, "send PurchaseUpdates with user id:" + str2 + ";reset flag:" + z + ", local cursor:" + a2 + ", parsed from old requestId:" + str);
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.B, str.toString());
            if (z) {
                a2 = null;
            }
            jSONObject.put(b.ar, a2);
            jSONObject.put(com.amazon.a.a.o.b.I, PurchasingService.SDK_VERSION);
            jSONObject.put("packageName", b2.getPackageName());
            bundle.putString("purchaseUpdatesInput", jSONObject.toString());
            Intent a3 = a("com.amazon.testclient.iap.purchaseUpdates");
            a3.addFlags(268435456);
            a3.putExtras(bundle);
            b2.startService(a3);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.b.b(a, "Error in sendPurchaseUpdatesRequest.");
        }
    }

    private UserDataResponse f(Intent intent) {
        RequestId requestId;
        UserDataResponse.RequestStatus requestStatus = UserDataResponse.RequestStatus.FAILED;
        UserData userData = null;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("userOutput"));
            requestId = RequestId.fromString(jSONObject.optString(com.amazon.a.a.o.b.B));
            try {
                requestStatus = UserDataResponse.RequestStatus.valueOf(jSONObject.optString("status"));
                if (requestStatus == UserDataResponse.RequestStatus.SUCCESSFUL) {
                    userData = new UserDataBuilder().setUserId(jSONObject.optString("userId")).setMarketplace(jSONObject.optString(com.amazon.a.a.o.b.m)).build();
                }
            } catch (Exception e) {
                e = e;
                Log.e(a, "Error parsing userid output", e);
                return new UserDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).build();
            }
        } catch (Exception e2) {
            e = e2;
            requestId = null;
        }
        return new UserDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).build();
    }

    private void g(Intent intent) {
        a(h(intent));
    }

    private PurchaseResponse h(Intent intent) {
        RequestId requestId;
        UserData userData;
        PurchaseResponse.RequestStatus requestStatus = PurchaseResponse.RequestStatus.FAILED;
        Receipt receipt = null;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("purchaseOutput"));
            requestId = RequestId.fromString(jSONObject.optString(com.amazon.a.a.o.b.B));
            try {
                userData = new UserDataBuilder().setUserId(jSONObject.optString("userId")).setMarketplace(jSONObject.optString(com.amazon.a.a.o.b.m)).build();
                try {
                    requestStatus = PurchaseResponse.RequestStatus.safeValueOf(jSONObject.optString("purchaseStatus"));
                    JSONObject optJSONObject = jSONObject.optJSONObject(com.amazon.a.a.o.b.D);
                    if (optJSONObject != null) {
                        receipt = a(optJSONObject);
                    }
                } catch (Exception e) {
                    e = e;
                    Log.e(a, "Error parsing purchase output", e);
                    return new PurchaseResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).setReceipt(receipt).build();
                }
            } catch (Exception e2) {
                e = e2;
                userData = null;
            }
        } catch (Exception e3) {
            e = e3;
            requestId = null;
            userData = null;
        }
        return new PurchaseResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).setReceipt(receipt).build();
    }

    private Receipt a(JSONObject jSONObject) throws ParseException {
        String optString = jSONObject.optString(com.amazon.a.a.o.b.E);
        String optString2 = jSONObject.optString("sku");
        ProductType valueOf = ProductType.valueOf(jSONObject.optString(com.amazon.a.a.o.b.k));
        Date parse = b.aq.parse(jSONObject.optString(com.amazon.a.a.o.b.Q));
        String optString3 = jSONObject.optString(com.amazon.a.a.o.b.e);
        Date parse2 = (optString3 == null || optString3.length() == 0) ? null : b.aq.parse(optString3);
        String optString4 = jSONObject.optString(com.amazon.a.a.o.b.R);
        return new ReceiptBuilder().setReceiptId(optString).setSku(optString2).setProductType(valueOf).setPurchaseDate(parse).setCancelDate(parse2).setDeferredSku(jSONObject.optString(com.amazon.a.a.o.b.M, null)).setDeferredDate((optString4 == null || optString4.length() == 0) ? null : b.aq.parse(optString4)).setTermSku(jSONObject.optString(com.amazon.a.a.o.b.L, null)).build();
    }
}
