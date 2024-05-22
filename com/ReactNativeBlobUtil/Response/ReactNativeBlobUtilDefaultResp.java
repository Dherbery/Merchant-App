package com.ReactNativeBlobUtil.Response;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilProgressConfig;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilReq;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

/* loaded from: classes.dex */
public class ReactNativeBlobUtilDefaultResp extends ResponseBody {
    boolean isIncrement;
    String mTaskId;
    ResponseBody originalBody;
    ReactApplicationContext rctContext;

    public ReactNativeBlobUtilDefaultResp(ReactApplicationContext reactApplicationContext, String str, ResponseBody responseBody, boolean z) {
        this.rctContext = reactApplicationContext;
        this.mTaskId = str;
        this.originalBody = responseBody;
        this.isIncrement = z;
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: contentType */
    public MediaType get$contentType() {
        return this.originalBody.get$contentType();
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: contentLength */
    public long getContentLength() {
        return this.originalBody.getContentLength();
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: source */
    public BufferedSource getSource() {
        return Okio.buffer(new ProgressReportingSource(this.originalBody.getSource()));
    }

    /* loaded from: classes.dex */
    private class ProgressReportingSource implements Source {
        long bytesRead = 0;
        BufferedSource mOriginalSource;

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // okio.Source
        /* renamed from: timeout */
        public Timeout getTimeout() {
            return null;
        }

        ProgressReportingSource(BufferedSource bufferedSource) {
            this.mOriginalSource = bufferedSource;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            long read = this.mOriginalSource.read(buffer, j);
            this.bytesRead += read > 0 ? read : 0L;
            ReactNativeBlobUtilProgressConfig reportProgress = ReactNativeBlobUtilReq.getReportProgress(ReactNativeBlobUtilDefaultResp.this.mTaskId);
            long contentLength = ReactNativeBlobUtilDefaultResp.this.getContentLength();
            if (reportProgress != null && contentLength != 0 && reportProgress.shouldReport((float) (this.bytesRead / ReactNativeBlobUtilDefaultResp.this.getContentLength()))) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("taskId", ReactNativeBlobUtilDefaultResp.this.mTaskId);
                createMap.putString("written", String.valueOf(this.bytesRead));
                createMap.putString("total", String.valueOf(ReactNativeBlobUtilDefaultResp.this.getContentLength()));
                if (ReactNativeBlobUtilDefaultResp.this.isIncrement) {
                    createMap.putString("chunk", buffer.readString(Charset.defaultCharset()));
                } else {
                    createMap.putString("chunk", "");
                }
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilDefaultResp.this.rctContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_PROGRESS, createMap);
            }
            return read;
        }
    }
}
