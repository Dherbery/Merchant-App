package expo.modules.location.records;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LocationArguments.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0016\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007B1\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fR$\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001b\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010&\u0012\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lexpo/modules/location/records/LocationOptions;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "map", "", "", "", "(Ljava/util/Map;)V", "accuracy", "", "distanceInterval", "mayShowUserSettingsDialog", "", "timeInterval", "", "(ILjava/lang/Integer;ZLjava/lang/Long;)V", "getAccuracy$annotations", "()V", "getAccuracy", "()I", "setAccuracy", "(I)V", "getDistanceInterval$annotations", "getDistanceInterval", "()Ljava/lang/Integer;", "setDistanceInterval", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMayShowUserSettingsDialog$annotations", "getMayShowUserSettingsDialog", "()Z", "setMayShowUserSettingsDialog", "(Z)V", "getTimeInterval$annotations", "getTimeInterval", "()Ljava/lang/Long;", "setTimeInterval", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "expo-location_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public class LocationOptions implements Record, Serializable {
    private int accuracy;
    private Integer distanceInterval;
    private boolean mayShowUserSettingsDialog;
    private Long timeInterval;

    public LocationOptions() {
        this(0, null, false, null, 15, null);
    }

    @Field
    public static /* synthetic */ void getAccuracy$annotations() {
    }

    @Field
    public static /* synthetic */ void getDistanceInterval$annotations() {
    }

    @Field
    public static /* synthetic */ void getMayShowUserSettingsDialog$annotations() {
    }

    @Field
    public static /* synthetic */ void getTimeInterval$annotations() {
    }

    public LocationOptions(int i, Integer num, boolean z, Long l) {
        this.accuracy = i;
        this.distanceInterval = num;
        this.mayShowUserSettingsDialog = z;
        this.timeInterval = l;
    }

    public /* synthetic */ LocationOptions(int i, Integer num, boolean z, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 3 : i, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? null : l);
    }

    public final int getAccuracy() {
        return this.accuracy;
    }

    public final void setAccuracy(int i) {
        this.accuracy = i;
    }

    public final Integer getDistanceInterval() {
        return this.distanceInterval;
    }

    public final void setDistanceInterval(Integer num) {
        this.distanceInterval = num;
    }

    public final boolean getMayShowUserSettingsDialog() {
        return this.mayShowUserSettingsDialog;
    }

    public final void setMayShowUserSettingsDialog(boolean z) {
        this.mayShowUserSettingsDialog = z;
    }

    public final Long getTimeInterval() {
        return this.timeInterval;
    }

    public final void setTimeInterval(Long l) {
        this.timeInterval = l;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LocationOptions(java.util.Map<java.lang.String, ? extends java.lang.Object> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "map"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "accuracy"
            java.lang.Object r0 = r6.get(r0)
            boolean r1 = r0 instanceof java.lang.Integer
            r2 = 0
            if (r1 == 0) goto L13
            java.lang.Integer r0 = (java.lang.Integer) r0
            goto L14
        L13:
            r0 = r2
        L14:
            if (r0 == 0) goto L1b
            int r0 = r0.intValue()
            goto L1c
        L1b:
            r0 = 3
        L1c:
            java.lang.String r1 = "distanceInterval"
            java.lang.Object r1 = r6.get(r1)
            boolean r3 = r1 instanceof java.lang.Integer
            if (r3 == 0) goto L29
            java.lang.Integer r1 = (java.lang.Integer) r1
            goto L2a
        L29:
            r1 = r2
        L2a:
            java.lang.String r3 = "mayShowUserSettingsDialog"
            java.lang.Object r3 = r6.get(r3)
            boolean r4 = r3 instanceof java.lang.Boolean
            if (r4 == 0) goto L37
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            goto L38
        L37:
            r3 = r2
        L38:
            if (r3 == 0) goto L3f
            boolean r3 = r3.booleanValue()
            goto L40
        L3f:
            r3 = 1
        L40:
            java.lang.String r4 = "timeInterval"
            java.lang.Object r6 = r6.get(r4)
            boolean r4 = r6 instanceof java.lang.Long
            if (r4 == 0) goto L4d
            r2 = r6
            java.lang.Long r2 = (java.lang.Long) r2
        L4d:
            r5.<init>(r0, r1, r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.records.LocationOptions.<init>(java.util.Map):void");
    }
}
