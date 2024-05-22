package com.amazon.device.simplesignin.a;

import android.content.Context;
import android.content.Intent;
import com.amazon.device.simplesignin.model.RequestId;
import com.amazon.device.simplesignin.model.request.LinkUserAccountRequest;
import java.util.Map;

/* compiled from: ISimpleSignInRequestHandler.java */
/* loaded from: classes.dex */
public interface b {
    void a(Context context, Intent intent);

    void a(RequestId requestId, LinkUserAccountRequest linkUserAccountRequest);

    void a(RequestId requestId, String str);

    void a(RequestId requestId, Map<String, String> map);

    void b(RequestId requestId, String str);
}
