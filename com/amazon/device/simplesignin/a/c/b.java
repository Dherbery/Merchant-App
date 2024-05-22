package com.amazon.device.simplesignin.a.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.amazon.device.simplesignin.ISimpleSignInResponseHandler;
import com.amazon.device.simplesignin.a.c;
import com.amazon.device.simplesignin.model.AccountLinkType;
import com.amazon.device.simplesignin.model.RequestId;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.request.LinkUserAccountRequest;
import com.amazon.device.simplesignin.model.response.GetUserAndLinksResponse;
import com.amazon.device.simplesignin.model.response.LinkUserAccountResponse;
import com.amazon.device.simplesignin.model.response.ShowLoginSelectionResponse;
import com.amazon.device.simplesignin.model.response.UnlinkUserAccountResponse;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SandboxRequestHandler.java */
/* loaded from: classes.dex */
public class b implements com.amazon.device.simplesignin.a.b {
    private static final String a = "b";
    private static final String b = "com.amazon.sdktestclient";
    private static final String c = "com.amazon.sdktestclient.command.CommandBroker";

    @Override // com.amazon.device.simplesignin.a.b
    public void a(RequestId requestId, String str) {
        Log.i(a, "Handling getUserAndLinks sandbox request.");
        Context c2 = c.a().c();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.B, requestId);
            jSONObject.put("packageName", c2.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.I, "1.0.0");
            jSONObject.put(com.amazon.device.simplesignin.a.a.a.a, str);
            Bundle bundle = new Bundle();
            bundle.putString("getUserAndLinksInput", jSONObject.toString());
            Intent a2 = a("com.amazon.testclient.simplesignin.getUserAndLinks");
            a2.addFlags(268435456);
            a2.putExtras(bundle);
            c2.startService(a2);
        } catch (JSONException unused) {
            Log.e(a, "Error in preparing getUserAndLinksInput.");
        }
    }

    @Override // com.amazon.device.simplesignin.a.b
    public void a(RequestId requestId, LinkUserAccountRequest linkUserAccountRequest) {
        Log.i(a, "Handling linkUserAccount sandbox request.");
        Context c2 = c.a().c();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.B, requestId);
            jSONObject.put("packageName", c2.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.I, "1.0.0");
            jSONObject.put(com.amazon.device.simplesignin.a.a.a.d, linkUserAccountRequest.getPartnerUserId());
            jSONObject.put(com.amazon.device.simplesignin.a.a.a.a, linkUserAccountRequest.getIdentityProviderName());
            jSONObject.put(com.amazon.device.simplesignin.a.a.a.e, linkUserAccountRequest.getUserLoginName());
            jSONObject.put(com.amazon.device.simplesignin.a.a.a.h, linkUserAccountRequest.getAccountLinkType());
            if (AccountLinkType.AMAZON_MANAGED.equals(linkUserAccountRequest.getAccountLinkType())) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("token", linkUserAccountRequest.getLinkToken().getToken());
                jSONObject2.put(com.amazon.device.simplesignin.a.a.a.A, linkUserAccountRequest.getLinkToken().getSchema());
                jSONObject.put(com.amazon.device.simplesignin.a.a.a.g, jSONObject2.toString());
                jSONObject.put(com.amazon.device.simplesignin.a.a.a.f, linkUserAccountRequest.getLinkSigningKey());
            }
            Bundle bundle = new Bundle();
            bundle.putString("linkUserAccountInput", jSONObject.toString());
            Intent a2 = a("com.amazon.testclient.simplesignin.linkUserAccount");
            a2.addFlags(268435456);
            a2.putExtras(bundle);
            c2.startService(a2);
        } catch (JSONException e) {
            Log.e(a, "Unable to create linkToken json");
            throw new IllegalStateException("Unable to create linkToken json", e);
        }
    }

    @Override // com.amazon.device.simplesignin.a.b
    public void a(RequestId requestId, Map<String, String> map) {
        Log.i(a, "Handling showLoginSelection sandbox request.");
        Context c2 = c.a().c();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.B, requestId);
            jSONObject.put("packageName", c2.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.I, "1.0.0");
            Intent a2 = a("com.amazon.testclient.simplesignin.showLoginSelection");
            a2.putExtra("showLoginSelectionInput", jSONObject.toString());
            a2.putExtra(com.amazon.device.simplesignin.a.a.a.m, new HashMap(map));
            a2.addFlags(268435456);
            c2.startService(a2);
        } catch (JSONException e) {
            Log.e(a, "Unable to create showLoginSelection Input");
            throw new IllegalStateException("Unable to create showLoginSelection input json", e);
        }
    }

    @Override // com.amazon.device.simplesignin.a.b
    public void b(RequestId requestId, String str) {
        Log.i(a, "Handling unlinkUserAccount sandbox request.");
        Context c2 = c.a().c();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.B, requestId);
            jSONObject.put("packageName", c2.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.I, "1.0.0");
            jSONObject.put(com.amazon.device.simplesignin.a.a.a.a, str);
            Bundle bundle = new Bundle();
            bundle.putString("unlinkUserAccountInput", jSONObject.toString());
            Intent a2 = a("com.amazon.testclient.simplesignin.unlinkUserAccount");
            a2.addFlags(268435456);
            a2.putExtras(bundle);
            c2.startService(a2);
        } catch (JSONException e) {
            Log.e(a, "Error in preparing unlinkUserAccount.", e);
        }
    }

    @Override // com.amazon.device.simplesignin.a.b
    public void a(Context context, Intent intent) {
        intent.setComponent(new ComponentName(b, c));
        try {
            String string = intent.getExtras().getString("responseType");
            if ("com.amazon.testclient.simplesignin.getUserAndLinks".equals(string)) {
                a(a(intent));
            } else if ("com.amazon.testclient.simplesignin.linkUserAccount".equals(string)) {
                a(b(intent));
            } else if ("com.amazon.testclient.simplesignin.showLoginSelection".equals(string)) {
                a(c(intent));
            } else if ("com.amazon.testclient.simplesignin.unlinkUserAccount".equals(string)) {
                a(d(intent));
            } else {
                Log.d(a, "Unknown response type received.");
            }
        } catch (Exception e) {
            Log.e(a, "Error handling response.", e);
        }
    }

    private GetUserAndLinksResponse a(Intent intent) {
        JSONObject jSONObject;
        RequestStatus valueOf;
        GetUserAndLinksResponse getUserAndLinksResponse = new GetUserAndLinksResponse();
        try {
            jSONObject = new JSONObject(intent.getStringExtra("getUserAndLinksOutput"));
            getUserAndLinksResponse.setRequestId(new RequestId(jSONObject.getString(com.amazon.a.a.o.b.B)));
            valueOf = RequestStatus.valueOf(jSONObject.getString("status"));
            getUserAndLinksResponse.setRequestStatus(valueOf);
        } catch (JSONException e) {
            Log.e(a, "Exception while parsing GetUserAndLinks response", e);
        }
        if (!RequestStatus.SUCCESSFUL.equals(valueOf)) {
            return getUserAndLinksResponse;
        }
        String string = jSONObject.getString(com.amazon.device.simplesignin.a.a.a.b);
        getUserAndLinksResponse.setAmazonUserId(string);
        getUserAndLinksResponse.setLinks(com.amazon.device.simplesignin.a.d.b.a(string, jSONObject.getString(com.amazon.device.simplesignin.a.a.a.c)));
        return getUserAndLinksResponse;
    }

    private LinkUserAccountResponse b(Intent intent) {
        JSONObject jSONObject;
        RequestStatus valueOf;
        LinkUserAccountResponse linkUserAccountResponse = new LinkUserAccountResponse();
        try {
            String stringExtra = intent.getStringExtra("linkUserAccountOutput");
            Log.i(a, "SimpleSignInService : linkUserAccountOutput " + stringExtra);
            jSONObject = new JSONObject(stringExtra);
            linkUserAccountResponse.setRequestId(new RequestId(jSONObject.getString(com.amazon.a.a.o.b.B)));
            valueOf = RequestStatus.valueOf(jSONObject.getString("status"));
            linkUserAccountResponse.setRequestStatus(valueOf);
        } catch (JSONException e) {
            Log.e(a, "Exception while parsing LinkUserAccount response", e);
        }
        if (!RequestStatus.SUCCESSFUL.equals(valueOf)) {
            return linkUserAccountResponse;
        }
        String string = jSONObject.getString(com.amazon.device.simplesignin.a.a.a.k);
        if (!LinkUserAccountResponse.SuccessCode.ConsentDenied.equals(LinkUserAccountResponse.SuccessCode.valueOf(string))) {
            linkUserAccountResponse.setLink(com.amazon.device.simplesignin.a.d.b.a(jSONObject.getString(com.amazon.device.simplesignin.a.a.a.j)));
        }
        linkUserAccountResponse.setSuccessCode(LinkUserAccountResponse.SuccessCode.valueOf(string));
        return linkUserAccountResponse;
    }

    private ShowLoginSelectionResponse c(Intent intent) {
        JSONObject jSONObject;
        RequestStatus valueOf;
        ShowLoginSelectionResponse showLoginSelectionResponse = new ShowLoginSelectionResponse();
        try {
            String stringExtra = intent.getStringExtra("showLoginSelectionOutput");
            Log.i(a, "SimpleSignInService : loginSelectionOutput " + stringExtra);
            jSONObject = new JSONObject(stringExtra);
            showLoginSelectionResponse.setRequestId(new RequestId(jSONObject.getString(com.amazon.a.a.o.b.B)));
            valueOf = RequestStatus.valueOf(jSONObject.getString("status"));
            showLoginSelectionResponse.setRequestStatus(valueOf);
        } catch (JSONException e) {
            Log.e(a, "Exception while parsing LinkUserAccount response", e);
            showLoginSelectionResponse.setUserSelection(ShowLoginSelectionResponse.UserSelection.ManualSignIn);
        }
        if (!RequestStatus.SUCCESSFUL.equals(valueOf)) {
            return showLoginSelectionResponse;
        }
        if (!ShowLoginSelectionResponse.UserSelection.LoginSelected.name().equals(jSONObject.getString(com.amazon.device.simplesignin.a.a.a.o))) {
            showLoginSelectionResponse.setUserSelection(ShowLoginSelectionResponse.UserSelection.ManualSignIn);
            return showLoginSelectionResponse;
        }
        String string = jSONObject.getString(com.amazon.device.simplesignin.a.a.a.p);
        if (string != null) {
            showLoginSelectionResponse.setUserSelection(ShowLoginSelectionResponse.UserSelection.LoginSelected);
            showLoginSelectionResponse.setLinkId(string);
        }
        return showLoginSelectionResponse;
    }

    private UnlinkUserAccountResponse d(Intent intent) {
        UnlinkUserAccountResponse unlinkUserAccountResponse = new UnlinkUserAccountResponse();
        try {
            String stringExtra = intent.getStringExtra("unlinkUserAccountOutput");
            Log.i(a, "SimpleSignInService : unlinkUserAccountOutput " + stringExtra);
            JSONObject jSONObject = new JSONObject(stringExtra);
            unlinkUserAccountResponse.setRequestId(new RequestId(jSONObject.getString(com.amazon.a.a.o.b.B)));
            RequestStatus valueOf = RequestStatus.valueOf(jSONObject.getString("status"));
            unlinkUserAccountResponse.setRequestStatus(valueOf);
            RequestStatus.SUCCESSFUL.equals(valueOf);
            return unlinkUserAccountResponse;
        } catch (JSONException e) {
            Log.e(a, "Exception while parsing UnlinkUserAccount response", e);
            return unlinkUserAccountResponse;
        }
    }

    private Intent a(String str) {
        Intent intent = new Intent(str);
        intent.setComponent(new ComponentName(b, c));
        return intent;
    }

    private void a(final Object obj) {
        Context c2 = c.a().c();
        final ISimpleSignInResponseHandler d = c.a().d();
        if (c2 == null || obj == null) {
            Log.i(a, "ISimpleSignInResponseHandler is not set. Dropping response: " + obj);
            return;
        }
        new Handler(c2.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.simplesignin.a.c.b.1
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
                        Log.e(b.a, "Unknown response type:" + obj.getClass().getName());
                    } else {
                        d.onUnlinkUserAccountResponse((UnlinkUserAccountResponse) obj2);
                    }
                } catch (Exception e) {
                    Log.e(b.a, "Error in sendResponse: " + e);
                }
            }
        });
    }
}
