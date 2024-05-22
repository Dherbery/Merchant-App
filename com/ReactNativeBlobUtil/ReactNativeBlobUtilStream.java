package com.ReactNativeBlobUtil;

import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: classes.dex */
public class ReactNativeBlobUtilStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final HashMap<String, ReactNativeBlobUtilStream> fileStreams = new HashMap<>();
    private final DeviceEventManagerModule.RCTDeviceEventEmitter emitter;
    private String encoding = ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64;
    private OutputStream writeStreamInstance = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReactNativeBlobUtilStream(ReactApplicationContext reactApplicationContext) {
        this.emitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0114 A[Catch: Exception -> 0x011d, FileNotFoundException -> 0x013b, TryCatch #0 {Exception -> 0x011d, blocks: (B:5:0x001a, B:12:0x002d, B:14:0x0033, B:15:0x005d, B:19:0x006a, B:20:0x007c, B:22:0x0082, B:24:0x008c, B:29:0x0093, B:33:0x0114, B:34:0x0119, B:38:0x009a, B:40:0x00a2, B:41:0x00a4, B:43:0x00ab, B:45:0x00b2, B:47:0x00ba, B:50:0x00bf, B:55:0x00c7, B:57:0x00cd, B:58:0x00cf, B:62:0x00d9, B:66:0x00f3, B:70:0x00e7, B:72:0x00fa, B:77:0x0044, B:78:0x0053), top: B:4:0x001a }] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void readStream(java.lang.String r17, java.lang.String r18, int r19, int r20, java.lang.String r21, com.facebook.react.bridge.ReactApplicationContext r22) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilStream.readStream(java.lang.String, java.lang.String, int, int, java.lang.String, com.facebook.react.bridge.ReactApplicationContext):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeStream(String str, String str2, boolean z, Callback callback) {
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!file.exists()) {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    callback.invoke("ENOTDIR", "Failed to create parent directory of '" + str + "'");
                    return;
                }
                if (!file.createNewFile()) {
                    callback.invoke("ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            } else if (file.isDirectory()) {
                callback.invoke("EISDIR", "Expecting a file but '" + str + "' is a directory");
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str, z);
            this.encoding = str2;
            String uuid = UUID.randomUUID().toString();
            fileStreams.put(uuid, this);
            this.writeStreamInstance = fileOutputStream;
            callback.invoke(null, null, uuid);
        } catch (Exception e) {
            callback.invoke("EUNSPECIFIED", "Failed to create write stream at path `" + str + "`; " + e.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeChunk(String str, String str2, Callback callback) {
        ReactNativeBlobUtilStream reactNativeBlobUtilStream = fileStreams.get(str);
        try {
            reactNativeBlobUtilStream.writeStreamInstance.write(ReactNativeBlobUtilUtils.stringToBytes(str2, reactNativeBlobUtilStream.encoding));
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeArrayChunk(String str, ReadableArray readableArray, Callback callback) {
        try {
            OutputStream outputStream = fileStreams.get(str).writeStreamInstance;
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            outputStream.write(bArr);
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void closeStream(String str, Callback callback) {
        try {
            HashMap<String, ReactNativeBlobUtilStream> hashMap = fileStreams;
            OutputStream outputStream = hashMap.get(str).writeStreamInstance;
            hashMap.remove(str);
            outputStream.close();
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    private void emitStreamEvent(String str, String str2, String str3) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        createMap.putString("detail", str3);
        createMap.putString("streamId", str);
        this.emitter.emit(ReactNativeBlobUtilConst.EVENT_FILESYSTEM, createMap);
    }

    private void emitStreamEvent(String str, String str2, WritableArray writableArray) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        createMap.putArray("detail", writableArray);
        createMap.putString("streamId", str);
        this.emitter.emit(ReactNativeBlobUtilConst.EVENT_FILESYSTEM, createMap);
    }

    private void emitStreamEvent(String str, String str2, String str3, String str4) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        createMap.putString("code", str3);
        createMap.putString("detail", str4);
        createMap.putString("streamId", str);
        this.emitter.emit(ReactNativeBlobUtilConst.EVENT_FILESYSTEM, createMap);
    }

    public static InputStream inputStreamFromPath(String str) throws IOException {
        if (str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)) {
            return ReactNativeBlobUtilImpl.RCTContext.getAssets().open(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
        }
        return new FileInputStream(new File(str));
    }
}
