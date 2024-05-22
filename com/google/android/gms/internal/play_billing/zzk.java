package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
public final class zzk extends zzp implements zzm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingService");
    }

    @Override // com.google.android.gms.internal.play_billing.zzm
    public final int zza(int i, String str, String str2) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(3);
        zzr.writeString(str);
        zzr.writeString(str2);
        Parcel zzs = zzs(5, zzr);
        int readInt = zzs.readInt();
        zzs.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.play_billing.zzm
    public final int zzc(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(i);
        zzr.writeString(str);
        zzr.writeString(str2);
        zzr.zzc(zzr, bundle);
        Parcel zzs = zzs(10, zzr);
        int readInt = zzs.readInt();
        zzs.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.play_billing.zzm
    public final Bundle zzd(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(9);
        zzr.writeString(str);
        zzr.writeString(str2);
        zzr.zzc(zzr, bundle);
        Parcel zzs = zzs(902, zzr);
        Bundle bundle2 = (Bundle) zzr.zza(zzs, Bundle.CREATOR);
        zzs.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzm
    public final Bundle zze(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(9);
        zzr.writeString(str);
        zzr.writeString(str2);
        zzr.zzc(zzr, bundle);
        Parcel zzs = zzs(12, zzr);
        Bundle bundle2 = (Bundle) zzr.zza(zzs, Bundle.CREATOR);
        zzs.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzm
    public final Bundle zzf(int i, String str, String str2, String str3, String str4) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(3);
        zzr.writeString(str);
        zzr.writeString(str2);
        zzr.writeString(str3);
        zzr.writeString(null);
        Parcel zzs = zzs(3, zzr);
        Bundle bundle = (Bundle) zzr.zza(zzs, Bundle.CREATOR);
        zzs.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzm
    public final Bundle zzg(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(i);
        zzr.writeString(str);
        zzr.writeString(str2);
        zzr.writeString(str3);
        zzr.writeString(null);
        zzr.zzc(zzr, bundle);
        Parcel zzs = zzs(8, zzr);
        Bundle bundle2 = (Bundle) zzr.zza(zzs, Bundle.CREATOR);
        zzs.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzm
    public final Bundle zzh(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(6);
        zzr.writeString(str);
        zzr.writeString(str2);
        zzr.writeString(str3);
        zzr.zzc(zzr, bundle);
        Parcel zzs = zzs(9, zzr);
        Bundle bundle2 = (Bundle) zzr.zza(zzs, Bundle.CREATOR);
        zzs.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzm
    public final Bundle zzi(int i, String str, String str2, String str3) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(3);
        zzr.writeString(str);
        zzr.writeString(str2);
        zzr.writeString(str3);
        Parcel zzs = zzs(4, zzr);
        Bundle bundle = (Bundle) zzr.zza(zzs, Bundle.CREATOR);
        zzs.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzm
    public final Bundle zzj(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(i);
        zzr.writeString(str);
        zzr.writeString(str2);
        zzr.writeString(str3);
        zzr.zzc(zzr, bundle);
        Parcel zzs = zzs(11, zzr);
        Bundle bundle2 = (Bundle) zzr.zza(zzs, Bundle.CREATOR);
        zzs.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzm
    public final Bundle zzk(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(3);
        zzr.writeString(str);
        zzr.writeString(str2);
        zzr.zzc(zzr, bundle);
        Parcel zzs = zzs(2, zzr);
        Bundle bundle2 = (Bundle) zzr.zza(zzs, Bundle.CREATOR);
        zzs.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzm
    public final Bundle zzl(int i, String str, String str2, Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(i);
        zzr.writeString(str);
        zzr.writeString(str2);
        zzr.zzc(zzr, bundle);
        zzr.zzc(zzr, bundle2);
        Parcel zzs = zzs(901, zzr);
        Bundle bundle3 = (Bundle) zzr.zza(zzs, Bundle.CREATOR);
        zzs.recycle();
        return bundle3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzm
    public final void zzm(int i, String str, Bundle bundle, zzd zzdVar) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(21);
        zzr.writeString(str);
        zzr.zzc(zzr, bundle);
        zzr.writeStrongBinder(zzdVar);
        zzu(1501, zzr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzm
    public final void zzn(int i, String str, Bundle bundle, zzf zzfVar) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(21);
        zzr.writeString(str);
        zzr.zzc(zzr, bundle);
        zzr.writeStrongBinder(zzfVar);
        zzu(1601, zzr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzm
    public final void zzo(int i, String str, Bundle bundle, zzh zzhVar) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(18);
        zzr.writeString(str);
        zzr.zzc(zzr, bundle);
        zzr.writeStrongBinder(zzhVar);
        zzt(1301, zzr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzm
    public final void zzp(int i, String str, Bundle bundle, zzj zzjVar) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(21);
        zzr.writeString(str);
        zzr.zzc(zzr, bundle);
        zzr.writeStrongBinder(zzjVar);
        zzu(1401, zzr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzm
    public final void zzq(int i, String str, Bundle bundle, zzo zzoVar) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(12);
        zzr.writeString(str);
        zzr.zzc(zzr, bundle);
        zzr.writeStrongBinder(zzoVar);
        zzt(1201, zzr);
    }

    @Override // com.google.android.gms.internal.play_billing.zzm
    public final int zzv(int i, String str, String str2) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(i);
        zzr.writeString(str);
        zzr.writeString(str2);
        Parcel zzs = zzs(1, zzr);
        int readInt = zzs.readInt();
        zzs.recycle();
        return readInt;
    }
}
