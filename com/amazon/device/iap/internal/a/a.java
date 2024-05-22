package com.amazon.device.iap.internal.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.amazon.a.a.i.h;

/* compiled from: FailurePrompt.java */
/* loaded from: classes.dex */
public class a extends h {
    private static final String b = "a";
    private static final String e = "http://www.amazon.com/gp/mas/get-appstore/android/ref=mas_mx_mba_iap_dl";
    private static final String f = "Amazon Appstore required";
    private static final String g = "Amazon Appstore Update Required";
    private static final long j = 31536000;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a h;
    private final com.amazon.a.a.i.c i;

    @Override // com.amazon.a.a.e.c
    protected long h() {
        return 31536000L;
    }

    public a(com.amazon.a.a.i.c cVar) {
        super(cVar);
        this.i = cVar;
    }

    @Override // com.amazon.a.a.i.h
    protected void i() {
        com.amazon.device.iap.internal.util.b.a(b, "doAction");
        if (f.equalsIgnoreCase(this.i.e()) || g.equalsIgnoreCase(this.i.e())) {
            try {
                Activity b2 = this.h.b();
                if (b2 == null) {
                    b2 = this.h.a();
                }
                b2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(e)));
            } catch (Exception e2) {
                com.amazon.device.iap.internal.util.b.b(b, "Exception in PurchaseItemCommandTask.OnSuccess: " + e2);
            }
        }
    }

    public String toString() {
        return b;
    }
}
