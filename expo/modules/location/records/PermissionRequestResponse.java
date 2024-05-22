package expo.modules.location.records;

import com.amplitude.api.DeviceInfo;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;

/* compiled from: LocationResults.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B5\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eR&\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001a\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R&\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001f¨\u0006("}, d2 = {"Lexpo/modules/location/records/PermissionRequestResponse;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", PermissionsResponse.CAN_ASK_AGAIN_KEY, "", PermissionsResponse.EXPIRES_KEY, "", PermissionsResponse.GRANTED_KEY, "status", DeviceInfo.OS_NAME, "Lexpo/modules/location/records/PermissionDetailsLocationAndroid;", "(Ljava/lang/Boolean;Ljava/lang/String;ZLjava/lang/String;Lexpo/modules/location/records/PermissionDetailsLocationAndroid;)V", "getAndroid$annotations", "()V", "getAndroid", "()Lexpo/modules/location/records/PermissionDetailsLocationAndroid;", "setAndroid", "(Lexpo/modules/location/records/PermissionDetailsLocationAndroid;)V", "getCanAskAgain$annotations", "getCanAskAgain", "()Ljava/lang/Boolean;", "setCanAskAgain", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getExpires$annotations", "getExpires", "()Ljava/lang/String;", "setExpires", "(Ljava/lang/String;)V", "getGranted$annotations", "getGranted", "()Z", "setGranted", "(Z)V", "getStatus$annotations", "getStatus", "setStatus", "expo-location_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PermissionRequestResponse implements Record, Serializable {
    private PermissionDetailsLocationAndroid android;
    private Boolean canAskAgain;
    private String expires;
    private boolean granted;
    private String status;

    @Field
    public static /* synthetic */ void getAndroid$annotations() {
    }

    @Field
    public static /* synthetic */ void getCanAskAgain$annotations() {
    }

    @Field
    public static /* synthetic */ void getExpires$annotations() {
    }

    @Field
    public static /* synthetic */ void getGranted$annotations() {
    }

    @Field
    public static /* synthetic */ void getStatus$annotations() {
    }

    public PermissionRequestResponse(Boolean bool, String str, boolean z, String str2, PermissionDetailsLocationAndroid permissionDetailsLocationAndroid) {
        this.canAskAgain = bool;
        this.expires = str;
        this.granted = z;
        this.status = str2;
        this.android = permissionDetailsLocationAndroid;
    }

    public final Boolean getCanAskAgain() {
        return this.canAskAgain;
    }

    public final void setCanAskAgain(Boolean bool) {
        this.canAskAgain = bool;
    }

    public final String getExpires() {
        return this.expires;
    }

    public final void setExpires(String str) {
        this.expires = str;
    }

    public final boolean getGranted() {
        return this.granted;
    }

    public final void setGranted(boolean z) {
        this.granted = z;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final PermissionDetailsLocationAndroid getAndroid() {
        return this.android;
    }

    public final void setAndroid(PermissionDetailsLocationAndroid permissionDetailsLocationAndroid) {
        this.android = permissionDetailsLocationAndroid;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PermissionRequestResponse(android.os.Bundle r8) {
        /*
            r7 = this;
            java.lang.String r0 = "bundle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "canAskAgain"
            boolean r0 = r8.getBoolean(r0)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)
            java.lang.String r0 = "expires"
            java.lang.String r3 = r8.getString(r0)
            java.lang.Class<expo.modules.location.records.PermissionRequestResponse> r0 = expo.modules.location.records.PermissionRequestResponse.class
            if (r3 == 0) goto L47
            java.lang.String r1 = "granted"
            boolean r4 = r8.getBoolean(r1)
            java.lang.String r1 = "status"
            java.lang.String r5 = r8.getString(r1)
            if (r5 == 0) goto L3d
            java.lang.String r0 = "android"
            android.os.Bundle r8 = r8.getBundle(r0)
            if (r8 == 0) goto L36
            expo.modules.location.records.PermissionDetailsLocationAndroid r0 = new expo.modules.location.records.PermissionDetailsLocationAndroid
            r0.<init>(r8)
            r6 = r0
            goto L38
        L36:
            r8 = 0
            r6 = r8
        L38:
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            return
        L3d:
            expo.modules.location.ConversionException r8 = new expo.modules.location.ConversionException
            java.lang.Class<android.os.Bundle> r1 = android.os.Bundle.class
            java.lang.String r2 = "value under `status` key is undefined"
            r8.<init>(r1, r0, r2)
            throw r8
        L47:
            expo.modules.location.ConversionException r8 = new expo.modules.location.ConversionException
            java.lang.Class<android.os.Bundle> r1 = android.os.Bundle.class
            java.lang.String r2 = "value under `expires` key is undefined"
            r8.<init>(r1, r0, r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.records.PermissionRequestResponse.<init>(android.os.Bundle):void");
    }
}
