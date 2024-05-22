package com.revenuecat.purchases;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.revenuecat.purchases.models.RawDataContainer;
import com.revenuecat.purchases.models.Transaction;
import com.revenuecat.purchases.utils.DateHelper;
import com.revenuecat.purchases.utils.JSONObjectParceler;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CustomerInfo.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002Bu\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0002\u0010\u0014J$\u0010F\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0014\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0002J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÂ\u0003J\u0017\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007HÆ\u0003J\u0017\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007HÆ\u0003J\t\u0010L\u001a\u00020\tHÆ\u0003J\t\u0010M\u001a\u00020\rHÆ\u0003J\t\u0010N\u001a\u00020\tHÆ\u0003J\t\u0010O\u001a\u00020\bHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\tHÆ\u0003J\u008d\u0001\u0010R\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\t\u0010S\u001a\u00020\rHÖ\u0001J\u0013\u0010T\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010WH\u0096\u0002J\u0010\u0010X\u001a\u0004\u0018\u00010\t2\u0006\u0010Y\u001a\u00020\bJ\u0010\u0010Z\u001a\u0004\u0018\u00010\t2\u0006\u0010[\u001a\u00020\bJ\u0012\u0010\\\u001a\u0004\u0018\u00010\t2\u0006\u0010]\u001a\u00020\bH\u0007J\u0010\u0010^\u001a\u0004\u0018\u00010\t2\u0006\u0010Y\u001a\u00020\bJ\u0010\u0010_\u001a\u0004\u0018\u00010\t2\u0006\u0010[\u001a\u00020\bJ\u0012\u0010`\u001a\u0004\u0018\u00010\t2\u0006\u0010]\u001a\u00020\bH\u0007J\b\u0010a\u001a\u00020\rH\u0016J\b\u0010b\u001a\u00020\bH\u0016J\u0019\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020\rHÖ\u0001R'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00168FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR'\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u00168FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001c\u0012\u0004\b!\u0010\u0018\u001a\u0004\b\"\u0010\u001aR'\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u00168FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b'\u0010\u001c\u0012\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010\u0013\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010,\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b/\u0010\u001c\u0012\u0004\b-\u0010\u0018\u001a\u0004\b.\u0010+R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R'\u00102\u001a\b\u0012\u0004\u0012\u000204038FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b8\u0010\u001c\u0012\u0004\b5\u0010\u0018\u001a\u0004\b6\u00107R\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b;\u0010+R\u001a\u0010<\u001a\u00020\u00038VX\u0096\u0004¢\u0006\f\u0012\u0004\b=\u0010\u0018\u001a\u0004\b>\u0010?R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b@\u0010+R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u001c\u0010C\u001a\n D*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\bE\u0010\u0018¨\u0006h"}, d2 = {"Lcom/revenuecat/purchases/CustomerInfo;", "Landroid/os/Parcelable;", "Lcom/revenuecat/purchases/models/RawDataContainer;", "Lorg/json/JSONObject;", CustomerInfoResponseJsonKeys.ENTITLEMENTS, "Lcom/revenuecat/purchases/EntitlementInfos;", "allExpirationDatesByProduct", "", "", "Ljava/util/Date;", "allPurchaseDatesByProduct", "requestDate", "schemaVersion", "", "firstSeen", "originalAppUserId", "managementURL", "Landroid/net/Uri;", "originalPurchaseDate", "jsonObject", "(Lcom/revenuecat/purchases/EntitlementInfos;Ljava/util/Map;Ljava/util/Map;Ljava/util/Date;ILjava/util/Date;Ljava/lang/String;Landroid/net/Uri;Ljava/util/Date;Lorg/json/JSONObject;)V", "activeSubscriptions", "", "getActiveSubscriptions$annotations", "()V", "getActiveSubscriptions", "()Ljava/util/Set;", "activeSubscriptions$delegate", "Lkotlin/Lazy;", "getAllExpirationDatesByProduct", "()Ljava/util/Map;", "getAllPurchaseDatesByProduct", "allPurchasedProductIds", "getAllPurchasedProductIds$annotations", "getAllPurchasedProductIds", "allPurchasedProductIds$delegate", "allPurchasedSkus", "getAllPurchasedSkus$annotations", "getAllPurchasedSkus", "allPurchasedSkus$delegate", "getEntitlements", "()Lcom/revenuecat/purchases/EntitlementInfos;", "getFirstSeen", "()Ljava/util/Date;", "latestExpirationDate", "getLatestExpirationDate$annotations", "getLatestExpirationDate", "latestExpirationDate$delegate", "getManagementURL", "()Landroid/net/Uri;", "nonSubscriptionTransactions", "", "Lcom/revenuecat/purchases/models/Transaction;", "getNonSubscriptionTransactions$annotations", "getNonSubscriptionTransactions", "()Ljava/util/List;", "nonSubscriptionTransactions$delegate", "getOriginalAppUserId", "()Ljava/lang/String;", "getOriginalPurchaseDate", Constants.MessagePayloadKeys.RAW_DATA, "getRawData$annotations", "getRawData", "()Lorg/json/JSONObject;", "getRequestDate", "getSchemaVersion", "()I", "subscriberJSONObject", "kotlin.jvm.PlatformType", "getSubscriberJSONObject$annotations", "activeIdentifiers", "expirations", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "getExpirationDateForEntitlement", "entitlement", "getExpirationDateForProductId", "productId", "getExpirationDateForSku", "sku", "getPurchaseDateForEntitlement", "getPurchaseDateForProductId", "getPurchaseDateForSku", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CustomerInfo implements Parcelable, RawDataContainer<JSONObject> {
    public static final Parcelable.Creator<CustomerInfo> CREATOR = new Creator();

    /* renamed from: activeSubscriptions$delegate, reason: from kotlin metadata */
    private final Lazy activeSubscriptions;
    private final Map<String, Date> allExpirationDatesByProduct;
    private final Map<String, Date> allPurchaseDatesByProduct;

    /* renamed from: allPurchasedProductIds$delegate, reason: from kotlin metadata */
    private final Lazy allPurchasedProductIds;

    /* renamed from: allPurchasedSkus$delegate, reason: from kotlin metadata */
    private final Lazy allPurchasedSkus;
    private final EntitlementInfos entitlements;
    private final Date firstSeen;
    private final JSONObject jsonObject;

    /* renamed from: latestExpirationDate$delegate, reason: from kotlin metadata */
    private final Lazy latestExpirationDate;
    private final Uri managementURL;

    /* renamed from: nonSubscriptionTransactions$delegate, reason: from kotlin metadata */
    private final Lazy nonSubscriptionTransactions;
    private final String originalAppUserId;
    private final Date originalPurchaseDate;
    private final Date requestDate;
    private final int schemaVersion;
    private final JSONObject subscriberJSONObject;

    /* compiled from: CustomerInfo.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<CustomerInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CustomerInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            EntitlementInfos createFromParcel = EntitlementInfos.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i = 0; i != readInt; i++) {
                linkedHashMap.put(parcel.readString(), parcel.readSerializable());
            }
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            int readInt2 = parcel.readInt();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(readInt2);
            for (int i2 = 0; i2 != readInt2; i2++) {
                linkedHashMap3.put(parcel.readString(), parcel.readSerializable());
            }
            return new CustomerInfo(createFromParcel, linkedHashMap2, linkedHashMap3, (Date) parcel.readSerializable(), parcel.readInt(), (Date) parcel.readSerializable(), parcel.readString(), (Uri) parcel.readParcelable(CustomerInfo.class.getClassLoader()), (Date) parcel.readSerializable(), JSONObjectParceler.INSTANCE.create(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CustomerInfo[] newArray(int i) {
            return new CustomerInfo[i];
        }
    }

    /* renamed from: component10, reason: from getter */
    private final JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public static /* synthetic */ void getActiveSubscriptions$annotations() {
    }

    public static /* synthetic */ void getAllPurchasedProductIds$annotations() {
    }

    @Deprecated(message = "Use allPurchasedProductIds instead", replaceWith = @ReplaceWith(expression = "allPurchasedProductIds", imports = {}))
    public static /* synthetic */ void getAllPurchasedSkus$annotations() {
    }

    public static /* synthetic */ void getLatestExpirationDate$annotations() {
    }

    public static /* synthetic */ void getNonSubscriptionTransactions$annotations() {
    }

    public static /* synthetic */ void getRawData$annotations() {
    }

    private static /* synthetic */ void getSubscriberJSONObject$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final EntitlementInfos getEntitlements() {
        return this.entitlements;
    }

    public final Map<String, Date> component2() {
        return this.allExpirationDatesByProduct;
    }

    public final Map<String, Date> component3() {
        return this.allPurchaseDatesByProduct;
    }

    /* renamed from: component4, reason: from getter */
    public final Date getRequestDate() {
        return this.requestDate;
    }

    /* renamed from: component5, reason: from getter */
    public final int getSchemaVersion() {
        return this.schemaVersion;
    }

    /* renamed from: component6, reason: from getter */
    public final Date getFirstSeen() {
        return this.firstSeen;
    }

    /* renamed from: component7, reason: from getter */
    public final String getOriginalAppUserId() {
        return this.originalAppUserId;
    }

    /* renamed from: component8, reason: from getter */
    public final Uri getManagementURL() {
        return this.managementURL;
    }

    /* renamed from: component9, reason: from getter */
    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    public final CustomerInfo copy(EntitlementInfos entitlements, Map<String, ? extends Date> allExpirationDatesByProduct, Map<String, ? extends Date> allPurchaseDatesByProduct, Date requestDate, int schemaVersion, Date firstSeen, String originalAppUserId, Uri managementURL, Date originalPurchaseDate, JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        Intrinsics.checkNotNullParameter(allExpirationDatesByProduct, "allExpirationDatesByProduct");
        Intrinsics.checkNotNullParameter(allPurchaseDatesByProduct, "allPurchaseDatesByProduct");
        Intrinsics.checkNotNullParameter(requestDate, "requestDate");
        Intrinsics.checkNotNullParameter(firstSeen, "firstSeen");
        Intrinsics.checkNotNullParameter(originalAppUserId, "originalAppUserId");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        return new CustomerInfo(entitlements, allExpirationDatesByProduct, allPurchaseDatesByProduct, requestDate, schemaVersion, firstSeen, originalAppUserId, managementURL, originalPurchaseDate, jsonObject);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.entitlements.writeToParcel(parcel, flags);
        Map<String, Date> map = this.allExpirationDatesByProduct;
        parcel.writeInt(map.size());
        for (Map.Entry<String, Date> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeSerializable(entry.getValue());
        }
        Map<String, Date> map2 = this.allPurchaseDatesByProduct;
        parcel.writeInt(map2.size());
        for (Map.Entry<String, Date> entry2 : map2.entrySet()) {
            parcel.writeString(entry2.getKey());
            parcel.writeSerializable(entry2.getValue());
        }
        parcel.writeSerializable(this.requestDate);
        parcel.writeInt(this.schemaVersion);
        parcel.writeSerializable(this.firstSeen);
        parcel.writeString(this.originalAppUserId);
        parcel.writeParcelable(this.managementURL, flags);
        parcel.writeSerializable(this.originalPurchaseDate);
        JSONObjectParceler.INSTANCE.write(this.jsonObject, parcel, flags);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomerInfo(EntitlementInfos entitlements, Map<String, ? extends Date> allExpirationDatesByProduct, Map<String, ? extends Date> allPurchaseDatesByProduct, Date requestDate, int i, Date firstSeen, String originalAppUserId, Uri uri, Date date, JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        Intrinsics.checkNotNullParameter(allExpirationDatesByProduct, "allExpirationDatesByProduct");
        Intrinsics.checkNotNullParameter(allPurchaseDatesByProduct, "allPurchaseDatesByProduct");
        Intrinsics.checkNotNullParameter(requestDate, "requestDate");
        Intrinsics.checkNotNullParameter(firstSeen, "firstSeen");
        Intrinsics.checkNotNullParameter(originalAppUserId, "originalAppUserId");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        this.entitlements = entitlements;
        this.allExpirationDatesByProduct = allExpirationDatesByProduct;
        this.allPurchaseDatesByProduct = allPurchaseDatesByProduct;
        this.requestDate = requestDate;
        this.schemaVersion = i;
        this.firstSeen = firstSeen;
        this.originalAppUserId = originalAppUserId;
        this.managementURL = uri;
        this.originalPurchaseDate = date;
        this.jsonObject = jsonObject;
        this.activeSubscriptions = LazyKt.lazy(new Function0<Set<? extends String>>() { // from class: com.revenuecat.purchases.CustomerInfo$activeSubscriptions$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends String> invoke() {
                Set<? extends String> activeIdentifiers;
                CustomerInfo customerInfo = CustomerInfo.this;
                activeIdentifiers = customerInfo.activeIdentifiers(customerInfo.getAllExpirationDatesByProduct());
                return activeIdentifiers;
            }
        });
        this.allPurchasedSkus = LazyKt.lazy(new Function0<Set<? extends String>>() { // from class: com.revenuecat.purchases.CustomerInfo$allPurchasedSkus$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends String> invoke() {
                List<Transaction> nonSubscriptionTransactions = CustomerInfo.this.getNonSubscriptionTransactions();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(nonSubscriptionTransactions, 10));
                Iterator<T> it = nonSubscriptionTransactions.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Transaction) it.next()).getProductIdentifier());
                }
                return SetsKt.plus(CollectionsKt.toSet(arrayList), (Iterable) CustomerInfo.this.getAllExpirationDatesByProduct().keySet());
            }
        });
        this.allPurchasedProductIds = LazyKt.lazy(new Function0<Set<? extends String>>() { // from class: com.revenuecat.purchases.CustomerInfo$allPurchasedProductIds$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends String> invoke() {
                List<Transaction> nonSubscriptionTransactions = CustomerInfo.this.getNonSubscriptionTransactions();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(nonSubscriptionTransactions, 10));
                Iterator<T> it = nonSubscriptionTransactions.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Transaction) it.next()).getProductIdentifier());
                }
                return SetsKt.plus(CollectionsKt.toSet(arrayList), (Iterable) CustomerInfo.this.getAllExpirationDatesByProduct().keySet());
            }
        });
        this.latestExpirationDate = LazyKt.lazy(new Function0<Date>() { // from class: com.revenuecat.purchases.CustomerInfo$latestExpirationDate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Date invoke() {
                List sortedWith = CollectionsKt.sortedWith(CustomerInfo.this.getAllExpirationDatesByProduct().values(), new Comparator() { // from class: com.revenuecat.purchases.CustomerInfo$latestExpirationDate$2$invoke$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues((Date) t, (Date) t2);
                    }
                });
                if (sortedWith.isEmpty()) {
                    sortedWith = null;
                }
                if (sortedWith != null) {
                    return (Date) CollectionsKt.last(sortedWith);
                }
                return null;
            }
        });
        this.nonSubscriptionTransactions = LazyKt.lazy(new Function0<List<? extends Transaction>>() { // from class: com.revenuecat.purchases.CustomerInfo$nonSubscriptionTransactions$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Transaction> invoke() {
                JSONObject jSONObject;
                ArrayList arrayList = new ArrayList();
                jSONObject = CustomerInfo.this.subscriberJSONObject;
                JSONObject jSONObject2 = jSONObject.getJSONObject(CustomerInfoResponseJsonKeys.NON_SUBSCRIPTIONS);
                Iterator<String> keys = jSONObject2.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "nonSubscriptions.keys()");
                while (keys.hasNext()) {
                    String productId = keys.next();
                    JSONArray jSONArray = jSONObject2.getJSONArray(productId);
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject transactionJSONObject = jSONArray.getJSONObject(i2);
                        Intrinsics.checkNotNullExpressionValue(productId, "productId");
                        Intrinsics.checkNotNullExpressionValue(transactionJSONObject, "transactionJSONObject");
                        arrayList.add(new Transaction(productId, transactionJSONObject));
                    }
                }
                return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.revenuecat.purchases.CustomerInfo$nonSubscriptionTransactions$2$invoke$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((Transaction) t).getPurchaseDate(), ((Transaction) t2).getPurchaseDate());
                    }
                });
            }
        });
        this.subscriberJSONObject = jsonObject.getJSONObject(CustomerInfoResponseJsonKeys.SUBSCRIBER);
    }

    public final EntitlementInfos getEntitlements() {
        return this.entitlements;
    }

    public final Map<String, Date> getAllExpirationDatesByProduct() {
        return this.allExpirationDatesByProduct;
    }

    public final Map<String, Date> getAllPurchaseDatesByProduct() {
        return this.allPurchaseDatesByProduct;
    }

    public final Date getRequestDate() {
        return this.requestDate;
    }

    public final int getSchemaVersion() {
        return this.schemaVersion;
    }

    public final Date getFirstSeen() {
        return this.firstSeen;
    }

    public final String getOriginalAppUserId() {
        return this.originalAppUserId;
    }

    public final Uri getManagementURL() {
        return this.managementURL;
    }

    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    public final Set<String> getActiveSubscriptions() {
        return (Set) this.activeSubscriptions.getValue();
    }

    public final Set<String> getAllPurchasedSkus() {
        return (Set) this.allPurchasedSkus.getValue();
    }

    public final Set<String> getAllPurchasedProductIds() {
        return (Set) this.allPurchasedProductIds.getValue();
    }

    public final Date getLatestExpirationDate() {
        return (Date) this.latestExpirationDate.getValue();
    }

    public final List<Transaction> getNonSubscriptionTransactions() {
        return (List) this.nonSubscriptionTransactions.getValue();
    }

    @Deprecated(message = "Use getExpirationDateForProductId instead", replaceWith = @ReplaceWith(expression = "getExpirationDateForProductId", imports = {}))
    public final Date getExpirationDateForSku(String sku) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        return this.allExpirationDatesByProduct.get(sku);
    }

    public final Date getExpirationDateForProductId(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        return this.allExpirationDatesByProduct.get(productId);
    }

    @Deprecated(message = "Use getPurchaseDateForProductId instead", replaceWith = @ReplaceWith(expression = "getPurchaseDateForProductId", imports = {}))
    public final Date getPurchaseDateForSku(String sku) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        return this.allPurchaseDatesByProduct.get(sku);
    }

    public final Date getPurchaseDateForProductId(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        return this.allPurchaseDatesByProduct.get(productId);
    }

    public final Date getExpirationDateForEntitlement(String entitlement) {
        Intrinsics.checkNotNullParameter(entitlement, "entitlement");
        EntitlementInfo entitlementInfo = this.entitlements.getAll().get(entitlement);
        if (entitlementInfo != null) {
            return entitlementInfo.getExpirationDate();
        }
        return null;
    }

    public final Date getPurchaseDateForEntitlement(String entitlement) {
        Intrinsics.checkNotNullParameter(entitlement, "entitlement");
        EntitlementInfo entitlementInfo = this.entitlements.getAll().get(entitlement);
        if (entitlementInfo != null) {
            return entitlementInfo.getLatestPurchaseDate();
        }
        return null;
    }

    @Override // com.revenuecat.purchases.models.RawDataContainer
    public JSONObject getRawData() {
        return this.jsonObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<CustomerInfo\n latestExpirationDate: ");
        sb.append(getLatestExpirationDate());
        sb.append("\nactiveSubscriptions:  ");
        Set<String> activeSubscriptions = getActiveSubscriptions();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(activeSubscriptions, 10));
        for (String str : activeSubscriptions) {
            arrayList.add(TuplesKt.to(str, MapsKt.mapOf(TuplesKt.to("expiresDate", getExpirationDateForProductId(str)))));
        }
        sb.append(MapsKt.toMap(arrayList));
        sb.append(",\nactiveEntitlements: ");
        Map<String, EntitlementInfo> active = this.entitlements.getActive();
        ArrayList arrayList2 = new ArrayList(active.size());
        Iterator<Map.Entry<String, EntitlementInfo>> it = active.entrySet().iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().toString());
        }
        sb.append(arrayList2);
        sb.append(",\nentitlements: ");
        Map<String, EntitlementInfo> all = this.entitlements.getAll();
        ArrayList arrayList3 = new ArrayList(all.size());
        Iterator<Map.Entry<String, EntitlementInfo>> it2 = all.entrySet().iterator();
        while (it2.hasNext()) {
            arrayList3.add(it2.next().toString());
        }
        sb.append(arrayList3);
        sb.append(",\nnonSubscriptionTransactions: ");
        sb.append(getNonSubscriptionTransactions());
        sb.append(",\nrequestDate: ");
        sb.append(this.requestDate);
        sb.append("\n>");
        return sb.toString();
    }

    public boolean equals(Object other) {
        return (other instanceof CustomerInfo) && Intrinsics.areEqual(new ComparableData(this), new ComparableData((CustomerInfo) other));
    }

    public int hashCode() {
        return new ComparableData(this).hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<String> activeIdentifiers(Map<String, ? extends Date> expirations) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends Date> entry : expirations.entrySet()) {
            if (DateHelper.Companion.m1103isDateActiveSxA4cEA$default(DateHelper.INSTANCE, entry.getValue(), this.requestDate, 0L, 4, null).isActive()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap.keySet();
    }
}
