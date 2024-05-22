package com.amazon.device.iap.internal.a.f;

import com.amazon.a.a.o.f;
import com.amazon.d.a.j;
import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.Receipt;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: PurchaseResponseCommandV1.java */
/* loaded from: classes.dex */
public final class b extends a {
    private static final String c = "b";

    public b(com.amazon.device.iap.internal.a.c cVar) {
        super(cVar, "1.0");
    }

    private void a(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (PurchaseResponse.RequestStatus.safeValueOf(jSONObject.getString(com.amazon.a.a.o.b.n)) == PurchaseResponse.RequestStatus.SUCCESSFUL) {
                com.amazon.device.iap.internal.b.d.a().a(str, str2, com.amazon.device.iap.internal.util.c.a(jSONObject, str2, str).getReceiptId(), str3);
            }
        } catch (Throwable th) {
            com.amazon.device.iap.internal.util.b.b(c, "Error in savePendingReceipt: " + th);
        }
    }

    @Override // com.amazon.a.a.n.a.h
    protected boolean b(j jVar) throws Exception {
        Receipt a;
        Map b = jVar.b();
        com.amazon.device.iap.internal.util.b.a(c, "data: " + b);
        String str = (String) b().get(com.amazon.a.a.o.b.B);
        String str2 = (String) b.get("userId");
        String str3 = (String) b.get(com.amazon.a.a.o.b.m);
        String str4 = (String) b.get(com.amazon.a.a.o.b.D);
        if (str == null || !e.a().a(str)) {
            j().a().c();
            return true;
        }
        if (f.a(str4)) {
            a(str2, str3, str, PurchaseResponse.RequestStatus.FAILED);
            return false;
        }
        JSONObject jSONObject = new JSONObject(str4);
        PurchaseResponse.RequestStatus safeValueOf = PurchaseResponse.RequestStatus.safeValueOf(jSONObject.getString(com.amazon.a.a.o.b.n));
        if (safeValueOf == PurchaseResponse.RequestStatus.SUCCESSFUL) {
            try {
                a = com.amazon.device.iap.internal.util.c.a(jSONObject, str2, str);
                if (ProductType.CONSUMABLE == a.getProductType()) {
                    a(str, str2, str4);
                }
            } catch (Throwable unused) {
                a(str2, str3, str, PurchaseResponse.RequestStatus.FAILED);
                return false;
            }
        } else {
            a = null;
        }
        com.amazon.device.iap.internal.a.c cVar = (com.amazon.device.iap.internal.a.c) j();
        cVar.a().a(new PurchaseResponseBuilder().setRequestId(cVar.d()).setRequestStatus(safeValueOf).setUserData(new UserDataBuilder().setUserId(str2).setMarketplace(str3).build()).setReceipt(a).build());
        return true;
    }
}
