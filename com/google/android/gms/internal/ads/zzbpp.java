package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbpp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbpp> CREATOR = new zzbpq();
    public final int zza;
    public final int zzb;
    public final String zzc;
    public final int zzd;

    public zzbpp(int i, int i2, String str, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
        this.zzd = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zzb;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeString(parcel, 2, this.zzc, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
