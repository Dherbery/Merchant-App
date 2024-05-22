package com.amazon.device.simplesignin.model.response;

import com.amazon.device.simplesignin.model.RequestId;
import com.amazon.device.simplesignin.model.RequestStatus;

/* loaded from: classes.dex */
public class UnlinkUserAccountResponse {
    private RequestId requestId;
    private RequestStatus requestStatus;

    public void setRequestId(RequestId requestId) {
        this.requestId = requestId;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof UnlinkUserAccountResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UnlinkUserAccountResponse)) {
            return false;
        }
        UnlinkUserAccountResponse unlinkUserAccountResponse = (UnlinkUserAccountResponse) obj;
        if (!unlinkUserAccountResponse.canEqual(this)) {
            return false;
        }
        RequestId requestId = getRequestId();
        RequestId requestId2 = unlinkUserAccountResponse.getRequestId();
        if (requestId != null ? !requestId.equals(requestId2) : requestId2 != null) {
            return false;
        }
        RequestStatus requestStatus = getRequestStatus();
        RequestStatus requestStatus2 = unlinkUserAccountResponse.getRequestStatus();
        return requestStatus != null ? requestStatus.equals(requestStatus2) : requestStatus2 == null;
    }

    public int hashCode() {
        RequestId requestId = getRequestId();
        int hashCode = requestId == null ? 43 : requestId.hashCode();
        RequestStatus requestStatus = getRequestStatus();
        return ((hashCode + 59) * 59) + (requestStatus != null ? requestStatus.hashCode() : 43);
    }

    public RequestId getRequestId() {
        return this.requestId;
    }

    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }
}
