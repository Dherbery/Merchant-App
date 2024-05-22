package com.revenuecat.purchases.common;

import android.os.Build;
import androidx.browser.trusted.sharing.ShareTarget;
import com.amazon.a.a.o.b;
import com.amplitude.api.DeviceInfo;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.networking.ETagManager;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPRequest;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.networking.MapConverter;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.interfaces.StorefrontProvider;
import com.revenuecat.purchases.strings.NetworkStrings;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HTTPClient.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 I2\u00020\u0001:\u0001IBC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\n \"*\u0004\u0018\u00010!0!2\u0006\u0010#\u001a\u00020$H\u0002JT\u0010%\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0&2\u0006\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010!2\u0006\u0010,\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010!H\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010\u00162\u0006\u0010#\u001a\u00020\u001dH\u0002J\u0012\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010#\u001a\u00020$H\u0002J\u0012\u00101\u001a\u0004\u0018\u00010!2\u0006\u0010#\u001a\u00020$H\u0002J\b\u00102\u001a\u00020!H\u0002Jj\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0016\u00109\u001a\u0012\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010&2\u001a\u0010:\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0<\u0018\u00010;2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0&2\u0006\u0010)\u001a\u00020*H\u0002Jh\u0010>\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0016\u00109\u001a\u0012\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010&2\u001a\u0010:\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0<\u0018\u00010;2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0&2\b\b\u0002\u0010)\u001a\u00020*J\u0010\u0010?\u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J*\u0010@\u001a\u00020\u001b2\u0006\u00107\u001a\u0002082\u0006\u0010A\u001a\u0002002\u0006\u0010B\u001a\u00020*2\b\u0010C\u001a\u0004\u0018\u000104H\u0002J6\u0010D\u001a\u00020E2\u0006\u0010(\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\b\u0010F\u001a\u0004\u0018\u00010!2\b\u0010+\u001a\u0004\u0018\u00010!2\b\u0010-\u001a\u0004\u0018\u00010!H\u0002J\u0018\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u00172\u0006\u00109\u001a\u00020!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/revenuecat/purchases/common/HTTPClient;", "", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "eTagManager", "Lcom/revenuecat/purchases/common/networking/ETagManager;", "diagnosticsTrackerIfEnabled", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "signingManager", "Lcom/revenuecat/purchases/common/verification/SigningManager;", "storefrontProvider", "Lcom/revenuecat/purchases/interfaces/StorefrontProvider;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "mapConverter", "Lcom/revenuecat/purchases/common/networking/MapConverter;", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/networking/ETagManager;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;Lcom/revenuecat/purchases/common/verification/SigningManager;Lcom/revenuecat/purchases/interfaces/StorefrontProvider;Lcom/revenuecat/purchases/common/DateProvider;Lcom/revenuecat/purchases/common/networking/MapConverter;)V", "getSigningManager", "()Lcom/revenuecat/purchases/common/verification/SigningManager;", "buffer", "Ljava/io/BufferedReader;", "inputStream", "Ljava/io/InputStream;", "Ljava/io/BufferedWriter;", "outputStream", "Ljava/io/OutputStream;", "clearCaches", "", "getConnection", "Ljava/net/HttpURLConnection;", "request", "Lcom/revenuecat/purchases/common/networking/HTTPRequest;", "getETagHeader", "", "kotlin.jvm.PlatformType", "connection", "Ljava/net/URLConnection;", "getHeaders", "", "authenticationHeaders", "urlPath", "refreshETag", "", "nonce", "shouldSignResponse", "postFieldsToSignHeader", "getInputStream", "getRequestDateHeader", "Ljava/util/Date;", "getRequestTimeHeader", "getXPlatformHeader", "performCall", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "baseURL", "Ljava/net/URL;", "endpoint", "Lcom/revenuecat/purchases/common/networking/Endpoint;", TtmlNode.TAG_BODY, "postFieldsToSign", "", "Lkotlin/Pair;", "requestHeaders", "performRequest", "readFully", "trackHttpRequestPerformedIfNeeded", "requestStartTime", "callSuccessful", "callResult", "verifyResponse", "Lcom/revenuecat/purchases/VerificationResult;", "payload", "writeFully", "writer", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class HTTPClient {
    public static final int NO_STATUS_CODE = -1;
    private final AppConfig appConfig;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final ETagManager eTagManager;
    private final MapConverter mapConverter;
    private final SigningManager signingManager;
    private final StorefrontProvider storefrontProvider;

    /* compiled from: HTTPClient.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Store.values().length];
            try {
                iArr[Store.AMAZON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public HTTPClient(AppConfig appConfig, ETagManager eTagManager, DiagnosticsTracker diagnosticsTracker, SigningManager signingManager, StorefrontProvider storefrontProvider, DateProvider dateProvider, MapConverter mapConverter) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(eTagManager, "eTagManager");
        Intrinsics.checkNotNullParameter(signingManager, "signingManager");
        Intrinsics.checkNotNullParameter(storefrontProvider, "storefrontProvider");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(mapConverter, "mapConverter");
        this.appConfig = appConfig;
        this.eTagManager = eTagManager;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.signingManager = signingManager;
        this.storefrontProvider = storefrontProvider;
        this.dateProvider = dateProvider;
        this.mapConverter = mapConverter;
    }

    public final SigningManager getSigningManager() {
        return this.signingManager;
    }

    public /* synthetic */ HTTPClient(AppConfig appConfig, ETagManager eTagManager, DiagnosticsTracker diagnosticsTracker, SigningManager signingManager, StorefrontProvider storefrontProvider, DateProvider dateProvider, MapConverter mapConverter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appConfig, eTagManager, diagnosticsTracker, signingManager, storefrontProvider, (i & 32) != 0 ? new DefaultDateProvider() : dateProvider, (i & 64) != 0 ? new MapConverter() : mapConverter);
    }

    private final BufferedReader buffer(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    private final BufferedWriter buffer(OutputStream outputStream) {
        return new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    private final String readFully(InputStream inputStream) throws IOException {
        return TextStreamsKt.readText(buffer(inputStream));
    }

    private final InputStream getInputStream(HttpURLConnection connection) {
        try {
            return connection.getInputStream();
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException ? true : e instanceof IOException) {
                LogIntent logIntent = LogIntent.WARNING;
                String format = String.format(NetworkStrings.PROBLEM_CONNECTING, Arrays.copyOf(new Object[]{e.getMessage()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                LogWrapperKt.log(logIntent, format);
                return connection.getErrorStream();
            }
            throw e;
        }
    }

    private final void writeFully(BufferedWriter writer, String body) throws IOException {
        writer.write(body);
        writer.flush();
    }

    public static /* synthetic */ HTTPResult performRequest$default(HTTPClient hTTPClient, URL url, Endpoint endpoint, Map map, List list, Map map2, boolean z, int i, Object obj) throws JSONException, IOException {
        if ((i & 32) != 0) {
            z = false;
        }
        return hTTPClient.performRequest(url, endpoint, map, list, map2, z);
    }

    public final HTTPResult performRequest(URL baseURL, Endpoint endpoint, Map<String, ? extends Object> body, List<Pair<String, String>> postFieldsToSign, Map<String, String> requestHeaders, boolean refreshETag) throws JSONException, IOException {
        Intrinsics.checkNotNullParameter(baseURL, "baseURL");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        if (this.appConfig.getForceServerErrors()) {
            LogUtilsKt.warnLog("Forcing server error for request to " + endpoint.getPath());
            return new HTTPResult(500, "", HTTPResult.Origin.BACKEND, null, VerificationResult.NOT_REQUESTED);
        }
        Date now = this.dateProvider.getNow();
        try {
            HTTPResult performCall = performCall(baseURL, endpoint, body, postFieldsToSign, requestHeaders, refreshETag);
            trackHttpRequestPerformedIfNeeded(endpoint, now, true, performCall);
            if (performCall != null) {
                return performCall;
            }
            LogWrapperKt.log(LogIntent.WARNING, NetworkStrings.ETAG_RETRYING_CALL);
            return performRequest(baseURL, endpoint, body, postFieldsToSign, requestHeaders, true);
        } catch (Throwable th) {
            trackHttpRequestPerformedIfNeeded(endpoint, now, false, null);
            throw th;
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009f A[Catch: all -> 0x0127, TRY_LEAVE, TryCatch #0 {all -> 0x0127, blocks: (B:21:0x007e, B:23:0x009f), top: B:20:0x007e }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.revenuecat.purchases.common.networking.HTTPResult performCall(java.net.URL r22, com.revenuecat.purchases.common.networking.Endpoint r23, java.util.Map<java.lang.String, ? extends java.lang.Object> r24, java.util.List<kotlin.Pair<java.lang.String, java.lang.String>> r25, java.util.Map<java.lang.String, java.lang.String> r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.HTTPClient.performCall(java.net.URL, com.revenuecat.purchases.common.networking.Endpoint, java.util.Map, java.util.List, java.util.Map, boolean):com.revenuecat.purchases.common.networking.HTTPResult");
    }

    private final void trackHttpRequestPerformedIfNeeded(Endpoint endpoint, Date requestStartTime, boolean callSuccessful, HTTPResult callResult) {
        int i;
        VerificationResult verificationResult;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            long between = DurationExtensionsKt.between(Duration.INSTANCE, requestStartTime, this.dateProvider.getNow());
            if (callSuccessful) {
                i = callResult != null ? callResult.getResponseCode() : RCHTTPStatusCodes.NOT_MODIFIED;
            } else {
                i = -1;
            }
            int i2 = i;
            HTTPResult.Origin origin = callResult != null ? callResult.getOrigin() : null;
            if (callResult == null || (verificationResult = callResult.getVerificationResult()) == null) {
                verificationResult = VerificationResult.NOT_REQUESTED;
            }
            diagnosticsTracker.m1094trackHttpRequestPerformedNcHsxvU(endpoint, between, callSuccessful && RCHTTPStatusCodes.INSTANCE.isSuccessful(i2), i2, origin, verificationResult);
        }
    }

    public final void clearCaches() {
        this.eTagManager.clearCaches$purchases_defaultsRelease();
    }

    private final Map<String, String> getHeaders(Map<String, String> authenticationHeaders, String urlPath, boolean refreshETag, String nonce, boolean shouldSignResponse, String postFieldsToSignHeader) {
        Pair[] pairArr = new Pair[14];
        pairArr[0] = TuplesKt.to("Content-Type", "application/json");
        pairArr[1] = TuplesKt.to("X-Platform", getXPlatformHeader());
        pairArr[2] = TuplesKt.to("X-Platform-Flavor", this.appConfig.getPlatformInfo().getFlavor());
        pairArr[3] = TuplesKt.to("X-Platform-Flavor-Version", this.appConfig.getPlatformInfo().getVersion());
        pairArr[4] = TuplesKt.to("X-Platform-Version", String.valueOf(Build.VERSION.SDK_INT));
        pairArr[5] = TuplesKt.to("X-Version", "7.6.0");
        pairArr[6] = TuplesKt.to("X-Client-Locale", this.appConfig.getLanguageTag());
        pairArr[7] = TuplesKt.to("X-Client-Version", this.appConfig.getVersionName());
        pairArr[8] = TuplesKt.to("X-Client-Bundle-ID", this.appConfig.getPackageName());
        boolean finishTransactions = this.appConfig.getFinishTransactions();
        String str = b.ac;
        pairArr[9] = TuplesKt.to("X-Observer-Mode-Enabled", finishTransactions ? "false" : b.ac);
        pairArr[10] = TuplesKt.to("X-Nonce", nonce);
        pairArr[11] = TuplesKt.to(HTTPRequest.POST_PARAMS_HASH, postFieldsToSignHeader);
        if (!this.appConfig.getCustomEntitlementComputation()) {
            str = null;
        }
        pairArr[12] = TuplesKt.to("X-Custom-Entitlements-Computation", str);
        pairArr[13] = TuplesKt.to("X-Storefront", this.storefrontProvider.getStorefront());
        return MapExtensionsKt.filterNotNullValues(MapsKt.plus(MapsKt.plus(MapsKt.mapOf(pairArr), authenticationHeaders), this.eTagManager.getETagHeaders$purchases_defaultsRelease(urlPath, shouldSignResponse, refreshETag)));
    }

    private final HttpURLConnection getConnection(HTTPRequest request) {
        URLConnection openConnection = request.getFullURL().openConnection();
        Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        JSONObject body = request.getBody();
        if (body != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
            OutputStream os = httpURLConnection.getOutputStream();
            Intrinsics.checkNotNullExpressionValue(os, "os");
            BufferedWriter buffer = buffer(os);
            String jSONObject = body.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "body.toString()");
            writeFully(buffer, jSONObject);
        }
        return httpURLConnection;
    }

    private final String getXPlatformHeader() {
        return WhenMappings.$EnumSwitchMapping$0[this.appConfig.getStore().ordinal()] == 1 ? "amazon" : DeviceInfo.OS_NAME;
    }

    private final VerificationResult verifyResponse(String urlPath, URLConnection connection, String payload, String nonce, String postFieldsToSignHeader) {
        return this.signingManager.verifyResponse(urlPath, connection.getHeaderField(HTTPResult.SIGNATURE_HEADER_NAME), nonce, payload, getRequestTimeHeader(connection), getETagHeader(connection), postFieldsToSignHeader);
    }

    private final String getETagHeader(URLConnection connection) {
        return connection.getHeaderField("X-RevenueCat-ETag");
    }

    private final String getRequestTimeHeader(URLConnection connection) {
        String headerField = connection.getHeaderField(HTTPResult.REQUEST_TIME_HEADER_NAME);
        if (headerField == null || !(!StringsKt.isBlank(headerField))) {
            return null;
        }
        return headerField;
    }

    private final Date getRequestDateHeader(URLConnection connection) {
        String requestTimeHeader = getRequestTimeHeader(connection);
        if (requestTimeHeader != null) {
            return new Date(Long.parseLong(requestTimeHeader));
        }
        return null;
    }
}
