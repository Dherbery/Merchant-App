package com.amazon.a.a.g;

import android.util.Log;

/* compiled from: SandboxLogHandler.java */
/* loaded from: classes.dex */
public class d implements c {
    private static final boolean a = true;
    private static final boolean b = true;
    private static final boolean c = true;

    @Override // com.amazon.a.a.g.c
    public boolean a() {
        return true;
    }

    @Override // com.amazon.a.a.g.c
    public boolean b() {
        return true;
    }

    @Override // com.amazon.a.a.g.c
    public boolean c() {
        return true;
    }

    @Override // com.amazon.a.a.g.c
    public void a(String str, String str2) {
        Log.d(str, a(str2));
    }

    @Override // com.amazon.a.a.g.c
    public void b(String str, String str2) {
        Log.e(str, a(str2));
    }

    @Override // com.amazon.a.a.g.c
    public void c(String str, String str2) {
        Log.v(str, a(str2));
    }

    private static String a(String str) {
        return "Appstore SDK - Sandbox Mode: " + str;
    }
}
