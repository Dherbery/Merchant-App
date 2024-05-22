package com.amazon.device.iap.internal.a.b;

import com.amazon.a.a.n.a.h;
import com.amazon.a.a.o.f;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import java.util.HashSet;

/* compiled from: GetPurchaseUpdatesRequest.java */
/* loaded from: classes.dex */
public final class a extends com.amazon.device.iap.internal.a.c {
    public a(RequestId requestId, boolean z) {
        super(requestId);
        com.amazon.device.iap.internal.a.c.d dVar = new com.amazon.device.iap.internal.a.c.d(this);
        dVar.a((h) new d(this, z));
        com.amazon.device.iap.internal.a.c.c cVar = new com.amazon.device.iap.internal.a.c.c(this);
        cVar.a((h) new c(this, z));
        dVar.b(cVar);
        a((h) dVar);
    }

    @Override // com.amazon.device.iap.internal.a.c, com.amazon.a.a.j.a
    public void b() {
        h hVar;
        PurchaseUpdatesResponse purchaseUpdatesResponse = (PurchaseUpdatesResponse) a().b();
        if (purchaseUpdatesResponse.getReceipts() == null || purchaseUpdatesResponse.getReceipts().size() <= 0) {
            hVar = null;
        } else {
            HashSet hashSet = new HashSet();
            for (Receipt receipt : purchaseUpdatesResponse.getReceipts()) {
                if (!f.a(receipt.getReceiptId())) {
                    hashSet.add(receipt.getReceiptId());
                }
            }
            hVar = new com.amazon.device.iap.internal.a.d.b(this, hashSet, com.amazon.device.iap.internal.model.a.DELIVERED.toString());
        }
        a(purchaseUpdatesResponse, hVar);
    }

    @Override // com.amazon.device.iap.internal.a.c, com.amazon.a.a.j.a
    public void c() {
        PurchaseUpdatesResponse build;
        Object b = a().b();
        if (b == null || !(b instanceof PurchaseUpdatesResponse)) {
            build = new PurchaseUpdatesResponseBuilder().setRequestId(d()).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.FAILED).build();
        } else {
            build = (PurchaseUpdatesResponse) b;
        }
        a(build);
    }
}
