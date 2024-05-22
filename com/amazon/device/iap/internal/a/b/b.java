package com.amazon.device.iap.internal.a.b;

import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.PurchasingService;

/* compiled from: PurchaseUpdatesCommandBase.java */
/* loaded from: classes.dex */
abstract class b extends h {
    protected static final String b = "purchase_updates";
    protected final boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(com.amazon.device.iap.internal.a.c cVar, String str, boolean z) {
        super(cVar, b, str, cVar.d().toString(), PurchasingService.SDK_VERSION);
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amazon.a.a.n.a.a
    public void e() throws com.amazon.a.a.d.b {
        super.e();
        a(com.amazon.a.a.o.b.b, this.c ? null : com.amazon.device.iap.internal.util.a.a((String) ((com.amazon.device.iap.internal.a.c) j()).a().a("userId")));
    }
}
