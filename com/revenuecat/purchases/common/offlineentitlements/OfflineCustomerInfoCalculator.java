package com.revenuecat.purchases.common.offlineentitlements;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.onesignal.common.modeling.ModelChangeTags;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.CustomerInfoFactory;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.revenuecat.purchases.common.responses.EntitlementsResponseJsonKeys;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.strings.CustomerInfoStrings;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import com.revenuecat.purchases.utils.Iso8601Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: OfflineCustomerInfoCalculator.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J6\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00120\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120\u0014J\u0010\u0010\u0017\u001a\n \u0018*\u0004\u0018\u00010\u00010\u0001H\u0002J\u0016\u0010\u0019\u001a\u00020\u001a2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0016\u0010\u001b\u001a\u00020\u001a2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/common/offlineentitlements/OfflineCustomerInfoCalculator;", "", "purchasedProductsFetcher", "Lcom/revenuecat/purchases/common/offlineentitlements/PurchasedProductsFetcher;", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Lcom/revenuecat/purchases/common/offlineentitlements/PurchasedProductsFetcher;Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/DateProvider;)V", "buildCustomerInfoUsingListOfPurchases", "Lcom/revenuecat/purchases/CustomerInfo;", "appUserID", "", "purchasedProducts", "", "Lcom/revenuecat/purchases/common/offlineentitlements/PurchasedProduct;", "calculateOriginalPurchaseDate", "computeOfflineCustomerInfo", "", "onSuccess", "Lkotlin/Function1;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "determineManagementURL", "kotlin.jvm.PlatformType", "generateEntitlementsResponse", "Lorg/json/JSONObject;", "generateSubscriptions", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class OfflineCustomerInfoCalculator {
    private final AppConfig appConfig;
    private final DateProvider dateProvider;
    private final PurchasedProductsFetcher purchasedProductsFetcher;

    public OfflineCustomerInfoCalculator(PurchasedProductsFetcher purchasedProductsFetcher, AppConfig appConfig, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(purchasedProductsFetcher, "purchasedProductsFetcher");
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.purchasedProductsFetcher = purchasedProductsFetcher;
        this.appConfig = appConfig;
        this.dateProvider = dateProvider;
    }

    public /* synthetic */ OfflineCustomerInfoCalculator(PurchasedProductsFetcher purchasedProductsFetcher, AppConfig appConfig, DefaultDateProvider defaultDateProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(purchasedProductsFetcher, appConfig, (i & 4) != 0 ? new DefaultDateProvider() : defaultDateProvider);
    }

    public final void computeOfflineCustomerInfo(final String appUserID, final Function1<? super CustomerInfo, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.purchasedProductsFetcher.queryActiveProducts(appUserID, new Function1<List<? extends PurchasedProduct>, Unit>() { // from class: com.revenuecat.purchases.common.offlineentitlements.OfflineCustomerInfoCalculator$computeOfflineCustomerInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends PurchasedProduct> list) {
                invoke2((List<PurchasedProduct>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<PurchasedProduct> purchasedProducts) {
                boolean z;
                CustomerInfo buildCustomerInfoUsingListOfPurchases;
                Intrinsics.checkNotNullParameter(purchasedProducts, "purchasedProducts");
                List<PurchasedProduct> list = purchasedProducts;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (((PurchasedProduct) it.next()).getStoreTransaction().getType() == ProductType.INAPP) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    buildCustomerInfoUsingListOfPurchases = this.buildCustomerInfoUsingListOfPurchases(appUserID, purchasedProducts);
                    onSuccess.invoke(buildCustomerInfoUsingListOfPurchases);
                    return;
                }
                PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.UnsupportedError, OfflineEntitlementsStrings.OFFLINE_ENTITLEMENTS_UNSUPPORTED_INAPP_PURCHASES);
                String format = String.format(CustomerInfoStrings.COMPUTING_OFFLINE_CUSTOMER_INFO_FAILED, Arrays.copyOf(new Object[]{purchasesError}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                LogUtilsKt.errorLog$default(format, null, 2, null);
                onError.invoke(purchasesError);
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.common.offlineentitlements.OfflineCustomerInfoCalculator$computeOfflineCustomerInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                String format = String.format(CustomerInfoStrings.COMPUTING_OFFLINE_CUSTOMER_INFO_FAILED, Arrays.copyOf(new Object[]{error}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                LogUtilsKt.errorLog$default(format, null, 2, null);
                onError.invoke(error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CustomerInfo buildCustomerInfoUsingListOfPurchases(String appUserID, List<PurchasedProduct> purchasedProducts) {
        JSONObject jSONObject = new JSONObject();
        Date now = this.dateProvider.getNow();
        String format = Iso8601Utils.format(now);
        jSONObject.put(CustomerInfoResponseJsonKeys.REQUEST_DATE, format);
        jSONObject.put(CustomerInfoResponseJsonKeys.REQUEST_DATE_MS, now.getTime());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(CustomerInfoResponseJsonKeys.ORIGINAL_APP_USER_ID, appUserID);
        jSONObject2.put(CustomerInfoResponseJsonKeys.ORIGINAL_APPLICATION_VERSION, "1.0");
        jSONObject2.put(CustomerInfoResponseJsonKeys.ENTITLEMENTS, generateEntitlementsResponse(purchasedProducts));
        jSONObject2.put(CustomerInfoResponseJsonKeys.FIRST_SEEN, format);
        jSONObject2.put("original_purchase_date", calculateOriginalPurchaseDate(purchasedProducts));
        jSONObject2.put(CustomerInfoResponseJsonKeys.NON_SUBSCRIPTIONS, new JSONObject());
        jSONObject2.put("subscriptions", generateSubscriptions(purchasedProducts));
        jSONObject2.put(CustomerInfoResponseJsonKeys.MANAGEMENT_URL, determineManagementURL());
        Unit unit = Unit.INSTANCE;
        jSONObject.put(CustomerInfoResponseJsonKeys.SUBSCRIBER, jSONObject2);
        return CustomerInfoFactory.INSTANCE.buildCustomerInfo(jSONObject, now, VerificationResult.VERIFIED_ON_DEVICE);
    }

    private final Object determineManagementURL() {
        return this.appConfig.getStore() == Store.PLAY_STORE ? Constants.GOOGLE_PLAY_MANAGEMENT_URL : JSONObject.NULL;
    }

    private final String calculateOriginalPurchaseDate(List<PurchasedProduct> purchasedProducts) {
        Long valueOf;
        Iterator<T> it = purchasedProducts.iterator();
        if (it.hasNext()) {
            valueOf = Long.valueOf(((PurchasedProduct) it.next()).getStoreTransaction().getPurchaseTime());
            while (it.hasNext()) {
                Long valueOf2 = Long.valueOf(((PurchasedProduct) it.next()).getStoreTransaction().getPurchaseTime());
                if (valueOf.compareTo(valueOf2) > 0) {
                    valueOf = valueOf2;
                }
            }
        } else {
            valueOf = null;
        }
        Long l = valueOf;
        if (l == null) {
            return null;
        }
        l.longValue();
        return ISO8601Utils.format(new Date(l.longValue()));
    }

    private final JSONObject generateSubscriptions(List<PurchasedProduct> purchasedProducts) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        for (PurchasedProduct purchasedProduct : purchasedProducts) {
            String productIdentifier = purchasedProduct.getProductIdentifier();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(ProductResponseJsonKeys.BILLING_ISSUES_DETECTED_AT, JSONObject.NULL);
            jSONObject2.put(ProductResponseJsonKeys.IS_SANDBOX, false);
            Date date = new Date(purchasedProduct.getStoreTransaction().getPurchaseTime());
            jSONObject2.put("original_purchase_date", Iso8601Utils.format(date));
            jSONObject2.put("purchase_date", Iso8601Utils.format(date));
            String lowerCase = this.appConfig.getStore().name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            jSONObject2.put(ProductResponseJsonKeys.STORE, lowerCase);
            jSONObject2.put(ProductResponseJsonKeys.UNSUBSCRIBE_DETECTED_AT, JSONObject.NULL);
            jSONObject2.put("product_plan_identifier", purchasedProduct.getBasePlanId());
            Date expiresDate = purchasedProduct.getExpiresDate();
            if (expiresDate == null || (obj = Iso8601Utils.format(expiresDate)) == null) {
                obj = JSONObject.NULL;
            }
            jSONObject2.put("expires_date", obj);
            String lowerCase2 = ModelChangeTags.NORMAL.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            jSONObject2.put(ProductResponseJsonKeys.PERIOD_TYPE, lowerCase2);
            Unit unit = Unit.INSTANCE;
            jSONObject.put(productIdentifier, jSONObject2);
        }
        return jSONObject;
    }

    private final JSONObject generateEntitlementsResponse(List<PurchasedProduct> purchasedProducts) {
        ArrayList<Pair> arrayList = new ArrayList();
        for (PurchasedProduct purchasedProduct : purchasedProducts) {
            List<String> entitlements = purchasedProduct.getEntitlements();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(entitlements, 10));
            Iterator<T> it = entitlements.iterator();
            while (it.hasNext()) {
                arrayList2.add(TuplesKt.to((String) it.next(), purchasedProduct));
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList) {
            String str = (String) pair.getFirst();
            Object obj = linkedHashMap.get(str);
            if (obj == null) {
                obj = (List) new ArrayList();
                linkedHashMap.put(str, obj);
            }
            ((List) obj).add((PurchasedProduct) pair.getSecond());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        Iterator it2 = linkedHashMap.entrySet().iterator();
        while (true) {
            Object obj2 = null;
            if (!it2.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it2.next();
            Object key = entry.getKey();
            List list = (List) entry.getValue();
            Iterator it3 = list.iterator();
            if (it3.hasNext()) {
                obj2 = it3.next();
                if (it3.hasNext()) {
                    Date expiresDate = ((PurchasedProduct) obj2).getExpiresDate();
                    long time = expiresDate != null ? expiresDate.getTime() : Long.MAX_VALUE;
                    do {
                        Object next = it3.next();
                        Date expiresDate2 = ((PurchasedProduct) next).getExpiresDate();
                        long time2 = expiresDate2 != null ? expiresDate2.getTime() : Long.MAX_VALUE;
                        if (time < time2) {
                            obj2 = next;
                            time = time2;
                        }
                    } while (it3.hasNext());
                }
            }
            PurchasedProduct purchasedProduct2 = (PurchasedProduct) obj2;
            if (purchasedProduct2 == null) {
                purchasedProduct2 = (PurchasedProduct) CollectionsKt.first(list);
            }
            linkedHashMap2.put(key, purchasedProduct2);
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            String str2 = (String) entry2.getKey();
            PurchasedProduct purchasedProduct3 = (PurchasedProduct) entry2.getValue();
            JSONObject jSONObject2 = new JSONObject();
            Date expiresDate3 = purchasedProduct3.getExpiresDate();
            jSONObject2.put("expires_date", expiresDate3 != null ? Iso8601Utils.format(expiresDate3) : null);
            jSONObject2.put(EntitlementsResponseJsonKeys.PRODUCT_IDENTIFIER, purchasedProduct3.getProductIdentifier());
            jSONObject2.put("purchase_date", Iso8601Utils.format(new Date(purchasedProduct3.getStoreTransaction().getPurchaseTime())));
            String basePlanId = purchasedProduct3.getBasePlanId();
            if (basePlanId != null) {
                jSONObject2.put("product_plan_identifier", basePlanId);
            }
            jSONObject.put(str2, jSONObject2);
        }
        return jSONObject;
    }
}
