package com.revenuecat.purchases.common.offerings;

import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfferingsFactory.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "inAppProducts", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class OfferingsFactory$getStoreProductsById$1$1$1 extends Lambda implements Function1<List<? extends StoreProduct>, Unit> {
    final /* synthetic */ Function1<Map<String, ? extends List<? extends StoreProduct>>, Unit> $onCompleted;
    final /* synthetic */ Map<String, List<StoreProduct>> $productsById;
    final /* synthetic */ OfferingsFactory this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OfferingsFactory$getStoreProductsById$1$1$1(OfferingsFactory offeringsFactory, Map<String, List<StoreProduct>> map, Function1<? super Map<String, ? extends List<? extends StoreProduct>>, Unit> function1) {
        super(1);
        this.this$0 = offeringsFactory;
        this.$productsById = map;
        this.$onCompleted = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreProduct> list) {
        invoke2(list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final List<? extends StoreProduct> inAppProducts) {
        Dispatcher dispatcher;
        Intrinsics.checkNotNullParameter(inAppProducts, "inAppProducts");
        dispatcher = this.this$0.dispatcher;
        final Map<String, List<StoreProduct>> map = this.$productsById;
        final Function1<Map<String, ? extends List<? extends StoreProduct>>, Unit> function1 = this.$onCompleted;
        Dispatcher.enqueue$default(dispatcher, new Runnable() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory$getStoreProductsById$1$1$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                OfferingsFactory$getStoreProductsById$1$1$1.invoke$lambda$1(map, inAppProducts, function1);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(Map productsById, List inAppProducts, Function1 onCompleted) {
        Intrinsics.checkNotNullParameter(productsById, "$productsById");
        Intrinsics.checkNotNullParameter(inAppProducts, "$inAppProducts");
        Intrinsics.checkNotNullParameter(onCompleted, "$onCompleted");
        List<StoreProduct> list = inAppProducts;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (StoreProduct storeProduct : list) {
            arrayList.add(TuplesKt.to(storeProduct.getPurchasingData().getProductId(), CollectionsKt.listOf(storeProduct)));
        }
        MapsKt.putAll(productsById, arrayList);
        onCompleted.invoke(productsById);
    }
}
