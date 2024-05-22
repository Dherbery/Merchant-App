package com.amazon.device.simplesignin.a.a.b;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.amazon.a.a.n.b.d;
import com.amazon.d.a.j;
import com.amazon.device.simplesignin.model.AccountLinkType;
import com.amazon.device.simplesignin.model.Link;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.request.LinkUserAccountRequest;
import com.amazon.device.simplesignin.model.response.LinkUserAccountResponse;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LinkUserAccountCommand.java */
/* loaded from: classes.dex */
public class b extends c {
    private static final String d = "SSI_LinkUserAccount";
    private static final String e = "1.0";
    private static final String f = "b";

    @com.amazon.a.a.k.a
    protected com.amazon.a.a.n.b b;

    @com.amazon.a.a.k.a
    protected com.amazon.a.a.a.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, LinkUserAccountRequest linkUserAccountRequest) {
        super(aVar, d, "1.0");
        super.a(com.amazon.device.simplesignin.a.a.a.d, linkUserAccountRequest.getPartnerUserId());
        super.a(com.amazon.device.simplesignin.a.a.a.a, linkUserAccountRequest.getIdentityProviderName());
        super.a(com.amazon.device.simplesignin.a.a.a.e, linkUserAccountRequest.getUserLoginName());
        super.a(com.amazon.device.simplesignin.a.a.a.h, linkUserAccountRequest.getAccountLinkType().toString());
        if (AccountLinkType.AMAZON_MANAGED.equals(linkUserAccountRequest.getAccountLinkType())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("token", linkUserAccountRequest.getLinkToken().getToken());
                jSONObject.put(com.amazon.device.simplesignin.a.a.a.A, linkUserAccountRequest.getLinkToken().getSchema());
                super.a(com.amazon.device.simplesignin.a.a.a.g, jSONObject.toString());
                super.a(com.amazon.device.simplesignin.a.a.a.f, linkUserAccountRequest.getLinkSigningKey());
            } catch (JSONException e2) {
                com.amazon.device.simplesignin.a.d.a.b(f, "Unable to create linkToken json " + e2);
                throw new IllegalStateException("Unable to create linkToken json", e2);
            }
        }
    }

    @Override // com.amazon.a.a.n.a.h
    protected boolean b(j jVar) throws RemoteException {
        Map b = jVar.b();
        if (b.containsKey(com.amazon.device.simplesignin.a.a.a.i) && b.get(com.amazon.device.simplesignin.a.a.a.i) != null) {
            a((Intent) b.get(com.amazon.device.simplesignin.a.a.a.i));
            return true;
        }
        if (b.containsKey(com.amazon.device.simplesignin.a.a.a.j) && b.get(com.amazon.device.simplesignin.a.a.a.j) != null) {
            String str = (String) b.get(com.amazon.device.simplesignin.a.a.a.j);
            String str2 = (String) b.get(com.amazon.device.simplesignin.a.a.a.k);
            Link a = com.amazon.device.simplesignin.a.d.b.a(str);
            if (a == null) {
                a(RequestStatus.FAILURE);
                return false;
            }
            super.a(RequestStatus.SUCCESSFUL, a, LinkUserAccountResponse.SuccessCode.valueOf(str2));
            return true;
        }
        super.a(RequestStatus.FAILURE);
        return false;
    }

    private void a(final Intent intent) {
        this.b.b(d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.device.simplesignin.a.a.b.b.1
            @Override // com.amazon.a.a.n.a
            public void a() {
                try {
                    Activity b = b.this.c.b();
                    if (b == null) {
                        b = b.this.c.a();
                    }
                    com.amazon.device.simplesignin.a.d.a.a(b.f, "Consent activity is about to start: " + b);
                    b.startActivity(intent);
                } catch (Exception e2) {
                    com.amazon.device.simplesignin.a.d.a.a(b.f, "Exception when starting consent activity: " + e2);
                }
            }
        });
    }
}
