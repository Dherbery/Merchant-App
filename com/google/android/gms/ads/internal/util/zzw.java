package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import com.google.android.exoplayer2.util.Util$$ExternalSyntheticApiModelOutline0;
import com.google.android.gms.internal.ads.zzbgc;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public class zzw extends zzv {
    @Override // com.google.android.gms.ads.internal.util.zzab
    public final Intent zzf(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
        return intent;
    }

    @Override // com.google.android.gms.ads.internal.util.zzab
    public final void zzg(Context context, String str, String str2) {
        Util$$ExternalSyntheticApiModelOutline0.m$1();
        NotificationChannel m = ComponentDialog$$ExternalSyntheticApiModelOutline0.m("offline_notification_channel", "AdMob Offline Notifications", ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzir)).intValue());
        m.setShowBadge(false);
        ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(m);
    }

    @Override // com.google.android.gms.ads.internal.util.zzab
    public final boolean zzh(Context context, String str) {
        NotificationChannel notificationChannel;
        int importance;
        notificationChannel = ((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationChannel("offline_notification_channel");
        if (notificationChannel == null) {
            return false;
        }
        importance = notificationChannel.getImportance();
        return importance == 0;
    }

    @Override // com.google.android.gms.ads.internal.util.zzab
    public final int zzi(Context context, TelephonyManager telephonyManager) {
        boolean isDataEnabled;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (zzt.zzz(context, "android.permission.ACCESS_NETWORK_STATE")) {
            isDataEnabled = telephonyManager.isDataEnabled();
            if (isDataEnabled) {
                return 2;
            }
        }
        return 1;
    }
}
