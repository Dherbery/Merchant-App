package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.Bundle;
import android.os.ext.SdkExtensions;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzetc implements zzexp {

    @Nullable
    private final Integer zza;

    private zzetc(@Nullable Integer num) {
        this.zza = num;
    }

    public static /* bridge */ /* synthetic */ zzetc zzb() {
        int extensionVersion;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjL)).booleanValue()) {
            return new zzetc(null);
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        int i = 0;
        if (Build.VERSION.SDK_INT >= 30) {
            extensionVersion = SdkExtensions.getExtensionVersion(30);
            if (extensionVersion > 3) {
                i = SdkExtensions.getExtensionVersion(1000000);
            }
        }
        return new zzetc(Integer.valueOf(i));
    }

    @Override // com.google.android.gms.internal.ads.zzexp
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Integer num = this.zza;
        Bundle bundle = (Bundle) obj;
        if (num != null) {
            bundle.putInt("aos", num.intValue());
        }
    }
}
