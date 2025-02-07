package com.onesignal.notifications.internal.common;

import android.content.Context;
import com.onesignal.common.AndroidUtils;
import com.onesignal.notifications.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OSNotificationOpenAppSettings.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/onesignal/notifications/internal/common/OSNotificationOpenAppSettings;", "", "()V", "getShouldOpenActivity", "", "context", "Landroid/content/Context;", "getSuppressLaunchURL", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class OSNotificationOpenAppSettings {
    public static final OSNotificationOpenAppSettings INSTANCE = new OSNotificationOpenAppSettings();

    private OSNotificationOpenAppSettings() {
    }

    public final boolean getShouldOpenActivity(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return !Intrinsics.areEqual("DISABLE", AndroidUtils.INSTANCE.getManifestMeta(context, "com.onesignal.NotificationOpened.DEFAULT"));
    }

    public final boolean getSuppressLaunchURL(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return AndroidUtils.INSTANCE.getManifestMetaBoolean(context, "com.onesignal.suppressLaunchURLs");
    }
}
