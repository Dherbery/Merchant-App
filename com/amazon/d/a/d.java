package com.amazon.d.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.amazon.d.a.c;
import com.amazon.d.a.i;

/* compiled from: CommandService.java */
/* loaded from: classes.dex */
public interface d extends IInterface {
    void a(c cVar, i iVar) throws RemoteException;

    /* compiled from: CommandService.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements d {
        static final int a = 1;
        private static final String b = "com.amazon.venezia.command.CommandService";

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, b);
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(b);
            if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                return (d) queryLocalInterface;
            }
            return new C0011a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString(b);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(b);
            a(c.a.a(parcel.readStrongBinder()), i.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        /* compiled from: CommandService.java */
        /* renamed from: com.amazon.d.a.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0011a implements d {
            private IBinder a;

            public String a() {
                return a.b;
            }

            C0011a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.amazon.d.a.d
            public void a(c cVar, i iVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.b);
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    obtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
