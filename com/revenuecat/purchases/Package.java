package com.revenuecat.purchases;

import com.revenuecat.purchases.models.StoreProduct;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Package.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/revenuecat/purchases/Package;", "", "identifier", "", "packageType", "Lcom/revenuecat/purchases/PackageType;", "product", "Lcom/revenuecat/purchases/models/StoreProduct;", "offering", "(Ljava/lang/String;Lcom/revenuecat/purchases/PackageType;Lcom/revenuecat/purchases/models/StoreProduct;Ljava/lang/String;)V", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Ljava/lang/String;Lcom/revenuecat/purchases/PackageType;Lcom/revenuecat/purchases/models/StoreProduct;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "getIdentifier", "()Ljava/lang/String;", "getOffering$annotations", "()V", "getOffering", "getPackageType", "()Lcom/revenuecat/purchases/PackageType;", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getProduct", "()Lcom/revenuecat/purchases/models/StoreProduct;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Package {
    private final String identifier;
    private final PackageType packageType;
    private final PresentedOfferingContext presentedOfferingContext;
    private final StoreProduct product;

    public static /* synthetic */ Package copy$default(Package r0, String str, PackageType packageType, StoreProduct storeProduct, PresentedOfferingContext presentedOfferingContext, int i, Object obj) {
        if ((i & 1) != 0) {
            str = r0.identifier;
        }
        if ((i & 2) != 0) {
            packageType = r0.packageType;
        }
        if ((i & 4) != 0) {
            storeProduct = r0.product;
        }
        if ((i & 8) != 0) {
            presentedOfferingContext = r0.presentedOfferingContext;
        }
        return r0.copy(str, packageType, storeProduct, presentedOfferingContext);
    }

    @Deprecated(message = "Use presentedOfferingContext.offeringIdentifier instead", replaceWith = @ReplaceWith(expression = "presentedOfferingContext.offeringIdentifier", imports = {}))
    public static /* synthetic */ void getOffering$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    /* renamed from: component2, reason: from getter */
    public final PackageType getPackageType() {
        return this.packageType;
    }

    /* renamed from: component3, reason: from getter */
    public final StoreProduct getProduct() {
        return this.product;
    }

    /* renamed from: component4, reason: from getter */
    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public final Package copy(String identifier, PackageType packageType, StoreProduct product, PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(packageType, "packageType");
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        return new Package(identifier, packageType, product, presentedOfferingContext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Package)) {
            return false;
        }
        Package r5 = (Package) other;
        return Intrinsics.areEqual(this.identifier, r5.identifier) && this.packageType == r5.packageType && Intrinsics.areEqual(this.product, r5.product) && Intrinsics.areEqual(this.presentedOfferingContext, r5.presentedOfferingContext);
    }

    public int hashCode() {
        return (((((this.identifier.hashCode() * 31) + this.packageType.hashCode()) * 31) + this.product.hashCode()) * 31) + this.presentedOfferingContext.hashCode();
    }

    public String toString() {
        return "Package(identifier=" + this.identifier + ", packageType=" + this.packageType + ", product=" + this.product + ", presentedOfferingContext=" + this.presentedOfferingContext + ')';
    }

    public Package(String identifier, PackageType packageType, StoreProduct product, PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(packageType, "packageType");
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        this.identifier = identifier;
        this.packageType = packageType;
        this.product = product;
        this.presentedOfferingContext = presentedOfferingContext;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final PackageType getPackageType() {
        return this.packageType;
    }

    public final StoreProduct getProduct() {
        return this.product;
    }

    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use constructor with presentedOfferingContext instead", replaceWith = @ReplaceWith(expression = "Package(identifier, packageType, product, PresentedOfferingContext(offeringIdentifier = offering))", imports = {}))
    public Package(String identifier, PackageType packageType, StoreProduct product, String offering) {
        this(identifier, packageType, product, new PresentedOfferingContext(offering));
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(packageType, "packageType");
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(offering, "offering");
    }

    public final String getOffering() {
        String offeringIdentifier = this.presentedOfferingContext.getOfferingIdentifier();
        return offeringIdentifier == null ? "" : offeringIdentifier;
    }
}
