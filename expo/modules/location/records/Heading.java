package expo.modules.location.records;

import android.os.Bundle;
import expo.modules.kotlin.records.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LocationResults.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\r\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0018R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0019"}, d2 = {"Lexpo/modules/location/records/Heading;", "", "trueHeading", "", "magHeading", "accuracy", "", "(FFI)V", "getAccuracy$annotations", "()V", "getAccuracy", "()I", "setAccuracy", "(I)V", "getMagHeading$annotations", "getMagHeading", "()F", "setMagHeading", "(F)V", "getTrueHeading$annotations", "getTrueHeading", "setTrueHeading", "toBundle", "Landroid/os/Bundle;", "toBundle$expo_location_release", "expo-location_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Heading {
    private int accuracy;
    private float magHeading;
    private float trueHeading;

    public Heading() {
        this(0.0f, 0.0f, 0, 7, null);
    }

    @Field
    public static /* synthetic */ void getAccuracy$annotations() {
    }

    @Field
    public static /* synthetic */ void getMagHeading$annotations() {
    }

    @Field
    public static /* synthetic */ void getTrueHeading$annotations() {
    }

    public Heading(float f, float f2, int i) {
        this.trueHeading = f;
        this.magHeading = f2;
        this.accuracy = i;
    }

    public /* synthetic */ Heading(float f, float f2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1.0f : f, (i2 & 2) != 0 ? -1.0f : f2, (i2 & 4) != 0 ? 0 : i);
    }

    public final float getTrueHeading() {
        return this.trueHeading;
    }

    public final void setTrueHeading(float f) {
        this.trueHeading = f;
    }

    public final float getMagHeading() {
        return this.magHeading;
    }

    public final void setMagHeading(float f) {
        this.magHeading = f;
    }

    public final int getAccuracy() {
        return this.accuracy;
    }

    public final void setAccuracy(int i) {
        this.accuracy = i;
    }

    public final Bundle toBundle$expo_location_release() {
        Bundle bundle = new Bundle();
        bundle.putFloat("trueHeading", this.trueHeading);
        bundle.putFloat("magHeading", this.magHeading);
        bundle.putInt("accuracy", this.accuracy);
        return bundle;
    }
}
