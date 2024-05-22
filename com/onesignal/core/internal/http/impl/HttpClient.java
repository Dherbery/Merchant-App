package com.onesignal.core.internal.http.impl;

import androidx.browser.trusted.sharing.ShareTarget;
import com.amazon.a.a.o.b;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.common.net.HttpHeaders;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.http.HttpResponse;
import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.polidea.rxandroidble2.ClientComponent;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: HttpClient.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J#\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J?\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ?\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ!\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010 J!\u0010!\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010 J!\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0017\u0010#\u001a\u0004\u0018\u00010\u00162\u0006\u0010$\u001a\u00020%H\u0002¢\u0006\u0002\u0010&R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/onesignal/core/internal/http/impl/HttpClient;", "Lcom/onesignal/core/internal/http/IHttpClient;", "_connectionFactory", "Lcom/onesignal/core/internal/http/impl/IHttpConnectionFactory;", "_prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/http/impl/IHttpConnectionFactory;Lcom/onesignal/core/internal/preferences/IPreferencesService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/time/ITime;)V", "delayNewRequestsUntil", "", "delete", "Lcom/onesignal/core/internal/http/HttpResponse;", ImagesContract.URL, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", b.ar, "cacheKey", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getThreadTimeout", "", ClientComponent.NamedSchedulers.TIMEOUT, "makeRequest", "method", "jsonBody", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "makeRequestIODispatcher", "patch", TtmlNode.TAG_BODY, "(Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "post", "put", "retryAfterFromResponse", "con", "Ljava/net/HttpURLConnection;", "(Ljava/net/HttpURLConnection;)Ljava/lang/Integer;", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class HttpClient implements IHttpClient {
    private static final String OS_ACCEPT_HEADER = "application/vnd.onesignal.v1+json";
    private static final String OS_API_VERSION = "1";
    private static final int THREAD_ID = 10000;
    private final ConfigModelStore _configModelStore;
    private final IHttpConnectionFactory _connectionFactory;
    private final IPreferencesService _prefs;
    private final ITime _time;
    private long delayNewRequestsUntil;

    private final int getThreadTimeout(int timeout) {
        return timeout + 5000;
    }

    public HttpClient(IHttpConnectionFactory _connectionFactory, IPreferencesService _prefs, ConfigModelStore _configModelStore, ITime _time) {
        Intrinsics.checkNotNullParameter(_connectionFactory, "_connectionFactory");
        Intrinsics.checkNotNullParameter(_prefs, "_prefs");
        Intrinsics.checkNotNullParameter(_configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(_time, "_time");
        this._connectionFactory = _connectionFactory;
        this._prefs = _prefs;
        this._configModelStore = _configModelStore;
        this._time = _time;
    }

    @Override // com.onesignal.core.internal.http.IHttpClient
    public Object post(String str, JSONObject jSONObject, Continuation<? super HttpResponse> continuation) {
        return makeRequest(str, ShareTarget.METHOD_POST, jSONObject, this._configModelStore.getModel().getHttpTimeout(), null, continuation);
    }

    @Override // com.onesignal.core.internal.http.IHttpClient
    public Object get(String str, String str2, Continuation<? super HttpResponse> continuation) {
        return makeRequest(str, null, null, this._configModelStore.getModel().getHttpGetTimeout(), str2, continuation);
    }

    @Override // com.onesignal.core.internal.http.IHttpClient
    public Object put(String str, JSONObject jSONObject, Continuation<? super HttpResponse> continuation) {
        return makeRequest(str, "PUT", jSONObject, this._configModelStore.getModel().getHttpTimeout(), null, continuation);
    }

    @Override // com.onesignal.core.internal.http.IHttpClient
    public Object patch(String str, JSONObject jSONObject, Continuation<? super HttpResponse> continuation) {
        return makeRequest(str, "PATCH", jSONObject, this._configModelStore.getModel().getHttpTimeout(), null, continuation);
    }

    @Override // com.onesignal.core.internal.http.IHttpClient
    public Object delete(String str, Continuation<? super HttpResponse> continuation) {
        return makeRequest(str, "DELETE", null, this._configModelStore.getModel().getHttpTimeout(), null, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x012c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object makeRequest(java.lang.String r22, java.lang.String r23, org.json.JSONObject r24, int r25, java.lang.String r26, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.http.HttpResponse> r27) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.http.impl.HttpClient.makeRequest(java.lang.String, java.lang.String, org.json.JSONObject, int, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object makeRequestIODispatcher(java.lang.String r19, java.lang.String r20, org.json.JSONObject r21, int r22, java.lang.String r23, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.http.HttpResponse> r24) {
        /*
            r18 = this;
            r0 = r24
            boolean r1 = r0 instanceof com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$1
            if (r1 == 0) goto L18
            r1 = r0
            com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$1 r1 = (com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L18
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r11 = r18
            goto L1f
        L18:
            com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$1 r1 = new com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$1
            r11 = r18
            r1.<init>(r11, r0)
        L1f:
            java.lang.Object r0 = r1.result
            java.lang.Object r12 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r13 = 1
            if (r2 == 0) goto L3c
            if (r2 != r13) goto L34
            java.lang.Object r1 = r1.L$0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L89
        L34:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3c:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            kotlinx.coroutines.GlobalScope r2 = kotlinx.coroutines.GlobalScope.INSTANCE
            r14 = r2
            kotlinx.coroutines.CoroutineScope r14 = (kotlinx.coroutines.CoroutineScope) r14
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            r15 = r2
            kotlin.coroutines.CoroutineContext r15 = (kotlin.coroutines.CoroutineContext) r15
            r16 = 0
            com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$job$1 r17 = new com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$job$1
            r10 = 0
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r22
            r6 = r21
            r7 = r20
            r8 = r23
            r9 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = r17
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r3 = 2
            r4 = 0
            r19 = r14
            r20 = r15
            r21 = r16
            r22 = r2
            r23 = r3
            r24 = r4
            kotlinx.coroutines.Job r2 = kotlinx.coroutines.BuildersKt.launch$default(r19, r20, r21, r22, r23, r24)
            r1.L$0 = r0
            r1.label = r13
            java.lang.Object r1 = r2.join(r1)
            if (r1 != r12) goto L88
            return r12
        L88:
            r1 = r0
        L89:
            T r0 = r1.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.http.impl.HttpClient.makeRequestIODispatcher(java.lang.String, java.lang.String, org.json.JSONObject, int, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer retryAfterFromResponse(HttpURLConnection con) {
        String headerField = con.getHeaderField(HttpHeaders.RETRY_AFTER);
        if (headerField != null) {
            Logging.debug$default("HttpClient: Response Retry-After: " + headerField, null, 2, null);
            Integer intOrNull = StringsKt.toIntOrNull(headerField);
            return Integer.valueOf(intOrNull != null ? intOrNull.intValue() : this._configModelStore.getModel().getHttpRetryAfterParseFailFallback());
        }
        if (con.getResponseCode() == 429) {
            return Integer.valueOf(this._configModelStore.getModel().getHttpRetryAfterParseFailFallback());
        }
        return null;
    }
}
