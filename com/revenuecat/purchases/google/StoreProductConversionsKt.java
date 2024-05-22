package com.revenuecat.purchases.google;

import com.android.billingclient.api.ProductDetails;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: storeProductConversions.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0002H\u0000\u001a\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000\u001a\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\b*\b\u0012\u0004\u0012\u00020\u00020\bH\u0000¨\u0006\u000b"}, d2 = {"createOneTimeProductPrice", "Lcom/revenuecat/purchases/models/Price;", "Lcom/android/billingclient/api/ProductDetails;", "toInAppStoreProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "toStoreProduct", "Lcom/revenuecat/purchases/models/GoogleStoreProduct;", "offerDetails", "", "Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;", "toStoreProducts", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class StoreProductConversionsKt {
    public static final StoreProduct toInAppStoreProduct(ProductDetails productDetails) {
        Intrinsics.checkNotNullParameter(productDetails, "<this>");
        return toStoreProduct(productDetails, CollectionsKt.emptyList());
    }

    public static final GoogleStoreProduct toStoreProduct(ProductDetails productDetails, List<ProductDetails.SubscriptionOfferDetails> offerDetails) {
        SubscriptionOptions subscriptionOptions;
        Price price;
        PricingPhase fullPricePhase;
        Intrinsics.checkNotNullParameter(productDetails, "<this>");
        Intrinsics.checkNotNullParameter(offerDetails, "offerDetails");
        if (ProductTypeConversionsKt.toRevenueCatProductType(productDetails.getProductType()) == ProductType.SUBS) {
            List<ProductDetails.SubscriptionOfferDetails> list = offerDetails;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails : list) {
                String productId = productDetails.getProductId();
                Intrinsics.checkNotNullExpressionValue(productId, "productId");
                arrayList.add(SubscriptionOptionConversionsKt.toSubscriptionOption(subscriptionOfferDetails, productId, productDetails));
            }
            subscriptionOptions = new SubscriptionOptions(arrayList);
        } else {
            subscriptionOptions = null;
        }
        SubscriptionOption basePlan = subscriptionOptions != null ? subscriptionOptions.getBasePlan() : null;
        Price price2 = (basePlan == null || (fullPricePhase = basePlan.getFullPricePhase()) == null) ? null : fullPricePhase.getPrice();
        Price createOneTimeProductPrice = createOneTimeProductPrice(productDetails);
        if (createOneTimeProductPrice != null) {
            price = createOneTimeProductPrice;
        } else {
            if (price2 == null) {
                return null;
            }
            price = price2;
        }
        String productId2 = productDetails.getProductId();
        Intrinsics.checkNotNullExpressionValue(productId2, "productId");
        String id = basePlan != null ? basePlan.getId() : null;
        ProductType revenueCatProductType = ProductTypeConversionsKt.toRevenueCatProductType(productDetails.getProductType());
        String name = productDetails.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        String title = productDetails.getTitle();
        Intrinsics.checkNotNullExpressionValue(title, "title");
        String description = productDetails.getDescription();
        Intrinsics.checkNotNullExpressionValue(description, "description");
        return new GoogleStoreProduct(productId2, id, revenueCatProductType, price, name, title, description, basePlan != null ? basePlan.getBillingPeriod() : null, subscriptionOptions, subscriptionOptions != null ? subscriptionOptions.getDefaultOffer() : null, productDetails, (PresentedOfferingContext) null);
    }

    private static final Price createOneTimeProductPrice(ProductDetails productDetails) {
        ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails;
        if (ProductTypeConversionsKt.toRevenueCatProductType(productDetails.getProductType()) != ProductType.INAPP || (oneTimePurchaseOfferDetails = productDetails.getOneTimePurchaseOfferDetails()) == null) {
            return null;
        }
        String formattedPrice = oneTimePurchaseOfferDetails.getFormattedPrice();
        Intrinsics.checkNotNullExpressionValue(formattedPrice, "it.formattedPrice");
        long priceAmountMicros = oneTimePurchaseOfferDetails.getPriceAmountMicros();
        String priceCurrencyCode = oneTimePurchaseOfferDetails.getPriceCurrencyCode();
        Intrinsics.checkNotNullExpressionValue(priceCurrencyCode, "it.priceCurrencyCode");
        return new Price(formattedPrice, priceAmountMicros, priceCurrencyCode);
    }

    public static final List<StoreProduct> toStoreProducts(List<ProductDetails> list) {
        ArrayList emptyList;
        LinkedHashMap emptyMap;
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (ProductDetails productDetails : list) {
            List<ProductDetails.SubscriptionOfferDetails> subscriptionOfferDetails = productDetails.getSubscriptionOfferDetails();
            if (subscriptionOfferDetails == null) {
                emptyList = CollectionsKt.emptyList();
            } else {
                Intrinsics.checkNotNullExpressionValue(subscriptionOfferDetails, "subscriptionOfferDetails");
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : subscriptionOfferDetails) {
                    ProductDetails.SubscriptionOfferDetails it = (ProductDetails.SubscriptionOfferDetails) obj;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (SubscriptionOptionConversionsKt.isBasePlan(it)) {
                        arrayList2.add(obj);
                    }
                }
                emptyList = arrayList2;
            }
            List<ProductDetails.SubscriptionOfferDetails> subscriptionOfferDetails2 = productDetails.getSubscriptionOfferDetails();
            if (subscriptionOfferDetails2 == null) {
                emptyMap = MapsKt.emptyMap();
            } else {
                Intrinsics.checkNotNullExpressionValue(subscriptionOfferDetails2, "subscriptionOfferDetails");
                emptyMap = new LinkedHashMap();
                for (Object obj2 : subscriptionOfferDetails2) {
                    String basePlanId = ((ProductDetails.SubscriptionOfferDetails) obj2).getBasePlanId();
                    Object obj3 = emptyMap.get(basePlanId);
                    if (obj3 == null) {
                        obj3 = (List) new ArrayList();
                        emptyMap.put(basePlanId, obj3);
                    }
                    ((List) obj3).add(obj2);
                }
            }
            if (emptyList.isEmpty()) {
                emptyList = null;
            }
            if (emptyList == null) {
                StoreProduct inAppStoreProduct = toInAppStoreProduct(productDetails);
                if (inAppStoreProduct != null) {
                    arrayList.add(inAppStoreProduct);
                } else {
                    LogIntent logIntent = LogIntent.RC_ERROR;
                    String format = String.format(PurchaseStrings.INVALID_PRODUCT_NO_PRICE, Arrays.copyOf(new Object[]{productDetails.getProductId()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                    LogWrapperKt.log(logIntent, format);
                }
            } else {
                Iterator it2 = emptyList.iterator();
                while (it2.hasNext()) {
                    List list2 = (List) emptyMap.get(((ProductDetails.SubscriptionOfferDetails) it2.next()).getBasePlanId());
                    if (list2 == null) {
                        list2 = CollectionsKt.emptyList();
                    }
                    GoogleStoreProduct storeProduct = toStoreProduct(productDetails, list2);
                    if (storeProduct != null) {
                        arrayList.add(storeProduct);
                    } else {
                        LogIntent logIntent2 = LogIntent.RC_ERROR;
                        String format2 = String.format(PurchaseStrings.INVALID_PRODUCT_NO_PRICE, Arrays.copyOf(new Object[]{productDetails.getProductId()}, 1));
                        Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
                        LogWrapperKt.log(logIntent2, format2);
                    }
                }
            }
        }
        return arrayList;
    }
}
