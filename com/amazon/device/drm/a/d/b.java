package com.amazon.device.drm.a.d;

import java.util.HashMap;
import java.util.Map;

/* compiled from: SandboxImplementationRegistry.java */
/* loaded from: classes.dex */
public final class b implements com.amazon.device.drm.a.b {
    private static final Map<Class, Class> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(com.amazon.device.drm.a.c.class, c.class);
    }

    @Override // com.amazon.device.drm.a.b
    public <T> Class<T> a(Class<T> cls) {
        return a.get(cls);
    }
}
