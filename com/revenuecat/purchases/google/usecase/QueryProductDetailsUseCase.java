package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.google.StoreProductConversionsKt;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.strings.OfferingStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* compiled from: QueryProductDetailsUseCase.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B²\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001c\u0010\u0006\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0002\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\r\u0012#\u0010\u000e\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\u0010\u0012\u0004\u0012\u00020\t0\u0007\u0012H\u0010\u0011\u001aD\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\t0\u0012j\u0002`\u0017¢\u0006\u0002\u0010\u0018J\b\u0010!\u001a\u00020\tH\u0016J\u0016\u0010\"\u001a\u00020\t2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J(\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J \u0010+\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR'\u0010\u0006\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0002\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u000e\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\u0010\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001e¨\u00060"}, d2 = {"Lcom/revenuecat/purchases/google/usecase/QueryProductDetailsUseCase;", "Lcom/revenuecat/purchases/google/usecase/BillingClientUseCase;", "", "Lcom/android/billingclient/api/ProductDetails;", "useCaseParams", "Lcom/revenuecat/purchases/google/usecase/QueryProductDetailsUseCaseParams;", "onReceive", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/models/StoreProduct;", "", "Lcom/revenuecat/purchases/common/StoreProductsCallback;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "withConnectedClient", "Lcom/android/billingclient/api/BillingClient;", "Lkotlin/ExtensionFunctionType;", "executeRequestOnUIThread", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "delayInMillis", "Lcom/revenuecat/purchases/google/usecase/ExecuteRequestOnUIThreadFunction;", "(Lcom/revenuecat/purchases/google/usecase/QueryProductDetailsUseCaseParams;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "getOnError", "()Lkotlin/jvm/functions/Function1;", "getOnReceive", "getWithConnectedClient", "executeAsync", "onOk", "received", "queryProductDetailsAsyncEnsuringOneResponse", "billingClient", "productType", OutcomeEventsTable.COLUMN_NAME_PARAMS, "Lcom/android/billingclient/api/QueryProductDetailsParams;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/android/billingclient/api/ProductDetailsResponseListener;", "trackGoogleQueryProductDetailsRequestIfNeeded", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "requestStartTime", "Ljava/util/Date;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class QueryProductDetailsUseCase extends BillingClientUseCase<List<? extends ProductDetails>> {
    private final Function1<PurchasesError, Unit> onError;
    private final Function1<List<? extends StoreProduct>, Unit> onReceive;
    private final QueryProductDetailsUseCaseParams useCaseParams;
    private final Function1<Function1<? super BillingClient, Unit>, Unit> withConnectedClient;

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public String getErrorMessage() {
        return "Error when fetching products";
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public /* bridge */ /* synthetic */ void onOk(List<? extends ProductDetails> list) {
        onOk2((List<ProductDetails>) list);
    }

    public final Function1<List<? extends StoreProduct>, Unit> getOnReceive() {
        return this.onReceive;
    }

    public final Function1<PurchasesError, Unit> getOnError() {
        return this.onError;
    }

    public final Function1<Function1<? super BillingClient, Unit>, Unit> getWithConnectedClient() {
        return this.withConnectedClient;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QueryProductDetailsUseCase(QueryProductDetailsUseCaseParams useCaseParams, Function1<? super List<? extends StoreProduct>, Unit> onReceive, Function1<? super PurchasesError, Unit> onError, Function1<? super Function1<? super BillingClient, Unit>, Unit> withConnectedClient, Function2<? super Long, ? super Function1<? super PurchasesError, Unit>, Unit> executeRequestOnUIThread) {
        super(useCaseParams, onError, executeRequestOnUIThread);
        Intrinsics.checkNotNullParameter(useCaseParams, "useCaseParams");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(withConnectedClient, "withConnectedClient");
        Intrinsics.checkNotNullParameter(executeRequestOnUIThread, "executeRequestOnUIThread");
        this.useCaseParams = useCaseParams;
        this.onReceive = onReceive;
        this.onError = onError;
        this.withConnectedClient = withConnectedClient;
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void executeAsync() {
        Set<String> productIds = this.useCaseParams.getProductIds();
        ArrayList arrayList = new ArrayList();
        for (Object obj : productIds) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        Set set = CollectionsKt.toSet(arrayList);
        if (set.isEmpty()) {
            LogWrapperKt.log(LogIntent.DEBUG, OfferingStrings.EMPTY_PRODUCT_ID_LIST);
            this.onReceive.invoke(CollectionsKt.emptyList());
        } else {
            this.withConnectedClient.invoke(new QueryProductDetailsUseCase$executeAsync$1(this, set));
        }
    }

    /* renamed from: onOk, reason: avoid collision after fix types in other method */
    public void onOk2(List<ProductDetails> received) {
        Intrinsics.checkNotNullParameter(received, "received");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(OfferingStrings.FETCHING_PRODUCTS_FINISHED, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(this.useCaseParams.getProductIds(), null, null, null, 0, null, null, 63, null)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        LogIntent logIntent2 = LogIntent.PURCHASE;
        String format2 = String.format(OfferingStrings.RETRIEVED_PRODUCTS, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(received, null, null, null, 0, null, new Function1<ProductDetails, CharSequence>() { // from class: com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase$onOk$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(ProductDetails it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String productDetails = it.toString();
                Intrinsics.checkNotNullExpressionValue(productDetails, "it.toString()");
                return productDetails;
            }
        }, 31, null)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
        LogWrapperKt.log(logIntent2, format2);
        List<ProductDetails> list = !received.isEmpty() ? received : null;
        if (list != null) {
            for (ProductDetails productDetails : list) {
                LogIntent logIntent3 = LogIntent.PURCHASE;
                String format3 = String.format(OfferingStrings.LIST_PRODUCTS, Arrays.copyOf(new Object[]{productDetails.getProductId(), productDetails}, 2));
                Intrinsics.checkNotNullExpressionValue(format3, "format(this, *args)");
                LogWrapperKt.log(logIntent3, format3);
            }
        }
        this.onReceive.invoke(StoreProductConversionsKt.toStoreProducts(received));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void queryProductDetailsAsyncEnsuringOneResponse(BillingClient billingClient, final String productType, QueryProductDetailsParams params, final ProductDetailsResponseListener listener) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Date now = this.useCaseParams.getDateProvider().getNow();
        billingClient.queryProductDetailsAsync(params, new ProductDetailsResponseListener() { // from class: com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase$$ExternalSyntheticLambda0
            @Override // com.android.billingclient.api.ProductDetailsResponseListener
            public final void onProductDetailsResponse(BillingResult billingResult, List list) {
                QueryProductDetailsUseCase.queryProductDetailsAsyncEnsuringOneResponse$lambda$3(atomicBoolean, this, productType, now, listener, billingResult, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryProductDetailsAsyncEnsuringOneResponse$lambda$3(AtomicBoolean hasResponded, QueryProductDetailsUseCase this$0, String productType, Date requestStartTime, ProductDetailsResponseListener listener, BillingResult billingResult, List productDetailsList) {
        Intrinsics.checkNotNullParameter(hasResponded, "$hasResponded");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(productType, "$productType");
        Intrinsics.checkNotNullParameter(requestStartTime, "$requestStartTime");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(productDetailsList, "productDetailsList");
        if (hasResponded.getAndSet(true)) {
            LogIntent logIntent = LogIntent.GOOGLE_ERROR;
            String format = String.format(OfferingStrings.EXTRA_QUERY_PRODUCT_DETAILS_RESPONSE, Arrays.copyOf(new Object[]{Integer.valueOf(billingResult.getResponseCode())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
            return;
        }
        this$0.trackGoogleQueryProductDetailsRequestIfNeeded(productType, billingResult, requestStartTime);
        listener.onProductDetailsResponse(billingResult, productDetailsList);
    }

    private final void trackGoogleQueryProductDetailsRequestIfNeeded(String productType, BillingResult billingResult, Date requestStartTime) {
        DiagnosticsTracker diagnosticsTrackerIfEnabled = this.useCaseParams.getDiagnosticsTrackerIfEnabled();
        if (diagnosticsTrackerIfEnabled != null) {
            int responseCode = billingResult.getResponseCode();
            String debugMessage = billingResult.getDebugMessage();
            Intrinsics.checkNotNullExpressionValue(debugMessage, "billingResult.debugMessage");
            diagnosticsTrackerIfEnabled.m1091trackGoogleQueryProductDetailsRequestWn2Vu4Y(productType, responseCode, debugMessage, DurationExtensionsKt.between(Duration.INSTANCE, requestStartTime, this.useCaseParams.getDateProvider().getNow()));
        }
    }
}
