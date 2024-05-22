package com.amazon.device.iap.internal.a.g;

/* compiled from: ResponseReceivedCommandV2.java */
/* loaded from: classes.dex */
public final class c extends a {
    public c(com.amazon.device.iap.internal.a.c cVar, boolean z) {
        super(cVar, com.amazon.a.a.o.b.ae);
        a(com.amazon.a.a.o.b.aa, Boolean.valueOf(z));
    }

    @Override // com.amazon.a.a.n.a.h
    public void l() {
        Object a = j().a().a(com.amazon.a.a.o.b.al);
        if (a != null && Boolean.TRUE.equals(a)) {
            a(com.amazon.a.a.o.b.ab, (Object) true);
        } else {
            a(com.amazon.a.a.o.b.ab, (Object) false);
        }
        super.l();
    }
}
