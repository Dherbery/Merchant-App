package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.exoplayer2.C;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
final class zzzy implements zzcp {
    private final zzdm zza;

    public zzzy(zzdm zzdmVar) {
        this.zza = zzdmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final zzcq zza(Context context, zzt zztVar, zzt zztVar2, zzw zzwVar, zzdn zzdnVar, Executor executor, List list, long j) throws zzdl {
        try {
            Constructor<?> constructor = Class.forName("androidx.media3.effect.PreviewingSingleInputVideoGraph$Factory").getConstructor(zzdm.class);
            Object[] objArr = new Object[1];
            try {
                objArr[0] = this.zza;
                return ((zzcp) constructor.newInstance(objArr)).zza(context, zztVar, zztVar2, zzwVar, zzdnVar, executor, list, 0L);
            } catch (Exception e) {
                e = e;
                if (e instanceof zzdl) {
                    throw ((zzdl) e);
                }
                throw new zzdl(e, C.TIME_UNSET);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
