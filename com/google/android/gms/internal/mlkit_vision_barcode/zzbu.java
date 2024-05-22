package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public abstract class zzbu extends zzby implements Serializable {
    private final transient Map zza;
    private transient int zzb;

    public zzbu(Map map) {
        zzbc.zzc(map.isEmpty());
        this.zza = map;
    }

    public static /* bridge */ /* synthetic */ int zzg(zzbu zzbuVar) {
        return zzbuVar.zzb;
    }

    public static /* bridge */ /* synthetic */ Map zzn(zzbu zzbuVar) {
        return zzbuVar.zza;
    }

    public static /* bridge */ /* synthetic */ void zzq(zzbu zzbuVar, int i) {
        zzbuVar.zzb = i;
    }

    public static /* bridge */ /* synthetic */ void zzr(zzbu zzbuVar, Object obj) {
        Object obj2;
        try {
            obj2 = zzbuVar.zza.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            zzbuVar.zzb -= size;
        }
    }

    public abstract Collection zza();

    Collection zzb() {
        throw null;
    }

    Collection zzc(Collection collection) {
        throw null;
    }

    public Collection zzd(Object obj, Collection collection) {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdj
    public final int zzh() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzby
    final Collection zzi() {
        return this instanceof zzdt ? new zzbx(this) : new zzbw(this);
    }

    public final Collection zzj(Object obj) {
        Collection collection = (Collection) this.zza.get(obj);
        if (collection == null) {
            collection = zza();
        }
        return zzd(obj, collection);
    }

    public final Collection zzk(@CheckForNull Object obj) {
        Collection collection = (Collection) this.zza.remove(obj);
        if (collection == null) {
            return zzb();
        }
        Collection zza = zza();
        zza.addAll(collection);
        this.zzb -= collection.size();
        collection.clear();
        return zzc(zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzby
    public final Iterator zzl() {
        return new zzbi(this);
    }

    public final List zzm(Object obj, List list, @CheckForNull zzbr zzbrVar) {
        if (list instanceof RandomAccess) {
            return new zzbp(this, obj, list, zzbrVar);
        }
        return new zzbt(this, obj, list, zzbrVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzby
    final Map zzo() {
        return new zzbl(this, this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzby
    final Set zzp() {
        return new zzbo(this, this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdj
    public final void zzs() {
        Iterator it = this.zza.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        this.zza.clear();
        this.zzb = 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzby, com.google.android.gms.internal.mlkit_vision_barcode.zzdj
    public final boolean zzt(Object obj, Object obj2) {
        Collection collection = (Collection) this.zza.get(obj);
        if (collection == null) {
            Collection zza = zza();
            if (zza.add(obj2)) {
                this.zzb++;
                this.zza.put(obj, zza);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        }
        if (!collection.add(obj2)) {
            return false;
        }
        this.zzb++;
        return true;
    }
}
