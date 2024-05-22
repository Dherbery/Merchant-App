package com.amazon.a.a.n.a;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.RemoteException;
import com.amazon.d.a.d;
import com.amazon.d.a.e;
import com.amazon.d.a.i;
import com.amazon.d.a.j;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: CommandServiceClient.java */
/* loaded from: classes.dex */
public class d {
    private static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("CommandServiceClient");
    private static final String b = "com.amazon.venezia.service.command.CommandServiceImpl";
    private static final String c = "com.amazon.venezia.CommandService";
    private com.amazon.d.a.d d;
    private String e;

    @com.amazon.a.a.k.a
    private Application h;

    @com.amazon.a.a.k.a
    private b i;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c j;
    private final BlockingQueue<c> f = new LinkedBlockingQueue();
    private final BlockingQueue<com.amazon.d.a.d> g = new LinkedBlockingQueue();
    private final ServiceConnection k = new ServiceConnection() { // from class: com.amazon.a.a.n.a.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.a.a("onServiceConnected");
            d.this.g.add(d.a.a(iBinder));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.a.a("onServiceDisconnected!!!");
        }
    };
    private final com.amazon.d.a.i l = new i.a() { // from class: com.amazon.a.a.n.a.d.2
        @Override // com.amazon.d.a.i
        public void a(j jVar) throws RemoteException {
            d.this.f.add(new c(jVar));
        }

        @Override // com.amazon.d.a.i
        public void a(com.amazon.d.a.h hVar) throws RemoteException {
            d.this.f.add(new c(hVar));
        }

        @Override // com.amazon.d.a.i
        public void a(com.amazon.d.a.f fVar) throws RemoteException {
            d.this.f.add(new c(fVar));
        }

        @Override // com.amazon.d.a.i
        public void a(com.amazon.d.a.g gVar) throws RemoteException {
            d.this.f.add(new c(gVar));
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommandServiceClient.java */
    /* loaded from: classes.dex */
    public static class a {
        int a;
        boolean b;
        long c;

        a() {
        }
    }

    public c a(com.amazon.d.a.c cVar) throws com.amazon.a.a.n.a.a.c, com.amazon.a.a.n.a.a.b, RemoteException {
        a aVar = new a();
        aVar.a = 6;
        aVar.c = 100L;
        while (true) {
            try {
                if (!d()) {
                    e();
                }
                return b(cVar);
            } catch (com.amazon.a.a.n.a.a.b e) {
                a(e, aVar);
                if (!aVar.b) {
                    throw e;
                }
            } catch (com.amazon.a.a.n.a.a.c e2) {
                a(e2, aVar);
                if (!aVar.b) {
                    throw e2;
                }
            }
        }
    }

    static void a(com.amazon.a.a.d.b bVar, a aVar) {
        com.amazon.a.a.o.c cVar = a;
        cVar.b("CommandServiceException happened, retriesLeft=" + aVar.a, bVar);
        if (aVar.a == 0) {
            aVar.b = false;
            return;
        }
        aVar.a--;
        aVar.b = true;
        try {
            cVar.a("Sleeping for " + aVar.c + " ms");
            Thread.sleep(aVar.c);
        } catch (InterruptedException unused) {
            aVar.b = false;
        }
        aVar.c *= 2;
    }

    private boolean d() {
        return this.d != null;
    }

    public String a() {
        return this.e;
    }

    private void e() throws com.amazon.a.a.n.a.a.b, com.amazon.a.a.n.a.a.c {
        long currentTimeMillis = System.currentTimeMillis();
        com.amazon.a.a.o.c cVar = a;
        cVar.a("Binding Service!!!");
        Intent f = f();
        if (!a(this.h, f)) {
            throw new com.amazon.a.a.n.a.a.c();
        }
        cVar.a("Found service on one or more packages");
        Intent a2 = a(f);
        String packageName = a2.getComponent().getPackageName();
        cVar.a("Attempting to bind to service on " + packageName);
        if (!this.h.bindService(a2, this.k, 1)) {
            throw new com.amazon.a.a.n.a.a.b();
        }
        try {
            cVar.a("Blocking while service is being bound!!");
            this.d = this.g.take();
            cVar.a("service bound, returning!!");
            if (com.amazon.a.a.o.c.a) {
                cVar.a("Kiwi.BindService Time: " + (System.currentTimeMillis() - currentTimeMillis));
            }
            this.j.a(com.amazon.a.a.m.c.f, packageName);
            this.e = packageName;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new com.amazon.a.a.n.a.a.b();
        }
    }

    private boolean a(Context context, Intent intent) {
        return context.getPackageManager().resolveService(intent, 64) != null;
    }

    private Intent f() {
        Intent intent = new Intent();
        intent.setAction(c);
        a.a("Created intent with  action  com.amazon.venezia.CommandService");
        return intent;
    }

    private Intent a(String str) {
        Intent intent = new Intent();
        intent.setAction(c);
        intent.setClassName(str, b);
        return intent;
    }

    private Intent a(Intent intent) throws com.amazon.a.a.n.a.a.c {
        if (this.e != null) {
            a.a("Using previously determined package " + this.e);
            return a(this.e);
        }
        com.amazon.a.a.o.c cVar = a;
        cVar.a("No previously determined package found, checking for suitable package.");
        Intent a2 = a(this.h.getPackageManager().queryIntentServices(intent, 64));
        if (a2 != null) {
            return a2;
        }
        cVar.a("No app with valid signature was providing our service.");
        throw new com.amazon.a.a.n.a.a.c();
    }

    private Intent a(List<ResolveInfo> list) {
        int i = 0;
        String str = null;
        while (true) {
            try {
                if (i >= list.size()) {
                    i = -1;
                    break;
                }
                ResolveInfo resolveInfo = list.get(i);
                String str2 = resolveInfo.serviceInfo.applicationInfo.packageName;
                com.amazon.a.a.o.c cVar = a;
                cVar.a("Examining package " + str2);
                cVar.a("Priority is " + resolveInfo.filter.getPriority());
                cVar.a("Checking signature of package " + str2);
                if (b(str2)) {
                    cVar.a("Signature of package " + str2 + " is okay");
                    str = str2;
                    break;
                }
                cVar.a("Signature of package " + str2 + " is bad");
                i++;
                str = str2;
            } catch (Exception e) {
                a.a("Caught exception " + e);
            }
        }
        if (i > -1) {
            return a(str);
        }
        return null;
    }

    private c b(com.amazon.d.a.c cVar) throws RemoteException {
        this.j.a(com.amazon.a.a.m.c.g, cVar.b());
        this.d.a(cVar, this.l);
        return g();
    }

    private c g() throws RemoteException {
        try {
            com.amazon.a.a.o.c cVar = a;
            cVar.a("Blocking for result from service");
            c take = this.f.take();
            cVar.a("Received result from service");
            return take;
        } catch (InterruptedException unused) {
            a.a("TaskThread interrupted, returning null result");
            return null;
        }
    }

    public c a(com.amazon.d.a.a aVar) throws RemoteException {
        aVar.a(null);
        return g();
    }

    public c a(com.amazon.d.a.f fVar, final e eVar) throws RemoteException {
        fVar.a(new e.a() { // from class: com.amazon.a.a.n.a.d.3
            @Override // com.amazon.d.a.e
            public Map b() throws RemoteException {
                return null;
            }

            @Override // com.amazon.d.a.e
            public String a() throws RemoteException {
                return eVar.name();
            }
        });
        return g();
    }

    public void b() {
        com.amazon.a.a.o.c cVar = a;
        StringBuilder sb = new StringBuilder("Finishing CommandServiceClient, unbinding service: ");
        sb.append(this.d != null);
        cVar.a(sb.toString());
        if (this.d != null) {
            this.h.unbindService(this.k);
            this.d = null;
        }
    }

    private boolean b(String str) {
        a.a("isPackageSignatureTrusted " + str);
        return this.i.a(str, i.a);
    }
}
