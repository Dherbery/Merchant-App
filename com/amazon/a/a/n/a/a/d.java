package com.amazon.a.a.n.a.a;

import android.os.DeadObjectException;
import android.os.RemoteException;

/* compiled from: CommandServiceRemoteException.java */
/* loaded from: classes.dex */
public class d extends com.amazon.a.a.d.b {
    private static final long a = 1;

    public d(RemoteException remoteException) {
        super(a(remoteException));
    }

    private static String a(RemoteException remoteException) {
        return remoteException instanceof DeadObjectException ? "COMMAND_SERVICE_DEAD_OBJECT_EXCEPTION" : "COMMAND_SERVICE_REMOTE_EXCEPTION";
    }
}
