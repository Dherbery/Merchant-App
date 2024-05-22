package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public final class zzcu extends zzcv {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzcv zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcu(zzcv zzcvVar, int i, int i2) {
        this.zzc = zzcvVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzbc.zza(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcv, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcq
    final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcq
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcq
    @CheckForNull
    public final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcv
    /* renamed from: zzf */
    public final zzcv subList(int i, int i2) {
        zzbc.zzd(i, i2, this.zzb);
        zzcv zzcvVar = this.zzc;
        int i3 = this.zza;
        return zzcvVar.subList(i + i3, i2 + i3);
    }
}
