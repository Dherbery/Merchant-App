package com.amazon.device.iap.model;

import com.amazon.a.a.o.b;
import com.amazon.a.a.o.f;
import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class UserDataResponse {
    private static final String REQUEST_ID = "REQUEST_ID";
    private static final String REQUEST_STATUS = "REQUEST_STATUS";
    private static final String TO_STRING_FORMAT = "(%s, requestId: \"%s\", requestStatus: \"%s\", userData: \"%s\")";
    private static final String USER_DATA = "USER_DATA";
    private final RequestId requestId;
    private final RequestStatus requestStatus;
    private final UserData userData;

    /* loaded from: classes.dex */
    public enum RequestStatus {
        SUCCESSFUL,
        FAILED,
        NOT_SUPPORTED
    }

    public UserDataResponse(UserDataResponseBuilder userDataResponseBuilder) {
        f.a(userDataResponseBuilder.getRequestId(), b.B);
        f.a(userDataResponseBuilder.getRequestStatus(), b.C);
        this.requestId = userDataResponseBuilder.getRequestId();
        this.requestStatus = userDataResponseBuilder.getRequestStatus();
        this.userData = userDataResponseBuilder.getUserData();
    }

    public RequestId getRequestId() {
        return this.requestId;
    }

    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = super.toString();
        objArr[1] = this.requestId;
        RequestStatus requestStatus = this.requestStatus;
        objArr[2] = requestStatus != null ? requestStatus.toString() : "null";
        UserData userData = this.userData;
        objArr[3] = userData != null ? userData.toString() : "null";
        return String.format(TO_STRING_FORMAT, objArr);
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(REQUEST_ID, this.requestId);
        jSONObject.put(REQUEST_STATUS, this.requestStatus);
        UserData userData = this.userData;
        jSONObject.put(USER_DATA, userData != null ? userData.toJSON() : "");
        return jSONObject;
    }
}
