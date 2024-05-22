package com.amazon.a.a.c;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import java.util.Map;

/* compiled from: EventManagerImpl.java */
/* loaded from: classes.dex */
public class g implements f {
    private static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("EventManagerImpl");
    private final Map<b, e<?>> b = new HashMap();

    @Override // com.amazon.a.a.c.f
    public <T extends a> void a(c<T> cVar) {
        com.amazon.a.a.o.a.a.a((Object) cVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        com.amazon.a.a.o.a.a.a();
        b a2 = cVar.a();
        a.a("Registering listener for event: " + a2 + ", " + cVar);
        e<?> eVar = this.b.get(a2);
        if (eVar == null) {
            eVar = new e<>();
            this.b.put(a2, eVar);
        }
        eVar.a((c<?>) cVar);
    }

    @Override // com.amazon.a.a.c.f
    public void a(a aVar) {
        b a2 = aVar.a();
        if (com.amazon.a.a.o.c.a) {
            a.a("Posting event: " + a2);
        }
        if (!this.b.containsKey(a2)) {
            if (com.amazon.a.a.o.c.a) {
                a.a("No registered listeners, returning");
                return;
            }
            return;
        }
        this.b.get(a2).a((e<?>) aVar);
    }
}
