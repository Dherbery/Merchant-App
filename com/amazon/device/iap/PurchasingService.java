package com.amazon.device.iap;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.amazon.a.a;
import com.amazon.device.iap.internal.d;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.RequestId;
import java.util.Set;

/* loaded from: classes.dex */
public final class PurchasingService extends Service {
    private static final String APPSTORE_SDK_NAME = "Amazon In-App Purchasing Android SDK :2.10.1.0";
    public static final String SDK_VERSION = "2.10.1.0";
    private static final String TAG = "PurchasingService";
    private final IBinder localBinder = new LocalBinder();

    public PurchasingService() {
        Log.i(TAG, "Amazon In-App Purchasing Android SDK initializing. SDK Version 2.10.1.0. ");
    }

    /* loaded from: classes.dex */
    private class LocalBinder extends Binder {
        private LocalBinder() {
        }

        public PurchasingService getService() {
            return PurchasingService.this;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.localBinder;
    }

    public static void registerListener(Context context, PurchasingListener purchasingListener) {
        a.a(context);
        d.e().a(context, purchasingListener);
    }

    public static RequestId getUserData() {
        return d.e().d();
    }

    public static RequestId purchase(String str) {
        return d.e().a(str);
    }

    public static RequestId getProductData(Set<String> set) {
        return d.e().a(set);
    }

    public static RequestId getPurchaseUpdates(boolean z) {
        return d.e().a(z);
    }

    public static void notifyFulfillment(String str, FulfillmentResult fulfillmentResult) {
        d.e().a(str, fulfillmentResult);
    }
}
