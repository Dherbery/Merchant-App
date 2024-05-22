package com.revenuecat.purchases.models;

import com.android.billingclient.api.ProductDetails;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.models.GooglePurchasingData;
import com.revenuecat.purchases.models.SubscriptionOption;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: GoogleSubscriptionOption.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eB\u0019\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0000\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012BY\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0013J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010/\u001a\u00020\u000bHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0011HÆ\u0003Ji\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0015R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!¨\u0006:"}, d2 = {"Lcom/revenuecat/purchases/models/GoogleSubscriptionOption;", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "productId", "", "basePlanId", "offerId", "pricingPhases", "", "Lcom/revenuecat/purchases/models/PricingPhase;", "tags", "productDetails", "Lcom/android/billingclient/api/ProductDetails;", "offerToken", "presentedOfferingId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/android/billingclient/api/ProductDetails;Ljava/lang/String;Ljava/lang/String;)V", "subscriptionOption", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Lcom/revenuecat/purchases/models/GoogleSubscriptionOption;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/android/billingclient/api/ProductDetails;Ljava/lang/String;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "getBasePlanId", "()Ljava/lang/String;", "id", "getId", "getOfferId", "getOfferToken", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "presentedOfferingIdentifier", "getPresentedOfferingIdentifier$annotations", "()V", "getPresentedOfferingIdentifier", "getPricingPhases", "()Ljava/util/List;", "getProductDetails", "()Lcom/android/billingclient/api/ProductDetails;", "getProductId", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "getPurchasingData", "()Lcom/revenuecat/purchases/models/PurchasingData;", "getTags", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GoogleSubscriptionOption implements SubscriptionOption {
    private final String basePlanId;
    private final String offerId;
    private final String offerToken;
    private final PresentedOfferingContext presentedOfferingContext;
    private final List<PricingPhase> pricingPhases;
    private final ProductDetails productDetails;
    private final String productId;
    private final List<String> tags;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GoogleSubscriptionOption(String productId, String basePlanId, String str, List<PricingPhase> pricingPhases, List<String> tags, ProductDetails productDetails, String offerToken) {
        this(productId, basePlanId, str, pricingPhases, tags, productDetails, offerToken, null, 128, null);
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(basePlanId, "basePlanId");
        Intrinsics.checkNotNullParameter(pricingPhases, "pricingPhases");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        Intrinsics.checkNotNullParameter(offerToken, "offerToken");
    }

    @Deprecated(message = "Use presentedOfferingContext instead", replaceWith = @ReplaceWith(expression = "presentedOfferingContext.offeringIdentifier", imports = {}))
    public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBasePlanId() {
        return this.basePlanId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getOfferId() {
        return this.offerId;
    }

    public final List<PricingPhase> component4() {
        return getPricingPhases();
    }

    public final List<String> component5() {
        return getTags();
    }

    /* renamed from: component6, reason: from getter */
    public final ProductDetails getProductDetails() {
        return this.productDetails;
    }

    /* renamed from: component7, reason: from getter */
    public final String getOfferToken() {
        return this.offerToken;
    }

    public final PresentedOfferingContext component8() {
        return getPresentedOfferingContext();
    }

    public final GoogleSubscriptionOption copy(String productId, String basePlanId, String offerId, List<PricingPhase> pricingPhases, List<String> tags, ProductDetails productDetails, String offerToken, PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(basePlanId, "basePlanId");
        Intrinsics.checkNotNullParameter(pricingPhases, "pricingPhases");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        Intrinsics.checkNotNullParameter(offerToken, "offerToken");
        return new GoogleSubscriptionOption(productId, basePlanId, offerId, pricingPhases, tags, productDetails, offerToken, presentedOfferingContext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoogleSubscriptionOption)) {
            return false;
        }
        GoogleSubscriptionOption googleSubscriptionOption = (GoogleSubscriptionOption) other;
        return Intrinsics.areEqual(this.productId, googleSubscriptionOption.productId) && Intrinsics.areEqual(this.basePlanId, googleSubscriptionOption.basePlanId) && Intrinsics.areEqual(this.offerId, googleSubscriptionOption.offerId) && Intrinsics.areEqual(getPricingPhases(), googleSubscriptionOption.getPricingPhases()) && Intrinsics.areEqual(getTags(), googleSubscriptionOption.getTags()) && Intrinsics.areEqual(this.productDetails, googleSubscriptionOption.productDetails) && Intrinsics.areEqual(this.offerToken, googleSubscriptionOption.offerToken) && Intrinsics.areEqual(getPresentedOfferingContext(), googleSubscriptionOption.getPresentedOfferingContext());
    }

    public int hashCode() {
        int hashCode = ((this.productId.hashCode() * 31) + this.basePlanId.hashCode()) * 31;
        String str = this.offerId;
        return ((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + getPricingPhases().hashCode()) * 31) + getTags().hashCode()) * 31) + this.productDetails.hashCode()) * 31) + this.offerToken.hashCode()) * 31) + (getPresentedOfferingContext() != null ? getPresentedOfferingContext().hashCode() : 0);
    }

    public String toString() {
        return "GoogleSubscriptionOption(productId=" + this.productId + ", basePlanId=" + this.basePlanId + ", offerId=" + this.offerId + ", pricingPhases=" + getPricingPhases() + ", tags=" + getTags() + ", productDetails=" + this.productDetails + ", offerToken=" + this.offerToken + ", presentedOfferingContext=" + getPresentedOfferingContext() + ')';
    }

    public GoogleSubscriptionOption(String productId, String basePlanId, String str, List<PricingPhase> pricingPhases, List<String> tags, ProductDetails productDetails, String offerToken, PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(basePlanId, "basePlanId");
        Intrinsics.checkNotNullParameter(pricingPhases, "pricingPhases");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        Intrinsics.checkNotNullParameter(offerToken, "offerToken");
        this.productId = productId;
        this.basePlanId = basePlanId;
        this.offerId = str;
        this.pricingPhases = pricingPhases;
        this.tags = tags;
        this.productDetails = productDetails;
        this.offerToken = offerToken;
        this.presentedOfferingContext = presentedOfferingContext;
    }

    public /* synthetic */ GoogleSubscriptionOption(String str, String str2, String str3, List list, List list2, ProductDetails productDetails, String str4, PresentedOfferingContext presentedOfferingContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (List<PricingPhase>) list, (List<String>) list2, productDetails, str4, (i & 128) != 0 ? null : presentedOfferingContext);
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public Period getBillingPeriod() {
        return SubscriptionOption.DefaultImpls.getBillingPeriod(this);
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public PricingPhase getFreePhase() {
        return SubscriptionOption.DefaultImpls.getFreePhase(this);
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public PricingPhase getFullPricePhase() {
        return SubscriptionOption.DefaultImpls.getFullPricePhase(this);
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public PricingPhase getIntroPhase() {
        return SubscriptionOption.DefaultImpls.getIntroPhase(this);
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public boolean isBasePlan() {
        return SubscriptionOption.DefaultImpls.isBasePlan(this);
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public boolean isPrepaid() {
        return SubscriptionOption.DefaultImpls.isPrepaid(this);
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getBasePlanId() {
        return this.basePlanId;
    }

    public final String getOfferId() {
        return this.offerId;
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public List<PricingPhase> getPricingPhases() {
        return this.pricingPhases;
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public List<String> getTags() {
        return this.tags;
    }

    public final ProductDetails getProductDetails() {
        return this.productDetails;
    }

    public final String getOfferToken() {
        return this.offerToken;
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use constructor with presentedOfferingContext instead", replaceWith = @ReplaceWith(expression = "GoogleSubscriptionOption(productId, basePlanId, offerId, pricingPhases, tags, productDetails, offerToken, PresentedOfferingContext(offeringIdentifier = presentedOfferingId))", imports = {}))
    public GoogleSubscriptionOption(String productId, String basePlanId, String str, List<PricingPhase> pricingPhases, List<String> tags, ProductDetails productDetails, String offerToken, String presentedOfferingId) {
        this(productId, basePlanId, str, pricingPhases, tags, productDetails, offerToken, new PresentedOfferingContext(presentedOfferingId));
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(basePlanId, "basePlanId");
        Intrinsics.checkNotNullParameter(pricingPhases, "pricingPhases");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        Intrinsics.checkNotNullParameter(offerToken, "offerToken");
        Intrinsics.checkNotNullParameter(presentedOfferingId, "presentedOfferingId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GoogleSubscriptionOption(GoogleSubscriptionOption subscriptionOption, PresentedOfferingContext presentedOfferingContext) {
        this(subscriptionOption.productId, subscriptionOption.basePlanId, subscriptionOption.offerId, subscriptionOption.getPricingPhases(), subscriptionOption.getTags(), subscriptionOption.productDetails, subscriptionOption.offerToken, presentedOfferingContext);
        Intrinsics.checkNotNullParameter(subscriptionOption, "subscriptionOption");
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public String getId() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.basePlanId);
        String str2 = this.offerId;
        if (str2 == null || StringsKt.isBlank(str2)) {
            str = "";
        } else {
            str = Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.offerId;
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public String getPresentedOfferingIdentifier() {
        PresentedOfferingContext presentedOfferingContext = getPresentedOfferingContext();
        if (presentedOfferingContext != null) {
            return presentedOfferingContext.getOfferingIdentifier();
        }
        return null;
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public PurchasingData getPurchasingData() {
        return new GooglePurchasingData.Subscription(this.productId, getId(), this.productDetails, this.offerToken);
    }
}
