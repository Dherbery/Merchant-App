package expo.modules.kotlin.devtools.cdp;

import com.amazon.a.a.o.b;
import expo.modules.kotlin.types.LazyKType$$ExternalSyntheticBackport0;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: CdpNetworkTypes.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB%\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\n\u0010\f\u001a\u00060\u0003j\u0002`\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\r\u0010\u0017\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003J\r\u0010\u0018\u001a\u00060\u0003j\u0002`\rHÆ\u0003J\t\u0010\u0019\u001a\u00020\u000fHÆ\u0003J/\u0010\u001a\u001a\u00020\u00002\f\b\u0002\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\f\b\u0002\u0010\f\u001a\u00060\u0003j\u0002`\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\b\u0010!\u001a\u00020\"H\u0016J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\f\u001a\u00060\u0003j\u0002`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lexpo/modules/kotlin/devtools/cdp/LoadingFinishedParams;", "Lexpo/modules/kotlin/devtools/cdp/JsonSerializable;", "now", "Ljava/math/BigDecimal;", b.B, "", "Lexpo/modules/kotlin/devtools/cdp/RequestId;", "request", "Lokhttp3/Request;", "response", "Lokhttp3/Response;", "(Ljava/math/BigDecimal;Ljava/lang/String;Lokhttp3/Request;Lokhttp3/Response;)V", "timestamp", "Lexpo/modules/kotlin/devtools/cdp/MonotonicTime;", "encodedDataLength", "", "(Ljava/lang/String;Ljava/math/BigDecimal;J)V", "getEncodedDataLength", "()J", "getRequestId", "()Ljava/lang/String;", "getTimestamp", "()Ljava/math/BigDecimal;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", "toString", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class LoadingFinishedParams implements JsonSerializable {
    private final long encodedDataLength;
    private final String requestId;
    private final BigDecimal timestamp;

    public static /* synthetic */ LoadingFinishedParams copy$default(LoadingFinishedParams loadingFinishedParams, String str, BigDecimal bigDecimal, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loadingFinishedParams.requestId;
        }
        if ((i & 2) != 0) {
            bigDecimal = loadingFinishedParams.timestamp;
        }
        if ((i & 4) != 0) {
            j = loadingFinishedParams.encodedDataLength;
        }
        return loadingFinishedParams.copy(str, bigDecimal, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: component2, reason: from getter */
    public final BigDecimal getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component3, reason: from getter */
    public final long getEncodedDataLength() {
        return this.encodedDataLength;
    }

    public final LoadingFinishedParams copy(String requestId, BigDecimal timestamp, long encodedDataLength) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        return new LoadingFinishedParams(requestId, timestamp, encodedDataLength);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadingFinishedParams)) {
            return false;
        }
        LoadingFinishedParams loadingFinishedParams = (LoadingFinishedParams) other;
        return Intrinsics.areEqual(this.requestId, loadingFinishedParams.requestId) && Intrinsics.areEqual(this.timestamp, loadingFinishedParams.timestamp) && this.encodedDataLength == loadingFinishedParams.encodedDataLength;
    }

    public int hashCode() {
        return (((this.requestId.hashCode() * 31) + this.timestamp.hashCode()) * 31) + LazyKType$$ExternalSyntheticBackport0.m(this.encodedDataLength);
    }

    public String toString() {
        return "LoadingFinishedParams(requestId=" + this.requestId + ", timestamp=" + this.timestamp + ", encodedDataLength=" + this.encodedDataLength + ")";
    }

    public LoadingFinishedParams(String requestId, BigDecimal timestamp, long j) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.encodedDataLength = j;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public final long getEncodedDataLength() {
        return this.encodedDataLength;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LoadingFinishedParams(java.math.BigDecimal r2, java.lang.String r3, okhttp3.Request r4, okhttp3.Response r5) {
        /*
            r1 = this;
            java.lang.String r0 = "now"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "requestId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r4 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r4)
            okhttp3.ResponseBody r4 = r5.body()
            if (r4 == 0) goto L1f
            long r4 = r4.getContentLength()
            goto L21
        L1f:
            r4 = 0
        L21:
            r1.<init>(r3, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.devtools.cdp.LoadingFinishedParams.<init>(java.math.BigDecimal, java.lang.String, okhttp3.Request, okhttp3.Response):void");
    }

    @Override // expo.modules.kotlin.devtools.cdp.JsonSerializable
    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(b.B, this.requestId);
        jSONObject.put("timestamp", this.timestamp);
        jSONObject.put("encodedDataLength", this.encodedDataLength);
        return jSONObject;
    }
}
