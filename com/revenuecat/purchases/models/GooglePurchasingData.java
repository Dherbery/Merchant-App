package com.revenuecat.purchases.models;

import com.android.billingclient.api.ProductDetails;
import com.revenuecat.purchases.ProductType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GooglePurchasingData.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/models/GooglePurchasingData;", "Lcom/revenuecat/purchases/models/PurchasingData;", "()V", "productType", "Lcom/revenuecat/purchases/ProductType;", "getProductType", "()Lcom/revenuecat/purchases/ProductType;", "InAppProduct", "Subscription", "Lcom/revenuecat/purchases/models/GooglePurchasingData$InAppProduct;", "Lcom/revenuecat/purchases/models/GooglePurchasingData$Subscription;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public abstract class GooglePurchasingData implements PurchasingData {
    public /* synthetic */ GooglePurchasingData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private GooglePurchasingData() {
    }

    /* compiled from: GooglePurchasingData.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/models/GooglePurchasingData$InAppProduct;", "Lcom/revenuecat/purchases/models/GooglePurchasingData;", "productId", "", "productDetails", "Lcom/android/billingclient/api/ProductDetails;", "(Ljava/lang/String;Lcom/android/billingclient/api/ProductDetails;)V", "getProductDetails", "()Lcom/android/billingclient/api/ProductDetails;", "getProductId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class InAppProduct extends GooglePurchasingData {
        private final ProductDetails productDetails;
        private final String productId;

        public static /* synthetic */ InAppProduct copy$default(InAppProduct inAppProduct, String str, ProductDetails productDetails, int i, Object obj) {
            if ((i & 1) != 0) {
                str = inAppProduct.getProductId();
            }
            if ((i & 2) != 0) {
                productDetails = inAppProduct.productDetails;
            }
            return inAppProduct.copy(str, productDetails);
        }

        public final String component1() {
            return getProductId();
        }

        /* renamed from: component2, reason: from getter */
        public final ProductDetails getProductDetails() {
            return this.productDetails;
        }

        public final InAppProduct copy(String productId, ProductDetails productDetails) {
            Intrinsics.checkNotNullParameter(productId, "productId");
            Intrinsics.checkNotNullParameter(productDetails, "productDetails");
            return new InAppProduct(productId, productDetails);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InAppProduct)) {
                return false;
            }
            InAppProduct inAppProduct = (InAppProduct) other;
            return Intrinsics.areEqual(getProductId(), inAppProduct.getProductId()) && Intrinsics.areEqual(this.productDetails, inAppProduct.productDetails);
        }

        public int hashCode() {
            return (getProductId().hashCode() * 31) + this.productDetails.hashCode();
        }

        public String toString() {
            return "InAppProduct(productId=" + getProductId() + ", productDetails=" + this.productDetails + ')';
        }

        @Override // com.revenuecat.purchases.models.PurchasingData
        public String getProductId() {
            return this.productId;
        }

        public final ProductDetails getProductDetails() {
            return this.productDetails;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InAppProduct(String productId, ProductDetails productDetails) {
            super(null);
            Intrinsics.checkNotNullParameter(productId, "productId");
            Intrinsics.checkNotNullParameter(productDetails, "productDetails");
            this.productId = productId;
            this.productDetails = productDetails;
        }
    }

    /* compiled from: GooglePurchasingData.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/models/GooglePurchasingData$Subscription;", "Lcom/revenuecat/purchases/models/GooglePurchasingData;", "productId", "", "optionId", "productDetails", "Lcom/android/billingclient/api/ProductDetails;", "token", "(Ljava/lang/String;Ljava/lang/String;Lcom/android/billingclient/api/ProductDetails;Ljava/lang/String;)V", "getOptionId", "()Ljava/lang/String;", "getProductDetails", "()Lcom/android/billingclient/api/ProductDetails;", "getProductId", "getToken", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Subscription extends GooglePurchasingData {
        private final String optionId;
        private final ProductDetails productDetails;
        private final String productId;
        private final String token;

        public static /* synthetic */ Subscription copy$default(Subscription subscription, String str, String str2, ProductDetails productDetails, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subscription.getProductId();
            }
            if ((i & 2) != 0) {
                str2 = subscription.optionId;
            }
            if ((i & 4) != 0) {
                productDetails = subscription.productDetails;
            }
            if ((i & 8) != 0) {
                str3 = subscription.token;
            }
            return subscription.copy(str, str2, productDetails, str3);
        }

        public final String component1() {
            return getProductId();
        }

        /* renamed from: component2, reason: from getter */
        public final String getOptionId() {
            return this.optionId;
        }

        /* renamed from: component3, reason: from getter */
        public final ProductDetails getProductDetails() {
            return this.productDetails;
        }

        /* renamed from: component4, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        public final Subscription copy(String productId, String optionId, ProductDetails productDetails, String token) {
            Intrinsics.checkNotNullParameter(productId, "productId");
            Intrinsics.checkNotNullParameter(optionId, "optionId");
            Intrinsics.checkNotNullParameter(productDetails, "productDetails");
            Intrinsics.checkNotNullParameter(token, "token");
            return new Subscription(productId, optionId, productDetails, token);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Subscription)) {
                return false;
            }
            Subscription subscription = (Subscription) other;
            return Intrinsics.areEqual(getProductId(), subscription.getProductId()) && Intrinsics.areEqual(this.optionId, subscription.optionId) && Intrinsics.areEqual(this.productDetails, subscription.productDetails) && Intrinsics.areEqual(this.token, subscription.token);
        }

        public int hashCode() {
            return (((((getProductId().hashCode() * 31) + this.optionId.hashCode()) * 31) + this.productDetails.hashCode()) * 31) + this.token.hashCode();
        }

        public String toString() {
            return "Subscription(productId=" + getProductId() + ", optionId=" + this.optionId + ", productDetails=" + this.productDetails + ", token=" + this.token + ')';
        }

        @Override // com.revenuecat.purchases.models.PurchasingData
        public String getProductId() {
            return this.productId;
        }

        public final String getOptionId() {
            return this.optionId;
        }

        public final ProductDetails getProductDetails() {
            return this.productDetails;
        }

        public final String getToken() {
            return this.token;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Subscription(String productId, String optionId, ProductDetails productDetails, String token) {
            super(null);
            Intrinsics.checkNotNullParameter(productId, "productId");
            Intrinsics.checkNotNullParameter(optionId, "optionId");
            Intrinsics.checkNotNullParameter(productDetails, "productDetails");
            Intrinsics.checkNotNullParameter(token, "token");
            this.productId = productId;
            this.optionId = optionId;
            this.productDetails = productDetails;
            this.token = token;
        }
    }

    @Override // com.revenuecat.purchases.models.PurchasingData
    public ProductType getProductType() {
        if (this instanceof InAppProduct) {
            return ProductType.INAPP;
        }
        if (this instanceof Subscription) {
            return ProductType.SUBS;
        }
        throw new NoWhenBranchMatchedException();
    }
}
