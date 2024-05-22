package com.amazon.device.simplesignin.model.response;

import com.amazon.device.simplesignin.model.Link;
import com.amazon.device.simplesignin.model.RequestId;
import com.amazon.device.simplesignin.model.RequestStatus;

/* loaded from: classes.dex */
public class LinkUserAccountResponse {
    private Link link;
    private RequestId requestId;
    private RequestStatus requestStatus;
    private SuccessCode successCode;

    /* loaded from: classes.dex */
    public enum SuccessCode {
        LinkAlreadyExists,
        LinkEstablished,
        ConsentDenied
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public void setRequestId(RequestId requestId) {
        this.requestId = requestId;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public void setSuccessCode(SuccessCode successCode) {
        this.successCode = successCode;
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof LinkUserAccountResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinkUserAccountResponse)) {
            return false;
        }
        LinkUserAccountResponse linkUserAccountResponse = (LinkUserAccountResponse) obj;
        if (!linkUserAccountResponse.canEqual(this)) {
            return false;
        }
        RequestId requestId = getRequestId();
        RequestId requestId2 = linkUserAccountResponse.getRequestId();
        if (requestId != null ? !requestId.equals(requestId2) : requestId2 != null) {
            return false;
        }
        RequestStatus requestStatus = getRequestStatus();
        RequestStatus requestStatus2 = linkUserAccountResponse.getRequestStatus();
        if (requestStatus != null ? !requestStatus.equals(requestStatus2) : requestStatus2 != null) {
            return false;
        }
        SuccessCode successCode = getSuccessCode();
        SuccessCode successCode2 = linkUserAccountResponse.getSuccessCode();
        if (successCode != null ? !successCode.equals(successCode2) : successCode2 != null) {
            return false;
        }
        Link link = getLink();
        Link link2 = linkUserAccountResponse.getLink();
        return link != null ? link.equals(link2) : link2 == null;
    }

    public int hashCode() {
        RequestId requestId = getRequestId();
        int hashCode = requestId == null ? 43 : requestId.hashCode();
        RequestStatus requestStatus = getRequestStatus();
        int hashCode2 = ((hashCode + 59) * 59) + (requestStatus == null ? 43 : requestStatus.hashCode());
        SuccessCode successCode = getSuccessCode();
        int hashCode3 = (hashCode2 * 59) + (successCode == null ? 43 : successCode.hashCode());
        Link link = getLink();
        return (hashCode3 * 59) + (link != null ? link.hashCode() : 43);
    }

    public RequestId getRequestId() {
        return this.requestId;
    }

    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }

    public SuccessCode getSuccessCode() {
        return this.successCode;
    }

    public Link getLink() {
        return this.link;
    }
}
