package com.amazon.device.iap.internal.a;

import android.content.Context;
import android.os.Handler;
import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataResponse;

/* compiled from: KiwiRequest.java */
/* loaded from: classes.dex */
public class c extends com.amazon.a.a.j.a {
    private static final String c = "c";
    private RequestId d;

    @Override // com.amazon.a.a.j.a
    public void b() {
    }

    @Override // com.amazon.a.a.j.a
    public void c() {
    }

    public c(RequestId requestId) {
        this.d = requestId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amazon.a.a.j.a
    public void a(h hVar) {
        this.b = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Object obj) {
        a(obj, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final Object obj, final h hVar) {
        com.amazon.a.a.o.f.a(obj, "response");
        Context b = com.amazon.device.iap.internal.d.e().b();
        final PurchasingListener a = com.amazon.device.iap.internal.d.e().a();
        if (b == null || a == null) {
            com.amazon.device.iap.internal.util.b.a(c, "PurchasingListener is not set. Dropping response: " + obj);
            return;
        }
        new Handler(b.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.iap.internal.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.a().a(com.amazon.a.a.o.b.al, Boolean.FALSE);
                try {
                    Object obj2 = obj;
                    if (obj2 instanceof ProductDataResponse) {
                        a.onProductDataResponse((ProductDataResponse) obj2);
                    } else if (obj2 instanceof UserDataResponse) {
                        a.onUserDataResponse((UserDataResponse) obj2);
                    } else if (obj2 instanceof PurchaseUpdatesResponse) {
                        PurchaseUpdatesResponse purchaseUpdatesResponse = (PurchaseUpdatesResponse) obj2;
                        a.onPurchaseUpdatesResponse(purchaseUpdatesResponse);
                        Object a2 = c.this.a().a(com.amazon.a.a.o.b.am);
                        if (a2 != null && (a2 instanceof String)) {
                            com.amazon.device.iap.internal.util.a.a(purchaseUpdatesResponse.getUserData().getUserId(), a2.toString());
                        }
                    } else if (!(obj2 instanceof PurchaseResponse)) {
                        com.amazon.device.iap.internal.util.b.b(c.c, "Unknown response type:" + obj.getClass().getName());
                    } else {
                        a.onPurchaseResponse((PurchaseResponse) obj2);
                    }
                    c.this.a().a(com.amazon.a.a.o.b.al, Boolean.TRUE);
                } catch (Throwable th) {
                    com.amazon.device.iap.internal.util.b.b(c.c, "Error in sendResponse: " + th);
                }
                h hVar2 = hVar;
                if (hVar2 != null) {
                    hVar2.a(true);
                    hVar.l();
                }
            }
        });
    }

    public RequestId d() {
        return this.d;
    }

    @Override // com.amazon.a.a.j.a
    public com.amazon.a.a.j.b a() {
        return this.a;
    }

    public void e() {
        if (this.b != null) {
            this.b.l();
        } else {
            b();
        }
    }
}
