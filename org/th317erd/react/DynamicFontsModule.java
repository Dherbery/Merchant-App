package org.th317erd.react;

import android.graphics.Typeface;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.views.text.ReactFontManager;
import java.io.File;

/* loaded from: classes6.dex */
class DynamicFontsModule extends ReactContextBaseJavaModule {
    WritableMap response;
    int tempNameCounter;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "DynamicFonts";
    }

    public DynamicFontsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.tempNameCounter = 0;
    }

    @ReactMethod
    public void loadFontFromFile(ReadableMap readableMap, Callback callback) {
        if (getCurrentActivity() == null) {
            callback.invoke("Invalid activity");
            return;
        }
        String string = readableMap.hasKey("filePath") ? readableMap.getString("filePath") : null;
        String string2 = readableMap.hasKey("name") ? readableMap.getString("name") : null;
        if (string == null || string.length() == 0) {
            callback.invoke("filePath property empty");
            return;
        }
        File file = new File(string);
        if (file.exists() && file.canRead()) {
            try {
                Typeface createFromFile = Typeface.createFromFile(file);
                ReactFontManager.getInstance().setTypeface(string2, createFromFile.getStyle(), createFromFile);
                callback.invoke(null, string2);
                return;
            } catch (Throwable th) {
                callback.invoke(th.getMessage());
                return;
            }
        }
        callback.invoke("invalid file");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f4 A[Catch: all -> 0x013a, Exception -> 0x013c, TryCatch #0 {Exception -> 0x013c, blocks: (B:41:0x00bd, B:44:0x00e7, B:46:0x00f4, B:47:0x0105, B:49:0x010b, B:50:0x011d, B:55:0x0136, B:56:0x0139), top: B:40:0x00bd, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010b A[Catch: all -> 0x013a, Exception -> 0x013c, TryCatch #0 {Exception -> 0x013c, blocks: (B:41:0x00bd, B:44:0x00e7, B:46:0x00f4, B:47:0x0105, B:49:0x010b, B:50:0x011d, B:55:0x0136, B:56:0x0139), top: B:40:0x00bd, outer: #2 }] */
    @com.facebook.react.bridge.ReactMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadFont(com.facebook.react.bridge.ReadableMap r12, com.facebook.react.bridge.Callback r13) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.th317erd.react.DynamicFontsModule.loadFont(com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.Callback):void");
    }
}
