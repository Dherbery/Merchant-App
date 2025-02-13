package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public final class zzvu extends zza implements zzvw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvu(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.barcode.aidls.IBarcodeScannerCreator");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzvw
    public final zzvt zzd(IObjectWrapper iObjectWrapper, zzvl zzvlVar) throws RemoteException {
        zzvt zzvtVar;
        Parcel zza = zza();
        zzc.zzb(zza, iObjectWrapper);
        zzc.zza(zza, zzvlVar);
        Parcel zzb = zzb(1, zza);
        IBinder readStrongBinder = zzb.readStrongBinder();
        if (readStrongBinder == null) {
            zzvtVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.mlkit.vision.barcode.aidls.IBarcodeScanner");
            zzvtVar = queryLocalInterface instanceof zzvt ? (zzvt) queryLocalInterface : new zzvt(readStrongBinder);
        }
        zzb.recycle();
        return zzvtVar;
    }
}
