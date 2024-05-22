package com.google.mlkit.vision.barcode.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.internal.mlkit_vision_barcode.zztx;
import com.google.android.gms.internal.mlkit_vision_barcode.zzui;
import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes5.dex */
public final class zzh extends LazyInstanceMap {
    private final MlKitContext zza;

    public zzh(MlKitContext mlKitContext) {
        this.zza = mlKitContext;
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzl zznVar;
        BarcodeScannerOptions barcodeScannerOptions = (BarcodeScannerOptions) obj;
        Context applicationContext = this.zza.getApplicationContext();
        zztx zzb = zzui.zzb(zzb.zzd());
        if (zzn.zzd(applicationContext) || GoogleApiAvailabilityLight.getInstance().getApkVersion(applicationContext) >= 204500000) {
            zznVar = new zzn(applicationContext, barcodeScannerOptions, zzb);
        } else {
            zznVar = new zzp(applicationContext, barcodeScannerOptions, zzb);
        }
        return new zzk(this.zza, barcodeScannerOptions, zznVar, zzb);
    }
}
