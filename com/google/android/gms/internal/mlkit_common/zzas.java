package com.google.android.gms.internal.mlkit_common;

import com.amazon.a.a.o.b.f;

/* compiled from: com.google.mlkit:common@@18.9.0 */
/* loaded from: classes4.dex */
final class zzas {
    private final Object zza;
    private final Object zzb;
    private final Object zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzas(Object obj, Object obj2, Object obj3) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = obj3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final IllegalArgumentException zza() {
        return new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(this.zza) + f.b + String.valueOf(this.zzb) + " and " + String.valueOf(this.zza) + f.b + String.valueOf(this.zzc));
    }
}
