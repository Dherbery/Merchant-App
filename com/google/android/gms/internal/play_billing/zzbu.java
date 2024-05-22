package com.google.android.gms.internal.play_billing;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
public final class zzbu {
    private static final zzbw zza;

    static {
        String[] strArr;
        strArr = zzbw.zzd;
        zza = zzb(strArr);
    }

    public static /* bridge */ /* synthetic */ zzbw zza() {
        return zza;
    }

    private static zzbw zzb(String[] strArr) {
        zzbw zzbwVar;
        try {
            zzbwVar = zzbx.zza();
        } catch (NoClassDefFoundError unused) {
            zzbwVar = null;
        }
        if (zzbwVar != null) {
            return zzbwVar;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            try {
                return (zzbw) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable th) {
                th = th;
                if (th instanceof InvocationTargetException) {
                    th = th.getCause();
                }
                sb.append('\n');
                sb.append(str);
                sb.append(": ");
                sb.append(th);
            }
        }
        throw new IllegalStateException(sb.insert(0, "No logging platforms found:").toString());
    }
}
