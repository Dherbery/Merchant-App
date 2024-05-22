package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.models.RawDataContainer;
import com.revenuecat.purchases.utils.JSONObjectParceler;
import java.util.Date;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: EntitlementInfo.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0087\u0001\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0003¢\u0006\u0002\u0010\u0019B\u008f\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ\t\u00106\u001a\u00020\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010;\u001a\u00020\u0017HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÂ\u0003J\t\u0010=\u001a\u00020\u001bHÆ\u0003J\t\u0010>\u001a\u00020\u0007HÆ\u0003J\t\u0010?\u001a\u00020\u0007HÆ\u0003J\t\u0010@\u001a\u00020\nHÆ\u0003J\t\u0010A\u001a\u00020\fHÆ\u0003J\t\u0010B\u001a\u00020\fHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010D\u001a\u00020\u0010HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J±\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u001bHÆ\u0001J\t\u0010G\u001a\u00020HHÖ\u0001J\u0013\u0010I\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010KH\u0096\u0002J\b\u0010L\u001a\u00020HH\u0016J\b\u0010M\u001a\u00020\u0005H\u0016J\u0019\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020HHÖ\u0001R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\"R\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\"R\u000e\u0010\u0018\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u001a\u0010+\u001a\u00020\u00038VX\u0096\u0004¢\u0006\f\u0012\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001eR\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\"¨\u0006S"}, d2 = {"Lcom/revenuecat/purchases/EntitlementInfo;", "Landroid/os/Parcelable;", "Lcom/revenuecat/purchases/models/RawDataContainer;", "Lorg/json/JSONObject;", "identifier", "", "isActive", "", "willRenew", "periodType", "Lcom/revenuecat/purchases/PeriodType;", "latestPurchaseDate", "Ljava/util/Date;", "originalPurchaseDate", "expirationDate", ProductResponseJsonKeys.STORE, "Lcom/revenuecat/purchases/Store;", "productIdentifier", "productPlanIdentifier", "isSandbox", "unsubscribeDetectedAt", "billingIssueDetectedAt", "ownershipType", "Lcom/revenuecat/purchases/OwnershipType;", "jsonObject", "(Ljava/lang/String;ZZLcom/revenuecat/purchases/PeriodType;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/Store;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/OwnershipType;Lorg/json/JSONObject;)V", "verification", "Lcom/revenuecat/purchases/VerificationResult;", "(Ljava/lang/String;ZZLcom/revenuecat/purchases/PeriodType;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/Store;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/OwnershipType;Lorg/json/JSONObject;Lcom/revenuecat/purchases/VerificationResult;)V", "getBillingIssueDetectedAt", "()Ljava/util/Date;", "getExpirationDate", "getIdentifier", "()Ljava/lang/String;", "()Z", "getLatestPurchaseDate", "getOriginalPurchaseDate", "getOwnershipType", "()Lcom/revenuecat/purchases/OwnershipType;", "getPeriodType", "()Lcom/revenuecat/purchases/PeriodType;", "getProductIdentifier", "getProductPlanIdentifier", Constants.MessagePayloadKeys.RAW_DATA, "getRawData$annotations", "()V", "getRawData", "()Lorg/json/JSONObject;", "getStore", "()Lcom/revenuecat/purchases/Store;", "getUnsubscribeDetectedAt", "getVerification", "()Lcom/revenuecat/purchases/VerificationResult;", "getWillRenew", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class EntitlementInfo implements Parcelable, RawDataContainer<JSONObject> {
    public static final Parcelable.Creator<EntitlementInfo> CREATOR = new Creator();
    private final Date billingIssueDetectedAt;
    private final Date expirationDate;
    private final String identifier;
    private final boolean isActive;
    private final boolean isSandbox;
    private final JSONObject jsonObject;
    private final Date latestPurchaseDate;
    private final Date originalPurchaseDate;
    private final OwnershipType ownershipType;
    private final PeriodType periodType;
    private final String productIdentifier;
    private final String productPlanIdentifier;
    private final Store store;
    private final Date unsubscribeDetectedAt;
    private final VerificationResult verification;
    private final boolean willRenew;

    /* compiled from: EntitlementInfo.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<EntitlementInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EntitlementInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new EntitlementInfo(parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, PeriodType.valueOf(parcel.readString()), (Date) parcel.readSerializable(), (Date) parcel.readSerializable(), (Date) parcel.readSerializable(), Store.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readInt() != 0, (Date) parcel.readSerializable(), (Date) parcel.readSerializable(), OwnershipType.valueOf(parcel.readString()), JSONObjectParceler.INSTANCE.create(parcel), VerificationResult.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EntitlementInfo[] newArray(int i) {
            return new EntitlementInfo[i];
        }
    }

    /* renamed from: component15, reason: from getter */
    private final JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public static /* synthetic */ void getRawData$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    /* renamed from: component10, reason: from getter */
    public final String getProductPlanIdentifier() {
        return this.productPlanIdentifier;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsSandbox() {
        return this.isSandbox;
    }

    /* renamed from: component12, reason: from getter */
    public final Date getUnsubscribeDetectedAt() {
        return this.unsubscribeDetectedAt;
    }

    /* renamed from: component13, reason: from getter */
    public final Date getBillingIssueDetectedAt() {
        return this.billingIssueDetectedAt;
    }

    /* renamed from: component14, reason: from getter */
    public final OwnershipType getOwnershipType() {
        return this.ownershipType;
    }

    /* renamed from: component16, reason: from getter */
    public final VerificationResult getVerification() {
        return this.verification;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getWillRenew() {
        return this.willRenew;
    }

    /* renamed from: component4, reason: from getter */
    public final PeriodType getPeriodType() {
        return this.periodType;
    }

    /* renamed from: component5, reason: from getter */
    public final Date getLatestPurchaseDate() {
        return this.latestPurchaseDate;
    }

    /* renamed from: component6, reason: from getter */
    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    /* renamed from: component7, reason: from getter */
    public final Date getExpirationDate() {
        return this.expirationDate;
    }

    /* renamed from: component8, reason: from getter */
    public final Store getStore() {
        return this.store;
    }

    /* renamed from: component9, reason: from getter */
    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    public final EntitlementInfo copy(String identifier, boolean isActive, boolean willRenew, PeriodType periodType, Date latestPurchaseDate, Date originalPurchaseDate, Date expirationDate, Store store, String productIdentifier, String productPlanIdentifier, boolean isSandbox, Date unsubscribeDetectedAt, Date billingIssueDetectedAt, OwnershipType ownershipType, JSONObject jsonObject, VerificationResult verification) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        Intrinsics.checkNotNullParameter(latestPurchaseDate, "latestPurchaseDate");
        Intrinsics.checkNotNullParameter(originalPurchaseDate, "originalPurchaseDate");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(ownershipType, "ownershipType");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(verification, "verification");
        return new EntitlementInfo(identifier, isActive, willRenew, periodType, latestPurchaseDate, originalPurchaseDate, expirationDate, store, productIdentifier, productPlanIdentifier, isSandbox, unsubscribeDetectedAt, billingIssueDetectedAt, ownershipType, jsonObject, verification);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.identifier);
        parcel.writeInt(this.isActive ? 1 : 0);
        parcel.writeInt(this.willRenew ? 1 : 0);
        parcel.writeString(this.periodType.name());
        parcel.writeSerializable(this.latestPurchaseDate);
        parcel.writeSerializable(this.originalPurchaseDate);
        parcel.writeSerializable(this.expirationDate);
        parcel.writeString(this.store.name());
        parcel.writeString(this.productIdentifier);
        parcel.writeString(this.productPlanIdentifier);
        parcel.writeInt(this.isSandbox ? 1 : 0);
        parcel.writeSerializable(this.unsubscribeDetectedAt);
        parcel.writeSerializable(this.billingIssueDetectedAt);
        parcel.writeString(this.ownershipType.name());
        JSONObjectParceler.INSTANCE.write(this.jsonObject, parcel, flags);
        parcel.writeString(this.verification.name());
    }

    public EntitlementInfo(String identifier, boolean z, boolean z2, PeriodType periodType, Date latestPurchaseDate, Date originalPurchaseDate, Date date, Store store, String productIdentifier, String str, boolean z3, Date date2, Date date3, OwnershipType ownershipType, JSONObject jsonObject, VerificationResult verification) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        Intrinsics.checkNotNullParameter(latestPurchaseDate, "latestPurchaseDate");
        Intrinsics.checkNotNullParameter(originalPurchaseDate, "originalPurchaseDate");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(ownershipType, "ownershipType");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(verification, "verification");
        this.identifier = identifier;
        this.isActive = z;
        this.willRenew = z2;
        this.periodType = periodType;
        this.latestPurchaseDate = latestPurchaseDate;
        this.originalPurchaseDate = originalPurchaseDate;
        this.expirationDate = date;
        this.store = store;
        this.productIdentifier = productIdentifier;
        this.productPlanIdentifier = str;
        this.isSandbox = z3;
        this.unsubscribeDetectedAt = date2;
        this.billingIssueDetectedAt = date3;
        this.ownershipType = ownershipType;
        this.jsonObject = jsonObject;
        this.verification = verification;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean getWillRenew() {
        return this.willRenew;
    }

    public final PeriodType getPeriodType() {
        return this.periodType;
    }

    public final Date getLatestPurchaseDate() {
        return this.latestPurchaseDate;
    }

    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    public final Date getExpirationDate() {
        return this.expirationDate;
    }

    public final Store getStore() {
        return this.store;
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    public final String getProductPlanIdentifier() {
        return this.productPlanIdentifier;
    }

    public final boolean isSandbox() {
        return this.isSandbox;
    }

    public final Date getUnsubscribeDetectedAt() {
        return this.unsubscribeDetectedAt;
    }

    public final Date getBillingIssueDetectedAt() {
        return this.billingIssueDetectedAt;
    }

    public final OwnershipType getOwnershipType() {
        return this.ownershipType;
    }

    public /* synthetic */ EntitlementInfo(String str, boolean z, boolean z2, PeriodType periodType, Date date, Date date2, Date date3, Store store, String str2, String str3, boolean z3, Date date4, Date date5, OwnershipType ownershipType, JSONObject jSONObject, VerificationResult verificationResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, z2, periodType, date, date2, date3, store, str2, str3, z3, date4, date5, ownershipType, jSONObject, (i & 32768) != 0 ? VerificationResult.NOT_REQUESTED : verificationResult);
    }

    public final VerificationResult getVerification() {
        return this.verification;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use the constructor with the verification parameter", replaceWith = @ReplaceWith(expression = "EntitlementInfo(identifier, isActive, willRenew, periodType, latestPurchaseDate, originalPurchaseDate, expirationDate, store, productIdentifier, productPlanIdentifier, isSandbox, unsubscribeDetectedAt, billingIssueDetectedAt, ownershipType, jsonObject, VerificationResult.NOT_REQUESTED)", imports = {"com.revenuecat.purchases.VerificationResult"}))
    public EntitlementInfo(String identifier, boolean z, boolean z2, PeriodType periodType, Date latestPurchaseDate, Date originalPurchaseDate, Date date, Store store, String productIdentifier, String str, boolean z3, Date date2, Date date3, OwnershipType ownershipType, JSONObject jsonObject) {
        this(identifier, z, z2, periodType, latestPurchaseDate, originalPurchaseDate, date, store, productIdentifier, str, z3, date2, date3, ownershipType, jsonObject, VerificationResult.NOT_REQUESTED);
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        Intrinsics.checkNotNullParameter(latestPurchaseDate, "latestPurchaseDate");
        Intrinsics.checkNotNullParameter(originalPurchaseDate, "originalPurchaseDate");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(ownershipType, "ownershipType");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
    }

    @Override // com.revenuecat.purchases.models.RawDataContainer
    public JSONObject getRawData() {
        return this.jsonObject;
    }

    public String toString() {
        return "EntitlementInfo(identifier='" + this.identifier + "', isActive=" + this.isActive + ", willRenew=" + this.willRenew + ", periodType=" + this.periodType + ", latestPurchaseDate=" + this.latestPurchaseDate + ", originalPurchaseDate=" + this.originalPurchaseDate + ", expirationDate=" + this.expirationDate + ", store=" + this.store + ", productIdentifier='" + this.productIdentifier + "', productPlanIdentifier='" + this.productPlanIdentifier + "', isSandbox=" + this.isSandbox + ", unsubscribeDetectedAt=" + this.unsubscribeDetectedAt + ", billingIssueDetectedAt=" + this.billingIssueDetectedAt + ", ownershipType=" + this.ownershipType + ", verification=" + this.verification + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.revenuecat.purchases.EntitlementInfo");
        EntitlementInfo entitlementInfo = (EntitlementInfo) other;
        return Intrinsics.areEqual(this.identifier, entitlementInfo.identifier) && this.isActive == entitlementInfo.isActive && this.willRenew == entitlementInfo.willRenew && this.periodType == entitlementInfo.periodType && Intrinsics.areEqual(this.latestPurchaseDate, entitlementInfo.latestPurchaseDate) && Intrinsics.areEqual(this.originalPurchaseDate, entitlementInfo.originalPurchaseDate) && Intrinsics.areEqual(this.expirationDate, entitlementInfo.expirationDate) && this.store == entitlementInfo.store && Intrinsics.areEqual(this.productIdentifier, entitlementInfo.productIdentifier) && Intrinsics.areEqual(this.productPlanIdentifier, entitlementInfo.productPlanIdentifier) && this.isSandbox == entitlementInfo.isSandbox && Intrinsics.areEqual(this.unsubscribeDetectedAt, entitlementInfo.unsubscribeDetectedAt) && Intrinsics.areEqual(this.billingIssueDetectedAt, entitlementInfo.billingIssueDetectedAt) && this.ownershipType == entitlementInfo.ownershipType && this.verification == entitlementInfo.verification;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.identifier.hashCode() * 31) + UByte$$ExternalSyntheticBackport0.m(this.isActive)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.willRenew)) * 31) + this.periodType.hashCode()) * 31) + this.latestPurchaseDate.hashCode()) * 31) + this.originalPurchaseDate.hashCode()) * 31;
        Date date = this.expirationDate;
        int hashCode2 = (((((hashCode + (date != null ? date.hashCode() : 0)) * 31) + this.store.hashCode()) * 31) + this.productIdentifier.hashCode()) * 31;
        String str = this.productPlanIdentifier;
        int hashCode3 = (((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.isSandbox)) * 31;
        Date date2 = this.unsubscribeDetectedAt;
        int hashCode4 = (hashCode3 + (date2 != null ? date2.hashCode() : 0)) * 31;
        Date date3 = this.billingIssueDetectedAt;
        return ((hashCode4 + (date3 != null ? date3.hashCode() : 0)) * 31) + this.ownershipType.hashCode();
    }
}
