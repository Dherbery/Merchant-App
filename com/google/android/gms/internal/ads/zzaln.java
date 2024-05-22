package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
final class zzaln {
    private static final Pattern zzd = Pattern.compile("\\s+");
    private static final zzgaf zze = zzgaf.zzp("auto", "none");
    private static final zzgaf zzf = zzgaf.zzq(TtmlNode.TEXT_EMPHASIS_MARK_DOT, TtmlNode.TEXT_EMPHASIS_MARK_SESAME, TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE);
    private static final zzgaf zzg = zzgaf.zzp(TtmlNode.TEXT_EMPHASIS_MARK_FILLED, TtmlNode.TEXT_EMPHASIS_MARK_OPEN);
    private static final zzgaf zzh = zzgaf.zzq(TtmlNode.ANNOTATION_POSITION_AFTER, TtmlNode.ANNOTATION_POSITION_BEFORE, TtmlNode.ANNOTATION_POSITION_OUTSIDE);
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzaln(int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    public static zzaln zza(String str) {
        boolean z;
        if (str == null) {
            return null;
        }
        String zza = zzfwk.zza(str.trim());
        if (zza.isEmpty()) {
            return null;
        }
        zzgaf zzm = zzgaf.zzm(TextUtils.split(zza, zzd));
        String str2 = (String) zzgag.zza(zzgca.zzb(zzh, zzm), TtmlNode.ANNOTATION_POSITION_OUTSIDE);
        int hashCode = str2.hashCode();
        int i = -1;
        int i2 = 0;
        if (hashCode != -1106037339) {
            if (hashCode == 92734940 && str2.equals(TtmlNode.ANNOTATION_POSITION_AFTER)) {
                z = false;
            }
            z = -1;
        } else {
            if (str2.equals(TtmlNode.ANNOTATION_POSITION_OUTSIDE)) {
                z = true;
            }
            z = -1;
        }
        int i3 = z ? !z ? 1 : -2 : 2;
        zzgbz zzb = zzgca.zzb(zze, zzm);
        if (!zzb.isEmpty()) {
            String str3 = (String) zzb.iterator().next();
            if (!((str3.hashCode() == 3387192 && str3.equals("none")) ? false : -1)) {
                i = 0;
            }
        } else {
            zzgbz zzb2 = zzgca.zzb(zzg, zzm);
            zzgbz zzb3 = zzgca.zzb(zzf, zzm);
            if (!zzb2.isEmpty() || !zzb3.isEmpty()) {
                String str4 = (String) zzgag.zza(zzb2, TtmlNode.TEXT_EMPHASIS_MARK_FILLED);
                int i4 = (str4.hashCode() == 3417674 && str4.equals(TtmlNode.TEXT_EMPHASIS_MARK_OPEN)) ? false : -1 ? 1 : 2;
                String str5 = (String) zzgag.zza(zzb3, TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE);
                int hashCode2 = str5.hashCode();
                if (hashCode2 != -905816648) {
                    if (hashCode2 == 99657 && str5.equals(TtmlNode.TEXT_EMPHASIS_MARK_DOT)) {
                        i = 0;
                    }
                } else if (str5.equals(TtmlNode.TEXT_EMPHASIS_MARK_SESAME)) {
                    i = 1;
                }
                if (i == 0) {
                    i = 2;
                } else if (i != 1) {
                    i2 = i4;
                    i = 1;
                } else {
                    i = 3;
                }
                i2 = i4;
            }
        }
        return new zzaln(i, i2, i3);
    }
}
