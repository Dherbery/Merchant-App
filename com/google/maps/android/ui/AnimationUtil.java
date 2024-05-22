package com.google.maps.android.ui;

import android.os.Handler;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

/* loaded from: classes5.dex */
public class AnimationUtil {
    public static void animateMarkerTo(final Marker marker, final LatLng latLng) {
        final LatLngInterpolator.Linear linear = new LatLngInterpolator.Linear();
        final LatLng position = marker.getPosition();
        final Handler handler = new Handler();
        final long uptimeMillis = SystemClock.uptimeMillis();
        final AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        handler.post(new Runnable() { // from class: com.google.maps.android.ui.AnimationUtil.1
            long elapsed;
            float t;
            float v;

            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                this.elapsed = uptimeMillis2;
                float f = ((float) uptimeMillis2) / 2000.0f;
                this.t = f;
                float interpolation = accelerateDecelerateInterpolator.getInterpolation(f);
                this.v = interpolation;
                marker.setPosition(linear.interpolate(interpolation, position, latLng));
                if (this.t < 1.0f) {
                    handler.postDelayed(this, 16L);
                }
            }
        });
    }

    /* loaded from: classes5.dex */
    interface LatLngInterpolator {
        LatLng interpolate(float f, LatLng latLng, LatLng latLng2);

        /* loaded from: classes5.dex */
        public static class Linear implements LatLngInterpolator {
            @Override // com.google.maps.android.ui.AnimationUtil.LatLngInterpolator
            public LatLng interpolate(float f, LatLng latLng, LatLng latLng2) {
                double d = f;
                double d2 = ((latLng2.latitude - latLng.latitude) * d) + latLng.latitude;
                double d3 = latLng2.longitude - latLng.longitude;
                if (Math.abs(d3) > 180.0d) {
                    d3 -= Math.signum(d3) * 360.0d;
                }
                return new LatLng(d2, (d3 * d) + latLng.longitude);
            }
        }
    }
}
