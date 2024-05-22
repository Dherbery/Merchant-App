package com.amazon.device.iap.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.amazon.a.a.o.f;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.RequestId;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: PurchasingManager.java */
/* loaded from: classes.dex */
public class d {
    private static String a = "d";
    private static String b = "sku";
    private static d c = new d();
    private e d;
    private Context e;
    private PurchasingListener f;

    private d() {
    }

    public PurchasingListener a() {
        return this.f;
    }

    public Context b() {
        return this.e;
    }

    private void f() {
        if (this.f == null) {
            throw new IllegalStateException("You must register a PurchasingListener before invoking this operation");
        }
    }

    public void a(Context context, PurchasingListener purchasingListener) {
        com.amazon.device.iap.internal.util.b.a(a, "PurchasingListener registered: " + purchasingListener);
        com.amazon.device.iap.internal.util.b.a(a, "PurchasingListener Context: " + context);
        if (purchasingListener == null || context == null) {
            throw new IllegalArgumentException("Neither PurchasingListener or its Context can be null");
        }
        this.e = context.getApplicationContext();
        e a2 = b.a().a(this.e);
        this.d = a2;
        if (a2 == null) {
            com.amazon.device.iap.internal.util.b.a(a, "requestHandler is null");
        }
        this.f = purchasingListener;
    }

    public boolean c() {
        f();
        return com.amazon.a.a.a((Application) this.e.getApplicationContext());
    }

    public RequestId d() {
        f();
        RequestId requestId = new RequestId();
        this.d.a(requestId);
        return requestId;
    }

    public RequestId a(String str) {
        f.a((Object) str, b);
        f();
        RequestId requestId = new RequestId();
        this.d.a(requestId, str);
        return requestId;
    }

    public RequestId a(Set<String> set) {
        f.a((Object) set, com.amazon.a.a.o.b.O);
        f.a((Collection<? extends Object>) set, com.amazon.a.a.o.b.O);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (it.next().trim().length() == 0) {
                throw new IllegalArgumentException("Empty SKU values are not allowed");
            }
        }
        if (set.size() > 100) {
            throw new IllegalArgumentException(set.size() + " SKUs were provided, but no more than 100 SKUs are allowed");
        }
        f();
        RequestId requestId = new RequestId();
        this.d.a(requestId, new LinkedHashSet(set));
        return requestId;
    }

    public RequestId a(boolean z) {
        f();
        RequestId requestId = new RequestId();
        this.d.a(requestId, z);
        return requestId;
    }

    public void a(String str, FulfillmentResult fulfillmentResult) {
        if (f.a(str)) {
            throw new IllegalArgumentException("Empty receiptId is not allowed");
        }
        f.a(fulfillmentResult, "fulfillmentResult");
        f();
        this.d.a(new RequestId(), str, fulfillmentResult);
    }

    public void a(Context context, Intent intent) {
        try {
            this.d.a(context, intent);
        } catch (Exception e) {
            com.amazon.device.iap.internal.util.b.b(a, "Error in onReceive: " + e);
        }
    }

    public static d e() {
        return c;
    }
}
