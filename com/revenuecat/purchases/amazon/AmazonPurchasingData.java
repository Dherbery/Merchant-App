package com.revenuecat.purchases.amazon;

import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.PurchasingData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AmazonPurchasingData.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/amazon/AmazonPurchasingData;", "Lcom/revenuecat/purchases/models/PurchasingData;", "()V", "Product", "Lcom/revenuecat/purchases/amazon/AmazonPurchasingData$Product;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AmazonPurchasingData implements PurchasingData {
    public /* synthetic */ AmazonPurchasingData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AmazonPurchasingData() {
    }

    /* compiled from: AmazonPurchasingData.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/amazon/AmazonPurchasingData$Product;", "Lcom/revenuecat/purchases/amazon/AmazonPurchasingData;", "storeProduct", "Lcom/revenuecat/purchases/amazon/AmazonStoreProduct;", "(Lcom/revenuecat/purchases/amazon/AmazonStoreProduct;)V", "productId", "", "getProductId", "()Ljava/lang/String;", "productType", "Lcom/revenuecat/purchases/ProductType;", "getProductType", "()Lcom/revenuecat/purchases/ProductType;", "getStoreProduct", "()Lcom/revenuecat/purchases/amazon/AmazonStoreProduct;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Product extends AmazonPurchasingData {
        private final AmazonStoreProduct storeProduct;

        public static /* synthetic */ Product copy$default(Product product, AmazonStoreProduct amazonStoreProduct, int i, Object obj) {
            if ((i & 1) != 0) {
                amazonStoreProduct = product.storeProduct;
            }
            return product.copy(amazonStoreProduct);
        }

        /* renamed from: component1, reason: from getter */
        public final AmazonStoreProduct getStoreProduct() {
            return this.storeProduct;
        }

        public final Product copy(AmazonStoreProduct storeProduct) {
            Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
            return new Product(storeProduct);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Product) && Intrinsics.areEqual(this.storeProduct, ((Product) other).storeProduct);
        }

        public int hashCode() {
            return this.storeProduct.hashCode();
        }

        public String toString() {
            return "Product(storeProduct=" + this.storeProduct + ')';
        }

        public final AmazonStoreProduct getStoreProduct() {
            return this.storeProduct;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Product(AmazonStoreProduct storeProduct) {
            super(null);
            Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
            this.storeProduct = storeProduct;
        }

        @Override // com.revenuecat.purchases.models.PurchasingData
        public String getProductId() {
            return this.storeProduct.getId();
        }

        @Override // com.revenuecat.purchases.models.PurchasingData
        public ProductType getProductType() {
            return this.storeProduct.getType();
        }
    }
}
