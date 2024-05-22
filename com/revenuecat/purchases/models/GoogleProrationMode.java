package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.ProrationMode;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoogleProrationMode.kt */
@Deprecated(message = "Replaced with GoogleReplacementMode", replaceWith = @ReplaceWith(expression = "GoogleReplacementMode", imports = {}))
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\u0001\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0016B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/models/GoogleProrationMode;", "", "Lcom/revenuecat/purchases/ProrationMode;", "playBillingClientMode", "", "(Ljava/lang/String;II)V", "asGoogleReplacementMode", "Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "getAsGoogleReplacementMode$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "getPlayBillingClientMode", "()I", "describeContents", "writeToParcel", "", "out", "Landroid/os/Parcel;", "flags", "IMMEDIATE_WITHOUT_PRORATION", "IMMEDIATE_WITH_TIME_PRORATION", "IMMEDIATE_AND_CHARGE_FULL_PRICE", "IMMEDIATE_AND_CHARGE_PRORATED_PRICE", "CREATOR", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public enum GoogleProrationMode implements ProrationMode {
    IMMEDIATE_WITHOUT_PRORATION(3),
    IMMEDIATE_WITH_TIME_PRORATION(1),
    IMMEDIATE_AND_CHARGE_FULL_PRICE(5),
    IMMEDIATE_AND_CHARGE_PRORATED_PRICE(2);


    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int playBillingClientMode;

    /* compiled from: GoogleProrationMode.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GoogleProrationMode.values().length];
            try {
                iArr[GoogleProrationMode.IMMEDIATE_WITHOUT_PRORATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GoogleProrationMode.IMMEDIATE_WITH_TIME_PRORATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GoogleProrationMode.IMMEDIATE_AND_CHARGE_FULL_PRICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GoogleProrationMode.IMMEDIATE_AND_CHARGE_PRORATED_PRICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    GoogleProrationMode(int i) {
        this.playBillingClientMode = i;
    }

    @Override // com.revenuecat.purchases.ProrationMode
    public /* bridge */ /* synthetic */ String getName() {
        return name();
    }

    public final int getPlayBillingClientMode() {
        return this.playBillingClientMode;
    }

    public final GoogleReplacementMode getAsGoogleReplacementMode$purchases_defaultsRelease() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return GoogleReplacementMode.WITHOUT_PRORATION;
        }
        if (i == 2) {
            return GoogleReplacementMode.WITH_TIME_PRORATION;
        }
        if (i == 3) {
            return GoogleReplacementMode.CHARGE_FULL_PRICE;
        }
        if (i == 4) {
            return GoogleReplacementMode.CHARGE_PRORATED_PRICE;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(name());
    }

    /* compiled from: GoogleProrationMode.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/models/GoogleProrationMode$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/revenuecat/purchases/models/GoogleProrationMode;", "()V", "createFromParcel", "in", "Landroid/os/Parcel;", "fromPlayBillingClientMode", "playBillingClientMode", "", "(Ljava/lang/Integer;)Lcom/revenuecat/purchases/models/GoogleProrationMode;", "newArray", "", "size", "(I)[Lcom/revenuecat/purchases/models/GoogleProrationMode;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.revenuecat.purchases.models.GoogleProrationMode$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion implements Parcelable.Creator<GoogleProrationMode> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GoogleProrationMode fromPlayBillingClientMode(Integer playBillingClientMode) {
            if (playBillingClientMode == null) {
                return null;
            }
            playBillingClientMode.intValue();
            for (GoogleProrationMode googleProrationMode : GoogleProrationMode.values()) {
                if (playBillingClientMode.intValue() == googleProrationMode.getPlayBillingClientMode()) {
                    return googleProrationMode;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GoogleProrationMode createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            String readString = in.readString();
            if (readString != null) {
                return GoogleProrationMode.valueOf(readString);
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GoogleProrationMode[] newArray(int size) {
            return new GoogleProrationMode[size];
        }
    }
}
