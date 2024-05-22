package com.revenuecat.purchases;

import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PostTransactionWithProductDetailsHelper.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006Jt\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\"\b\u0002\u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013j\u0004\u0018\u0001`\u00152\"\b\u0002\u0010\u0016\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013j\u0004\u0018\u0001`\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/revenuecat/purchases/PostTransactionWithProductDetailsHelper;", "", "billing", "Lcom/revenuecat/purchases/common/BillingAbstract;", "postReceiptHelper", "Lcom/revenuecat/purchases/PostReceiptHelper;", "(Lcom/revenuecat/purchases/common/BillingAbstract;Lcom/revenuecat/purchases/PostReceiptHelper;)V", "postTransactions", "", "transactions", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "allowSharingPlayStoreAccount", "", "appUserID", "", "initiationSource", "Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "transactionPostSuccess", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/CustomerInfo;", "Lcom/revenuecat/purchases/SuccessfulPurchaseCallback;", "transactionPostError", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/ErrorPurchaseCallback;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PostTransactionWithProductDetailsHelper {
    private final BillingAbstract billing;
    private final PostReceiptHelper postReceiptHelper;

    public PostTransactionWithProductDetailsHelper(BillingAbstract billing, PostReceiptHelper postReceiptHelper) {
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(postReceiptHelper, "postReceiptHelper");
        this.billing = billing;
        this.postReceiptHelper = postReceiptHelper;
    }

    public final void postTransactions(List<StoreTransaction> transactions, final boolean allowSharingPlayStoreAccount, final String appUserID, final PostReceiptInitiationSource initiationSource, final Function2<? super StoreTransaction, ? super CustomerInfo, Unit> transactionPostSuccess, final Function2<? super StoreTransaction, ? super PurchasesError, Unit> transactionPostError) {
        Intrinsics.checkNotNullParameter(transactions, "transactions");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        for (final StoreTransaction storeTransaction : transactions) {
            if (storeTransaction.getPurchaseState() != PurchaseState.PENDING) {
                this.billing.queryProductDetailsAsync(storeTransaction.getType(), CollectionsKt.toSet(storeTransaction.getProductIds()), new Function1<List<? extends StoreProduct>, Unit>() { // from class: com.revenuecat.purchases.PostTransactionWithProductDetailsHelper$postTransactions$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreProduct> list) {
                        invoke2(list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<? extends StoreProduct> storeProducts) {
                        StoreProduct storeProduct;
                        PostReceiptHelper postReceiptHelper;
                        Intrinsics.checkNotNullParameter(storeProducts, "storeProducts");
                        Object obj = null;
                        if (StoreTransaction.this.getType() == ProductType.SUBS) {
                            StoreTransaction storeTransaction2 = StoreTransaction.this;
                            Iterator<T> it = storeProducts.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                Object next = it.next();
                                SubscriptionOptions subscriptionOptions = ((StoreProduct) next).getSubscriptionOptions();
                                boolean z = false;
                                if (subscriptionOptions != null) {
                                    SubscriptionOptions subscriptionOptions2 = subscriptionOptions;
                                    if (!(subscriptionOptions2 instanceof Collection) || !subscriptionOptions2.isEmpty()) {
                                        Iterator<SubscriptionOption> it2 = subscriptionOptions2.iterator();
                                        while (true) {
                                            if (!it2.hasNext()) {
                                                break;
                                            } else if (Intrinsics.areEqual(it2.next().getId(), storeTransaction2.getSubscriptionOptionId())) {
                                                z = true;
                                                break;
                                            }
                                        }
                                    }
                                }
                                if (z) {
                                    obj = next;
                                    break;
                                }
                            }
                            storeProduct = (StoreProduct) obj;
                        } else {
                            StoreTransaction storeTransaction3 = StoreTransaction.this;
                            Iterator<T> it3 = storeProducts.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    break;
                                }
                                Object next2 = it3.next();
                                if (Intrinsics.areEqual(((StoreProduct) next2).getId(), CollectionsKt.firstOrNull((List) storeTransaction3.getProductIds()))) {
                                    obj = next2;
                                    break;
                                }
                            }
                            storeProduct = (StoreProduct) obj;
                        }
                        postReceiptHelper = this.postReceiptHelper;
                        postReceiptHelper.postTransactionAndConsumeIfNeeded(StoreTransaction.this, storeProduct, allowSharingPlayStoreAccount, appUserID, initiationSource, transactionPostSuccess, transactionPostError);
                    }
                }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostTransactionWithProductDetailsHelper$postTransactions$1$2
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
                        PostReceiptHelper postReceiptHelper;
                        Intrinsics.checkNotNullParameter(it, "it");
                        postReceiptHelper = PostTransactionWithProductDetailsHelper.this.postReceiptHelper;
                        postReceiptHelper.postTransactionAndConsumeIfNeeded(storeTransaction, null, allowSharingPlayStoreAccount, appUserID, initiationSource, transactionPostSuccess, transactionPostError);
                    }
                });
            } else if (transactionPostError != null) {
                PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.PaymentPendingError, null, 2, null);
                LogUtilsKt.errorLog(purchasesError);
                Unit unit = Unit.INSTANCE;
                transactionPostError.invoke(storeTransaction, purchasesError);
            }
        }
    }
}
