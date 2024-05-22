package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.common.LogUtilsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Period.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002'(B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J'\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012¨\u0006)"}, d2 = {"Lcom/revenuecat/purchases/models/Period;", "Landroid/os/Parcelable;", "value", "", "unit", "Lcom/revenuecat/purchases/models/Period$Unit;", "iso8601", "", "(ILcom/revenuecat/purchases/models/Period$Unit;Ljava/lang/String;)V", "getIso8601", "()Ljava/lang/String;", "getUnit", "()Lcom/revenuecat/purchases/models/Period$Unit;", "getValue", "()I", "valueInMonths", "", "getValueInMonths", "()D", "valueInWeeks", "getValueInWeeks$purchases_defaultsRelease", "valueInYears", "getValueInYears$purchases_defaultsRelease", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Factory", "Unit", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Period implements Parcelable {
    private static final double DAYS_PER_MONTH = 30.0d;
    private static final double DAYS_PER_WEEK = 7.0d;
    private static final double DAYS_PER_YEAR = 365.0d;
    private static final double MONTHS_PER_YEAR = 12.0d;
    private static final double WEEKS_PER_MONTH = 4.345238095238096d;
    private static final double WEEKS_PER_YEAR = 52.142857142857146d;
    private final String iso8601;
    private final Unit unit;
    private final int value;

    /* renamed from: Factory, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<Period> CREATOR = new Creator();

    /* compiled from: Period.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<Period> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Period createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Period(parcel.readInt(), Unit.valueOf(parcel.readString()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Period[] newArray(int i) {
            return new Period[i];
        }
    }

    /* compiled from: Period.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/models/Period$Unit;", "", "(Ljava/lang/String;I)V", "DAY", "WEEK", "MONTH", "YEAR", "UNKNOWN", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public enum Unit {
        DAY,
        WEEK,
        MONTH,
        YEAR,
        UNKNOWN
    }

    /* compiled from: Period.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Unit.values().length];
            try {
                iArr[Unit.DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Unit.WEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Unit.MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Unit.YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Unit.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ Period copy$default(Period period, int i, Unit unit, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = period.value;
        }
        if ((i2 & 2) != 0) {
            unit = period.unit;
        }
        if ((i2 & 4) != 0) {
            str = period.iso8601;
        }
        return period.copy(i, unit, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    /* renamed from: component2, reason: from getter */
    public final Unit getUnit() {
        return this.unit;
    }

    /* renamed from: component3, reason: from getter */
    public final String getIso8601() {
        return this.iso8601;
    }

    public final Period copy(int value, Unit unit, String iso8601) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(iso8601, "iso8601");
        return new Period(value, unit, iso8601);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Period)) {
            return false;
        }
        Period period = (Period) other;
        return this.value == period.value && this.unit == period.unit && Intrinsics.areEqual(this.iso8601, period.iso8601);
    }

    public int hashCode() {
        return (((this.value * 31) + this.unit.hashCode()) * 31) + this.iso8601.hashCode();
    }

    public String toString() {
        return "Period(value=" + this.value + ", unit=" + this.unit + ", iso8601=" + this.iso8601 + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.value);
        parcel.writeString(this.unit.name());
        parcel.writeString(this.iso8601);
    }

    public Period(int i, Unit unit, String iso8601) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(iso8601, "iso8601");
        this.value = i;
        this.unit = unit;
        this.iso8601 = iso8601;
    }

    public final int getValue() {
        return this.value;
    }

    public final Unit getUnit() {
        return this.unit;
    }

    public final String getIso8601() {
        return this.iso8601;
    }

    /* compiled from: Period.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/models/Period$Factory;", "", "()V", "DAYS_PER_MONTH", "", "DAYS_PER_WEEK", "DAYS_PER_YEAR", "MONTHS_PER_YEAR", "WEEKS_PER_MONTH", "WEEKS_PER_YEAR", "create", "Lcom/revenuecat/purchases/models/Period;", "iso8601", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.revenuecat.purchases.models.Period$Factory, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Period create(String iso8601) {
            Intrinsics.checkNotNullParameter(iso8601, "iso8601");
            Pair access$toPeriod = PeriodKt.access$toPeriod(iso8601);
            return new Period(((Number) access$toPeriod.getFirst()).intValue(), (Unit) access$toPeriod.getSecond(), iso8601);
        }
    }

    public final double getValueInWeeks$purchases_defaultsRelease() {
        double d;
        double d2;
        int i = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i == 1) {
            return this.value / 7.0d;
        }
        if (i == 2) {
            return this.value;
        }
        if (i == 3) {
            d = this.value;
            d2 = WEEKS_PER_MONTH;
        } else {
            if (i != 4) {
                if (i == 5) {
                    LogUtilsKt.errorLog$default("Unknown period unit trying to get value in months: " + this.unit, null, 2, null);
                    return 0.0d;
                }
                throw new NoWhenBranchMatchedException();
            }
            d = this.value;
            d2 = WEEKS_PER_YEAR;
        }
        return d * d2;
    }

    public final double getValueInMonths() {
        double d;
        double d2;
        int i = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i == 1) {
            d = this.value;
            d2 = DAYS_PER_MONTH;
        } else {
            if (i != 2) {
                if (i == 3) {
                    return this.value;
                }
                if (i == 4) {
                    return this.value * MONTHS_PER_YEAR;
                }
                if (i == 5) {
                    LogUtilsKt.errorLog$default("Unknown period unit trying to get value in months: " + this.unit, null, 2, null);
                    return 0.0d;
                }
                throw new NoWhenBranchMatchedException();
            }
            d = this.value;
            d2 = WEEKS_PER_MONTH;
        }
        return d / d2;
    }

    public final double getValueInYears$purchases_defaultsRelease() {
        double d;
        double d2;
        int i = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i == 1) {
            d = this.value;
            d2 = DAYS_PER_YEAR;
        } else if (i == 2) {
            d = this.value;
            d2 = WEEKS_PER_YEAR;
        } else {
            if (i != 3) {
                if (i == 4) {
                    return this.value;
                }
                if (i == 5) {
                    LogUtilsKt.errorLog$default("Unknown period unit trying to get value in months: " + this.unit, null, 2, null);
                    return 0.0d;
                }
                throw new NoWhenBranchMatchedException();
            }
            d = this.value;
            d2 = MONTHS_PER_YEAR;
        }
        return d / d2;
    }
}
