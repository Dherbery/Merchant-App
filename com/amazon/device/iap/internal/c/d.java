package com.amazon.device.iap.internal.c;

import java.util.HashMap;
import java.util.Map;

/* compiled from: SandboxImplementationRegistry.java */
/* loaded from: classes.dex */
public final class d implements com.amazon.device.iap.internal.c {
    private static final Map<Class, Class> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(com.amazon.device.iap.internal.e.class, e.class);
    }

    @Override // com.amazon.device.iap.internal.c
    public <T> Class<T> a(Class<T> cls) {
        return a.get(cls);
    }
}
