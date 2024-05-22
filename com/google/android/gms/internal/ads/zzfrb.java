package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzfrb {
    public static zzfsk zza(Context context, int i, int i2, String str, String str2, String str3, zzfqr zzfqrVar) {
        return new zzfra(context, 1, i2, str, str2, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, zzfqrVar).zzb(50000);
    }
}
