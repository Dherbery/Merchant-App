package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
final class zzcu implements Iterator {
    final /* synthetic */ zzcv zza;
    private int zzb = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcu(zzcv zzcvVar) {
        this.zza = zzcvVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb;
        zzcv zzcvVar = this.zza;
        return i < zzcvVar.zza() - zzcvVar.zzb();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object[] objArr;
        int i = this.zzb;
        zzcv zzcvVar = this.zza;
        if (i < zzcvVar.zza() - zzcvVar.zzb()) {
            zzcv zzcvVar2 = this.zza;
            objArr = zzcvVar2.zzb.zzb;
            Object obj = objArr[zzcvVar2.zzb() + i];
            this.zzb = i + 1;
            return obj;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
