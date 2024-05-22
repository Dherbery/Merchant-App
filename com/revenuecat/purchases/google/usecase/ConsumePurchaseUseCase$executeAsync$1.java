package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ConsumePurchaseUseCase.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
final class ConsumePurchaseUseCase$executeAsync$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ ConsumePurchaseUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumePurchaseUseCase$executeAsync$1(ConsumePurchaseUseCase consumePurchaseUseCase) {
        super(1);
        this.this$0 = consumePurchaseUseCase;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BillingClient billingClient) {
        invoke2(billingClient);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BillingClient invoke) {
        ConsumePurchaseUseCaseParams consumePurchaseUseCaseParams;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        ConsumeParams.Builder newBuilder = ConsumeParams.newBuilder();
        consumePurchaseUseCaseParams = this.this$0.useCaseParams;
        ConsumeParams build = newBuilder.setPurchaseToken(consumePurchaseUseCaseParams.getPurchaseToken()).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …\n                .build()");
        final ConsumePurchaseUseCase consumePurchaseUseCase = this.this$0;
        invoke.consumeAsync(build, new ConsumeResponseListener() { // from class: com.revenuecat.purchases.google.usecase.ConsumePurchaseUseCase$executeAsync$1$$ExternalSyntheticLambda0
            @Override // com.android.billingclient.api.ConsumeResponseListener
            public final void onConsumeResponse(BillingResult billingResult, String str) {
                ConsumePurchaseUseCase$executeAsync$1.invoke$processResult(ConsumePurchaseUseCase.this, billingResult, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ void invoke$processResult(ConsumePurchaseUseCase consumePurchaseUseCase, BillingResult billingResult, String str) {
        BillingClientUseCase.processResult$default(consumePurchaseUseCase, billingResult, str, null, null, 12, null);
    }
}
