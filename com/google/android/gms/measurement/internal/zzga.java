package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
/* loaded from: classes4.dex */
public final class zzga {
    public static String zza(Context context) {
        try {
            return context.getResources().getResourcePackageName(R.string.common_google_play_services_unknown_issue);
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }

    public static final String zzb(String str, Resources resources, String str2) {
        int identifier = resources.getIdentifier(str, "string", str2);
        if (identifier != 0) {
            try {
            } catch (Resources.NotFoundException unused) {
                return null;
            }
        }
        return resources.getString(identifier);
    }
}
