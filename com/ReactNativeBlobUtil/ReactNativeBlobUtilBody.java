package com.ReactNativeBlobUtil;

import android.net.Uri;
import android.util.Base64;
import androidx.webkit.internal.AssetHelper;
import androidx.work.Data;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilReq;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import org.apache.commons.io.IOUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ReactNativeBlobUtilBody extends RequestBody {
    private File bodyCache;
    private ReadableArray form;
    private String mTaskId;
    private MediaType mime;
    private String rawBody;
    private ReactNativeBlobUtilReq.RequestType requestType;
    private long contentLength = 0;
    int reported = 0;
    private Boolean chunkedEncoding = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReactNativeBlobUtilBody(String str) {
        this.mTaskId = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReactNativeBlobUtilBody chunkedEncoding(boolean z) {
        this.chunkedEncoding = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReactNativeBlobUtilBody setMIME(MediaType mediaType) {
        this.mime = mediaType;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReactNativeBlobUtilBody setRequestType(ReactNativeBlobUtilReq.RequestType requestType) {
        this.requestType = requestType;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReactNativeBlobUtilBody setBody(String str) {
        this.rawBody = str;
        if (str == null) {
            this.rawBody = "";
            this.requestType = ReactNativeBlobUtilReq.RequestType.AsIs;
        }
        try {
            int i = AnonymousClass1.$SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[this.requestType.ordinal()];
            if (i == 1) {
                this.contentLength = getRequestStream().available();
            } else if (i == 2) {
                this.contentLength = this.rawBody.getBytes().length;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ReactNativeBlobUtilUtils.emitWarningEvent("ReactNativeBlobUtil failed to create single content request body :" + e.getLocalizedMessage() + IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ReactNativeBlobUtil.ReactNativeBlobUtilBody$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType;

        static {
            int[] iArr = new int[ReactNativeBlobUtilReq.RequestType.values().length];
            $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType = iArr;
            try {
                iArr[ReactNativeBlobUtilReq.RequestType.SingleFile.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[ReactNativeBlobUtilReq.RequestType.AsIs.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[ReactNativeBlobUtilReq.RequestType.Others.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReactNativeBlobUtilBody setBody(ReadableArray readableArray) {
        this.form = readableArray;
        try {
            File createMultipartBodyCache = createMultipartBodyCache();
            this.bodyCache = createMultipartBodyCache;
            this.contentLength = createMultipartBodyCache.length();
        } catch (Exception e) {
            e.printStackTrace();
            ReactNativeBlobUtilUtils.emitWarningEvent("ReactNativeBlobUtil failed to create request multipart body :" + e.getLocalizedMessage());
        }
        return this;
    }

    InputStream getInputStreamForRequestBody() {
        try {
            if (this.form != null) {
                return new FileInputStream(this.bodyCache);
            }
            int i = AnonymousClass1.$SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[this.requestType.ordinal()];
            if (i == 1) {
                return getRequestStream();
            }
            if (i == 2) {
                return new ByteArrayInputStream(this.rawBody.getBytes());
            }
            if (i != 3) {
                return null;
            }
            ReactNativeBlobUtilUtils.emitWarningEvent("ReactNativeBlobUtil could not create input stream for request type others");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            ReactNativeBlobUtilUtils.emitWarningEvent("ReactNativeBlobUtil failed to create input stream for request:" + e.getLocalizedMessage());
            return null;
        }
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        if (this.chunkedEncoding.booleanValue()) {
            return -1L;
        }
        return this.contentLength;
    }

    @Override // okhttp3.RequestBody
    /* renamed from: contentType */
    public MediaType getContentType() {
        return this.mime;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) {
        try {
            pipeStreamToSink(getInputStreamForRequestBody(), bufferedSink);
        } catch (Exception e) {
            ReactNativeBlobUtilUtils.emitWarningEvent(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean clearRequestBody() {
        try {
            File file = this.bodyCache;
            if (file == null || !file.exists()) {
                return true;
            }
            this.bodyCache.delete();
            return true;
        } catch (Exception e) {
            ReactNativeBlobUtilUtils.emitWarningEvent(e.getLocalizedMessage());
            return false;
        }
    }

    private InputStream getRequestStream() throws Exception {
        if (this.rawBody.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX)) {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(this.rawBody.substring(27));
            if (ReactNativeBlobUtilUtils.isAsset(normalizePath)) {
                try {
                    return ReactNativeBlobUtilImpl.RCTContext.getAssets().open(normalizePath.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
                } catch (Exception e) {
                    throw new Exception("error when getting request stream from asset : " + e.getLocalizedMessage());
                }
            }
            File file = new File(ReactNativeBlobUtilUtils.normalizePath(normalizePath));
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                return new FileInputStream(file);
            } catch (Exception e2) {
                throw new Exception("error when getting request stream: " + e2.getLocalizedMessage());
            }
        }
        if (this.rawBody.startsWith(ReactNativeBlobUtilConst.CONTENT_PREFIX)) {
            String substring = this.rawBody.substring(30);
            try {
                return ReactNativeBlobUtilImpl.RCTContext.getContentResolver().openInputStream(Uri.parse(substring));
            } catch (Exception e3) {
                throw new Exception("error when getting request stream for content URI: " + substring, e3);
            }
        }
        try {
            return new ByteArrayInputStream(Base64.decode(this.rawBody, 0));
        } catch (Exception e4) {
            throw new Exception("error when getting request stream: " + e4.getLocalizedMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0163, code lost:
    
        if (r10 == null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.File createMultipartBodyCache() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 475
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilBody.createMultipartBodyCache():java.io.File");
    }

    private void pipeStreamToSink(InputStream inputStream, BufferedSink bufferedSink) throws IOException {
        byte[] bArr = new byte[Data.MAX_DATA_BYTES];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr, 0, Data.MAX_DATA_BYTES);
            if (read > 0) {
                bufferedSink.write(bArr, 0, read);
                j += read;
                emitUploadProgress(j);
            } else {
                inputStream.close();
                return;
            }
        }
    }

    private void pipeStreamToFileStream(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[Data.MAX_DATA_BYTES];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                return;
            }
        }
    }

    private ArrayList<FormField> countFormDataLength() throws IOException {
        int length;
        long j;
        ArrayList<FormField> arrayList = new ArrayList<>();
        ReactApplicationContext reactApplicationContext = ReactNativeBlobUtilImpl.RCTContext;
        long j2 = 0;
        for (int i = 0; i < this.form.size(); i++) {
            FormField formField = new FormField(this.form.getMap(i));
            arrayList.add(formField);
            if (formField.data == null) {
                ReactNativeBlobUtilUtils.emitWarningEvent("ReactNativeBlobUtil multipart request builder has found a field without `data` property, the field `" + formField.name + "` will be removed implicitly.");
            } else {
                if (formField.filename != null) {
                    String str = formField.data;
                    if (str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX)) {
                        String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str.substring(27));
                        if (ReactNativeBlobUtilUtils.isAsset(normalizePath)) {
                            try {
                                length = reactApplicationContext.getAssets().open(normalizePath.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "")).available();
                            } catch (IOException e) {
                                ReactNativeBlobUtilUtils.emitWarningEvent(e.getLocalizedMessage());
                            }
                        } else {
                            j = new File(ReactNativeBlobUtilUtils.normalizePath(normalizePath)).length();
                            j2 += j;
                        }
                    } else if (str.startsWith(ReactNativeBlobUtilConst.CONTENT_PREFIX)) {
                        String substring = str.substring(30);
                        InputStream inputStream = null;
                        try {
                            try {
                                inputStream = reactApplicationContext.getContentResolver().openInputStream(Uri.parse(substring));
                                j2 += inputStream.available();
                                if (inputStream == null) {
                                }
                            } catch (Exception e2) {
                                ReactNativeBlobUtilUtils.emitWarningEvent("Failed to estimate form data length from content URI:" + substring + ", " + e2.getLocalizedMessage());
                                if (inputStream == null) {
                                }
                            }
                            inputStream.close();
                        } catch (Throwable th) {
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    } else {
                        length = Base64.decode(str, 0).length;
                    }
                } else {
                    length = formField.data.getBytes().length;
                }
                j = length;
                j2 += j;
            }
        }
        this.contentLength = j2;
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class FormField {
        public String data;
        String filename;
        String mime;
        public String name;

        FormField(ReadableMap readableMap) {
            if (readableMap.hasKey("name")) {
                this.name = readableMap.getString("name");
            }
            if (readableMap.hasKey("filename")) {
                this.filename = readableMap.getString("filename");
            }
            if (readableMap.hasKey("type")) {
                this.mime = readableMap.getString("type");
            } else {
                this.mime = this.filename == null ? AssetHelper.DEFAULT_MIME_TYPE : "application/octet-stream";
            }
            if (readableMap.hasKey("data")) {
                this.data = readableMap.getString("data");
            }
        }
    }

    private void emitUploadProgress(long j) {
        ReactNativeBlobUtilProgressConfig reportUploadProgress = ReactNativeBlobUtilReq.getReportUploadProgress(this.mTaskId);
        if (reportUploadProgress != null) {
            long j2 = this.contentLength;
            if (j2 == 0 || !reportUploadProgress.shouldReport(((float) j) / ((float) j2))) {
                return;
            }
            WritableMap createMap = Arguments.createMap();
            createMap.putString("taskId", this.mTaskId);
            createMap.putString("written", String.valueOf(j));
            createMap.putString("total", String.valueOf(this.contentLength));
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilImpl.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_UPLOAD_PROGRESS, createMap);
        }
    }
}
