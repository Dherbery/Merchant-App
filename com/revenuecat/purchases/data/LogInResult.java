package com.revenuecat.purchases.data;

import com.revenuecat.purchases.CustomerInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogInResult.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/data/LogInResult;", "", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "created", "", "(Lcom/revenuecat/purchases/CustomerInfo;Z)V", "getCreated", "()Z", "getCustomerInfo", "()Lcom/revenuecat/purchases/CustomerInfo;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class LogInResult {
    private final boolean created;
    private final CustomerInfo customerInfo;

    public static /* synthetic */ LogInResult copy$default(LogInResult logInResult, CustomerInfo customerInfo, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            customerInfo = logInResult.customerInfo;
        }
        if ((i & 2) != 0) {
            z = logInResult.created;
        }
        return logInResult.copy(customerInfo, z);
    }

    /* renamed from: component1, reason: from getter */
    public final CustomerInfo getCustomerInfo() {
        return this.customerInfo;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getCreated() {
        return this.created;
    }

    public final LogInResult copy(CustomerInfo customerInfo, boolean created) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        return new LogInResult(customerInfo, created);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogInResult)) {
            return false;
        }
        LogInResult logInResult = (LogInResult) other;
        return Intrinsics.areEqual(this.customerInfo, logInResult.customerInfo) && this.created == logInResult.created;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.customerInfo.hashCode() * 31;
        boolean z = this.created;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "LogInResult(customerInfo=" + this.customerInfo + ", created=" + this.created + ')';
    }

    public LogInResult(CustomerInfo customerInfo, boolean z) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        this.customerInfo = customerInfo;
        this.created = z;
    }

    public final CustomerInfo getCustomerInfo() {
        return this.customerInfo;
    }

    public final boolean getCreated() {
        return this.created;
    }
}
