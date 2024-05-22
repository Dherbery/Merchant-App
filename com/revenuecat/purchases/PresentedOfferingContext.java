package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PresentedOfferingContext.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/PresentedOfferingContext;", "Landroid/os/Parcelable;", "offeringIdentifier", "", "(Ljava/lang/String;)V", "getOfferingIdentifier", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PresentedOfferingContext implements Parcelable {
    public static final Parcelable.Creator<PresentedOfferingContext> CREATOR = new Creator();
    private final String offeringIdentifier;

    /* compiled from: PresentedOfferingContext.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<PresentedOfferingContext> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PresentedOfferingContext createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PresentedOfferingContext(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PresentedOfferingContext[] newArray(int i) {
            return new PresentedOfferingContext[i];
        }
    }

    public static /* synthetic */ PresentedOfferingContext copy$default(PresentedOfferingContext presentedOfferingContext, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = presentedOfferingContext.offeringIdentifier;
        }
        return presentedOfferingContext.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOfferingIdentifier() {
        return this.offeringIdentifier;
    }

    public final PresentedOfferingContext copy(String offeringIdentifier) {
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        return new PresentedOfferingContext(offeringIdentifier);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PresentedOfferingContext) && Intrinsics.areEqual(this.offeringIdentifier, ((PresentedOfferingContext) other).offeringIdentifier);
    }

    public int hashCode() {
        return this.offeringIdentifier.hashCode();
    }

    public String toString() {
        return "PresentedOfferingContext(offeringIdentifier=" + this.offeringIdentifier + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.offeringIdentifier);
    }

    public PresentedOfferingContext(String offeringIdentifier) {
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        this.offeringIdentifier = offeringIdentifier;
    }

    public final String getOfferingIdentifier() {
        return this.offeringIdentifier;
    }
}
