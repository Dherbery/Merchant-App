package com.amazon.a.a.d;

import com.revenuecat.purchases.common.Constants;

/* compiled from: KiwiException.java */
/* loaded from: classes.dex */
public abstract class b extends Exception {
    private static final long a = 1;
    private final String b;
    private final String c;
    private final String d;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(String str) {
        this(str, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(String str, String str2) {
        this(str, str2, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(String str, String str2, String str3) {
        super(str + ": " + str2 + ": " + str3);
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(String str, Throwable th) {
        this(str, b(th), th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(String str, String str2, Throwable th) {
        this(str, str2, a(th));
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    private static String a(Throwable th) {
        if (th == null) {
            return null;
        }
        Throwable c = c(th);
        StringBuilder sb = new StringBuilder();
        sb.append(b(th));
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append(th.getMessage());
        if (th != c) {
            sb.append("/");
            sb.append(b(c));
            sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb.append(c.getMessage());
        }
        return sb.toString();
    }

    private static String b(Throwable th) {
        return th.getClass().getName();
    }

    private static Throwable c(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }
}
