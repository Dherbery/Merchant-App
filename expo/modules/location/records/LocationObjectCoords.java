package expo.modules.location.records;

import android.os.BaseBundle;
import android.os.Bundle;
import android.os.PersistableBundle;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.location.ConversionException;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationResults.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005BY\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eJ'\u0010(\u001a\u0002H)\"\b\b\u0000\u0010)*\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H)0,H\u0000¢\u0006\u0004\b-\u0010.R(\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0015\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0015\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R(\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0015\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R(\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0015\u0012\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R(\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0015\u0012\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R(\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0015\u0012\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R(\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0015\u0012\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014¨\u0006/"}, d2 = {"Lexpo/modules/location/records/LocationObjectCoords;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "location", "Landroid/location/Location;", "(Landroid/location/Location;)V", "latitude", "", "longitude", "altitude", "accuracy", "altitudeAccuracy", "heading", "speed", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getAccuracy$annotations", "()V", "getAccuracy", "()Ljava/lang/Double;", "setAccuracy", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getAltitude$annotations", "getAltitude", "setAltitude", "getAltitudeAccuracy$annotations", "getAltitudeAccuracy", "setAltitudeAccuracy", "getHeading$annotations", "getHeading", "setHeading", "getLatitude$annotations", "getLatitude", "setLatitude", "getLongitude$annotations", "getLongitude", "setLongitude", "getSpeed$annotations", "getSpeed", "setSpeed", "toBundle", "BundleType", "Landroid/os/BaseBundle;", "bundleTypeClass", "Ljava/lang/Class;", "toBundle$expo_location_release", "(Ljava/lang/Class;)Landroid/os/BaseBundle;", "expo-location_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocationObjectCoords implements Record, Serializable {
    private Double accuracy;
    private Double altitude;
    private Double altitudeAccuracy;
    private Double heading;
    private Double latitude;
    private Double longitude;
    private Double speed;

    public LocationObjectCoords() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    @Field
    public static /* synthetic */ void getAccuracy$annotations() {
    }

    @Field
    public static /* synthetic */ void getAltitude$annotations() {
    }

    @Field
    public static /* synthetic */ void getAltitudeAccuracy$annotations() {
    }

    @Field
    public static /* synthetic */ void getHeading$annotations() {
    }

    @Field
    public static /* synthetic */ void getLatitude$annotations() {
    }

    @Field
    public static /* synthetic */ void getLongitude$annotations() {
    }

    @Field
    public static /* synthetic */ void getSpeed$annotations() {
    }

    public LocationObjectCoords(Double d, Double d2, Double d3, Double d4, Double d5, Double d6, Double d7) {
        this.latitude = d;
        this.longitude = d2;
        this.altitude = d3;
        this.accuracy = d4;
        this.altitudeAccuracy = d5;
        this.heading = d6;
        this.speed = d7;
    }

    public /* synthetic */ LocationObjectCoords(Double d, Double d2, Double d3, Double d4, Double d5, Double d6, Double d7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : d2, (i & 4) != 0 ? null : d3, (i & 8) != 0 ? null : d4, (i & 16) != 0 ? null : d5, (i & 32) != 0 ? null : d6, (i & 64) != 0 ? null : d7);
    }

    public final Double getLatitude() {
        return this.latitude;
    }

    public final void setLatitude(Double d) {
        this.latitude = d;
    }

    public final Double getLongitude() {
        return this.longitude;
    }

    public final void setLongitude(Double d) {
        this.longitude = d;
    }

    public final Double getAltitude() {
        return this.altitude;
    }

    public final void setAltitude(Double d) {
        this.altitude = d;
    }

    public final Double getAccuracy() {
        return this.accuracy;
    }

    public final void setAccuracy(Double d) {
        this.accuracy = d;
    }

    public final Double getAltitudeAccuracy() {
        return this.altitudeAccuracy;
    }

    public final void setAltitudeAccuracy(Double d) {
        this.altitudeAccuracy = d;
    }

    public final Double getHeading() {
        return this.heading;
    }

    public final void setHeading(Double d) {
        this.heading = d;
    }

    public final Double getSpeed() {
        return this.speed;
    }

    public final void setSpeed(Double d) {
        this.speed = d;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LocationObjectCoords(android.location.Location r11) {
        /*
            r10 = this;
            java.lang.String r0 = "location"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            double r0 = r11.getLatitude()
            java.lang.Double r3 = java.lang.Double.valueOf(r0)
            double r0 = r11.getLongitude()
            java.lang.Double r4 = java.lang.Double.valueOf(r0)
            double r0 = r11.getAltitude()
            java.lang.Double r5 = java.lang.Double.valueOf(r0)
            float r0 = r11.getAccuracy()
            double r0 = (double) r0
            java.lang.Double r6 = java.lang.Double.valueOf(r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 < r1) goto L36
            float r0 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m(r11)
            double r0 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            goto L37
        L36:
            r0 = 0
        L37:
            r7 = r0
            float r0 = r11.getBearing()
            double r0 = (double) r0
            java.lang.Double r8 = java.lang.Double.valueOf(r0)
            float r11 = r11.getSpeed()
            double r0 = (double) r11
            java.lang.Double r9 = java.lang.Double.valueOf(r0)
            r2 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.records.LocationObjectCoords.<init>(android.location.Location):void");
    }

    public final <BundleType extends BaseBundle> BundleType toBundle$expo_location_release(Class<BundleType> bundleTypeClass) {
        Intrinsics.checkNotNullParameter(bundleTypeClass, "bundleTypeClass");
        BundleType persistableBundle = Intrinsics.areEqual(bundleTypeClass, PersistableBundle.class) ? new PersistableBundle() : new Bundle();
        BundleType bundletype = persistableBundle instanceof BaseBundle ? persistableBundle : null;
        if (bundletype == null) {
            throw new ConversionException(LocationObjectCoords.class, bundleTypeClass, "Requested an unsupported bundle type");
        }
        Double d = this.latitude;
        if (d != null) {
            bundletype.putDouble("latitude", d.doubleValue());
        }
        Double d2 = this.longitude;
        if (d2 != null) {
            bundletype.putDouble("longitude", d2.doubleValue());
        }
        Double d3 = this.altitude;
        if (d3 != null) {
            bundletype.putDouble("altitude", d3.doubleValue());
        }
        Double d4 = this.accuracy;
        if (d4 != null) {
            bundletype.putDouble("accuracy", d4.doubleValue());
        }
        Double d5 = this.altitudeAccuracy;
        if (d5 != null) {
            bundletype.putDouble("altitudeAccuracy", d5.doubleValue());
        }
        Double d6 = this.heading;
        if (d6 != null) {
            bundletype.putDouble("heading", d6.doubleValue());
        }
        Double d7 = this.speed;
        if (d7 != null) {
            bundletype.putDouble("speed", d7.doubleValue());
        }
        return bundletype;
    }
}
