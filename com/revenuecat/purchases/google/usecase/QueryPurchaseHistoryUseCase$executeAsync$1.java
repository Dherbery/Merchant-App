package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PurchaseHistoryResponseListener;
import com.android.billingclient.api.QueryPurchaseHistoryParams;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.google.BillingClientParamBuildersKt;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.strings.RestoreStrings;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: QueryPurchaseHistoryUseCase.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
final class QueryPurchaseHistoryUseCase$executeAsync$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ QueryPurchaseHistoryUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryPurchaseHistoryUseCase$executeAsync$1(QueryPurchaseHistoryUseCase queryPurchaseHistoryUseCase) {
        super(1);
        this.this$0 = queryPurchaseHistoryUseCase;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BillingClient billingClient) {
        invoke2(billingClient);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BillingClient invoke) {
        QueryPurchaseHistoryUseCaseParams queryPurchaseHistoryUseCaseParams;
        QueryPurchaseHistoryUseCaseParams queryPurchaseHistoryUseCaseParams2;
        Unit unit;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        queryPurchaseHistoryUseCaseParams = this.this$0.useCaseParams;
        final Date now = queryPurchaseHistoryUseCaseParams.getDateProvider().getNow();
        queryPurchaseHistoryUseCaseParams2 = this.this$0.useCaseParams;
        QueryPurchaseHistoryParams buildQueryPurchaseHistoryParams = BillingClientParamBuildersKt.buildQueryPurchaseHistoryParams(queryPurchaseHistoryUseCaseParams2.getProductType());
        if (buildQueryPurchaseHistoryParams != null) {
            final QueryPurchaseHistoryUseCase queryPurchaseHistoryUseCase = this.this$0;
            invoke.queryPurchaseHistoryAsync(buildQueryPurchaseHistoryParams, new PurchaseHistoryResponseListener() { // from class: com.revenuecat.purchases.google.usecase.QueryPurchaseHistoryUseCase$executeAsync$1$$ExternalSyntheticLambda0
                @Override // com.android.billingclient.api.PurchaseHistoryResponseListener
                public final void onPurchaseHistoryResponse(BillingResult billingResult, List list) {
                    QueryPurchaseHistoryUseCase$executeAsync$1.invoke$lambda$1$lambda$0(atomicBoolean, queryPurchaseHistoryUseCase, now, billingResult, list);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QueryPurchaseHistoryUseCase queryPurchaseHistoryUseCase2 = this.this$0;
            String format = String.format(PurchaseStrings.INVALID_PRODUCT_TYPE, Arrays.copyOf(new Object[]{"queryPurchaseHistory"}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogUtilsKt.errorLog$default(format, null, 2, null);
            BillingResult build = BillingResult.newBuilder().setResponseCode(5).build();
            Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …                 .build()");
            BillingClientUseCase.processResult$default(queryPurchaseHistoryUseCase2, build, null, null, null, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(AtomicBoolean hasResponded, QueryPurchaseHistoryUseCase this$0, Date requestStartTime, BillingResult billingResult, List list) {
        QueryPurchaseHistoryUseCaseParams queryPurchaseHistoryUseCaseParams;
        Intrinsics.checkNotNullParameter(hasResponded, "$hasResponded");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(requestStartTime, "$requestStartTime");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        if (!hasResponded.getAndSet(true)) {
            queryPurchaseHistoryUseCaseParams = this$0.useCaseParams;
            this$0.trackGoogleQueryPurchaseHistoryRequestIfNeeded(queryPurchaseHistoryUseCaseParams.getProductType(), billingResult, requestStartTime);
            BillingClientUseCase.processResult$default(this$0, billingResult, list, null, null, 12, null);
        } else {
            LogIntent logIntent = LogIntent.GOOGLE_ERROR;
            String format = String.format(RestoreStrings.EXTRA_QUERY_PURCHASE_HISTORY_RESPONSE, Arrays.copyOf(new Object[]{Integer.valueOf(billingResult.getResponseCode())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
        }
    }
}
