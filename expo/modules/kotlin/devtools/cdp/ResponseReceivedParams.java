package expo.modules.kotlin.devtools.cdp;

import com.amazon.a.a.o.b;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: CdpNetworkTypes.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bBA\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\u0010\r\u001a\u00060\u0003j\u0002`\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\r\u0010!\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\r\u0010#\u001a\u00060\u0003j\u0002`\u000eHÆ\u0003J\t\u0010$\u001a\u00020\u0010HÆ\u0003J\t\u0010%\u001a\u00020\u0012HÆ\u0003J\t\u0010&\u001a\u00020\u0014HÆ\u0003JM\u0010'\u001a\u00020\u00002\f\b\u0002\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\f\u001a\u00020\u00052\f\b\u0002\u0010\r\u001a\u00060\u0003j\u0002`\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001J\u0013\u0010(\u001a\u00020\u00142\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\b\u0010-\u001a\u00020.H\u0016J\t\u0010/\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\r\u001a\u00060\u0003j\u0002`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00060"}, d2 = {"Lexpo/modules/kotlin/devtools/cdp/ResponseReceivedParams;", "Lexpo/modules/kotlin/devtools/cdp/JsonSerializable;", "now", "Ljava/math/BigDecimal;", b.B, "", "Lexpo/modules/kotlin/devtools/cdp/RequestId;", "request", "Lokhttp3/Request;", "okhttpResponse", "Lokhttp3/Response;", "(Ljava/math/BigDecimal;Ljava/lang/String;Lokhttp3/Request;Lokhttp3/Response;)V", "loaderId", "timestamp", "Lexpo/modules/kotlin/devtools/cdp/MonotonicTime;", "type", "Lexpo/modules/kotlin/devtools/cdp/ResourceType;", "response", "Lexpo/modules/kotlin/devtools/cdp/Response;", "hasExtraInfo", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;Lexpo/modules/kotlin/devtools/cdp/ResourceType;Lexpo/modules/kotlin/devtools/cdp/Response;Z)V", "getHasExtraInfo", "()Z", "getLoaderId", "()Ljava/lang/String;", "getRequestId", "getResponse", "()Lexpo/modules/kotlin/devtools/cdp/Response;", "getTimestamp", "()Ljava/math/BigDecimal;", "getType", "()Lexpo/modules/kotlin/devtools/cdp/ResourceType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", "toString", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ResponseReceivedParams implements JsonSerializable {
    private final boolean hasExtraInfo;
    private final String loaderId;
    private final String requestId;
    private final Response response;
    private final BigDecimal timestamp;
    private final ResourceType type;

    public static /* synthetic */ ResponseReceivedParams copy$default(ResponseReceivedParams responseReceivedParams, String str, String str2, BigDecimal bigDecimal, ResourceType resourceType, Response response, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = responseReceivedParams.requestId;
        }
        if ((i & 2) != 0) {
            str2 = responseReceivedParams.loaderId;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            bigDecimal = responseReceivedParams.timestamp;
        }
        BigDecimal bigDecimal2 = bigDecimal;
        if ((i & 8) != 0) {
            resourceType = responseReceivedParams.type;
        }
        ResourceType resourceType2 = resourceType;
        if ((i & 16) != 0) {
            response = responseReceivedParams.response;
        }
        Response response2 = response;
        if ((i & 32) != 0) {
            z = responseReceivedParams.hasExtraInfo;
        }
        return responseReceivedParams.copy(str, str3, bigDecimal2, resourceType2, response2, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLoaderId() {
        return this.loaderId;
    }

    /* renamed from: component3, reason: from getter */
    public final BigDecimal getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component4, reason: from getter */
    public final ResourceType getType() {
        return this.type;
    }

    /* renamed from: component5, reason: from getter */
    public final Response getResponse() {
        return this.response;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getHasExtraInfo() {
        return this.hasExtraInfo;
    }

    public final ResponseReceivedParams copy(String requestId, String loaderId, BigDecimal timestamp, ResourceType type, Response response, boolean hasExtraInfo) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(loaderId, "loaderId");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(response, "response");
        return new ResponseReceivedParams(requestId, loaderId, timestamp, type, response, hasExtraInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResponseReceivedParams)) {
            return false;
        }
        ResponseReceivedParams responseReceivedParams = (ResponseReceivedParams) other;
        return Intrinsics.areEqual(this.requestId, responseReceivedParams.requestId) && Intrinsics.areEqual(this.loaderId, responseReceivedParams.loaderId) && Intrinsics.areEqual(this.timestamp, responseReceivedParams.timestamp) && this.type == responseReceivedParams.type && Intrinsics.areEqual(this.response, responseReceivedParams.response) && this.hasExtraInfo == responseReceivedParams.hasExtraInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.requestId.hashCode() * 31) + this.loaderId.hashCode()) * 31) + this.timestamp.hashCode()) * 31) + this.type.hashCode()) * 31) + this.response.hashCode()) * 31;
        boolean z = this.hasExtraInfo;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "ResponseReceivedParams(requestId=" + this.requestId + ", loaderId=" + this.loaderId + ", timestamp=" + this.timestamp + ", type=" + this.type + ", response=" + this.response + ", hasExtraInfo=" + this.hasExtraInfo + ")";
    }

    public ResponseReceivedParams(String requestId, String loaderId, BigDecimal timestamp, ResourceType type, Response response, boolean z) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(loaderId, "loaderId");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(response, "response");
        this.requestId = requestId;
        this.loaderId = loaderId;
        this.timestamp = timestamp;
        this.type = type;
        this.response = response;
        this.hasExtraInfo = z;
    }

    public /* synthetic */ ResponseReceivedParams(String str, String str2, BigDecimal bigDecimal, ResourceType resourceType, Response response, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, bigDecimal, resourceType, response, (i & 32) != 0 ? false : z);
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getLoaderId() {
        return this.loaderId;
    }

    public final BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public final ResourceType getType() {
        return this.type;
    }

    public final Response getResponse() {
        return this.response;
    }

    public final boolean getHasExtraInfo() {
        return this.hasExtraInfo;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ResponseReceivedParams(java.math.BigDecimal r10, java.lang.String r11, okhttp3.Request r12, okhttp3.Response r13) {
        /*
            r9 = this;
            java.lang.String r0 = "now"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "requestId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r12 = "okhttpResponse"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r12)
            r2 = 0
            expo.modules.kotlin.devtools.cdp.ResourceType$Companion r12 = expo.modules.kotlin.devtools.cdp.ResourceType.INSTANCE
            java.lang.String r0 = "Content-Type"
            java.lang.String r1 = ""
            java.lang.String r0 = r13.header(r0, r1)
            if (r0 != 0) goto L22
            goto L23
        L22:
            r1 = r0
        L23:
            expo.modules.kotlin.devtools.cdp.ResourceType r4 = r12.fromMimeType(r1)
            expo.modules.kotlin.devtools.cdp.Response r5 = new expo.modules.kotlin.devtools.cdp.Response
            r5.<init>(r13)
            r6 = 0
            r7 = 34
            r8 = 0
            r0 = r9
            r1 = r11
            r3 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.devtools.cdp.ResponseReceivedParams.<init>(java.math.BigDecimal, java.lang.String, okhttp3.Request, okhttp3.Response):void");
    }

    @Override // expo.modules.kotlin.devtools.cdp.JsonSerializable
    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(b.B, this.requestId);
        jSONObject.put("loaderId", this.loaderId);
        jSONObject.put("timestamp", this.timestamp);
        jSONObject.put("type", this.type.getValue());
        jSONObject.put("response", this.response.toJSONObject());
        jSONObject.put("hasExtraInfo", this.hasExtraInfo);
        return jSONObject;
    }
}
