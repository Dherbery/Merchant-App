package com.revenuecat.purchases.hybridcommon;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.amazon.a.a.o.b;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.react.uimanager.ViewProps;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.DangerousSettings;
import com.revenuecat.purchases.EntitlementVerificationMode;
import com.revenuecat.purchases.ListenerConversionsCommonKt;
import com.revenuecat.purchases.ListenerConversionsKt;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesConfiguration;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.hybridcommon.mappers.CustomerInfoMapperKt;
import com.revenuecat.purchases.hybridcommon.mappers.LogHandlerWithMapping;
import com.revenuecat.purchases.hybridcommon.mappers.MappedProductCategory;
import com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt;
import com.revenuecat.purchases.hybridcommon.mappers.PurchasesErrorKt;
import com.revenuecat.purchases.hybridcommon.mappers.StoreProductMapperKt;
import com.revenuecat.purchases.hybridcommon.mappers.StoreTransactionMapperKt;
import com.revenuecat.purchases.interfaces.Callback;
import com.revenuecat.purchases.models.BillingFeature;
import com.revenuecat.purchases.models.GoogleProrationMode;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: common.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u001a,\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u001ae\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u001b\u001a\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\fH\u0000\u001a\u0006\u0010\u001e\u001a\u00020\f\u001a\u000e\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020 \u001a\u0019\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0002\u0010$\u001a\u000e\u0010%\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020 \u001a$\u0010&\u001a\u00020\u00012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010(\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020)\u001a\u0006\u0010*\u001a\u00020+\u001a\b\u0010,\u001a\u0004\u0018\u00010\f\u001a$\u0010-\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00010.2\u0006\u0010\u0007\u001a\u00020 H\u0002\u001a\"\u00101\u001a\u0014\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010.2\u0006\u0010\u0007\u001a\u00020 H\u0002\u001a\u0006\u00103\u001a\u00020\u0001\u001a\u0006\u00104\u001a\u00020\t\u001a\u0016\u00105\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020 \u001a\u000e\u00106\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020 \u001a\u0010\u00107\u001a\u0002082\u0006\u0010(\u001a\u00020\fH\u0001\u001aK\u00109\u001a\u00020\u00012\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u00020\f2\b\u0010>\u001a\u0004\u0018\u00010\f2\b\u0010?\u001a\u0004\u0018\u00010\u00062\b\u0010@\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020 ¢\u0006\u0002\u0010A\u001a_\u0010B\u001a\u00020\u00012\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010C\u001a\u00020\f2\u0006\u0010(\u001a\u00020\f2\b\u0010D\u001a\u0004\u0018\u00010\f2\b\u0010>\u001a\u0004\u0018\u00010\f2\b\u0010?\u001a\u0004\u0018\u00010\u00062\b\u0010@\u001a\u0004\u0018\u00010\t2\b\u0010E\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020 ¢\u0006\u0002\u0010F\u001aU\u0010G\u001a\u00020\u00012\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010C\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f2\b\u0010>\u001a\u0004\u0018\u00010\f2\b\u0010?\u001a\u0004\u0018\u00010\u00062\b\u0010@\u001a\u0004\u0018\u00010\t2\b\u0010E\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020 ¢\u0006\u0002\u0010I\u001a\u000e\u0010J\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020 \u001a\u0010\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020\tH\u0007\u001a\u0010\u0010M\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\tH\u0007\u001a\u000e\u0010O\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\t\u001a5\u0010P\u001a\u00020\u00012-\u0010Q\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\f\bS\u0012\b\bT\u0012\u0004\b\b(U\u0012\u0004\u0012\u00020\u00010R\u001a\u000e\u0010V\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020 \u001a\u000e\u0010W\u001a\u00020\u00012\u0006\u0010X\u001a\u00020\f\u001a\u0010\u0010Y\u001a\u00020\u00012\b\u0010Z\u001a\u0004\u0018\u00010\f\u001a$\u0010[\u001a\u00020\u00012\b\u0010:\u001a\u0004\u0018\u00010;2\u0010\b\u0002\u0010\\\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010\u0005H\u0007\u001a\u0006\u0010^\u001a\u00020\u0001\u001a\u0010\u0010_\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\fH\u0000\u001a\u0016\u0010`\u001a\u00020a*\u00020a2\b\u0010E\u001a\u0004\u0018\u00010\fH\u0002¨\u0006b"}, d2 = {"canMakePayments", "", "context", "Landroid/content/Context;", "features", "", "", "onResult", "Lcom/revenuecat/purchases/hybridcommon/OnResultAny;", "", "checkTrialOrIntroductoryPriceEligibility", "", "", "", "productIdentifiers", "configure", "apiKey", "appUserID", "observerMode", "platformInfo", "Lcom/revenuecat/purchases/common/PlatformInfo;", ProductResponseJsonKeys.STORE, "Lcom/revenuecat/purchases/Store;", "dangerousSettings", "Lcom/revenuecat/purchases/DangerousSettings;", "shouldShowInAppMessagesAutomatically", "verificationMode", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/revenuecat/purchases/common/PlatformInfo;Lcom/revenuecat/purchases/Store;Lcom/revenuecat/purchases/DangerousSettings;Ljava/lang/Boolean;Ljava/lang/String;)V", "errorLog", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "getAppUserID", "getCustomerInfo", "Lcom/revenuecat/purchases/hybridcommon/OnResult;", "getGoogleProrationMode", "Lcom/revenuecat/purchases/models/GoogleProrationMode;", "prorationModeInt", "(Ljava/lang/Integer;)Lcom/revenuecat/purchases/models/GoogleProrationMode;", "getOfferings", "getProductInfo", "productIDs", "type", "Lcom/revenuecat/purchases/hybridcommon/OnResultList;", "getPromotionalOffer", "Lcom/revenuecat/purchases/hybridcommon/ErrorContainer;", "getProxyURLString", "getPurchaseCompletedFunction", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/models/StoreTransaction;", "Lcom/revenuecat/purchases/CustomerInfo;", "getPurchaseErrorFunction", "Lcom/revenuecat/purchases/PurchasesError;", "invalidateCustomerInfoCache", "isAnonymous", "logIn", "logOut", "mapStringToProductType", "Lcom/revenuecat/purchases/ProductType;", "purchasePackage", "activity", "Landroid/app/Activity;", "packageIdentifier", "offeringIdentifier", "googleOldProductId", "googleProrationMode", "googleIsPersonalizedPrice", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/revenuecat/purchases/hybridcommon/OnResult;)V", "purchaseProduct", "productIdentifier", "googleBasePlanId", "presentedOfferingIdentifier", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Lcom/revenuecat/purchases/hybridcommon/OnResult;)V", "purchaseSubscriptionOption", "optionIdentifier", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Lcom/revenuecat/purchases/hybridcommon/OnResult;)V", "restorePurchases", "setAllowSharingAppStoreAccount", "allowSharingAppStoreAccount", "setDebugLogsEnabled", ViewProps.ENABLED, "setFinishTransactions", "setLogHandler", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "logDetails", "setLogHandlerWithOnResult", "setLogLevel", "level", "setProxyURLString", "proxyURLString", "showInAppMessagesIfNeeded", "inAppMessageTypes", "Lcom/revenuecat/purchases/models/InAppMessageType;", "syncPurchases", "warnLog", "applyOfferingIdentifier", "Lcom/revenuecat/purchases/models/StoreProduct;", "hybridcommon_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class CommonKt {
    public static final void configure(Context context, String apiKey, String str, Boolean bool, PlatformInfo platformInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(platformInfo, "platformInfo");
        configure$default(context, apiKey, str, bool, platformInfo, null, null, null, null, 480, null);
    }

    public static final void configure(Context context, String apiKey, String str, Boolean bool, PlatformInfo platformInfo, Store store) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(platformInfo, "platformInfo");
        Intrinsics.checkNotNullParameter(store, "store");
        configure$default(context, apiKey, str, bool, platformInfo, store, null, null, null, 448, null);
    }

    public static final void configure(Context context, String apiKey, String str, Boolean bool, PlatformInfo platformInfo, Store store, DangerousSettings dangerousSettings) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(platformInfo, "platformInfo");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(dangerousSettings, "dangerousSettings");
        configure$default(context, apiKey, str, bool, platformInfo, store, dangerousSettings, null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null);
    }

    public static final void configure(Context context, String apiKey, String str, Boolean bool, PlatformInfo platformInfo, Store store, DangerousSettings dangerousSettings, Boolean bool2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(platformInfo, "platformInfo");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(dangerousSettings, "dangerousSettings");
        configure$default(context, apiKey, str, bool, platformInfo, store, dangerousSettings, bool2, null, 256, null);
    }

    public static final void showInAppMessagesIfNeeded(Activity activity) {
        showInAppMessagesIfNeeded$default(activity, null, 2, null);
    }

    @Deprecated(message = "Replaced with configuration in the RevenueCat dashboard", replaceWith = @ReplaceWith(expression = "configure through the RevenueCat dashboard", imports = {}))
    public static final void setAllowSharingAppStoreAccount(boolean z) {
        Purchases.INSTANCE.getSharedInstance().setAllowSharingPlayStoreAccount(z);
    }

    public static final void getOfferings(final OnResult onResult) {
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        ListenerConversionsCommonKt.getOfferingsWith(Purchases.INSTANCE.getSharedInstance(), new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$getOfferings$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                OnResult.this.onError(PurchasesErrorKt.map$default(it, null, 1, null));
            }
        }, new Function1<Offerings, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$getOfferings$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offerings offerings) {
                invoke2(offerings);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Offerings it) {
                Intrinsics.checkNotNullParameter(it, "it");
                OnResult.this.onReceived(OfferingsMapperKt.map(it));
            }
        });
    }

    public static final void getProductInfo(List<String> productIDs, String type, final OnResultList onResult) {
        Intrinsics.checkNotNullParameter(productIDs, "productIDs");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        Function1<PurchasesError, Unit> function1 = new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$getProductInfo$onError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                OnResultList.this.onError(PurchasesErrorKt.map$default(it, null, 1, null));
            }
        };
        Function1<List<? extends StoreProduct>, Unit> function12 = new Function1<List<? extends StoreProduct>, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$getProductInfo$onReceived$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreProduct> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends StoreProduct> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                OnResultList.this.onReceived(StoreProductMapperKt.map(it));
            }
        };
        if (mapStringToProductType(type) == ProductType.SUBS) {
            ListenerConversionsCommonKt.getProductsWith(Purchases.INSTANCE.getSharedInstance(), productIDs, ProductType.SUBS, function1, function12);
        } else {
            ListenerConversionsCommonKt.getProductsWith(Purchases.INSTANCE.getSharedInstance(), productIDs, ProductType.INAPP, function1, function12);
        }
    }

    public static final void purchaseProduct(final Activity activity, final String productIdentifier, String type, final String str, final String str2, Integer num, final Boolean bool, final String str3, final OnResult onResult) {
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        try {
            final GoogleProrationMode googleProrationMode = getGoogleProrationMode(num);
            final ProductType mapStringToProductType = mapStringToProductType(type);
            if (activity != null) {
                Function1<List<? extends StoreProduct>, Unit> function1 = new Function1<List<? extends StoreProduct>, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$purchaseProduct$onReceiveStoreProducts$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreProduct> list) {
                        invoke2(list);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:23:0x0066 A[EDGE_INSN: B:23:0x0066->B:24:0x0066 BREAK  A[LOOP:0: B:2:0x0011->B:44:?], SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:44:? A[LOOP:0: B:2:0x0011->B:44:?, LOOP_END, SYNTHETIC] */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke2(java.util.List<? extends com.revenuecat.purchases.models.StoreProduct> r11) {
                        /*
                            r10 = this;
                            java.lang.String r0 = "storeProducts"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                            java.lang.Iterable r11 = (java.lang.Iterable) r11
                            java.lang.String r0 = r7
                            com.revenuecat.purchases.ProductType r1 = r8
                            java.lang.String r2 = r9
                            java.util.Iterator r11 = r11.iterator()
                        L11:
                            boolean r3 = r11.hasNext()
                            r4 = 1
                            r5 = 0
                            if (r3 == 0) goto L65
                            java.lang.Object r3 = r11.next()
                            r6 = r3
                            com.revenuecat.purchases.models.StoreProduct r6 = (com.revenuecat.purchases.models.StoreProduct) r6
                            java.lang.String r7 = r6.getId()
                            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r0)
                            r8 = 0
                            if (r7 == 0) goto L33
                            com.revenuecat.purchases.ProductType r7 = r6.getType()
                            if (r7 != r1) goto L33
                            r7 = r4
                            goto L34
                        L33:
                            r7 = r8
                        L34:
                            com.revenuecat.purchases.models.PurchasingData r9 = r6.getPurchasingData()
                            java.lang.String r9 = r9.getProductId()
                            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r0)
                            if (r9 == 0) goto L5c
                            com.revenuecat.purchases.models.GoogleStoreProduct r9 = com.revenuecat.purchases.models.GoogleStoreProductKt.getGoogleProduct(r6)
                            if (r9 == 0) goto L4d
                            java.lang.String r9 = r9.getBasePlanId()
                            goto L4e
                        L4d:
                            r9 = r5
                        L4e:
                            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r2)
                            if (r9 == 0) goto L5c
                            com.revenuecat.purchases.ProductType r6 = r6.getType()
                            if (r6 != r1) goto L5c
                            r6 = r4
                            goto L5d
                        L5c:
                            r6 = r8
                        L5d:
                            if (r7 != 0) goto L61
                            if (r6 == 0) goto L62
                        L61:
                            r8 = r4
                        L62:
                            if (r8 == 0) goto L11
                            goto L66
                        L65:
                            r3 = r5
                        L66:
                            com.revenuecat.purchases.models.StoreProduct r3 = (com.revenuecat.purchases.models.StoreProduct) r3
                            if (r3 == 0) goto L71
                            java.lang.String r11 = r1
                            com.revenuecat.purchases.models.StoreProduct r11 = com.revenuecat.purchases.hybridcommon.CommonKt.access$applyOfferingIdentifier(r3, r11)
                            goto L72
                        L71:
                            r11 = r5
                        L72:
                            if (r11 == 0) goto Lbc
                            com.revenuecat.purchases.PurchaseParams$Builder r0 = new com.revenuecat.purchases.PurchaseParams$Builder
                            android.app.Activity r1 = r2
                            r0.<init>(r1, r11)
                            java.lang.String r11 = r3
                            if (r11 == 0) goto L94
                            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
                            boolean r11 = kotlin.text.StringsKt.isBlank(r11)
                            r11 = r11 ^ r4
                            if (r11 == 0) goto L94
                            java.lang.String r11 = r3
                            r0.oldProductId(r11)
                            com.revenuecat.purchases.models.GoogleProrationMode r11 = r4
                            if (r11 == 0) goto L94
                            r0.googleProrationMode(r11)
                        L94:
                            java.lang.Boolean r11 = r5
                            if (r11 == 0) goto La2
                            r11.booleanValue()
                            boolean r11 = r11.booleanValue()
                            r0.isPersonalizedPrice(r11)
                        La2:
                            com.revenuecat.purchases.Purchases$Companion r11 = com.revenuecat.purchases.Purchases.INSTANCE
                            com.revenuecat.purchases.Purchases r11 = r11.getSharedInstance()
                            com.revenuecat.purchases.PurchaseParams r0 = r0.build()
                            com.revenuecat.purchases.hybridcommon.OnResult r1 = r6
                            kotlin.jvm.functions.Function2 r1 = com.revenuecat.purchases.hybridcommon.CommonKt.access$getPurchaseErrorFunction(r1)
                            com.revenuecat.purchases.hybridcommon.OnResult r2 = r6
                            kotlin.jvm.functions.Function2 r2 = com.revenuecat.purchases.hybridcommon.CommonKt.access$getPurchaseCompletedFunction(r2)
                            com.revenuecat.purchases.ListenerConversionsCommonKt.purchaseWith(r11, r0, r1, r2)
                            goto Ldc
                        Lbc:
                            com.revenuecat.purchases.hybridcommon.OnResult r11 = r6
                            com.revenuecat.purchases.PurchasesError r0 = new com.revenuecat.purchases.PurchasesError
                            com.revenuecat.purchases.PurchasesErrorCode r1 = com.revenuecat.purchases.PurchasesErrorCode.ProductNotAvailableForPurchaseError
                            java.lang.StringBuilder r2 = new java.lang.StringBuilder
                            java.lang.String r3 = "Couldn't find product "
                            r2.<init>(r3)
                            java.lang.String r3 = r7
                            r2.append(r3)
                            java.lang.String r2 = r2.toString()
                            r0.<init>(r1, r2)
                            com.revenuecat.purchases.hybridcommon.ErrorContainer r0 = com.revenuecat.purchases.hybridcommon.mappers.PurchasesErrorKt.map$default(r0, r5, r4, r5)
                            r11.onError(r0)
                        Ldc:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.hybridcommon.CommonKt$purchaseProduct$onReceiveStoreProducts$1.invoke2(java.util.List):void");
                    }
                };
                if (mapStringToProductType == ProductType.SUBS) {
                    ListenerConversionsCommonKt.getProductsWith(Purchases.INSTANCE.getSharedInstance(), CollectionsKt.listOf((String) CollectionsKt.first(StringsKt.split$default((CharSequence) productIdentifier, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null))), ProductType.SUBS, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$purchaseProduct$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                            invoke2(purchasesError);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(PurchasesError it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            OnResult.this.onError(PurchasesErrorKt.map$default(it, null, 1, null));
                        }
                    }, function1);
                    return;
                } else {
                    ListenerConversionsCommonKt.getProductsWith(Purchases.INSTANCE.getSharedInstance(), CollectionsKt.listOf(productIdentifier), ProductType.INAPP, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$purchaseProduct$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                            invoke2(purchasesError);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(PurchasesError it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            OnResult.this.onError(PurchasesErrorKt.map$default(it, null, 1, null));
                        }
                    }, function1);
                    return;
                }
            }
            onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, "There is no current Activity"), null, 1, null));
        } catch (InvalidProrationModeException unused) {
            onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.UnknownError, "Invalid google proration mode passed to purchaseProduct."), null, 1, null));
        }
    }

    public static final void purchasePackage(final Activity activity, final String packageIdentifier, final String offeringIdentifier, final String str, Integer num, final Boolean bool, final OnResult onResult) {
        Intrinsics.checkNotNullParameter(packageIdentifier, "packageIdentifier");
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        try {
            final GoogleProrationMode googleProrationMode = getGoogleProrationMode(num);
            if (activity != null) {
                ListenerConversionsCommonKt.getOfferingsWith(Purchases.INSTANCE.getSharedInstance(), new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$purchasePackage$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                        invoke2(purchasesError);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PurchasesError it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        OnResult.this.onError(PurchasesErrorKt.map$default(it, null, 1, null));
                    }
                }, new Function1<Offerings, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$purchasePackage$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Offerings offerings) {
                        invoke2(offerings);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Offerings offerings) {
                        Package r3;
                        Function2 purchaseErrorFunction;
                        Function2 purchaseCompletedFunction;
                        List<Package> availablePackages;
                        Object obj;
                        Intrinsics.checkNotNullParameter(offerings, "offerings");
                        Offering offering = offerings.get(offeringIdentifier);
                        if (offering == null || (availablePackages = offering.getAvailablePackages()) == null) {
                            r3 = null;
                        } else {
                            String str2 = packageIdentifier;
                            Iterator<T> it = availablePackages.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    obj = null;
                                    break;
                                } else {
                                    obj = it.next();
                                    if (StringsKt.equals(((Package) obj).getIdentifier(), str2, true)) {
                                        break;
                                    }
                                }
                            }
                            r3 = (Package) obj;
                        }
                        if (r3 != null) {
                            PurchaseParams.Builder builder = new PurchaseParams.Builder(activity, r3);
                            String str3 = str;
                            if (str3 != null && (true ^ StringsKt.isBlank(str3))) {
                                builder.oldProductId(str);
                                GoogleProrationMode googleProrationMode2 = googleProrationMode;
                                if (googleProrationMode2 != null) {
                                    builder.googleProrationMode(googleProrationMode2);
                                }
                            }
                            Boolean bool2 = bool;
                            if (bool2 != null) {
                                bool2.booleanValue();
                                builder.isPersonalizedPrice(bool2.booleanValue());
                            }
                            Purchases sharedInstance = Purchases.INSTANCE.getSharedInstance();
                            PurchaseParams build = builder.build();
                            purchaseErrorFunction = CommonKt.getPurchaseErrorFunction(onResult);
                            purchaseCompletedFunction = CommonKt.getPurchaseCompletedFunction(onResult);
                            ListenerConversionsCommonKt.purchaseWith(sharedInstance, build, purchaseErrorFunction, purchaseCompletedFunction);
                            return;
                        }
                        onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, "Couldn't find product for package " + packageIdentifier), null, 1, null));
                    }
                });
            } else {
                onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, "There is no current Activity"), null, 1, null));
            }
        } catch (InvalidProrationModeException unused) {
            onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.UnknownError, "Invalid google proration mode passed to purchasePackage."), null, 1, null));
        }
    }

    public static final void purchaseSubscriptionOption(final Activity activity, final String productIdentifier, final String optionIdentifier, final String str, Integer num, final Boolean bool, final String str2, final OnResult onResult) {
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(optionIdentifier, "optionIdentifier");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        if (Purchases.INSTANCE.getSharedInstance().getStore() != Store.PLAY_STORE) {
            onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.UnknownError, "purchaseSubscriptionOption() is only supported on the Play Store."), null, 1, null));
            return;
        }
        try {
            final GoogleProrationMode googleProrationMode = getGoogleProrationMode(num);
            if (activity != null) {
                ListenerConversionsCommonKt.getProductsWith(Purchases.INSTANCE.getSharedInstance(), CollectionsKt.listOf(productIdentifier), ProductType.SUBS, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$purchaseSubscriptionOption$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                        invoke2(purchasesError);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PurchasesError it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        OnResult.this.onError(PurchasesErrorKt.map$default(it, null, 1, null));
                    }
                }, new Function1<List<? extends StoreProduct>, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$purchaseSubscriptionOption$onReceiveStoreProducts$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreProduct> list) {
                        invoke2(list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<? extends StoreProduct> storeProducts) {
                        SubscriptionOption subscriptionOption;
                        Function2 purchaseErrorFunction;
                        Function2 purchaseCompletedFunction;
                        StoreProduct applyOfferingIdentifier;
                        SubscriptionOption subscriptionOption2;
                        Intrinsics.checkNotNullParameter(storeProducts, "storeProducts");
                        String str3 = str2;
                        String str4 = productIdentifier;
                        String str5 = optionIdentifier;
                        Iterator<T> it = storeProducts.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                subscriptionOption = null;
                                break;
                            }
                            StoreProduct storeProduct = (StoreProduct) it.next();
                            applyOfferingIdentifier = CommonKt.applyOfferingIdentifier(storeProduct, str3);
                            SubscriptionOptions subscriptionOptions = applyOfferingIdentifier.getSubscriptionOptions();
                            if (subscriptionOptions != null) {
                                Iterator<SubscriptionOption> it2 = subscriptionOptions.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        subscriptionOption2 = null;
                                        break;
                                    } else {
                                        subscriptionOption2 = it2.next();
                                        if (Intrinsics.areEqual(storeProduct.getPurchasingData().getProductId(), str4) && Intrinsics.areEqual(subscriptionOption2.getId(), str5)) {
                                            break;
                                        }
                                    }
                                }
                                subscriptionOption = subscriptionOption2;
                            } else {
                                subscriptionOption = null;
                            }
                            if (subscriptionOption != null) {
                                break;
                            }
                        }
                        if (subscriptionOption != null) {
                            PurchaseParams.Builder builder = new PurchaseParams.Builder(activity, subscriptionOption);
                            String str6 = str;
                            String str7 = str6;
                            String str8 = str7 == null || StringsKt.isBlank(str7) ? null : str6;
                            if (str8 != null) {
                                GoogleProrationMode googleProrationMode2 = googleProrationMode;
                                builder.oldProductId(str8);
                                if (googleProrationMode2 != null) {
                                    builder.googleProrationMode(googleProrationMode2);
                                }
                            }
                            Boolean bool2 = bool;
                            if (bool2 != null) {
                                bool2.booleanValue();
                                builder.isPersonalizedPrice(bool2.booleanValue());
                            }
                            Purchases sharedInstance = Purchases.INSTANCE.getSharedInstance();
                            PurchaseParams build = builder.build();
                            purchaseErrorFunction = CommonKt.getPurchaseErrorFunction(onResult);
                            purchaseCompletedFunction = CommonKt.getPurchaseCompletedFunction(onResult);
                            ListenerConversionsCommonKt.purchaseWith(sharedInstance, build, purchaseErrorFunction, purchaseCompletedFunction);
                            return;
                        }
                        onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, "Couldn't find product " + productIdentifier + AbstractJsonLexerKt.COLON + optionIdentifier), null, 1, null));
                    }
                });
            } else {
                onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, "There is no current Activity"), null, 1, null));
            }
        } catch (InvalidProrationModeException unused) {
            onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.UnknownError, "Invalid google proration mode passed to purchaseSubscriptionOption."), null, 1, null));
        }
    }

    public static final String getAppUserID() {
        return Purchases.INSTANCE.getSharedInstance().getAppUserID();
    }

    public static final void restorePurchases(final OnResult onResult) {
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        ListenerConversionsCommonKt.restorePurchasesWith(Purchases.INSTANCE.getSharedInstance(), new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$restorePurchases$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                OnResult.this.onError(PurchasesErrorKt.map$default(it, null, 1, null));
            }
        }, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$restorePurchases$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                invoke2(customerInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CustomerInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                OnResult.this.onReceived(CustomerInfoMapperKt.map(it));
            }
        });
    }

    public static final void logIn(String appUserID, final OnResult onResult) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        ListenerConversionsKt.logInWith(Purchases.INSTANCE.getSharedInstance(), appUserID, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$logIn$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                OnResult.this.onError(PurchasesErrorKt.map$default(it, null, 1, null));
            }
        }, new Function2<CustomerInfo, Boolean, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$logIn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo, Boolean bool) {
                invoke(customerInfo, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(CustomerInfo customerInfo, boolean z) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                OnResult.this.onReceived(MapsKt.mapOf(TuplesKt.to("customerInfo", CustomerInfoMapperKt.map(customerInfo)), TuplesKt.to("created", Boolean.valueOf(z))));
            }
        });
    }

    public static final void logOut(final OnResult onResult) {
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        ListenerConversionsKt.logOutWith(Purchases.INSTANCE.getSharedInstance(), new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$logOut$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                OnResult.this.onError(PurchasesErrorKt.map$default(it, null, 1, null));
            }
        }, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$logOut$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                invoke2(customerInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CustomerInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                OnResult.this.onReceived(CustomerInfoMapperKt.map(it));
            }
        });
    }

    @Deprecated(message = "Use setLogLevel instead")
    public static final void setDebugLogsEnabled(boolean z) {
        Purchases.INSTANCE.setDebugLogsEnabled(z);
    }

    public static final void setLogLevel(String level) {
        Intrinsics.checkNotNullParameter(level, "level");
        try {
            Purchases.INSTANCE.setLogLevel(LogLevel.valueOf(level));
        } catch (IllegalArgumentException unused) {
            warnLog("Unrecognized log level: " + level);
        }
    }

    public static final void setLogHandler(Function1<? super Map<String, String>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Purchases.INSTANCE.setLogHandler(new LogHandlerWithMapping(callback));
    }

    public static final void setLogHandlerWithOnResult(final OnResult onResult) {
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        setLogHandler(new Function1<Map<String, ? extends String>, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$setLogHandlerWithOnResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> map) {
                invoke2((Map<String, String>) map);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, String> logDetails) {
                Intrinsics.checkNotNullParameter(logDetails, "logDetails");
                OnResult.this.onReceived(logDetails);
            }
        });
    }

    public static final void setProxyURLString(String str) {
        Purchases.INSTANCE.setProxyURL(str != null ? new URL(str) : null);
    }

    public static final String getProxyURLString() {
        return String.valueOf(Purchases.INSTANCE.getProxyURL());
    }

    public static final void getCustomerInfo(final OnResult onResult) {
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        ListenerConversionsKt.getCustomerInfoWith(Purchases.INSTANCE.getSharedInstance(), new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$getCustomerInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                OnResult.this.onError(PurchasesErrorKt.map$default(it, null, 1, null));
            }
        }, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$getCustomerInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                invoke2(customerInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CustomerInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                OnResult.this.onReceived(CustomerInfoMapperKt.map(it));
            }
        });
    }

    public static final void syncPurchases() {
        Purchases.syncPurchases$default(Purchases.INSTANCE.getSharedInstance(), null, 1, null);
    }

    public static final boolean isAnonymous() {
        return Purchases.INSTANCE.getSharedInstance().isAnonymous();
    }

    public static final void setFinishTransactions(boolean z) {
        Purchases.INSTANCE.getSharedInstance().setFinishTransactions(z);
    }

    public static final Map<String, Map<String, Object>> checkTrialOrIntroductoryPriceEligibility(List<String> productIdentifiers) {
        Intrinsics.checkNotNullParameter(productIdentifiers, "productIdentifiers");
        List<String> list = productIdentifiers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(TuplesKt.to((String) it.next(), MapsKt.mapOf(TuplesKt.to("status", 0), TuplesKt.to(b.c, "Status indeterminate."))));
        }
        return MapsKt.toMap(arrayList);
    }

    public static final void invalidateCustomerInfoCache() {
        Purchases.INSTANCE.getSharedInstance().invalidateCustomerInfoCache();
    }

    public static final void canMakePayments(Context context, List<Integer> features, final OnResultAny<Boolean> onResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        ArrayList arrayList = new ArrayList();
        try {
            BillingFeature[] values = BillingFeature.values();
            List<Integer> list = features;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(values[((Number) it.next()).intValue()]);
            }
            arrayList.addAll(arrayList2);
            Purchases.INSTANCE.canMakePayments(context, arrayList, new Callback() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$$ExternalSyntheticLambda0
                @Override // com.revenuecat.purchases.interfaces.Callback
                public final void onReceived(Object obj) {
                    CommonKt.canMakePayments$lambda$2(OnResultAny.this, (Boolean) obj);
                }
            });
        } catch (IndexOutOfBoundsException unused) {
            onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.UnknownError, "Invalid feature type passed to canMakePayments."), null, 1, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void canMakePayments$lambda$2(OnResultAny onResult, Boolean it) {
        Intrinsics.checkNotNullParameter(onResult, "$onResult");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        onResult.onReceived(it);
    }

    public static /* synthetic */ void showInAppMessagesIfNeeded$default(Activity activity, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        showInAppMessagesIfNeeded(activity, list);
    }

    public static final void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> list) {
        if (activity == null) {
            errorLog("showInAppMessages called with null activity");
        } else if (list == null) {
            Purchases.showInAppMessagesIfNeeded$default(Purchases.INSTANCE.getSharedInstance(), activity, null, 2, null);
        } else {
            Purchases.INSTANCE.getSharedInstance().showInAppMessagesIfNeeded(activity, list);
        }
    }

    public static /* synthetic */ void configure$default(Context context, String str, String str2, Boolean bool, PlatformInfo platformInfo, Store store, DangerousSettings dangerousSettings, Boolean bool2, String str3, int i, Object obj) {
        configure(context, str, str2, bool, platformInfo, (i & 32) != 0 ? Store.PLAY_STORE : store, (i & 64) != 0 ? new DangerousSettings(true) : dangerousSettings, (i & 128) != 0 ? null : bool2, (i & 256) != 0 ? null : str3);
    }

    public static final void configure(Context context, String apiKey, String str, Boolean bool, PlatformInfo platformInfo, Store store, DangerousSettings dangerousSettings, Boolean bool2, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(platformInfo, "platformInfo");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(dangerousSettings, "dangerousSettings");
        Purchases.INSTANCE.setPlatformInfo(platformInfo);
        PurchasesConfiguration.Builder dangerousSettings2 = new PurchasesConfiguration.Builder(context, apiKey).appUserID(str).store(store).dangerousSettings(dangerousSettings);
        if (bool != null) {
            dangerousSettings2.observerMode(bool.booleanValue());
        }
        if (bool2 != null) {
            dangerousSettings2.showInAppMessagesAutomatically(bool2.booleanValue());
        }
        if (str2 != null) {
            try {
                dangerousSettings2.entitlementVerificationMode(EntitlementVerificationMode.valueOf(str2));
            } catch (IllegalArgumentException unused) {
                warnLog("Attempted to configure with unknown verification mode: " + str2 + '.');
            }
        }
        Purchases.INSTANCE.configure(dangerousSettings2.build());
    }

    public static final ErrorContainer getPromotionalOffer() {
        return new ErrorContainer(PurchasesErrorCode.UnsupportedError.getCode(), "Android platform doesn't support promotional offers", MapsKt.emptyMap());
    }

    public static final ProductType mapStringToProductType(String type) {
        MappedProductCategory mappedProductCategory;
        Intrinsics.checkNotNullParameter(type, "type");
        MappedProductCategory[] values = MappedProductCategory.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                mappedProductCategory = null;
                break;
            }
            mappedProductCategory = values[i];
            if (StringsKt.equals(mappedProductCategory.getValue(), type, true)) {
                break;
            }
            i++;
        }
        if (mappedProductCategory != null) {
            return mappedProductCategory.getToProductType();
        }
        String lowerCase = type.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (Intrinsics.areEqual(lowerCase, "subs")) {
            return ProductType.SUBS;
        }
        if (Intrinsics.areEqual(lowerCase, "inapp")) {
            return ProductType.INAPP;
        }
        warnLog("Unrecognized product type: " + type + "... Defaulting to INAPP");
        return ProductType.INAPP;
    }

    public static final GoogleProrationMode getGoogleProrationMode(Integer num) throws InvalidProrationModeException {
        GoogleProrationMode googleProrationMode = null;
        if (num != null) {
            int intValue = num.intValue();
            GoogleProrationMode[] values = GoogleProrationMode.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                GoogleProrationMode googleProrationMode2 = values[i];
                if (googleProrationMode2.getPlayBillingClientMode() == intValue) {
                    googleProrationMode = googleProrationMode2;
                    break;
                }
                i++;
            }
            if (googleProrationMode == null) {
                throw new InvalidProrationModeException();
            }
        }
        return googleProrationMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StoreProduct applyOfferingIdentifier(StoreProduct storeProduct, String str) {
        StoreProduct copyWithOfferingId;
        return (str == null || (copyWithOfferingId = storeProduct.copyWithOfferingId(str)) == null) ? storeProduct : copyWithOfferingId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<PurchasesError, Boolean, Unit> getPurchaseErrorFunction(final OnResult onResult) {
        return new Function2<PurchasesError, Boolean, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$getPurchaseErrorFunction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, Boolean bool) {
                invoke(purchasesError, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PurchasesError error, boolean z) {
                Intrinsics.checkNotNullParameter(error, "error");
                OnResult.this.onError(PurchasesErrorKt.map(error, MapsKt.mapOf(TuplesKt.to("userCancelled", Boolean.valueOf(z)))));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<StoreTransaction, CustomerInfo, Unit> getPurchaseCompletedFunction(final OnResult onResult) {
        return new Function2<StoreTransaction, CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.hybridcommon.CommonKt$getPurchaseCompletedFunction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                invoke2(storeTransaction, customerInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                Unit unit;
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                if (storeTransaction != null) {
                    OnResult.this.onReceived(MapsKt.mapOf(TuplesKt.to("productIdentifier", storeTransaction.getProductIds().get(0)), TuplesKt.to("customerInfo", CustomerInfoMapperKt.map(customerInfo)), TuplesKt.to("transaction", StoreTransactionMapperKt.map(storeTransaction))));
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    OnResult.this.onError(new ErrorContainer(PurchasesErrorCode.UnsupportedError.getCode(), "Error purchasing. Null transaction returned from a successful non-upgrade purchase.", MapsKt.emptyMap()));
                }
            }
        };
    }

    public static final void warnLog(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (Purchases.INSTANCE.getLogLevel().compareTo(LogLevel.WARN) <= 0) {
            Log.w("PurchasesHybridCommon", message);
        }
    }

    public static final void errorLog(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (Purchases.INSTANCE.getLogLevel().compareTo(LogLevel.ERROR) <= 0) {
            Log.e("PurchasesHybridCommon", message);
        }
    }
}
