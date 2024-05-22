package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zzdo {
    static final zzdo zza = new zzdo(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private final Map zzd;

    zzdo() {
        this.zzd = new HashMap();
    }

    public static zzdo zza() {
        return zza;
    }

    public final zzeb zzb(zzfo zzfoVar, int i) {
        return (zzeb) this.zzd.get(new zzdn(zzfoVar, i));
    }

    zzdo(boolean z) {
        this.zzd = Collections.emptyMap();
    }
}
