package com.amazon.a.a.o;

import android.util.Log;

/* compiled from: KiwiLogger.java */
/* loaded from: classes.dex */
public class c {
    public static boolean a = true;
    public static boolean b = true;
    private static boolean c = false;
    private static final String d = "Kiwi";
    private String e;

    public c(String str) {
        this.e = str;
    }

    public void a(String str) {
        if (a) {
            Log.d(d, d(str));
        }
    }

    private String d(String str) {
        return this.e + ": " + str;
    }

    public void a(String str, Throwable th) {
        if (a) {
            Log.d(d, d(str), th);
        }
    }

    public void b(String str) {
        if (b) {
            Log.e(d, d(str));
        }
    }

    public void b(String str, Throwable th) {
        if (b) {
            Log.e(d, d(str), th);
        }
    }

    public void c(String str) {
        if (c) {
            Log.e(d, "TEST-" + d(str));
        }
    }

    public static void a() {
        c = true;
    }

    public static boolean b() {
        return c;
    }
}
