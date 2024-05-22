package com.mrousavy.camera.frameprocessor;

import com.facebook.jni.HybridData;

/* loaded from: classes5.dex */
public final class FrameProcessor {
    private final HybridData mHybridData;

    public native void call(Frame frame);

    public FrameProcessor(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
