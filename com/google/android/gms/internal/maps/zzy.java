package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes4.dex */
public final class zzy extends zza implements zzaa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IMapCapabilitiesDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final boolean zzd() throws RemoteException {
        Parcel zzJ = zzJ(1, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }
}
