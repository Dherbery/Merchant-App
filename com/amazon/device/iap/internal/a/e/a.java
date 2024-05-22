package com.amazon.device.iap.internal.a.e;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.amazon.a.a.n.a.h;
import com.amazon.d.a.j;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.util.MetricsHelper;
import java.util.Map;

/* compiled from: PurchaseItemCommandBase.java */
/* loaded from: classes.dex */
abstract class a extends h {
    protected static final String b = "purchase_item";
    private static final String f = "a";

    @com.amazon.a.a.k.a
    protected com.amazon.a.a.n.b c;

    @com.amazon.a.a.k.a
    protected com.amazon.a.a.a.a d;
    protected final String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.amazon.device.iap.internal.a.c cVar, String str, String str2) {
        super(cVar, b, str, cVar.d().toString(), PurchasingService.SDK_VERSION);
        this.e = str2;
        a("sku", str2);
    }

    @Override // com.amazon.a.a.n.a.h
    protected boolean b(j jVar) throws RemoteException, com.amazon.a.a.d.b {
        Map b2 = jVar.b();
        String str = f;
        com.amazon.device.iap.internal.util.b.a(str, "data: " + b2);
        if (!b2.containsKey(com.amazon.a.a.o.b.z)) {
            com.amazon.device.iap.internal.util.b.b(str, "did not find intent");
            return false;
        }
        com.amazon.device.iap.internal.util.b.a(str, "found intent");
        final Intent intent = (Intent) b2.remove(com.amazon.a.a.o.b.z);
        this.c.b(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.device.iap.internal.a.e.a.1
            @Override // com.amazon.a.a.n.a
            public void a() {
                try {
                    Activity b3 = a.this.d.b();
                    if (b3 == null) {
                        b3 = a.this.d.a();
                    }
                    com.amazon.device.iap.internal.util.b.a(a.f, "About to fire intent with activity " + b3);
                    b3.startActivity(intent);
                } catch (Exception e) {
                    MetricsHelper.submitExceptionMetrics(a.this.k(), a.f + ".onResult().execute()", e);
                    com.amazon.device.iap.internal.util.b.b(a.f, "Exception when attempting to fire intent: " + e);
                }
            }
        });
        return true;
    }
}
