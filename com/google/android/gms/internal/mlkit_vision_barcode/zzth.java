package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public final class zzth {
    private final zzcv zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzth(zztf zztfVar, zztg zztgVar) {
        zzcv zzcvVar;
        zzcvVar = zztfVar.zza;
        this.zza = zzcvVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzth) {
            return Objects.equal(this.zza, ((zzth) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza);
    }

    public final zzcv zza() {
        return this.zza;
    }
}
