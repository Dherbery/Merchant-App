package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.a.a.o.b;
import com.facebook.hermes.intl.Constants;
import com.revenuecat.purchases.utils.PriceExtensionsKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PricingPhase.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u001b\u001a\u00020\tHÆ\u0003J8\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\u0012\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020$HÖ\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006."}, d2 = {"Lcom/revenuecat/purchases/models/PricingPhase;", "Landroid/os/Parcelable;", "billingPeriod", "Lcom/revenuecat/purchases/models/Period;", "recurrenceMode", "Lcom/revenuecat/purchases/models/RecurrenceMode;", "billingCycleCount", "", b.x, "Lcom/revenuecat/purchases/models/Price;", "(Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/RecurrenceMode;Ljava/lang/Integer;Lcom/revenuecat/purchases/models/Price;)V", "getBillingCycleCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBillingPeriod", "()Lcom/revenuecat/purchases/models/Period;", "offerPaymentMode", "Lcom/revenuecat/purchases/models/OfferPaymentMode;", "getOfferPaymentMode", "()Lcom/revenuecat/purchases/models/OfferPaymentMode;", "getPrice", "()Lcom/revenuecat/purchases/models/Price;", "getRecurrenceMode", "()Lcom/revenuecat/purchases/models/RecurrenceMode;", "component1", "component2", "component3", "component4", "copy", "(Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/RecurrenceMode;Ljava/lang/Integer;Lcom/revenuecat/purchases/models/Price;)Lcom/revenuecat/purchases/models/PricingPhase;", "describeContents", "equals", "", "other", "", "formattedPriceInMonths", "", Constants.LOCALE, "Ljava/util/Locale;", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PricingPhase implements Parcelable {
    public static final Parcelable.Creator<PricingPhase> CREATOR = new Creator();
    private final Integer billingCycleCount;
    private final Period billingPeriod;
    private final Price price;
    private final RecurrenceMode recurrenceMode;

    /* compiled from: PricingPhase.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<PricingPhase> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PricingPhase createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PricingPhase(Period.CREATOR.createFromParcel(parcel), RecurrenceMode.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), Price.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PricingPhase[] newArray(int i) {
            return new PricingPhase[i];
        }
    }

    public static /* synthetic */ PricingPhase copy$default(PricingPhase pricingPhase, Period period, RecurrenceMode recurrenceMode, Integer num, Price price, int i, Object obj) {
        if ((i & 1) != 0) {
            period = pricingPhase.billingPeriod;
        }
        if ((i & 2) != 0) {
            recurrenceMode = pricingPhase.recurrenceMode;
        }
        if ((i & 4) != 0) {
            num = pricingPhase.billingCycleCount;
        }
        if ((i & 8) != 0) {
            price = pricingPhase.price;
        }
        return pricingPhase.copy(period, recurrenceMode, num, price);
    }

    /* renamed from: component1, reason: from getter */
    public final Period getBillingPeriod() {
        return this.billingPeriod;
    }

    /* renamed from: component2, reason: from getter */
    public final RecurrenceMode getRecurrenceMode() {
        return this.recurrenceMode;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getBillingCycleCount() {
        return this.billingCycleCount;
    }

    /* renamed from: component4, reason: from getter */
    public final Price getPrice() {
        return this.price;
    }

    public final PricingPhase copy(Period billingPeriod, RecurrenceMode recurrenceMode, Integer billingCycleCount, Price price) {
        Intrinsics.checkNotNullParameter(billingPeriod, "billingPeriod");
        Intrinsics.checkNotNullParameter(recurrenceMode, "recurrenceMode");
        Intrinsics.checkNotNullParameter(price, "price");
        return new PricingPhase(billingPeriod, recurrenceMode, billingCycleCount, price);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PricingPhase)) {
            return false;
        }
        PricingPhase pricingPhase = (PricingPhase) other;
        return Intrinsics.areEqual(this.billingPeriod, pricingPhase.billingPeriod) && this.recurrenceMode == pricingPhase.recurrenceMode && Intrinsics.areEqual(this.billingCycleCount, pricingPhase.billingCycleCount) && Intrinsics.areEqual(this.price, pricingPhase.price);
    }

    public final String formattedPriceInMonths() {
        return formattedPriceInMonths$default(this, null, 1, null);
    }

    public int hashCode() {
        int hashCode = ((this.billingPeriod.hashCode() * 31) + this.recurrenceMode.hashCode()) * 31;
        Integer num = this.billingCycleCount;
        return ((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.price.hashCode();
    }

    public String toString() {
        return "PricingPhase(billingPeriod=" + this.billingPeriod + ", recurrenceMode=" + this.recurrenceMode + ", billingCycleCount=" + this.billingCycleCount + ", price=" + this.price + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int intValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.billingPeriod.writeToParcel(parcel, flags);
        parcel.writeString(this.recurrenceMode.name());
        Integer num = this.billingCycleCount;
        if (num == null) {
            intValue = 0;
        } else {
            parcel.writeInt(1);
            intValue = num.intValue();
        }
        parcel.writeInt(intValue);
        this.price.writeToParcel(parcel, flags);
    }

    public PricingPhase(Period billingPeriod, RecurrenceMode recurrenceMode, Integer num, Price price) {
        Intrinsics.checkNotNullParameter(billingPeriod, "billingPeriod");
        Intrinsics.checkNotNullParameter(recurrenceMode, "recurrenceMode");
        Intrinsics.checkNotNullParameter(price, "price");
        this.billingPeriod = billingPeriod;
        this.recurrenceMode = recurrenceMode;
        this.billingCycleCount = num;
        this.price = price;
    }

    public final Period getBillingPeriod() {
        return this.billingPeriod;
    }

    public final RecurrenceMode getRecurrenceMode() {
        return this.recurrenceMode;
    }

    public final Integer getBillingCycleCount() {
        return this.billingCycleCount;
    }

    public final Price getPrice() {
        return this.price;
    }

    public final OfferPaymentMode getOfferPaymentMode() {
        if (this.recurrenceMode != RecurrenceMode.FINITE_RECURRING) {
            return null;
        }
        if (this.price.getAmountMicros() == 0) {
            return OfferPaymentMode.FREE_TRIAL;
        }
        Integer num = this.billingCycleCount;
        if (num != null && num.intValue() == 1) {
            return OfferPaymentMode.SINGLE_PAYMENT;
        }
        Integer num2 = this.billingCycleCount;
        if (num2 == null || num2.intValue() <= 1) {
            return null;
        }
        return OfferPaymentMode.DISCOUNTED_RECURRING_PAYMENT;
    }

    public static /* synthetic */ String formattedPriceInMonths$default(PricingPhase pricingPhase, Locale locale, int i, Object obj) {
        if ((i & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return pricingPhase.formattedPriceInMonths(locale);
    }

    public final String formattedPriceInMonths(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return PriceExtensionsKt.pricePerMonth(this.price, this.billingPeriod, locale).getFormatted();
    }
}
