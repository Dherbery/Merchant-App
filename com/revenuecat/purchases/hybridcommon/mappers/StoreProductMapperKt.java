package com.revenuecat.purchases.hybridcommon.mappers;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.OfferPaymentMode;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoreProductMapper.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%0$*\u00020\u0005\u001a$\u0010#\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%0$0&*\b\u0012\u0004\u0012\u00020\u00050&\u001a\u001c\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010$*\u00020\u0005H\u0001\u001a\u001c\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010$*\u00020\tH\u0002\u001a\u001c\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010$*\u00020\tH\u0002\u001a\u001a\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%0$*\u00020+H\u0002\u001a\u001a\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%0$*\u00020\rH\u0002\u001a\f\u0010-\u001a\u00020.*\u00020\u0005H\u0001\u001a\f\u0010/\u001a\u00020\u0011*\u00020\u0005H\u0001\u001a\"\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%0$*\u0002012\u0006\u00102\u001a\u00020\u0005H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0017\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u001a\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0017\u0010\u001b\u001a\u0004\u0018\u00010\t*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000b\"\u0015\u0010\u001d\u001a\u00020\u0015*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0017\"\u0015\u0010\u001f\u001a\u00020\u0011*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b \u0010\u0013\"\u0015\u0010!\u001a\u00020\u0011*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0013¨\u00063"}, d2 = {"DAYS_PER_WEEK", "", "MICROS_CONVERSION_METRIC", "", "freeTrialCycles", "Lcom/revenuecat/purchases/models/StoreProduct;", "getFreeTrialCycles", "(Lcom/revenuecat/purchases/models/StoreProduct;)Ljava/lang/Integer;", b.p, "Lcom/revenuecat/purchases/models/Period;", "getFreeTrialPeriod", "(Lcom/revenuecat/purchases/models/StoreProduct;)Lcom/revenuecat/purchases/models/Period;", "introductoryPhase", "Lcom/revenuecat/purchases/models/PricingPhase;", "getIntroductoryPhase", "(Lcom/revenuecat/purchases/models/StoreProduct;)Lcom/revenuecat/purchases/models/PricingPhase;", "introductoryPrice", "", "getIntroductoryPrice", "(Lcom/revenuecat/purchases/models/StoreProduct;)Ljava/lang/String;", "introductoryPriceAmountMicros", "", "getIntroductoryPriceAmountMicros", "(Lcom/revenuecat/purchases/models/StoreProduct;)J", "introductoryPriceCycles", "getIntroductoryPriceCycles", "(Lcom/revenuecat/purchases/models/StoreProduct;)I", "introductoryPricePeriod", "getIntroductoryPricePeriod", "priceAmountMicros", "getPriceAmountMicros", "priceCurrencyCode", "getPriceCurrencyCode", "priceString", "getPriceString", "map", "", "", "", "mapIntroPrice", "mapPeriod", "mapPeriodForStoreProduct", "mapPrice", "Lcom/revenuecat/purchases/models/Price;", "mapPricingPhase", "mapProductCategory", "Lcom/revenuecat/purchases/hybridcommon/mappers/MappedProductCategory;", "mapProductType", "mapSubscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "storeProduct", "hybridcommon_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class StoreProductMapperKt {
    private static final int DAYS_PER_WEEK = 7;
    private static final double MICROS_CONVERSION_METRIC = 1000000.0d;

    /* compiled from: StoreProductMapper.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ProductType.values().length];
            try {
                iArr[ProductType.INAPP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProductType.SUBS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProductType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Period.Unit.values().length];
            try {
                iArr2[Period.Unit.DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[Period.Unit.WEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[Period.Unit.MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[Period.Unit.YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[Period.Unit.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final long getPriceAmountMicros(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        return storeProduct.getPrice().getAmountMicros();
    }

    public static final String getPriceString(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        return storeProduct.getPrice().getFormatted();
    }

    public static final String getPriceCurrencyCode(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        return storeProduct.getPrice().getCurrencyCode();
    }

    public static final Period getFreeTrialPeriod(StoreProduct storeProduct) {
        PricingPhase freePhase;
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        if (defaultOption == null || (freePhase = defaultOption.getFreePhase()) == null) {
            return null;
        }
        return freePhase.getBillingPeriod();
    }

    public static final Integer getFreeTrialCycles(StoreProduct storeProduct) {
        PricingPhase freePhase;
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        if (defaultOption == null || (freePhase = defaultOption.getFreePhase()) == null) {
            return null;
        }
        return freePhase.getBillingCycleCount();
    }

    private static final PricingPhase getIntroductoryPhase(StoreProduct storeProduct) {
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        if (defaultOption != null) {
            return defaultOption.getIntroPhase();
        }
        return null;
    }

    public static final String getIntroductoryPrice(StoreProduct storeProduct) {
        Price price;
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        PricingPhase introductoryPhase = getIntroductoryPhase(storeProduct);
        if (introductoryPhase == null || (price = introductoryPhase.getPrice()) == null) {
            return null;
        }
        return price.getFormatted();
    }

    public static final Period getIntroductoryPricePeriod(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        PricingPhase introductoryPhase = getIntroductoryPhase(storeProduct);
        if (introductoryPhase != null) {
            return introductoryPhase.getBillingPeriod();
        }
        return null;
    }

    public static final long getIntroductoryPriceAmountMicros(StoreProduct storeProduct) {
        Price price;
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        PricingPhase introductoryPhase = getIntroductoryPhase(storeProduct);
        if (introductoryPhase == null || (price = introductoryPhase.getPrice()) == null) {
            return 0L;
        }
        return price.getAmountMicros();
    }

    public static final int getIntroductoryPriceCycles(StoreProduct storeProduct) {
        Integer billingCycleCount;
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        PricingPhase introductoryPhase = getIntroductoryPhase(storeProduct);
        if (introductoryPhase == null || (billingCycleCount = introductoryPhase.getBillingCycleCount()) == null) {
            return 0;
        }
        return billingCycleCount.intValue();
    }

    public static final Map<String, Object> map(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        Pair[] pairArr = new Pair[14];
        pairArr[0] = TuplesKt.to("identifier", storeProduct.getId());
        pairArr[1] = TuplesKt.to(b.c, storeProduct.getDescription());
        pairArr[2] = TuplesKt.to("title", storeProduct.getTitle());
        pairArr[3] = TuplesKt.to(b.x, Double.valueOf(getPriceAmountMicros(storeProduct) / MICROS_CONVERSION_METRIC));
        pairArr[4] = TuplesKt.to("priceString", getPriceString(storeProduct));
        pairArr[5] = TuplesKt.to("currencyCode", getPriceCurrencyCode(storeProduct));
        pairArr[6] = TuplesKt.to("introPrice", mapIntroPrice(storeProduct));
        ArrayList arrayList = null;
        pairArr[7] = TuplesKt.to("discounts", null);
        pairArr[8] = TuplesKt.to("productCategory", mapProductCategory(storeProduct).getValue());
        pairArr[9] = TuplesKt.to("productType", mapProductType(storeProduct));
        Period period = storeProduct.getPeriod();
        pairArr[10] = TuplesKt.to(b.o, period != null ? period.getIso8601() : null);
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        pairArr[11] = TuplesKt.to("defaultOption", defaultOption != null ? mapSubscriptionOption(defaultOption, storeProduct) : null);
        SubscriptionOptions subscriptionOptions = storeProduct.getSubscriptionOptions();
        if (subscriptionOptions != null) {
            SubscriptionOptions subscriptionOptions2 = subscriptionOptions;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(subscriptionOptions2, 10));
            Iterator<SubscriptionOption> it = subscriptionOptions2.iterator();
            while (it.hasNext()) {
                arrayList2.add(mapSubscriptionOption(it.next(), storeProduct));
            }
            arrayList = arrayList2;
        }
        pairArr[12] = TuplesKt.to("subscriptionOptions", arrayList);
        pairArr[13] = TuplesKt.to("presentedOfferingIdentifier", storeProduct.getPresentedOfferingIdentifier());
        return MapsKt.mapOf(pairArr);
    }

    public static final List<Map<String, Object>> map(List<? extends StoreProduct> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<? extends StoreProduct> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(map((StoreProduct) it.next()));
        }
        return arrayList;
    }

    public static final MappedProductCategory mapProductCategory(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[storeProduct.getType().ordinal()];
        if (i == 1) {
            return MappedProductCategory.NON_SUBSCRIPTION;
        }
        if (i == 2) {
            return MappedProductCategory.SUBSCRIPTION;
        }
        if (i == 3) {
            return MappedProductCategory.UNKNOWN;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String mapProductType(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[storeProduct.getType().ordinal()];
        if (i == 1) {
            return "CONSUMABLE";
        }
        if (i == 2) {
            SubscriptionOption defaultOption = storeProduct.getDefaultOption();
            return defaultOption != null && defaultOption.isPrepaid() ? "PREPAID_SUBSCRIPTION" : "AUTO_RENEWABLE_SUBSCRIPTION";
        }
        if (i == 3) {
            return "UNKNOWN";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Map<String, Object> mapIntroPrice(StoreProduct storeProduct) {
        Period introductoryPricePeriod;
        Map<String, Object> mapPeriodForStoreProduct;
        Map<String, Object> mapPeriodForStoreProduct2;
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        if (getFreeTrialPeriod(storeProduct) != null) {
            Period freeTrialPeriod = getFreeTrialPeriod(storeProduct);
            if (freeTrialPeriod == null || (mapPeriodForStoreProduct2 = mapPeriodForStoreProduct(freeTrialPeriod)) == null) {
                return null;
            }
            Pair[] pairArr = new Pair[4];
            pairArr[0] = TuplesKt.to(b.x, 0);
            pairArr[1] = TuplesKt.to("priceString", MappersHelpersKt.formatUsingDeviceLocale(getPriceCurrencyCode(storeProduct), 0L));
            Period freeTrialPeriod2 = getFreeTrialPeriod(storeProduct);
            pairArr[2] = TuplesKt.to("period", freeTrialPeriod2 != null ? freeTrialPeriod2.getIso8601() : null);
            Integer freeTrialCycles = getFreeTrialCycles(storeProduct);
            pairArr[3] = TuplesKt.to("cycles", Integer.valueOf(freeTrialCycles != null ? freeTrialCycles.intValue() : 1));
            return MapsKt.plus(MapsKt.mapOf(pairArr), mapPeriodForStoreProduct2);
        }
        if (getIntroductoryPrice(storeProduct) == null || (introductoryPricePeriod = getIntroductoryPricePeriod(storeProduct)) == null || (mapPeriodForStoreProduct = mapPeriodForStoreProduct(introductoryPricePeriod)) == null) {
            return null;
        }
        Pair[] pairArr2 = new Pair[4];
        pairArr2[0] = TuplesKt.to(b.x, Double.valueOf(getIntroductoryPriceAmountMicros(storeProduct) / MICROS_CONVERSION_METRIC));
        pairArr2[1] = TuplesKt.to("priceString", getIntroductoryPrice(storeProduct));
        Period introductoryPricePeriod2 = getIntroductoryPricePeriod(storeProduct);
        pairArr2[2] = TuplesKt.to("period", introductoryPricePeriod2 != null ? introductoryPricePeriod2.getIso8601() : null);
        pairArr2[3] = TuplesKt.to("cycles", Integer.valueOf(getIntroductoryPriceCycles(storeProduct)));
        return MapsKt.plus(MapsKt.mapOf(pairArr2), mapPeriodForStoreProduct);
    }

    private static final Map<String, Object> mapPeriodForStoreProduct(Period period) {
        int i = WhenMappings.$EnumSwitchMapping$1[period.getUnit().ordinal()];
        if (i == 1) {
            return MapsKt.mapOf(TuplesKt.to("periodUnit", "DAY"), TuplesKt.to("periodNumberOfUnits", Integer.valueOf(period.getValue())));
        }
        if (i == 2) {
            return MapsKt.mapOf(TuplesKt.to("periodUnit", "DAY"), TuplesKt.to("periodNumberOfUnits", Integer.valueOf(period.getValue() * 7)));
        }
        if (i == 3) {
            return MapsKt.mapOf(TuplesKt.to("periodUnit", "MONTH"), TuplesKt.to("periodNumberOfUnits", Integer.valueOf(period.getValue())));
        }
        if (i == 4) {
            return MapsKt.mapOf(TuplesKt.to("periodUnit", "YEAR"), TuplesKt.to("periodNumberOfUnits", Integer.valueOf(period.getValue())));
        }
        if (i == 5) {
            return MapsKt.mapOf(TuplesKt.to("periodUnit", "DAY"), TuplesKt.to("periodNumberOfUnits", 0));
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final Map<String, Object> mapPeriod(Period period) {
        Map mapOf;
        int i = WhenMappings.$EnumSwitchMapping$1[period.getUnit().ordinal()];
        if (i == 1) {
            mapOf = MapsKt.mapOf(TuplesKt.to("unit", "DAY"), TuplesKt.to("value", Integer.valueOf(period.getValue())));
        } else if (i == 2) {
            mapOf = MapsKt.mapOf(TuplesKt.to("unit", "DAY"), TuplesKt.to("value", Integer.valueOf(period.getValue() * 7)));
        } else if (i == 3) {
            mapOf = MapsKt.mapOf(TuplesKt.to("unit", "MONTH"), TuplesKt.to("value", Integer.valueOf(period.getValue())));
        } else if (i == 4) {
            mapOf = MapsKt.mapOf(TuplesKt.to("unit", "YEAR"), TuplesKt.to("value", Integer.valueOf(period.getValue())));
        } else {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            mapOf = MapsKt.mapOf(TuplesKt.to("unit", "DAY"), TuplesKt.to("value", 0));
        }
        return MapsKt.plus(mapOf, MapsKt.mapOf(TuplesKt.to("iso8601", period.getIso8601())));
    }

    private static final Map<String, Object> mapSubscriptionOption(SubscriptionOption subscriptionOption, StoreProduct storeProduct) {
        Pair[] pairArr = new Pair[12];
        pairArr[0] = TuplesKt.to("id", subscriptionOption.getId());
        pairArr[1] = TuplesKt.to("storeProductId", storeProduct.getId());
        pairArr[2] = TuplesKt.to("productId", storeProduct.getPurchasingData().getProductId());
        List<PricingPhase> pricingPhases = subscriptionOption.getPricingPhases();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pricingPhases, 10));
        Iterator<T> it = pricingPhases.iterator();
        while (it.hasNext()) {
            arrayList.add(mapPricingPhase((PricingPhase) it.next()));
        }
        pairArr[3] = TuplesKt.to("pricingPhases", arrayList);
        pairArr[4] = TuplesKt.to("tags", subscriptionOption.getTags());
        pairArr[5] = TuplesKt.to("isBasePlan", Boolean.valueOf(subscriptionOption.isBasePlan()));
        Period billingPeriod = subscriptionOption.getBillingPeriod();
        pairArr[6] = TuplesKt.to("billingPeriod", billingPeriod != null ? mapPeriod(billingPeriod) : null);
        pairArr[7] = TuplesKt.to("isPrepaid", Boolean.valueOf(subscriptionOption.isPrepaid()));
        PricingPhase fullPricePhase = subscriptionOption.getFullPricePhase();
        pairArr[8] = TuplesKt.to("fullPricePhase", fullPricePhase != null ? mapPricingPhase(fullPricePhase) : null);
        PricingPhase freePhase = subscriptionOption.getFreePhase();
        pairArr[9] = TuplesKt.to("freePhase", freePhase != null ? mapPricingPhase(freePhase) : null);
        PricingPhase introPhase = subscriptionOption.getIntroPhase();
        pairArr[10] = TuplesKt.to("introPhase", introPhase != null ? mapPricingPhase(introPhase) : null);
        pairArr[11] = TuplesKt.to("presentedOfferingIdentifier", subscriptionOption.getPresentedOfferingIdentifier());
        return MapsKt.mapOf(pairArr);
    }

    private static final Map<String, Object> mapPricingPhase(PricingPhase pricingPhase) {
        Pair[] pairArr = new Pair[5];
        Period billingPeriod = pricingPhase.getBillingPeriod();
        pairArr[0] = TuplesKt.to("billingPeriod", billingPeriod != null ? mapPeriod(billingPeriod) : null);
        pairArr[1] = TuplesKt.to("recurrenceMode", pricingPhase.getRecurrenceMode().getIdentifier());
        pairArr[2] = TuplesKt.to("billingCycleCount", pricingPhase.getBillingCycleCount());
        pairArr[3] = TuplesKt.to(b.x, mapPrice(pricingPhase.getPrice()));
        OfferPaymentMode offerPaymentMode = pricingPhase.getOfferPaymentMode();
        pairArr[4] = TuplesKt.to("offerPaymentMode", offerPaymentMode != null ? offerPaymentMode.toString() : null);
        return MapsKt.mapOf(pairArr);
    }

    private static final Map<String, Object> mapPrice(Price price) {
        return MapsKt.mapOf(TuplesKt.to("formatted", price.getFormatted()), TuplesKt.to("amountMicros", Long.valueOf(price.getAmountMicros())), TuplesKt.to("currencyCode", price.getCurrencyCode()));
    }
}
