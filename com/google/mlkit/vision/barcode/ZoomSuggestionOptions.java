package com.google.mlkit.vision.barcode;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes5.dex */
public class ZoomSuggestionOptions {
    private final ZoomCallback zza;
    private final float zzb;

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
    /* loaded from: classes5.dex */
    public static class Builder {
        private final ZoomCallback zza;
        private float zzb;

        public Builder(ZoomCallback zoomCallback) {
            this.zza = zoomCallback;
        }

        public ZoomSuggestionOptions build() {
            return new ZoomSuggestionOptions(this.zza, this.zzb, null);
        }

        public Builder setMaxSupportedZoomRatio(float f) {
            this.zzb = f;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
    /* loaded from: classes5.dex */
    public interface ZoomCallback {
        boolean setZoom(float f);
    }

    /* synthetic */ ZoomSuggestionOptions(ZoomCallback zoomCallback, float f, zzb zzbVar) {
        this.zza = zoomCallback;
        this.zzb = f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ZoomSuggestionOptions)) {
            return false;
        }
        ZoomSuggestionOptions zoomSuggestionOptions = (ZoomSuggestionOptions) obj;
        return Objects.equal(this.zza, zoomSuggestionOptions.zza) && this.zzb == zoomSuggestionOptions.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, Float.valueOf(this.zzb));
    }

    public final float zza() {
        return this.zzb;
    }

    public final ZoomCallback zzb() {
        return this.zza;
    }
}
