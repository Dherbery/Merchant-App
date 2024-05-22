package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.MimeTypes;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public interface zzht extends zzgw {
    public static final zzfxf zza = new zzfxf() { // from class: com.google.android.gms.internal.ads.zzhn
        @Override // com.google.android.gms.internal.ads.zzfxf
        public final boolean zza(Object obj) {
            String str = (String) obj;
            if (str == null) {
                return false;
            }
            String zza2 = zzfwk.zza(str);
            if (TextUtils.isEmpty(zza2)) {
                return false;
            }
            return ((zza2.contains("text") && !zza2.contains(MimeTypes.TEXT_VTT)) || zza2.contains(InAppMessageContent.HTML) || zza2.contains("xml")) ? false : true;
        }
    };

    @Override // com.google.android.gms.internal.ads.zzgw
    Map zze();
}
