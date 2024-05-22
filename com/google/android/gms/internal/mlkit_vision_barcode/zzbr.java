package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
class zzbr extends AbstractCollection {
    final Object zza;
    Collection zzb;

    @CheckForNull
    final zzbr zzc;

    @CheckForNull
    final Collection zzd;
    final /* synthetic */ zzbu zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbr(zzbu zzbuVar, Object obj, @CheckForNull Collection collection, zzbr zzbrVar) {
        this.zze = zzbuVar;
        this.zza = obj;
        this.zzb = collection;
        this.zzc = zzbrVar;
        this.zzd = zzbrVar == null ? null : zzbrVar.zzb;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        boolean add = this.zzb.add(obj);
        if (add) {
            zzbu zzbuVar = this.zze;
            zzbu.zzq(zzbuVar, zzbu.zzg(zzbuVar) + 1);
            if (isEmpty) {
                zza();
                return true;
            }
        }
        return add;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.zzb.addAll(collection);
        if (!addAll) {
            return addAll;
        }
        int size2 = this.zzb.size();
        zzbu zzbuVar = this.zze;
        zzbu.zzq(zzbuVar, zzbu.zzg(zzbuVar) + (size2 - size));
        if (size != 0) {
            return addAll;
        }
        zza();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.zzb.clear();
        zzbu zzbuVar = this.zze;
        zzbu.zzq(zzbuVar, zzbu.zzg(zzbuVar) - size);
        zzc();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        zzb();
        return this.zzb.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        zzb();
        return this.zzb.containsAll(collection);
    }

    @Override // java.util.Collection
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        zzb();
        return this.zzb.equals(obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        zzb();
        return this.zzb.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzb();
        return new zzbq(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(@CheckForNull Object obj) {
        zzb();
        boolean remove = this.zzb.remove(obj);
        if (remove) {
            zzbu.zzq(this.zze, zzbu.zzg(r0) - 1);
            zzc();
        }
        return remove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.zzb.removeAll(collection);
        if (removeAll) {
            int size2 = this.zzb.size();
            zzbu zzbuVar = this.zze;
            zzbu.zzq(zzbuVar, zzbu.zzg(zzbuVar) + (size2 - size));
            zzc();
        }
        return removeAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        zzb();
        return this.zzb.size();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        zzb();
        return this.zzb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        zzbr zzbrVar = this.zzc;
        if (zzbrVar != null) {
            zzbrVar.zza();
        } else {
            zzbu.zzn(this.zze).put(this.zza, this.zzb);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb() {
        Collection collection;
        zzbr zzbrVar = this.zzc;
        if (zzbrVar != null) {
            zzbrVar.zzb();
            if (this.zzc.zzb != this.zzd) {
                throw new ConcurrentModificationException();
            }
        } else {
            if (!this.zzb.isEmpty() || (collection = (Collection) zzbu.zzn(this.zze).get(this.zza)) == null) {
                return;
            }
            this.zzb = collection;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc() {
        zzbr zzbrVar = this.zzc;
        if (zzbrVar != null) {
            zzbrVar.zzc();
        } else if (this.zzb.isEmpty()) {
            zzbu.zzn(this.zze).remove(this.zza);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        int size = size();
        boolean retainAll = this.zzb.retainAll(collection);
        if (retainAll) {
            int size2 = this.zzb.size();
            zzbu zzbuVar = this.zze;
            zzbu.zzq(zzbuVar, zzbu.zzg(zzbuVar) + (size2 - size));
            zzc();
        }
        return retainAll;
    }
}
