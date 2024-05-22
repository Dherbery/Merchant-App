package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.ReplacementMode;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoogleReplacementMode.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0016B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "", "Lcom/revenuecat/purchases/ReplacementMode;", "playBillingClientMode", "", "(Ljava/lang/String;II)V", "asGoogleProrationMode", "Lcom/revenuecat/purchases/models/GoogleProrationMode;", "getAsGoogleProrationMode$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/models/GoogleProrationMode;", "getPlayBillingClientMode", "()I", "describeContents", "writeToParcel", "", "out", "Landroid/os/Parcel;", "flags", "WITHOUT_PRORATION", "WITH_TIME_PRORATION", "CHARGE_FULL_PRICE", "CHARGE_PRORATED_PRICE", "CREATOR", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public enum GoogleReplacementMode implements ReplacementMode {
    WITHOUT_PRORATION(3),
    WITH_TIME_PRORATION(1),
    CHARGE_FULL_PRICE(5),
    CHARGE_PRORATED_PRICE(2);


    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int playBillingClientMode;

    /* compiled from: GoogleReplacementMode.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GoogleReplacementMode.values().length];
            try {
                iArr[GoogleReplacementMode.WITHOUT_PRORATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GoogleReplacementMode.WITH_TIME_PRORATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GoogleReplacementMode.CHARGE_FULL_PRICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GoogleReplacementMode.CHARGE_PRORATED_PRICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    GoogleReplacementMode(int i) {
        this.playBillingClientMode = i;
    }

    @Override // com.revenuecat.purchases.ReplacementMode
    public /* bridge */ /* synthetic */ String getName() {
        return name();
    }

    public final int getPlayBillingClientMode() {
        return this.playBillingClientMode;
    }

    public final GoogleProrationMode getAsGoogleProrationMode$purchases_defaultsRelease() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return GoogleProrationMode.IMMEDIATE_WITHOUT_PRORATION;
        }
        if (i == 2) {
            return GoogleProrationMode.IMMEDIATE_WITH_TIME_PRORATION;
        }
        if (i == 3) {
            return GoogleProrationMode.IMMEDIATE_AND_CHARGE_FULL_PRICE;
        }
        if (i == 4) {
            return GoogleProrationMode.IMMEDIATE_AND_CHARGE_PRORATED_PRICE;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(name());
    }

    /* compiled from: GoogleReplacementMode.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/models/GoogleReplacementMode$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "()V", "createFromParcel", "in", "Landroid/os/Parcel;", "fromPlayBillingClientMode", "playBillingClientMode", "", "(Ljava/lang/Integer;)Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "newArray", "", "size", "(I)[Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.revenuecat.purchases.models.GoogleReplacementMode$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion implements Parcelable.Creator<GoogleReplacementMode> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GoogleReplacementMode fromPlayBillingClientMode(Integer playBillingClientMode) {
            if (playBillingClientMode == null) {
                return null;
            }
            playBillingClientMode.intValue();
            for (GoogleReplacementMode googleReplacementMode : GoogleReplacementMode.values()) {
                if (playBillingClientMode.intValue() == googleReplacementMode.getPlayBillingClientMode()) {
                    return googleReplacementMode;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GoogleReplacementMode createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            String readString = in.readString();
            if (readString != null) {
                return GoogleReplacementMode.valueOf(readString);
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GoogleReplacementMode[] newArray(int size) {
            return new GoogleReplacementMode[size];
        }
    }
}
