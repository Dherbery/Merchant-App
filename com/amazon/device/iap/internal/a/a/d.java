package com.amazon.device.iap.internal.a.a;

import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.RequestId;
import java.util.Set;

/* compiled from: GetProductDataRequest.java */
/* loaded from: classes.dex */
public final class d extends com.amazon.device.iap.internal.a.c {
    public d(RequestId requestId, Set<String> set) {
        super(requestId);
        c cVar = new c(this, set);
        cVar.b(new b(this, set));
        a((h) cVar);
    }

    @Override // com.amazon.device.iap.internal.a.c, com.amazon.a.a.j.a
    public void b() {
        a((ProductDataResponse) a().b());
    }

    @Override // com.amazon.device.iap.internal.a.c, com.amazon.a.a.j.a
    public void c() {
        ProductDataResponse productDataResponse = (ProductDataResponse) a().b();
        if (productDataResponse == null) {
            productDataResponse = new ProductDataResponseBuilder().setRequestId(d()).setRequestStatus(ProductDataResponse.RequestStatus.FAILED).build();
        }
        a(productDataResponse);
    }
}
