package com.amazon.device.simplesignin.a.a.b.a;

import com.amazon.d.a.j;
import com.amazon.device.simplesignin.a.a.b.c;
import com.amazon.device.simplesignin.a.a.d;
import com.amazon.device.simplesignin.model.Link;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.response.LinkUserAccountResponse;
import java.util.Map;

/* compiled from: LinkUserAccountResponseCommand.java */
/* loaded from: classes.dex */
class a extends c {
    private static final String b = "SSI_LinkUserAccountResponse";
    private static final String c = "1.0";

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d dVar) {
        super(dVar, b, "1.0");
    }

    @Override // com.amazon.a.a.n.a.h
    protected boolean b(j jVar) throws Exception {
        Map b2 = jVar.b();
        if (!b2.containsKey(com.amazon.device.simplesignin.a.a.a.j) && !b2.containsKey(com.amazon.device.simplesignin.a.a.a.k)) {
            super.a(RequestStatus.FAILURE);
            return false;
        }
        String str = (String) b2.get(com.amazon.device.simplesignin.a.a.a.k);
        if (str == null) {
            super.a(RequestStatus.FAILURE);
            return false;
        }
        String str2 = (String) b2.get(com.amazon.device.simplesignin.a.a.a.j);
        if (LinkUserAccountResponse.SuccessCode.LinkEstablished.name().equals(str) && str2 == null) {
            super.a(RequestStatus.FAILURE);
            return false;
        }
        Link a = str2 != null ? com.amazon.device.simplesignin.a.d.b.a(str2) : null;
        if (LinkUserAccountResponse.SuccessCode.LinkEstablished.name().equals(str) && a == null) {
            super.a(RequestStatus.FAILURE);
            return false;
        }
        super.a(RequestStatus.SUCCESSFUL, a, LinkUserAccountResponse.SuccessCode.valueOf(str));
        return true;
    }
}
