package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public abstract class zzcy extends zzcq implements Set {

    @CheckForNull
    private transient zzcv zza;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        return zzdv.zzb(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return zzdv.zza(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcq, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract zzdx iterator();

    public final zzcv zzf() {
        zzcv zzcvVar = this.zza;
        if (zzcvVar != null) {
            return zzcvVar;
        }
        zzcv zzg = zzg();
        this.zza = zzg;
        return zzg;
    }

    zzcv zzg() {
        Object[] array = toArray();
        int i = zzcv.zzd;
        return zzcv.zzg(array, array.length);
    }
}
