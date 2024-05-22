package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: AcknowledgePurchaseUseCase.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
final class AcknowledgePurchaseUseCase$executeAsync$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ AcknowledgePurchaseUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcknowledgePurchaseUseCase$executeAsync$1(AcknowledgePurchaseUseCase acknowledgePurchaseUseCase) {
        super(1);
        this.this$0 = acknowledgePurchaseUseCase;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BillingClient billingClient) {
        invoke2(billingClient);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BillingClient invoke) {
        AcknowledgePurchaseUseCaseParams acknowledgePurchaseUseCaseParams;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        AcknowledgePurchaseParams.Builder newBuilder = AcknowledgePurchaseParams.newBuilder();
        acknowledgePurchaseUseCaseParams = this.this$0.useCaseParams;
        AcknowledgePurchaseParams build = newBuilder.setPurchaseToken(acknowledgePurchaseUseCaseParams.getPurchaseToken()).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …\n                .build()");
        final AcknowledgePurchaseUseCase acknowledgePurchaseUseCase = this.this$0;
        invoke.acknowledgePurchase(build, new AcknowledgePurchaseResponseListener() { // from class: com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCase$executeAsync$1$$ExternalSyntheticLambda0
            @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
            public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                AcknowledgePurchaseUseCase$executeAsync$1.invoke$lambda$0(AcknowledgePurchaseUseCase.this, billingResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(AcknowledgePurchaseUseCase this$0, BillingResult billingResult) {
        AcknowledgePurchaseUseCaseParams acknowledgePurchaseUseCaseParams;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        AcknowledgePurchaseUseCase acknowledgePurchaseUseCase = this$0;
        acknowledgePurchaseUseCaseParams = this$0.useCaseParams;
        BillingClientUseCase.processResult$default(acknowledgePurchaseUseCase, billingResult, acknowledgePurchaseUseCaseParams.getPurchaseToken(), null, null, 12, null);
    }
}
