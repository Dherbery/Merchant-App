package com.onesignal.core.internal.purchases.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferencePlayerPurchasesKeys;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.core.internal.purchases.impl.TrackGooglePurchase;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.PurchaseInfo;
import com.onesignal.user.internal.operations.TrackPurchaseOperation;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TrackGooglePurchase.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0002J8\u0010\u001f\u001a\u00020\u001c2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001a0!j\b\u0012\u0004\u0012\u00020\u001a`\"2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u001a0!j\b\u0012\u0004\u0012\u00020\u001a`\"H\u0002J\b\u0010$\u001a\u00020\u001cH\u0016J\b\u0010%\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/onesignal/core/internal/purchases/impl/TrackGooglePurchase;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "_operationRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/preferences/IPreferencesService;Lcom/onesignal/core/internal/operations/IOperationRepo;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/identity/IdentityModelStore;)V", "getPurchasesMethod", "Ljava/lang/reflect/Method;", "getSkuDetailsMethod", "isWaitingForPurchasesRequest", "", "mIInAppBillingService", "", "mServiceConn", "Landroid/content/ServiceConnection;", "newAsExisting", PreferencePlayerPurchasesKeys.PREFS_PURCHASE_TOKENS, "", "", "onFocus", "", "onUnfocused", "queryBoughtItems", "sendPurchases", "skusToAdd", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "newPurchaseTokens", "start", "trackIAP", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class TrackGooglePurchase implements IStartableService, IApplicationLifecycleHandler {
    private static Class<?> iInAppBillingServiceClass;
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;
    private final IOperationRepo _operationRepo;
    private final IPreferencesService _prefs;
    private Method getPurchasesMethod;
    private Method getSkuDetailsMethod;
    private boolean isWaitingForPurchasesRequest;
    private Object mIInAppBillingService;
    private ServiceConnection mServiceConn;
    private boolean newAsExisting;
    private final List<String> purchaseTokens;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int iapEnabled = -99;

    @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onUnfocused() {
    }

    public TrackGooglePurchase(IApplicationService _applicationService, IPreferencesService _prefs, IOperationRepo _operationRepo, ConfigModelStore _configModelStore, IdentityModelStore _identityModelStore) {
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(_prefs, "_prefs");
        Intrinsics.checkNotNullParameter(_operationRepo, "_operationRepo");
        Intrinsics.checkNotNullParameter(_configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(_identityModelStore, "_identityModelStore");
        this._applicationService = _applicationService;
        this._prefs = _prefs;
        this._operationRepo = _operationRepo;
        this._configModelStore = _configModelStore;
        this._identityModelStore = _identityModelStore;
        this.purchaseTokens = new ArrayList();
        this.newAsExisting = true;
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        if (INSTANCE.canTrack(this._applicationService.getAppContext())) {
            try {
                JSONArray jSONArray = new JSONArray(this._prefs.getString(PreferenceStores.PLAYER_PURCHASES, PreferencePlayerPurchasesKeys.PREFS_PURCHASE_TOKENS, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    this.purchaseTokens.add(jSONArray.get(i).toString());
                }
                boolean z = jSONArray.length() == 0;
                this.newAsExisting = z;
                if (z) {
                    Boolean bool = this._prefs.getBool(PreferenceStores.PLAYER_PURCHASES, PreferencePlayerPurchasesKeys.PREFS_EXISTING_PURCHASES, true);
                    Intrinsics.checkNotNull(bool);
                    this.newAsExisting = bool.booleanValue();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this._applicationService.addApplicationLifecycleHandler(this);
            trackIAP();
        }
    }

    @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onFocus() {
        trackIAP();
    }

    private final void trackIAP() {
        if (this.mServiceConn == null) {
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.onesignal.core.internal.purchases.impl.TrackGooglePurchase$trackIAP$serviceConn$1
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName name) {
                    Intrinsics.checkNotNullParameter(name, "name");
                    TrackGooglePurchase.Companion companion = TrackGooglePurchase.INSTANCE;
                    TrackGooglePurchase.iapEnabled = -99;
                    TrackGooglePurchase.this.mIInAppBillingService = null;
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName name, IBinder service) {
                    Method asInterfaceMethod;
                    Intrinsics.checkNotNullParameter(name, "name");
                    Intrinsics.checkNotNullParameter(service, "service");
                    try {
                        Class<?> stubClass = Class.forName("com.android.vending.billing.IInAppBillingService$Stub");
                        TrackGooglePurchase.Companion companion = TrackGooglePurchase.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(stubClass, "stubClass");
                        asInterfaceMethod = companion.getAsInterfaceMethod(stubClass);
                        Intrinsics.checkNotNull(asInterfaceMethod);
                        asInterfaceMethod.setAccessible(true);
                        TrackGooglePurchase.this.mIInAppBillingService = asInterfaceMethod.invoke(null, service);
                        TrackGooglePurchase.this.queryBoughtItems();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            };
            this.mServiceConn = serviceConnection;
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            this._applicationService.getAppContext().getApplicationContext().bindService(intent, serviceConnection, 1);
            return;
        }
        if (this.mIInAppBillingService != null) {
            queryBoughtItems();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void queryBoughtItems() {
        if (this.isWaitingForPurchasesRequest) {
            return;
        }
        new Thread(new Runnable() { // from class: com.onesignal.core.internal.purchases.impl.TrackGooglePurchase$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TrackGooglePurchase.m1011queryBoughtItems$lambda0(TrackGooglePurchase.this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: queryBoughtItems$lambda-0, reason: not valid java name */
    public static final void m1011queryBoughtItems$lambda0(TrackGooglePurchase this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isWaitingForPurchasesRequest = true;
        try {
            if (this$0.getPurchasesMethod == null) {
                Method getPurchasesMethod = INSTANCE.getGetPurchasesMethod(iInAppBillingServiceClass);
                this$0.getPurchasesMethod = getPurchasesMethod;
                Intrinsics.checkNotNull(getPurchasesMethod);
                getPurchasesMethod.setAccessible(true);
            }
            Method method = this$0.getPurchasesMethod;
            Intrinsics.checkNotNull(method);
            Object invoke = method.invoke(this$0.mIInAppBillingService, 3, this$0._applicationService.getAppContext().getPackageName(), "inapp", null);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type android.os.Bundle");
            Bundle bundle = (Bundle) invoke;
            if (bundle.getInt("RESPONSE_CODE") == 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                ArrayList<String> arrayList2 = new ArrayList<>();
                ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                Intrinsics.checkNotNull(stringArrayList2);
                int size = stringArrayList2.size();
                for (int i = 0; i < size; i++) {
                    String str = stringArrayList2.get(i);
                    Intrinsics.checkNotNull(stringArrayList);
                    String str2 = stringArrayList.get(i);
                    String string = new JSONObject(str).getString("purchaseToken");
                    if (!this$0.purchaseTokens.contains(string) && !arrayList2.contains(string)) {
                        arrayList2.add(string);
                        arrayList.add(str2);
                    }
                }
                if (arrayList.size() > 0) {
                    this$0.sendPurchases(arrayList, arrayList2);
                } else if (stringArrayList2.size() == 0) {
                    this$0.newAsExisting = false;
                    this$0._prefs.saveBool(PreferenceStores.PLAYER_PURCHASES, PreferencePlayerPurchasesKeys.PREFS_EXISTING_PURCHASES, false);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this$0.isWaitingForPurchasesRequest = false;
    }

    private final void sendPurchases(ArrayList<String> skusToAdd, ArrayList<String> newPurchaseTokens) {
        try {
            if (this.getSkuDetailsMethod == null) {
                Method getSkuDetailsMethod = INSTANCE.getGetSkuDetailsMethod(iInAppBillingServiceClass);
                this.getSkuDetailsMethod = getSkuDetailsMethod;
                Intrinsics.checkNotNull(getSkuDetailsMethod);
                getSkuDetailsMethod.setAccessible(true);
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", skusToAdd);
            Method method = this.getSkuDetailsMethod;
            Intrinsics.checkNotNull(method);
            Object invoke = method.invoke(this.mIInAppBillingService, 3, this._applicationService.getAppContext().getPackageName(), "inapp", bundle);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type android.os.Bundle");
            Bundle bundle2 = (Bundle) invoke;
            if (bundle2.getInt("RESPONSE_CODE") == 0) {
                ArrayList<String> stringArrayList = bundle2.getStringArrayList("DETAILS_LIST");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Intrinsics.checkNotNull(stringArrayList);
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject = new JSONObject(it.next());
                    String sku = jSONObject.getString("productId");
                    String iso = jSONObject.getString("price_currency_code");
                    BigDecimal divide = new BigDecimal(jSONObject.getString("price_amount_micros")).divide(new BigDecimal(1000000));
                    Intrinsics.checkNotNullExpressionValue(divide, "price.divide(BigDecimal(1000000))");
                    Intrinsics.checkNotNullExpressionValue(sku, "sku");
                    Intrinsics.checkNotNullExpressionValue(iso, "iso");
                    linkedHashMap.put(sku, new PurchaseInfo(sku, iso, divide));
                }
                ArrayList arrayList = new ArrayList();
                Iterator<String> it2 = skusToAdd.iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    if (linkedHashMap.containsKey(next)) {
                        Object obj = linkedHashMap.get(next);
                        Intrinsics.checkNotNull(obj);
                        arrayList.add(obj);
                    }
                }
                if (!arrayList.isEmpty()) {
                    IOperationRepo.DefaultImpls.enqueue$default(this._operationRepo, new TrackPurchaseOperation(this._configModelStore.getModel().getAppId(), this._identityModelStore.getModel().getOnesignalId(), this.newAsExisting, new BigDecimal(0), arrayList), false, 2, null);
                    this.purchaseTokens.addAll(newPurchaseTokens);
                    this._prefs.saveString(PreferenceStores.PLAYER_PURCHASES, PreferencePlayerPurchasesKeys.PREFS_PURCHASE_TOKENS, this.purchaseTokens.toString());
                    this._prefs.saveBool(PreferenceStores.PLAYER_PURCHASES, PreferencePlayerPurchasesKeys.PREFS_EXISTING_PURCHASES, true);
                    this.newAsExisting = false;
                    this.isWaitingForPurchasesRequest = false;
                }
            }
        } catch (Throwable th) {
            Logging.warn("Failed to track IAP purchases", th);
        }
    }

    /* compiled from: TrackGooglePurchase.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0002J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/onesignal/core/internal/purchases/impl/TrackGooglePurchase$Companion;", "", "()V", "iInAppBillingServiceClass", "Ljava/lang/Class;", "iapEnabled", "", "canTrack", "", "context", "Landroid/content/Context;", "getAsInterfaceMethod", "Ljava/lang/reflect/Method;", "clazz", "getGetPurchasesMethod", "getGetSkuDetailsMethod", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean canTrack(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (TrackGooglePurchase.iapEnabled == -99) {
                TrackGooglePurchase.iapEnabled = context.checkCallingOrSelfPermission("com.android.vending.BILLING");
            }
            try {
                if (TrackGooglePurchase.iapEnabled == 0) {
                    TrackGooglePurchase.iInAppBillingServiceClass = Class.forName("com.android.vending.billing.IInAppBillingService");
                }
                return TrackGooglePurchase.iapEnabled == 0;
            } catch (Throwable unused) {
                TrackGooglePurchase.iapEnabled = 0;
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Method getAsInterfaceMethod(Class<?> clazz) {
            Method[] methods = clazz.getMethods();
            Intrinsics.checkNotNullExpressionValue(methods, "clazz.methods");
            for (Method method : methods) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && Intrinsics.areEqual(parameterTypes[0], IBinder.class)) {
                    return method;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Method getGetPurchasesMethod(Class<?> clazz) {
            Intrinsics.checkNotNull(clazz);
            Method[] methods = clazz.getMethods();
            Intrinsics.checkNotNullExpressionValue(methods, "clazz!!.methods");
            for (Method method : methods) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 4 && Intrinsics.areEqual(parameterTypes[0], Integer.TYPE) && Intrinsics.areEqual(parameterTypes[1], String.class) && Intrinsics.areEqual(parameterTypes[2], String.class) && Intrinsics.areEqual(parameterTypes[3], String.class)) {
                    return method;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Method getGetSkuDetailsMethod(Class<?> clazz) {
            Intrinsics.checkNotNull(clazz);
            Method[] methods = clazz.getMethods();
            Intrinsics.checkNotNullExpressionValue(methods, "clazz!!.methods");
            for (Method method : methods) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Class<?> returnType = method.getReturnType();
                if (parameterTypes.length == 4 && Intrinsics.areEqual(parameterTypes[0], Integer.TYPE) && Intrinsics.areEqual(parameterTypes[1], String.class) && Intrinsics.areEqual(parameterTypes[2], String.class) && Intrinsics.areEqual(parameterTypes[3], Bundle.class) && Intrinsics.areEqual(returnType, Bundle.class)) {
                    return method;
                }
            }
            return null;
        }
    }
}
