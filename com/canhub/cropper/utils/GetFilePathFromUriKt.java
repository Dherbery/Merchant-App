package com.canhub.cropper.utils;

import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.facebook.common.util.UriUtil;
import com.facebook.react.uimanager.events.TouchesHelper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: GetFilePathFromUri.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a \u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a \u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¨\u0006\u0012"}, d2 = {"copy", "", "source", "Ljava/io/InputStream;", TouchesHelper.TARGET_KEY, "Ljava/io/OutputStream;", "getFileExtension", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "getFileFromContentUri", "Ljava/io/File;", "contentUri", "uniqueName", "", "getFilePathFromUri", "cropper_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class GetFilePathFromUriKt {
    public static final String getFilePathFromUri(Context context, Uri uri, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String path = uri.getPath();
        boolean z2 = false;
        if (path != null && StringsKt.contains$default((CharSequence) path, (CharSequence) "file://", false, 2, (Object) null)) {
            z2 = true;
        }
        if (z2) {
            String path2 = uri.getPath();
            Intrinsics.checkNotNull(path2);
            return path2;
        }
        String path3 = getFileFromContentUri(context, uri, z).getPath();
        Intrinsics.checkNotNullExpressionValue(path3, "getFileFromContentUri(co…xt, uri, uniqueName).path");
        return path3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x007b, code lost:
    
        if (r1 == null) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.io.File getFileFromContentUri(android.content.Context r5, android.net.Uri r6, boolean r7) {
        /*
            java.lang.String r0 = getFileExtension(r5, r6)
            java.lang.String r1 = ""
            if (r0 != 0) goto L9
            r0 = r1
        L9:
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r3 = "yyyyMMdd_HHmmss"
            java.util.Locale r4 = java.util.Locale.getDefault()
            r2.<init>(r3, r4)
            java.util.Date r3 = new java.util.Date
            r3.<init>()
            java.lang.String r2 = r2.format(r3)
            if (r7 == 0) goto L21
            r1 = r2
        L21:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r2 = "temp_file_"
            r7.<init>(r2)
            r7.append(r1)
            java.lang.String r1 = "."
            r7.append(r1)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            java.io.File r0 = new java.io.File
            java.io.File r1 = r5.getCacheDir()
            r0.<init>(r1, r7)
            r0.createNewFile()
            r7 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L7f
            java.io.InputStream r7 = r5.openInputStream(r6)     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L7f
            if (r7 == 0) goto L5a
            r5 = r1
            java.io.OutputStream r5 = (java.io.OutputStream) r5     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L7f
            copy(r7, r5)     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L7f
        L5a:
            r1.flush()     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L7f
            if (r7 == 0) goto L62
            r7.close()
        L62:
            r1.close()
            goto L7e
        L66:
            r5 = move-exception
            goto L6d
        L68:
            r5 = move-exception
            r1 = r7
            goto L80
        L6b:
            r5 = move-exception
            r1 = r7
        L6d:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L7f
            r5 = r7
            java.io.InputStream r5 = (java.io.InputStream) r5
            if (r7 == 0) goto L78
            r7.close()
        L78:
            r5 = r1
            java.io.FileOutputStream r5 = (java.io.FileOutputStream) r5
            if (r1 == 0) goto L7e
            goto L62
        L7e:
            return r0
        L7f:
            r5 = move-exception
        L80:
            r6 = r7
            java.io.InputStream r6 = (java.io.InputStream) r6
            if (r7 == 0) goto L88
            r7.close()
        L88:
            r6 = r1
            java.io.FileOutputStream r6 = (java.io.FileOutputStream) r6
            if (r1 == 0) goto L90
            r1.close()
        L90:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.canhub.cropper.utils.GetFilePathFromUriKt.getFileFromContentUri(android.content.Context, android.net.Uri, boolean):java.io.File");
    }

    private static final String getFileExtension(Context context, Uri uri) {
        if (Intrinsics.areEqual(uri.getScheme(), UriUtil.LOCAL_CONTENT_SCHEME)) {
            return MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
        }
        String path = uri.getPath();
        if (path != null) {
            return MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(path)).toString());
        }
        return null;
    }

    private static final void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }
}
