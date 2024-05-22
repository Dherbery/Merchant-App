package expo.modules.location.records;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LocationArguments.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\u001d\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001e0\u001dH\u0000¢\u0006\u0002\b\u001fR(\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0010\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015¨\u0006 "}, d2 = {"Lexpo/modules/location/records/LocationTaskServiceOptions;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "notificationTitle", "", "notificationBody", "killServiceOnDestroy", "", "notificationColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getKillServiceOnDestroy$annotations", "()V", "getKillServiceOnDestroy", "()Ljava/lang/Boolean;", "setKillServiceOnDestroy", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getNotificationBody$annotations", "getNotificationBody", "()Ljava/lang/String;", "setNotificationBody", "(Ljava/lang/String;)V", "getNotificationColor$annotations", "getNotificationColor", "setNotificationColor", "getNotificationTitle$annotations", "getNotificationTitle", "setNotificationTitle", "toMutableMap", "", "", "toMutableMap$expo_location_release", "expo-location_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocationTaskServiceOptions implements Record, Serializable {
    private Boolean killServiceOnDestroy;
    private String notificationBody;
    private String notificationColor;
    private String notificationTitle;

    public LocationTaskServiceOptions() {
        this(null, null, null, null, 15, null);
    }

    @Field
    public static /* synthetic */ void getKillServiceOnDestroy$annotations() {
    }

    @Field
    public static /* synthetic */ void getNotificationBody$annotations() {
    }

    @Field
    public static /* synthetic */ void getNotificationColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getNotificationTitle$annotations() {
    }

    public LocationTaskServiceOptions(String str, String str2, Boolean bool, String str3) {
        this.notificationTitle = str;
        this.notificationBody = str2;
        this.killServiceOnDestroy = bool;
        this.notificationColor = str3;
    }

    public /* synthetic */ LocationTaskServiceOptions(String str, String str2, Boolean bool, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : str3);
    }

    public final String getNotificationTitle() {
        return this.notificationTitle;
    }

    public final void setNotificationTitle(String str) {
        this.notificationTitle = str;
    }

    public final String getNotificationBody() {
        return this.notificationBody;
    }

    public final void setNotificationBody(String str) {
        this.notificationBody = str;
    }

    public final Boolean getKillServiceOnDestroy() {
        return this.killServiceOnDestroy;
    }

    public final void setKillServiceOnDestroy(Boolean bool) {
        this.killServiceOnDestroy = bool;
    }

    public final String getNotificationColor() {
        return this.notificationColor;
    }

    public final void setNotificationColor(String str) {
        this.notificationColor = str;
    }

    public final Map<String, ? extends Object> toMutableMap$expo_location_release() {
        return MapsKt.mutableMapOf(TuplesKt.to("notificationTitle", this.notificationTitle), TuplesKt.to("notificationBody", this.notificationBody), TuplesKt.to("killServiceOnDestroy", this.killServiceOnDestroy), TuplesKt.to("notificationColor", this.notificationColor));
    }
}
