package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.revenuecat.purchases.google.BillingClientParamBuildersKt;
import com.revenuecat.purchases.google.ProductTypeConversionsKt;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: QueryProductDetailsUseCase.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
final class QueryProductDetailsUseCase$executeAsync$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ Set<String> $nonEmptyProductIds;
    final /* synthetic */ QueryProductDetailsUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryProductDetailsUseCase$executeAsync$1(QueryProductDetailsUseCase queryProductDetailsUseCase, Set<String> set) {
        super(1);
        this.this$0 = queryProductDetailsUseCase;
        this.$nonEmptyProductIds = set;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BillingClient billingClient) {
        invoke2(billingClient);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BillingClient invoke) {
        QueryProductDetailsUseCaseParams queryProductDetailsUseCaseParams;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        queryProductDetailsUseCaseParams = this.this$0.useCaseParams;
        String googleProductType = ProductTypeConversionsKt.toGoogleProductType(queryProductDetailsUseCaseParams.getProductType());
        if (googleProductType == null) {
            googleProductType = "inapp";
        }
        QueryProductDetailsParams buildQueryProductDetailsParams = BillingClientParamBuildersKt.buildQueryProductDetailsParams(googleProductType, this.$nonEmptyProductIds);
        final QueryProductDetailsUseCase queryProductDetailsUseCase = this.this$0;
        queryProductDetailsUseCase.queryProductDetailsAsyncEnsuringOneResponse(invoke, googleProductType, buildQueryProductDetailsParams, new ProductDetailsResponseListener() { // from class: com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase$executeAsync$1$$ExternalSyntheticLambda0
            @Override // com.android.billingclient.api.ProductDetailsResponseListener
            public final void onProductDetailsResponse(BillingResult billingResult, List list) {
                QueryProductDetailsUseCase$executeAsync$1.invoke$processResult(QueryProductDetailsUseCase.this, billingResult, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ void invoke$processResult(QueryProductDetailsUseCase queryProductDetailsUseCase, BillingResult billingResult, List list) {
        BillingClientUseCase.processResult$default(queryProductDetailsUseCase, billingResult, list, null, null, 12, null);
    }
}
