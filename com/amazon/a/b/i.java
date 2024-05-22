package com.amazon.a.b;

import java.lang.reflect.Method;

/* compiled from: NotifyDeveloperOfDRMSuccessTask.java */
/* loaded from: classes.dex */
public class i implements com.amazon.a.a.n.a {
    private static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("DRMSuccessTask");
    private static final String b = "com.amazon.drm.AmazonLicenseVerificationCallback";
    private static final String c = "onDRMSuccess";

    @Override // com.amazon.a.a.n.a
    public void a() {
        Method a2;
        Class<?> a3 = com.amazon.a.a.o.d.a(b);
        if (a3 == null || (a2 = a(a3, c)) == null) {
            return;
        }
        if (com.amazon.a.a.o.c.a) {
            a.a("Invoking callback: " + a2.getName());
        }
        try {
            a2.invoke(null, new Object[0]);
            if (com.amazon.a.a.o.c.a) {
                a.a("Callback invoked.");
            }
        } catch (Exception unused) {
        }
    }

    private static Method a(Class<?> cls, String str) {
        com.amazon.a.a.o.a.a.a((Object) cls, "Class<?> target");
        com.amazon.a.a.o.a.a.a((Object) str, "String methodName");
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
            if (declaredMethod == null) {
                if (com.amazon.a.a.o.c.a) {
                    a.a("No exception thrown, but method '" + str + "' was not found, this should not happen. ");
                }
                return null;
            }
            declaredMethod.setAccessible(true);
            if (!com.amazon.a.a.o.d.c(declaredMethod)) {
                if (com.amazon.a.a.o.c.a) {
                    a.a("Callback " + str + " isn't static, ignoring...");
                }
                return null;
            }
            if (!com.amazon.a.a.o.d.b(declaredMethod)) {
                if (com.amazon.a.a.o.c.a) {
                    a.a("Callback " + str + " returns a value, ignoring...");
                }
                return null;
            }
            if (!com.amazon.a.a.o.d.a(declaredMethod)) {
                return declaredMethod;
            }
            if (com.amazon.a.a.o.c.a) {
                a.a("Callback " + str + " takes parameters, ignoring...");
            }
            return null;
        } catch (NoSuchMethodException unused) {
            if (com.amazon.a.a.o.c.a) {
                a.a("Did not find method " + str);
            }
            return null;
        }
    }
}
