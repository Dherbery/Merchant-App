package com.revenuecat.purchases.amazon.purchasing;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.core.content.ContextCompat;
import com.amazon.device.iap.model.RequestId;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.amazon.AmazonStrings;
import com.revenuecat.purchases.amazon.PurchasingServiceProvider;
import com.revenuecat.purchases.common.LogUtilsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: ProxyAmazonBillingDelegate.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\b\u0017R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/amazon/purchasing/ProxyAmazonBillingDelegate;", "", "()V", "broadcastReceiver", "Lcom/revenuecat/purchases/amazon/purchasing/ProxyAmazonBillingActivityBroadcastReceiver;", "getBroadcastReceiver$purchases_defaultsRelease$annotations", "getBroadcastReceiver$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/amazon/purchasing/ProxyAmazonBillingActivityBroadcastReceiver;", "setBroadcastReceiver$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/amazon/purchasing/ProxyAmazonBillingActivityBroadcastReceiver;)V", "filter", "Landroid/content/IntentFilter;", "onCreate", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "startAmazonPurchase", "Lcom/amazon/device/iap/model/RequestId;", "intent", "Landroid/content/Intent;", "startAmazonPurchase$purchases_defaultsRelease", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ProxyAmazonBillingDelegate {
    private /* synthetic */ ProxyAmazonBillingActivityBroadcastReceiver broadcastReceiver;
    private final IntentFilter filter = ProxyAmazonBillingActivityBroadcastReceiver.INSTANCE.newPurchaseFinishedIntentFilter();

    public static /* synthetic */ void getBroadcastReceiver$purchases_defaultsRelease$annotations() {
    }

    /* renamed from: getBroadcastReceiver$purchases_defaultsRelease, reason: from getter */
    public final ProxyAmazonBillingActivityBroadcastReceiver getBroadcastReceiver() {
        return this.broadcastReceiver;
    }

    public final void setBroadcastReceiver$purchases_defaultsRelease(ProxyAmazonBillingActivityBroadcastReceiver proxyAmazonBillingActivityBroadcastReceiver) {
        this.broadcastReceiver = proxyAmazonBillingActivityBroadcastReceiver;
    }

    public final void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ProxyAmazonBillingActivityBroadcastReceiver proxyAmazonBillingActivityBroadcastReceiver = new ProxyAmazonBillingActivityBroadcastReceiver(activity);
        this.broadcastReceiver = proxyAmazonBillingActivityBroadcastReceiver;
        ContextCompat.registerReceiver(activity, proxyAmazonBillingActivityBroadcastReceiver, this.filter, 2);
        if (savedInstanceState == null) {
            Intent intent = activity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
            if (startAmazonPurchase$purchases_defaultsRelease(intent) == null) {
                activity.finish();
            }
        }
    }

    public final void onDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.unregisterReceiver(this.broadcastReceiver);
        this.broadcastReceiver = null;
    }

    public final RequestId startAmazonPurchase$purchases_defaultsRelease(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra("sku");
        ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra(ProxyAmazonBillingActivity.EXTRAS_RESULT_RECEIVER);
        PurchasingServiceProvider purchasingServiceProvider = (PurchasingServiceProvider) intent.getParcelableExtra(ProxyAmazonBillingActivity.EXTRAS_PURCHASING_SERVICE_PROVIDER);
        if (stringExtra == null || resultReceiver == null || purchasingServiceProvider == null) {
            PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.PurchaseInvalidError;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(AmazonStrings.ERROR_PURCHASE_INVALID_PROXY_ACTIVITY_ARGUMENTS, Arrays.copyOf(new Object[]{intent.toUri(0)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            LogUtilsKt.errorLog(new PurchasesError(purchasesErrorCode, format));
            return null;
        }
        RequestId purchase = purchasingServiceProvider.purchase(stringExtra);
        Bundle bundle = new Bundle();
        bundle.putParcelable(ProxyAmazonBillingActivity.EXTRAS_REQUEST_ID, purchase);
        resultReceiver.send(0, bundle);
        return purchase;
    }
}
