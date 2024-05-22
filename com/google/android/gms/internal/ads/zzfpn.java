package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzfpn {
    private static UiModeManager zza;

    public static zzfoj zza() {
        UiModeManager uiModeManager = zza;
        if (uiModeManager == null) {
            return zzfoj.OTHER;
        }
        int currentModeType = uiModeManager.getCurrentModeType();
        if (currentModeType == 1) {
            return zzfoj.MOBILE;
        }
        if (currentModeType == 4) {
            return zzfoj.CTV;
        }
        return zzfoj.OTHER;
    }

    public static void zzb(Context context) {
        if (context != null) {
            zza = (UiModeManager) context.getSystemService("uimode");
        }
    }
}
