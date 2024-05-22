package com.amazon.device.simplesignin.a.a;

import android.content.Context;
import android.content.Intent;
import com.amazon.device.simplesignin.model.RequestId;
import com.amazon.device.simplesignin.model.request.LinkUserAccountRequest;
import java.util.Map;

/* compiled from: KiwiRequestHandler.java */
/* loaded from: classes.dex */
public class b implements com.amazon.device.simplesignin.a.b {
    private static final String a = "b";

    @Override // com.amazon.device.simplesignin.a.b
    public void a(RequestId requestId, String str) {
        new com.amazon.device.simplesignin.a.a.a.a(requestId, str).d();
    }

    @Override // com.amazon.device.simplesignin.a.b
    public void a(RequestId requestId, LinkUserAccountRequest linkUserAccountRequest) {
        new com.amazon.device.simplesignin.a.a.b.a(requestId, linkUserAccountRequest).d();
    }

    @Override // com.amazon.device.simplesignin.a.b
    public void a(RequestId requestId, Map<String, String> map) {
        new com.amazon.device.simplesignin.a.a.c.a(requestId, map).d();
    }

    @Override // com.amazon.device.simplesignin.a.b
    public void b(RequestId requestId, String str) {
        new com.amazon.device.simplesignin.a.a.d.a(requestId, str).d();
    }

    @Override // com.amazon.device.simplesignin.a.b
    public void a(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(a.l);
        if (stringExtra == null) {
            com.amazon.device.simplesignin.a.d.a.b(a, "Invalid response type: null");
            return;
        }
        com.amazon.device.simplesignin.a.d.a.a(a, "Found response type: " + stringExtra);
        if (a.r.equals(stringExtra)) {
            new com.amazon.device.simplesignin.a.a.b.a.b(new RequestId(intent.getStringExtra(com.amazon.a.a.o.b.B))).d();
        }
        if (a.s.equals(stringExtra)) {
            new com.amazon.device.simplesignin.a.a.c.a.a(new RequestId(intent.getStringExtra(com.amazon.a.a.o.b.B))).d();
        }
    }
}
