package com.revenuecat.purchases.common.offerings;

import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfferingsFactory.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "subscriptionProducts", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class OfferingsFactory$getStoreProductsById$1 extends Lambda implements Function1<List<? extends StoreProduct>, Unit> {
    final /* synthetic */ Function1<Map<String, ? extends List<? extends StoreProduct>>, Unit> $onCompleted;
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Set<String> $productIds;
    final /* synthetic */ OfferingsFactory this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OfferingsFactory$getStoreProductsById$1(OfferingsFactory offeringsFactory, Set<String> set, Function1<? super Map<String, ? extends List<? extends StoreProduct>>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        super(1);
        this.this$0 = offeringsFactory;
        this.$productIds = set;
        this.$onCompleted = function1;
        this.$onError = function12;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreProduct> list) {
        invoke2(list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final List<? extends StoreProduct> subscriptionProducts) {
        Dispatcher dispatcher;
        Intrinsics.checkNotNullParameter(subscriptionProducts, "subscriptionProducts");
        dispatcher = this.this$0.dispatcher;
        final Set<String> set = this.$productIds;
        final OfferingsFactory offeringsFactory = this.this$0;
        final Function1<Map<String, ? extends List<? extends StoreProduct>>, Unit> function1 = this.$onCompleted;
        final Function1<PurchasesError, Unit> function12 = this.$onError;
        Dispatcher.enqueue$default(dispatcher, new Runnable() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory$getStoreProductsById$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                OfferingsFactory$getStoreProductsById$1.invoke$lambda$1(subscriptionProducts, set, offeringsFactory, function1, function12);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(List subscriptionProducts, Set productIds, OfferingsFactory this$0, Function1 onCompleted, final Function1 onError) {
        BillingAbstract billingAbstract;
        Intrinsics.checkNotNullParameter(subscriptionProducts, "$subscriptionProducts");
        Intrinsics.checkNotNullParameter(productIds, "$productIds");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onCompleted, "$onCompleted");
        Intrinsics.checkNotNullParameter(onError, "$onError");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : subscriptionProducts) {
            String productId = ((StoreProduct) obj).getPurchasingData().getProductId();
            Object obj2 = linkedHashMap.get(productId);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(productId, obj2);
            }
            ((List) obj2).add(obj);
        }
        Map mutableMap = MapsKt.toMutableMap(linkedHashMap);
        Set<String> minus = SetsKt.minus(productIds, (Iterable) mutableMap.keySet());
        if (!minus.isEmpty()) {
            billingAbstract = this$0.billing;
            billingAbstract.queryProductDetailsAsync(ProductType.INAPP, minus, new OfferingsFactory$getStoreProductsById$1$1$1(this$0, mutableMap, onCompleted), new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory$getStoreProductsById$1$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                    invoke2(purchasesError);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PurchasesError it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    onError.invoke(it);
                }
            });
        } else {
            onCompleted.invoke(mutableMap);
        }
    }
}
