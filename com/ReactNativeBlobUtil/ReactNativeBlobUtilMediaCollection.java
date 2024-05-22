package com.ReactNativeBlobUtil;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.ReactNativeBlobUtil.Utils.FileDescription;
import com.facebook.react.bridge.ReactApplicationContext;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.IOUtils;

/* loaded from: classes.dex */
public class ReactNativeBlobUtilMediaCollection {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* loaded from: classes.dex */
    public enum MediaType {
        Audio,
        Image,
        Video,
        Download
    }

    private static Uri getMediaUri(MediaType mediaType) {
        Uri contentUri;
        if (mediaType == MediaType.Audio) {
            if (Build.VERSION.SDK_INT >= 29) {
                return MediaStore.Audio.Media.getContentUri("external_primary");
            }
            return MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        }
        if (mediaType == MediaType.Video) {
            if (Build.VERSION.SDK_INT >= 29) {
                return MediaStore.Video.Media.getContentUri("external_primary");
            }
            return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        if (mediaType == MediaType.Image) {
            if (Build.VERSION.SDK_INT >= 29) {
                return MediaStore.Images.Media.getContentUri("external_primary");
            }
            return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }
        if (mediaType != MediaType.Download || Build.VERSION.SDK_INT < 29) {
            return null;
        }
        contentUri = MediaStore.Downloads.getContentUri("external_primary");
        return contentUri;
    }

    private static String getRelativePath(MediaType mediaType, ReactApplicationContext reactApplicationContext) {
        return Build.VERSION.SDK_INT >= 29 ? mediaType == MediaType.Audio ? Environment.DIRECTORY_MUSIC : mediaType == MediaType.Video ? Environment.DIRECTORY_MOVIES : mediaType == MediaType.Image ? Environment.DIRECTORY_PICTURES : mediaType == MediaType.Download ? Environment.DIRECTORY_DOWNLOADS : Environment.DIRECTORY_DOWNLOADS : mediaType == MediaType.Audio ? ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyMusicDir").toString() : mediaType == MediaType.Video ? ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyMovieDir").toString() : mediaType == MediaType.Image ? ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyPictureDir").toString() : mediaType == MediaType.Download ? ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyDownloadDir").toString() : ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyDownloadDir").toString();
    }

    public static Uri createNewMediaFile(FileDescription fileDescription, MediaType mediaType, ReactApplicationContext reactApplicationContext) {
        ContentResolver contentResolver = ReactNativeBlobUtilImpl.RCTContext.getApplicationContext().getContentResolver();
        ContentValues contentValues = new ContentValues();
        String relativePath = getRelativePath(mediaType, reactApplicationContext);
        String str = fileDescription.mimeType;
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("date_added", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("date_modified", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("mime_type", str);
            contentValues.put("_display_name", fileDescription.name);
            contentValues.put("relative_path", relativePath + IOUtils.DIR_SEPARATOR_UNIX + fileDescription.partentFolder);
            try {
                return contentResolver.insert(getMediaUri(mediaType), contentValues);
            } catch (Exception unused) {
                return null;
            }
        }
        File file = new File(relativePath + fileDescription.getFullPath());
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                return null;
            }
            try {
                file.createNewFile();
                return Uri.fromFile(file);
            } catch (IOException unused2) {
                return null;
            }
        }
        return Uri.fromFile(file);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00d1 A[Catch: IOException -> 0x00d5, TryCatch #2 {IOException -> 0x00d5, blocks: (B:7:0x000b, B:30:0x009c, B:24:0x00ab, B:44:0x00d1, B:45:0x00d4, B:38:0x00c9), top: B:6:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean writeToMediaFile(android.net.Uri r8, java.lang.String r9, boolean r10, com.facebook.react.bridge.Promise r11, com.facebook.react.bridge.ReactApplicationContext r12) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilMediaCollection.writeToMediaFile(android.net.Uri, java.lang.String, boolean, com.facebook.react.bridge.Promise, com.facebook.react.bridge.ReactApplicationContext):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0094 -> B:17:0x00d0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void copyToInternal(android.net.Uri r6, java.lang.String r7, com.facebook.react.bridge.Promise r8) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilMediaCollection.copyToInternal(android.net.Uri, java.lang.String, com.facebook.react.bridge.Promise):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0082 A[Catch: IOException -> 0x008b, TRY_LEAVE, TryCatch #0 {IOException -> 0x008b, blocks: (B:3:0x000c, B:5:0x001f, B:8:0x0039, B:16:0x0067, B:18:0x0070, B:20:0x0076, B:22:0x007e, B:24:0x0082, B:26:0x004e, B:29:0x0058), top: B:2:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void getBlob(android.net.Uri r5, java.lang.String r6, com.facebook.react.bridge.Promise r7) {
        /*
            java.lang.String r0 = "Read only "
            com.facebook.react.bridge.ReactApplicationContext r1 = com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.RCTContext
            android.content.Context r1 = r1.getApplicationContext()
            android.content.ContentResolver r1 = r1.getContentResolver()
            java.io.InputStream r5 = r1.openInputStream(r5)     // Catch: java.io.IOException -> L8b
            int r1 = r5.available()     // Catch: java.io.IOException -> L8b
            byte[] r2 = new byte[r1]     // Catch: java.io.IOException -> L8b
            int r3 = r5.read(r2)     // Catch: java.io.IOException -> L8b
            r5.close()     // Catch: java.io.IOException -> L8b
            if (r3 >= r1) goto L39
            java.lang.String r5 = "EUNSPECIFIED"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L8b
            r6.<init>(r0)     // Catch: java.io.IOException -> L8b
            r6.append(r3)     // Catch: java.io.IOException -> L8b
            java.lang.String r0 = " bytes of "
            r6.append(r0)     // Catch: java.io.IOException -> L8b
            r6.append(r1)     // Catch: java.io.IOException -> L8b
            java.lang.String r6 = r6.toString()     // Catch: java.io.IOException -> L8b
            r7.reject(r5, r6)     // Catch: java.io.IOException -> L8b
            return
        L39:
            java.lang.String r5 = r6.toLowerCase()     // Catch: java.io.IOException -> L8b
            int r6 = r5.hashCode()     // Catch: java.io.IOException -> L8b
            r0 = -1396204209(0xffffffffacc79d4f, float:-5.673385E-12)
            r3 = 0
            r4 = 1
            if (r6 == r0) goto L58
            r0 = 93106001(0x58caf51, float:1.3229938E-35)
            if (r6 == r0) goto L4e
            goto L62
        L4e:
            java.lang.String r6 = "ascii"
            boolean r5 = r5.equals(r6)     // Catch: java.io.IOException -> L8b
            if (r5 == 0) goto L62
            r5 = r4
            goto L63
        L58:
            java.lang.String r6 = "base64"
            boolean r5 = r5.equals(r6)     // Catch: java.io.IOException -> L8b
            if (r5 == 0) goto L62
            r5 = r3
            goto L63
        L62:
            r5 = -1
        L63:
            if (r5 == 0) goto L82
            if (r5 == r4) goto L70
            java.lang.String r5 = new java.lang.String     // Catch: java.io.IOException -> L8b
            r5.<init>(r2)     // Catch: java.io.IOException -> L8b
            r7.resolve(r5)     // Catch: java.io.IOException -> L8b
            goto L8f
        L70:
            com.facebook.react.bridge.WritableArray r5 = com.facebook.react.bridge.Arguments.createArray()     // Catch: java.io.IOException -> L8b
        L74:
            if (r3 >= r1) goto L7e
            r6 = r2[r3]     // Catch: java.io.IOException -> L8b
            r5.pushInt(r6)     // Catch: java.io.IOException -> L8b
            int r3 = r3 + 1
            goto L74
        L7e:
            r7.resolve(r5)     // Catch: java.io.IOException -> L8b
            goto L8f
        L82:
            r5 = 2
            java.lang.String r5 = android.util.Base64.encodeToString(r2, r5)     // Catch: java.io.IOException -> L8b
            r7.resolve(r5)     // Catch: java.io.IOException -> L8b
            goto L8f
        L8b:
            r5 = move-exception
            r5.printStackTrace()
        L8f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilMediaCollection.getBlob(android.net.Uri, java.lang.String, com.facebook.react.bridge.Promise):void");
    }
}
