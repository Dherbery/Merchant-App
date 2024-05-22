package com.google.android.gms.internal.play_billing;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@6.1.0 */
/* loaded from: classes4.dex */
public final class zzcv extends AbstractSet {
    final int zza = -1;
    final /* synthetic */ zzcw zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcv(zzcw zzcwVar, int i) {
        this.zzb = zzcwVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Object[] objArr;
        int i = this.zza;
        objArr = this.zzb.zzb;
        return Arrays.binarySearch(objArr, zzb(), zza(), obj, i == -1 ? zzcw.zza : zzcy.zza) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzcu(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return zza() - zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zza() {
        int[] iArr;
        int i = this.zza;
        iArr = this.zzb.zzc;
        return iArr[i + 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzb() {
        int[] iArr;
        if (this.zza == -1) {
            return 0;
        }
        iArr = this.zzb.zzc;
        return iArr[0];
    }
}
