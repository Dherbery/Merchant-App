package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
abstract class zzch implements Iterator {
    int zzb;
    int zzc;
    int zzd;
    final /* synthetic */ zzcl zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzch(zzcl zzclVar, zzcg zzcgVar) {
        int i;
        this.zze = zzclVar;
        i = zzclVar.zzf;
        this.zzb = i;
        this.zzc = zzclVar.zze();
        this.zzd = -1;
    }

    private final void zzb() {
        int i;
        i = this.zze.zzf;
        if (i != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        zzb();
        if (hasNext()) {
            int i = this.zzc;
            this.zzd = i;
            Object zza = zza(i);
            this.zzc = this.zze.zzf(this.zzc);
            return zza;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzb();
        zzbc.zze(this.zzd >= 0, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        zzcl zzclVar = this.zze;
        int i = this.zzd;
        Object[] objArr = zzclVar.zzb;
        objArr.getClass();
        zzclVar.remove(objArr[i]);
        this.zzc--;
        this.zzd = -1;
    }

    abstract Object zza(int i);
}
