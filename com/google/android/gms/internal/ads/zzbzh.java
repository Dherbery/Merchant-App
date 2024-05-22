package com.google.android.gms.internal.ads;

import com.amazon.a.a.o.b;
import com.amazon.a.a.o.b.f;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzbzh {
    private final List zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final boolean zze;
    private final boolean zzf;
    private final String zzg;
    private final String zzh;
    private final String zzi;
    private final int zzj;
    private final JSONObject zzk;
    private final String zzl;
    private final String zzm;

    public zzbzh(JSONObject jSONObject) {
        this.zzi = jSONObject.optString(ImagesContract.URL);
        this.zzb = jSONObject.optString("base_uri");
        this.zzc = jSONObject.optString("post_parameters");
        this.zze = zzj(jSONObject.optString("drt_include"));
        this.zzf = zzj(jSONObject.optString("cookies_include", b.ac));
        this.zzg = jSONObject.optString(ProxyAmazonBillingActivity.EXTRAS_REQUEST_ID);
        this.zzd = jSONObject.optString("type");
        String optString = jSONObject.optString("errors");
        this.zza = optString == null ? null : Arrays.asList(optString.split(f.a));
        this.zzj = jSONObject.optInt("valid", 0) == 1 ? -2 : 1;
        this.zzh = jSONObject.optString("fetched_ad");
        jSONObject.optBoolean("render_test_ad_label");
        JSONObject optJSONObject = jSONObject.optJSONObject("preprocessor_flags");
        this.zzk = optJSONObject == null ? new JSONObject() : optJSONObject;
        this.zzl = jSONObject.optString("analytics_query_ad_event_id");
        jSONObject.optBoolean("is_analytics_logging_enabled");
        this.zzm = jSONObject.optString("pool_key");
    }

    private static boolean zzj(String str) {
        if (str != null) {
            return str.equals(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE) || str.equals(b.ac);
        }
        return false;
    }

    public final int zza() {
        return this.zzj;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzm;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzi;
    }

    public final List zzf() {
        return this.zza;
    }

    public final JSONObject zzg() {
        return this.zzk;
    }

    public final boolean zzh() {
        return this.zzf;
    }

    public final boolean zzi() {
        return this.zze;
    }
}
