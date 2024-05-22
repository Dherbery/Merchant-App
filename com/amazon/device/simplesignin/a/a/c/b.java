package com.amazon.device.simplesignin.a.a.c;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.amazon.d.a.j;
import com.amazon.device.simplesignin.a.a.c;
import com.amazon.device.simplesignin.a.a.d;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.response.ShowLoginSelectionResponse;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ShowLoginSelectionCommand.java */
/* loaded from: classes.dex */
public class b extends c {
    private static final String d = "a";
    private static final String e = "SSI_ShowLoginSelection";
    private static final String f = "1.0";

    @com.amazon.a.a.k.a
    protected com.amazon.a.a.n.b b;

    @com.amazon.a.a.k.a
    protected com.amazon.a.a.a.a c;
    private final Map<String, String> g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Map<String, String> map) {
        super(aVar, e, "1.0");
        this.g = map;
    }

    @Override // com.amazon.a.a.n.a.h
    protected boolean b(j jVar) throws RemoteException {
        Map b = jVar.b();
        if (!b.containsKey(com.amazon.device.simplesignin.a.a.a.n)) {
            a(RequestStatus.FAILURE);
            return false;
        }
        Intent intent = (Intent) b.get(com.amazon.device.simplesignin.a.a.a.n);
        if (intent == null) {
            a(RequestStatus.FAILURE);
            return false;
        }
        intent.putExtra(com.amazon.device.simplesignin.a.a.a.m, new HashMap(this.g));
        a(intent);
        return true;
    }

    @Override // com.amazon.device.simplesignin.a.a.c
    protected void a(RequestStatus requestStatus) {
        d dVar = (d) j();
        ShowLoginSelectionResponse showLoginSelectionResponse = new ShowLoginSelectionResponse();
        showLoginSelectionResponse.setRequestId(dVar.e());
        if (RequestStatus.INVALID_LINK_SIGNING_KEY_ENCRYPTION.equals(requestStatus) || RequestStatus.INVALID_LINK_SIGNING_KEY.equals(requestStatus)) {
            showLoginSelectionResponse.setRequestStatus(RequestStatus.FAILURE);
        } else {
            showLoginSelectionResponse.setRequestStatus(requestStatus);
            super.a(showLoginSelectionResponse);
        }
    }

    private void a(final Intent intent) {
        this.b.b(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.device.simplesignin.a.a.c.b.1
            @Override // com.amazon.a.a.n.a
            public void a() {
                try {
                    Activity b = b.this.c.b();
                    if (b == null) {
                        b = b.this.c.a();
                    }
                    com.amazon.device.simplesignin.a.d.a.a(b.d, "ShowLoginSelection activity initiated through startActivity");
                    b.startActivity(intent);
                } catch (Exception e2) {
                    com.amazon.device.simplesignin.a.d.a.a(b.d, "Exception when starting show login selection activity: " + e2);
                }
            }
        });
    }
}
