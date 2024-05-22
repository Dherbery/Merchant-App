package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
final class zzuh extends LazyInstanceMap {
    private zzuh() {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        zztp zztpVar = (zztp) obj;
        MlKitContext mlKitContext = MlKitContext.getInstance();
        return new zztx(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), new zztq(MlKitContext.getInstance().getApplicationContext(), zztpVar), zztpVar.zzb());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzuh(zzug zzugVar) {
    }
}
