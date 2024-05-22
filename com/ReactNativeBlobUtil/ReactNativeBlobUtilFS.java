package com.ReactNativeBlobUtil;

import android.content.res.AssetFileDescriptor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.StatFs;
import androidx.work.Data;
import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.revenuecat.purchases.common.verification.SigningManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ReactNativeBlobUtilFS {
    private DeviceEventManagerModule.RCTDeviceEventEmitter emitter;
    private ReactApplicationContext mCtx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReactNativeBlobUtilFS(ReactApplicationContext reactApplicationContext) {
        this.mCtx = reactApplicationContext;
        this.emitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean writeFile(String str, String str2, String str3, boolean z) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(ReactNativeBlobUtilUtils.normalizePath(str));
            File parentFile = file.getParentFile();
            if (!file.exists() && ((parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) || !file.createNewFile())) {
                return false;
            }
            if (str2.equalsIgnoreCase("uri")) {
                File file2 = new File(ReactNativeBlobUtilUtils.normalizePath(str3));
                if (!file2.exists()) {
                    return false;
                }
                byte[] bArr = new byte[Data.MAX_DATA_BYTES];
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file2);
                    try {
                        fileOutputStream = new FileOutputStream(file, z);
                        while (true) {
                            try {
                                int read = fileInputStream2.read(bArr);
                                if (read > 0) {
                                    fileOutputStream.write(bArr, 0, read);
                                } else {
                                    fileInputStream2.close();
                                    fileOutputStream.close();
                                    return true;
                                }
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } else {
                byte[] stringToBytes = ReactNativeBlobUtilUtils.stringToBytes(str3, str2);
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
                try {
                    fileOutputStream2.write(stringToBytes);
                    int length = stringToBytes.length;
                    return true;
                } finally {
                    fileOutputStream2.close();
                }
            }
        } catch (FileNotFoundException | Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeFile(String str, String str2, String str3, boolean z, boolean z2, Promise promise) {
        int length;
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!file.exists()) {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
                    promise.reject("EUNSPECIFIED", "Failed to create parent directory of '" + str + "'");
                    return;
                }
                if (!file.createNewFile()) {
                    promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            }
            if (str2.equalsIgnoreCase("uri")) {
                String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str3);
                File file2 = new File(normalizePath);
                if (!file2.exists()) {
                    promise.reject("ENOENT", "No such file '" + str + "' ('" + normalizePath + "')");
                    return;
                }
                byte[] bArr = new byte[Data.MAX_DATA_BYTES];
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file2);
                    try {
                        fileOutputStream = new FileOutputStream(file, z2);
                        length = 0;
                        while (true) {
                            try {
                                int read = fileInputStream2.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                                length += read;
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                        }
                        fileInputStream2.close();
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } else {
                byte[] stringToBytes = ReactNativeBlobUtilUtils.stringToBytes(str3, str2);
                if (z) {
                    if (ReactNativeBlobUtilFileTransformer.sharedFileTransformer == null) {
                        throw new IllegalStateException("Write file with transform was specified but the shared file transformer is not set");
                    }
                    stringToBytes = ReactNativeBlobUtilFileTransformer.sharedFileTransformer.onWriteFile(stringToBytes);
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, z2);
                try {
                    fileOutputStream2.write(stringToBytes);
                    length = stringToBytes.length;
                } finally {
                    fileOutputStream2.close();
                }
            }
            promise.resolve(Integer.valueOf(length));
        } catch (FileNotFoundException unused) {
            promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created, or it is a directory");
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeFile(String str, ReadableArray readableArray, boolean z, Promise promise) {
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!file.exists()) {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
                    promise.reject("ENOTDIR", "Failed to create parent directory of '" + str + "'");
                    return;
                }
                if (!file.createNewFile()) {
                    promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, z);
            try {
                byte[] bArr = new byte[readableArray.size()];
                for (int i = 0; i < readableArray.size(); i++) {
                    bArr[i] = (byte) readableArray.getInt(i);
                }
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                promise.resolve(Integer.valueOf(readableArray.size()));
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (FileNotFoundException unused) {
            promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created");
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0102 A[Catch: Exception -> 0x010a, FileNotFoundException -> 0x0113, TRY_LEAVE, TryCatch #2 {FileNotFoundException -> 0x0113, Exception -> 0x010a, blocks: (B:52:0x0010, B:54:0x0016, B:9:0x006d, B:13:0x0087, B:15:0x008b, B:16:0x0092, B:17:0x0099, B:18:0x009a, B:29:0x00dc, B:31:0x00e6, B:33:0x00ef, B:35:0x00f6, B:37:0x00fe, B:39:0x0102, B:41:0x00b6, B:44:0x00c0, B:47:0x00cb, B:7:0x0036, B:50:0x0052), top: B:51:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x006d A[Catch: Exception -> 0x010a, FileNotFoundException -> 0x0113, TryCatch #2 {FileNotFoundException -> 0x0113, Exception -> 0x010a, blocks: (B:52:0x0010, B:54:0x0016, B:9:0x006d, B:13:0x0087, B:15:0x008b, B:16:0x0092, B:17:0x0099, B:18:0x009a, B:29:0x00dc, B:31:0x00e6, B:33:0x00ef, B:35:0x00f6, B:37:0x00fe, B:39:0x0102, B:41:0x00b6, B:44:0x00c0, B:47:0x00cb, B:7:0x0036, B:50:0x0052), top: B:51:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void readFile(java.lang.String r7, java.lang.String r8, boolean r9, com.facebook.react.bridge.Promise r10) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.readFile(java.lang.String, java.lang.String, boolean, com.facebook.react.bridge.Promise):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Object> getSystemfolders(ReactApplicationContext reactApplicationContext) {
        HashMap hashMap = new HashMap();
        hashMap.put("DocumentDir", getFilesDirPath(reactApplicationContext));
        hashMap.put("CacheDir", getCacheDirPath(reactApplicationContext));
        hashMap.put("DCIMDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_DCIM));
        hashMap.put("PictureDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_PICTURES));
        hashMap.put("MusicDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_MUSIC));
        hashMap.put("DownloadDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_DOWNLOADS));
        hashMap.put("MovieDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_MOVIES));
        hashMap.put("RingtoneDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_RINGTONES));
        if (Environment.getExternalStorageState().equals("mounted")) {
            hashMap.put("SDCardDir", getExternalFilesDirPath(reactApplicationContext, null));
            File externalFilesDir = reactApplicationContext.getExternalFilesDir(null);
            if (externalFilesDir != null && externalFilesDir.getParentFile() != null) {
                hashMap.put("SDCardApplicationDir", externalFilesDir.getParentFile().getAbsolutePath());
            } else {
                hashMap.put("SDCardApplicationDir", "");
            }
        } else {
            hashMap.put("SDCardDir", "");
            hashMap.put("SDCardApplicationDir", "");
        }
        hashMap.put("MainBundleDir", reactApplicationContext.getApplicationInfo().dataDir);
        hashMap.put("LibraryDir", "");
        hashMap.put("ApplicationSupportDir", "");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Object> getLegacySystemfolders(ReactApplicationContext reactApplicationContext) {
        HashMap hashMap = new HashMap();
        hashMap.put("LegacyDCIMDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath());
        hashMap.put("LegacyPictureDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
        hashMap.put("LegacyMusicDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath());
        hashMap.put("LegacyDownloadDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
        hashMap.put("LegacyMovieDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath());
        hashMap.put("LegacyRingtoneDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES).getAbsolutePath());
        if (Environment.getExternalStorageState().equals("mounted")) {
            hashMap.put("LegacySDCardDir", Environment.getExternalStorageDirectory().getAbsolutePath());
        } else {
            hashMap.put("LegacySDCardDir", "");
        }
        return hashMap;
    }

    static String getExternalFilesDirPath(ReactApplicationContext reactApplicationContext, String str) {
        File externalFilesDir = reactApplicationContext.getExternalFilesDir(str);
        return externalFilesDir != null ? externalFilesDir.getAbsolutePath() : "";
    }

    static String getFilesDirPath(ReactApplicationContext reactApplicationContext) {
        File filesDir = reactApplicationContext.getFilesDir();
        return filesDir != null ? filesDir.getAbsolutePath() : "";
    }

    static String getCacheDirPath(ReactApplicationContext reactApplicationContext) {
        File cacheDir = reactApplicationContext.getCacheDir();
        return cacheDir != null ? cacheDir.getAbsolutePath() : "";
    }

    public static void getSDCardDir(ReactApplicationContext reactApplicationContext, Promise promise) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                promise.resolve(reactApplicationContext.getExternalFilesDir(null).getAbsolutePath());
                return;
            } catch (Exception e) {
                promise.reject("ReactNativeBlobUtil.getSDCardDir", e.getLocalizedMessage());
                return;
            }
        }
        promise.reject("ReactNativeBlobUtil.getSDCardDir", "External storage not mounted");
    }

    public static void getSDCardApplicationDir(ReactApplicationContext reactApplicationContext, Promise promise) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                promise.resolve(reactApplicationContext.getExternalFilesDir(null).getParentFile().getAbsolutePath());
                return;
            } catch (Exception e) {
                promise.reject("ReactNativeBlobUtil.getSDCardApplicationDir", e.getLocalizedMessage());
                return;
            }
        }
        promise.reject("ReactNativeBlobUtil.getSDCardApplicationDir", "External storage not mounted");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getTmpPath(String str) {
        return ReactNativeBlobUtilImpl.RCTContext.getFilesDir() + "/ReactNativeBlobUtilTmp_" + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void unlink(String str, Callback callback) {
        try {
            deleteRecursive(new File(ReactNativeBlobUtilUtils.normalizePath(str)));
            callback.invoke(null, true);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage(), false);
        }
    }

    private static void deleteRecursive(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                throw new NullPointerException("Received null trying to list files of directory '" + file + "'");
            }
            for (File file2 : listFiles) {
                deleteRecursive(file2);
            }
        }
        if (file.delete()) {
            return;
        }
        throw new IOException("Failed to delete '" + file + "'");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void mkdir(String str, Promise promise) {
        String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        File file = new File(normalizePath);
        if (file.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append(file.isDirectory() ? "Folder" : "File");
            sb.append(" '");
            sb.append(normalizePath);
            sb.append("' already exists");
            promise.reject("EEXIST", sb.toString());
            return;
        }
        try {
            if (!file.mkdirs()) {
                promise.reject("EUNSPECIFIED", "mkdir failed to create some or all directories in '" + normalizePath + "'");
                return;
            }
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f6 A[Catch: Exception -> 0x00f2, TRY_LEAVE, TryCatch #9 {Exception -> 0x00f2, blocks: (B:63:0x00ee, B:56:0x00f6), top: B:62:0x00ee }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void cp(java.lang.String r7, java.lang.String r8, com.facebook.react.bridge.Callback r9) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.cp(java.lang.String, java.lang.String, com.facebook.react.bridge.Callback):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void mv(String str, String str2, Callback callback) {
        String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        String normalizePath2 = ReactNativeBlobUtilUtils.normalizePath(str2);
        File file = new File(normalizePath);
        if (!file.exists()) {
            callback.invoke("Source file at path `" + normalizePath + "` does not exist");
            return;
        }
        try {
            File file2 = new File(normalizePath2);
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                callback.invoke("mv failed because the destination directory doesn't exist");
                return;
            }
            if (file2.exists()) {
                file2.delete();
            }
            if (!file.renameTo(file2)) {
                callback.invoke("mv failed for unknown reasons");
            } else {
                callback.invoke(new Object[0]);
            }
        } catch (Exception e) {
            callback.invoke(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void exists(String str, Callback callback) {
        if (isAsset(str)) {
            try {
                ReactNativeBlobUtilImpl.RCTContext.getAssets().openFd(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
                callback.invoke(true, false);
                return;
            } catch (IOException unused) {
                callback.invoke(false, false);
                return;
            }
        }
        String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        if (normalizePath != null) {
            callback.invoke(Boolean.valueOf(new File(normalizePath).exists()), Boolean.valueOf(new File(normalizePath).isDirectory()));
        } else {
            callback.invoke(false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void ls(String str, Promise promise) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            File file = new File(normalizePath);
            if (!file.exists()) {
                promise.reject("ENOENT", "No such file '" + normalizePath + "'");
                return;
            }
            if (!file.isDirectory()) {
                promise.reject("ENOTDIR", "Not a directory '" + normalizePath + "'");
                return;
            }
            String[] list = new File(normalizePath).list();
            WritableArray createArray = Arguments.createArray();
            for (String str2 : list) {
                createArray.pushString(str2);
            }
            promise.resolve(createArray);
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void slice(String str, String str2, int i, int i2, String str3, Promise promise) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            String normalizePath2 = ReactNativeBlobUtilUtils.normalizePath(str2);
            File file = new File(normalizePath);
            if (file.isDirectory()) {
                promise.reject("EISDIR", "Expecting a file but '" + normalizePath + "' is a directory");
                return;
            }
            if (!file.exists()) {
                promise.reject("ENOENT", "No such file '" + normalizePath + "'");
                return;
            }
            int length = (int) file.length();
            int min = Math.min(length, i2) - i;
            FileInputStream fileInputStream = new FileInputStream(new File(normalizePath));
            FileOutputStream fileOutputStream = new FileOutputStream(new File(normalizePath2));
            int skip = (int) fileInputStream.skip(i);
            if (skip != i) {
                promise.reject("EUNSPECIFIED", "Skipped " + skip + " instead of the specified " + i + " bytes, size is " + length);
                return;
            }
            byte[] bArr = new byte[Data.MAX_DATA_BYTES];
            int i3 = 0;
            while (i3 < min) {
                int read = fileInputStream.read(bArr, 0, Data.MAX_DATA_BYTES);
                int i4 = min - i3;
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, Math.min(i4, read));
                i3 += read;
            }
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            promise.resolve(normalizePath2);
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.ReactNativeBlobUtil.ReactNativeBlobUtilFS$1] */
    public static void lstat(String str, final Callback callback) {
        new AsyncTask<String, Integer, Integer>() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Integer doInBackground(String... strArr) {
                WritableArray createArray = Arguments.createArray();
                if (strArr[0] == null) {
                    Callback.this.invoke("the path specified for lstat is either `null` or `undefined`.");
                    return 0;
                }
                File file = new File(strArr[0]);
                if (!file.exists()) {
                    Callback.this.invoke("failed to lstat path `" + strArr[0] + "` because it does not exist or it is not a folder");
                    return 0;
                }
                if (file.isDirectory()) {
                    for (String str2 : file.list()) {
                        createArray.pushMap(ReactNativeBlobUtilFS.statFile(file.getPath() + "/" + str2));
                    }
                } else {
                    createArray.pushMap(ReactNativeBlobUtilFS.statFile(file.getAbsolutePath()));
                }
                Callback.this.invoke(null, createArray);
                return 0;
            }
        }.execute(ReactNativeBlobUtilUtils.normalizePath(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void stat(String str, Callback callback) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            WritableMap statFile = statFile(normalizePath);
            if (statFile == null) {
                callback.invoke("failed to stat path `" + normalizePath + "` because it does not exist or it is not a folder", null);
            } else {
                callback.invoke(null, statFile);
            }
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WritableMap statFile(String str) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            WritableMap createMap = Arguments.createMap();
            if (isAsset(normalizePath)) {
                String replace = normalizePath.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "");
                AssetFileDescriptor openFd = ReactNativeBlobUtilImpl.RCTContext.getAssets().openFd(replace);
                createMap.putString("filename", replace);
                createMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, normalizePath);
                createMap.putString("type", UriUtil.LOCAL_ASSET_SCHEME);
                createMap.putString("size", String.valueOf(openFd.getLength()));
                createMap.putInt("lastModified", 0);
            } else {
                File file = new File(normalizePath);
                if (!file.exists()) {
                    return null;
                }
                createMap.putString("filename", file.getName());
                createMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, file.getPath());
                createMap.putString("type", file.isDirectory() ? "directory" : "file");
                createMap.putString("size", String.valueOf(file.length()));
                createMap.putString("lastModified", String.valueOf(file.lastModified()));
            }
            return createMap;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scanFile(String[] strArr, String[] strArr2, final Callback callback) {
        try {
            MediaScannerConnection.scanFile(this.mCtx, strArr, strArr2, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.2
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str, Uri uri) {
                    callback.invoke(null, true);
                }
            });
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void hash(String str, String str2, Promise promise) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("md5", MessageDigestAlgorithms.MD5);
            hashMap.put("sha1", MessageDigestAlgorithms.SHA_1);
            hashMap.put("sha224", "SHA-224");
            hashMap.put(SigningManager.POST_PARAMS_ALGORITHM, MessageDigestAlgorithms.SHA_256);
            hashMap.put("sha384", MessageDigestAlgorithms.SHA_384);
            hashMap.put("sha512", MessageDigestAlgorithms.SHA_512);
            if (!hashMap.containsKey(str2)) {
                promise.reject("EINVAL", "Invalid algorithm '" + str2 + "', must be one of md5, sha1, sha224, sha256, sha384, sha512");
                return;
            }
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            File file = new File(normalizePath);
            if (file.isDirectory()) {
                promise.reject("EISDIR", "Expecting a file but '" + normalizePath + "' is a directory");
                return;
            }
            if (!file.exists()) {
                promise.reject("ENOENT", "No such file '" + normalizePath + "'");
                return;
            }
            MessageDigest messageDigest = MessageDigest.getInstance((String) hashMap.get(str2));
            FileInputStream fileInputStream = new FileInputStream(normalizePath);
            byte[] bArr = new byte[1048576];
            if (file.length() != 0) {
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        messageDigest.update(bArr, 0, read);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest.digest()) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            promise.resolve(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void createFile(String str, String str2, String str3, Promise promise) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            File file = new File(normalizePath);
            boolean createNewFile = file.createNewFile();
            if (str3.equals("uri")) {
                File file2 = new File(str2.replace(ReactNativeBlobUtilConst.FILE_PREFIX, ""));
                if (!file2.exists()) {
                    promise.reject("ENOENT", "Source file : " + str2 + " does not exist");
                    return;
                }
                FileInputStream fileInputStream = new FileInputStream(file2);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[Data.MAX_DATA_BYTES];
                for (int read = fileInputStream.read(bArr); read > 0; read = fileInputStream.read(bArr)) {
                    fileOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                fileOutputStream.close();
            } else {
                if (!createNewFile) {
                    promise.reject("EEXIST", "File `" + normalizePath + "` already exists");
                    return;
                }
                new FileOutputStream(file).write(ReactNativeBlobUtilUtils.stringToBytes(str2, str3));
            }
            promise.resolve(normalizePath);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void createFileASCII(String str, ReadableArray readableArray, Promise promise) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            File file = new File(normalizePath);
            if (!file.createNewFile()) {
                promise.reject("EEXIST", "File at path `" + normalizePath + "` already exists");
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            fileOutputStream.write(bArr);
            promise.resolve(normalizePath);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void df(Callback callback, ReactApplicationContext reactApplicationContext) {
        StatFs statFs = new StatFs(reactApplicationContext.getFilesDir().getPath());
        WritableMap createMap = Arguments.createMap();
        createMap.putString("internal_free", String.valueOf(statFs.getFreeBytes()));
        createMap.putString("internal_total", String.valueOf(statFs.getTotalBytes()));
        File externalFilesDir = reactApplicationContext.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            StatFs statFs2 = new StatFs(externalFilesDir.getPath());
            createMap.putString("external_free", String.valueOf(statFs2.getFreeBytes()));
            createMap.putString("external_total", String.valueOf(statFs2.getTotalBytes()));
        } else {
            createMap.putString("external_free", "-1");
            createMap.putString("external_total", "-1");
        }
        callback.invoke(null, createMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeSession(ReadableArray readableArray, final Callback callback) {
        new AsyncTask<ReadableArray, Integer, Integer>() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Integer doInBackground(ReadableArray... readableArrayArr) {
                try {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < readableArrayArr[0].size(); i++) {
                        String string = readableArrayArr[0].getString(i);
                        File file = new File(string);
                        if (file.exists() && !file.delete()) {
                            arrayList.add(string);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        Callback.this.invoke(null, true);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to delete: ");
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            sb.append((String) it.next());
                            sb.append(", ");
                        }
                        Callback.this.invoke(sb.toString());
                    }
                } catch (Exception e) {
                    Callback.this.invoke(e.getLocalizedMessage());
                }
                return Integer.valueOf(readableArrayArr[0].size());
            }
        }.execute(readableArray);
    }

    private static InputStream inputStreamFromPath(String str) throws IOException {
        if (str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)) {
            return ReactNativeBlobUtilImpl.RCTContext.getAssets().open(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
        }
        return new FileInputStream(new File(str));
    }

    private static boolean isPathExists(String str) {
        if (str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)) {
            try {
                ReactNativeBlobUtilImpl.RCTContext.getAssets().open(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
        return new File(str).exists();
    }

    static boolean isAsset(String str) {
        return str != null && str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET);
    }
}
