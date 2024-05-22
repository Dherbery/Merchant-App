package com.amazon.a.b.a;

import com.amazon.a.a.d.b;
import com.amazon.a.a.o.b.f;
import com.amazon.a.a.o.d.c;
import java.util.Iterator;

/* compiled from: LicenseVerificationException.java */
/* loaded from: classes.dex */
public class a extends b {
    private static final long a = 1;
    private final c b;

    public a(c cVar) {
        super("LICENSE_VERIFICATION_FAILURE", "VERIFICATION_ERRORS", a(cVar));
        com.amazon.a.a.o.a.a.a(cVar.a(), "Created a verification exception with a Verifier that has no errors");
        this.b = cVar;
    }

    private static String a(c cVar) {
        StringBuilder sb = new StringBuilder();
        Iterator<com.amazon.a.a.o.d.a> it = cVar.iterator();
        while (it.hasNext()) {
            com.amazon.a.a.o.d.a next = it.next();
            if (sb.length() != 0) {
                sb.append(f.a);
            }
            sb.append(next.a().a());
        }
        return sb.toString();
    }

    public c d() {
        return this.b;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return this.b.toString();
    }
}
