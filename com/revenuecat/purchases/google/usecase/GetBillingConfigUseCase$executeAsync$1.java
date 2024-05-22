package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingConfig;
import com.android.billingclient.api.BillingConfigResponseListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.GetBillingConfigParams;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.strings.OfferingStrings;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: GetBillingConfigUseCase.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
final class GetBillingConfigUseCase$executeAsync$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ GetBillingConfigUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetBillingConfigUseCase$executeAsync$1(GetBillingConfigUseCase getBillingConfigUseCase) {
        super(1);
        this.this$0 = getBillingConfigUseCase;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BillingClient billingClient) {
        invoke2(billingClient);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BillingClient invoke) {
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        GetBillingConfigParams build = GetBillingConfigParams.newBuilder().build();
        final GetBillingConfigUseCase getBillingConfigUseCase = this.this$0;
        invoke.getBillingConfigAsync(build, new BillingConfigResponseListener() { // from class: com.revenuecat.purchases.google.usecase.GetBillingConfigUseCase$executeAsync$1$$ExternalSyntheticLambda0
            @Override // com.android.billingclient.api.BillingConfigResponseListener
            public final void onBillingConfigResponse(BillingResult billingResult, BillingConfig billingConfig) {
                GetBillingConfigUseCase$executeAsync$1.invoke$lambda$0(atomicBoolean, getBillingConfigUseCase, billingResult, billingConfig);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(AtomicBoolean hasResponded, GetBillingConfigUseCase this$0, BillingResult result, BillingConfig billingConfig) {
        Intrinsics.checkNotNullParameter(hasResponded, "$hasResponded");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (hasResponded.getAndSet(true)) {
            LogIntent logIntent = LogIntent.GOOGLE_ERROR;
            String format = String.format(OfferingStrings.EXTRA_GET_BILLING_CONFIG_RESPONSE, Arrays.copyOf(new Object[]{Integer.valueOf(result.getResponseCode())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
            return;
        }
        BillingClientUseCase.processResult$default(this$0, result, billingConfig, null, null, 12, null);
    }
}
