package com.onesignal.core.internal.http;

import com.onesignal.core.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: HttpResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/onesignal/core/internal/http/HttpResponse;", "", "statusCode", "", "payload", "", "throwable", "", "retryAfterSeconds", "(ILjava/lang/String;Ljava/lang/Throwable;Ljava/lang/Integer;)V", "isSuccess", "", "()Z", "getPayload", "()Ljava/lang/String;", "getRetryAfterSeconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatusCode", "()I", "getThrowable", "()Ljava/lang/Throwable;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class HttpResponse {
    private final String payload;
    private final Integer retryAfterSeconds;
    private final int statusCode;
    private final Throwable throwable;

    public HttpResponse(int i, String str, Throwable th, Integer num) {
        this.statusCode = i;
        this.payload = str;
        this.throwable = th;
        this.retryAfterSeconds = num;
    }

    public /* synthetic */ HttpResponse(int i, String str, Throwable th, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? null : th, (i2 & 8) != 0 ? null : num);
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final Integer getRetryAfterSeconds() {
        return this.retryAfterSeconds;
    }

    public final boolean isSuccess() {
        int i = this.statusCode;
        return i == 200 || i == 202 || i == 304 || i == 201;
    }
}
