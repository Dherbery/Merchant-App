package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.GmsLogger;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public final class zzur implements zzek {
    final /* synthetic */ zzpk zza;
    final /* synthetic */ float zzb;
    final /* synthetic */ zzuv zzc;
    final /* synthetic */ float zzd;
    final /* synthetic */ zzus zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzur(zzus zzusVar, zzpk zzpkVar, float f, zzuv zzuvVar, float f2) {
        this.zze = zzusVar;
        this.zza = zzpkVar;
        this.zzb = f;
        this.zzc = zzuvVar;
        this.zzd = f2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzek
    public final void zza(Throwable th) {
        GmsLogger gmsLogger;
        AtomicBoolean atomicBoolean;
        gmsLogger = zzus.zzf;
        gmsLogger.w("AutoZoom", "Unable to set zoom to " + this.zzd, th);
        atomicBoolean = this.zze.zzg;
        atomicBoolean.set(false);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzek
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        AtomicBoolean atomicBoolean;
        Float f = (Float) obj;
        if (f.floatValue() >= 1.0f) {
            zzus.zzg(this.zze, f.floatValue());
            this.zze.zzq(this.zza, this.zzb, f.floatValue(), this.zzc);
        }
        atomicBoolean = this.zze.zzg;
        atomicBoolean.set(false);
    }
}
