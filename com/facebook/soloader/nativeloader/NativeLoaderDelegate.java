package com.facebook.soloader.nativeloader;

import java.io.IOException;

/* loaded from: classes3.dex */
public interface NativeLoaderDelegate {
    public static final int SKIP_MERGED_JNI_ONLOAD = 1;

    String getLibraryPath(String str) throws IOException;

    int getSoSourcesVersion();

    boolean loadLibrary(String str, int i);
}
