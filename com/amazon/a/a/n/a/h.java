package com.amazon.a.a.n.a;

import android.os.RemoteException;
import com.amazon.d.a.j;
import java.util.HashMap;
import java.util.Map;

/* compiled from: KiwiCommand.java */
/* loaded from: classes.dex */
public abstract class h extends a {
    private static final com.amazon.a.a.o.c b = new com.amazon.a.a.o.c("KiwiCommand");
    private final com.amazon.a.a.j.a c;
    private final String d;
    private final String e;
    private final String f;
    private final Map<String, Object> g;
    private boolean i;
    private h j;
    private h k;
    private final com.amazon.a.b.f h = new com.amazon.a.b.f();
    private boolean l = false;

    protected void b(com.amazon.d.a.h hVar) {
    }

    protected abstract boolean b(j jVar) throws Exception;

    protected void c(com.amazon.a.a.d.b bVar) {
    }

    @Override // com.amazon.a.a.n.a.a
    protected boolean d() {
        return true;
    }

    public h(com.amazon.a.a.j.a aVar, String str, String str2, String str3, String str4) {
        this.c = aVar;
        this.d = str3;
        this.e = str;
        this.f = str2;
        HashMap hashMap = new HashMap();
        this.g = hashMap;
        hashMap.put(com.amazon.a.a.o.b.B, str3);
        hashMap.put(com.amazon.a.a.o.b.I, str4);
        this.i = true;
        this.j = null;
        this.k = null;
    }

    public h a(boolean z) {
        this.l = z;
        return this;
    }

    public boolean i() {
        return this.l;
    }

    public void a(h hVar) {
        this.j = hVar;
    }

    public void b(h hVar) {
        this.k = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, Object obj) {
        this.g.put(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.amazon.a.a.j.a j() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String k() {
        return this.d;
    }

    @Override // com.amazon.a.a.n.a.a
    protected String a_() {
        return this.e;
    }

    @Override // com.amazon.a.a.n.a.a
    protected String c() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amazon.a.a.n.a.a
    public Map<String, Object> b() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(boolean z) {
        this.i = z;
    }

    private void a(com.amazon.a.a.i.c cVar) {
        if (cVar == null) {
            return;
        }
        com.amazon.a.a.i.a aVar = new com.amazon.a.a.i.a(cVar);
        com.amazon.a.a.i.e a = com.amazon.a.a.a();
        if (a == null) {
            b.b("Prompt manager is null. Cannot show prompt dropping request");
        } else {
            a.a((com.amazon.a.a.i.b) aVar);
        }
    }

    @Override // com.amazon.a.a.n.a.a
    protected void a(j jVar) throws RemoteException, com.amazon.a.a.d.b {
        boolean z;
        h hVar;
        String str = (String) jVar.b().get("errorMessage");
        b.a("onSuccess: result = " + jVar + ", errorMessage: " + str);
        if (com.amazon.a.a.o.f.a(str)) {
            try {
                z = b(jVar);
            } catch (Exception e) {
                b.a("Error calling onResult: " + e);
                z = false;
            }
            if (z && (hVar = this.j) != null) {
                hVar.l();
                return;
            } else {
                if (this.l) {
                    return;
                }
                if (z) {
                    this.c.b();
                    return;
                } else {
                    this.c.c();
                    return;
                }
            }
        }
        if (this.l) {
            return;
        }
        this.c.c();
    }

    @Override // com.amazon.a.a.n.a.a
    protected void a(com.amazon.d.a.h hVar) throws RemoteException, com.amazon.a.a.d.b {
        h hVar2;
        String str;
        b.a("onFailure: result = " + hVar);
        if (((hVar == null || (str = (String) hVar.f().get(com.amazon.a.a.o.b.ak)) == null || !str.equalsIgnoreCase("1.0")) ? false : true) && (hVar2 = this.k) != null) {
            hVar2.a(this.l);
            this.k.l();
            return;
        }
        try {
            b(hVar);
        } catch (Exception e) {
            b.a("Error calling onResult: " + e);
        }
        if (this.i) {
            a(new com.amazon.a.a.i.c(hVar.b(), hVar.c(), hVar.d(), hVar.e()));
        }
        if (this.l) {
            return;
        }
        this.c.c();
    }

    @Override // com.amazon.a.a.n.a.a
    protected void b(com.amazon.a.a.d.b bVar) {
        h hVar;
        if ("UNHANDLED_EXCEPTION".equals(bVar.a()) && com.amazon.a.a.o.b.ae.equals(this.f) && (hVar = this.k) != null) {
            hVar.a(this.l);
            this.k.l();
            return;
        }
        try {
            c(bVar);
        } catch (Exception e) {
            b.a("Error calling onResult: " + e);
        }
        if (this.i) {
            a(this.h.a(bVar));
        }
        if (this.l) {
            return;
        }
        this.c.c();
    }

    public void l() {
        com.amazon.a.a.a(this);
    }
}
