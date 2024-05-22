package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.ProrationMode;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.utils.JSONObjectParceler;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: StoreTransaction.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0001\b\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aB\u0095\u0001\b\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010\u001dB\u0093\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010 J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0015HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0007HÆ\u0003J\t\u0010L\u001a\u00020\tHÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\fHÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0011HÆ\u0003Jº\u0001\u0010R\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0002\u0010SJ\t\u0010T\u001a\u00020UHÖ\u0001J\u0013\u0010V\u001a\u00020\u000e2\b\u0010W\u001a\u0004\u0018\u00010XH\u0096\u0002J\b\u0010Y\u001a\u00020UH\u0016J\t\u0010Z\u001a\u00020\u0003HÖ\u0001J\u0019\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020UHÖ\u0001R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\r\u0010!R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010+\u001a\u0004\b,\u0010$R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001c8FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010+\u001a\u0004\b0\u00101R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010$R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010$R \u0010<\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b=\u0010+\u001a\u0004\b>\u0010.R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010$R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010$R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u0010B¨\u0006`"}, d2 = {"Lcom/revenuecat/purchases/models/StoreTransaction;", "Landroid/os/Parcelable;", "orderId", "", "productIds", "", "type", "Lcom/revenuecat/purchases/ProductType;", "purchaseTime", "", "purchaseToken", "purchaseState", "Lcom/revenuecat/purchases/models/PurchaseState;", "isAutoRenewing", "", "signature", "originalJson", "Lorg/json/JSONObject;", "presentedOfferingIdentifier", "storeUserID", "purchaseType", "Lcom/revenuecat/purchases/models/PurchaseType;", b.m, "subscriptionOptionId", "replacementMode", "Lcom/revenuecat/purchases/ReplacementMode;", "(Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/ProductType;JLjava/lang/String;Lcom/revenuecat/purchases/models/PurchaseState;Ljava/lang/Boolean;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchaseType;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ReplacementMode;)V", b.l, "Lcom/revenuecat/purchases/ProrationMode;", "(Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/ProductType;JLjava/lang/String;Lcom/revenuecat/purchases/models/PurchaseState;Ljava/lang/Boolean;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchaseType;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ProrationMode;)V", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/ProductType;JLjava/lang/String;Lcom/revenuecat/purchases/models/PurchaseState;Ljava/lang/Boolean;Ljava/lang/String;Lorg/json/JSONObject;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchaseType;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ReplacementMode;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMarketplace", "()Ljava/lang/String;", "getOrderId", "getOriginalJson", "()Lorg/json/JSONObject;", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPresentedOfferingIdentifier$annotations", "()V", "getPresentedOfferingIdentifier", "getProductIds", "()Ljava/util/List;", "getProrationMode$annotations", "getProrationMode", "()Lcom/revenuecat/purchases/ProrationMode;", "getPurchaseState", "()Lcom/revenuecat/purchases/models/PurchaseState;", "getPurchaseTime", "()J", "getPurchaseToken", "getPurchaseType", "()Lcom/revenuecat/purchases/models/PurchaseType;", "getReplacementMode", "()Lcom/revenuecat/purchases/ReplacementMode;", "getSignature", b.O, "getSkus$annotations", "getSkus", "getStoreUserID", "getSubscriptionOptionId", "getType", "()Lcom/revenuecat/purchases/ProductType;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/ProductType;JLjava/lang/String;Lcom/revenuecat/purchases/models/PurchaseState;Ljava/lang/Boolean;Ljava/lang/String;Lorg/json/JSONObject;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchaseType;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ReplacementMode;)Lcom/revenuecat/purchases/models/StoreTransaction;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StoreTransaction implements Parcelable {
    public static final Parcelable.Creator<StoreTransaction> CREATOR = new Creator();
    private final Boolean isAutoRenewing;
    private final String marketplace;
    private final String orderId;
    private final JSONObject originalJson;
    private final PresentedOfferingContext presentedOfferingContext;
    private final List<String> productIds;
    private final PurchaseState purchaseState;
    private final long purchaseTime;
    private final String purchaseToken;
    private final PurchaseType purchaseType;
    private final ReplacementMode replacementMode;
    private final String signature;
    private final String storeUserID;
    private final String subscriptionOptionId;
    private final ProductType type;

    /* compiled from: StoreTransaction.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<StoreTransaction> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StoreTransaction createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            ProductType valueOf2 = ProductType.valueOf(parcel.readString());
            long readLong = parcel.readLong();
            String readString2 = parcel.readString();
            PurchaseState valueOf3 = PurchaseState.valueOf(parcel.readString());
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new StoreTransaction(readString, createStringArrayList, valueOf2, readLong, readString2, valueOf3, valueOf, parcel.readString(), JSONObjectParceler.INSTANCE.create(parcel), parcel.readInt() != 0 ? PresentedOfferingContext.CREATOR.createFromParcel(parcel) : null, parcel.readString(), PurchaseType.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), (ReplacementMode) parcel.readParcelable(StoreTransaction.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StoreTransaction[] newArray(int i) {
            return new StoreTransaction[i];
        }
    }

    @Deprecated(message = "Use presentedOfferingContext", replaceWith = @ReplaceWith(expression = "presentedOfferingContext.offeringIdentifier", imports = {}))
    public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
    }

    @Deprecated(message = "Use replacementMode", replaceWith = @ReplaceWith(expression = "replacementMode()", imports = {}))
    public static /* synthetic */ void getProrationMode$annotations() {
    }

    @Deprecated(message = "Replaced with productIds", replaceWith = @ReplaceWith(expression = "productIds", imports = {}))
    public static /* synthetic */ void getSkus$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    /* renamed from: component10, reason: from getter */
    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    /* renamed from: component11, reason: from getter */
    public final String getStoreUserID() {
        return this.storeUserID;
    }

    /* renamed from: component12, reason: from getter */
    public final PurchaseType getPurchaseType() {
        return this.purchaseType;
    }

    /* renamed from: component13, reason: from getter */
    public final String getMarketplace() {
        return this.marketplace;
    }

    /* renamed from: component14, reason: from getter */
    public final String getSubscriptionOptionId() {
        return this.subscriptionOptionId;
    }

    /* renamed from: component15, reason: from getter */
    public final ReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    public final List<String> component2() {
        return this.productIds;
    }

    /* renamed from: component3, reason: from getter */
    public final ProductType getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final long getPurchaseTime() {
        return this.purchaseTime;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    /* renamed from: component6, reason: from getter */
    public final PurchaseState getPurchaseState() {
        return this.purchaseState;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getIsAutoRenewing() {
        return this.isAutoRenewing;
    }

    /* renamed from: component8, reason: from getter */
    public final String getSignature() {
        return this.signature;
    }

    /* renamed from: component9, reason: from getter */
    public final JSONObject getOriginalJson() {
        return this.originalJson;
    }

    public final StoreTransaction copy(String orderId, List<String> productIds, ProductType type, long purchaseTime, String purchaseToken, PurchaseState purchaseState, Boolean isAutoRenewing, String signature, JSONObject originalJson, PresentedOfferingContext presentedOfferingContext, String storeUserID, PurchaseType purchaseType, String marketplace, String subscriptionOptionId, ReplacementMode replacementMode) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(purchaseState, "purchaseState");
        Intrinsics.checkNotNullParameter(originalJson, "originalJson");
        Intrinsics.checkNotNullParameter(purchaseType, "purchaseType");
        return new StoreTransaction(orderId, productIds, type, purchaseTime, purchaseToken, purchaseState, isAutoRenewing, signature, originalJson, presentedOfferingContext, storeUserID, purchaseType, marketplace, subscriptionOptionId, replacementMode);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "StoreTransaction(orderId=" + this.orderId + ", productIds=" + this.productIds + ", type=" + this.type + ", purchaseTime=" + this.purchaseTime + ", purchaseToken=" + this.purchaseToken + ", purchaseState=" + this.purchaseState + ", isAutoRenewing=" + this.isAutoRenewing + ", signature=" + this.signature + ", originalJson=" + this.originalJson + ", presentedOfferingContext=" + this.presentedOfferingContext + ", storeUserID=" + this.storeUserID + ", purchaseType=" + this.purchaseType + ", marketplace=" + this.marketplace + ", subscriptionOptionId=" + this.subscriptionOptionId + ", replacementMode=" + this.replacementMode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.orderId);
        parcel.writeStringList(this.productIds);
        parcel.writeString(this.type.name());
        parcel.writeLong(this.purchaseTime);
        parcel.writeString(this.purchaseToken);
        parcel.writeString(this.purchaseState.name());
        Boolean bool = this.isAutoRenewing;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.signature);
        JSONObjectParceler.INSTANCE.write(this.originalJson, parcel, flags);
        PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
        if (presentedOfferingContext == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            presentedOfferingContext.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.storeUserID);
        parcel.writeString(this.purchaseType.name());
        parcel.writeString(this.marketplace);
        parcel.writeString(this.subscriptionOptionId);
        parcel.writeParcelable(this.replacementMode, flags);
    }

    public StoreTransaction(String str, List<String> productIds, ProductType type, long j, String purchaseToken, PurchaseState purchaseState, Boolean bool, String str2, JSONObject originalJson, PresentedOfferingContext presentedOfferingContext, String str3, PurchaseType purchaseType, String str4, String str5, ReplacementMode replacementMode) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(purchaseState, "purchaseState");
        Intrinsics.checkNotNullParameter(originalJson, "originalJson");
        Intrinsics.checkNotNullParameter(purchaseType, "purchaseType");
        this.orderId = str;
        this.productIds = productIds;
        this.type = type;
        this.purchaseTime = j;
        this.purchaseToken = purchaseToken;
        this.purchaseState = purchaseState;
        this.isAutoRenewing = bool;
        this.signature = str2;
        this.originalJson = originalJson;
        this.presentedOfferingContext = presentedOfferingContext;
        this.storeUserID = str3;
        this.purchaseType = purchaseType;
        this.marketplace = str4;
        this.subscriptionOptionId = str5;
        this.replacementMode = replacementMode;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final List<String> getProductIds() {
        return this.productIds;
    }

    public final ProductType getType() {
        return this.type;
    }

    public final long getPurchaseTime() {
        return this.purchaseTime;
    }

    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    public final PurchaseState getPurchaseState() {
        return this.purchaseState;
    }

    public final Boolean isAutoRenewing() {
        return this.isAutoRenewing;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final JSONObject getOriginalJson() {
        return this.originalJson;
    }

    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public final String getStoreUserID() {
        return this.storeUserID;
    }

    public final PurchaseType getPurchaseType() {
        return this.purchaseType;
    }

    public final String getMarketplace() {
        return this.marketplace;
    }

    public final String getSubscriptionOptionId() {
        return this.subscriptionOptionId;
    }

    public final ReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use constructor with presentedOfferingContext instead")
    public StoreTransaction(String str, List<String> productIds, ProductType type, long j, String purchaseToken, PurchaseState purchaseState, Boolean bool, String str2, JSONObject originalJson, String str3, String str4, PurchaseType purchaseType, String str5, String str6, ReplacementMode replacementMode) {
        this(str, productIds, type, j, purchaseToken, purchaseState, bool, str2, originalJson, str3 != null ? new PresentedOfferingContext(str3) : null, str4, purchaseType, str5, str6, replacementMode);
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(purchaseState, "purchaseState");
        Intrinsics.checkNotNullParameter(originalJson, "originalJson");
        Intrinsics.checkNotNullParameter(purchaseType, "purchaseType");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "prorationMode is deprecated, use constructor with replacementMode")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public StoreTransaction(java.lang.String r21, java.util.List<java.lang.String> r22, com.revenuecat.purchases.ProductType r23, long r24, java.lang.String r26, com.revenuecat.purchases.models.PurchaseState r27, java.lang.Boolean r28, java.lang.String r29, org.json.JSONObject r30, java.lang.String r31, java.lang.String r32, com.revenuecat.purchases.models.PurchaseType r33, java.lang.String r34, java.lang.String r35, com.revenuecat.purchases.ProrationMode r36) {
        /*
            r20 = this;
            r0 = r31
            r1 = r36
            java.lang.String r2 = "productIds"
            r5 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            java.lang.String r2 = "type"
            r6 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            java.lang.String r2 = "purchaseToken"
            r9 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r2)
            java.lang.String r2 = "purchaseState"
            r10 = r27
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r2)
            java.lang.String r2 = "originalJson"
            r13 = r30
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r2)
            java.lang.String r2 = "purchaseType"
            r15 = r33
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r2)
            r2 = 0
            if (r0 == 0) goto L38
            com.revenuecat.purchases.PresentedOfferingContext r3 = new com.revenuecat.purchases.PresentedOfferingContext
            r3.<init>(r0)
            r14 = r3
            goto L39
        L38:
            r14 = r2
        L39:
            boolean r0 = r1 instanceof com.revenuecat.purchases.models.GoogleProrationMode
            if (r0 == 0) goto L41
            r0 = r1
            com.revenuecat.purchases.models.GoogleProrationMode r0 = (com.revenuecat.purchases.models.GoogleProrationMode) r0
            goto L42
        L41:
            r0 = r2
        L42:
            if (r0 == 0) goto L48
            com.revenuecat.purchases.models.GoogleReplacementMode r2 = r0.getAsGoogleReplacementMode$purchases_defaultsRelease()
        L48:
            r19 = r2
            com.revenuecat.purchases.ReplacementMode r19 = (com.revenuecat.purchases.ReplacementMode) r19
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r9 = r26
            r10 = r27
            r11 = r28
            r12 = r29
            r13 = r30
            r15 = r32
            r16 = r33
            r17 = r34
            r18 = r35
            r3.<init>(r4, r5, r6, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.models.StoreTransaction.<init>(java.lang.String, java.util.List, com.revenuecat.purchases.ProductType, long, java.lang.String, com.revenuecat.purchases.models.PurchaseState, java.lang.Boolean, java.lang.String, org.json.JSONObject, java.lang.String, java.lang.String, com.revenuecat.purchases.models.PurchaseType, java.lang.String, java.lang.String, com.revenuecat.purchases.ProrationMode):void");
    }

    public final ProrationMode getProrationMode() {
        ReplacementMode replacementMode = this.replacementMode;
        GoogleReplacementMode googleReplacementMode = replacementMode instanceof GoogleReplacementMode ? (GoogleReplacementMode) replacementMode : null;
        return googleReplacementMode != null ? googleReplacementMode.getAsGoogleProrationMode$purchases_defaultsRelease() : null;
    }

    public final String getPresentedOfferingIdentifier() {
        PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
        if (presentedOfferingContext != null) {
            return presentedOfferingContext.getOfferingIdentifier();
        }
        return null;
    }

    public final List<String> getSkus() {
        return this.productIds;
    }

    public boolean equals(Object other) {
        return (other instanceof StoreTransaction) && Intrinsics.areEqual(new ComparableData(this), new ComparableData((StoreTransaction) other));
    }

    public int hashCode() {
        return new ComparableData(this).hashCode();
    }
}
