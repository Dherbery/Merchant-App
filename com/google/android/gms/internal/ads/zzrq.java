package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.PlaybackException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzrq extends IOException {
    public final int zza;

    public zzrq(Throwable th, int i) {
        super(th);
        this.zza = PlaybackException.ERROR_CODE_DRM_SCHEME_UNSUPPORTED;
    }
}
