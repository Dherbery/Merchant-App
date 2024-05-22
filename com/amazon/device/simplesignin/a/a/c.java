package com.amazon.device.simplesignin.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import com.amazon.a.a.n.a.h;
import com.amazon.device.simplesignin.ISimpleSignInResponseHandler;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.response.GetUserAndLinksResponse;
import com.amazon.device.simplesignin.model.response.LinkUserAccountResponse;
import com.amazon.device.simplesignin.model.response.ShowLoginSelectionResponse;
import com.amazon.device.simplesignin.model.response.UnlinkUserAccountResponse;

/* compiled from: SSIKiwiCommandBase.java */
/* loaded from: classes.dex */
public abstract class c extends h {
    private static final String b = "c";

    protected abstract void a(RequestStatus requestStatus);

    public c(d dVar, String str, String str2) {
        super(dVar, str, str2, dVar.e().toString(), "1.0.0");
        super.b(false);
    }

    @Override // com.amazon.a.a.n.a.h
    public void b(com.amazon.d.a.h hVar) {
        String g;
        try {
            g = hVar.g();
        } catch (RemoteException unused) {
            com.amazon.device.simplesignin.a.d.a.b(b, "Exception while fetching reason for failure");
        }
        if (a.B.equals(g)) {
            a(RequestStatus.NOT_SUPPORTED);
            return;
        }
        if (a.E.equals(g)) {
            a(RequestStatus.NOT_AVAILABLE);
            return;
        }
        if (a.C.equals(g)) {
            a(RequestStatus.DUPLICATE_REQUEST);
            return;
        }
        if (a.D.equals(g)) {
            a(RequestStatus.FEATURE_TURNED_OFF);
            return;
        }
        if (a.F.equals(g)) {
            a(RequestStatus.RETRYABLE_FAILURE);
            return;
        }
        if (a.G.equals(g)) {
            a(RequestStatus.INVALID_LINK_SIGNING_KEY_ENCRYPTION);
            return;
        }
        if (a.H.equals(g)) {
            a(RequestStatus.INVALID_LINK_SIGNING_KEY);
            return;
        }
        a(RequestStatus.FAILURE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final Object obj) {
        if (obj == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        String str = b;
        com.amazon.device.simplesignin.a.d.a.a(str, "Response type received: " + obj.getClass().getSimpleName());
        Context c = com.amazon.device.simplesignin.a.c.a().c();
        final ISimpleSignInResponseHandler d = com.amazon.device.simplesignin.a.c.a().d();
        if (c == null || d == null) {
            com.amazon.device.simplesignin.a.d.a.a(str, "Dropping the response as context of response handler is null.");
        } else {
            new Handler(c.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.simplesignin.a.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Object obj2 = obj;
                        if (obj2 instanceof GetUserAndLinksResponse) {
                            d.onGetUserAndLinksResponse((GetUserAndLinksResponse) obj2);
                        } else if (obj2 instanceof LinkUserAccountResponse) {
                            d.onLinkUserAccountResponse((LinkUserAccountResponse) obj2);
                        } else if (obj2 instanceof ShowLoginSelectionResponse) {
                            d.onShowLoginSelectionResponse((ShowLoginSelectionResponse) obj2);
                        } else if (!(obj2 instanceof UnlinkUserAccountResponse)) {
                            com.amazon.device.simplesignin.a.d.a.b(c.b, "Unknown response type:" + obj.getClass().getName());
                        } else {
                            d.onUnlinkUserAccountResponse((UnlinkUserAccountResponse) obj2);
                        }
                    } catch (Exception e) {
                        com.amazon.device.simplesignin.a.d.a.b(c.b, "Error in sending response to callback: " + e);
                    }
                }
            });
        }
    }
}
