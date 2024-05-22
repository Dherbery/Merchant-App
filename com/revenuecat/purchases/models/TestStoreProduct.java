package com.revenuecat.purchases.models;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TestStoreProduct.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\fBO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eJ\n\u00102\u001a\u0004\u0018\u00010*H\u0002J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\tHÂ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0007HÂ\u0003J_\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0010\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u0003H\u0017J\u0012\u0010>\u001a\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0013\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BHÖ\u0003J\t\u0010C\u001a\u00020DHÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0014R\u0016\u0010)\u001a\u0004\u0018\u00010*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0014R\u0014\u0010.\u001a\u00020/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u0006F"}, d2 = {"Lcom/revenuecat/purchases/models/TestStoreProduct;", "Lcom/revenuecat/purchases/models/StoreProduct;", "id", "", "title", b.c, b.x, "Lcom/revenuecat/purchases/models/Price;", "period", "Lcom/revenuecat/purchases/models/Period;", b.p, "introPrice", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Price;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/Price;)V", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Price;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/Price;)V", "defaultOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "getDefaultOption", "()Lcom/revenuecat/purchases/models/SubscriptionOption;", "getDescription", "()Ljava/lang/String;", "getId", "getName", "getPeriod", "()Lcom/revenuecat/purchases/models/Period;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "presentedOfferingIdentifier", "getPresentedOfferingIdentifier$annotations", "()V", "getPresentedOfferingIdentifier", "getPrice", "()Lcom/revenuecat/purchases/models/Price;", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "getPurchasingData", "()Lcom/revenuecat/purchases/models/PurchasingData;", "sku", "getSku", "subscriptionOptions", "Lcom/revenuecat/purchases/models/SubscriptionOptions;", "getSubscriptionOptions", "()Lcom/revenuecat/purchases/models/SubscriptionOptions;", "getTitle", "type", "Lcom/revenuecat/purchases/ProductType;", "getType", "()Lcom/revenuecat/purchases/ProductType;", "buildSubscriptionOptions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "copyWithOfferingId", "offeringId", "copyWithPresentedOfferingContext", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TestStoreProduct implements StoreProduct {
    private final String description;
    private final Period freeTrialPeriod;
    private final String id;
    private final Price introPrice;
    private final String name;
    private final Period period;
    private final Price price;
    private final String title;

    /* renamed from: component7, reason: from getter */
    private final Period getFreeTrialPeriod() {
        return this.freeTrialPeriod;
    }

    /* renamed from: component8, reason: from getter */
    private final Price getIntroPrice() {
        return this.introPrice;
    }

    @Deprecated(message = "Use presentedOfferingContext", replaceWith = @ReplaceWith(expression = "presentedOfferingContext.offeringIdentifier", imports = {}))
    public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
    }

    public final String component1() {
        return getId();
    }

    public final String component2() {
        return getName();
    }

    public final String component3() {
        return getTitle();
    }

    public final String component4() {
        return getDescription();
    }

    public final Price component5() {
        return getPrice();
    }

    public final Period component6() {
        return getPeriod();
    }

    public final TestStoreProduct copy(String id, String name, String title, String description, Price price, Period period, Period freeTrialPeriod, Price introPrice) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(price, "price");
        return new TestStoreProduct(id, name, title, description, price, period, freeTrialPeriod, introPrice);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TestStoreProduct)) {
            return false;
        }
        TestStoreProduct testStoreProduct = (TestStoreProduct) other;
        return Intrinsics.areEqual(getId(), testStoreProduct.getId()) && Intrinsics.areEqual(getName(), testStoreProduct.getName()) && Intrinsics.areEqual(getTitle(), testStoreProduct.getTitle()) && Intrinsics.areEqual(getDescription(), testStoreProduct.getDescription()) && Intrinsics.areEqual(getPrice(), testStoreProduct.getPrice()) && Intrinsics.areEqual(getPeriod(), testStoreProduct.getPeriod()) && Intrinsics.areEqual(this.freeTrialPeriod, testStoreProduct.freeTrialPeriod) && Intrinsics.areEqual(this.introPrice, testStoreProduct.introPrice);
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public PresentedOfferingContext getPresentedOfferingContext() {
        return null;
    }

    public int hashCode() {
        int hashCode = ((((((((((getId().hashCode() * 31) + getName().hashCode()) * 31) + getTitle().hashCode()) * 31) + getDescription().hashCode()) * 31) + getPrice().hashCode()) * 31) + (getPeriod() == null ? 0 : getPeriod().hashCode())) * 31;
        Period period = this.freeTrialPeriod;
        int hashCode2 = (hashCode + (period == null ? 0 : period.hashCode())) * 31;
        Price price = this.introPrice;
        return hashCode2 + (price != null ? price.hashCode() : 0);
    }

    public String toString() {
        return "TestStoreProduct(id=" + getId() + ", name=" + getName() + ", title=" + getTitle() + ", description=" + getDescription() + ", price=" + getPrice() + ", period=" + getPeriod() + ", freeTrialPeriod=" + this.freeTrialPeriod + ", introPrice=" + this.introPrice + ')';
    }

    public TestStoreProduct(String id, String name, String title, String description, Price price, Period period, Period period2, Price price2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(price, "price");
        this.id = id;
        this.name = name;
        this.title = title;
        this.description = description;
        this.price = price;
        this.period = period;
        this.freeTrialPeriod = period2;
        this.introPrice = price2;
    }

    public /* synthetic */ TestStoreProduct(String str, String str2, String str3, String str4, Price price, Period period, Period period2, Price price2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, price, period, (i & 64) != 0 ? null : period2, (i & 128) != 0 ? null : price2);
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String formattedPricePerMonth(Locale locale) {
        return StoreProduct.DefaultImpls.formattedPricePerMonth(this, locale);
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

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getId() {
        return this.id;
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
    public Price getPrice() {
        return this.price;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public Period getPeriod() {
        return this.period;
    }

    public /* synthetic */ TestStoreProduct(String str, String str2, String str3, Price price, Period period, Period period2, Price price2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, price, period, (i & 32) != 0 ? null : period2, (i & 64) != 0 ? null : price2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Replaced with constructor that takes a name", replaceWith = @ReplaceWith(expression = "TestStoreProduct(id, name, title, description, price, period, freeTrialPeriod, introPrice)", imports = {}))
    public TestStoreProduct(String id, String title, String description, Price price, Period period, Period period2, Price price2) {
        this(id, title, title, description, price, period, period2, price2);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(price, "price");
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public ProductType getType() {
        return getPeriod() == null ? ProductType.INAPP : ProductType.SUBS;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public SubscriptionOptions getSubscriptionOptions() {
        return buildSubscriptionOptions();
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public SubscriptionOption getDefaultOption() {
        SubscriptionOptions subscriptionOptions = getSubscriptionOptions();
        if (subscriptionOptions != null) {
            return subscriptionOptions.getDefaultOffer();
        }
        return null;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public PurchasingData getPurchasingData() {
        return new PurchasingData() { // from class: com.revenuecat.purchases.models.TestStoreProduct$purchasingData$1
            @Override // com.revenuecat.purchases.models.PurchasingData
            public String getProductId() {
                return TestStoreProduct.this.getId();
            }

            @Override // com.revenuecat.purchases.models.PurchasingData
            public ProductType getProductType() {
                return TestStoreProduct.this.getType();
            }
        };
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getPresentedOfferingIdentifier() {
        PresentedOfferingContext presentedOfferingContext = getPresentedOfferingContext();
        if (presentedOfferingContext != null) {
            return presentedOfferingContext.getOfferingIdentifier();
        }
        return null;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getSku() {
        return getId();
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    @Deprecated(message = "Use copyWithPresentedOfferingContext instead", replaceWith = @ReplaceWith(expression = "copyWithPresentedOfferingContext(PresentedOfferingContext(offeringId))", imports = {}))
    public StoreProduct copyWithOfferingId(String offeringId) {
        Intrinsics.checkNotNullParameter(offeringId, "offeringId");
        return copyWithPresentedOfferingContext(new PresentedOfferingContext(offeringId));
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public StoreProduct copyWithPresentedOfferingContext(PresentedOfferingContext presentedOfferingContext) {
        return this;
    }

    private final SubscriptionOptions buildSubscriptionOptions() {
        if (getPeriod() == null) {
            return null;
        }
        Period period = this.freeTrialPeriod;
        PricingPhase pricingPhase = period != null ? new PricingPhase(period, RecurrenceMode.FINITE_RECURRING, 1, new Price("Free", 0L, getPrice().getCurrencyCode())) : null;
        Price price = this.introPrice;
        PricingPhase pricingPhase2 = price != null ? new PricingPhase(new Period(1, Period.Unit.MONTH, "P1M"), RecurrenceMode.FINITE_RECURRING, 1, price) : null;
        PricingPhase pricingPhase3 = new PricingPhase(getPeriod(), RecurrenceMode.INFINITE_RECURRING, null, getPrice());
        TestSubscriptionOption[] testSubscriptionOptionArr = new TestSubscriptionOption[2];
        testSubscriptionOptionArr[0] = this.freeTrialPeriod != null || pricingPhase2 != null ? new TestSubscriptionOption(getId(), CollectionsKt.listOfNotNull((Object[]) new PricingPhase[]{pricingPhase, pricingPhase2, pricingPhase3}), null, null, null, 28, null) : null;
        testSubscriptionOptionArr[1] = new TestSubscriptionOption(getId(), CollectionsKt.listOf(pricingPhase3), null, null, null, 28, null);
        return new SubscriptionOptions(CollectionsKt.listOfNotNull((Object[]) testSubscriptionOptionArr));
    }
}
