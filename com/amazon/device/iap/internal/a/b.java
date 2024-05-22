package com.amazon.device.iap.internal.a;

import java.util.HashMap;
import java.util.Map;

/* compiled from: KiwiImplementationRegistry.java */
/* loaded from: classes.dex */
public final class b implements com.amazon.device.iap.internal.c {
    private static final Map<Class, Class> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(com.amazon.device.iap.internal.e.class, d.class);
    }

    @Override // com.amazon.device.iap.internal.c
    public <T> Class<T> a(Class<T> cls) {
        return a.get(cls);
    }
}
