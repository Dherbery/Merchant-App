package com.revenuecat.purchases;

import android.app.Activity;
import com.revenuecat.purchases.models.GoogleProrationMode;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.TestStoreProduct;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PurchaseParams.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001&B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068@X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u000f\u0010\u0011R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00188@X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u001c8@X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006'"}, d2 = {"Lcom/revenuecat/purchases/PurchaseParams;", "", "builder", "Lcom/revenuecat/purchases/PurchaseParams$Builder;", "(Lcom/revenuecat/purchases/PurchaseParams$Builder;)V", "activity", "Landroid/app/Activity;", "getActivity$purchases_defaultsRelease", "()Landroid/app/Activity;", "getBuilder", "()Lcom/revenuecat/purchases/PurchaseParams$Builder;", "googleReplacementMode", "Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "getGoogleReplacementMode", "()Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "isPersonalizedPrice", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "oldProductId", "", "getOldProductId", "()Ljava/lang/String;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPresentedOfferingContext$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "getPurchasingData$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/models/PurchasingData;", "component1", "copy", "equals", "other", "hashCode", "", "toString", "Builder", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PurchaseParams {
    private final Activity activity;
    private final Builder builder;
    private final GoogleReplacementMode googleReplacementMode;
    private final Boolean isPersonalizedPrice;
    private final String oldProductId;
    private final PresentedOfferingContext presentedOfferingContext;
    private final PurchasingData purchasingData;

    public static /* synthetic */ PurchaseParams copy$default(PurchaseParams purchaseParams, Builder builder, int i, Object obj) {
        if ((i & 1) != 0) {
            builder = purchaseParams.builder;
        }
        return purchaseParams.copy(builder);
    }

    /* renamed from: component1, reason: from getter */
    public final Builder getBuilder() {
        return this.builder;
    }

    public final PurchaseParams copy(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return new PurchaseParams(builder);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PurchaseParams) && Intrinsics.areEqual(this.builder, ((PurchaseParams) other).builder);
    }

    public int hashCode() {
        return this.builder.hashCode();
    }

    public String toString() {
        return "PurchaseParams(builder=" + this.builder + ')';
    }

    public PurchaseParams(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.isPersonalizedPrice = builder.getIsPersonalizedPrice();
        this.oldProductId = builder.getOldProductId();
        this.googleReplacementMode = builder.getGoogleReplacementMode();
        this.purchasingData = builder.getPurchasingData();
        this.activity = builder.getActivity();
        this.presentedOfferingContext = builder.getPresentedOfferingContext();
    }

    public final Builder getBuilder() {
        return this.builder;
    }

    /* renamed from: isPersonalizedPrice, reason: from getter */
    public final Boolean getIsPersonalizedPrice() {
        return this.isPersonalizedPrice;
    }

    public final String getOldProductId() {
        return this.oldProductId;
    }

    public final GoogleReplacementMode getGoogleReplacementMode() {
        return this.googleReplacementMode;
    }

    /* renamed from: getPurchasingData$purchases_defaultsRelease, reason: from getter */
    public final /* synthetic */ PurchasingData getPurchasingData() {
        return this.purchasingData;
    }

    /* renamed from: getActivity$purchases_defaultsRelease, reason: from getter */
    public final /* synthetic */ Activity getActivity() {
        return this.activity;
    }

    /* renamed from: getPresentedOfferingContext$purchases_defaultsRelease, reason: from getter */
    public final /* synthetic */ PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    /* compiled from: PurchaseParams.kt */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0012J\b\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u0002022\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u00103\u001a\u00020\u00002\u0006\u00103\u001a\u000204H\u0007J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R&\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168@@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR,\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001c8@@@X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u0015\u001a\u0004\u0018\u00010#8@@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010\r\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u00065"}, d2 = {"Lcom/revenuecat/purchases/PurchaseParams$Builder;", "", "activity", "Landroid/app/Activity;", "packageToPurchase", "Lcom/revenuecat/purchases/Package;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;)V", "storeProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/StoreProduct;)V", "subscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/SubscriptionOption;)V", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "product", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/PurchasingData;Lcom/revenuecat/purchases/PresentedOfferingContext;Lcom/revenuecat/purchases/models/StoreProduct;)V", "getActivity$purchases_defaultsRelease", "()Landroid/app/Activity;", "<set-?>", "Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "googleReplacementMode", "getGoogleReplacementMode$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "setGoogleReplacementMode$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/models/GoogleReplacementMode;)V", "", "isPersonalizedPrice", "isPersonalizedPrice$purchases_defaultsRelease", "()Ljava/lang/Boolean;", "setPersonalizedPrice$purchases_defaultsRelease", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "", "oldProductId", "getOldProductId$purchases_defaultsRelease", "()Ljava/lang/String;", "setOldProductId$purchases_defaultsRelease", "(Ljava/lang/String;)V", "getPresentedOfferingContext$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getProduct$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/models/StoreProduct;", "getPurchasingData$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/models/PurchasingData;", "build", "Lcom/revenuecat/purchases/PurchaseParams;", "ensureNoTestProduct", "", "googleProrationMode", "Lcom/revenuecat/purchases/models/GoogleProrationMode;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static class Builder {
        private final Activity activity;
        private GoogleReplacementMode googleReplacementMode;
        private Boolean isPersonalizedPrice;
        private String oldProductId;
        private final PresentedOfferingContext presentedOfferingContext;
        private final StoreProduct product;
        private final PurchasingData purchasingData;

        private Builder(Activity activity, PurchasingData purchasingData, PresentedOfferingContext presentedOfferingContext, StoreProduct storeProduct) {
            this.activity = activity;
            this.purchasingData = purchasingData;
            this.presentedOfferingContext = presentedOfferingContext;
            this.product = storeProduct;
            this.googleReplacementMode = GoogleReplacementMode.WITHOUT_PRORATION;
        }

        /* renamed from: getActivity$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ Activity getActivity() {
            return this.activity;
        }

        /* renamed from: getPurchasingData$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ PurchasingData getPurchasingData() {
            return this.purchasingData;
        }

        /* renamed from: getPresentedOfferingContext$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ PresentedOfferingContext getPresentedOfferingContext() {
            return this.presentedOfferingContext;
        }

        /* renamed from: getProduct$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ StoreProduct getProduct() {
            return this.product;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Activity activity, Package packageToPurchase) {
            this(activity, packageToPurchase.getProduct().getPurchasingData(), packageToPurchase.getPresentedOfferingContext(), packageToPurchase.getProduct());
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(packageToPurchase, "packageToPurchase");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Activity activity, StoreProduct storeProduct) {
            this(activity, storeProduct.getPurchasingData(), storeProduct.getPresentedOfferingContext(), storeProduct);
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        }

        private final void ensureNoTestProduct(StoreProduct storeProduct) {
            if (storeProduct instanceof TestStoreProduct) {
                throw new PurchasesException(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, "Cannot purchase " + storeProduct));
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Activity activity, SubscriptionOption subscriptionOption) {
            this(activity, subscriptionOption.getPurchasingData(), subscriptionOption.getPresentedOfferingContext(), null);
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(subscriptionOption, "subscriptionOption");
        }

        /* renamed from: isPersonalizedPrice$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ Boolean getIsPersonalizedPrice() {
            return this.isPersonalizedPrice;
        }

        public final /* synthetic */ void setPersonalizedPrice$purchases_defaultsRelease(Boolean bool) {
            this.isPersonalizedPrice = bool;
        }

        /* renamed from: getOldProductId$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ String getOldProductId() {
            return this.oldProductId;
        }

        public final /* synthetic */ void setOldProductId$purchases_defaultsRelease(String str) {
            this.oldProductId = str;
        }

        /* renamed from: getGoogleReplacementMode$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ GoogleReplacementMode getGoogleReplacementMode() {
            return this.googleReplacementMode;
        }

        public final /* synthetic */ void setGoogleReplacementMode$purchases_defaultsRelease(GoogleReplacementMode googleReplacementMode) {
            Intrinsics.checkNotNullParameter(googleReplacementMode, "<set-?>");
            this.googleReplacementMode = googleReplacementMode;
        }

        public final Builder isPersonalizedPrice(boolean isPersonalizedPrice) {
            this.isPersonalizedPrice = Boolean.valueOf(isPersonalizedPrice);
            return this;
        }

        public final Builder oldProductId(String oldProductId) {
            Intrinsics.checkNotNullParameter(oldProductId, "oldProductId");
            this.oldProductId = oldProductId;
            return this;
        }

        @Deprecated(message = "Use googleReplacementMode()", replaceWith = @ReplaceWith(expression = "googleReplacementMode()", imports = {}))
        public final Builder googleProrationMode(GoogleProrationMode googleProrationMode) {
            Intrinsics.checkNotNullParameter(googleProrationMode, "googleProrationMode");
            this.googleReplacementMode = googleProrationMode.getAsGoogleReplacementMode$purchases_defaultsRelease();
            return this;
        }

        public final Builder googleReplacementMode(GoogleReplacementMode googleReplacementMode) {
            Intrinsics.checkNotNullParameter(googleReplacementMode, "googleReplacementMode");
            this.googleReplacementMode = googleReplacementMode;
            return this;
        }

        public PurchaseParams build() {
            StoreProduct storeProduct = this.product;
            if (storeProduct != null) {
                ensureNoTestProduct(storeProduct);
            }
            return new PurchaseParams(this);
        }
    }
}
