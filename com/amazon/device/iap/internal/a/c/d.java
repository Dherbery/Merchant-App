package com.amazon.device.iap.internal.a.c;

import android.os.RemoteException;
import com.amazon.a.a.o.f;
import com.amazon.d.a.j;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import java.util.Map;

/* compiled from: GetUserIdCommandV2.java */
/* loaded from: classes.dex */
public final class d extends b {
    private static final String d = "d";

    public d(com.amazon.device.iap.internal.a.c cVar) {
        super(cVar, com.amazon.a.a.o.b.ae);
    }

    @Override // com.amazon.a.a.n.a.h
    protected boolean b(j jVar) throws RemoteException, com.amazon.a.a.d.b {
        String str = d;
        com.amazon.device.iap.internal.util.b.a(str, "onResult: result = " + jVar);
        Map b = jVar.b();
        com.amazon.device.iap.internal.util.b.a(str, "data: " + b);
        String str2 = (String) b.get("userId");
        String str3 = (String) b.get(com.amazon.a.a.o.b.m);
        com.amazon.device.iap.internal.a.c cVar = (com.amazon.device.iap.internal.a.c) j();
        if (f.a(str2) || f.a(str3)) {
            cVar.a().a(new UserDataResponseBuilder().setRequestId(cVar.d()).setRequestStatus(UserDataResponse.RequestStatus.FAILED).build());
            return false;
        }
        UserData build = new UserDataBuilder().setUserId(str2).setMarketplace(str3).build();
        UserDataResponse build2 = new UserDataResponseBuilder().setRequestId(cVar.d()).setRequestStatus(UserDataResponse.RequestStatus.SUCCESSFUL).setUserData(build).build();
        cVar.a().a("userId", build.getUserId());
        cVar.a().a(build2);
        return true;
    }
}
