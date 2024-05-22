package expo.modules.location;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LocationExceptions.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/location/GeofencingException;", "Lexpo/modules/kotlin/exception/CodedException;", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "expo-location_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GeofencingException extends CodedException {
    public /* synthetic */ GeofencingException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GeofencingException(java.lang.String r3, java.lang.Throwable r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            if (r3 != 0) goto L5
            r3 = r0
        L5:
            if (r4 == 0) goto Lf
            java.lang.String r4 = r4.getMessage()
            if (r4 != 0) goto Le
            goto Lf
        Le:
            r0 = r4
        Lf:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r1 = "A geofencing exception has occurred: "
            r4.<init>(r1)
            r4.append(r3)
            java.lang.String r3 = " "
            r4.append(r3)
            r4.append(r0)
            java.lang.String r3 = r4.toString()
            r4 = 2
            r0 = 0
            r2.<init>(r3, r0, r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.GeofencingException.<init>(java.lang.String, java.lang.Throwable):void");
    }
}
