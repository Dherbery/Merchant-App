package com.amazon.device.iap.internal.a.d;

import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.internal.a.c;
import com.amazon.device.iap.internal.b.d;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.RequestId;
import java.util.HashSet;

/* compiled from: NotifyFulfillmentRequest.java */
/* loaded from: classes.dex */
public final class a extends c {
    private final String c;
    private final FulfillmentResult d;

    @Override // com.amazon.device.iap.internal.a.c, com.amazon.a.a.j.a
    public void b() {
    }

    public a(RequestId requestId, String str, FulfillmentResult fulfillmentResult) {
        super(requestId);
        HashSet hashSet = new HashSet();
        hashSet.add(str);
        this.c = str;
        this.d = fulfillmentResult;
        a((h) new b(this, hashSet, fulfillmentResult.toString()));
    }

    @Override // com.amazon.device.iap.internal.a.c, com.amazon.a.a.j.a
    public void c() {
        String c;
        if ((FulfillmentResult.FULFILLED == this.d || FulfillmentResult.UNAVAILABLE == this.d) && (c = d.a().c(this.c)) != null) {
            new com.amazon.device.iap.internal.a.g.b(this, c).l();
            d.a().a(this.c);
        }
    }
}
