package com.google.mlkit.vision.barcode.internal;

import com.google.android.gms.internal.mlkit_vision_barcode.zzcv;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes5.dex */
public class BarcodeRegistrar implements ComponentRegistrar {
    public static final /* synthetic */ int zza = 0;

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        return zzcv.zzh(Component.builder(zzh.class).add(Dependency.required((Class<?>) MlKitContext.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.vision.barcode.internal.zzc
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                int i = BarcodeRegistrar.zza;
                return new zzh((MlKitContext) componentContainer.get(MlKitContext.class));
            }
        }).build(), Component.builder(zzg.class).add(Dependency.required((Class<?>) zzh.class)).add(Dependency.required((Class<?>) ExecutorSelector.class)).add(Dependency.required((Class<?>) MlKitContext.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.vision.barcode.internal.zzd
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new zzg((zzh) componentContainer.get(zzh.class), (ExecutorSelector) componentContainer.get(ExecutorSelector.class), (MlKitContext) componentContainer.get(MlKitContext.class));
            }
        }).build());
    }
}
