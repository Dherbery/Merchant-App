package com.mrousavy.camera.core;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraError.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/mrousavy/camera/core/CameraError;", "", "domain", "", "id", OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "cause", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "getDomain", "()Ljava/lang/String;", "getId", "react-native-vision-camera_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class CameraError extends Throwable {
    private final String domain;
    private final String id;

    public /* synthetic */ CameraError(String str, String str2, String str3, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : th);
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getId() {
        return this.id;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraError(String domain, String id, String message, Throwable th) {
        super("[" + domain + "/" + id + "] " + message, th);
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(message, "message");
        this.domain = domain;
        this.id = id;
    }
}
