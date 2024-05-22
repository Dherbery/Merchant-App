package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.QueryPurchasesParams;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.google.BillingClientParamBuildersKt;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: QueryPurchasesByTypeUseCase.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
final class QueryPurchasesByTypeUseCase$executeAsync$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ QueryPurchasesByTypeUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryPurchasesByTypeUseCase$executeAsync$1(QueryPurchasesByTypeUseCase queryPurchasesByTypeUseCase) {
        super(1);
        this.this$0 = queryPurchasesByTypeUseCase;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BillingClient billingClient) {
        invoke2(billingClient);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BillingClient invoke) {
        QueryPurchasesByTypeUseCaseParams queryPurchasesByTypeUseCaseParams;
        Unit unit;
        QueryPurchasesByTypeUseCaseParams queryPurchasesByTypeUseCaseParams2;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        queryPurchasesByTypeUseCaseParams = this.this$0.useCaseParams;
        QueryPurchasesParams buildQueryPurchasesParams = BillingClientParamBuildersKt.buildQueryPurchasesParams(queryPurchasesByTypeUseCaseParams.getProductType());
        if (buildQueryPurchasesParams != null) {
            final QueryPurchasesByTypeUseCase queryPurchasesByTypeUseCase = this.this$0;
            queryPurchasesByTypeUseCaseParams2 = queryPurchasesByTypeUseCase.useCaseParams;
            queryPurchasesByTypeUseCase.queryPurchasesAsyncWithTrackingEnsuringOneResponse(invoke, queryPurchasesByTypeUseCaseParams2.getProductType(), buildQueryPurchasesParams, new PurchasesResponseListener() { // from class: com.revenuecat.purchases.google.usecase.QueryPurchasesByTypeUseCase$executeAsync$1$$ExternalSyntheticLambda0
                @Override // com.android.billingclient.api.PurchasesResponseListener
                public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                    QueryPurchasesByTypeUseCase$executeAsync$1.invoke$lambda$1$lambda$0(QueryPurchasesByTypeUseCase.this, billingResult, list);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QueryPurchasesByTypeUseCase queryPurchasesByTypeUseCase2 = this.this$0;
            String format = String.format(PurchaseStrings.INVALID_PRODUCT_TYPE, Arrays.copyOf(new Object[]{"queryPurchasesByType"}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogUtilsKt.errorLog$default(format, null, 2, null);
            BillingResult build = BillingResult.newBuilder().setResponseCode(5).build();
            Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …                 .build()");
            BillingClientUseCase.processResult$default(queryPurchasesByTypeUseCase2, build, MapsKt.emptyMap(), null, null, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(QueryPurchasesByTypeUseCase this$0, BillingResult result, List purchases) {
        QueryPurchasesByTypeUseCaseParams queryPurchasesByTypeUseCaseParams;
        Map mapOfGooglePurchaseWrapper;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        queryPurchasesByTypeUseCaseParams = this$0.useCaseParams;
        mapOfGooglePurchaseWrapper = this$0.toMapOfGooglePurchaseWrapper(purchases, queryPurchasesByTypeUseCaseParams.getProductType());
        BillingClientUseCase.processResult$default(this$0, result, mapOfGooglePurchaseWrapper, null, null, 12, null);
    }
}
