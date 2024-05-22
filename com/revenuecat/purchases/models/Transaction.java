package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.a.a.o.b;
import java.util.Date;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Transaction.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B-\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001eHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001eHÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006*"}, d2 = {"Lcom/revenuecat/purchases/models/Transaction;", "Landroid/os/Parcelable;", "productId", "", "jsonObject", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "transactionIdentifier", "revenuecatId", "productIdentifier", b.Q, "Ljava/util/Date;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V", "getProductId$annotations", "()V", "getProductId", "()Ljava/lang/String;", "getProductIdentifier", "getPurchaseDate", "()Ljava/util/Date;", "getRevenuecatId$annotations", "getRevenuecatId", "getTransactionIdentifier", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Transaction implements Parcelable {
    public static final Parcelable.Creator<Transaction> CREATOR = new Creator();
    private final String productId;
    private final String productIdentifier;
    private final Date purchaseDate;
    private final String revenuecatId;
    private final String transactionIdentifier;

    /* compiled from: Transaction.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<Transaction> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Transaction createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Transaction(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Date) parcel.readSerializable());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Transaction[] newArray(int i) {
            return new Transaction[i];
        }
    }

    public static /* synthetic */ Transaction copy$default(Transaction transaction, String str, String str2, String str3, String str4, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = transaction.transactionIdentifier;
        }
        if ((i & 2) != 0) {
            str2 = transaction.revenuecatId;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = transaction.productIdentifier;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = transaction.productId;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            date = transaction.purchaseDate;
        }
        return transaction.copy(str, str5, str6, str7, date);
    }

    @Deprecated(message = "Use productIdentifier instead", replaceWith = @ReplaceWith(expression = "productIdentifier", imports = {}))
    public static /* synthetic */ void getProductId$annotations() {
    }

    @Deprecated(message = "Use transactionIdentifier instead", replaceWith = @ReplaceWith(expression = "transactionIdentifier", imports = {}))
    public static /* synthetic */ void getRevenuecatId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getTransactionIdentifier() {
        return this.transactionIdentifier;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRevenuecatId() {
        return this.revenuecatId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    /* renamed from: component4, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* renamed from: component5, reason: from getter */
    public final Date getPurchaseDate() {
        return this.purchaseDate;
    }

    public final Transaction copy(String transactionIdentifier, String revenuecatId, String productIdentifier, String productId, Date purchaseDate) {
        Intrinsics.checkNotNullParameter(transactionIdentifier, "transactionIdentifier");
        Intrinsics.checkNotNullParameter(revenuecatId, "revenuecatId");
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
        return new Transaction(transactionIdentifier, revenuecatId, productIdentifier, productId, purchaseDate);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Transaction)) {
            return false;
        }
        Transaction transaction = (Transaction) other;
        return Intrinsics.areEqual(this.transactionIdentifier, transaction.transactionIdentifier) && Intrinsics.areEqual(this.revenuecatId, transaction.revenuecatId) && Intrinsics.areEqual(this.productIdentifier, transaction.productIdentifier) && Intrinsics.areEqual(this.productId, transaction.productId) && Intrinsics.areEqual(this.purchaseDate, transaction.purchaseDate);
    }

    public int hashCode() {
        return (((((((this.transactionIdentifier.hashCode() * 31) + this.revenuecatId.hashCode()) * 31) + this.productIdentifier.hashCode()) * 31) + this.productId.hashCode()) * 31) + this.purchaseDate.hashCode();
    }

    public String toString() {
        return "Transaction(transactionIdentifier=" + this.transactionIdentifier + ", revenuecatId=" + this.revenuecatId + ", productIdentifier=" + this.productIdentifier + ", productId=" + this.productId + ", purchaseDate=" + this.purchaseDate + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.transactionIdentifier);
        parcel.writeString(this.revenuecatId);
        parcel.writeString(this.productIdentifier);
        parcel.writeString(this.productId);
        parcel.writeSerializable(this.purchaseDate);
    }

    public Transaction(String transactionIdentifier, String revenuecatId, String productIdentifier, String productId, Date purchaseDate) {
        Intrinsics.checkNotNullParameter(transactionIdentifier, "transactionIdentifier");
        Intrinsics.checkNotNullParameter(revenuecatId, "revenuecatId");
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
        this.transactionIdentifier = transactionIdentifier;
        this.revenuecatId = revenuecatId;
        this.productIdentifier = productIdentifier;
        this.productId = productId;
        this.purchaseDate = purchaseDate;
    }

    public final String getTransactionIdentifier() {
        return this.transactionIdentifier;
    }

    public final String getRevenuecatId() {
        return this.revenuecatId;
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final Date getPurchaseDate() {
        return this.purchaseDate;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Transaction(java.lang.String r8, org.json.JSONObject r9) {
        /*
            r7 = this;
            java.lang.String r0 = "productId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "jsonObject"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "id"
            java.lang.String r2 = r9.getString(r0)
            java.lang.String r1 = "jsonObject.getString(\"id\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            java.lang.String r3 = r9.getString(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            java.lang.String r0 = "purchase_date"
            java.util.Date r6 = com.revenuecat.purchases.utils.JSONObjectExtensionsKt.getDate(r9, r0)
            r1 = r7
            r4 = r8
            r5 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.models.Transaction.<init>(java.lang.String, org.json.JSONObject):void");
    }
}
