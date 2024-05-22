package com.reactnativeimageresizer;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

/* loaded from: classes5.dex */
abstract class ImageResizerSpec extends ReactContextBaseJavaModule {
    public abstract void createResizedImage(String str, double d, double d2, String str2, double d3, String str3, boolean z, Double d4, String str4, Boolean bool, Promise promise);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageResizerSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }
}
