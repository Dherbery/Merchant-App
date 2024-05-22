package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
final class zzaq extends zzbf {
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbf
    public final long zza() {
        return TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime());
    }
}
