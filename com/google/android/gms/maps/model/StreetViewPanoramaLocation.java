package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes4.dex */
public class StreetViewPanoramaLocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaLocation> CREATOR = new zzw();
    public final StreetViewPanoramaLink[] links;
    public final String panoId;
    public final LatLng position;

    public StreetViewPanoramaLocation(StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this.links = streetViewPanoramaLinkArr;
        this.position = latLng;
        this.panoId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) obj;
        return this.panoId.equals(streetViewPanoramaLocation.panoId) && this.position.equals(streetViewPanoramaLocation.position);
    }

    public int hashCode() {
        return Objects.hashCode(this.position, this.panoId);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("panoId", this.panoId).add(ViewProps.POSITION, this.position.toString()).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = this.links;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, streetViewPanoramaLinkArr, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.position, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.panoId, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
