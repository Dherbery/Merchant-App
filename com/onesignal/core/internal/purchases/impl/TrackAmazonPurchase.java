package com.onesignal.core.internal.purchases.impl;

import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataResponse;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.BuildConfig;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.PurchaseInfo;
import com.onesignal.user.internal.operations.TrackPurchaseOperation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: TrackAmazonPurchase.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0002\u001e\u001fB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0018\u00010\u0013R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/onesignal/core/internal/purchases/impl/TrackAmazonPurchase;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_operationRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/operations/IOperationRepo;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/identity/IdentityModelStore;)V", "canTrack", "", "listenerHandlerField", "Ljava/lang/reflect/Field;", "listenerHandlerObject", "", "osPurchasingListener", "Lcom/onesignal/core/internal/purchases/impl/TrackAmazonPurchase$OSPurchasingListener;", "registerListenerOnMainThread", "logAmazonIAPListenerError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onFocus", "onUnfocused", "setListener", "start", "Companion", "OSPurchasingListener", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class TrackAmazonPurchase implements IStartableService, IApplicationLifecycleHandler {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;
    private final IOperationRepo _operationRepo;
    private boolean canTrack;
    private Field listenerHandlerField;
    private Object listenerHandlerObject;
    private OSPurchasingListener osPurchasingListener;
    private boolean registerListenerOnMainThread;

    @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onFocus() {
    }

    public TrackAmazonPurchase(IApplicationService _applicationService, IOperationRepo _operationRepo, ConfigModelStore _configModelStore, IdentityModelStore _identityModelStore) {
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(_operationRepo, "_operationRepo");
        Intrinsics.checkNotNullParameter(_configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(_identityModelStore, "_identityModelStore");
        this._applicationService = _applicationService;
        this._operationRepo = _operationRepo;
        this._configModelStore = _configModelStore;
        this._identityModelStore = _identityModelStore;
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        if (INSTANCE.canTrack()) {
            try {
                Class<?> cls = Class.forName("com.amazon.device.iap.internal.d");
                try {
                    try {
                        this.listenerHandlerObject = cls.getMethod("d", new Class[0]).invoke(null, new Object[0]);
                    } catch (NullPointerException unused) {
                        this.listenerHandlerObject = cls.getMethod("e", new Class[0]).invoke(null, new Object[0]);
                        this.registerListenerOnMainThread = true;
                    }
                } catch (NullPointerException unused2) {
                    this.listenerHandlerObject = cls.getMethod("g", new Class[0]).invoke(null, new Object[0]);
                    this.registerListenerOnMainThread = true;
                }
                Field declaredField = cls.getDeclaredField("f");
                declaredField.setAccessible(true);
                OSPurchasingListener oSPurchasingListener = new OSPurchasingListener(this, this._operationRepo, this._configModelStore, this._identityModelStore);
                this.osPurchasingListener = oSPurchasingListener;
                Intrinsics.checkNotNull(oSPurchasingListener);
                oSPurchasingListener.setOrgPurchasingListener((PurchasingListener) declaredField.get(this.listenerHandlerObject));
                this.listenerHandlerField = declaredField;
                this.canTrack = true;
                setListener();
            } catch (ClassCastException e) {
                logAmazonIAPListenerError(e);
            } catch (ClassNotFoundException e2) {
                logAmazonIAPListenerError(e2);
            } catch (IllegalAccessException e3) {
                logAmazonIAPListenerError(e3);
            } catch (NoSuchFieldException e4) {
                logAmazonIAPListenerError(e4);
            } catch (NoSuchMethodException e5) {
                logAmazonIAPListenerError(e5);
            } catch (InvocationTargetException e6) {
                logAmazonIAPListenerError(e6);
            }
            this._applicationService.addApplicationLifecycleHandler(this);
        }
    }

    private final void logAmazonIAPListenerError(Exception e) {
        Logging.error("Error adding Amazon IAP listener.", e);
        e.printStackTrace();
    }

    @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onUnfocused() {
        if (this.canTrack) {
            try {
                Field field = this.listenerHandlerField;
                Intrinsics.checkNotNull(field);
                PurchasingListener purchasingListener = (PurchasingListener) field.get(this.listenerHandlerObject);
                OSPurchasingListener oSPurchasingListener = this.osPurchasingListener;
                if (purchasingListener != oSPurchasingListener) {
                    Intrinsics.checkNotNull(oSPurchasingListener);
                    oSPurchasingListener.setOrgPurchasingListener(purchasingListener);
                    setListener();
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private final void setListener() {
        if (this.registerListenerOnMainThread) {
            ThreadUtilsKt.suspendifyOnMain(new TrackAmazonPurchase$setListener$1(this, null));
        } else {
            PurchasingService.registerListener(this._applicationService.getAppContext(), this.osPurchasingListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TrackAmazonPurchase.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/onesignal/core/internal/purchases/impl/TrackAmazonPurchase$OSPurchasingListener;", "Lcom/amazon/device/iap/PurchasingListener;", "_operationRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "(Lcom/onesignal/core/internal/purchases/impl/TrackAmazonPurchase;Lcom/onesignal/core/internal/operations/IOperationRepo;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/identity/IdentityModelStore;)V", "currentMarket", "", "lastRequestId", "Lcom/amazon/device/iap/model/RequestId;", "orgPurchasingListener", "getOrgPurchasingListener", "()Lcom/amazon/device/iap/PurchasingListener;", "setOrgPurchasingListener", "(Lcom/amazon/device/iap/PurchasingListener;)V", "marketToCurrencyCode", "market", "onProductDataResponse", "", "response", "Lcom/amazon/device/iap/model/ProductDataResponse;", "onPurchaseResponse", "Lcom/amazon/device/iap/model/PurchaseResponse;", "onPurchaseUpdatesResponse", "Lcom/amazon/device/iap/model/PurchaseUpdatesResponse;", "onUserDataResponse", "Lcom/amazon/device/iap/model/UserDataResponse;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public final class OSPurchasingListener implements PurchasingListener {
        private final ConfigModelStore _configModelStore;
        private final IdentityModelStore _identityModelStore;
        private final IOperationRepo _operationRepo;
        private String currentMarket;
        private RequestId lastRequestId;
        private PurchasingListener orgPurchasingListener;
        final /* synthetic */ TrackAmazonPurchase this$0;

        /* compiled from: TrackAmazonPurchase.kt */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes5.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ProductDataResponse.RequestStatus.values().length];
                iArr[ProductDataResponse.RequestStatus.SUCCESSFUL.ordinal()] = 1;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public OSPurchasingListener(TrackAmazonPurchase trackAmazonPurchase, IOperationRepo _operationRepo, ConfigModelStore _configModelStore, IdentityModelStore _identityModelStore) {
            Intrinsics.checkNotNullParameter(_operationRepo, "_operationRepo");
            Intrinsics.checkNotNullParameter(_configModelStore, "_configModelStore");
            Intrinsics.checkNotNullParameter(_identityModelStore, "_identityModelStore");
            this.this$0 = trackAmazonPurchase;
            this._operationRepo = _operationRepo;
            this._configModelStore = _configModelStore;
            this._identityModelStore = _identityModelStore;
        }

        public final PurchasingListener getOrgPurchasingListener() {
            return this.orgPurchasingListener;
        }

        public final void setOrgPurchasingListener(PurchasingListener purchasingListener) {
            this.orgPurchasingListener = purchasingListener;
        }

        private final String marketToCurrencyCode(String market) {
            if (market == null) {
                return "";
            }
            int hashCode = market.hashCode();
            return hashCode != 2100 ? hashCode != 2128 ? hashCode != 2142 ? hashCode != 2177 ? hashCode != 2222 ? hashCode != 2252 ? hashCode != 2267 ? hashCode != 2347 ? hashCode != 2374 ? (hashCode == 2718 && market.equals("US")) ? "USD" : "" : !market.equals("JP") ? "" : "JPY" : !market.equals("IT") ? "" : "EUR" : !market.equals("GB") ? "" : "GBP" : !market.equals("FR") ? "" : "EUR" : !market.equals("ES") ? "" : "EUR" : !market.equals("DE") ? "" : "EUR" : !market.equals("CA") ? "" : "CDN" : !market.equals("BR") ? "" : "BRL" : !market.equals("AU") ? "" : "AUD";
        }

        @Override // com.amazon.device.iap.PurchasingListener
        public void onProductDataResponse(ProductDataResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            RequestId requestId = this.lastRequestId;
            if (requestId != null && Intrinsics.areEqual(String.valueOf(requestId), response.getRequestId().toString())) {
                ProductDataResponse.RequestStatus requestStatus = response.getRequestStatus();
                if ((requestStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$0[requestStatus.ordinal()]) == 1) {
                    ArrayList arrayList = new ArrayList();
                    Map<String, Product> productData = response.getProductData();
                    BigDecimal bigDecimal = new BigDecimal(0);
                    Iterator<String> it = productData.keySet().iterator();
                    BigDecimal bigDecimal2 = bigDecimal;
                    while (it.hasNext()) {
                        Product product = productData.get(it.next());
                        Intrinsics.checkNotNull(product);
                        String sku = product.getSku();
                        String marketToCurrencyCode = marketToCurrencyCode(this.currentMarket);
                        String priceStr = product.getPrice();
                        Intrinsics.checkNotNullExpressionValue(priceStr, "priceStr");
                        if (!new Regex("^[0-9]").matches(priceStr)) {
                            Intrinsics.checkNotNullExpressionValue(priceStr, "priceStr");
                            priceStr = priceStr.substring(1);
                            Intrinsics.checkNotNullExpressionValue(priceStr, "this as java.lang.String).substring(startIndex)");
                        }
                        BigDecimal bigDecimal3 = new BigDecimal(priceStr);
                        bigDecimal2 = bigDecimal2.add(bigDecimal3);
                        Intrinsics.checkNotNullExpressionValue(bigDecimal2, "this.add(other)");
                        Intrinsics.checkNotNullExpressionValue(sku, "sku");
                        arrayList.add(new PurchaseInfo(sku, marketToCurrencyCode, bigDecimal3));
                    }
                    IOperationRepo.DefaultImpls.enqueue$default(this._operationRepo, new TrackPurchaseOperation(this._configModelStore.getModel().getAppId(), this._identityModelStore.getModel().getOnesignalId(), false, bigDecimal2, arrayList), false, 2, null);
                    return;
                }
                return;
            }
            PurchasingListener purchasingListener = this.orgPurchasingListener;
            if (purchasingListener != null) {
                Intrinsics.checkNotNull(purchasingListener);
                purchasingListener.onProductDataResponse(response);
            }
        }

        @Override // com.amazon.device.iap.PurchasingListener
        public void onPurchaseResponse(PurchaseResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.getRequestStatus() == PurchaseResponse.RequestStatus.SUCCESSFUL) {
                this.currentMarket = response.getUserData().getMarketplace();
                HashSet hashSet = new HashSet();
                String sku = response.getReceipt().getSku();
                Intrinsics.checkNotNullExpressionValue(sku, "response.receipt.sku");
                hashSet.add(sku);
                this.lastRequestId = PurchasingService.getProductData(hashSet);
            }
            PurchasingListener purchasingListener = this.orgPurchasingListener;
            if (purchasingListener != null) {
                Intrinsics.checkNotNull(purchasingListener);
                purchasingListener.onPurchaseResponse(response);
            }
        }

        @Override // com.amazon.device.iap.PurchasingListener
        public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            PurchasingListener purchasingListener = this.orgPurchasingListener;
            if (purchasingListener != null) {
                Intrinsics.checkNotNull(purchasingListener);
                purchasingListener.onPurchaseUpdatesResponse(response);
            }
        }

        @Override // com.amazon.device.iap.PurchasingListener
        public void onUserDataResponse(UserDataResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            PurchasingListener purchasingListener = this.orgPurchasingListener;
            if (purchasingListener != null) {
                Intrinsics.checkNotNull(purchasingListener);
                purchasingListener.onUserDataResponse(response);
            }
        }
    }

    /* compiled from: TrackAmazonPurchase.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/onesignal/core/internal/purchases/impl/TrackAmazonPurchase$Companion;", "", "()V", "canTrack", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean canTrack() {
            try {
                Class.forName("com.amazon.device.iap.PurchasingListener");
                return true;
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
    }
}
