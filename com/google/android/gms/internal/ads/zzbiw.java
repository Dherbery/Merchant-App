package com.google.android.gms.internal.ads;

import android.graphics.Color;
import com.google.mlkit.common.MlKitException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzbiw extends zzbje {
    static final int zza;
    static final int zzb;
    private static final int zzc;
    private final String zzd;
    private final List zze = new ArrayList();
    private final List zzf = new ArrayList();
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;

    static {
        int rgb = Color.rgb(12, 174, MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR);
        zzc = rgb;
        zza = Color.rgb(204, 204, 204);
        zzb = rgb;
    }

    public zzbiw(String str, List list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        int i3;
        int i4;
        this.zzd = str;
        for (int i5 = 0; i5 < list.size(); i5++) {
            zzbiz zzbizVar = (zzbiz) list.get(i5);
            this.zze.add(zzbizVar);
            this.zzf.add(zzbizVar);
        }
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = zza;
        }
        this.zzg = i3;
        if (num2 != null) {
            i4 = num2.intValue();
        } else {
            i4 = zzb;
        }
        this.zzh = i4;
        this.zzi = num3 != null ? num3.intValue() : 12;
        this.zzj = i;
        this.zzk = i2;
    }

    public final int zzb() {
        return this.zzj;
    }

    public final int zzc() {
        return this.zzk;
    }

    public final int zzd() {
        return this.zzg;
    }

    public final int zze() {
        return this.zzh;
    }

    public final int zzf() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final String zzg() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final List zzh() {
        return this.zzf;
    }

    public final List zzi() {
        return this.zze;
    }
}
