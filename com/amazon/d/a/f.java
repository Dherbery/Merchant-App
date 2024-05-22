package com.amazon.d.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.amazon.d.a.a;
import com.amazon.d.a.e;
import java.util.Map;

/* compiled from: DecisionResult.java */
/* loaded from: classes.dex */
public interface f extends IInterface {
    String a() throws RemoteException;

    void a(e eVar) throws RemoteException;

    String b() throws RemoteException;

    String c() throws RemoteException;

    long d() throws RemoteException;

    com.amazon.d.a.a e() throws RemoteException;

    com.amazon.d.a.a f() throws RemoteException;

    com.amazon.d.a.a g() throws RemoteException;

    Map h() throws RemoteException;

    /* compiled from: DecisionResult.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements f {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        static final int d = 4;
        static final int e = 5;
        static final int f = 6;
        static final int g = 7;
        static final int h = 8;
        static final int i = 9;
        private static final String j = "com.amazon.venezia.command.DecisionResult";

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, j);
        }

        public static f a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(j);
            if (queryLocalInterface != null && (queryLocalInterface instanceof f)) {
                return (f) queryLocalInterface;
            }
            return new C0013a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(j);
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface(j);
                    String a2 = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a2);
                    return true;
                case 2:
                    parcel.enforceInterface(j);
                    String b2 = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b2);
                    return true;
                case 3:
                    parcel.enforceInterface(j);
                    String c2 = c();
                    parcel2.writeNoException();
                    parcel2.writeString(c2);
                    return true;
                case 4:
                    parcel.enforceInterface(j);
                    long d2 = d();
                    parcel2.writeNoException();
                    parcel2.writeLong(d2);
                    return true;
                case 5:
                    parcel.enforceInterface(j);
                    a(e.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(j);
                    com.amazon.d.a.a e2 = e();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(e2 != null ? e2.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface(j);
                    com.amazon.d.a.a f2 = f();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(f2 != null ? f2.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface(j);
                    com.amazon.d.a.a g2 = g();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(g2 != null ? g2.asBinder() : null);
                    return true;
                case 9:
                    parcel.enforceInterface(j);
                    Map h2 = h();
                    parcel2.writeNoException();
                    parcel2.writeMap(h2);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* compiled from: DecisionResult.java */
        /* renamed from: com.amazon.d.a.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0013a implements f {
            private IBinder a;

            public String i() {
                return a.j;
            }

            C0013a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.amazon.d.a.f
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.j);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amazon.d.a.f
            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.j);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amazon.d.a.f
            public String c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.j);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amazon.d.a.f
            public long d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.j);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amazon.d.a.f
            public void a(e eVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.j);
                    obtain.writeStrongBinder(eVar != null ? eVar.asBinder() : null);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amazon.d.a.f
            public com.amazon.d.a.a e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.j);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return a.AbstractBinderC0007a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amazon.d.a.f
            public com.amazon.d.a.a f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.j);
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return a.AbstractBinderC0007a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amazon.d.a.f
            public com.amazon.d.a.a g() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.j);
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return a.AbstractBinderC0007a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.amazon.d.a.f
            public Map h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.j);
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
