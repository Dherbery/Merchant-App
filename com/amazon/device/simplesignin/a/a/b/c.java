package com.amazon.device.simplesignin.a.a.b;

import com.amazon.device.simplesignin.a.a.d;
import com.amazon.device.simplesignin.model.Link;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.response.LinkUserAccountResponse;

/* compiled from: LinkUserAccountCommandBase.java */
/* loaded from: classes.dex */
public abstract class c extends com.amazon.device.simplesignin.a.a.c {
    /* JADX INFO: Access modifiers changed from: protected */
    public c(d dVar, String str, String str2) {
        super(dVar, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amazon.device.simplesignin.a.a.c
    public void a(RequestStatus requestStatus) {
        a(requestStatus, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(RequestStatus requestStatus, Link link, LinkUserAccountResponse.SuccessCode successCode) {
        d dVar = (d) j();
        LinkUserAccountResponse linkUserAccountResponse = new LinkUserAccountResponse();
        linkUserAccountResponse.setRequestId(dVar.e());
        linkUserAccountResponse.setRequestStatus(requestStatus);
        linkUserAccountResponse.setLink(link);
        linkUserAccountResponse.setSuccessCode(successCode);
        super.a(linkUserAccountResponse);
    }
}
