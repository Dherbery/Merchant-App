package expo.modules.location.records;

import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationResults.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tR$\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lexpo/modules/location/records/PermissionDetailsLocationAndroid;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", PermissionsResponse.SCOPE_KEY, "", "accuracy", "(Ljava/lang/String;Ljava/lang/String;)V", "getAccuracy$annotations", "()V", "getAccuracy", "()Ljava/lang/String;", "setAccuracy", "(Ljava/lang/String;)V", "getScope$annotations", "getScope", "setScope", "expo-location_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PermissionDetailsLocationAndroid implements Record, Serializable {
    private String accuracy;
    private String scope;

    @Field
    public static /* synthetic */ void getAccuracy$annotations() {
    }

    @Field
    public static /* synthetic */ void getScope$annotations() {
    }

    public PermissionDetailsLocationAndroid(String scope, String accuracy) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(accuracy, "accuracy");
        this.scope = scope;
        this.accuracy = accuracy;
    }

    public final String getScope() {
        return this.scope;
    }

    public final void setScope(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scope = str;
    }

    public final String getAccuracy() {
        return this.accuracy;
    }

    public final void setAccuracy(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accuracy = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PermissionDetailsLocationAndroid(android.os.Bundle r4) {
        /*
            r3 = this;
            java.lang.String r0 = "bundle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "accuracy"
            java.lang.String r1 = r4.getString(r0)
            java.lang.String r2 = "none"
            if (r1 != 0) goto L10
            r1 = r2
        L10:
            java.lang.String r4 = r4.getString(r0)
            if (r4 != 0) goto L17
            goto L18
        L17:
            r2 = r4
        L18:
            r3.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.records.PermissionDetailsLocationAndroid.<init>(android.os.Bundle):void");
    }
}
