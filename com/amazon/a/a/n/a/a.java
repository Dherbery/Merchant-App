package com.amazon.a.a.n.a;

import android.app.Application;
import android.content.Intent;
import android.os.RemoteException;
import com.amazon.d.a.c;
import com.amazon.d.a.j;
import java.util.Map;

/* compiled from: AbstractCommandTask.java */
/* loaded from: classes.dex */
public abstract class a extends com.amazon.a.a.n.c.a {
    private static final com.amazon.a.a.o.c b = new com.amazon.a.a.o.c("AbstractCommandTask");

    @com.amazon.a.a.k.a
    protected com.amazon.a.a.l.b a;

    @com.amazon.a.a.k.a
    private Application c;

    @com.amazon.a.a.k.a
    private d d;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.i.e e;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.h.c f;

    @com.amazon.a.a.k.a
    private b g;

    protected abstract void a(com.amazon.d.a.h hVar) throws RemoteException, com.amazon.a.a.d.b;

    protected abstract void a(j jVar) throws RemoteException, com.amazon.a.a.d.b;

    protected abstract String a_();

    protected abstract Map<String, Object> b();

    protected abstract String c();

    protected abstract boolean d();

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() throws com.amazon.a.a.d.b {
    }

    protected boolean f() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
    
        if (com.amazon.a.a.o.c.a != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0080, code lost:
    
        j();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0083, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007b, code lost:
    
        com.amazon.a.a.n.a.a.b.a("Task finished");
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0079, code lost:
    
        if (com.amazon.a.a.o.c.a == false) goto L28;
     */
    @Override // com.amazon.a.a.n.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            r6 = this;
            java.lang.String r0 = "----------------------------------------------"
            java.lang.String r1 = "Task finished"
            java.lang.String r2 = "Executing Command: "
            java.lang.String r3 = "Executing: "
            boolean r4 = com.amazon.a.a.o.c.a     // Catch: java.lang.Throwable -> L73
            if (r4 == 0) goto L27
            com.amazon.a.a.o.c r4 = com.amazon.a.a.n.a.a.b     // Catch: java.lang.Throwable -> L73
            r4.a(r0)     // Catch: java.lang.Throwable -> L73
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L73
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L73
            java.lang.String r3 = r6.a_()     // Catch: java.lang.Throwable -> L73
            r5.append(r3)     // Catch: java.lang.Throwable -> L73
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L73
            r4.a(r3)     // Catch: java.lang.Throwable -> L73
            r4.a(r0)     // Catch: java.lang.Throwable -> L73
        L27:
            r6.e()     // Catch: java.lang.Throwable -> L73
            boolean r0 = r6.d()     // Catch: java.lang.Throwable -> L73
            if (r0 != 0) goto L48
            boolean r0 = com.amazon.a.a.o.c.a     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L3b
            com.amazon.a.a.o.c r0 = com.amazon.a.a.n.a.a.b     // Catch: java.lang.Throwable -> L73
            java.lang.String r2 = "Execution not needed, quitting"
            r0.a(r2)     // Catch: java.lang.Throwable -> L73
        L3b:
            boolean r0 = com.amazon.a.a.o.c.a
            if (r0 == 0) goto L44
            com.amazon.a.a.o.c r0 = com.amazon.a.a.n.a.a.b
            r0.a(r1)
        L44:
            r6.j()
            return
        L48:
            boolean r0 = com.amazon.a.a.o.c.a     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L61
            com.amazon.a.a.o.c r0 = com.amazon.a.a.n.a.a.b     // Catch: java.lang.Throwable -> L73
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L73
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L73
            java.lang.String r2 = r6.a_()     // Catch: java.lang.Throwable -> L73
            r3.append(r2)     // Catch: java.lang.Throwable -> L73
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L73
            r0.a(r2)     // Catch: java.lang.Throwable -> L73
        L61:
            com.amazon.a.a.n.a.d r0 = r6.d     // Catch: java.lang.Throwable -> L73
            com.amazon.d.a.c r2 = r6.i()     // Catch: java.lang.Throwable -> L73
            com.amazon.a.a.n.a.c r0 = r0.a(r2)     // Catch: java.lang.Throwable -> L73
            r6.a(r0)     // Catch: java.lang.Throwable -> L73
            boolean r0 = com.amazon.a.a.o.c.a
            if (r0 == 0) goto L80
            goto L7b
        L73:
            r0 = move-exception
            r6.a(r0)     // Catch: java.lang.Throwable -> L84
            boolean r0 = com.amazon.a.a.o.c.a
            if (r0 == 0) goto L80
        L7b:
            com.amazon.a.a.o.c r0 = com.amazon.a.a.n.a.a.b
            r0.a(r1)
        L80:
            r6.j()
            return
        L84:
            r0 = move-exception
            boolean r2 = com.amazon.a.a.o.c.a
            if (r2 == 0) goto L8e
            com.amazon.a.a.o.c r2 = com.amazon.a.a.n.a.a.b
            r2.a(r1)
        L8e:
            r6.j()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.a.a.n.a.a.a():void");
    }

    private void a(c cVar) throws com.amazon.a.a.d.b, RemoteException {
        if (com.amazon.a.a.o.c.a) {
            b.a("Received result from CommandService: " + cVar);
        }
        if (cVar == null) {
            if (com.amazon.a.a.o.c.a) {
                b.a("Received null result from command service, exiting task");
            }
        } else {
            if (cVar.e() != null) {
                a(cVar.e());
                return;
            }
            this.g.a(cVar.a(), this.d.a());
            if (cVar.b() != null) {
                b(cVar.b());
            } else if (cVar.c() != null) {
                b(cVar.c());
            } else if (f()) {
                a(cVar.d());
            }
        }
    }

    private void a(com.amazon.d.a.g gVar) throws RemoteException, com.amazon.a.a.d.b {
        throw new com.amazon.a.a.n.a.a.f(gVar);
    }

    private void b(j jVar) throws RemoteException, com.amazon.a.a.d.b {
        if (com.amazon.a.a.o.c.a) {
            b.a("Command executed successfully");
        }
        a(jVar);
    }

    private void b(com.amazon.d.a.h hVar) throws RemoteException, com.amazon.a.a.d.b {
        if (com.amazon.a.a.o.c.a) {
            b.a("Command failed execution: " + hVar.b());
        }
        a(hVar);
    }

    private void a(com.amazon.d.a.f fVar) throws RemoteException, com.amazon.a.a.d.b {
        if (com.amazon.a.a.o.c.a) {
            b.a("Handling Decision");
        }
        try {
            f fVar2 = new f(fVar);
            this.e.a((com.amazon.a.a.i.b) fVar2);
            com.amazon.d.a.a i = fVar2.i();
            if (i == null) {
                if (com.amazon.a.a.o.c.a) {
                    b.a("DecisionChooser returned null!!, expiring");
                }
                a(fVar, e.EXPIRATION_DURATION_ELAPSED);
                return;
            }
            a(fVar, i);
        } catch (com.amazon.a.a.n.a.a.e e) {
            a(fVar, e.a());
        }
    }

    private void a(com.amazon.d.a.f fVar, com.amazon.d.a.a aVar) throws RemoteException, com.amazon.a.a.d.b {
        if (com.amazon.a.a.o.c.a) {
            b.a("Handling customer choice: " + aVar);
        }
        Intent b2 = aVar.b();
        if (b2 != null) {
            if (com.amazon.a.a.o.c.a) {
                b.a("Choice has intent, scheduling it to be fired!!");
            }
            com.amazon.a.a.l.a a = this.a.a(b2);
            if (a == null) {
                if (com.amazon.a.a.o.c.a) {
                    b.a("No result recived, expiring decision");
                }
                a(fVar, e.EXPIRATION_DURATION_ELAPSED);
                return;
            } else if (a.d() == 0) {
                if (com.amazon.a.a.o.c.a) {
                    b.a("Result canceled, expiring decision");
                }
                a(fVar, e.ACTION_CANCELED);
                return;
            } else {
                if (com.amazon.a.a.o.c.a) {
                    b.a("Result received!!!, notifying service");
                }
                a(this.d.a(aVar));
                return;
            }
        }
        if (com.amazon.a.a.o.c.a) {
            b.a("No intent given, choosing now");
        }
        a(this.d.a(aVar));
    }

    private void a(com.amazon.d.a.f fVar, e eVar) throws RemoteException, com.amazon.a.a.d.b {
        if (com.amazon.a.a.o.c.a) {
            b.a("Expiring Decision: " + fVar + ", reason: " + eVar);
        }
        a(this.d.a(fVar, eVar));
    }

    private com.amazon.d.a.c i() {
        return new c.a() { // from class: com.amazon.a.a.n.a.a.1
            @Override // com.amazon.d.a.c
            public String a() throws RemoteException {
                return a.this.c();
            }

            @Override // com.amazon.d.a.c
            public String b() throws RemoteException {
                return a.this.a_();
            }

            @Override // com.amazon.d.a.c
            public Map c() throws RemoteException {
                return a.this.b();
            }

            @Override // com.amazon.d.a.c
            public String d() throws RemoteException {
                return a.this.c.getPackageName();
            }
        };
    }

    private void a(Throwable th) {
        if (com.amazon.a.a.o.c.a) {
            b.a("Exception occurred while processing task: " + th, th);
        }
        com.amazon.a.a.d.b b2 = b(th);
        b(b2);
        this.f.a(a(b2));
    }

    private com.amazon.a.a.d.b b(Throwable th) {
        if (th instanceof com.amazon.a.a.d.b) {
            return (com.amazon.a.a.d.b) th;
        }
        if (th instanceof RemoteException) {
            return new com.amazon.a.a.n.a.a.d((RemoteException) th);
        }
        return new com.amazon.a.a.n.a.a.h(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.amazon.a.a.h.a a(com.amazon.a.a.d.b bVar) {
        com.amazon.a.a.h.a aVar = new com.amazon.a.a.h.a(g());
        aVar.a("subType", bVar.a()).a("reason", bVar.b()).a("context", bVar.c());
        return aVar;
    }

    protected String g() {
        return a_() + "_failure";
    }

    protected String h() {
        return a_() + "_success";
    }

    protected void b(com.amazon.a.a.d.b bVar) {
        b.b("On Exception!!!!: " + bVar);
    }

    private void j() {
        if (m()) {
            return;
        }
        this.d.b();
    }
}
