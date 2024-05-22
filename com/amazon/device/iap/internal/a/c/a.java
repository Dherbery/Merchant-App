package com.amazon.device.iap.internal.a.c;

import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataResponse;

/* compiled from: GetUserDataRequest.java */
/* loaded from: classes.dex */
public final class a extends com.amazon.device.iap.internal.a.c {
    public a(RequestId requestId) {
        super(requestId);
        d dVar = new d(this);
        dVar.b(new c(this));
        a((h) dVar);
    }

    @Override // com.amazon.device.iap.internal.a.c, com.amazon.a.a.j.a
    public void b() {
        a((UserDataResponse) a().b());
    }

    @Override // com.amazon.device.iap.internal.a.c, com.amazon.a.a.j.a
    public void c() {
        UserDataResponse userDataResponse = (UserDataResponse) a().b();
        if (userDataResponse == null) {
            userDataResponse = new UserDataResponseBuilder().setRequestId(d()).setRequestStatus(UserDataResponse.RequestStatus.FAILED).build();
        }
        a(userDataResponse);
    }
}
