package com.amazon.device.simplesignin.a;

import android.app.Application;
import android.content.Context;

/* compiled from: HandlerFactory.java */
/* loaded from: classes.dex */
class a {
    private static final String a = "a";
    private static final a b = new a();
    private static volatile b c;

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    if (b(context)) {
                        c = new com.amazon.device.simplesignin.a.c.b();
                        com.amazon.device.simplesignin.a.d.a.a(a, "SDK initialized in Sandbox mode.");
                    } else {
                        c = new com.amazon.device.simplesignin.a.a.b();
                        com.amazon.device.simplesignin.a.d.a.a(a, "SDK initialized in Production mode.");
                    }
                }
            }
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Context context) {
        return com.amazon.a.a.a((Application) context.getApplicationContext());
    }
}
