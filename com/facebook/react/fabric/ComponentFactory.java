package com.facebook.react.fabric;

import com.facebook.jni.HybridData;

/* loaded from: classes3.dex */
public class ComponentFactory {
    private final HybridData mHybridData = initHybrid();

    private static native HybridData initHybrid();

    static {
        FabricSoLoader.staticInit();
    }
}
