package com.revenuecat.purchases;

import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SyncPurchasesHelper.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "allPurchases", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class SyncPurchasesHelper$syncPurchases$1 extends Lambda implements Function1<List<? extends StoreTransaction>, Unit> {
    final /* synthetic */ boolean $appInBackground;
    final /* synthetic */ String $appUserID;
    final /* synthetic */ boolean $isRestore;
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Function1<CustomerInfo, Unit> $onSuccess;
    final /* synthetic */ SyncPurchasesHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SyncPurchasesHelper$syncPurchases$1(SyncPurchasesHelper syncPurchasesHelper, String str, boolean z, boolean z2, Function1<? super CustomerInfo, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        super(1);
        this.this$0 = syncPurchasesHelper;
        this.$appUserID = str;
        this.$appInBackground = z;
        this.$isRestore = z2;
        this.$onSuccess = function1;
        this.$onError = function12;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreTransaction> list) {
        invoke2((List<StoreTransaction>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<StoreTransaction> allPurchases) {
        PostReceiptHelper postReceiptHelper;
        Intrinsics.checkNotNullParameter(allPurchases, "allPurchases");
        if (!(!allPurchases.isEmpty())) {
            this.this$0.retrieveCustomerInfo(this.$appUserID, this.$appInBackground, this.$isRestore, this.$onSuccess, this.$onError);
            return;
        }
        final StoreTransaction storeTransaction = (StoreTransaction) CollectionsKt.last((List) allPurchases);
        final ArrayList arrayList = new ArrayList();
        final SyncPurchasesHelper syncPurchasesHelper = this.this$0;
        final boolean z = this.$isRestore;
        String str = this.$appUserID;
        boolean z2 = this.$appInBackground;
        Function1<CustomerInfo, Unit> function1 = this.$onSuccess;
        Function1<PurchasesError, Unit> function12 = this.$onError;
        for (final StoreTransaction storeTransaction2 : allPurchases) {
            ReceiptInfo receiptInfo = new ReceiptInfo(storeTransaction2.getProductIds(), null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
            postReceiptHelper = syncPurchasesHelper.postReceiptHelper;
            final String str2 = str;
            final Function1<PurchasesError, Unit> function13 = function12;
            final boolean z3 = z2;
            final Function1<CustomerInfo, Unit> function14 = function1;
            final boolean z4 = z2;
            final String str3 = str;
            postReceiptHelper.postTokenWithoutConsuming(storeTransaction2.getPurchaseToken(), storeTransaction2.getStoreUserID(), receiptInfo, z, str3, storeTransaction2.getMarketplace(), PostReceiptInitiationSource.RESTORE, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                    invoke2(customerInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CustomerInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    LogIntent logIntent = LogIntent.PURCHASE;
                    String format = String.format(PurchaseStrings.PURCHASE_SYNCED, Arrays.copyOf(new Object[]{StoreTransaction.this}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                    LogWrapperKt.log(logIntent, format);
                    SyncPurchasesHelper$syncPurchases$1.invoke$handleLastPurchase(arrayList, syncPurchasesHelper, str2, z3, z, function14, function13, StoreTransaction.this, storeTransaction);
                }
            }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$1$1$2
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
                public final void invoke2(PurchasesError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    LogIntent logIntent = LogIntent.RC_ERROR;
                    String format = String.format(PurchaseStrings.SYNCING_PURCHASES_ERROR_DETAILS, Arrays.copyOf(new Object[]{StoreTransaction.this, error}, 2));
                    Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                    LogWrapperKt.log(logIntent, format);
                    arrayList.add(error);
                    SyncPurchasesHelper$syncPurchases$1.invoke$handleLastPurchase(arrayList, syncPurchasesHelper, str3, z4, z, function14, function13, StoreTransaction.this, storeTransaction);
                }
            });
            function12 = function13;
            function1 = function14;
            z2 = z4;
            str = str3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$handleLastPurchase(List<PurchasesError> list, SyncPurchasesHelper syncPurchasesHelper, String str, boolean z, boolean z2, Function1<? super CustomerInfo, Unit> function1, Function1<? super PurchasesError, Unit> function12, StoreTransaction storeTransaction, StoreTransaction storeTransaction2) {
        if (Intrinsics.areEqual(storeTransaction, storeTransaction2)) {
            if (list.isEmpty()) {
                LogUtilsKt.debugLog(PurchaseStrings.SYNCED_PURCHASES_SUCCESSFULLY);
                syncPurchasesHelper.retrieveCustomerInfo(str, z, z2, function1, function12);
            } else {
                String format = String.format(PurchaseStrings.SYNCING_PURCHASES_ERROR, Arrays.copyOf(new Object[]{list}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                LogUtilsKt.errorLog$default(format, null, 2, null);
                function12.invoke(CollectionsKt.first((List) list));
            }
        }
    }
}
