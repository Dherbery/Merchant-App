package com.revenuecat.purchases.common.networking;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.common.net.HttpHeaders;
import com.revenuecat.purchases.VerificationResult;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: HTTPResult.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0080\b\u0018\u0000 '2\u00020\u0001:\u0002'(B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J=\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0006\u0010%\u001a\u00020\u0005J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPResult;", "", "responseCode", "", "payload", "", "origin", "Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;", "requestDate", "Ljava/util/Date;", "verificationResult", "Lcom/revenuecat/purchases/VerificationResult;", "(ILjava/lang/String;Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;Ljava/util/Date;Lcom/revenuecat/purchases/VerificationResult;)V", TtmlNode.TAG_BODY, "Lorg/json/JSONObject;", "getBody", "()Lorg/json/JSONObject;", "getOrigin", "()Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;", "getPayload", "()Ljava/lang/String;", "getRequestDate", "()Ljava/util/Date;", "getResponseCode", "()I", "getVerificationResult", "()Lcom/revenuecat/purchases/VerificationResult;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "serialize", "toString", "Companion", HttpHeaders.ORIGIN, "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class HTTPResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String ETAG_HEADER_NAME = "X-RevenueCat-ETag";
    public static final String REQUEST_TIME_HEADER_NAME = "X-RevenueCat-Request-Time";
    public static final String SIGNATURE_HEADER_NAME = "X-Signature";
    private final JSONObject body;
    private final Origin origin;
    private final String payload;
    private final Date requestDate;
    private final int responseCode;
    private final VerificationResult verificationResult;

    /* compiled from: HTTPResult.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;", "", "(Ljava/lang/String;I)V", "BACKEND", "CACHE", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public enum Origin {
        BACKEND,
        CACHE
    }

    public static /* synthetic */ HTTPResult copy$default(HTTPResult hTTPResult, int i, String str, Origin origin, Date date, VerificationResult verificationResult, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = hTTPResult.responseCode;
        }
        if ((i2 & 2) != 0) {
            str = hTTPResult.payload;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            origin = hTTPResult.origin;
        }
        Origin origin2 = origin;
        if ((i2 & 8) != 0) {
            date = hTTPResult.requestDate;
        }
        Date date2 = date;
        if ((i2 & 16) != 0) {
            verificationResult = hTTPResult.verificationResult;
        }
        return hTTPResult.copy(i, str2, origin2, date2, verificationResult);
    }

    /* renamed from: component1, reason: from getter */
    public final int getResponseCode() {
        return this.responseCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPayload() {
        return this.payload;
    }

    /* renamed from: component3, reason: from getter */
    public final Origin getOrigin() {
        return this.origin;
    }

    /* renamed from: component4, reason: from getter */
    public final Date getRequestDate() {
        return this.requestDate;
    }

    /* renamed from: component5, reason: from getter */
    public final VerificationResult getVerificationResult() {
        return this.verificationResult;
    }

    public final HTTPResult copy(int responseCode, String payload, Origin origin, Date requestDate, VerificationResult verificationResult) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        return new HTTPResult(responseCode, payload, origin, requestDate, verificationResult);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HTTPResult)) {
            return false;
        }
        HTTPResult hTTPResult = (HTTPResult) other;
        return this.responseCode == hTTPResult.responseCode && Intrinsics.areEqual(this.payload, hTTPResult.payload) && this.origin == hTTPResult.origin && Intrinsics.areEqual(this.requestDate, hTTPResult.requestDate) && this.verificationResult == hTTPResult.verificationResult;
    }

    public int hashCode() {
        int hashCode = ((((this.responseCode * 31) + this.payload.hashCode()) * 31) + this.origin.hashCode()) * 31;
        Date date = this.requestDate;
        return ((hashCode + (date == null ? 0 : date.hashCode())) * 31) + this.verificationResult.hashCode();
    }

    public String toString() {
        return "HTTPResult(responseCode=" + this.responseCode + ", payload=" + this.payload + ", origin=" + this.origin + ", requestDate=" + this.requestDate + ", verificationResult=" + this.verificationResult + ')';
    }

    public HTTPResult(int i, String payload, Origin origin, Date date, VerificationResult verificationResult) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        this.responseCode = i;
        this.payload = payload;
        this.origin = origin;
        this.requestDate = date;
        this.verificationResult = verificationResult;
        payload = StringsKt.isBlank(payload) ^ true ? payload : null;
        this.body = payload != null ? new JSONObject(payload) : new JSONObject();
    }

    public final int getResponseCode() {
        return this.responseCode;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final Origin getOrigin() {
        return this.origin;
    }

    public final Date getRequestDate() {
        return this.requestDate;
    }

    public final VerificationResult getVerificationResult() {
        return this.verificationResult;
    }

    /* compiled from: HTTPResult.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPResult$Companion;", "", "()V", "ETAG_HEADER_NAME", "", "REQUEST_TIME_HEADER_NAME", "SIGNATURE_HEADER_NAME", "deserialize", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "serialized", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HTTPResult deserialize(String serialized) {
            Origin origin;
            VerificationResult verificationResult;
            Intrinsics.checkNotNullParameter(serialized, "serialized");
            JSONObject jSONObject = new JSONObject(serialized);
            int i = jSONObject.getInt("responseCode");
            String payload = jSONObject.getString("payload");
            if (jSONObject.has("origin")) {
                String string = jSONObject.getString("origin");
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(SERIALIZATION_NAME_ORIGIN)");
                origin = Origin.valueOf(string);
            } else {
                origin = Origin.CACHE;
            }
            Origin origin2 = origin;
            Date date = jSONObject.has("requestDate") ? new Date(jSONObject.getLong("requestDate")) : null;
            if (jSONObject.has("verificationResult")) {
                String string2 = jSONObject.getString("verificationResult");
                Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(SER…NAME_VERIFICATION_RESULT)");
                verificationResult = VerificationResult.valueOf(string2);
            } else {
                verificationResult = VerificationResult.NOT_REQUESTED;
            }
            Intrinsics.checkNotNullExpressionValue(payload, "payload");
            return new HTTPResult(i, payload, origin2, date, verificationResult);
        }
    }

    public final JSONObject getBody() {
        return this.body;
    }

    public final String serialize() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("responseCode", this.responseCode);
        jSONObject.put("payload", this.payload);
        jSONObject.put("origin", this.origin.name());
        Date date = this.requestDate;
        jSONObject.put("requestDate", date != null ? Long.valueOf(date.getTime()) : null);
        jSONObject.put("verificationResult", this.verificationResult.name());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }
}
