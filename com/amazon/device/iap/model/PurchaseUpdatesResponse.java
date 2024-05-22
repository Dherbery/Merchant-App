package com.amazon.device.iap.model;

import com.amazon.a.a.o.b;
import com.amazon.a.a.o.f;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class PurchaseUpdatesResponse {
    private static final String HAS_MORE = "HAS_MORE";
    private static final String RECEIPTS = "RECEIPTS";
    private static final String REQUEST_ID = "REQUEST_ID";
    private static final String REQUEST_STATUS = "REQUEST_STATUS";
    private static final String TO_STRING_FORMAT = "(%s, requestId: \"%s\", requestStatus: \"%s\", userData: \"%s\", receipts: %s, hasMore: \"%b\")";
    private static final String USER_DATA = "USER_DATA";
    private final boolean hasMore;
    private final List<Receipt> receipts;
    private final RequestId requestId;
    private final RequestStatus requestStatus;
    private final UserData userData;

    /* loaded from: classes.dex */
    public enum RequestStatus {
        SUCCESSFUL,
        FAILED,
        NOT_SUPPORTED
    }

    public PurchaseUpdatesResponse(PurchaseUpdatesResponseBuilder purchaseUpdatesResponseBuilder) {
        f.a(purchaseUpdatesResponseBuilder.getRequestId(), b.B);
        f.a(purchaseUpdatesResponseBuilder.getRequestStatus(), b.C);
        if (RequestStatus.SUCCESSFUL == purchaseUpdatesResponseBuilder.getRequestStatus()) {
            f.a(purchaseUpdatesResponseBuilder.getUserData(), "userData");
            f.a((Object) purchaseUpdatesResponseBuilder.getReceipts(), b.G);
        }
        this.requestId = purchaseUpdatesResponseBuilder.getRequestId();
        this.requestStatus = purchaseUpdatesResponseBuilder.getRequestStatus();
        this.userData = purchaseUpdatesResponseBuilder.getUserData();
        this.receipts = purchaseUpdatesResponseBuilder.getReceipts() == null ? new ArrayList<>() : purchaseUpdatesResponseBuilder.getReceipts();
        this.hasMore = purchaseUpdatesResponseBuilder.hasMore();
    }

    public RequestId getRequestId() {
        return this.requestId;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }

    public List<Receipt> getReceipts() {
        return this.receipts;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public String toString() {
        Object[] objArr = new Object[6];
        objArr[0] = super.toString();
        objArr[1] = this.requestId;
        objArr[2] = this.requestStatus;
        objArr[3] = this.userData;
        List<Receipt> list = this.receipts;
        objArr[4] = list != null ? Arrays.toString(list.toArray()) : "null";
        objArr[5] = Boolean.valueOf(this.hasMore);
        return String.format(TO_STRING_FORMAT, objArr);
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(REQUEST_ID, this.requestId);
        jSONObject.put(REQUEST_STATUS, this.requestStatus);
        UserData userData = this.userData;
        jSONObject.put(USER_DATA, userData != null ? userData.toJSON() : "");
        JSONArray jSONArray = new JSONArray();
        List<Receipt> list = this.receipts;
        if (list != null) {
            Iterator<Receipt> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJSON());
            }
        }
        jSONObject.put(RECEIPTS, jSONArray);
        jSONObject.put(HAS_MORE, this.hasMore);
        return jSONObject;
    }
}
