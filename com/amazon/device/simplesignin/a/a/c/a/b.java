package com.amazon.device.simplesignin.a.a.c.a;

import com.amazon.d.a.j;
import com.amazon.device.simplesignin.a.a.c;
import com.amazon.device.simplesignin.a.a.d;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.response.ShowLoginSelectionResponse;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginSelectionResponseCommand.java */
/* loaded from: classes.dex */
public class b extends c {
    private static final String b = "SSI_LoginSelectionResponse";
    private static final String c = "1.0";

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        super(aVar, b, "1.0");
    }

    @Override // com.amazon.a.a.n.a.h
    protected boolean b(j jVar) throws Exception {
        Map b2 = jVar.b();
        if (!b2.containsKey(com.amazon.device.simplesignin.a.a.a.o)) {
            a(RequestStatus.FAILURE);
            return false;
        }
        String str = (String) b2.get(com.amazon.device.simplesignin.a.a.a.o);
        if (str == null) {
            a(RequestStatus.FAILURE);
            return false;
        }
        String str2 = (String) b2.get(com.amazon.device.simplesignin.a.a.a.p);
        if (ShowLoginSelectionResponse.UserSelection.LoginSelected.name().equals(str) && str2 != null) {
            a(RequestStatus.SUCCESSFUL, str2, ShowLoginSelectionResponse.UserSelection.LoginSelected);
            return true;
        }
        a(RequestStatus.SUCCESSFUL, null, ShowLoginSelectionResponse.UserSelection.ManualSignIn);
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

    private void a(RequestStatus requestStatus, String str, ShowLoginSelectionResponse.UserSelection userSelection) {
        d dVar = (d) j();
        ShowLoginSelectionResponse showLoginSelectionResponse = new ShowLoginSelectionResponse();
        showLoginSelectionResponse.setRequestId(dVar.e());
        showLoginSelectionResponse.setRequestStatus(requestStatus);
        showLoginSelectionResponse.setUserSelection(userSelection);
        showLoginSelectionResponse.setLinkId(str);
        super.a(showLoginSelectionResponse);
    }
}
