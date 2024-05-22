package com.rnfs;

import android.os.AsyncTask;
import android.webkit.MimeTypeMap;
import expo.modules.imagepicker.MediaTypes;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public class Uploader extends AsyncTask<UploadParams, int[], UploadResult> {
    private AtomicBoolean mAbort = new AtomicBoolean(false);
    private UploadParams mParams;
    private UploadResult res;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public UploadResult doInBackground(UploadParams... uploadParamsArr) {
        this.mParams = uploadParamsArr[0];
        this.res = new UploadResult();
        new Thread(new Runnable() { // from class: com.rnfs.Uploader.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Uploader uploader = Uploader.this;
                    uploader.upload(uploader.mParams, Uploader.this.res);
                    Uploader.this.mParams.onUploadComplete.onUploadComplete(Uploader.this.res);
                } catch (Exception e) {
                    Uploader.this.res.exception = e;
                    Uploader.this.mParams.onUploadComplete.onUploadComplete(Uploader.this.res);
                }
            }
        }).start();
        return this.res;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0120 A[Catch: all -> 0x01b3, TryCatch #1 {all -> 0x01b3, blocks: (B:48:0x00d5, B:56:0x010f, B:58:0x0120, B:60:0x0156, B:61:0x015f, B:70:0x00fe), top: B:47:0x00d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void upload(com.rnfs.UploadParams r37, com.rnfs.UploadResult r38) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 851
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnfs.Uploader.upload(com.rnfs.UploadParams, com.rnfs.UploadResult):void");
    }

    protected String getMimeType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        String mimeTypeFromExtension = fileExtensionFromUrl != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase()) : null;
        return mimeTypeFromExtension == null ? MediaTypes.AllMimeType : mimeTypeFromExtension;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stop() {
        this.mAbort.set(true);
    }
}
