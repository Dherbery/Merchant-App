package com.revenuecat.purchases.common;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReceiptInfo.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B[\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u0004H\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0011¨\u0006."}, d2 = {"Lcom/revenuecat/purchases/common/ReceiptInfo;", "", "productIDs", "", "", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "subscriptionOptionId", "storeProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", b.x, "", b.a, "replacementMode", "Lcom/revenuecat/purchases/ReplacementMode;", "(Ljava/util/List;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/String;Lcom/revenuecat/purchases/models/StoreProduct;Ljava/lang/Double;Ljava/lang/String;Lcom/revenuecat/purchases/ReplacementMode;)V", "getCurrency", "()Ljava/lang/String;", "duration", "getDuration", "platformProductIds", "Lcom/revenuecat/purchases/common/PlatformProductId;", "getPlatformProductIds$purchases_defaultsRelease", "()Ljava/util/List;", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPrice", "()Ljava/lang/Double;", "Ljava/lang/Double;", "pricingPhases", "Lcom/revenuecat/purchases/models/PricingPhase;", "getPricingPhases", "getProductIDs", "getReplacementMode", "()Lcom/revenuecat/purchases/ReplacementMode;", "getStoreProduct", "()Lcom/revenuecat/purchases/models/StoreProduct;", "subscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "getSubscriptionOptionId", "equals", "", "other", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ReceiptInfo {
    private final String currency;
    private final String duration;
    private final PresentedOfferingContext presentedOfferingContext;
    private final Double price;
    private final List<PricingPhase> pricingPhases;
    private final List<String> productIDs;
    private final ReplacementMode replacementMode;
    private final StoreProduct storeProduct;
    private final SubscriptionOption subscriptionOption;
    private final String subscriptionOptionId;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
    
        if ((r3.length() == 0) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ReceiptInfo(java.util.List<java.lang.String> r2, com.revenuecat.purchases.PresentedOfferingContext r3, java.lang.String r4, com.revenuecat.purchases.models.StoreProduct r5, java.lang.Double r6, java.lang.String r7, com.revenuecat.purchases.ReplacementMode r8) {
        /*
            r1 = this;
            java.lang.String r0 = "productIDs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r1.<init>()
            r1.productIDs = r2
            r1.presentedOfferingContext = r3
            r1.subscriptionOptionId = r4
            r1.storeProduct = r5
            r1.price = r6
            r1.currency = r7
            r1.replacementMode = r8
            r2 = 0
            if (r5 == 0) goto L34
            com.revenuecat.purchases.models.Period r3 = r5.getPeriod()
            if (r3 == 0) goto L34
            java.lang.String r3 = r3.getIso8601()
            if (r3 == 0) goto L34
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 != 0) goto L30
            r4 = 1
            goto L31
        L30:
            r4 = 0
        L31:
            if (r4 != 0) goto L34
            goto L35
        L34:
            r3 = r2
        L35:
            r1.duration = r3
            if (r5 == 0) goto L63
            com.revenuecat.purchases.models.SubscriptionOptions r3 = r5.getSubscriptionOptions()
            if (r3 == 0) goto L63
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L45:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L5f
            java.lang.Object r4 = r3.next()
            r5 = r4
            com.revenuecat.purchases.models.SubscriptionOption r5 = (com.revenuecat.purchases.models.SubscriptionOption) r5
            java.lang.String r5 = r5.getId()
            java.lang.String r6 = r1.subscriptionOptionId
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L45
            goto L60
        L5f:
            r4 = r2
        L60:
            com.revenuecat.purchases.models.SubscriptionOption r4 = (com.revenuecat.purchases.models.SubscriptionOption) r4
            goto L64
        L63:
            r4 = r2
        L64:
            r1.subscriptionOption = r4
            if (r4 == 0) goto L6c
            java.util.List r2 = r4.getPricingPhases()
        L6c:
            r1.pricingPhases = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.ReceiptInfo.<init>(java.util.List, com.revenuecat.purchases.PresentedOfferingContext, java.lang.String, com.revenuecat.purchases.models.StoreProduct, java.lang.Double, java.lang.String, com.revenuecat.purchases.ReplacementMode):void");
    }

    public final List<String> getProductIDs() {
        return this.productIDs;
    }

    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public final String getSubscriptionOptionId() {
        return this.subscriptionOptionId;
    }

    public final StoreProduct getStoreProduct() {
        return this.storeProduct;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ ReceiptInfo(java.util.List r9, com.revenuecat.purchases.PresentedOfferingContext r10, java.lang.String r11, com.revenuecat.purchases.models.StoreProduct r12, java.lang.Double r13, java.lang.String r14, com.revenuecat.purchases.ReplacementMode r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r8 = this;
            r0 = r16 & 2
            r1 = 0
            if (r0 == 0) goto L7
            r0 = r1
            goto L8
        L7:
            r0 = r10
        L8:
            r2 = r16 & 4
            if (r2 == 0) goto Le
            r2 = r1
            goto Lf
        Le:
            r2 = r11
        Lf:
            r3 = r16 & 8
            if (r3 == 0) goto L15
            r3 = r1
            goto L16
        L15:
            r3 = r12
        L16:
            r4 = r16 & 16
            if (r4 == 0) goto L34
            if (r3 == 0) goto L32
            com.revenuecat.purchases.models.Price r4 = r3.getPrice()
            if (r4 == 0) goto L32
            long r4 = r4.getAmountMicros()
            double r4 = (double) r4
            r6 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r4 = r4 / r6
            java.lang.Double r4 = java.lang.Double.valueOf(r4)
            goto L35
        L32:
            r4 = r1
            goto L35
        L34:
            r4 = r13
        L35:
            r5 = r16 & 32
            if (r5 == 0) goto L48
            if (r3 == 0) goto L46
            com.revenuecat.purchases.models.Price r5 = r3.getPrice()
            if (r5 == 0) goto L46
            java.lang.String r5 = r5.getCurrencyCode()
            goto L49
        L46:
            r5 = r1
            goto L49
        L48:
            r5 = r14
        L49:
            r6 = r16 & 64
            if (r6 == 0) goto L4e
            goto L4f
        L4e:
            r1 = r15
        L4f:
            r10 = r8
            r11 = r9
            r12 = r0
            r13 = r2
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r1
            r10.<init>(r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.ReceiptInfo.<init>(java.util.List, com.revenuecat.purchases.PresentedOfferingContext, java.lang.String, com.revenuecat.purchases.models.StoreProduct, java.lang.Double, java.lang.String, com.revenuecat.purchases.ReplacementMode, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Double getPrice() {
        return this.price;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final ReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final List<PricingPhase> getPricingPhases() {
        return this.pricingPhases;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.revenuecat.purchases.common.ReceiptInfo");
        ReceiptInfo receiptInfo = (ReceiptInfo) other;
        return Intrinsics.areEqual(this.productIDs, receiptInfo.productIDs) && Intrinsics.areEqual(this.presentedOfferingContext, receiptInfo.presentedOfferingContext) && Intrinsics.areEqual(this.storeProduct, receiptInfo.storeProduct) && Intrinsics.areEqual(this.price, receiptInfo.price) && Intrinsics.areEqual(this.currency, receiptInfo.currency) && Intrinsics.areEqual(this.subscriptionOptionId, receiptInfo.subscriptionOptionId);
    }

    public final List<PlatformProductId> getPlatformProductIds$purchases_defaultsRelease() {
        PlatformProductId platformProductId;
        SubscriptionOption subscriptionOption = this.subscriptionOption;
        if (subscriptionOption == null || (platformProductId = ReceiptInfoKt.platformProductId(subscriptionOption)) == null) {
            StoreProduct storeProduct = this.storeProduct;
            platformProductId = storeProduct != null ? ReceiptInfoKt.platformProductId(storeProduct) : null;
        }
        List<String> list = this.productIDs;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!Intrinsics.areEqual((String) obj, platformProductId != null ? platformProductId.getProductId() : null)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(new PlatformProductId((String) it.next()));
        }
        return CollectionsKt.plus((Collection) arrayList3, (Iterable) CollectionsKt.listOfNotNull(platformProductId));
    }

    public int hashCode() {
        int hashCode = this.productIDs.hashCode() * 31;
        PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
        int hashCode2 = (hashCode + (presentedOfferingContext != null ? presentedOfferingContext.hashCode() : 0)) * 31;
        StoreProduct storeProduct = this.storeProduct;
        int hashCode3 = (hashCode2 + (storeProduct != null ? storeProduct.hashCode() : 0)) * 31;
        String str = this.subscriptionOptionId;
        return hashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ReceiptInfo(productIDs='" + CollectionsKt.joinToString$default(this.productIDs, null, null, null, 0, null, null, 63, null) + "', presentedOfferingContext=" + this.presentedOfferingContext + ", storeProduct=" + this.storeProduct + ", subscriptionOptionId=" + this.subscriptionOptionId + ", pricingPhases=" + this.pricingPhases + ", price=" + this.price + ", currency=" + this.currency + ", duration=" + this.duration + ')';
    }
}
