package com.revenuecat.purchases.models;

import com.amazon.a.a.o.b;
import com.android.billingclient.api.ProductDetails;
import com.facebook.hermes.intl.Constants;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.GooglePurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: GoogleStoreProduct.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016Bk\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0018B-\b\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0000\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u001bB\u007f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u001cJ\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u0010?\u001a\u00020\u0013HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0006HÆ\u0003J\t\u0010D\u001a\u00020\bHÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0097\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001J\u0010\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020\u0003H\u0017J\u0012\u0010M\u001a\u00020\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0013\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010QHÖ\u0003J\u0012\u0010R\u001a\u0004\u0018\u00010\u00032\u0006\u0010S\u001a\u00020TH\u0016J\t\u0010U\u001a\u00020VHÖ\u0001J\t\u0010W\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u000b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001eR\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010*\u001a\u0004\b+\u0010\u001eR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0014\u00101\u001a\u0002028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b6\u0010*\u001a\u0004\b7\u0010\u001eR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0014\u0010\n\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<¨\u0006X"}, d2 = {"Lcom/revenuecat/purchases/models/GoogleStoreProduct;", "Lcom/revenuecat/purchases/models/StoreProduct;", "productId", "", "basePlanId", "type", "Lcom/revenuecat/purchases/ProductType;", b.x, "Lcom/revenuecat/purchases/models/Price;", "name", "title", b.c, "period", "Lcom/revenuecat/purchases/models/Period;", "subscriptionOptions", "Lcom/revenuecat/purchases/models/SubscriptionOptions;", "defaultOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "productDetails", "Lcom/android/billingclient/api/ProductDetails;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;Lcom/revenuecat/purchases/models/Price;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/SubscriptionOptions;Lcom/revenuecat/purchases/models/SubscriptionOption;Lcom/android/billingclient/api/ProductDetails;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "presentedOfferingIdentifier", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;Lcom/revenuecat/purchases/models/Price;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/SubscriptionOptions;Lcom/revenuecat/purchases/models/SubscriptionOption;Lcom/android/billingclient/api/ProductDetails;Ljava/lang/String;)V", "otherProduct", "subscriptionOptionsWithOfferingId", "(Lcom/revenuecat/purchases/models/GoogleStoreProduct;Lcom/revenuecat/purchases/models/SubscriptionOption;Lcom/revenuecat/purchases/models/SubscriptionOptions;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;Lcom/revenuecat/purchases/models/Price;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/SubscriptionOptions;Lcom/revenuecat/purchases/models/SubscriptionOption;Lcom/android/billingclient/api/ProductDetails;Ljava/lang/String;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "getBasePlanId", "()Ljava/lang/String;", "getDefaultOption", "()Lcom/revenuecat/purchases/models/SubscriptionOption;", "getDescription", "id", "getId", "getName", "getPeriod", "()Lcom/revenuecat/purchases/models/Period;", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPresentedOfferingIdentifier$annotations", "()V", "getPresentedOfferingIdentifier", "getPrice", "()Lcom/revenuecat/purchases/models/Price;", "getProductDetails", "()Lcom/android/billingclient/api/ProductDetails;", "getProductId", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "getPurchasingData", "()Lcom/revenuecat/purchases/models/PurchasingData;", "sku", "getSku$annotations", "getSku", "getSubscriptionOptions", "()Lcom/revenuecat/purchases/models/SubscriptionOptions;", "getTitle", "getType", "()Lcom/revenuecat/purchases/ProductType;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "copyWithOfferingId", "offeringId", "copyWithPresentedOfferingContext", "equals", "", "other", "", "formattedPricePerMonth", Constants.LOCALE, "Ljava/util/Locale;", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GoogleStoreProduct implements StoreProduct {
    private final String basePlanId;
    private final SubscriptionOption defaultOption;
    private final String description;
    private final String name;
    private final Period period;
    private final PresentedOfferingContext presentedOfferingContext;
    private final String presentedOfferingIdentifier;
    private final Price price;
    private final ProductDetails productDetails;
    private final String productId;
    private final SubscriptionOptions subscriptionOptions;
    private final String title;
    private final ProductType type;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Replaced with constructor that takes a presentedOfferingContext", replaceWith = @ReplaceWith(expression = "GoogleStoreProduct(productId, basePlanId, type, price, name, title, description, period, subscriptionOptions, defaultOption, productDetails, PresentedOfferingContext(presentedOfferingIdentifier))", imports = {}))
    public GoogleStoreProduct(String productId, String str, ProductType type, Price price, String name, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails) {
        this(productId, str, type, price, name, title, description, period, subscriptionOptions, subscriptionOption, productDetails, null, null, 6144, null);
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Replaced with constructor that takes a presentedOfferingContext", replaceWith = @ReplaceWith(expression = "GoogleStoreProduct(productId, basePlanId, type, price, name, title, description, period, subscriptionOptions, defaultOption, productDetails, PresentedOfferingContext(presentedOfferingIdentifier))", imports = {}))
    public GoogleStoreProduct(String productId, String str, ProductType type, Price price, String name, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, String str2) {
        this(productId, str, type, price, name, title, description, period, subscriptionOptions, subscriptionOption, productDetails, str2, null, 4096, null);
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
    }

    @Deprecated(message = "Use presentedOfferingContext instead", replaceWith = @ReplaceWith(expression = "presentedOfferingContext.offeringIdentifier", imports = {}))
    public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
    }

    @Deprecated(message = "Replaced with productId", replaceWith = @ReplaceWith(expression = "productId", imports = {}))
    public static /* synthetic */ void getSku$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    public final SubscriptionOption component10() {
        return getDefaultOption();
    }

    /* renamed from: component11, reason: from getter */
    public final ProductDetails getProductDetails() {
        return this.productDetails;
    }

    public final String component12() {
        return getPresentedOfferingIdentifier();
    }

    public final PresentedOfferingContext component13() {
        return getPresentedOfferingContext();
    }

    /* renamed from: component2, reason: from getter */
    public final String getBasePlanId() {
        return this.basePlanId;
    }

    public final ProductType component3() {
        return getType();
    }

    public final Price component4() {
        return getPrice();
    }

    public final String component5() {
        return getName();
    }

    public final String component6() {
        return getTitle();
    }

    public final String component7() {
        return getDescription();
    }

    public final Period component8() {
        return getPeriod();
    }

    public final SubscriptionOptions component9() {
        return getSubscriptionOptions();
    }

    public final GoogleStoreProduct copy(String productId, String basePlanId, ProductType type, Price price, String name, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption defaultOption, ProductDetails productDetails, String presentedOfferingIdentifier, PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        return new GoogleStoreProduct(productId, basePlanId, type, price, name, title, description, period, subscriptionOptions, defaultOption, productDetails, presentedOfferingIdentifier, presentedOfferingContext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoogleStoreProduct)) {
            return false;
        }
        GoogleStoreProduct googleStoreProduct = (GoogleStoreProduct) other;
        return Intrinsics.areEqual(this.productId, googleStoreProduct.productId) && Intrinsics.areEqual(this.basePlanId, googleStoreProduct.basePlanId) && getType() == googleStoreProduct.getType() && Intrinsics.areEqual(getPrice(), googleStoreProduct.getPrice()) && Intrinsics.areEqual(getName(), googleStoreProduct.getName()) && Intrinsics.areEqual(getTitle(), googleStoreProduct.getTitle()) && Intrinsics.areEqual(getDescription(), googleStoreProduct.getDescription()) && Intrinsics.areEqual(getPeriod(), googleStoreProduct.getPeriod()) && Intrinsics.areEqual(getSubscriptionOptions(), googleStoreProduct.getSubscriptionOptions()) && Intrinsics.areEqual(getDefaultOption(), googleStoreProduct.getDefaultOption()) && Intrinsics.areEqual(this.productDetails, googleStoreProduct.productDetails) && Intrinsics.areEqual(getPresentedOfferingIdentifier(), googleStoreProduct.getPresentedOfferingIdentifier()) && Intrinsics.areEqual(getPresentedOfferingContext(), googleStoreProduct.getPresentedOfferingContext());
    }

    public int hashCode() {
        int hashCode = this.productId.hashCode() * 31;
        String str = this.basePlanId;
        return ((((((((((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + getType().hashCode()) * 31) + getPrice().hashCode()) * 31) + getName().hashCode()) * 31) + getTitle().hashCode()) * 31) + getDescription().hashCode()) * 31) + (getPeriod() == null ? 0 : getPeriod().hashCode())) * 31) + (getSubscriptionOptions() == null ? 0 : getSubscriptionOptions().hashCode())) * 31) + (getDefaultOption() == null ? 0 : getDefaultOption().hashCode())) * 31) + this.productDetails.hashCode()) * 31) + (getPresentedOfferingIdentifier() == null ? 0 : getPresentedOfferingIdentifier().hashCode())) * 31) + (getPresentedOfferingContext() != null ? getPresentedOfferingContext().hashCode() : 0);
    }

    public String toString() {
        return "GoogleStoreProduct(productId=" + this.productId + ", basePlanId=" + this.basePlanId + ", type=" + getType() + ", price=" + getPrice() + ", name=" + getName() + ", title=" + getTitle() + ", description=" + getDescription() + ", period=" + getPeriod() + ", subscriptionOptions=" + getSubscriptionOptions() + ", defaultOption=" + getDefaultOption() + ", productDetails=" + this.productDetails + ", presentedOfferingIdentifier=" + getPresentedOfferingIdentifier() + ", presentedOfferingContext=" + getPresentedOfferingContext() + ')';
    }

    @Deprecated(message = "Replaced with constructor that takes a presentedOfferingContext", replaceWith = @ReplaceWith(expression = "GoogleStoreProduct(productId, basePlanId, type, price, name, title, description, period, subscriptionOptions, defaultOption, productDetails, PresentedOfferingContext(presentedOfferingIdentifier))", imports = {}))
    public GoogleStoreProduct(String productId, String str, ProductType type, Price price, String name, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, String str2, PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        this.productId = productId;
        this.basePlanId = str;
        this.type = type;
        this.price = price;
        this.name = name;
        this.title = title;
        this.description = description;
        this.period = period;
        this.subscriptionOptions = subscriptionOptions;
        this.defaultOption = subscriptionOption;
        this.productDetails = productDetails;
        this.presentedOfferingIdentifier = str2;
        this.presentedOfferingContext = presentedOfferingContext;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public Price pricePerMonth(Locale locale) {
        return StoreProduct.DefaultImpls.pricePerMonth(this, locale);
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public Price pricePerWeek(Locale locale) {
        return StoreProduct.DefaultImpls.pricePerWeek(this, locale);
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public Price pricePerYear(Locale locale) {
        return StoreProduct.DefaultImpls.pricePerYear(this, locale);
    }

    public /* synthetic */ GoogleStoreProduct(String str, String str2, ProductType productType, Price price, String str3, String str4, String str5, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, String str6, PresentedOfferingContext presentedOfferingContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, productType, price, str3, str4, str5, period, subscriptionOptions, subscriptionOption, productDetails, (i & 2048) != 0 ? null : str6, (i & 4096) != 0 ? null : presentedOfferingContext);
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getBasePlanId() {
        return this.basePlanId;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public ProductType getType() {
        return this.type;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public Price getPrice() {
        return this.price;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getName() {
        return this.name;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getTitle() {
        return this.title;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getDescription() {
        return this.description;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public Period getPeriod() {
        return this.period;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public SubscriptionOptions getSubscriptionOptions() {
        return this.subscriptionOptions;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public SubscriptionOption getDefaultOption() {
        return this.defaultOption;
    }

    public final ProductDetails getProductDetails() {
        return this.productDetails;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getPresentedOfferingIdentifier() {
        return this.presentedOfferingIdentifier;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public /* synthetic */ GoogleStoreProduct(String str, String str2, ProductType productType, Price price, String str3, String str4, String str5, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, PresentedOfferingContext presentedOfferingContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, productType, price, str3, str4, str5, period, subscriptionOptions, subscriptionOption, productDetails, (i & 2048) != 0 ? null : presentedOfferingContext);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GoogleStoreProduct(String productId, String str, ProductType type, Price price, String name, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, PresentedOfferingContext presentedOfferingContext) {
        this(productId, str, type, price, name, title, description, period, subscriptionOptions, subscriptionOption, productDetails, presentedOfferingContext != null ? presentedOfferingContext.getOfferingIdentifier() : null, presentedOfferingContext);
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
    }

    public /* synthetic */ GoogleStoreProduct(String str, String str2, ProductType productType, Price price, String str3, String str4, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, productType, price, str3, str4, period, subscriptionOptions, subscriptionOption, productDetails, (i & 1024) != 0 ? null : str5);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Replaced with constructor that takes a name", replaceWith = @ReplaceWith(expression = "GoogleStoreProduct(productId, basePlanId, type, price, name, title, description, period, subscriptionOptions, defaultOption, productDetails, presentedOfferingIdentifier)", imports = {}))
    public GoogleStoreProduct(String productId, String str, ProductType type, Price price, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, String str2) {
        this(productId, str, type, price, title, title, description, period, subscriptionOptions, subscriptionOption, productDetails, str2 != null ? new PresentedOfferingContext(str2) : null);
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
    }

    private GoogleStoreProduct(GoogleStoreProduct googleStoreProduct, SubscriptionOption subscriptionOption, SubscriptionOptions subscriptionOptions, PresentedOfferingContext presentedOfferingContext) {
        this(googleStoreProduct.productId, googleStoreProduct.basePlanId, googleStoreProduct.getType(), googleStoreProduct.getPrice(), googleStoreProduct.getName(), googleStoreProduct.getTitle(), googleStoreProduct.getDescription(), googleStoreProduct.getPeriod(), subscriptionOptions, subscriptionOption, googleStoreProduct.productDetails, presentedOfferingContext);
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getId() {
        if (this.basePlanId != null) {
            String str = this.productId + AbstractJsonLexerKt.COLON + this.basePlanId;
            if (str != null) {
                return str;
            }
        }
        return this.productId;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public PurchasingData getPurchasingData() {
        if (getType() == ProductType.SUBS && getDefaultOption() != null) {
            return getDefaultOption().getPurchasingData();
        }
        return new GooglePurchasingData.InAppProduct(getId(), this.productDetails);
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getSku() {
        return this.productId;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    @Deprecated(message = "Use copyWithPresentedOfferingContext instead", replaceWith = @ReplaceWith(expression = "copyWithPresentedOfferingContext(presentedOfferingContext)", imports = {}))
    public StoreProduct copyWithOfferingId(String offeringId) {
        PresentedOfferingContext presentedOfferingContext;
        Intrinsics.checkNotNullParameter(offeringId, "offeringId");
        PresentedOfferingContext presentedOfferingContext2 = getPresentedOfferingContext();
        if (presentedOfferingContext2 == null || (presentedOfferingContext = presentedOfferingContext2.copy(offeringId)) == null) {
            presentedOfferingContext = new PresentedOfferingContext(offeringId);
        }
        return copyWithPresentedOfferingContext(presentedOfferingContext);
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public StoreProduct copyWithPresentedOfferingContext(PresentedOfferingContext presentedOfferingContext) {
        ArrayList arrayList;
        SubscriptionOptions subscriptionOptions = getSubscriptionOptions();
        if (subscriptionOptions != null) {
            ArrayList arrayList2 = new ArrayList();
            for (SubscriptionOption subscriptionOption : subscriptionOptions) {
                GoogleSubscriptionOption googleSubscriptionOption = subscriptionOption instanceof GoogleSubscriptionOption ? (GoogleSubscriptionOption) subscriptionOption : null;
                GoogleSubscriptionOption googleSubscriptionOption2 = googleSubscriptionOption != null ? new GoogleSubscriptionOption(googleSubscriptionOption, presentedOfferingContext) : null;
                if (googleSubscriptionOption2 != null) {
                    arrayList2.add(googleSubscriptionOption2);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        SubscriptionOption defaultOption = getDefaultOption();
        GoogleSubscriptionOption googleSubscriptionOption3 = defaultOption instanceof GoogleSubscriptionOption ? (GoogleSubscriptionOption) defaultOption : null;
        return new GoogleStoreProduct(this, googleSubscriptionOption3 != null ? new GoogleSubscriptionOption(googleSubscriptionOption3, presentedOfferingContext) : null, arrayList != null ? new SubscriptionOptions(arrayList) : null, presentedOfferingContext);
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String formattedPricePerMonth(Locale locale) {
        SubscriptionOption basePlan;
        List<PricingPhase> pricingPhases;
        PricingPhase pricingPhase;
        Intrinsics.checkNotNullParameter(locale, "locale");
        SubscriptionOptions subscriptionOptions = getSubscriptionOptions();
        if (subscriptionOptions == null || (basePlan = subscriptionOptions.getBasePlan()) == null || (pricingPhases = basePlan.getPricingPhases()) == null || (pricingPhase = (PricingPhase) CollectionsKt.last((List) pricingPhases)) == null) {
            return null;
        }
        return pricingPhase.formattedPriceInMonths(locale);
    }
}
