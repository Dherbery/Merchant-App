package expo.modules.location.records;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LocationArguments.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006R(\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\r\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\r\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Lexpo/modules/location/records/LocationLastKnownOptions;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "maxAge", "", "requiredAccuracy", "(Ljava/lang/Double;Ljava/lang/Double;)V", "getMaxAge$annotations", "()V", "getMaxAge", "()Ljava/lang/Double;", "setMaxAge", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getRequiredAccuracy$annotations", "getRequiredAccuracy", "setRequiredAccuracy", "expo-location_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocationLastKnownOptions implements Record, Serializable {
    private Double maxAge;
    private Double requiredAccuracy;

    public LocationLastKnownOptions() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Field
    public static /* synthetic */ void getMaxAge$annotations() {
    }

    @Field
    public static /* synthetic */ void getRequiredAccuracy$annotations() {
    }

    public LocationLastKnownOptions(Double d, Double d2) {
        this.maxAge = d;
        this.requiredAccuracy = d2;
    }

    public /* synthetic */ LocationLastKnownOptions(Double d, Double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : d2);
    }

    public final Double getMaxAge() {
        return this.maxAge;
    }

    public final void setMaxAge(Double d) {
        this.maxAge = d;
    }

    public final Double getRequiredAccuracy() {
        return this.requiredAccuracy;
    }

    public final void setRequiredAccuracy(Double d) {
        this.requiredAccuracy = d;
    }
}
