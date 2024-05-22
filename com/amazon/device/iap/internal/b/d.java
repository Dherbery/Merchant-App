package com.amazon.device.iap.internal.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.amazon.a.a.o.f;
import com.amazon.device.iap.model.Receipt;
import com.revenuecat.purchases.common.Constants;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PendingReceiptsManager.java */
/* loaded from: classes.dex */
public class d {
    private static final String a = "d";
    private static final String d = "LAST_CLEANING_TIME";
    private static final String b = d.class.getName() + "_PREFS";
    private static final String c = d.class.getName() + "_CLEANER_PREFS";
    private static int e = 604800000;
    private static final d f = new d();

    public void a(String str, String str2, String str3, String str4) {
        com.amazon.device.iap.internal.util.b.a(a, "enter saveReceipt for receipt [" + str4 + "]");
        try {
            f.a(str2, "userId");
            f.a(str3, com.amazon.a.a.o.b.E);
            f.a(str4, "receiptString");
            Context b2 = com.amazon.device.iap.internal.d.e().b();
            f.a(b2, "context");
            c cVar = new c(str2, str4, str, System.currentTimeMillis());
            SharedPreferences.Editor edit = b2.getSharedPreferences(b, 0).edit();
            edit.putString(str3, cVar.e());
            edit.commit();
        } catch (Throwable th) {
            com.amazon.device.iap.internal.util.b.a(a, "error in saving pending receipt:" + str + "/" + str4 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + th.getMessage());
        }
        com.amazon.device.iap.internal.util.b.a(a, "leaving saveReceipt for receipt id [" + str3 + "]");
    }

    private void e() {
        com.amazon.device.iap.internal.util.b.a(a, "enter old receipts cleanup! ");
        final Context b2 = com.amazon.device.iap.internal.d.e().b();
        f.a(b2, "context");
        a(System.currentTimeMillis());
        new Handler().post(new Runnable() { // from class: com.amazon.device.iap.internal.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.amazon.device.iap.internal.util.b.a(d.a, "perform house keeping! ");
                    SharedPreferences sharedPreferences = b2.getSharedPreferences(d.b, 0);
                    for (String str : sharedPreferences.getAll().keySet()) {
                        try {
                            if (System.currentTimeMillis() - c.a(sharedPreferences.getString(str, null)).d() > d.e) {
                                com.amazon.device.iap.internal.util.b.a(d.a, "house keeping - try remove Receipt:" + str + " since it's too old");
                                d.this.a(str);
                            }
                        } catch (b unused) {
                            com.amazon.device.iap.internal.util.b.a(d.a, "house keeping - try remove Receipt:" + str + " since it's invalid ");
                            d.this.a(str);
                        }
                    }
                } catch (Throwable th) {
                    com.amazon.device.iap.internal.util.b.a(d.a, "Error in running cleaning job:" + th);
                }
            }
        });
    }

    public void a(String str) {
        String str2 = a;
        com.amazon.device.iap.internal.util.b.a(str2, "enter removeReceipt for receipt[" + str + "]");
        Context b2 = com.amazon.device.iap.internal.d.e().b();
        f.a(b2, "context");
        SharedPreferences.Editor edit = b2.getSharedPreferences(b, 0).edit();
        edit.remove(str);
        edit.commit();
        com.amazon.device.iap.internal.util.b.a(str2, "leave removeReceipt for receipt[" + str + "]");
    }

    private long f() {
        Context b2 = com.amazon.device.iap.internal.d.e().b();
        f.a(b2, "context");
        long currentTimeMillis = System.currentTimeMillis();
        long j = b2.getSharedPreferences(c, 0).getLong(d, 0L);
        if (j != 0) {
            return j;
        }
        a(currentTimeMillis);
        return currentTimeMillis;
    }

    private void a(long j) {
        Context b2 = com.amazon.device.iap.internal.d.e().b();
        f.a(b2, "context");
        SharedPreferences.Editor edit = b2.getSharedPreferences(c, 0).edit();
        edit.putLong(d, j);
        edit.commit();
    }

    public Set<Receipt> b(String str) {
        Context b2 = com.amazon.device.iap.internal.d.e().b();
        f.a(b2, "context");
        String str2 = a;
        com.amazon.device.iap.internal.util.b.a(str2, "enter getLocalReceipts for user[" + str + "]");
        HashSet hashSet = new HashSet();
        if (f.a(str)) {
            com.amazon.device.iap.internal.util.b.b(str2, "empty UserId: " + str);
            throw new RuntimeException("Invalid UserId:" + str);
        }
        Map<String, ?> all = b2.getSharedPreferences(b, 0).getAll();
        for (String str3 : all.keySet()) {
            String str4 = (String) all.get(str3);
            try {
                c a2 = c.a(str4);
                hashSet.add(com.amazon.device.iap.internal.util.c.a(new JSONObject(a2.c()), str, a2.b()));
            } catch (com.amazon.device.iap.internal.a.f unused) {
                a(str3);
                com.amazon.device.iap.internal.util.b.b(a, "failed to verify signature:[" + str4 + "]");
            } catch (JSONException unused2) {
                a(str3);
                com.amazon.device.iap.internal.util.b.b(a, "failed to convert string to JSON object:[" + str4 + "]");
            } catch (Throwable unused3) {
                com.amazon.device.iap.internal.util.b.b(a, "failed to load the receipt from SharedPreference:[" + str4 + "]");
            }
        }
        com.amazon.device.iap.internal.util.b.a(a, "leaving getLocalReceipts for user[" + str + "], " + hashSet.size() + " local receipts found.");
        if (System.currentTimeMillis() - f() > e) {
            e();
        }
        return hashSet;
    }

    public static d a() {
        return f;
    }

    public String c(String str) {
        Context b2 = com.amazon.device.iap.internal.d.e().b();
        f.a(b2, "context");
        if (f.a(str)) {
            com.amazon.device.iap.internal.util.b.b(a, "empty receiptId: " + str);
            throw new RuntimeException("Invalid ReceiptId:" + str);
        }
        String string = b2.getSharedPreferences(b, 0).getString(str, null);
        if (string != null) {
            try {
                return c.a(string).b();
            } catch (b unused) {
            }
        }
        return null;
    }
}
