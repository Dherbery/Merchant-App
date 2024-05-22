package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.ExoPlayer;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzbio {
    public static final zzbhm zza = zzbhm.zzd("gads:invalidate_token_at_refresh_start", true);
    public static final zzbhm zzb = zzbhm.zzd("gms:expose_token_for_gma:enabled", true);
    public static final zzbhm zzc = zzbhm.zzb("gads:timeout_for_trustless_token:millis", ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    public static final zzbhm zzd = zzbhm.zzb("gads:cached_token:ttl_millis", 10800000);
}
