package com.revenuecat.purchases;

import com.amazon.a.a.o.b;
import com.facebook.hermes.intl.Constants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Offering.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u0015\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006HÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003JO\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0012\u00106\u001a\u0004\u0018\u00010\t2\u0006\u00107\u001a\u000208H\u0002J\u0011\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\u0003H\u0086\u0002J\u0016\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u0003J\u000e\u0010>\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003J\t\u0010?\u001a\u00020@HÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0017\u0010\u000fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001b\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001c\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u001d\u0010!\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b\"\u0010\u000fR\u001d\u0010$\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b%\u0010\u000fR\u001d\u0010'\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0011\u001a\u0004\b(\u0010\u000fR\u001d\u0010*\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0011\u001a\u0004\b+\u0010\u000f¨\u0006B"}, d2 = {"Lcom/revenuecat/purchases/Offering;", "", "identifier", "", "serverDescription", TtmlNode.TAG_METADATA, "", "availablePackages", "", "Lcom/revenuecat/purchases/Package;", "paywall", "Lcom/revenuecat/purchases/paywalls/PaywallData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Lcom/revenuecat/purchases/paywalls/PaywallData;)V", "annual", "getAnnual", "()Lcom/revenuecat/purchases/Package;", "annual$delegate", "Lkotlin/Lazy;", "getAvailablePackages", "()Ljava/util/List;", "getIdentifier", "()Ljava/lang/String;", "lifetime", "getLifetime", "lifetime$delegate", "getMetadata", "()Ljava/util/Map;", "monthly", "getMonthly", "monthly$delegate", "getPaywall", "()Lcom/revenuecat/purchases/paywalls/PaywallData;", "getServerDescription", "sixMonth", "getSixMonth", "sixMonth$delegate", "threeMonth", "getThreeMonth", "threeMonth$delegate", "twoMonth", "getTwoMonth", "twoMonth$delegate", "weekly", "getWeekly", "weekly$delegate", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "findPackage", "packageType", "Lcom/revenuecat/purchases/PackageType;", b.ar, "s", "getMetadataString", SubscriberAttributeKt.JSON_NAME_KEY, Constants.COLLATION_DEFAULT, "getPackage", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Offering {

    /* renamed from: annual$delegate, reason: from kotlin metadata */
    private final Lazy annual;
    private final List<Package> availablePackages;
    private final String identifier;

    /* renamed from: lifetime$delegate, reason: from kotlin metadata */
    private final Lazy lifetime;
    private final Map<String, Object> metadata;

    /* renamed from: monthly$delegate, reason: from kotlin metadata */
    private final Lazy monthly;
    private final PaywallData paywall;
    private final String serverDescription;

    /* renamed from: sixMonth$delegate, reason: from kotlin metadata */
    private final Lazy sixMonth;

    /* renamed from: threeMonth$delegate, reason: from kotlin metadata */
    private final Lazy threeMonth;

    /* renamed from: twoMonth$delegate, reason: from kotlin metadata */
    private final Lazy twoMonth;

    /* renamed from: weekly$delegate, reason: from kotlin metadata */
    private final Lazy weekly;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Offering(String identifier, String serverDescription, Map<String, ? extends Object> metadata, List<Package> availablePackages) {
        this(identifier, serverDescription, metadata, availablePackages, null, 16, null);
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(serverDescription, "serverDescription");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(availablePackages, "availablePackages");
    }

    public static /* synthetic */ Offering copy$default(Offering offering, String str, String str2, Map map, List list, PaywallData paywallData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = offering.identifier;
        }
        if ((i & 2) != 0) {
            str2 = offering.serverDescription;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            map = offering.metadata;
        }
        Map map2 = map;
        if ((i & 8) != 0) {
            list = offering.availablePackages;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            paywallData = offering.paywall;
        }
        return offering.copy(str, str3, map2, list2, paywallData);
    }

    /* renamed from: component1, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    /* renamed from: component2, reason: from getter */
    public final String getServerDescription() {
        return this.serverDescription;
    }

    public final Map<String, Object> component3() {
        return this.metadata;
    }

    public final List<Package> component4() {
        return this.availablePackages;
    }

    /* renamed from: component5, reason: from getter */
    public final PaywallData getPaywall() {
        return this.paywall;
    }

    public final Offering copy(String identifier, String serverDescription, Map<String, ? extends Object> metadata, List<Package> availablePackages, PaywallData paywall) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(serverDescription, "serverDescription");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(availablePackages, "availablePackages");
        return new Offering(identifier, serverDescription, metadata, availablePackages, paywall);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Offering)) {
            return false;
        }
        Offering offering = (Offering) other;
        return Intrinsics.areEqual(this.identifier, offering.identifier) && Intrinsics.areEqual(this.serverDescription, offering.serverDescription) && Intrinsics.areEqual(this.metadata, offering.metadata) && Intrinsics.areEqual(this.availablePackages, offering.availablePackages) && Intrinsics.areEqual(this.paywall, offering.paywall);
    }

    public int hashCode() {
        int hashCode = ((((((this.identifier.hashCode() * 31) + this.serverDescription.hashCode()) * 31) + this.metadata.hashCode()) * 31) + this.availablePackages.hashCode()) * 31;
        PaywallData paywallData = this.paywall;
        return hashCode + (paywallData == null ? 0 : paywallData.hashCode());
    }

    public String toString() {
        return "Offering(identifier=" + this.identifier + ", serverDescription=" + this.serverDescription + ", metadata=" + this.metadata + ", availablePackages=" + this.availablePackages + ", paywall=" + this.paywall + ')';
    }

    public Offering(String identifier, String serverDescription, Map<String, ? extends Object> metadata, List<Package> availablePackages, PaywallData paywallData) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(serverDescription, "serverDescription");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(availablePackages, "availablePackages");
        this.identifier = identifier;
        this.serverDescription = serverDescription;
        this.metadata = metadata;
        this.availablePackages = availablePackages;
        this.paywall = paywallData;
        this.lifetime = LazyKt.lazy(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$lifetime$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                Package findPackage;
                findPackage = Offering.this.findPackage(PackageType.LIFETIME);
                return findPackage;
            }
        });
        this.annual = LazyKt.lazy(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$annual$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                Package findPackage;
                findPackage = Offering.this.findPackage(PackageType.ANNUAL);
                return findPackage;
            }
        });
        this.sixMonth = LazyKt.lazy(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$sixMonth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                Package findPackage;
                findPackage = Offering.this.findPackage(PackageType.SIX_MONTH);
                return findPackage;
            }
        });
        this.threeMonth = LazyKt.lazy(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$threeMonth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                Package findPackage;
                findPackage = Offering.this.findPackage(PackageType.THREE_MONTH);
                return findPackage;
            }
        });
        this.twoMonth = LazyKt.lazy(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$twoMonth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                Package findPackage;
                findPackage = Offering.this.findPackage(PackageType.TWO_MONTH);
                return findPackage;
            }
        });
        this.monthly = LazyKt.lazy(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$monthly$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                Package findPackage;
                findPackage = Offering.this.findPackage(PackageType.MONTHLY);
                return findPackage;
            }
        });
        this.weekly = LazyKt.lazy(new Function0<Package>() { // from class: com.revenuecat.purchases.Offering$weekly$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                Package findPackage;
                findPackage = Offering.this.findPackage(PackageType.WEEKLY);
                return findPackage;
            }
        });
    }

    public /* synthetic */ Offering(String str, String str2, Map map, List list, PaywallData paywallData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, map, list, (i & 16) != 0 ? null : paywallData);
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getServerDescription() {
        return this.serverDescription;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final List<Package> getAvailablePackages() {
        return this.availablePackages;
    }

    public final PaywallData getPaywall() {
        return this.paywall;
    }

    public final Package getLifetime() {
        return (Package) this.lifetime.getValue();
    }

    public final Package getAnnual() {
        return (Package) this.annual.getValue();
    }

    public final Package getSixMonth() {
        return (Package) this.sixMonth.getValue();
    }

    public final Package getThreeMonth() {
        return (Package) this.threeMonth.getValue();
    }

    public final Package getTwoMonth() {
        return (Package) this.twoMonth.getValue();
    }

    public final Package getMonthly() {
        return (Package) this.monthly.getValue();
    }

    public final Package getWeekly() {
        return (Package) this.weekly.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Package findPackage(PackageType packageType) {
        Object obj;
        Iterator<T> it = this.availablePackages.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Package) obj).getIdentifier(), packageType.getIdentifier())) {
                break;
            }
        }
        return (Package) obj;
    }

    public final Package get(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        return getPackage(s);
    }

    public final Package getPackage(String identifier) throws NoSuchElementException {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        for (Package r1 : this.availablePackages) {
            if (Intrinsics.areEqual(r1.getIdentifier(), identifier)) {
                return r1;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final String getMetadataString(String key, String r3) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(r3, "default");
        Object obj = this.metadata.get(key);
        String str = obj instanceof String ? (String) obj : null;
        return str == null ? r3 : str;
    }
}
