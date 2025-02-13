package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public final class zzvt extends zza implements IInterface {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvt(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.barcode.aidls.IBarcodeScanner");
    }

    public final List zzd(IObjectWrapper iObjectWrapper, zzwc zzwcVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, iObjectWrapper);
        zzc.zza(zza, zzwcVar);
        Parcel zzb = zzb(3, zza);
        ArrayList createTypedArrayList = zzb.createTypedArrayList(zzvj.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final void zze() throws RemoteException {
        zzc(1, zza());
    }

    public final void zzf() throws RemoteException {
        zzc(2, zza());
    }
}
