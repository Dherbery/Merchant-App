package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PurchasesStateCache.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/PurchasesStateCache;", "Lcom/revenuecat/purchases/PurchasesStateProvider;", "purchasesState", "Lcom/revenuecat/purchases/PurchasesState;", "(Lcom/revenuecat/purchases/PurchasesState;)V", "getPurchasesState", "()Lcom/revenuecat/purchases/PurchasesState;", "setPurchasesState", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PurchasesStateCache implements PurchasesStateProvider {
    private PurchasesState purchasesState;

    public static /* synthetic */ PurchasesStateCache copy$default(PurchasesStateCache purchasesStateCache, PurchasesState purchasesState, int i, Object obj) {
        if ((i & 1) != 0) {
            purchasesState = purchasesStateCache.getPurchasesState();
        }
        return purchasesStateCache.copy(purchasesState);
    }

    public final PurchasesState component1() {
        return getPurchasesState();
    }

    public final PurchasesStateCache copy(PurchasesState purchasesState) {
        Intrinsics.checkNotNullParameter(purchasesState, "purchasesState");
        return new PurchasesStateCache(purchasesState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PurchasesStateCache) && Intrinsics.areEqual(getPurchasesState(), ((PurchasesStateCache) other).getPurchasesState());
    }

    public int hashCode() {
        return getPurchasesState().hashCode();
    }

    public String toString() {
        return "PurchasesStateCache(purchasesState=" + getPurchasesState() + ')';
    }

    public PurchasesStateCache(PurchasesState purchasesState) {
        Intrinsics.checkNotNullParameter(purchasesState, "purchasesState");
        this.purchasesState = purchasesState;
    }

    @Override // com.revenuecat.purchases.PurchasesStateProvider
    public synchronized PurchasesState getPurchasesState() {
        return this.purchasesState;
    }

    public synchronized void setPurchasesState(PurchasesState purchasesState) {
        Intrinsics.checkNotNullParameter(purchasesState, "<set-?>");
        this.purchasesState = purchasesState;
    }
}
