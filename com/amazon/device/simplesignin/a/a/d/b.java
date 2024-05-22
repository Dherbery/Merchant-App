package com.amazon.device.simplesignin.a.a.d;

import com.amazon.d.a.j;
import com.amazon.device.simplesignin.a.a.c;
import com.amazon.device.simplesignin.a.a.d;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.response.UnlinkUserAccountResponse;
import java.util.Map;

/* compiled from: UnlinkUserAccountCommand.java */
/* loaded from: classes.dex */
public class b extends c {
    private static final String b = "SSI_UnlinkUserAccount";
    private static final String c = "1.0";

    public b(a aVar, String str) {
        super(aVar, b, "1.0");
        super.a(com.amazon.device.simplesignin.a.a.a.a, str);
    }

    @Override // com.amazon.device.simplesignin.a.a.c
    protected void a(RequestStatus requestStatus) {
        b(requestStatus);
    }

    @Override // com.amazon.a.a.n.a.h
    protected boolean b(j jVar) throws Exception {
        b(RequestStatus.SUCCESSFUL);
        Map b2 = jVar.b();
        return b2.containsKey(com.amazon.device.simplesignin.a.a.a.q) && b2.get(com.amazon.device.simplesignin.a.a.a.q) != null;
    }

    private void b(RequestStatus requestStatus) {
        d dVar = (d) j();
        UnlinkUserAccountResponse unlinkUserAccountResponse = new UnlinkUserAccountResponse();
        unlinkUserAccountResponse.setRequestId(dVar.e());
        unlinkUserAccountResponse.setRequestStatus(requestStatus);
        super.a(unlinkUserAccountResponse);
    }
}
