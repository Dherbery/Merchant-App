package com.amazon.device.simplesignin.a.a.a;

import android.os.RemoteException;
import com.amazon.d.a.j;
import com.amazon.device.simplesignin.a.a.c;
import com.amazon.device.simplesignin.a.a.d;
import com.amazon.device.simplesignin.model.Link;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.response.GetUserAndLinksResponse;
import java.util.List;
import java.util.Map;

/* compiled from: GetUserAndLinksCommand.java */
/* loaded from: classes.dex */
public class b extends c {
    private static final String b = "SSI_GetUserAndLinks";
    private static final String c = "1.0";
    private static final String d = "b";

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str) {
        super(aVar, b, "1.0");
        super.a(com.amazon.device.simplesignin.a.a.a.a, str);
    }

    @Override // com.amazon.a.a.n.a.h
    protected boolean b(j jVar) throws RemoteException {
        Map b2 = jVar.b();
        if (!b2.containsKey(com.amazon.device.simplesignin.a.a.a.b) || !b2.containsKey(com.amazon.device.simplesignin.a.a.a.c)) {
            a(RequestStatus.FAILURE);
            return false;
        }
        String str = (String) b2.get(com.amazon.device.simplesignin.a.a.a.b);
        String str2 = (String) b2.get(com.amazon.device.simplesignin.a.a.a.c);
        if (str == null || str2 == null) {
            a(RequestStatus.FAILURE);
            return false;
        }
        List<Link> a = com.amazon.device.simplesignin.a.d.b.a(str, str2);
        if (a == null) {
            a(RequestStatus.FAILURE);
            return false;
        }
        a(RequestStatus.SUCCESSFUL, str, a);
        return true;
    }

    @Override // com.amazon.device.simplesignin.a.a.c
    protected void a(RequestStatus requestStatus) {
        if (RequestStatus.INVALID_LINK_SIGNING_KEY_ENCRYPTION.equals(requestStatus) || RequestStatus.INVALID_LINK_SIGNING_KEY.equals(requestStatus)) {
            a(RequestStatus.FAILURE, null, null);
        } else {
            a(requestStatus, null, null);
        }
    }

    private void a(RequestStatus requestStatus, String str, List<Link> list) {
        d dVar = (d) j();
        GetUserAndLinksResponse getUserAndLinksResponse = new GetUserAndLinksResponse();
        getUserAndLinksResponse.setRequestId(dVar.e());
        getUserAndLinksResponse.setRequestStatus(requestStatus);
        getUserAndLinksResponse.setAmazonUserId(str);
        getUserAndLinksResponse.setLinks(list);
        super.a(getUserAndLinksResponse);
    }
}
