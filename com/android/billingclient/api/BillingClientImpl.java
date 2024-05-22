package com.android.billingclient.api;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.BundleCompat;
import com.android.billingclient.BuildConfig;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzhy;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzic;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzii;
import com.google.android.gms.internal.play_billing.zzin;
import com.google.android.gms.internal.play_billing.zzio;
import com.google.android.gms.internal.play_billing.zziq;
import com.google.android.gms.internal.play_billing.zzis;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes.dex */
public class BillingClientImpl extends BillingClient {
    private ExecutorService zzA;
    private volatile int zza;
    private final String zzb;
    private final Handler zzc;
    private volatile zzh zzd;
    private Context zze;
    private zzbi zzf;
    private volatile com.google.android.gms.internal.play_billing.zzm zzg;
    private volatile zzao zzh;
    private boolean zzi;
    private boolean zzj;
    private int zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private zzbx zzy;
    private boolean zzz;

    private BillingClientImpl(Activity activity, zzbx zzbxVar, String str) {
        this(activity.getApplicationContext(), zzbxVar, new zzba(), str, null, null, null, null);
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzbx zzbxVar, AlternativeBillingListener alternativeBillingListener, String str, zzbi zzbiVar) {
        this.zze = context.getApplicationContext();
        zzin zzv = zzio.zzv();
        zzv.zzj(str);
        zzv.zzi(this.zze.getPackageName());
        if (zzbiVar != null) {
            this.zzf = zzbiVar;
        } else {
            this.zzf = new zzbn(this.zze, (zzio) zzv.zzc());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzd = new zzh(this.zze, purchasesUpdatedListener, alternativeBillingListener, this.zzf);
        this.zzy = zzbxVar;
        this.zzz = alternativeBillingListener != null;
        this.zze.getPackageName();
    }

    private int launchBillingFlowCpp(Activity activity, BillingFlowParams billingFlowParams) {
        return launchBillingFlow(activity, billingFlowParams).getResponseCode();
    }

    private void startConnection(long j) {
        zzba zzbaVar = new zzba(j);
        if (isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Service connection is valid. No need to re-initialize.");
            this.zzf.zzb(zzbh.zzb(6));
            zzbaVar.onBillingSetupFinished(zzbk.zzl);
            return;
        }
        int i = 1;
        if (this.zza == 1) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Client is already in the process of connecting to billing service.");
            this.zzf.zza(zzbh.zza(37, 6, zzbk.zzd));
            zzbaVar.onBillingSetupFinished(zzbk.zzd);
            return;
        }
        if (this.zza == 3) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            this.zzf.zza(zzbh.zza(38, 6, zzbk.zzm));
            zzbaVar.onBillingSetupFinished(zzbk.zzm);
            return;
        }
        this.zza = 1;
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Starting in-app billing setup.");
        this.zzh = new zzao(this, zzbaVar, null);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> queryIntentServices = this.zze.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            i = 41;
        } else {
            ResolveInfo resolveInfo = queryIntentServices.get(0);
            if (resolveInfo.serviceInfo != null) {
                String str = resolveInfo.serviceInfo.packageName;
                String str2 = resolveInfo.serviceInfo.name;
                if (!"com.android.vending".equals(str) || str2 == null) {
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "The device doesn't have valid Play Store.");
                    i = 40;
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.zzb);
                    if (this.zze.bindService(intent2, this.zzh, 1)) {
                        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Service was bonded successfully.");
                        return;
                    } else {
                        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Connection to Billing service is blocked.");
                        i = 39;
                    }
                }
            }
        }
        this.zza = 0;
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Billing service unavailable on device.");
        this.zzf.zza(zzbh.zza(i, 6, zzbk.zzc));
        zzbaVar.onBillingSetupFinished(zzbk.zzc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzce zzX(BillingClientImpl billingClientImpl, String str, int i) {
        Bundle zzi;
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        int i2 = 0;
        Bundle zzd = com.google.android.gms.internal.play_billing.zzb.zzd(billingClientImpl.zzn, billingClientImpl.zzv, true, false, billingClientImpl.zzb);
        List list = null;
        String str2 = null;
        while (true) {
            try {
                if (billingClientImpl.zzn) {
                    zzi = billingClientImpl.zzg.zzj(z != billingClientImpl.zzv ? 9 : 19, billingClientImpl.zze.getPackageName(), str, str2, zzd);
                } else {
                    zzi = billingClientImpl.zzg.zzi(3, billingClientImpl.zze.getPackageName(), str, str2);
                }
                zzcf zza = zzcg.zza(zzi, "BillingClient", "getPurchase()");
                BillingResult zza2 = zza.zza();
                if (zza2 == zzbk.zzl) {
                    ArrayList<String> stringArrayList = zzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                    ArrayList<String> stringArrayList2 = zzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                    ArrayList<String> stringArrayList3 = zzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                    int i3 = i2;
                    int i4 = i3;
                    while (i3 < stringArrayList2.size()) {
                        String str3 = stringArrayList2.get(i3);
                        String str4 = stringArrayList3.get(i3);
                        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i3))));
                        try {
                            Purchase purchase = new Purchase(str3, str4);
                            if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                                com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "BUG: empty/null token!");
                                i4 = 1;
                            }
                            arrayList.add(purchase);
                            i3++;
                        } catch (JSONException e) {
                            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Got an exception trying to decode the purchase!", e);
                            billingClientImpl.zzf.zza(zzbh.zza(51, 9, zzbk.zzj));
                            return new zzce(zzbk.zzj, null);
                        }
                    }
                    if (i4 != 0) {
                        billingClientImpl.zzf.zza(zzbh.zza(26, 9, zzbk.zzj));
                    }
                    str2 = zzi.getString("INAPP_CONTINUATION_TOKEN");
                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Continuation token: ".concat(String.valueOf(str2)));
                    if (TextUtils.isEmpty(str2)) {
                        return new zzce(zzbk.zzl, arrayList);
                    }
                    list = null;
                    z = true;
                    i2 = 0;
                } else {
                    billingClientImpl.zzf.zza(zzbh.zza(zza.zzb(), 9, zza2));
                    return new zzce(zza2, list);
                }
            } catch (Exception e2) {
                billingClientImpl.zzf.zza(zzbh.zza(52, 9, zzbk.zzm));
                com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Got exception trying to get purchasesm try to reconnect", e2);
                return new zzce(zzbk.zzm, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler zzY() {
        return Looper.myLooper() == null ? this.zzc : new Handler(Looper.myLooper());
    }

    private final BillingResult zzZ(final BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.zzc.post(new Runnable() { // from class: com.android.billingclient.api.zzj
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzN(billingResult);
            }
        });
        return billingResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingResult zzaa() {
        if (this.zza == 0 || this.zza == 3) {
            return zzbk.zzm;
        }
        return zzbk.zzj;
    }

    private static String zzab() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return BuildConfig.VERSION_NAME;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Future zzac(Callable callable, long j, final Runnable runnable, Handler handler) {
        if (this.zzA == null) {
            this.zzA = Executors.newFixedThreadPool(com.google.android.gms.internal.play_billing.zzb.zza, new zzag(this));
        }
        try {
            final Future submit = this.zzA.submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzn
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = submit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j * 0.95d));
            return submit;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    private final void zzad(String str, final PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        if (!isReady()) {
            this.zzf.zza(zzbh.zza(2, 11, zzbk.zzm));
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzbk.zzm, null);
        } else if (zzac(new zzai(this, str, purchaseHistoryResponseListener), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzy
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzT(purchaseHistoryResponseListener);
            }
        }, zzY()) == null) {
            BillingResult zzaa = zzaa();
            this.zzf.zza(zzbh.zza(25, 11, zzaa));
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzaa, null);
        }
    }

    private final void zzae(String str, final PurchasesResponseListener purchasesResponseListener) {
        if (!isReady()) {
            this.zzf.zza(zzbh.zza(2, 9, zzbk.zzm));
            purchasesResponseListener.onQueryPurchasesResponse(zzbk.zzm, com.google.android.gms.internal.play_billing.zzaf.zzk());
        } else if (TextUtils.isEmpty(str)) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Please provide a valid product type.");
            this.zzf.zza(zzbh.zza(50, 9, zzbk.zzg));
            purchasesResponseListener.onQueryPurchasesResponse(zzbk.zzg, com.google.android.gms.internal.play_billing.zzaf.zzk());
        } else if (zzac(new zzah(this, str, purchasesResponseListener), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzs
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzU(purchasesResponseListener);
            }
        }, zzY()) == null) {
            BillingResult zzaa = zzaa();
            this.zzf.zza(zzbh.zza(25, 9, zzaa));
            purchasesResponseListener.onQueryPurchasesResponse(zzaa, com.google.android.gms.internal.play_billing.zzaf.zzk());
        }
    }

    private final void zzaf(BillingResult billingResult, int i, int i2) {
        zzic zzicVar = null;
        zzhy zzhyVar = null;
        if (billingResult.getResponseCode() != 0) {
            zzbi zzbiVar = this.zzf;
            try {
                zzhx zzv = zzhy.zzv();
                zzie zzv2 = zzii.zzv();
                zzv2.zzk(billingResult.getResponseCode());
                zzv2.zzj(billingResult.getDebugMessage());
                zzv2.zzl(i);
                zzv.zzi(zzv2);
                zzv.zzk(5);
                zziq zzv3 = zzis.zzv();
                zzv3.zzi(i2);
                zzv.zzj((zzis) zzv3.zzc());
                zzhyVar = (zzhy) zzv.zzc();
            } catch (Exception e) {
                com.google.android.gms.internal.play_billing.zzb.zzl("BillingLogger", "Unable to create logging payload", e);
            }
            zzbiVar.zza(zzhyVar);
            return;
        }
        zzbi zzbiVar2 = this.zzf;
        try {
            zzib zzv4 = zzic.zzv();
            zzv4.zzj(5);
            zziq zzv5 = zzis.zzv();
            zzv5.zzi(i2);
            zzv4.zzi((zzis) zzv5.zzc());
            zzicVar = (zzic) zzv4.zzc();
        } catch (Exception e2) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingLogger", "Unable to create logging payload", e2);
        }
        zzbiVar2.zzb(zzicVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzaz zzg(BillingClientImpl billingClientImpl, String str) {
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Querying purchase history, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        Bundle zzd = com.google.android.gms.internal.play_billing.zzb.zzd(billingClientImpl.zzn, billingClientImpl.zzv, true, false, billingClientImpl.zzb);
        String str2 = null;
        while (billingClientImpl.zzl) {
            try {
                Bundle zzh = billingClientImpl.zzg.zzh(6, billingClientImpl.zze.getPackageName(), str, str2, zzd);
                zzcf zza = zzcg.zza(zzh, "BillingClient", "getPurchaseHistory()");
                BillingResult zza2 = zza.zza();
                if (zza2 == zzbk.zzl) {
                    ArrayList<String> stringArrayList = zzh.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                    ArrayList<String> stringArrayList2 = zzh.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                    ArrayList<String> stringArrayList3 = zzh.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                    int i2 = i;
                    int i3 = i2;
                    while (i2 < stringArrayList2.size()) {
                        String str3 = stringArrayList2.get(i2);
                        String str4 = stringArrayList3.get(i2);
                        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Purchase record found for sku : ".concat(String.valueOf(stringArrayList.get(i2))));
                        try {
                            PurchaseHistoryRecord purchaseHistoryRecord = new PurchaseHistoryRecord(str3, str4);
                            if (TextUtils.isEmpty(purchaseHistoryRecord.getPurchaseToken())) {
                                com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "BUG: empty/null token!");
                                i3 = 1;
                            }
                            arrayList.add(purchaseHistoryRecord);
                            i2++;
                        } catch (JSONException e) {
                            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Got an exception trying to decode the purchase!", e);
                            billingClientImpl.zzf.zza(zzbh.zza(51, 11, zzbk.zzj));
                            return new zzaz(zzbk.zzj, null);
                        }
                    }
                    if (i3 != 0) {
                        billingClientImpl.zzf.zza(zzbh.zza(26, 11, zzbk.zzj));
                    }
                    str2 = zzh.getString("INAPP_CONTINUATION_TOKEN");
                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Continuation token: ".concat(String.valueOf(str2)));
                    if (TextUtils.isEmpty(str2)) {
                        return new zzaz(zzbk.zzl, arrayList);
                    }
                    i = 0;
                } else {
                    billingClientImpl.zzf.zza(zzbh.zza(zza.zzb(), 11, zza2));
                    return new zzaz(zza2, null);
                }
            } catch (RemoteException e2) {
                com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Got exception trying to get purchase history, try to reconnect", e2);
                billingClientImpl.zzf.zza(zzbh.zza(59, 11, zzbk.zzm));
                return new zzaz(zzbk.zzm, null);
            }
        }
        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "getPurchaseHistory is not supported on current device");
        return new zzaz(zzbk.zzq, null);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void acknowledgePurchase(final AcknowledgePurchaseParams acknowledgePurchaseParams, final AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (!isReady()) {
            this.zzf.zza(zzbh.zza(2, 3, zzbk.zzm));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbk.zzm);
            return;
        }
        if (TextUtils.isEmpty(acknowledgePurchaseParams.getPurchaseToken())) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Please provide a valid purchase token.");
            this.zzf.zza(zzbh.zza(26, 3, zzbk.zzi));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbk.zzi);
        } else if (!this.zzn) {
            this.zzf.zza(zzbh.zza(27, 3, zzbk.zzb));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbk.zzb);
        } else if (zzac(new Callable() { // from class: com.android.billingclient.api.zzaf
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzk(acknowledgePurchaseParams, acknowledgePurchaseResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzk
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzM(acknowledgePurchaseResponseListener);
            }
        }, zzY()) == null) {
            BillingResult zzaa = zzaa();
            this.zzf.zza(zzbh.zza(25, 3, zzaa));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzaa);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void consumeAsync(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        if (!isReady()) {
            this.zzf.zza(zzbh.zza(2, 4, zzbk.zzm));
            consumeResponseListener.onConsumeResponse(zzbk.zzm, consumeParams.getPurchaseToken());
        } else if (zzac(new Callable() { // from class: com.android.billingclient.api.zzw
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzl(consumeParams, consumeResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzx
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzO(consumeResponseListener, consumeParams);
            }
        }, zzY()) == null) {
            BillingResult zzaa = zzaa();
            this.zzf.zza(zzbh.zza(25, 4, zzaa));
            consumeResponseListener.onConsumeResponse(zzaa, consumeParams.getPurchaseToken());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void createAlternativeBillingOnlyReportingDetailsAsync(final AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        if (!isReady()) {
            this.zzf.zza(zzbh.zza(2, 15, zzbk.zzm));
            alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(zzbk.zzm, null);
        } else if (!this.zzx) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Current client doesn't support alternative billing only.");
            this.zzf.zza(zzbh.zza(66, 15, zzbk.zzD));
            alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(zzbk.zzD, null);
        } else if (zzac(new Callable() { // from class: com.android.billingclient.api.zzo
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzq(alternativeBillingOnlyReportingDetailsListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzp
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzP(alternativeBillingOnlyReportingDetailsListener);
            }
        }, zzY()) == null) {
            BillingResult zzaa = zzaa();
            this.zzf.zza(zzbh.zza(25, 15, zzaa));
            alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(zzaa, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void endConnection() {
        this.zzf.zzb(zzbh.zzb(12));
        try {
            try {
                if (this.zzd != null) {
                    this.zzd.zze();
                }
                if (this.zzh != null) {
                    this.zzh.zzc();
                }
                if (this.zzh != null && this.zzg != null) {
                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Unbinding from service.");
                    this.zze.unbindService(this.zzh);
                    this.zzh = null;
                }
                this.zzg = null;
                ExecutorService executorService = this.zzA;
                if (executorService != null) {
                    executorService.shutdownNow();
                    this.zzA = null;
                }
            } catch (Exception e) {
                com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "There was an exception while ending connection!", e);
            }
        } finally {
            this.zza = 3;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void getBillingConfigAsync(GetBillingConfigParams getBillingConfigParams, final BillingConfigResponseListener billingConfigResponseListener) {
        if (!isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Service disconnected.");
            this.zzf.zza(zzbh.zza(2, 13, zzbk.zzm));
            billingConfigResponseListener.onBillingConfigResponse(zzbk.zzm, null);
        } else {
            if (!this.zzu) {
                com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Current client doesn't support get billing config.");
                this.zzf.zza(zzbh.zza(32, 13, zzbk.zzz));
                billingConfigResponseListener.onBillingConfigResponse(zzbk.zzz, null);
                return;
            }
            String str = this.zzb;
            final Bundle bundle = new Bundle();
            bundle.putString("playBillingLibraryVersion", str);
            if (zzac(new Callable() { // from class: com.android.billingclient.api.zzl
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    BillingClientImpl.this.zzm(bundle, billingConfigResponseListener);
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzm
                @Override // java.lang.Runnable
                public final void run() {
                    BillingClientImpl.this.zzQ(billingConfigResponseListener);
                }
            }, zzY()) == null) {
                BillingResult zzaa = zzaa();
                this.zzf.zza(zzbh.zza(25, 13, zzaa));
                billingConfigResponseListener.onBillingConfigResponse(zzaa, null);
            }
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final int getConnectionState() {
        return this.zza;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void isAlternativeBillingOnlyAvailableAsync(final AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        if (!isReady()) {
            this.zzf.zza(zzbh.zza(2, 14, zzbk.zzm));
            alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(zzbk.zzm);
        } else if (!this.zzx) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Current client doesn't support alternative billing only.");
            this.zzf.zza(zzbh.zza(66, 14, zzbk.zzD));
            alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(zzbk.zzD);
        } else if (zzac(new Callable() { // from class: com.android.billingclient.api.zzt
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzr(alternativeBillingOnlyAvailabilityListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzv
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzR(alternativeBillingOnlyAvailabilityListener);
            }
        }, zzY()) == null) {
            BillingResult zzaa = zzaa();
            this.zzf.zza(zzbh.zza(25, 14, zzaa));
            alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(zzaa);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult isFeatureSupported(String str) {
        char c;
        if (!isReady()) {
            BillingResult billingResult = zzbk.zzm;
            if (billingResult.getResponseCode() != 0) {
                this.zzf.zza(zzbh.zza(2, 5, billingResult));
            } else {
                this.zzf.zzb(zzbh.zzb(5));
            }
            return zzbk.zzm;
        }
        int i = zzbk.zzF;
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS_UPDATE)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 96321:
                if (str.equals("aaa")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 97314:
                if (str.equals(BillingClient.FeatureType.IN_APP_MESSAGING)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 98307:
                if (str.equals("ccc")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 99300:
                if (str.equals("ddd")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 100293:
                if (str.equals("eee")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 101286:
                if (str.equals(BillingClient.FeatureType.PRODUCT_DETAILS)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 102279:
                if (str.equals(BillingClient.FeatureType.BILLING_CONFIG)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 103272:
                if (str.equals("hhh")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 104265:
                if (str.equals("iii")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 105258:
                if (str.equals(BillingClient.FeatureType.ALTERNATIVE_BILLING_ONLY)) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 207616302:
                if (str.equals(BillingClient.FeatureType.PRICE_CHANGE_CONFIRMATION)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1987365622:
                if (str.equals("subscriptions")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                BillingResult billingResult2 = this.zzi ? zzbk.zzl : zzbk.zzo;
                zzaf(billingResult2, 9, 2);
                return billingResult2;
            case 1:
                BillingResult billingResult3 = this.zzj ? zzbk.zzl : zzbk.zzp;
                zzaf(billingResult3, 10, 3);
                return billingResult3;
            case 2:
                BillingResult billingResult4 = this.zzm ? zzbk.zzl : zzbk.zzr;
                zzaf(billingResult4, 35, 4);
                return billingResult4;
            case 3:
                BillingResult billingResult5 = this.zzp ? zzbk.zzl : zzbk.zzw;
                zzaf(billingResult5, 30, 5);
                return billingResult5;
            case 4:
                BillingResult billingResult6 = this.zzr ? zzbk.zzl : zzbk.zzs;
                zzaf(billingResult6, 31, 6);
                return billingResult6;
            case 5:
                BillingResult billingResult7 = this.zzq ? zzbk.zzl : zzbk.zzu;
                zzaf(billingResult7, 21, 7);
                return billingResult7;
            case 6:
                BillingResult billingResult8 = this.zzs ? zzbk.zzl : zzbk.zzt;
                zzaf(billingResult8, 19, 8);
                return billingResult8;
            case 7:
                BillingResult billingResult9 = this.zzs ? zzbk.zzl : zzbk.zzt;
                zzaf(billingResult9, 61, 9);
                return billingResult9;
            case '\b':
                BillingResult billingResult10 = this.zzt ? zzbk.zzl : zzbk.zzv;
                zzaf(billingResult10, 20, 10);
                return billingResult10;
            case '\t':
                BillingResult billingResult11 = this.zzu ? zzbk.zzl : zzbk.zzz;
                zzaf(billingResult11, 32, 11);
                return billingResult11;
            case '\n':
                BillingResult billingResult12 = this.zzu ? zzbk.zzl : zzbk.zzA;
                zzaf(billingResult12, 33, 12);
                return billingResult12;
            case 11:
                BillingResult billingResult13 = this.zzw ? zzbk.zzl : zzbk.zzC;
                zzaf(billingResult13, 60, 13);
                return billingResult13;
            case '\f':
                BillingResult billingResult14 = this.zzx ? zzbk.zzl : zzbk.zzD;
                zzaf(billingResult14, 66, 14);
                return billingResult14;
            default:
                com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Unsupported feature: ".concat(String.valueOf(str)));
                zzaf(zzbk.zzy, 34, 1);
                return zzbk.zzy;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final boolean isReady() {
        return (this.zza != 2 || this.zzg == null || this.zzh == null) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0438 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03f5  */
    @Override // com.android.billingclient.api.BillingClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.android.billingclient.api.BillingResult launchBillingFlow(android.app.Activity r32, final com.android.billingclient.api.BillingFlowParams r33) {
        /*
            Method dump skipped, instructions count: 1328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.launchBillingFlow(android.app.Activity, com.android.billingclient.api.BillingFlowParams):com.android.billingclient.api.BillingResult");
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryProductDetailsAsync(final QueryProductDetailsParams queryProductDetailsParams, final ProductDetailsResponseListener productDetailsResponseListener) {
        if (!isReady()) {
            this.zzf.zza(zzbh.zza(2, 7, zzbk.zzm));
            productDetailsResponseListener.onProductDetailsResponse(zzbk.zzm, new ArrayList());
        } else if (!this.zzt) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Querying product details is not supported.");
            this.zzf.zza(zzbh.zza(20, 7, zzbk.zzv));
            productDetailsResponseListener.onProductDetailsResponse(zzbk.zzv, new ArrayList());
        } else if (zzac(new Callable() { // from class: com.android.billingclient.api.zzu
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzn(queryProductDetailsParams, productDetailsResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzz
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzS(productDetailsResponseListener);
            }
        }, zzY()) == null) {
            BillingResult zzaa = zzaa();
            this.zzf.zza(zzbh.zza(25, 7, zzaa));
            productDetailsResponseListener.onProductDetailsResponse(zzaa, new ArrayList());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(QueryPurchaseHistoryParams queryPurchaseHistoryParams, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzad(queryPurchaseHistoryParams.zza(), purchaseHistoryResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(QueryPurchasesParams queryPurchasesParams, PurchasesResponseListener purchasesResponseListener) {
        zzae(queryPurchasesParams.zza(), purchasesResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void querySkuDetailsAsync(SkuDetailsParams skuDetailsParams, final SkuDetailsResponseListener skuDetailsResponseListener) {
        if (!isReady()) {
            this.zzf.zza(zzbh.zza(2, 8, zzbk.zzm));
            skuDetailsResponseListener.onSkuDetailsResponse(zzbk.zzm, null);
            return;
        }
        final String skuType = skuDetailsParams.getSkuType();
        final List<String> skusList = skuDetailsParams.getSkusList();
        if (TextUtils.isEmpty(skuType)) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Please fix the input params. SKU type can't be empty.");
            this.zzf.zza(zzbh.zza(49, 8, zzbk.zzf));
            skuDetailsResponseListener.onSkuDetailsResponse(zzbk.zzf, null);
        } else if (skusList == null) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Please fix the input params. The list of SKUs can't be empty.");
            this.zzf.zza(zzbh.zza(48, 8, zzbk.zze));
            skuDetailsResponseListener.onSkuDetailsResponse(zzbk.zze, null);
        } else {
            final String str = null;
            if (zzac(new Callable(skuType, skusList, str, skuDetailsResponseListener) { // from class: com.android.billingclient.api.zzq
                public final /* synthetic */ String zzb;
                public final /* synthetic */ List zzc;
                public final /* synthetic */ SkuDetailsResponseListener zzd;

                {
                    this.zzd = skuDetailsResponseListener;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    BillingClientImpl.this.zzo(this.zzb, this.zzc, null, this.zzd);
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzr
                @Override // java.lang.Runnable
                public final void run() {
                    BillingClientImpl.this.zzV(skuDetailsResponseListener);
                }
            }, zzY()) == null) {
                BillingResult zzaa = zzaa();
                this.zzf.zza(zzbh.zza(25, 8, zzaa));
                skuDetailsResponseListener.onSkuDetailsResponse(zzaa, null);
            }
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult showAlternativeBillingOnlyInformationDialog(final Activity activity, final AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        if (!isReady()) {
            this.zzf.zza(zzbh.zza(2, 16, zzbk.zzm));
            return zzbk.zzm;
        }
        if (!this.zzx) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Current Play Store version doesn't support alternative billing only.");
            this.zzf.zza(zzbh.zza(66, 16, zzbk.zzD));
            return zzbk.zzD;
        }
        final zzak zzakVar = new zzak(this, this.zzc, alternativeBillingOnlyInformationDialogListener);
        if (zzac(new Callable() { // from class: com.android.billingclient.api.zzad
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzs(activity, zzakVar, alternativeBillingOnlyInformationDialogListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzae
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzW(alternativeBillingOnlyInformationDialogListener);
            }
        }, this.zzc) == null) {
            BillingResult zzaa = zzaa();
            this.zzf.zza(zzbh.zza(25, 16, zzaa));
            return zzaa;
        }
        return zzbk.zzl;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult showInAppMessages(final Activity activity, InAppMessageParams inAppMessageParams, InAppMessageResponseListener inAppMessageResponseListener) {
        if (!isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Service disconnected.");
            return zzbk.zzm;
        }
        if (!this.zzp) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Current client doesn't support showing in-app messages.");
            return zzbk.zzw;
        }
        View findViewById = activity.findViewById(R.id.content);
        IBinder windowToken = findViewById.getWindowToken();
        Rect rect = new Rect();
        findViewById.getGlobalVisibleRect(rect);
        final Bundle bundle = new Bundle();
        BundleCompat.putBinder(bundle, "KEY_WINDOW_TOKEN", windowToken);
        bundle.putInt("KEY_DIMEN_LEFT", rect.left);
        bundle.putInt("KEY_DIMEN_TOP", rect.top);
        bundle.putInt("KEY_DIMEN_RIGHT", rect.right);
        bundle.putInt("KEY_DIMEN_BOTTOM", rect.bottom);
        bundle.putString("playBillingLibraryVersion", this.zzb);
        bundle.putIntegerArrayList("KEY_CATEGORY_IDS", inAppMessageParams.zza());
        final zzaj zzajVar = new zzaj(this, this.zzc, inAppMessageResponseListener);
        zzac(new Callable() { // from class: com.android.billingclient.api.zzaa
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzp(bundle, activity, zzajVar);
                return null;
            }
        }, 5000L, null, this.zzc);
        return zzbk.zzl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzM(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        this.zzf.zza(zzbh.zza(24, 3, zzbk.zzn));
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbk.zzn);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzN(BillingResult billingResult) {
        if (this.zzd.zzd() != null) {
            this.zzd.zzd().onPurchasesUpdated(billingResult, null);
        } else {
            this.zzd.zzc();
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzO(ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        this.zzf.zza(zzbh.zza(24, 4, zzbk.zzn));
        consumeResponseListener.onConsumeResponse(zzbk.zzn, consumeParams.getPurchaseToken());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzP(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        this.zzf.zza(zzbh.zza(24, 15, zzbk.zzn));
        alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(zzbk.zzn, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzQ(BillingConfigResponseListener billingConfigResponseListener) {
        this.zzf.zza(zzbh.zza(24, 13, zzbk.zzn));
        billingConfigResponseListener.onBillingConfigResponse(zzbk.zzn, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzR(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        this.zzf.zza(zzbh.zza(24, 14, zzbk.zzn));
        alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(zzbk.zzn);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzS(ProductDetailsResponseListener productDetailsResponseListener) {
        this.zzf.zza(zzbh.zza(24, 7, zzbk.zzn));
        productDetailsResponseListener.onProductDetailsResponse(zzbk.zzn, new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzT(PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        this.zzf.zza(zzbh.zza(24, 11, zzbk.zzn));
        purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzbk.zzn, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzU(PurchasesResponseListener purchasesResponseListener) {
        this.zzf.zza(zzbh.zza(24, 9, zzbk.zzn));
        purchasesResponseListener.onQueryPurchasesResponse(zzbk.zzn, com.google.android.gms.internal.play_billing.zzaf.zzk());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzV(SkuDetailsResponseListener skuDetailsResponseListener) {
        this.zzf.zza(zzbh.zza(24, 8, zzbk.zzn));
        skuDetailsResponseListener.onSkuDetailsResponse(zzbk.zzn, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzW(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        this.zzf.zza(zzbh.zza(24, 16, zzbk.zzn));
        alternativeBillingOnlyInformationDialogListener.onAlternativeBillingOnlyInformationDialogResponse(zzbk.zzn);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Bundle zzc(int i, String str, String str2, BillingFlowParams billingFlowParams, Bundle bundle) throws Exception {
        return this.zzg.zzg(i, this.zze.getPackageName(), str, str2, null, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Bundle zzd(String str, String str2) throws Exception {
        return this.zzg.zzf(3, this.zze.getPackageName(), str, str2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object zzk(AcknowledgePurchaseParams acknowledgePurchaseParams, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) throws Exception {
        try {
            com.google.android.gms.internal.play_billing.zzm zzmVar = this.zzg;
            String packageName = this.zze.getPackageName();
            String purchaseToken = acknowledgePurchaseParams.getPurchaseToken();
            String str = this.zzb;
            Bundle bundle = new Bundle();
            bundle.putString("playBillingLibraryVersion", str);
            Bundle zzd = zzmVar.zzd(9, packageName, purchaseToken, bundle);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbk.zza(com.google.android.gms.internal.play_billing.zzb.zzb(zzd, "BillingClient"), com.google.android.gms.internal.play_billing.zzb.zzg(zzd, "BillingClient")));
            return null;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Error acknowledge purchase!", e);
            this.zzf.zza(zzbh.zza(28, 3, zzbk.zzm));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbk.zzm);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object zzl(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) throws Exception {
        int zza;
        String str;
        String purchaseToken = consumeParams.getPurchaseToken();
        try {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Consuming purchase with token: " + purchaseToken);
            if (this.zzn) {
                com.google.android.gms.internal.play_billing.zzm zzmVar = this.zzg;
                String packageName = this.zze.getPackageName();
                boolean z = this.zzn;
                String str2 = this.zzb;
                Bundle bundle = new Bundle();
                if (z) {
                    bundle.putString("playBillingLibraryVersion", str2);
                }
                Bundle zze = zzmVar.zze(9, packageName, purchaseToken, bundle);
                zza = zze.getInt("RESPONSE_CODE");
                str = com.google.android.gms.internal.play_billing.zzb.zzg(zze, "BillingClient");
            } else {
                zza = this.zzg.zza(3, this.zze.getPackageName(), purchaseToken);
                str = "";
            }
            BillingResult zza2 = zzbk.zza(zza, str);
            if (zza == 0) {
                com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Successfully consumed purchase.");
                consumeResponseListener.onConsumeResponse(zza2, purchaseToken);
                return null;
            }
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Error consuming purchase with token. Response code: " + zza);
            this.zzf.zza(zzbh.zza(23, 4, zza2));
            consumeResponseListener.onConsumeResponse(zza2, purchaseToken);
            return null;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Error consuming purchase!", e);
            this.zzf.zza(zzbh.zza(29, 4, zzbk.zzm));
            consumeResponseListener.onConsumeResponse(zzbk.zzm, purchaseToken);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object zzm(Bundle bundle, BillingConfigResponseListener billingConfigResponseListener) throws Exception {
        try {
            this.zzg.zzo(18, this.zze.getPackageName(), bundle, new zzau(billingConfigResponseListener, this.zzf, null));
        } catch (DeadObjectException e) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "getBillingConfig got a dead object exception (try to reconnect).", e);
            this.zzf.zza(zzbh.zza(62, 13, zzbk.zzm));
            billingConfigResponseListener.onBillingConfigResponse(zzbk.zzm, null);
        } catch (Exception e2) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "getBillingConfig got an exception.", e2);
            this.zzf.zza(zzbh.zza(62, 13, zzbk.zzj));
            billingConfigResponseListener.onBillingConfigResponse(zzbk.zzj, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object zzn(QueryProductDetailsParams queryProductDetailsParams, ProductDetailsResponseListener productDetailsResponseListener) throws Exception {
        String str;
        int i;
        int i2;
        int i3;
        com.google.android.gms.internal.play_billing.zzm zzmVar;
        int i4;
        String packageName;
        Bundle bundle;
        com.google.android.gms.internal.play_billing.zzaf zzafVar;
        ArrayList arrayList = new ArrayList();
        String zzb = queryProductDetailsParams.zzb();
        com.google.android.gms.internal.play_billing.zzaf zza = queryProductDetailsParams.zza();
        int size = zza.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                str = "";
                i = 0;
                break;
            }
            int i6 = i5 + 20;
            ArrayList arrayList2 = new ArrayList(zza.subList(i5, i6 > size ? size : i6));
            ArrayList<String> arrayList3 = new ArrayList<>();
            int size2 = arrayList2.size();
            for (int i7 = 0; i7 < size2; i7++) {
                arrayList3.add(((QueryProductDetailsParams.Product) arrayList2.get(i7)).zza());
            }
            Bundle bundle2 = new Bundle();
            bundle2.putStringArrayList("ITEM_ID_LIST", arrayList3);
            bundle2.putString("playBillingLibraryVersion", this.zzb);
            try {
                zzmVar = this.zzg;
                i4 = true != this.zzw ? 17 : 20;
                packageName = this.zze.getPackageName();
                String str2 = this.zzb;
                if (TextUtils.isEmpty(null)) {
                    this.zze.getPackageName();
                }
                bundle = new Bundle();
                bundle.putString("playBillingLibraryVersion", str2);
                bundle.putBoolean("enablePendingPurchases", true);
                bundle.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                int size3 = arrayList2.size();
                zzafVar = zza;
                int i8 = 0;
                boolean z = false;
                boolean z2 = false;
                while (i8 < size3) {
                    QueryProductDetailsParams.Product product = (QueryProductDetailsParams.Product) arrayList2.get(i8);
                    ArrayList arrayList6 = arrayList2;
                    arrayList4.add(null);
                    z |= !TextUtils.isEmpty(null);
                    String zzb2 = product.zzb();
                    int i9 = size3;
                    if (zzb2.equals("first_party")) {
                        com.google.android.gms.internal.play_billing.zzx.zzc(null, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                        arrayList5.add(null);
                        z2 = true;
                    }
                    i8++;
                    size3 = i9;
                    arrayList2 = arrayList6;
                }
                if (z) {
                    bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                }
                if (!arrayList5.isEmpty()) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                }
                if (z2 && !TextUtils.isEmpty(null)) {
                    bundle.putString("accountName", null);
                }
                i3 = 7;
            } catch (Exception e) {
                e = e;
                i2 = 6;
                i3 = 7;
            }
            try {
                Bundle zzl = zzmVar.zzl(i4, packageName, zzb, bundle2, bundle);
                str = "Item is unavailable for purchase.";
                if (zzl != null) {
                    if (zzl.containsKey("DETAILS_LIST")) {
                        ArrayList<String> stringArrayList = zzl.getStringArrayList("DETAILS_LIST");
                        if (stringArrayList != null) {
                            for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
                                try {
                                    ProductDetails productDetails = new ProductDetails(stringArrayList.get(i10));
                                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Got product details: ".concat(productDetails.toString()));
                                    arrayList.add(productDetails);
                                } catch (JSONException e2) {
                                    com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e2);
                                    str = "Error trying to decode SkuDetails.";
                                    i2 = 6;
                                    this.zzf.zza(zzbh.zza(47, 7, zzbk.zza(6, "Error trying to decode SkuDetails.")));
                                    i = i2;
                                    productDetailsResponseListener.onProductDetailsResponse(zzbk.zza(i, str), arrayList);
                                    return null;
                                }
                            }
                            i5 = i6;
                            zza = zzafVar;
                        } else {
                            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "queryProductDetailsAsync got null response list");
                            this.zzf.zza(zzbh.zza(46, 7, zzbk.zzB));
                            break;
                        }
                    } else {
                        i = com.google.android.gms.internal.play_billing.zzb.zzb(zzl, "BillingClient");
                        str = com.google.android.gms.internal.play_billing.zzb.zzg(zzl, "BillingClient");
                        if (i != 0) {
                            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + i);
                            this.zzf.zza(zzbh.zza(23, 7, zzbk.zza(i, str)));
                        } else {
                            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.");
                            this.zzf.zza(zzbh.zza(45, 7, zzbk.zza(6, str)));
                            i = 6;
                        }
                    }
                } else {
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "queryProductDetailsAsync got empty product details response.");
                    this.zzf.zza(zzbh.zza(44, 7, zzbk.zzB));
                    break;
                }
            } catch (Exception e3) {
                e = e3;
                i2 = 6;
                com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "queryProductDetailsAsync got a remote exception (try to reconnect).", e);
                this.zzf.zza(zzbh.zza(43, i3, zzbk.zzj));
                str = "An internal error occurred.";
                i = i2;
                productDetailsResponseListener.onProductDetailsResponse(zzbk.zza(i, str), arrayList);
                return null;
            }
        }
        i = 4;
        productDetailsResponseListener.onProductDetailsResponse(zzbk.zza(i, str), arrayList);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object zzo(String str, List list, String str2, SkuDetailsResponseListener skuDetailsResponseListener) throws Exception {
        String str3;
        int i;
        Bundle zzk;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                str3 = "";
                i = 0;
                break;
            }
            int i3 = i2 + 20;
            ArrayList<String> arrayList2 = new ArrayList<>(list.subList(i2, i3 > size ? size : i3));
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList2);
            bundle.putString("playBillingLibraryVersion", this.zzb);
            try {
                if (this.zzo) {
                    com.google.android.gms.internal.play_billing.zzm zzmVar = this.zzg;
                    String packageName = this.zze.getPackageName();
                    int i4 = this.zzk;
                    String str4 = this.zzb;
                    Bundle bundle2 = new Bundle();
                    if (i4 >= 9) {
                        bundle2.putString("playBillingLibraryVersion", str4);
                    }
                    if (i4 >= 9) {
                        bundle2.putBoolean("enablePendingPurchases", true);
                    }
                    zzk = zzmVar.zzl(10, packageName, str, bundle, bundle2);
                } else {
                    zzk = this.zzg.zzk(3, this.zze.getPackageName(), str, bundle);
                }
                str3 = "Item is unavailable for purchase.";
                if (zzk != null) {
                    if (zzk.containsKey("DETAILS_LIST")) {
                        ArrayList<String> stringArrayList = zzk.getStringArrayList("DETAILS_LIST");
                        if (stringArrayList != null) {
                            for (int i5 = 0; i5 < stringArrayList.size(); i5++) {
                                try {
                                    SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i5));
                                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Got sku details: ".concat(skuDetails.toString()));
                                    arrayList.add(skuDetails);
                                } catch (JSONException e) {
                                    com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Got a JSON exception trying to decode SkuDetails.", e);
                                    str3 = "Error trying to decode SkuDetails.";
                                    this.zzf.zza(zzbh.zza(47, 8, zzbk.zza(6, "Error trying to decode SkuDetails.")));
                                    arrayList = null;
                                    i = 6;
                                    skuDetailsResponseListener.onSkuDetailsResponse(zzbk.zza(i, str3), arrayList);
                                    return null;
                                }
                            }
                            i2 = i3;
                        } else {
                            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "querySkuDetailsAsync got null response list");
                            this.zzf.zza(zzbh.zza(46, 8, zzbk.zzB));
                            break;
                        }
                    } else {
                        int zzb = com.google.android.gms.internal.play_billing.zzb.zzb(zzk, "BillingClient");
                        str3 = com.google.android.gms.internal.play_billing.zzb.zzg(zzk, "BillingClient");
                        if (zzb != 0) {
                            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "getSkuDetails() failed. Response code: " + zzb);
                            this.zzf.zza(zzbh.zza(23, 8, zzbk.zza(zzb, str3)));
                            i = zzb;
                        } else {
                            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                            this.zzf.zza(zzbh.zza(45, 8, zzbk.zza(6, str3)));
                        }
                    }
                } else {
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "querySkuDetailsAsync got null sku details list");
                    this.zzf.zza(zzbh.zza(44, 8, zzbk.zzB));
                    break;
                }
            } catch (Exception e2) {
                com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "querySkuDetailsAsync got a remote exception (try to reconnect).", e2);
                this.zzf.zza(zzbh.zza(43, 8, zzbk.zzm));
                str3 = "Service connection is disconnected.";
                i = -1;
                arrayList = null;
            }
        }
        arrayList = null;
        i = 4;
        skuDetailsResponseListener.onSkuDetailsResponse(zzbk.zza(i, str3), arrayList);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object zzp(Bundle bundle, Activity activity, ResultReceiver resultReceiver) throws Exception {
        this.zzg.zzq(12, this.zze.getPackageName(), bundle, new zzay(new WeakReference(activity), resultReceiver, null));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void zzq(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) throws Exception {
        try {
            this.zzg.zzm(21, this.zze.getPackageName(), new Bundle(), new zzaq(alternativeBillingOnlyReportingDetailsListener, this.zzf, null));
        } catch (Exception unused) {
            this.zzf.zza(zzbh.zza(70, 15, zzbk.zzj));
            alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(zzbk.zzj, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void zzr(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) throws Exception {
        try {
            this.zzg.zzp(21, this.zze.getPackageName(), new Bundle(), new zzaw(alternativeBillingOnlyAvailabilityListener, this.zzf, null));
        } catch (Exception unused) {
            this.zzf.zza(zzbh.zza(69, 14, zzbk.zzj));
            alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(zzbk.zzj);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void zzs(Activity activity, ResultReceiver resultReceiver, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) throws Exception {
        try {
            this.zzg.zzn(21, this.zze.getPackageName(), new Bundle(), new zzas(new WeakReference(activity), resultReceiver, this.zzf, null));
        } catch (Exception unused) {
            this.zzf.zza(zzbh.zza(74, 16, zzbk.zzj));
            alternativeBillingOnlyInformationDialogListener.onAlternativeBillingOnlyInformationDialogResponse(zzbk.zzj);
        }
        return null;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(String str, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzad(str, purchaseHistoryResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(String str, PurchasesResponseListener purchasesResponseListener) {
        zzae(str, purchasesResponseListener);
    }

    private BillingClientImpl(Context context, zzbx zzbxVar, PurchasesUpdatedListener purchasesUpdatedListener, String str, String str2, UserChoiceBillingListener userChoiceBillingListener, zzbi zzbiVar, ExecutorService executorService) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = str;
        initialize(context, purchasesUpdatedListener, zzbxVar, userChoiceBillingListener, str, (zzbi) null);
    }

    private BillingClientImpl(String str) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BillingClientImpl(String str, Context context, zzbi zzbiVar, ExecutorService executorService) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        String zzab = zzab();
        this.zzb = zzab;
        this.zze = context.getApplicationContext();
        zzin zzv = zzio.zzv();
        zzv.zzj(zzab);
        zzv.zzi(this.zze.getPackageName());
        this.zzf = new zzbn(this.zze, (zzio) zzv.zzc());
        this.zze.getPackageName();
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzbx zzbxVar, UserChoiceBillingListener userChoiceBillingListener, String str, zzbi zzbiVar) {
        this.zze = context.getApplicationContext();
        zzin zzv = zzio.zzv();
        zzv.zzj(str);
        zzv.zzi(this.zze.getPackageName());
        if (zzbiVar != null) {
            this.zzf = zzbiVar;
        } else {
            this.zzf = new zzbn(this.zze, (zzio) zzv.zzc());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzd = new zzh(this.zze, purchasesUpdatedListener, userChoiceBillingListener, this.zzf);
        this.zzy = zzbxVar;
        this.zzz = userChoiceBillingListener != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BillingClientImpl(String str, zzbx zzbxVar, Context context, zzbq zzbqVar, zzbi zzbiVar, ExecutorService executorService) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = zzab();
        this.zze = context.getApplicationContext();
        zzin zzv = zzio.zzv();
        zzv.zzj(zzab());
        zzv.zzi(this.zze.getPackageName());
        this.zzf = new zzbn(this.zze, (zzio) zzv.zzc());
        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zzd = new zzh(this.zze, null, this.zzf);
        this.zzy = zzbxVar;
        this.zze.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BillingClientImpl(String str, zzbx zzbxVar, Context context, PurchasesUpdatedListener purchasesUpdatedListener, AlternativeBillingListener alternativeBillingListener, zzbi zzbiVar, ExecutorService executorService) {
        String zzab = zzab();
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = zzab;
        initialize(context, purchasesUpdatedListener, zzbxVar, alternativeBillingListener, zzab, (zzbi) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BillingClientImpl(String str, zzbx zzbxVar, Context context, PurchasesUpdatedListener purchasesUpdatedListener, UserChoiceBillingListener userChoiceBillingListener, zzbi zzbiVar, ExecutorService executorService) {
        this(context, zzbxVar, purchasesUpdatedListener, zzab(), null, userChoiceBillingListener, null, null);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void startConnection(BillingClientStateListener billingClientStateListener) {
        if (isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Service connection is valid. No need to re-initialize.");
            this.zzf.zzb(zzbh.zzb(6));
            billingClientStateListener.onBillingSetupFinished(zzbk.zzl);
            return;
        }
        int i = 1;
        if (this.zza == 1) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Client is already in the process of connecting to billing service.");
            this.zzf.zza(zzbh.zza(37, 6, zzbk.zzd));
            billingClientStateListener.onBillingSetupFinished(zzbk.zzd);
            return;
        }
        if (this.zza == 3) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            this.zzf.zza(zzbh.zza(38, 6, zzbk.zzm));
            billingClientStateListener.onBillingSetupFinished(zzbk.zzm);
            return;
        }
        this.zza = 1;
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Starting in-app billing setup.");
        this.zzh = new zzao(this, billingClientStateListener, null);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> queryIntentServices = this.zze.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            i = 41;
        } else {
            ResolveInfo resolveInfo = queryIntentServices.get(0);
            if (resolveInfo.serviceInfo != null) {
                String str = resolveInfo.serviceInfo.packageName;
                String str2 = resolveInfo.serviceInfo.name;
                if (!"com.android.vending".equals(str) || str2 == null) {
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "The device doesn't have valid Play Store.");
                    i = 40;
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.zzb);
                    if (this.zze.bindService(intent2, this.zzh, 1)) {
                        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Service was bonded successfully.");
                        return;
                    } else {
                        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Connection to Billing service is blocked.");
                        i = 39;
                    }
                }
            }
        }
        this.zza = 0;
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Billing service unavailable on device.");
        this.zzf.zza(zzbh.zza(i, 6, zzbk.zzc));
        billingClientStateListener.onBillingSetupFinished(zzbk.zzc);
    }
}
