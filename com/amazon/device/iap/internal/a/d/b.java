package com.amazon.device.iap.internal.a.d;

import android.os.RemoteException;
import com.amazon.a.a.n.a.h;
import com.amazon.d.a.j;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.a.c;
import java.util.Set;

/* compiled from: PurchaseFulfilledCommandV2.java */
/* loaded from: classes.dex */
public final class b extends h {
    private static final String d = "purchase_fulfilled";
    protected final Set<String> b;
    protected final String c;

    @Override // com.amazon.a.a.n.a.h
    protected boolean b(j jVar) throws RemoteException, com.amazon.a.a.d.b {
        return true;
    }

    public b(c cVar, Set<String> set, String str) {
        super(cVar, d, com.amazon.a.a.o.b.ae, cVar.d().toString(), PurchasingService.SDK_VERSION);
        this.b = set;
        this.c = str;
        b(false);
        a(com.amazon.a.a.o.b.F, set);
        a(com.amazon.a.a.o.b.g, str);
    }

    @Override // com.amazon.a.a.n.a.h
    public void l() {
        Object a = j().a().a(com.amazon.a.a.o.b.al);
        if (a != null && Boolean.FALSE.equals(a)) {
            a(com.amazon.a.a.o.b.g, com.amazon.device.iap.internal.model.a.DELIVERY_ATTEMPTED.toString());
        }
        super.l();
    }
}
