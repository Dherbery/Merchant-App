package com.amazon.device.iap.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.a.a.o.f;

/* compiled from: CursorUtil.java */
/* loaded from: classes.dex */
public class a {
    private static final String a = a.class.getName() + "_PREFS";

    public static String a(String str) {
        f.a((Object) str, "userId");
        Context b = com.amazon.device.iap.internal.d.e().b();
        f.a(b, "context");
        return b.getSharedPreferences(a, 0).getString(str, null);
    }

    public static void a(String str, String str2) {
        f.a((Object) str, "userId");
        Context b = com.amazon.device.iap.internal.d.e().b();
        f.a(b, "context");
        SharedPreferences.Editor edit = b.getSharedPreferences(a, 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }
}
