package com.revenuecat.purchases.amazon;

import com.amazon.a.a.o.b;
import com.amazon.a.a.o.b.f;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductType;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: storeProductConversions.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0000\u001a\u000e\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u0004H\u0000\u001a\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"pattern", "Ljava/util/regex/Pattern;", "createPeriod", "Lcom/revenuecat/purchases/models/Period;", "", "createPrice", "Lcom/revenuecat/purchases/models/Price;", b.m, "parsePriceUsingRegex", "Ljava/math/BigDecimal;", "toStoreProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "Lcom/amazon/device/iap/model/Product;", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class StoreProductConversionsKt {
    private static final Pattern pattern;

    public static final StoreProduct toStoreProduct(Product product, String marketplace) {
        Intrinsics.checkNotNullParameter(product, "<this>");
        Intrinsics.checkNotNullParameter(marketplace, "marketplace");
        if (product.getPrice() == null) {
            LogIntent logIntent = LogIntent.AMAZON_ERROR;
            String format = String.format(AmazonStrings.PRODUCT_PRICE_MISSING, Arrays.copyOf(new Object[]{product.getSku()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
            return null;
        }
        String price = product.getPrice();
        Intrinsics.checkNotNullExpressionValue(price, "price");
        Price createPrice = createPrice(price, marketplace);
        String sku = product.getSku();
        Intrinsics.checkNotNullExpressionValue(sku, "sku");
        ProductType productType = product.getProductType();
        Intrinsics.checkNotNullExpressionValue(productType, "productType");
        com.revenuecat.purchases.ProductType revenueCatProductType = ProductTypeConversionsKt.toRevenueCatProductType(productType);
        String title = product.getTitle();
        Intrinsics.checkNotNullExpressionValue(title, "title");
        String title2 = product.getTitle();
        Intrinsics.checkNotNullExpressionValue(title2, "title");
        String description = product.getDescription();
        Intrinsics.checkNotNullExpressionValue(description, "description");
        String subscriptionPeriod = product.getSubscriptionPeriod();
        Period createPeriod = subscriptionPeriod != null ? createPeriod(subscriptionPeriod) : null;
        String smallIconUrl = product.getSmallIconUrl();
        Intrinsics.checkNotNullExpressionValue(smallIconUrl, "smallIconUrl");
        String freeTrialPeriod = product.getFreeTrialPeriod();
        Period createPeriod2 = freeTrialPeriod != null ? createPeriod(freeTrialPeriod) : null;
        JSONObject json = product.toJSON();
        Intrinsics.checkNotNullExpressionValue(json, "this.toJSON()");
        return new AmazonStoreProduct(sku, revenueCatProductType, title, title2, description, createPeriod, createPrice, (SubscriptionOptions) null, (SubscriptionOption) null, smallIconUrl, createPeriod2, json, (PresentedOfferingContext) null);
    }

    public static final Period createPeriod(String str) {
        String str2;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(str, "<this>");
        switch (str.hashCode()) {
            case -2115097178:
                if (str.equals("BiMonthly")) {
                    return new Period(2, Period.Unit.MONTH, "P2M");
                }
                break;
            case -1707840351:
                if (str.equals("Weekly")) {
                    return new Period(1, Period.Unit.WEEK, "P1W");
                }
                break;
            case -1393678355:
                if (str.equals("Monthly")) {
                    return new Period(1, Period.Unit.MONTH, "P1M");
                }
                break;
            case -580032564:
                if (str.equals("Annually")) {
                    return new Period(1, Period.Unit.YEAR, "P1Y");
                }
                break;
            case -308855462:
                if (str.equals("SemiAnnually")) {
                    return new Period(6, Period.Unit.MONTH, "P6M");
                }
                break;
            case 347098056:
                if (str.equals("BiWeekly")) {
                    return new Period(2, Period.Unit.WEEK, "P2W");
                }
                break;
            case 937940249:
                if (str.equals("Quarterly")) {
                    return new Period(3, Period.Unit.MONTH, "P3M");
                }
                break;
        }
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR}, false, 0, 6, (Object) null);
        if (!(split$default.size() == 2)) {
            split$default = null;
        }
        if (split$default == null || (str2 = (String) CollectionsKt.firstOrNull(split$default)) == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) {
            return null;
        }
        int intValue = intOrNull.intValue();
        String valueOf = String.valueOf(StringsKt.first((CharSequence) split$default.get(1)));
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return Period.INSTANCE.create("P" + intValue + upperCase);
    }

    public static final Price createPrice(String str, String marketplace) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(marketplace, "marketplace");
        BigDecimal priceNumeric = parsePriceUsingRegex(str);
        if (priceNumeric == null) {
            priceNumeric = BigDecimal.ZERO;
        }
        Intrinsics.checkNotNullExpressionValue(priceNumeric, "priceNumeric");
        BigDecimal multiply = priceNumeric.multiply(new BigDecimal(1000000));
        Intrinsics.checkNotNullExpressionValue(multiply, "this.multiply(other)");
        return new Price(str, multiply.longValue(), ISO3166Alpha2ToISO42170Converter.INSTANCE.convertOrEmpty(marketplace));
    }

    static {
        Pattern compile = Pattern.compile("(\\d+[[\\.,\\s]\\d+]*)");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(\"(\\\\d+[[\\\\.,\\\\s]\\\\d+]*)\")");
        pattern = compile;
    }

    public static final BigDecimal parsePriceUsingRegex(String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Matcher matcher = pattern.matcher(str);
        if ((matcher.find() ? matcher : null) == null) {
            return null;
        }
        String dirtyPrice = matcher.group();
        Intrinsics.checkNotNullExpressionValue(dirtyPrice, "dirtyPrice");
        String obj = StringsKt.trim((CharSequence) StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(dirtyPrice, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "", false, 4, (Object) null), " ", "", false, 4, (Object) null), " ", "", false, 4, (Object) null)).toString();
        List split$default = StringsKt.split$default((CharSequence) obj, new String[]{".", f.a}, false, 0, 6, (Object) null);
        if (split$default.size() != 1) {
            if (((String) CollectionsKt.last(split$default)).length() == 3) {
                str2 = StringsKt.replace$default(StringsKt.replace$default(obj, ".", "", false, 4, (Object) null), f.a, "", false, 4, (Object) null);
            } else {
                str2 = CollectionsKt.joinToString$default(CollectionsKt.dropLast(split$default, 1), "", null, null, 0, null, null, 62, null) + '.' + ((String) CollectionsKt.last(split$default));
            }
            obj = str2;
        }
        return new BigDecimal(StringsKt.trim((CharSequence) obj).toString());
    }
}
