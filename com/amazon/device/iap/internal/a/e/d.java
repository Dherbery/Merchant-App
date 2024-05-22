package com.amazon.device.iap.internal.a.e;

import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.RequestId;

/* compiled from: PurchaseRequest.java */
/* loaded from: classes.dex */
public final class d extends com.amazon.device.iap.internal.a.c {
    @Override // com.amazon.device.iap.internal.a.c, com.amazon.a.a.j.a
    public void b() {
    }

    public d(RequestId requestId, String str) {
        super(requestId);
        c cVar = new c(this, str);
        cVar.b(new b(this, str));
        a((h) cVar);
    }

    @Override // com.amazon.device.iap.internal.a.c, com.amazon.a.a.j.a
    public void c() {
        PurchaseResponse purchaseResponse = (PurchaseResponse) a().b();
        if (purchaseResponse == null) {
            purchaseResponse = new PurchaseResponseBuilder().setRequestId(d()).setRequestStatus(PurchaseResponse.RequestStatus.FAILED).build();
        }
        a(purchaseResponse);
    }
}
