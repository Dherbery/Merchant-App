package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.PlaybackException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public class zzhp extends zzgx {
    public final zzhb zzb;
    public final int zzc;

    public zzhp(zzhb zzhbVar, int i, int i2) {
        super(zzb(2008, 1));
        this.zzb = zzhbVar;
        this.zzc = 1;
    }

    public static zzhp zza(IOException iOException, zzhb zzhbVar, int i) {
        int i2;
        String message = iOException.getMessage();
        if (iOException instanceof SocketTimeoutException) {
            i2 = PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT;
        } else if (iOException instanceof InterruptedIOException) {
            i2 = 1004;
        } else {
            i2 = (message == null || !zzfwk.zza(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        }
        if (i2 == 2007) {
            return new zzho(iOException, zzhbVar);
        }
        return new zzhp(iOException, zzhbVar, i2, i);
    }

    private static int zzb(int i, int i2) {
        if (i != 2000) {
            return i;
        }
        if (i2 != 1) {
            return 2000;
        }
        return PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED;
    }

    public zzhp(IOException iOException, zzhb zzhbVar, int i, int i2) {
        super(iOException, zzb(i, i2));
        this.zzb = zzhbVar;
        this.zzc = i2;
    }

    public zzhp(String str, zzhb zzhbVar, int i, int i2) {
        super(str, zzb(i, i2));
        this.zzb = zzhbVar;
        this.zzc = i2;
    }

    public zzhp(String str, IOException iOException, zzhb zzhbVar, int i, int i2) {
        super(str, iOException, zzb(i, i2));
        this.zzb = zzhbVar;
        this.zzc = i2;
    }
}
