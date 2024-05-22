package com.amazon.device.drm.model;

import com.amazon.a.a.o.b;
import com.amazon.a.a.o.f;
import com.amazon.device.drm.a.c.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class LicenseResponse {
    private static final String REQUEST_ID = "REQUEST_ID";
    private static final String REQUEST_STATUS = "REQUEST_STATUS";
    private static final String TO_STRING_FORMAT = "LicenseResponse: {requestId: \"%s\", requestStatus: \"%s\"}";
    private final RequestId requestId;
    private final RequestStatus requestStatus;

    /* loaded from: classes.dex */
    public enum RequestStatus {
        LICENSED,
        NOT_LICENSED,
        ERROR_VERIFICATION,
        ERROR_INVALID_LICENSING_KEYS,
        EXPIRED,
        UNKNOWN_ERROR
    }

    public LicenseResponse(a aVar) {
        f.a(aVar.b(), b.B);
        f.a(aVar.c(), b.C);
        this.requestId = aVar.b();
        this.requestStatus = aVar.c();
    }

    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }

    public RequestId getRequestId() {
        return this.requestId;
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = this.requestId;
        RequestStatus requestStatus = this.requestStatus;
        objArr[1] = requestStatus != null ? requestStatus.toString() : "null";
        return String.format(TO_STRING_FORMAT, objArr);
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(REQUEST_STATUS, this.requestStatus);
        jSONObject.put(REQUEST_ID, this.requestId);
        return jSONObject;
    }
}
