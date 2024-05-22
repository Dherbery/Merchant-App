package com.amazon.a.a.m;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ExpirableValueDataStore.java */
/* loaded from: classes.dex */
public class b implements com.amazon.a.a.e.b<a> {
    private static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("ExpirableValueDataStore");

    @com.amazon.a.a.k.a
    private com.amazon.a.a.k.b b;
    private final Map<String, a> c = new HashMap();

    public synchronized boolean a(String str) {
        return b(str) != null;
    }

    public synchronized <T> T b(String str) {
        if (com.amazon.a.a.o.c.a) {
            a.a("Fetching value: " + str);
        }
        a aVar = this.c.get(str);
        if (aVar == null) {
            if (com.amazon.a.a.o.c.a) {
                a.a("Value not present in store, returning null");
            }
            return null;
        }
        return (T) aVar.h();
    }

    public synchronized void a(String str, a aVar) {
        com.amazon.a.a.o.a.a.a((Object) str, SubscriberAttributeKt.JSON_NAME_KEY);
        com.amazon.a.a.o.a.a.a((Object) aVar, "value");
        if (com.amazon.a.a.o.c.a) {
            a.a("Placing value into store with key: " + str + ", expiration: " + aVar.a());
        }
        this.b.b(aVar);
        aVar.a(this);
        this.c.put(str, aVar);
    }

    public synchronized <T> void a(String str, T t) {
        if (com.amazon.a.a.o.c.a) {
            a.a("Placing non-expiring value into store with key: " + str);
        }
        this.c.put(str, new a(t, new Date()) { // from class: com.amazon.a.a.m.b.1
            @Override // com.amazon.a.a.e.a
            protected void d() {
                if (com.amazon.a.a.o.c.b) {
                    b.a.b("Woah, non-expirable value was expired!!!!");
                }
            }
        });
    }

    public synchronized void c(String str) {
        a aVar = this.c.get(str);
        if (aVar == null) {
            return;
        }
        if (com.amazon.a.a.o.c.a) {
            a.a("Removing value associated with key: " + str + ", value: " + aVar);
        }
        this.c.remove(str);
        aVar.f();
    }

    @Override // com.amazon.a.a.e.b
    public synchronized void a(a aVar) {
        if (com.amazon.a.a.o.c.a) {
            a.a("Observed expiration: " + aVar + " removing from store!");
        }
        Iterator<Map.Entry<String, a>> it = this.c.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue() == aVar) {
                if (com.amazon.a.a.o.c.a) {
                    a.a("Removing entry from store: " + aVar);
                }
                it.remove();
            }
        }
    }

    public String toString() {
        return this.c.toString();
    }
}
