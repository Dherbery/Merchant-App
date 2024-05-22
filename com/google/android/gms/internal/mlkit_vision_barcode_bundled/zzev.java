package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
public final class zzev extends zzcm implements RandomAccess, zzew {

    @Deprecated
    public static final zzew zza;
    private static final zzev zzb;
    private final List zzc;

    static {
        zzev zzevVar = new zzev(false);
        zzb = zzevVar;
        zza = zzevVar;
    }

    public zzev() {
        this(10);
    }

    private static String zzi(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdb) {
            return ((zzdb) obj).zzt(zzem.zzb);
        }
        return zzem.zzd((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zza();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        zza();
        if (collection instanceof zzew) {
            collection = ((zzew) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.zzc.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zzi(remove);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zza();
        return zzi(this.zzc.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzel
    public final /* bridge */ /* synthetic */ zzel zzd(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzc);
        return new zzev(arrayList);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzew
    public final zzew zze() {
        return zzc() ? new zzhd(this) : this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzew
    public final Object zzf(int i) {
        return this.zzc.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdb) {
            zzdb zzdbVar = (zzdb) obj;
            String zzt = zzdbVar.zzt(zzem.zzb);
            if (zzdbVar.zzn()) {
                this.zzc.set(i, zzt);
            }
            return zzt;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzem.zzd(bArr);
        if (zzhn.zzg(bArr)) {
            this.zzc.set(i, zzd);
        }
        return zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzew
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzev(int i) {
        super(true);
        ArrayList arrayList = new ArrayList(i);
        this.zzc = arrayList;
    }

    private zzev(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzev(boolean z) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
